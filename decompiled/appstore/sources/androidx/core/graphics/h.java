package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.os.Handler;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.provider.FontsContractCompat;

/* JADX INFO: loaded from: classes.dex */
public abstract class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TypefaceCompatBaseImpl f2565a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final androidx.collection.d f2566b = null;

    public static class a extends FontsContractCompat.FontRequestCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public androidx.core.content.res.a.e f2567a;

        public a(androidx.core.content.res.a.e r10) {
            this.f2567a = r10;
        }

        @Override // androidx.core.provider.FontsContractCompat.FontRequestCallback
        public void a(int r10) {
            androidx.core.content.res.a.e r11 = this.f2567a;
            if (r11 == null) goto L6;
            r11.onFontRetrievalFailed(r10);
            return;
        }

        @Override // androidx.core.provider.FontsContractCompat.FontRequestCallback
        public void b(Typeface r10) {
            androidx.core.content.res.a.e r11 = this.f2567a;
            if (r11 == null) goto L6;
            r11.onFontRetrieved(r10);
            return;
        }
    }

    static {
        f2565a = new i();
        f2566b = new androidx.collection.d(16);
    }

    public static Typeface a(Context r10, Typeface r11, int r12) {
        if (r10 == null) goto L6;
        return Typeface.create(r11, r12);
    L6:
        throw new IllegalArgumentException("Context cannot be null");
    }

    public static Typeface b(Context r10, CancellationSignal r11, FontsContractCompat.b[] r12, int r13) {
        return f2565a.b(r10, r11, r12, r13);
    }

    public static Typeface c(Context r13, FontResourcesParserCompat.FamilyResourceEntry r14, Resources r15, int r16, String r17, int r18, int r19, androidx.core.content.res.a.e r20, Handler r21, boolean r22) {
        if ((r14 instanceof FontResourcesParserCompat.d) == false) goto L22;
        FontResourcesParserCompat.d r10 = (FontResourcesParserCompat.d) r14;
        Typeface r11 = g(r10.c());
        if (r11 == null) goto L10;
        if (r20 == null) goto L8;
        r20.callbackSuccessAsync(r11, r21);
    L8:
        return r11;
    L10:
        if (r22 == true) goto L12;
        if (r20 == null) goto L13;
    L14:
        boolean r12 = false;
    L17:
        if (r22 == false) goto L20;
        int r23 = r10.d();
    L19:
        int r110 = r23;
        Typeface r24 = FontsContractCompat.c(r13, r10.b(), r19, r12, r110, androidx.core.content.res.a.e.getHandler(r21), new a(r20));
    L27:
        if (r24 == null) goto L29;
        f2566b.d(e(r15, r16, r17, r18, r19), r24);
    L29:
        return r24;
    L20:
        r23 = -1;
    L13:
        r12 = true;
        goto L17
    L12:
        if (r10.a() != 0) goto L14;
    L22:
        r24 = f2565a.a(r13, (FontResourcesParserCompat.b) r14, r15, r19);
        if (r20 == null) goto L27;
        if (r24 == null) goto L26;
        r20.callbackSuccessAsync(r24, r21);
        goto L27
    L26:
        r20.callbackFailAsync(-3, r21);
        goto L27
    }

    public static Typeface d(Context r10, Resources r11, int r12, String r13, int r14, int r15) {
        Typeface r16 = f2565a.c(r10, r11, r12, r13, r15);
        if (r16 == null) goto L5;
        String r17 = e(r11, r12, r13, r14, r15);
        f2566b.d(r17, r16);
    L5:
        return r16;
    }

    public static String e(Resources r10, int r11, String r12, int r13, int r14) {
        return r10.getResourcePackageName(r11) + '-' + r12 + '-' + r13 + '-' + r11 + '-' + r14;
    }

    public static Typeface f(Resources r10, int r11, String r12, int r13, int r14) {
        return (Typeface) f2566b.c(e(r10, r11, r12, r13, r14));
    }

    public static Typeface g(String r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        if (r10.isEmpty() == true) goto L16;
        Typeface r11 = Typeface.create(r10, 0);
        Typeface r12 = Typeface.create(Typeface.DEFAULT, 0);
        if (r11 != null) goto L10;
        return null;
    L10:
        if (r11.equals(r12) == false) goto L12;
        return null;
    L12:
        return r11;
    L16:
        return null;
    }
}
