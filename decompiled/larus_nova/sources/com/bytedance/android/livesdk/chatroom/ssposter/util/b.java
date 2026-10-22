package com.bytedance.android.livesdk.chatroom.ssposter.util;

import android.graphics.Bitmap;
import android.view.View;
import com.bytedance.android.live.base.model.ImageModel;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageModel f111576a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function2<View, Bitmap, Unit> f111577b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Bitmap f111578c;

    public b() {
        throw null;
    }

    public b(ImageModel r100, Function2 r101) {
        Intrinsics.checkNotNullParameter(r100, "imageModel");
        Intrinsics.checkNotNullParameter(r101, "loadedAction");
        this.f111576a = r100;
        this.f111577b = r101;
        this.f111578c = null;
    }
}
