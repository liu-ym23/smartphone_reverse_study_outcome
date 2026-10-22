package bl3;

import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes14.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f19424a;

    public b(Function1 r100) {
        this.f19424a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        Function1 r102 = this.f19424a;
        if (r102 == null) goto L6;
        Unit r103 = (Unit) r102.invoke(Boolean.FALSE);
        return;
    }
}
