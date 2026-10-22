package com.android.ttcjpaysdk.kmp.common.ui.overlay;

import androidx.exifinterface.media.ExifInterface;
import com.ss.android.downloadlib.constants.ComplianceConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0004HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\bHÆ\u0003J3\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/common/ui/overlay/CJOverlayRoute;", ExifInterface.GPS_DIRECTION_TRUE, "", "name", "", ComplianceConstants.ComplianceRequest.MARKET_STORE, "Lcom/android/ttcjpaysdk/kmp/common/ui/overlay/CJOverlayEntryStore;", "defaultMask", "Lcom/android/ttcjpaysdk/kmp/common/ui/overlay/CJOverlayMask;", "<init>", "(Ljava/lang/String;Lcom/android/ttcjpaysdk/kmp/common/ui/overlay/CJOverlayEntryStore;Lcom/android/ttcjpaysdk/kmp/common/ui/overlay/CJOverlayMask;)V", "getName", "()Ljava/lang/String;", "getStore", "()Lcom/android/ttcjpaysdk/kmp/common/ui/overlay/CJOverlayEntryStore;", "getDefaultMask", "()Lcom/android/ttcjpaysdk/kmp/common/ui/overlay/CJOverlayMask;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "cj_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CJOverlayRoute<T> {
    public static final int $stable = 8;
    private final CJOverlayMask defaultMask;
    private final String name;
    private final CJOverlayEntryStore<T> store;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CJOverlayRoute copy$default(CJOverlayRoute r100, String r101, CJOverlayEntryStore r102, CJOverlayMask r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.name;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.store;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.defaultMask;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.name;
    }

    public final CJOverlayEntryStore<T> component2() {
        return this.store;
    }

    public final CJOverlayMask component3() {
        return this.defaultMask;
    }

    public final CJOverlayRoute<T> copy(String r100, CJOverlayEntryStore<T> r101, CJOverlayMask r102) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, ComplianceConstants.ComplianceRequest.MARKET_STORE);
        Intrinsics.checkNotNullParameter(r102, "defaultMask");
        return new CJOverlayRoute(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CJOverlayRoute) == true) goto L8;
        return false;
    L8:
        CJOverlayRoute r101 = (CJOverlayRoute) r100;
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.store, r101.store) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.defaultMask, r101.defaultMask) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.name.hashCode() * 31) + this.store.hashCode()) * 31) + this.defaultMask.hashCode();
    }

    public String toString() {
        return "CJOverlayRoute(name=" + this.name + ", store=" + this.store + ", defaultMask=" + this.defaultMask + ')';
    }

    public final CJOverlayMask getDefaultMask() {
        return this.defaultMask;
    }

    public final String getName() {
        return this.name;
    }

    public final CJOverlayEntryStore<T> getStore() {
        return this.store;
    }

    public CJOverlayRoute(String r100, CJOverlayEntryStore<T> r101, CJOverlayMask r102) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, ComplianceConstants.ComplianceRequest.MARKET_STORE);
        Intrinsics.checkNotNullParameter(r102, "defaultMask");
        this.name = r100;
        this.store = r101;
        this.defaultMask = r102;
    }

    public /* synthetic */ CJOverlayRoute(String r100, CJOverlayEntryStore r101, CJOverlayMask r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 4) == 0) goto L5;
        r102 = new CJOverlayMask(null, 0, 3, null);
    L5:
        this(r100, r101, r102);
    }
}
