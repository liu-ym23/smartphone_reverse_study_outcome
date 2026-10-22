package com.bytedance.android.livesdk.feedback.relax;

import java.util.ArrayList;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<String> f124809a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Integer> f124810b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<String> f124811c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<? extends ArrayList<Map<String, Object>>> f124812d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function1<? super Map<String, Object>, Unit> f124813e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function0<Unit> f124814f;

    public m(Function0<String> r100, Function0<Integer> r101, Function0<String> r102, Function0<? extends ArrayList<Map<String, Object>>> r103, Function1<? super Map<String, Object>, Unit> r104, Function0<Unit> r105) {
        Intrinsics.checkNotNullParameter(r100, "feedType");
        Intrinsics.checkNotNullParameter(r101, "iconNeed");
        Intrinsics.checkNotNullParameter(r102, "questionDesc");
        Intrinsics.checkNotNullParameter(r103, "options");
        Intrinsics.checkNotNullParameter(r104, "handleSelected");
        Intrinsics.checkNotNullParameter(r105, "handleCloseClick");
        this.f124809a = r100;
        this.f124810b = r101;
        this.f124811c = r102;
        this.f124812d = r103;
        this.f124813e = r104;
        this.f124814f = r105;
    }
}
