package com.bytedance.android.livesdk.feedback.view.preview;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class e<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LargeCardPreviewView f125017a;

    public e(LargeCardPreviewView r100) {
        this.f125017a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        if ((!Intrinsics.areEqual((Boolean) r100, Boolean.TRUE)) == true) goto L7;
        this.f125017a.f124993c.setVisibility(4);
        return;
    }
}
