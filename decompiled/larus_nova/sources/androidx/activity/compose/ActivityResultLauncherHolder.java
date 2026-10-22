package androidx.activity.compose;

import androidx.activity.result.ActivityResultLauncher;
import androidx.core.app.ActivityOptionsCompat;
import com.ss.android.common.applog.EventVerify;
import com.xiaomi.mipush.sdk.MiPushClient;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u001f\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00018\u00002\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fJ\u0006\u0010\u0010\u001a\u00020\u000bR\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0011"}, d2 = {"Landroidx/activity/compose/ActivityResultLauncherHolder;", "I", "", "()V", "launcher", "Landroidx/activity/result/ActivityResultLauncher;", "getLauncher", "()Landroidx/activity/result/ActivityResultLauncher;", "setLauncher", "(Landroidx/activity/result/ActivityResultLauncher;)V", EventVerify.TYPE_LAUNCH, "", "input", "options", "Landroidx/core/app/ActivityOptionsCompat;", "(Ljava/lang/Object;Landroidx/core/app/ActivityOptionsCompat;)V", MiPushClient.COMMAND_UNREGISTER, "activity-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ActivityResultLauncherHolder<I> {
    private ActivityResultLauncher<I> launcher;

    public ActivityResultLauncherHolder() {
    }

    public final void unregister() {
        ActivityResultLauncher<I> r100 = this.launcher;
        if (r100 == null) goto L5;
        r100.unregister();
        Unit r101 = Unit.INSTANCE;
    L6:
        if (r101 == null) goto L9;
        return;
    L9:
        throw new IllegalStateException("Launcher has not been initialized".toString());
    L5:
        r101 = null;
        goto L6
    }

    public final ActivityResultLauncher<I> getLauncher() {
        return this.launcher;
    }

    public final void setLauncher(ActivityResultLauncher<I> r100) {
        this.launcher = r100;
    }

    public final void launch(I r100, ActivityOptionsCompat r101) {
        ActivityResultLauncher<I> r102 = this.launcher;
        if (r102 == null) goto L5;
        r102.launch(r100, r101);
        Unit r103 = Unit.INSTANCE;
    L6:
        if (r103 == null) goto L9;
        return;
    L9:
        throw new IllegalStateException("Launcher has not been initialized".toString());
    L5:
        r103 = null;
        goto L6
    }
}
