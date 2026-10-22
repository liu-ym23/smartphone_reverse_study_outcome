package com.stepos.ailauncher.taskstore.livenotification;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/stepos/ailauncher/taskstore/livenotification/o;", "", "<init>", "()V", "", "foregroundRiskSession", "islandFallback", Const.INTENT_KEY_APIKEY, "(ZZ)Z", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.taskstore.livenotification.o, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3727o {
    public static final C3727o INSTANCE = new C3727o();

    public final boolean a(boolean foregroundRiskSession, boolean islandFallback) {
        return foregroundRiskSession && !islandFallback;
    }
}
