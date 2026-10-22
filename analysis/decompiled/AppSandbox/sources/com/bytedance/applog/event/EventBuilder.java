package com.bytedance.applog.event;

import com.bytedance.applog.log.IAppLogLogger;
import com.bytedance.bdtracker.a;
import com.bytedance.bdtracker.d;
import com.bytedance.bdtracker.l4;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class EventBuilder {
    public final d a;
    public String b;
    public String c;
    public JSONObject d;

    public EventBuilder(d dVar) {
        this.a = dVar;
    }

    public EventBuilder addParam(String str, Object obj) throws JSONException {
        if (this.d == null) {
            this.d = new JSONObject();
        }
        try {
            this.d.put(str, obj);
            return this;
        } catch (JSONException e) {
            e.printStackTrace();
            return this;
        }
    }

    public l4 build() {
        String str = this.a.m;
        String str2 = this.b;
        JSONObject jSONObject = this.d;
        l4 l4Var = new l4(str, str2, false, jSONObject != null ? jSONObject.toString() : null, 0);
        l4Var.j = this.c;
        this.a.D.debug(4, "EventBuilder build: {}", l4Var);
        return l4Var;
    }

    public EventBuilder setAbSdkVersion(String str) {
        this.c = str;
        return this;
    }

    public EventBuilder setEvent(String str) {
        this.b = str;
        return this;
    }

    public void track() {
        l4 l4VarBuild = build();
        IAppLogLogger iAppLogLogger = this.a.D;
        StringBuilder sbA = a.a("EventBuilder track: ");
        sbA.append(this.b);
        iAppLogLogger.debug(4, sbA.toString(), new Object[0]);
        this.a.receive(l4VarBuild);
    }
}
