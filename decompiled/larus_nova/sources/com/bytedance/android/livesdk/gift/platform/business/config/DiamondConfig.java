package com.bytedance.android.livesdk.gift.platform.business.config;

import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.GiftPanelBizBoostUtils;
import com.bytedance.android.livesdk.utils.r3;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class DiamondConfig {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f126566c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f126567d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final py.k f126568a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f126569b;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static DiamondConfig a() {
            GiftPanelBizBoostUtils.E.getClass();
            if (((Boolean) GiftPanelBizBoostUtils.f127363r.getValue()).booleanValue() == false) goto L7;
            return (DiamondConfig) DiamondConfig.f126566c.getValue();
        L7:
            return new DiamondConfig(r3.a(), r3.c(), r3.b(), "");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DiamondConfig() {
        Object[] r100 = 0 == true ? 1 : 0;
        Object[] r101 = 0 == true ? 1 : 0;
        this(null, r100, r101, 15);
    }

    static {
        f126567d = new a();
        f126566c = LazyKt.lazy(DiamondConfig$Companion$defaultInst$2.INSTANCE);
    }

    public /* synthetic */ DiamondConfig(py.k r100, String r101, String r102, int r103) {
        String r104 = null;
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = "";
    L9:
        if ((r103 & 4) == 0) goto L12;
        r102 = "";
    L12:
        if ((r103 & 8) == 0) goto L14;
        r104 = "";
    L14:
        this(r100, r101, r102, r104);
    }

    public DiamondConfig(py.k r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r101, "diamondSuffix");
        Intrinsics.checkNotNullParameter(r102, "diamondSuffixShort");
        Intrinsics.checkNotNullParameter(r103, "lowerDiamondSuffix");
        this.f126568a = r100;
        this.f126569b = r102;
    }
}
