package com.bytedance.android.livehostapi.business.depend.elder;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/elder/LiveElderModeConfig;", "", "()V", "enableEditResources", "", "getEnableEditResources", "()Z", "setEnableEditResources", "(Z)V", "enableElderMode", "getEnableElderMode", "setEnableElderMode", "enableSpUnit", "getEnableSpUnit", "setEnableSpUnit", "fontScale", "Lcom/bytedance/android/livehostapi/business/depend/elder/LiveElderModeConfig$FontScale;", "getFontScale", "()Lcom/bytedance/android/livehostapi/business/depend/elder/LiveElderModeConfig$FontScale;", "setFontScale", "(Lcom/bytedance/android/livehostapi/business/depend/elder/LiveElderModeConfig$FontScale;)V", "toString", "", "FontScale", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LiveElderModeConfig {

    @SerializedName("live_enable_edit_resources")
    private boolean enableEditResources;

    @SerializedName("live_enable_elder_mode")
    private boolean enableElderMode;

    @SerializedName("live_enable_sp_unit")
    private boolean enableSpUnit;

    @SerializedName("live_elder_mode_font_scale")
    private FontScale fontScale;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/elder/LiveElderModeConfig$FontScale;", "", "(Ljava/lang/String;I)V", "FONT_SCALE_BY_RESOURCE", "FONT_SCALE_NORMAL", "FONT_SCALE_LARGE_115", "FONT_SCALE_LARGE_125", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum FontScale extends Enum<FontScale> {
        private static final /* synthetic */ FontScale[] $VALUES = null;
        public static final FontScale FONT_SCALE_BY_RESOURCE = null;
        public static final FontScale FONT_SCALE_LARGE_115 = null;
        public static final FontScale FONT_SCALE_LARGE_125 = null;
        public static final FontScale FONT_SCALE_NORMAL = null;

        static {
            FontScale r100 = new FontScale("FONT_SCALE_BY_RESOURCE", 0);
            FONT_SCALE_BY_RESOURCE = r100;
            FontScale r101 = new FontScale("FONT_SCALE_NORMAL", 1);
            FONT_SCALE_NORMAL = r101;
            FontScale r102 = new FontScale("FONT_SCALE_LARGE_115", 2);
            FONT_SCALE_LARGE_115 = r102;
            FontScale r103 = new FontScale("FONT_SCALE_LARGE_125", 3);
            FONT_SCALE_LARGE_125 = r103;
            $VALUES = new FontScale[]{r100, r101, r102, r103};
        }

        public static FontScale valueOf(String r100) {
            return (FontScale) a.a(FontScale.class, r100);
        }

        public static FontScale[] values() {
            return (FontScale[]) $VALUES.clone();
        }

        private FontScale(String r100, int r101) {
            super(r100, r101);
        }
    }

    public String toString() {
        return "LiveElderModeConfig(enableEditResources=" + this.enableEditResources + ", enableElderMode=" + this.enableElderMode + ", enableSpUnit=" + this.enableSpUnit + ')';
    }

    public LiveElderModeConfig() {
        this.fontScale = FontScale.FONT_SCALE_BY_RESOURCE;
    }

    public final boolean getEnableEditResources() {
        return this.enableEditResources;
    }

    public final boolean getEnableElderMode() {
        return this.enableElderMode;
    }

    public final boolean getEnableSpUnit() {
        return this.enableSpUnit;
    }

    public final FontScale getFontScale() {
        return this.fontScale;
    }

    public final void setEnableEditResources(boolean r100) {
        this.enableEditResources = r100;
    }

    public final void setEnableElderMode(boolean r100) {
        this.enableElderMode = r100;
    }

    public final void setEnableSpUnit(boolean r100) {
        this.enableSpUnit = r100;
    }

    public final void setFontScale(FontScale r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.fontScale = r100;
    }
}
