package com.bytedance.android.livesdk.interactivity.interactive.dialog.provider;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.ui.KeyboardShadowView;
import com.bytedance.android.livesdk.interactivity.interactive.dialog.framework.VSInputSectionType;
import com.bytedance.android.livesdk.r3;
import com.larus.nova.R;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class t implements k82.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final VSInputSectionType f137332a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public k82.c f137333b;

    public final class a extends k82.c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public KeyboardShadowView f137334c;

        public a(View r100, h82.b r101) {
            Intrinsics.checkNotNullParameter(r100, "view");
            Intrinsics.checkNotNullParameter(r101, "bridges");
            super(r100, r101);
        }
    }

    @Override // k82.d
    public final void a() {
    }

    @Override // k82.d
    public final void d() {
    }

    @Override // k82.d
    public final void e() {
    }

    public t() {
        this.f137332a = VSInputSectionType.SHADOW;
    }

    @Override // k82.d
    public final VSInputSectionType b() {
        return this.f137332a;
    }

    @Override // k82.d
    public final k82.c c() {
        return this.f137333b;
    }

    @Override // k82.d
    public final View g(h82.b r100) {
        Intrinsics.checkNotNullParameter(r100, "panelBridge");
        Activity r101 = r100.getActivity();
        if (r101 != null) goto L5;
        return null;
    L5:
        View r102 = LayoutInflater.from(r101).inflate(R.layout.ttlive_input_view_shadow_vs, null);
        a r103 = new a(r102, r100);
        KeyboardShadowView r104 = (KeyboardShadowView) r103.f502090a.findViewById(R.id.input_view_shadow);
        r103.f137334c = r104;
        if (r104 == null) goto L8;
        r104.setOnClickListener(new s(r103));
    L8:
        KeyboardShadowView r105 = r103.f137334c;
        if (r105 == null) goto L11;
        r105.enableDispatchTouchEventToActivity(false);
    L11:
        KeyboardShadowView r106 = r103.f137334c;
        if (r106 == null) goto L14;
        r106.setIsAnchor(r103.f502091b.u());
    L14:
        KeyboardShadowView r107 = r103.f137334c;
        if (r107 == null) goto L17;
        r103.f502091b.v();
        r107.setIsPortrait(true);
    L17:
        Activity r108 = r103.f502091b.getActivity();
        if (r108 == null) goto L22;
        KeyboardShadowView r109 = r103.f137334c;
        if (r109 == null) goto L22;
        r109.setActivity(r108);
    L22:
        r3.c(r103.f137334c, s1.B(R.string.ttlive_a11y_keyboard_exit), true);
        Unit r110 = Unit.INSTANCE;
        this.f137333b = r103;
        return r102;
    }

    @Override // k82.d
    public final void h(VSInputSectionType r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, "sectionType");
        Intrinsics.checkNotNullParameter(r101, "view");
        k82.d.a.a(r100, r101);
    }
}
