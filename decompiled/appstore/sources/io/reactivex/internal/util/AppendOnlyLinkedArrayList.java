package io.reactivex.internal.util;

import io.reactivex.functions.Predicate;

/* JADX INFO: loaded from: classes4.dex */
public class AppendOnlyLinkedArrayList {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f20722a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object[] f20723b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object[] f20724c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f20725d;

    public interface NonThrowingPredicate<T> extends Predicate<T> {
        @Override // io.reactivex.functions.Predicate
        boolean test(T r10);
    }

    public AppendOnlyLinkedArrayList(int r10) {
        this.f20722a = r10;
        Object[] r11 = new Object[r10 + 1];
        this.f20723b = r11;
        this.f20724c = r11;
    }

    public void a(Object r10) {
        int r11 = this.f20722a;
        int r12 = this.f20725d;
        if (r12 != r11) goto L5;
        Object[] r13 = new Object[r11 + 1];
        this.f20724c[r11] = r13;
        this.f20724c = r13;
        r12 = 0;
    L5:
        this.f20724c[r12] = r10;
        this.f20725d = r12 + 1;
    }

    public void b(NonThrowingPredicate r10) {
        Object[] r11 = this.f20723b;
        int r12 = this.f20722a;
    L3:
        if (r11 == null) goto L14;
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L13;
        Object[] r14 = r11[r13];
        if (r14 == null) goto L13;
        if (r10.test(r14) == true) goto L11;
        r13 = r13 + 1;
        goto L5
    L11:
        return;
    L13:
        r11 = r11[r12];
        goto L3
    }
}
