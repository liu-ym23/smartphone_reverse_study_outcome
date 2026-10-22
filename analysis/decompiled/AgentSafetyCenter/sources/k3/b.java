package k3;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Trace;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import p.p;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final p f7211a = new p(2);

    /* renamed from: b, reason: collision with root package name */
    public static final e2.d f7212b = new e2.d(2);

    public static wd.a a(Context context, List list) {
        Trace.beginSection(com.stepos.statsrpk.h.J("FontProvider.getFontFamilyResult"));
        try {
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (true) {
                int i3 = 4;
                if (i >= list.size()) {
                    wd.a aVar = new wd.a(i3);
                    aVar.f15389f = 0;
                    aVar.f15390g = arrayList;
                    VarHandle.storeStoreFence();
                    return aVar;
                }
                c cVar = (c) list.get(i);
                String str = cVar.f7217e;
                Typeface typefaceE = f3.d.e(str);
                if (typefaceE == null || f3.d.f(typefaceE) == null) {
                    ProviderInfo providerInfoB = b(context.getPackageManager(), cVar, context.getResources());
                    if (providerInfoB == null) {
                        wd.a aVar2 = new wd.a(i3);
                        aVar2.f15389f = 1;
                        aVar2.f15390g = Collections.singletonList(null);
                        VarHandle.storeStoreFence();
                        return aVar2;
                    }
                    arrayList.add(c(context, cVar, providerInfoB.authority));
                } else {
                    String str2 = cVar.f7218f;
                    h hVar = new h();
                    hVar.f7232a = new Uri.Builder().scheme("systemfont").authority(str).build();
                    hVar.f7233b = 0;
                    hVar.f7234c = 400;
                    hVar.f7235d = false;
                    hVar.f7236e = str2;
                    hVar.f7237f = 0;
                    arrayList.add(new h[]{hVar});
                }
                i++;
            }
        } finally {
            Trace.endSection();
        }
    }

    public static ProviderInfo b(PackageManager packageManager, c cVar, Resources resources) {
        e2.d dVar = f7212b;
        p pVar = f7211a;
        Trace.beginSection(com.stepos.statsrpk.h.J("FontProvider.getProvider"));
        try {
            List listI = cVar.f7216d;
            String str = cVar.f7213a;
            String str2 = cVar.f7214b;
            if (listI == null) {
                listI = e3.b.i(resources, 0);
            }
            a aVar = new a();
            aVar.f7208a = str;
            aVar.f7209b = str2;
            aVar.f7210c = listI;
            ProviderInfo providerInfo = (ProviderInfo) pVar.b(aVar);
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
            Collections.sort(arrayList, dVar);
            for (int i = 0; i < listI.size(); i++) {
                ArrayList arrayList2 = new ArrayList((Collection) listI.get(i));
                Collections.sort(arrayList2, dVar);
                if (arrayList.size() == arrayList2.size()) {
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        if (!Arrays.equals((byte[]) arrayList.get(i3), (byte[]) arrayList2.get(i3))) {
                            break;
                        }
                    }
                    pVar.c(aVar, providerInfoResolveContentProvider);
                    return providerInfoResolveContentProvider;
                }
            }
            Trace.endSection();
            return null;
        } finally {
            Trace.endSection();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x014a A[Catch: all -> 0x0153, TRY_ENTER, TryCatch #3 {all -> 0x0153, blocks: (B:3:0x000f, B:65:0x014a, B:67:0x014f, B:68:0x0152, B:55:0x012e, B:57:0x0133, B:58:0x0136), top: B:78:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x014f A[Catch: all -> 0x0153, TryCatch #3 {all -> 0x0153, blocks: (B:3:0x000f, B:65:0x014a, B:67:0x014f, B:68:0x0152, B:55:0x012e, B:57:0x0133, B:58:0x0136), top: B:78:0x000f }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static k3.h[] c(android.content.Context r18, k3.c r19, java.lang.String r20) {
        /*
            Method dump skipped, instructions count: 344
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k3.b.c(android.content.Context, k3.c, java.lang.String):k3.h[]");
    }
}
