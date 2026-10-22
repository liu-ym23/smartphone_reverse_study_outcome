package U2;

import Y2.f;
import android.content.Context;
import android.text.TextUtils;
import b3.C0565c;
import e3.C0688b;
import g3.C0742e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private final List<C0565c.b> f5461a = new ArrayList();

    private static Map<String, Object> b(Map<String, Object> map) {
        if (map == null) {
            return null;
        }
        return new HashMap(map);
    }

    private void d(b bVar, int i5, Map<String, Object> map) {
        C0565c.b bVar2 = new C0565c.b(bVar, i5, map);
        C0565c c0565cQ = f.m().q();
        if (c0565cQ != null) {
            C0742e.c("EventController", "send success");
            c0565cQ.j(bVar2);
        } else {
            C0742e.l("EventController", "send fail, tracker is null");
            f(bVar2);
            f.m().l(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(Context context, String str, String str2, Map map, int i5, Map map2) {
        d(new a(context, str, str2, map), i5, map2);
    }

    private synchronized void f(C0565c.b bVar) {
        if (this.f5461a.size() < 300) {
            this.f5461a.add(bVar);
        } else {
            C0742e.l("EventController", "fail event data list is already full");
        }
    }

    private static Map<String, String> g(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        return new HashMap(map);
    }

    public synchronized void c() {
        if (this.f5461a.isEmpty()) {
            C0742e.c("EventController", "fail event data list is empty");
            return;
        }
        C0565c c0565cQ = f.m().q();
        for (int i5 = 0; i5 < this.f5461a.size(); i5++) {
            c0565cQ.j(this.f5461a.get(i5));
        }
        C0742e.i("EventController", "resend fail event data success, number: " + this.f5461a.size());
        this.f5461a.clear();
    }

    public void h(final Context context, final String str, final String str2, Map<String, String> map, final int i5, Map<String, Object> map2) {
        C0742e.c("EventController", "onActionXEvent, eventName: " + str + ", pageName: " + str2 + ", properties: " + map + ", sendType: " + i5 + ", replaceMap: " + map2);
        if (TextUtils.isEmpty(str)) {
            C0742e.d("EventController", "onActionXEvent fail, eventName is empty");
            return;
        }
        final Map<String, String> mapG = g(map);
        final Map<String, Object> mapB = b(map2);
        C0688b.b(new Runnable() { // from class: U2.c
            @Override // java.lang.Runnable
            public final void run() {
                this.f5454a.e(context, str, str2, mapG, i5, mapB);
            }
        });
    }
}
