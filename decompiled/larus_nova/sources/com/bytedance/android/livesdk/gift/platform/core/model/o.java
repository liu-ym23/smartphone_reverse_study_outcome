package com.bytedance.android.livesdk.gift.platform.core.model;

import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.livesdk.gift.model.h1;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\"\u0010\u000e\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\u0011R$\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\t\u001a\u0004\b\u001a\u0010\u000b¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/core/model/o;", "", "", "giftId", "J", "b", "()J", "", "price", "I", "d", "()I", "index", "c", "forceInsert", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setForceInsert", "(I)V", "", "sortExtra", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "f", "(Ljava/lang/String;)V", "pageType", "getPageType", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f130919a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f130920b;

    @SerializedName("force_insert")
    private int forceInsert;

    @SerializedName("id")
    private final long giftId;

    @SerializedName("index")
    private final int index;

    @SerializedName("page_type")
    private final int pageType;

    @SerializedName("price")
    private final int price;

    @SerializedName("sort_extra")
    private String sortExtra;

    public final int a() {
        return this.forceInsert;
    }

    public final long b() {
        return this.giftId;
    }

    public final int c() {
        return this.index;
    }

    public final int d() {
        return this.price;
    }

    public final String e() {
        return this.sortExtra;
    }

    public final void f(String r100) {
        this.sortExtra = r100;
    }

    public final void g(int r100) {
        this.forceInsert = r100;
    }

    public o(h1 r100, int r101, long r102, int r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, PbRequest.SwitchType.GIFT);
        long r105 = r100.getId();
        int r106 = r100.getDiamondCount();
        String r107 = r100.getSortExtra();
        this.giftId = r105;
        this.price = r106;
        this.index = r101;
        this.forceInsert = 0;
        this.sortExtra = r107;
        this.pageType = r103;
        this.f130919a = r104;
        this.f130920b = r102;
    }
}
