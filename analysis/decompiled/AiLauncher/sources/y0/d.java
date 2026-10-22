package y0;

import android.content.ContentProviderClient;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.RemoteException;
import android.util.Log;
import androidx.collection.l;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import o1.C4996a;
import y0.g;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static final l<c, ProviderInfo> f43754a = new l<>(2);

    /* renamed from: b, reason: collision with root package name */
    public static final Comparator<byte[]> f43755b = new Comparator() { // from class: y0.c
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return d.a((byte[]) obj, (byte[]) obj2);
        }
    };

    public interface a {
        static a a(Context context, Uri uri) {
            return new b(context, uri);
        }

        Cursor b(Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal);

        void close();
    }

    public static class b implements a {

        /* renamed from: a, reason: collision with root package name */
        public final ContentProviderClient f43756a;

        public b(Context context, Uri uri) {
            this.f43756a = context.getContentResolver().acquireUnstableContentProviderClient(uri);
        }

        @Override // y0.d.a
        public Cursor b(Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
            ContentProviderClient contentProviderClient = this.f43756a;
            if (contentProviderClient == null) {
                return null;
            }
            try {
                return contentProviderClient.query(uri, strArr, str, strArr2, str2, cancellationSignal);
            } catch (RemoteException e10) {
                Log.w("FontsProvider", "Unable to query the content provider", e10);
                return null;
            }
        }

        @Override // y0.d.a
        public void close() {
            ContentProviderClient contentProviderClient = this.f43756a;
            if (contentProviderClient != null) {
                contentProviderClient.close();
            }
        }
    }

    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public String f43757a;

        /* renamed from: b, reason: collision with root package name */
        public String f43758b;

        /* renamed from: c, reason: collision with root package name */
        public List<List<byte[]>> f43759c;

        public c(String str, String str2, List<List<byte[]>> list) {
            this.f43757a = str;
            this.f43758b = str2;
            this.f43759c = list;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return Objects.equals(this.f43757a, cVar.f43757a) && Objects.equals(this.f43758b, cVar.f43758b) && Objects.equals(this.f43759c, cVar.f43759c);
        }

        public int hashCode() {
            return Objects.hash(this.f43757a, this.f43758b, this.f43759c);
        }
    }

    public static /* synthetic */ int a(byte[] bArr, byte[] bArr2) {
        if (bArr.length != bArr2.length) {
            return bArr.length - bArr2.length;
        }
        for (int i10 = 0; i10 < bArr.length; i10++) {
            byte b10 = bArr[i10];
            byte b11 = bArr2[i10];
            if (b10 != b11) {
                return b10 - b11;
            }
        }
        return 0;
    }

    public static List<byte[]> b(Signature[] signatureArr) {
        ArrayList arrayList = new ArrayList();
        for (Signature signature : signatureArr) {
            arrayList.add(signature.toByteArray());
        }
        return arrayList;
    }

    public static boolean c(List<byte[]> list, List<byte[]> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i10 = 0; i10 < list.size(); i10++) {
            if (!Arrays.equals(list.get(i10), list2.get(i10))) {
                return false;
            }
        }
        return true;
    }

    public static List<List<byte[]>> d(e eVar, Resources resources) {
        return eVar.b() != null ? eVar.b() : s0.e.c(resources, eVar.c());
    }

    public static g.a e(Context context, List<e> list, CancellationSignal cancellationSignal) throws PackageManager.NameNotFoundException {
        C4996a.a("FontProvider.getFontFamilyResult");
        try {
            ArrayList arrayList = new ArrayList();
            for (int i10 = 0; i10 < list.size(); i10++) {
                e eVar = list.get(i10);
                String strH = eVar.h();
                Typeface typefaceH = t0.h.h(strH);
                if (typefaceH == null || t0.h.j(typefaceH) == null) {
                    ProviderInfo providerInfoF = f(context.getPackageManager(), eVar, context.getResources());
                    if (providerInfoF == null) {
                        return g.a.b(1, null);
                    }
                    arrayList.add(g(context, eVar, providerInfoF.authority, cancellationSignal));
                } else {
                    arrayList.add(new g.b[]{new g.b(strH, eVar.i())});
                }
            }
            return g.a.a(0, arrayList);
        } finally {
            C4996a.b();
        }
    }

    public static ProviderInfo f(PackageManager packageManager, e eVar, Resources resources) throws PackageManager.NameNotFoundException {
        C4996a.a("FontProvider.getProvider");
        try {
            List<List<byte[]>> listD = d(eVar, resources);
            c cVar = new c(eVar.e(), eVar.f(), listD);
            ProviderInfo providerInfo = f43754a.get(cVar);
            if (providerInfo != null) {
                return providerInfo;
            }
            String strE = eVar.e();
            ProviderInfo providerInfoResolveContentProvider = packageManager.resolveContentProvider(strE, 0);
            if (providerInfoResolveContentProvider == null) {
                throw new PackageManager.NameNotFoundException("No package found for authority: " + strE);
            }
            if (!providerInfoResolveContentProvider.packageName.equals(eVar.f())) {
                throw new PackageManager.NameNotFoundException("Found content provider " + strE + ", but package was not " + eVar.f());
            }
            List<byte[]> listB = b(packageManager.getPackageInfo(providerInfoResolveContentProvider.packageName, 64).signatures);
            Collections.sort(listB, f43755b);
            for (int i10 = 0; i10 < listD.size(); i10++) {
                ArrayList arrayList = new ArrayList(listD.get(i10));
                Collections.sort(arrayList, f43755b);
                if (c(listB, arrayList)) {
                    f43754a.put(cVar, providerInfoResolveContentProvider);
                    return providerInfoResolveContentProvider;
                }
            }
            C4996a.b();
            return null;
        } finally {
            C4996a.b();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00e1  */
    /* JADX WARN: Type inference failed for: r16v1 */
    /* JADX WARN: Type inference failed for: r16v10 */
    /* JADX WARN: Type inference failed for: r16v2, types: [y0.d$a] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static y0.g.b[] g(android.content.Context r16, y0.e r17, java.lang.String r18, android.os.CancellationSignal r19) {
        /*
            Method dump skipped, instructions count: 284
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y0.d.g(android.content.Context, y0.e, java.lang.String, android.os.CancellationSignal):y0.g$b[]");
    }
}
