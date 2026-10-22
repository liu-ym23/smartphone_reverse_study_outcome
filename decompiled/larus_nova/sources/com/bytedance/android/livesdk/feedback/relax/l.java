package com.bytedance.android.livesdk.feedback.relax;

import java.util.ArrayList;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<String> f124803a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Integer> f124804b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<String> f124805c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<? extends ArrayList<Map<String, Object>>> f124806d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function1<? super Map<String, Object>, Unit> f124807e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function0<Unit> f124808f;

    public l(Function0<String> r100, Function0<Integer> r101, Function0<String> r102, Function0<? extends ArrayList<Map<String, Object>>> r103, boolean r104, Function1<? super Map<String, Object>, Unit> r105, Function0<Unit> r106) {
        Intrinsics.checkNotNullParameter(r100, "feedType");
        Intrinsics.checkNotNullParameter(r101, "iconNeed");
        Intrinsics.checkNotNullParameter(r102, "questionDesc");
        Intrinsics.checkNotNullParameter(r103, "options");
        Intrinsics.checkNotNullParameter(r105, "handleSelected");
        Intrinsics.checkNotNullParameter(r106, "handleCloseClick");
        this.f124803a = r100;
        this.f124804b = r101;
        this.f124805c = r102;
        this.f124806d = r103;
        this.f124807e = r105;
        this.f124808f = r106;
    }
}
