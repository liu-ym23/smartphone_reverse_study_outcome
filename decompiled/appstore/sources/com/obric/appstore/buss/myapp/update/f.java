package com.obric.appstore.buss.myapp.update;

import androidx.recyclerview.widget.DiffUtil;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes3.dex */
public final class f extends DiffUtil.ItemCallback {
    public f() {
    }

    public boolean a(e r10, e r11) {
        q.g(r10, "oldItem");
        q.g(r11, "newItem");
        if ((r10 instanceof e.a) == false) goto L14;
        if ((r11 instanceof e.a) == false) goto L14;
        if (((e.a) r10).a() != ((e.a) r11).a()) goto L12;
        if (com.obric.appstore.buss.apps.b.f10596a.a(r10.getAppInfo(), r11.getAppInfo()) == false) goto L12;
        return true;
    L12:
        return false;
    L14:
        if ((r10 instanceof e.b) == false) goto L25;
        if ((r11 instanceof e.b) == false) goto L25;
        e.b r12 = (e.b) r10;
        e.b r13 = (e.b) r11;
        if (r12.a() != r13.a()) goto L23;
        if (r12.b() != r13.b()) goto L23;
        return true;
    L23:
        return false;
    L25:
        if ((r10 instanceof e.c) == true) goto L27;
    L35:
        return false;
    L27:
        if ((r11 instanceof e.c) == false) goto L35;
        e.c r14 = (e.c) r10;
        e.c r15 = (e.c) r11;
        if (r14.a() != r15.a()) goto L34;
        if (r14.b() != r15.b()) goto L34;
        return true;
    L34:
        return false;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    public /* bridge */ /* synthetic */ boolean areContentsTheSame(Object r10, Object r11) {
        return a((e) r10, (e) r11);
    }

    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    public /* bridge */ /* synthetic */ boolean areItemsTheSame(Object r10, Object r11) {
        return b((e) r10, (e) r11);
    }

    public boolean b(e r10, e r11) {
        q.g(r10, "oldItem");
        q.g(r11, "newItem");
        if ((r10 instanceof e.a) == false) goto L9;
        if ((r11 instanceof e.a) == false) goto L9;
        return com.obric.appstore.buss.apps.b.f10596a.b(r10.getAppInfo(), r11.getAppInfo());
    L9:
        if ((r10 instanceof e.b) == false) goto L14;
        if ((r11 instanceof e.b) == false) goto L14;
        return true;
    L14:
        if ((r10 instanceof e.c) == true) goto L16;
        return false;
    L16:
        if ((r11 instanceof e.c) == false) goto L20;
        return true;
    L20:
        return false;
    }
}
