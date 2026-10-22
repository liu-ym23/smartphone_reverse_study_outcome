package com.obric.autogui.agents.vlm.models.omni.intent;

import com.google.gson.JsonArray;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: OmniGUIIntent.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f28419a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final JsonArray f28420b;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, j.class) == true) goto L8;
        return false;
    L8:
        j r6 = (j) ZeusTransformUtils.preCheckCast(r5, j.class, "com.obric.aiagent.plugin");
        if (o.a(this.f28419a, r6.f28419a) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f28420b, r6.f28420b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f28419a.hashCode() * 31) + this.f28420b.hashCode();
    }

    public String toString() {
        return "SingleAction(actionName=" + this.f28419a + ", args=" + this.f28420b + ')';
    }

    public j(String r2, JsonArray r3) {
        o.e(r2, "actionName");
        o.e(r3, "args");
        this.f28419a = r2;
        this.f28420b = r3;
    }

    public final String a() {
        return this.f28419a;
    }

    public final JsonArray b() {
        return this.f28420b;
    }
}
