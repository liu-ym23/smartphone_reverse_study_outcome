package com.zyql.common.utils.upload;

import S7.a;
import android.view.result.ActivityResultLauncher;
import android.view.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.policy.sdk.util.PolicySdkPermissionManifestUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\t\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\rR\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u000eR\"\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000f8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/zyql/common/utils/upload/MediaPermissionHelper;", "", "Landroidx/appcompat/app/AppCompatActivity;", "activity", "Lkotlin/Function0;", "LC7/r;", "onPermissionGranted", AppAgent.CONSTRUCT, "(Landroidx/appcompat/app/AppCompatActivity;LS7/a;)V", "register", "(Landroidx/appcompat/app/AppCompatActivity;)V", "requestMediaPermissions", "()V", "Landroidx/appcompat/app/AppCompatActivity;", "LS7/a;", "Landroidx/activity/result/ActivityResultLauncher;", "", "", "launcher", "Landroidx/activity/result/ActivityResultLauncher;", "utils_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class MediaPermissionHelper {
    private final AppCompatActivity activity;
    private ActivityResultLauncher<String[]> launcher;
    private final a onPermissionGranted;

    public MediaPermissionHelper(AppCompatActivity activity, a onPermissionGranted) {
        k.f(activity, "activity");
        k.f(onPermissionGranted, "onPermissionGranted");
        this.activity = activity;
        this.onPermissionGranted = onPermissionGranted;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void register$lambda$1(MediaPermissionHelper mediaPermissionHelper, Map map) {
        Set setEntrySet = map.entrySet();
        if (!(setEntrySet instanceof Collection) || !setEntrySet.isEmpty()) {
            Iterator it = setEntrySet.iterator();
            while (it.hasNext()) {
                if (!((Boolean) ((Map.Entry) it.next()).getValue()).booleanValue()) {
                    return;
                }
            }
        }
        mediaPermissionHelper.onPermissionGranted.invoke();
    }

    public final void register(AppCompatActivity activity) {
        k.f(activity, "activity");
        this.launcher = activity.registerForActivityResult(new ActivityResultContracts.RequestMultiplePermissions(), new B5.a(this, 20));
    }

    public final void requestMediaPermissions() {
        String[] strArr = {PolicySdkPermissionManifestUtils.READ_MEDIA_IMAGES, PolicySdkPermissionManifestUtils.READ_MEDIA_VIDEO, PolicySdkPermissionManifestUtils.READ_MEDIA_AUDIO};
        for (String str : strArr) {
            if (this.activity.checkSelfPermission(str) != 0) {
                ActivityResultLauncher<String[]> activityResultLauncher = this.launcher;
                if (activityResultLauncher != null) {
                    activityResultLauncher.launch(strArr);
                    return;
                } else {
                    k.n("launcher");
                    throw null;
                }
            }
        }
        this.onPermissionGranted.invoke();
    }
}
