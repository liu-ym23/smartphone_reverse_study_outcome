package com.fasterxml.jackson.databind.a;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.e.ai;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Map;

/* JADX INFO: compiled from: ConfigOverrides.java */
/* JADX INFO: loaded from: classes2.dex */
public class h implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Map<Class<?>, Object> f12209a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected JsonInclude.Value f12210b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected JsonSetter.Value f12211c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected ai<?> f12212d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected Boolean f12213e;
    protected Boolean f;

    public h() {
        this(null, JsonInclude.Value.empty(), JsonSetter.Value.empty(), ai.a.a(), null, null);
    }

    public h(Map<Class<?>, Object> r3, JsonInclude.Value r4, JsonSetter.Value r5, ai<?> r6, Boolean r7, Boolean r8) {
        Map<Class<?>, Object> r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        ai<?> r10 = (ai) ZeusTransformUtils.wrapperContextForParams(r6, ai.class, "com.obric.aiagent.plugin");
        this.f12209a = r9;
        this.f12210b = r4;
        this.f12211c = r5;
        this.f12212d = r10;
        this.f12213e = r7;
        this.f = r8;
    }

    public g a(Class<?> r2) {
        Map<Class<?>, Object> r1 = this.f12209a;
        if (r1 != null) goto L7;
        return null;
    L7:
        return (g) ZeusTransformUtils.preCheckCast(r1.get(r2), g.class, "com.obric.aiagent.plugin");
    }

    public JsonFormat.Value b(Class<?> r3) {
        Map<Class<?>, Object> r0 = this.f12209a;
        if (r0 == null) goto L13;
        g r4 = (g) ZeusTransformUtils.preCheckCast(r0.get(r3), g.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L13;
        JsonFormat.Value r5 = r4.b();
        if (r5 == null) goto L13;
        if (r5.hasLenient() == false) goto L11;
        return r5;
    L11:
        return r5.withLenient(this.f);
    L13:
        Boolean r2 = this.f;
        if (r2 != null) goto L18;
        return JsonFormat.Value.empty();
    L18:
        return JsonFormat.Value.forLeniency(r2.booleanValue());
    }

    public JsonInclude.Value a() {
        return this.f12210b;
    }

    public JsonSetter.Value b() {
        return this.f12211c;
    }

    public Boolean c() {
        return this.f12213e;
    }

    public ai<?> d() {
        return this.f12212d;
    }
}
