package com.bytedance.android.ec.core.utils;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes43.dex */
public final class m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<i> f45642a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f45643b;

    public static final class a {
    }

    static {
    }

    public final String c() {
        if (((ArrayList) this.f45642a).isEmpty() == true) goto L5;
        Iterator r100 = ((ArrayList) this.f45642a).iterator();
    L7:
        boolean r101 = false;
        if (r100.hasNext() == false) goto L17;
        i r102 = (i) r100.next();
        if (StringsKt.contains$default(this.f45643b, r102.f45605a, false, 2, null) == false) goto L7;
        String r103 = this.f45643b;
        String r104 = r102.f45605a;
        String r105 = r102.f45606b;
        if (TextUtils.isEmpty(r103) == false) goto L14;
    L16:
        this.f45643b = r103;
        r100.remove();
        goto L7
    L14:
        if (TextUtils.isEmpty(r104) == true) goto L16;
        r103 = new Regex("(" + r104 + "=[^&]*)").replace(r103, r104 + com.alipay.sdk.m.n.a.f25612h + r105);
        goto L16
    L17:
        String r106 = e2.b(this.f45642a, "UTF-8");
        if (this.f45643b.length() != 0) goto L20;
        r101 = true;
    L20:
        if (r101 == false) goto L23;
        return r106;
    L23:
        if (StringsKt.indexOf$default(this.f45643b, '?', 0, false, 6, null) < 0) goto L26;
        return this.f45643b + Typography.amp + r106;
    L26:
        return this.f45643b + '?' + r106;
    L5:
        return this.f45643b;
    }

    public final String toString() {
        return c();
    }

    public m0(String r100) {
        Intrinsics.checkNotNullParameter(r100, "mUrl");
        this.f45643b = r100;
        this.f45642a = new ArrayList();
    }

    public final void a(String r100, String r101) {
        if (cg4.a.a(r101) == false) goto L6;
        List<i> r102 = this.f45642a;
        ArrayList r103 = (ArrayList) r102;
        r103.add(new i(r100, r101));
        return;
    }

    public final void b(String r100, String r101) {
        List<i> r102 = this.f45642a;
        ArrayList r103 = (ArrayList) r102;
        r103.add(new i(r100, r101));
    }
}
