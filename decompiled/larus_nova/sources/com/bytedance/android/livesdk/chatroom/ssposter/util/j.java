package com.bytedance.android.livesdk.chatroom.ssposter.util;

import android.graphics.Bitmap;
import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bitmap f111610a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function2<? super View, ? super Bitmap, Unit> f111611b;

    public j(Bitmap r100, Function2<? super View, ? super Bitmap, Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "loadAction");
        this.f111610a = r100;
        this.f111611b = r101;
    }
}
