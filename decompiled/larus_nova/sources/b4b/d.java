package b4b;

import android.content.DialogInterface;
import android.view.KeyEvent;

/* JADX INFO: loaded from: classes35.dex */
public final class d implements DialogInterface.OnKeyListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f17711a;

    public d(b r100) {
        this.f17711a = r100;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public final boolean onKey(DialogInterface r100, int r101, KeyEvent r102) {
        if (r101 != 4) goto L7;
        this.f17711a.f17694b.invoke();
        return true;
    L7:
        return true;
    }
}
