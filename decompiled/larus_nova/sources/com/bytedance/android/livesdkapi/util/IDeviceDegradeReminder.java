package com.bytedance.android.livesdkapi.util;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/util/IDeviceDegradeReminder;", "", "Companion", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IDeviceDegradeReminder {
    public static final String ANIMATION_BANNER = "animation_banner";
    public static final String ANIMATION_BARRAGE = "animation_barrage";
    public static final String ANIMATION_DIGG = "animation_digg";
    public static final String ANIMATION_GIFT_PANEL = "animation_gift_panel";
    public static final String ANIMATION_GIFT_TRAY = "animation_gift_tray";
    public static final String ANIMATION_LONG_TOUCH = "animation_long_touch";
    public static final String ANIMATION_MERGE_MESSAGE = "animation_merge_message";
    public static final String ANIMATION_RANK = "animation_rank";
    public static final String ANIMATION_SHORT_TOUCH_FIRST = "animation_short_touch_first";
    public static final String ANIMATION_TOOLBAR = "animation_toolbar";
    public static final Companion Companion = null;
    public static final String STRATEGY_CANCEL = "strategy_cancel";
    public static final String STRATEGY_DELAY_LIFECYCLE = "strategy_delay_lifecycle";
    public static final String STRATEGY_DELAY_TIME = "strategy_delay_time";
    public static final String WIDGET_BANNER = "widget_banner";
    public static final String WIDGET_BARRAGE = "widget_barrage";
    public static final String WIDGET_BIG_GIFT = "widget_big_gift";
    public static final String WIDGET_GIFT_TRAY = "widget_gift_tray";
    public static final String WIDGET_LINK = "widget_link";
    public static final String WIDGET_LONG_TOUCH = "widget_long_touch";
    public static final String WIDGET_MERGE_MESSAGE = "widget_merge_message";
    public static final String WIDGET_RANK = "widget_rank";
    public static final String WIDGET_VERTICAL_RANK = "widget_vertical_rank";

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0016\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdkapi/util/IDeviceDegradeReminder$Companion;", "", "()V", "ANIMATION_BANNER", "", "ANIMATION_BARRAGE", "ANIMATION_DIGG", "ANIMATION_GIFT_PANEL", "ANIMATION_GIFT_TRAY", "ANIMATION_LONG_TOUCH", "ANIMATION_MERGE_MESSAGE", "ANIMATION_RANK", "ANIMATION_SHORT_TOUCH_FIRST", "ANIMATION_TOOLBAR", "STRATEGY_CANCEL", "STRATEGY_DELAY_LIFECYCLE", "STRATEGY_DELAY_TIME", "WIDGET_BANNER", "WIDGET_BARRAGE", "WIDGET_BIG_GIFT", "WIDGET_GIFT_TRAY", "WIDGET_LINK", "WIDGET_LONG_TOUCH", "WIDGET_MERGE_MESSAGE", "WIDGET_RANK", "WIDGET_VERTICAL_RANK", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        public static final String ANIMATION_BANNER = "animation_banner";
        public static final String ANIMATION_BARRAGE = "animation_barrage";
        public static final String ANIMATION_DIGG = "animation_digg";
        public static final String ANIMATION_GIFT_PANEL = "animation_gift_panel";
        public static final String ANIMATION_GIFT_TRAY = "animation_gift_tray";
        public static final String ANIMATION_LONG_TOUCH = "animation_long_touch";
        public static final String ANIMATION_MERGE_MESSAGE = "animation_merge_message";
        public static final String ANIMATION_RANK = "animation_rank";
        public static final String ANIMATION_SHORT_TOUCH_FIRST = "animation_short_touch_first";
        public static final String ANIMATION_TOOLBAR = "animation_toolbar";
        public static final String STRATEGY_CANCEL = "strategy_cancel";
        public static final String STRATEGY_DELAY_LIFECYCLE = "strategy_delay_lifecycle";
        public static final String STRATEGY_DELAY_TIME = "strategy_delay_time";
        public static final String WIDGET_BANNER = "widget_banner";
        public static final String WIDGET_BARRAGE = "widget_barrage";
        public static final String WIDGET_BIG_GIFT = "widget_big_gift";
        public static final String WIDGET_GIFT_TRAY = "widget_gift_tray";
        public static final String WIDGET_LINK = "widget_link";
        public static final String WIDGET_LONG_TOUCH = "widget_long_touch";
        public static final String WIDGET_MERGE_MESSAGE = "widget_merge_message";
        public static final String WIDGET_RANK = "widget_rank";
        public static final String WIDGET_VERTICAL_RANK = "widget_vertical_rank";

        private Companion() {
        }

        static {
            $$INSTANCE = new Companion();
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }
}
