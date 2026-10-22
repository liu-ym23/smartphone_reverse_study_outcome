package androidx.core.provider;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.CancellationSignal;
import androidx.annotation.DoNotInline;
import androidx.core.content.res.FontResourcesParserCompat;
import com.bytedanceos.common.toolbox.ServerElements;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Comparator f2593a = null;

    public static class a {
        @DoNotInline
        public static Cursor a(ContentResolver r10, Uri r11, String[] r12, String r13, String[] r14, String r15, Object r16) {
            return r10.query(r11, r12, r13, r14, r15, (CancellationSignal) r16);
        }
    }

    static {
        f2593a = new q.b();
    }

    public static /* synthetic */ int a(byte[] r10, byte[] r11) {
        return g(r10, r11);
    }

    public static List b(Signature[] r10) {
        ArrayList r11 = new ArrayList();
        int r12 = r10.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r11.add(r10[r13].toByteArray());
        r13 = r13 + 1;
        goto L3
    L5:
        return r11;
    }

    public static boolean c(List r10, List r11) {
        if (r10.size() == r11.size()) goto L5;
        return false;
    L5:
        int r12 = 0;
    L7:
        if (r12 >= r10.size()) goto L12;
        if (Arrays.equals((byte[]) r10.get(r12), (byte[]) r11.get(r12)) == false) goto L10;
        r12 = r12 + 1;
        goto L7
    L10:
        return false;
    L12:
        return true;
    }

    public static List d(q.c r10, Resources r11) {
        if (r10.b() == null) goto L7;
        return r10.b();
    L7:
        return FontResourcesParserCompat.c(r11, r10.c());
    }

    public static FontsContractCompat.a e(Context r10, q.c r11, CancellationSignal r12) {
        ProviderInfo r13 = f(r10.getPackageManager(), r11, r10.getResources());
        if (r13 != null) goto L7;
        return FontsContractCompat.a.a(1, null);
    L7:
        return FontsContractCompat.a.a(0, h(r10, r11, r13.authority, r12));
    }

    public static ProviderInfo f(PackageManager r10, q.c r11, Resources r12) {
        String r13 = r11.e();
        int r14 = 0;
        ProviderInfo r15 = r10.resolveContentProvider(r13, 0);
        if (r15 == null) goto L18;
        if (r15.packageName.equals(r11.f()) == false) goto L16;
        List r16 = b(r10.getPackageInfo(r15.packageName, 64).signatures);
        Collections.sort(r16, f2593a);
        List r17 = d(r11, r12);
    L8:
        if (r14 >= r17.size()) goto L13;
        ArrayList r18 = new ArrayList((Collection) r17.get(r14));
        Collections.sort(r18, f2593a);
        if (c(r16, r18) == true) goto L11;
        r14 = r14 + 1;
        goto L8
    L11:
        return r15;
    L13:
        return null;
    L16:
        throw new PackageManager.NameNotFoundException("Found content provider " + r13 + ", but package was not " + r11.f());
    L18:
        throw new PackageManager.NameNotFoundException("No package found for authority: " + r13);
    }

    public static /* synthetic */ int g(byte[] r10, byte[] r11) {
        if (r10.length != r11.length) goto L5;
        int r12 = 0;
    L8:
        if (r12 >= r10.length) goto L14;
        byte r13 = r10[r12];
        byte r14 = r11[r12];
        if (r13 != r14) goto L12;
        r12 = r12 + 1;
        goto L8
    L12:
        return r13 - r14;
    L14:
        return 0;
    L5:
        return r10.length - r11.length;
    }

    public static FontsContractCompat.b[] h(Context r16, q.c r17, String r18, CancellationSignal r19) {
        ArrayList r10 = new ArrayList();
        Uri r11 = new Uri.Builder().scheme(ServerElements.CONTENT).authority(r18).build();
        Uri r12 = new Uri.Builder().scheme(ServerElements.CONTENT).authority(r18).appendPath("file").build();
        Cursor r13 = null;
        ContentResolver r14 = r16.getContentResolver();     // Catch: Throwable -> L13
        r13 = a.a(r14, r11, new String[]{"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"}, "query = ?", new String[]{r17.g()}, null, r19);     // Catch: Throwable -> L13
        if (r13 != null) goto L6;
    L33:
        if (r13 == null) goto L36;
        r13.close();
    L36:
        return (FontsContractCompat.b[]) r10.toArray(new FontsContractCompat.b[0]);
    L6:
        if (r13.getCount() <= 0) goto L33;
        int r15 = r13.getColumnIndex("result_code");     // Catch: Throwable -> L13
        ArrayList r20 = new ArrayList();     // Catch: Throwable -> L13
        int r21 = r13.getColumnIndex("_id");     // Catch: Throwable -> L13
        int r22 = r13.getColumnIndex("file_id");     // Catch: Throwable -> L13
        int r23 = r13.getColumnIndex("font_ttc_index");     // Catch: Throwable -> L13
        int r24 = r13.getColumnIndex("font_weight");     // Catch: Throwable -> L13
        int r110 = r13.getColumnIndex("font_italic");     // Catch: Throwable -> L13
    L8:
        if (r13.moveToNext() == false) goto L32;
        if (r15 == (-1)) goto L15;
        int r111 = r13.getInt(r15);     // Catch: Throwable -> L13
    L16:
        if (r23 == (-1)) goto L18;
        int r112 = r13.getInt(r23);     // Catch: Throwable -> L13
    L19:
        if (r22 != (-1)) goto L21;
        Uri r113 = ContentUris.withAppendedId(r11, r13.getLong(r21));     // Catch: Throwable -> L13
    L22:
        if (r24 == (-1)) goto L24;
        int r114 = r13.getInt(r24);     // Catch: Throwable -> L13
    L25:
        if (r110 == (-1)) goto L29;
        boolean r25 = true;
        if (r13.getInt(r110) != 1) goto L29;
    L30:
        r20.add(FontsContractCompat.b.a(r113, r112, r114, r25, r111));     // Catch: Throwable -> L13
    L29:
        r25 = false;
        goto L30
    L24:
        r114 = 400;
        goto L25
    L21:
        r113 = ContentUris.withAppendedId(r12, r13.getLong(r22));     // Catch: Throwable -> L13
        goto L22
    L18:
        r112 = 0;
        goto L19
    L15:
        r111 = 0;
        goto L16
    L32:
        r10 = r20;
    L13:
        th = move-exception;
        if (r13 == null) goto L39;
        r13.close();
    L39:
        throw th;
    }
}
