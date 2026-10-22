package com.android.ttcjpaysdk.kmp.common.view.lynx;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J3\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/common/view/lynx/CJLynxCardViewParams;", "", "schema", "", "initData", "globalProps", "useAnnieXCard", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getSchema", "()Ljava/lang/String;", "getInitData", "getGlobalProps", "getUseAnnieXCard", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "cj_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CJLynxCardViewParams {
    public static final int $stable = 0;
    private final String globalProps;
    private final String initData;
    private final String schema;
    private final boolean useAnnieXCard;

    public static /* synthetic */ CJLynxCardViewParams copy$default(CJLynxCardViewParams r100, String r101, String r102, String r103, boolean r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.schema;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.initData;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.globalProps;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.useAnnieXCard;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.schema;
    }

    public final String component2() {
        return this.initData;
    }

    public final String component3() {
        return this.globalProps;
    }

    public final boolean component4() {
        return this.useAnnieXCard;
    }

    public final CJLynxCardViewParams copy(String r100, String r101, String r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        Intrinsics.checkNotNullParameter(r101, "initData");
        return new CJLynxCardViewParams(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CJLynxCardViewParams) == true) goto L8;
        return false;
    L8:
        CJLynxCardViewParams r101 = (CJLynxCardViewParams) r100;
        if (Intrinsics.areEqual(this.schema, r101.schema) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.initData, r101.initData) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.globalProps, r101.globalProps) == true) goto L18;
        return false;
    L18:
        if (this.useAnnieXCard == r101.useAnnieXCard) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r100 = ((this.schema.hashCode() * 31) + this.initData.hashCode()) * 31;
        String r101 = this.globalProps;
        if (r101 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.useAnnieXCard == false) goto L9;
        int r104 = 1231;
    L11:
        return r103 + r104;
    L9:
        r104 = 1237;
        goto L11
    L5:
        r102 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "CJLynxCardViewParams(schema=" + this.schema + ", initData=" + this.initData + ", globalProps=" + this.globalProps + ", useAnnieXCard=" + this.useAnnieXCard + ')';
    }

    public final String getGlobalProps() {
        return this.globalProps;
    }

    public final String getInitData() {
        return this.initData;
    }

    public final String getSchema() {
        return this.schema;
    }

    public final boolean getUseAnnieXCard() {
        return this.useAnnieXCard;
    }

    public CJLynxCardViewParams(String r100, String r101, String r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        Intrinsics.checkNotNullParameter(r101, "initData");
        this.schema = r100;
        this.initData = r101;
        this.globalProps = r102;
        this.useAnnieXCard = r103;
    }

    public /* synthetic */ CJLynxCardViewParams(String r100, String r101, String r102, boolean r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 4) == 0) goto L6;
        r102 = null;
    L6:
        if ((r104 & 8) == 0) goto L8;
        r103 = false;
    L8:
        this(r100, r101, r102, r103);
    }
}
