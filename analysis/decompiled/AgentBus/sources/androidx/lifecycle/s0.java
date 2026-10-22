package androidx.lifecycle;

import android.util.Log;
import java.util.LinkedHashMap;
import java.util.TreeMap;

/* loaded from: classes.dex */
public final class s0 {

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f1030a;

    public s0(int i2) {
        switch (i2) {
            case 1:
                this.f1030a = new LinkedHashMap();
                break;
            case 2:
                this.f1030a = new LinkedHashMap(0, 0.75f, true);
                break;
            case 3:
                this.f1030a = new LinkedHashMap();
                break;
            default:
                this.f1030a = new LinkedHashMap();
                break;
        }
    }

    public void a(i5.n... nVarArr) {
        q7.k.e(nVarArr, "migrations");
        for (i5.n nVar : nVarArr) {
            nVar.getClass();
            LinkedHashMap linkedHashMap = this.f1030a;
            Object treeMap = linkedHashMap.get(1);
            if (treeMap == null) {
                treeMap = new TreeMap();
                linkedHashMap.put(1, treeMap);
            }
            TreeMap treeMap2 = (TreeMap) treeMap;
            if (treeMap2.containsKey(2)) {
                Log.w("ROOM", "Overriding migration " + treeMap2.get(2) + " with " + nVar);
            }
            treeMap2.put(2, nVar);
        }
    }
}
