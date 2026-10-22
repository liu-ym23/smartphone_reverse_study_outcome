package com.bytedance.android.ec.core.cps;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ttnet.org.chromium.base.BaseSwitches;
import faceverify.w;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001a\u0010\u0010\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u000e\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0011\u001a\u0004\b\u0014\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/ec/core/cps/h;", "", "", "version", "Ljava/lang/String;", ce.f26391f, "()Ljava/lang/String;", "event", "b", "params", "d", "sysTime", "f", w.BLOB_ELEM_IMAGE_HASHCODE, "c", "", "r", "I", "e", "()I", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("c")
    private final int f43937c;

    @SerializedName("e")
    private final String event;

    @SerializedName("h")
    private final String hash;

    @SerializedName("d")
    private final String params;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @SerializedName("r")
    private final int f43938r;

    @SerializedName("t")
    private final String sysTime;

    @SerializedName(BaseSwitches.V)
    private final String version;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof h) == false) goto L20;
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.version, r101.version) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.event, r101.event) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.params, r101.params) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.sysTime, r101.sysTime) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.hash, r101.hash) == true) goto L16;
        return false;
    L16:
        if (this.f43938r == r101.f43938r) goto L18;
        return false;
    L18:
        if (this.f43937c == r101.f43937c) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        String r100 = this.version;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.event;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.params;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.sysTime;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.hash;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return ((((r112 + r101) * 31) + this.f43938r) * 31) + this.f43937c;
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "DynamicEventStruct(version=" + this.version + ", event=" + this.event + ", params=" + this.params + ", sysTime=" + this.sysTime + ", hash=" + this.hash + ", r=" + this.f43938r + ", c=" + this.f43937c + ")";
    }

    public final int a() {
        return this.f43937c;
    }

    public final String b() {
        return this.event;
    }

    public final String c() {
        return this.hash;
    }

    public final String d() {
        return this.params;
    }

    public final int e() {
        return this.f43938r;
    }

    public final String f() {
        return this.sysTime;
    }

    public final String g() {
        return this.version;
    }

    public h(String r100, String r101, String r102, String r103, String r104, int r105, int r106) {
        Intrinsics.checkNotNullParameter(r100, "version");
        Intrinsics.checkNotNullParameter(r101, "event");
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r103, "sysTime");
        Intrinsics.checkNotNullParameter(r104, w.BLOB_ELEM_IMAGE_HASHCODE);
        this.version = r100;
        this.event = r101;
        this.params = r102;
        this.sysTime = r103;
        this.hash = r104;
        this.f43938r = r105;
        this.f43937c = r106;
    }
}
