package com.bytedance.android.livesdk.interactivity.comment.newinput.behavior;

import am2.x;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService;
import com.bytedance.android.livesdk.interactivity.comment.newinput.framework.InputFunctionEnum;
import com.bytedance.android.livesdk.interactivity.comment.newinput.framework.InputFunctionType;
import com.bytedance.android.livesdk.interactivity.comment.newinput.framework.InputSectionType;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public abstract class c implements com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f135392a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f135393b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f135394c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.bytedance.android.livesdk.interactivity.comment.newinput.framework.h f135395d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f135396e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final InputFunctionEnum f135397f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Context f135398g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final InputSectionType f135399h;

    public static final class a {
    }

    static {
    }

    public int c() {
        return 0;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a
    public int o() {
        return 0;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a
    public void r(com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r100) {
        Intrinsics.checkNotNullParameter(r100, "bridge");
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a
    public void s(com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r100) {
        Intrinsics.checkNotNullParameter(r100, "bridges");
    }

    public final InputFunctionType b() {
        return this.f135397f.getType();
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a
    public boolean canShowRedDot() {
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.h r100 = this.f135395d;
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.f135510a >= com.bytedance.android.livesdk.paas.c.b()) goto L9;
        return false;
    L9:
        if (((Number) new com.bytedance.android.livesdk.sharedpref.e(this.f135396e, 0).getValue()).intValue() >= 3) goto L12;
        return true;
    L12:
        return false;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a
    public View getView() {
        if (this.f135392a != null) goto L10;
        if (c() <= 0) goto L10;
        View r100 = LayoutInflater.from(this.f135398g).inflate(c(), null);
        this.f135392a = r100;
        if (r100 == null) goto L10;
        r100.setTag(this.f135397f);
    L10:
        return this.f135392a;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a
    public final void j() {
        if (this.f135395d == null) goto L6;
        com.bytedance.android.livesdk.sharedpref.f.d(new com.bytedance.android.livesdk.sharedpref.e(this.f135396e, 0), 3);
        u(false, true);
        return;
    }

    public final Context getContext() {
        return this.f135398g;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a
    public final boolean i() {
        return this.f135394c;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a
    public final InputSectionType l() {
        return this.f135399h;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a
    public final int n() {
        return this.f135393b;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a
    public final InputFunctionEnum q() {
        return this.f135397f;
    }

    public final void a(com.bytedance.android.livesdk.interactivity.comment.newinput.framework.h r100) {
        Intrinsics.checkNotNullParameter(r100, "redDot");
        Unit r101 = Unit.INSTANCE;
        this.f135395d = r100;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a
    public void k(com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r100) {
        Intrinsics.checkNotNullParameter(r100, "bridges");
        r3.a(getView(), this.f135397f.getDesc());
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a
    public final void m(int r100) {
        this.f135393b = r100;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a
    public void p(com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r100) {
        Intrinsics.checkNotNullParameter(r100, "bridges");
        Intrinsics.checkNotNullParameter(r100, "bridges");
    }

    public static void d(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "icon");
        HashMap r102 = new HashMap();
        r102.put("click_icon", r100);
        r102.put("screen_type", "portrait");
        if (r101 == false) goto L5;
        String r103 = "on";
    L6:
        r102.put("extend_mode", r103);
        IInteractivityInjectService r104 = (IInteractivityInjectService) jc1.k.f(IInteractivityInjectService.class);
        if (r104 == null) goto L9;
        r104.buildVsRoomLog(null, r102);
    L9:
        j0.l().sendLog("livesdk_comment_expansion_module_click", r102, new Object[]{IRoom.class, x.class});
        return;
    L5:
        r103 = "off";
        goto L6
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a
    public void t(View r100, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "bridges");
        d(this.f135397f.getLogValue(), r101.i());
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a
    public void u(boolean r100, boolean r101) {
        View r102 = null;
        if (r100 == false) goto L11;
        View r103 = this.f135392a;
        if (r103 == null) goto L7;
        r102 = r103.findViewById(R.id.red_dot);
    L7:
        if (r102 == null) goto L9;
        UtilityKotlinExtentionsKt.w(r102);
    L9:
        if (r101 == false) goto L16;
        com.bytedance.android.livesdk.sharedpref.e r104 = new com.bytedance.android.livesdk.sharedpref.e(this.f135396e, 0);
        com.bytedance.android.livesdk.sharedpref.f.d(r104, Integer.valueOf(((Integer) r104.getValue()).intValue() + 1));
    L16:
        this.f135394c = r100;
        return;
    L11:
        View r105 = this.f135392a;
        if (r105 == null) goto L14;
        r102 = r105.findViewById(R.id.red_dot);
    L14:
        if (r102 == null) goto L16;
        UtilityKotlinExtentionsKt.t(r102);
        goto L16
    }

    public c(InputFunctionEnum r100, Context r101, InputSectionType r102) {
        Intrinsics.checkNotNullParameter(r100, "symbol");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f135397f = r100;
        this.f135398g = r101;
        this.f135399h = r102;
        this.f135393b = 1;
        this.f135396e = "red_dot_" + r100.name();
    }
}
