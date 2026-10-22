package com.bytedance.android.livesdkapi.distribution.config;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B+\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdkapi/distribution/config/ComponentConfig;", "Lcom/bytedance/android/livesdkapi/distribution/config/BaseCommonConfig;", "enable", "", "shieldMode", "Lcom/bytedance/android/livesdkapi/distribution/config/ShieldMode;", "whiteOrBlackList", "", "", "(ZLcom/bytedance/android/livesdkapi/distribution/config/ShieldMode;Ljava/util/List;)V", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ComponentConfig extends BaseCommonConfig {
    public ComponentConfig() {
        this(false, null, null, 7, null);
    }

    public ComponentConfig(boolean r100, ShieldMode r101, List<String> r102) {
        Intrinsics.checkNotNullParameter(r101, "shieldMode");
        super(r100, r101, r102);
    }

    public /* synthetic */ ComponentConfig(boolean r100, ShieldMode r101, List r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = true;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = ShieldMode.NONE;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
