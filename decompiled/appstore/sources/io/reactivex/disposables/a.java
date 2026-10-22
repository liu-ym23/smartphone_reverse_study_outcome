package io.reactivex.disposables;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableContainer;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.e;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes4.dex */
public final class a implements Disposable, DisposableContainer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f20594a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f20595b;

    public a() {
    }

    public void a(e r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        Object[] r11 = r10.b();
        int r12 = r11.length;
        ArrayList r13 = null;
        int r14 = 0;
    L5:
        if (r14 >= r12) goto L16;
        Object r15 = r11[r14];
        if ((r15 instanceof Disposable) == false) goto L15;
        ((Disposable) r15).dispose();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        if (r13 != null) goto L14;
        r13 = new ArrayList();
    L14:
        r13.add(th);
    L15:
        r14 = r14 + 1;
        goto L5
    L16:
        if (r13 != null) goto L18;
        return;
    L18:
        if (r13.size() != 1) goto L22;
        throw ExceptionHelper.d((Throwable) r13.get(0));
    L22:
        throw new CompositeException(r13);
    }

    @Override // io.reactivex.internal.disposables.DisposableContainer
    public boolean add(Disposable r10) {
        io.reactivex.internal.functions.a.b(r10, "disposable is null");
        if (this.f20595b == true) goto L20;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.f20595b == true) goto L16;
        e r11 = this.f20594a;     // Catch: Throwable -> L10
        if (r11 != null) goto L12;
        r11 = new e();     // Catch: Throwable -> L10
        this.f20594a = r11;     // Catch: Throwable -> L10
    L12:
        r11.a(r10);     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        return true;
    L16:
        monitor-exit(this);     // Catch: Throwable -> L10
    L20:
        r10.dispose();
        return false;
    }

    public int b() {
        int r10 = 0;
        if (this.f20595b == false) goto L5;
        return 0;
    L5:
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L7:
        if (this.f20595b == false) goto L12;
        monitor-exit(this);     // Catch: Throwable -> L10
        return 0;
    L12:
        e r11 = this.f20594a;     // Catch: Throwable -> L10
        if (r11 == null) goto L15;
        r10 = r11.g();     // Catch: Throwable -> L10
    L15:
        monitor-exit(this);     // Catch: Throwable -> L10
        return r10;
    }

    @Override // io.reactivex.internal.disposables.DisposableContainer
    public boolean delete(Disposable r10) {
        io.reactivex.internal.functions.a.b(r10, "disposables is null");
        if (this.f20595b == false) goto L5;
        return false;
    L5:
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L7:
        if (this.f20595b == false) goto L12;
        monitor-exit(this);     // Catch: Throwable -> L10
        return false;
    L12:
        e r11 = this.f20594a;     // Catch: Throwable -> L10
        if (r11 != null) goto L15;
    L20:
        monitor-exit(this);     // Catch: Throwable -> L10
        return false;
    L15:
        if (r11.e(r10) == false) goto L20;
        monitor-exit(this);     // Catch: Throwable -> L10
        return true;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        if (this.f20595b == false) goto L5;
        return;
    L5:
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L7:
        if (this.f20595b == false) goto L12;
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    L12:
        this.f20595b = true;     // Catch: Throwable -> L10
        e r10 = this.f20594a;     // Catch: Throwable -> L10
        this.f20594a = null;     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        a(r10);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.f20595b;
    }

    @Override // io.reactivex.internal.disposables.DisposableContainer
    public boolean remove(Disposable r10) {
        if (delete(r10) == false) goto L6;
        r10.dispose();
        return true;
    L6:
        return false;
    }
}
