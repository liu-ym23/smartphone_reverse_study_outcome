package com.bytedance.android.rts.util;

import com.relax.relaxframework.ImageMode;
import com.relax.relaxframework.TapEvent;
import com.relax.relaxframework.p6;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f163395a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<String> f163396b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<p6> f163397c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageMode f163398d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function1<? super TapEvent, Unit> f163399e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function1<? super TapEvent, Unit> f163400f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f163401g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f163402h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f163403i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f163404j;

    public b() {
        throw null;
    }

    public b(String r100, Function0 r101, ArrayList r102, ImageMode r103, Function1 r104, Function1 r105, String r106, int r110) {
        if ((r110 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r110 & 4) == 0) goto L9;
        r102 = null;
    L9:
        if ((r110 & 8) == 0) goto L12;
        r103 = null;
    L12:
        if ((r110 & 16) == 0) goto L15;
        r104 = null;
    L15:
        if ((r110 & 32) == 0) goto L18;
        r105 = null;
    L18:
        if ((r110 & 256) == 0) goto L20;
        r106 = null;
    L20:
        Intrinsics.checkNotNullParameter(r100, "src");
        this.f163395a = r100;
        this.f163396b = r101;
        this.f163397c = r102;
        this.f163398d = r103;
        this.f163399e = r104;
        this.f163400f = r105;
        this.f163401g = null;
        this.f163402h = null;
        this.f163403i = r106;
        this.f163404j = null;
    }
}
