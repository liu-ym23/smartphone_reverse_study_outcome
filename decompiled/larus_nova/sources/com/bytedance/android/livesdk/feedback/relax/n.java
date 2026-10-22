package com.bytedance.android.livesdk.feedback.relax;

import java.util.ArrayList;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<String> f124815a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Integer> f124816b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<String> f124817c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<? extends ArrayList<Map<String, Object>>> f124818d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function1<? super Map<String, Object>, Unit> f124819e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function0<Unit> f124820f;

    public n(Function0 r100, Function0 r101, Function0 r102, Function0 r103, Function1 r104, Function0 r105) {
        Intrinsics.checkNotNullParameter(r100, "feedType");
        Intrinsics.checkNotNullParameter(r101, "iconNeed");
        Intrinsics.checkNotNullParameter(r102, "questionDesc");
        Intrinsics.checkNotNullParameter(r103, "options");
        Intrinsics.checkNotNullParameter(r104, "handleSelected");
        Intrinsics.checkNotNullParameter(r105, "handleCloseClick");
        this.f124815a = r100;
        this.f124816b = r101;
        this.f124817c = r102;
        this.f124818d = r103;
        this.f124819e = r104;
        this.f124820f = r105;
    }
}
