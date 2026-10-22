package com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config;

import com.ss.android.lark.opmonitor.trace.OPTrace;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J'\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/LocalComponentXLoadConfig;", "", OPTrace.BATCH_DATA_KEY, "", "componentListStr", "componentCount", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "getBatch", "()Ljava/lang/String;", "setBatch", "(Ljava/lang/String;)V", "getComponentCount", "()I", "setComponentCount", "(I)V", "getComponentListStr", "setComponentListStr", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LocalComponentXLoadConfig {
    private String batch;
    private int componentCount;
    private String componentListStr;

    public LocalComponentXLoadConfig() {
        this(null, null, 0, 7, null);
    }

    public static /* synthetic */ LocalComponentXLoadConfig copy$default(LocalComponentXLoadConfig r100, String r101, String r102, int r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.batch;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.componentListStr;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.componentCount;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.batch;
    }

    public final String component2() {
        return this.componentListStr;
    }

    public final int component3() {
        return this.componentCount;
    }

    public final LocalComponentXLoadConfig copy(String r100, String r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, OPTrace.BATCH_DATA_KEY);
        Intrinsics.checkNotNullParameter(r101, "componentListStr");
        return new LocalComponentXLoadConfig(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof LocalComponentXLoadConfig) == false) goto L12;
        LocalComponentXLoadConfig r101 = (LocalComponentXLoadConfig) r100;
        if (Intrinsics.areEqual(this.batch, r101.batch) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.componentListStr, r101.componentListStr) == true) goto L10;
        return false;
    L10:
        if (this.componentCount == r101.componentCount) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        String r100 = this.batch;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.componentListStr;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return ((r103 + r101) * 31) + this.componentCount;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "LocalComponentXLoadConfig(batch=" + this.batch + ", componentListStr=" + this.componentListStr + ", componentCount=" + this.componentCount + ")";
    }

    public final String getBatch() {
        return this.batch;
    }

    public final int getComponentCount() {
        return this.componentCount;
    }

    public final String getComponentListStr() {
        return this.componentListStr;
    }

    public final void setBatch(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.batch = r100;
    }

    public final void setComponentCount(int r100) {
        this.componentCount = r100;
    }

    public final void setComponentListStr(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.componentListStr = r100;
    }

    public LocalComponentXLoadConfig(String r100, String r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, OPTrace.BATCH_DATA_KEY);
        Intrinsics.checkNotNullParameter(r101, "componentListStr");
        this.batch = r100;
        this.componentListStr = r101;
        this.componentCount = r102;
    }

    public /* synthetic */ LocalComponentXLoadConfig(String r100, String r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = "";
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = 0;
    L11:
        this(r100, r101, r102);
    }
}
