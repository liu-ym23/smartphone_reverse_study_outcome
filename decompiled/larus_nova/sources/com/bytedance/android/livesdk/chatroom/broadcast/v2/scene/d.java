package com.bytedance.android.livesdk.chatroom.broadcast.v2.scene;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.broadcast.api.scope.global.IBroadcastInitService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.ui.BaseFragment;
import com.bytedance.android.livesdk.chatroom.broadcast.v2.path.ShellPageCorePathWayManager;
import com.bytedance.android.livesdk.config.ai;
import com.bytedance.android.livesdk.config.fh;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.nova.R;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes7.dex */
public class d extends com.bytedance.android.live.broadcast.api.scope.service.a implements hs1.e, WeakHandler.IHandler {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f105444o = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f105445b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f105446c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f105447d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c f105448e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f105449f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f105450g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final WeakHandler f105451h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final dg1.a f105452i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ShellPageCorePathWayManager f105453j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final com.bytedance.android.livesdk.sharedpref.e<String> f105454k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f105455l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final BaseFragment f105456m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final hs1.d f105457n;

    public static final class a {
    }

    static {
    }

    @Override // hs1.e
    public final void b(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        this.f105457n.b(r100, r101);
    }

    public final void d(hs1.e r100) {
        Intrinsics.checkNotNullParameter(r100, "d");
        this.f105457n.a(r100);
    }

    public final i00.c g() {
        return (i00.c) this.f105449f.getValue();
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public final void handleMsg(Message r100) {
    }

    public final i00.a i() {
        return (i00.a) this.f105450g.getValue();
    }

    @Override // hs1.e
    public final void onCreate() {
        this.f105457n.onCreate();
    }

    @Override // hs1.e
    public final void onPause() {
        this.f105457n.onPause();
    }

    @Override // hs1.e
    public final void onResume() {
        this.f105457n.onResume();
    }

    @Override // hs1.e
    public final void onStart() {
        this.f105457n.onStart();
    }

    @Override // hs1.e
    public final void onStop() {
        this.f105457n.onStop();
    }

    @Override // com.bytedance.android.live.broadcast.api.scope.service.a, hs1.f
    public Context getContext() {
        return this.f105456m.getContext();
    }

    public final c h() {
        c r100 = this.f105448e;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type T");
    }

    @Override // hs1.e
    public final void onDestroy() {
        if (this.f105446c == false) goto L6;
        i().stop("Shell");
        g().stop();
        ALogger.i("NewLiveBroadcastFunctionBridge", "has Destroy. when all in one mode.");
        return;
    L6:
        this.f105451h.removeCallbacksAndMessages(null);
        this.f105457n.onDestroy();
        if (this.f105448e.f105428a == true) goto L9;
    L12:
        i().stop("ShellDirect");
        g().stop();
        return;
    L9:
        if (this.f105447d == false) goto L11;
        return;
    L11:
        if (fh.f120202a.getValue().booleanValue() == true) goto L12;
    }

    public d(BaseFragment r100) {
        hs1.d r101 = new hs1.d();
        Intrinsics.checkNotNullParameter(r100, "hostFragment");
        Intrinsics.checkNotNullParameter(r101, "fragmentSceneDelegate");
        this.f105456m = r100;
        this.f105457n = r101;
        IBroadcastInitService r102 = (IBroadcastInitService) k.f(IBroadcastInitService.class);
        if (r102 == null) goto L5;
        r102.start("ShellScene");
    L5:
        this.f105448e = new c(0);
        new hs1.a();
        this.f105449f = LazyKt.lazy(new BroadcastShellScene$broadcastInstance$2(this));
        this.f105450g = LazyKt.lazy(new BroadcastShellScene$shellInLiveInstance$2(this));
        this.f105451h = new WeakHandler(this);
        dg1.a r103 = new dg1.a(this);
        d(r103);
        this.f105452i = r103;
        ShellPageCorePathWayManager r104 = new ShellPageCorePathWayManager(this);
        r101.a(r104);
        this.f105453j = r104;
        this.f105454k = new com.bytedance.android.livesdk.sharedpref.e("live_preview_stream_info", "");
        this.f105455l = LazyKt.lazy(new BroadcastShellScene$dataCenter$2(this));
    }

    @Override // hs1.e
    public final void c(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        g().start();
        c r101 = this.f105448e;
        r101.f105443p = System.currentTimeMillis();
        y50.c.f566208d.b("inter_load_total");
        this.f105457n.c(r100);
        dg1.a r102 = this.f105452i;
        DataCenter r103 = (DataCenter) this.f105455l.getValue();
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "dataCenter");
        r102.f468367a = r103;
        i().setDataCenter((DataCenter) this.f105455l.getValue());
    }

    public final <T extends View> T e(int r100) {
        hs1.d r101 = this.f105457n;
        if (r101.f486949c != null) goto L5;
        r101.f486949c = new LinkedHashMap();
    L5:
        View r102 = (View) ((LinkedHashMap) r101.f486949c).get(Integer.valueOf(r100));
        if (r102 != null) goto L14;
        View r103 = r101.f486948b;
        if (r103 == null) goto L12;
        r102 = r103.findViewById(r100);
        if (r102 == null) goto L12;
        r101.f486949c.put(Integer.valueOf(r100), r102);
    L12:
        r102 = null;
    L14:
        if ((r102 instanceof View) == true) goto L17;
        return null;
    L17:
        return (T) r102;
    }

    public final void f(Map<String, String> r100) {
        if (this.f105448e.f105428a == false) goto L11;
        f00.f r101 = (f00.f) i().a(Reflection.getOrCreateKotlinClass(f00.f.class));
        if (r101 == null) goto L7;
        Room r102 = r101.getRoom();
    L8:
        if (r102 != null) goto L11;
        ALogger.i("LiveBroadcastFunctionBridge", "onDestroy before finish. when all in one mode.");
        this.f105447d = true;
        onDestroy();
        this.f105446c = true;
        goto L11
    L7:
        r102 = null;
    L11:
        if (ai.f119791a.getValue().booleanValue() == true) goto L13;
    L25:
        BaseFragment r103 = this.f105456m;
        if (r103 == null) goto L31;
        FragmentActivity r104 = r103.getActivity();
        if (r104 == null) goto L31;
        r104.finish();
    L31:
        if (ai.f119791a.getValue().booleanValue() == true) goto L33;
        return;
    L33:
        if (this.f105448e.f105429b == false) goto L42;
        BaseFragment r105 = this.f105456m;
        if (r105 == null) goto L43;
        FragmentActivity r106 = r105.getActivity();
        if (r106 == null) goto L44;
        r106.overridePendingTransition(0, R.anim.ttlive_fade_out_150ms);
        return;
    L44:
        return;
    L43:
        return;
    L42:
        return;
    L13:
        if (this.f105448e.f105429b == false) goto L25;
        Intent r107 = new Intent();
        if (r100 == null) goto L20;
        Iterator<Map.Entry<String, String>> r108 = r100.entrySet().iterator();
    L18:
        if (r108.hasNext() == false) goto L20;
        Map.Entry<String, String> r109 = r108.next();
        r107.putExtra(r109.getKey(), r109.getValue());
    L20:
        BaseFragment r110 = this.f105456m;
        if (r110 == null) goto L25;
        FragmentActivity r111 = r110.getActivity();
        if (r111 == null) goto L25;
        r111.setResult(-1, r107);
        goto L25
    }
}
