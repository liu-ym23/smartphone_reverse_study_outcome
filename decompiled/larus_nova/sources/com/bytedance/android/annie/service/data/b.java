package com.bytedance.android.annie.service.data;

import com.bytedance.android.annie.api.data.subscribe.e;
import com.bytedance.android.annie.api.data.subscribe.g;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f39869a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, g<?>> f39870b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<Character, Integer> f39871c = null;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e<T> f39872a;

        public a(e<T> r100) {
            this.f39872a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Disposable r101 = (Disposable) r100;
            b r102 = b.f39869a;
            b.b(this.f39872a);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.annie.service.data.b$b, reason: collision with other inner class name */
    public static final class C0746b implements Action {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e<T> f39873a;

        public C0746b(e<T> r100) {
            this.f39873a = r100;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            this.f39873a.onRelease();
            b.f39869a.d(this.f39873a);
        }
    }

    public b() {
    }

    static {
        f39869a = new b();
        f39870b = new ConcurrentHashMap();
        f39871c = new ConcurrentHashMap();
    }

    public static g a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return (g) ((ConcurrentHashMap) f39870b).get(r100);
    }

    public static void b(g r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        int r101 = x8.a.f562881a;
        StringBuilder r102 = new StringBuilder("register data provider, key:");
        r102.append(r100.key());
        r102.append(", split: ");
        r102.append(r100.d());
        r102.append(", hasExist: ");
        Map<String, g<?>> r103 = f39870b;
        ConcurrentHashMap r104 = (ConcurrentHashMap) r103;
        r102.append(r104.containsKey(r100.key()));
        x8.a.d("DataShareRegisterCenter", r102.toString(), false);
        r104.put(r100.key(), r100);
        Map<Character, Integer> r105 = f39871c;
        ConcurrentHashMap r106 = (ConcurrentHashMap) r105;
        Integer r107 = (Integer) r106.get(Character.valueOf(r100.d()));
        if (r107 == null) goto L5;
        int r108 = r107.intValue();
        r106.put(Character.valueOf(r100.d()), Integer.valueOf(r108 + 1));
        return;
    L5:
        r106.put(Character.valueOf(r100.d()), 1);
    }

    public final synchronized <T> Observable<Unit> c(e<T> r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "state");     // Catch: Throwable -> L6
        Observable<T> r101 = Observable.empty().doOnSubscribe(new a(r100)).doOnDispose(new C0746b(r100));     // Catch: Throwable -> L6
        monitor-exit(this);
        return r101;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized void d(e r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "state");     // Catch: Throwable -> L15
        int r101 = x8.a.f562881a;     // Catch: Throwable -> L15
        StringBuilder r102 = new StringBuilder("unregister data provider, key:");     // Catch: Throwable -> L15
        r102.append(r100.key());     // Catch: Throwable -> L15
        r102.append(", split: ");     // Catch: Throwable -> L15
        r102.append(r100.d());     // Catch: Throwable -> L15
        r102.append(", hashcode: ");     // Catch: Throwable -> L15
        r102.append(r100.hashCode());     // Catch: Throwable -> L15
        r102.append(", hasExist: ");     // Catch: Throwable -> L15
        Map<String, g<?>> r103 = f39870b;     // Catch: Throwable -> L15
        ConcurrentHashMap r104 = (ConcurrentHashMap) r103;     // Catch: Throwable -> L15
        r102.append(r104.containsKey(r100.key()));     // Catch: Throwable -> L15
        x8.a.d("DataShareRegisterCenter", r102.toString(), false);     // Catch: Throwable -> L15
        ConcurrentHashMap r105 = (ConcurrentHashMap) r103;     // Catch: Throwable -> L15
        if (Intrinsics.areEqual(r105.get(r100.key()), r100) == false) goto L7;
        ConcurrentHashMap r106 = (ConcurrentHashMap) r103;     // Catch: Throwable -> L15
        r106.remove(r100.key());     // Catch: Throwable -> L15
    L7:
        Map<Character, Integer> r107 = f39871c;     // Catch: Throwable -> L15
        ConcurrentHashMap r108 = (ConcurrentHashMap) r107;     // Catch: Throwable -> L15
        Integer r109 = (Integer) r108.get(Character.valueOf(r100.d()));     // Catch: Throwable -> L15
        if (r109 == null) goto L13;
        int r110 = r109.intValue();     // Catch: Throwable -> L15
        if (r110 <= 1) goto L12;
        ConcurrentHashMap r111 = (ConcurrentHashMap) r107;     // Catch: Throwable -> L15
        r111.put(Character.valueOf(r100.d()), Integer.valueOf(r110 - 1));     // Catch: Throwable -> L15
        goto L13
    L12:
        ConcurrentHashMap r112 = (ConcurrentHashMap) r107;     // Catch: Throwable -> L15
        r112.remove(Character.valueOf(r100.d()));     // Catch: Throwable -> L15
    L13:
        monitor-exit(this);
        return;
    L15:
        th = move-exception;
        throw th;
    }
}
