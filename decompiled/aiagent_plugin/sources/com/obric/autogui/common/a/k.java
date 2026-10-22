package com.obric.autogui.common.a;

import android.content.Context;
import android.graphics.Bitmap;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: VlmAgentConfig.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private g f28989a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private g f28990b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private g f28991c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private a f28992d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private a f28993e;
    private g f;
    private g g;
    private g h;
    private g i;
    private g j;
    private g k;
    private g l;
    private g m;
    private a n;
    private j o;
    private a p;
    private Bitmap.CompressFormat q;
    private float r;
    private int s;
    private long t;

    public k() {
        this.f28989a = new g("vlm_thinking_timeout", ZeusTransformUtils.mapRes(R.integer.config_vlm_thingking_timeout_millis, WsChannelMultiProcessSharedProvider.INT_TYPE, "config_vlm_thingking_timeout_millis"), 0, 4, null);
        this.f28990b = new g("vlm_max_pred_steps", ZeusTransformUtils.mapRes(R.integer.config_vlm_thingking_maximum_steps, WsChannelMultiProcessSharedProvider.INT_TYPE, "config_vlm_thingking_maximum_steps"), 0, 4, null);
        this.f28991c = new g("vlm_wait_time_each_step", ZeusTransformUtils.mapRes(R.integer.config_vlm_fixed_waiting_time, WsChannelMultiProcessSharedProvider.INT_TYPE, "config_vlm_fixed_waiting_time"), 0, 4, null);
        this.f28992d = new a("vlm_loading_judge_enabled", ZeusTransformUtils.mapRes(R.bool.config_vlm_loading_judge_enabled, "bool", "config_vlm_loading_judge_enabled"), false, 4, null);
        this.f28993e = new a("vlm_enable_max_page_not_change_detect", ZeusTransformUtils.mapRes(R.bool.config_enable_vlm_max_page_not_change_detect, "bool", "config_enable_vlm_max_page_not_change_detect"), false, 4, null);
        this.f = new g("vlm_max_page_not_changed_count", ZeusTransformUtils.mapRes(R.integer.config_vlm_max_page_not_changed_steps, WsChannelMultiProcessSharedProvider.INT_TYPE, "config_vlm_max_page_not_changed_steps"), 0, 4, null);
        this.g = new g("vlm_max_retry_count", ZeusTransformUtils.mapRes(R.integer.config_vlm_thingking_maximum_retry, WsChannelMultiProcessSharedProvider.INT_TYPE, "config_vlm_thingking_maximum_retry"), 0, 4, null);
        this.h = new g("vlm_model_type", ZeusTransformUtils.mapRes(R.integer.config_vlm_type, WsChannelMultiProcessSharedProvider.INT_TYPE, "config_vlm_type"), 0, 4, null);
        this.i = new g("vlm_task_max_execution_time", ZeusTransformUtils.mapRes(R.integer.config_vlm_task_max_execution_time, WsChannelMultiProcessSharedProvider.INT_TYPE, "config_vlm_task_max_execution_time"), 0, 4, null);
        this.j = new g("vlm_task_max_queue_time", ZeusTransformUtils.mapRes(R.integer.config_vlm_task_max_queue_time, WsChannelMultiProcessSharedProvider.INT_TYPE, "config_vlm_task_max_queue_time"), 0, 4, null);
        this.k = new g("vlm_environment_type", ZeusTransformUtils.mapRes(R.integer.config_environment_type, WsChannelMultiProcessSharedProvider.INT_TYPE, "config_environment_type"), 0, 4, null);
        this.l = new g("vlm_max_tolerable_thermal_state", ZeusTransformUtils.mapRes(R.integer.config_vlm_max_tolerable_thermal_level, WsChannelMultiProcessSharedProvider.INT_TYPE, "config_vlm_max_tolerable_thermal_level"), 0, 4, null);
        this.m = new g("vlm_max_time_millis_in_max_tolerable_thermal_level", ZeusTransformUtils.mapRes(R.integer.config_vlm_max_time_millis_in_max_tolerable_thermal_level, WsChannelMultiProcessSharedProvider.INT_TYPE, "config_vlm_max_time_millis_in_max_tolerable_thermal_level"), 0, 4, null);
        this.n = new a("vlm_using_streaming_reply", ZeusTransformUtils.mapRes(R.bool.config_vlm_using_streaming_reply, "bool", "config_vlm_using_streaming_reply"), false, 4, null);
        this.o = new j("vlm_ppe_env", ZeusTransformUtils.mapRes(R.string.config_vlm_ppe_env, WsChannelMultiProcessSharedProvider.STRING_TYPE, "config_vlm_ppe_env"), null, 4, null);
        this.p = new a("vlm_using_memory_search", ZeusTransformUtils.mapRes(R.bool.config_vlm_using_memory_search, "bool", "config_vlm_using_memory_search"), false, 4, null);
        this.q = Bitmap.CompressFormat.JPEG;
        this.r = 0.5f;
        this.s = 95;
        this.t = 2000;
    }

    public final g a() {
        return this.f28989a;
    }

    public final g b() {
        return this.f28991c;
    }

    public final a c() {
        return this.f28992d;
    }

    public final g d() {
        return this.g;
    }

    public final g e() {
        return this.h;
    }

    public final g f() {
        return this.i;
    }

    public final g g() {
        return this.j;
    }

    public final g h() {
        return this.k;
    }

    public final g i() {
        return this.l;
    }

    public final g j() {
        return this.m;
    }

    public final a k() {
        return this.n;
    }

    public final j l() {
        return this.o;
    }

    public final a m() {
        return this.p;
    }

    public final float n() {
        return this.r;
    }

    public final long o() {
        return this.t;
    }

    public final void a(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "context");
        this.f28989a.b(r4);
        this.f28990b.b(r4);
        this.f28991c.b(r4);
        this.f28992d.b(r4);
        this.f.b(r4);
        this.g.b(r4);
        this.h.b(r4);
        this.i.b(r4);
        this.j.b(r4);
        this.k.b(r4);
        this.l.b(r4);
        this.m.b(r4);
        this.n.b(r4);
        this.o.b(r4);
        this.p.b(r4);
    }
}
