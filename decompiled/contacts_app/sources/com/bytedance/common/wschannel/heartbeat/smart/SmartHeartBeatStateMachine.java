package com.bytedance.common.wschannel.heartbeat.smart;

import android.os.Handler;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.channel.impl.ok.OkChannelImpl;
import com.bytedance.common.wschannel.heartbeat.HeartBeatReactListener;
import com.bytedance.common.wschannel.heartbeat.smart.state.ActiveHeartBeatState;
import com.bytedance.common.wschannel.heartbeat.smart.state.ISmartHeartBeatState;
import com.bytedance.common.wschannel.heartbeat.smart.state.IdleHeartBeatState;
import com.bytedance.common.wschannel.heartbeat.smart.state.PlumbHeartBeatState;
import com.bytedance.common.wschannel.heartbeat.smart.state.SecondaryActiveHeartBeatState;
import com.bytedance.common.wschannel.heartbeat.smart.state.StableHeartBeatState;

/* JADX INFO: loaded from: classes2.dex */
public class SmartHeartBeatStateMachine {
    private ISmartHeartBeatState activeState;
    private ISmartHeartBeatState idleState;
    private ISmartHeartBeatState plumbState;
    private SmartHeartBeatPolicy policy;
    private ISmartHeartBeatState secondaryActiveState;
    private ISmartHeartBeatState stableState;

    public SmartHeartBeatStateMachine() {
    }

    public void init(HeartBeatReactListener r1, SmartHeartBeatPolicy r2, SmartHeartBeatMeta r3, Handler r4) {
        this.policy = r2;
        this.activeState = new ActiveHeartBeatState(r1, this, r3, r4);
        this.secondaryActiveState = new SecondaryActiveHeartBeatState(r1, this, r3, r4);
        this.plumbState = new PlumbHeartBeatState(r1, this, r3, r4);
        this.stableState = new StableHeartBeatState(r1, this, r3, r4);
        this.idleState = new IdleHeartBeatState(this);
        onIdleState();
    }

    public void onActiveState() {
        Logger.e(OkChannelImpl.TAG, "enter active state");
        this.policy.setState(this.activeState);
    }

    public void onSecondaryActiveState() {
        Logger.e(OkChannelImpl.TAG, "enter secondary active state");
        this.policy.setState(this.secondaryActiveState);
    }

    public void onPlumbState() {
        Logger.e(OkChannelImpl.TAG, "emter plumb state");
        this.policy.setState(this.plumbState);
    }

    public void onStableState() {
        Logger.e(OkChannelImpl.TAG, "enter stable state");
        this.policy.setState(this.stableState);
    }

    public void onIdleState() {
        Logger.e(OkChannelImpl.TAG, "enter idle state");
        this.policy.setState(this.idleState);
    }
}
