package com.bytedance.android.ec.core.arch.lifecycle;

import androidx.lifecycle.Lifecycle;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes43.dex */
public final class PausingDispatcherKt {
    public static final <T> Object a(Lifecycle r100, Lifecycle.State r101, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> r102, Continuation<? super T> r103) {
        return BuildersKt.withContext(Dispatchers.getMain().getImmediate(), new PausingDispatcherKt$whenStateAtLeast$2(r100, r101, r102, null), r103);
    }
}
