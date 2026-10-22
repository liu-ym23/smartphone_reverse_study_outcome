package com.obric.oui.banner;

import kotlin.Metadata;

/* JADX INFO: compiled from: StubViewHolder.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/banner/StubBannerData;", "Lcom/obric/oui/banner/BannerData;", "()V", "holderKey", "", "getHolderKey", "()Ljava/lang/String;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class StubBannerData implements BannerData {
    public StubBannerData() {
    }

    @Override // com.obric.oui.banner.BannerData
    public String getHolderKey() {
        return StubViewHolder.Companion.getKey();
    }
}
