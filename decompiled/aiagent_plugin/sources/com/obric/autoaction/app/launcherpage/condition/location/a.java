package com.obric.autoaction.app.launcherpage.condition.location;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ConditionLocationModel.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("Province")
    private final j f23120a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("City")
    private final j f23121b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("District")
    private final j f23122c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SerializedName("Town")
    private final j f23123d;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
        return false;
    L8:
        a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f23120a, r6.f23120a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f23121b, r6.f23121b) == true) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f23122c, r6.f23122c) == true) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.f23123d, r6.f23123d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.f23120a.hashCode() * 31) + this.f23121b.hashCode()) * 31) + this.f23122c.hashCode()) * 31) + this.f23123d.hashCode();
    }

    public String toString() {
        return "Adms(province=" + this.f23120a + ", city=" + this.f23121b + ", district=" + this.f23122c + ", town=" + this.f23123d + ')';
    }
}
