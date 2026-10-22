package com.bytedance.android.live.core.utils;

import android.app.Activity;
import android.content.Intent;
import android.os.Environment;
import android.provider.MediaStore;
import androidx.fragment.app.Fragment;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.common.utility.UIUtils;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes45.dex */
public final class k implements o60.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Activity f66198a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p1 f66199b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Fragment f66200c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f66201d;

    @Override // o60.e
    public final void onPermissionDenied(String... r100) {
        p1 r101 = this.f66199b;
        if (r101 == null) goto L5;
        r101.onCallback();
    L5:
        TokenCert r102 = q.f66260a;
    }

    @Override // o60.e
    public final void onPermissionGrant(String... r100) {
        if ("mounted".equals(Environment.getExternalStorageState()) == true) goto L8;
        UIUtils.displayToastWithIcon(this.f66198a, R.drawable.ttlive_close_popup_textpage, R.string.ttlive_core_photo_error_no_sdcard);
        p1 r101 = this.f66199b;
        if (r101 == null) goto L19;
        r101.onCallback();
        return;
    L19:
        return;
    L8:
        Intent r102 = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        Fragment r103 = this.f66200c;     // Catch: Exception -> L14
        if (r103 == null) goto L12;
        r103.startActivityForResult(r102, this.f66201d);     // Catch: Exception -> L14
    L16:
        return;
    L12:
        this.f66198a.startActivityForResult(r102, this.f66201d);     // Catch: Exception -> L14
    L14:
        UIUtils.displayToastWithIcon(this.f66198a, R.drawable.ttlive_close_popup_textpage, R.string.ttlive_core_photo_error_no_gallery);
    }

    public k(Activity r100, Fragment r101, int r102) {
        this.f66198a = r100;
        this.f66199b = null;
        this.f66200c = r101;
        this.f66201d = r102;
    }
}
