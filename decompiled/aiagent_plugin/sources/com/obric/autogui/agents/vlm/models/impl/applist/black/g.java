package com.obric.autogui.agents.vlm.models.impl.applist.black;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import com.bytedance.apm.battery.dao.DBHelper;
import com.obric.autogui.common.api.AOAgentRobotsTools;
import com.obric.autogui.common.api.AOPackagesTools;
import com.obric.autogui.common.api.agent.blacklist.AppBlackListEvent;
import com.obric.autogui.common.api.agent.blacklist.AppBlackListEventHolder;
import com.obric.autogui.common.api.agent.blacklist.AppBlackListState;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.AOPlatformTools;
import com.obric.autogui.common.api.platform.packages.appinfo.OpenableAppInfo;
import com.obric.autogui.common.api.platform.security.IAutoActionSecurityApi;
import com.obric.autogui.common.api.platform.strategy.IAutoActionPlatformStrategyApi;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ax;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import kotlinx.coroutines.am;
import kotlinx.coroutines.bd;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: AppBlackListStorage.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g {
    private static final String TAG = "BLStorage";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f27362a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Set<String> f27363b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static com.obric.autogui.agents.vlm.models.impl.applist.black.b f27364c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Set<String> f27365d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Set<String> f27366e = null;
    private static volatile int f;
    private static final Set<String> g = null;
    private static final Object h = null;
    private static volatile Boolean i;
    private static volatile int j;
    private static volatile int k;
    private static volatile Set<String> l;
    private static final AtomicLong m = null;
    private static volatile com.obric.autogui.agents.vlm.models.impl.applist.black.j n;
    private static volatile com.obric.autogui.agents.vlm.models.impl.applist.black.j o;
    private static final Object p = null;
    private static volatile Set<String> q;
    private static volatile long r;

    /* JADX INFO: compiled from: AppBlackListStorage.kt */
    private static final class a implements com.obric.autogui.agents.vlm.models.impl.applist.black.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f27367a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.obric.autogui.agents.vlm.models.impl.applist.black.j f27368b;

        /* JADX INFO: renamed from: com.obric.autogui.agents.vlm.models.impl.applist.black.g$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: AppBlackListStorage.kt */
        @d.c.b.a.f(b = "AppBlackListStorage.kt", c = {219, 226}, d = DownloadConstants.QUERY_KEY, e = "com.obric.autogui.agents.vlm.models.impl.applist.black.AppBlackListStorage$GlobalWhitelistUserDefinedDataSource")
        static final class C0688a extends d.c.b.a.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            Object f27369a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            Object f27370b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            /* synthetic */ Object f27371c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ a f27372d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            int f27373e;

            C0688a(a r3, d.c.d<? super C0688a> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f27372d = r3;
                super(r5);
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r3) {
                this.f27371c = r3;
                this.f27373e |= Integer.MIN_VALUE;
                return this.f27372d.query(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
            }
        }

        /* JADX INFO: compiled from: AppBlackListStorage.kt */
        @d.c.b.a.f(b = "AppBlackListStorage.kt", c = {236, 243}, d = "queryState", e = "com.obric.autogui.agents.vlm.models.impl.applist.black.AppBlackListStorage$GlobalWhitelistUserDefinedDataSource")
        static final class b extends d.c.b.a.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            Object f27374a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            Object f27375b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            /* synthetic */ Object f27376c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ a f27377d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            int f27378e;

            b(a r3, d.c.d<? super b> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f27377d = r3;
                super(r5);
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r3) {
                this.f27376c = r3;
                this.f27378e |= Integer.MIN_VALUE;
                return this.f27377d.a(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
            }
        }

        public a(Context r3, com.obric.autogui.agents.vlm.models.impl.applist.black.j r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            com.obric.autogui.agents.vlm.models.impl.applist.black.j r6 = (com.obric.autogui.agents.vlm.models.impl.applist.black.j) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.autogui.agents.vlm.models.impl.applist.black.j.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r5, "appContext");
            d.h.b.o.e(r6, "delegate");
            this.f27367a = ZeusTransformUtils.wrapperContext(r5, "com.obric.aiagent.plugin");
            this.f27368b = r6;
        }

        public final com.obric.autogui.agents.vlm.models.impl.applist.black.j a() {
            return this.f27368b;
        }

        private final String a(String r2) {
            return d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        }

        private final Object b(String r10, d.c.d<? super Boolean> r11) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
            String r4 = a(r10);
            if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L7;
            return d.c.b.a.b.a(false);
        L7:
            return IAutoActionPlatformStrategyApi.DefaultImpls.isGloballyWhitelistedPackage$default(AOPlatformTools.INSTANCE.platformStrategy(), this.f27367a, r4, null, r6, 4, null);
        }

        @Override // com.obric.autogui.agents.vlm.models.impl.applist.black.j
        public Object query(String r7, d.c.d<? super com.obric.autogui.agents.vlm.models.impl.applist.black.j.c> r8) {
            d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r9, C0688a.class) == false) goto L7;
            C0688a r0 = (C0688a) ZeusTransformUtils.preCheckCast(r9, C0688a.class, "com.obric.aiagent.plugin");
            if ((r0.f27373e & Integer.MIN_VALUE) == 0) goto L7;
            r0.f27373e -= Integer.MIN_VALUE;
        L8:
            Object r10 = r0.f27371c;
            Object r2 = d.c.a.b.a();
            int r3 = r0.f27373e;
            if (r3 == 0) goto L16;
            if (r3 == 1) goto L15;
            if (r3 != 2) goto L14;
            d.o.a(r10);
        L26:
            return r10;
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L15:
            r7 = (String) ZeusTransformUtils.preCheckCast(r0.f27370b, String.class, "com.obric.aiagent.plugin");
            a this = (a) ZeusTransformUtils.preCheckCast(r0.f27369a, a.class, "com.obric.aiagent.plugin");
            d.o.a(r10);
        L20:
            if (((Boolean) ZeusTransformUtils.preCheckCast(r10, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == false) goto L23;
            Loog.INSTANCE.i(g.TAG, "[BL] global whitelist bypass query: pkg=" + this.a(r7));
            return new com.obric.autogui.agents.vlm.models.impl.applist.black.j.c(true, null);
        L23:
            com.obric.autogui.agents.vlm.models.impl.applist.black.j r11 = this.f27368b;
            String r6 = g.a(g.f27362a, this.f27367a, r7);
            r0.f27369a = null;
            r0.f27370b = null;
            r0.f27373e = 2;
            r10 = r11.query(r6, r0);
            if (r10 != r2) goto L26;
            return r2;
        L16:
            d.o.a(r10);
            r0.f27369a = this;
            r0.f27370b = r7;
            r0.f27373e = 1;
            r10 = b(r7, r0);
            if (r10 != r2) goto L20;
            return r2;
        L7:
            r0 = new C0688a(this, r9);
            goto L8
        }

        @Override // com.obric.autogui.agents.vlm.models.impl.applist.black.j
        public Object a(d.c.d<? super com.obric.autogui.agents.vlm.models.impl.applist.black.j.a> r3) {
            d.c.d<? super com.obric.autogui.agents.vlm.models.impl.applist.black.j.a> r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return this.f27368b.a(r4);
        }

        @Override // com.obric.autogui.agents.vlm.models.impl.applist.black.j
        public Object a(String r7, d.c.d<? super com.obric.autogui.agents.vlm.models.impl.applist.black.j.d> r8) {
            d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r9, b.class) == false) goto L7;
            b r0 = (b) ZeusTransformUtils.preCheckCast(r9, b.class, "com.obric.aiagent.plugin");
            if ((r0.f27378e & Integer.MIN_VALUE) == 0) goto L7;
            r0.f27378e -= Integer.MIN_VALUE;
        L8:
            Object r10 = r0.f27376c;
            Object r2 = d.c.a.b.a();
            int r3 = r0.f27378e;
            if (r3 == 0) goto L16;
            if (r3 == 1) goto L15;
            if (r3 != 2) goto L14;
            d.o.a(r10);
        L26:
            return r10;
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L15:
            r7 = (String) ZeusTransformUtils.preCheckCast(r0.f27375b, String.class, "com.obric.aiagent.plugin");
            a this = (a) ZeusTransformUtils.preCheckCast(r0.f27374a, a.class, "com.obric.aiagent.plugin");
            d.o.a(r10);
        L20:
            if (((Boolean) ZeusTransformUtils.preCheckCast(r10, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == false) goto L23;
            Loog.INSTANCE.i(g.TAG, "[BL] global whitelist bypass queryState: pkg=" + this.a(r7));
            return new com.obric.autogui.agents.vlm.models.impl.applist.black.j.d(true, com.obric.autogui.agents.vlm.models.impl.applist.black.j.e.f27428a);
        L23:
            com.obric.autogui.agents.vlm.models.impl.applist.black.j r11 = this.f27368b;
            String r6 = g.a(g.f27362a, this.f27367a, r7);
            r0.f27374a = null;
            r0.f27375b = null;
            r0.f27378e = 2;
            r10 = r11.a(r6, r0);
            if (r10 != r2) goto L26;
            return r2;
        L16:
            d.o.a(r10);
            r0.f27374a = this;
            r0.f27375b = r7;
            r0.f27378e = 1;
            r10 = b(r7, r0);
            if (r10 != r2) goto L20;
            return r2;
        L7:
            r0 = new b(this, r9);
            goto L8
        }

        @Override // com.obric.autogui.agents.vlm.models.impl.applist.black.j
        public Object b(d.c.d<? super com.obric.autogui.agents.vlm.models.impl.applist.black.j.b> r3) {
            d.c.d<? super com.obric.autogui.agents.vlm.models.impl.applist.black.j.b> r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return this.f27368b.b(r4);
        }

        @Override // com.obric.autogui.agents.vlm.models.impl.applist.black.j
        public Object update(String r3, com.obric.autogui.agents.vlm.models.impl.applist.black.j.e r4, d.c.d<? super Boolean> r5) {
            d.c.d<? super Boolean> r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return this.f27368b.update(g.a(g.f27362a, this.f27367a, r3), r4, r6);
        }
    }

    /* JADX INFO: compiled from: AppBlackListStorage.kt */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Set<String> f27379a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Set<String> f27380b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f27379a, r6.f27379a) == true) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f27380b, r6.f27380b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f27379a.hashCode() * 31) + this.f27380b.hashCode();
        }

        public String toString() {
            return "SaepPackages(restrictedPackages=" + this.f27379a + ", saepDeclaredPackages=" + this.f27380b + ')';
        }

        public b(Set<String> r3, Set<String> r4) {
            Set<String> r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.aiagent.plugin");
            Set<String> r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r5, "restrictedPackages");
            d.h.b.o.e(r6, "saepDeclaredPackages");
            this.f27379a = r5;
            this.f27380b = r6;
        }

        public final Set<String> a() {
            return this.f27379a;
        }

        public final Set<String> b() {
            return this.f27380b;
        }
    }

    /* JADX INFO: compiled from: AppBlackListStorage.kt */
    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f27381a = null;

        static {
            int[] r0 = new int[com.obric.autogui.agents.vlm.models.impl.applist.black.e.a.values().length];
            r0[com.obric.autogui.agents.vlm.models.impl.applist.black.e.a.f27353a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[com.obric.autogui.agents.vlm.models.impl.applist.black.e.a.f27354b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[com.obric.autogui.agents.vlm.models.impl.applist.black.e.a.f27355c.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f27381a = r0;
        }
    }

    /* JADX INFO: compiled from: AppBlackListStorage.kt */
    @d.c.b.a.f(b = "AppBlackListStorage.kt", c = {845}, d = "amendUserDefined", e = "com.obric.autogui.agents.vlm.models.impl.applist.black.AppBlackListStorage")
    static final class d extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f27382a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ g f27383b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f27384c;

        d(g r3, d.c.d<? super d> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f27383b = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f27382a = r3;
            this.f27384c |= Integer.MIN_VALUE;
            return this.f27383b.a(null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: AppBlackListStorage.kt */
    @d.c.b.a.f(b = "AppBlackListStorage.kt", c = {803}, d = "getAllUserDefined", e = "com.obric.autogui.agents.vlm.models.impl.applist.black.AppBlackListStorage")
    static final class e extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f27385a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ g f27386b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f27387c;

        e(g r3, d.c.d<? super e> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f27386b = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f27385a = r3;
            this.f27387c |= Integer.MIN_VALUE;
            return this.f27386b.a(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: AppBlackListStorage.kt */
    @d.c.b.a.f(b = "AppBlackListStorage.kt", c = {594}, d = "queryBlackListState", e = "com.obric.autogui.agents.vlm.models.impl.applist.black.AppBlackListStorage")
    static final class f extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f27388a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ g f27389b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f27390c;

        f(g r3, d.c.d<? super f> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f27389b = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f27388a = r3;
            this.f27390c |= Integer.MIN_VALUE;
            return this.f27389b.a(null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.autogui.agents.vlm.models.impl.applist.black.g$g, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AppBlackListStorage.kt */
    @d.c.b.a.f(b = "AppBlackListStorage.kt", c = {619, 631, 703}, d = "queryBlackListStateUnsafe", e = "com.obric.autogui.agents.vlm.models.impl.applist.black.AppBlackListStorage")
    static final class C0689g extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f27391a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f27392b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f27393c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f27394d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        /* synthetic */ Object f27395e;
        final /* synthetic */ g f;
        int g;

        C0689g(g r3, d.c.d<? super C0689g> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f27395e = r3;
            this.g |= Integer.MIN_VALUE;
            return g.a(this.f, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: AppBlackListStorage.kt */
    @d.c.b.a.f(b = "AppBlackListStorage.kt", c = {818}, d = "queryUserDefined", e = "com.obric.autogui.agents.vlm.models.impl.applist.black.AppBlackListStorage")
    static final class h extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f27396a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ g f27397b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f27398c;

        h(g r3, d.c.d<? super h> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f27397b = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f27396a = r3;
            this.f27398c |= Integer.MIN_VALUE;
            return g.b(this.f27397b, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: AppBlackListStorage.kt */
    @d.c.b.a.f(b = "AppBlackListStorage.kt", c = {779, 786}, d = "removeGlobalWhitelistedPackages", e = "com.obric.autogui.agents.vlm.models.impl.applist.black.AppBlackListStorage")
    static final class i extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f27399a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f27400b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f27401c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f27402d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f27403e;
        Object f;
        Object g;
        /* synthetic */ Object h;
        final /* synthetic */ g i;
        int j;

        i(g r3, d.c.d<? super i> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.i = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.h = r3;
            this.j |= Integer.MIN_VALUE;
            return g.a(this.i, null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: AppBlackListStorage.kt */
    @d.c.b.a.f(b = "AppBlackListStorage.kt", c = {469, 505, 527, 538, 558}, d = "invokeSuspend", e = "com.obric.autogui.agents.vlm.models.impl.applist.black.AppBlackListStorage$syncFrameworkDisabledApps$2")
    static final class j extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f27404a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f27405b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f27406c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f27407d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f27408e;
        Object f;
        Object g;
        int h;
        final /* synthetic */ boolean i;
        final /* synthetic */ Context j;
        private /* synthetic */ Object k;

        j(boolean r3, Context r4, d.c.d<? super j> r5) {
            Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.i = r3;
            this.j = ZeusTransformUtils.wrapperContext(r6, "com.obric.aiagent.plugin");
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((j) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), j.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            j r0 = new j(this.i, this.j, r6);
            r0.k = r4;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:98:0x03a9 -> B:99:0x03ae). Please report as a decompilation issue!!! */
        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r19) {
            Object r2 = d.c.a.b.a();
            int r0 = this.h;
            boolean r8 = false;
            if (r0 == 0) goto L20;
            if (r0 == 1) goto L19;
            if (r0 == 2) goto L18;
            if (r0 == 3) goto L13;
            if (r0 == 4) goto L12;
            if (r0 != 5) goto L11;
            LinkedHashSet r1 = (LinkedHashSet) ZeusTransformUtils.preCheckCast(this.f27404a, LinkedHashSet.class, "com.obric.aiagent.plugin");
            Set r3 = (Set) ZeusTransformUtils.preCheckCast(this.k, Set.class, "com.obric.aiagent.plugin");
            d.o.a(r19);
        L125:
        L119:
            th = move-exception;
            Loog.INSTANCE.e(g.TAG, "[BL-Sync] setGloballyDisabledPackages failed: e=" + th, th);
        L122:
            return x.f38692a;
        L115:
            if (g.a(g.f27362a, true, (Set) ZeusTransformUtils.preCheckCast(r1, Set.class, "com.obric.aiagent.plugin")) == false) goto L117;
            AOPlatformTools.INSTANCE.display().setGloballyDisabledPackages(this.j, (Collection) ZeusTransformUtils.preCheckCast(r1, Collection.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L119
            Loog.INSTANCE.d(g.TAG, "[BL-Sync] synced v=" + g.f().incrementAndGet() + ", disabled=" + r1.size() + ", allowed=" + r3.size());     // Catch: Throwable -> L119
            goto L122
        L117:
            Loog.INSTANCE.d(g.TAG, "[BL-Sync] synced unchanged; skip apply; disabled=" + r1.size() + ", allowed=" + r3.size());     // Catch: Throwable -> L119
            goto L122
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L12:
            String r4 = (String) ZeusTransformUtils.preCheckCast(this.g, String.class, "com.obric.aiagent.plugin");
            Iterator r6 = (Iterator) ZeusTransformUtils.preCheckCast(this.f, Iterator.class, "com.obric.aiagent.plugin");
            Collection<OpenableAppInfo> r7 = (Collection) ZeusTransformUtils.preCheckCast(this.f27408e, Collection.class, "com.obric.aiagent.plugin");
            String r9 = (String) ZeusTransformUtils.preCheckCast(this.f27407d, String.class, "com.obric.aiagent.plugin");
            b r13 = (b) ZeusTransformUtils.preCheckCast(this.f27406c, b.class, "com.obric.aiagent.plugin");
            LinkedHashSet r14 = (LinkedHashSet) ZeusTransformUtils.preCheckCast(this.f27405b, LinkedHashSet.class, "com.obric.aiagent.plugin");
            Set r5 = (Set) ZeusTransformUtils.preCheckCast(this.f27404a, Set.class, "com.obric.aiagent.plugin");
            IAutoActionPlatformStrategyApi r11 = (IAutoActionPlatformStrategyApi) ZeusTransformUtils.preCheckCast(this.k, IAutoActionPlatformStrategyApi.class, "com.obric.aiagent.plugin");
            d.o.a(r19);
            Object r10 = r19;
            Object r12 = r2;
            r3 = r5;
        L100:
            if (((Boolean) ZeusTransformUtils.preCheckCast(r10, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == false) goto L103;
        L109:
            r1 = r14;
        L88:
            if (r6.hasNext() == false) goto L110;
            String r15 = (String) ZeusTransformUtils.preCheckCast(r6.next(), String.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(r15, r9) == true) goto L88;
            if (g.e().contains(r15) == true) goto L88;
            Context r16 = this.j;
            d.c.d<? super Boolean> r17 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.k = r11;
            this.f27404a = r3;
            this.f27405b = r1;
            this.f27406c = r13;
            this.f27407d = r9;
            this.f27408e = r7;
            this.f = r6;
            this.g = r15;
            this.h = 4;
            r10 = r11.isGloballyWhitelistedPackage(r16, r15, r7, r17);
            if (r10 != r12) goto L98;
            return r12;
        L98:
            r14 = r1;
            r4 = r15;
            goto L100
        L110:
            r1.removeAll((Collection) ZeusTransformUtils.preCheckCast(g.e(), Collection.class, "com.obric.aiagent.plugin"));
            g r18 = g.f27362a;
            Context r20 = this.j;
            Set r21 = (Set) ZeusTransformUtils.preCheckCast(r1, Set.class, "com.obric.aiagent.plugin");
            d.c.d r22 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.k = r3;
            this.f27404a = r1;
            this.f27405b = null;
            this.f27406c = null;
            this.f27407d = null;
            this.f27408e = null;
            this.f = null;
            this.g = null;
            this.h = 5;
            if (g.a(r18, r11, r20, r21, r22) != r12) goto L125;
            return r12;
        L103:
            if (g.a(g.f27362a, r4, r13) == false) goto L109;
            if (r3.contains(g.a(g.f27362a, this.j, r4)) == true) goto L109;
            r14.add(r4);
            goto L109
        L13:
            String r23 = (String) ZeusTransformUtils.preCheckCast(this.f27408e, String.class, "com.obric.aiagent.plugin");
            b r24 = (b) ZeusTransformUtils.preCheckCast(this.f27407d, b.class, "com.obric.aiagent.plugin");
            LinkedHashSet r25 = (LinkedHashSet) ZeusTransformUtils.preCheckCast(this.f27406c, LinkedHashSet.class, "com.obric.aiagent.plugin");
            Set r26 = (Set) ZeusTransformUtils.preCheckCast(this.f27405b, Set.class, "com.obric.aiagent.plugin");
            Set r110 = (Set) ZeusTransformUtils.preCheckCast(this.f27404a, Set.class, "com.obric.aiagent.plugin");
            IAutoActionPlatformStrategyApi r111 = (IAutoActionPlatformStrategyApi) ZeusTransformUtils.preCheckCast(this.k, IAutoActionPlatformStrategyApi.class, "com.obric.aiagent.plugin");
            d.o.a(r19);     // Catch: Throwable -> L16
            Object r27 = r19;
        L76:
            Object r28 = d.n.f((Collection) ZeusTransformUtils.preCheckCast(r27, Collection.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L16
        L81:
            String r112 = r23;
            b r29 = r24;
            if (d.n.b(r28) == false) goto L84;
            r28 = null;
        L84:
            Collection<OpenableAppInfo> r30 = (Collection) ZeusTransformUtils.preCheckCast(r28, Collection.class, "com.obric.aiagent.plugin");
        L86:
            r6 = r26.iterator();
            r9 = r112;
            LinkedHashSet r113 = r25;
            r7 = r30;
            r1 = r113;
            b r114 = r29;
            r12 = r2;
            r3 = r110;
            r11 = r111;
            r13 = r114;
        L16:
            th = th;
        L80:
            d.n.a r115 = d.n.f38560a;
            r28 = d.n.f(d.o.a(th));
            goto L81
        L18:
            IAutoActionPlatformStrategyApi r31 = (IAutoActionPlatformStrategyApi) ZeusTransformUtils.preCheckCast(this.f27404a, IAutoActionPlatformStrategyApi.class, "com.obric.aiagent.plugin");
            am r32 = (am) ZeusTransformUtils.preCheckCast(this.k, am.class, "com.obric.aiagent.plugin");
            d.o.a(r19);
            r111 = r31;
            Object r33 = r19;
        L50:
            com.obric.autogui.agents.vlm.models.impl.applist.black.j.b r34 = (com.obric.autogui.agents.vlm.models.impl.applist.black.j.b) ZeusTransformUtils.preCheckCast(r33, com.obric.autogui.agents.vlm.models.impl.applist.black.j.b.class, "com.obric.aiagent.plugin");
            if (r34.a() == true) goto L54;
            Loog.INSTANCE.e(g.TAG, "[BL-Sync] queryAllStates failed; skip");
            return x.f38692a;
        L54:
            Map<String, com.obric.autogui.agents.vlm.models.impl.applist.black.j.e> r35 = r34.b();
            if (r35 == null) goto L68;
            LinkedHashMap r36 = new LinkedHashMap();
            Iterator<Map.Entry<String, com.obric.autogui.agents.vlm.models.impl.applist.black.j.e>> r37 = r35.entrySet().iterator();
        L58:
            if (r37.hasNext() == false) goto L65;
            Map.Entry r38 = (Map.Entry) ZeusTransformUtils.preCheckCast(r37.next(), Map.Entry.class, "com.obric.aiagent.plugin");
            if (((com.obric.autogui.agents.vlm.models.impl.applist.black.j.e) ZeusTransformUtils.preCheckCast(r38.getValue(), com.obric.autogui.agents.vlm.models.impl.applist.black.j.e.class, "com.obric.aiagent.plugin")) != com.obric.autogui.agents.vlm.models.impl.applist.black.j.e.f27428a) goto L62;
            boolean r116 = true;
        L63:
            if (r116 == false) goto L58;
            r36.put(r38.getKey(), r38.getValue());
            goto L58
        L62:
            r116 = false;
            goto L63
        L65:
            Set r39 = ((Map) ZeusTransformUtils.preCheckCast(r36, Map.class, "com.obric.aiagent.plugin")).keySet();
            if (r39 == null) goto L68;
        L69:
            r110 = r39;
            r26 = g.a(g.f27362a, this.j);
            r25 = new LinkedHashSet(r26.size() + g.d().size());
            r29 = g.b(g.f27362a, this.j);
            r25.addAll((Collection) ZeusTransformUtils.preCheckCast(g.d(), Collection.class, "com.obric.aiagent.plugin"));
            r112 = this.j.getPackageName();
            if (com.obric.autogui.common.a.d.f28974a.q() == false) goto L85;
            Context r40 = this.j;
            d.n.a r117 = d.n.f38560a;     // Catch: Throwable -> L78
            AOPackagesTools r118 = AOPackagesTools.INSTANCE;     // Catch: Throwable -> L78
            this.k = r111;     // Catch: Throwable -> L78
            this.f27404a = r110;     // Catch: Throwable -> L78
            this.f27405b = r26;     // Catch: Throwable -> L78
            this.f27406c = r25;     // Catch: Throwable -> L78
            this.f27407d = r29;     // Catch: Throwable -> L78
            this.f27408e = r112;     // Catch: Throwable -> L78
            this.h = 3;     // Catch: Throwable -> L78
            r27 = r118.getOpenableApps(r40, this);     // Catch: Throwable -> L78
            if (r27 != r2) goto L75;
            return r2;
        L75:
            r24 = r29;
            r23 = r112;
        L78:
            th = th;
            r24 = r29;
            r23 = r112;
            goto L80
        L85:
            r30 = null;
        L68:
            r39 = ax.b();
            goto L69
        L19:
            LinkedHashSet r41 = (LinkedHashSet) ZeusTransformUtils.preCheckCast(this.k, LinkedHashSet.class, "com.obric.aiagent.plugin");
            d.o.a(r19);
        L128:
        L42:
            th = move-exception;
            Loog.INSTANCE.e(g.TAG, "[BL-Sync] hard-only apply failed: e=" + th, th);
        L45:
            return x.f38692a;
        L32:
            if (g.a(g.f27362a, false, (Set) ZeusTransformUtils.preCheckCast(r41, Set.class, "com.obric.aiagent.plugin")) == false) goto L37;
            AOPlatformTools.INSTANCE.display().setGloballyDisabledPackages(this.j, (Collection) ZeusTransformUtils.preCheckCast(r41, Collection.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L42
            long r42 = g.f().incrementAndGet();     // Catch: Throwable -> L42
            Loog r43 = Loog.INSTANCE;     // Catch: Throwable -> L42
            StringBuilder r44 = new StringBuilder().append("[BL-Sync] hard-only; applied v=").append(r42).append(", disabled=").append(r41.size()).append(", cc=");     // Catch: Throwable -> L42
            if (g.f27362a.a() == true) goto L36;
            r8 = true;
        L36:
            r43.d(g.TAG, r44.append(r8).toString());     // Catch: Throwable -> L42
            goto L45
        L37:
            Loog r45 = Loog.INSTANCE;     // Catch: Throwable -> L42
            StringBuilder r46 = new StringBuilder().append("[BL-Sync] hard-only; unchanged; skip apply; disabled=").append(r41.size()).append(", cc=");     // Catch: Throwable -> L42
            if (g.f27362a.a() == true) goto L40;
            r8 = true;
        L40:
            r45.d(g.TAG, r46.append(r8).toString());     // Catch: Throwable -> L42
            goto L45
        L20:
            d.o.a(r19);
            am r47 = (am) ZeusTransformUtils.preCheckCast(this.k, am.class, "com.obric.aiagent.plugin");
            IAutoActionPlatformStrategyApi r48 = AOPlatformTools.INSTANCE.platformStrategy();
            if (this.i == true) goto L23;
        L25:
            boolean r119 = false;
        L26:
            if (r119 == true) goto L46;
            r41 = new LinkedHashSet(g.d().size());
            r41.addAll((Collection) ZeusTransformUtils.preCheckCast(g.d(), Collection.class, "com.obric.aiagent.plugin"));
            r41.remove(this.j.getPackageName());
            r41.removeAll((Collection) ZeusTransformUtils.preCheckCast(g.e(), Collection.class, "com.obric.aiagent.plugin"));
            g r49 = g.f27362a;
            Context r50 = this.j;
            Set r51 = (Set) ZeusTransformUtils.preCheckCast(r41, Set.class, "com.obric.aiagent.plugin");
            d.c.d r120 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.k = r41;
            this.h = 1;
            if (g.a(r49, r48, r50, r51, r120) != r2) goto L128;
            return r2;
        L46:
            com.obric.autogui.agents.vlm.models.impl.applist.black.j r121 = g.f27362a.a(this.j);
            d.c.d<? super com.obric.autogui.agents.vlm.models.impl.applist.black.j.b> r122 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.k = r47;
            this.f27404a = r48;
            this.h = 2;
            r33 = r121.b(r122);
            if (r33 != r2) goto L49;
            return r2;
        L49:
            r111 = r48;
            goto L50
        L23:
            if (g.f27362a.a() == false) goto L25;
            r119 = true;
            goto L26
        }
    }

    private g() {
    }

    public static final /* synthetic */ Object a(g r2, Context r3, String r4, d.c.d r5) {
        return r2.b((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), r4, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(g r2, IAutoActionPlatformStrategyApi r3, Context r4, Set r5, d.c.d r6) {
        return r2.a((IAutoActionPlatformStrategyApi) ZeusTransformUtils.wrapperContextForParams(r3, IAutoActionPlatformStrategyApi.class, "com.obric.aiagent.plugin"), (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin"), (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ String a(g r2, Context r3, String r4) {
        return r2.a((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), r4);
    }

    public static final /* synthetic */ Set a(g r2, Context r3) {
        return r2.b((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ boolean a(g r0, String r1, b r2) {
        return r0.a(r1, r2);
    }

    public static final /* synthetic */ boolean a(g r2, boolean r3, Set r4) {
        return r2.a(r3, (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ b b(g r2, Context r3) {
        return r2.c((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object b(g r2, Context r3, String r4, d.c.d r5) {
        return r2.c((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), r4, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Set d() {
        return f27365d;
    }

    public static final /* synthetic */ Set e() {
        return f27363b;
    }

    public static final /* synthetic */ AtomicLong f() {
        return m;
    }

    private final String a(Context r3, String r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        String r6 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        if (d.h.b.o.a(r6, "com.obric.feedback") == true) goto L9;
        return r6;
    L9:
        r5.getPackageManager().getPackageInfo("com.obric.feedbackserviceproject", 0);     // Catch: Exception -> L7
        return "com.obric.feedbackserviceproject";
    L8:
        return r6;
    }

    public final boolean a() {
        return !com.obric.autogui.common.a.c.f28972a.a().c();
    }

    public final void a(String r10) {
        d.h.b.o.e(r10, "packageName");
        String r11 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L6;
        return;
    L6:
        if (a() == true) goto L9;
        Loog.INSTANCE.i(TAG, "[CC-Auth] skip legacy UserDefined event: pkg=" + r11);
        return;
    L9:
        AppBlackListEventHolder.INSTANCE.setBlackListEvent(new AppBlackListEvent(new ComponentName(r11, "OpenApp"), AppBlackListState.UserDefinedBlackList, 0, 0, false, 28, null));
        Loog.INSTANCE.i(TAG, "[BL] post UD event for OpenApp: pkg=" + r11);
    }

    static {
        f27362a = new g();
        f27363b = ax.a(new String[]{"com.android.launcher3", "com.miui.home"});
        f27365d = Collections.synchronizedSet((Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.aiagent.plugin"));
        f27366e = Collections.synchronizedSet((Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.aiagent.plugin"));
        g = Collections.synchronizedSet((Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.aiagent.plugin"));
        h = new Object();
        m = new AtomicLong(0);
        p = new Object();
    }

    private final boolean a(boolean r6, Set<String> r7) {
        Set r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r7, Set.class, "com.obric.aiagent.plugin");
        Object r8 = h;
        monitor-enter(r8);
        Boolean r0 = i;     // Catch: Throwable -> L22
        int r1 = j;     // Catch: Throwable -> L22
        int r2 = k;     // Catch: Throwable -> L22
        Set<String> r3 = l;     // Catch: Throwable -> L22
        if (r0 != null) goto L7;
    L18:
        i = Boolean.valueOf(r6);     // Catch: Throwable -> L22
        j = r5.hashCode();     // Catch: Throwable -> L22
        k = r5.size();     // Catch: Throwable -> L22
        l = (Set) ZeusTransformUtils.preCheckCast(new HashSet((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.aiagent.plugin")), Set.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L22
        monitor-exit(r8);
        return true;
    L7:
        if (d.h.b.o.a(r0, Boolean.valueOf(r6)) == false) goto L18;
        if (r1 != r5.hashCode()) goto L18;
        if (r2 != r5.size()) goto L18;
        if (r3 == null) goto L18;
        if (d.h.b.o.a(r3, r5) == false) goto L18;
        monitor-exit(r8);
        return false;
    L22:
        th = move-exception;
        throw th;
    }

    private final com.obric.autogui.agents.vlm.models.impl.applist.black.j a(Context r3, com.obric.autogui.agents.vlm.models.impl.applist.black.j r4) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.vlm.models.impl.applist.black.j r5 = (com.obric.autogui.agents.vlm.models.impl.applist.black.j) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.autogui.agents.vlm.models.impl.applist.black.j.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L7;
        Context r6 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.c(r6, "getApplicationContext(...)");
        return (com.obric.autogui.agents.vlm.models.impl.applist.black.j) ZeusTransformUtils.preCheckCast(new a(r6, r5), com.obric.autogui.agents.vlm.models.impl.applist.black.j.class, "com.obric.aiagent.plugin");
    L7:
        return r5;
    }

    public final com.obric.autogui.agents.vlm.models.impl.applist.black.j a(Context r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r9, "context");
        com.obric.autogui.agents.vlm.models.impl.applist.black.j r0 = n;
        if (r0 == null) goto L7;
        return a(r9, r0);
    L7:
        if (com.obric.autogui.common.a.d.f28974a.q() == false) goto L9;
        com.obric.autogui.agents.vlm.models.impl.applist.black.j r7 = o;
        if (r7 == null) goto L13;
        return r7;
    L13:
        Object r10 = p;
        monitor-enter(r10);
        com.obric.autogui.agents.vlm.models.impl.applist.black.j r1 = o;     // Catch: Throwable -> L22
        if (r1 == null) goto L19;
        monitor-exit(r10);
        return r1;
    L19:
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r9.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L22
        d.h.b.o.c(r2, "getApplicationContext(...)");     // Catch: Throwable -> L22
        l r3 = new l((com.obric.autogui.agents.vlm.models.impl.applist.black.j) ZeusTransformUtils.preCheckCast(new k(r2), com.obric.autogui.agents.vlm.models.impl.applist.black.j.class, "com.obric.aiagent.plugin"), 0, 2, null);     // Catch: Throwable -> L22
        com.obric.autogui.agents.vlm.models.impl.applist.black.j r11 = f27362a.a(r9, (com.obric.autogui.agents.vlm.models.impl.applist.black.j) ZeusTransformUtils.preCheckCast(r3, com.obric.autogui.agents.vlm.models.impl.applist.black.j.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L22
        o = r11;     // Catch: Throwable -> L22
        monitor-exit(r10);
        return r11;
    L22:
        th = move-exception;
        throw th;
    L9:
        return a(r9, (com.obric.autogui.agents.vlm.models.impl.applist.black.j) ZeusTransformUtils.preCheckCast(new k(r9), com.obric.autogui.agents.vlm.models.impl.applist.black.j.class, "com.obric.aiagent.plugin"));
    }

    public final void b() {
        com.obric.autogui.agents.vlm.models.impl.applist.black.j r2 = o;
        if (ZeusTransformUtils.instanceOf(r2, l.class) == false) goto L6;
        ((l) ZeusTransformUtils.preCheckCast(r2, l.class, "com.obric.aiagent.plugin")).a();
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r2, a.class) == false) goto L15;
        com.obric.autogui.agents.vlm.models.impl.applist.black.j r3 = ((a) ZeusTransformUtils.preCheckCast(r2, a.class, "com.obric.aiagent.plugin")).a();
        if (ZeusTransformUtils.instanceOf(r3, l.class) == false) goto L10;
        l r4 = (l) ZeusTransformUtils.preCheckCast(r3, l.class, "com.obric.aiagent.plugin");
    L11:
        if (r4 == null) goto L16;
        r4.a();
        return;
    L16:
        return;
    L10:
        r4 = null;
        goto L11
    }

    public final void c() {
        com.obric.autogui.agents.vlm.models.impl.applist.black.b r0 = f27364c;
        if (r0 == null) goto L5;
        r0.b();
    L5:
        f27364c = null;
        f27365d.clear();
        f27366e.clear();
        f = 0;
        g.clear();
    }

    public final void a(Integer r2) {
        int r1 = 1;
        if (r2 != null) goto L6;
    L8:
        r1 = 0;
    L9:
        f = r1;
        Loog.INSTANCE.i(TAG, "[BL-Mode] server list mode=" + f);
        return;
    L6:
        if (r2.intValue() != 1) goto L8;
        goto L8
    }

    public final void a(Iterable<com.obric.autogui.agents.vlm.models.impl.applist.black.h> r5) {
        Iterable r4 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r5, Iterable.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, DBHelper.BATTERY_COL_SOURCE);
        Iterator r6 = r4.iterator();
        int r1 = 0;
    L4:
        if (r6.hasNext() == false) goto L18;
        String r2 = ((com.obric.autogui.agents.vlm.models.impl.applist.black.h) ZeusTransformUtils.preCheckCast(r6.next(), com.obric.autogui.agents.vlm.models.impl.applist.black.h.class, "com.obric.aiagent.plugin")).a();
        if (r2 == null) goto L8;
        String r3 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin")).toString();
    L9:
        CharSequence r7 = (CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L12;
    L15:
        boolean r8 = true;
    L16:
        if (r8 == true) goto L4;
        g.add(r3);
        r1 = r1 + 1;
        goto L4
    L12:
        if (d.o.o.d(r7) == true) goto L15;
        r8 = false;
        goto L16
    L8:
        r3 = null;
        goto L9
    L18:
        Loog.INSTANCE.i(TAG, "[BL-Pour] white-list with " + r1 + " items");
    }

    public final void a(Iterable<com.obric.autogui.agents.vlm.models.impl.applist.black.a> r10, com.obric.autogui.agents.vlm.models.impl.applist.black.e.a r11) {
        Iterable r9 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r10, Iterable.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r9, DBHelper.BATTERY_COL_SOURCE);
        d.h.b.o.e(r11, "type");
        com.obric.autogui.agents.vlm.models.impl.applist.black.b r12 = f27364c;
        if (r12 != null) goto L5;
        r12 = (com.obric.autogui.agents.vlm.models.impl.applist.black.b) ZeusTransformUtils.preCheckCast(new com.obric.autogui.agents.vlm.models.impl.applist.black.d(), com.obric.autogui.agents.vlm.models.impl.applist.black.b.class, "com.obric.aiagent.plugin");
        f27364c = r12;
    L5:
        Iterator r13 = r9.iterator();
        int r2 = 0;
    L7:
        if (r13.hasNext() == false) goto L25;
        com.obric.autogui.agents.vlm.models.impl.applist.black.a r3 = (com.obric.autogui.agents.vlm.models.impl.applist.black.a) ZeusTransformUtils.preCheckCast(r13.next(), com.obric.autogui.agents.vlm.models.impl.applist.black.a.class, "com.obric.aiagent.plugin");
        String r4 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r3.d(), CharSequence.class, "com.obric.aiagent.plugin")).toString();
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L20;
        int r5 = c.f27381a[r11.ordinal()];
        if (r5 == 1) goto L19;
        if (r5 != 2) goto L14;
        f27366e.add(r4);
        goto L20
    L14:
        if (r5 == 3) goto L20;
        throw new d.k();
    L19:
        f27365d.add(r4);
    L20:
        String r6 = r3.d();
        Collection r7 = (Collection) ZeusTransformUtils.preCheckCast(d.a.p.b(new String[]{r3.a(), r3.b()}), Collection.class, "com.obric.aiagent.plugin");
        List<String> r8 = r3.c();
        if (r8 != null) goto L24;
        r8 = d.a.p.b();
    L24:
        r12.a((com.obric.autogui.agents.vlm.models.impl.applist.black.e) ZeusTransformUtils.preCheckCast(new com.obric.autogui.agents.vlm.models.impl.applist.black.f(r11, r6, (Collection) ZeusTransformUtils.preCheckCast(d.a.p.c(r7, (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.aiagent.plugin")), Collection.class, "com.obric.aiagent.plugin")), com.obric.autogui.agents.vlm.models.impl.applist.black.e.class, "com.obric.aiagent.plugin"));
        r2 = r2 + 1;
        goto L7
    L25:
        Loog.INSTANCE.i(TAG, "[BL-Pour] black-list with " + r2 + '/' + r12.a() + " items as " + r11);
    }

    private final Set<String> b(Context r8) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
        long r1 = System.currentTimeMillis();
        Set<String> r9 = q;
        long r3 = r;
        if (r9 != null) goto L5;
    L28:
        PackageManager r10 = r7.getPackageManager();     // Catch: Throwable -> L25
        Intent r11 = new Intent("android.intent.action.MAIN").addCategory("android.intent.category.LAUNCHER");     // Catch: Throwable -> L25
        d.h.b.o.c(r11, "addCategory(...)");     // Catch: Throwable -> L25
        List<ResolveInfo> r12 = r10.queryIntentActivities(r11, 0);     // Catch: Throwable -> L25
        d.h.b.o.c(r12, "queryIntentActivities(...)");     // Catch: Throwable -> L25
        LinkedHashSet r13 = new LinkedHashSet(r12.size());     // Catch: Throwable -> L25
        Iterator<ResolveInfo> r14 = r12.iterator();     // Catch: Throwable -> L25
    L9:
        if (r14.hasNext() == false) goto L23;
        ActivityInfo r4 = ((ResolveInfo) ZeusTransformUtils.preCheckCast(r14.next(), ResolveInfo.class, "com.obric.aiagent.plugin")).activityInfo;     // Catch: Throwable -> L25
        if (r4 == null) goto L13;
        String r5 = r4.packageName;     // Catch: Throwable -> L25
    L14:
        CharSequence r6 = (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        if (r6 != null) goto L17;
    L20:
        boolean r15 = true;
    L21:
        if (r15 == true) goto L9;
        r13.add(r5);     // Catch: Throwable -> L25
        goto L9
    L17:
        if (d.o.o.d(r6) == true) goto L20;
        r15 = false;
        goto L21
    L13:
        r5 = null;
        goto L14
    L23:
        q = (Set) ZeusTransformUtils.preCheckCast(r13, Set.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        r = r1;     // Catch: Throwable -> L25
        return (Set) ZeusTransformUtils.preCheckCast(r13, Set.class, "com.obric.aiagent.plugin");
    L25:
        th = move-exception;
        Loog.INSTANCE.e(TAG, "[BL-Sync] getLaunchablePackages failed: e=" + th, th);
        return ax.b();
    L5:
        if ((r1 - r3) >= 60000) goto L28;
        return r9;
    }

    public final Object a(Context r4, boolean r5, d.c.d<? super x> r6) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        Object r8 = kotlinx.coroutines.i.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), (d.h.a.m) ZeusTransformUtils.preCheckCast(new j(r5, r3, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r7);
        if (r8 != d.c.a.b.a()) goto L6;
        return r8;
    L6:
        return x.f38692a;
    }

    public final Object a(Context r6, String r7, d.c.d<? super AppBlackListState> r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r10, f.class) == false) goto L7;
        f r0 = (f) ZeusTransformUtils.preCheckCast(r10, f.class, "com.obric.aiagent.plugin");
        if ((r0.f27390c & Integer.MIN_VALUE) == 0) goto L7;
        r0.f27390c -= Integer.MIN_VALUE;
    L8:
        Object r11 = r0.f27388a;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f27390c;
        if (r3 == 0) goto L17;
        if (r3 != 1) goto L16;
        d.o.a(r11);     // Catch: Throwable -> L13
    L21:
        return (AppBlackListState) ZeusTransformUtils.preCheckCast(r11, AppBlackListState.class, "com.obric.aiagent.plugin");
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        d.o.a(r11);
        r0.f27390c = 1;     // Catch: Throwable -> L13
        r11 = b(r9, r7, r0);     // Catch: Throwable -> L13
        if (r11 != r2) goto L21;
        return r2;
    L13:
        th = move-exception;
        Loog.INSTANCE.e(TAG, "[BL] queryBlackListState(): exception = " + th, th);
        return AppBlackListState.CannotObtain;
    L7:
        r0 = new f(this, r10);
        goto L8
    }

    private final Object b(Context r21, String r22, d.c.d<? super AppBlackListState> r23) {
        String r9 = r22;
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r21, Context.class, "com.obric.aiagent.plugin");
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r23, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r2, C0689g.class) == false) goto L7;
        C0689g r3 = (C0689g) ZeusTransformUtils.preCheckCast(r2, C0689g.class, "com.obric.aiagent.plugin");
        if ((r3.g & Integer.MIN_VALUE) == 0) goto L7;
        r3.g -= Integer.MIN_VALUE;
    L8:
        C0689g r12 = r3;
        Object r4 = r12.f27395e;
        Object r13 = d.c.a.b.a();
        int r5 = r12.g;
        boolean r16 = false;
        if (r5 == 0) goto L26;
        if (r5 == 1) goto L21;
        if (r5 == 2) goto L16;
        if (r5 != 3) goto L15;
        d.o.a(r4);
    L125:
        return r4;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        com.obric.autogui.agents.vlm.models.impl.applist.black.b r1 = (com.obric.autogui.agents.vlm.models.impl.applist.black.b) ZeusTransformUtils.preCheckCast(r12.f27394d, com.obric.autogui.agents.vlm.models.impl.applist.black.b.class, "com.obric.aiagent.plugin");
        String r6 = (String) ZeusTransformUtils.preCheckCast(r12.f27393c, String.class, "com.obric.aiagent.plugin");
        Context r7 = (Context) ZeusTransformUtils.preCheckCast(r12.f27392b, Context.class, "com.obric.aiagent.plugin");
        g r8 = (g) ZeusTransformUtils.preCheckCast(r12.f27391a, g.class, "com.obric.aiagent.plugin");
        d.o.a(r4);     // Catch: Throwable -> L19
        Object r0 = r4;
        String r15 = TAG;
        com.obric.autogui.agents.vlm.models.impl.applist.black.b r10 = r1;
        int r14 = 2;
    L55:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r0, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() != true) goto L61;
        boolean r17 = true;
    L62:
        if (r17 == false) goto L66;
        Loog.INSTANCE.w(r15, "[BL] virus detected: pkg=" + r6);
        return AppBlackListState.Virus;
    L66:
        if (r10 == null) goto L68;
        com.obric.autogui.agents.vlm.models.impl.applist.black.e r18 = r10.query(new com.obric.autogui.agents.vlm.models.impl.applist.black.c(r6));
    L69:
        if (r18 == null) goto L71;
        com.obric.autogui.agents.vlm.models.impl.applist.black.e.a r19 = r18.getType();
    L73:
        if (r19 == com.obric.autogui.agents.vlm.models.impl.applist.black.e.a.f27353a) goto L75;
        b r20 = r8.c(r7);
        if (r20 == null) goto L83;
        Set<String> r24 = r20.a();
        if (r24 == null) goto L83;
        if (r24.contains(r6) != true) goto L83;
        boolean r25 = true;
    L84:
        if (r25 == true) goto L86;
        if (r20 == null) goto L93;
        Set<String> r26 = r20.b();
        if (r26 == null) goto L93;
        if (r26.contains(r6) != true) goto L93;
        r16 = true;
    L93:
        if (r16 == false) goto L95;
    L111:
        if (r16 == true) goto L119;
        if (f != 1) goto L119;
        if (g.contains(r6) == true) goto L119;
        return AppBlackListState.SoftBlackList;
    L119:
        if (r8.a() == true) goto L122;
        Loog.INSTANCE.d(r15, "[CC-Auth] bypass legacy UserDefined query: pkg=" + r6);
        return AppBlackListState.Usable;
    L122:
        r12.f27391a = null;
        r12.f27392b = null;
        r12.f27393c = null;
        r12.f27394d = null;
        r12.g = 3;
        r4 = r8.c(r7, r6, r12);
        if (r4 != r13) goto L125;
        return r13;
    L95:
        if (f != 0) goto L111;
        if (r18 == null) goto L111;
        int r27 = c.f27381a[r18.getType().ordinal()];
        if (r27 == 1) goto L110;
        if (r27 == r14) goto L140;
        if (r27 != 3) goto L107;
        if (r8.a() == true) goto L138;
        Loog.INSTANCE.d(r15, "[CC-Auth] bypass legacy UserDefined item: pkg=" + r6);
        return AppBlackListState.Usable;
    L138:
        return AppBlackListState.UserDefinedBlackList;
    L107:
        throw new d.k();
    L140:
        return AppBlackListState.SoftBlackList;
    L110:
        return AppBlackListState.HardBlackList;
    L86:
        return AppBlackListState.SAEPBlackList;
    L83:
        r25 = false;
        goto L84
    L75:
        return AppBlackListState.HardBlackList;
    L71:
        r19 = null;
        goto L73
    L68:
        r18 = null;
    L61:
        r17 = false;
    L59:
        Throwable th = th;
    L60:
        Loog.INSTANCE.e(r15, "[BL] checkVirus failed: pkg=" + r6 + ", err=" + th, th);
    L19:
        th = th;
        r10 = r1;
        r15 = TAG;
        r14 = 2;
        goto L60
    L21:
        com.obric.autogui.agents.vlm.models.impl.applist.black.b r28 = (com.obric.autogui.agents.vlm.models.impl.applist.black.b) ZeusTransformUtils.preCheckCast(r12.f27394d, com.obric.autogui.agents.vlm.models.impl.applist.black.b.class, "com.obric.aiagent.plugin");
        r6 = (String) ZeusTransformUtils.preCheckCast(r12.f27393c, String.class, "com.obric.aiagent.plugin");
        r11 = (Context) ZeusTransformUtils.preCheckCast(r12.f27392b, Context.class, "com.obric.aiagent.plugin");
        g r29 = (g) ZeusTransformUtils.preCheckCast(r12.f27391a, g.class, "com.obric.aiagent.plugin");
        d.o.a(r4);     // Catch: Throwable -> L24
        com.obric.autogui.agents.vlm.models.impl.applist.black.b r110 = r28;
        r15 = TAG;
        r14 = 2;
    L126:
        boolean r30 = ((Boolean) ZeusTransformUtils.preCheckCast(r4, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();     // Catch: Throwable -> L38
        r8 = r29;
        r7 = r11;
    L46:
        r10 = r110;
        if (r30 == false) goto L128;
        Loog.INSTANCE.i(r15, "[AuthWL] pkg=" + r6 + " (global whitelisted; bypass blacklist)");
        return AppBlackListState.Usable;
    L128:
        IAutoActionSecurityApi r31 = AOPlatformTools.INSTANCE.security();     // Catch: Throwable -> L59
        if (r31 == null) goto L61;
        r12.f27391a = r8;     // Catch: Throwable -> L59
        r12.f27392b = r7;     // Catch: Throwable -> L59
        r12.f27393c = r6;     // Catch: Throwable -> L59
        r12.f27394d = r10;     // Catch: Throwable -> L59
        r12.g = r14;     // Catch: Throwable -> L59
        r0 = r31.checkVirus(r6, r12);     // Catch: Throwable -> L59
        if (r0 != r13) goto L55;
        return r13;
    L38:
        th = th;
        r9 = r6;
    L45:
        Loog.INSTANCE.e(r15, "[BL] global whitelist check failed: pkg=" + r9 + ", err=" + th, th);
        r8 = r29;
        r6 = r9;
        r7 = r11;
        r30 = false;
    L24:
        th = th;
        r110 = r28;
        r9 = r6;
        r15 = TAG;
        r14 = 2;
        goto L45
    L26:
        d.o.a(r4);
        com.obric.autogui.agents.vlm.models.impl.applist.black.b r32 = f27364c;
        if (f27363b.contains(r9) == true) goto L29;
        IAutoActionPlatformStrategyApi r33 = AOPlatformTools.INSTANCE.platformStrategy();     // Catch: Throwable -> L42
        r12.f27391a = this;     // Catch: Throwable -> L42
        r12.f27392b = r11;     // Catch: Throwable -> L42
        r12.f27393c = r9;     // Catch: Throwable -> L42
        r12.f27394d = r32;     // Catch: Throwable -> L42
        r12.g = 1;     // Catch: Throwable -> L42
        r110 = r32;
        r15 = TAG;
        r14 = 2;
        r4 = IAutoActionPlatformStrategyApi.DefaultImpls.isGloballyWhitelistedPackage$default(r33, r11, r22, null, r12, 4, null);     // Catch: Throwable -> L40
        if (r4 != r13) goto L35;
        return r13;
    L35:
        r29 = this;
        r6 = r9;
    L40:
        th = th;
    L44:
        r29 = this;
    L42:
        th = th;
        r110 = r32;
        r15 = TAG;
        r14 = 2;
        goto L44
    L29:
        return AppBlackListState.Usable;
    L7:
        r3 = new C0689g(this, r2);
        goto L8
    }

    private final boolean a(String r3, b r4) {
        if (r4 == null) goto L9;
        Set<String> r1 = r4.a();
        if (r1 == null) goto L9;
        if (r1.contains(r3) != true) goto L9;
        boolean r2 = true;
    L10:
        if (r2 == false) goto L12;
        return false;
    L12:
        if (r4 == null) goto L18;
        Set<String> r5 = r4.b();
        if (r5 == null) goto L18;
        if (r5.contains(r3) != true) goto L18;
        boolean r6 = true;
    L19:
        if (r6 == false) goto L22;
        return true;
    L22:
        if (f != 1) goto L27;
        if (g.contains(r3) == true) goto L27;
        return false;
    L27:
        return !f27366e.contains(r3);
    L18:
        r6 = false;
    L9:
        r2 = false;
        goto L10
    }

    private final b c(Context r7) {
        String r8 = AOAgentRobotsTools.INSTANCE.querySaepPackagesJson((Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin"));
        Object r0 = null;
        if (r8 != null) goto L18;
        return null;
    L18:
        d.n.a r2 = d.n.f38560a;     // Catch: Throwable -> L7
        g r6 = (g) ZeusTransformUtils.preCheckCast(this, g.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7
        JSONObject r3 = new JSONObject(r8);     // Catch: Throwable -> L7
        Object r9 = d.n.f(new b(r6.a(r3, "restricted_packages"), r6.a(r3, "saep_declared_packages")));     // Catch: Throwable -> L7
    L9:
        Throwable r4 = d.n.c(r9);
        if (r4 == null) goto L13;
        Loog.INSTANCE.e(TAG, "[SAEP] parse packages failed: " + r8, r4);
    L13:
        if (d.n.b(r9) == true) goto L17;
        r0 = r9;
    L17:
        return (b) ZeusTransformUtils.preCheckCast(r0, b.class, "com.obric.aiagent.plugin");
    L7:
        th = move-exception;
        d.n.a r5 = d.n.f38560a;
        r9 = d.n.f(d.o.a(th));
        goto L9
    }

    private final Set<String> a(JSONObject r5, String r6) {
        JSONArray r4 = r5.optJSONArray(r6);
        if (r4 == null) goto L5;
        LinkedHashSet r7 = new LinkedHashSet(r4.length());
        int r8 = 0;
        int r0 = r4.length();
    L8:
        if (r8 >= r0) goto L14;
        String r2 = r4.optString(r8);
        d.h.b.o.c(r2, "optString(...)");
        String r3 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L12;
        r7.add(r3);
    L12:
        r8 = r8 + 1;
        goto L8
    L14:
        return (Set) ZeusTransformUtils.preCheckCast(r7, Set.class, "com.obric.aiagent.plugin");
    L5:
        return ax.b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v10 */
    /* JADX WARN: Type inference failed for: r14v17, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r14v18 */
    /* JADX WARN: Type inference failed for: r14v19 */
    /* JADX WARN: Type inference failed for: r14v20 */
    /* JADX WARN: Type inference failed for: r14v21 */
    /* JADX WARN: Type inference failed for: r14v5 */
    /* JADX WARN: Type inference failed for: r14v7 */
    /* JADX WARN: Type inference failed for: r14v8, types: [java.lang.Object, java.util.Collection] */
    /* JADX WARN: Type inference failed for: r14v9 */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v2, types: [com.obric.autogui.common.api.platform.strategy.IAutoActionPlatformStrategyApi, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v8, types: [com.obric.autogui.common.api.platform.strategy.IAutoActionPlatformStrategyApi] */
    /* JADX WARN: Type inference failed for: r7v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x0163 -> B:48:0x0166). Please report as a decompilation issue!!! */
    private final Object a(IAutoActionPlatformStrategyApi r12, Context r13, Set<String> r14, d.c.d<? super x> r15) {
        IAutoActionPlatformStrategyApi r16 = (IAutoActionPlatformStrategyApi) ZeusTransformUtils.wrapperContextForParams(r12, IAutoActionPlatformStrategyApi.class, "com.obric.aiagent.plugin");
        Context r17 = (Context) ZeusTransformUtils.wrapperContextForParams(r13, Context.class, "com.obric.aiagent.plugin");
        Set r18 = (Set) ZeusTransformUtils.wrapperContextForParams(r14, Set.class, "com.obric.aiagent.plugin");
        d.c.d r19 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r15, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r19, i.class) == false) goto L7;
        i r0 = (i) ZeusTransformUtils.preCheckCast(r19, i.class, "com.obric.aiagent.plugin");
        if ((r0.j & Integer.MIN_VALUE) == 0) goto L7;
        r0.j -= Integer.MIN_VALUE;
    L8:
        Object r110 = r0.h;
        Object r2 = d.c.a.b.a();
        int r3 = r0.j;
        Object r4 = null;
        if (r3 == 0) goto L24;
        if (r3 == 1) goto L19;
        if (r3 != 2) goto L18;
        String r11 = (String) ZeusTransformUtils.preCheckCast(r0.g, String.class, "com.obric.aiagent.plugin");
        Iterator r111 = (Iterator) ZeusTransformUtils.preCheckCast(r0.f, Iterator.class, "com.obric.aiagent.plugin");
        ArrayList r112 = (ArrayList) ZeusTransformUtils.preCheckCast(r0.f27403e, ArrayList.class, "com.obric.aiagent.plugin");
        ?? r113 = (Collection) ZeusTransformUtils.preCheckCast(r0.f27402d, Collection.class, "com.obric.aiagent.plugin");
        Set r5 = (Set) ZeusTransformUtils.preCheckCast(r0.f27401c, Set.class, "com.obric.aiagent.plugin");
        Context r6 = (Context) ZeusTransformUtils.preCheckCast(r0.f27400b, Context.class, "com.obric.aiagent.plugin");
        ?? r7 = (IAutoActionPlatformStrategyApi) ZeusTransformUtils.preCheckCast(r0.f27399a, IAutoActionPlatformStrategyApi.class, "com.obric.aiagent.plugin");
        d.o.a(r110);     // Catch: Throwable -> L15
        r7 = r7;
        r113 = r113;
    L48:
        boolean r114 = ((Boolean) ZeusTransformUtils.preCheckCast(r110, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();     // Catch: Throwable -> L15
        ?? r8 = r7;
        ?? r115 = r113;
    L51:
        if (r114 == false) goto L43;
        r112.add(r11);
    L43:
        if (r111.hasNext() == false) goto L54;
        Object r116 = r111.next();
        d.h.b.o.c(r116, "next(...)");
        r11 = (String) ZeusTransformUtils.preCheckCast(r116, String.class, "com.obric.aiagent.plugin");
        r0.f27399a = r8;     // Catch: Throwable -> L15
        r0.f27400b = r6;     // Catch: Throwable -> L15
        r0.f27401c = r5;     // Catch: Throwable -> L15
        r0.f27402d = r115;     // Catch: Throwable -> L15
        r0.f27403e = r112;     // Catch: Throwable -> L15
        r0.f = r111;     // Catch: Throwable -> L15
        r0.g = r11;     // Catch: Throwable -> L15
        r0.j = 2;     // Catch: Throwable -> L15
        r110 = r8.isGloballyWhitelistedPackage(r6, r11, r115, r0);     // Catch: Throwable -> L15
        r7 = r8;
        r113 = r115;
        if (r110 != r2) goto L48;
        return r2;
    L54:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r112, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L57;
        r5.removeAll((Collection) ZeusTransformUtils.preCheckCast(d.a.p.q((Iterable) ZeusTransformUtils.preCheckCast(r112, Iterable.class, "com.obric.aiagent.plugin")), Collection.class, "com.obric.aiagent.plugin"));
    L57:
        return x.f38692a;
    L15:
        th = move-exception;
        Loog.INSTANCE.e(TAG, "[BL] global whitelist check failed: pkg=" + r11 + ", err=" + th, th);
        r114 = false;
        r8 = r7;
        r115 = r113;
        goto L51
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        r18 = (Set) ZeusTransformUtils.preCheckCast(r0.f27401c, Set.class, "com.obric.aiagent.plugin");
        r17 = (Context) ZeusTransformUtils.preCheckCast(r0.f27400b, Context.class, "com.obric.aiagent.plugin");
        r16 = (IAutoActionPlatformStrategyApi) ZeusTransformUtils.preCheckCast(r0.f27399a, IAutoActionPlatformStrategyApi.class, "com.obric.aiagent.plugin");
        d.o.a(r110);     // Catch: Throwable -> L22
    L33:
        Object r117 = d.n.f((Collection) ZeusTransformUtils.preCheckCast(r110, Collection.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L22
    L37:
        if (d.n.b(r117) == true) goto L40;
        r4 = r117;
    L40:
        r4 = (Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.aiagent.plugin");
    L41:
        ArrayList r118 = new ArrayList();
        r8 = r16;
        r5 = r18;
        r111 = r18.iterator();
        r115 = r4;
        r6 = r17;
        r112 = r118;
        goto L43
    L24:
        d.o.a(r110);
        if (r18.isEmpty() == false) goto L29;
        return x.f38692a;
    L29:
        if (com.obric.autogui.common.a.d.f28974a.q() == false) goto L41;
        d.n.a r119 = d.n.f38560a;     // Catch: Throwable -> L22
        g r120 = (g) ZeusTransformUtils.preCheckCast(this, g.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L22
        AOPackagesTools r121 = AOPackagesTools.INSTANCE;     // Catch: Throwable -> L22
        r0.f27399a = r16;     // Catch: Throwable -> L22
        r0.f27400b = r17;     // Catch: Throwable -> L22
        r0.f27401c = r18;     // Catch: Throwable -> L22
        r0.j = 1;     // Catch: Throwable -> L22
        r110 = r121.getOpenableApps(r17, r0);     // Catch: Throwable -> L22
        if (r110 != r2) goto L33;
        return r2;
    L22:
        th = move-exception;
        d.n.a r122 = d.n.f38560a;
        r117 = d.n.f(d.o.a(th));
    L7:
        r0 = new i(this, r19);
        goto L8
    }

    public final Object a(Context r6, d.c.d<? super Set<String>> r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r9, e.class) == false) goto L7;
        e r0 = (e) ZeusTransformUtils.preCheckCast(r9, e.class, "com.obric.aiagent.plugin");
        if ((r0.f27387c & Integer.MIN_VALUE) == 0) goto L7;
        r0.f27387c -= Integer.MIN_VALUE;
    L8:
        Object r10 = r0.f27385a;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f27387c;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        d.o.a(r10);
    L17:
        com.obric.autogui.agents.vlm.models.impl.applist.black.j.a r5 = (com.obric.autogui.agents.vlm.models.impl.applist.black.j.a) ZeusTransformUtils.preCheckCast(r10, com.obric.autogui.agents.vlm.models.impl.applist.black.j.a.class, "com.obric.aiagent.plugin");
        if (r5.a() == false) goto L23;
        Set<String> r11 = r5.b();
        if (r11 == null) goto L22;
        return r11;
    L22:
        return ax.b();
    L23:
        Loog.INSTANCE.e(TAG, "Failed to query user-defined list; keep old");
        return ax.b();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r10);
        com.obric.autogui.agents.vlm.models.impl.applist.black.j r12 = a(r8);
        r0.f27387c = 1;
        r10 = r12.a(r0);
        if (r10 != r2) goto L17;
        return r2;
    L7:
        r0 = new e(this, r9);
        goto L8
    }

    private final Object c(Context r6, String r7, d.c.d<? super AppBlackListState> r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r10, h.class) == false) goto L7;
        h r0 = (h) ZeusTransformUtils.preCheckCast(r10, h.class, "com.obric.aiagent.plugin");
        if ((r0.f27398c & Integer.MIN_VALUE) == 0) goto L7;
        r0.f27398c -= Integer.MIN_VALUE;
    L8:
        Object r11 = r0.f27396a;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f27398c;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        d.o.a(r11);
    L17:
        com.obric.autogui.agents.vlm.models.impl.applist.black.j.c r5 = (com.obric.autogui.agents.vlm.models.impl.applist.black.j.c) ZeusTransformUtils.preCheckCast(r11, com.obric.autogui.agents.vlm.models.impl.applist.black.j.c.class, "com.obric.aiagent.plugin");
        if (r5.a() == true) goto L21;
        return AppBlackListState.CannotObtain;
    L21:
        if (r5.b() != null) goto L24;
        return AppBlackListState.Usable;
    L24:
        return AppBlackListState.UserDefinedBlackList;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r11);
        com.obric.autogui.agents.vlm.models.impl.applist.black.j r12 = a(r9);
        r0.f27398c = 1;
        r11 = r12.query(r7, r0);
        if (r11 != r2) goto L17;
        return r2;
    L7:
        r0 = new h(this, r10);
        goto L8
    }

    public final Object a(Context r6, String r7, com.obric.autogui.agents.vlm.models.impl.applist.black.j.e r8, d.c.d<? super Boolean> r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r11, d.class) == false) goto L7;
        d r0 = (d) ZeusTransformUtils.preCheckCast(r11, d.class, "com.obric.aiagent.plugin");
        if ((r0.f27384c & Integer.MIN_VALUE) == 0) goto L7;
        r0.f27384c -= Integer.MIN_VALUE;
    L8:
        Object r12 = r0.f27382a;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f27384c;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        d.o.a(r12);
    L18:
        return d.c.b.a.b.a(((Boolean) ZeusTransformUtils.preCheckCast(r12, Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r12);
        com.obric.autogui.agents.vlm.models.impl.applist.black.j r5 = a(r10);
        r0.f27384c = 1;
        r12 = r5.update(r7, r8, r0);
        if (r12 != r2) goto L18;
        return r2;
    L7:
        r0 = new d(this, r11);
        goto L8
    }
}
