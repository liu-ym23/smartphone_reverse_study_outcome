package com.android.ttcjpaysdk.base.h5.cjjsb.contacts;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J-\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/contacts/LocalContact;", "", "name", "", "phoneNumbers", "", "indexLetter", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getIndexLetter", "()Ljava/lang/String;", "getName", "getPhoneNumbers", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LocalContact {
    private final String indexLetter;
    private final String name;
    private final List<String> phoneNumbers;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LocalContact copy$default(LocalContact r100, String r101, List r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.name;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.phoneNumbers;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.indexLetter;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.name;
    }

    public final List<String> component2() {
        return this.phoneNumbers;
    }

    public final String component3() {
        return this.indexLetter;
    }

    public final LocalContact copy(String r100, List<String> r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "phoneNumbers");
        Intrinsics.checkNotNullParameter(r102, "indexLetter");
        return new LocalContact(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof LocalContact) == true) goto L8;
        return false;
    L8:
        LocalContact r101 = (LocalContact) r100;
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.phoneNumbers, r101.phoneNumbers) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.indexLetter, r101.indexLetter) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.name.hashCode() * 31) + this.phoneNumbers.hashCode()) * 31) + this.indexLetter.hashCode();
    }

    public String toString() {
        return "LocalContact(name=" + this.name + ", phoneNumbers=" + this.phoneNumbers + ", indexLetter=" + this.indexLetter + ')';
    }

    public final String getIndexLetter() {
        return this.indexLetter;
    }

    public final String getName() {
        return this.name;
    }

    public final List<String> getPhoneNumbers() {
        return this.phoneNumbers;
    }

    public LocalContact(String r100, List<String> r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "phoneNumbers");
        Intrinsics.checkNotNullParameter(r102, "indexLetter");
        this.name = r100;
        this.phoneNumbers = r101;
        this.indexLetter = r102;
    }
}
