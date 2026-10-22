package com.bytedance.bdtracker;

import com.bytedance.applog.util.HardwareUtils;
import java.util.Collections;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class f0 {
    public final e0 a;

    public f0(e0 e0Var) {
        this.a = e0Var;
    }

    public void a(e4 e4Var) {
        try {
            JSONObject jSONObject = e4Var.o != null ? e4Var.o : new JSONObject();
            if (this.a.e.c.isScreenOrientationEnabled()) {
                jSONObject.put("$screen_orientation", HardwareUtils.getScreenOrientation(this.a.d.n) == 2 ? "landscape" : "portrait");
            }
            s sVar = this.a.d.B;
            if (sVar != null) {
                jSONObject.put("$longitude", sVar.a);
                jSONObject.put("$latitude", sVar.b);
                jSONObject.put("$geo_coordinate_system", sVar.c);
            }
            if (jSONObject.length() > 0) {
                e4Var.o = jSONObject;
            }
        } catch (Throwable th) {
            this.a.d.D.error(4, Collections.singletonList("LifeHook"), "Do beforeEventSave failed", th, new Object[0]);
        }
    }
}
