package com.bytedance.android.livesdk.interactivity.api.publicscreen.utils;

import android.text.Spanned;
import java.util.Comparator;

/* JADX INFO: loaded from: classes9.dex */
public final class w implements Comparator<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Spanned f133655a;

    public w(Spanned r100) {
        this.f133655a = r100;
    }

    @Override // java.util.Comparator
    public final int compare(Object r100, Object r101) {
        if (r100 == null) goto L7;
        if (r101 != null) goto L6;
        return -1;
    L6:
        return this.f133655a.getSpanStart(r100) - this.f133655a.getSpanStart(r101);
    L7:
        return -1;
    }
}
