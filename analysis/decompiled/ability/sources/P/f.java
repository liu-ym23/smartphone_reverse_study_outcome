package P;

import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import g1.AbstractC1451a;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class f implements N.b {

    /* renamed from: a, reason: collision with root package name */
    public String f1058a;
    public String b;
    public JSONObject c;
    public JSONObject d;

    @Override // N.b
    public final JSONObject a() {
        try {
            if (this.d == null) {
                this.d = new JSONObject();
            }
            this.d.put("log_type", "ui_action");
            this.d.put(GuiTaskProgressKt.GuiTaskProgress_KEY_ACTION, this.f1058a);
            this.d.put("page", this.b);
            this.d.put("context", this.c);
            return this.d;
        } catch (JSONException unused) {
            return null;
        }
    }

    @Override // N.b
    public final boolean b() {
        return AbstractC1451a.f4474w.b("ui");
    }

    @Override // N.b
    public final String d() {
        return "ui_action";
    }

    @Override // N.b
    public final String g() {
        return "ui_action";
    }
}
