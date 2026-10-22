package com.bytedance.android.live.room.share.summersinging;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.larus.nova.R;
import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class n implements o60.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f100361a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ GroupPhotoShareLayoutViewHolder$trySaveImg$1 f100362b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function0 f100363c;

    @Override // o60.e
    public final void onPermissionDenied(String... r100) {
        Intrinsics.checkNotNullParameter(r100, ComplianceResult.JsonKey.PERMISSIONS);
        f2.b(R.string.ttlive_group_photo_request_perimission_denied, 0);
        ALogger.e("GroupPhotoShareLayoutViewHolder", "request permissoin denied");
        Function0 r101 = this.f100363c;
        if (r101 == null) goto L5;
        Unit r102 = (Unit) r101.invoke();
    L5:
        this.f100361a.f100357b = false;
    }

    @Override // o60.e
    public final void onPermissionGrant(String... r100) {
        Intrinsics.checkNotNullParameter(r100, ComplianceResult.JsonKey.PERMISSIONS);
        this.f100362b.invoke2();
    }

    public n(l r100, GroupPhotoShareLayoutViewHolder$trySaveImg$1 r101, Function0 r102) {
        this.f100361a = r100;
        this.f100362b = r101;
        this.f100363c = r102;
    }
}
