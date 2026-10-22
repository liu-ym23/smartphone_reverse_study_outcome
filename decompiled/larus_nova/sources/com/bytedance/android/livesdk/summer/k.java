package com.bytedance.android.livesdk.summer;

import com.bytedance.android.livesdkapi.service.ISummerService;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public class k<R> extends j<R> {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f158475k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f158476l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f158477m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Function0<? extends R> f158478n;

    @Override // com.bytedance.android.livesdkapi.summer.ISummerTask
    public final void onRelease() {
    }

    @Override // com.bytedance.android.livesdk.summer.c
    public final R f() {
        return this.f158478n.invoke();
    }

    @Override // com.bytedance.android.livesdk.summer.j, com.bytedance.android.livesdkapi.summer.ISummerTask
    public final int getPriority() {
        return this.f158477m;
    }

    @Override // com.bytedance.android.livesdk.summer.j, com.bytedance.android.livesdkapi.summer.ISummerTask
    public final int getTaskType() {
        return this.f158476l;
    }

    @Override // com.bytedance.android.livesdk.summer.j
    public final int h() {
        return this.f158475k;
    }

    @Override // com.bytedance.android.livesdkapi.summer.ISummerTask
    public final /* bridge */ /* synthetic */ Boolean needCancel() {
        return Boolean.FALSE;
    }

    public k(@ISummerService.TaskID int r100, int r101, int r102, Function0<? extends R> r103) {
        Intrinsics.checkNotNullParameter(r103, "action");
        this.f158475k = r100;
        this.f158476l = r101;
        this.f158477m = r102;
        this.f158478n = r103;
    }
}
