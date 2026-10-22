package com.obric.capabilitykit.common;

import androidx.annotation.Keep;
import com.bytedanceos.common.model.AppInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\bHÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\bHÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/obric/capabilitykit/common/Parameter;", "", "name", "", "desc", "is_required", "", "type", "", "(Ljava/lang/String;Ljava/lang/String;ZI)V", "getDesc", "()Ljava/lang/String;", "()Z", "getName", "getType", "()I", "component1", "component2", "component3", "component4", "copy", "equals", AppInfo.SEARCH_SOURCE_EXTENAL, "hashCode", "toString", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class Parameter {

    @NotNull
    private final String desc;
    private final boolean is_required;

    @NotNull
    private final String name;
    private final int type;

    public Parameter(@NotNull String r10, @NotNull String r11, boolean r12, int r13) {
        kotlin.jvm.internal.q.g(r10, "name");
        kotlin.jvm.internal.q.g(r11, "desc");
        this.name = r10;
        this.desc = r11;
        this.is_required = r12;
        this.type = r13;
    }

    public static /* synthetic */ Parameter copy$default(Parameter r10, String r11, String r12, boolean r13, int r14, int r15, Object r16) {
        if ((r15 & 1) == 0) goto L6;
        r11 = r10.name;
    L6:
        if ((r15 & 2) == 0) goto L9;
        r12 = r10.desc;
    L9:
        if ((r15 & 4) == 0) goto L12;
        r13 = r10.is_required;
    L12:
        if ((r15 & 8) == 0) goto L15;
        r14 = r10.type;
    L15:
        return r10.copy(r11, r12, r13, r14);
    }

    @NotNull
    public final String component1() {
        return this.name;
    }

    @NotNull
    public final String component2() {
        return this.desc;
    }

    public final boolean component3() {
        return this.is_required;
    }

    public final int component4() {
        return this.type;
    }

    @NotNull
    public final Parameter copy(@NotNull String r10, @NotNull String r11, boolean r12, int r13) {
        kotlin.jvm.internal.q.g(r10, "name");
        kotlin.jvm.internal.q.g(r11, "desc");
        return new Parameter(r10, r11, r12, r13);
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof Parameter) == true) goto L8;
        return false;
    L8:
        Parameter r11 = (Parameter) r10;
        if (kotlin.jvm.internal.q.b(this.name, r11.name) == true) goto L12;
        return false;
    L12:
        if (kotlin.jvm.internal.q.b(this.desc, r11.desc) == true) goto L15;
        return false;
    L15:
        if (this.is_required == r11.is_required) goto L18;
        return false;
    L18:
        if (this.type == r11.type) goto L20;
        return false;
    L20:
        return true;
    }

    @NotNull
    public final String getDesc() {
        return this.desc;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    public final int getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    public int hashCode() {
        int r10 = ((this.name.hashCode() * 31) + this.desc.hashCode()) * 31;
        boolean r11 = this.is_required;
        ?? r12 = r11;
        if (r11 == false) goto L6;
        r12 = 1;
    L6:
        return ((r10 + r12) * 31) + Integer.hashCode(this.type);
    }

    public final boolean is_required() {
        return this.is_required;
    }

    @NotNull
    public String toString() {
        return "Parameter(name=" + this.name + ", desc=" + this.desc + ", is_required=" + this.is_required + ", type=" + this.type + ')';
    }

    public /* synthetic */ Parameter(String r10, String r11, boolean r12, int r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 4) == 0) goto L6;
        r12 = false;
    L6:
        if ((r14 & 8) == 0) goto L8;
        r13 = 1;
    L8:
        this(r10, r11, r12, r13);
    }
}
