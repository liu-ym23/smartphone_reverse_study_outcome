package com.byted.cast.sdk.core;

import android.os.Handler;
import android.os.HandlerThread;
import com.byted.cast.sdk.IRTCEngineEventListener;
import com.byted.cast.sdk.RTCEngine;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;

/* JADX INFO: loaded from: classes43.dex */
public class RTCEventNotifier implements IRTCEngineEventListener {
    private static final String TAG = "RTCEventNotifier";
    private Handler mHandler;
    private HandlerThread mHandlerThread;
    private IRTCEngineEventListener mRTCEngineEventListener;

    public static /* synthetic */ void a(RTCEventNotifier r100, int r101, int r102, int r103, int r104) {
        r100.lambda$onCastPortSet$10(r101, r102, r103, r104);
    }

    public static /* synthetic */ void b(RTCEventNotifier r100, int r101, int r102, int r103, int r104) {
        r100.lambda$onCastPortUnSet$11(r101, r102, r103, r104);
    }

    public static /* synthetic */ void c(RTCEventNotifier r100, int r101) {
        r100.lambda$onServerStart$12(r101);
    }

    public static /* synthetic */ void d(RTCEventNotifier r100, String r101, String r102) {
        r100.lambda$onSinkLatencyStat$7(r101, r102);
    }

    public static /* synthetic */ void e(RTCEventNotifier r100, String r101) {
        r100.lambda$onStuckStat$1(r101);
    }

    public static /* synthetic */ void f(RTCEventNotifier r100, String r101) {
        r100.lambda$onFirstVideoFrame$8(r101);
    }

    public static /* synthetic */ void g(RTCEventNotifier r100, String r101, String r102) {
        r100.lambda$onSinkStuckStat$2(r101, r102);
    }

    public static /* synthetic */ void h(RTCEventNotifier r100, int r101, int r102, String r103) {
        r100.lambda$onInfo$9(r101, r102, r103);
    }

    public static /* synthetic */ void i(RTCEventNotifier r100, String r101) {
        r100.lambda$onIntoBackground$5(r101);
    }

    public static /* synthetic */ void j(RTCEventNotifier r100, String r101, String r102) {
        r100.lambda$onMonitorEvent$3(r101, r102);
    }

    public static /* synthetic */ void k(RTCEventNotifier r100, int r101) {
        r100.lambda$onServerStop$13(r101);
    }

    public static /* synthetic */ void l(RTCEventNotifier r100, String r101) {
        r100.lambda$onIntoForeground$6(r101);
    }

    public static /* synthetic */ void m(RTCEventNotifier r100, String r101) {
        r100.lambda$onStat$0(r101);
    }

    public static /* synthetic */ void n(RTCEventNotifier r100) {
        r100.lambda$onKilled$4();
    }

    private /* synthetic */ void lambda$onKilled$4() {
        this.mRTCEngineEventListener.onKilled();
    }

    @Override // com.byted.cast.sdk.IRTCEngineEventListener
    public void onCancelSuccess() {
        this.mHandler.post(new AnonymousClass6(this));
    }

    @Override // com.byted.cast.sdk.IRTCEngineEventListener
    public void onCastSuccess() {
        this.mHandler.post(new AnonymousClass5(this));
    }

    @Override // com.byted.cast.sdk.IRTCEngineEventListener
    public void onKilled() {
        this.mHandler.post(new i(this));
    }

    @Override // com.byted.cast.sdk.IRTCEngineEventListener
    public void onPaused() {
        this.mHandler.post(new AnonymousClass11(this));
    }

    @Override // com.byted.cast.sdk.IRTCEngineEventListener
    public void onResumed() {
        this.mHandler.post(new AnonymousClass10(this));
    }

    @Override // com.byted.cast.sdk.IRTCEngineEventListener
    public void onStopped() {
        this.mHandler.post(new AnonymousClass12(this));
    }

    public void remove() {
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHandlerThread.quit();
    }

    public RTCEventNotifier(IRTCEngineEventListener r100) {
        PthreadHandlerThreadV2 r101 = new PthreadHandlerThreadV2(TAG);
        this.mHandlerThread = r101;
        ThreadMethodProxy.start(r101);
        this.mHandler = new Handler(this.mHandlerThread.getLooper());
        this.mRTCEngineEventListener = r100;
    }

    public static /* synthetic */ IRTCEngineEventListener access$000(RTCEventNotifier r100) {
        return r100.mRTCEngineEventListener;
    }

    private /* synthetic */ void lambda$onFirstVideoFrame$8(String r100) {
        this.mRTCEngineEventListener.onFirstVideoFrame(r100);
    }

    private /* synthetic */ void lambda$onIntoBackground$5(String r100) {
        this.mRTCEngineEventListener.onIntoBackground(r100);
    }

    private /* synthetic */ void lambda$onIntoForeground$6(String r100) {
        this.mRTCEngineEventListener.onIntoForeground(r100);
    }

    private /* synthetic */ void lambda$onServerStart$12(int r100) {
        this.mRTCEngineEventListener.onServerStart(r100);
    }

    private /* synthetic */ void lambda$onServerStop$13(int r100) {
        this.mRTCEngineEventListener.onServerStop(r100);
    }

    private /* synthetic */ void lambda$onStat$0(String r100) {
        this.mRTCEngineEventListener.onStat(r100);
    }

    private /* synthetic */ void lambda$onStuckStat$1(String r100) {
        this.mRTCEngineEventListener.onStuckStat(r100);
    }

    @Override // com.byted.cast.sdk.IRTCEngineEventListener
    public void onCancelRequest(final String r100) {
        this.mHandler.post(new AnonymousClass15(this, r100));
    }

    @Override // com.byted.cast.sdk.IRTCEngineEventListener
    public void onConnectStateChanged(final RTCEngine.ConnectState r100) {
        this.mHandler.post(new AnonymousClass1(this, r100));
    }

    @Override // com.byted.cast.sdk.IRTCEngineEventListener
    public void onFirstVideoFrame(final String r100) {
        this.mHandler.post(new m(this, r100));
    }

    @Override // com.byted.cast.sdk.IRTCEngineEventListener
    public void onIntoBackground(final String r100) {
        this.mHandler.post(new h(this, r100));
    }

    @Override // com.byted.cast.sdk.IRTCEngineEventListener
    public void onIntoForeground(final String r100) {
        this.mHandler.post(new k(this, r100));
    }

    @Override // com.byted.cast.sdk.IRTCEngineEventListener
    public void onRecvMetaData(final String r100) {
        this.mHandler.post(new AnonymousClass9(this, r100));
    }

    @Override // com.byted.cast.sdk.IRTCEngineEventListener
    public void onServerStart(final int r100) {
        this.mHandler.post(new l(this, r100));
    }

    @Override // com.byted.cast.sdk.IRTCEngineEventListener
    public void onServerStop(final int r100) {
        this.mHandler.post(new j(this, r100));
    }

    @Override // com.byted.cast.sdk.IRTCEngineEventListener
    public void onStat(final String r100) {
        this.mHandler.post(new f(this, r100));
    }

    @Override // com.byted.cast.sdk.IRTCEngineEventListener
    public void onStuckStat(final String r100) {
        this.mHandler.post(new e(this, r100));
    }

    private /* synthetic */ void lambda$onMonitorEvent$3(String r100, String r101) {
        this.mRTCEngineEventListener.onMonitorEvent(r100, r101);
    }

    private /* synthetic */ void lambda$onSinkLatencyStat$7(String r100, String r101) {
        this.mRTCEngineEventListener.onSinkLatencyStat(r100, r101);
    }

    private /* synthetic */ void lambda$onSinkStuckStat$2(String r100, String r101) {
        this.mRTCEngineEventListener.onSinkStuckStat(r100, r101);
    }

    @Override // com.byted.cast.sdk.IRTCEngineEventListener
    public void onCastControl(final int r100, final int r101) {
        this.mHandler.post(new AnonymousClass7(this, r100, r101));
    }

    @Override // com.byted.cast.sdk.IRTCEngineEventListener
    public boolean onCastRequest(String r100, String r101) {
        return this.mRTCEngineEventListener.onCastRequest(r100, r101);
    }

    @Override // com.byted.cast.sdk.IRTCEngineEventListener
    public void onConnect(final String r100, final String r101) {
        this.mHandler.post(new AnonymousClass13(this, r100, r101));
    }

    @Override // com.byted.cast.sdk.IRTCEngineEventListener
    public void onDisconnect(final RTCEngine.ExitReason r100, final String r101) {
        this.mHandler.post(new AnonymousClass8(this, r100, r101));
    }

    @Override // com.byted.cast.sdk.IRTCEngineEventListener
    public void onError(final int r100, final String r101) {
        this.mHandler.post(new AnonymousClass3(this, r100, r101));
    }

    @Override // com.byted.cast.sdk.IRTCEngineEventListener
    public void onLogMonitor(final String r100, final String[][] r101) {
        this.mHandler.post(new AnonymousClass2(this, r100, r101));
    }

    @Override // com.byted.cast.sdk.IRTCEngineEventListener
    public void onMonitorEvent(final String r100, final String r101) {
        this.mHandler.post(new p(this, r100, r101));
    }

    @Override // com.byted.cast.sdk.IRTCEngineEventListener
    public void onRecvMetaData(final String r100, final String r101) {
        this.mHandler.post(new AnonymousClass16(this, r100, r101));
    }

    @Override // com.byted.cast.sdk.IRTCEngineEventListener
    public void onSinkLatencyStat(final String r100, final String r101) {
        this.mHandler.post(new d(this, r100, r101));
    }

    @Override // com.byted.cast.sdk.IRTCEngineEventListener
    public void onSinkStuckStat(final String r100, final String r101) {
        this.mHandler.post(new n(this, r100, r101));
    }

    private /* synthetic */ void lambda$onInfo$9(int r100, int r101, String r102) {
        this.mRTCEngineEventListener.onInfo(r100, r101, r102);
    }

    @Override // com.byted.cast.sdk.IRTCEngineEventListener
    public void onAudioSetVolume(final String r100, final float r101, final float r102) {
        this.mHandler.post(new AnonymousClass17(this, r100, r101, r102));
    }

    @Override // com.byted.cast.sdk.IRTCEngineEventListener
    public void onConnectSuccess(final int r100, final int r101, final int r102) {
        this.mHandler.post(new AnonymousClass4(this, r100, r101, r102));
    }

    @Override // com.byted.cast.sdk.IRTCEngineEventListener
    public void onDisconnect(final String r100, final RTCEngine.ExitReason r101, final String r102) {
        this.mHandler.post(new AnonymousClass14(this, r100, r101, r102));
    }

    @Override // com.byted.cast.sdk.IRTCEngineEventListener
    public void onInfo(final int r100, final int r101, final String r102) {
        this.mHandler.post(new o(this, r100, r101, r102));
    }

    private /* synthetic */ void lambda$onCastPortSet$10(int r100, int r101, int r102, int r103) {
        this.mRTCEngineEventListener.onCastPortSet(r100, r101, r102, r103);
    }

    private /* synthetic */ void lambda$onCastPortUnSet$11(int r100, int r101, int r102, int r103) {
        this.mRTCEngineEventListener.onCastPortUnSet(r100, r101, r102, r103);
    }

    @Override // com.byted.cast.sdk.IRTCEngineEventListener
    public void OnVideoSizeChanged(final String r100, final int r110, final int r111, final int r112) {
        this.mHandler.post(new AnonymousClass18(this, r100, r110, r111, r112));
    }

    @Override // com.byted.cast.sdk.IRTCEngineEventListener
    public void onCastPortSet(final int r100, final int r110, final int r111, final int r112) {
        this.mHandler.post(new c(this, r100, r110, r111, r112));
    }

    @Override // com.byted.cast.sdk.IRTCEngineEventListener
    public void onCastPortUnSet(final int r100, final int r110, final int r111, final int r112) {
        this.mHandler.post(new g(this, r100, r110, r111, r112));
    }

    @Override // com.byted.cast.sdk.IRTCEngineEventListener
    public void onVideoEncoder(final String r110, final int r111, final int r112, final int r113, final int r114, final boolean r115, final int r116) {
        this.mHandler.post(new AnonymousClass19(this, r110, r111, r112, r113, r114, r115, r116));
    }
}
