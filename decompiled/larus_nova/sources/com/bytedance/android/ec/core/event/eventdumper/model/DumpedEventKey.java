package com.bytedance.android.ec.core.event.eventdumper.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/ec/core/event/eventdumper/model/DumpedEventKey;", "Ljava/io/Serializable;", "keyName", "", "isDeclared", "", "(Ljava/lang/String;Z)V", "()Z", "setDeclared", "(Z)V", "getKeyName", "()Ljava/lang/String;", "setKeyName", "(Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DumpedEventKey implements Serializable {

    @SerializedName("is_declared")
    private boolean isDeclared;

    @SerializedName("key_name")
    private String keyName;

    /* JADX WARN: Multi-variable type inference failed */
    public DumpedEventKey() {
        String r100 = null;
        this(r100, false, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ DumpedEventKey copy$default(DumpedEventKey r100, String r101, boolean r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.keyName;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.isDeclared;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.keyName;
    }

    public final boolean component2() {
        return this.isDeclared;
    }

    public final DumpedEventKey copy(String r100, boolean r101) {
        return new DumpedEventKey(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof DumpedEventKey) == false) goto L10;
        DumpedEventKey r101 = (DumpedEventKey) r100;
        if (Intrinsics.areEqual(this.keyName, r101.keyName) == true) goto L8;
        return false;
    L8:
        if (this.isDeclared == r101.isDeclared) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public int hashCode() {
        String r100 = this.keyName;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L6:
        int r102 = r101 * 31;
        boolean r103 = this.isDeclared;
        ?? r104 = r103;
        if (r103 == false) goto L10;
        r104 = 1;
    L10:
        return r102 + r104;
    L5:
        r101 = 0;
        goto L6
    }

    public String toString() {
        return "DumpedEventKey(keyName=" + this.keyName + ", isDeclared=" + this.isDeclared + ")";
    }

    public final String getKeyName() {
        return this.keyName;
    }

    public final boolean isDeclared() {
        return this.isDeclared;
    }

    public final void setDeclared(boolean r100) {
        this.isDeclared = r100;
    }

    public final void setKeyName(String r100) {
        this.keyName = r100;
    }

    public DumpedEventKey(String r100, boolean r101) {
        this.keyName = r100;
        this.isDeclared = r101;
    }

    public /* synthetic */ DumpedEventKey(String r100, boolean r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = false;
    L8:
        this(r100, r101);
    }
}
