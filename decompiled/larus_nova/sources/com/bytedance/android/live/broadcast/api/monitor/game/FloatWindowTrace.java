package com.bytedance.android.live.broadcast.api.monitor.game;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import d00.a;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes45.dex */
public final class FloatWindowTrace extends a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final HashMap<String, Boolean> f59064i = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/monitor/game/FloatWindowTrace$Step;", "", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Step {
        public static final String CLICK_FLOAT_BALL = "game_float_window_click_float_ball";
        public static final String CLICK_FLOAT_MSG = "game_float_window_click_float_msg";
        public static final String CLICK_MENU_ITEM = "game_float_window_click_menu_item";
        public static final a Companion = null;
        public static final String DRAG_FLOAT_BALL = "game_float_window_drag_float_ball";
        public static final String DRAG_FLOAT_WINDOW = "game_float_window_drag_float_window";
        public static final String FLOAT_PERMISSION = "game_float_window_float_permission";
        public static final String SHOW_FLOAT_MSG = "game_float_window_show_float_msg";
        public static final String SHOW_FLOAT_WINDOW = "game_float_window_show_float_window";
        public static final String WINDOW_CAPTURE_FILTER = "game_float_window_window_capture_filter";
        public static final String WINDOW_GAME_CP_ACTION = "game_float_window_window_game_cp_action";
        public static final String WINDOW_MESSAGE_FILTER = "game_float_window_window_message_filter";
        public static final String WINDOW_SAFE_BORDER = "game_float_window_window_safe_border";

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f59065a = null;

            public a() {
            }

            static {
                f59065a = new a();
            }
        }

        static {
            Companion = a.f59065a;
        }
    }

    @Override // d00.a
    public final String c() {
        return GameLiveModule.FLOAT_WINDOW;
    }

    static {
        Boolean r100 = Boolean.FALSE;
        f59064i = MapsKt.hashMapOf(new Pair[]{TuplesKt.to(Step.SHOW_FLOAT_WINDOW, r100), TuplesKt.to(Step.DRAG_FLOAT_WINDOW, r100), TuplesKt.to(Step.CLICK_FLOAT_BALL, r100), TuplesKt.to(Step.DRAG_FLOAT_BALL, r100)});
    }
}
