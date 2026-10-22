package com.bytedance.android.debug;

import android.view.View;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;

/* JADX INFO: loaded from: classes43.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DebugAssetsListAdapter f42607a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f42608b;

    public a(DebugAssetsListAdapter r100, int r101) {
        this.f42607a = r100;
        this.f42608b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        List<com.bytedance.android.live.core.resources.e> r101 = this.f42607a.f42548b;
        if (r101 == null) goto L10;
        com.bytedance.android.live.core.resources.e r102 = (com.bytedance.android.live.core.resources.e) ListProtector.get(r101, this.f42608b);
        if (r102 == null) goto L11;
        DebugAssetsListAdapter.a r103 = this.f42607a.f42549c;
        if (r103 == null) goto L12;
        r103.a(r102);
        return;
    L12:
        return;
    L11:
        return;
    }
}
