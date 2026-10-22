package com.stepos.ailauncher.taskstore.livenotification;

import Ua.C1060i;
import Ua.L0;
import Ua.Y;
import android.content.Context;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/stepos/ailauncher/taskstore/livenotification/ArtifactExposureNotificationCanceller;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "taskId", "reason", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "TAG", "Ljava/lang/String;", "LUa/M;", "scope", "LUa/M;", "", "handled", "Ljava/util/Set;", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArtifactExposureNotificationCanceller {
    private static final String TAG = "TaskLiveNotification";
    private static final Set<String> handled;
    public static final ArtifactExposureNotificationCanceller INSTANCE = new ArtifactExposureNotificationCanceller();
    private static final Ua.M scope = kotlinx.coroutines.d.a(L0.b(null, 1, null).plus(Y.b()));

    static {
        ConcurrentHashMap.KeySetView keySetViewNewKeySet = ConcurrentHashMap.newKeySet();
        kotlin.jvm.internal.p.h(keySetViewNewKeySet, "newKeySet(...)");
        handled = keySetViewNewKeySet;
    }

    public final void b(Context context, String taskId, String reason) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(taskId, "taskId");
        kotlin.jvm.internal.p.i(reason, "reason");
        if (La.H.x0(taskId) || handled.contains(taskId)) {
            return;
        }
        C1060i.d(scope, null, null, new ArtifactExposureNotificationCanceller$onArtifactExposed$1(taskId, reason, context.getApplicationContext(), null), 3, null);
    }
}
