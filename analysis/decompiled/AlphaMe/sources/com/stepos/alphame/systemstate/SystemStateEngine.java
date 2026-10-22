package com.stepos.alphame.systemstate;

import B0.g;
import com.stepos.alphame.NotProguard;
import com.stepos.alphame.engine.EngineBase;
import com.stepos.alphame.engine.EngineFunc;
import com.stepos.alphame.manager.ActionManager;
import com.stepos.alphame.systemstate.SystemStateMachine;

/* loaded from: classes.dex */
public class SystemStateEngine extends EngineBase {
    public static final String TAG = "SystemStateEngine";
    private int mState = 3;
    private SystemStateMachine.IStateChangeListener mStateReceiver = new SystemStateMachine.IStateChangeListener() { // from class: com.stepos.alphame.systemstate.SystemStateEngine.1
        @Override // com.stepos.alphame.systemstate.SystemStateMachine.IStateChangeListener
        public void onStateChange(int i4) {
            g.z("SystemStateEngine onStateChange: ", i4, SystemStateEngine.TAG);
            SystemStateEngine.this.mState = i4;
            ActionManager.getInstance().broadcast("SYSTEM_STATE_CHANGED", Integer.valueOf(i4));
        }
    };

    public class getSystemStateFunc extends EngineFunc {
        public getSystemStateFunc(EngineBase engineBase) {
            super(engineBase);
            this.name = "getSystemState";
            this.isPublic = true;
            this.argsType = new byte[]{0};
            this.returnType = (byte) 4;
            this.annotation = new String[]{"获取当前系统状态状态", "@author liukeliang", "@return  0-Active", "        2-Puase", "        3-IDLE", "        4-STANDBY"};
        }
    }

    public SystemStateEngine() {
        initVariable();
    }

    private void initVariable() {
        EngineBase.addFunc(new getSystemStateFunc(this));
    }

    @NotProguard
    public int getSystemState() {
        return this.mState;
    }

    @Override // com.stepos.alphame.engine.EngineBase
    public void onStart() {
        SystemStateMachine.getInstance().registerStateLister(this.mStateReceiver);
    }

    @Override // com.stepos.alphame.engine.EngineBase
    public void onStop() {
        SystemStateMachine.getInstance().removeStateLister(this.mStateReceiver);
    }
}
