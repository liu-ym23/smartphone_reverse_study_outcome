package com.bytedance.android.annie.card.web;

import android.app.Activity;
import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes43.dex */
public final class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UploadFileFragment f39196a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Intent f39197b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Activity f39198c;

    @Override // com.bytedance.android.annie.card.web.a
    public final void onPermissionDenied() {
        com.bytedance.android.annie.util.c.b(this.f39198c, R.string.hybrid_web_upload_cancel);
        UploadFileFragment r100 = this.f39196a;
        int r101 = UploadFileFragment.f39150i;
        r100.T90(null);
    }

    @Override // com.bytedance.android.annie.card.web.a
    public final void onPermissionGranted() {
        UploadFileFragment r100 = this.f39196a;
        Intent r101 = this.f39197b;
        int r102 = UploadFileFragment.f39150i;
        r100.V90(r101);
    }

    public b(UploadFileFragment r100, Intent r101, FragmentActivity r102) {
        this.f39196a = r100;
        this.f39197b = r101;
        this.f39198c = r102;
    }
}
