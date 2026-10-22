package com.stepos.ailauncher.container.wallpaper;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\u0007J\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000bJ5\u0010\u0012\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\t¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/stepos/ailauncher/container/wallpaper/g;", "", "<init>", "()V", "", "flags", "c", "(I)I", Const.INTENT_KEY_UMID, "", Const.INTENT_KEY_APIKEY, "(I)Z", "", "panelRatio", "latchClose", "pendingCloseEnd", "closingTowardLauncher", "hideCommitted", Const.INTENT_KEY_PKGNAME, "(FFZZZ)Z", "container_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class g {
    public static final g INSTANCE = new g();

    public final boolean a(int flags) {
        return (1048576 & flags) != 0;
    }

    public final boolean b(float panelRatio, float latchClose, boolean pendingCloseEnd, boolean closingTowardLauncher, boolean hideCommitted) {
        if (hideCommitted && panelRatio <= latchClose) {
            return pendingCloseEnd || closingTowardLauncher;
        }
        return false;
    }

    public final int c(int flags) {
        return 1048576 | flags;
    }

    public final int d(int flags) {
        return (-1048577) & flags;
    }
}
