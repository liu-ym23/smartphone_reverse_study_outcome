package com.bytedance.android.live.broadcastgame.opengame.dialog;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.live.broadcastgame.api.openplatform.PluginType;
import com.bytedance.android.live.broadcastgame.opengame.network.GameReportApi;
import com.bytedance.android.live.broadcastgame.opengame.network.LiveOpenGameClient;
import com.bytedance.android.live.broadcastgame.opengame.network.q;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.google.gson.annotations.SerializedName;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import v19.f;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/dialog/OpenGameReportDialog;", "Landroidx/fragment/app/FragmentActivity;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "InnerPageParams", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OpenGameReportDialog extends FragmentActivity {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f60029m = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<Integer, View> f60030a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f60031b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Disposable f60032c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f60033d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f60034e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f60035f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f60036g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f60037h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f60038i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f60039j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f60040k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Function1<? super Integer, Unit> f60041l;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0016B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0004\u001a\u00020\u0002HÆ\u0003J\u001d\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0002HÆ\u0001J\t\u0010\b\u001a\u00020\u0002HÖ\u0001J\t\u0010\n\u001a\u00020\tHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0003R\u001a\u0010\u0005\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u000f\u001a\u0004\b\u0012\u0010\u0011¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/dialog/OpenGameReportDialog$InnerPageParams;", "Ljava/io/Serializable;", "", "component1", "component2", "path", "query", "copy", "toString", "", "hashCode", "", "other", "", "equals", "Ljava/lang/String;", "getPath", "()Ljava/lang/String;", "getQuery", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class InnerPageParams implements Serializable {
        public static final a Companion = null;
        public static final long serialVersionUID = 1;

        @SerializedName("path")
        private final String path;

        @SerializedName("query")
        private final String query;

        public static final class a {
            public a() {
            }
        }

        static {
            Companion = new a();
        }

        public static /* synthetic */ InnerPageParams copy$default(InnerPageParams r100, String r101, String r102, int r103, Object r104) {
            if ((r103 & 1) == 0) goto L6;
            r101 = r100.path;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = r100.query;
        L9:
            return r100.copy(r101, r102);
        }

        public final String component1() {
            return this.path;
        }

        public final String component2() {
            return this.query;
        }

        public final InnerPageParams copy(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "path");
            Intrinsics.checkNotNullParameter(r101, "query");
            return new InnerPageParams(r100, r101);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof InnerPageParams) == false) goto L10;
            InnerPageParams r101 = (InnerPageParams) r100;
            if (Intrinsics.areEqual(this.path, r101.path) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.query, r101.query) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public int hashCode() {
            String r100 = this.path;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            String r104 = this.query;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return r103 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        public String toString() {
            return "InnerPageParams(path=" + this.path + ", query=" + this.query + ")";
        }

        public final String getPath() {
            return this.path;
        }

        public final String getQuery() {
            return this.query;
        }

        public InnerPageParams(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "path");
            Intrinsics.checkNotNullParameter(r101, "query");
            this.path = r100;
            this.query = r101;
        }
    }

    public static final class a {
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f60045a = null;

        static {
            f60045a = new b();
        }

        public b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OpenGameReportDialog f60046a;

        public c(OpenGameReportDialog r100) {
            this.f60046a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            final List<q.a> r101 = ((q) ((Response) r100).data).a();
            if (r101 == null) goto L6;
            UtilityKotlinExtentionsKt.s(0, false, false, new OpenGameReportDialog$requestData$1$$special$$inlined$let$lambda$1(r101, this), 7);
            return;
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f60047a = null;

        static {
            f60047a = new d();
        }

        public d() {
        }

        @Override // io.reactivex.functions.Consumer
        public final /* bridge */ /* synthetic */ void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
        }
    }

    static {
    }

    /* JADX INFO: Removed unreachable split cross block B:51:0x0104 */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r100 = FLogger.f375446a;
        r100.i("ActivityLancet", "finish ".concat(OpenGameReportDialog.class.getName()));
        long r101 = SystemClock.uptimeMillis();
        Map<Activity, Long> r102 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r102);
        Long r103 = r102.get(this);     // Catch: Throwable -> L45
        if (r103 != null) goto L10;
    L13:
        r102.put(this, Long.valueOf(r101));     // Catch: Throwable -> L45
        monitor-exit(r102);     // Catch: Throwable -> L45
    L42:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L48:
        return;
    L16:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L19;
        r100.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L42
        goto L48
    L19:
        if (isFinishing() == true) goto L22;
        r100.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L42
        goto L48
    L22:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L25;
        r100.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L42
        goto L48
    L25:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L28;
        r100.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L42
        goto L48
    L28:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L31;
        r100.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L42
        goto L48
    L31:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L33;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L42
        goto L48
    L33:
        Intent r104 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L42
        if (r104 == null) goto L48;
        r104.addFlags(268435456);     // Catch: Throwable -> L42
        r104.addFlags(2097152);     // Catch: Throwable -> L42
        r100.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L42
        startActivity(r104);     // Catch: Throwable -> L39
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L42
        goto L48
    L10:
        if ((r101 - r103.longValue()) >= 800) goto L13;
        monitor-exit(r102);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        throw th;
    }

    public final void y1() {
        Lazy r100 = LiveOpenGameClient.f60290d;
        GameReportApi r101 = (GameReportApi) LiveOpenGameClient.a.a().a(GameReportApi.class);
        if (((Number) this.f60039j.getValue()).intValue() != PluginType.MINI_APP.getValue()) goto L5;
        String r102 = BdpAppEventConstant.MICRO_APP;
    L6:
        this.f60032c = r101.getReportReasonList(r102, ((Number) this.f60035f.getValue()).longValue()).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new c(this), d.f60047a);
        return;
    L5:
        r102 = "mini_app";
        goto L6
    }

    public OpenGameReportDialog() {
        this.f60030a = new LinkedHashMap();
        this.f60033d = true;
        this.f60034e = LazyKt.lazy(new OpenGameReportDialog$develop$2(this));
        this.f60035f = LazyKt.lazy(new OpenGameReportDialog$roomId$2(this));
        this.f60036g = LazyKt.lazy(new OpenGameReportDialog$isAnchor$2(this));
        this.f60037h = LazyKt.lazy(new OpenGameReportDialog$appId$2(this));
        this.f60038i = LazyKt.lazy(new OpenGameReportDialog$appName$2(this));
        this.f60039j = LazyKt.lazy(new OpenGameReportDialog$pluginType$2(this));
        this.f60040k = LazyKt.lazy(new OpenGameReportDialog$miniAppPagerParams$2(this));
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        Function1<? super Integer, Unit> r100 = this.f60041l;
        if (r100 == null) goto L5;
        Unit r101 = r100.invoke(Integer.valueOf(this.f60031b));
    L5:
        this.f60041l = null;
        Disposable r102 = this.f60032c;
        if (r102 == null) goto L9;
        r102.dispose();
        return;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        this.f60031b = 0;
        if (this.f60033d == true) goto L5;
        y1();
    L5:
        this.f60033d = false;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStop() {
        super.onStop();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L14;
        View r100 = getWindow().getDecorView();     // Catch: Throwable -> L11
        if (com.larus.home.impl.utils.c.f346345e == false) goto L9;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");     // Catch: Throwable -> L11
        Thread r101 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L11
        if (r101 == com.larus.home.impl.utils.c.f346341a) goto L9;
        com.larus.home.impl.utils.c.a(r101, "getDecorView");     // Catch: Throwable -> L11
    L9:
        r100.getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L11
        return;
    L15:
        return;
    }

    public final View _$_findCachedViewById(int r100) {
        if (this.f60030a != null) goto L5;
        this.f60030a = new LinkedHashMap();
    L5:
        View r101 = this.f60030a.get(Integer.valueOf(r100));
        if (r101 != null) goto L12;
        View r102 = findViewById(r100);
        if (r102 == null) goto L10;
        this.f60030a.put(Integer.valueOf(r100), r102);
        return r102;
    L10:
        return null;
    L12:
        return r101;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle r100) {
        if (z2.f365865a.enableGlobalActivityTheme() == false) goto L6;
        f.a(getTheme());     // Catch: Throwable -> L17
    L6:
        if (f.f(this) == false) goto L8;
        f.c(getTheme());     // Catch: Throwable -> L17
    L8:
        super.onCreate(r100);
        setContentView(com.larus.nova.R.layout.opengame_dialog_report);
        getWindow().setGravity(80);
        getWindow().setLayout(-1, -2);
        overridePendingTransition(com.larus.nova.R.anim.slide_in_bottom, com.larus.nova.R.anim.slide_out_bottom);
        int r101 = 0;
        if ((!StringsKt.isBlank((String) this.f60034e.getValue())) == false) goto L11;
        ((TextView) _$_findCachedViewById(com.larus.nova.R.id.tv_desc)).setText(s1.C(com.larus.nova.R.string.ttlive_report_function_des, new Object[]{(String) this.f60034e.getValue()}));
    L11:
        View r102 = _$_findCachedViewById(com.larus.nova.R.id.tv_desc);
        Boolean r103 = Boolean.valueOf(true ^ StringsKt.isBlank((String) this.f60034e.getValue()));
        Intrinsics.checkNotNullParameter(r102, "$this$setVisible");
        if (Intrinsics.areEqual(r103, Boolean.TRUE) == true) goto L15;
        r101 = 8;
    L15:
        r102.setVisibility(r101);
        y1();
        ((ScrollView) _$_findCachedViewById(com.larus.nova.R.id.root_bg)).setOnClickListener(b.f60045a);
    }
}
