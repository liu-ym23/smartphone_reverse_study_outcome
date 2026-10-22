package com.obric.capabilitykit.version;

import androidx.annotation.Keep;
import com.bytedanceos.common.model.AppInfo;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0011\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0000H\u0096\u0002J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\r\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/obric/capabilitykit/version/EntityVersionData;", "", "selfVersion", "", "appEntityVersion", "(II)V", "getAppEntityVersion", "()I", "setAppEntityVersion", "(I)V", "getSelfVersion", "setSelfVersion", "compareTo", AppInfo.SEARCH_SOURCE_EXTENAL, "component1", "component2", "copy", "equals", "", "", "hashCode", "toString", "", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class EntityVersionData implements Comparable<EntityVersionData> {

    @SerializedName("appEntityVersion")
    private int appEntityVersion;

    @SerializedName("selfVersion")
    private int selfVersion;

    public EntityVersionData() {
        int r10 = 0;
        this(r10, r10, 3, null);
    }

    public static /* synthetic */ EntityVersionData copy$default(EntityVersionData r10, int r11, int r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = r10.selfVersion;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r12 = r10.appEntityVersion;
    L9:
        return r10.copy(r11, r12);
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(@NotNull EntityVersionData r10) {
        q.g(r10, AppInfo.SEARCH_SOURCE_EXTENAL);
        int r11 = q.i(this.appEntityVersion, r10.appEntityVersion);
        if (r11 <= 0) goto L6;
        return r11;
    L6:
        return q.i(this.selfVersion, r10.selfVersion);
    }

    public final int component1() {
        return this.selfVersion;
    }

    public final int component2() {
        return this.appEntityVersion;
    }

    @NotNull
    public final EntityVersionData copy(int r10, int r11) {
        return new EntityVersionData(r10, r11);
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof EntityVersionData) == true) goto L8;
        return false;
    L8:
        EntityVersionData r11 = (EntityVersionData) r10;
        if (this.selfVersion == r11.selfVersion) goto L12;
        return false;
    L12:
        if (this.appEntityVersion == r11.appEntityVersion) goto L14;
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

    public final void setAppEntityVersion(int r10) {
        this.appEntityVersion = r10;
    }

    public final void setSelfVersion(int r10) {
        this.selfVersion = r10;
    }

    @NotNull
    public String toString() {
        return "EntityVersionData(selfVersion=" + this.selfVersion + ", appEntityVersion=" + this.appEntityVersion + ')';
    }

    public EntityVersionData(int r10, int r11) {
        this.selfVersion = r10;
        this.appEntityVersion = r11;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(EntityVersionData r10) {
        return compareTo2(r10);
    }

    public /* synthetic */ EntityVersionData(int r10, int r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L6;
        r10 = -1;
    L6:
        if ((r12 & 2) == 0) goto L8;
        r11 = -1;
    L8:
        this(r10, r11);
    }
}
