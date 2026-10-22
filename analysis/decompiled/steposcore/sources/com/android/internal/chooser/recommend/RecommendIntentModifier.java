package com.android.internal.chooser.recommend;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import com.android.internal.chooser.base.IntentModifier;

/* loaded from: classes.dex */
public class RecommendIntentModifier implements IntentModifier {
    @Override // com.android.internal.chooser.base.IntentModifier
    public Intent modifyQueryIntent(Intent intent) {
        Intent intent2 = new Intent(intent);
        intent2.setComponent(null);
        intent2.setDataAndType(intent2.getData(), "*/*");
        return intent2;
    }

    @Override // com.android.internal.chooser.base.IntentModifier
    public Intent modifySendIntent(Intent intent, ResolveInfo resolveInfo, boolean quickLook) {
        intent.addFlags(50331648);
        ActivityInfo ai = resolveInfo.activityInfo;
        intent.setComponent(new ComponentName(ai.applicationInfo.packageName, ai.name));
        return intent;
    }
}
