package androidx.activity;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import nc.t0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class f implements t4.c {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f671a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f672b;

    public /* synthetic */ f(int i) {
        this.f671a = i;
    }

    @Override // t4.c
    public final Bundle a() {
        jb.g[] gVarArr;
        int i = this.f671a;
        Object obj = this.f672b;
        switch (i) {
            case 0:
                return p.b((p) obj);
            case 1:
                ad.y yVar = (ad.y) obj;
                for (Map.Entry entry : kb.w.R((LinkedHashMap) yVar.f633c).entrySet()) {
                    yVar.m(((t0) entry.getValue()).getValue(), (String) entry.getKey());
                }
                for (Map.Entry entry2 : kb.w.R((LinkedHashMap) yVar.f631a).entrySet()) {
                    yVar.m(((t4.c) entry2.getValue()).a(), (String) entry2.getKey());
                }
                LinkedHashMap linkedHashMap = (LinkedHashMap) yVar.f635e;
                if (linkedHashMap.isEmpty()) {
                    gVarArr = new jb.g[0];
                } else {
                    ArrayList arrayList = new ArrayList(linkedHashMap.size());
                    for (Map.Entry entry3 : linkedHashMap.entrySet()) {
                        arrayList.add(new jb.g((String) entry3.getKey(), entry3.getValue()));
                    }
                    gVarArr = (jb.g[]) arrayList.toArray(new jb.g[0]);
                }
                return h5.t.o((jb.g[]) Arrays.copyOf(gVarArr, gVarArr.length));
            default:
                Map mapB = ((t0.h) obj).b();
                Bundle bundle = new Bundle();
                for (Map.Entry entry4 : mapB.entrySet()) {
                    String str = (String) entry4.getKey();
                    List list = (List) entry4.getValue();
                    bundle.putParcelableArrayList(str, list instanceof ArrayList ? (ArrayList) list : new ArrayList<>(list));
                }
                return bundle;
        }
    }
}
