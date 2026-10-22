package com.bytedance.android.anya.internal;

import android.os.Looper;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Action;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class d<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayDeque<E> f41677a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<Function1<E, Boolean>> f41678b;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f41679a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function1 f41680b;

        public a(d r100, Function1 r101) {
            this.f41679a = r100;
            this.f41680b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Iterator<E> r100 = this.f41679a.f41677a.iterator();     // Catch: Throwable -> L10
        L4:
            if (r100.hasNext() == false) goto L8;
            E r101 = r100.next();     // Catch: Throwable -> L10
            if (((Boolean) this.f41680b.invoke(r101)).booleanValue() == false) goto L4;
            r100.remove();     // Catch: Throwable -> L10
            goto L4
        L8:
            this.f41679a.f41678b.add(this.f41680b);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L14;
            return;
        L14:
            throw th;
        }
    }

    public static final class b implements Action {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f41681a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function1 f41682b;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f41683a;

            public a(b r100) {
                this.f41683a = r100;
            }

            @Override // java.lang.Runnable
            public final void run() {
                b r100 = this.f41683a;     // Catch: Throwable -> L4
                r100.f41681a.f41678b.remove(r100.f41682b);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public b(d r100, Function1 r101) {
            this.f41681a = r100;
            this.f41682b = r101;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            if ((!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) == false) goto L5;
            v.f41726a.post(new a(this));
            return;
        L5:
            this.f41681a.f41678b.remove(this.f41682b);
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f41684a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f41685b;

        public c(d r100, Object r101) {
            this.f41684a = r100;
            this.f41685b = r101;
        }

        public final void a() {
            Set<Function1<E, Boolean>> r100 = this.f41684a.f41678b;
            boolean r101 = true;
            if ((r100 instanceof Collection) == true) goto L5;
        L7:
            Iterator<T> r102 = r100.iterator();
        L9:
            if (r102.hasNext() == false) goto L13;
            if (((Boolean) ((Function1) r102.next()).invoke(this.f41685b)).booleanValue() == false) goto L9;
            r101 = false;
        L13:
            if (r101 == false) goto L19;
            this.f41684a.f41677a.push((E) this.f41685b);
            return;
        L19:
            return;
        L5:
            if (r100.isEmpty() == false) goto L7;
            goto L7
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public d() {
        this.f41677a = new ArrayDeque();
        this.f41678b = new LinkedHashSet();
    }

    public final Disposable a(Function1<? super E, Boolean> r100) {
        if ((!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) == false) goto L5;
        v.f41726a.post(new a(this, r100));
    L13:
        return Disposables.fromAction(new b(this, r100));
    L5:
        Iterator<E> r101 = this.f41677a.iterator();
    L7:
        if (r101.hasNext() == false) goto L11;
        if (r100.invoke(r101.next()).booleanValue() == false) goto L7;
        r101.remove();
        goto L7
    L11:
        this.f41678b.add(r100);
        goto L13
    }

    public final void b(E r100) {
        boolean r101 = true;
        if ((!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) == false) goto L5;
        v.f41726a.post(new c(this, r100));
        return;
    L5:
        Set<Function1<E, Boolean>> r102 = this.f41678b;
        if ((r102 instanceof Collection) == true) goto L8;
    L10:
        Iterator<T> r103 = r102.iterator();
    L12:
        if (r103.hasNext() == false) goto L16;
        if (((Boolean) ((Function1) r103.next()).invoke(r100)).booleanValue() == false) goto L12;
        r101 = false;
    L16:
        if (r101 == false) goto L23;
        this.f41677a.push(r100);
        return;
    L23:
        return;
    L8:
        if (r102.isEmpty() == false) goto L10;
        goto L10
    }
}
