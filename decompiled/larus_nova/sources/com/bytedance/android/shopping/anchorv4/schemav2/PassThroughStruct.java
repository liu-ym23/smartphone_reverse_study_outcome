package com.bytedance.android.shopping.anchorv4.schemav2;

import com.google.gson.annotations.SerializedName;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0006J\u0011\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0004HÆ\u0003J'\u0010\r\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0004HÖ\u0001R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/schemav2/PassThroughStruct;", "Ljava/io/Serializable;", RemoteMessageConst.TO, "", "", "data", "(Ljava/util/List;Ljava/lang/String;)V", "getData", "()Ljava/lang/String;", "getTo", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PassThroughStruct implements Serializable {

    @SerializedName("data")
    private final String data;

    /* JADX INFO: renamed from: to, reason: collision with root package name */
    @SerializedName(RemoteMessageConst.TO)
    private final List<String> f167341to;

    /* JADX WARN: Multi-variable type inference failed */
    public PassThroughStruct() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PassThroughStruct copy$default(PassThroughStruct r100, List r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.f167341to;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.data;
    L9:
        return r100.copy(r101, r102);
    }

    public final List<String> component1() {
        return this.f167341to;
    }

    public final String component2() {
        return this.data;
    }

    public final PassThroughStruct copy(List<String> r100, String r101) {
        return new PassThroughStruct(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof PassThroughStruct) == false) goto L10;
        PassThroughStruct r101 = (PassThroughStruct) r100;
        if (Intrinsics.areEqual(this.f167341to, r101.f167341to) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.data, r101.data) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        List<String> r100 = this.f167341to;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.data;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "PassThroughStruct(to=" + this.f167341to + ", data=" + this.data + ")";
    }

    public final String getData() {
        return this.data;
    }

    public final List<String> getTo() {
        return this.f167341to;
    }

    public PassThroughStruct(List<String> r100, String r101) {
        this.f167341to = r100;
        this.data = r101;
    }

    public /* synthetic */ PassThroughStruct(List r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
