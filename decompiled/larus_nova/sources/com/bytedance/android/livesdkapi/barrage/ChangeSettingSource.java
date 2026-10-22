package com.bytedance.android.livesdkapi.barrage;

import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0004\u001a\u00020\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdkapi/barrage/ChangeSettingSource;", "", SocialConstants.PARAM_APP_DESC, "", "isBaseSetting", "", "(Ljava/lang/String;ILjava/lang/String;Z)V", "getDesc", "()Ljava/lang/String;", "PREVIEW_LONG_PRESS_PANEL", "SETTING_PANEL_RESET", "SETTING_PANEL_CLOSE", "SETTING_PANEL_LINE", "SETTING_PANEL_ALPHA", "SETTING_PANEL_SPEED", "SETTING_PANEL_FONT_SIZE", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ChangeSettingSource extends Enum<ChangeSettingSource> {
    private static final /* synthetic */ ChangeSettingSource[] $VALUES = null;
    public static final ChangeSettingSource PREVIEW_LONG_PRESS_PANEL = null;
    public static final ChangeSettingSource SETTING_PANEL_ALPHA = null;
    public static final ChangeSettingSource SETTING_PANEL_CLOSE = null;
    public static final ChangeSettingSource SETTING_PANEL_FONT_SIZE = null;
    public static final ChangeSettingSource SETTING_PANEL_LINE = null;
    public static final ChangeSettingSource SETTING_PANEL_RESET = null;
    public static final ChangeSettingSource SETTING_PANEL_SPEED = null;
    private final String desc;
    private final boolean isBaseSetting;

    static {
        ChangeSettingSource r100 = new ChangeSettingSource("PREVIEW_LONG_PRESS_PANEL", 0, "预览流长按面板打开", false);
        PREVIEW_LONG_PRESS_PANEL = r100;
        ChangeSettingSource r101 = new ChangeSettingSource("SETTING_PANEL_RESET", 1, "设置面板重置", false);
        SETTING_PANEL_RESET = r101;
        ChangeSettingSource r102 = new ChangeSettingSource("SETTING_PANEL_CLOSE", 2, "设置面板关闭", false);
        SETTING_PANEL_CLOSE = r102;
        ChangeSettingSource r103 = new ChangeSettingSource("SETTING_PANEL_LINE", 3, "设置面板显示区域行", true);
        SETTING_PANEL_LINE = r103;
        ChangeSettingSource r104 = new ChangeSettingSource("SETTING_PANEL_ALPHA", 4, "设置面板不透明度", true);
        SETTING_PANEL_ALPHA = r104;
        ChangeSettingSource r105 = new ChangeSettingSource("SETTING_PANEL_SPEED", 5, "设置面板移动速度", true);
        SETTING_PANEL_SPEED = r105;
        ChangeSettingSource r106 = new ChangeSettingSource("SETTING_PANEL_FONT_SIZE", 6, "设置面板字体大小", true);
        SETTING_PANEL_FONT_SIZE = r106;
        $VALUES = new ChangeSettingSource[]{r100, r101, r102, r103, r104, r105, r106};
    }

    public static ChangeSettingSource valueOf(String r100) {
        return (ChangeSettingSource) a.a(ChangeSettingSource.class, r100);
    }

    public static ChangeSettingSource[] values() {
        return (ChangeSettingSource[]) $VALUES.clone();
    }

    public final String getDesc() {
        return this.desc;
    }

    public final boolean isBaseSetting() {
        return this.isBaseSetting;
    }

    private ChangeSettingSource(String r100, int r101, String r102, boolean r103) {
        super(r100, r101);
        this.desc = r102;
        this.isBaseSetting = r103;
    }
}
