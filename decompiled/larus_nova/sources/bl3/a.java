package bl3;

import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes14.dex */
public final class a<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f19423a;

    public a(Function1 r100) {
        this.f19423a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        cl3.b r101 = (cl3.b) r100;
        Function1 r102 = this.f19423a;
        if (r102 == null) goto L13;
        Integer r103 = r101.a();
        if (r103 != null) goto L8;
    L10:
        boolean r104 = false;
    L11:
        Unit r105 = (Unit) r102.invoke(Boolean.valueOf(r104));
        return;
    L8:
        if (r103.intValue() != 0) goto L10;
        r104 = true;
        goto L11
    }
}
