package com.bytedance.android.livesdk.interactivity.roomintro.v2.adapter;

import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.core.widget.HSImageView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f140634a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f140635b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HSImageView f140636c;

    public p(View r100, TextView r101, HSImageView r102) {
        Intrinsics.checkNotNullParameter(r100, "tagLayout");
        Intrinsics.checkNotNullParameter(r101, "tagText");
        Intrinsics.checkNotNullParameter(r102, "tagIcon");
        this.f140634a = r100;
        this.f140635b = r101;
        this.f140636c = r102;
    }
}
