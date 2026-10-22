package com.android.ttcjpaysdk.integrated.counter.fragment;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/counter/fragment/BindCardParamsData;", "", "lynxBindCardSchema", "", "bindCardInfo", "Lorg/json/JSONObject;", "(Ljava/lang/String;Lorg/json/JSONObject;)V", "getBindCardInfo", "()Lorg/json/JSONObject;", "getLynxBindCardSchema", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "integrated-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BindCardParamsData {
    private final JSONObject bindCardInfo;
    private final String lynxBindCardSchema;

    /* JADX WARN: Multi-variable type inference failed */
    public BindCardParamsData() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ BindCardParamsData copy$default(BindCardParamsData r100, String r101, JSONObject r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.lynxBindCardSchema;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.bindCardInfo;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.lynxBindCardSchema;
    }

    public final JSONObject component2() {
        return this.bindCardInfo;
    }

    public final BindCardParamsData copy(String r100, JSONObject r101) {
        return new BindCardParamsData(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof BindCardParamsData) == true) goto L8;
        return false;
    L8:
        BindCardParamsData r101 = (BindCardParamsData) r100;
        if (Intrinsics.areEqual(this.lynxBindCardSchema, r101.lynxBindCardSchema) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.bindCardInfo, r101.bindCardInfo) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        String r100 = this.lynxBindCardSchema;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        JSONObject r104 = this.bindCardInfo;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "BindCardParamsData(lynxBindCardSchema=" + this.lynxBindCardSchema + ", bindCardInfo=" + this.bindCardInfo + ')';
    }

    public final JSONObject getBindCardInfo() {
        return this.bindCardInfo;
    }

    public final String getLynxBindCardSchema() {
        return this.lynxBindCardSchema;
    }

    public BindCardParamsData(String r100, JSONObject r101) {
        this.lynxBindCardSchema = r100;
        this.bindCardInfo = r101;
    }

    public /* synthetic */ BindCardParamsData(String r100, JSONObject r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
