package a0b;

import android.app.Activity;
import android.content.DialogInterface;
import com.larksuite.framework.utils.u;

/* JADX INFO: loaded from: classes34.dex */
public final class d implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Activity f1339a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.ss.android.lark.utils.h.e f1340b;

    public d(Activity r100, com.ss.android.lark.utils.h.e r101) {
        this.f1339a = r100;
        this.f1340b = r101;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        u.a(this.f1339a.getApplicationContext());
        com.ss.android.lark.utils.h.e r102 = this.f1340b;
        if (r102 == null) goto L6;
        r102.a(false);
        return;
    }
}
