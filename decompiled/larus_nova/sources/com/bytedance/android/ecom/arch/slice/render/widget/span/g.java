package com.bytedance.android.ecom.arch.slice.render.widget.span;

import android.text.SpannableStringBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes44.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SpannableStringBuilder f51001a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f51002b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f51003c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f51004d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Float f51005e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<a> f51006f;

    public g(SpannableStringBuilder r100, long r101, boolean r102, e r103, Float r104, List r105, int r110) {
        if ((r110 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r110 & 2) == 0) goto L9;
        r101 = 0;
    L9:
        if ((r110 & 4) == 0) goto L12;
        r102 = false;
    L12:
        if ((r110 & 8) == 0) goto L15;
        r103 = null;
    L15:
        if ((r110 & 16) == 0) goto L18;
        r104 = null;
    L18:
        if ((r110 & 32) == 0) goto L20;
        r105 = null;
    L20:
        this.f51001a = r100;
        this.f51002b = r101;
        this.f51003c = r102;
        this.f51004d = r103;
        this.f51005e = r104;
        this.f51006f = r105;
    }
}
