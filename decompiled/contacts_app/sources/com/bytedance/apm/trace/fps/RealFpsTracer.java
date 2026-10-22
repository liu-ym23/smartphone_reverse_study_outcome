package com.bytedance.apm.trace.fps;

import android.content.Context;
import android.graphics.Canvas;
import android.os.SystemClock;
import android.view.View;
import android.view.WindowManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.block.trace.FrameTracer;
import com.bytedance.apm.block.trace.MainThreadMonitor;
import com.bytedance.apm.block.trace.MethodItem;
import com.bytedance.apm.samplers.SamplerHelper;
import com.bytedance.apm.thread.AsyncEventManager;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class RealFpsTracer {
    private static final int FACTOR = 10000;
    private static final long FAKE_FRAME_TIME = 10;
    private static final double HITCH_THRESHOLD = 8.33d;
    private static final Long MAX_INTERVAL = null;
    public static final int MIN_DROP_FRAME = 0;
    private static final Long MONITOR_INTERVAL = null;
    private static final int OFFSET_TO_MS = 100;
    public static final String REPORT_LIST_SIZEE = "report_list_size";
    public static final String SCROLL_DISTANCE = "distance";
    public static final String SCROLL_TIME = "total_scroll_time";
    public static final String SCROLL_VELOCITY = "velocity";
    private static final String TAG = "FpsTracer";
    private static FrameTracer sFrameTracer;
    private FrameTracer.BlockCollectItem blockCollectItem;
    private final boolean mCollectWhenNotHit;
    private final JSONObject mExtra;
    private FpsRecordView mFPSFpsRecordView;
    private volatile boolean mFPSState;
    private long mFirstFrameTime;
    private LinkedList<Integer> mFrameCostList;
    private volatile FpsTracer.IBlockTimeCallBack mIBlockTimeCallBack;
    private volatile FpsTracer.IDropFrameCallback mIDropFrameCallback;
    private FpsTracer.IFPSCallBack mIFPSCallBack;
    private FpsTracer.IFrameCallBack mIFrameCallBack;
    private volatile FpsTracer.IHtrFrmaeCallback mIHtrFrameCallback;
    private float mScrollDistanceX;
    private float mScrollDistanceY;
    private float mScrollSpeedX;
    private float mScrollSpeedY;
    private final String mType;
    private WindowManager mWindowManager;
    private long startTime;
    private HashMap<String, String> tags;

    private class FpsRecordView extends View {
        private int mCounter;
        private long mStartTime;
        final /* synthetic */ RealFpsTracer this$0;

        static /* synthetic */ long access$002(FpsRecordView r0, long r1) {
            r0.mStartTime = r1;
            return r1;
        }

        static /* synthetic */ int access$302(FpsRecordView r0, int r1) {
            r0.mCounter = r1;
            return r1;
        }

        public FpsRecordView(RealFpsTracer r1, Context r2) {
            this.this$0 = r1;
            super(r2);
            this.mStartTime = -1;
            this.mCounter = 0;
        }

        @Override // android.view.View
        protected void onDraw(Canvas r5) {
            if (this.mStartTime != (-1)) goto L5;
            this.mStartTime = SystemClock.elapsedRealtime();
            this.mCounter = 0;
        L7:
            if (RealFpsTracer.access$1500(this.this$0) == null) goto L9;
            RealFpsTracer.access$1500(this.this$0).onFrame(SystemClock.elapsedRealtime());
        L9:
            long r0 = SystemClock.elapsedRealtime() - this.mStartTime;
            if (r0 <= RealFpsTracer.access$1600().longValue()) goto L16;
            double r2 = (((double) this.mCounter) / r0) * RealFpsTracer.access$1700().longValue();
            if (RealFpsTracer.access$1800(this.this$0) == null) goto L14;
            RealFpsTracer.access$1800(this.this$0).fpsCallBack(r2);
        L14:
            FpsAggregateManger.getInstance().aggregate(RealFpsTracer.access$1900(this.this$0), RealFpsTracer.access$900(this.this$0), (float) r2);
            RealFpsTracer.access$2000(this.this$0);
            return;
        L16:
            return;
        L5:
            this.mCounter++;
            goto L7
        }
    }

    static /* synthetic */ boolean access$100(RealFpsTracer r0) {
        return r0.mFPSState;
    }

    static /* synthetic */ float access$1000(RealFpsTracer r0) {
        return r0.mScrollSpeedX;
    }

    static /* synthetic */ float access$1100(RealFpsTracer r0) {
        return r0.mScrollSpeedY;
    }

    static /* synthetic */ float access$1200(RealFpsTracer r0) {
        return r0.mScrollDistanceX;
    }

    static /* synthetic */ float access$1300(RealFpsTracer r0) {
        return r0.mScrollDistanceY;
    }

    static /* synthetic */ JSONObject access$1400(RealFpsTracer r0) {
        return r0.mExtra;
    }

    static /* synthetic */ FpsTracer.IFrameCallBack access$1500(RealFpsTracer r0) {
        return r0.mIFrameCallBack;
    }

    static /* synthetic */ Long access$1600() {
        return MONITOR_INTERVAL;
    }

    static /* synthetic */ Long access$1700() {
        return MAX_INTERVAL;
    }

    static /* synthetic */ FpsTracer.IFPSCallBack access$1800(RealFpsTracer r0) {
        return r0.mIFPSCallBack;
    }

    static /* synthetic */ HashMap access$1900(RealFpsTracer r0) {
        return r0.tags;
    }

    static /* synthetic */ FpsRecordView access$200(RealFpsTracer r0) {
        return r0.mFPSFpsRecordView;
    }

    static /* synthetic */ void access$2000(RealFpsTracer r0) {
        r0.endLowJellyBean();
    }

    static /* synthetic */ int access$400(int r0, float r1) {
        return getDroppedCount(r0, r1);
    }

    static /* synthetic */ void access$500(RealFpsTracer r0, Map r1, float r2) {
        r0.calculateFps(r1, r2);
    }

    static /* synthetic */ FpsTracer.IDropFrameCallback access$600(RealFpsTracer r0) {
        return r0.mIDropFrameCallback;
    }

    static /* synthetic */ FpsTracer.IBlockTimeCallBack access$700(RealFpsTracer r0) {
        return r0.mIBlockTimeCallBack;
    }

    static /* synthetic */ FpsTracer.IHtrFrmaeCallback access$800(RealFpsTracer r0) {
        return r0.mIHtrFrameCallback;
    }

    static /* synthetic */ String access$900(RealFpsTracer r0) {
        return r0.mType;
    }

    static {
        MONITOR_INTERVAL = 200L;
        MAX_INTERVAL = 1000L;
    }

    public RealFpsTracer(String r2) {
        this(r2, true);
    }

    public RealFpsTracer(String r2, boolean r3) {
        this(r2, r3, null);
    }

    public RealFpsTracer(String r4, boolean r5, JSONObject r6) {
        this.mFPSState = false;
        this.blockCollectItem = new FrameTracer.BlockCollectItem();
        this.mIFrameCallBack = null;
        this.tags = new HashMap();
        this.mScrollSpeedX = 0.0f;
        this.mScrollSpeedY = 0.0f;
        this.mScrollDistanceX = 0.0f;
        this.mScrollDistanceY = 0.0f;
        this.startTime = 0;
        this.mFirstFrameTime = 0;
        this.mFPSFpsRecordView = null;
        this.mWindowManager = null;
        this.mType = r4;
        this.mCollectWhenNotHit = r5;
        this.mExtra = r6;
        this.mFrameCostList = new LinkedList();
    }

    public void setDropFrameCallback(FpsTracer.IDropFrameCallback r1) {
        this.mIDropFrameCallback = r1;
    }

    public void setHtrFrameCallback(FpsTracer.IHtrFrmaeCallback r1) {
        this.mIHtrFrameCallback = r1;
    }

    public static void setFrameTracer(FrameTracer r0) {
        sFrameTracer = r0;
    }

    public void setIFrameCallBack(FpsTracer.IFrameCallBack r1) {
        this.mIFrameCallBack = r1;
    }

    public void setScrollSpeed(float r1, float r2) {
        this.mScrollSpeedX = r1;
        this.mScrollSpeedY = r2;
    }

    public void setScrollDistance(float r1, float r2) {
        this.mScrollDistanceX = r1;
        this.mScrollDistanceY = r2;
    }

    public boolean getMonitorFPSStatus() {
        return this.mFPSState;
    }

    public void setIFPSCallBack(FpsTracer.IFPSCallBack r1) {
        this.mIFPSCallBack = r1;
    }

    public void startRecyclerView(RecyclerView r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        r2.addOnScrollListener(new AnonymousClass1(this));
    }

    public void addTag(String r1, String r2) {
        this.tags.put(r1, r2);
    }

    public void removeTag(String r1) {
        this.tags.remove(r1);
    }

    public void start() {
        if (this.mFPSState == false) goto L6;
        return;
    L6:
        if (this.mCollectWhenNotHit == false) goto L8;
    L10:
        resetScrollInfo();
        startHighJellyBean();
        FpsTracer.addScene(this.mType);
        this.startTime = SystemClock.uptimeMillis();
        this.mFPSState = true;
        return;
    L8:
        if (isNeedTraceFps() == true) goto L10;
    }

    private void resetScrollInfo() {
        this.mScrollSpeedX = 0.0f;
        this.mScrollSpeedY = 0.0f;
        this.mScrollDistanceX = 0.0f;
        this.mScrollDistanceY = 0.0f;
        this.startTime = 0;
    }

    public synchronized void stop() {
        monitor-enter(this);
        endHighJellyBean();     // Catch: Throwable -> L6
        FpsTracer.removeScene(this.mType);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private boolean isSampleHit() {
        return SamplerHelper.getPerfFpsAllowSwitch("fps", this.mType);
    }

    private boolean isFpsDropSampleHit() {
        return SamplerHelper.getPerfFpsAllowSwitch("fps_drop", this.mType);
    }

    public boolean isNeedTraceFps() {
        if (MainThreadMonitor.getMonitor().isEnableLooperOpt() == false) goto L13;
        if (ApmContext.isNeedSalvage() == true) goto L7;
        return false;
    L7:
        if (isFpsDropSampleHit() == true) goto L11;
        if (isSampleHit() == true) goto L11;
        return false;
    L11:
        return true;
    L13:
        if (ApmContext.isNeedSalvage() == true) goto L19;
        if (isFpsDropSampleHit() == true) goto L19;
        if (isSampleHit() == true) goto L19;
        return false;
    L19:
        return true;
    }

    private void startHighJellyBean() {
        if (sFrameTracer == null) goto L6;
        this.mFPSState = true;
        sFrameTracer.addFpsTracer(this);
        return;
    }

    private void endHighJellyBean() {
        FrameTracer r0 = sFrameTracer;
        if (r0 == null) goto L9;
        r0.removeFpsTracer(this);
        if (this.mFPSState == true) goto L7;
        return;
    L7:
        doReportAndCalculateFps(this.startTime, SystemClock.uptimeMillis());
        this.mFPSState = false;
        return;
    }

    private void startLowJellyBean() {
        FpsRecordView.access$002(this.mFPSFpsRecordView, -1);
        WindowManager.LayoutParams r0 = new WindowManager.LayoutParams(-2, -2, 2005, 0, -3);
        r0.gravity = 51;
        r0.flags = 24;
        r0.height = 1;
        r0.width = 1;
        this.mWindowManager.removeView(this.mFPSFpsRecordView);     // Catch: Exception -> L6
    L4:
        this.mWindowManager.addView(this.mFPSFpsRecordView, r0);
        this.mFPSFpsRecordView.postDelayed(new AnonymousClass2(this), 10);
    }

    private void endLowJellyBean() {
        if (this.mFPSState == true) goto L10;
        return;
    L10:
        this.mWindowManager.removeView(this.mFPSFpsRecordView);     // Catch: Exception -> L9
        FpsRecordView.access$002(this.mFPSFpsRecordView, -1);     // Catch: Exception -> L9
        FpsRecordView.access$302(this.mFPSFpsRecordView, 0);     // Catch: Exception -> L9
    L7:
        this.mFPSState = false;
    }

    private void calculateFps(Map<String, String> r4, float r5) {
        FpsTracer.IFPSCallBack r0 = this.mIFPSCallBack;
        if (r0 == null) goto L5;
        r0.fpsCallBack(r5);
    L5:
        FpsAggregateManger.getInstance().aggregate(r4, this.mType, r5);
    }

    public void doDropCompute(long r3) {
        if (r3 >= 0) goto L5;
        return;
    L5:
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (this.mFrameCostList.size() <= 20000) goto L9;
        this.mFrameCostList.poll();     // Catch: Throwable -> L12
    L9:
        this.mFrameCostList.add(Integer.valueOf(((int) r3) * 100));     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L12
    }

    private void doReportAndCalculateFps(long r2, long r4) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.mFrameCostList.isEmpty() == false) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L11
        return;
    L7:
        int r3 = (this.mFirstFrameTime > 0 ? 1 : (this.mFirstFrameTime == 0 ? 0 : -1));
        this.mFirstFrameTime = 0;     // Catch: Throwable -> L11
        final LinkedList<Integer> r5 = this.mFrameCostList;     // Catch: Throwable -> L11
        this.mFrameCostList = new LinkedList();     // Catch: Throwable -> L11
        final FrameTracer.BlockCollectItem r6 = this.blockCollectItem;     // Catch: Throwable -> L11
        this.blockCollectItem = new FrameTracer.BlockCollectItem();     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
        final HashMap r7 = new HashMap();
        r7.putAll(this.tags);
        AsyncEventManager.getInstance().post(new AnonymousClass3(this, r5, r7, r6));
    }

    public static long stackToString(List<MethodItem> r5, StringBuilder r6) {
        Iterator<MethodItem> r7 = r5.iterator();
        long r0 = 0;
    L4:
        if (r7.hasNext() == false) goto L8;
        MethodItem r2 = r7.next();
        r6.append(r2.toString()).append('\n');
        if (r0 >= r2.durTime) goto L4;
        r0 = r2.durTime;
        goto L4
    L8:
        return r0;
    }

    private static int getDroppedCount(int r1, float r2) {
        return r1 / ((int) (r2 * 100.0f));
    }

    public void doBlock(long r1, boolean r3) {
        this.blockCollectItem.collect(r1, r3);
    }

    public void setIBlockTimeCallBack(FpsTracer.IBlockTimeCallBack r1) {
        this.mIBlockTimeCallBack = r1;
    }
}
