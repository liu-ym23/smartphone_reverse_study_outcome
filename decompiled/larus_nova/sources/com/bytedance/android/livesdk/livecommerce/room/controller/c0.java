package com.bytedance.android.livesdk.livecommerce.room.controller;

import android.content.Context;
import com.bytedance.android.ec.common.api.jump.model.LiveRoomParams;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.ControlRule;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes10.dex */
public class c0 implements com.bytedance.android.livesdk.livecommerce.room.api.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineScope f151685a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a0 f151686b;

    public void F() {
    }

    public void G() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public void a(com.bytedance.android.ec.adapter.api.state.a r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public void d(com.bytedance.android.livesdk.livecommerce.room.api.e r100) {
        Intrinsics.checkNotNullParameter(r100, "handler");
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void e(com.bytedance.android.livesdk.livecommerce.room.api.f r100) {
        Intrinsics.checkNotNullParameter(r100, "eventHub");
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public void g(com.bytedance.android.livesdk.livecommerce.room.api.d r100) {
        Intrinsics.checkNotNullParameter(r100, "messageHandler");
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public void i(com.bytedance.android.livesdk.livecommerce.room.api.c r100) {
        Intrinsics.checkNotNullParameter(r100, "functionHandler");
    }

    public void n() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public void onActivityCreated() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public void onContextAttached(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public void onCreate() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public void onDestroyView() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public void onEnterRoomPrepared() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onFirstFrame() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onP0WidgetLoadFinished() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public void onPause() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public void onResume() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public void onRoomVisible() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public void onSpecificViewAttached(String r100) {
        Intrinsics.checkNotNullParameter(r100, "viewClassName");
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public void onStart() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public void onStop() {
    }

    public final RealRoomController A() {
        return this.f151686b.m();
    }

    public final com.bytedance.android.ec.adapter.api.state.a C() {
        return this.f151686b.i();
    }

    public final String D() {
        return this.f151686b.a();
    }

    public final com.bytedance.android.livesdk.livecommerce.room.api.e E() {
        return this.f151686b.g();
    }

    public final LiveRoomParams l() {
        return this.f151686b.h();
    }

    public final Context m() {
        return this.f151686b.context();
    }

    public final ECContext o() {
        return this.f151686b.k();
    }

    public final com.bytedance.android.livesdk.livecommerce.room.api.c q() {
        return this.f151686b.e();
    }

    public final boolean u() {
        return this.f151686b.n();
    }

    public final boolean v() {
        return this.f151686b.isPreview();
    }

    public final boolean w() {
        return this.f151686b.j();
    }

    public final String B() {
        if (w() == true) goto L7;
        return "";
    L7:
        return C().f42691f;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public void onDestroy() {
        n();
        CoroutineScopeKt.cancel$default(this.f151685a, null, 1, null);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public void onExitRoom() {
        F();
        n();
        G();
    }

    public final Map<String, String> p() {
        return o().getEnterRoomParams().getValue();
    }

    public final ECContext r() {
        if (w() == true) goto L7;
        return null;
    L7:
        return o();
    }

    public final boolean s() {
        if (w() == true) goto L7;
        return false;
    L7:
        return C().f42688c;
    }

    public final boolean t() {
        if (w() == true) goto L7;
        return true;
    L7:
        return com.bytedance.android.livesdk.livecommerce.room.model.h.a(C());
    }

    public final boolean x() {
        return A().f151435z;
    }

    public final String y() {
        if (w() == true) goto L7;
        return "";
    L7:
        return C().f42692g;
    }

    public final String z() {
        if (w() == true) goto L7;
        return "";
    L7:
        return C().f42693h;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public void onWidgetLoadFinished() {
        F();
    }

    public c0(a0 r100) {
        Intrinsics.checkNotNullParameter(r100, "roomResources");
        this.f151686b = r100;
        this.f151685a = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain()));
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void j(com.bytedance.android.livesdk.livecommerce.room.api.h r100) {
        Intrinsics.checkNotNullParameter(r100, "eventHub");
        Intrinsics.checkNotNullParameter(r100, "eventHub");
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public void onSpecificWidgetLoadFinished(String r100) {
        Intrinsics.checkNotNullParameter(r100, "widgetClassName");
        Intrinsics.checkNotNullParameter(r100, "widgetClassName");
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public void c(Context r100, com.bytedance.android.ec.adapter.api.state.a r101) {
        F();
        G();
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public void onSpecificBehaviorUnload(String r100, boolean r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "behaviorClassName");
        Intrinsics.checkNotNullParameter(r100, "behaviorClassName");
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public void onSpecificBehaviorLoad(String r100, boolean r101, boolean r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "behaviorClassName");
        Intrinsics.checkNotNullParameter(r103, ControlRule.KEY_EXTRA_DATA);
        Intrinsics.checkNotNullParameter(r100, "behaviorClassName");
        Intrinsics.checkNotNullParameter(r103, ControlRule.KEY_EXTRA_DATA);
    }
}
