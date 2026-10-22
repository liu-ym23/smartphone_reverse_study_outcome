package com.obric.autoaction.vdplayer.legacy.components;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.lifecycle.p;
import com.obric.autoaction.a.e;
import com.obric.autoaction.a.f;
import com.obric.autoaction.vdplayer.VDPlayerActivity;
import com.obric.autoaction.vdplayer.legacy.d.r;
import com.obric.autoaction.vdplayer.legacy.d.s;
import com.obric.autoaction.vdplayer.legacy.d.u;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.presentation.AutoActionUIContext;
import com.obric.autogui.common.api.presentation.GlobalUIContext;
import com.obric.autogui.common.api.presentation.IAutoActionPresentationApi;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import kotlinx.coroutines.b.ak;
import kotlinx.coroutines.b.x;

/* JADX INFO: compiled from: CommonLogicComponent.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class CommonLogicComponent implements e, f {
    private static final String TAG = "VDPlayer";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f25704a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.obric.autoaction.a.c f25705b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private u f25706c;

    /* JADX INFO: compiled from: CommonLogicComponent.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        f25704a = new a(null);
    }

    public CommonLogicComponent() {
    }

    @Override // com.obric.autoaction.a.f
    public void a(com.obric.autoaction.a.c r3) {
        o.e(r3, "componentHost");
        this.f25705b = r3;
        this.f25706c = (u) ZeusTransformUtils.preCheckCast(r3.c().a(u.class), u.class, "com.obric.aiagent.plugin");
    }

    @Override // androidx.lifecycle.d
    public void a(p r4) {
        p r5 = (p) ZeusTransformUtils.wrapperContextForParams(r4, p.class, "com.obric.aiagent.plugin");
        o.e(r5, "owner");
        super.a(r5);
        Loog.INSTANCE.d(TAG, "onCreate");
        com.obric.autoaction.a.c r6 = this.f25705b;
        String r0 = null;
        if (r6 == null) goto L5;
        Context r7 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
    L7:
        if (ZeusTransformUtils.instanceOf(r7, Activity.class) == false) goto L9;
        Activity r8 = (Activity) ZeusTransformUtils.preCheckCast(r7, Activity.class, "com.obric.aiagent.plugin");
    L10:
        u r3 = this.f25706c;
        if (r3 == null) goto L18;
        if (r8 == null) goto L16;
        Intent r9 = r8.getIntent();
        if (r9 == null) goto L16;
        r0 = r9.getStringExtra("o_omni_instruction_type");
    L16:
        r3.a(r0);
        return;
    L18:
        return;
    L9:
        r8 = null;
        goto L10
    L5:
        r7 = null;
        goto L7
    }

    @Override // androidx.lifecycle.d
    public void b(p r10) {
        p r11 = (p) ZeusTransformUtils.wrapperContextForParams(r10, p.class, "com.obric.aiagent.plugin");
        o.e(r11, "owner");
        super.b(r11);
        VDPlayerActivity.Companion.a(true);
        Loog.INSTANCE.d(TAG, "onStart");
        x<GlobalUIContext> r9 = AutoActionUIContext.INSTANCE.getState();
    L3:
        GlobalUIContext r12 = r9.c();
        GlobalUIContext r2 = (GlobalUIContext) ZeusTransformUtils.preCheckCast(r12, GlobalUIContext.class, "com.obric.aiagent.plugin");
        if (r9.a(r12, GlobalUIContext.copy$default(r2, r2.getPlayer().copy(IAutoActionPresentationApi.PlayerVisibility.Visible), null, null, null, 14, null)) == false) goto L3;
    }

    @Override // androidx.lifecycle.d
    public void onResume(p r9) {
        p r10 = (p) ZeusTransformUtils.wrapperContextForParams(r9, p.class, "com.obric.aiagent.plugin");
        o.e(r10, "owner");
        super.onResume(r10);
        Loog.INSTANCE.d(TAG, "onResume");
        com.obric.autoaction.a.c r11 = this.f25705b;
        String r0 = null;
        if (r11 == null) goto L5;
        Context r12 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r11.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
    L7:
        if (ZeusTransformUtils.instanceOf(r12, Activity.class) == false) goto L9;
        Activity r13 = (Activity) ZeusTransformUtils.preCheckCast(r12, Activity.class, "com.obric.aiagent.plugin");
    L10:
        if (r13 != null) goto L12;
        return;
    L12:
        Intent r1 = r13.getIntent();
        if (r1 == null) goto L15;
        boolean r2 = r1.getBooleanExtra("auto_enter_call_user", false);
    L16:
        Intent r4 = r13.getIntent();
        if (r4 == null) goto L19;
        boolean r5 = r4.getBooleanExtra("start_clarify_input", false);
    L20:
        Intent r6 = r13.getIntent();
        if (r6 == null) goto L23;
        r0 = r6.getStringExtra("source_from");
    L23:
        if (r0 != null) goto L25;
        r0 = "";
    L25:
        Intent r7 = r13.getIntent();
        if (r7 == null) goto L28;
        boolean r8 = r7.getBooleanExtra("disable_doubao_interaction", false);
    L29:
        u r14 = this.f25706c;
        if (r14 == null) goto L32;
        r14.a(r8);
    L32:
        u r15 = this.f25706c;
        if (r15 == null) goto L39;
        if (r5 == false) goto L37;
        if (r8 == true) goto L37;
        boolean r16 = true;
    L38:
        r15.a(r2, r16, r0);
    L37:
        r16 = false;
    L39:
        Intent r17 = r13.getIntent();
        if (r17 == null) goto L42;
        r17.putExtra("auto_enter_call_user", false);
    L42:
        Intent r18 = r13.getIntent();
        if (r18 == null) goto L46;
        r18.putExtra("start_clarify_input", false);
        return;
    L46:
        return;
    L28:
        r8 = false;
        goto L29
    L19:
        r5 = false;
        goto L20
    L15:
        r2 = false;
        goto L16
    L9:
        r13 = null;
        goto L10
    L5:
        r12 = null;
        goto L7
    }

    @Override // com.obric.autoaction.a.e
    public void a(Intent r4) {
        Loog.INSTANCE.d(TAG, "onNewIntent");
        boolean r0 = false;
        if (r4 == null) goto L5;
        r0 = r4.getBooleanExtra("disable_doubao_interaction", false);
    L5:
        u r3 = this.f25706c;
        if (r3 == null) goto L9;
        r3.a(r0);
        return;
    }

    @Override // androidx.lifecycle.d
    public void c(p r3) {
        p r4 = (p) ZeusTransformUtils.wrapperContextForParams(r3, p.class, "com.obric.aiagent.plugin");
        o.e(r4, "owner");
        super.c(r4);
        Loog.INSTANCE.d(TAG, "onPause");
    }

    @Override // androidx.lifecycle.d
    public void d(p r10) {
        p r11 = (p) ZeusTransformUtils.wrapperContextForParams(r10, p.class, "com.obric.aiagent.plugin");
        o.e(r11, "owner");
        super.d(r11);
        Loog.INSTANCE.d(TAG, "onStop");
        VDPlayerActivity.Companion.a(false);
        x<GlobalUIContext> r9 = AutoActionUIContext.INSTANCE.getState();
    L3:
        GlobalUIContext r12 = r9.c();
        GlobalUIContext r2 = (GlobalUIContext) ZeusTransformUtils.preCheckCast(r12, GlobalUIContext.class, "com.obric.aiagent.plugin");
        if (r9.a(r12, GlobalUIContext.copy$default(r2, r2.getPlayer().copy(IAutoActionPresentationApi.PlayerVisibility.Invisible), null, null, null, 14, null)) == false) goto L3;
    }

    @Override // androidx.lifecycle.d
    public void e(p r3) {
        p r4 = (p) ZeusTransformUtils.wrapperContextForParams(r3, p.class, "com.obric.aiagent.plugin");
        o.e(r4, "owner");
        super.e(r4);
        Loog.INSTANCE.d(TAG, "onDestroy");
        a();
    }

    private final void a() {
        u r0 = this.f25706c;
        if (r0 == null) goto L18;
        ak<s> r1 = r0.b();
        if (r1 == null) goto L19;
        s r2 = (s) ZeusTransformUtils.preCheckCast(r1.c(), s.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L20;
        com.obric.autoaction.vdplayer.legacy.d.o r3 = r2.e();
        if (r3 != null) goto L12;
        return;
    L12:
        if (r3 != com.obric.autoaction.vdplayer.legacy.d.o.f25926a) goto L14;
        return;
    L14:
        Loog.INSTANCE.i(TAG, "onDestroy while user operating (" + r3 + "), exiting to resume task");
        u r5 = this.f25706c;
        if (r5 == null) goto L21;
        r5.a((com.obric.autoaction.vdplayer.legacy.b.b) ZeusTransformUtils.preCheckCast(r.c.f25946a, com.obric.autoaction.vdplayer.legacy.b.b.class, "com.obric.aiagent.plugin"));
        return;
    L21:
        return;
    L20:
        return;
    L19:
        return;
    }
}
