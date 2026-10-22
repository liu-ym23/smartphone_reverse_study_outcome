package androidx.fragment.app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class s extends e.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1302a;

    public /* synthetic */ s(int i) {
        this.f1302a = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // e.b
    public final Intent a(Context context, Cloneable cloneable) {
        Bundle bundleExtra;
        switch (this.f1302a) {
            case 0:
                d.j jVar = (d.j) cloneable;
                Intent intent = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST");
                Intent intent2 = jVar.f2943f;
                if (intent2 != null && (bundleExtra = intent2.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) != null) {
                    intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundleExtra);
                    intent2.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                    if (intent2.getBooleanExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", false)) {
                        jVar = new d.j(jVar.f2942c, null, jVar.f2944g, jVar.f2945h);
                    }
                }
                intent.putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", jVar);
                if (u.h(2)) {
                    Log.v("FragmentManager", "CreateIntent created the following intent: " + intent);
                }
                return intent;
            case 1:
                Intent intentPutExtra = new Intent("androidx.activity.result.contract.action.REQUEST_PERMISSIONS").putExtra("androidx.activity.result.contract.extra.PERMISSIONS", (String[]) cloneable);
                intentPutExtra.getClass();
                return intentPutExtra;
            default:
                return (Intent) cloneable;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // e.b
    public e.a b(Context context, Cloneable cloneable) {
        switch (this.f1302a) {
            case 1:
                String[] strArr = (String[]) cloneable;
                if (strArr.length == 0) {
                    return new e.a(kb.t.f7405c);
                }
                for (String str : strArr) {
                    if (d3.a.a(context, str) != 0) {
                        return null;
                    }
                }
                int iL = kb.x.L(strArr.length);
                if (iL < 16) {
                    iL = 16;
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap(iL);
                for (String str2 : strArr) {
                    linkedHashMap.put(str2, Boolean.TRUE);
                }
                return new e.a(linkedHashMap);
            default:
                return super.b(context, cloneable);
        }
    }

    @Override // e.b
    public final Object c(Intent intent, int i) {
        switch (this.f1302a) {
            case 0:
                return new d.a(intent, i);
            case 1:
                if (i == -1 && intent != null) {
                    String[] stringArrayExtra = intent.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
                    int[] intArrayExtra = intent.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
                    if (intArrayExtra != null && stringArrayExtra != null) {
                        ArrayList arrayList = new ArrayList(intArrayExtra.length);
                        for (int i3 : intArrayExtra) {
                            arrayList.add(Boolean.valueOf(i3 == 0));
                        }
                        return kb.w.Q(kb.l.P0(kb.k.p0(stringArrayExtra), arrayList));
                    }
                }
                return kb.t.f7405c;
            default:
                return new d.a(intent, i);
        }
    }
}
