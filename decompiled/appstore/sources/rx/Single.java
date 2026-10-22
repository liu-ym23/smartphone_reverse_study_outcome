package rx;

import jg.b;
import og.c;
import rx.functions.Action1;
import rx.functions.Func1;

/* JADX INFO: loaded from: classes4.dex */
public class Single {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OnSubscribe f24141a;

    public interface OnSubscribe<T> extends Action1<b> {
    }

    public interface Transformer<T, R> extends Func1<Single, Single> {
    }

    public Single(OnSubscribe r10) {
        this.f24141a = c.i(r10);
    }
}
