package com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.method.data;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/method/data/CJUnifyMethodGroupFoldBean;", "", "groupType", "", "foldDesc", "folded", "", "(Ljava/lang/String;Ljava/lang/String;Z)V", "getFoldDesc", "()Ljava/lang/String;", "getFolded", "()Z", "setFolded", "(Z)V", "getGroupType", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJUnifyMethodGroupFoldBean {
    private final String foldDesc;
    private boolean folded;
    private final String groupType;

    public static /* synthetic */ CJUnifyMethodGroupFoldBean copy$default(CJUnifyMethodGroupFoldBean r100, String r101, String r102, boolean r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.groupType;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.foldDesc;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.folded;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.groupType;
    }

    public final String component2() {
        return this.foldDesc;
    }

    public final boolean component3() {
        return this.folded;
    }

    public final CJUnifyMethodGroupFoldBean copy(String r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "groupType");
        Intrinsics.checkNotNullParameter(r101, "foldDesc");
        return new CJUnifyMethodGroupFoldBean(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CJUnifyMethodGroupFoldBean) == true) goto L8;
        return false;
    L8:
        CJUnifyMethodGroupFoldBean r101 = (CJUnifyMethodGroupFoldBean) r100;
        if (Intrinsics.areEqual(this.groupType, r101.groupType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.foldDesc, r101.foldDesc) == true) goto L15;
        return false;
    L15:
        if (this.folded == r101.folded) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r100 = ((this.groupType.hashCode() * 31) + this.foldDesc.hashCode()) * 31;
        if (this.folded == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public String toString() {
        return "CJUnifyMethodGroupFoldBean(groupType=" + this.groupType + ", foldDesc=" + this.foldDesc + ", folded=" + this.folded + ')';
    }

    public final String getFoldDesc() {
        return this.foldDesc;
    }

    public final boolean getFolded() {
        return this.folded;
    }

    public final String getGroupType() {
        return this.groupType;
    }

    public final void setFolded(boolean r100) {
        this.folded = r100;
    }

    public CJUnifyMethodGroupFoldBean(String r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "groupType");
        Intrinsics.checkNotNullParameter(r101, "foldDesc");
        this.groupType = r100;
        this.foldDesc = r101;
        this.folded = r102;
    }

    public /* synthetic */ CJUnifyMethodGroupFoldBean(String r100, String r101, boolean r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 4) == 0) goto L5;
        r102 = true;
    L5:
        this(r100, r101, r102);
    }
}
