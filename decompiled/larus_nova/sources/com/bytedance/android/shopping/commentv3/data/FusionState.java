package com.bytedance.android.shopping.commentv3.data;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/commentv3/data/FusionState;", "", "", "type", "I", "getType", "()I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "PRODUCT", "FUSION", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum FusionState extends Enum<FusionState> {
    public static final a Companion = null;
    public static final FusionState FUSION = null;
    public static final FusionState PRODUCT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FusionState[] f172723a = null;
    private final int type;

    public static final class a {
        public a() {
        }
    }

    static {
        FusionState r100 = new FusionState("PRODUCT", 0, 0);
        PRODUCT = r100;
        FusionState r101 = new FusionState("FUSION", 1, 1);
        FUSION = r101;
        f172723a = new FusionState[]{r100, r101};
        Companion = new a();
    }

    public static FusionState valueOf(String r100) {
        return (FusionState) r27.a.a(FusionState.class, r100);
    }

    public static FusionState[] values() {
        return (FusionState[]) f172723a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public FusionState(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
