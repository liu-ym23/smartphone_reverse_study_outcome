package com.bytedance.android.live.liveinteract.plantform.utils;

import com.bytedance.android.livesdk.logger.PanelType;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/utils/OpenPanelSource;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "LINK_SETTING_PANEL", "LINK_INTERACT_PANEL_TAB", "USE_RECENTLY", "INTERACTION_BUTTON", "APPLY_PANEL", "LINK_PLAYMODE_PANEL", "PK_ICON", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum OpenPanelSource extends Enum<OpenPanelSource> {
    public static final OpenPanelSource APPLY_PANEL = null;
    public static final OpenPanelSource INTERACTION_BUTTON = null;
    public static final OpenPanelSource LINK_INTERACT_PANEL_TAB = null;
    public static final OpenPanelSource LINK_PLAYMODE_PANEL = null;
    public static final OpenPanelSource LINK_SETTING_PANEL = null;
    public static final OpenPanelSource PK_ICON = null;
    public static final OpenPanelSource USE_RECENTLY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OpenPanelSource[] f77430a = null;
    private final String value;

    static {
        OpenPanelSource r100 = new OpenPanelSource("LINK_SETTING_PANEL", 0, "link_setting_panel");
        LINK_SETTING_PANEL = r100;
        OpenPanelSource r101 = new OpenPanelSource("LINK_INTERACT_PANEL_TAB", 1, "link_interact_panel_tab");
        LINK_INTERACT_PANEL_TAB = r101;
        OpenPanelSource r102 = new OpenPanelSource("USE_RECENTLY", 2, "use_recently");
        USE_RECENTLY = r102;
        OpenPanelSource r103 = new OpenPanelSource("INTERACTION_BUTTON", 3, "interaction_button");
        INTERACTION_BUTTON = r103;
        OpenPanelSource r104 = new OpenPanelSource("APPLY_PANEL", 4, PanelType.APPLY_PANEL);
        APPLY_PANEL = r104;
        OpenPanelSource r105 = new OpenPanelSource("LINK_PLAYMODE_PANEL", 5, "link_playmode_panel");
        LINK_PLAYMODE_PANEL = r105;
        OpenPanelSource r106 = new OpenPanelSource("PK_ICON", 6, "pk_icon");
        PK_ICON = r106;
        f77430a = new OpenPanelSource[]{r100, r101, r102, r103, r104, r105, r106};
    }

    public static OpenPanelSource valueOf(String r100) {
        return (OpenPanelSource) r27.a.a(OpenPanelSource.class, r100);
    }

    public static OpenPanelSource[] values() {
        return (OpenPanelSource[]) f77430a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public OpenPanelSource(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
