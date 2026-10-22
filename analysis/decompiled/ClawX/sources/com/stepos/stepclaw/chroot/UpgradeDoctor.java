package com.stepos.stepclaw.chroot;

import android.content.Context;
import com.stepos.stepclaw.SecurePrefs;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/stepos/stepclaw/chroot/UpgradeDoctor;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "Landroid/content/Context;", "context", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "filesDirPath", "Lb5/a0;", "runQuickCheckAndAuditIfDebug", "(Landroid/content/Context;Ljava/lang/String;)V", "TAG", "Ljava/lang/String;", "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class UpgradeDoctor {
    public static final UpgradeDoctor INSTANCE = new UpgradeDoctor();
    private static final String TAG = "UpgradeDoctor";

    private UpgradeDoctor() {
    }

    public final void runQuickCheckAndAuditIfDebug(Context context, String filesDirPath) {
        p.e(context, "context");
        p.e(filesDirPath, "filesDirPath");
    }
}
