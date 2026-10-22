package com.bytedance.android.live.broadcast.rts;

import com.relax.relaxframework.ImageMode;
import com.relax.relaxframework.TapEvent;
import com.relax.relaxframework.p6;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f59210a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<String> f59211b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<p6> f59212c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageMode f59213d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function1<? super TapEvent, Unit> f59214e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f59215f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f59216g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f59217h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f59218i;

    public j() {
        throw null;
    }

    public j(String r100, ArrayList r101, Function1 r102, int r103) {
        if ((r103 & 4) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 16) == 0) goto L8;
        r102 = null;
    L8:
        Intrinsics.checkNotNullParameter(r100, "src");
        this.f59210a = r100;
        this.f59211b = null;
        this.f59212c = r101;
        this.f59213d = null;
        this.f59214e = r102;
        this.f59215f = null;
        this.f59216g = null;
        this.f59217h = null;
        this.f59218i = null;
    }
}
