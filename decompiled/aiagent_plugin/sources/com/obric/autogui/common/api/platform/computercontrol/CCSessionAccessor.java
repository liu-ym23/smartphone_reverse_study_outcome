package com.obric.autogui.common.api.platform.computercontrol;

import d.m;

/* JADX INFO: compiled from: CCSessionAccessor.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface CCSessionAccessor {
    int getDisplayId();

    m<Integer, Integer> getDisplaySize();

    CCSessionState getState();

    boolean isClosed();
}
