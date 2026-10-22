package a0b;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes34.dex */
public final class e implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.ss.android.lark.utils.h.e f1341a;

    public e(com.ss.android.lark.utils.h.e r100) {
        this.f1341a = r100;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        com.ss.android.lark.utils.h.e r102 = this.f1341a;
        if (r102 == null) goto L6;
        r102.a(true);
        return;
    }
}
