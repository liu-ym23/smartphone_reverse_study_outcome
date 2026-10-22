package com.obric.capabilitykit.version;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: loaded from: classes4.dex */
public final class EntityVersionData implements Comparable<EntityVersionData> {

    @SerializedName("appEntityVersion")
    private int appEntityVersion;

    @SerializedName("selfVersion")
    private int selfVersion;

    public EntityVersionData() {
        int r0 = 0;
        this(r0, r0, 3, null);
    }

    public EntityVersionData(int r1, int r2) {
        this.selfVersion = r1;
        this.appEntityVersion = r2;
    }

    public /* synthetic */ EntityVersionData(int r2, int r3, int r4, h r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = -1;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = -1;
    L8:
        this(r2, r3);
    }

    public static /* synthetic */ EntityVersionData copy$default(EntityVersionData r0, int r1, int r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.selfVersion;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.appEntityVersion;
    L9:
        return r0.copy(r1, r2);
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(EntityVersionData r3) {
        o.e(r3, "other");
        int r0 = o.a(this.appEntityVersion, r3.appEntityVersion);
        if (r0 <= 0) goto L6;
        return r0;
    L6:
        return o.a(this.selfVersion, r3.selfVersion);
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(EntityVersionData r3) {
        return compareTo2((EntityVersionData) ZeusTransformUtils.preCheckCast(r3, EntityVersionData.class, "com.obric.aiagent.plugin"));
    }

    public final int component1() {
        return this.selfVersion;
    }

    public final int component2() {
        return this.appEntityVersion;
    }

    public final EntityVersionData copy(int r1, int r2) {
        return new EntityVersionData(r1, r2);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, EntityVersionData.class) == true) goto L8;
        return false;
    L8:
        EntityVersionData r6 = (EntityVersionData) ZeusTransformUtils.preCheckCast(r5, EntityVersionData.class, "com.obric.aiagent.plugin");
        if (this.selfVersion == r6.selfVersion) goto L12;
        return false;
    L12:
        if (this.appEntityVersion == r6.appEntityVersion) goto L14;
        return false;
    L14:
        return true;
    }

    public final int getAppEntityVersion() {
        return this.appEntityVersion;
    }

    public final int getSelfVersion() {
        return this.selfVersion;
    }

    public int hashCode() {
        return (Integer.hashCode(this.selfVersion) * 31) + Integer.hashCode(this.appEntityVersion);
    }

    public final void setAppEntityVersion(int r1) {
        this.appEntityVersion = r1;
    }

    public final void setSelfVersion(int r1) {
        this.selfVersion = r1;
    }

    public String toString() {
        return "EntityVersionData(selfVersion=" + this.selfVersion + ", appEntityVersion=" + this.appEntityVersion + ')';
    }
}
