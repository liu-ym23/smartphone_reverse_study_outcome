package qe;

import a2.i;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PermissionInfo;
import android.text.TextUtils;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class d {

    /* renamed from: d, reason: collision with root package name */
    public static volatile d f10227d;

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f10228a;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f10229b;

    /* renamed from: c, reason: collision with root package name */
    public final i f10230c;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0528  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x053d  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x054d  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x056b  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x057f  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x059d  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x05bb  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x05d0  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x05e5  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x05fa  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0619  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0633  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0656  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0431 A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0439 A[PHI: r1 r4 r5 r20 r21 r22 r23 r24 r25 r26 r57
      0x0439: PHI (r1v124 java.lang.Object) = 
      (r1v77 java.lang.Object)
      (r1v90 java.lang.Object)
      (r1v93 java.lang.Object)
      (r1v94 java.lang.Object)
      (r1v125 java.lang.Object)
     binds: [B:101:0x0534, B:98:0x051d, B:68:0x046f, B:64:0x045c, B:57:0x0431] A[DONT_GENERATE, DONT_INLINE]
      0x0439: PHI (r4v46 java.lang.Object) = 
      (r4v18 java.lang.Object)
      (r4v25 java.lang.Object)
      (r4v27 java.lang.Object)
      (r4v28 java.lang.Object)
      (r4v47 java.lang.Object)
     binds: [B:101:0x0534, B:98:0x051d, B:68:0x046f, B:64:0x045c, B:57:0x0431] A[DONT_GENERATE, DONT_INLINE]
      0x0439: PHI (r5v47 java.lang.Object) = 
      (r5v20 java.lang.Object)
      (r5v27 java.lang.Object)
      (r5v29 java.lang.Object)
      (r5v30 java.lang.Object)
      (r5v48 java.lang.Object)
     binds: [B:101:0x0534, B:98:0x051d, B:68:0x046f, B:64:0x045c, B:57:0x0431] A[DONT_GENERATE, DONT_INLINE]
      0x0439: PHI (r20v7 java.lang.Object) = 
      (r20v1 java.lang.Object)
      (r20v5 java.lang.Object)
      (r20v1 java.lang.Object)
      (r20v1 java.lang.Object)
      (r20v1 java.lang.Object)
     binds: [B:101:0x0534, B:98:0x051d, B:68:0x046f, B:64:0x045c, B:57:0x0431] A[DONT_GENERATE, DONT_INLINE]
      0x0439: PHI (r21v7 java.lang.Object) = 
      (r21v1 java.lang.Object)
      (r21v5 java.lang.Object)
      (r21v1 java.lang.Object)
      (r21v1 java.lang.Object)
      (r21v1 java.lang.Object)
     binds: [B:101:0x0534, B:98:0x051d, B:68:0x046f, B:64:0x045c, B:57:0x0431] A[DONT_GENERATE, DONT_INLINE]
      0x0439: PHI (r22v7 java.lang.Object) = 
      (r22v1 java.lang.Object)
      (r22v5 java.lang.Object)
      (r22v1 java.lang.Object)
      (r22v1 java.lang.Object)
      (r22v1 java.lang.Object)
     binds: [B:101:0x0534, B:98:0x051d, B:68:0x046f, B:64:0x045c, B:57:0x0431] A[DONT_GENERATE, DONT_INLINE]
      0x0439: PHI (r23v7 java.lang.Object) = 
      (r23v1 java.lang.Object)
      (r23v5 java.lang.Object)
      (r23v1 java.lang.Object)
      (r23v1 java.lang.Object)
      (r23v1 java.lang.Object)
     binds: [B:101:0x0534, B:98:0x051d, B:68:0x046f, B:64:0x045c, B:57:0x0431] A[DONT_GENERATE, DONT_INLINE]
      0x0439: PHI (r24v7 java.lang.Object) = 
      (r24v1 java.lang.Object)
      (r24v5 java.lang.Object)
      (r24v1 java.lang.Object)
      (r24v1 java.lang.Object)
      (r24v1 java.lang.Object)
     binds: [B:101:0x0534, B:98:0x051d, B:68:0x046f, B:64:0x045c, B:57:0x0431] A[DONT_GENERATE, DONT_INLINE]
      0x0439: PHI (r25v7 java.lang.Object) = 
      (r25v1 java.lang.Object)
      (r25v5 java.lang.Object)
      (r25v1 java.lang.Object)
      (r25v1 java.lang.Object)
      (r25v1 java.lang.Object)
     binds: [B:101:0x0534, B:98:0x051d, B:68:0x046f, B:64:0x045c, B:57:0x0431] A[DONT_GENERATE, DONT_INLINE]
      0x0439: PHI (r26v7 java.lang.Object) = 
      (r26v1 java.lang.Object)
      (r26v2 java.lang.Object)
      (r26v1 java.lang.Object)
      (r26v1 java.lang.Object)
      (r26v1 java.lang.Object)
     binds: [B:101:0x0534, B:98:0x051d, B:68:0x046f, B:64:0x045c, B:57:0x0431] A[DONT_GENERATE, DONT_INLINE]
      0x0439: PHI (r57v15 java.lang.Object) = 
      (r57v2 java.lang.Object)
      (r57v9 java.lang.Object)
      (r57v11 java.lang.Object)
      (r57v12 java.lang.Object)
      (r57v16 java.lang.Object)
     binds: [B:101:0x0534, B:98:0x051d, B:68:0x046f, B:64:0x045c, B:57:0x0431] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x043d  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0450  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0463  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0476  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0490  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x04aa  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x04c4  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x04dd  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x04f5  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x050d  */
    /* JADX WARN: Type inference failed for: r1v126 */
    /* JADX WARN: Type inference failed for: r1v69, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v76, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v13, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v44 */
    /* JADX WARN: Type inference failed for: r4v48 */
    /* JADX WARN: Type inference failed for: r4v8, types: [android.content.pm.PackageManager] */
    /* JADX WARN: Type inference failed for: r5v13, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v45 */
    /* JADX WARN: Type inference failed for: r5v49 */
    /* JADX WARN: Type inference failed for: r5v50 */
    /* JADX WARN: Type inference failed for: r5v51 */
    /* JADX WARN: Type inference failed for: r5v52 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public d(android.content.Context r66) {
        /*
            Method dump skipped, instructions count: 1750
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: qe.d.<init>(android.content.Context):void");
    }

    public static d a(Context context) {
        if (f10227d == null) {
            synchronized (d.class) {
                try {
                    if (f10227d == null) {
                        f10227d = new d(context);
                    }
                } finally {
                }
            }
        }
        return f10227d;
    }

    public final String b(String str) throws PackageManager.NameNotFoundException {
        a aVar = (a) this.f10228a.get(str);
        if ("zh_CN".equals(Locale.getDefault().toString()) && aVar != null) {
            String str2 = aVar.f10219b;
            if (!TextUtils.isEmpty(str2)) {
                return str2;
            }
        }
        PackageManager packageManager = (PackageManager) this.f10230c.f49f;
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
        int i = 0;
        for (String str : strArr) {
            if (this.f10229b.containsKey(str)) {
                d(str, arrayList);
                if (z10) {
                    Iterator it = ((Set) this.f10229b.get(str)).iterator();
                    while (it.hasNext()) {
                        e((String) it.next(), arrayList);
                    }
                }
            } else {
                e(str, arrayList);
            }
        }
        Collections.sort(arrayList);
        int size = arrayList.size();
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            Collections.sort(((c) obj).f10226h);
        }
        return arrayList;
    }

    public final c d(String str, ArrayList arrayList) {
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            c cVar = (c) obj;
            if (cVar.f10224f.equals(str)) {
                return cVar;
            }
        }
        a aVar = (a) this.f10228a.get(str);
        c cVar2 = new c();
        cVar2.f10226h = new ArrayList();
        cVar2.f10224f = str;
        cVar2.f10225g = aVar;
        cVar2.f10223c = this.f10230c;
        VarHandle.storeStoreFence();
        arrayList.add(cVar2);
        return cVar2;
    }

    public final void e(String str, ArrayList arrayList) {
        String str2;
        b bVar;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ArrayList arrayList2 = ((c) obj).f10226h;
            int size2 = arrayList2.size();
            int i3 = 0;
            while (true) {
                if (i3 >= size2) {
                    bVar = null;
                    break;
                }
                Object obj2 = arrayList2.get(i3);
                i3++;
                bVar = (b) obj2;
                if (bVar.f10221f.equals(str)) {
                    break;
                }
            }
            if (bVar != null) {
                return;
            }
        }
        a aVar = (a) this.f10228a.get(str);
        b bVar2 = new b();
        bVar2.f10221f = str;
        bVar2.f10222g = aVar;
        bVar2.f10220c = this.f10230c;
        VarHandle.storeStoreFence();
        Iterator it = this.f10229b.entrySet().iterator();
        loop2: while (true) {
            if (!it.hasNext()) {
                str2 = "stepos.permission-group.OTHER";
                break;
            }
            Map.Entry entry = (Map.Entry) it.next();
            Iterator it2 = ((Set) entry.getValue()).iterator();
            while (it2.hasNext()) {
                if (str.equals((String) it2.next())) {
                    str2 = (String) entry.getKey();
                    break loop2;
                }
            }
        }
        d(str2, arrayList).f10226h.add(bVar2);
    }
}
