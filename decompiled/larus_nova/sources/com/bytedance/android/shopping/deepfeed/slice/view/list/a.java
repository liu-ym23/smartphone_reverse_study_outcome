package com.bytedance.android.shopping.deepfeed.slice.view.list;

import java.util.Map;
import kotlin.Pair;
import yg3.e;

/* JADX INFO: loaded from: classes13.dex */
public final class a implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DeepFeedSlcList f173587a;

    @Override // yg3.e
    public final void g() {
        DeepFeedSlcList r100 = this.f173587a;
        c r101 = r100.f173567n;
        if (r101 == null) goto L10;
        Pair<String, Map<String, Object>> r102 = r101.f173593d;
        if (r102 == null) goto L11;
        com.bytedance.android.shopping.deepfeed.slice.service.b r103 = r100.w();
        if (r103 == null) goto L12;
        r103.O(r102.getFirst(), (Map) r102.getSecond(), this.f173587a);
        return;
    L12:
        return;
    L11:
        return;
    }

    public a(DeepFeedSlcList r100) {
        this.f173587a = r100;
    }
}
