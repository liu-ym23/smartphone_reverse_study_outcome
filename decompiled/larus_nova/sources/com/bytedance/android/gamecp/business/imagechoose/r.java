package com.bytedance.android.gamecp.business.imagechoose;

import io.reactivex.functions.Action;

/* JADX INFO: loaded from: classes44.dex */
public final class r implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r f56099a = null;

    static {
        f56099a = new r();
    }

    public r() {
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        yr.b.b(4, "Together#ImagePickerProvider", "upload finish, try to dismiss dialog");
        jv.a.a().b(new ImageChooseDialog.b());
    }
}
