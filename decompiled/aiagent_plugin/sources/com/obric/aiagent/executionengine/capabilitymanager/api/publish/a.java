package com.obric.aiagent.executionengine.capabilitymanager.api.publish;

import com.obric.capabilitykit.common.intent.AppIntentImplInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.lang.reflect.Type;
import java.util.List;

/* JADX INFO: compiled from: IIntentInfoManagerApi.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f16423a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<AppIntentImplInfo> f16424b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Type f16425c;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
        return false;
    L8:
        a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
        if (o.a(this.f16423a, r6.f16423a) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f16424b, r6.f16424b) == true) goto L15;
        return false;
    L15:
        if (o.a(this.f16425c, r6.f16425c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.f16423a.hashCode() * 31) + this.f16424b.hashCode()) * 31) + this.f16425c.hashCode();
    }

    public String toString() {
        return "IntentInfo(name=" + this.f16423a + ", implList=" + this.f16424b + ", inputType=" + this.f16425c + ')';
    }

    public a(String r3, List<AppIntentImplInfo> r4, Type r5) {
        List<AppIntentImplInfo> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        Type r7 = (Type) ZeusTransformUtils.wrapperContextForParams(r5, Type.class, "com.obric.aiagent.plugin");
        o.e(r3, "name");
        o.e(r6, "implList");
        o.e(r7, "inputType");
        this.f16423a = r3;
        this.f16424b = r6;
        this.f16425c = r7;
    }

    public final String a() {
        return this.f16423a;
    }

    public final List<AppIntentImplInfo> b() {
        return this.f16424b;
    }
}
