package stepos.support.v7.permission;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PermissionInfo;
import android.text.TextUtils;
import com.stepos.core.common.util.TraceIdKeys;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: d, reason: collision with root package name */
    public static volatile e f12319d;

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f12320a;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f12321b;

    /* renamed from: c, reason: collision with root package name */
    public final b f12322c;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0522  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0537  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0547  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0565  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0579  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0597  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x05b5  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x05ca  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x05df  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x05f4  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0613  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x062d  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0650  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x042b A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0433 A[PHI: r1 r4 r5 r20 r21 r22 r23 r24 r25 r26 r57
      0x0433: PHI (r1v124 java.lang.Object) = 
      (r1v77 java.lang.Object)
      (r1v90 java.lang.Object)
      (r1v93 java.lang.Object)
      (r1v94 java.lang.Object)
      (r1v125 java.lang.Object)
     binds: [B:101:0x052e, B:98:0x0517, B:68:0x0469, B:64:0x0456, B:57:0x042b] A[DONT_GENERATE, DONT_INLINE]
      0x0433: PHI (r4v45 java.lang.Object) = 
      (r4v17 java.lang.Object)
      (r4v24 java.lang.Object)
      (r4v26 java.lang.Object)
      (r4v27 java.lang.Object)
      (r4v46 java.lang.Object)
     binds: [B:101:0x052e, B:98:0x0517, B:68:0x0469, B:64:0x0456, B:57:0x042b] A[DONT_GENERATE, DONT_INLINE]
      0x0433: PHI (r5v47 java.lang.Object) = 
      (r5v20 java.lang.Object)
      (r5v27 java.lang.Object)
      (r5v29 java.lang.Object)
      (r5v30 java.lang.Object)
      (r5v48 java.lang.Object)
     binds: [B:101:0x052e, B:98:0x0517, B:68:0x0469, B:64:0x0456, B:57:0x042b] A[DONT_GENERATE, DONT_INLINE]
      0x0433: PHI (r20v7 java.lang.Object) = 
      (r20v1 java.lang.Object)
      (r20v5 java.lang.Object)
      (r20v1 java.lang.Object)
      (r20v1 java.lang.Object)
      (r20v1 java.lang.Object)
     binds: [B:101:0x052e, B:98:0x0517, B:68:0x0469, B:64:0x0456, B:57:0x042b] A[DONT_GENERATE, DONT_INLINE]
      0x0433: PHI (r21v7 java.lang.Object) = 
      (r21v1 java.lang.Object)
      (r21v5 java.lang.Object)
      (r21v1 java.lang.Object)
      (r21v1 java.lang.Object)
      (r21v1 java.lang.Object)
     binds: [B:101:0x052e, B:98:0x0517, B:68:0x0469, B:64:0x0456, B:57:0x042b] A[DONT_GENERATE, DONT_INLINE]
      0x0433: PHI (r22v7 java.lang.Object) = 
      (r22v1 java.lang.Object)
      (r22v5 java.lang.Object)
      (r22v1 java.lang.Object)
      (r22v1 java.lang.Object)
      (r22v1 java.lang.Object)
     binds: [B:101:0x052e, B:98:0x0517, B:68:0x0469, B:64:0x0456, B:57:0x042b] A[DONT_GENERATE, DONT_INLINE]
      0x0433: PHI (r23v7 java.lang.Object) = 
      (r23v1 java.lang.Object)
      (r23v5 java.lang.Object)
      (r23v1 java.lang.Object)
      (r23v1 java.lang.Object)
      (r23v1 java.lang.Object)
     binds: [B:101:0x052e, B:98:0x0517, B:68:0x0469, B:64:0x0456, B:57:0x042b] A[DONT_GENERATE, DONT_INLINE]
      0x0433: PHI (r24v7 java.lang.Object) = 
      (r24v1 java.lang.Object)
      (r24v5 java.lang.Object)
      (r24v1 java.lang.Object)
      (r24v1 java.lang.Object)
      (r24v1 java.lang.Object)
     binds: [B:101:0x052e, B:98:0x0517, B:68:0x0469, B:64:0x0456, B:57:0x042b] A[DONT_GENERATE, DONT_INLINE]
      0x0433: PHI (r25v7 java.lang.Object) = 
      (r25v1 java.lang.Object)
      (r25v5 java.lang.Object)
      (r25v1 java.lang.Object)
      (r25v1 java.lang.Object)
      (r25v1 java.lang.Object)
     binds: [B:101:0x052e, B:98:0x0517, B:68:0x0469, B:64:0x0456, B:57:0x042b] A[DONT_GENERATE, DONT_INLINE]
      0x0433: PHI (r26v7 java.lang.Object) = 
      (r26v1 java.lang.Object)
      (r26v2 java.lang.Object)
      (r26v1 java.lang.Object)
      (r26v1 java.lang.Object)
      (r26v1 java.lang.Object)
     binds: [B:101:0x052e, B:98:0x0517, B:68:0x0469, B:64:0x0456, B:57:0x042b] A[DONT_GENERATE, DONT_INLINE]
      0x0433: PHI (r57v15 java.lang.Object) = 
      (r57v2 java.lang.Object)
      (r57v9 java.lang.Object)
      (r57v11 java.lang.Object)
      (r57v12 java.lang.Object)
      (r57v16 java.lang.Object)
     binds: [B:101:0x052e, B:98:0x0517, B:68:0x0469, B:64:0x0456, B:57:0x042b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0437  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x044a  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x045d  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0470  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x048a  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x04a4  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x04be  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x04d7  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x04ef  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0507  */
    /* JADX WARN: Type inference failed for: r1v126 */
    /* JADX WARN: Type inference failed for: r1v69, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v76, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v12, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v43 */
    /* JADX WARN: Type inference failed for: r4v47 */
    /* JADX WARN: Type inference failed for: r4v7, types: [android.content.pm.PackageManager] */
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
    public e(android.content.Context r66) {
        /*
            Method dump skipped, instructions count: 1744
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.permission.e.<init>(android.content.Context):void");
    }

    public static e a(Context context) {
        if (f12319d == null) {
            synchronized (e.class) {
                try {
                    if (f12319d == null) {
                        f12319d = new e(context);
                    }
                } finally {
                }
            }
        }
        return f12319d;
    }

    public final String b(String str) throws PackageManager.NameNotFoundException {
        a aVar = (a) this.f12320a.get(str);
        if ("zh_CN".equals(Locale.getDefault().toString()) && aVar != null) {
            String str2 = aVar.f12310b;
            if (!TextUtils.isEmpty(str2)) {
                return str2;
            }
        }
        PackageManager packageManager = this.f12322c.f12311a;
        String string = null;
        try {
            PermissionInfo permissionInfo = packageManager.getPermissionInfo(str, TraceIdKeys.MAX_LENGTH);
            if (permissionInfo.labelRes != 0) {
                string = permissionInfo.loadLabel(packageManager).toString();
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return TextUtils.isEmpty(string) ? str : string;
    }

    public final List<d> c(String[] strArr, boolean z) {
        if (strArr == null || strArr.length <= 0) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        for (String str : strArr) {
            if (this.f12321b.containsKey(str)) {
                d(str, arrayList);
                if (z) {
                    Iterator it = ((Set) this.f12321b.get(str)).iterator();
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
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            Collections.sort(((d) obj).f12318d);
        }
        return arrayList;
    }

    public final d d(String str, ArrayList arrayList) {
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            d dVar = (d) obj;
            if (dVar.f12316b.equals(str)) {
                return dVar;
            }
        }
        d dVar2 = new d(str, (a) this.f12320a.get(str), this.f12322c);
        arrayList.add(dVar2);
        return dVar2;
    }

    public final void e(String str, ArrayList arrayList) {
        String str2;
        c cVar;
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            ArrayList arrayList2 = ((d) obj).f12318d;
            int size2 = arrayList2.size();
            int i11 = 0;
            while (true) {
                if (i11 >= size2) {
                    cVar = null;
                    break;
                }
                Object obj2 = arrayList2.get(i11);
                i11++;
                cVar = (c) obj2;
                if (cVar.f12313b.equals(str)) {
                    break;
                }
            }
            if (cVar != null) {
                return;
            }
        }
        c cVar2 = new c(str, (a) this.f12320a.get(str), this.f12322c);
        Iterator it = this.f12321b.entrySet().iterator();
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
        d(str2, arrayList).f12318d.add(cVar2);
    }
}
