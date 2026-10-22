package com.bytedance.android.livesdk.livecommerce.room.controller;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.ControlRule;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public class a implements com.bytedance.android.livesdk.livecommerce.room.api.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.android.livesdk.livecommerce.room.api.e f151446a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f151447b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.bytedance.android.ec.adapter.api.state.a f151448c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.bytedance.android.livesdk.livecommerce.room.api.c f151449d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.bytedance.android.livesdk.livecommerce.room.api.f f151450e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.bytedance.android.livesdk.livecommerce.room.api.h f151451f;

    public a() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public void g(com.bytedance.android.livesdk.livecommerce.room.api.d r100) {
        Intrinsics.checkNotNullParameter(r100, "messageHandler");
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public void onActivityCreated() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public void onCreate() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public void onDestroy() {
        this.f151450e = null;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public void onDestroyView() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public void onEnterRoomPrepared() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public void onExitRoom() {
        this.f151450e = null;
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
    public void onStart() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public void onStop() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public void onWidgetLoadFinished() {
    }

    public final com.bytedance.android.ec.adapter.api.state.a b() {
        com.bytedance.android.ec.adapter.api.state.a r100 = this.f151448c;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("currentRoomState");
    L5:
        return r100;
    }

    public final Context getContext() {
        Context r100 = this.f151447b;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException(PerfLog.PARAM_KEY_CONTEXT_ID);
    L5:
        return r100;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public void a(com.bytedance.android.ec.adapter.api.state.a r100) {
        Intrinsics.checkNotNullParameter(r100, "stateEC");
        this.f151448c = r100;
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public void d(com.bytedance.android.livesdk.livecommerce.room.api.e r100) {
        Intrinsics.checkNotNullParameter(r100, "handler");
        this.f151446a = r100;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public void e(com.bytedance.android.livesdk.livecommerce.room.api.f r100) {
        Intrinsics.checkNotNullParameter(r100, "eventHub");
        this.f151450e = r100;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public void i(com.bytedance.android.livesdk.livecommerce.room.api.c r100) {
        Intrinsics.checkNotNullParameter(r100, "functionHandler");
        this.f151449d = r100;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public void j(com.bytedance.android.livesdk.livecommerce.room.api.h r100) {
        Intrinsics.checkNotNullParameter(r100, "eventHub");
        this.f151451f = r100;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public void onContextAttached(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f151447b = r100;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public void onSpecificViewAttached(String r100) {
        Intrinsics.checkNotNullParameter(r100, "viewClassName");
        Intrinsics.checkNotNullParameter(r100, "viewClassName");
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public void onSpecificWidgetLoadFinished(String r100) {
        Intrinsics.checkNotNullParameter(r100, "widgetClassName");
        Intrinsics.checkNotNullParameter(r100, "widgetClassName");
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public void c(Context r100, com.bytedance.android.ec.adapter.api.state.a r101) {
        if (r101 == null) goto L5;
        this.f151448c = r101;
        return;
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
