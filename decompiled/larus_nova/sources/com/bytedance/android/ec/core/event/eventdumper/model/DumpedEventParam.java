package com.bytedance.android.ec.core.event.eventdumper.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003J+\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R \u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/ec/core/event/eventdumper/model/DumpedEventParam;", "Ljava/io/Serializable;", "paramValue", "", "isFromEventContext", "", "eventContextClassInfo", "Lcom/bytedance/android/ec/core/event/eventdumper/model/ClassInfo;", "(Ljava/lang/String;ZLcom/bytedance/android/ec/core/event/eventdumper/model/ClassInfo;)V", "getEventContextClassInfo", "()Lcom/bytedance/android/ec/core/event/eventdumper/model/ClassInfo;", "setEventContextClassInfo", "(Lcom/bytedance/android/ec/core/event/eventdumper/model/ClassInfo;)V", "()Z", "setFromEventContext", "(Z)V", "getParamValue", "()Ljava/lang/String;", "setParamValue", "(Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DumpedEventParam implements Serializable {

    @SerializedName("event_context_class_info")
    private ClassInfo eventContextClassInfo;

    @SerializedName("is_from_context")
    private boolean isFromEventContext;

    @SerializedName("param_value")
    private String paramValue;

    public DumpedEventParam() {
        this(null, false, null, 7, null);
    }

    public static /* synthetic */ DumpedEventParam copy$default(DumpedEventParam r100, String r101, boolean r102, ClassInfo r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.paramValue;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.isFromEventContext;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.eventContextClassInfo;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.paramValue;
    }

    public final boolean component2() {
        return this.isFromEventContext;
    }

    public final ClassInfo component3() {
        return this.eventContextClassInfo;
    }

    public final DumpedEventParam copy(String r100, boolean r101, ClassInfo r102) {
        return new DumpedEventParam(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof DumpedEventParam) == false) goto L12;
        DumpedEventParam r101 = (DumpedEventParam) r100;
        if (Intrinsics.areEqual(this.paramValue, r101.paramValue) == true) goto L8;
        return false;
    L8:
        if (this.isFromEventContext == r101.isFromEventContext) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.eventContextClassInfo, r101.eventContextClassInfo) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    public int hashCode() {
        String r100 = this.paramValue;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        boolean r104 = this.isFromEventContext;
        ?? r105 = r104;
        if (r104 == false) goto L9;
        r105 = 1;
    L9:
        int r106 = (r103 + r105) * 31;
        ClassInfo r107 = this.eventContextClassInfo;
        if (r107 == null) goto L13;
        r101 = r107.hashCode();
    L13:
        return r106 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "DumpedEventParam(paramValue=" + this.paramValue + ", isFromEventContext=" + this.isFromEventContext + ", eventContextClassInfo=" + this.eventContextClassInfo + ")";
    }

    public final ClassInfo getEventContextClassInfo() {
        return this.eventContextClassInfo;
    }

    public final String getParamValue() {
        return this.paramValue;
    }

    public final boolean isFromEventContext() {
        return this.isFromEventContext;
    }

    public final void setEventContextClassInfo(ClassInfo r100) {
        this.eventContextClassInfo = r100;
    }

    public final void setFromEventContext(boolean r100) {
        this.isFromEventContext = r100;
    }

    public final void setParamValue(String r100) {
        this.paramValue = r100;
    }

    public DumpedEventParam(String r100, boolean r101, ClassInfo r102) {
        this.paramValue = r100;
        this.isFromEventContext = r101;
        this.eventContextClassInfo = r102;
    }

    public /* synthetic */ DumpedEventParam(String r100, boolean r101, ClassInfo r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = false;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
