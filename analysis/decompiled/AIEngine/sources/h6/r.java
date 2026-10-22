package h6;

import android.content.Context;
import android.content.Intent;
import com.stepos.aiengine.modelmanager.ModelManagerActivity;
import com.stepos.core.common.notification.ModelDownloadNotifier;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class r {
    public static Intent a(Context context, String str, int i10) {
        if ((i10 & 2) != 0) {
            str = null;
        }
        Intent intent = new Intent(ModelDownloadNotifier.ACTION_MODEL_MANAGER);
        intent.setPackage("com.stepos.aiengine");
        intent.setClassName("com.stepos.aiengine", ModelManagerActivity.class.getName());
        if (str != null) {
            intent.putExtra("com.stepos.aiengine.extra.MODEL_ID", str);
        }
        intent.putExtra("com.stepos.aiengine.extra.CALLER_PACKAGE", context.getPackageName());
        return intent;
    }
}
