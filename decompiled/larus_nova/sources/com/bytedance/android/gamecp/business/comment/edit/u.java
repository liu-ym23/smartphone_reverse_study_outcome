package com.bytedance.android.gamecp.business.comment.edit;

import android.content.Context;
import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class u implements uu.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CommentEditorImageAdapter f52174a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f52175b;

    @Override // uu.d
    public final void onPermissionDenied(String... r100) {
        Intrinsics.checkNotNullParameter(r100, ComplianceResult.JsonKey.PERMISSIONS);
    }

    @Override // uu.d
    public final void onPermissionGrant(String... r100) {
        Intrinsics.checkNotNullParameter(r100, ComplianceResult.JsonKey.PERMISSIONS);
        this.f52174a.A2(this.f52175b);
    }

    public u(CommentEditorImageAdapter r100, Context r101) {
        this.f52174a = r100;
        this.f52175b = r101;
    }
}
