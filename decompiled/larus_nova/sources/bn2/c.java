package bn2;

import io.reactivex.functions.Consumer;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes11.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f19716a;

    public c(a r100) {
        this.f19716a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        a r102 = this.f19716a;
        a.InterfaceC0318a r103 = r102.f19707c;
        if (r103 == null) goto L10;
        ArrayList<fz.a> r104 = r102.f19705a;
        boolean r105 = r102.f19709e;
        if (r102.f19708d == 0) goto L7;
        boolean r106 = true;
    L8:
        r103.a(r104, r105, r106);
        return;
    L7:
        r106 = false;
        goto L8
    }
}
