package com.bytedance.android.livesdk.chatroom.vs_base.base.util;

import com.huawei.hms.framework.common.ContainerUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<eua.c> f117948a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f117949b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f117950c;

    public final String c() {
        if (((ArrayList) this.f117948a).isEmpty() == true) goto L5;
        List<eua.c> r100 = this.f117948a;
        String r101 = this.f117950c;
        StringBuilder r102 = new StringBuilder();
        Iterator r103 = ((ArrayList) r100).iterator();
    L8:
        if (r103.hasNext() == false) goto L17;
        cua.c r104 = (cua.c) r103.next();
        String r105 = dua.a.a(r104.getName(), r101);
        String r106 = r104.getValue();
        if (r106 == null) goto L12;
        String r107 = dua.a.a(r106, r101);
    L14:
        if (r102.length() <= 0) goto L16;
        r102.append("&");
    L16:
        r102.append(r105);
        r102.append(ContainerUtils.KEY_VALUE_DELIMITER);
        r102.append(r107);
        goto L8
    L12:
        r107 = "";
        goto L14
    L17:
        String r108 = r102.toString();
        String r109 = this.f117949b;
        if (r109 != null) goto L20;
        return r108;
    L20:
        if (r109.length() == 0) goto L36;
        int r110 = this.f117949b.indexOf(63);
        if (r110 < 0) goto L31;
        if (this.f117949b.indexOf(61, r110) <= 0) goto L29;
        int r111 = r110 + 1;
        return this.f117949b.substring(0, r111) + r108 + "&" + this.f117949b.substring(r111);
    L29:
        return this.f117949b + "&" + r108;
    L31:
        return this.f117949b + "?" + r108;
    L36:
        return r108;
    L5:
        return this.f117949b;
    }

    public final String toString() {
        return c();
    }

    public p(String r100) {
        this.f117948a = new ArrayList();
        this.f117950c = "UTF-8";
        this.f117949b = r100;
    }

    public final void a(String r100, int r101) {
        List<eua.c> r102 = this.f117948a;
        ArrayList r103 = (ArrayList) r102;
        r103.add(new eua.c(r100, String.valueOf(r101)));
    }

    public final void b(String r100, String r101) {
        List<eua.c> r102 = this.f117948a;
        ArrayList r103 = (ArrayList) r102;
        r103.add(new eua.c(r100, r101));
    }
}
