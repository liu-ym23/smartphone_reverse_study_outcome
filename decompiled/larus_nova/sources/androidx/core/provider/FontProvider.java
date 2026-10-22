package androidx.core.provider;

import android.content.ContentProviderClient;
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
import androidx.collection.LruCache;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.tracing.Trace;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import f06.b;
import f06.d;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes17.dex */
class FontProvider {
    private static final Comparator<byte[]> sByteArrayComparator = null;
    private static final LruCache<ProviderCacheKey, ProviderInfo> sProviderCache = null;

    public interface ContentQueryWrapper {

        /* JADX INFO: renamed from: androidx.core.provider.FontProvider$ContentQueryWrapper$-CC, reason: invalid class name */
        public final /* synthetic */ class CC {
            public static ContentQueryWrapper make(Context r100, Uri r101) {
                if (Build.VERSION.SDK_INT >= 24) goto L7;
                return new ContentQueryWrapperApi16Impl(r100, r101);
            L7:
                return new ContentQueryWrapperApi24Impl(r100, r101);
            }
        }

        void close();

        Cursor query(Uri r100, String[] r101, String r102, String[] r103, String r104, CancellationSignal r105);
    }

    public static class ContentQueryWrapperApi16Impl implements ContentQueryWrapper {
        private final ContentProviderClient mClient;

        @Override // androidx.core.provider.FontProvider.ContentQueryWrapper
        public void close() {
            ContentProviderClient r100 = this.mClient;
            if (r100 == null) goto L6;
            r100.release();
            return;
        }

        public ContentQueryWrapperApi16Impl(Context r100, Uri r101) {
            this.mClient = androidx_core_provider_FontProvider$ContentQueryWrapperApi16Impl_android_content_ContentResolver_acquireUnstableContentProviderClient(r100.getContentResolver(), r101);
        }

        private static ContentProviderClient androidx_core_provider_FontProvider$ContentQueryWrapperApi16Impl_android_content_ContentResolver_acquireUnstableContentProviderClient(ContentResolver r110, Uri r111) {
            ArrayList r100 = new ArrayList();
            Object[] r101 = {r111};
            b r112 = new b();
            g06.a r102 = ApiHookConfig.f245611b.get(240008);
            if (r102 == null) goto L5;
            f06.a[] r103 = r102.f479473i;
        L6:
            f06.a[] r113 = r103;
            int r104 = r113.length;
            int r105 = 0;
        L8:
            if (r105 >= r104) goto L15;
            f06.a r106 = r113[r105];
            int r114 = r105;
            int r115 = r104;
            d r107 = r106.preInvoke(240008, "android/content/ContentResolver", "acquireUnstableContentProviderClient", r110, r101, "android.content.ContentProviderClient", r112);     // Catch: Exception -> L22
            if (r107.f474982a == true) goto L17;
            r100.add(r106);     // Catch: Exception -> L22
        L17:
            if (r107.f474982a == false) goto L21;
            return (ContentProviderClient) r107.f474983b;
        L21:
            return r110.acquireUnstableContentProviderClient(r111);
        L14:
            r105 = r114 + 1;
            r104 = r115;
            goto L8
        L15:
            r107 = new d(false, null);
            goto L17
        L5:
            r103 = ApiHookConfig.f245613d;
            goto L6
        }

        @Override // androidx.core.provider.FontProvider.ContentQueryWrapper
        public Cursor query(Uri r100, String[] r110, String r111, String[] r112, String r113, CancellationSignal r114) {
            ContentProviderClient r101 = this.mClient;
            if (r101 != null) goto L9;
            return null;
        L9:
            return r101.query(r100, r110, r111, r112, r113, r114);
        L8:
            return null;
        }
    }

    public static class ContentQueryWrapperApi24Impl implements ContentQueryWrapper {
        private final ContentProviderClient mClient;

        @Override // androidx.core.provider.FontProvider.ContentQueryWrapper
        public void close() {
            ContentProviderClient r100 = this.mClient;
            if (r100 == null) goto L6;
            r100.close();
            return;
        }

        public ContentQueryWrapperApi24Impl(Context r100, Uri r101) {
            this.mClient = androidx_core_provider_FontProvider$ContentQueryWrapperApi24Impl_android_content_ContentResolver_acquireUnstableContentProviderClient(r100.getContentResolver(), r101);
        }

        private static ContentProviderClient androidx_core_provider_FontProvider$ContentQueryWrapperApi24Impl_android_content_ContentResolver_acquireUnstableContentProviderClient(ContentResolver r110, Uri r111) {
            ArrayList r100 = new ArrayList();
            Object[] r101 = {r111};
            b r112 = new b();
            g06.a r102 = ApiHookConfig.f245611b.get(240008);
            if (r102 == null) goto L5;
            f06.a[] r103 = r102.f479473i;
        L6:
            f06.a[] r113 = r103;
            int r104 = r113.length;
            int r105 = 0;
        L8:
            if (r105 >= r104) goto L15;
            f06.a r106 = r113[r105];
            int r114 = r105;
            int r115 = r104;
            d r107 = r106.preInvoke(240008, "android/content/ContentResolver", "acquireUnstableContentProviderClient", r110, r101, "android.content.ContentProviderClient", r112);     // Catch: Exception -> L22
            if (r107.f474982a == true) goto L17;
            r100.add(r106);     // Catch: Exception -> L22
        L17:
            if (r107.f474982a == false) goto L21;
            return (ContentProviderClient) r107.f474983b;
        L21:
            return r110.acquireUnstableContentProviderClient(r111);
        L14:
            r105 = r114 + 1;
            r104 = r115;
            goto L8
        L15:
            r107 = new d(false, null);
            goto L17
        L5:
            r103 = ApiHookConfig.f245613d;
            goto L6
        }

        @Override // androidx.core.provider.FontProvider.ContentQueryWrapper
        public Cursor query(Uri r100, String[] r110, String r111, String[] r112, String r113, CancellationSignal r114) {
            ContentProviderClient r101 = this.mClient;
            if (r101 != null) goto L9;
            return null;
        L9:
            return r101.query(r100, r110, r111, r112, r113, r114);
        L8:
            return null;
        }
    }

    public static class ProviderCacheKey {
        String mAuthority;
        List<List<byte[]>> mCertificates;
        String mPackageName;

        public int hashCode() {
            return Objects.hash(new Object[]{this.mAuthority, this.mPackageName, this.mCertificates});
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof ProviderCacheKey) == true) goto L8;
            return false;
        L8:
            ProviderCacheKey r101 = (ProviderCacheKey) r100;
            if (Objects.equals(this.mAuthority, r101.mAuthority) == true) goto L11;
        L15:
            return false;
        L11:
            if (Objects.equals(this.mPackageName, r101.mPackageName) == false) goto L15;
            if (Objects.equals(this.mCertificates, r101.mCertificates) == false) goto L15;
            return true;
        }

        public ProviderCacheKey(String r100, String r101, List<List<byte[]>> r102) {
            this.mAuthority = r100;
            this.mPackageName = r101;
            this.mCertificates = r102;
        }
    }

    private FontProvider() {
    }

    public static /* synthetic */ int a(byte[] r100, byte[] r101) {
        return lambda$static$0(r100, r101);
    }

    static {
        sProviderCache = new LruCache(2);
        sByteArrayComparator = new a();
    }

    public static void clearProviderCache() {
        sProviderCache.evictAll();
    }

    private static List<byte[]> convertToByteArrayList(Signature[] r100) {
        ArrayList r101 = new ArrayList();
        int r102 = r100.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        r101.add(r100[r103].toByteArray());
        r103 = r103 + 1;
        goto L3
    L5:
        return r101;
    }

    private static boolean equalsByteArrayList(List<byte[]> r100, List<byte[]> r101) {
        if (r100.size() == r101.size()) goto L5;
        return false;
    L5:
        int r102 = 0;
    L7:
        if (r102 >= r100.size()) goto L12;
        if (Arrays.equals((byte[]) ListProtector.get(r100, r102), (byte[]) ListProtector.get(r101, r102)) == false) goto L10;
        r102 = r102 + 1;
        goto L7
    L10:
        return false;
    L12:
        return true;
    }

    private static List<List<byte[]>> getCertificates(FontRequest r100, Resources r101) {
        if (r100.getCertificates() == null) goto L7;
        return r100.getCertificates();
    L7:
        return FontResourcesParserCompat.readCerts(r101, r100.getCertificatesArrayResId());
    }

    private static /* synthetic */ int lambda$static$0(byte[] r100, byte[] r101) {
        if (r100.length != r101.length) goto L5;
        int r102 = 0;
    L8:
        if (r102 >= r100.length) goto L14;
        byte r103 = r100[r102];
        byte r104 = r101[r102];
        if (r103 != r104) goto L12;
        r102 = r102 + 1;
        goto L8
    L12:
        return r103 - r104;
    L14:
        return 0;
    L5:
        return r100.length - r101.length;
    }

    public static FontsContractCompat.FontFamilyResult getFontFamilyResult(Context r100, List<FontRequest> r101, CancellationSignal r102) throws PackageManager.NameNotFoundException {
        Trace.beginSection("FontProvider.getFontFamilyResult");
        ArrayList r103 = new ArrayList();     // Catch: Throwable -> L15
        int r104 = 0;
    L5:
        if (r104 >= r101.size()) goto L12;
        FontRequest r105 = r101.get(r104);     // Catch: Throwable -> L15
        ProviderInfo r106 = getProvider(r100.getPackageManager(), r105, r100.getResources());     // Catch: Throwable -> L15
        if (r106 == null) goto L8;
        r103.add(query(r100, r105, r106.authority, r102));     // Catch: Throwable -> L15
        r104 = r104 + 1;     // Catch: Throwable -> L15
        goto L5
    L8:
        FontsContractCompat.FontFamilyResult r107 = FontsContractCompat.FontFamilyResult.create(1, null);     // Catch: Throwable -> L15
        Trace.endSection();
        return r107;
    L12:
        FontsContractCompat.FontFamilyResult r108 = FontsContractCompat.FontFamilyResult.create(0, r103);     // Catch: Throwable -> L15
        Trace.endSection();
        return r108;
    L15:
        th = move-exception;
        Trace.endSection();
        throw th;
    }

    public static ProviderInfo getProvider(PackageManager r100, FontRequest r101, Resources r102) throws PackageManager.NameNotFoundException {
        Trace.beginSection("FontProvider.getProvider");
        List<List<byte[]>> r103 = getCertificates(r101, r102);     // Catch: Throwable -> L26
        ProviderCacheKey r104 = new ProviderCacheKey(r101.getProviderAuthority(), r101.getProviderPackage(), r103);     // Catch: Throwable -> L26
        ProviderInfo r105 = sProviderCache.get(r104);     // Catch: Throwable -> L26
        if (r105 == null) goto L7;
        Trace.endSection();
        return r105;
    L7:
        String r106 = r101.getProviderAuthority();     // Catch: Throwable -> L26
        int r107 = 0;
        ProviderInfo r108 = r100.resolveContentProvider(r106, 0);     // Catch: Throwable -> L26
        if (r108 == null) goto L25;
        if (r108.packageName.equals(r101.getProviderPackage()) == false) goto L23;
        List<byte[]> r109 = convertToByteArrayList(r100.getPackageInfo(r108.packageName, 64).signatures);     // Catch: Throwable -> L26
        Collections.sort(r109, sByteArrayComparator);     // Catch: Throwable -> L26
    L13:
        if (r107 >= r103.size()) goto L20;
        ArrayList r110 = new ArrayList(r103.get(r107));     // Catch: Throwable -> L26
        Collections.sort(r110, sByteArrayComparator);     // Catch: Throwable -> L26
        if (equalsByteArrayList(r109, r110) == true) goto L16;
        r107 = r107 + 1;
        goto L13
    L16:
        sProviderCache.put(r104, r108);     // Catch: Throwable -> L26
        Trace.endSection();
        return r108;
    L20:
        Trace.endSection();
        return null;
    L23:
        throw new PackageManager.NameNotFoundException("Found content provider " + r106 + ", but package was not " + r101.getProviderPackage());     // Catch: Throwable -> L26
    L25:
        throw new PackageManager.NameNotFoundException("No package found for authority: " + r106);     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        Trace.endSection();
        throw th;
    }

    public static FontsContractCompat.FontInfo[] query(Context r110, FontRequest r111, String r112, CancellationSignal r113) {
        Trace.beginSection("FontProvider.query");
        ArrayList r100 = new ArrayList();     // Catch: Throwable -> L48
        Uri r101 = new Uri.Builder().scheme("content").authority(r112).build();     // Catch: Throwable -> L48
        Uri r102 = new Uri.Builder().scheme("content").authority(r112).appendPath("file").build();     // Catch: Throwable -> L48
        ContentQueryWrapper r103 = ContentQueryWrapper.CC.make(r110, r101);     // Catch: Throwable -> L48
        Cursor r114 = null;
        String[] r104 = {DBDefinition.ID, "file_id", FontsContractCompat.Columns.TTC_INDEX, FontsContractCompat.Columns.VARIATION_SETTINGS, FontsContractCompat.Columns.WEIGHT, FontsContractCompat.Columns.ITALIC, "result_code"};     // Catch: Throwable -> L43
        Trace.beginSection("ContentQueryWrapper.query");     // Catch: Throwable -> L43
        boolean r115 = true;
        r114 = r103.query(r101, r104, "query = ?", new String[]{r111.getQuery()}, null, r113);     // Catch: Throwable -> L40
        Trace.endSection();     // Catch: Throwable -> L43
        if (r114 != null) goto L10;
    L35:
        if (r114 == null) goto L37;
        r114.close();     // Catch: Throwable -> L48
    L37:
        r103.close();     // Catch: Throwable -> L48
        FontsContractCompat.FontInfo[] r105 = (FontsContractCompat.FontInfo[]) r100.toArray(new FontsContractCompat.FontInfo[0]);     // Catch: Throwable -> L48
        Trace.endSection();
        return r105;
    L10:
        if (r114.getCount() <= 0) goto L35;
        int r106 = r114.getColumnIndex("result_code");     // Catch: Throwable -> L43
        ArrayList r107 = new ArrayList();     // Catch: Throwable -> L43
        int r108 = r114.getColumnIndex(DBDefinition.ID);     // Catch: Throwable -> L43
        int r109 = r114.getColumnIndex("file_id");     // Catch: Throwable -> L43
        int r116 = r114.getColumnIndex(FontsContractCompat.Columns.TTC_INDEX);     // Catch: Throwable -> L43
        int r117 = r114.getColumnIndex(FontsContractCompat.Columns.WEIGHT);     // Catch: Throwable -> L43
        int r118 = r114.getColumnIndex(FontsContractCompat.Columns.ITALIC);     // Catch: Throwable -> L43
    L13:
        if (r114.moveToNext() == false) goto L34;
        if (r106 == (-1)) goto L17;
        int r119 = r114.getInt(r106);     // Catch: Throwable -> L43
    L18:
        if (r116 == (-1)) goto L20;
        int r120 = r114.getInt(r116);     // Catch: Throwable -> L43
    L21:
        if (r109 != (-1)) goto L23;
        Uri r121 = ContentUris.withAppendedId(r101, r114.getLong(r108));     // Catch: Throwable -> L43
    L24:
        if (r117 == (-1)) goto L26;
        int r122 = r114.getInt(r117);     // Catch: Throwable -> L43
    L27:
        if (r118 != (-1)) goto L29;
    L31:
        r115 = false;
    L32:
        r107.add(FontsContractCompat.FontInfo.create(r121, r120, r122, r115, r119));     // Catch: Throwable -> L43
        r115 = true;
        goto L13
    L29:
        if (r114.getInt(r118) != r115) goto L31;
    L26:
        r122 = 400;
        goto L27
    L23:
        r121 = ContentUris.withAppendedId(r102, r114.getLong(r109));     // Catch: Throwable -> L43
        goto L24
    L20:
        r120 = 0;
        goto L21
    L17:
        r119 = 0;
        goto L18
    L34:
        r100 = r107;
        goto L35
    L40:
        th = move-exception;
        Trace.endSection();     // Catch: Throwable -> L43
        throw th;     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        if (r114 == null) goto L46;
        r114.close();     // Catch: Throwable -> L48
    L46:
        r103.close();     // Catch: Throwable -> L48
        throw th;     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        Trace.endSection();
        throw th;
    }
}
