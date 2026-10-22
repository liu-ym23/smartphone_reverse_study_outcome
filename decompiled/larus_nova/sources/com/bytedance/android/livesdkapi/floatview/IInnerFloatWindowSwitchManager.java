package com.bytedance.android.livesdkapi.floatview;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001:\u0001\u0010J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\f\u001a\u00020\u0003H&J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdkapi/floatview/IInnerFloatWindowSwitchManager;", "", "canShowSwitch", "", "switchType", "Lcom/bytedance/android/livesdkapi/floatview/IInnerFloatWindowSwitchManager$LiveFloatWindowSwitchType;", "enableSwitch", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "enable", "hasPermission", "isGlobalSwitchOpen", "isSwitchEnable", "requestPermission", "showPartSceneWindowDialog", "LiveFloatWindowSwitchType", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IInnerFloatWindowSwitchManager {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdkapi/floatview/IInnerFloatWindowSwitchManager$LiveFloatWindowSwitchType;", "", "type", "", "(Ljava/lang/String;ILjava/lang/String;)V", "KEEP_VOICE", "BG_WINDOW_SWITCH", "PART_SCENE_WINDOW_SWITCH", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum LiveFloatWindowSwitchType extends Enum<LiveFloatWindowSwitchType> {
        private static final /* synthetic */ LiveFloatWindowSwitchType[] $VALUES = null;
        public static final LiveFloatWindowSwitchType BG_WINDOW_SWITCH = null;
        public static final LiveFloatWindowSwitchType KEEP_VOICE = null;
        public static final LiveFloatWindowSwitchType PART_SCENE_WINDOW_SWITCH = null;

        static {
            LiveFloatWindowSwitchType r100 = new LiveFloatWindowSwitchType("KEEP_VOICE", 0, "KEEP_VOICE");
            KEEP_VOICE = r100;
            LiveFloatWindowSwitchType r101 = new LiveFloatWindowSwitchType("BG_WINDOW_SWITCH", 1, "BG_WINDOW_SWITCH");
            BG_WINDOW_SWITCH = r101;
            LiveFloatWindowSwitchType r102 = new LiveFloatWindowSwitchType("PART_SCENE_WINDOW_SWITCH", 2, "PART_SCENE_WINDOW_SWITCH");
            PART_SCENE_WINDOW_SWITCH = r102;
            $VALUES = new LiveFloatWindowSwitchType[]{r100, r101, r102};
        }

        public static LiveFloatWindowSwitchType valueOf(String r100) {
            return (LiveFloatWindowSwitchType) a.a(LiveFloatWindowSwitchType.class, r100);
        }

        public static LiveFloatWindowSwitchType[] values() {
            return (LiveFloatWindowSwitchType[]) $VALUES.clone();
        }

        private LiveFloatWindowSwitchType(String r100, int r101, String r102) {
            super(r100, r101);
        }
    }

    boolean canShowSwitch(LiveFloatWindowSwitchType r100);

    void enableSwitch(Context r100, boolean r101, LiveFloatWindowSwitchType r102);

    boolean hasPermission(Context r100, LiveFloatWindowSwitchType r101);

    boolean isGlobalSwitchOpen();

    boolean isSwitchEnable(Context r100, LiveFloatWindowSwitchType r101);

    boolean requestPermission(Context r100, LiveFloatWindowSwitchType r101);

    void showPartSceneWindowDialog(Context r100);
}
