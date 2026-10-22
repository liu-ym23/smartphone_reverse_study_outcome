package com.bytedance.android.annie.debug.ui;

import android.content.Context;
import android.view.View;
import com.bytedance.common.utility.android.ClipboardCompat;

/* JADX INFO: loaded from: classes43.dex */
public final class c implements View.OnLongClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DialogItem f39462a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DialogAdapter f39463b;

    public c(DialogItem r100, DialogAdapter r101) {
        this.f39462a = r100;
        this.f39463b = r101;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r100) {
        String r101 = this.f39462a.f39428b;
        if (r101 == null) goto L9;
        DialogAdapter r102 = this.f39463b;
        ClipboardCompat.setText(r102.f39421b, "", r101);
        Context r103 = r102.f39421b;
        if (r103 == null) goto L11;
        a8.d.a(r103, "已经复制到剪切板");
        return true;
    L11:
        return true;
    L9:
        return false;
    }
}
