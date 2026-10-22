package com.bytedance.android.livesdk.vscore_impl.paidlive.ablity.log;

import am2.n;
import android.text.TextUtils;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.vscore_api.paidlive.ability.i;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public abstract class a implements i {
    public a() {
    }

    @Override // com.bytedance.android.livesdk.vscore_api.paidlive.ability.i
    public void Ck() {
    }

    @Override // com.bytedance.android.livesdk.vscore_api.paidlive.ability.i
    public void E2(Map<String, String> r100) {
    }

    @Override // com.bytedance.android.livesdk.vscore_api.paidlive.ability.i
    public void L2() {
    }

    @Override // com.bytedance.android.livesdk.vscore_api.paidlive.ability.i
    public String Q6() {
        return "";
    }

    @Override // com.bytedance.android.livesdk.vscore_api.paidlive.ability.i
    public String ao() {
        return "";
    }

    @Override // com.bytedance.android.livesdk.vscore_api.paidlive.ability.i
    public void ca() {
    }

    @Override // com.bytedance.android.livesdk.vscore_api.paidlive.ability.i
    public void l2(Map<String, String> r100, long r101) {
    }

    @Override // com.bytedance.android.livesdk.vscore_api.paidlive.ability.i
    public void oa() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // com.bytedance.android.livesdk.vscore_api.paidlive.ability.i
    public void rd(Map<String, String> r100) {
    }

    @Override // com.bytedance.android.livesdk.vscore_api.paidlive.ability.i
    public void z3(Map<String, String> r100) {
    }

    @Override // com.bytedance.android.livesdk.vscore_api.paidlive.ability.i
    public Map<String, String> Ra() {
        return new LinkedHashMap();
    }

    @Override // com.bytedance.android.livesdk.vscore_api.paidlive.ability.i
    public final String R3(o<Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "pageFilter");
        Map<String, String> r101 = r100.getMap();
        String r102 = n.f().c();
        if (r102 != null) goto L5;
    L8:
        boolean r103 = true;
    L10:
        if (r103 == false) goto L12;
    L22:
        String r104 = r101.get("enter_from_merge");
        if (r104 != null) goto L26;
        return "";
    L26:
        return r104;
    L12:
        if (r101.containsKey("enter_from_ad_type") == false) goto L22;
        if (TextUtils.isEmpty(r101.get("enter_from_ad_type")) == true) goto L22;
        String r105 = r101.get("enter_from_ad_type");
        if (r105 != null) goto L18;
        r105 = r101.get("enter_from_merge");
    L18:
        if (r105 != null) goto L21;
        return "";
    L21:
        return r105;
    L5:
        if (r102.length() == 0) goto L8;
        r103 = false;
        goto L10
    }

    @Override // com.bytedance.android.livesdk.vscore_api.paidlive.ability.i
    public void setOnBuyTicketAction(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        Intrinsics.checkNotNullParameter(r100, "action");
    }
}
