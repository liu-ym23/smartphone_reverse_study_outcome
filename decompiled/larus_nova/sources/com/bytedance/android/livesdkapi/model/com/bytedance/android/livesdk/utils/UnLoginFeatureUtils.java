package com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.utils;

import android.text.TextUtils;
import com.bytedance.android.livesdk.c8;
import com.bytedance.android.livesdk.config.cn0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u0010\u0010\u000b\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u0010\u0010\f\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/utils/UnLoginFeatureUtils;", "", "()V", "KEY_BAN_USER_CARD_WHEN_UNLOGIN", "", "KEY_BAN_USER_LIST_WHEN_UNLOGIN", "KEY_RESTART_LIVE_WHEN_LOGIN", "disableUserCardWhenUnLogin", "", "room", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "disableUserListWhenUnLogin", "restartWhenLogin", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UnLoginFeatureUtils {
    public static final UnLoginFeatureUtils INSTANCE = null;
    private static final String KEY_BAN_USER_CARD_WHEN_UNLOGIN = "live_anchor_ban_user_card_when_unlogin";
    private static final String KEY_BAN_USER_LIST_WHEN_UNLOGIN = "live_anchor_ban_user_list_when_unlogin";
    private static final String KEY_RESTART_LIVE_WHEN_LOGIN = "live_anchor_restart_live_when_login";

    private UnLoginFeatureUtils() {
    }

    static {
        INSTANCE = new UnLoginFeatureUtils();
    }

    public final boolean disableUserCardWhenUnLogin(IRoom r100) {
        if (c8.f104417a.getValue().booleanValue() == true) goto L11;
        if (r100 == null) goto L6;
        String r101 = r100.getAnchorAbValue(KEY_BAN_USER_CARD_WHEN_UNLOGIN);
    L8:
        if (TextUtils.equals(r101, "true") == true) goto L11;
        return false;
    L6:
        r101 = null;
    L11:
        return true;
    }

    public final boolean disableUserListWhenUnLogin(IRoom r100) {
        if (r100 == null) goto L4;
        String r101 = r100.getAnchorAbValue(KEY_BAN_USER_LIST_WHEN_UNLOGIN);
    L6:
        return TextUtils.equals(r101, "true");
    L4:
        r101 = null;
        goto L6
    }

    public final boolean restartWhenLogin(IRoom r100) {
        if (r100 == null) goto L4;
        String r101 = r100.getAnchorAbValue(KEY_RESTART_LIVE_WHEN_LOGIN);
    L6:
        if (TextUtils.equals(r101, "true") == true) goto L8;
    L10:
        return false;
    L8:
        if (cn0.f119966a.getValue().booleanValue() == false) goto L10;
        return true;
    L4:
        r101 = null;
        goto L6
    }
}
