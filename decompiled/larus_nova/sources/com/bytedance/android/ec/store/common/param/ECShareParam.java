package com.bytedance.android.ec.store.common.param;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.store.aggregate.classification.a;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0000R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/ec/store/common/param/ECShareParam;", "Ljava/io/Serializable;", "()V", "avatarMedium", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getAvatarMedium", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "setAvatarMedium", "(Lcom/bytedance/android/ec/model/ECUrlModel;)V", "nickName", "", "getNickName", "()Ljava/lang/String;", "setNickName", "(Ljava/lang/String;)V", "shopLogo", "getShopLogo", "setShopLogo", "shopName", "getShopName", "setShopName", "copyFrom", "", "other", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECShareParam implements Serializable {
    private ECUrlModel avatarMedium;
    private String nickName;
    private ECUrlModel shopLogo;
    private String shopName;

    public ECShareParam() {
    }

    public final ECUrlModel getAvatarMedium() {
        return this.avatarMedium;
    }

    public final String getNickName() {
        return this.nickName;
    }

    public final ECUrlModel getShopLogo() {
        return this.shopLogo;
    }

    public final String getShopName() {
        return this.shopName;
    }

    public final void copyFrom(ECShareParam r100) {
        Intrinsics.checkNotNullParameter(r100, "other");
        ECUrlModel r101 = r100.avatarMedium;
        ECUrlModel r102 = null;
        if (r101 == null) goto L5;
        ECUrlModel r103 = a.a(r101);
    L6:
        this.avatarMedium = r103;
        ECUrlModel r104 = r100.shopLogo;
        if (r104 == null) goto L9;
        r102 = a.a(r104);
    L9:
        this.shopLogo = r102;
        this.shopName = r100.shopName;
        this.nickName = r100.nickName;
        return;
    L5:
        r103 = null;
        goto L6
    }

    public final void setAvatarMedium(ECUrlModel r100) {
        this.avatarMedium = r100;
    }

    public final void setNickName(String r100) {
        this.nickName = r100;
    }

    public final void setShopLogo(ECUrlModel r100) {
        this.shopLogo = r100;
    }

    public final void setShopName(String r100) {
        this.shopName = r100;
    }
}
