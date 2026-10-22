package com.bytedance.android.ec.core.data;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000bJ&\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/ec/core/data/ParamsWriteConfig;", "Ljava/io/Serializable;", "action", "", "optional", "", "(Ljava/lang/Integer;Ljava/lang/Boolean;)V", "getAction", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getOptional", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/Boolean;)Lcom/bytedance/android/ec/core/data/ParamsWriteConfig;", "equals", "other", "", "hashCode", "toString", "", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ParamsWriteConfig implements Serializable {

    @SerializedName("action")
    private final Integer action;

    @SerializedName("optional")
    private final Boolean optional;

    /* JADX WARN: Multi-variable type inference failed */
    public ParamsWriteConfig() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ ParamsWriteConfig copy$default(ParamsWriteConfig r100, Integer r101, Boolean r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.action;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.optional;
    L9:
        return r100.copy(r101, r102);
    }

    public final Integer component1() {
        return this.action;
    }

    public final Boolean component2() {
        return this.optional;
    }

    public final ParamsWriteConfig copy(Integer r100, Boolean r101) {
        return new ParamsWriteConfig(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ParamsWriteConfig) == false) goto L10;
        ParamsWriteConfig r101 = (ParamsWriteConfig) r100;
        if (Intrinsics.areEqual(this.action, r101.action) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.optional, r101.optional) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        Integer r100 = this.action;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.optional;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "ParamsWriteConfig(action=" + this.action + ", optional=" + this.optional + ")";
    }

    public final Integer getAction() {
        return this.action;
    }

    public final Boolean getOptional() {
        return this.optional;
    }

    public ParamsWriteConfig(Integer r100, Boolean r101) {
        this.action = r100;
        this.optional = r101;
    }

    public /* synthetic */ ParamsWriteConfig(Integer r100, Boolean r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = Boolean.FALSE;
    L8:
        this(r100, r101);
    }
}
