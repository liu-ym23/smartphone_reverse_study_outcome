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
import androidx.core.content.res.FontResourcesParserCompat;
import com.obric.aikernel.sdk.ext.Params;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class FontProvider {
    private static final Comparator<byte[]> sByteArrayComparator = null;

    static class Api16Impl {
        private Api16Impl() {
        }

        static Cursor query(ContentResolver r7, Uri r8, String[] r9, String r10, String[] r11, String r12, Object r13) {
            return r7.query(r8, r9, r10, r11, r12, (CancellationSignal) r13);
        }
    }

    private FontProvider() {
    }

    static FontsContractCompat.FontFamilyResult getFontFamilyResult(Context r2, FontRequest r3, CancellationSignal r4) throws PackageManager.NameNotFoundException {
        ProviderInfo r0 = getProvider(r2.getPackageManager(), r3, r2.getResources());
        if (r0 != null) goto L7;
        return FontsContractCompat.FontFamilyResult.create(1, null);
    L7:
        return FontsContractCompat.FontFamilyResult.create(0, query(r2, r3, r0.authority, r4));
    }

    static ProviderInfo getProvider(PackageManager r5, FontRequest r6, Resources r7) throws PackageManager.NameNotFoundException {
        String r0 = r6.getProviderAuthority();
        int r1 = 0;
        ProviderInfo r2 = r5.resolveContentProvider(r0, 0);
        if (r2 == null) goto L18;
        if (r2.packageName.equals(r6.getProviderPackage()) == false) goto L16;
        List<byte[]> r8 = convertToByteArrayList(r5.getPackageInfo(r2.packageName, 64).signatures);
        Collections.sort(r8, sByteArrayComparator);
        List<List<byte[]>> r9 = getCertificates(r6, r7);
    L8:
        if (r1 >= r9.size()) goto L13;
        ArrayList r10 = new ArrayList(r9.get(r1));
        Collections.sort(r10, sByteArrayComparator);
        if (equalsByteArrayList(r8, r10) == true) goto L11;
        r1 = r1 + 1;
        goto L8
    L11:
        return r2;
    L13:
        return null;
    L16:
        throw new PackageManager.NameNotFoundException("Found content provider " + r0 + ", but package was not " + r6.getProviderPackage());
    L18:
        throw new PackageManager.NameNotFoundException("No package found for authority: " + r0);
    }

    static FontsContractCompat.FontInfo[] query(Context r16, FontRequest r17, String r18, CancellationSignal r19) {
        ArrayList r1 = new ArrayList();
        Uri r2 = new Uri.Builder().scheme(Params.CONTENT).authority(r18).build();
        Uri r0 = new Uri.Builder().scheme(Params.CONTENT).authority(r18).appendPath("file").build();
        Cursor r3 = null;
        int r12 = 0;
        r3 = Api16Impl.query(r16.getContentResolver(), r2, new String[]{"_id", FontsContractCompat.Columns.FILE_ID, FontsContractCompat.Columns.TTC_INDEX, FontsContractCompat.Columns.VARIATION_SETTINGS, FontsContractCompat.Columns.WEIGHT, FontsContractCompat.Columns.ITALIC, FontsContractCompat.Columns.RESULT_CODE}, "query = ?", new String[]{r17.getQuery()}, null, r19);     // Catch: Throwable -> L35
        if (r3 != null) goto L6;
    L31:
        if (r3 == null) goto L34;
        r3.close();
    L34:
        return (FontsContractCompat.FontInfo[]) r1.toArray(new FontsContractCompat.FontInfo[0]);
    L6:
        if (r3.getCount() <= 0) goto L31;
        int r4 = r3.getColumnIndex(FontsContractCompat.Columns.RESULT_CODE);     // Catch: Throwable -> L35
        ArrayList r5 = new ArrayList();     // Catch: Throwable -> L35
        int r6 = r3.getColumnIndex("_id");     // Catch: Throwable -> L35
        int r7 = r3.getColumnIndex(FontsContractCompat.Columns.FILE_ID);     // Catch: Throwable -> L35
        int r8 = r3.getColumnIndex(FontsContractCompat.Columns.TTC_INDEX);     // Catch: Throwable -> L35
        int r9 = r3.getColumnIndex(FontsContractCompat.Columns.WEIGHT);     // Catch: Throwable -> L35
        int r10 = r3.getColumnIndex(FontsContractCompat.Columns.ITALIC);     // Catch: Throwable -> L35
    L8:
        if (r3.moveToNext() == false) goto L30;
        if (r4 == (-1)) goto L13;
        int r13 = r3.getInt(r4);     // Catch: Throwable -> L35
    L14:
        if (r8 == (-1)) goto L16;
        int r14 = r3.getInt(r8);     // Catch: Throwable -> L35
    L17:
        if (r7 != (-1)) goto L19;
        Uri r15 = ContentUris.withAppendedId(r2, r3.getLong(r6));     // Catch: Throwable -> L35
    L20:
        if (r9 == (-1)) goto L22;
        int r110 = r3.getInt(r9);     // Catch: Throwable -> L35
    L23:
        if (r10 != (-1)) goto L25;
    L27:
        boolean r111 = false;
    L28:
        r5.add(FontsContractCompat.FontInfo.create(r15, r14, r110, r111, r13));     // Catch: Throwable -> L35
        r12 = 0;
        goto L8
    L25:
        if (r3.getInt(r10) != 1) goto L27;
        r111 = true;
        goto L28
    L22:
        r110 = 400;
        goto L23
    L19:
        r15 = ContentUris.withAppendedId(r0, r3.getLong(r7));     // Catch: Throwable -> L35
        goto L20
    L16:
        r14 = r12;
        goto L17
    L13:
        r13 = r12;
        goto L14
    L30:
        r1 = r5;
    L35:
        th = move-exception;
        if (r3 == null) goto L38;
        r3.close();
    L38:
        throw th;
    }

    private static List<List<byte[]>> getCertificates(FontRequest r1, Resources r2) {
        if (r1.getCertificates() == null) goto L7;
        return r1.getCertificates();
    L7:
        return FontResourcesParserCompat.readCerts(r2, r1.getCertificatesArrayResId());
    }

    static {
        sByteArrayComparator = new FontProvider$$ExternalSyntheticLambda0();
    }

    static /* synthetic */ int lambda$static$0(byte[] r4, byte[] r5) {
        if (r4.length != r5.length) goto L5;
        int r1 = 0;
    L8:
        if (r1 >= r4.length) goto L14;
        byte r2 = r4[r1];
        byte r3 = r5[r1];
        if (r2 != r3) goto L12;
        r1 = r1 + 1;
        goto L8
    L12:
        return r2 - r3;
    L14:
        return 0;
    L5:
        return r4.length - r5.length;
    }

    private static boolean equalsByteArrayList(List<byte[]> r4, List<byte[]> r5) {
        if (r4.size() == r5.size()) goto L5;
        return false;
    L5:
        int r0 = 0;
    L7:
        if (r0 >= r4.size()) goto L12;
        if (Arrays.equals(r4.get(r0), r5.get(r0)) == false) goto L10;
        r0 = r0 + 1;
        goto L7
    L10:
        return false;
    L12:
        return true;
    }

    private static List<byte[]> convertToByteArrayList(Signature[] r4) {
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
