package com.bytedance.android.anniex.ability;

import com.bytedance.android.anniex.web.model.AnnieXWebModel;

/* JADX INFO: loaded from: classes43.dex */
public final class m implements ue7.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AnnieXWebModel f40226a;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ue7.b
    public final String a() {
        t36.j r100 = this.f40226a.f41473h;
        if (r100 == null) goto L11;
        t36.d r101 = r100.f544443a;
        if (r101 == null) goto L12;
        String r102 = (String) new y36.p(r101, "app_id", "").f565862b;
        if (r102 != null) goto L10;
        return "";
    L10:
        return r102;
    L12:
        return "";
    L11:
        return "";
    }

    public m(AnnieXWebModel r100) {
        this.f40226a = r100;
    }
}
