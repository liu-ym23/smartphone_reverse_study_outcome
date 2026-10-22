package com.bytedance.android.livesdk.livecommerce.room.controller;

import android.content.Context;
import com.bytedance.android.livesdk.livecommerce.room.LiveRoomProvider;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.ControlRule;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class x implements com.bytedance.android.livesdk.livecommerce.room.api.b {
    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void c(Context r100, com.bytedance.android.ec.adapter.api.state.a r101) {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void d(com.bytedance.android.livesdk.livecommerce.room.api.e r100) {
        Intrinsics.checkNotNullParameter(r100, "handler");
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void g(com.bytedance.android.livesdk.livecommerce.room.api.d r100) {
        Intrinsics.checkNotNullParameter(r100, "messageHandler");
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onActivityCreated() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onContextAttached(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onCreate() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onDestroy() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onDestroyView() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onEnterRoomPrepared() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onExitRoom() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onFirstFrame() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onP0WidgetLoadFinished() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onPause() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onResume() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onRoomVisible() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onStart() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onStop() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onWidgetLoadFinished() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void a(com.bytedance.android.ec.adapter.api.state.a r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void e(com.bytedance.android.livesdk.livecommerce.room.api.f r100) {
        Intrinsics.checkNotNullParameter(r100, "eventHub");
        Intrinsics.checkNotNullParameter(r100, "eventHub");
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void i(com.bytedance.android.livesdk.livecommerce.room.api.c r100) {
        Intrinsics.checkNotNullParameter(r100, "functionHandler");
        Intrinsics.checkNotNullParameter(r100, "functionHandler");
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void j(com.bytedance.android.livesdk.livecommerce.room.api.h r100) {
        Intrinsics.checkNotNullParameter(r100, "eventHub");
        Intrinsics.checkNotNullParameter(r100, "eventHub");
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onSpecificViewAttached(String r100) {
        Intrinsics.checkNotNullParameter(r100, "viewClassName");
        Intrinsics.checkNotNullParameter(r100, "viewClassName");
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onSpecificWidgetLoadFinished(String r100) {
        Intrinsics.checkNotNullParameter(r100, "widgetClassName");
        Intrinsics.checkNotNullParameter(r100, "widgetClassName");
    }

    public x(String r100, String r101, LiveRoomProvider.ECProviderSource r102) {
        Intrinsics.checkNotNullParameter(r100, "roomId");
        Intrinsics.checkNotNullParameter(r101, "uniqueKey");
        Intrinsics.checkNotNullParameter(r102, "env");
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onSpecificBehaviorUnload(String r100, boolean r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "behaviorClassName");
        Intrinsics.checkNotNullParameter(r100, "behaviorClassName");
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onSpecificBehaviorLoad(String r100, boolean r101, boolean r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "behaviorClassName");
        Intrinsics.checkNotNullParameter(r103, ControlRule.KEY_EXTRA_DATA);
        Intrinsics.checkNotNullParameter(r100, "behaviorClassName");
        Intrinsics.checkNotNullParameter(r103, ControlRule.KEY_EXTRA_DATA);
    }
}
