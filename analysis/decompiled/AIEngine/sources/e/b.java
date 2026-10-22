package e;

import android.content.Context;
import android.content.Intent;
import e.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.g;
import mb.l;
import mb.m;
import mb.v;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b extends a<String[], Map<String, Boolean>> {
    @Override // e.a
    public final Intent a(Context context, String[] strArr) {
        String[] input = strArr;
        g.f(input, "input");
        Intent intentPutExtra = new Intent("androidx.activity.result.contract.action.REQUEST_PERMISSIONS").putExtra("androidx.activity.result.contract.extra.PERMISSIONS", input);
        g.e(intentPutExtra, "putExtra(...)");
        return intentPutExtra;
    }

    @Override // e.a
    public final a.C0074a<Map<String, Boolean>> b(Context context, String[] strArr) {
        String[] input = strArr;
        g.f(input, "input");
        if (input.length == 0) {
            return new a.C0074a<>(kotlin.collections.b.d0());
        }
        for (String str : input) {
            if (androidx.core.content.a.a(context, str) != 0) {
                return null;
            }
        }
        int iA0 = v.a0(input.length);
        if (iA0 < 16) {
            iA0 = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iA0);
        for (String str2 : input) {
            linkedHashMap.put(str2, Boolean.TRUE);
        }
        return new a.C0074a<>(linkedHashMap);
    }

    @Override // e.a
    public final Map<String, Boolean> c(int i10, Intent intent) {
        if (i10 != -1) {
            return kotlin.collections.b.d0();
        }
        if (intent == null) {
            return kotlin.collections.b.d0();
        }
        String[] stringArrayExtra = intent.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
        int[] intArrayExtra = intent.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
        if (intArrayExtra == null || stringArrayExtra == null) {
            return kotlin.collections.b.d0();
        }
        ArrayList arrayList = new ArrayList(intArrayExtra.length);
        for (int i11 : intArrayExtra) {
            arrayList.add(Boolean.valueOf(i11 == 0));
        }
        ArrayList arrayListD0 = l.d0(stringArrayExtra);
        Iterator it = arrayListD0.iterator();
        Iterator it2 = arrayList.iterator();
        ArrayList arrayList2 = new ArrayList(Math.min(m.Z(arrayListD0, 10), m.Z(arrayList, 10)));
        while (it.hasNext() && it2.hasNext()) {
            arrayList2.add(new Pair(it.next(), it2.next()));
        }
        return kotlin.collections.b.m0(arrayList2);
    }
}
