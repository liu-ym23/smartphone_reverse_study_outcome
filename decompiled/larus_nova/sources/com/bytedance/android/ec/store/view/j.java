package com.bytedance.android.ec.store.view;

import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes44.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f48933a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f48934b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, String> f48935c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<String> f48936d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final xm.c f48937e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function0<Unit> f48938f;

    public j(String r100, Integer r101, Map r102, Function0 r103, xm.c r104, Function0 r105, int r106) {
        if ((r106 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r106 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r106 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r106 & 8) == 0) goto L15;
        r103 = null;
    L15:
        if ((r106 & 16) == 0) goto L18;
        r104 = null;
    L18:
        if ((r106 & 64) == 0) goto L20;
        r105 = null;
    L20:
        this.f48933a = r100;
        this.f48934b = r101;
        this.f48935c = r102;
        this.f48936d = r103;
        this.f48937e = r104;
        this.f48938f = r105;
    }
}
