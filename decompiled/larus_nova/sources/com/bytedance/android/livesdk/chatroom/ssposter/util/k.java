package com.bytedance.android.livesdk.chatroom.ssposter.util;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<View, Unit> f111612a;

    /* JADX WARN: Multi-variable type inference failed */
    public k(Function1<? super View, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "setAction");
        this.f111612a = r100;
    }
}
