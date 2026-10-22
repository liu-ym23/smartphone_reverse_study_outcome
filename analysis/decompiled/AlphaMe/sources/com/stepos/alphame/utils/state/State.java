package com.stepos.alphame.utils.state;

import android.os.Message;

/* loaded from: classes.dex */
public class State implements IState {
    @Override // com.stepos.alphame.utils.state.IState
    public void enter() {
    }

    @Override // com.stepos.alphame.utils.state.IState
    public void exit() {
    }

    @Override // com.stepos.alphame.utils.state.IState
    public String getName() {
        String name = getClass().getName();
        return name.substring(name.lastIndexOf(36) + 1);
    }

    @Override // com.stepos.alphame.utils.state.IState
    public boolean processMessage(Message message) {
        return false;
    }
}
