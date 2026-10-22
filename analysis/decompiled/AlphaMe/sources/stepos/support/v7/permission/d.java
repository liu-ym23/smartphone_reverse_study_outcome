package stepos.support.v7.permission;

import android.content.Context;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import stepos.support.v7.app.C0872q;

/* loaded from: classes2.dex */
public final class d {

    /* renamed from: d, reason: collision with root package name */
    public static volatile d f14649d;

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f14650a;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f14651b;

    /* renamed from: c, reason: collision with root package name */
    public final C0872q f14652c;

    /* JADX WARN: Removed duplicated region for block: B:100:0x0469  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x046f  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0475  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x047b  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x048b  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0496  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x04ba  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x04c9 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x039b  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x03a9  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x03b7  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x03c5  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x03d0  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x03db  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x03e6  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x03f1  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x03fc  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0407  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0412  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0421  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0441  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0448  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0459  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public d(android.content.Context r19) {
        /*
            Method dump skipped, instructions count: 1312
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.permission.d.<init>(android.content.Context):void");
    }

    public static d a(Context context) {
        if (f14649d == null) {
            synchronized (d.class) {
                try {
                    if (f14649d == null) {
                        f14649d = new d(context);
                    }
                } finally {
                }
            }
        }
        return f14649d;
    }

    public final List b(String[] strArr, boolean z4) {
        if (strArr == null || strArr.length <= 0) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            if (this.f14651b.containsKey(str)) {
                c(str, arrayList);
                if (z4) {
                    Iterator it = ((Set) this.f14651b.get(str)).iterator();
                    while (it.hasNext()) {
                        d((String) it.next(), arrayList);
                    }
                }
            } else {
                d(str, arrayList);
            }
        }
        Collections.sort(arrayList);
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            Collections.sort(((c) it2.next()).f14648d);
        }
        return arrayList;
    }

    public final c c(String str, ArrayList arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (cVar.f14646b.equals(str)) {
                return cVar;
            }
        }
        c cVar2 = new c(str, (a) this.f14650a.get(str), this.f14652c);
        arrayList.add(cVar2);
        return cVar2;
    }

    public final void d(String str, ArrayList arrayList) {
        String str2;
        b bVar;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Iterator it2 = ((c) it.next()).f14648d.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    bVar = null;
                    break;
                } else {
                    bVar = (b) it2.next();
                    if (bVar.f14643b.equals(str)) {
                        break;
                    }
                }
            }
            if (bVar != null) {
                return;
            }
        }
        b bVar2 = new b(str, (a) this.f14650a.get(str), this.f14652c);
        Iterator it3 = this.f14651b.entrySet().iterator();
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
        c(str2, arrayList).f14648d.add(bVar2);
    }
}
