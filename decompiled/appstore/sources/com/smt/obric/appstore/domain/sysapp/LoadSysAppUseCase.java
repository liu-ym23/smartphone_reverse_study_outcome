package com.smt.obric.appstore.domain.sysapp;

import android.content.Context;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.j;
import com.smt.obric.appstore.domain.oapplet.GetAllOAppletUseCase;
import com.smt.obric.appstore.domain.oapplet.OAppletUtilKt;
import com.smt.obric.appstore.domain.sysapp.autoupdate.GetSysAppAutoUpdateWhitelistUseCase;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.t;
import kotlin.coroutines.Continuation;
import kotlin.enums.EnumEntries;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.d0;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.SharedFlow;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class LoadSysAppUseCase {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f18082h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f18083a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Filter f18084b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LoadLaunchableSysAppUseCase f18085c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LoadObricPreloadSysAppUseCase f18086d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final GetZTEDeletedSysApps f18087e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final GetAllOAppletUseCase f18088f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final GetSysAppAutoUpdateWhitelistUseCase f18089g;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/smt/obric/appstore/domain/sysapp/LoadSysAppUseCase$Filter;", "", "(Ljava/lang/String;I)V", "Full", "AutoUpdate", "SysAppRecovery", "appstorecommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final enum Filter extends Enum<Filter> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ Filter[] $VALUES = null;
        public static final Filter AutoUpdate = null;
        public static final Filter Full = null;
        public static final Filter SysAppRecovery = null;

        private static final /* synthetic */ Filter[] $values() {
            return new Filter[]{Full, AutoUpdate, SysAppRecovery};
        }

        static {
            Full = new Filter("Full", 0);
            AutoUpdate = new Filter("AutoUpdate", 1);
            SysAppRecovery = new Filter("SysAppRecovery", 2);
            Filter[] r10 = $values();
            $VALUES = r10;
            $ENTRIES = kotlin.enums.a.a(r10);
        }

        private Filter(String r10, int r11) {
            super(r10, r11);
        }

        @NotNull
        public static EnumEntries<Filter> getEntries() {
            return $ENTRIES;
        }

        public static Filter valueOf(String r10) {
            return (Filter) Enum.valueOf(Filter.class, r10);
        }

        public static Filter[] values() {
            return (Filter[]) $VALUES.clone();
        }
    }

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    static {
        f18082h = new a(null);
    }

    public LoadSysAppUseCase(Context r10, Filter r11) {
        q.g(r10, "context");
        q.g(r11, "filter");
        this.f18083a = r10;
        this.f18084b = r11;
        this.f18085c = new LoadLaunchableSysAppUseCase(r10);
        this.f18086d = new LoadObricPreloadSysAppUseCase(r10);
        this.f18087e = new GetZTEDeletedSysApps(r10);
        this.f18088f = new GetAllOAppletUseCase(r10);
        this.f18089g = new GetSysAppAutoUpdateWhitelistUseCase(r10);
    }

    public static final /* synthetic */ Filter a(LoadSysAppUseCase r10) {
        return r10.f18084b;
    }

    public static final /* synthetic */ GetSysAppAutoUpdateWhitelistUseCase b(LoadSysAppUseCase r10) {
        return r10.f18089g;
    }

    public static final /* synthetic */ LoadLaunchableSysAppUseCase c(LoadSysAppUseCase r10) {
        return r10.f18085c;
    }

    public static final /* synthetic */ GetAllOAppletUseCase d(LoadSysAppUseCase r10) {
        return r10.f18088f;
    }

    public static final /* synthetic */ LoadObricPreloadSysAppUseCase e(LoadSysAppUseCase r10) {
        return r10.f18086d;
    }

    public static final /* synthetic */ GetZTEDeletedSysApps f(LoadSysAppUseCase r10) {
        return r10.f18087e;
    }

    public static final /* synthetic */ Object g(LoadSysAppUseCase r10, Continuation r11) {
        return r10.m(r11);
    }

    public static final /* synthetic */ void h(LoadSysAppUseCase r10, String r11, List r12) {
        r10.n(r11, r12);
    }

    public static final /* synthetic */ String i(LoadSysAppUseCase r10, AppInfo r11) {
        return r10.o(r11);
    }

    public static final /* synthetic */ void j(LoadSysAppUseCase r10, Map r11, String r12, AppInfo r13) {
        r10.p(r11, r12, r13);
    }

    public static final /* synthetic */ boolean k(LoadSysAppUseCase r10, AppInfo r11) {
        return r10.q(r11);
    }

    public final Flow l() {
        Flow r10 = kotlinx.coroutines.flow.c.C(Unit.f21064a);
        final SharedFlow r11 = le.b.f21950a.a();
        Flow r12 = new LoadSysAppUseCase$invoke$$inlined$map$1(r11);
        final Flow r13 = OAppletUtilKt.a(this.f18083a, "LoadSysAppUseCase[" + hashCode() + ']');
        return kotlinx.coroutines.flow.c.H(kotlinx.coroutines.flow.c.J(new Flow[]{r10, r12, new LoadSysAppUseCase$invoke$$inlined$map$2(r13)}), new LoadSysAppUseCase$invoke$1(this, null));
    }

    public final Object m(Continuation r10) {
        if ((r10 instanceof LoadSysAppUseCase$loadOnce$1) == false) goto L7;
        LoadSysAppUseCase$loadOnce$1 r11 = (LoadSysAppUseCase$loadOnce$1) r10;
        int r12 = r11.label;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r11.label = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r11.result;
        Object r14 = kotlin.coroutines.intrinsics.a.d();
        int r15 = r11.label;
        if (r15 == 0) goto L19;
        if (r15 == 1) goto L18;
        if (r15 != 2) goto L17;
        kotlin.c.b(r13);     // Catch: Throwable -> L14
    L26:
        Object r16 = Result.m35constructorimpl((List) r13);     // Catch: Throwable -> L14
    L29:
        Throwable r17 = Result.m38exceptionOrNullimpl(r16);
        if (r17 != null) goto L32;
    L35:
        return r16;
    L32:
        if ((r17 instanceof CancellationException) == false) goto L35;
        throw r17;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        LoadSysAppUseCase this = (LoadSysAppUseCase) r11.L$0;
        kotlin.c.b(r13);
    L22:
        boolean r18 = ((Boolean) r13).booleanValue();
        Result.a r19 = Result.Companion;     // Catch: Throwable -> L14
        LoadSysAppUseCase$loadOnce$2$1 r20 = new LoadSysAppUseCase$loadOnce$2$1(this, r18, null);     // Catch: Throwable -> L14
        r11.L$0 = null;     // Catch: Throwable -> L14
        r11.label = 2;     // Catch: Throwable -> L14
        r13 = d0.e(r20, r11);     // Catch: Throwable -> L14
        if (r13 != r14) goto L26;
        return r14;
    L19:
        kotlin.c.b(r13);
        GmsUtil r21 = GmsUtil.f18070a;
        Context r22 = this.f18083a;
        r11.L$0 = this;
        r11.label = 1;
        r13 = r21.a(r22, r11);
        if (r13 != r14) goto L22;
        return r14;
    L14:
        th = move-exception;
        Result.a r23 = Result.Companion;
        r16 = Result.m35constructorimpl(kotlin.c.a(th));
    L7:
        r11 = new LoadSysAppUseCase$loadOnce$1(this, r10);
        goto L8
    }

    public final void n(String r10, List r11) {
        Iterator r12 = r11.iterator();
        int r13 = 0;
    L4:
        if (r12.hasNext() == false) goto L12;
        Object r14 = r12.next();
        int r15 = r13 + 1;
        if (r13 >= 0) goto L8;
        t.q();
    L8:
        AppInfo r16 = (AppInfo) r14;
        if (k(this, r16) == false) goto L11;
        j.n("[SysAppNameDebug][LoadSysAppUseCase] source=" + r10 + '[' + r13 + "] " + o(r16));
    L11:
        r13 = r15;
        goto L4
    }

    public final String o(AppInfo r10) {
        return "pkg=" + r10.appPackageName + " name=" + r10.appName + " version=" + r10.appVersionCode + '/' + r10.appVersionName + " state=" + r10.appState + " appSource=" + r10.appSource + " icon=" + r10.appIcon + " preloadPath=" + r10.obricPreloadApkFilePath;
    }

    public final void p(Map r10, String r11, AppInfo r12) {
        AppInfo r13 = (AppInfo) r10.put(r12.appPackageName, r12);
        boolean r14 = true;
        if (q(r12) == true) goto L7;
        if (r13 != null) goto L6;
        return;
    L6:
        if (q(r13) == true) goto L7;
        return;
    L7:
        StringBuilder r15 = new StringBuilder();
        r15.append("[SysAppNameDebug][LoadSysAppUseCase] merge source=");
        r15.append(r11);
        r15.append(" replaced=");
        if (r13 != null) goto L11;
        r14 = false;
    L11:
        r15.append(r14);
        r15.append(" new=");
        r15.append(o(r12));
        r15.append(" previous=");
        if (r13 == null) goto L14;
        String r16 = o(r13);
    L15:
        r15.append(r16);
        j.n(r15.toString());
        return;
    L14:
        r16 = null;
        goto L15
    }

    public final boolean q(AppInfo r10) {
        return q.b(r10.appPackageName, "com.obric.recorder");
    }

    public /* synthetic */ LoadSysAppUseCase(Context r10, Filter r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = Filter.Full;
    L5:
        this(r10, r11);
    }
}
