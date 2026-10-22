package com.bytedance.android.live.ktv.common.util;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes45.dex */
public interface c extends b {
    Function2<Boolean, Long, Unit> getOneDrawCallback();

    void setOneDrawCallback(Function2<? super Boolean, ? super Long, Unit> r100);
}
