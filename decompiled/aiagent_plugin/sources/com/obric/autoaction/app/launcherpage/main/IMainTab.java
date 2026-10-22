package com.obric.autoaction.app.launcherpage.main;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: IMainTab.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface IMainTab {
    public static final a Companion = null;

    /* JADX INFO: compiled from: IMainTab.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f23951a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final String f23952b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final String f23953c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final String f23954d = null;

        private a() {
        }

        static {
            f23951a = new a();
            f23952b = "ShortCutTab";
            f23953c = "AutomationTab";
            f23954d = "DiscoveryTab";
        }

        public final String a() {
            return f23952b;
        }

        public final String b() {
            return f23953c;
        }

        public final String c() {
            return f23954d;
        }
    }

    /* JADX INFO: compiled from: IMainTab.kt */
    public static final class b {
        public static void a(IMainTab r2) {
            IMainTab r3 = (IMainTab) ZeusTransformUtils.wrapperContextForParams(r2, IMainTab.class, "com.obric.aiagent.plugin");
        }

        public static void b(IMainTab r2) {
            IMainTab r3 = (IMainTab) ZeusTransformUtils.wrapperContextForParams(r2, IMainTab.class, "com.obric.aiagent.plugin");
        }

        public static void c(IMainTab r2) {
            IMainTab r3 = (IMainTab) ZeusTransformUtils.wrapperContextForParams(r2, IMainTab.class, "com.obric.aiagent.plugin");
        }

        public static boolean d(IMainTab r2) {
            IMainTab r3 = (IMainTab) ZeusTransformUtils.wrapperContextForParams(r2, IMainTab.class, "com.obric.aiagent.plugin");
            return true;
        }

        public static boolean e(IMainTab r2) {
            IMainTab r3 = (IMainTab) ZeusTransformUtils.wrapperContextForParams(r2, IMainTab.class, "com.obric.aiagent.plugin");
            return true;
        }

        public static boolean f(IMainTab r2) {
            IMainTab r3 = (IMainTab) ZeusTransformUtils.wrapperContextForParams(r2, IMainTab.class, "com.obric.aiagent.plugin");
            return false;
        }
    }

    static {
        Companion = a.f23951a;
    }

    Class<? extends Fragment> fragmentClass();

    boolean onBackPressed();

    void onTabReselected();

    void onTabSelected();

    void onTabUnselected();

    int order();

    boolean shouldShow();

    c tabConfig(Context r1);

    String tag();

    boolean titleBarMaskEnabled();
}
