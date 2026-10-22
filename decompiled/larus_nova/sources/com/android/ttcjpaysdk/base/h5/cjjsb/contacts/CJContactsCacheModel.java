package com.android.ttcjpaysdk.base.h5.cjjsb.contacts;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J#\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/contacts/CJContactsCacheModel;", "", "name", "", "phoneNumberList", "", "(Ljava/lang/String;Ljava/util/List;)V", "getName", "()Ljava/lang/String;", "getPhoneNumberList", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJContactsCacheModel {
    private final String name;
    private final List<String> phoneNumberList;

    /* JADX WARN: Multi-variable type inference failed */
    public CJContactsCacheModel() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CJContactsCacheModel copy$default(CJContactsCacheModel r100, String r101, List r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.name;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.phoneNumberList;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.name;
    }

    public final List<String> component2() {
        return this.phoneNumberList;
    }

    public final CJContactsCacheModel copy(String r100, List<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "phoneNumberList");
        return new CJContactsCacheModel(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CJContactsCacheModel) == true) goto L8;
        return false;
    L8:
        CJContactsCacheModel r101 = (CJContactsCacheModel) r100;
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.phoneNumberList, r101.phoneNumberList) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.name.hashCode() * 31) + this.phoneNumberList.hashCode();
    }

    public String toString() {
        return "CJContactsCacheModel(name=" + this.name + ", phoneNumberList=" + this.phoneNumberList + ')';
    }

    public final String getName() {
        return this.name;
    }

    public final List<String> getPhoneNumberList() {
        return this.phoneNumberList;
    }

    public CJContactsCacheModel(String r100, List<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "phoneNumberList");
        this.name = r100;
        this.phoneNumberList = r101;
    }

    public /* synthetic */ CJContactsCacheModel(String r100, List r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = CollectionsKt.emptyList();
    L8:
        this(r100, r101);
    }
}
