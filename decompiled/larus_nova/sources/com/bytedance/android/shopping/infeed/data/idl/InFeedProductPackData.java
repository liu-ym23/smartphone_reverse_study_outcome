package com.bytedance.android.shopping.infeed.data.idl;

import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/shopping/infeed/data/idl/InFeedProductPackData;", "Ljava/io/Serializable;", SlcElement.KEY_ELEMENTS, "Lcom/bytedance/android/shopping/infeed/data/idl/InFeedProductPackDataElements;", "(Lcom/bytedance/android/shopping/infeed/data/idl/InFeedProductPackDataElements;)V", "getElements", "()Lcom/bytedance/android/shopping/infeed/data/idl/InFeedProductPackDataElements;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InFeedProductPackData implements Serializable {

    @SerializedName(SlcElement.KEY_ELEMENTS)
    private final InFeedProductPackDataElements elements;

    /* JADX WARN: Multi-variable type inference failed */
    public InFeedProductPackData() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final InFeedProductPackDataElements getElements() {
        return this.elements;
    }

    public InFeedProductPackData(InFeedProductPackDataElements r100) {
        this.elements = r100;
    }

    public /* synthetic */ InFeedProductPackData(InFeedProductPackDataElements r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
