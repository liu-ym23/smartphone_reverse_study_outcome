package com.obric.oui.indexscrollbar;

import android.graphics.Bitmap;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: LBLetter.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f35307a = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static b f35308e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f35309b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f35310c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Bitmap[] f35311d;

    /* JADX INFO: compiled from: LBLetter.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }

        public final b a() {
            return b.c();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final b a(String r3) {
            o.e(r3, "letter");
            return new b(0, r3, null, 0 == true ? 1 : 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final b b(String r3) {
            o.e(r3, "letter");
            return new b(1, r3, null, 0 == true ? 1 : 0);
        }

        public final b a(String r3, Bitmap[] r4) {
            o.e(r3, "symbol");
            o.e(r4, "letterBitmaps");
            return new b(2, r3, r4, null);
        }
    }

    public /* synthetic */ b(int r1, String r2, Bitmap[] r3, h r4) {
        this(r1, r2, r3);
    }

    private b(int r2, String r3, Bitmap[] r4) {
        this.f35309b = r2;
        this.f35310c = r3;
        this.f35311d = r4;
        if (r2 != 2) goto L15;
        boolean r5 = false;
        if (r4 != null) goto L7;
        int r6 = 0;
    L9:
        if (r6 != 3) goto L11;
        r5 = true;
    L11:
        if (r5 == false) goto L14;
        this.f35311d = r4;
        return;
    L14:
        throw new IllegalStateException("symbol must have 3 bitmaps!".toString());
    L7:
        r6 = r4.length;
        goto L9
    }

    public static final /* synthetic */ b c() {
        return f35308e;
    }

    public final int getType() {
        return this.f35309b;
    }

    public final String a() {
        return this.f35310c;
    }

    public final Bitmap[] b() {
        return this.f35311d;
    }

    static {
        a r0 = new a(null);
        f35307a = r0;
        f35308e = r0.a("#");
    }
}
