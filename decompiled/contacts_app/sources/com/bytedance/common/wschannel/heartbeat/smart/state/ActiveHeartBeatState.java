package com.bytedance.common.wschannel.heartbeat.smart.state;

import android.os.Handler;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.channel.impl.ok.OkChannelImpl;
import com.bytedance.common.wschannel.heartbeat.HeartBeatReactListener;
import com.bytedance.common.wschannel.heartbeat.model.AppState;
import com.bytedance.common.wschannel.heartbeat.smart.SmartHeartBeatMeta;
import com.bytedance.common.wschannel.heartbeat.smart.SmartHeartBeatStateMachine;
import com.bytedance.common.wschannel.utils.Utils;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.Response;

/* JADX INFO: loaded from: classes2.dex */
public class ActiveHeartBeatState implements ISmartHeartBeatState {
    private final Handler mHandler;
    private Runnable mSendHeartBeatRunnable;
    private Runnable mTimeoutCheckRunnable;
    private AtomicBoolean mWaitingForPong;
    private SmartHeartBeatStateMachine machine;
    private SmartHeartBeatMeta meta;
    private HeartBeatReactListener reactListener;

    static /* synthetic */ AtomicBoolean access$000(ActiveHeartBeatState r0) {
        return r0.mWaitingForPong;
    }

    static /* synthetic */ void access$100(ActiveHeartBeatState r0) {
        r0.disConnect();
    }

    static /* synthetic */ HeartBeatReactListener access$200(ActiveHeartBeatState r0) {
        return r0.reactListener;
    }

    static /* synthetic */ void access$300(ActiveHeartBeatState r0) {
        r0.schedule();
    }

    public ActiveHeartBeatState(HeartBeatReactListener r3, SmartHeartBeatStateMachine r4, SmartHeartBeatMeta r5, Handler r6) {
        this.mWaitingForPong = new AtomicBoolean(false);
        this.mTimeoutCheckRunnable = new AnonymousClass1(this);
        this.mSendHeartBeatRunnable = new AnonymousClass2(this);
        this.reactListener = r3;
        this.machine = r4;
        this.meta = r5;
        this.mHandler = r6;
    }

    @Override // com.bytedance.common.wschannel.heartbeat.smart.state.ISmartHeartBeatState
    public void onEnterThisState() {
        SmartHeartBeatMeta r0 = this.meta;
        r0.setCurrentPingInterval(r0.getMinPingInterval());
        schedule();
    }

    @Override // com.bytedance.common.wschannel.heartbeat.IHeartBeatPolicy
    public void onReceivePong() {
        Logger.d(OkChannelImpl.TAG, "receive pong");
        this.mWaitingForPong.set(false);
        this.mHandler.removeCallbacks(this.mTimeoutCheckRunnable);
    }

    @Override // com.bytedance.common.wschannel.heartbeat.IHeartBeatPolicy
    public void onPingSendSuccess() {
        Logger.d(OkChannelImpl.TAG, "ping sent，waiting for pong");
        waitingForPong();
    }

    @Override // com.bytedance.common.wschannel.heartbeat.IHeartBeatPolicy
    public void onAppStateUpdate(AppState r2) {
        if (r2 != AppState.STATE_BACKGROUND) goto L6;
        this.machine.onSecondaryActiveState();
        disConnect();
        return;
    }

    @Override // com.bytedance.common.wschannel.heartbeat.IHeartBeatPolicy
    public void onConnected(Response r1) {
        schedule();
    }

    @Override // com.bytedance.common.wschannel.heartbeat.IHeartBeatPolicy
    public void onDisconnected() {
        disConnect();
        this.machine.onIdleState();
    }

    @Override // com.bytedance.common.wschannel.heartbeat.smart.state.ISmartHeartBeatState
    public StateType provideType() {
        return StateType.ACTIVE;
    }

    private void disConnect() {
        this.mHandler.removeCallbacks(this.mTimeoutCheckRunnable);
        this.mHandler.removeCallbacks(this.mSendHeartBeatRunnable);
        this.mWaitingForPong.set(false);
    }

    private void schedule() {
        long r0 = this.meta.getMinPingInterval();
        Logger.d(OkChannelImpl.TAG, "interval :" + r0 + " ms,the next time to send heartbeat is " + Utils.getTimeFormat(System.currentTimeMillis() + r0));
        this.mHandler.removeCallbacks(this.mSendHeartBeatRunnable);
        this.mHandler.postDelayed(this.mSendHeartBeatRunnable, r0);
    }

    private void waitingForPong() {
        this.mWaitingForPong.set(true);
        this.mHandler.removeCallbacks(this.mTimeoutCheckRunnable);
        this.mHandler.postDelayed(this.mTimeoutCheckRunnable, this.meta.getPingTimeOut());
    }
}
