package com.bytedance.android.ec.core.slice.ectaggroup;

import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.ecom.arch.slice.action.r;
import com.bytedance.android.ecom.arch.slice.render.b;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECTagGroupViewWrapper f45340a;

    public a(ECTagGroupViewWrapper r100) {
        this.f45340a = r100;
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.b
    public final void a(r r100) {
        Intrinsics.checkNotNullParameter(r100, "actionInfo");
        IAction r101 = r100.f49993a;
        String r102 = r101.getType();
        if (r102.hashCode() == (-1444844223)) goto L6;
        return;
    L6:
        if (r102.equals("ectagCouponExpire") == false) goto L17;
        Map<String, Object> r103 = r101.getParams();
        Object r104 = null;
        if (r103 == null) goto L10;
        Object r105 = r103.get("tag_info");
    L12:
        if ((r105 instanceof Map) == false) goto L15;
        r104 = r105;
    L15:
        Map r106 = (Map) r104;
        ECTagGroupViewWrapper r107 = this.f45340a;
        Lazy r108 = ECTagGroupViewWrapper.f45337c;
        r107.getClass();
        return;
    L10:
        r105 = null;
        goto L12
    }
}
