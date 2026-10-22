package com.bytedance.android.shopping.abilities.pdp;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.ec.common.api.abilities.IShoppingAbilities;
import com.bytedance.android.ec.common.api.abilities.IShoppingAbilitiesAdapter;
import com.bytedance.android.ec.core.opt.ab.u;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class c implements IShoppingAbilitiesAdapter {
    public c() {
    }

    @Override // com.bytedance.android.ec.common.api.abilities.IShoppingAbilitiesAdapter
    public final void preloadPdpBySchema(Context r100, String r101, ze.a r102, boolean r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "schema");
        if (r110 == false) goto L5;
    L7:
        Uri r103 = UriProtector.parse(r101);
        int r111 = ECSdk.f48106a;
        IShoppingAbilities r104 = (IShoppingAbilities) ECSdk.a(IShoppingAbilities.class);
        if (r104 == null) goto L11;
        r104.preloadPdpBySchema(r100, a.b(r103), a.a(r103, false, false), null, r101);
        return;
    L11:
        return;
    L5:
        if (u.a() == true) goto L7;
    }
}
