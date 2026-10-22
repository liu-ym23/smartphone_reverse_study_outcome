package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import androidx.core.provider.FontsContractCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: TypefaceCompat.java */
/* JADX INFO: loaded from: classes.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final p f1219a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final androidx.b.e<String, Typeface> f1220b = null;

    /* JADX INFO: compiled from: TypefaceCompat.java */
    public static class a extends FontsContractCompat.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private androidx.core.content.b.h.f f1221a;

        public a(androidx.core.content.b.h.f r1) {
            this.f1221a = r1;
        }

        @Override // androidx.core.provider.FontsContractCompat.c
        public void a(Typeface r1) {
            androidx.core.content.b.h.f r0 = this.f1221a;
            if (r0 == null) goto L6;
            r0.a(r1);
            return;
        }

        @Override // androidx.core.provider.FontsContractCompat.c
        public void a(int r1) {
            androidx.core.content.b.h.f r0 = this.f1221a;
            if (r0 == null) goto L6;
            r0.a(r1);
            return;
        }
    }

    static {
        if (Build.VERSION.SDK_INT < 29) goto L6;
        f1219a = new o();
    L20:
        f1220b = new androidx.b.e(16);
        return;
    L6:
        if (Build.VERSION.SDK_INT < 28) goto L9;
        f1219a = new n();
        goto L20
    L9:
        if (Build.VERSION.SDK_INT < 26) goto L12;
        f1219a = new m();
        goto L20
    L12:
        if (Build.VERSION.SDK_INT < 24) goto L17;
        if (l.a() == false) goto L17;
        f1219a = new l();
    L17:
        if (Build.VERSION.SDK_INT < 21) goto L19;
        f1219a = new k();
        goto L20
    L19:
        f1219a = new p();
        goto L20
    }

    public static Typeface a(Resources r1, int r2, String r3, int r4, int r5) {
        return (Typeface) ZeusTransformUtils.preCheckCast(f1220b.a(b(r1, r2, r3, r4, r5)), Typeface.class, "com.obric.aiagent.plugin");
    }

    private static String b(Resources r1, int r2, String r3, int r4, int r5) {
        return r1.getResourcePackageName(r2) + '-' + r3 + '-' + r4 + '-' + r2 + '-' + r5;
    }

    private static Typeface a(String r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        if (r3.isEmpty() == true) goto L16;
        Typeface r4 = Typeface.create(r3, 0);
        Typeface r1 = Typeface.create(Typeface.DEFAULT, 0);
        if (r4 != null) goto L10;
        return null;
    L10:
        if (r4.equals(r1) == false) goto L12;
        return null;
    L12:
        return r4;
    L16:
        return null;
    }

    public static Typeface a(Context r11, androidx.core.content.b.e.b r12, Resources r13, int r14, String r15, int r16, int r17, androidx.core.content.b.h.f r18, Handler r19, boolean r20) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.aiagent.plugin");
        androidx.core.content.b.e.b r2 = (androidx.core.content.b.e.b) ZeusTransformUtils.wrapperContextForParams(r12, androidx.core.content.b.e.b.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r2, androidx.core.content.b.e.C0026e.class) == false) goto L21;
        androidx.core.content.b.e.C0026e r3 = (androidx.core.content.b.e.C0026e) ZeusTransformUtils.preCheckCast(r2, androidx.core.content.b.e.C0026e.class, "com.obric.aiagent.plugin");
        Typeface r5 = a(r3.d());
        if (r5 == null) goto L10;
        if (r18 == null) goto L8;
        r18.a(r5, r19);
    L8:
        return r5;
    L10:
        if (r20 == true) goto L12;
        if (r18 != null) goto L16;
    L15:
        boolean r7 = true;
    L17:
        if (r20 == false) goto L19;
        int r6 = r3.c();
    L20:
        Handler r9 = androidx.core.content.b.h.f.a(r19);
        a r10 = new a(r18);
        Typeface r0 = FontsContractCompat.a(r4, r3.a(), r17, r7, r6, r9, r10);
    L27:
        if (r0 == null) goto L29;
        f1220b.a(b(r13, r14, r15, r16, r17), r0);
    L29:
        return r0;
    L19:
        r6 = -1;
    L16:
        r7 = false;
        goto L17
    L12:
        if (r3.b() != 0) goto L16;
    L21:
        Typeface r8 = f1219a.a(r4, (androidx.core.content.b.e.c) ZeusTransformUtils.preCheckCast(r2, androidx.core.content.b.e.c.class, "com.obric.aiagent.plugin"), r13, r17);
        if (r18 == null) goto L26;
        if (r8 == null) goto L25;
        r18.a(r8, r19);
        goto L26
    L25:
        r18.a(-3, r19);
    L26:
        r0 = r8;
        goto L27
    }

    public static Typeface a(Context r6, Resources r7, int r8, String r9, int r10, int r11) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        Typeface r12 = f1219a.a(r1, r7, r8, r9, r11);
        if (r12 == null) goto L5;
        String r13 = b(r7, r8, r9, r10, r11);
        f1220b.a(r13, r12);
    L5:
        return r12;
    }

    public static Typeface a(Context r2, CancellationSignal r3, FontsContractCompat.b[] r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        return f1219a.a(r6, r3, r4, r5);
    }

    private static Typeface b(Context r2, Typeface r3, int r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        p r0 = f1219a;
        androidx.core.content.b.e.c r6 = r0.a(r3);
        if (r6 != null) goto L7;
        return null;
    L7:
        return r0.a(r5, r6, ZeusTransformUtils.getResources(r5, "com.obric.aiagent.plugin"), r4);
    }

    public static Typeface a(Context r2, Typeface r3, int r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L12;
        if (Build.VERSION.SDK_INT >= 21) goto L10;
        Typeface r6 = b(r5, r3, r4);
        if (r6 == null) goto L10;
        return r6;
    L10:
        return Typeface.create(r3, r4);
    L12:
        throw new IllegalArgumentException("Context cannot be null");
    }
}
