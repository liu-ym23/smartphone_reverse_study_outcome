package com.bytedance.android.livesdk.feedback.view.preview;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class f<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LargeCardPreviewView f125018a;

    public f(LargeCardPreviewView r100) {
        this.f125018a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        if ((!Intrinsics.areEqual((Boolean) r100, Boolean.TRUE)) == true) goto L7;
        this.f125018a.f124993c.setVisibility(0);
        return;
    }
}
