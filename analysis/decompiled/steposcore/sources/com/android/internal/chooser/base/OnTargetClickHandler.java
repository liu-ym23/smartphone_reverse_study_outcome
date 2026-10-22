package com.android.internal.chooser.base;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import com.android.internal.chooser.ShareStrategy;
import java.util.List;

/* loaded from: classes.dex */
public interface OnTargetClickHandler {
    void handleClick(Activity activity, Intent intent, ResolveInfo resolveInfo, List<ResolveInfo> list, boolean z, boolean z2, ShareStrategy shareStrategy);
}
