package com.bytedance.android.shopping.abscontainer.arch.core.starter;

import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/abscontainer/arch/core/starter/OpenType;", "", FeatureConfigInfo.PUSH_FEATURE_TYPE_ID, "PRESENT", "ADD_CHILD", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum OpenType extends Enum<OpenType> {
    public static final OpenType ADD_CHILD = null;
    public static final OpenType PRESENT = null;
    public static final OpenType PUSH = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OpenType[] f164148a = null;

    static {
        OpenType r100 = new OpenType(FeatureConfigInfo.PUSH_FEATURE_TYPE_ID, 0);
        PUSH = r100;
        OpenType r101 = new OpenType("PRESENT", 1);
        PRESENT = r101;
        OpenType r102 = new OpenType("ADD_CHILD", 2);
        ADD_CHILD = r102;
        f164148a = new OpenType[]{r100, r101, r102};
    }

    public static OpenType valueOf(String r100) {
        return (OpenType) r27.a.a(OpenType.class, r100);
    }

    public static OpenType[] values() {
        return (OpenType[]) f164148a.clone();
    }

    public OpenType(String r100, int r101) {
        super(r100, r101);
    }
}
