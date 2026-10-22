package com.amap.api.col.jmsl;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.autonavi.aps.amapapi.storage.SdCardDbCreator;

/* renamed from: com.amap.api.col.jmsl.t1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1607t1 {

    /* renamed from: a, reason: collision with root package name */
    public volatile b f16961a = new b(0);

    /* renamed from: com.amap.api.col.jmsl.t1$a */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static C1607t1 f16962a = new C1607t1();
    }

    public C1607t1() {
        L1.c(TextUtils.isDigitsOnly("HttpsDecisionUtil") ? "SPUtil" : "HttpsDecisionUtil");
    }

    public static C1607t1 a() {
        return a.f16962a;
    }

    public void b(Context context) {
        if (this.f16961a == null) {
            this.f16961a = new b((byte) 0);
        }
        this.f16961a.f16964b = C1575l0.j(context, "open_common", SdCardDbCreator.FIELD_LASTLOC_TIME, true);
        this.f16961a.a(context);
        E.a(context).b();
    }

    public final void c(Context context, boolean z10) {
        if (this.f16961a == null) {
            this.f16961a = new b((byte) 0);
        }
        SharedPreferences.Editor editorB = C1575l0.b(context, "open_common");
        C1575l0.i(editorB, SdCardDbCreator.FIELD_LASTLOC_TIME, z10);
        C1575l0.e(editorB);
        this.f16961a.f16964b = z10;
    }

    public boolean d(boolean z10) {
        if (z10) {
            return true;
        }
        byte b10 = 0;
        if (this.f16961a == null) {
            this.f16961a = new b(b10);
        }
        return this.f16961a.c();
    }

    public void e(boolean z10) {
        if (this.f16961a == null) {
            this.f16961a = new b((byte) 0);
        }
        this.f16961a.b(z10);
    }

    public boolean f() {
        if (this.f16961a == null) {
            this.f16961a = new b((byte) 0);
        }
        return this.f16961a.c();
    }

    /* renamed from: com.amap.api.col.jmsl.t1$b */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public int f16963a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f16964b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f16965c;

        public b() {
            this.f16963a = 0;
            this.f16964b = true;
            this.f16965c = false;
        }

        public final void a(Context context) {
            if (context != null && this.f16963a <= 0) {
                this.f16963a = context.getApplicationContext().getApplicationInfo().targetSdkVersion;
            }
        }

        public final void b(boolean z10) {
            this.f16965c = z10;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001b  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x001f A[RETURN] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final boolean c() {
            /*
                r3 = this;
                boolean r0 = r3.f16965c
                r1 = 1
                if (r0 != 0) goto L20
                boolean r0 = r3.f16964b
                r2 = 0
                if (r0 == 0) goto L1b
                int r3 = r3.f16963a
                r0 = 28
                if (r3 > 0) goto L11
                r3 = r0
            L11:
                if (r3 < r0) goto L15
                r3 = r1
                goto L16
            L15:
                r3 = r2
            L16:
                if (r3 == 0) goto L19
                goto L1b
            L19:
                r3 = r2
                goto L1c
            L1b:
                r3 = r1
            L1c:
                if (r3 == 0) goto L1f
                goto L20
            L1f:
                return r2
            L20:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.jmsl.C1607t1.b.c():boolean");
        }

        public /* synthetic */ b(byte b10) {
            this();
        }
    }
}
