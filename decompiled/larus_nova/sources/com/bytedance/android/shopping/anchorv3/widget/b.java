package com.bytedance.android.shopping.anchorv3.widget;

import com.bytedance.android.shopping.api.anchorv3.ECLogExtraData;
import com.bytedance.android.shopping.extensions.h;
import jd3.n0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECLogExtraData f165599a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f165600b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function0 f165601c;

    public final void a() {
        this.f165601c.invoke();
        int r100 = com.bytedance.android.shopping.anchorv3.track.b.f165294a;
        String r101 = this.f165599a.getEnterFrom();
        String r102 = h.a(this.f165599a);
        String r103 = this.f165600b;
        if (r103.length() != 0) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == false) goto L8;
        r103 = "video";
    L8:
        Intrinsics.checkNotNullParameter("risk_popup_pass", "eventName");
        int r105 = a63.a.f1951a;
        int r106 = com.bytedance.android.ec.core.opt.ab.c.f45223a;
        n0 r107 = new n0("risk_popup_pass");
        r107.f498390a = r101;
        r107.f498391b = r102;
        r107.f498392c = r103;
        r107.post(null, null);
        return;
    L5:
        r104 = false;
        goto L6
    }

    public b(ECLogExtraData r100, String r101, Function0 r102) {
        this.f165599a = r100;
        this.f165600b = r101;
        this.f165601c = r102;
    }
}
