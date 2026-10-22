package com.android.internal.notification;

import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: classes.dex */
public class StepOSNotificationHelper {
    private static final ArrayList<String> sCoreApp = new ArrayList<>();
    private static final ArrayList<String> sNonGrantAndEditableApp = new ArrayList<>();

    static {
        String[] coreApp = {"com.stepos.safe", "com.android.alarmclock", "com.android.dialer", "com.stepos.update", "com.android.settings", "com.android.mms", "com.android.incallui", "com.android.server.telecom", "com.stepos.superalgorithmservice", "com.stepos.sceneengine", "com.stepos.share", "com.stepos.ai.taskagent"};
        String[] noneGrantAndEditableApp = {"com.stepos.notepaper", "com.android.browser", "com.android.soundrecorder", "com.stepos.net.search", "com.stepos.media.gallery", "com.stepos.media.music", "com.stepos.steposbbs", "com.stepos.store", "com.stepos.gamecenter"};
        sCoreApp.addAll(Arrays.asList(coreApp));
        sNonGrantAndEditableApp.addAll(Arrays.asList(noneGrantAndEditableApp));
    }

    public static ArrayList<String> getCoreAppList() {
        return new ArrayList<>(sCoreApp);
    }

    public static boolean isCoreApp(String packageName) {
        return sCoreApp.contains(packageName);
    }

    public static boolean isInShouldNotGrantList(String packageName) {
        return sNonGrantAndEditableApp.contains(packageName);
    }

    public static boolean isInEditableBlackList(String packageName) {
        return sCoreApp.contains(packageName);
    }
}
