package com.bytedance.android.live.ui.artist;

import android.text.Spanned;
import java.util.Comparator;

/* JADX INFO: loaded from: classes7.dex */
public final class b implements Comparator<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Spanned f102044a;

    public b(Spanned r100) {
        this.f102044a = r100;
    }

    @Override // java.util.Comparator
    public final int compare(Object r100, Object r101) {
        if (r100 == null) goto L7;
        if (r101 != null) goto L6;
        return -1;
    L6:
        return this.f102044a.getSpanStart(r100) - this.f102044a.getSpanStart(r101);
    L7:
        return -1;
    }
}
