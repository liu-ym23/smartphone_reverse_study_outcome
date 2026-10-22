package com.obric.autogui.common;

import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: StatusMessage.kt */
/* JADX INFO: loaded from: classes3.dex */
public class d<T> extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f29012a = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private T f29013c;

    /* JADX INFO: compiled from: StatusMessage.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }

        public final <T> d<T> a(T r4) {
            return new d(true, "", 0, r4);
        }

        public final <T> d<T> a(String r3) {
            o.e(r3, "msg");
            return new d(false, r3, 0, null);
        }

        public final <T> d<T> b(String r8) {
            o.e(r8, "msg");
            d<T> r7 = new d(false, r8, 0, null, 12, null);
            r7.a(true);
            return r7;
        }

        public final <T> d<T> a(int r4) {
            return new d(false, "failed", r4, null);
        }

        public final <T> d<T> a(e r4) {
            o.e(r4, "another");
            return new d(r4.g(), r4.h(), r4.i(), null);
        }

        public final <I extends O, O> d<O> a(d<I> r4) {
            o.e(r4, "<this>");
            return new d(r4.g(), r4.h(), r4.i(), r4.a());
        }
    }

    static {
        f29012a = new a(null);
    }

    public /* synthetic */ d(boolean r1, String r2, int r3, Object r4, int r5, h r6) {
        if ((r5 & 2) == 0) goto L6;
        r2 = "";
    L6:
        if ((r5 & 4) == 0) goto L9;
        r3 = 0;
    L9:
        if ((r5 & 8) == 0) goto L11;
        r4 = null;
    L11:
        this(r1, r2, r3, r4);
    }

    public final T a() {
        return this.f29013c;
    }

    public final void a(T r1) {
        this.f29013c = r1;
    }

    public d(boolean r2, String r3, int r4, T r5) {
        o.e(r3, "message");
        super(r2, r3, r4);
        this.f29013c = r5;
    }
}
