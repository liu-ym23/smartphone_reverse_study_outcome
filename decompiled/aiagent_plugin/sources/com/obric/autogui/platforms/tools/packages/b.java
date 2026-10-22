package com.obric.autogui.platforms.tools.packages;

import android.app.Activity;
import android.app.ActivityOptions;
import android.app.TaskInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.LauncherApps;
import android.graphics.drawable.Drawable;
import android.os.Build;
import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.AOPlatformTools;
import com.obric.autogui.common.api.platform.packages.IAutoActionPackagesApi;
import com.obric.autogui.common.api.platform.packages.StartActivityPosition;
import com.obric.autogui.common.api.platform.packages.StartActivityResult;
import com.obric.autogui.common.api.platform.packages.appinfo.AppInfoEntry;
import com.obric.autogui.common.api.platform.packages.appinfo.LauncherEntryInfo;
import com.obric.autogui.common.api.platform.packages.appinfo.LauncherShortcutInfo;
import com.obric.autogui.common.api.platform.packages.appinfo.OpenableAppInfo;
import com.obric.autogui.common.api.space.AOOperatingSpace;
import com.obric.autogui.common.api.space.DisplayOperatingSpace;
import com.obric.autogui.common.api.space.OperatingSpaceManager;
import com.obric.autogui.common.api.virtualdisplay.AutoActionVirtualDisplay;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.d;
import d.c.b.a.f;
import d.h.b.h;
import d.h.b.o;
import d.h.b.z;
import d.k;
import d.l;
import java.util.Collection;
import java.util.Iterator;
import kotlinx.coroutines.ax;

/* JADX INFO: compiled from: StandardPackagesApiImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b implements IAutoActionPackagesApi {
    private static final String TAG = "Std/PkgApi";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f30510a = null;

    /* JADX INFO: compiled from: StandardPackagesApiImpl.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: renamed from: com.obric.autogui.platforms.tools.packages.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: StandardPackagesApiImpl.kt */
    public /* synthetic */ class C0820b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f30511a = null;

        static {
            int[] r0 = new int[StartActivityPosition.values().length];
            r0[StartActivityPosition.ActiveOperatingSpace.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[StartActivityPosition.MainDisplay.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f30511a = r0;
        }
    }

    /* JADX INFO: compiled from: StandardPackagesApiImpl.kt */
    @f(b = "StandardPackagesApiImpl.kt", c = {338}, d = "killAppAndDelay", e = "com.obric.autogui.platforms.tools.packages.StandardPackagesApiImpl")
    static final class c extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f30512a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f30513b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ b f30514c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f30515d;

        c(b r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f30514c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            this.f30513b = r7;
            this.f30515d |= Integer.MIN_VALUE;
            return this.f30514c.killAppAndDelay(null, false, 0, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        f30510a = new a(null);
    }

    /* JADX INFO: renamed from: lambda$Hj9-CTBJ1REHSURf5JhOgIuBLG0, reason: not valid java name */
    public static /* synthetic */ String m874lambda$Hj9CTBJ1REHSURf5JhOgIuBLG0(TaskInfo r0, String r1, z.a r2) {
        return a(r0, r1, r2);
    }

    public b() {
    }

    @Override // com.obric.autogui.common.api.platform.packages.IAutoActionPackagesApi
    public void init(Context r2) {
        o.e((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), "context");
        StandardPackagesTools.f30438a.b();
    }

    @Override // com.obric.autogui.common.api.platform.packages.IAutoActionPackagesApi
    public void registerPackageChangeListener(IAutoActionPackagesApi.PackageChangeListener r2) {
        IAutoActionPackagesApi.PackageChangeListener r1 = (IAutoActionPackagesApi.PackageChangeListener) ZeusTransformUtils.wrapperContextForParams(r2, IAutoActionPackagesApi.PackageChangeListener.class, "com.obric.aiagent.plugin");
        o.e(r1, "listener");
        StandardPackagesTools.f30438a.a(r1);
    }

    @Override // com.obric.autogui.common.api.platform.packages.IAutoActionPackagesApi
    public void unregisterPackageChangeListener(IAutoActionPackagesApi.PackageChangeListener r2) {
        IAutoActionPackagesApi.PackageChangeListener r1 = (IAutoActionPackagesApi.PackageChangeListener) ZeusTransformUtils.wrapperContextForParams(r2, IAutoActionPackagesApi.PackageChangeListener.class, "com.obric.aiagent.plugin");
        o.e(r1, "listener");
        StandardPackagesTools.f30438a.b(r1);
    }

    @Override // com.obric.autogui.common.api.platform.packages.IAutoActionPackagesApi
    public AppInfoEntry getAppInfo(Context r2, String r3) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        o.e(r3, "packageName");
        return StandardPackagesTools.f30438a.a(r1, r3);
    }

    @Override // com.obric.autogui.common.api.platform.packages.IAutoActionPackagesApi
    public String getAppSign(Context r2, String r3) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        o.e(r3, "packageName");
        return StandardPackagesTools.f30438a.d(r1, r3);
    }

    @Override // com.obric.autogui.common.api.platform.packages.IAutoActionPackagesApi
    public String getAppApkMd5(Context r2, String r3) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        o.e(r3, "packageName");
        return StandardPackagesTools.f30438a.e(r1, r3);
    }

    @Override // com.obric.autogui.common.api.platform.packages.IAutoActionPackagesApi
    public String getAppApkMd5FromCacheOnly(String r1) {
        o.e(r1, "packageName");
        return StandardPackagesTools.f30438a.a(r1);
    }

    @Override // com.obric.autogui.common.api.platform.packages.IAutoActionPackagesApi
    public boolean isSystemApp(Context r2, String r3) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        o.e(r3, "packageName");
        return StandardPackagesTools.f30438a.f(r1, r3);
    }

    @Override // com.obric.autogui.common.api.platform.packages.IAutoActionPackagesApi
    public void prefetchAppSignAndMd5(Context r2, String r3) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        o.e(r3, "packageName");
        StandardPackagesTools.f30438a.g(r1, r3);
    }

    @Override // com.obric.autogui.common.api.platform.packages.IAutoActionPackagesApi
    public Intent getLaunchIntent(Context r2, String r3) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        o.e(r3, "packageName");
        return StandardPackagesTools.f30438a.b(r1, r3);
    }

    @Override // com.obric.autogui.common.api.platform.packages.IAutoActionPackagesApi
    public Drawable getAppIconDrawable(Context r2, String r3) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        o.e(r3, "packageName");
        return StandardPackagesTools.f30438a.c(r1, r3);
    }

    @Override // com.obric.autogui.common.api.platform.packages.IAutoActionPackagesApi
    public Collection<LauncherEntryInfo> getLauncherEntriesForLabel(Context r2, String r3, boolean r4) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        o.e(r3, "label");
        return StandardPackagesTools.f30438a.a(r1, r3, r4);
    }

    @Override // com.obric.autogui.common.api.platform.packages.IAutoActionPackagesApi
    public Collection<LauncherShortcutInfo> getLauncherShortcutsForLabel(Context r2, String r3, boolean r4) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        o.e(r3, "label");
        return StandardPackagesTools.f30438a.b(r1, r3, r4);
    }

    @Override // com.obric.autogui.common.api.platform.packages.IAutoActionPackagesApi
    public Collection<String> getPackageNamesForLabel(Context r2, String r3, boolean r4) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        o.e(r3, "label");
        return (Collection) ZeusTransformUtils.preCheckCast(StandardPackagesTools.f30438a.c(r1, r3, r4), Collection.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autogui.common.api.platform.packages.IAutoActionPackagesApi
    public Object getOpenableApps(Context r8, d.c.d<? super Collection<OpenableAppInfo>> r9) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
        d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
        return StandardPackagesTools.a(StandardPackagesTools.f30438a, r2, false, r4, 2, null);
    }

    @Override // com.obric.autogui.common.api.platform.packages.IAutoActionPackagesApi
    public void invalidateCache() {
        StandardPackagesTools.f30438a.a();
    }

    @Override // com.obric.autogui.common.api.platform.packages.IAutoActionPackagesApi
    public void refreshCacheAsync(Context r2) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        StandardPackagesTools.f30438a.a(r1);
    }

    @Override // com.obric.autogui.common.api.platform.packages.IAutoActionPackagesApi
    public boolean openAppOnMainDisplay(Context r2, String r3) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        o.e(r3, "packageName");
        return StandardPackagesTools.f30438a.h(r1, r3);
    }

    @Override // com.obric.autogui.common.api.platform.packages.IAutoActionPackagesApi
    public StartActivityResult startActivity(Context r3, Intent r4, AOOperatingSpace r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AOOperatingSpace r7 = (AOOperatingSpace) ZeusTransformUtils.wrapperContextForParams(r5, AOOperatingSpace.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        o.e(r4, MemorySourceLinkType.INTENT);
        o.e(r7, "operatingSpace");
        if (ZeusTransformUtils.instanceOf(r7, DisplayOperatingSpace.class) == true) goto L7;
        Loog.INSTANCE.e(TAG, "[StartActivity] ActiveSpace is not DisplaySpace");
        return new StartActivityResult(StartActivityResult.Status.NotSupported);
    L7:
        return a(r6, r4, ((DisplayOperatingSpace) ZeusTransformUtils.preCheckCast(r7, DisplayOperatingSpace.class, "com.obric.aiagent.plugin")).getDisplayId());
    }

    @Override // com.obric.autogui.common.api.platform.packages.IAutoActionPackagesApi
    public StartActivityResult startActivity(Context r3, Intent r4, StartActivityPosition r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        o.e(r4, MemorySourceLinkType.INTENT);
        o.e(r5, "position");
        int r7 = C0820b.f30511a[r5.ordinal()];
        if (r7 != 1) goto L5;
        AOOperatingSpace r8 = OperatingSpaceManager.INSTANCE.getActiveSpace();
        if (r8 != null) goto L15;
        Loog.INSTANCE.e(TAG, "[StartActivity] NoActiveSPace");
        return new StartActivityResult(StartActivityResult.Status.SpaceNotFound);
    L15:
        return startActivity(r6, r4, r8);
    L5:
        if (r7 != 2) goto L9;
        return a(r6, r4, AOSystemTools.INSTANCE.getMainDisplayId());
    L9:
        throw new k();
    }

    @Override // com.obric.autogui.common.api.platform.packages.IAutoActionPackagesApi
    public StartActivityResult startShortcut(Context r10, String r11, String r12, StartActivityPosition r13) {
        Context r14 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        o.e(r14, "context");
        o.e(r11, "packageName");
        o.e(r12, "shortcutId");
        o.e(r13, "position");
        if (Build.VERSION.SDK_INT >= 26) goto L6;
        Loog.INSTANCE.e(TAG, "[StartShortcut] SDK Version Not supported: " + Build.VERSION.SDK_INT);
        return new StartActivityResult(StartActivityResult.Status.NotSupported);
    L6:
        int r15 = C0820b.f30511a[r13.ordinal()];
        if (r15 != 1) goto L9;
        AOOperatingSpace r16 = OperatingSpaceManager.INSTANCE.getActiveSpace();
        if (r16 != null) goto L18;
        Loog.INSTANCE.e(TAG, "[StartActivity] NoActiveSPace");
        return new StartActivityResult(StartActivityResult.Status.SpaceNotFound);
    L18:
        if (ZeusTransformUtils.instanceOf(r16, DisplayOperatingSpace.class) == true) goto L21;
        Loog.INSTANCE.e(TAG, "[StartShortcut] ActiveSpace is not DisplaySpace");
        return new StartActivityResult(StartActivityResult.Status.NotSupported);
    L21:
        int r17 = ((DisplayOperatingSpace) ZeusTransformUtils.preCheckCast(r16, DisplayOperatingSpace.class, "com.obric.aiagent.plugin")).getDisplayId();
    L39:
        LauncherApps r18 = (LauncherApps) ZeusTransformUtils.preCheckCast(r14.getSystemService(LauncherApps.class), LauncherApps.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L24
    L26:
        LauncherApps r3 = r18;
        if (r3 != null) goto L37;
        Loog.INSTANCE.w(TAG, " - [ShortcutOpener] LauncherApps service is not available.");
        return new StartActivityResult(StartActivityResult.Status.ApiFailed);
    L37:
        r3.startShortcut(r11, r12, null, a(r17).toBundle(), AOHostAppTools.INSTANCE.getUserHandle());     // Catch: Throwable -> L34
        return StartActivityResult.Companion.getOK();
    L34:
        th = move-exception;
        Loog.INSTANCE.e(TAG, " - [ShortcutOpener] Failed to start shortcut `" + r12 + "` for package `" + r11 + "`.", th);
        return a(th);
    L24:
        th = move-exception;
        Loog.INSTANCE.w(TAG, " - [ShortcutOpener] Failed to get LauncherApps service.", th);
        r18 = null;
        goto L26
    L9:
        if (r15 != 2) goto L12;
        r17 = AOSystemTools.INSTANCE.getMainDisplayId();
        goto L39
    L12:
        throw new k();
    }

    private final StartActivityResult a(Context r3, Intent r4, int r5) {
        startActivityUnsafe((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), r4, r5);     // Catch: Throwable -> L6
        Loog.INSTANCE.i(TAG, " - [StartActivity] package=" + r4.getPackage() + ", component=" + r4.getComponent() + ", cat=" + r4.getCategories() + ", flg=" + r4.getFlags());
        return StartActivityResult.Companion.getOK();
    L6:
        th = move-exception;
        return a(th);
    }

    private final StartActivityResult a(Throwable r4) {
        if (ZeusTransformUtils.instanceOf(r4, ActivityNotFoundException.class) == false) goto L5;
        Loog.INSTANCE.e(TAG, " - [StartActivity] activity not-found: " + r4.getMessage());
        return new StartActivityResult(StartActivityResult.Status.TargetNotFound);
    L5:
        Loog.INSTANCE.e(TAG, " - [StartActivity] throwable " + r4.getMessage(), r4);
        return new StartActivityResult(StartActivityResult.Status.ApiFailed);
    }

    @Override // com.obric.autogui.common.api.platform.packages.IAutoActionPackagesApi
    public void startActivityUnsafe(Context r4, Intent r5, int r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        o.e(r7, "context");
        o.e(r5, MemorySourceLinkType.INTENT);
        if (Build.VERSION.SDK_INT < 26) goto L10;
        ActivityOptions r3 = a(r6);
        if (ZeusTransformUtils.instanceOf(r7, Activity.class) == false) goto L7;
        ZeusTransformUtils.startActivity((Activity) ZeusTransformUtils.preCheckCast(r7, Activity.class, "com.obric.aiagent.plugin"), r5, r3.toBundle(), "com.obric.aiagent.plugin");
        return;
    L7:
        r5.addFlags(268435456);
        ZeusTransformUtils.startActivity(r7, r5, r3.toBundle(), "com.obric.aiagent.plugin");
        return;
    L10:
        throw new l("SDK Version Not supported: " + Build.VERSION.SDK_INT);
    }

    @Override // com.obric.autogui.common.api.platform.packages.IAutoActionPackagesApi
    public boolean killApp(String r1, boolean r2) {
        return a(r1, r2);
    }

    @Override // com.obric.autogui.common.api.platform.packages.IAutoActionPackagesApi
    public Object killAppAndDelay(String r5, boolean r6, long r7, d.c.d<? super Boolean> r9) {
        d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r10, c.class) == false) goto L7;
        c r0 = (c) ZeusTransformUtils.preCheckCast(r10, c.class, "com.obric.aiagent.plugin");
        if ((r0.f30515d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f30515d -= Integer.MIN_VALUE;
    L8:
        Object r11 = r0.f30513b;
        Object r1 = d.c.a.b.a();
        int r2 = r0.f30515d;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        boolean r4 = r0.f30512a;
        d.o.a(r11);
    L22:
        return d.c.b.a.b.a(r4);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r11);
        r4 = a(r5, r6);
        if (r4 == false) goto L22;
        if (r7 <= 0) goto L22;
        r0.f30512a = r4;
        r0.f30515d = 1;
        if (ax.a(r7, r0) != r1) goto L22;
        return r1;
    L7:
        r0 = new c(this, r10);
        goto L8
    }

    private final boolean a(final String r7, boolean r8) {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return false;
    L11:
        final z.a r2 = new z.a();
        Iterator<TaskInfo> r3 = AOPlatformTools.INSTANCE.special().getTasks(100, false, false, AutoActionVirtualDisplay.INSTANCE.getOperatingDisplayId()).iterator();     // Catch: Exception -> L24
    L13:
        if (r3.hasNext() == false) goto L27;
        final TaskInfo r4 = (TaskInfo) ZeusTransformUtils.preCheckCast(r3.next(), TaskInfo.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L24
        ComponentName r5 = r4.topActivity;     // Catch: Exception -> L24
        if (r5 == null) goto L18;
        String r6 = r5.getPackageName();     // Catch: Exception -> L24
    L20:
        if (o.a(r6, r7) == false) goto L13;
        r2.f38499a = AOPlatformTools.INSTANCE.special().removeTask(r4.taskId);     // Catch: Exception -> L24
        Loog.INSTANCE.dp(TAG, new $$Lambda$b$Hj9CTBJ1REHSURf5JhOgIuBLG0(r4, r7, r2));     // Catch: Exception -> L24
        if (r8 == true) goto L13;
    L18:
        r6 = null;
    L27:
        return r2.f38499a;
    L24:
        e = move-exception;
        Loog.INSTANCE.e(TAG, "[killApp] failed: " + e);
        goto L27
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    private static final String a(TaskInfo r2, String r3, z.a r4) {
        return "[killApp] remove task: " + r2.taskId + ", packageName: " + r3 + ", isSuccess: " + r4.f38499a;
    }

    private final ActivityOptions a(int r4) {
        ActivityOptions r3 = ActivityOptions.makeBasic();
        Loog.INSTANCE.i(TAG, "[StartActivityOptions] on startOnDisplay=" + r4);
        r3.setLaunchDisplayId(r4);
        o.a(r3);
        return r3;
    }
}
