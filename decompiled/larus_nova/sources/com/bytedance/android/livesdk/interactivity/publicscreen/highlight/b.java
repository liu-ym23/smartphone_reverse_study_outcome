package com.bytedance.android.livesdk.interactivity.publicscreen.highlight;

import android.content.Context;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.h;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.i;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class b implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<i> f138920a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f138921b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k f138922c;

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.h
    public final void a() {
        Iterator<T> r100 = this.f138920a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((i) r100.next()).a();
        goto L4
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.h
    public final void b() {
        Iterator<T> r100 = this.f138920a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((i) r100.next()).b();
        goto L4
    }

    public b(Context r100, PSHighlightContext r101) {
        Intrinsics.checkNotNullParameter(r101, "psHighlightContext");
        this.f138921b = r100;
        this.f138922c = r101;
        this.f138920a = new ArrayList();
    }
}
