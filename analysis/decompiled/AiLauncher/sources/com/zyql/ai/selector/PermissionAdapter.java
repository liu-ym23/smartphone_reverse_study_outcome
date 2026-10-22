package com.zyql.ai.selector;

import android.content.Context;
import com.stepos.policy.sdk.util.PolicySdkPermissionManifestUtils;
import com.zyql.ai.selector.permissions.PermissionChecker;
import d.AbstractC3936b;
import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ)\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/zyql/ai/selector/PermissionAdapter;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "checkMediaPermission", "(Landroid/content/Context;)Z", "Ld/b;", "", "", "launcher", "LY8/t;", "requestMediaPermission", "(Landroid/content/Context;Ld/b;)V", "getStoragePermissions", "()[Ljava/lang/String;", "storagePermissions", "selector_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PermissionAdapter {
    public static final PermissionAdapter INSTANCE = new PermissionAdapter();

    private PermissionAdapter() {
    }

    public final boolean checkMediaPermission(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        return PermissionChecker.checkSelfPermission(context, PolicySdkPermissionManifestUtils.READ_MEDIA_IMAGES) && PermissionChecker.checkSelfPermission(context, PolicySdkPermissionManifestUtils.READ_MEDIA_VIDEO);
    }

    public final String[] getStoragePermissions() {
        return new String[]{PolicySdkPermissionManifestUtils.READ_MEDIA_IMAGES, PolicySdkPermissionManifestUtils.READ_MEDIA_VIDEO};
    }

    public final void requestMediaPermission(Context context, AbstractC3936b<String[]> launcher) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(launcher, "launcher");
        if (checkMediaPermission(context)) {
            return;
        }
        launcher.a(getStoragePermissions());
    }
}
