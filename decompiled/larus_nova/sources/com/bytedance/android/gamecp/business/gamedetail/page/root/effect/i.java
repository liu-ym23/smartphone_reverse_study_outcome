package com.bytedance.android.gamecp.business.gamedetail.page.root.effect;

import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class i implements com.bytedance.ies.sve_core.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.gamecp.business.gamedetail.component.scaffold.g f55515a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JSONObject f55516b;

    @Override // com.bytedance.ies.sve_core.i
    public final boolean a() {
        return true;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof i) == false) goto L10;
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f55515a, r101.f55515a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f55516b, r101.f55516b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        com.bytedance.android.gamecp.business.gamedetail.component.scaffold.g r100 = this.f55515a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        JSONObject r104 = this.f55516b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ScaffoldDataUpdateIntent(props=" + this.f55515a + ", data=" + this.f55516b + ")";
    }

    public i(com.bytedance.android.gamecp.business.gamedetail.component.scaffold.g r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_PROPS);
        this.f55515a = r100;
        this.f55516b = r101;
    }
}
