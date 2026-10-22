package ha;

import android.content.Context;
import android.text.TextUtils;
import androidx.appcompat.app.l;
import java.util.ArrayList;
import java.util.Map;
import la.c;
import oa.b;
import ra.a;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f9380a = new ArrayList();

    public final void a(Context context, String str, String str2, Map map, int i10) {
        StringBuilder sbS = ai.onnxruntime.a.s("onActionXEvent, eventName: ", str, ", pageName: ", str2, ", properties: ");
        sbS.append(map);
        sbS.append(", sendType: ");
        sbS.append(i10);
        sbS.append(", replaceMap: null");
        ta.c.a("EventController", sbS.toString());
        if (TextUtils.isEmpty(str)) {
            ta.c.b("EventController", "onActionXEvent fail, eventName is empty");
            return;
        }
        a aVar = new a(context, str, str2, map);
        b.C0119b c0119b = new b.C0119b();
        c0119b.f10849a = aVar;
        c0119b.f10850b = i10;
        la.c cVar = c.a.f10391a;
        oa.b bVar = cVar.f10386d;
        if (bVar != null) {
            ta.c.a("EventController", "send success");
            a.C0133a.f11759a.f11758a.execute(new l(19, bVar, c0119b));
            return;
        }
        ta.c.f("EventController", "send fail, tracker is null");
        synchronized (this) {
            if (this.f9380a.size() < 300) {
                this.f9380a.add(c0119b);
            } else {
                ta.c.f("EventController", "fail event data list is already full");
            }
        }
        a.C0133a.f11759a.f11758a.execute(new e9.a(false, 1, cVar));
    }
}
