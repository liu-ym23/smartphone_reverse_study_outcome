package com.bytedance.android.livesdk.padutils;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp;
import jc1.k;

/* JADX INFO: loaded from: classes11.dex */
public final class c {
    public static final void a(String r100) {
        rm0.a r101 = om0.c.e();
        if (r101 == null) goto L5;
        Context r102 = r101.getContext();
    L6:
        if (r102 != null) goto L8;
        return;
    L8:
        if (TextUtils.isEmpty(r100) == true) goto L17;
        IMiddlewareHostApp r103 = (IMiddlewareHostApp) k.f(IMiddlewareHostApp.class);
        if (r103 == null) goto L13;
        r103.centerToast(r102, r100, 0);
        return;
    L13:
        Toast r104 = Toast.makeText(r102, r100, 0);
        r104.setGravity(17, 0, 0);
        r104.show();
        return;
    L17:
        return;
    L5:
        r102 = null;
        goto L6
    }
}
