package androidx.core.graphics;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.fonts.FontStyle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.provider.FontsContractCompat;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class i extends TypefaceCompatBaseImpl {
    public i() {
    }

    public static int e(FontStyle r10, FontStyle r11) {
        int r12 = Math.abs(r10.getWeight() - r11.getWeight()) / 100;
        if (r10.getSlant() != r11.getSlant()) goto L5;
        int r13 = 0;
    L7:
        return r12 + r13;
    L5:
        r13 = 2;
        goto L7
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    public Typeface a(Context r10, FontResourcesParserCompat.b r11, Resources r12, int r13) {
        FontResourcesParserCompat.c[] r14 = r11.a();     // Catch: Exception -> L15
        int r15 = r14.length;     // Catch: Exception -> L15
        int r16 = 0;
        FontFamily.Builder r17 = null;
    L4:
        if (r16 >= r15) goto L11;
        FontResourcesParserCompat.c r18 = r14[r16];     // Catch: Exception -> L15
        Font r19 = new Font.Builder(r12, r18.a()).setWeight(r18.d()).setSlant(r18.e() ? 1 : 0).setTtcIndex(r18.b()).setFontVariationSettings(r18.c()).build();     // Catch: IOException -> L16 Exception -> L15
        if (r17 != null) goto L9;
        r17 = new FontFamily.Builder(r19);     // Catch: IOException -> L16 Exception -> L15
        goto L10
    L9:
        r17.addFont(r19);     // Catch: IOException -> L16 Exception -> L15
    L10:
        r16 = r16 + 1;
        goto L4
    L11:
        if (r17 != null) goto L13;
        return null;
    L13:
        FontFamily r20 = r17.build();     // Catch: Exception -> L15
        return new Typeface.CustomFallbackBuilder(r20).setStyle(d(r20, r13).getStyle()).build();
    L15:
        return null;
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    public Typeface b(Context r10, CancellationSignal r11, FontsContractCompat.b[] r12, int r13) {
        ContentResolver r14 = r10.getContentResolver();
        int r15 = r12.length;     // Catch: Exception -> L28
        int r16 = 0;
        FontFamily.Builder r17 = null;
    L4:
        if (r16 >= r15) goto L24;
        FontsContractCompat.b r18 = r12[r16];     // Catch: Exception -> L28
        ParcelFileDescriptor r19 = r14.openFileDescriptor(r18.d(), "r", r11);     // Catch: IOException -> L29 Exception -> L28
        if (r19 != null) goto L34;
        if (r19 == null) goto L23;
    L9:
        r19.close();     // Catch: IOException -> L29 Exception -> L28
        goto L23
    L34:
        Font r20 = new Font.Builder(r19).setWeight(r18.e()).setSlant(r18.f() ? 1 : 0).setTtcIndex(r18.c()).build();     // Catch: Throwable -> L14
        if (r17 != null) goto L16;
        r17 = new FontFamily.Builder(r20);     // Catch: Throwable -> L14
        goto L9
    L16:
        r17.addFont(r20);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        r19.close();     // Catch: Throwable -> L20
    L22:
        throw th;     // Catch: IOException -> L29 Exception -> L28
    L20:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L29 Exception -> L28
    L23:
        r16 = r16 + 1;
        goto L4
    L24:
        if (r17 != null) goto L26;
        return null;
    L26:
        FontFamily r21 = r17.build();     // Catch: Exception -> L28
        return new Typeface.CustomFallbackBuilder(r21).setStyle(d(r21, r13).getStyle()).build();
    L28:
        return null;
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    public Typeface c(Context r10, Resources r11, int r12, String r13, int r14) {
        Font r15 = new Font.Builder(r11, r12).build();     // Catch: Exception -> L4
        return new Typeface.CustomFallbackBuilder(new FontFamily.Builder(r15).build()).setStyle(r15.getStyle()).build();
    L4:
        return null;
    }

    public final Font d(FontFamily r10, int r11) {
        if ((r11 & 1) == 0) goto L5;
        int r12 = 700;
    L6:
        int r13 = 1;
        if ((r11 & 2) == 0) goto L9;
        int r14 = 1;
    L10:
        FontStyle r15 = new FontStyle(r12, r14);
        Font r16 = r10.getFont(0);
        int r17 = e(r15, r16.getStyle());
    L12:
        if (r13 >= r10.getSize()) goto L17;
        Font r18 = r10.getFont(r13);
        int r19 = e(r15, r18.getStyle());
        if (r19 >= r17) goto L16;
        r16 = r18;
        r17 = r19;
    L16:
        r13 = r13 + 1;
        goto L12
    L17:
        return r16;
    L9:
        r14 = 0;
        goto L10
    L5:
        r12 = 400;
        goto L6
    }
}
