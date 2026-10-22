package com.bytedance.android.live.broadcastgame.openplatform.miniapp.card;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes45.dex */
public interface a<T> {
    int getType();

    void setData(T r100);

    void setOnClickBlock(Function0<Unit> r100);

    void setOnCloseBlock(Function0<Unit> r100);
}
