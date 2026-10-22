package com.baidu.mapapi.map;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.NinePatch;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapsdkplatform.comapi.commonutils.AssetsLoadUtil;
import com.baidu.mapsdkplatform.comapi.map.s;
import com.baidu.mapsdkplatform.comapi.map.y;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.bmsdk.BmDrawItem;
import com.baidu.platform.comapi.map.MapSurfaceView;
import com.baidu.platform.comapi.map.v;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.ee.bear.document.customheader.CustomHeaderConfig;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.downloadlib.addownload.AdQuickAppManager;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadTimer;
import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;
import javax.microedition.khronos.opengles.GL10;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes39.dex */
public class WearMapView extends ViewGroup implements View.OnApplyWindowInsetsListener {
    public static final int BT_INVIEW = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f31520a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f31521b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static int f31522c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static int f31523d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static int f31524e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static int f31525f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static int f31526g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final SparseArray<Integer> f31527h = null;
    private float A;
    private int B;
    private int C;
    private int D;
    private int E;
    private int F;
    private int G;
    private boolean H;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private MapSurfaceView f31528i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private BaiduMap f31529j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private ImageView f31530k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Bitmap f31531l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private y f31532m;
    public AnimationTask mTask;
    public Timer mTimer;
    public f mTimerHandler;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f31533n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private Point f31534o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private Point f31535p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private RelativeLayout f31536q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private SwipeDismissView f31537r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private TextView f31538s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private TextView f31539t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private ImageView f31540u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f31541v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private Context f31542w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    ScreenShape f31543x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f31544y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f31545z;

    public class AnimationTask extends TimerTask {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ WearMapView f31546a;

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            com_baidu_mapapi_map_WearMapView$AnimationTask_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_baidu_mapapi_map_WearMapView$AnimationTask__run$___twin___() {
            Message r100 = new Message();
            r100.what = 1;
            this.f31546a.mTimerHandler.sendMessage(r100);
        }

        public AnimationTask(WearMapView r100) {
            this.f31546a = r100;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_baidu_mapapi_map_WearMapView$AnimationTask_com_larus_apm_impl_protector_RunnableLancet_run(AnimationTask r100) {
            r100.com_baidu_mapapi_map_WearMapView$AnimationTask__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public interface OnDismissCallback {
        void onDismiss();

        void onNotify();
    }

    public static final enum ScreenShape extends Enum<ScreenShape> {
        public static final ScreenShape RECTANGLE = null;
        public static final ScreenShape ROUND = null;
        public static final ScreenShape UNDETECTED = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final /* synthetic */ ScreenShape[] f31547a = null;

        static {
            ScreenShape r100 = new ScreenShape("ROUND", 0);
            ROUND = r100;
            ScreenShape r101 = new ScreenShape("RECTANGLE", 1);
            RECTANGLE = r101;
            ScreenShape r102 = new ScreenShape("UNDETECTED", 2);
            UNDETECTED = r102;
            f31547a = new ScreenShape[]{r100, r101, r102};
        }

        public static ScreenShape[] values() {
            return (ScreenShape[]) f31547a.clone();
        }

        public static ScreenShape valueOf(String r100) {
            return (ScreenShape) r27.a.a(ScreenShape.class, r100);
        }

        private ScreenShape(String r100, int r101) {
            super(r100, r101);
        }
    }

    public class a implements com.baidu.mapsdkplatform.comapi.map.c.InterfaceC0646c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ CustomMapStyleCallBack f31548a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ MapCustomStyleOptions f31549b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ WearMapView f31550c;

        @Override // com.baidu.mapsdkplatform.comapi.map.c.InterfaceC0646c
        public void onPreLoadLastCustomMapStyle(String r100) {
            CustomMapStyleCallBack r101 = this.f31548a;
            if (r101 != null) goto L5;
        L7:
            WearMapView.a(this.f31550c, true);
            WearMapView.a(this.f31550c, r100, this.f31549b);
            return;
        L5:
            if (r101.onPreLoadLastCustomMapStyle(r100) == false) goto L7;
        }

        @Override // com.baidu.mapsdkplatform.comapi.map.c.InterfaceC0646c
        public void onCustomMapStyleLoadSuccess(boolean r100, String r101) {
            CustomMapStyleCallBack r102 = this.f31548a;
            if (r102 == null) goto L8;
            if (r102.onCustomMapStyleLoadSuccess(r100, r101) == false) goto L8;
            return;
        L8:
            if (TextUtils.isEmpty(r101) == true) goto L11;
            WearMapView.a(this.f31550c, r101, "");
            this.f31550c.setMapCustomStyleEnable(true);
            return;
        }

        public a(WearMapView r100, CustomMapStyleCallBack r101, MapCustomStyleOptions r102) {
            this.f31550c = r100;
            this.f31548a = r101;
            this.f31549b = r102;
        }

        @Override // com.baidu.mapsdkplatform.comapi.map.c.InterfaceC0646c
        public void onCustomMapStyleLoadFailed(int r100, String r101, String r102) {
            CustomMapStyleCallBack r103 = this.f31548a;
            if (r103 == null) goto L8;
            if (r103.onCustomMapStyleLoadFailed(r100, r101, r102) == false) goto L8;
            return;
        L8:
            if (WearMapView.a(this.f31550c) == false) goto L10;
            return;
        L10:
            WearMapView.a(this.f31550c, r102, this.f31549b);
        }
    }

    public class b implements v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ WearMapView f31551a;

        @Override // com.baidu.platform.comapi.map.v
        public void a() {
        }

        @Override // com.baidu.platform.comapi.map.v
        public void a(MotionEvent r100) {
        }

        @Override // com.baidu.platform.comapi.map.v
        public void a(GeoPoint r100) {
        }

        @Override // com.baidu.platform.comapi.map.v
        public void a(GL10 r100, s r101) {
        }

        @Override // com.baidu.platform.comapi.map.v
        public void a(boolean r100) {
        }

        @Override // com.baidu.platform.comapi.map.v
        public void a(boolean r100, int r101) {
        }

        @Override // com.baidu.platform.comapi.map.v
        public boolean a(Point r100, Point r101, s r102) {
            return false;
        }

        @Override // com.baidu.platform.comapi.map.v
        public boolean a(Point r100, s r101) {
            return false;
        }

        @Override // com.baidu.platform.comapi.map.v
        public boolean a(MotionEvent r100, float r101, float r102, s r103) {
            return false;
        }

        @Override // com.baidu.platform.comapi.map.v
        public boolean a(BmDrawItem r100) {
            return false;
        }

        @Override // com.baidu.platform.comapi.map.v
        public boolean a(String r100) {
            return false;
        }

        @Override // com.baidu.platform.comapi.map.v
        public void b() {
        }

        @Override // com.baidu.platform.comapi.map.v
        public void b(s r100) {
        }

        @Override // com.baidu.platform.comapi.map.v
        public void b(GeoPoint r100) {
        }

        @Override // com.baidu.platform.comapi.map.v
        public void b(String r100) {
        }

        @Override // com.baidu.platform.comapi.map.v
        public boolean b(Point r100, Point r101, s r102) {
            return false;
        }

        @Override // com.baidu.platform.comapi.map.v
        public void c() {
        }

        @Override // com.baidu.platform.comapi.map.v
        public void c(s r100) {
        }

        @Override // com.baidu.platform.comapi.map.v
        public void c(GeoPoint r100) {
        }

        @Override // com.baidu.platform.comapi.map.v
        public boolean c(Point r100, Point r101, s r102) {
            return false;
        }

        @Override // com.baidu.platform.comapi.map.v
        public void d() {
        }

        @Override // com.baidu.platform.comapi.map.v
        public void d(GeoPoint r100) {
        }

        @Override // com.baidu.platform.comapi.map.v
        public boolean d(Point r100, Point r101, s r102) {
            return false;
        }

        @Override // com.baidu.platform.comapi.map.v
        public void e(GeoPoint r100) {
        }

        @Override // com.baidu.platform.comapi.map.v
        public void f(GeoPoint r100) {
        }

        @Override // com.baidu.platform.comapi.map.v
        public void g(GeoPoint r100) {
        }

        @Override // com.baidu.platform.comapi.map.v
        public void onFirstMapTileLoaded() {
        }

        public b(WearMapView r100) {
            this.f31551a = r100;
        }

        @Override // com.baidu.platform.comapi.map.v
        public void a(s r100) {
            if (WearMapView.b(this.f31551a) != null) goto L5;
            return;
        L5:
            if (WearMapView.b(this.f31551a).getBaseMap() == null) goto L23;
            float r101 = WearMapView.b(this.f31551a).getZoomLevel();
            if (r101 >= WearMapView.b(this.f31551a).getController().mMinZoomLevel) goto L11;
            r101 = WearMapView.b(this.f31551a).getController().mMinZoomLevel;
        L14:
            if (Math.abs(WearMapView.c(this.f31551a) - r101) <= 0.0f) goto L20;
            int r102 = ((Integer) WearMapView.c().get(Math.round(r101))).intValue();
            int r103 = ((int) (((double) r102) / WearMapView.b(this.f31551a).getController().getZoomUnitsInMeter())) / 2;
            WearMapView.d(this.f31551a).setPadding(r103, 0, r103, 0);
            if (r102 < 1000) goto L18;
            String r104 = String.format(" %d公里 ", new Object[]{Integer.valueOf(r102 / 1000)});
        L19:
            WearMapView.e(this.f31551a).setText(r104);
            WearMapView.f(this.f31551a).setText(r104);
            WearMapView.a(this.f31551a, r101);
            goto L20
        L18:
            r104 = String.format(" %d米 ", new Object[]{Integer.valueOf(r102)});
        L20:
            this.f31551a.requestLayout();
            return;
        L11:
            if (r101 <= WearMapView.b(this.f31551a).getController().mMaxZoomLevel) goto L14;
            r101 = WearMapView.b(this.f31551a).getController().mMaxZoomLevel;
            goto L14
        }
    }

    public class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ WearMapView f31552a;

        public c(WearMapView r100) {
            this.f31552a = r100;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r100) {
            s r101 = WearMapView.b(this.f31552a).getBaseMap().z();
            r101.f32200a -= 1.0f;
            WearMapView.b(this.f31552a).getBaseMap().a(r101, 300);
        }
    }

    public class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ WearMapView f31553a;

        public d(WearMapView r100) {
            this.f31553a = r100;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r100) {
            s r101 = WearMapView.b(this.f31553a).getBaseMap().z();
            r101.f32200a += 1.0f;
            WearMapView.b(this.f31553a).getBaseMap().a(r101, 300);
        }
    }

    public class e extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f31554a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ WearMapView f31555b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r100) {
            this.f31554a.setVisibility(4);
            super.onAnimationEnd(r100);
        }

        public e(WearMapView r100, View r101) {
            this.f31555b = r100;
            this.f31554a = r101;
        }
    }

    public class f extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final WeakReference<Context> f31556a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ WearMapView f31557b;

        @Override // android.os.Handler
        public void handleMessage(Message r100) {
            if (this.f31556a.get() != null) goto L5;
            return;
        L5:
            super.handleMessage(r100);
            if (r100.what == 1) goto L9;
            return;
        L9:
            if (WearMapView.g(this.f31557b) != null) goto L11;
            return;
        L11:
            WearMapView.b(this.f31557b, true);
        }

        public f(WearMapView r100, Context r101) {
            this.f31557b = r100;
            this.f31556a = new WeakReference(r101);
        }
    }

    public static void setMapCustomEnable(boolean r100) {
    }

    public void onExitAmbient() {
        a(1);
    }

    public void setCustomStyleFilePathAndMode(String r100, int r101) {
    }

    public void setMapCustomStyleEnable(boolean r100) {
    }

    static {
        f31520a = "MapView";
        f31522c = 0;
        f31523d = 0;
        f31524e = 0;
        f31525f = 0;
        f31526g = 10;
        SparseArray<Integer> r100 = new SparseArray();
        f31527h = r100;
        r100.append(3, 2000000);
        r100.append(4, 1000000);
        r100.append(5, 500000);
        r100.append(6, 200000);
        r100.append(7, 100000);
        r100.append(8, 50000);
        r100.append(9, 25000);
        r100.append(10, 20000);
        r100.append(11, 10000);
        r100.append(12, 5000);
        r100.append(13, 2000);
        r100.append(14, 1000);
        r100.append(15, 500);
        r100.append(16, 200);
        r100.append(17, 100);
        r100.append(18, 50);
        r100.append(19, 20);
        r100.append(20, 10);
        r100.append(21, 5);
        r100.append(22, 2);
    }

    private void a() {
        MapSurfaceView r100 = this.f31528i;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.onBackground();
    }

    private void b() {
        MapSurfaceView r100 = this.f31528i;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.onForeground();
    }

    private void d() {
        if (this.f31528i != null) goto L6;
        return;
    L6:
        if (this.f31541v == true) goto L9;
        a();
        this.f31541v = true;
        return;
    }

    private void e() {
        if (this.f31528i != null) goto L6;
        return;
    L6:
        if (this.f31541v == false) goto L9;
        b();
        this.f31541v = false;
        return;
    }

    public final BaiduMap getMap() {
        BaiduMap r100 = this.f31529j;
        r100.f30727m0 = this;
        return r100;
    }

    public final int getMapLevel() {
        float r100 = this.f31528i.getZoomLevel();
        return f31527h.get((int) r100).intValue();
    }

    public final void onDestroy() {
        if (this.f31542w == null) goto L5;
        this.f31528i.unInit();
    L5:
        Bitmap r100 = this.f31531l;
        if (r100 != null) goto L8;
    L10:
        this.f31532m.d();
        BMapManager.destroy();
        com.baidu.mapsdkplatform.comapi.map.e.a();
        AnimationTask r101 = this.mTask;
        if (r101 == null) goto L13;
        r101.cancel();
    L13:
        this.f31542w = null;
        return;
    L8:
        if (r100.isRecycled() == true) goto L10;
        this.f31531l.recycle();
        this.f31531l = null;
        goto L10
    }

    public static /* synthetic */ SparseArray c() {
        return f31527h;
    }

    public int getScaleControlViewHeight() {
        return this.F;
    }

    public int getScaleControlViewWidth() {
        return this.G;
    }

    public final void onDismiss() {
        removeAllViews();
    }

    public WearMapView(Context r100) {
        super(r100);
        this.f31533n = true;
        this.f31541v = true;
        this.f31543x = ScreenShape.ROUND;
        this.f31544y = true;
        this.f31545z = true;
        this.H = false;
        a(r100, null);
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_baidu_mapapi_map_WearMapView_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    private void a(Context r110) {
        int r100 = SysOSUtil.getDensityDpi();
        if (r100 >= 180) goto L5;
        String r101 = "logo_l.png";
    L6:
        Bitmap r102 = AssetsLoadUtil.loadAssetsFile(r101, r110);
        if (r100 <= 480) goto L10;
        Matrix r103 = new Matrix();
        r103.postScale(2.0f, 2.0f);
        this.f31531l = Bitmap.createBitmap(r102, 0, 0, r102.getWidth(), r102.getHeight(), r103, true);
    L15:
        if (this.f31531l == null) goto L18;
        ImageView r104 = new ImageView(r110);
        this.f31530k = r104;
        r104.setImageBitmap(this.f31531l);
        addView(this.f31530k);
        return;
    L18:
        return;
    L10:
        if (r100 <= 320) goto L13;
        if (r100 > 480) goto L13;
        Matrix r105 = new Matrix();
        r105.postScale(1.5f, 1.5f);
        this.f31531l = Bitmap.createBitmap(r102, 0, 0, r102.getWidth(), r102.getHeight(), r105, true);
    L13:
        this.f31531l = r102;
        goto L15
    L5:
        r101 = "logo_h.png";
        goto L6
    }

    private void b(Context r100) {
        this.f31536q = new RelativeLayout(r100);
        ViewGroup.LayoutParams r101 = new ViewGroup.LayoutParams(-2, -2);
        this.f31536q.setLayoutParams(r101);
        this.f31538s = new TextView(r100);
        RelativeLayout.LayoutParams r102 = new RelativeLayout.LayoutParams(-2, -2);
        r102.addRule(14);
        this.f31538s.setTextColor(ColorProtector.parseColor(CustomHeaderConfig.COLOR_LIGHT));
        this.f31538s.setTextSize(2, 11.0f);
        TextView r103 = this.f31538s;
        r103.setTypeface(r103.getTypeface(), 1);
        this.f31538s.setLayoutParams(r102);
        this.f31538s.setId(Integer.MAX_VALUE);
        this.f31536q.addView(this.f31538s);
        this.f31539t = new TextView(r100);
        RelativeLayout.LayoutParams r104 = new RelativeLayout.LayoutParams(-2, -2);
        r104.width = -2;
        r104.height = -2;
        r104.addRule(14);
        this.f31539t.setTextColor(ColorProtector.parseColor(CustomHeaderConfig.COLOR_DARK));
        this.f31539t.setTextSize(2, 11.0f);
        this.f31539t.setLayoutParams(r104);
        this.f31536q.addView(this.f31539t);
        this.f31540u = new ImageView(r100);
        RelativeLayout.LayoutParams r105 = new RelativeLayout.LayoutParams(-2, -2);
        r105.width = -2;
        r105.height = -2;
        r105.addRule(14);
        r105.addRule(3, this.f31538s.getId());
        this.f31540u.setLayoutParams(r105);
        Bitmap r106 = AssetsLoadUtil.loadAssetsFile("icon_scale.9.png", r100);
        byte[] r107 = r106.getNinePatchChunk();
        NinePatch.isNinePatchChunk(r107);
        NinePatchDrawable r108 = new NinePatchDrawable(r106, r107, new Rect(), null);
        this.f31540u.setBackgroundDrawable(r108);
        this.f31536q.addView(this.f31540u);
        addView(this.f31536q);
    }

    private void c(Context r100) {
        this.f31537r = new SwipeDismissView(r100, this);
        ViewGroup.LayoutParams r101 = new ViewGroup.LayoutParams((int) ((INVOKEVIRTUAL_com_baidu_mapapi_map_WearMapView_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100.getResources()).density * 34.0f) + 0.5f), f31525f);
        this.f31537r.setBackgroundColor(Color.argb(0, 0, 0, 0));
        this.f31537r.setLayoutParams(r101);
        addView(this.f31537r);
    }

    private void d(Context r100) {
        y r101 = new y(r100, true);
        this.f31532m = r101;
        if (r101.c() == true) goto L5;
        return;
    L5:
        this.f31532m.setOnZoomOutClickListener(new c(this));
        this.f31532m.setOnZoomInClickListener(new d(this));
        addView(this.f31532m);
    }

    public static /* synthetic */ TextView e(WearMapView r100) {
        return r100.f31538s;
    }

    public static /* synthetic */ TextView f(WearMapView r100) {
        return r100.f31539t;
    }

    public static /* synthetic */ y g(WearMapView r100) {
        return r100.f31532m;
    }

    public static void setCustomMapStylePath(String r100) {
        if (r100 == null) goto L12;
        if (r100.length() == 0) goto L12;
        if (new PolarisFileWrapper(r100).exists() == false) goto L10;
        f31521b = r100;
        return;
    L10:
        throw new RuntimeException("BDMapSDKException: please check whether the customMapStylePath file exits");
    L12:
        throw new RuntimeException("BDMapSDKException: customMapStylePath String is illegal");
    }

    public static void setIconCustom(int r100) {
        f31523d = r100;
    }

    public static void setLoadCustomMapStyleFileMode(int r100) {
        f31522c = r100;
    }

    private static void setScreenSize(Context r100) {
        ((WindowManager) r100.getSystemService(LiveEndPageData.TAG_WINDOW)).getDefaultDisplay();
    }

    public final void onEnterAmbient(Bundle r100) {
        a(0);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r100) {
        int r101 = r100.getAction();
        if (r101 == 0) goto L12;
        if (r101 != 1) goto L29;
        this.mTimer = new PthreadTimer("p/WearMapView");
        AnimationTask r102 = this.mTask;
        if (r102 == null) goto L10;
        r102.cancel();
    L10:
        AnimationTask r103 = new AnimationTask(this);
        this.mTask = r103;
        this.mTimer.schedule(r103, 5000);
    L29:
        return super.onInterceptTouchEvent(r100);
    L12:
        if (this.f31532m.getVisibility() != 0) goto L20;
        Timer r104 = this.mTimer;
        if (r104 == null) goto L29;
        if (this.mTask == null) goto L18;
        r104.cancel();
        this.mTask.cancel();
    L18:
        this.mTimer = null;
        this.mTask = null;
        goto L29
    L20:
        if (this.f31532m.getVisibility() != 4) goto L29;
        if (this.mTimer == null) goto L27;
        AnimationTask r105 = this.mTask;
        if (r105 == null) goto L26;
        r105.cancel();
    L26:
        this.mTimer.cancel();
        this.mTask = null;
        this.mTimer = null;
    L27:
        a(false);
        goto L29
    }

    public void onSaveInstanceState(Bundle r100) {
        if (r100 == null) goto L14;
        BaiduMap r101 = this.f31529j;
        if (r101 == null) goto L15;
        r100.putParcelable("mapstatus", r101.getMapStatus());
        Point r102 = this.f31534o;
        if (r102 == null) goto L9;
        r100.putParcelable("scalePosition", r102);
    L9:
        Point r103 = this.f31535p;
        if (r103 == null) goto L12;
        r100.putParcelable("zoomPosition", r103);
    L12:
        r100.putBoolean("mZoomControlEnabled", this.f31544y);
        r100.putBoolean("mScaleControlEnabled", this.f31545z);
        r100.putInt("paddingLeft", this.B);
        r100.putInt("paddingTop", this.D);
        r100.putInt("paddingRight", this.C);
        r100.putInt("paddingBottom", this.E);
        return;
    L15:
        return;
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View r100) {
        if (r100 != this.f31530k) goto L5;
        return;
    L5:
        super.removeView(r100);
    }

    public void setMapCustomStylePath(String r100) {
        a(r100, "");
    }

    public void setOnDismissCallbackListener(OnDismissCallback r100) {
        SwipeDismissView r101 = this.f31537r;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setCallback(r100);
    }

    public void setScaleControlPosition(Point r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        int r101 = r100.x;
        if (r101 >= 0) goto L7;
        return;
    L7:
        if (r100.y >= 0) goto L9;
        return;
    L9:
        if (r101 <= getWidth()) goto L11;
        return;
    L11:
        if (r100.y > getHeight()) goto L17;
        this.f31534o = r100;
        requestLayout();
        return;
    }

    public void setShape(ScreenShape r100) {
        this.f31543x = r100;
    }

    public void setViewAnimitionEnable(boolean r100) {
        this.f31533n = r100;
    }

    public void setZoomControlsPosition(Point r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        int r101 = r100.x;
        if (r101 >= 0) goto L7;
        return;
    L7:
        if (r100.y >= 0) goto L9;
        return;
    L9:
        if (r101 <= getWidth()) goto L11;
        return;
    L11:
        if (r100.y > getHeight()) goto L17;
        this.f31535p = r100;
        requestLayout();
        return;
    }

    public void showScaleControl(boolean r100) {
        RelativeLayout r101 = this.f31536q;
        if (r100 == false) goto L5;
        int r102 = 0;
    L6:
        r101.setVisibility(r102);
        this.f31545z = r100;
        return;
    L5:
        r102 = 8;
        goto L6
    }

    public void showZoomControls(boolean r100) {
        if (this.f31532m.c() == false) goto L10;
        y r101 = this.f31532m;
        if (r100 == false) goto L7;
        int r102 = 0;
    L8:
        r101.setVisibility(r102);
        this.f31544y = r100;
        return;
    L7:
        r102 = 8;
        goto L8
    }

    private void a(View r100) {
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        if (r101 != null) goto L5;
        r101 = new ViewGroup.LayoutParams(-2, -2);
    L5:
        int r102 = r101.width;
        if (r102 <= 0) goto L8;
        int r103 = View.MeasureSpec.makeMeasureSpec(r102, 1073741824);
    L9:
        int r104 = r101.height;
        if (r104 <= 0) goto L12;
        int r105 = View.MeasureSpec.makeMeasureSpec(r104, 1073741824);
    L13:
        r100.measure(r103, r105);
        return;
    L12:
        r105 = View.MeasureSpec.makeMeasureSpec(0, 0);
        goto L13
    L8:
        r103 = View.MeasureSpec.makeMeasureSpec(0, 0);
        goto L9
    }

    public static /* synthetic */ MapSurfaceView b(WearMapView r100) {
        return r100.f31528i;
    }

    public static /* synthetic */ float c(WearMapView r100) {
        return r100.A;
    }

    public static /* synthetic */ ImageView d(WearMapView r100) {
        return r100.f31540u;
    }

    private void a(int r100) {
        MapSurfaceView r101 = this.f31528i;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r100 != 0) goto L7;
        r101.onPause();
        d();
        return;
    L7:
        if (r100 != 1) goto L13;
        r101.onResume();
        e();
        return;
    }

    private void a(boolean r100) {
        if (this.f31533n == true) goto L5;
        return;
    L5:
        a(this.f31532m, r100);
    }

    public static /* synthetic */ boolean a(WearMapView r100) {
        return r100.H;
    }

    public WearMapView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f31533n = true;
        this.f31541v = true;
        this.f31543x = ScreenShape.ROUND;
        this.f31544y = true;
        this.f31545z = true;
        this.H = false;
        a(r100, null);
    }

    private void a(View r100, boolean r110) {
        if (r110 == false) goto L5;
        AnimatorSet r111 = new AnimatorSet();
        r111.playTogether(new Animator[]{ObjectAnimator.ofFloat(r100, "TranslationY", new float[]{0.0f, -50.0f}), ObjectAnimator.ofFloat(r100, "alpha", new float[]{1.0f, 0.0f})});
        r111.addListener(new e(this, r100));
        r111.setDuration(AdQuickAppManager.DEFAULT_QUICK_APP_CHECK_TIME);
        r111.start();
        return;
    L5:
        r100.setVisibility(0);
        AnimatorSet r112 = new AnimatorSet();
        r112.playTogether(new Animator[]{ObjectAnimator.ofFloat(r100, "TranslationY", new float[]{-50.0f, 0.0f}), ObjectAnimator.ofFloat(r100, "alpha", new float[]{0.0f, 1.0f})});
        r112.setDuration(AdQuickAppManager.DEFAULT_QUICK_APP_CHECK_TIME);
        r112.start();
    }

    public static /* synthetic */ void b(WearMapView r100, boolean r101) {
        r100.a(r101);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View r100, ViewGroup.LayoutParams r101) {
        if ((r101 instanceof MapViewLayoutParams) == false) goto L6;
        super.addView(r100, r101);
        return;
    }

    @Override // android.view.View.OnApplyWindowInsetsListener
    public WindowInsets onApplyWindowInsets(View r100, WindowInsets r101) {
        if (r101.isRound() == false) goto L5;
        this.f31543x = ScreenShape.ROUND;
    L6:
        return r101;
    L5:
        this.f31543x = ScreenShape.RECTANGLE;
        goto L6
    }

    public void onCreate(Context r100, Bundle r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        MapStatus r102 = (MapStatus) r101.getParcelable("mapstatus");
        if (this.f31534o == null) goto L8;
        this.f31534o = (Point) r101.getParcelable("scalePosition");
    L8:
        if (this.f31535p == null) goto L10;
        this.f31535p = (Point) r101.getParcelable("zoomPosition");
    L10:
        this.f31544y = r101.getBoolean("mZoomControlEnabled");
        this.f31545z = r101.getBoolean("mScaleControlEnabled");
        setPadding(r101.getInt("paddingLeft"), r101.getInt("paddingTop"), r101.getInt("paddingRight"), r101.getInt("paddingBottom"));
        a(r100, new BaiduMapOptions().mapStatus(r102));
    }

    public void setMapCustomStyle(MapCustomStyleOptions r100, CustomMapStyleCallBack r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        String r102 = r100.getCustomMapStyleId();
        if (r102 != null) goto L7;
    L11:
        String r103 = r100.getLocalCustomStyleFilePath();
        if (r103 != null) goto L14;
        return;
    L14:
        if (r103.isEmpty() == true) goto L18;
        a(r103, "");
        return;
    L18:
        return;
    L7:
        if (r102.isEmpty() == true) goto L11;
        com.baidu.mapsdkplatform.comapi.map.c.a().a(this.f31542w, r102, new a(this, r101, r100));
    }

    public WearMapView(Context r100, BaiduMapOptions r101) {
        super(r100);
        this.f31533n = true;
        this.f31541v = true;
        this.f31543x = ScreenShape.ROUND;
        this.f31544y = true;
        this.f31545z = true;
        this.H = false;
        a(r100, r101);
    }

    private void a(Context r100, BaiduMapOptions r101) {
        setScreenSize(r100);
        setOnApplyWindowInsetsListener(this);
        this.f31542w = r100;
        this.mTimerHandler = new f(this, r100);
        this.mTimer = new PthreadTimer("p/WearMapView");
        AnimationTask r102 = this.mTask;
        if (r102 == null) goto L5;
        r102.cancel();
    L5:
        AnimationTask r103 = new AnimationTask(this);
        this.mTask = r103;
        this.mTimer.schedule(r103, 5000);
        com.baidu.mapsdkplatform.comapi.map.e.c();
        BMapManager.init();
        a(r100, r101, f31521b);
        this.f31528i.getController().set3DGestureEnable(false);
        this.f31528i.getController().setOverlookGestureEnable(false);
        a(r100);
        d(r100);
        c(r100);
        if (r101 != null) goto L8;
    L10:
        b(r100);
        if (r101 != null) goto L13;
    L15:
        if (r101 == null) goto L19;
        Point r104 = r101.f30785l;
        if (r104 == null) goto L19;
        this.f31535p = r104;
    L19:
        if (r101 == null) goto L24;
        Point r105 = r101.f30784k;
        if (r105 == null) goto L25;
        this.f31534o = r105;
        return;
    L25:
        return;
    L24:
        return;
    L13:
        if (r101.f30782i == true) goto L15;
        this.f31536q.setVisibility(4);
        goto L15
    L8:
        if (r101.f30781h == true) goto L10;
        this.f31532m.setVisibility(4);
        goto L10
    }

    private void a(String r100, String r101) {
        MapSurfaceView r102 = this.f31528i;
        if (r102 != null) goto L5;
        return;
    L5:
        if (r102.getBaseMap() != null) goto L8;
        return;
    L8:
        if (TextUtils.isEmpty(r100) == false) goto L11;
        return;
    L11:
        if (r100.endsWith(".sty") == true) goto L14;
        return;
    L14:
        if (new PolarisFileWrapper(r100).exists() == true) goto L16;
        return;
    L16:
        this.f31528i.getBaseMap().a(r100, "");
    }

    private void a(String r100, MapCustomStyleOptions r101) {
        if (TextUtils.isEmpty(r100) == true) goto L5;
        a(r100, "");
        setMapCustomStyleEnable(true);
        return;
    L5:
        String r102 = r101.getLocalCustomStyleFilePath();
        if (TextUtils.isEmpty(r102) == true) goto L10;
        a(r102, "");
        setMapCustomStyleEnable(true);
        return;
    }

    private int a(int r100, int r101) {
        return r100 - ((int) Math.sqrt(Math.pow(r100, 2.0d) - Math.pow(r101, 2.0d)));
    }

    public static /* synthetic */ float a(WearMapView r100, float r101) {
        r100.A = r101;
        return r101;
    }

    public static /* synthetic */ boolean a(WearMapView r100, boolean r101) {
        r100.H = r101;
        return r101;
    }

    public WearMapView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f31533n = true;
        this.f31541v = true;
        this.f31543x = ScreenShape.ROUND;
        this.f31544y = true;
        this.f31545z = true;
        this.H = false;
        a(r100, null);
    }

    private void a(Context r100, BaiduMapOptions r101, String r102) {
        this.f31528i = new MapSurfaceView(r100);
        if (r101 == null) goto L5;
        this.f31529j = new BaiduMap(r100, this.f31528i, r101.a());
    L6:
        addView(this.f31528i);
        b r103 = new b(this);
        this.f31528i.getBaseMap().a(r103);
        return;
    L5:
        this.f31529j = new BaiduMap(r100, this.f31528i, null);
        goto L6
    }

    public static /* synthetic */ void a(WearMapView r100, String r101, MapCustomStyleOptions r102) {
        r100.a(r101, r102);
    }

    public static /* synthetic */ void a(WearMapView r100, String r101, String r102) {
        r100.a(r101, r102);
    }

    @Override // android.view.View
    public void setPadding(int r100, int r101, int r102, int r103) {
        this.B = r100;
        this.D = r101;
        this.C = r102;
        this.E = r103;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r110, int r111, int r112, int r113, int r114) {
        int r115 = getChildCount();
        a(this.f31530k);
        if ((((getWidth() - this.B) - this.C) - this.f31530k.getMeasuredWidth()) > 0) goto L5;
    L7:
        this.B = 0;
        this.C = 0;
        this.E = 0;
        this.D = 0;
        float r116 = 1.0f;
        float r117 = 1.0f;
    L8:
        int r118 = 0;
    L9:
        if (r118 >= r115) goto L57;
        View r100 = getChildAt(r118);
        MapSurfaceView r101 = this.f31528i;
        if (r100 != r101) goto L14;
        r101.layout(0, 0, getWidth(), getHeight());
    L56:
        r118 = r118 + 1;
        goto L9
    L14:
        if (r100 != this.f31530k) goto L20;
        int r102 = (int) (this.E + (12.0f * r117));
        if (this.f31543x != ScreenShape.ROUND) goto L18;
        a(this.f31532m);
        int r103 = f31524e / 2;
        int r104 = a(r103, this.f31532m.getMeasuredWidth() / 2);
        int r105 = ((f31524e / 2) - a(r103, r103 - r104)) + f31526g;
    L19:
        int r106 = (f31525f - r104) - r102;
        int r107 = r106 - this.f31530k.getMeasuredHeight();
        int r108 = f31524e - r105;
        this.f31530k.layout(r108 - this.f31530k.getMeasuredWidth(), r107, r108, r106);
        goto L56
    L18:
        r104 = 0;
        r105 = 0;
        goto L19
    L20:
        y r109 = this.f31532m;
        if (r100 != r109) goto L34;
        if (r109.c() == false) goto L56;
        a(this.f31532m);
        Point r119 = this.f31535p;
        if (r119 == null) goto L28;
        y r120 = this.f31532m;
        int r121 = r119.x;
        r120.layout(r121, r119.y, r120.getMeasuredWidth() + r121, this.f31535p.y + this.f31532m.getMeasuredHeight());
        goto L56
    L28:
        if (this.f31543x != ScreenShape.ROUND) goto L30;
        int r122 = a(f31525f / 2, this.f31532m.getMeasuredWidth() / 2);
    L31:
        int r123 = (int) (((12.0f * r117) + this.D) + r122);
        int r124 = (f31524e - this.f31532m.getMeasuredWidth()) / 2;
        this.f31532m.layout(r124, r123, this.f31532m.getMeasuredWidth() + r124, this.f31532m.getMeasuredHeight() + r123);
        goto L56
    L30:
        r122 = 0;
        goto L31
    L34:
        if (r100 == this.f31536q) goto L36;
        View r125 = this.f31537r;
        if (r100 != r125) goto L46;
        a(r125);
        this.f31537r.layout(0, 0, this.f31537r.getMeasuredWidth(), f31525f);
        goto L56
    L46:
        ViewGroup.LayoutParams r126 = r100.getLayoutParams();
        if ((r126 instanceof MapViewLayoutParams) == false) goto L56;
        MapViewLayoutParams r127 = (MapViewLayoutParams) r126;
        if (r127.f31094c != MapViewLayoutParams.ELayoutMode.absoluteMode) goto L51;
        Point r128 = r127.f31093b;
    L55:
        a(r100);
        int r129 = r100.getMeasuredWidth();
        int r130 = r100.getMeasuredHeight();
        float r131 = r127.f31095d;
        float r132 = r127.f31096e;
        int r133 = (int) (r128.x - (r131 * r129));
        int r134 = ((int) (r128.y - (r132 * r130))) + r127.f31097f;
        r100.layout(r133, r134, r129 + r133, r130 + r134);
        goto L56
    L51:
        GeoPoint r135 = CoordUtil.ll2mc(r127.f31092a);
        if (this.f31528i.getBaseMap() == null) goto L54;
        r128 = this.f31528i.getBaseMap().a(r135);
        goto L55
    L54:
        r128 = new Point();
        goto L55
    L36:
        if (this.f31543x != ScreenShape.ROUND) goto L38;
        a(r109);
        int r136 = f31524e / 2;
        int r137 = a(r136, this.f31532m.getMeasuredWidth() / 2);
        int r138 = ((f31524e / 2) - a(r136, r136 - r137)) + f31526g;
    L39:
        a(this.f31536q);
        Point r139 = this.f31534o;
        if (r139 != null) goto L42;
        int r140 = (int) (this.E + (12.0f * r117));
        this.G = this.f31536q.getMeasuredWidth();
        this.F = this.f31536q.getMeasuredHeight();
        int r141 = (int) ((this.B + (5.0f * r116)) + r138);
        int r142 = (f31525f - r140) - r137;
        int r143 = this.G + r141;
        this.f31536q.layout(r141, r142 - this.f31536q.getMeasuredHeight(), r143, r142);
        goto L56
    L42:
        RelativeLayout r144 = this.f31536q;
        int r145 = r139.x;
        r144.layout(r145, r139.y, r144.getMeasuredWidth() + r145, this.f31534o.y + this.f31536q.getMeasuredHeight());
        goto L56
    L38:
        r137 = 0;
        r138 = 0;
        goto L39
    L57:
        return;
    L5:
        if ((((getHeight() - this.D) - this.E) - this.f31530k.getMeasuredHeight()) <= 0) goto L7;
        r116 = ((getWidth() - this.B) - this.C) / getWidth();
        r117 = ((getHeight() - this.D) - this.E) / getHeight();
        goto L8
    }
}
