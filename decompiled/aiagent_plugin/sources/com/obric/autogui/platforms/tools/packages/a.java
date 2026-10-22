package com.obric.autogui.platforms.tools.packages;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.LauncherApps;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ShortcutInfo;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.autogui.common.api.AOBizTracking;
import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.abilities.AutoActionAbilitiesKt;
import com.obric.autogui.common.api.abilities.AutoActionAbility;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.packages.appinfo.AppInfoEntry;
import com.obric.autogui.common.api.platform.packages.appinfo.LauncherEntryInfo;
import com.obric.autogui.common.api.platform.packages.appinfo.LauncherShortcutInfo;
import com.obric.autogui.common.api.platform.packages.appinfo.OpenableAppInfo;
import com.obric.autogui.common.api.platform.tracking.IAutoActionTrackingApi;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.a.ax;
import d.a.p;
import d.c.b.a.l;
import d.h.a.m;
import d.h.b.o;
import d.n;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.cx;
import kotlinx.coroutines.w;
import kotlinx.coroutines.y;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: FastOpenableAppsLoader.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private static final String TAG = "FastPkgTools";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final C0819a f30473a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final am f30474b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final w<g> f30475c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AtomicBoolean f30476d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile g f30477e;
    private volatile c f;
    private volatile boolean g;

    /* JADX INFO: renamed from: com.obric.autogui.platforms.tools.packages.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: FastOpenableAppsLoader.kt */
    private static final class C0819a {
        public /* synthetic */ C0819a(d.h.b.h r1) {
            this();
        }

        private C0819a() {
        }
    }

    /* JADX INFO: compiled from: FastOpenableAppsLoader.kt */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final e f30478a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f30479b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (o.a(this.f30478a, r6.f30478a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f30479b, r6.f30479b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f30478a.hashCode() * 31) + this.f30479b.hashCode();
        }

        public String toString() {
            return "ComparableItem(key=" + this.f30478a + ", label=" + this.f30479b + ')';
        }

        public b(e r2, String r3) {
            o.e(r2, "key");
            o.e(r3, "label");
            this.f30478a = r2;
            this.f30479b = r3;
        }

        public final e a() {
            return this.f30478a;
        }

        public final String b() {
            return this.f30479b;
        }

        public final OpenableAppInfo c() {
            return new OpenableAppInfo(this.f30479b, this.f30478a.a(), null, this.f30478a.getType());
        }
    }

    /* JADX INFO: compiled from: FastOpenableAppsLoader.kt */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f30480a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f30481b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Set<String> f30482c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f30483d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final Set<String> f30484e;
        private final Set<String> f;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
            return false;
        L8:
            c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
            if (o.a(this.f30480a, r6.f30480a) == true) goto L12;
            return false;
        L12:
            if (this.f30481b == r6.f30481b) goto L15;
            return false;
        L15:
            if (o.a(this.f30482c, r6.f30482c) == true) goto L18;
            return false;
        L18:
            if (this.f30483d == r6.f30483d) goto L21;
            return false;
        L21:
            if (o.a(this.f30484e, r6.f30484e) == true) goto L24;
            return false;
        L24:
            if (o.a(this.f, r6.f) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public int hashCode() {
            return (((((((((this.f30480a.hashCode() * 31) + Boolean.hashCode(this.f30481b)) * 31) + this.f30482c.hashCode()) * 31) + Boolean.hashCode(this.f30483d)) * 31) + this.f30484e.hashCode()) * 31) + this.f.hashCode();
        }

        public String toString() {
            return "Config(hostAppPackage=" + this.f30480a + ", canOperateHostApp=" + this.f30481b + ", notOpenablePackages=" + this.f30482c + ", skipShortcutsWithoutLauncher=" + this.f30483d + ", forceLoadShortcutPackages=" + this.f30484e + ", miniAppPackages=" + this.f + ')';
        }

        public c(String r3, boolean r4, Set<String> r5, boolean r6, Set<String> r7, Set<String> r8) {
            Set<String> r9 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.aiagent.plugin");
            Set<String> r10 = (Set) ZeusTransformUtils.wrapperContextForParams(r7, Set.class, "com.obric.aiagent.plugin");
            Set<String> r11 = (Set) ZeusTransformUtils.wrapperContextForParams(r8, Set.class, "com.obric.aiagent.plugin");
            o.e(r3, "hostAppPackage");
            o.e(r9, "notOpenablePackages");
            o.e(r10, "forceLoadShortcutPackages");
            o.e(r11, "miniAppPackages");
            this.f30480a = r3;
            this.f30481b = r4;
            this.f30482c = r9;
            this.f30483d = r6;
            this.f30484e = r10;
            this.f = r11;
        }

        public final String a() {
            return this.f30480a;
        }

        public final boolean b() {
            return this.f30481b;
        }

        public final Set<String> c() {
            return this.f30482c;
        }

        public final boolean d() {
            return this.f30483d;
        }

        public final Set<String> e() {
            return this.f30484e;
        }

        public final Set<String> f() {
            return this.f;
        }
    }

    /* JADX INFO: compiled from: FastOpenableAppsLoader.kt */
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<b> f30485a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List<b> f30486b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final List<f> f30487c;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, d.class) == true) goto L8;
            return false;
        L8:
            d r6 = (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.aiagent.plugin");
            if (o.a(this.f30485a, r6.f30485a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f30486b, r6.f30486b) == true) goto L15;
            return false;
        L15:
            if (o.a(this.f30487c, r6.f30487c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.f30485a.hashCode() * 31) + this.f30486b.hashCode()) * 31) + this.f30487c.hashCode();
        }

        public String toString() {
            return "Diff(fastOnly=" + this.f30485a + ", slowOnly=" + this.f30486b + ", labelMismatches=" + this.f30487c + ')';
        }

        public d(List<b> r3, List<b> r4, List<f> r5) {
            List<b> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
            List<b> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            List<f> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
            o.e(r6, "fastOnly");
            o.e(r7, "slowOnly");
            o.e(r8, "labelMismatches");
            this.f30485a = r6;
            this.f30486b = r7;
            this.f30487c = r8;
        }

        public final List<b> a() {
            return this.f30485a;
        }

        public final List<b> b() {
            return this.f30486b;
        }

        public final List<f> c() {
            return this.f30487c;
        }
    }

    /* JADX INFO: compiled from: FastOpenableAppsLoader.kt */
    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f30488a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final OpenableAppInfo.OpenableAppType f30489b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f30490c;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, e.class) == true) goto L8;
            return false;
        L8:
            e r6 = (e) ZeusTransformUtils.preCheckCast(r5, e.class, "com.obric.aiagent.plugin");
            if (o.a(this.f30488a, r6.f30488a) == true) goto L12;
            return false;
        L12:
            if (this.f30489b == r6.f30489b) goto L15;
            return false;
        L15:
            if (o.a(this.f30490c, r6.f30490c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.f30488a.hashCode() * 31) + this.f30489b.hashCode()) * 31) + this.f30490c.hashCode();
        }

        public String toString() {
            return "ItemKey(packageName=" + this.f30488a + ", type=" + this.f30489b + ", stableId=" + this.f30490c + ')';
        }

        public e(String r2, OpenableAppInfo.OpenableAppType r3, String r4) {
            o.e(r2, "packageName");
            o.e(r3, "type");
            o.e(r4, "stableId");
            this.f30488a = r2;
            this.f30489b = r3;
            this.f30490c = r4;
        }

        public final String a() {
            return this.f30488a;
        }

        public final OpenableAppInfo.OpenableAppType getType() {
            return this.f30489b;
        }

        public final String b() {
            return this.f30490c;
        }
    }

    /* JADX INFO: compiled from: FastOpenableAppsLoader.kt */
    public static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final e f30491a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f30492b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f30493c;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, f.class) == true) goto L8;
            return false;
        L8:
            f r6 = (f) ZeusTransformUtils.preCheckCast(r5, f.class, "com.obric.aiagent.plugin");
            if (o.a(this.f30491a, r6.f30491a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f30492b, r6.f30492b) == true) goto L15;
            return false;
        L15:
            if (o.a(this.f30493c, r6.f30493c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.f30491a.hashCode() * 31) + this.f30492b.hashCode()) * 31) + this.f30493c.hashCode();
        }

        public String toString() {
            return "LabelMismatch(key=" + this.f30491a + ", fastLabel=" + this.f30492b + ", slowLabel=" + this.f30493c + ')';
        }

        public f(e r2, String r3, String r4) {
            o.e(r2, "key");
            o.e(r3, "fastLabel");
            o.e(r4, "slowLabel");
            this.f30491a = r2;
            this.f30492b = r3;
            this.f30493c = r4;
        }

        public final e a() {
            return this.f30491a;
        }
    }

    /* JADX INFO: compiled from: FastOpenableAppsLoader.kt */
    public static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<b> f30494a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f30495b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f30496c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final long f30497d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final d.f f30498e;

        public static /* synthetic */ List lambda$ZdqqI5RP38sULcgXli0WPrsqmSM(g r0) {
            return a(r0);
        }

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, g.class) == true) goto L8;
            return false;
        L8:
            g r10 = (g) ZeusTransformUtils.preCheckCast(r9, g.class, "com.obric.aiagent.plugin");
            if (o.a(this.f30494a, r10.f30494a) == true) goto L12;
            return false;
        L12:
            if (this.f30495b == r10.f30495b) goto L15;
            return false;
        L15:
            if (this.f30496c == r10.f30496c) goto L18;
            return false;
        L18:
            if (this.f30497d == r10.f30497d) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            return (((((this.f30494a.hashCode() * 31) + Long.hashCode(this.f30495b)) * 31) + Long.hashCode(this.f30496c)) * 31) + Long.hashCode(this.f30497d);
        }

        public String toString() {
            return "Snapshot(items=" + this.f30494a + ", launcherDurationMs=" + this.f30495b + ", shortcutDurationMs=" + this.f30496c + ", totalDurationMs=" + this.f30497d + ')';
        }

        public g(List<b> r3, long r4, long r6, long r8) {
            List<b> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
            o.e(r5, "items");
            this.f30494a = r5;
            this.f30495b = r4;
            this.f30496c = r6;
            this.f30497d = r8;
            this.f30498e = d.g.a(new $$Lambda$a$g$ZdqqI5RP38sULcgXli0WPrsqmSM(this));
        }

        public final List<b> a() {
            return this.f30494a;
        }

        public final long b() {
            return this.f30495b;
        }

        public final long c() {
            return this.f30496c;
        }

        public final long d() {
            return this.f30497d;
        }

        public final List<OpenableAppInfo> e() {
            return (List) ZeusTransformUtils.preCheckCast(this.f30498e.b(), List.class, "com.obric.aiagent.plugin");
        }

        private static final List a(g r4) {
            Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(r4.f30494a, Iterable.class, "com.obric.aiagent.plugin");
            Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r5, 10)), Collection.class, "com.obric.aiagent.plugin");
            Iterator r6 = r5.iterator();
        L4:
            if (r6.hasNext() == false) goto L7;
            r0.add(((b) ZeusTransformUtils.preCheckCast(r6.next(), b.class, "com.obric.aiagent.plugin")).c());
            goto L4
        L7:
            return (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: FastOpenableAppsLoader.kt */
    @d.c.b.a.f(b = "FastOpenableAppsLoader.kt", c = {121}, d = "awaitOpenableApps", e = "com.obric.autogui.platforms.tools.packages.FastOpenableAppsLoader")
    static final class h extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f30499a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f30500b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f30501c;

        h(a r3, d.c.d<? super h> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f30500b = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f30499a = r3;
            this.f30501c |= Integer.MIN_VALUE;
            return this.f30500b.a((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: FastOpenableAppsLoader.kt */
    @d.c.b.a.f(b = "FastOpenableAppsLoader.kt", c = {132}, d = "invokeSuspend", e = "com.obric.autogui.platforms.tools.packages.FastOpenableAppsLoader$compareWithSlowAsync$1")
    static final class i extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f30502a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f30503b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ List<AppInfoEntry> f30504c;

        i(a r3, List<AppInfoEntry> r4, d.c.d<? super i> r5) {
            List<AppInfoEntry> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f30503b = r3;
            this.f30504c = r6;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((i) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), i.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new i(this.f30503b, this.f30504c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f30502a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r5);
        L11:
            g r6 = (g) ZeusTransformUtils.preCheckCast(r5, g.class, "com.obric.aiagent.plugin");
            if (r6 == null) goto L14;
            c r2 = a.b(this.f30503b);
            if (r2 == null) goto L18;
            a r3 = this.f30503b;
            a.a(r3, r6, a.a(r3, (Collection) ZeusTransformUtils.preCheckCast(this.f30504c, Collection.class, "com.obric.aiagent.plugin"), r2));
            return x.f38692a;
        L18:
            return x.f38692a;
        L14:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r5);
            w r7 = a.a(this.f30503b);
            d.c.d r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f30502a = 1;
            r5 = r7.a(r4);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: FastOpenableAppsLoader.kt */
    @d.c.b.a.f(b = "FastOpenableAppsLoader.kt", c = {}, d = "invokeSuspend", e = "com.obric.autogui.platforms.tools.packages.FastOpenableAppsLoader$start$2")
    static final class j extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f30505a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f30506b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Context f30507c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ c f30508d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private /* synthetic */ Object f30509e;

        j(a r3, Context r4, c r5, d.c.d<? super j> r6) {
            Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f30506b = r3;
            this.f30507c = ZeusTransformUtils.wrapperContext(r7, "com.obric.aiagent.plugin");
            this.f30508d = r5;
            super(2, r8);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((j) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), j.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r5, d.c.d<?> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            j r0 = new j(this.f30506b, this.f30507c, this.f30508d, r7);
            r0.f30509e = r5;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            d.c.a.b.a();
            if (this.f30505a != 0) goto L18;
            d.o.a(r7);
            am r8 = (am) ZeusTransformUtils.preCheckCast(this.f30509e, am.class, "com.obric.aiagent.plugin");
            a r9 = this.f30506b;
            Context r0 = this.f30507c;
            c r2 = this.f30508d;
            n.a r3 = n.f38560a;     // Catch: Throwable -> L7
            Object r10 = n.f(a.a(r9, r0, r2));     // Catch: Throwable -> L7
        L9:
            a r1 = this.f30506b;
            Throwable r4 = n.c(r10);
            if (r4 == null) goto L13;
            Loog.INSTANCE.e(a.TAG, "Failed to load fast openable apps", r4);
            a.a(r1, r4);
        L13:
            if (n.b(r10) == false) goto L15;
            r10 = null;
        L15:
            g r11 = (g) ZeusTransformUtils.preCheckCast(r10, g.class, "com.obric.aiagent.plugin");
            a.a(this.f30506b, r11);
            a.a(this.f30506b).a(r11);
            return x.f38692a;
        L7:
            th = move-exception;
            n.a r5 = n.f38560a;
            r10 = n.f(d.o.a(th));
            goto L9
        L18:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        f30473a = new C0819a(null);
    }

    private static final String a(String r0) {
        return r0;
    }

    public static /* synthetic */ String lambda$10khPciCq7YoSQyut11Bn4haU7Q(String r0) {
        return a(r0);
    }

    /* JADX INFO: renamed from: lambda$SD-pL_LG-invdYdRThrH8UEeUm8, reason: not valid java name */
    public static /* synthetic */ String m873lambda$SDpL_LGinvdYdRThrH8UEeUm8(String r0, d r1) {
        return a(r0, r1);
    }

    public a() {
        this.f30474b = an.a(cx.a(null, 1, null).plus((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin")));
        this.f30475c = y.a(null, 1, null);
        this.f30476d = new AtomicBoolean(false);
    }

    public static final /* synthetic */ g a(a r2, Context r3, c r4) {
        return r2.b((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), r4);
    }

    public static final /* synthetic */ List a(a r2, Collection r3, c r4) {
        return r2.a((Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.aiagent.plugin"), r4);
    }

    public static final /* synthetic */ w a(a r0) {
        return r0.f30475c;
    }

    public static final /* synthetic */ void a(a r0, g r1) {
        r0.f30477e = r1;
    }

    public static final /* synthetic */ void a(a r2, g r3, List r4) {
        r2.a(r3, (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ void a(a r0, Throwable r1) {
        r0.a(r1);
    }

    public static final /* synthetic */ c b(a r0) {
        return r0.f;
    }

    public final void a(Context r8, c r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
        o.e(r10, "context");
        o.e(r9, "config");
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.g == false) goto L9;
        monitor-exit(this);
        return;
    L9:
        this.g = true;     // Catch: Throwable -> L13
        this.f = r9;     // Catch: Throwable -> L13
        x r0 = x.f38692a;     // Catch: Throwable -> L13
        monitor-exit(this);
        kotlinx.coroutines.i.a(this.f30474b, null, null, (m) ZeusTransformUtils.preCheckCast(new j(this, r10, r9, null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    public final Object a(d.c.d<? super List<OpenableAppInfo>> r6) {
        d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r7, h.class) == false) goto L7;
        h r0 = (h) ZeusTransformUtils.preCheckCast(r7, h.class, "com.obric.aiagent.plugin");
        if ((r0.f30501c & Integer.MIN_VALUE) == 0) goto L7;
        r0.f30501c -= Integer.MIN_VALUE;
    L8:
        Object r8 = r0.f30499a;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f30501c;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        d.o.a(r8);
    L17:
        g r5 = (g) ZeusTransformUtils.preCheckCast(r8, g.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L22;
        return null;
    L22:
        return r5.e();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r8);
        w<g> r9 = this.f30475c;
        r0.f30501c = 1;
        r8 = r9.a(r0);
        if (r8 != r2) goto L17;
        return r2;
    L7:
        r0 = new h(this, r7);
        goto L8
    }

    public final List<OpenableAppInfo> a() {
        g r0 = this.f30477e;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.e();
    }

    public final void a(Collection<AppInfoEntry> r9) {
        Collection r10 = (Collection) ZeusTransformUtils.wrapperContextForParams(r9, Collection.class, "com.obric.aiagent.plugin");
        o.e(r10, "entries");
        if (this.f30476d.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        List r11 = p.o((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.aiagent.plugin"));
        kotlinx.coroutines.i.a(this.f30474b, null, null, (m) ZeusTransformUtils.preCheckCast(new i(this, r11, null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    private final g b(Context r21, c r22) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r21, Context.class, "com.obric.aiagent.plugin");
        long r4 = AOSystemTools.INSTANCE.bootTimeMillis();
        PackageManager r6 = r2.getPackageManager();
        long r7 = AOSystemTools.INSTANCE.bootTimeMillis();
        List<ResolveInfo> r8 = r6.queryIntentActivities(new Intent("android.intent.action.MAIN").addCategory("android.intent.category.LAUNCHER"), 0);
        o.c(r8, "queryIntentActivities(...)");
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.aiagent.plugin");
        Collection r10 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r11 = r9.iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        ResolveInfo r12 = (ResolveInfo) ZeusTransformUtils.preCheckCast(r11.next(), ResolveInfo.class, "com.obric.aiagent.plugin");
        o.a(r12);
        b r13 = a(r12, r2, r22);
        if (r13 == null) goto L4;
        r10.add(r13);
        goto L4
    L8:
        List r14 = (List) ZeusTransformUtils.preCheckCast(r10, List.class, "com.obric.aiagent.plugin");
        long r15 = AOSystemTools.INSTANCE.bootTimeMillis() - r7;
        Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.aiagent.plugin");
        Collection r17 = (Collection) ZeusTransformUtils.preCheckCast((Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.aiagent.plugin"), Collection.class, "com.obric.aiagent.plugin");
        Iterator r18 = r16.iterator();
    L10:
        if (r18.hasNext() == false) goto L12;
        r17.add(((ResolveInfo) ZeusTransformUtils.preCheckCast(r18.next(), ResolveInfo.class, "com.obric.aiagent.plugin")).activityInfo.packageName);
        goto L10
    L12:
        Set<String> r19 = (Set) ZeusTransformUtils.preCheckCast(r17, Set.class, "com.obric.aiagent.plugin");
        long r20 = AOSystemTools.INSTANCE.bootTimeMillis();
        List<b> r1 = a(r2, r22, r19);
        long r110 = AOSystemTools.INSTANCE.bootTimeMillis() - r20;
        g r3 = new g(p.c((Collection) ZeusTransformUtils.preCheckCast(r14, Collection.class, "com.obric.aiagent.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.aiagent.plugin")), r15, r110, AOSystemTools.INSTANCE.bootTimeMillis() - r4);
        a(r3);
        return r3;
    }

    private final List<b> a(Collection<AppInfoEntry> r12, c r13) {
        Collection r14 = (Collection) ZeusTransformUtils.wrapperContextForParams(r12, Collection.class, "com.obric.aiagent.plugin");
        List<b> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        Iterator r15 = ((Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r15.hasNext() == false) goto L37;
        AppInfoEntry r2 = (AppInfoEntry) ZeusTransformUtils.preCheckCast(r15.next(), AppInfoEntry.class, "com.obric.aiagent.plugin");
        String r3 = r2.getAppInfo().packageName;
        o.a(r3);
        if (a(r3, r13) == false) goto L4;
        Collection<LauncherEntryInfo> r4 = r2.getLauncherEntries();
        if (r4 != null) goto L11;
        r4 = (Collection) ZeusTransformUtils.preCheckCast(p.b(), Collection.class, "com.obric.aiagent.plugin");
    L11:
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L13:
        if (r5.hasNext() == false) goto L25;
        LauncherEntryInfo r6 = (LauncherEntryInfo) ZeusTransformUtils.preCheckCast(r5.next(), LauncherEntryInfo.class, "com.obric.aiagent.plugin");
        CharSequence r7 = r6.getLabel();
        if (r7 == null) goto L13;
        String r8 = r7.toString();
        if (r8 == null) goto L13;
        ComponentName r9 = r6.getIntent().getComponent();
        if (r9 == null) goto L23;
        String r10 = r9.flattenToShortString();
        if (r10 == null) goto L23;
    L24:
        Collection r11 = (Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.aiagent.plugin");
        String r16 = r6.getAppPackageName();
        OpenableAppInfo.OpenableAppType r17 = OpenableAppInfo.OpenableAppType.LauncherEntry;
        o.a(r10);
        r11.add(new b(new e(r16, r17, r10), r8));
    L23:
        r10 = r6.getIntent().toUri(0);
        goto L24
    L25:
        Collection<LauncherShortcutInfo> r18 = r2.getLauncherShortcuts();
        if (r18 != null) goto L28;
        r18 = (Collection) ZeusTransformUtils.preCheckCast(p.b(), Collection.class, "com.obric.aiagent.plugin");
    L28:
        Iterator r19 = ((Iterable) ZeusTransformUtils.preCheckCast(r18, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L30:
        if (r19.hasNext() == false) goto L4;
        LauncherShortcutInfo r20 = (LauncherShortcutInfo) ZeusTransformUtils.preCheckCast(r19.next(), LauncherShortcutInfo.class, "com.obric.aiagent.plugin");
        CharSequence r21 = r20.getLabel();
        if (r21 == null) goto L30;
        String r22 = r21.toString();
        if (r22 == null) goto L30;
        ((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.aiagent.plugin")).add(new b(new e(r20.getAppPackageName(), OpenableAppInfo.OpenableAppType.LauncherShortcut, r20.getShortcutId()), r22));
        goto L30
    L37:
        return r0;
    }

    private final d a(List<b> r11, List<b> r12) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin");
        List r13 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.aiagent.plugin");
        Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.aiagent.plugin");
        Map r1 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(d.l.n.c(ao.a(p.a(r14, 10)), 16)), Map.class, "com.obric.aiagent.plugin");
        Iterator r15 = r14.iterator();
    L4:
        if (r15.hasNext() == false) goto L6;
        Object r3 = r15.next();
        r1.put(((b) ZeusTransformUtils.preCheckCast(r3, b.class, "com.obric.aiagent.plugin")).a(), r3);
        goto L4
    L6:
        Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.aiagent.plugin");
        Map r17 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(d.l.n.c(ao.a(p.a(r16, 10)), 16)), Map.class, "com.obric.aiagent.plugin");
        Iterator r18 = r16.iterator();
    L8:
        if (r18.hasNext() == false) goto L10;
        Object r19 = r18.next();
        r17.put(((b) ZeusTransformUtils.preCheckCast(r19, b.class, "com.obric.aiagent.plugin")).a(), r19);
        goto L8
    L10:
        Iterable r110 = (Iterable) ZeusTransformUtils.preCheckCast(ax.a(r1.keySet(), (Iterable) ZeusTransformUtils.preCheckCast(r17.keySet(), Iterable.class, "com.obric.aiagent.plugin")), Iterable.class, "com.obric.aiagent.plugin");
        Collection r111 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r112 = r110.iterator();
    L12:
        if (r112.hasNext() == false) goto L16;
        b r2 = (b) ZeusTransformUtils.preCheckCast(r1.get((e) ZeusTransformUtils.preCheckCast(r112.next(), e.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L12;
        r111.add(r2);
        goto L12
    L16:
        List r113 = (List) ZeusTransformUtils.preCheckCast(r111, List.class, "com.obric.aiagent.plugin");
        Iterable r114 = (Iterable) ZeusTransformUtils.preCheckCast(ax.a(r17.keySet(), (Iterable) ZeusTransformUtils.preCheckCast(r1.keySet(), Iterable.class, "com.obric.aiagent.plugin")), Iterable.class, "com.obric.aiagent.plugin");
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r115 = r114.iterator();
    L18:
        if (r115.hasNext() == false) goto L22;
        b r5 = (b) ZeusTransformUtils.preCheckCast(r17.get((e) ZeusTransformUtils.preCheckCast(r115.next(), e.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L18;
        r4.add(r5);
        goto L18
    L22:
        List r116 = (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.aiagent.plugin");
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(p.a((Iterable) ZeusTransformUtils.preCheckCast(r1.keySet(), Iterable.class, "com.obric.aiagent.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(r17.keySet(), Iterable.class, "com.obric.aiagent.plugin")), Iterable.class, "com.obric.aiagent.plugin");
        Collection r7 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r8 = r6.iterator();
    L24:
        if (r8.hasNext() == false) goto L38;
        e r9 = (e) ZeusTransformUtils.preCheckCast(r8.next(), e.class, "com.obric.aiagent.plugin");
        b r20 = (b) ZeusTransformUtils.preCheckCast(r1.get(r9), b.class, "com.obric.aiagent.plugin");
        f r21 = null;
        if (r20 == null) goto L35;
        b r22 = (b) ZeusTransformUtils.preCheckCast(r17.get(r9), b.class, "com.obric.aiagent.plugin");
        if (r22 == null) goto L35;
        if (o.a(r20.b(), r22.b()) == true) goto L35;
        r21 = new f(r9, r20.b(), r22.b());
    L35:
        if (r21 == null) goto L24;
        r7.add(r21);
        goto L24
    L38:
        return new d(r113, r116, (List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.aiagent.plugin"));
    }

    private final void a(g r12, List<b> r13) {
        List<b> r14 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.aiagent.plugin");
        final d r0 = a(r12.a(), r14);
        if (r0.a().isEmpty() == true) goto L5;
    L9:
        boolean r2 = false;
    L10:
        final String r3 = "fast/slow app-list diff: fast_size=" + r12.a().size() + ", slow_size=" + r14.size() + ", fast_only=" + r0.a().size() + ", slow_only=" + r0.b().size() + ", label_mismatch=" + r0.c().size() + ", is_equal=" + r2;
        Loog.INSTANCE.ip(TAG, new $$Lambda$a$SDpL_LGinvdYdRThrH8UEeUm8(r3, r0), new $$Lambda$a$10khPciCq7YoSQyut11Bn4haU7Q(r3));
        IAutoActionTrackingApi r4 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");
        JSONObject r5 = new JSONObject();
        r5.put("is_equal", r2);
        r5.put("fast_size", r12.a().size());
        r5.put("slow_size", r14.size());
        r5.put("fast_only_count", r0.a().size());
        r5.put("slow_only_count", r0.b().size());
        r5.put("label_mismatch_count", r0.c().size());
        r5.put("fast_only_items", a(r0.a()));
        r5.put("slow_only_items", a(r0.b()));
        r5.put("label_mismatch_items", b(r0.c()));
        x r11 = x.f38692a;
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r4, "oauto_fast_slow_app_info_diff", r5, false, false, null, 28, null);
        return;
    L5:
        if (r0.b().isEmpty() == false) goto L9;
        if (r0.c().isEmpty() == false) goto L9;
        r2 = true;
        goto L10
    }

    private static final String a(String r1, d r2) {
        return r1 + "; fast_only_items=" + r2.a() + "; slow_only_items=" + r2.b() + "; label_mismatches=" + r2.c();
    }

    private final void a(Throwable r9) {
        IAutoActionTrackingApi r0 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");
        JSONObject r2 = new JSONObject();
        String r8 = r9.getMessage();
        if (r8 != null) goto L5;
        r8 = r9.getClass().getSimpleName();
    L5:
        r2.put(WsConstants.KEY_CONNECTION_ERROR, r8);
        x r10 = x.f38692a;
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r0, "oauto_fast_app_info", r2, false, false, null, 28, null);
    }

    private final b a(ResolveInfo r5, Context r6, c r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        ActivityInfo r0 = r5.activityInfo;
        String r2 = null;
        if (r0 != null) goto L5;
        return null;
    L5:
        String r3 = r0.packageName;
        o.a(r3);
        if (a(r3, r7) == true) goto L29;
        return null;
    L29:
        n.a r4 = n.f38560a;     // Catch: Throwable -> L14
        CharSequence r9 = r5.loadLabel(r8.getPackageManager());     // Catch: Throwable -> L14
        if (r9 == null) goto L11;
        String r10 = r9.toString();     // Catch: Throwable -> L14
    L12:
        Object r11 = n.f(r10);     // Catch: Throwable -> L14
    L17:
        if (n.b(r11) == false) goto L19;
        r11 = null;
    L19:
        String r12 = (String) ZeusTransformUtils.preCheckCast(r11, String.class, "com.obric.aiagent.plugin");
        if (r12 != null) goto L22;
    L26:
        r2 = r3;
    L27:
        OpenableAppInfo.OpenableAppType r13 = OpenableAppInfo.OpenableAppType.LauncherEntry;
        String r14 = new ComponentName(r3, r0.name).flattenToShortString();
        o.c(r14, "flattenToShortString(...)");
        return new b(new e(r3, r13, r14), r2);
    L22:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L24;
        r2 = r12;
    L24:
        if (r2 == null) goto L26;
    L11:
        r10 = null;
    L14:
        th = move-exception;
        n.a r15 = n.f38560a;
        r11 = n.f(d.o.a(th));
        goto L17
    }

    private final List<b> a(Context r5, c r6, Set<String> r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        Set<String> r9 = (Set) ZeusTransformUtils.wrapperContextForParams(r7, Set.class, "com.obric.aiagent.plugin");
        if (AutoActionAbilitiesKt.isSupported(AutoActionAbility.PkgAccessLauncherShortcuts) == false) goto L5;
        LauncherApps r10 = (LauncherApps) ZeusTransformUtils.preCheckCast(r8.getSystemService(LauncherApps.class), LauncherApps.class, "com.obric.aiagent.plugin");
        if (r10 == null) goto L20;
        LauncherApps.ShortcutQuery r0 = new LauncherApps.ShortcutQuery();
        r0.setQueryFlags(1024);
        List<ShortcutInfo> r11 = r10.getShortcuts(r0, AOHostAppTools.INSTANCE.getUserHandle());
        if (r11 != null) goto L11;
        r11 = p.b();
    L11:
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.aiagent.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r13 = r12.iterator();
    L13:
        if (r13.hasNext() == false) goto L18;
        ShortcutInfo r2 = (ShortcutInfo) ZeusTransformUtils.preCheckCast(r13.next(), ShortcutInfo.class, "com.obric.aiagent.plugin");
        o.a(r2);
        b r3 = a(r2, r6, r9);
        if (r3 == null) goto L13;
        r1.add(r3);
        goto L13
    L18:
        return (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.aiagent.plugin");
    L20:
        throw new IllegalStateException("LauncherApps service is unavailable");
    L5:
        return p.b();
    }

    private final b a(ShortcutInfo r7, c r8, Set<String> r9) {
        Set r10 = (Set) ZeusTransformUtils.wrapperContextForParams(r9, Set.class, "com.obric.aiagent.plugin");
        String r0 = r7.getPackage();
        o.c(r0, "getPackage(...)");
        if (a(r0, r8) == true) goto L6;
        return null;
    L6:
        if (r8.d() == true) goto L8;
    L12:
        CharSequence r6 = r7.getShortLabel();
        if (r6 == null) goto L28;
        String r11 = r6.toString();
        if (r11 == null) goto L28;
        boolean r3 = false;
        if (r8.f().contains(r0) == false) goto L23;
        String r12 = r7.getId();
        o.c(r12, "getId(...)");
        if (d.o.o.b(r12, "miniapp.", false, 2, null) == false) goto L23;
        r3 = true;
    L23:
        if (o.a(r0, r8.a()) == false) goto L26;
        if (r3 == true) goto L26;
        return null;
    L26:
        OpenableAppInfo.OpenableAppType r1 = OpenableAppInfo.OpenableAppType.LauncherShortcut;
        String r13 = r7.getId();
        o.c(r13, "getId(...)");
        return new b(new e(r0, r1, r13), r11);
    L28:
        return null;
    L8:
        if (r10.contains(r0) == true) goto L12;
        if (r8.e().contains(r0) == true) goto L12;
        return null;
    }

    private final boolean a(String r2, c r3) {
        if (r3.c().contains(r2) == false) goto L6;
        return false;
    L6:
        if (r3.b() == false) goto L8;
    L9:
        return true;
    L8:
        if (o.a(r2, r3.a()) == false) goto L9;
        return false;
    }

    private final void a(g r15) {
        Loog r14 = Loog.INSTANCE;
        StringBuilder r0 = new StringBuilder().append("loaded fast app list in ").append(r15.d()).append("ms; size=").append(r15.a().size()).append(", launcher=");
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r15.a(), Iterable.class, "com.obric.aiagent.plugin");
        int r5 = 0;
        if (ZeusTransformUtils.instanceOf(r1, Collection.class) == true) goto L5;
    L7:
        Iterator r2 = r1.iterator();
        int r3 = 0;
    L9:
        if (r2.hasNext() == false) goto L18;
        if (((b) ZeusTransformUtils.preCheckCast(r2.next(), b.class, "com.obric.aiagent.plugin")).a().getType() != OpenableAppInfo.OpenableAppType.LauncherEntry) goto L13;
        boolean r6 = true;
    L14:
        if (r6 == false) goto L9;
        r3 = r3 + 1;
        if (r3 >= 0) goto L9;
        p.d();
        goto L9
    L13:
        r6 = false;
    L18:
        StringBuilder r4 = r0.append(r3).append(", shortcut=");
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r15.a(), Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r7, Collection.class) == true) goto L21;
    L23:
        Iterator r8 = r7.iterator();
        int r9 = 0;
    L25:
        if (r8.hasNext() == false) goto L34;
        if (((b) ZeusTransformUtils.preCheckCast(r8.next(), b.class, "com.obric.aiagent.plugin")).a().getType() != OpenableAppInfo.OpenableAppType.LauncherShortcut) goto L29;
        boolean r10 = true;
    L30:
        if (r10 == false) goto L25;
        r9 = r9 + 1;
        if (r9 >= 0) goto L25;
        p.d();
        goto L25
    L29:
        r10 = false;
    L34:
        r14.i(TAG, r4.append(r9).toString());
        IAutoActionTrackingApi r11 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");
        JSONObject r12 = new JSONObject();
        r12.put("duration", r15.d());
        r12.put("launcher_duration", r15.b());
        r12.put("shortcut_duration", r15.c());
        r12.put("app_size", r15.a().size());
        Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast(r15.a(), Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r16, Collection.class) == true) goto L37;
    L39:
        Iterator r17 = r16.iterator();
        int r13 = 0;
    L41:
        if (r17.hasNext() == false) goto L50;
        if (((b) ZeusTransformUtils.preCheckCast(r17.next(), b.class, "com.obric.aiagent.plugin")).a().getType() != OpenableAppInfo.OpenableAppType.LauncherEntry) goto L45;
        boolean r18 = true;
    L46:
        if (r18 == false) goto L41;
        r13 = r13 + 1;
        if (r13 >= 0) goto L41;
        p.d();
        goto L41
    L45:
        r18 = false;
    L50:
        r12.put("launcher_size", r13);
        Iterable r19 = (Iterable) ZeusTransformUtils.preCheckCast(r15.a(), Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r19, Collection.class) == true) goto L53;
    L55:
        Iterator r110 = r19.iterator();
        int r111 = 0;
    L57:
        if (r110.hasNext() == false) goto L66;
        if (((b) ZeusTransformUtils.preCheckCast(r110.next(), b.class, "com.obric.aiagent.plugin")).a().getType() != OpenableAppInfo.OpenableAppType.LauncherShortcut) goto L61;
        boolean r20 = true;
    L62:
        if (r20 == false) goto L57;
        r111 = r111 + 1;
        if (r111 >= 0) goto L57;
        p.d();
        goto L57
    L61:
        r20 = false;
        goto L62
    L66:
        r5 = r111;
    L67:
        r12.put("shortcut_size", r5);
        x r112 = x.f38692a;
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r11, "oauto_fast_app_info", r12, false, false, null, 28, null);
        return;
    L53:
        if (((Collection) ZeusTransformUtils.preCheckCast(r19, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L55;
    L37:
        if (((Collection) ZeusTransformUtils.preCheckCast(r16, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L39;
        r13 = 0;
        goto L50
    L21:
        if (((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L23;
        r9 = 0;
        goto L34
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r1, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L7;
        r3 = 0;
        goto L18
    }

    private final JSONArray a(List<b> r6) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        JSONArray r7 = new JSONArray();
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(p.c((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.aiagent.plugin"), 50), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r8.hasNext() == false) goto L6;
        b r1 = (b) ZeusTransformUtils.preCheckCast(r8.next(), b.class, "com.obric.aiagent.plugin");
        JSONObject r2 = new JSONObject();
        r2.put("package_name", r1.a().a());
        r2.put("type", r1.a().getType().name());
        r2.put("stable_id", r1.a().b());
        r7.put(r2);
        goto L4
    L6:
        return r7;
    }

    private final JSONArray b(List<f> r6) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        JSONArray r7 = new JSONArray();
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(p.c((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.aiagent.plugin"), 50), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r8.hasNext() == false) goto L6;
        f r1 = (f) ZeusTransformUtils.preCheckCast(r8.next(), f.class, "com.obric.aiagent.plugin");
        JSONObject r2 = new JSONObject();
        r2.put("package_name", r1.a().a());
        r2.put("type", r1.a().getType().name());
        r2.put("stable_id", r1.a().b());
        r7.put(r2);
        goto L4
    L6:
        return r7;
    }
}
