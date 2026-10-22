package com.obric.autogui.agents.scripted.api;

import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.io.Serializable;

/* JADX INFO: compiled from: AbilityDescription.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("name")
    private final String f26891a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("description")
    private final String f26892b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("ability")
    private final String f26893c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SerializedName("schema")
    private final JsonElement f26894d;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
        return false;
    L8:
        a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
        if (o.a(this.f26891a, r6.f26891a) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f26892b, r6.f26892b) == true) goto L15;
        return false;
    L15:
        if (o.a(this.f26893c, r6.f26893c) == true) goto L18;
        return false;
    L18:
        if (o.a(this.f26894d, r6.f26894d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r0 = ((((this.f26891a.hashCode() * 31) + this.f26892b.hashCode()) * 31) + this.f26893c.hashCode()) * 31;
        JsonElement r2 = this.f26894d;
        if (r2 != null) goto L5;
        int r3 = 0;
    L7:
        return r0 + r3;
    L5:
        r3 = r2.hashCode();
        goto L7
    }

    public String toString() {
        return "AbilityDescription(name=" + this.f26891a + ", description=" + this.f26892b + ", ability=" + this.f26893c + ", schema=" + this.f26894d + ')';
    }

    public final String a() {
        return this.f26891a;
    }

    public final String b() {
        return this.f26893c;
    }
}
