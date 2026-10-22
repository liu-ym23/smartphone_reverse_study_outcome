package com.obric.autogui.platforms.tools.packages;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.LauncherApps;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ShortcutInfo;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.UserHandle;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crypto.utils.CryptoConst;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.common.api.AOBizTracking;
import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.abilities.AutoActionAbilitiesKt;
import com.obric.autogui.common.api.abilities.AutoActionAbility;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.configs.AutoActionConfigs;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.packages.IAutoActionPackagesApi;
import com.obric.autogui.common.api.platform.packages.StartActivityPosition;
import com.obric.autogui.common.api.platform.packages.StartActivityResult;
import com.obric.autogui.common.api.platform.packages.appinfo.AppInfoEntry;
import com.obric.autogui.common.api.platform.packages.appinfo.DoubaoMiniAppInfo;
import com.obric.autogui.common.api.platform.packages.appinfo.LauncherEntryInfo;
import com.obric.autogui.common.api.platform.packages.appinfo.LauncherShortcutInfo;
import com.obric.autogui.common.api.platform.packages.appinfo.OpenableAppInfo;
import com.obric.autogui.common.api.platform.tracking.IAutoActionTrackingApi;
import com.obric.autogui.common.api.threading.AOThreadingTools;
import com.obric.livecard.api.impl.IslandImpl;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.a.ax;
import d.a.p;
import d.c.b.a.l;
import d.h.a.m;
import d.h.b.o;
import d.n;
import d.o.k;
import d.s;
import d.x;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.au;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.ca;
import kotlinx.coroutines.i;
import kotlinx.coroutines.w;
import kotlinx.coroutines.y;
import org.json.JSONObject;

/* JADX INFO: compiled from: StandardPackagesTools.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class StandardPackagesTools {
    private static final String TAG = "StdPkgTools";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final StandardPackagesTools f30438a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Set<String> f30439b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final d.f f30440c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Intent f30441d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final com.obric.autogui.platforms.tools.packages.a f30442e = null;
    private static w<x> f;
    private static volatile ConcurrentHashMap<String, AppInfoEntry> g;
    private static ca h;
    private static final StandardPackagesTools$mIconCache$1 i = null;
    private static final ConcurrentHashMap.KeySetView<String, Boolean> j = null;
    private static final CopyOnWriteArrayList<IAutoActionPackagesApi.PackageChangeListener> k = null;
    private static long l;
    private static final Set<String> m = null;
    private static final LauncherCallback n = null;
    private static final a o = null;

    /* JADX INFO: compiled from: StandardPackagesTools.kt */
    private static final class LauncherCallback extends LauncherApps.Callback {
        @Override // android.content.pm.LauncherApps.Callback
        public void onPackagesAvailable(String[] r1, UserHandle r2, boolean r3) {
        }

        @Override // android.content.pm.LauncherApps.Callback
        public void onPackagesUnavailable(String[] r1, UserHandle r2, boolean r3) {
        }

        public LauncherCallback() {
        }

        private final boolean isMainUser(UserHandle r1) {
            if (r1 != null) goto L4;
        L7:
            return true;
        L4:
            if (o.a(r1, AOHostAppTools.INSTANCE.getUserHandle()) == true) goto L7;
            return false;
        }

        @Override // android.content.pm.LauncherApps.Callback
        public void onPackageRemoved(String r4, UserHandle r5) {
            if (isMainUser(r5) == true) goto L6;
            Loog.INSTANCE.d(StandardPackagesTools.TAG, "[PackageTools] ignored removal for other user: `" + r4 + "` (u=" + r5 + ')');
            return;
        L6:
            if (r4 == null) goto L11;
            Loog.INSTANCE.d(StandardPackagesTools.TAG, "[PackageTools] triggered removal for `" + r4 + '`');
            StandardPackagesTools.a(StandardPackagesTools.f30438a, r4);
            StandardPackagesTools.c().remove(r4);
            StandardPackagesTools.a(StandardPackagesTools.f30438a, r4, false);
            Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(StandardPackagesTools.d(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
        L9:
            if (r3.hasNext() == false) goto L13;
            ((IAutoActionPackagesApi.PackageChangeListener) ZeusTransformUtils.preCheckCast(r3.next(), IAutoActionPackagesApi.PackageChangeListener.class, "com.obric.aiagent.plugin")).onPackageRemoved(r4);
            goto L9
        L13:
            return;
        }

        @Override // android.content.pm.LauncherApps.Callback
        public void onPackageAdded(String r4, UserHandle r5) {
            if (isMainUser(r5) == true) goto L6;
            Loog.INSTANCE.d(StandardPackagesTools.TAG, "[PackageTools] ignored added for other user: `" + r4 + "` (u=" + r5 + ')');
            return;
        L6:
            if (r4 == null) goto L11;
            Loog.INSTANCE.d(StandardPackagesTools.TAG, "[PackageTools] triggered added for `" + r4 + '`');
            StandardPackagesTools.a(StandardPackagesTools.f30438a, r4, false, 2, null);
            StandardPackagesTools.a(StandardPackagesTools.f30438a, r4, true);
            Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(StandardPackagesTools.d(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
        L9:
            if (r3.hasNext() == false) goto L13;
            ((IAutoActionPackagesApi.PackageChangeListener) ZeusTransformUtils.preCheckCast(r3.next(), IAutoActionPackagesApi.PackageChangeListener.class, "com.obric.aiagent.plugin")).onPackageAdded(r4);
            goto L9
        L13:
            return;
        }

        @Override // android.content.pm.LauncherApps.Callback
        public void onPackageChanged(String r9, UserHandle r10) {
            if (isMainUser(r10) == true) goto L6;
            Loog.INSTANCE.d(StandardPackagesTools.TAG, "[PackageTools] ignored change for other user: `" + r9 + "` (u=" + r10 + ')');
            return;
        L6:
            if (r9 == null) goto L21;
            Loog.INSTANCE.i(StandardPackagesTools.TAG, "[PackageTools] triggered change for `" + r9 + '`');
            AppInfoEntry r8 = (AppInfoEntry) ZeusTransformUtils.preCheckCast(StandardPackagesTools.e().get(r9), AppInfoEntry.class, "com.obric.aiagent.plugin");
            String r11 = null;
            if (r8 == null) goto L10;
            String r4 = r8.getAppFirstSign();
        L11:
            if (r8 == null) goto L13;
            r11 = r8.getAppMd5();
        L13:
            String r5 = r11;
            if (r8 == null) goto L16;
            long r1 = r8.getAntiFraudApkUpdateTime();
        L17:
            StandardPackagesTools.b(StandardPackagesTools.f30438a, r9, true);
            StandardPackagesTools.c().remove(r9);
            StandardPackagesTools.a(StandardPackagesTools.f30438a, r9, r4, r5, r1);
            Iterator r12 = ((Iterable) ZeusTransformUtils.preCheckCast(StandardPackagesTools.d(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
        L19:
            if (r12.hasNext() == false) goto L23;
            ((IAutoActionPackagesApi.PackageChangeListener) ZeusTransformUtils.preCheckCast(r12.next(), IAutoActionPackagesApi.PackageChangeListener.class, "com.obric.aiagent.plugin")).onPackageChanged(r9);
            goto L19
        L23:
            return;
        L16:
            r1 = 0;
            goto L17
        L10:
            r4 = null;
            goto L11
        }
    }

    /* JADX INFO: compiled from: StandardPackagesTools.kt */
    private static final class a extends PluginBroadcastReceiver {
        public a() {
        }

        public void onReceive(Context r2, Intent r3) {
            o.e((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), "context");
            if (r3 == null) goto L5;
            String r1 = r3.getAction();
        L7:
            if (o.a(r1, "android.intent.action.LOCALE_CHANGED") == false) goto L10;
            Loog.INSTANCE.i(StandardPackagesTools.TAG, " - [LocaleChanged] marking app-info cache to dirty.");
            StandardPackagesTools r4 = StandardPackagesTools.f30438a;
            StandardPackagesTools.a(-1);
            return;
        L10:
            return;
        L5:
            r1 = null;
            goto L7
        }
    }

    /* JADX INFO: compiled from: StandardPackagesTools.kt */
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f30443a = null;

        static {
            int[] r0 = new int[StartActivityResult.Status.values().length];
            r0[StartActivityResult.Status.Ok.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r0[StartActivityResult.Status.TargetNotFound.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r0[StartActivityResult.Status.SpaceNotFound.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[StartActivityResult.Status.NotSupported.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r0[StartActivityResult.Status.ApiFailed.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            f30443a = r0;
        }
    }

    /* JADX INFO: compiled from: StandardPackagesTools.kt */
    @d.c.b.a.f(b = "StandardPackagesTools.kt", c = {208, 210}, d = "ensureInitialAppInfoLoad", e = "com.obric.autogui.platforms.tools.packages.StandardPackagesTools")
    static final class c extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f30444a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f30445b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f30446c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ StandardPackagesTools f30447d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f30448e;

        c(StandardPackagesTools r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f30447d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f30446c = r3;
            this.f30448e |= Integer.MIN_VALUE;
            return StandardPackagesTools.a(this.f30447d, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: StandardPackagesTools.kt */
    @d.c.b.a.f(b = "StandardPackagesTools.kt", c = {545}, d = "getOpenableAppLabels", e = "com.obric.autogui.platforms.tools.packages.StandardPackagesTools")
    static final class d extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f30449a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f30450b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ StandardPackagesTools f30451c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f30452d;

        d(StandardPackagesTools r3, d.c.d<? super d> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f30451c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f30450b = r3;
            this.f30452d |= Integer.MIN_VALUE;
            return this.f30451c.a(null, false, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: StandardPackagesTools.kt */
    @d.c.b.a.f(b = "StandardPackagesTools.kt", c = {907, 908, 908}, d = "invokeSuspend", e = "com.obric.autogui.platforms.tools.packages.StandardPackagesTools$prefetchAppSignAndMd5$2")
    static final class e extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f30453a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f30454b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f30455c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        long f30456d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f30457e;
        final /* synthetic */ String f;
        final /* synthetic */ Context g;
        private /* synthetic */ Object h;

        /* JADX INFO: compiled from: StandardPackagesTools.kt */
        @d.c.b.a.f(b = "StandardPackagesTools.kt", c = {}, d = "invokeSuspend", e = "com.obric.autogui.platforms.tools.packages.StandardPackagesTools$prefetchAppSignAndMd5$2$md5Job$1")
        static final class a extends l implements m<am, d.c.d<? super n<? extends String>>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f30458a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ Context f30459b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ String f30460c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private /* synthetic */ Object f30461d;

            a(Context r3, String r4, d.c.d<? super a> r5) {
                Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
                d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
                this.f30459b = ZeusTransformUtils.wrapperContext(r6, "com.obric.aiagent.plugin");
                this.f30460c = r4;
                super(2, r7);
            }

            public final Object a(am r3, d.c.d<? super n<String>> r4) {
                return ((a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(Object r4, d.c.d<?> r5) {
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
                a r0 = new a(this.f30459b, this.f30460c, r6);
                r0.f30461d = r4;
                return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d.c.d<? super n<? extends String>> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r3) {
                d.c.a.b.a();
                if (this.f30458a != 0) goto L12;
                d.o.a(r3);
                am r4 = (am) ZeusTransformUtils.preCheckCast(this.f30461d, am.class, "com.obric.aiagent.plugin");
                Context r5 = this.f30459b;
                String r2 = this.f30460c;
                n.a r0 = n.f38560a;     // Catch: Throwable -> L7
                Object r6 = n.f(StandardPackagesTools.f30438a.e(r5, r2));     // Catch: Throwable -> L7
            L10:
                return n.g(r6);
            L7:
                th = move-exception;
                n.a r7 = n.f38560a;
                r6 = n.f(d.o.a(th));
                goto L10
            L12:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: compiled from: StandardPackagesTools.kt */
        @d.c.b.a.f(b = "StandardPackagesTools.kt", c = {}, d = "invokeSuspend", e = "com.obric.autogui.platforms.tools.packages.StandardPackagesTools$prefetchAppSignAndMd5$2$signJob$1")
        static final class b extends l implements m<am, d.c.d<? super n<? extends String>>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f30462a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ Context f30463b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ String f30464c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private /* synthetic */ Object f30465d;

            b(Context r3, String r4, d.c.d<? super b> r5) {
                Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
                d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
                this.f30463b = ZeusTransformUtils.wrapperContext(r6, "com.obric.aiagent.plugin");
                this.f30464c = r4;
                super(2, r7);
            }

            public final Object a(am r3, d.c.d<? super n<String>> r4) {
                return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(Object r4, d.c.d<?> r5) {
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
                b r0 = new b(this.f30463b, this.f30464c, r6);
                r0.f30465d = r4;
                return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d.c.d<? super n<? extends String>> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r3) {
                d.c.a.b.a();
                if (this.f30462a != 0) goto L12;
                d.o.a(r3);
                am r4 = (am) ZeusTransformUtils.preCheckCast(this.f30465d, am.class, "com.obric.aiagent.plugin");
                Context r5 = this.f30463b;
                String r2 = this.f30464c;
                n.a r0 = n.f38560a;     // Catch: Throwable -> L7
                Object r6 = n.f(StandardPackagesTools.f30438a.d(r5, r2));     // Catch: Throwable -> L7
            L10:
                return n.g(r6);
            L7:
                th = move-exception;
                n.a r7 = n.f38560a;
                r6 = n.f(d.o.a(th));
                goto L10
            L12:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        e(String r3, Context r4, d.c.d<? super e> r5) {
            Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f = r3;
            this.g = ZeusTransformUtils.wrapperContext(r6, "com.obric.aiagent.plugin");
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((e) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            e r0 = new e(this.f, this.g, r6);
            r0.h = r4;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r18) {
            Object r0 = d.c.a.b.a();
            int r2 = this.f30457e;
            if (r2 == 0) goto L18;
            if (r2 == 1) goto L15;
            if (r2 == 2) goto L12;
            if (r2 != 3) goto L11;
            StringBuilder r1 = (StringBuilder) ZeusTransformUtils.preCheckCast(this.f30454b, StringBuilder.class, "com.obric.aiagent.plugin");
            String r3 = (String) ZeusTransformUtils.preCheckCast(this.f30453a, String.class, "com.obric.aiagent.plugin");
            Loog r4 = (Loog) ZeusTransformUtils.preCheckCast(this.h, Loog.class, "com.obric.aiagent.plugin");
            d.o.a(r18);     // Catch: Throwable -> L34
            Loog r6 = r4;
            Object r5 = r18;
        L31:
            r6.i(r3, r1.append(n.d(((n) ZeusTransformUtils.preCheckCast(r5, n.class, "com.obric.aiagent.plugin")).a())).toString());     // Catch: Throwable -> L34
            StandardPackagesTools.f().remove(this.f);
            return x.f38692a;
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L12:
            StringBuilder r7 = (StringBuilder) ZeusTransformUtils.preCheckCast(this.f30455c, StringBuilder.class, "com.obric.aiagent.plugin");
            String r8 = (String) ZeusTransformUtils.preCheckCast(this.f30454b, String.class, "com.obric.aiagent.plugin");
            r6 = (Loog) ZeusTransformUtils.preCheckCast(this.f30453a, Loog.class, "com.obric.aiagent.plugin");
            au r9 = (au) ZeusTransformUtils.preCheckCast(this.h, au.class, "com.obric.aiagent.plugin");
            d.o.a(r18);     // Catch: Throwable -> L34
            au r10 = r9;
            StringBuilder r11 = r7;
            r3 = r8;
            Object r12 = r18;
        L27:
            StringBuilder r13 = r11.append(n.d(((n) ZeusTransformUtils.preCheckCast(r12, n.class, "com.obric.aiagent.plugin")).a())).append("，md5=");     // Catch: Throwable -> L34
            d.c.d r14 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L34
            this.h = r6;     // Catch: Throwable -> L34
            this.f30453a = r3;     // Catch: Throwable -> L34
            this.f30454b = r13;     // Catch: Throwable -> L34
            this.f30455c = null;     // Catch: Throwable -> L34
            this.f30457e = 3;     // Catch: Throwable -> L34
            r5 = r10.a(r14);     // Catch: Throwable -> L34
            if (r5 != r0) goto L30;
            return r0;
        L30:
            r1 = r13;
            goto L31
        L15:
            long r15 = this.f30456d;
            au r16 = (au) ZeusTransformUtils.preCheckCast(this.f30453a, au.class, "com.obric.aiagent.plugin");
            au r17 = (au) ZeusTransformUtils.preCheckCast(this.h, au.class, "com.obric.aiagent.plugin");
            d.o.a(r18);     // Catch: Throwable -> L34
        L23:
            Loog r19 = Loog.INSTANCE;     // Catch: Throwable -> L34
            r11 = new StringBuilder().append("[AntiFraud] prefetch sign+md5 for `").append(this.f).append("` spent=").append(AOSystemTools.INSTANCE.bootTimeMillis() - r15).append("ms，sign=");     // Catch: Throwable -> L34
            d.c.d r20 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L34
            this.h = r16;     // Catch: Throwable -> L34
            this.f30453a = r19;     // Catch: Throwable -> L34
            this.f30454b = StandardPackagesTools.TAG;     // Catch: Throwable -> L34
            this.f30455c = r11;     // Catch: Throwable -> L34
            this.f30457e = 2;     // Catch: Throwable -> L34
            r12 = r17.a(r20);     // Catch: Throwable -> L34
            if (r12 != r0) goto L26;
            return r0;
        L26:
            r10 = r16;
            r6 = r19;
            r3 = StandardPackagesTools.TAG;
            goto L27
        L18:
            d.o.a(r18);
            am r21 = (am) ZeusTransformUtils.preCheckCast(this.h, am.class, "com.obric.aiagent.plugin");
            long r110 = AOSystemTools.INSTANCE.bootTimeMillis();
            au r111 = i.b(r21, null, null, (m) ZeusTransformUtils.preCheckCast(new b(this.g, this.f, null), m.class, "com.obric.aiagent.plugin"), 3, null);     // Catch: Throwable -> L34
            au r22 = i.b(r21, null, null, (m) ZeusTransformUtils.preCheckCast(new a(this.g, this.f, null), m.class, "com.obric.aiagent.plugin"), 3, null);     // Catch: Throwable -> L34
            au[] r23 = {r111, r22};     // Catch: Throwable -> L34
            d.c.d r112 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L34
            this.h = r111;     // Catch: Throwable -> L34
            this.f30453a = r22;     // Catch: Throwable -> L34
            this.f30456d = r110;     // Catch: Throwable -> L34
            this.f30457e = 1;     // Catch: Throwable -> L34
            if (kotlinx.coroutines.f.a(r23, r112) != r0) goto L22;
            return r0;
        L22:
            r17 = r111;
            r16 = r22;
            r15 = r110;
        L34:
            th = move-exception;
            StandardPackagesTools.f().remove(this.f);
            throw th;
        }
    }

    /* JADX INFO: compiled from: StandardPackagesTools.kt */
    @d.c.b.a.f(b = "StandardPackagesTools.kt", c = {}, d = "invokeSuspend", e = "com.obric.autogui.platforms.tools.packages.StandardPackagesTools$refreshCacheAsync$1")
    static final class f extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f30466a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f30467b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private /* synthetic */ Object f30468c;

        f(Context r3, d.c.d<? super f> r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f30467b = ZeusTransformUtils.wrapperContext(r5, "com.obric.aiagent.plugin");
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((f) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), f.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            f r0 = new f(this.f30467b, r5);
            r0.f30468c = r3;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            d.c.a.b.a();
            if (this.f30466a != 0) goto L14;
            d.o.a(r3);
            am r4 = (am) ZeusTransformUtils.preCheckCast(this.f30468c, am.class, "com.obric.aiagent.plugin");
            boolean r2 = StandardPackagesTools.a(StandardPackagesTools.f30438a, this.f30467b);
            if (an.a(r4) == false) goto L7;
            if (r2 == false) goto L10;
            StandardPackagesTools.f30438a.a();
        L12:
            return x.f38692a;
        L10:
            StandardPackagesTools r5 = StandardPackagesTools.f30438a;
            StandardPackagesTools.a(AOSystemTools.INSTANCE.bootTimeMillis());
            goto L12
        L7:
            return x.f38692a;
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: StandardPackagesTools.kt */
    @d.c.b.a.f(b = "StandardPackagesTools.kt", c = {}, d = "invokeSuspend", e = "com.obric.autogui.platforms.tools.packages.StandardPackagesTools$setup$1")
    static final class g extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f30469a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ LauncherApps f30470b;

        g(LauncherApps r3, d.c.d<? super g> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f30470b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((g) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), g.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new g(this.f30470b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r4) {
            d.c.a.b.a();
            if (this.f30469a != 0) goto L10;
            d.o.a(r4);
            LauncherApps r3 = this.f30470b;
            if (r3 == null) goto L7;
            r3.registerCallback((LauncherApps.Callback) ZeusTransformUtils.preCheckCast(StandardPackagesTools.g(), LauncherApps.Callback.class, "com.obric.aiagent.plugin"));
        L7:
            Context r5 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
            PluginBroadcastReceiver r0 = (PluginBroadcastReceiver) ZeusTransformUtils.preCheckCast(StandardPackagesTools.h(), PluginBroadcastReceiver.class, "com.obric.aiagent.plugin");
            IntentFilter r1 = new IntentFilter();
            r1.addAction("android.intent.action.LOCALE_CHANGED");
            x r2 = x.f38692a;
            ZeusTransformUtils.registerReceiver(r5, r0, r1, "com.obric.aiagent.plugin");
            return x.f38692a;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: StandardPackagesTools.kt */
    @d.c.b.a.f(b = "StandardPackagesTools.kt", c = {}, d = "invokeSuspend", e = "com.obric.autogui.platforms.tools.packages.StandardPackagesTools$setup$2")
    static final class h extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f30471a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f30472b;

        h(Context r3, d.c.d<? super h> r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f30472b = ZeusTransformUtils.wrapperContext(r5, "com.obric.aiagent.plugin");
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((h) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), h.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new h(this.f30472b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r4) {
            d.c.a.b.a();
            if (this.f30471a != 0) goto L10;
            d.o.a(r4);
            StandardPackagesTools.a(StandardPackagesTools.f30438a, this.f30472b, false, 2, null);
            if ((!((Map) ZeusTransformUtils.preCheckCast(StandardPackagesTools.e(), Map.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L8;
            com.obric.autogui.platforms.tools.packages.a r3 = StandardPackagesTools.i();
            Collection<AppInfoEntry> r5 = StandardPackagesTools.e().values();
            o.c(r5, "<get-values>(...)");
            r3.a(r5);
        L8:
            return x.f38692a;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static /* synthetic */ CharSequence lambda$2iZ7YiUGp_PZTui1sPDfUyvW4rE(byte r0) {
        return a(r0);
    }

    public static /* synthetic */ String lambda$77NJPbj1_kr4dBgSHqx1kl5cjzk(ShortcutInfo r0, CharSequence r1, String r2) {
        return b(r0, r1, r2);
    }

    public static /* synthetic */ String lambda$Ezeokm53iHCdz4JPkZeeYf8rlf4(ShortcutInfo r0, String r1) {
        return b(r0, r1);
    }

    public static /* synthetic */ String lambda$ZUofkQsy8woMesThfaVjsVXeHZI(ShortcutInfo r0, String r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ CharSequence lambda$m1GYn5vRxEpiJoIq9tC1qJdOGBI(byte r0) {
        return b(r0);
    }

    /* JADX INFO: renamed from: lambda$qk1W4Jnx2HdH8RLzS-X9A0ByQ4Q, reason: not valid java name */
    public static /* synthetic */ String m871lambda$qk1W4Jnx2HdH8RLzSX9A0ByQ4Q(ShortcutInfo r0, CharSequence r1, String r2) {
        return a(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$v0qyI5LBGDAoayHd-DHzui3blqs, reason: not valid java name */
    public static /* synthetic */ Map m872lambda$v0qyI5LBGDAoayHdDHzui3blqs() {
        return r();
    }

    private StandardPackagesTools() {
    }

    public static final /* synthetic */ Object a(StandardPackagesTools r2, Context r3, d.c.d r4) {
        return r2.b((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ void a(long r0) {
        l = r0;
    }

    public static final /* synthetic */ void a(StandardPackagesTools r0, String r1) {
        r0.b(r1);
    }

    public static final /* synthetic */ void a(StandardPackagesTools r0, String r1, String r2, String r3, long r4) {
        r0.a(r1, r2, r3, r4);
    }

    public static final /* synthetic */ void a(StandardPackagesTools r0, String r1, boolean r2) {
        r0.a(r1, r2);
    }

    public static final /* synthetic */ boolean a(StandardPackagesTools r2, Context r3) {
        return r2.c((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ void b(StandardPackagesTools r0, String r1, boolean r2) {
        r0.b(r1, r2);
    }

    public static final /* synthetic */ StandardPackagesTools$mIconCache$1 c() {
        return i;
    }

    public static final /* synthetic */ CopyOnWriteArrayList d() {
        return k;
    }

    public static final /* synthetic */ ConcurrentHashMap e() {
        return g;
    }

    public static final /* synthetic */ ConcurrentHashMap.KeySetView f() {
        return j;
    }

    public static final /* synthetic */ LauncherCallback g() {
        return n;
    }

    public static final /* synthetic */ a h() {
        return o;
    }

    public static final /* synthetic */ com.obric.autogui.platforms.tools.packages.a i() {
        return f30442e;
    }

    /* JADX WARN: Type inference failed for: r0v11, types: [com.obric.autogui.platforms.tools.packages.StandardPackagesTools$mIconCache$1] */
    static {
        f30438a = new StandardPackagesTools();
        f30439b = ax.a(new String[]{"com.android.launcher3", "com.miui.home", IslandImpl.LIVE_CARD_HOST});
        f30440c = d.g.a($$Lambda$StandardPackagesTools$v0qyI5LBGDAoayHdDHzui3blqs.INSTANCE);
        f30441d = new Intent();
        f30442e = new com.obric.autogui.platforms.tools.packages.a();
        f = y.a(null, 1, null);
        g = new ConcurrentHashMap();
        i = new StandardPackagesTools$mIconCache$1();
        j = ConcurrentHashMap.newKeySet();
        k = new CopyOnWriteArrayList();
        l = -1;
        m = ax.a(new String[]{"com.larus.nova", "com.obric.appletapp"});
        n = new LauncherCallback();
        o = new a();
    }

    private final Map<String, String> j() {
        return (Map) ZeusTransformUtils.preCheckCast(f30440c.b(), Map.class, "com.obric.aiagent.plugin");
    }

    private static final Map r() {
        return ao.a(s.a(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_app_name_doubao, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_app_name_doubao")), "com.larus.nova"));
    }

    private final boolean k() {
        return AutoActionAbilitiesKt.isSupported(AutoActionAbility.ProdOperateHostApp);
    }

    private final boolean l() {
        return AutoActionConfigs.INSTANCE.getBooleanCfg("pkg.use_launcher_entry_as_launch_intent", true);
    }

    private final long m() {
        return AutoActionConfigs.INSTANCE.getLongCfg("pkg.cache_timeout_ms", 10800000);
    }

    private final boolean n() {
        return AutoActionConfigs.INSTANCE.getBooleanCfg("pkg.skip_shortcuts_without_launcher", true);
    }

    private final List<String> o() {
        List<?> r4 = AutoActionConfigs.INSTANCE.getListCfg("pkg.force_load_shortcuts_list");
        if (r4 == null) goto L15;
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.aiagent.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r6 = r5.iterator();
    L6:
        if (r6.hasNext() == false) goto L21;
        Object r2 = r6.next();
        if (ZeusTransformUtils.instanceOf(r2, String.class) == false) goto L10;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.aiagent.plugin");
    L11:
        if (r3 == null) goto L6;
        r1.add(r3);
        goto L6
    L10:
        r3 = null;
        goto L11
    L21:
        return (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.aiagent.plugin");
    L15:
        return p.o((Iterable) ZeusTransformUtils.preCheckCast(m, Iterable.class, "com.obric.aiagent.plugin"));
    }

    private final boolean p() {
        return AutoActionConfigs.INSTANCE.getBooleanCfg("pkg.get_meta", false);
    }

    public final void a(IAutoActionPackagesApi.PackageChangeListener r2) {
        IAutoActionPackagesApi.PackageChangeListener r1 = (IAutoActionPackagesApi.PackageChangeListener) ZeusTransformUtils.wrapperContextForParams(r2, IAutoActionPackagesApi.PackageChangeListener.class, "com.obric.aiagent.plugin");
        o.e(r1, "listener");
        k.addIfAbsent(r1);
    }

    public final void b(IAutoActionPackagesApi.PackageChangeListener r2) {
        IAutoActionPackagesApi.PackageChangeListener r1 = (IAutoActionPackagesApi.PackageChangeListener) ZeusTransformUtils.wrapperContextForParams(r2, IAutoActionPackagesApi.PackageChangeListener.class, "com.obric.aiagent.plugin");
        o.e(r1, "listener");
        k.remove(r1);
    }

    public final void a() {
        Loog.INSTANCE.w(TAG, "The app-info List has been invalidated.");
        l = -1;
        ca r2 = h;
        if (r2 == null) goto L5;
        ca.a.a(r2, null, 1, null);
    L5:
        h = null;
    }

    static /* synthetic */ boolean a(StandardPackagesTools r1, Context r2, boolean r3, int r4, Object r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L6;
        r3 = false;
    L6:
        return r1.a(r6, r3);
    }

    private final boolean a(Context r7, boolean r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        long r0 = AOSystemTools.INSTANCE.bootTimeMillis();
        monitor-enter(this);
        long r2 = l;     // Catch: Throwable -> L18
        if (r2 != (-1)) goto L7;
    L8:
        r8 = true;
    L9:
        x r1 = x.f38692a;     // Catch: Throwable -> L18
        monitor-exit(this);
        if (r8 == true) goto L14;
        return false;
    L14:
        f = y.a(null, 1, null);
        boolean r10 = c(r9);
        l = AOSystemTools.INSTANCE.bootTimeMillis();
        f.a(x.f38692a);
        if (r10 == false) goto L17;
        a();
    L17:
        return true;
    L7:
        if ((r0 - r2) <= f30438a.m()) goto L9;
    L18:
        th = move-exception;
        throw th;
    }

    private final Object a(Context r3, d.c.d<? super x> r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        d.c.d<? super x> r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        if (g.isEmpty() == true) goto L5;
        b(r5);
    L14:
        return x.f38692a;
    L5:
        if (f.i() == true) goto L11;
        Loog.INSTANCE.w(TAG, " - [PackageTool] cache empty, awaiting initial load...");
        Object r2 = f.a(r6);
        if (r2 != d.c.a.b.a()) goto L10;
        return r2;
    L10:
        return x.f38692a;
    L11:
        d.c.b.a.b.a(a(this, r5, false, 2, null));
        goto L14
    }

    private final Object b(Context r7, d.c.d<? super x> r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r10, c.class) == false) goto L7;
        c r0 = (c) ZeusTransformUtils.preCheckCast(r10, c.class, "com.obric.aiagent.plugin");
        if ((r0.f30448e & Integer.MIN_VALUE) == 0) goto L7;
        r0.f30448e -= Integer.MIN_VALUE;
    L8:
        Object r11 = r0.f30446c;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f30448e;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        d.o.a(r11);
    L35:
        return x.f38692a;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r9 = (Context) ZeusTransformUtils.preCheckCast(r0.f30445b, Context.class, "com.obric.aiagent.plugin");
        StandardPackagesTools this = (StandardPackagesTools) ZeusTransformUtils.preCheckCast(r0.f30444a, StandardPackagesTools.class, "com.obric.aiagent.plugin");
        d.o.a(r11);
    L28:
        if (f30442e.a() != null) goto L37;
        if (g.isEmpty() == false) goto L37;
        r0.f30444a = null;
        r0.f30445b = null;
        r0.f30448e = 2;
        if (this.a(r9, r0) != r2) goto L35;
        return r2;
    L37:
        return x.f38692a;
    L16:
        d.o.a(r11);
        if ((!((Map) ZeusTransformUtils.preCheckCast(g, Map.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L20;
        b(r9);
        return x.f38692a;
    L20:
        com.obric.autogui.platforms.tools.packages.a r12 = f30442e;
        if (r12.a() != null) goto L23;
        r12.a(r9, q());
        r0.f30444a = this;
        r0.f30445b = r9;
        r0.f30448e = 1;
        if (r12.a(r0) != r2) goto L28;
        return r2;
    L23:
        return x.f38692a;
    L7:
        r0 = new c(this, r10);
        goto L8
    }

    private final void b(Context r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        long r0 = AOSystemTools.INSTANCE.bootTimeMillis();
        monitor-enter(this);
        long r2 = l;     // Catch: Throwable -> L16
        if (r2 == (-1)) goto L11;
        if ((r0 - r2) > f30438a.m()) goto L11;
        boolean r1 = false;
    L12:
        monitor-exit(this);
        if (r1 == false) goto L21;
        Loog.INSTANCE.i(TAG, "maybeRefreshAppInfoCacheAsync: cache expired, triggering async refresh");
        a(r8);
        return;
    L21:
        return;
    L11:
        r1 = true;
    L16:
        th = move-exception;
        throw th;
    }

    private final boolean a(List<? extends PackageInfo> r8) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
        if (r7.isEmpty() == false) goto L7;
        Loog.INSTANCE.e(TAG, "[PackageTools] Fetched apps is empty.");
        return false;
    L7:
        if (r7.size() != 1) goto L23;
        PackageInfo r9 = (PackageInfo) ZeusTransformUtils.preCheckCast(r7.get(0), PackageInfo.class, "com.obric.aiagent.plugin");
        if (r9 == null) goto L11;
        String r10 = r9.packageName;
    L12:
        Loog.INSTANCE.w(TAG, "[PackageTools] Fetched apps contains only one (" + r10 + ").");
        CharSequence r4 = (CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L15;
    L18:
        boolean r5 = true;
    L19:
        if (r5 == false) goto L21;
    L22:
        return false;
    L21:
        if (r10.contentEquals((CharSequence) ZeusTransformUtils.preCheckCast(AOHostAppTools.INSTANCE.getHostAppPackage(), CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L23;
    L15:
        if (d.o.o.d(r4) == true) goto L18;
        r5 = false;
        goto L19
    L11:
        r10 = null;
    L23:
        Loog.INSTANCE.d(TAG, "[PackageTools] Treated fetched apps (size=" + r7.size() + ") as valid.");
        return true;
    }

    public final AppInfoEntry a(Context r5, String r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        o.e(r7, "context");
        o.e(r6, "packageName");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return null;
    L9:
        AppInfoEntry r1 = (AppInfoEntry) ZeusTransformUtils.preCheckCast(g.get(r6), AppInfoEntry.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L13;
        f30438a.b(r7);
        return r1;
    L13:
        b(r6, true);
        Loog.INSTANCE.w(TAG, "looked-up a package `" + r6 + "` that seems to be a new one; forcing a refresh.");
        return (AppInfoEntry) ZeusTransformUtils.preCheckCast(g.get(r6), AppInfoEntry.class, "com.obric.aiagent.plugin");
    L5:
        r0 = false;
        goto L6
    }

    public final Collection<LauncherEntryInfo> a(Context r13, String r14, boolean r15) {
        Context r16 = (Context) ZeusTransformUtils.wrapperContextForParams(r13, Context.class, "com.obric.aiagent.plugin");
        o.e(r16, "context");
        o.e(r14, "name");
        b(r16);
        String r12 = (String) ZeusTransformUtils.preCheckCast(j().get(r14), String.class, "com.obric.aiagent.plugin");
        boolean r0 = true;
        if (r12 == null) goto L12;
        AppInfoEntry r17 = (AppInfoEntry) ZeusTransformUtils.preCheckCast(g.get(r12), AppInfoEntry.class, "com.obric.aiagent.plugin");
        Loog r1 = Loog.INSTANCE;
        StringBuilder r18 = new StringBuilder().append(" - [PackageTools] found a write-down app: ").append(r14).append(" -> ").append(r12).append(" (appInfo-found=");
        if (r17 != null) goto L8;
        r0 = false;
    L8:
        r1.d(TAG, r18.append(r0).append(')').toString());
        if (r17 != null) goto L11;
        return null;
    L11:
        return r17.getLauncherEntries();
    L12:
        Iterable r19 = (Iterable) ZeusTransformUtils.preCheckCast(new k("\\s+").c((CharSequence) ZeusTransformUtils.preCheckCast(d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.aiagent.plugin")).toString(), CharSequence.class, "com.obric.aiagent.plugin"), 0), Iterable.class, "com.obric.aiagent.plugin");
        Collection r110 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r111 = r19.iterator();
    L14:
        if (r111.hasNext() == false) goto L21;
        Object r3 = r111.next();
        if (((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L18;
        boolean r4 = true;
    L19:
        if (r4 == false) goto L14;
        r110.add(r3);
        goto L14
    L18:
        r4 = false;
        goto L19
    L21:
        List r112 = (List) ZeusTransformUtils.preCheckCast(r110, List.class, "com.obric.aiagent.plugin");
        if (r112.isEmpty() == false) goto L24;
        return null;
    L24:
        Map r113 = (Map) ZeusTransformUtils.preCheckCast(g, Map.class, "com.obric.aiagent.plugin");
        Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r114 = r113.entrySet().iterator();
    L26:
        if (r114.hasNext() == false) goto L55;
        Collection<LauncherEntryInfo> r6 = ((AppInfoEntry) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r114.next(), Map.Entry.class, "com.obric.aiagent.plugin")).getValue(), AppInfoEntry.class, "com.obric.aiagent.plugin")).getLauncherEntries();
        if (r6 != null) goto L30;
        List r7 = null;
    L52:
        if (r7 == null) goto L26;
        r5.add(r7);
        goto L26
    L30:
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.aiagent.plugin");
        Collection r9 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r10 = r8.iterator();
    L32:
        if (r10.hasNext() == false) goto L51;
        Object r11 = r10.next();
        CharSequence r20 = ((LauncherEntryInfo) ZeusTransformUtils.preCheckCast(r11, LauncherEntryInfo.class, "com.obric.aiagent.plugin")).getLabel();
        if (r20 == null) goto L48;
        String r21 = r20.toString();
        if (r21 == null) goto L48;
        Iterable r22 = (Iterable) ZeusTransformUtils.preCheckCast(r112, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r22, Collection.class) == true) goto L41;
    L43:
        Iterator r23 = r22.iterator();
    L45:
        if (r23.hasNext() == false) goto L42;
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r21, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r23.next(), String.class, "com.obric.aiagent.plugin"), CharSequence.class, "com.obric.aiagent.plugin"), r15) == true) goto L45;
    L42:
        boolean r24 = true;
    L49:
        if (r24 == false) goto L32;
        r9.add(r11);
        goto L32
    L41:
        if (((Collection) ZeusTransformUtils.preCheckCast(r22, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L43;
    L48:
        r24 = false;
        goto L49
    L51:
        r7 = (List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.aiagent.plugin");
        goto L52
    L55:
        return (Collection) ZeusTransformUtils.preCheckCast(p.c((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin")), Collection.class, "com.obric.aiagent.plugin");
    }

    public final Collection<LauncherShortcutInfo> b(Context r13, String r14, boolean r15) {
        Context r16 = (Context) ZeusTransformUtils.wrapperContextForParams(r13, Context.class, "com.obric.aiagent.plugin");
        o.e(r16, "context");
        o.e(r14, "name");
        b(r16);
        String r12 = (String) ZeusTransformUtils.preCheckCast(j().get(r14), String.class, "com.obric.aiagent.plugin");
        boolean r0 = true;
        if (r12 == null) goto L12;
        AppInfoEntry r17 = (AppInfoEntry) ZeusTransformUtils.preCheckCast(g.get(r12), AppInfoEntry.class, "com.obric.aiagent.plugin");
        Loog r1 = Loog.INSTANCE;
        StringBuilder r18 = new StringBuilder().append(" - [PackageTools] found a write-down app: ").append(r14).append(" -> ").append(r12).append(" (appInfo-found=");
        if (r17 != null) goto L8;
        r0 = false;
    L8:
        r1.d(TAG, r18.append(r0).append(')').toString());
        if (r17 != null) goto L11;
        return null;
    L11:
        return r17.getLauncherShortcuts();
    L12:
        Iterable r19 = (Iterable) ZeusTransformUtils.preCheckCast(new k("\\s+").c((CharSequence) ZeusTransformUtils.preCheckCast(d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.aiagent.plugin")).toString(), CharSequence.class, "com.obric.aiagent.plugin"), 0), Iterable.class, "com.obric.aiagent.plugin");
        Collection r110 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r111 = r19.iterator();
    L14:
        if (r111.hasNext() == false) goto L21;
        Object r3 = r111.next();
        if (((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L18;
        boolean r4 = true;
    L19:
        if (r4 == false) goto L14;
        r110.add(r3);
        goto L14
    L18:
        r4 = false;
        goto L19
    L21:
        List r112 = (List) ZeusTransformUtils.preCheckCast(r110, List.class, "com.obric.aiagent.plugin");
        if (r112.isEmpty() == false) goto L24;
        return null;
    L24:
        Map r113 = (Map) ZeusTransformUtils.preCheckCast(g, Map.class, "com.obric.aiagent.plugin");
        Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r114 = r113.entrySet().iterator();
    L26:
        if (r114.hasNext() == false) goto L55;
        Collection<LauncherShortcutInfo> r6 = ((AppInfoEntry) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r114.next(), Map.Entry.class, "com.obric.aiagent.plugin")).getValue(), AppInfoEntry.class, "com.obric.aiagent.plugin")).getLauncherShortcuts();
        if (r6 != null) goto L30;
        List r7 = null;
    L52:
        if (r7 == null) goto L26;
        r5.add(r7);
        goto L26
    L30:
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.aiagent.plugin");
        Collection r9 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r10 = r8.iterator();
    L32:
        if (r10.hasNext() == false) goto L51;
        Object r11 = r10.next();
        CharSequence r20 = ((LauncherShortcutInfo) ZeusTransformUtils.preCheckCast(r11, LauncherShortcutInfo.class, "com.obric.aiagent.plugin")).getLabel();
        if (r20 == null) goto L48;
        String r21 = r20.toString();
        if (r21 == null) goto L48;
        Iterable r22 = (Iterable) ZeusTransformUtils.preCheckCast(r112, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r22, Collection.class) == true) goto L41;
    L43:
        Iterator r23 = r22.iterator();
    L45:
        if (r23.hasNext() == false) goto L42;
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r21, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r23.next(), String.class, "com.obric.aiagent.plugin"), CharSequence.class, "com.obric.aiagent.plugin"), r15) == true) goto L45;
    L42:
        boolean r24 = true;
    L49:
        if (r24 == false) goto L32;
        r9.add(r11);
        goto L32
    L41:
        if (((Collection) ZeusTransformUtils.preCheckCast(r22, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L43;
    L48:
        r24 = false;
        goto L49
    L51:
        r7 = (List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.aiagent.plugin");
        goto L52
    L55:
        return (Collection) ZeusTransformUtils.preCheckCast(p.c((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin")), Collection.class, "com.obric.aiagent.plugin");
    }

    public final List<String> c(Context r9, String r10, boolean r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        o.e(r12, "context");
        o.e(r10, "name");
        b(r12);
        String r8 = (String) ZeusTransformUtils.preCheckCast(j().get(r10), String.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L6;
        Loog.INSTANCE.d(TAG, " - [PackageTools] found a write-down app: " + r10 + " -> " + r8);
        return p.a(r8);
    L6:
        Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast(new k("\\s+").c((CharSequence) ZeusTransformUtils.preCheckCast(d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin")).toString(), CharSequence.class, "com.obric.aiagent.plugin"), 0), Iterable.class, "com.obric.aiagent.plugin");
        Collection r14 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r15 = r13.iterator();
    L7:
        boolean r2 = true;
        if (r15.hasNext() == false) goto L15;
        Object r0 = r15.next();
        if (((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.aiagent.plugin"), CharSequence.class, "com.obric.aiagent.plugin")).length() > 0) goto L13;
        r2 = false;
    L13:
        if (r2 == false) goto L7;
        r14.add(r0);
        goto L7
    L15:
        List r16 = (List) ZeusTransformUtils.preCheckCast(r14, List.class, "com.obric.aiagent.plugin");
        Map r17 = (Map) ZeusTransformUtils.preCheckCast(g, Map.class, "com.obric.aiagent.plugin");
        Map r1 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        Iterator r18 = r17.entrySet().iterator();
    L17:
        if (r18.hasNext() == false) goto L37;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r18.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3.getKey(), String.class, "com.obric.aiagent.plugin");
        CharSequence r5 = ((AppInfoEntry) ZeusTransformUtils.preCheckCast(r3.getValue(), AppInfoEntry.class, "com.obric.aiagent.plugin")).getAppLabel();
        if (r5 != null) goto L22;
        r5 = (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.aiagent.plugin");
    L22:
        if (r16.isEmpty() == false) goto L24;
    L23:
        boolean r6 = false;
    L35:
        if (r6 == false) goto L17;
        r1.put(r3.getKey(), r3.getValue());
        goto L17
    L24:
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r16, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r7, Collection.class) == true) goto L27;
    L29:
        Iterator r19 = r7.iterator();
    L31:
        if (r19.hasNext() == false) goto L28;
        if (d.o.o.c(r5, (CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r19.next(), String.class, "com.obric.aiagent.plugin"), CharSequence.class, "com.obric.aiagent.plugin"), r11) == true) goto L31;
    L28:
        r6 = true;
        goto L35
    L27:
        if (((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L29;
    L37:
        Collection r20 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r1.size()), Collection.class, "com.obric.aiagent.plugin");
        Iterator r21 = r1.entrySet().iterator();
    L39:
        if (r21.hasNext() == false) goto L42;
        r20.add(((AppInfoEntry) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r21.next(), Map.Entry.class, "com.obric.aiagent.plugin")).getValue(), AppInfoEntry.class, "com.obric.aiagent.plugin")).getAppInfo().packageName);
        goto L39
    L42:
        return (List) ZeusTransformUtils.preCheckCast(r20, List.class, "com.obric.aiagent.plugin");
    }

    private final Intent i(Context r2, String r3) {
        return ((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin")).getPackageManager().getLaunchIntentForPackage(r3);
    }

    private final Collection<LauncherEntryInfo> a(Context r11, String r12, List<? extends ResolveInfo> r13) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.aiagent.plugin");
        List<ResolveInfo> r14 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.aiagent.plugin");
        PackageManager r15 = r10.getPackageManager();
        if (r14 != null) goto L9;
        Intent r16 = new Intent("android.intent.action.MAIN");     // Catch: RuntimeException -> L6
        r16.addCategory("android.intent.category.LAUNCHER");     // Catch: RuntimeException -> L6
        r16.setPackage(r12);     // Catch: RuntimeException -> L6
        r14 = r15.queryIntentActivities(r16, 0);     // Catch: RuntimeException -> L6
        o.a(r14);     // Catch: RuntimeException -> L6
    L6:
        e = move-exception;
        Loog.INSTANCE.e(TAG, "Failed to query intent activities for " + r12 + " (runtime-exception): " + e.getMessage());
        r14 = p.b();
    L9:
        if (r14.isEmpty() == true) goto L11;
        Iterable r17 = (Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.aiagent.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r17, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r18 = r17.iterator();
    L14:
        if (r18.hasNext() == false) goto L24;
        ResolveInfo r3 = (ResolveInfo) ZeusTransformUtils.preCheckCast(r18.next(), ResolveInfo.class, "com.obric.aiagent.plugin");
        CharSequence r4 = r3.loadLabel(r15);
        Intent r6 = new Intent("android.intent.action.MAIN");
        r6.setFlags(268435456);
        IntentFilter r7 = r3.filter;
        if (r7 == null) goto L22;
        Iterator<String> r8 = r7.categoriesIterator();
        if (r8 == null) goto L22;
    L20:
        if (r8.hasNext() == false) goto L22;
        r6.addCategory((String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.aiagent.plugin"));
    L22:
        r6.addCategory("android.intent.category.LAUNCHER");
        r6.setClassName(r3.activityInfo.packageName, r3.activityInfo.name);
        x r5 = x.f38692a;
        r2.add(new LauncherEntryInfo(r12, r4, null, r6));
        goto L14
    L24:
        return (Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.aiagent.plugin"), Collection.class, "com.obric.aiagent.plugin");
    L11:
        return (Collection) ZeusTransformUtils.preCheckCast(p.b(), Collection.class, "com.obric.aiagent.plugin");
    }

    private final com.obric.autogui.platforms.tools.packages.a.c q() {
        return new com.obric.autogui.platforms.tools.packages.a.c(AOHostAppTools.INSTANCE.getHostAppPackage(), k(), f30439b, n(), p.q((Iterable) ZeusTransformUtils.preCheckCast(o(), Iterable.class, "com.obric.aiagent.plugin")), m);
    }

    private final Collection<LauncherShortcutInfo> j(Context r12, final String r13) {
        Context r14 = (Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.aiagent.plugin");
        if (AutoActionAbilitiesKt.isSupported(AutoActionAbility.PkgAccessLauncherShortcuts) == true) goto L47;
        return (Collection) ZeusTransformUtils.preCheckCast(p.b(), Collection.class, "com.obric.aiagent.plugin");
    L47:
        LauncherApps r15 = (LauncherApps) ZeusTransformUtils.preCheckCast(r14.getSystemService(LauncherApps.class), LauncherApps.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
    L11:
        if (r15 != null) goto L14;
        Loog.INSTANCE.e(TAG, " - [PackageTools] cannot find ShortcutService.");
        return (Collection) ZeusTransformUtils.preCheckCast(p.b(), Collection.class, "com.obric.aiagent.plugin");
    L14:
        LauncherApps.ShortcutQuery r3 = new LauncherApps.ShortcutQuery();
        r3.setQueryFlags(1024);
        r3.setPackage(r13);
        List<ShortcutInfo> r16 = r15.getShortcuts(r3, AOHostAppTools.INSTANCE.getUserHandle());     // Catch: RuntimeException -> L39 IllegalStateException -> L41 SecurityException -> L43
        if (r16 == null) goto L37;
        Iterable r17 = (Iterable) ZeusTransformUtils.preCheckCast(r16, Iterable.class, "com.obric.aiagent.plugin");     // Catch: RuntimeException -> L39 IllegalStateException -> L41 SecurityException -> L43
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");     // Catch: RuntimeException -> L39 IllegalStateException -> L41 SecurityException -> L43
        Iterator r18 = r17.iterator();     // Catch: RuntimeException -> L39 IllegalStateException -> L41 SecurityException -> L43
    L19:
        if (r18.hasNext() == false) goto L36;
        final ShortcutInfo r5 = (ShortcutInfo) ZeusTransformUtils.preCheckCast(r18.next(), ShortcutInfo.class, "com.obric.aiagent.plugin");     // Catch: RuntimeException -> L39 IllegalStateException -> L41 SecurityException -> L43
        final CharSequence r6 = r5.getShortLabel();     // Catch: RuntimeException -> L39 IllegalStateException -> L41 SecurityException -> L43
        if (r6 != null) goto L26;
        Loog.INSTANCE.w(TAG, " - [PackageTools] found a shortcut without label: " + r5.getId());     // Catch: RuntimeException -> L39 IllegalStateException -> L41 SecurityException -> L43
    L23:
        LauncherShortcutInfo r7 = null;
    L34:
        if (r7 == null) goto L19;
        r4.add(r7);     // Catch: RuntimeException -> L39 IllegalStateException -> L41 SecurityException -> L43
        goto L19
    L26:
        if (m.contains(r13) == false) goto L31;
        String r8 = r5.getId();     // Catch: RuntimeException -> L39 IllegalStateException -> L41 SecurityException -> L43
        o.c(r8, "getId(...)");     // Catch: RuntimeException -> L39 IllegalStateException -> L41 SecurityException -> L43
        if (d.o.o.b(r8, "miniapp.", false, 2, null) == false) goto L31;
        Loog.INSTANCE.dp(TAG, new $$Lambda$StandardPackagesTools$qk1W4Jnx2HdH8RLzSX9A0ByQ4Q(r5, r6, r13), new $$Lambda$StandardPackagesTools$ZUofkQsy8woMesThfaVjsVXeHZI(r5, r13));     // Catch: RuntimeException -> L39 IllegalStateException -> L41 SecurityException -> L43
        String r9 = r5.getId();     // Catch: RuntimeException -> L39 IllegalStateException -> L41 SecurityException -> L43
        o.c(r9, "getId(...)");     // Catch: RuntimeException -> L39 IllegalStateException -> L41 SecurityException -> L43
        r7 = (LauncherShortcutInfo) ZeusTransformUtils.preCheckCast(new DoubaoMiniAppInfo(r13, r6, null, r9), LauncherShortcutInfo.class, "com.obric.aiagent.plugin");     // Catch: RuntimeException -> L39 IllegalStateException -> L41 SecurityException -> L43
    L31:
        if (o.a(r13, AOHostAppTools.INSTANCE.getHostAppPackage()) == false) goto L33;
        Loog.INSTANCE.w(TAG, " - [PackageTools] disabled HostApp's shortcut: " + r5.getId() + " (" + r6 + ", " + r5.getShortLabel() + ") of package: " + r13);     // Catch: RuntimeException -> L39 IllegalStateException -> L41 SecurityException -> L43
        goto L23
    L33:
        Loog.INSTANCE.dp(TAG, new $$Lambda$StandardPackagesTools$77NJPbj1_kr4dBgSHqx1kl5cjzk(r5, r6, r13), new $$Lambda$StandardPackagesTools$Ezeokm53iHCdz4JPkZeeYf8rlf4(r5, r13));     // Catch: RuntimeException -> L39 IllegalStateException -> L41 SecurityException -> L43
        String r10 = r5.getId();     // Catch: RuntimeException -> L39 IllegalStateException -> L41 SecurityException -> L43
        o.c(r10, "getId(...)");     // Catch: RuntimeException -> L39 IllegalStateException -> L41 SecurityException -> L43
        r7 = new LauncherShortcutInfo(r13, r6, null, r10);     // Catch: RuntimeException -> L39 IllegalStateException -> L41 SecurityException -> L43
        goto L34
    L36:
        List r19 = (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.aiagent.plugin");     // Catch: RuntimeException -> L39 IllegalStateException -> L41 SecurityException -> L43
    L46:
        return (Collection) ZeusTransformUtils.preCheckCast(r19, Collection.class, "com.obric.aiagent.plugin");
    L37:
        r19 = p.b();     // Catch: RuntimeException -> L39 IllegalStateException -> L41 SecurityException -> L43
    L41:
        e = move-exception;
        Loog.INSTANCE.e(TAG, "Failed to query shortcuts for " + r13 + " (illegal-state): " + e.getMessage());
        r19 = p.b();
    L43:
        e = move-exception;
        Loog.INSTANCE.e(TAG, "Failed to query shortcuts for " + r13 + ": " + e.getMessage());
        r19 = p.b();
    L39:
        e = move-exception;
        Loog.INSTANCE.e(TAG, "Failed to query shortcuts for " + r13 + " (runtime-exception): " + e.getMessage());
        r19 = p.b();
    L9:
        th = move-exception;
        Loog.INSTANCE.w(TAG, " - [PackageTools] Failed to get LauncherApps service.", th);
        r15 = null;
        goto L11
    }

    private static final String a(ShortcutInfo r2, CharSequence r3, String r4) {
        return " - [PackageTools] found a MiniApp: " + r2.getId() + " (" + ((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin")) + ", " + r2.getShortLabel() + ") of package: " + r4;
    }

    private static final String a(ShortcutInfo r2, String r3) {
        return " - [PackageTools] found a MiniApp: " + r2.getId() + " of package: " + r3;
    }

    private static final String b(ShortcutInfo r2, CharSequence r3, String r4) {
        return " - [PackageTools] found a shortcut: " + r2.getId() + " (" + ((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin")) + ", " + r2.getShortLabel() + ") of package: " + r4;
    }

    private static final String b(ShortcutInfo r2, String r3) {
        return " - [PackageTools] found a shortcut: " + r2.getId() + " of package: " + r3;
    }

    public final Intent b(Context r6, String r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        o.e(r8, "context");
        o.e(r7, "packageName");
        if (f30439b.contains(r7) == false) goto L6;
        Loog.INSTANCE.w(TAG, "getLaunchIntent blocked for packageName=" + r7);
        return null;
    L6:
        AppInfoEntry r0 = a(r8, r7);
        if (r0 != null) goto L10;
        Loog.INSTANCE.w(TAG, "no such packageName=" + r7 + " exists in cached packageNames.");
        return null;
    L10:
        Intent r1 = r0.getLaunchIntent();
        Intent r3 = f30441d;
        if (o.a(r1, r3) == false) goto L13;
        return null;
    L13:
        if (r1 != null) goto L18;
        r1 = i(r8, r7);
        if (r1 != null) goto L17;
        r0.setLaunchIntent(r3);
        goto L18
    L17:
        r0.setLaunchIntent(r1);
    L18:
        return r1;
    }

    public static /* synthetic */ Object a(StandardPackagesTools r1, Context r2, boolean r3, d.c.d r4, int r5, Object r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        d.c.d<? super List<OpenableAppInfo>> r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r3 = true;
    L6:
        return r1.a(r7, r3, r8);
    }

    public final Object a(Context r10, boolean r11, d.c.d<? super List<OpenableAppInfo>> r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        d.c.d r14 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r12, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r14, d.class) == false) goto L7;
        d r0 = (d) ZeusTransformUtils.preCheckCast(r14, d.class, "com.obric.aiagent.plugin");
        if ((r0.f30452d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f30452d -= Integer.MIN_VALUE;
    L8:
        Object r15 = r0.f30450b;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f30452d;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r11 = r0.f30449a;
        d.o.a(r15);
    L18:
        if (g.isEmpty() == false) goto L23;
        List<OpenableAppInfo> r9 = f30442e.a();
        if (r9 == null) goto L22;
        return r9;
    L22:
        return p.b();
    L23:
        Collection<AppInfoEntry> r16 = g.values();
        o.c(r16, "<get-values>(...)");
        String r17 = AOHostAppTools.INSTANCE.getHostAppPackage();
        Iterable r18 = (Iterable) ZeusTransformUtils.preCheckCast(r16, Iterable.class, "com.obric.aiagent.plugin");
        Collection r19 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r20 = r18.iterator();
    L24:
        boolean r4 = false;
        if (r20.hasNext() == false) goto L36;
        Object r1 = r20.next();
        AppInfoEntry r5 = (AppInfoEntry) ZeusTransformUtils.preCheckCast(r1, AppInfoEntry.class, "com.obric.aiagent.plugin");
        if (f30438a.k() == true) goto L32;
        if (o.a(r17, r5.getAppInfo().packageName) == false) goto L32;
        Loog.INSTANCE.w(TAG, " - [PackageTool] CanOperateHostApp is set to false. (h=" + r17 + ')');
    L34:
        if (r4 == false) goto L24;
        r19.add(r1);
    L32:
        if (f30439b.contains(r5.getAppInfo().packageName) == true) goto L34;
        r4 = true;
        goto L34
    L36:
        List r21 = (List) ZeusTransformUtils.preCheckCast(r19, List.class, "com.obric.aiagent.plugin");
        if (r11 == false) goto L82;
        Iterable r110 = (Iterable) ZeusTransformUtils.preCheckCast(r21, Iterable.class, "com.obric.aiagent.plugin");
        Collection r111 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r112 = r110.iterator();
    L40:
        if (r112.hasNext() == false) goto L59;
        AppInfoEntry r6 = (AppInfoEntry) ZeusTransformUtils.preCheckCast(r112.next(), AppInfoEntry.class, "com.obric.aiagent.plugin");
        Collection<LauncherEntryInfo> r7 = r6.getLauncherEntries();
        if (r7 == null) goto L56;
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.aiagent.plugin");
        Collection r22 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r23 = r8.iterator();
    L45:
        if (r23.hasNext() == false) goto L55;
        LauncherEntryInfo r24 = (LauncherEntryInfo) ZeusTransformUtils.preCheckCast(r23.next(), LauncherEntryInfo.class, "com.obric.aiagent.plugin");
        CharSequence r25 = r24.getLabel();
        if (r25 == null) goto L49;
        String r26 = r25.toString();
    L50:
        if (r26 != null) goto L52;
        OpenableAppInfo r27 = null;
    L53:
        if (r27 == null) goto L45;
        r22.add(r27);
        goto L45
    L52:
        r27 = new OpenableAppInfo(r26, r24.getAppPackageName(), r6.getAppFirstSign(), OpenableAppInfo.OpenableAppType.LauncherEntry);
        goto L53
    L49:
        r26 = null;
        goto L50
    L55:
        List r28 = (List) ZeusTransformUtils.preCheckCast(r22, List.class, "com.obric.aiagent.plugin");
    L57:
        if (r28 == null) goto L40;
        r111.add(r28);
        goto L40
    L56:
        r28 = null;
        goto L57
    L59:
        List r113 = p.c((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r111, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"));
        Iterable r29 = (Iterable) ZeusTransformUtils.preCheckCast(r21, Iterable.class, "com.obric.aiagent.plugin");
        Collection r114 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r30 = r29.iterator();
    L61:
        if (r30.hasNext() == false) goto L81;
        AppInfoEntry r31 = (AppInfoEntry) ZeusTransformUtils.preCheckCast(r30.next(), AppInfoEntry.class, "com.obric.aiagent.plugin");
        Collection<LauncherShortcutInfo> r32 = r31.getLauncherShortcuts();
        if (r32 == null) goto L77;
        Iterable r33 = (Iterable) ZeusTransformUtils.preCheckCast(r32, Iterable.class, "com.obric.aiagent.plugin");
        Collection r34 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r35 = r33.iterator();
    L66:
        if (r35.hasNext() == false) goto L76;
        LauncherShortcutInfo r36 = (LauncherShortcutInfo) ZeusTransformUtils.preCheckCast(r35.next(), LauncherShortcutInfo.class, "com.obric.aiagent.plugin");
        CharSequence r37 = r36.getLabel();
        if (r37 == null) goto L70;
        String r38 = r37.toString();
    L71:
        if (r38 != null) goto L73;
        OpenableAppInfo r39 = null;
    L74:
        if (r39 == null) goto L66;
        r34.add(r39);
        goto L66
    L73:
        r39 = new OpenableAppInfo(r38, r36.getAppPackageName(), r31.getAppFirstSign(), OpenableAppInfo.OpenableAppType.LauncherShortcut);
        goto L74
    L70:
        r38 = null;
        goto L71
    L76:
        List r40 = (List) ZeusTransformUtils.preCheckCast(r34, List.class, "com.obric.aiagent.plugin");
    L78:
        if (r40 == null) goto L61;
        r114.add(r40);
        goto L61
    L77:
        r40 = null;
        goto L78
    L81:
        return p.c((Collection) ZeusTransformUtils.preCheckCast(r113, Collection.class, "com.obric.aiagent.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(p.c((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r114, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin")), Iterable.class, "com.obric.aiagent.plugin"));
    L82:
        Iterable r41 = (Iterable) ZeusTransformUtils.preCheckCast(r21, Iterable.class, "com.obric.aiagent.plugin");
        Collection r115 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r42 = r41.iterator();
    L84:
        if (r42.hasNext() == false) goto L93;
        Object r116 = r42.next();
        AppInfoEntry r43 = (AppInfoEntry) ZeusTransformUtils.preCheckCast(r116, AppInfoEntry.class, "com.obric.aiagent.plugin");
        if (r43.getLaunchIntent() != null) goto L88;
    L90:
        boolean r44 = false;
    L91:
        if (r44 == false) goto L84;
        r115.add(r116);
        goto L84
    L88:
        if (o.a(r43.getLaunchIntent(), f30441d) == true) goto L90;
        r44 = true;
        goto L91
    L93:
        Iterable r45 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r115, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
        Collection r117 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r46 = r45.iterator();
    L95:
        if (r46.hasNext() == false) goto L106;
        AppInfoEntry r118 = (AppInfoEntry) ZeusTransformUtils.preCheckCast(r46.next(), AppInfoEntry.class, "com.obric.aiagent.plugin");
        CharSequence r47 = r118.getAppLabel();
        if (r47 == null) goto L99;
        String r48 = r47.toString();
    L100:
        if (r48 != null) goto L102;
        OpenableAppInfo r49 = null;
    L103:
        if (r49 == null) goto L95;
        r117.add(r49);
        goto L95
    L102:
        String r50 = r118.getAppInfo().packageName;
        o.c(r50, "packageName");
        r49 = new OpenableAppInfo(r48, r50, r118.getAppFirstSign(), OpenableAppInfo.OpenableAppType.AppName);
        goto L103
    L99:
        r48 = null;
        goto L100
    L106:
        return (List) ZeusTransformUtils.preCheckCast(r117, List.class, "com.obric.aiagent.plugin");
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r15);
        r0.f30449a = r11;
        r0.f30452d = 1;
        if (b(r13, r0) != r2) goto L18;
        return r2;
    L7:
        r0 = new d(this, r14);
        goto L8
    }

    private final Drawable k(Context r3, String r4) {
        return ((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin")).getPackageManager().getApplicationIcon(r4);
    L5:
        th = move-exception;
        Loog.INSTANCE.e(TAG, "[PackageTools] failed to load icon for `" + r4 + "`; e=" + th, th);
        return null;
    }

    public final Drawable c(Context r5, String r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        o.e(r7, "context");
        o.e(r6, "packageName");
        StandardPackagesTools$mIconCache$1 r0 = i;
        Drawable r1 = (Drawable) ZeusTransformUtils.preCheckCast(r0.get(r6), Drawable.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L5;
        return r1;
    L5:
        Drawable r4 = k(r7, r6);
        if (r4 != null) goto L9;
        return null;
    L9:
        r0.put(r6, r4);
        return r4;
    }

    private final String a(PackageInfo r14) {
        SigningInfo r2 = r14.signingInfo;     // Catch: Throwable -> L16
        if (r2 == null) goto L10;
        Signature[] r3 = r2.getApkContentsSigners();     // Catch: Throwable -> L16
        if (r3 == null) goto L10;
        Signature r4 = r3[0];     // Catch: Throwable -> L16
        if (r4 == null) goto L10;
        byte[] r5 = r4.toByteArray();     // Catch: Throwable -> L16
    L11:
        if (r5 != null) goto L14;
        Loog.INSTANCE.e(TAG, "[Sign] while loading sign of " + r14.packageName + ": cert is NULL.");     // Catch: Throwable -> L16
        return null;
    L14:
        MessageDigest r6 = MessageDigest.getInstance("SHA-256");     // Catch: Throwable -> L16
        r6.update(r5);     // Catch: Throwable -> L16
        byte[] r7 = r6.digest();     // Catch: Throwable -> L16
        o.a(r7);     // Catch: Throwable -> L16
        String r8 = d.a.i.a(r7, (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, $$Lambda$StandardPackagesTools$2iZ7YiUGp_PZTui1sPDfUyvW4rE.INSTANCE, 30, null);     // Catch: Throwable -> L16
        Loog.INSTANCE.i(TAG, "[Sign] sha256Hex=" + r8);     // Catch: Throwable -> L16
        return r8;
    L10:
        r5 = null;
    L16:
        th = move-exception;
        Loog.INSTANCE.e(TAG, "[Sign] while loading sign of " + r14.packageName + ": cert is not digestable.", th);
        return null;
    }

    private static final CharSequence a(byte r3) {
        String r4 = String.format("%02x", Arrays.copyOf(new Object[]{Integer.valueOf(r3 & 255)}, 1));
        o.c(r4, "format(...)");
        return (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin");
    }

    public final String d(Context r11, String r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.aiagent.plugin");
        o.e(r13, "context");
        o.e(r12, "packageName");
        boolean r1 = true;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L6:
        String r3 = null;
        if (r0 == false) goto L9;
        return null;
    L9:
        AppInfoEntry r10 = a(r13, r12);
        if (r10 != null) goto L12;
        return null;
    L12:
        String r2 = r10.getAppFirstSign();
        if (r2 == null) goto L16;
        return r2;
    L16:
        if (Build.VERSION.SDK_INT >= 28) goto L18;
        return null;
    L18:
        Object r4 = r10.getSignLock();
        monitor-enter(r4);
        String r5 = r10.getAppFirstSign();     // Catch: Throwable -> L38
        if (r5 == null) goto L24;
        monitor-exit(r4);
        return r5;
    L24:
        long r6 = AOSystemTools.INSTANCE.bootTimeMillis();     // Catch: Throwable -> L38
        PackageInfo r14 = r13.getPackageManager().getPackageInfo(r12, 134217728);     // Catch: Throwable -> L27
        StandardPackagesTools r7 = f30438a;     // Catch: Throwable -> L27
        o.a(r14);     // Catch: Throwable -> L27
        r3 = r7.a(r14);     // Catch: Throwable -> L27
    L29:
        if (r3 == null) goto L31;
        r10.setAppFirstSign(r3);     // Catch: Throwable -> L38
    L31:
        Loog r15 = Loog.INSTANCE;     // Catch: Throwable -> L38
        StringBuilder r16 = new StringBuilder().append("[Sign] getAppSign for `").append(r12).append("` spent=").append(AOSystemTools.INSTANCE.bootTimeMillis() - r6).append("ms, hasSign=");     // Catch: Throwable -> L38
        if (r3 != null) goto L35;
        r1 = false;
    L35:
        r15.i(TAG, r16.append(r1).toString());     // Catch: Throwable -> L38
        monitor-exit(r4);
        return r3;
    L27:
        th = move-exception;
        Loog.INSTANCE.e(TAG, "[Sign] failed to load signature for `" + r12 + "`; e=" + th, th);     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        throw th;
    L5:
        r0 = false;
        goto L6
    }

    public final String e(Context r12, String r13) {
        Context r14 = (Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.aiagent.plugin");
        o.e(r14, "context");
        o.e(r13, "packageName");
        boolean r1 = true;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L6:
        String r3 = null;
        if (r0 == false) goto L9;
        return null;
    L9:
        AppInfoEntry r11 = a(r14, r13);
        if (r11 != null) goto L12;
        return null;
    L12:
        String r2 = r11.getAppMd5();
        if (r2 == null) goto L15;
        return r2;
    L15:
        Object r4 = r11.getMd5Lock();
        monitor-enter(r4);
        String r5 = r11.getAppMd5();     // Catch: Throwable -> L44
        if (r5 == null) goto L21;
        monitor-exit(r4);
        return r5;
    L21:
        long r6 = AOSystemTools.INSTANCE.bootTimeMillis();     // Catch: Throwable -> L44
        String r7 = r14.getPackageManager().getApplicationInfo(r13, 0).sourceDir;     // Catch: Throwable -> L33
        CharSequence r8 = (CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L33
        if (r8 != null) goto L25;
    L28:
        boolean r9 = true;
    L29:
        if (r9 == false) goto L31;
        Loog.INSTANCE.e(TAG, "[Md5] no sourceDir for `" + r13 + "`.");     // Catch: Throwable -> L33
    L35:
        if (r3 == null) goto L37;
        r11.setAppMd5(r3);     // Catch: Throwable -> L44
        r11.setAntiFraudApkUpdateTime(f30438a.l(r14, r13));     // Catch: Throwable -> L44
    L37:
        Loog r15 = Loog.INSTANCE;     // Catch: Throwable -> L44
        StringBuilder r16 = new StringBuilder().append("[Md5] getAppApkMd5 for `").append(r13).append("` spent=").append(AOSystemTools.INSTANCE.bootTimeMillis() - r6).append("ms, hasMd5=");     // Catch: Throwable -> L44
        if (r3 != null) goto L41;
        r1 = false;
    L41:
        r15.i(TAG, r16.append(r1).toString());     // Catch: Throwable -> L44
        monitor-exit(r4);
        return r3;
    L31:
        r3 = f30438a.a(new File(r7));     // Catch: Throwable -> L33
        goto L35
    L25:
        if (r8.length() == 0) goto L28;
        r9 = false;
    L33:
        th = move-exception;
        Loog.INSTANCE.e(TAG, "[Md5] failed to compute md5 for `" + r13 + "`; e=" + th, th);     // Catch: Throwable -> L44
    L44:
        th = move-exception;
        throw th;
    L5:
        r0 = false;
        goto L6
    }

    private final long l(Context r3, String r4) {
        return ((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin")).getPackageManager().getPackageInfo(r4, 0).lastUpdateTime;
    L5:
        th = move-exception;
        Loog.INSTANCE.e(TAG, "[AntiFraud] failed to read lastUpdateTime for `" + r4 + "`; e=" + th, th);
        return 0;
    }

    public final String a(String r4) {
        o.e(r4, "packageName");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L5;
        boolean r3 = true;
    L6:
        String r1 = null;
        if (r3 == false) goto L9;
        return null;
    L9:
        AppInfoEntry r5 = (AppInfoEntry) ZeusTransformUtils.preCheckCast(g.get(r4), AppInfoEntry.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L12;
        r1 = r5.getAppMd5();
    L12:
        if (r1 != null) goto L16;
        Context r6 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContextOrNull(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L16;
        f30438a.g(r6, r4);
    L16:
        return r1;
    L5:
        r3 = false;
        goto L6
    }

    public final boolean f(Context r5, String r6) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "context");
        o.e(r6, "packageName");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L5;
        boolean r7 = true;
    L6:
        if (r7 == false) goto L8;
        return false;
    L8:
        AppInfoEntry r8 = (AppInfoEntry) ZeusTransformUtils.preCheckCast(g.get(r6), AppInfoEntry.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L22;
        ApplicationInfo r9 = r8.getAppInfo();
        if (r9 == null) goto L22;
        int r10 = r9.flags;
    L15:
        if ((r10 & 129) == 0) goto L18;
        return true;
    L18:
        return false;
    L22:
        r10 = r4.getPackageManager().getApplicationInfo(r6, 0).flags;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        Loog.INSTANCE.e(TAG, "[SysApp] failed to get flags for `" + r6 + "`; e=" + th, th);
        return false;
    L5:
        r7 = false;
        goto L6
    }

    public final void g(Context r8, String r9) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
        o.e(r7, "context");
        o.e(r9, "packageName");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L5;
        boolean r10 = true;
    L6:
        if (r10 == false) goto L8;
        return;
    L8:
        AppInfoEntry r11 = (AppInfoEntry) ZeusTransformUtils.preCheckCast(g.get(r9), AppInfoEntry.class, "com.obric.aiagent.plugin");
        if (r11 == null) goto L16;
        if (r11.getAppFirstSign() == null) goto L16;
        if (r11.getAppMd5() == null) goto L16;
        return;
    L16:
        if (j.add(r9) == true) goto L19;
        Loog.INSTANCE.d(TAG, "[AntiFraud] prefetch already in-flight, skip: " + r9);
        return;
    L19:
        Loog.INSTANCE.i(TAG, "[AntiFraud] prefetch sign+md5 start: " + r9);
        i.a(an.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin")), null, null, (m) ZeusTransformUtils.preCheckCast(new e(r9, r7, null), m.class, "com.obric.aiagent.plugin"), 3, null);
        return;
    L5:
        r10 = false;
        goto L6
    }

    private final void a(String r8, boolean r9) {
        AppInfoEntry r0 = (AppInfoEntry) ZeusTransformUtils.preCheckCast(g.get(r8), AppInfoEntry.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L5;
        String r3 = r0.getAppFirstSign();
    L6:
        boolean r4 = true;
        if (r3 == null) goto L9;
        boolean r5 = true;
    L10:
        if (r0 == null) goto L12;
        String r6 = r0.getAppMd5();
    L13:
        if (r6 != null) goto L16;
        r4 = false;
    L16:
        if (r0 == null) goto L18;
        r0.setAppFirstSign(null);
        r0.setAppMd5(null);
    L18:
        Loog.INSTANCE.i(TAG, "[AntiFraud] invalidated cache for `" + r8 + "` (sign=" + r5 + ", md5=" + r4 + ')');
        if (r9 == false) goto L22;
        g((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r8);
        return;
    L22:
        return;
    L12:
        r6 = null;
        goto L13
    L9:
        r5 = false;
        goto L10
    L5:
        r3 = null;
        goto L6
    }

    private final void a(String r7, String r8, String r9, long r10) {
        long r2 = l((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r7);
        if (r10 != 0) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r0 == false) goto L16;
        if (r8 == null) goto L16;
        if (r9 == null) goto L16;
        AppInfoEntry r6 = (AppInfoEntry) ZeusTransformUtils.preCheckCast(g.get(r7), AppInfoEntry.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L14;
        r6.setAppFirstSign(r8);
        r6.setAppMd5(r9);
        r6.setAntiFraudApkUpdateTime(r10);
    L14:
        Loog.INSTANCE.i(TAG, "[AntiFraud] apk unchanged for `" + r7 + "` (updateTime=" + r10 + "), reuse cached sign/md5");
        return;
    L16:
        a(r7, true);
        return;
    L5:
        if (r10 != r2) goto L7;
        r0 = true;
        goto L8
    }

    private final String a(File r19) {
        if (r19.isFile() == true) goto L6;
        Loog.INSTANCE.e(TAG, "[Md5] not a file: " + r19.getPath());
        return null;
    L6:
        long r4 = AOSystemTools.INSTANCE.bootTimeMillis();
        MessageDigest r1 = MessageDigest.getInstance(CryptoConst.ALGORITHM_MD5);     // Catch: Throwable -> L28
        Closeable r6 = (Closeable) ZeusTransformUtils.preCheckCast(new FileInputStream(r19), Closeable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L26
        FileInputStream r8 = (FileInputStream) ZeusTransformUtils.preCheckCast(r6, FileInputStream.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L19
        byte[] r9 = new byte[8192];     // Catch: Throwable -> L19
    L11:
        int r10 = r8.read(r9);     // Catch: Throwable -> L19
        if (r10 < 0) goto L13;
        r1.update(r9, 0, r10);     // Catch: Throwable -> L19
        goto L11
    L13:
        x r11 = x.f38692a;     // Catch: Throwable -> L19
        d.f.c.a(r6, null);     // Catch: Throwable -> L26
        byte[] r12 = r1.digest();     // Catch: Throwable -> L26
        o.c(r12, "digest(...)");     // Catch: Throwable -> L26
        String r0 = d.a.i.a(r12, (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, $$Lambda$StandardPackagesTools$m1GYn5vRxEpiJoIq9tC1qJdOGBI.INSTANCE, 30, null);     // Catch: Throwable -> L26
        Loog.INSTANCE.i(TAG, "[Md5] computeFileMd5 for " + r19.getPath() + " (size=" + r19.length() + "B) spent=" + (AOSystemTools.INSTANCE.bootTimeMillis() - r4) + "ms");     // Catch: Throwable -> L26
        return r0;
    L19:
        th = move-exception;
        throw th;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        d.f.c.a(r6, th);     // Catch: Throwable -> L26
        throw th;     // Catch: Throwable -> L26
    L26:
        th = th;
    L30:
        Loog.INSTANCE.e(TAG, "[Md5] failed to stream md5 for " + r19.getPath() + "; e=" + th, th);
        return null;
    L28:
        th = th;
        goto L30
    }

    private static final CharSequence b(byte r3) {
        String r4 = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(r3)}, 1));
        o.c(r4, "format(...)");
        return (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin");
    }

    static /* synthetic */ void a(StandardPackagesTools r0, String r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = false;
    L5:
        r0.b(r1, r2);
    }

    private final void b(String r10, boolean r11) {
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        PackageInfo r3 = r2.getPackageManager().getPackageInfo(r10, 128);     // Catch: Throwable -> L5
        o.a(r3);     // Catch: Throwable -> L5
        a(this, r2, r3, r11, null, null, 24, null);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Loog.INSTANCE.e(TAG, "got null when finding appInfo for `" + r10 + "`; e=" + th, th);
    }

    static /* synthetic */ void a(StandardPackagesTools r7, Context r8, PackageInfo r9, boolean r10, List r11, Map r12, int r13, Object r14) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
        List<? extends ResolveInfo> r15 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin");
        Map<String, AppInfoEntry> r16 = (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.aiagent.plugin");
        if ((r13 & 8) == 0) goto L5;
        List<? extends ResolveInfo> r5 = null;
    L7:
        if ((r13 & 16) == 0) goto L9;
        Map<String, AppInfoEntry> r6 = null;
    L10:
        r7.a(r2, r9, r10, r5, r6);
        return;
    L9:
        r6 = r16;
        goto L10
    L5:
        r5 = r15;
        goto L7
    }

    private final void a(Context r22, PackageInfo r23, boolean r24, List<? extends ResolveInfo> r25, Map<String, AppInfoEntry> r26) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r22, Context.class, "com.obric.aiagent.plugin");
        List<? extends ResolveInfo> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r25, List.class, "com.obric.aiagent.plugin");
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r26, Map.class, "com.obric.aiagent.plugin");
        ApplicationInfo r14 = r23.applicationInfo;
        if (r14 != null) goto L6;
        Loog.INSTANCE.e(TAG, "[LoadApp] got NULL appInfo for pkgInfo=" + r23.packageName);
        return;
    L6:
        PackageManager r1 = r2.getPackageManager();
        if (r4 != null) goto L9;
        Map r15 = (Map) ZeusTransformUtils.preCheckCast(g, Map.class, "com.obric.aiagent.plugin");
    L11:
        if (r15.containsKey(r14.packageName) == false) goto L14;
        if (r24 == true) goto L14;
        return;
    L14:
        long r18 = AOSystemTools.INSTANCE.bootTimeMillis();
        CharSequence r8 = r1.getApplicationLabel(r14);
        o.c(r8, "getApplicationLabel(...)");
        String r5 = r14.packageName;
        o.c(r5, "packageName");
        Collection<LauncherEntryInfo> r10 = a(r2, r5, r3);
        if (l() == false) goto L21;
        LauncherEntryInfo r6 = (LauncherEntryInfo) ZeusTransformUtils.preCheckCast(p.f((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.aiagent.plugin")), LauncherEntryInfo.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L20;
        Intent r7 = r6.getIntent();
        if (r7 == null) goto L20;
    L24:
        Intent r9 = r7;
        if (r9 == f30441d) goto L27;
    L32:
        String r11 = r14.packageName;
        o.c(r11, "packageName");
        Collection<LauncherShortcutInfo> r0 = j(r2, r11);
    L33:
        Map r20 = r15;
        AppInfoEntry r12 = new AppInfoEntry(r14, r9, r8, null, r10, r0, null, null, 0, 384, null);
        if (r4 == null) goto L36;
        r20.put(r14.packageName, r12);
    L41:
        if (com.obric.autogui.common.b.b.f29001a.a() == false) goto L49;
        Loog.INSTANCE.d(TAG, "added app-info entry: " + r14.packageName + "; spent=" + (AOSystemTools.INSTANCE.bootTimeMillis() - r18) + "ms");
        return;
    L49:
        return;
    L36:
        ConcurrentHashMap<String, AppInfoEntry> r13 = g;
        monitor-enter(r13);
        r20.put(r14.packageName, r12);     // Catch: Throwable -> L44
        x r16 = x.f38692a;     // Catch: Throwable -> L44
        monitor-exit(r13);
    L44:
        th = move-exception;
        throw th;
    L27:
        if (o().contains(r14.packageName) == true) goto L32;
        if (n() == false) goto L32;
        r0 = (Collection) ZeusTransformUtils.preCheckCast(p.b(), Collection.class, "com.obric.aiagent.plugin");
    L20:
        r7 = f30441d;
        goto L24
    L21:
        String r17 = r14.packageName;
        o.c(r17, "packageName");
        r7 = i(r2, r17);
        if (r7 != null) goto L24;
        r7 = f30441d;
        goto L24
    L9:
        r15 = r4;
        goto L11
    }

    private final void b(String r4) {
        ConcurrentHashMap<String, AppInfoEntry> r3 = g;
        monitor-enter(r3);
        AppInfoEntry r0 = (AppInfoEntry) ZeusTransformUtils.preCheckCast(g.remove(r4), AppInfoEntry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L8
        monitor-exit(r3);
        Loog.INSTANCE.i(TAG, "removed app-info entry: " + r4);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public final void b() {
        Loog.INSTANCE.i(TAG, " - initialising app-list listening...");
        LauncherApps r0 = (LauncherApps) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getSystemService(LauncherApps.class), LauncherApps.class, "com.obric.aiagent.plugin");
        AOThreadingTools.INSTANCE.launchUI((m) ZeusTransformUtils.preCheckCast(new g(r0, null), m.class, "com.obric.aiagent.plugin"));
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        f30442e.a(r1, q());
        AOThreadingTools.INSTANCE.launchIO((m) ZeusTransformUtils.preCheckCast(new h(r1, null), m.class, "com.obric.aiagent.plugin"));
    }

    public final boolean h(Context r11, String r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.aiagent.plugin");
        o.e(r13, "context");
        o.e(r12, "packageName");
        if (f30439b.contains(r12) == false) goto L6;
        Loog.INSTANCE.w(TAG, "openAppOnMainDisplay blocked for packageName=" + r12);
        return false;
    L6:
        Intent r0 = b(r13, r12);
        if (r0 != null) goto L10;
        Loog.INSTANCE.w(TAG, "no launch intent found for packageName=" + r12 + "; refreshing cache...");
        b(r12, true);
        r0 = b(r13, r12);
    L10:
        if (r0 != null) goto L13;
        Loog.INSTANCE.e(TAG, "no launch intent found for packageName=" + r12 + "; failed to open.");
        return false;
    L13:
        boolean r6 = false;
    L14:
        StartActivityResult r1 = AOSystemTools.INSTANCE.startActivity(r13, r0, StartActivityPosition.MainDisplay);
        if (r1.getOk() == true) goto L16;
        int r7 = b.f30443a[r1.getStatus().ordinal()];
        if (r7 == 1) goto L40;
        if (r7 != 2) goto L22;
        if (r6 == true) goto L33;
        Loog.INSTANCE.w(TAG, "ActivityNotFound for packageName=" + r12 + "; refreshing cache... ");
        b(r12, true);
        r0 = b(r13, r12);
        if (r0 == null) goto L37;
        r6 = true;
        goto L14
    L37:
        Loog.INSTANCE.e(TAG, "no launch intent found for packageName=" + r12 + "; failed to open.");
        return false;
    L33:
        Loog.INSTANCE.e(TAG, "[second trial] ActivityNotFound for packageName=" + r12 + ". (TargetNotFound)");
        Loog.INSTANCE.e(TAG, "failed to open packageName=" + r12 + " because activity is not openable.");
        return false;
    L22:
        if (r7 != 3) goto L24;
    L30:
        Loog.INSTANCE.e(TAG, "failed to open packageName=" + r12 + "; e=" + r1.getStatus());
        return false;
    L24:
        if (r7 == 4) goto L30;
        if (r7 == 5) goto L30;
        throw new d.k();
    L40:
        return true;
    L16:
        return true;
    }

    public final void a(Context r9) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        o.e(r8, "context");
        ca r10 = h;
        if (r10 == null) goto L5;
        ca.a.a(r10, null, 1, null);
    L5:
        h = i.a(an.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin")), null, null, (m) ZeusTransformUtils.preCheckCast(new f(r8, null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    private final boolean c(Context r20) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r20, Context.class, "com.obric.aiagent.plugin");
        Loog.INSTANCE.i(TAG, "refreshAppInfoInternal");
        long r11 = AOSystemTools.INSTANCE.bootTimeMillis();
        PackageManager r1 = r9.getPackageManager();
        n.a r0 = n.f38560a;     // Catch: Throwable -> L9
        if (((StandardPackagesTools) ZeusTransformUtils.preCheckCast(this, StandardPackagesTools.class, "com.obric.aiagent.plugin")).p() == false) goto L6;
        int r2 = 128;
    L7:
        Object r3 = n.f(r1.getInstalledPackages(r2));     // Catch: Throwable -> L9
    L11:
        Throwable r4 = n.c(r3);
        String r5 = "";
        if (r4 == null) goto L18;
        String r6 = r4.getMessage();
        if (r6 == null) goto L17;
        r5 = r6;
    L17:
        Loog.INSTANCE.e(TAG, "getInstalledPackages error: " + r4.getMessage(), r4);
    L18:
        String r13 = r5;
        List r7 = p.b();
        if (n.b(r3) == false) goto L21;
        r3 = r7;
    L21:
        List<? extends PackageInfo> r14 = (List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.aiagent.plugin");
        if (a(r14) == true) goto L26;
        Loog.INSTANCE.e(TAG, "[PackageTools] no packages found!");
        if (r9.checkSelfPermission("com.android.permission.GET_INSTALLED_APPS") == 0) goto L26;
        Loog.INSTANCE.e(TAG, " - [PackageTools] no permission to get installed apps!");
        boolean r15 = true;
    L27:
        ConcurrentHashMap<String, AppInfoEntry> r8 = new ConcurrentHashMap(r14.size() + 16);
        List<ResolveInfo> r10 = r1.queryIntentActivities(new Intent("android.intent.action.MAIN").addCategory("android.intent.category.LAUNCHER"), 0);     // Catch: RuntimeException -> L30
        o.a(r10);     // Catch: RuntimeException -> L30
    L32:
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.aiagent.plugin");
        Map r16 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        Iterator r17 = r12.iterator();
    L34:
        if (r17.hasNext() == false) goto L39;
        Object r18 = r17.next();
        String r19 = ((ResolveInfo) ZeusTransformUtils.preCheckCast(r18, ResolveInfo.class, "com.obric.aiagent.plugin")).activityInfo.packageName;
        Object r21 = r16.get(r19);
        if (r21 != null) goto L38;
        r21 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        r16.put(r19, r21);
    L38:
        ((List) ZeusTransformUtils.preCheckCast(r21, List.class, "com.obric.aiagent.plugin")).add(r18);
        goto L34
    L39:
        Iterator<? extends PackageInfo> r22 = r14.iterator();
    L41:
        if (r22.hasNext() == false) goto L50;
        PackageInfo r23 = (PackageInfo) ZeusTransformUtils.preCheckCast(r22.next(), PackageInfo.class, "com.obric.aiagent.plugin");
        ApplicationInfo r24 = r23.applicationInfo;
        if (r24 == null) goto L49;
        String r25 = r24.packageName;
        if (r25 == null) goto L49;
        o.a(r23);
        a(r9, r23, true, (List) ZeusTransformUtils.preCheckCast(r16.get(r25), List.class, "com.obric.aiagent.plugin"), (Map) ZeusTransformUtils.preCheckCast(r8, Map.class, "com.obric.aiagent.plugin"));
    L49:
        r8 = r8;
        r16 = r16;
        goto L41
    L50:
        g = r8;
        long r26 = AOSystemTools.INSTANCE.bootTimeMillis() - r11;
        Loog.INSTANCE.i(TAG, "refreshed app info cache in " + r26 + "ms; app_size=" + r14.size());
        IAutoActionTrackingApi r27 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");
        JSONObject r28 = new JSONObject();
        r28.put("duration", r26);
        r28.put("app_size", r14.size());
        r28.put("permission_not_granted", r15);
        r28.put(WsConstants.KEY_CONNECTION_ERROR, r13);
        x r29 = x.f38692a;
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r27, "oauto_refresh_app_info", r28, false, false, null, 28, null);
        return r15;
    L30:
        e = move-exception;
        Loog.INSTANCE.e(TAG, "Failed to batch query launcher activities: " + e.getMessage());
        r10 = p.b();
    L26:
        r15 = false;
        goto L27
    L6:
        r2 = 0;
    L9:
        th = move-exception;
        n.a r30 = n.f38560a;
        r3 = n.f(d.o.a(th));
        goto L11
    }
}
