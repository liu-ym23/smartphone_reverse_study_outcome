package com.bytedance.android.livesdk.chatroom.ssposter.util;

import android.graphics.Bitmap;
import com.bytedance.android.live.base.model.ImageModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f111595a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageModel f111596b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Bitmap f111597c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f111598d;

    public e(ImageModel r100, Bitmap r101) {
        Intrinsics.checkNotNullParameter(r100, "imageModel");
        this.f111596b = r100;
        this.f111597c = r101;
        this.f111598d = false;
    }
}
