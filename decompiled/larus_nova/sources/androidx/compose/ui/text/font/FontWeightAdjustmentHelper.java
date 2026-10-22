package androidx.compose.ui.text.font;

import android.content.Context;
import android.os.Build;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/ui/text/font/FontWeightAdjustmentHelper;", "", "<init>", "()V", "getFontWeightAdjustment", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FontWeightAdjustmentHelper {
    public static final int $stable = 0;
    public static final FontWeightAdjustmentHelper INSTANCE = null;

    static {
        INSTANCE = new FontWeightAdjustmentHelper();
    }

    private FontWeightAdjustmentHelper() {
    }

    public final int getFontWeightAdjustment(Context r100) {
        if (Build.VERSION.SDK_INT >= 31) goto L7;
        return 0;
    L7:
        return FontWeightAdjustmentHelperApi31.INSTANCE.fontWeightAdjustment(r100);
    }
}
