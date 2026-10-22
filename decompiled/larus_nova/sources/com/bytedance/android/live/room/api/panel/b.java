package com.bytedance.android.live.room.api.panel;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes47.dex */
public interface b {
    void a(Function1<? super Integer, Unit> r100, Function1<? super String, Unit> r101);

    PanelName getPanelName();

    int getUnionId();
}
