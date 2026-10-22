package com.bytedance.android.livesdk.log.filter;

import android.text.TextUtils;
import com.bytedance.android.live.core.setting.o2;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public final class l extends a<am2.i> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Boolean f153302e;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f153303c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f153304d;

    public l() {
        this.f153303c = "";
        this.f153304d = "";
    }

    @Override // com.bytedance.android.livesdk.log.filter.a, com.bytedance.android.livesdk.log.filter.o
    public final void a(Map<String, String> r100) {
        super.a(r100);
        am2.j.a().getClass();
        String r101 = "1";
        if (am2.j.f4288d == false) goto L5;
        String r102 = "1";
    L6:
        r100.put("is_first_start", r102);
        am2.j.c r103 = am2.j.a().f4291b;
        int r104 = -1;
        if (r103 != null) goto L9;
        int r105 = -1;
    L10:
        r100.put("net_quality", String.valueOf(r105));
        am2.j.b r106 = am2.j.a().f4292c;
        if (r106 != null) goto L13;
        int r107 = -1;
    L14:
        r100.put("downstream_throughput_kbps", String.valueOf(r107));
        am2.j.a r108 = am2.j.a().f4290a;
        if (r108 != null) goto L17;
        String r109 = "";
    L18:
        r100.put("definition", r109);
        r100.put("fold_state", FoldScreenUtils.a() + "");
        boolean r110 = FoldScreenUtils.f();
        if (r110 == false) goto L21;
        String r111 = "1";
    L22:
        r100.put("is_fold", r111);
        if (f153302e != null) goto L26;
        f153302e = o2.f65373a.getValue();
    L26:
        if (f153302e == Boolean.TRUE) goto L28;
        return;
    L28:
        if (TextUtils.isEmpty(this.f153303c) == false) goto L32;
        ce1.d r112 = ce1.e.f23443a;
        if (r112 == null) goto L32;
        this.f153303c = r112.a();
    L32:
        r100.put("is_pad", this.f153303c);
        if (r110 == true) goto L36;
        r101 = "0";
    L36:
        r100.put("is_fold_screen", r101);
        if (TextUtils.isEmpty(this.f153304d) == true) goto L41;
        if (TextUtils.equals(this.f153304d, "-1") == true) goto L41;
    L47:
        r100.put("fold_type", this.f153304d);
        return;
    L41:
        if (FoldScreenUtils.f66393a != null) goto L43;
        FoldScreenUtils.f66393a = (IMiddleWareHostContext) jc1.k.f(IMiddleWareHostContext.class);
    L43:
        IMiddleWareHostContext r113 = FoldScreenUtils.f66393a;
        if (r113 == null) goto L46;
        r104 = r113.getFoldType();
    L46:
        this.f153304d = String.valueOf(r104);
        goto L47
    L21:
        r111 = "0";
        goto L22
    L17:
        r109 = r108.getDefinition();
        goto L18
    L13:
        r107 = r106.a();
        goto L14
    L9:
        r105 = r103.getNetQuality();
        goto L10
    L5:
        r102 = "0";
        goto L6
    }
}
