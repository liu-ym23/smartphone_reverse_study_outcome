package com.bytedance.android.livesdkapi.service;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceLookup;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@ServiceLookup("com.bytedance.android.livesdk.performance.LiveFloatWindowDegradeManager")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u0000 \u000b2\u00020\u00012\u00020\u0002:\u0001\u000bJ\b\u0010\u0003\u001a\u00020\u0004H&J\u001a\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdkapi/service/IFloatWindowDegradeManager;", "Lcom/bytedance/android/live/base/IService;", "Lcom/bytedance/android/livesdkapi/service/IMiddleWareWindowDegradeManager;", "clear", "", "registerDegradeTask", "degradeFlag", "", "degradeTask", "Lcom/bytedance/android/livesdkapi/service/IDegradeTask;", "unregisterDegradeTask", "Companion", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IFloatWindowDegradeManager extends IService, IMiddleWareWindowDegradeManager {
    public static final Companion Companion = null;
    public static final String NATIVE_KEY_ANCHOR_INVITE = "anchor_invite_panel";
    public static final String NATIVE_KEY_ANCHOR_LINK_INVITE = "anchor_link_invite_panel";
    public static final String NATIVE_KEY_ANCHOR_LINK_MAIN = "anchor_link_main_panel";
    public static final String NATIVE_KEY_GIFT_MAIN = "gift_panel";
    public static final String NATIVE_KEY_INTERACT = "interact_panel";
    public static final String NATIVE_KEY_MORE = "more_panel";
    public static final String NATIVE_KEY_PROFILE = "profile_parallax";
    public static final String NATIVE_KEY_RECHARGE = "recharge_panel";
    public static final String NATIVE_KEY_RIGHT_DRAWER = "right_drawer";

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdkapi/service/IFloatWindowDegradeManager$Companion;", "", "()V", "NATIVE_KEY_ANCHOR_INVITE", "", "NATIVE_KEY_ANCHOR_LINK_INVITE", "NATIVE_KEY_ANCHOR_LINK_MAIN", "NATIVE_KEY_GIFT_MAIN", "NATIVE_KEY_INTERACT", "NATIVE_KEY_MORE", "NATIVE_KEY_PROFILE", "NATIVE_KEY_RECHARGE", "NATIVE_KEY_RIGHT_DRAWER", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        public static final String NATIVE_KEY_ANCHOR_INVITE = "anchor_invite_panel";
        public static final String NATIVE_KEY_ANCHOR_LINK_INVITE = "anchor_link_invite_panel";
        public static final String NATIVE_KEY_ANCHOR_LINK_MAIN = "anchor_link_main_panel";
        public static final String NATIVE_KEY_GIFT_MAIN = "gift_panel";
        public static final String NATIVE_KEY_INTERACT = "interact_panel";
        public static final String NATIVE_KEY_MORE = "more_panel";
        public static final String NATIVE_KEY_PROFILE = "profile_parallax";
        public static final String NATIVE_KEY_RECHARGE = "recharge_panel";
        public static final String NATIVE_KEY_RIGHT_DRAWER = "right_drawer";

        private Companion() {
        }

        static {
            $$INSTANCE = new Companion();
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    void clear();

    void registerDegradeTask(@IMiddleWareWindowDegradeManager.DegradeFlag int r100, IDegradeTask r101);

    void unregisterDegradeTask(int r100);
}
