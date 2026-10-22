package com.bytedance.android.ec.model.response.anchorv3;

import android.widget.TextView;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f47945a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<TextView> f47946b;

    public d(String r100, List<TextView> r101) {
        Intrinsics.checkNotNullParameter(r101, "textViewList");
        this.f47945a = r100;
        this.f47946b = r101;
    }
}
