package com.stepos.ailauncher.screenshot;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\nR\u0014\u0010\u0010\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\nR\u0014\u0010\u0011\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\n¨\u0006\u0012"}, d2 = {"Lcom/stepos/ailauncher/screenshot/f;", "", "<init>", "()V", "", "status", "", Const.INTENT_KEY_PKGNAME, "(I)Ljava/lang/String;", "currentStatus", "I", Const.INTENT_KEY_APIKEY, "()I", "c", "(I)V", "STATUS_ALLOWED", "STATUS_DENIED", "STATUS_REQUESTING", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class f {
    public static final f INSTANCE = new f();
    public static final int STATUS_ALLOWED = 1;
    public static final int STATUS_DENIED = 2;
    public static final int STATUS_REQUESTING = 3;
    private static int currentStatus;

    public final int a() {
        return currentStatus;
    }

    public final String b(int status) {
        if (status == 1) {
            return "ALLOWED";
        }
        if (status == 2) {
            return "DENIED";
        }
        if (status == 3) {
            return "REQUESTING";
        }
        return "UNKNOWN(" + status + ")";
    }

    public final void c(int i10) {
        currentStatus = i10;
    }
}
