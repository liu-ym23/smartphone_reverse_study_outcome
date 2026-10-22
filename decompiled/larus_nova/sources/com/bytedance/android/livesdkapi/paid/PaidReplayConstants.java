package com.bytedance.android.livesdkapi.paid;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdkapi/paid/PaidReplayConstants;", "", "()V", "KEY_BUY_TICKET_MODULE_FROM", "", "KEY_FROM_AUTHOR_ID", "KEY_FROM_CONTENT_ID", "KEY_FROM_CONTENT_TYPE", "KEY_PRIVILEGE_TYPE", "KEY_RESOLUTION_FREE_TRIAL", "KEY_RESOLUTION_INFO", "KEY_TICKET_ENTRANCE", "KEY_VS_MACHINE_TYPE", "PAID_REPLAY_LOG_TAG", "VALUE_BUY_TICKET_CAMERA_BUTTON", "VALUE_BUY_TICKET_CAMERA_PLAYER_TIP", "VALUE_FROM_CONTENT_TYPE", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PaidReplayConstants {
    public static final PaidReplayConstants INSTANCE = null;
    public static final String KEY_BUY_TICKET_MODULE_FROM = "buyticket_module_form";
    public static final String KEY_FROM_AUTHOR_ID = "from_author_id";
    public static final String KEY_FROM_CONTENT_ID = "from_content_id";
    public static final String KEY_FROM_CONTENT_TYPE = "from_content_type";
    public static final String KEY_PRIVILEGE_TYPE = "paid_live_type";
    public static final String KEY_RESOLUTION_FREE_TRIAL = "resolution_free_trial";
    public static final String KEY_RESOLUTION_INFO = "resolution_info";
    public static final String KEY_TICKET_ENTRANCE = "ticket_entrance";
    public static final String KEY_VS_MACHINE_TYPE = "vs_machine_type";
    public static final String PAID_REPLAY_LOG_TAG = "PaidReplayLogTag";
    public static final String VALUE_BUY_TICKET_CAMERA_BUTTON = "live_machine_entrance";
    public static final String VALUE_BUY_TICKET_CAMERA_PLAYER_TIP = "live_machine_try_buyticket_bar";
    public static final String VALUE_FROM_CONTENT_TYPE = "live_replay";

    private PaidReplayConstants() {
    }

    static {
        INSTANCE = new PaidReplayConstants();
    }
}
