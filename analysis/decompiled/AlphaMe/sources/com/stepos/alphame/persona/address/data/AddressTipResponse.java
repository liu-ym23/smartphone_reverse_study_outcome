package com.stepos.alphame.persona.address.data;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/stepos/alphame/persona/address/data/AddressTipResponse;", "", "code", "", "value", "", "Lcom/stepos/alphame/persona/address/data/AddressTipBean;", "(ILjava/util/List;)V", "getCode", "()I", "getValue", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class AddressTipResponse {
    private final int code;

    @NotNull
    private final List<AddressTipBean> value;

    public AddressTipResponse(int i4, @NotNull List<AddressTipBean> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.code = i4;
        this.value = value;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AddressTipResponse copy$default(AddressTipResponse addressTipResponse, int i4, List list, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i4 = addressTipResponse.code;
        }
        if ((i5 & 2) != 0) {
            list = addressTipResponse.value;
        }
        return addressTipResponse.copy(i4, list);
    }

    /* renamed from: component1, reason: from getter */
    public final int getCode() {
        return this.code;
    }

    @NotNull
    public final List<AddressTipBean> component2() {
        return this.value;
    }

    @NotNull
    public final AddressTipResponse copy(int code, @NotNull List<AddressTipBean> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return new AddressTipResponse(code, value);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AddressTipResponse)) {
            return false;
        }
        AddressTipResponse addressTipResponse = (AddressTipResponse) other;
        return this.code == addressTipResponse.code && Intrinsics.areEqual(this.value, addressTipResponse.value);
    }

    public final int getCode() {
        return this.code;
    }

    @NotNull
    public final List<AddressTipBean> getValue() {
        return this.value;
    }

    public int hashCode() {
        return this.value.hashCode() + (Integer.hashCode(this.code) * 31);
    }

    @NotNull
    public String toString() {
        return "AddressTipResponse(code=" + this.code + ", value=" + this.value + ")";
    }
}
