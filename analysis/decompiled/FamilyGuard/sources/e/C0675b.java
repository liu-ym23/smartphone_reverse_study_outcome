package e;

import V3.m;
import V3.r;
import W3.C0396g;
import W3.C0403n;
import W3.E;
import android.content.Context;
import android.content.Intent;
import e.AbstractC0674a;
import j4.g;
import j4.k;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.ranges.l;

/* renamed from: e.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0675b extends AbstractC0674a<String[], Map<String, Boolean>> {

    /* renamed from: a, reason: collision with root package name */
    public static final a f16631a = new a(null);

    /* renamed from: e.b$a */
    public static final class a {
        public /* synthetic */ a(g gVar) {
            this();
        }

        public final Intent a(String[] strArr) {
            k.g(strArr, "input");
            Intent intentPutExtra = new Intent("androidx.activity.result.contract.action.REQUEST_PERMISSIONS").putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr);
            k.f(intentPutExtra, "Intent(ACTION_REQUEST_PE…EXTRA_PERMISSIONS, input)");
            return intentPutExtra;
        }

        private a() {
        }
    }

    @Override // e.AbstractC0674a
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public Intent a(Context context, String[] strArr) {
        k.g(context, "context");
        k.g(strArr, "input");
        return f16631a.a(strArr);
    }

    @Override // e.AbstractC0674a
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public AbstractC0674a.C0207a<Map<String, Boolean>> b(Context context, String[] strArr) {
        k.g(context, "context");
        k.g(strArr, "input");
        if (strArr.length == 0) {
            return new AbstractC0674a.C0207a<>(E.d());
        }
        for (String str : strArr) {
            if (androidx.core.content.a.a(context, str) != 0) {
                return null;
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(l.b(E.a(strArr.length), 16));
        for (String str2 : strArr) {
            m mVarA = r.a(str2, Boolean.TRUE);
            linkedHashMap.put(mVarA.c(), mVarA.d());
        }
        return new AbstractC0674a.C0207a<>(linkedHashMap);
    }

    @Override // e.AbstractC0674a
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public Map<String, Boolean> c(int i5, Intent intent) {
        if (i5 == -1 && intent != null) {
            String[] stringArrayExtra = intent.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
            int[] intArrayExtra = intent.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
            if (intArrayExtra == null || stringArrayExtra == null) {
                return E.d();
            }
            ArrayList arrayList = new ArrayList(intArrayExtra.length);
            for (int i6 : intArrayExtra) {
                arrayList.add(Boolean.valueOf(i6 == 0));
            }
            return E.g(C0403n.Y(C0396g.m(stringArrayExtra), arrayList));
        }
        return E.d();
    }
}
