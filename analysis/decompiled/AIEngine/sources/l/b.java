package l;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import org.json.JSONException;
import org.json.JSONObject;
import p.o;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10166a = 1;

    /* renamed from: b, reason: collision with root package name */
    public Object f10167b;

    /* renamed from: c, reason: collision with root package name */
    public Object f10168c;

    /* renamed from: d, reason: collision with root package name */
    public Object f10169d;

    public /* synthetic */ b() {
    }

    public static JSONObject c(JSONObject jSONObject, b bVar) throws JSONException {
        if (bVar == null) {
            return null;
        }
        jSONObject.put("app_id", (String) bVar.f10167b);
        jSONObject.put("code", (String) bVar.f10168c);
        jSONObject.put("message", (String) bVar.f10169d);
        return jSONObject;
    }

    public static b d(JSONObject jSONObject, b bVar) {
        if (!jSONObject.isNull("app_id")) {
            bVar.f10167b = jSONObject.getString("app_id");
        }
        if (!jSONObject.isNull("code")) {
            bVar.f10168c = jSONObject.getString("code");
        }
        if (!jSONObject.isNull("message")) {
            bVar.f10169d = jSONObject.getString("message");
        }
        return bVar;
    }

    public MenuItem e(MenuItem menuItem) {
        if (!(menuItem instanceof p0.b)) {
            return menuItem;
        }
        p0.b bVar = (p0.b) menuItem;
        if (((o) this.f10168c) == null) {
            this.f10168c = new o();
        }
        MenuItem menuItem2 = (MenuItem) ((o) this.f10168c).get(bVar);
        if (menuItem2 != null) {
            return menuItem2;
        }
        c cVar = new c((Context) this.f10167b, bVar);
        ((o) this.f10168c).put(bVar, cVar);
        return cVar;
    }

    public SubMenu f(SubMenu subMenu) {
        if (!(subMenu instanceof p0.c)) {
            return subMenu;
        }
        p0.c cVar = (p0.c) subMenu;
        if (((o) this.f10169d) == null) {
            this.f10169d = new o();
        }
        SubMenu subMenu2 = (SubMenu) ((o) this.f10169d).get(cVar);
        if (subMenu2 != null) {
            return subMenu2;
        }
        g gVar = new g((Context) this.f10167b, cVar);
        ((o) this.f10169d).put(cVar, gVar);
        return gVar;
    }

    public String toString() {
        switch (this.f10166a) {
            case 1:
                return "appId=" + ((String) this.f10167b) + ", code=" + ((String) this.f10168c) + ", message=" + ((String) this.f10169d);
            default:
                return super.toString();
        }
    }

    public b(Context context) {
        this.f10167b = context;
    }
}
