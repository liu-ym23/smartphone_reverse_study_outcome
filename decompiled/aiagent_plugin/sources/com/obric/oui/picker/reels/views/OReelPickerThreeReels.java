package com.obric.oui.picker.reels.views;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.aiagent.plugin.R;
import com.obric.oui.common.util.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.h.b.p;
import d.l.n;
import java.util.ArrayList;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: OReelPickerThreeReels.kt */
/* JADX INFO: loaded from: classes4.dex */
public class OReelPickerThreeReels extends ConstraintLayout implements com.obric.oui.picker.reels.a {
    public static final b Companion = null;
    private static final String TAG = "OReelPickerThreeReels";
    private int reelsCount;
    private final d.f wv1$delegate;
    private final d.f wv2$delegate;
    private final d.f wv3$delegate;

    /* JADX INFO: compiled from: OReelPickerThreeReels.kt */
    public static final class a implements com.obric.oui.picker.reels.a.InterfaceC0969a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<com.obric.oui.picker.reels.a.b> f35951a;

        public a() {
            this.f35951a = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        }

        public com.obric.oui.picker.reels.a.InterfaceC0969a a(com.obric.oui.picker.reels.a.b r2) {
            o.e(r2, "reel");
            this.f35951a.add(r2);
            return (com.obric.oui.picker.reels.a.InterfaceC0969a) ZeusTransformUtils.preCheckCast(this, com.obric.oui.picker.reels.a.InterfaceC0969a.class, "com.obric.aiagent.plugin");
        }

        public com.obric.oui.picker.reels.a a(Context r3, AttributeSet r4, int r5) {
            Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
            o.e(r6, "context");
            OReelPickerThreeReels r0 = new OReelPickerThreeReels(r6, r7, r5);
            a(r0, this.f35951a);
            r0.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new LinearLayout.LayoutParams(-1, g.a((View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.aiagent.plugin"), 240)), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
            return (com.obric.oui.picker.reels.a) ZeusTransformUtils.preCheckCast(r0, com.obric.oui.picker.reels.a.class, "com.obric.aiagent.plugin");
        }

        private final void a(OReelPickerThreeReels r8, List<com.obric.oui.picker.reels.a.b> r9) {
            List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
            int r7 = this.f35951a.size();
            if (r7 != 0) goto L5;
            OReelPickerThreeReels.access$setReelsCount$p(r8, 0);
            return;
        L5:
            if (r7 != 1) goto L7;
            OReelPickerThreeReels.access$configure(r8, OReelPickerThreeReels.access$getWv1(r8), (com.obric.oui.picker.reels.a.b) ZeusTransformUtils.preCheckCast(r10.get(0), com.obric.oui.picker.reels.a.b.class, "com.obric.aiagent.plugin"), 0, 0);
            ((View) ZeusTransformUtils.preCheckCast(OReelPickerThreeReels.access$getWv2(r8), View.class, "com.obric.aiagent.plugin")).setVisibility(8);
            ((View) ZeusTransformUtils.preCheckCast(OReelPickerThreeReels.access$getWv3(r8), View.class, "com.obric.aiagent.plugin")).setVisibility(8);
            OReelPickerThreeReels.access$setReelsCount$p(r8, 1);
            return;
        L7:
            if (r7 == 2) goto L9;
            OReelPickerThreeReels.access$configure(r8, OReelPickerThreeReels.access$getWv1(r8), (com.obric.oui.picker.reels.a.b) ZeusTransformUtils.preCheckCast(r10.get(0), com.obric.oui.picker.reels.a.b.class, "com.obric.aiagent.plugin"), 0, 2);
            OReelPickerThreeReels.access$configure(r8, OReelPickerThreeReels.access$getWv2(r8), (com.obric.oui.picker.reels.a.b) ZeusTransformUtils.preCheckCast(r10.get(1), com.obric.oui.picker.reels.a.b.class, "com.obric.aiagent.plugin"), 1, 2);
            OReelPickerThreeReels.access$configure(r8, OReelPickerThreeReels.access$getWv3(r8), (com.obric.oui.picker.reels.a.b) ZeusTransformUtils.preCheckCast(r10.get(2), com.obric.oui.picker.reels.a.b.class, "com.obric.aiagent.plugin"), 2, 2);
            OReelPickerThreeReels.access$setReelsCount$p(r8, 3);
            return;
        L9:
            OReelPickerThreeReels.access$configure(r8, OReelPickerThreeReels.access$getWv1(r8), (com.obric.oui.picker.reels.a.b) ZeusTransformUtils.preCheckCast(r10.get(0), com.obric.oui.picker.reels.a.b.class, "com.obric.aiagent.plugin"), 0, 1);
            OReelPickerThreeReels.access$configure(r8, OReelPickerThreeReels.access$getWv2(r8), (com.obric.oui.picker.reels.a.b) ZeusTransformUtils.preCheckCast(r10.get(1), com.obric.oui.picker.reels.a.b.class, "com.obric.aiagent.plugin"), 1, 1);
            ((View) ZeusTransformUtils.preCheckCast(OReelPickerThreeReels.access$getWv3(r8), View.class, "com.obric.aiagent.plugin")).setVisibility(8);
            OReelPickerThreeReels.access$setReelsCount$p(r8, 2);
        }
    }

    /* JADX INFO: compiled from: OReelPickerThreeReels.kt */
    public static final class b {
        public /* synthetic */ b(h r1) {
            this();
        }

        private b() {
        }
    }

    /* JADX INFO: compiled from: OReelPickerThreeReels.kt */
    public static final class c implements com.obric.oui.picker.reels.views.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.obric.oui.picker.reels.a.b f35952a;

        c(com.obric.oui.picker.reels.a.b r1) {
            this.f35952a = r1;
        }

        @Override // com.obric.oui.picker.reels.views.a
        public void a(int r3, int r4) {
            a(OReelPickerThreeReels.TAG, "onChanged: " + r3 + " -> " + r4);
            com.obric.oui.picker.reels.a.c r5 = this.f35952a.i();
            if (r5 == null) goto L7;
            r5.onReelChanged(this.f35952a.a(), r4);
            return;
        }

        @Override // com.obric.oui.picker.reels.views.a
        public void a(int r3) {
            a(OReelPickerThreeReels.TAG, o.a("onStopped: ", Integer.valueOf(r3)));
            com.obric.oui.picker.reels.a.c r0 = this.f35952a.i();
            if (r0 == null) goto L7;
            r0.onReelChanged(this.f35952a.a(), r3);
            return;
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int a(String r1, String r2) {
            if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
            return 0;
        L5:
            return Log.d(r1, r2);
        }
    }

    /* JADX INFO: compiled from: OReelPickerThreeReels.kt */
    static final class d extends p implements d.h.a.a<WheelView> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OReelPickerThreeReels f35953a;

        d(OReelPickerThreeReels r1) {
            this.f35953a = r1;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ WheelView invoke() {
            return a();
        }

        public final WheelView a() {
            return (WheelView) ZeusTransformUtils.preCheckCast(this.f35953a.findViewById(ZeusTransformUtils.mapRes(R.id.wv_1, DbHelper.COL_ID, "wv_1")), WheelView.class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: OReelPickerThreeReels.kt */
    static final class e extends p implements d.h.a.a<WheelView> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OReelPickerThreeReels f35954a;

        e(OReelPickerThreeReels r1) {
            this.f35954a = r1;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ WheelView invoke() {
            return a();
        }

        public final WheelView a() {
            return (WheelView) ZeusTransformUtils.preCheckCast(this.f35954a.findViewById(ZeusTransformUtils.mapRes(R.id.wv_2, DbHelper.COL_ID, "wv_2")), WheelView.class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: OReelPickerThreeReels.kt */
    static final class f extends p implements d.h.a.a<WheelView> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OReelPickerThreeReels f35955a;

        f(OReelPickerThreeReels r1) {
            this.f35955a = r1;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ WheelView invoke() {
            return a();
        }

        public final WheelView a() {
            return (WheelView) ZeusTransformUtils.preCheckCast(this.f35955a.findViewById(ZeusTransformUtils.mapRes(R.id.wv_3, DbHelper.COL_ID, "wv_3")), WheelView.class, "com.obric.aiagent.plugin");
        }
    }

    static {
        Companion = new b(null);
    }

    public OReelPickerThreeReels(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public OReelPickerThreeReels(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public /* synthetic */ OReelPickerThreeReels(Context r2, AttributeSet r3, int r4, int r5, h r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r7, r8, r4);
    }

    public static final /* synthetic */ void access$configure(OReelPickerThreeReels r0, WheelView r1, com.obric.oui.picker.reels.a.b r2, int r3, int r4) {
        r0.configure(r1, r2, r3, r4);
    }

    public static final /* synthetic */ WheelView access$getWv1(OReelPickerThreeReels r0) {
        return r0.getWv1();
    }

    public static final /* synthetic */ WheelView access$getWv2(OReelPickerThreeReels r0) {
        return r0.getWv2();
    }

    public static final /* synthetic */ WheelView access$getWv3(OReelPickerThreeReels r0) {
        return r0.getWv3();
    }

    public static final /* synthetic */ void access$setReelsCount$p(OReelPickerThreeReels r0, int r1) {
        r0.reelsCount = r1;
    }

    public OReelPickerThreeReels(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        super(r6, r7, r5);
        this.wv1$delegate = d.g.a((d.h.a.a) ZeusTransformUtils.preCheckCast(new d(this), d.h.a.a.class, "com.obric.aiagent.plugin"));
        this.wv2$delegate = d.g.a((d.h.a.a) ZeusTransformUtils.preCheckCast(new e(this), d.h.a.a.class, "com.obric.aiagent.plugin"));
        this.wv3$delegate = d.g.a((d.h.a.a) ZeusTransformUtils.preCheckCast(new f(this), d.h.a.a.class, "com.obric.aiagent.plugin"));
        ZeusTransformUtils.inflate(LayoutInflater.from(r6), ZeusTransformUtils.mapRes(R.layout.o_reel_picker_3_reels, "layout", "o_reel_picker_3_reels"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
    }

    private final WheelView getWv1() {
        Object r2 = this.wv1$delegate.b();
        o.c(r2, "<get-wv1>(...)");
        return (WheelView) ZeusTransformUtils.preCheckCast(r2, WheelView.class, "com.obric.aiagent.plugin");
    }

    private final WheelView getWv2() {
        Object r2 = this.wv2$delegate.b();
        o.c(r2, "<get-wv2>(...)");
        return (WheelView) ZeusTransformUtils.preCheckCast(r2, WheelView.class, "com.obric.aiagent.plugin");
    }

    private final WheelView getWv3() {
        Object r2 = this.wv3$delegate.b();
        o.c(r2, "<get-wv3>(...)");
        return (WheelView) ZeusTransformUtils.preCheckCast(r2, WheelView.class, "com.obric.aiagent.plugin");
    }

    private final void configure(WheelView r3, com.obric.oui.picker.reels.a.b r4, int r5, int r6) {
        ((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.aiagent.plugin")).setVisibility(0);
        CharSequence r2 = r4.c();
        if (r2 == null) goto L6;
        r3.setTagText(r2);
    L6:
        r3.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new LinearLayout.LayoutParams(0, -1, r4.d()), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        r3.setOnWheelChangedListener((com.obric.oui.picker.reels.views.a) ZeusTransformUtils.preCheckCast(new c(r4), com.obric.oui.picker.reels.views.a.class, "com.obric.aiagent.plugin"));
        r3.setEntries(r4.b(), n.a(r4.h(), 0, n.c(r4.b().size() - 1, 0)));
    }

    @Override // com.obric.oui.picker.reels.a
    public View asView() {
        return (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.oui.picker.reels.a
    public WheelView getReelView(int r2) {
        if (r2 == 0) goto L11;
        if (r2 == 1) goto L14;
        if (r2 == 2) goto L13;
        return null;
    L13:
        return getWv3();
    L14:
        return getWv2();
    L11:
        return getWv1();
    }

    public void configure(int r3, com.obric.oui.picker.reels.a.b r4) {
        o.e(r4, "reel");
        WheelView r0 = getReelView(r3);
        if (r0 == null) goto L7;
        configure(r0, r4, r3, this.reelsCount - 1);
        return;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }
}
