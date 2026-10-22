package com.obric.appstore.buss.myapp.myapp;

import androidx.recyclerview.widget.DiffUtil;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends DiffUtil.ItemCallback {
    public c() {
    }

    public boolean a(b r10, b r11) {
        q.g(r10, "oldItem");
        q.g(r11, "newItem");
        if ((r10 instanceof b.a) == false) goto L13;
        if ((r11 instanceof b.a) == false) goto L13;
        if (r10.a() == r11.a()) goto L9;
        return false;
    L9:
        if (com.obric.appstore.buss.apps.b.f10596a.a(r10.getAppInfo(), r11.getAppInfo()) == false) goto L20;
        return true;
    L20:
        return false;
    L13:
        if ((r10 instanceof b.c) == true) goto L15;
    L18:
        return false;
    L15:
        if ((r11 instanceof b.c) == false) goto L18;
        return q.b(r10, r11);
    }

    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    public /* bridge */ /* synthetic */ boolean areContentsTheSame(Object r10, Object r11) {
        return a((b) r10, (b) r11);
    }

    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    public /* bridge */ /* synthetic */ boolean areItemsTheSame(Object r10, Object r11) {
        return b((b) r10, (b) r11);
    }

    public boolean b(b r10, b r11) {
        q.g(r10, "oldItem");
        q.g(r11, "newItem");
        if ((r10 instanceof b.a) == false) goto L14;
        if ((r11 instanceof b.a) == false) goto L14;
        if (r10.a() != r11.a()) goto L12;
        if (com.obric.appstore.buss.apps.b.f10596a.b(r10.getAppInfo(), r11.getAppInfo()) == false) goto L12;
        return true;
    L12:
        return false;
    L14:
        if ((r10 instanceof b.c) == true) goto L16;
    L22:
        return false;
    L16:
        if ((r11 instanceof b.c) == false) goto L22;
        if (r10.a() != r11.a()) goto L21;
        return true;
    L21:
        return false;
    }
}
