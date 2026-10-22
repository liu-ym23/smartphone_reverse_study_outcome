package com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature;

import android.view.View;
import com.bytedance.android.shopping.anchorv4.helper.SlcTemplateViewHelper;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import ti.l;

/* JADX INFO: loaded from: classes13.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f180941a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.ecom.arch.slice.g f180942b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SlcTemplateViewHelper f180943c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final l f180944d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f180945e;

    public final void a() {
        l r100 = this.f180944d;
        if (r100 == null) goto L5;
        r100.release();
    L5:
        ((Map) this.f180941a.getValue()).clear();
    }

    public g(String r100, com.bytedance.android.ecom.arch.slice.g r101, SlcTemplateViewHelper r102, l r103, View r104, int r105) {
        if ((r105 & 4) == 0) goto L6;
        r102 = null;
    L6:
        if ((r105 & 8) == 0) goto L9;
        r103 = null;
    L9:
        if ((r105 & 16) == 0) goto L11;
        r104 = null;
    L11:
        Intrinsics.checkNotNullParameter(r100, "sliceType");
        Intrinsics.checkNotNullParameter(r101, "slice");
        this.f180942b = r101;
        this.f180943c = r102;
        this.f180944d = r103;
        this.f180945e = r104;
        this.f180941a = LazyKt.lazy(OptCacheItem$subViewCache$2.INSTANCE);
    }
}
