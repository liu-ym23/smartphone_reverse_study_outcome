package bl3;

import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes14.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f19425a;

    public c(Function1 r100) {
        this.f19425a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Function1 r101 = this.f19425a;
        Long r102 = ((cl3.a) r100).a();
        if (r102 != null) goto L6;
    L8:
        boolean r103 = false;
    L9:
        r101.invoke(Boolean.valueOf(r103));
        return;
    L6:
        if (r102.longValue() != 1) goto L8;
        r103 = true;
        goto L9
    }
}
