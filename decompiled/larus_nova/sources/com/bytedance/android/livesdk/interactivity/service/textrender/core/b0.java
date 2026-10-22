package com.bytedance.android.livesdk.interactivity.service.textrender.core;

import android.text.SpannableString;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SpannableString f141012a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<b> f141013b;

    public b0(SpannableString r100, List<b> r101) {
        Intrinsics.checkNotNullParameter(r100, "spannable");
        Intrinsics.checkNotNullParameter(r101, "asyncInfos");
        this.f141012a = r100;
        this.f141013b = r101;
    }
}
