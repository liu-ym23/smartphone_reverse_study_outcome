package com.android.internal.chooser.chooser;

import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentExt;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import com.android.internal.chooser.base.IntentModifier;

/* loaded from: classes.dex */
public class ChooserIntentModifier implements IntentModifier {
    @Override // com.android.internal.chooser.base.IntentModifier
    public Intent modifyQueryIntent(Intent intent) {
        return intent;
    }

    @Override // com.android.internal.chooser.base.IntentModifier
    public Intent modifySendIntent(Intent intent, ResolveInfo resolveInfo, boolean quickLook) {
        intent.setFlags(intent.getFlags() & (-8388609));
        intent.addFlags(1);
        intent.addFlags(IntentExt.STEPOS_FLAG_UNINSTALL);
        intent.addFlags(IntentExt.STEPOS_FLAG_ACTIVITYINFO_BLACKLIST);
        String action = intent.getAction();
        if ("android.intent.action.SEND".equals(action) || "android.intent.action.SEND_MULTIPLE".equals(action) || quickLook) {
            intent.addFlags(134742016);
        }
        ActivityInfo ai = resolveInfo.activityInfo;
        intent.setComponent(new ComponentName(ai.applicationInfo.packageName, ai.name));
        return intent;
    }
}
