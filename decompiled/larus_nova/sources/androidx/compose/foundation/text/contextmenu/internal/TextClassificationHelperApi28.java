package androidx.compose.foundation.text.contextmenu.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Build;
import android.view.textclassifier.TextClassification;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0016\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f¨\u0006\r"}, d2 = {"Landroidx/compose/foundation/text/contextmenu/internal/TextClassificationHelperApi28;", "", "<init>", "()V", "sendPendingIntent", "", BaseGmsClient.KEY_PENDING_INTENT, "Landroid/app/PendingIntent;", "sendLegacyIntent", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "textClassification", "Landroid/view/textclassifier/TextClassification;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TextClassificationHelperApi28 {
    public static final int $stable = 0;
    public static final TextClassificationHelperApi28 INSTANCE = null;

    static {
        INSTANCE = new TextClassificationHelperApi28();
    }

    private TextClassificationHelperApi28() {
    }

    public final void sendPendingIntent(PendingIntent r100) {
        if (Build.VERSION.SDK_INT < 34) goto L5;
        TextClassificationHelper34.INSTANCE.sendIntentAllowBackgroundActivityStart(r100);
        return;
    L5:
        r100.send();
    }

    public final void sendLegacyIntent(Context r100, TextClassification r101) {
        String r102 = r101.getText();
        if (r102 == null) goto L5;
        int r103 = r102.hashCode();
    L6:
        sendPendingIntent(PendingIntent.getActivity(r100, r103, r101.getIntent(), 201326592));
        return;
    L5:
        r103 = 0;
        goto L6
    }
}
