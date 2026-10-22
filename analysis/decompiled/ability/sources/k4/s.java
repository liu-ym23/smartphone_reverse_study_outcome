package k4;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;

/* loaded from: classes3.dex */
public final class s extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public final n f4813a;
    public boolean b;

    public s(n registry) {
        kotlin.jvm.internal.k.f(registry, "registry");
        this.f4813a = registry;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        String schemeSpecificPart;
        int size;
        Uri data;
        if (intent == null || (data = intent.getData()) == null || (schemeSpecificPart = data.getSchemeSpecificPart()) == null || j9.m.s0(schemeSpecificPart)) {
            schemeSpecificPart = null;
        }
        if (schemeSpecificPart == null) {
            androidx.constraintlayout.core.dsl.a.w("package broadcast without package name: action=", intent != null ? intent.getAction() : null, "McpPackageChange");
            return;
        }
        n nVar = this.f4813a;
        nVar.getClass();
        synchronized (nVar.b) {
            try {
                Set<Map.Entry<String, m>> setEntrySet = nVar.d.entrySet();
                kotlin.jvm.internal.k.e(setEntrySet, "<get-entries>(...)");
                ArrayList arrayList = new ArrayList();
                for (Object obj : setEntrySet) {
                    if (kotlin.jvm.internal.k.b(((m) ((Map.Entry) obj).getValue()).f4807a.f4797a, schemeSpecificPart)) {
                        arrayList.add(obj);
                    }
                }
                ArrayList arrayList2 = new ArrayList(D7.w.c0(arrayList, 10));
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    arrayList2.add(new Pair(entry.getKey(), Integer.valueOf(((m) entry.getValue()).b)));
                }
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    Pair pair = (Pair) it2.next();
                    Object obj2 = pair.f4886a;
                    kotlin.jvm.internal.k.e(obj2, "component1(...)");
                    String str = (String) obj2;
                    int iIntValue = ((Number) pair.b).intValue();
                    nVar.d.remove(str);
                    nVar.a(iIntValue, str);
                }
                size = arrayList2.size();
            } catch (Throwable th) {
                throw th;
            }
        }
        if (size > 0) {
            Log.i("CallerIdentityRegistry", "dropped " + size + " binding(s) of " + schemeSpecificPart + " (package replaced/removed)");
        }
    }
}
