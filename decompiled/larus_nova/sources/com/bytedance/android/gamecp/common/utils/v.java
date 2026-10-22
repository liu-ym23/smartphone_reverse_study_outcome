package com.bytedance.android.gamecp.common.utils;

import android.content.Context;
import com.bytedance.bpea.cert.token.TokenCert;
import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import java.io.File;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class v implements uu.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f57318a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ File f57319b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f57320c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f57321d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Function1 f57322e;

    @Override // uu.d
    public final void onPermissionDenied(String... r100) {
        Intrinsics.checkNotNullParameter(r100, ComplianceResult.JsonKey.PERMISSIONS);
        this.f57322e.invoke(null);
    }

    @Override // uu.d
    public final void onPermissionGrant(String... r100) {
        Intrinsics.checkNotNullParameter(r100, ComplianceResult.JsonKey.PERMISSIONS);
        TokenCert r101 = x.f57327a;
        x.a(this.f57318a, this.f57319b, this.f57320c, this.f57321d, this.f57322e);
    }

    public v(Context r100, File r101, String r102, String r103, Function1 r104) {
        this.f57318a = r100;
        this.f57319b = r101;
        this.f57320c = r102;
        this.f57321d = r103;
        this.f57322e = r104;
    }
}
