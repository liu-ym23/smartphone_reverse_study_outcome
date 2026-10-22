package s0;

import android.content.ContentProviderClient;
import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.RemoteException;
import android.os.Trace;
import android.util.Log;
import com.stepos.core.ability.speech.AsrCloudConfig;
import com.stepos.core.ability.speech.AsrCloudWsSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final p.g<a, ProviderInfo> f11831a = new p.g<>(2);

    /* renamed from: b, reason: collision with root package name */
    public static final c f11832b = new c();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f11833a;

        /* renamed from: b, reason: collision with root package name */
        public String f11834b;

        /* renamed from: c, reason: collision with root package name */
        public List<List<byte[]>> f11835c;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Objects.equals(this.f11833a, aVar.f11833a) && Objects.equals(this.f11834b, aVar.f11834b) && Objects.equals(this.f11835c, aVar.f11835c);
        }

        public final int hashCode() {
            return Objects.hash(this.f11833a, this.f11834b, this.f11835c);
        }
    }

    public static k a(Context context, List list) {
        String str;
        Typeface typefaceE;
        Trace.beginSection(c2.a.a("FontProvider.getFontFamilyResult"));
        try {
            ArrayList arrayList = new ArrayList();
            for (int i10 = 0; i10 < list.size(); i10++) {
                e eVar = (e) list.get(i10);
                if (Build.VERSION.SDK_INT < 31 || (typefaceE = n0.e.e((str = eVar.f11840e))) == null || n0.e.f(typefaceE) == null) {
                    ProviderInfo providerInfoB = b(context.getPackageManager(), eVar, context.getResources());
                    if (providerInfoB == null) {
                        return new k();
                    }
                    arrayList.add(c(context, eVar, providerInfoB.authority));
                } else {
                    arrayList.add(new l[]{new l(str, eVar.f11841f)});
                }
            }
            return new k(arrayList);
        } finally {
            Trace.endSection();
        }
    }

    public static ProviderInfo b(PackageManager packageManager, e eVar, Resources resources) {
        c cVar = f11832b;
        p.g<a, ProviderInfo> gVar = f11831a;
        Trace.beginSection(c2.a.a("FontProvider.getProvider"));
        try {
            List<List<byte[]>> listB = eVar.f11839d;
            String str = eVar.f11836a;
            String str2 = eVar.f11837b;
            if (listB == null) {
                listB = m0.e.b(resources, 0);
            }
            a aVar = new a();
            aVar.f11833a = str;
            aVar.f11834b = str2;
            aVar.f11835c = listB;
            ProviderInfo providerInfoA = gVar.a(aVar);
            if (providerInfoA != null) {
                return providerInfoA;
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
            Collections.sort(arrayList, cVar);
            for (int i10 = 0; i10 < listB.size(); i10++) {
                ArrayList arrayList2 = new ArrayList(listB.get(i10));
                Collections.sort(arrayList2, cVar);
                if (arrayList.size() == arrayList2.size()) {
                    for (int i11 = 0; i11 < arrayList.size(); i11++) {
                        if (!Arrays.equals((byte[]) arrayList.get(i11), (byte[]) arrayList2.get(i11))) {
                            break;
                        }
                    }
                    gVar.b(aVar, providerInfoResolveContentProvider);
                    return providerInfoResolveContentProvider;
                }
            }
            Trace.endSection();
            return null;
        } finally {
            Trace.endSection();
        }
    }

    public static l[] c(Context context, e eVar, String str) {
        Trace.beginSection(c2.a.a("FontProvider.query"));
        try {
            ArrayList arrayList = new ArrayList();
            Uri uriBuild = new Uri.Builder().scheme("content").authority(str).build();
            Uri uriBuild2 = new Uri.Builder().scheme("content").authority(str).appendPath(AsrCloudConfig.SCENE_MODE_FILE).build();
            ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(uriBuild);
            Cursor cursorQuery = null;
            try {
                String[] strArr = {"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"};
                Trace.beginSection(c2.a.a("ContentQueryWrapper.query"));
                try {
                    String[] strArr2 = {eVar.f11838c};
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
                            int i10 = columnIndex != -1 ? cursorQuery.getInt(columnIndex) : 0;
                            arrayList2.add(new l(columnIndex3 == -1 ? ContentUris.withAppendedId(uriBuild, cursorQuery.getLong(columnIndex2)) : ContentUris.withAppendedId(uriBuild2, cursorQuery.getLong(columnIndex3)), columnIndex4 != -1 ? cursorQuery.getInt(columnIndex4) : 0, columnIndex5 != -1 ? cursorQuery.getInt(columnIndex5) : AsrCloudWsSession.SILENCE_TAIL_MARGIN_MS, columnIndex6 != -1 && cursorQuery.getInt(columnIndex6) == 1, i10));
                        }
                        arrayList = arrayList2;
                    }
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                        contentProviderClientAcquireUnstableContentProviderClient.close();
                    }
                    return (l[]) arrayList.toArray(new l[0]);
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
