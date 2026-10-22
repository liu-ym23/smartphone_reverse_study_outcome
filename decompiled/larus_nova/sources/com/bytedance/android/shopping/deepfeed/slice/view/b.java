package com.bytedance.android.shopping.deepfeed.slice.view;

import com.bytedance.android.shopping.deepfeed.slice.action.t;
import com.bytedance.android.shopping.deepfeed.slice.action.v;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class b implements t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f173458a;

    public b(a r100) {
        this.f173458a = r100;
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.t
    public final v a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        v r101 = (v) ((LinkedHashMap) this.f173458a.f173437i).get(r100);
        if (r101 == null) goto L5;
        return r101;
    L5:
        t r102 = this.f173458a.f173433e;
        if (r102 != null) goto L10;
        return null;
    L10:
        return r102.a(r100);
    }
}
