package com.bytedance.applog.priority.a;

import com.bytedance.keva.Keva;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: Config.kt */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f5845a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Keva f5846b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f5847c;

    public b(String r3) {
        o.d(r3, "appId");
        this.f5847c = r3;
        this.f5845a = "data";
        Keva r4 = Keva.getRepo("applog_priority_origin@" + r3 + "_config", 0);
        o.b(r4, "Keva.getRepo(\"applog_pri…ants.MODE_SINGLE_PROCESS)");
        this.f5846b = r4;
    }

    public final JSONObject a() {
        String r2 = this.f5846b.getString(this.f5845a, "");
        o.b(r2, "keva.getString(configKey, \"\")");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L12;
        return null;
    L12:
        return new JSONObject(r2);
    L11:
        return null;
    L5:
        r0 = false;
        goto L7
    }

    public final void a(String r2) {
        o.d(r2, "json");
        this.f5846b.storeString(this.f5845a, r2);
    }

    public final void a(String r2, int r3) {
        o.d(r2, "groupDbName");
        this.f5846b.storeInt(r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final List<String> b() {
        List<String> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        Map<String, ?> r1 = this.f5846b.getAll();
        o.b(r1, "keva.all");
        Iterator<Map.Entry<String, ?>> r2 = r1.entrySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L15;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r2.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        if ((!o.a(this.f5845a, (String) ZeusTransformUtils.preCheckCast(r3.getKey(), String.class, "com.obric.aiagent.plugin"))) == false) goto L4;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(String.valueOf(r3.getValue()), CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L10;
        boolean r4 = true;
    L11:
        if (r4 == false) goto L4;
        if ((!o.a(String.valueOf(r3.getValue()), "0")) == false) goto L4;
        Object r5 = r3.getKey();
        o.b(r5, "item.key");
        r0.add(r5);
        goto L4
    L10:
        r4 = false;
        goto L11
    L15:
        return r0;
    }
}
