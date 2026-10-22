package com.bytedance.android.livesdk.preview;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class g1<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LivePurePreviewView f156553a;

    public g1(LivePurePreviewView r100) {
        this.f156553a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        if ((!Intrinsics.areEqual((Boolean) r100, Boolean.TRUE)) == true) goto L10;
        LivePurePreviewView r101 = this.f156553a;
        r101.f156408j = true;
        if ((System.currentTimeMillis() - r101.f156406h) < r101.f156407i) goto L11;
        r101.f156406h = System.currentTimeMillis();
        r101.b();
        return;
    L11:
        return;
    }
}
