package com.bytedance.android.livesdk.performance;

import android.os.Handler;
import android.os.HandlerThread;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.livesdk.config.m00;
import com.bytedance.android.livesdkapi.depend.model.live.HotRoomInfo;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.service.IHotRoomManager;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.HashMap;

/* JADX INFO: loaded from: classes11.dex */
public class LiveHotRoomManager implements IHotRoomManager {
    public static final long MILLS = 1000;
    private final Runnable checkResetTimeRunnable;
    public boolean isHotRoom;
    private long mCurrentRoomId;
    public int mHotRoomType;
    public long mLastHotRoomMessageTime;
    public long mTotalHotRoomTime;
    private Handler mWorkHandler;
    private HandlerThread mWorkThread;
    private long resetInterval;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveHotRoomManager f154372a;

        @Override // java.lang.Runnable
        public final void run() {
            long r100 = System.currentTimeMillis();     // Catch: Throwable -> L8
            LiveHotRoomManager r101 = this.f154372a;     // Catch: Throwable -> L8
            if ((r100 - r101.mLastHotRoomMessageTime) < LiveHotRoomManager.access$000(r101)) goto L11;
            LiveHotRoomManager r102 = this.f154372a;     // Catch: Throwable -> L8
            if (r102.isHotRoom == false) goto L15;
            r102.isHotRoom = false;     // Catch: Throwable -> L8
            r102.mHotRoomType = 0;     // Catch: Throwable -> L8
            return;
        L15:
            return;
        L11:
            return;
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        }

        public a(LiveHotRoomManager r100) {
            this.f154372a = r100;
        }
    }

    @Override // com.bytedance.android.livesdkapi.service.IHotRoomManager
    public void onEnterRoom() {
    }

    @Override // com.bytedance.android.livesdkapi.service.IHotRoomManager
    public void onExitRoom() {
    }

    @Override // com.bytedance.android.livesdkapi.service.IHotRoomManager
    public void release() {
    }

    private boolean check() {
        if (tb1.c.f545235g == true) goto L6;
        return false;
    L6:
        if (this.mWorkHandler == null) goto L11;
        HandlerThread r100 = this.mWorkThread;
        if (r100 == null) goto L11;
        if (ThreadMethodProxy.isAlive(r100) == false) goto L11;
    L13:
        if (this.resetInterval != 0) goto L16;
        this.resetInterval = ((long) m00.f120722a.getValue().intValue()) * 1000;
    L16:
        if (this.mWorkHandler == null) goto L23;
        HandlerThread r101 = this.mWorkThread;
        if (r101 != null) goto L20;
        return false;
    L20:
        if (ThreadMethodProxy.isAlive(r101) == false) goto L25;
        return true;
    L25:
        return false;
    L23:
        return false;
    L11:
        init();
        goto L13
    }

    private void init() {
        if (tb1.c.f545235g == false) goto L6;
        PthreadHandlerThreadV2 r100 = new PthreadHandlerThreadV2("LiveHotRoomManagerThread", 0);
        this.mWorkThread = r100;
        ThreadMethodProxy.start(r100);
        this.mWorkHandler = new Handler(this.mWorkThread.getLooper());
        return;
    }

    private void register() {
        if (tb1.c.f545235g == false) goto L6;
        jc1.k.l(IHotRoomManager.class, this);
        return;
    }

    @Override // com.bytedance.android.livesdkapi.service.IHotRoomManager
    public void onEnterPlay() {
        if (tb1.c.f545235g == false) goto L15;
        this.mLastHotRoomMessageTime = 0;
        this.mTotalHotRoomTime = 0;
        boolean r100 = false;
        this.isHotRoom = false;
        this.mHotRoomType = 0;
        Room r101 = ((IRoomService) jc1.k.f(IRoomService.class)).getCurrentRoom();
        if (r101 == null) goto L16;
        this.mCurrentRoomId = r101.getRoomId();
        HotRoomInfo r102 = r101.hotRoomInfo;
        if (r102 == null) goto L17;
        int r103 = r102.bitMap;
        this.mHotRoomType = r103;
        if (r103 <= 0) goto L11;
        r100 = true;
    L11:
        this.isHotRoom = r100;
        if (r100 == false) goto L18;
        this.mLastHotRoomMessageTime = System.currentTimeMillis();
        notifyHotStatus(this.mCurrentRoomId);
        monitorHotRoomTransform(true);
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    }

    @Override // com.bytedance.android.livesdkapi.service.IHotRoomManager
    public void onExitPlay() {
        if (tb1.c.f545235g == true) goto L5;
        return;
    L5:
        if (this.isHotRoom == false) goto L9;
        long r100 = System.currentTimeMillis();
        long r101 = this.mLastHotRoomMessageTime;
        if ((r100 - r101) >= this.resetInterval) goto L9;
        this.mTotalHotRoomTime = (this.mTotalHotRoomTime + r100) - r101;
    L9:
        Handler r102 = this.mWorkHandler;
        if (r102 == null) goto L12;
        r102.removeCallbacks(this.checkResetTimeRunnable);
    L12:
        this.mWorkHandler = null;
        HandlerThread r103 = this.mWorkThread;     // Catch: Exception -> L17
        if (r103 == null) goto L23;
        r103.quit();     // Catch: Exception -> L17
        this.mWorkThread = null;     // Catch: Exception -> L17
        return;
    L23:
        return;
    L17:
        e = move-exception;
        ALogger.e("HandlerThread", e.getMessage());
    }

    public LiveHotRoomManager() {
        this.mLastHotRoomMessageTime = 0;
        this.mTotalHotRoomTime = 0;
        this.isHotRoom = false;
        this.mHotRoomType = 0;
        this.resetInterval = 0;
        this.checkResetTimeRunnable = new a(this);
        register();
    }

    public static /* synthetic */ long access$000(LiveHotRoomManager r100) {
        return r100.resetInterval;
    }

    private void monitorHotRoomTransform(boolean r100) {
        HashMap r101 = new HashMap();
        if (r100 == false) goto L5;
        String r102 = "0";
    L6:
        r101.put("is_transform", r102);
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_live_hotroom_transform", r101, new Object[]{Room.class});
        return;
    L5:
        r102 = "1";
        goto L6
    }

    @Override // com.bytedance.android.livesdkapi.service.IHotRoomManager
    public int getHotRoomType(long r100) {
        if (this.mCurrentRoomId == r100) goto L5;
        return 0;
    L5:
        return this.mHotRoomType;
    }

    @Override // com.bytedance.android.livesdkapi.service.IHotRoomManager
    public long getTotalHotRoomTime(long r100) {
        if (this.mCurrentRoomId == r100) goto L5;
        return 0;
    L5:
        return this.mTotalHotRoomTime;
    }

    @Override // com.bytedance.android.livesdkapi.service.IHotRoomManager
    public boolean isHotRoom(long r100) {
        if (this.mCurrentRoomId == r100) goto L5;
        return false;
    L5:
        return this.isHotRoom;
    }

    @Override // com.bytedance.android.livesdkapi.service.IHotRoomManager
    public void notifyHotStatus(long r100) {
        if (check() == true) goto L6;
        return;
    L6:
        if (r100 != this.mCurrentRoomId) goto L13;
        long r101 = System.currentTimeMillis();
        if (this.isHotRoom == false) goto L10;
        this.mTotalHotRoomTime = (this.mTotalHotRoomTime + r101) - this.mLastHotRoomMessageTime;
        this.mLastHotRoomMessageTime = r101;
    L11:
        this.isHotRoom = true;
        this.mWorkHandler.removeCallbacks(this.checkResetTimeRunnable);
        this.mWorkHandler.postDelayed(this.checkResetTimeRunnable, this.resetInterval);
        return;
    L10:
        this.mLastHotRoomMessageTime = r101;
        monitorHotRoomTransform(false);
        goto L11
    }

    @Override // com.bytedance.android.livesdkapi.service.IHotRoomManager
    public void setHotRoomType(int r100) {
        this.mHotRoomType = r100;
    }
}
