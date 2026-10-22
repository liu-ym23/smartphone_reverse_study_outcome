package com.android.server.pm.resolution;

import android.content.pm.ResolveInfo;
import com.android.internal.pm.pkg.component.ParsedActivity;
import com.android.server.pm.Settings;

/* JADX INFO: loaded from: classes2.dex */
public class ComponentResolverSmtEx {
    private ComponentResolver mResolver;

    static class ActivityIntentResolverSmtEx {
        Settings mSettings;

        ActivityIntentResolverSmtEx() {
        }
    }

    ComponentResolverSmtEx(ComponentResolver resolver) {
        this.mResolver = resolver;
    }

    public void setSettings(Settings settings) {
        this.mResolver.mActivities.getSmtEx().mSettings = settings;
    }

    static void setChosenPriority(int userId, ParsedActivity info, ResolveInfo res, Settings settings) {
        if (settings == null) goto L7;
        int priority = settings.getSmtEx().getChosenPriority(info.getComponentName().flattenToShortString(), userId);
        if (priority <= 0) goto L8;
        res.activityInfo.getSmtEx().chosenPriority = priority;
        return;
    L8:
        return;
    }
}
