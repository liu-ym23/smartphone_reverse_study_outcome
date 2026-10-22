package F9;

import F9.v;
import I4.l;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.stepos.ability.App;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class v {

    /* renamed from: a, reason: collision with root package name */
    public ArrayList f656a;

    public v(int i) {
        switch (i) {
            case 1:
                this.f656a = new ArrayList();
                break;
            default:
                this.f656a = new ArrayList(20);
                break;
        }
    }

    public void a(String str, String str2) {
        ArrayList arrayList = this.f656a;
        if (arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            if (it.hasNext()) {
                throw B7.a.f(it);
            }
        }
        if (TextUtils.isEmpty(str2)) {
            Log.d("ApmInsight", U7.a.e(new String[]{str}));
        } else {
            Log.d("ApmInsight", U7.a.e(new String[]{B7.a.B(str, ":", str2)}));
        }
    }

    public void b(String str, JSONObject jSONObject) {
        ArrayList arrayList = this.f656a;
        if (arrayList.size() <= 0 || jSONObject == null) {
            return;
        }
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("DATA_DOCTOR");
            jSONObject2.put(str, System.currentTimeMillis());
            jSONObject2.optInt("DATA_ID");
            Iterator it = arrayList.iterator();
            if (it.hasNext()) {
                if (it.next() != null) {
                    throw new ClassCastException();
                }
                throw null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void c(String name, String value) {
        kotlin.jvm.internal.k.f(name, "name");
        kotlin.jvm.internal.k.f(value, "value");
        AbstractC0226d.b(name);
        AbstractC0226d.c(value, name);
        d(name, value);
    }

    public void d(String name, String value) {
        kotlin.jvm.internal.k.f(name, "name");
        kotlin.jvm.internal.k.f(value, "value");
        ArrayList arrayList = this.f656a;
        arrayList.add(name);
        arrayList.add(j9.m.R0(value).toString());
    }

    public void e(String name, String value) {
        kotlin.jvm.internal.k.f(name, "name");
        kotlin.jvm.internal.k.f(value, "value");
        if (name.length() <= 0) {
            throw new IllegalArgumentException("name is empty");
        }
        int length = name.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = name.charAt(i);
            if ('!' > cCharAt || cCharAt >= 127) {
                throw new IllegalArgumentException(G9.b.g("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(cCharAt), Integer.valueOf(i), name).toString());
            }
        }
        d(name, value);
    }

    public void f(final App app, final String str, final String str2, Map map, final int i) {
        StringBuilder sbW = B7.a.w("onActionXEvent, eventName: ", str, ", pageName: ", str2, ", properties: ");
        sbW.append(map);
        sbW.append(", sendType: ");
        sbW.append(i);
        sbW.append(", replaceMap: null");
        W5.c.a("EventController", sbW.toString());
        if (TextUtils.isEmpty(str)) {
            W5.c.b("EventController", "onActionXEvent fail, eventName is empty");
            return;
        }
        final HashMap map2 = null;
        final HashMap map3 = map == null ? null : new HashMap(map);
        I9.d.a(new Runnable() { // from class: J5.c
            @Override // java.lang.Runnable
            public final void run() {
                v vVar = this.f877a;
                Context context = app;
                String str3 = str;
                String str4 = str2;
                Map map4 = map3;
                int i6 = i;
                Map map5 = map2;
                a aVar = new a(context, str3, str4, map4);
                R5.c cVar = new R5.c();
                cVar.f1154a = aVar;
                cVar.b = i6;
                cVar.c = map5;
                O5.d dVar = O5.c.f1037a;
                R5.d dVar2 = dVar.d;
                if (dVar2 != null) {
                    W5.c.a("EventController", "send success");
                    I9.d.a(new l(2, dVar2, cVar));
                    return;
                }
                W5.c.f("EventController", "send fail, tracker is null");
                synchronized (vVar) {
                    if (vVar.f656a.size() < 300) {
                        vVar.f656a.add(cVar);
                    } else {
                        W5.c.f("EventController", "fail event data list is already full");
                    }
                }
                I9.d.a(new O5.b(dVar, false, 0));
            }
        });
    }

    public w g() {
        return new w((String[]) this.f656a.toArray(new String[0]));
    }

    public void h(String name) {
        ArrayList arrayList = this.f656a;
        kotlin.jvm.internal.k.f(name, "name");
        int i = 0;
        while (i < arrayList.size()) {
            if (name.equalsIgnoreCase((String) arrayList.get(i))) {
                arrayList.remove(i);
                arrayList.remove(i);
                i -= 2;
            }
            i += 2;
        }
    }
}
