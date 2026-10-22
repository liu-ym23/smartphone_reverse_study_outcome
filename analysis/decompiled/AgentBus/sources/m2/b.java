package m2;

import android.content.ContentProviderClient;
import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.RemoteException;
import android.os.Trace;
import android.util.Log;
import b0.q;
import ib.k;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import k.p;
import nb.i;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final p f6133a = new p(2);

    /* renamed from: b, reason: collision with root package name */
    public static final q f6134b = new q(2);

    /* JADX WARN: Removed duplicated region for block: B:22:0x0057 A[Catch: all -> 0x0083, TryCatch #0 {all -> 0x0083, blocks: (B:3:0x0005, B:4:0x000c, B:6:0x0013, B:8:0x001f, B:10:0x0026, B:13:0x002d, B:15:0x0039, B:19:0x0042, B:21:0x0048, B:28:0x0077, B:22:0x0057, B:24:0x0065, B:27:0x006e, B:29:0x007a), top: B:35:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static d1.b a(android.content.Context r9, java.util.List r10) {
        /*
            java.lang.String r0 = "FontProvider.getFontFamilyResult"
            nb.i.f(r0)
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L83
            r0.<init>()     // Catch: java.lang.Throwable -> L83
            r1 = 0
            r2 = r1
        Lc:
            int r3 = r10.size()     // Catch: java.lang.Throwable -> L83
            r4 = 3
            if (r2 >= r3) goto L7a
            java.lang.Object r3 = r10.get(r2)     // Catch: java.lang.Throwable -> L83
            m2.c r3 = (m2.c) r3     // Catch: java.lang.Throwable -> L83
            int r5 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L83
            r6 = 31
            if (r5 < r6) goto L57
            java.lang.String r5 = r3.f6139e     // Catch: java.lang.Throwable -> L83
            h4.n r6 = k2.b.f5579a     // Catch: java.lang.Throwable -> L83
            r6 = 0
            if (r5 == 0) goto L40
            boolean r7 = r5.isEmpty()     // Catch: java.lang.Throwable -> L83
            if (r7 == 0) goto L2d
            goto L40
        L2d:
            android.graphics.Typeface r7 = android.graphics.Typeface.create(r5, r1)     // Catch: java.lang.Throwable -> L83
            android.graphics.Typeface r8 = android.graphics.Typeface.DEFAULT     // Catch: java.lang.Throwable -> L83
            android.graphics.Typeface r8 = android.graphics.Typeface.create(r8, r1)     // Catch: java.lang.Throwable -> L83
            if (r7 == 0) goto L40
            boolean r8 = r7.equals(r8)     // Catch: java.lang.Throwable -> L83
            if (r8 != 0) goto L40
            r6 = r7
        L40:
            if (r6 == 0) goto L57
            android.graphics.fonts.Font r6 = k2.b.b(r6)     // Catch: java.lang.Throwable -> L83
            if (r6 == 0) goto L57
            m2.d r4 = new m2.d     // Catch: java.lang.Throwable -> L83
            java.lang.String r3 = r3.f6140f     // Catch: java.lang.Throwable -> L83
            r4.<init>(r5, r3)     // Catch: java.lang.Throwable -> L83
            m2.d[] r3 = new m2.d[]{r4}     // Catch: java.lang.Throwable -> L83
            r0.add(r3)     // Catch: java.lang.Throwable -> L83
            goto L77
        L57:
            android.content.pm.PackageManager r5 = r9.getPackageManager()     // Catch: java.lang.Throwable -> L83
            android.content.res.Resources r6 = r9.getResources()     // Catch: java.lang.Throwable -> L83
            android.content.pm.ProviderInfo r5 = b(r5, r3, r6)     // Catch: java.lang.Throwable -> L83
            if (r5 != 0) goto L6e
            d1.b r9 = new d1.b     // Catch: java.lang.Throwable -> L83
            r9.<init>(r4)     // Catch: java.lang.Throwable -> L83
            android.os.Trace.endSection()
            return r9
        L6e:
            java.lang.String r4 = r5.authority     // Catch: java.lang.Throwable -> L83
            m2.d[] r3 = c(r9, r3, r4)     // Catch: java.lang.Throwable -> L83
            r0.add(r3)     // Catch: java.lang.Throwable -> L83
        L77:
            int r2 = r2 + 1
            goto Lc
        L7a:
            d1.b r9 = new d1.b     // Catch: java.lang.Throwable -> L83
            r9.<init>(r4, r0)     // Catch: java.lang.Throwable -> L83
            android.os.Trace.endSection()
            return r9
        L83:
            r9 = move-exception
            android.os.Trace.endSection()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: m2.b.a(android.content.Context, java.util.List):d1.b");
    }

    public static ProviderInfo b(PackageManager packageManager, c cVar, Resources resources) {
        q qVar = f6134b;
        p pVar = f6133a;
        i.f("FontProvider.getProvider");
        try {
            List listJ = cVar.f6138d;
            String str = cVar.f6135a;
            String str2 = cVar.f6136b;
            if (listJ == null) {
                listJ = k.J(resources, 0);
            }
            a aVar = new a();
            aVar.f6130a = str;
            aVar.f6131b = str2;
            aVar.f6132c = listJ;
            ProviderInfo providerInfo = (ProviderInfo) pVar.a(aVar);
            if (providerInfo != null) {
                return providerInfo;
            }
            ProviderInfo providerInfoResolveContentProvider = packageManager.resolveContentProvider(str, 0);
            if (providerInfoResolveContentProvider == null) {
                throw new PackageManager.NameNotFoundException("No package found for authority: " + str);
            }
            if (!providerInfoResolveContentProvider.packageName.equals(str2)) {
                throw new PackageManager.NameNotFoundException("Found content provider " + str + ", but package was not " + str2);
            }
            Signature[] signatureArr = packageManager.getPackageInfo(providerInfoResolveContentProvider.packageName, 64).signatures;
            ArrayList arrayList = new ArrayList();
            for (Signature signature : signatureArr) {
                arrayList.add(signature.toByteArray());
            }
            Collections.sort(arrayList, qVar);
            for (int i2 = 0; i2 < listJ.size(); i2++) {
                ArrayList arrayList2 = new ArrayList((Collection) listJ.get(i2));
                Collections.sort(arrayList2, qVar);
                if (arrayList.size() == arrayList2.size()) {
                    for (int i10 = 0; i10 < arrayList.size(); i10++) {
                        if (!Arrays.equals((byte[]) arrayList.get(i10), (byte[]) arrayList2.get(i10))) {
                            break;
                        }
                    }
                    pVar.b(aVar, providerInfoResolveContentProvider);
                    return providerInfoResolveContentProvider;
                }
            }
            Trace.endSection();
            return null;
        } finally {
            Trace.endSection();
        }
    }

    public static d[] c(Context context, c cVar, String str) {
        i.f("FontProvider.query");
        try {
            ArrayList arrayList = new ArrayList();
            Uri uriBuild = new Uri.Builder().scheme("content").authority(str).build();
            Uri uriBuild2 = new Uri.Builder().scheme("content").authority(str).appendPath("file").build();
            ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(uriBuild);
            Cursor cursorQuery = null;
            try {
                String[] strArr = {"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"};
                i.f("ContentQueryWrapper.query");
                try {
                    String[] strArr2 = {cVar.f6137c};
                    if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                        try {
                            cursorQuery = contentProviderClientAcquireUnstableContentProviderClient.query(uriBuild, strArr, "query = ?", strArr2, null, null);
                        } catch (RemoteException e10) {
                            Log.w("FontsProvider", "Unable to query the content provider", e10);
                        }
                    }
                    Trace.endSection();
                    if (cursorQuery != null && cursorQuery.getCount() > 0) {
                        int columnIndex = cursorQuery.getColumnIndex("result_code");
                        ArrayList arrayList2 = new ArrayList();
                        int columnIndex2 = cursorQuery.getColumnIndex("_id");
                        int columnIndex3 = cursorQuery.getColumnIndex("file_id");
                        int columnIndex4 = cursorQuery.getColumnIndex("font_ttc_index");
                        int columnIndex5 = cursorQuery.getColumnIndex("font_weight");
                        int columnIndex6 = cursorQuery.getColumnIndex("font_italic");
                        while (cursorQuery.moveToNext()) {
                            int i2 = columnIndex != -1 ? cursorQuery.getInt(columnIndex) : 0;
                            arrayList2.add(new d(columnIndex3 == -1 ? ContentUris.withAppendedId(uriBuild, cursorQuery.getLong(columnIndex2)) : ContentUris.withAppendedId(uriBuild2, cursorQuery.getLong(columnIndex3)), columnIndex4 != -1 ? cursorQuery.getInt(columnIndex4) : 0, columnIndex5 != -1 ? cursorQuery.getInt(columnIndex5) : 400, columnIndex6 != -1 && cursorQuery.getInt(columnIndex6) == 1, cVar.f6140f, i2));
                        }
                        arrayList = arrayList2;
                    }
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                        contentProviderClientAcquireUnstableContentProviderClient.close();
                    }
                    return (d[]) arrayList.toArray(new d[0]);
                } finally {
                }
            } catch (Throwable th) {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                    contentProviderClientAcquireUnstableContentProviderClient.close();
                }
                throw th;
            }
        } finally {
        }
    }
}
