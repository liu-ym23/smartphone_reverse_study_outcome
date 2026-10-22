package com.obric.funcall_api.bean;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: IntentAppAction.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ECAContent {

    @SerializedName("Content")
    private final String ecaData;

    @SerializedName("Version")
    private final Integer version;

    /* JADX WARN: Multi-variable type inference failed */
    public ECAContent() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ ECAContent copy$default(ECAContent r0, Integer r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.version;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.ecaData;
    L9:
        return r0.copy(r1, r2);
    }

    public final Integer component1() {
        return this.version;
    }

    public final String component2() {
        return this.ecaData;
    }

    public final ECAContent copy(Integer r1, String r2) {
        return new ECAContent(r1, r2);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ECAContent.class) == true) goto L8;
        return false;
    L8:
        ECAContent r6 = (ECAContent) ZeusTransformUtils.preCheckCast(r5, ECAContent.class, "com.obric.aiagent.plugin");
        if (o.a(this.version, r6.version) == true) goto L12;
        return false;
    L12:
        if (o.a(this.ecaData, r6.ecaData) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        Integer r0 = this.version;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.ecaData;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "ECAContent(version=" + this.version + ", ecaData=" + this.ecaData + ')';
    }

    public ECAContent(Integer r1, String r2) {
        this.version = r1;
        this.ecaData = r2;
    }

    public /* synthetic */ ECAContent(Integer r2, String r3, int r4, h r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }

    public final Integer getVersion() {
        return this.version;
    }

    public final String getEcaData() {
        return this.ecaData;
    }
}
