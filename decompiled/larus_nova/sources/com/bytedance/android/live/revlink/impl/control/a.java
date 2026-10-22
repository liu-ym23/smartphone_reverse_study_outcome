package com.bytedance.android.live.revlink.impl.control;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Pair;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public final class a<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CreateLinkLynxWidget f92301a;

    public a(CreateLinkLynxWidget r100) {
        this.f92301a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Pair r101 = (Pair) r100;
        zy0.b r102 = this.f92301a.f92213b;
        if (r102 == null) goto L11;
        xy0.a<?> r103 = r102.g();
        if (r103 == null) goto L12;
        if (r101 == null) goto L8;
        JSONObject r104 = (JSONObject) r101.getSecond();
    L9:
        r103.sendJsEvent("H5_revenueInteractData", String.valueOf(r104));
        return;
    L8:
        r104 = null;
        goto L9
    L12:
        return;
    }
}
