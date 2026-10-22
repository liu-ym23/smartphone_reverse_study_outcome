package com.bytedanceos.common.toolbox;

import android.content.ComponentName;
import android.os.Build;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.R$dimen;
import com.bytedanceos.common.model.AppInfo;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f10009a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List f10010b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final List f10011c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final float f10012d = 0.0f;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f10013e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final List f10014f = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ComponentName f10015a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final ComponentName f10016b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final ComponentName f10017c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final ComponentName f10018d = null;

        static {
            f10015a = new ComponentName("com.obric.cleaner", "com.bytedanceos.cleaner.activity.CleanerActivity");
            f10016b = new ComponentName("com.obric.security", "com.bytedanceos.storage.StorageActivity");
            f10017c = new ComponentName("com.obric.security", "com.bytedanceos.securitycenter.MainActivity");
            f10018d = new ComponentName("com.tencent.mm", "com.tencent.mm.ui.tools.ShareImgUI");
        }
    }

    static {
        f10009a = Build.MODEL;
        f10010b = Collections.unmodifiableList(Arrays.asList(new String[]{"gloable_search", "launcher", AppInfo.SEARCH_SOURCE_EXTENAL, "yyb"}));
        f10011c = Collections.unmodifiableList(Arrays.asList(new String[]{"gloable_search", "launcher", "sys_app_default", "sys_app_force", "sys_app_silence", "sys_app_silence_mobile"}));
        f10012d = BaseApplication.c().getResources().getDimensionPixelSize(R$dimen.detail_app_icon_radius);
        f10013e = "";
        f10014f = Collections.unmodifiableList(Arrays.asList(new String[]{"com.google.android.gsf.login", "com.google.android.gsf", "com.google.android.gms", "com.google.android.syncadapters.calendar", "com.google.android.syncadapters.contacts", "com.android.vending"}));
    }
}
