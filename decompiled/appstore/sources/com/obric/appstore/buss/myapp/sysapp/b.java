package com.obric.appstore.buss.myapp.sysapp;

import androidx.recyclerview.widget.DiffUtil;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends DiffUtil.ItemCallback {
    public b() {
    }

    public boolean a(a r10, a r11) {
        q.g(r10, "oldItem");
        q.g(r11, "newItem");
        if ((r10 instanceof a.C0168a) == true) goto L5;
        return false;
    L5:
        if ((r11 instanceof a.C0168a) == true) goto L7;
        return false;
    L7:
        if (((a.C0168a) r10).a() == ((a.C0168a) r11).a()) goto L9;
        return false;
    L9:
        if (q.b(r10.getAppInfo().obricPreloadApkFilePath, r11.getAppInfo().obricPreloadApkFilePath) == true) goto L11;
        return false;
    L11:
        if (r10.getAppInfo().appVersionCode == r11.getAppInfo().appVersionCode) goto L13;
        return false;
    L13:
        if (com.obric.appstore.buss.apps.b.f10596a.a(r10.getAppInfo(), r11.getAppInfo()) == false) goto L21;
        return true;
    L21:
        return false;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    public /* bridge */ /* synthetic */ boolean areContentsTheSame(Object r10, Object r11) {
        return a((a) r10, (a) r11);
    }

    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    public /* bridge */ /* synthetic */ boolean areItemsTheSame(Object r10, Object r11) {
        return b((a) r10, (a) r11);
    }

    public boolean b(a r10, a r11) {
        q.g(r10, "oldItem");
        q.g(r11, "newItem");
        if ((r10 instanceof a.C0168a) == true) goto L5;
        return false;
    L5:
        if ((r11 instanceof a.C0168a) == true) goto L7;
        return false;
    L7:
        return com.obric.appstore.buss.apps.b.f10596a.b(r10.getAppInfo(), r11.getAppInfo());
    }
}
