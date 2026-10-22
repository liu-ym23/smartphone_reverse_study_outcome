package com.bytedance.android.ec.core.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes43.dex */
@Deprecated(message = "狗屎，不要用")
public final class n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<i> f45649a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f45650b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f45651c;

    public final String c() {
        if (((ArrayList) this.f45649a).isEmpty() == true) goto L5;
        Iterator r100 = ((ArrayList) this.f45649a).iterator();
    L7:
        boolean r101 = false;
        if (r100.hasNext() == false) goto L14;
        if (StringsKt.contains$default(this.f45650b, ((i) r100.next()).f45605a, false, 2, null) == false) goto L7;
        if (this.f45651c == true) goto L7;
        r100.remove();
        goto L7
    L14:
        String r102 = e2.b(this.f45649a, "UTF-8");
        if (this.f45650b.length() != 0) goto L17;
        r101 = true;
    L17:
        if (r101 == false) goto L20;
        return r102;
    L20:
        if (StringsKt.indexOf$default(this.f45650b, '?', 0, false, 6, null) < 0) goto L23;
        return this.f45650b + Typography.amp + r102;
    L23:
        return this.f45650b + '?' + r102;
    L5:
        return this.f45650b;
    }

    public final String toString() {
        return c();
    }

    public n0(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "mUrl");
        this.f45650b = r100;
        this.f45651c = r101;
        this.f45649a = new ArrayList();
    }

    public final void a(String r100, long r101) {
        List<i> r102 = this.f45649a;
        ArrayList r103 = (ArrayList) r102;
        r103.add(new i(r100, String.valueOf(r101)));
    }

    public final void b(String r100, String r101) {
        List<i> r102 = this.f45649a;
        ArrayList r103 = (ArrayList) r102;
        r103.add(new i(r100, r101));
    }
}
