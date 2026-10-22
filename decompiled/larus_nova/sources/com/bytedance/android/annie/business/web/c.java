package com.bytedance.android.annie.business.web;

import android.app.Activity;
import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes43.dex */
public final class c implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FixedUploadFileFragment f39094a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Intent f39095b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Activity f39096c;

    @Override // com.bytedance.android.annie.business.web.d
    public final void onPermissionDenied() {
        com.bytedance.android.annie.util.c.b(this.f39096c, R.string.hybrid_web_upload_cancel);
        FixedUploadFileFragment r100 = this.f39094a;
        int r101 = FixedUploadFileFragment.f39067i;
        r100.T90(null);
    }

    @Override // com.bytedance.android.annie.business.web.d
    public final void onPermissionGranted() {
        FixedUploadFileFragment r100 = this.f39094a;
        Intent r101 = this.f39095b;
        int r102 = FixedUploadFileFragment.f39067i;
        r100.W90(r101);
    }

    public c(FixedUploadFileFragment r100, Intent r101, FragmentActivity r102) {
        this.f39094a = r100;
        this.f39095b = r101;
        this.f39096c = r102;
    }
}
