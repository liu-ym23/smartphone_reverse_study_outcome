package c;

import android.content.Context;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import q7.z;

/* loaded from: classes.dex */
public final /* synthetic */ class e {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f1673a;

    public /* synthetic */ e(i iVar) {
        this.f1673a = iVar;
    }

    public final void a(Context context) {
        q7.k.e(context, "it");
        i iVar = this.f1673a;
        Bundle bundleY0 = ((q6.b) iVar.f1687i.f8787g).y0("android:support:activity-result");
        if (bundleY0 != null) {
            h hVar = iVar.f1691m;
            LinkedHashMap linkedHashMap = hVar.f1679a;
            Bundle bundle = hVar.f1684f;
            LinkedHashMap linkedHashMap2 = hVar.f1680b;
            ArrayList<Integer> integerArrayList = bundleY0.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
            ArrayList<String> stringArrayList = bundleY0.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
            if (stringArrayList == null || integerArrayList == null) {
                return;
            }
            ArrayList<String> stringArrayList2 = bundleY0.getStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS");
            if (stringArrayList2 != null) {
                hVar.f1681c.addAll(stringArrayList2);
            }
            Bundle bundle2 = bundleY0.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT");
            if (bundle2 != null) {
                bundle.putAll(bundle2);
            }
            int size = stringArrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                String str = stringArrayList.get(i2);
                if (linkedHashMap2.containsKey(str)) {
                    Integer num = (Integer) linkedHashMap2.remove(str);
                    if (!bundle.containsKey(str)) {
                        z.a(linkedHashMap).remove(num);
                    }
                }
                Integer num2 = integerArrayList.get(i2);
                q7.k.d(num2, "get(...)");
                int iIntValue = num2.intValue();
                String str2 = stringArrayList.get(i2);
                q7.k.d(str2, "get(...)");
                String str3 = str2;
                linkedHashMap.put(Integer.valueOf(iIntValue), str3);
                linkedHashMap2.put(str3, Integer.valueOf(iIntValue));
            }
        }
    }
}
