package com.bytedance.android.gamecp.business.comment.edit;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.View;
import com.bytedance.bpea.cert.token.TokenCert;
import com.ss.android.download.api.constant.BaseConstants;
import java.util.Arrays;

/* JADX INFO: loaded from: classes44.dex */
public final class r implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CommentEditorImageAdapter f52168a;

    public r(CommentEditorImageAdapter r100) {
        this.f52168a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        CommentEditorImageAdapter r101 = this.f52168a;
        Context r102 = r100.getContext();
        r101.getClass();
        int r103 = Build.VERSION.SDK_INT;
        if (r103 != 33) goto L6;
        String[] r104 = {BaseConstants.PERMISSION_READ_MEDIA_IMAGES};
    L10:
        if (ru.c.c(r102, (String[]) Arrays.copyOf(r104, r104.length)) == false) goto L12;
        r101.A2(r102);
        return;
    L12:
        Activity r105 = com.bytedance.android.gamecp.common.utils.g.a(r102);
        TokenCert r106 = ru.j.f539228a;
        ru.j.b r107 = new ru.j.b(r105);
        r107.f539231c = new tu.d();
        u r108 = new u(r101, r102);
        String[] r109 = (String[]) Arrays.copyOf(r104, r104.length);
        r107.a(r108, ru.j.f539228a, r109);
        return;
    L6:
        if (r103 < 34) goto L8;
        r104 = new String[]{BaseConstants.PERMISSION_READ_MEDIA_IMAGES, "android.permission.READ_MEDIA_VISUAL_USER_SELECTED"};
        goto L10
    L8:
        r104 = new String[]{"android.permission.READ_EXTERNAL_STORAGE"};
        goto L10
    }
}
