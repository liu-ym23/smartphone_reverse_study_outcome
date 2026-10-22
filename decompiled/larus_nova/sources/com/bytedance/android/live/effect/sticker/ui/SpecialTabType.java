package com.bytedance.android.live.effect.sticker.ui;

import com.bytedance.android.live.core.utils.s1;
import com.larus.nova.R;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/effect/sticker/ui/SpecialTabType;", "", "", "tabName", "Ljava/lang/String;", "getTabName", "()Ljava/lang/String;", "tabKey", "getTabKey", "SEARCH", "FAVORITE", "CAMPAIGN", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum SpecialTabType extends Enum<SpecialTabType> {
    public static final SpecialTabType CAMPAIGN = null;
    public static final SpecialTabType FAVORITE = null;
    public static final SpecialTabType SEARCH = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SpecialTabType[] f68455a = null;
    private final String tabKey;
    private final String tabName;

    static {
        SpecialTabType r100 = new SpecialTabType("SEARCH", 0, s1.B(R.string.ttlive_effect_composer_sticker_tab_search), s1.B(R.string.ttlive_effect_composer_sticker_tab_search_key));
        SEARCH = r100;
        SpecialTabType r101 = new SpecialTabType("FAVORITE", 1, s1.B(R.string.ttlive_effect_favorite_text_normal), s1.B(R.string.ttlive_effect_composer_sticker_tab_favorite_key));
        FAVORITE = r101;
        SpecialTabType r102 = new SpecialTabType("CAMPAIGN", 2, s1.B(R.string.ttlive_effect_composer_sticker_tab_campaign), s1.B(R.string.ttlive_effect_composer_sticker_tab_campaign_key));
        CAMPAIGN = r102;
        f68455a = new SpecialTabType[]{r100, r101, r102};
    }

    public static SpecialTabType valueOf(String r100) {
        return (SpecialTabType) r27.a.a(SpecialTabType.class, r100);
    }

    public static SpecialTabType[] values() {
        return (SpecialTabType[]) f68455a.clone();
    }

    public final String getTabKey() {
        return this.tabKey;
    }

    public final String getTabName() {
        return this.tabName;
    }

    public SpecialTabType(String r100, int r101, String r102, String r103) {
        super(r100, r101);
        this.tabName = r102;
        this.tabKey = r103;
    }
}
