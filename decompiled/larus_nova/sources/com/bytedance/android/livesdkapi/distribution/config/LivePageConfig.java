package com.bytedance.android.livesdkapi.distribution.config;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B=\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdkapi/distribution/config/LivePageConfig;", "Lcom/bytedance/android/livesdkapi/distribution/config/BaseCommonConfig;", "enable", "", "shieldMode", "Lcom/bytedance/android/livesdkapi/distribution/config/ShieldMode;", "whiteOrBlackList", "", "", "exitAction", "Lkotlin/Function0;", "", "(ZLcom/bytedance/android/livesdkapi/distribution/config/ShieldMode;Ljava/util/List;Lkotlin/jvm/functions/Function0;)V", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LivePageConfig extends BaseCommonConfig {
    public LivePageConfig() {
        this(false, null, null, null, 15, null);
    }

    public LivePageConfig(boolean r100, ShieldMode r101, List<String> r102, Function0<Unit> r103) {
        Intrinsics.checkNotNullParameter(r101, "shieldMode");
        super(r100, r101, r102);
    }

    public /* synthetic */ LivePageConfig(boolean r100, ShieldMode r101, List r102, Function0 r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = true;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = ShieldMode.NONE;
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
