package be8;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes25.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f18781a = 0;

    static {
    }

    public static boolean a(String r100) {
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        if (Intrinsics.areEqual(r100, "task_skill_entry") == false) goto L7;
    L18:
        return true;
    L7:
        if (StringsKt.startsWith$default(r100, "task_skill_chip_", false, 2, null) == true) goto L18;
        if (Intrinsics.areEqual(r100, "task_device_entry") == true) goto L18;
        if (Intrinsics.areEqual(r100, "task_folder_entry") == true) goto L18;
        if (Intrinsics.areEqual(r100, "task_device_folder_merged_entry") == true) goto L18;
        if (Intrinsics.areEqual(r100, "task_authorization_mode") == true) goto L18;
        if (Intrinsics.areEqual(r100, "task_connector_entry") == true) goto L18;
        return false;
    }
}
