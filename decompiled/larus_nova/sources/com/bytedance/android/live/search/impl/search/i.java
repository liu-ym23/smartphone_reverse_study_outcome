package com.bytedance.android.live.search.impl.search;

import com.google.gson.JsonObject;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class i<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f100775a;

    public i(h r100) {
        this.f100775a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ra1.e r101 = (ra1.e) r100;
        h r102 = this.f100775a;
        r102.f100755a = false;
        r102.f100758d = r101.d();
        this.f100775a.f100756b = r101.c();
        this.f100775a.f100758d = r101.d();
        this.f100775a.f100757c = r101.e();
        h r103 = this.f100775a;
        r103.f100761g = r101.k(r103.f100761g);
        List<ra1.f> r104 = r101.f();
        if (r104 != null) goto L5;
        return;
    L5:
        if ((!r104.isEmpty()) == true) goto L8;
        r104 = null;
    L8:
        if (r104 == null) goto L29;
        Iterator<T> r105 = r104.iterator();
    L11:
        if (r105.hasNext() == false) goto L21;
        ra1.f r106 = (ra1.f) r105.next();
        ra1.a r107 = r106.a();
        if (r107 == null) goto L15;
        String r108 = r101.e();
        Intrinsics.checkNotNullParameter(r108, "<set-?>");
        r107.f536803a = r108;
    L15:
        ra1.a r109 = r106.a();
        if (r109 == null) goto L11;
        JsonObject r110 = r101.g();
        if (r110 != null) goto L20;
        r110 = new JsonObject();
    L20:
        Intrinsics.checkNotNullParameter(r110, "<set-?>");
        r109.f536804b = r110;
        goto L11
    L21:
        h r111 = this.f100775a;
        r111.f100764j.C6(r104, r111.f100758d);
        return;
    }
}
