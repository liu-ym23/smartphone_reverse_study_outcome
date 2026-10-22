package com.bytedance.android.live.broadcastgame.opengame.panel;

import am2.x;
import android.content.SharedPreferences;
import com.bytedance.android.live.broadcastgame.opengame.runtime.PluginContext;
import com.bytedance.android.live.broadcastgame.opengame.utils.m;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.livesdk.config.re0;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.utils.v5;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes45.dex */
public final class ShowTipsHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f60660a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f60661b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f60662c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public k f60663d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f60664e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f60665f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public l f60666g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final PluginContext f60667h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Function0<Boolean> f60668i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Function0<Unit> f60669j;

    public final void a() {
        MainThreadPostUtils.d(this.f60663d);
        PluginContext r100 = this.f60667h;
        if (r100 == null) goto L7;
        DataCenter r101 = r100.f60805i;
        if (r101 == null) goto L7;
        r101.removeObserver(this.f60666g);
    L7:
        this.f60665f = false;
    }

    public final void b() {
        int r100 = m.f61175a;
        if (re0.f121126a.getValue().booleanValue() == false) goto L47;
        PluginContext r101 = this.f60667h;
        if (r101 != null) goto L9;
        return;
    L9:
        if (this.f60665f == false) goto L12;
        return;
    L12:
        if (r101.f60811o == false) goto L14;
        return;
    L14:
        if (r101.f60809m.f61077c == false) goto L17;
        return;
    L17:
        if (v5.b().getBoolean("live.key.AUDIENCE_HAS_COLLECTED_V2", false) == true) goto L51;
        int r102 = v5.b().getInt("live.key.SHOW_START_GAME_TIP_COUNT", 0);
        if (r102 < 10) goto L23;
        return;
    L23:
        if (r101.f60809m.f61079e == false) goto L53;
        Ref.ObjectRef r103 = new Ref.ObjectRef();
        r103.element = "default";
        this.f60665f = true;
        String r104 = r101.f60809m.f61083i;
        this.f60663d = new k(this, r103, r104, r102);
        this.f60666g = new l(this, r104, r103);
        if (((SharedPreferences) this.f60660a.getValue()).contains(r104) == false) goto L28;
        r103.element = "launch_again";
        long r105 = 3000;
    L41:
        DataCenter r106 = r101.f60805i;
        if (r106 == null) goto L44;
        r106.observe("key_live_game_pay_success", this.f60666g, false);
    L44:
        MainThreadPostUtils.c(this.f60663d, r105);
        ((SharedPreferences) this.f60660a.getValue()).edit().putBoolean(r104, true).apply();
        return;
    L28:
        o r107 = u.l().c(x.class);
        if (r107 == null) goto L37;
        Map<String, String> r108 = r107.getMap();
        if (r108 == null) goto L37;
        String r109 = r108.get("enter_from_merge");
        if (r109 == null) goto L37;
        if (StringsKt.contains$default(r109, "search", false, 2, null) != true) goto L37;
        boolean r110 = true;
    L38:
        if (r110 == false) goto L40;
        r103.element = "enter_from_search";
        r105 = 5000;
        goto L41
    L40:
        r103.element = "exceed_avg_duration";
        r105 = 85000;
    L37:
        r110 = false;
        goto L38
    L53:
        return;
    L51:
        return;
    }

    public ShowTipsHelper(PluginContext r100, Function0<Boolean> r101, Function0<Unit> r102) {
        Intrinsics.checkNotNullParameter(r101, "isPanelShow");
        Intrinsics.checkNotNullParameter(r102, "showTipsHandler");
        this.f60667h = r100;
        this.f60668i = r101;
        this.f60669j = r102;
        this.f60660a = LazyKt.lazy(ShowTipsHelper$gameStartSP$2.INSTANCE);
        this.f60661b = LazyKt.lazy(ShowTipsHelper$gamePaySP$2.INSTANCE);
        this.f60662c = LazyKt.lazy(ShowTipsHelper$gameHasShowSP$2.INSTANCE);
    }
}
