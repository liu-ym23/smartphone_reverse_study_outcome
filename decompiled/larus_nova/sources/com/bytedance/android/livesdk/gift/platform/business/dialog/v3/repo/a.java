package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/repo/a;", "", "", "source", "Ljava/lang/String;", "getSource", "()Ljava/lang/String;", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("source")
    private final String source;

    public a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "source");
        this.source = r100;
    }
}
