package com.bytedance.android.livesdkapi.model;

import com.larus.dora.api.model.FlowDoraWifiScene;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/DisplayMode;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "INITIAL", "PREVIEW", "INNER", "PREVIEW_PREPLAY", "INNER_PREPLAY", "BACKGROUND_WATCHING", "SMALL_WINDOW", FlowDoraWifiScene.OTHER, "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum DisplayMode extends Enum<DisplayMode> {
    private static final /* synthetic */ DisplayMode[] $VALUES = null;
    public static final DisplayMode BACKGROUND_WATCHING = null;
    public static final DisplayMode INITIAL = null;
    public static final DisplayMode INNER = null;
    public static final DisplayMode INNER_PREPLAY = null;
    public static final DisplayMode OTHER = null;
    public static final DisplayMode PREVIEW = null;
    public static final DisplayMode PREVIEW_PREPLAY = null;
    public static final DisplayMode SMALL_WINDOW = null;
    private final String value;

    public static DisplayMode valueOf(String r100) {
        return (DisplayMode) a.a(DisplayMode.class, r100);
    }

    public static DisplayMode[] values() {
        return (DisplayMode[]) $VALUES.clone();
    }

    static {
        DisplayMode r100 = new DisplayMode("INITIAL", 0, "display_model_inital");
        INITIAL = r100;
        DisplayMode r101 = new DisplayMode("PREVIEW", 1, "display_model_preview");
        PREVIEW = r101;
        DisplayMode r102 = new DisplayMode("INNER", 2, "display_model_inner");
        INNER = r102;
        DisplayMode r103 = new DisplayMode("PREVIEW_PREPLAY", 3, "display_model_preview_preplay");
        PREVIEW_PREPLAY = r103;
        DisplayMode r104 = new DisplayMode("INNER_PREPLAY", 4, "display_model_inner_preplay");
        INNER_PREPLAY = r104;
        DisplayMode r105 = new DisplayMode("BACKGROUND_WATCHING", 5, "display_model_background_watching");
        BACKGROUND_WATCHING = r105;
        DisplayMode r106 = new DisplayMode("SMALL_WINDOW", 6, "display_model_small_window");
        SMALL_WINDOW = r106;
        DisplayMode r107 = new DisplayMode(FlowDoraWifiScene.OTHER, 7, "display_model_other");
        OTHER = r107;
        $VALUES = new DisplayMode[]{r100, r101, r102, r103, r104, r105, r106, r107};
    }

    public final String getValue() {
        return this.value;
    }

    private DisplayMode(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
