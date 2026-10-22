package com.bytedance.android.ec.common.api;

import com.ss.texturerender.TextureRenderKeys;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/ec/common/api/NewPromotionListItemModuleName;", "", "", TextureRenderKeys.KEY_MODULE_NAME, "Ljava/lang/String;", "getModuleName", "()Ljava/lang/String;", "INFO_AREA", "BOTTOM_AREA", "EXPLAIN_PLAYBACK_OR_REQUEST_EXPLAIN_INFO", "ec-common-api_release"}, k = 1, mv = {1, 4, 3})
public final enum NewPromotionListItemModuleName extends Enum<NewPromotionListItemModuleName> {
    public static final NewPromotionListItemModuleName BOTTOM_AREA = null;
    public static final NewPromotionListItemModuleName EXPLAIN_PLAYBACK_OR_REQUEST_EXPLAIN_INFO = null;
    public static final NewPromotionListItemModuleName INFO_AREA = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ NewPromotionListItemModuleName[] f42822a = null;
    private final String moduleName;

    static {
        NewPromotionListItemModuleName r100 = new NewPromotionListItemModuleName("INFO_AREA", 0, "InfoArea");
        INFO_AREA = r100;
        NewPromotionListItemModuleName r101 = new NewPromotionListItemModuleName("BOTTOM_AREA", 1, "BottomArea");
        BOTTOM_AREA = r101;
        NewPromotionListItemModuleName r102 = new NewPromotionListItemModuleName("EXPLAIN_PLAYBACK_OR_REQUEST_EXPLAIN_INFO", 2, "ExplainPlaybackOrRequestExplainInfo");
        EXPLAIN_PLAYBACK_OR_REQUEST_EXPLAIN_INFO = r102;
        f42822a = new NewPromotionListItemModuleName[]{r100, r101, r102};
    }

    public static NewPromotionListItemModuleName valueOf(String r100) {
        return (NewPromotionListItemModuleName) a.a(NewPromotionListItemModuleName.class, r100);
    }

    public static NewPromotionListItemModuleName[] values() {
        return (NewPromotionListItemModuleName[]) f42822a.clone();
    }

    public final String getModuleName() {
        return this.moduleName;
    }

    public NewPromotionListItemModuleName(String r100, int r101, String r102) {
        super(r100, r101);
        this.moduleName = r102;
    }
}
