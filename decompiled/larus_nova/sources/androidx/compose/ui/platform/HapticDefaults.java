package androidx.compose.ui.platform;

import android.content.Context;
import android.os.Build;
import android.os.Vibrator;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/ui/platform/HapticDefaults;", "", "<init>", "()V", "isPremiumVibratorEnabled", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class HapticDefaults {
    public static final int $stable = 0;
    public static final HapticDefaults INSTANCE = null;

    static {
        INSTANCE = new HapticDefaults();
    }

    private HapticDefaults() {
    }

    public final boolean isPremiumVibratorEnabled(Context r100) {
        if (Build.VERSION.SDK_INT >= 31) goto L5;
        return false;
    L5:
        if (((Vibrator) r100.getSystemService(Vibrator.class)).areAllPrimitivesSupported(new int[]{1, 7, 2}) == false) goto L10;
        return true;
    L10:
        return false;
    }
}
