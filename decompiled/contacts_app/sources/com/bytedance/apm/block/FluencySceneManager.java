package com.bytedance.apm.block;

import com.android.contacts.common.SimContactsConstants;
import com.bytedance.apm.util.ListUtils;
import java.util.ConcurrentModificationException;
import java.util.HashSet;

/* JADX INFO: loaded from: classes2.dex */
public class FluencySceneManager {
    private static HashSet<String> sFpsScenes;
    private static String sFpsScenesString;
    private static boolean sInjectSceneChanged;

    public FluencySceneManager() {
    }

    static {
        sFpsScenes = new HashSet();
        sFpsScenesString = "";
        sInjectSceneChanged = true;
    }

    public static String getInjectScene() {
        if (sInjectSceneChanged == false) goto L6;
        sFpsScenesString = ListUtils.listToString(sFpsScenes, SimContactsConstants.EMAIL_SEP);     // Catch: ConcurrentModificationException -> L7
        sInjectSceneChanged = false;     // Catch: ConcurrentModificationException -> L7
    L6:
        return sFpsScenesString;
    }

    public static void addScene(String r1) {
        sInjectSceneChanged = true;
        sFpsScenes.add(r1);
    }

    public static void removeScene(String r1) {
        sInjectSceneChanged = true;
        sFpsScenes.remove(r1);
    }
}
