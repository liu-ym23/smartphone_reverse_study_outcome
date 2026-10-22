package com.android.ttcjpaysdk.kmp.common.view.page.protocol;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/common/view/page/protocol/ProtocolPageState;", "", "agreements", "", "Lcom/android/ttcjpaysdk/kmp/common/view/page/protocol/UserAgreement;", "<init>", "(Ljava/util/List;)V", "getAgreements", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "cj_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ProtocolPageState {
    public static final int $stable = 8;
    private final List<UserAgreement> agreements;

    /* JADX WARN: Multi-variable type inference failed */
    public ProtocolPageState() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ProtocolPageState copy$default(ProtocolPageState r100, List r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.agreements;
    L6:
        return r100.copy(r101);
    }

    public final List<UserAgreement> component1() {
        return this.agreements;
    }

    public final ProtocolPageState copy(List<UserAgreement> r100) {
        Intrinsics.checkNotNullParameter(r100, "agreements");
        return new ProtocolPageState(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ProtocolPageState) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.agreements, ((ProtocolPageState) r100).agreements) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.agreements.hashCode();
    }

    public String toString() {
        return "ProtocolPageState(agreements=" + this.agreements + ')';
    }

    public final List<UserAgreement> getAgreements() {
        return this.agreements;
    }

    public ProtocolPageState(List<UserAgreement> r100) {
        Intrinsics.checkNotNullParameter(r100, "agreements");
        this.agreements = r100;
    }

    public /* synthetic */ ProtocolPageState(List r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = CollectionsKt.emptyList();
    L5:
        this(r100);
    }
}
