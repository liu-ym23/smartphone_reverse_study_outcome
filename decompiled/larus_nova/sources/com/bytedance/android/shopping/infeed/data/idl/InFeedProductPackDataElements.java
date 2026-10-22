package com.bytedance.android.shopping.infeed.data.idl;

import com.google.gson.annotations.SerializedName;
import he3.n0;
import he3.p0;
import ie3.a;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B=\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0019\u0010\u001aR\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR$\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/shopping/infeed/data/idl/InFeedProductPackDataElements;", "Ljava/io/Serializable;", "", "Lhe3/p0;", "products", "Ljava/util/List;", "getProducts", "()Ljava/util/List;", "Lhe3/n0;", "sliceCard", "Lhe3/n0;", "getSliceCard", "()Lhe3/n0;", "Lie3/a;", "ad", "Lie3/a;", "getAd", "()Lie3/a;", "setAd", "(Lie3/a;)V", "Lhe3/a;", "author", "Lhe3/a;", "getAuthor", "()Lhe3/a;", "<init>", "(Ljava/util/List;Lhe3/n0;Lie3/a;Lhe3/a;)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InFeedProductPackDataElements implements Serializable {

    /* JADX INFO: renamed from: ad, reason: collision with root package name */
    @SerializedName("ad")
    private a f176229ad;

    @SerializedName("author")
    private final he3.a author;

    @SerializedName("products")
    private final List<p0> products;

    @SerializedName("slice_card")
    private final n0 sliceCard;

    public InFeedProductPackDataElements() {
        this(null, null, null, null, 15, null);
    }

    public final a getAd() {
        return this.f176229ad;
    }

    public final he3.a getAuthor() {
        return this.author;
    }

    public final List<p0> getProducts() {
        return this.products;
    }

    public final n0 getSliceCard() {
        return this.sliceCard;
    }

    public final void setAd(a r100) {
        this.f176229ad = r100;
    }

    public InFeedProductPackDataElements(List<p0> r100, n0 r101, a r102, he3.a r103) {
        this.products = r100;
        this.sliceCard = r101;
        this.f176229ad = r102;
        this.author = r103;
    }

    public /* synthetic */ InFeedProductPackDataElements(List r100, n0 r101, a r102, he3.a r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
