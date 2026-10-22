package com.obric.appstore.buss.apps;

import androidx.recyclerview.widget.DiffUtil;
import com.bytedanceos.common.model.AppInfo;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends DiffUtil.ItemCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f10596a = null;

    static {
        f10596a = new b();
    }

    public b() {
    }

    public boolean a(AppInfo r10, AppInfo r11) {
        q.g(r10, "oldItem");
        q.g(r11, "newItem");
        if (q.b(r10, r11) == true) goto L5;
    L11:
        return false;
    L5:
        if (q.b(r10.appBrief, r11.appBrief) == false) goto L11;
        if (q.b(r10.appCategoryName, r11.appCategoryName) == false) goto L11;
        if (q.b(r10.recmd_brief, r11.recmd_brief) == false) goto L11;
        return true;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    public /* bridge */ /* synthetic */ boolean areContentsTheSame(Object r10, Object r11) {
        return a((AppInfo) r10, (AppInfo) r11);
    }

    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    public /* bridge */ /* synthetic */ boolean areItemsTheSame(Object r10, Object r11) {
        return b((AppInfo) r10, (AppInfo) r11);
    }

    public boolean b(AppInfo r10, AppInfo r11) {
        q.g(r10, "oldItem");
        q.g(r11, "newItem");
        return q.b(r10.appPackageName, r11.appPackageName);
    }
}
