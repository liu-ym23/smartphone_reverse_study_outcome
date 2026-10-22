package bt1;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes8.dex */
public final class f implements DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f20527a;

    public f(b r100) {
        this.f20527a = r100;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        this.f20527a.f20505i = null;
    }
}
