package com.stepos.ailauncher.chat.sheet;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.activity.ChatScene;
import com.stepos.ailauncher.contract.api.homegesture.HomeGestureEligibilityContract;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JO\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/stepos/ailauncher/chat/sheet/b;", "", "<init>", "()V", "Lcom/stepos/ailauncher/chat/activity/ChatScene;", HomeGestureEligibilityContract.EXTRA_SCENE, "", "panelTaskId", "foregroundTaskId", "", "foregroundPackage", "selfPackage", "", "panelIsTaskTop", "recentsIdle", "externalUiCover", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/ailauncher/chat/activity/ChatScene;IILjava/lang/String;Ljava/lang/String;ZZZ)Z", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.chat.sheet.b, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2731b {
    public static final C2731b INSTANCE = new C2731b();

    public final boolean a(ChatScene scene, int panelTaskId, int foregroundTaskId, String foregroundPackage, String selfPackage, boolean panelIsTaskTop, boolean recentsIdle, boolean externalUiCover) {
        kotlin.jvm.internal.p.i(scene, "scene");
        kotlin.jvm.internal.p.i(selfPackage, "selfPackage");
        return ((scene != ChatScene.BOARD && scene != ChatScene.TRANSIENT) || !recentsIdle || externalUiCover || !panelIsTaskTop || panelTaskId <= 0 || foregroundTaskId <= 0 || panelTaskId == foregroundTaskId || foregroundPackage == null || foregroundPackage.length() == 0 || kotlin.jvm.internal.p.d(foregroundPackage, selfPackage) || kotlin.jvm.internal.p.d(foregroundPackage, "com.android.launcher3") || La.D.X(foregroundPackage, "com.android.systemui", false, 2, null)) ? false : true;
    }
}
