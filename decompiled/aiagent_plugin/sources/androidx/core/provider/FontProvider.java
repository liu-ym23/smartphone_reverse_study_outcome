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
import android.os.Build;
import android.os.CancellationSignal;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class FontProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Comparator<byte[]> f1283a = null;

    static class Api16Impl {
        private Api16Impl() {
        }

        static Cursor query(ContentResolver r8, Uri r9, String[] r10, String r11, String[] r12, String r13, Object r14) {
            return ZeusProviderTransform.query(r8, r9, r10, r11, r12, r13, (CancellationSignal) ZeusTransformUtils.preCheckCast(r14, CancellationSignal.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        }
    }

    public static /* synthetic */ int lambda$DVDSm1jV1cxrWYthV08Zvpy8NM0(byte[] r0, byte[] r1) {
        return a(r0, r1);
    }

    static FontsContractCompat.a a(Context r2, c r3, CancellationSignal r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        ProviderInfo r0 = a(r5.getPackageManager(), r3, ZeusTransformUtils.getResources(r5, "com.obric.aiagent.plugin"));
        if (r0 != null) goto L7;
        return FontsContractCompat.a.a(1, null);
    L7:
        return FontsContractCompat.a.a(0, query(r5, r3, r0.authority, r4));
    }

    static ProviderInfo a(PackageManager r5, c r6, Resources r7) {
        String r0 = r6.a();
        int r1 = 0;
        ProviderInfo r2 = r5.resolveContentProvider(r0, 0);
        if (r2 == null) goto L18;
        if (r2.packageName.equals(r6.b()) == false) goto L16;
        List<byte[]> r8 = a(r5.getPackageInfo(r2.packageName, 64).signatures);
        Collections.sort(r8, f1283a);
        List<List<byte[]>> r9 = a(r6, r7);
    L8:
        if (r1 >= r9.size()) goto L13;
        ArrayList r10 = new ArrayList((Collection) ZeusTransformUtils.preCheckCast(r9.get(r1), Collection.class, "com.obric.aiagent.plugin"));
        Collections.sort(r10, f1283a);
        if (a(r8, r10) == true) goto L11;
        r1 = r1 + 1;
        goto L8
    L11:
        return r2;
    L13:
        return null;
    L16:
        throw new PackageManager.NameNotFoundException("Found content provider " + r0 + ", but package was not " + r6.b());
    L18:
        throw new PackageManager.NameNotFoundException("No package found for authority: " + r0);
    }

    static FontsContractCompat.b[] query(Context r16, c r17, String r18, CancellationSignal r19) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r16, Context.class, "com.obric.aiagent.plugin");
        ArrayList r3 = new ArrayList();
        Uri r4 = new Uri.Builder().scheme("content").authority(r18).build();
        Uri r0 = new Uri.Builder().scheme("content").authority(r18).appendPath("file").build();
        Cursor r5 = null;
        String[] r8 = {"_id", FontsContractCompat.Columns.FILE_ID, FontsContractCompat.Columns.TTC_INDEX, FontsContractCompat.Columns.VARIATION_SETTINGS, FontsContractCompat.Columns.WEIGHT, FontsContractCompat.Columns.ITALIC, FontsContractCompat.Columns.RESULT_CODE};     // Catch: Throwable -> L38
        ContentResolver r6 = r1.getContentResolver();     // Catch: Throwable -> L38
        boolean r13 = true;
        int r14 = 0;
        if (Build.VERSION.SDK_INT <= 16) goto L7;
        Cursor r2 = Api16Impl.query(r6, r4, r8, "query = ?", new String[]{r17.c()}, null, r19);     // Catch: Throwable -> L38
    L6:
        r5 = r2;
        if (r5 != null) goto L10;
    L34:
        if (r5 == null) goto L37;
        r5.close();
    L37:
        return (FontsContractCompat.b[]) ZeusTransformUtils.preCheckCast(r3.toArray(new FontsContractCompat.b[0]), FontsContractCompat.b[].class, "com.obric.aiagent.plugin");
    L10:
        if (r5.getCount() <= 0) goto L34;
        int r7 = r5.getColumnIndex(FontsContractCompat.Columns.RESULT_CODE);     // Catch: Throwable -> L38
        r3 = new ArrayList();     // Catch: Throwable -> L38
        int r9 = r5.getColumnIndex("_id");     // Catch: Throwable -> L38
        int r10 = r5.getColumnIndex(FontsContractCompat.Columns.FILE_ID);     // Catch: Throwable -> L38
        int r11 = r5.getColumnIndex(FontsContractCompat.Columns.TTC_INDEX);     // Catch: Throwable -> L38
        int r12 = r5.getColumnIndex(FontsContractCompat.Columns.WEIGHT);     // Catch: Throwable -> L38
        int r15 = r5.getColumnIndex(FontsContractCompat.Columns.ITALIC);     // Catch: Throwable -> L38
    L12:
        if (r5.moveToNext() == false) goto L34;
        if (r7 == (-1)) goto L17;
        int r110 = r5.getInt(r7);     // Catch: Throwable -> L38
    L18:
        if (r11 == (-1)) goto L20;
        int r111 = r5.getInt(r11);     // Catch: Throwable -> L38
    L21:
        if (r10 != (-1)) goto L23;
        Uri r112 = ContentUris.withAppendedId(r4, r5.getLong(r9));     // Catch: Throwable -> L38
    L24:
        if (r12 == (-1)) goto L26;
        int r113 = r5.getInt(r12);     // Catch: Throwable -> L38
    L27:
        if (r15 != (-1)) goto L29;
    L31:
        r13 = false;
    L32:
        r3.add(FontsContractCompat.b.a(r112, r111, r113, r13, r110));     // Catch: Throwable -> L38
        r13 = true;
        r14 = 0;
        goto L12
    L29:
        if (r5.getInt(r15) != r13) goto L31;
    L26:
        r113 = 400;
        goto L27
    L23:
        r112 = ContentUris.withAppendedId(r0, r5.getLong(r10));     // Catch: Throwable -> L38
        goto L24
    L20:
        r111 = r14;
        goto L21
    L17:
        r110 = r14;
        goto L18
    L7:
        r2 = ZeusProviderTransform.query(r6, r4, r8, "query = ?", new String[]{r17.c()}, null, "com.obric.aiagent.plugin");     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        if (r5 == null) goto L41;
        r5.close();
    L41:
        throw th;
    }

    private static List<List<byte[]>> a(c r1, Resources r2) {
        if (r1.d() == null) goto L7;
        return r1.d();
    L7:
        return androidx.core.content.b.e.a(r2, r1.e());
    }

    static {
        f1283a = $$Lambda$FontProvider$DVDSm1jV1cxrWYthV08Zvpy8NM0.INSTANCE;
    }

    private static /* synthetic */ int a(byte[] r4, byte[] r5) {
        if (r4.length == r5.length) goto L7;
        int r6 = r4.length;
        int r7 = r5.length;
    L6:
        return r6 - r7;
    L7:
        int r1 = 0;
    L9:
        if (r1 >= r4.length) goto L14;
        if (r4[r1] != r5[r1]) goto L12;
        r1 = r1 + 1;
        goto L9
    L12:
        r6 = r4[r1];
        r7 = r5[r1];
        goto L6
    L14:
        return 0;
    }

    private static boolean a(List<byte[]> r6, List<byte[]> r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        if (r8.size() == r9.size()) goto L5;
        return false;
    L5:
        int r1 = 0;
    L7:
        if (r1 >= r8.size()) goto L12;
        if (Arrays.equals((byte[]) ZeusTransformUtils.preCheckCast(r8.get(r1), byte[].class, "com.obric.aiagent.plugin"), (byte[]) ZeusTransformUtils.preCheckCast(r9.get(r1), byte[].class, "com.obric.aiagent.plugin")) == false) goto L10;
        r1 = r1 + 1;
        goto L7
    L10:
        return false;
    L12:
        return true;
    }

    private static List<byte[]> a(Signature[] r4) {
        ArrayList r0 = new ArrayList();
        int r1 = r4.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        r0.add(r4[r2].toByteArray());
        r2 = r2 + 1;
        goto L3
    L5:
        return r0;
    }
}
