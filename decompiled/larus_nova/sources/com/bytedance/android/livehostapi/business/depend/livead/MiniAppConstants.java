package com.bytedance.android.livehostapi.business.depend.livead;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tb1.c;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0013B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/livead/MiniAppConstants;", "", "()V", "KEY_MINI_APP_LIVE_ROOM_ID", "", "KEY_MINI_APP_LIVE_URL", "KEY_MINI_APP_LIVE_USER_AVATAR", "KEY_MINI_APP_LIVE_USER_NAME", "KEY_MINI_APP_STREAM_DATA", "STAMP_MESSAGE_TYPE_MINI_APP", "", "searchStamp", "stampCheckAuthList", "stampDelete", "stampInfo", "stampSaveUrl", "stampSelectionUrl", "stampSensitiveCheck", "stampStatusUpdate", "Scene", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MiniAppConstants {
    public static final MiniAppConstants INSTANCE = null;
    public static final String KEY_MINI_APP_LIVE_ROOM_ID = "live_room_id";
    public static final String KEY_MINI_APP_LIVE_URL = "live_url";
    public static final String KEY_MINI_APP_LIVE_USER_AVATAR = "live_user_avatar";
    public static final String KEY_MINI_APP_LIVE_USER_NAME = "live_user_name";
    public static final String KEY_MINI_APP_STREAM_DATA = "stream_data";
    public static final int STAMP_MESSAGE_TYPE_MINI_APP = 4;
    public static final String searchStamp = "/webcast/stamp/search/";
    public static final String stampCheckAuthList = "/aweme/v1/microapp/webcast/auth/";
    public static final String stampDelete = "/webcast/stamp/delete/";
    public static final String stampInfo = "/webcast/stamp/info/";
    public static final String stampSaveUrl = "/webcast/stamp/save/";
    public static final String stampSelectionUrl = "/webcast/stamp/selection/";
    public static final String stampSensitiveCheck = "/webcast/stamp/check/";
    public static final String stampStatusUpdate = "/webcast/stamp/status/update/";

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/livead/MiniAppConstants$Scene;", "", "()V", "AUDIENCE_IN_LIVE", "", "getAUDIENCE_IN_LIVE", "()Ljava/lang/String;", "setAUDIENCE_IN_LIVE", "(Ljava/lang/String;)V", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Scene {
        private static String AUDIENCE_IN_LIVE;
        public static final Scene INSTANCE = null;

        private Scene() {
        }

        static {
            INSTANCE = new Scene();
            if (c.f545231c == false) goto L5;
            String r100 = "103010";
        L6:
            AUDIENCE_IN_LIVE = r100;
            return;
        L5:
            r100 = "023010";
            goto L6
        }

        public final String getAUDIENCE_IN_LIVE() {
            return AUDIENCE_IN_LIVE;
        }

        public final void setAUDIENCE_IN_LIVE(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            AUDIENCE_IN_LIVE = r100;
        }
    }

    private MiniAppConstants() {
    }

    static {
        INSTANCE = new MiniAppConstants();
    }
}
