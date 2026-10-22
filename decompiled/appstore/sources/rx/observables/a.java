package rx.observables;

import rx.Observable;
import rx.functions.Action1;

/* JADX INFO: loaded from: classes4.dex */
public abstract class a extends Observable {
    public a(Observable.OnSubscribe r10) {
        super(r10);
    }

    public abstract void B(Action1 r10);
}
