package stepos.support.v7.permission;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PermissionInfo;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import w0.C2086g;

/* loaded from: classes4.dex */
public final class d {
    public static volatile d d;

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f6373a;
    public final HashMap b;
    public final C2086g c;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x052d  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0542  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0552  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0570  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0584  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x05a2  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x05c0  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x05d5  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x05ea  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x05ff  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x061e  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0638  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x065b  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0436 A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x043e A[PHI: r1 r3 r4 r20 r21 r22 r23 r24 r25 r26 r56
      0x043e: PHI (r1v58 java.lang.Object) = 
      (r1v11 java.lang.Object)
      (r1v24 java.lang.Object)
      (r1v27 java.lang.Object)
      (r1v28 java.lang.Object)
      (r1v59 java.lang.Object)
     binds: [B:103:0x0539, B:100:0x0522, B:70:0x0474, B:66:0x0461, B:59:0x0436] A[DONT_GENERATE, DONT_INLINE]
      0x043e: PHI (r3v36 java.lang.Object) = 
      (r3v8 java.lang.Object)
      (r3v15 java.lang.Object)
      (r3v17 java.lang.Object)
      (r3v18 java.lang.Object)
      (r3v37 java.lang.Object)
     binds: [B:103:0x0539, B:100:0x0522, B:70:0x0474, B:66:0x0461, B:59:0x0436] A[DONT_GENERATE, DONT_INLINE]
      0x043e: PHI (r4v36 java.lang.Object) = 
      (r4v9 java.lang.Object)
      (r4v16 java.lang.Object)
      (r4v18 java.lang.Object)
      (r4v19 java.lang.Object)
      (r4v37 java.lang.Object)
     binds: [B:103:0x0539, B:100:0x0522, B:70:0x0474, B:66:0x0461, B:59:0x0436] A[DONT_GENERATE, DONT_INLINE]
      0x043e: PHI (r20v7 java.lang.Object) = 
      (r20v1 java.lang.Object)
      (r20v5 java.lang.Object)
      (r20v1 java.lang.Object)
      (r20v1 java.lang.Object)
      (r20v1 java.lang.Object)
     binds: [B:103:0x0539, B:100:0x0522, B:70:0x0474, B:66:0x0461, B:59:0x0436] A[DONT_GENERATE, DONT_INLINE]
      0x043e: PHI (r21v7 java.lang.Object) = 
      (r21v1 java.lang.Object)
      (r21v5 java.lang.Object)
      (r21v1 java.lang.Object)
      (r21v1 java.lang.Object)
      (r21v1 java.lang.Object)
     binds: [B:103:0x0539, B:100:0x0522, B:70:0x0474, B:66:0x0461, B:59:0x0436] A[DONT_GENERATE, DONT_INLINE]
      0x043e: PHI (r22v7 java.lang.Object) = 
      (r22v1 java.lang.Object)
      (r22v5 java.lang.Object)
      (r22v1 java.lang.Object)
      (r22v1 java.lang.Object)
      (r22v1 java.lang.Object)
     binds: [B:103:0x0539, B:100:0x0522, B:70:0x0474, B:66:0x0461, B:59:0x0436] A[DONT_GENERATE, DONT_INLINE]
      0x043e: PHI (r23v7 java.lang.Object) = 
      (r23v1 java.lang.Object)
      (r23v5 java.lang.Object)
      (r23v1 java.lang.Object)
      (r23v1 java.lang.Object)
      (r23v1 java.lang.Object)
     binds: [B:103:0x0539, B:100:0x0522, B:70:0x0474, B:66:0x0461, B:59:0x0436] A[DONT_GENERATE, DONT_INLINE]
      0x043e: PHI (r24v7 java.lang.Object) = 
      (r24v1 java.lang.Object)
      (r24v5 java.lang.Object)
      (r24v1 java.lang.Object)
      (r24v1 java.lang.Object)
      (r24v1 java.lang.Object)
     binds: [B:103:0x0539, B:100:0x0522, B:70:0x0474, B:66:0x0461, B:59:0x0436] A[DONT_GENERATE, DONT_INLINE]
      0x043e: PHI (r25v7 java.lang.Object) = 
      (r25v1 java.lang.Object)
      (r25v5 java.lang.Object)
      (r25v1 java.lang.Object)
      (r25v1 java.lang.Object)
      (r25v1 java.lang.Object)
     binds: [B:103:0x0539, B:100:0x0522, B:70:0x0474, B:66:0x0461, B:59:0x0436] A[DONT_GENERATE, DONT_INLINE]
      0x043e: PHI (r26v7 java.lang.Object) = 
      (r26v1 java.lang.Object)
      (r26v2 java.lang.Object)
      (r26v1 java.lang.Object)
      (r26v1 java.lang.Object)
      (r26v1 java.lang.Object)
     binds: [B:103:0x0539, B:100:0x0522, B:70:0x0474, B:66:0x0461, B:59:0x0436] A[DONT_GENERATE, DONT_INLINE]
      0x043e: PHI (r56v15 java.lang.Object) = 
      (r56v2 java.lang.Object)
      (r56v9 java.lang.Object)
      (r56v11 java.lang.Object)
      (r56v12 java.lang.Object)
      (r56v16 java.lang.Object)
     binds: [B:103:0x0539, B:100:0x0522, B:70:0x0474, B:66:0x0461, B:59:0x0436] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0442  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0455  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0468  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x047b  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0495  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x04af  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x04c9  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x04e2  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x04fa  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0512  */
    /* JADX WARN: Type inference failed for: r13v23, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v10, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v60 */
    /* JADX WARN: Type inference failed for: r2v74, types: [android.content.pm.PackageManager] */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v34 */
    /* JADX WARN: Type inference failed for: r3v38 */
    /* JADX WARN: Type inference failed for: r3v39 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v40 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public d(android.content.Context r66) {
        /*
            Method dump skipped, instructions count: 1750
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.permission.d.<init>(android.content.Context):void");
    }

    public static d a(Context context) {
        if (d == null) {
            synchronized (d.class) {
                try {
                    if (d == null) {
                        d = new d(context);
                    }
                } finally {
                }
            }
        }
        return d;
    }

    public final String b(String str) throws PackageManager.NameNotFoundException {
        a aVar = (a) this.f6373a.get(str);
        if ("zh_CN".equals(Locale.getDefault().toString()) && aVar != null) {
            String str2 = aVar.b;
            if (!TextUtils.isEmpty(str2)) {
                return str2;
            }
        }
        PackageManager packageManager = (PackageManager) this.c.f6811a;
        String string = null;
        try {
            PermissionInfo permissionInfo = packageManager.getPermissionInfo(str, 128);
            if (permissionInfo.labelRes != 0) {
                string = permissionInfo.loadLabel(packageManager).toString();
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return TextUtils.isEmpty(string) ? str : string;
    }

    public final List c(String[] strArr, boolean z10) {
        if (strArr == null || strArr.length <= 0) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            if (this.b.containsKey(str)) {
                d(str, arrayList);
                if (z10) {
                    Iterator it = ((Set) this.b.get(str)).iterator();
                    while (it.hasNext()) {
                        e((String) it.next(), arrayList);
                    }
                }
            } else {
                e(str, arrayList);
            }
        }
        Collections.sort(arrayList);
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            Collections.sort(((c) it2.next()).d);
        }
        return arrayList;
    }

    public final c d(String str, ArrayList arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (cVar.b.equals(str)) {
                return cVar;
            }
        }
        c cVar2 = new c(str, (a) this.f6373a.get(str), this.c);
        arrayList.add(cVar2);
        return cVar2;
    }

    public final void e(String str, ArrayList arrayList) {
        String str2;
        b bVar;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Iterator it2 = ((c) it.next()).d.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    bVar = null;
                    break;
                } else {
                    bVar = (b) it2.next();
                    if (bVar.b.equals(str)) {
                        break;
                    }
                }
            }
            if (bVar != null) {
                return;
            }
        }
        b bVar2 = new b(str, (a) this.f6373a.get(str), this.c);
        Iterator it3 = this.b.entrySet().iterator();
        loop2: while (true) {
            if (!it3.hasNext()) {
                str2 = "stepos.permission-group.OTHER";
                break;
            }
            Map.Entry entry = (Map.Entry) it3.next();
            Iterator it4 = ((Set) entry.getValue()).iterator();
            while (it4.hasNext()) {
                if (str.equals((String) it4.next())) {
                    str2 = (String) entry.getKey();
                    break loop2;
                }
            }
        }
        d(str2, arrayList).d.add(bVar2);
    }
}
