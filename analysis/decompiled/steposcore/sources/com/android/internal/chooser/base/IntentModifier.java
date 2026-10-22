package com.android.internal.chooser.base;

import android.content.Intent;
import android.content.pm.ResolveInfo;

/* loaded from: classes.dex */
public interface IntentModifier {
    Intent modifyQueryIntent(Intent intent);

    Intent modifySendIntent(Intent intent, ResolveInfo resolveInfo, boolean z);
}
