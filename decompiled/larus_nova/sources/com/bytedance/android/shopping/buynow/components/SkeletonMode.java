package com.bytedance.android.shopping.buynow.components;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/shopping/buynow/components/SkeletonMode;", "", EffectConstants.NORMAL, "ULTIMATE", "ONLY_PAY", "CONTINUE_PAY", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum SkeletonMode extends Enum<SkeletonMode> {
    public static final SkeletonMode CONTINUE_PAY = null;
    public static final SkeletonMode NORMAL = null;
    public static final SkeletonMode ONLY_PAY = null;
    public static final SkeletonMode ULTIMATE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SkeletonMode[] f170728a = null;

    static {
        SkeletonMode r100 = new SkeletonMode(EffectConstants.NORMAL, 0);
        NORMAL = r100;
        SkeletonMode r101 = new SkeletonMode("ULTIMATE", 1);
        ULTIMATE = r101;
        SkeletonMode r102 = new SkeletonMode("ONLY_PAY", 2);
        ONLY_PAY = r102;
        SkeletonMode r103 = new SkeletonMode("CONTINUE_PAY", 3);
        CONTINUE_PAY = r103;
        f170728a = new SkeletonMode[]{r100, r101, r102, r103};
    }

    public static SkeletonMode valueOf(String r100) {
        return (SkeletonMode) a.a(SkeletonMode.class, r100);
    }

    public static SkeletonMode[] values() {
        return (SkeletonMode[]) f170728a.clone();
    }

    public SkeletonMode(String r100, int r101) {
        super(r100, r101);
    }
}
