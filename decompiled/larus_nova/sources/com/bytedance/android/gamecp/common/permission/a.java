package com.bytedance.android.gamecp.common.permission;

import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a implements uu.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f56725a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Continuation f56726b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ b f56727c;

    @Override // uu.b
    public final void cancel() {
        if (this.f56725a == true) goto L6;
        this.f56725a = true;
        Continuation r100 = this.f56726b;
        Boolean r101 = Boolean.FALSE;
        Intrinsics.checkNotNullParameter(r100, "$this$resumeInJava");
        r100.resumeWith(Result.m9449constructorimpl(r101));
        return;
    }

    @Override // uu.b
    public final void execute() {
        if (this.f56725a == true) goto L6;
        yr.b.b(4, "PermissionFragment", "requestPermissions use ezpermission; beforeGoToAppSetting called");
        this.f56727c.f56728a.getClass();
        this.f56725a = true;
        Continuation r100 = this.f56726b;
        Boolean r101 = Boolean.TRUE;
        Intrinsics.checkNotNullParameter(r100, "$this$resumeInJava");
        r100.resumeWith(Result.m9449constructorimpl(r101));
        return;
    }

    public a(b r100, SafeContinuation r101) {
        this.f56727c = r100;
        this.f56726b = r101;
    }
}
