package com.stepos.ailauncher.chat.input.camera;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.sheet.T;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\b\u001a\u00020\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\b\u0010\tJ-\u0010\u000e\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0007¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00108\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00108\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/stepos/ailauncher/chat/input/camera/a;", "", "<init>", "()V", "", "topPackage", "topActivityClassName", "", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Ljava/lang/String;)Z", "interruptedByPermissionUi", "alreadyRetried", "cancelledFromHome", "sessionActive", Const.INTENT_KEY_PKGNAME, "(ZZZZ)Z", "", "RETRY_DELAY_MS", "J", "TOP_RESAMPLE_DELAY_MS", "SELECTOR_CAMERA_EMPTY_ACTIVITY", "Ljava/lang/String;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class a {
    public static final a INSTANCE = new a();
    public static final long RETRY_DELAY_MS = 300;
    public static final String SELECTOR_CAMERA_EMPTY_ACTIVITY = "com.zyql.ai.selector.PictureSelectorCameraEmptyActivity";
    public static final long TOP_RESAMPLE_DELAY_MS = 150;

    public final boolean a(String topPackage, String topActivityClassName) {
        if (p.d(topPackage, T.PKG_PERMISSION_CONTROLLER)) {
            return true;
        }
        return T.INSTANCE.d(topActivityClassName);
    }

    public final boolean b(boolean interruptedByPermissionUi, boolean alreadyRetried, boolean cancelledFromHome, boolean sessionActive) {
        if (!interruptedByPermissionUi || alreadyRetried || cancelledFromHome) {
            return false;
        }
        return sessionActive;
    }
}
