package com.obric.autogui.agents.scripted.api;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: compiled from: AbilityDescription.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("scripts")
    private final List<a> f26895a;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
        return false;
    L8:
        c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
        if (o.a(this.f26895a, r6.f26895a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.f26895a.hashCode();
    }

    public String toString() {
        return "ScriptManifest(scripts=" + this.f26895a + ')';
    }

    public final List<a> a() {
        return this.f26895a;
    }
}
