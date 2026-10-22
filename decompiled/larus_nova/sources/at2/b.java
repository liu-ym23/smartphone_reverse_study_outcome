package at2;

import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f16217a = null;

    static {
        f16217a = new b();
    }

    public b() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        String r102 = c.f16218a;
        Intrinsics.checkNotNullParameter("enter_room", "tag1");
        if (Intrinsics.areEqual(c.f16218a, "enter_room") == false) goto L6;
        c.f16218a = "";
        c.f16219b = "";
        return;
    }
}
