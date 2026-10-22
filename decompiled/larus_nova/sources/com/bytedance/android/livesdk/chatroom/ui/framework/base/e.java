package com.bytedance.android.livesdk.chatroom.ui.framework.base;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<SceneType, j70.h<? extends h70.b>> f112913a;

    /* JADX WARN: Multi-variable type inference failed */
    public e(Function1<? super SceneType, ? extends j70.h<? extends h70.b>> r100, FunctionType r101) {
        Intrinsics.checkNotNullParameter(r100, "creator");
        Intrinsics.checkNotNullParameter(r101, "functionType");
        this.f112913a = r100;
    }
}
