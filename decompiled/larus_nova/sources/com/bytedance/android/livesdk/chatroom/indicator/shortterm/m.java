package com.bytedance.android.livesdk.chatroom.indicator.shortterm;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.sti.ShortTermIcon;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f106649a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Vector<Integer> f106650b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Vector<ShortTermIcon> f106651c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ShortTermIndicatorManager f106652d;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m f106653a;

        public a(m r100) {
            this.f106653a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Long r101 = (Long) r100;
            m.a(this.f106653a);
        }
    }

    public m(ShortTermIndicatorManager r100) {
        Intrinsics.checkNotNullParameter(r100, "shortTermIndicatorManager");
        this.f106652d = r100;
        this.f106649a = "ShortTouchLazyShowController";
        this.f106650b = new Vector();
        this.f106651c = new Vector();
        new CompositeDisposable().add(Observable.timer(5, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this)));
    }

    public static final void a(m r100) {
        r100.f106650b.clear();
        if (r100.f106651c.size() == 0) goto L23;
        Iterator<ShortTermIcon> r101 = r100.f106651c.iterator();     // Catch: Throwable -> L10
    L7:
        if (r101.hasNext() == false) goto L12;
        ShortTermIcon r102 = r101.next();     // Catch: Throwable -> L10
        r100.f106652d.add(r102);     // Catch: Throwable -> L10
    L12:
        r100.f106651c.clear();
        return;
    L10:
        th = move-exception;
        ALogger.e(r100.f106649a, th);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        r100.f106651c.clear();
        throw th;
    }
}
