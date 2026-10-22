package com.obric.oui.sheet.v2;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.oui.d.i;
import com.obric.oui.dialog.alert.view.RadiusLayout;
import com.obric.oui.material.MaterialToken;
import com.obric.oui.material.k;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.m;
import d.h.b.o;
import d.h.b.p;
import d.x;
import java.util.Objects;

/* JADX INFO: compiled from: OSheetBase.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface a extends e {

    /* JADX INFO: renamed from: com.obric.oui.sheet.v2.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: OSheetBase.kt */
    public static final class C0991a {

        /* JADX INFO: renamed from: com.obric.oui.sheet.v2.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: OSheetBase.kt */
        static final class C0992a extends p implements m<Boolean, Throwable, x> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ a f36226a;

            C0992a(a r3) {
                this.f36226a = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin");
                super(2);
            }

            @Override // d.h.a.m
            public /* synthetic */ x invoke(Boolean r3, Throwable r4) {
                a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue(), (Throwable) ZeusTransformUtils.preCheckCast(r4, Throwable.class, "com.obric.aiagent.plugin"));
                return x.f38692a;
            }

            public final void a(boolean r4, Throwable r5) {
                d.f36236a.a((View) ZeusTransformUtils.preCheckCast(this.f36226a.getRootContainer(), View.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.id.o_dialog_anim_in, DbHelper.COL_ID, "o_dialog_anim_in"));
                this.f36226a.setRunningAnim(null);
            }
        }

        /* JADX INFO: renamed from: com.obric.oui.sheet.v2.a$a$b */
        /* JADX INFO: compiled from: OSheetBase.kt */
        static final class b extends p implements m<Boolean, Throwable, x> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ a f36227a;

            b(a r3) {
                this.f36227a = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin");
                super(2);
            }

            @Override // d.h.a.m
            public /* synthetic */ x invoke(Boolean r3, Throwable r4) {
                a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue(), (Throwable) ZeusTransformUtils.preCheckCast(r4, Throwable.class, "com.obric.aiagent.plugin"));
                return x.f38692a;
            }

            public final void a(boolean r4, Throwable r5) {
                d.f36236a.a((View) ZeusTransformUtils.preCheckCast(this.f36227a.getRootContainer(), View.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.id.o_dialog_anim_in, DbHelper.COL_ID, "o_dialog_anim_in"));
                this.f36227a.setRunningAnim(null);
                this.f36227a.onShowAnimEnd();
            }
        }

        /* JADX INFO: renamed from: com.obric.oui.sheet.v2.a$a$c */
        /* JADX INFO: compiled from: OSheetBase.kt */
        static final class c extends p implements m<Boolean, Throwable, x> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ a f36228a;

            c(a r3) {
                this.f36228a = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin");
                super(2);
            }

            @Override // d.h.a.m
            public /* synthetic */ x invoke(Boolean r3, Throwable r4) {
                a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue(), (Throwable) ZeusTransformUtils.preCheckCast(r4, Throwable.class, "com.obric.aiagent.plugin"));
                return x.f38692a;
            }

            public final void a(boolean r4, Throwable r5) {
                d.f36236a.a((View) ZeusTransformUtils.preCheckCast(this.f36228a.getRootContainer(), View.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.id.o_dialog_anim_out, DbHelper.COL_ID, "o_dialog_anim_out"));
                this.f36228a.setRunningAnim(null);
                this.f36228a.onDismissAnimEnd();
                this.f36228a.onDismissComplete();
            }
        }

        public static /* synthetic */ void lambda$1LaADmbk7p1KgnCKKM5Jrpch_ZU(a r0) {
            s(r0);
        }

        /* JADX INFO: renamed from: lambda$BJat3QW3bCBZSnIharfELGJy-gA, reason: not valid java name */
        public static /* synthetic */ void m1181lambda$BJat3QW3bCBZSnIharfELGJygA(a r0) {
            t(r0);
        }

        public static int a(a r2) {
            a r3 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.aiagent.plugin");
            o.e(r3, "this");
            if (r3.isContentOverlayMode() == false) goto L7;
            return ZeusTransformUtils.mapRes(R.layout.o_sheet_container_overlay, "layout", "o_sheet_container_overlay");
        L7:
            return ZeusTransformUtils.mapRes(R.layout.o_sheet_container, "layout", "o_sheet_container");
        }

        public static void a(a r11, Context r12) {
            a r13 = (a) ZeusTransformUtils.wrapperContextForParams(r11, a.class, "com.obric.aiagent.plugin");
            Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.aiagent.plugin");
            o.e(r13, "this");
            o.e(r3, "context");
            r13.setRootContainer((RadiusLayout) ZeusTransformUtils.preCheckCast(r13.getViewById(ZeusTransformUtils.mapRes(R.id.root_constraint, DbHelper.COL_ID, "root_constraint")), RadiusLayout.class, "com.obric.aiagent.plugin"));
            r13.setupDimView(r3);
            r13.setHeaderContainer((FrameLayout) ZeusTransformUtils.preCheckCast(r13.getViewById(ZeusTransformUtils.mapRes(R.id.header_container, DbHelper.COL_ID, "header_container")), FrameLayout.class, "com.obric.aiagent.plugin"));
            r13.setBodyContainer((FrameLayout) ZeusTransformUtils.preCheckCast(r13.getViewById(ZeusTransformUtils.mapRes(R.id.body_container, DbHelper.COL_ID, "body_container")), FrameLayout.class, "com.obric.aiagent.plugin"));
            r13.setFooterContainer((FrameLayout) ZeusTransformUtils.preCheckCast(r13.getViewById(ZeusTransformUtils.mapRes(R.id.footer_container, DbHelper.COL_ID, "footer_container")), FrameLayout.class, "com.obric.aiagent.plugin"));
            r13.setScaffoldContainer((ViewGroup) ZeusTransformUtils.preCheckCast(r13.getViewById(ZeusTransformUtils.mapRes(R.id.scaffold_container, DbHelper.COL_ID, "scaffold_container")), ViewGroup.class, "com.obric.aiagent.plugin"));
            r13.updateFullWindowSize();
            r13.setScaffoldController(new com.obric.oui.sheet.v2.c(r3, r13, r13.getRootContainer(), r13.getHeaderContainer(), r13.getBodyContainer(), r13.getFooterContainer(), r13.getScaffoldContainer(), r13.getDimView()));
            r13.getScaffoldController().a(r13.getHeightStyle());
            r13.getScaffoldController().a(r13.getIgnoreInsetBottom());
            r13.getScaffoldController().a(r13.getFullWindowSize());
            r13.initBgColor();
        }

        public static void b(a r3) {
            a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin");
            o.e(r4, "this");
            r4.setFullWindowSize(com.obric.oui.window.a.d((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getSheetContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")));
            if (r4.getUserWindowWidth() <= 0) goto L8;
            if (r4.getUserWindowWidth() >= r4.getFullWindowSize().getWidth()) goto L8;
            r4.setFullWindowSize(new Size(r4.getUserWindowWidth(), r4.getFullWindowSize().getHeight()));
        L8:
            if (r4.getUserWindowHeight() > 0) goto L10;
            return;
        L10:
            if (r4.getUserWindowHeight() >= r4.getFullWindowSize().getHeight()) goto L14;
            r4.setFullWindowSize(new Size(r4.getFullWindowSize().getWidth(), r4.getUserWindowHeight()));
            return;
        }

        public static void a(a r2, OSheet.c r3) {
            a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.aiagent.plugin");
            o.e(r4, "this");
            o.e(r3, "height");
            r4.setHeightStyle(r3);
            r4.getScaffoldController().a(r3);
            r4.getScaffoldController().g();
        }

        public static void a(a r2, boolean r3) {
            a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.aiagent.plugin");
            o.e(r4, "this");
            r4.setIgnoreInsetBottom(r3);
            r4.getScaffoldController().a(r3);
        }

        public static void b(a r2, boolean r3) {
            a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.aiagent.plugin");
            o.e(r4, "this");
            if (r4.getAutoAddBodyPaddingTopWhenOverlay() == r3) goto L8;
            r4.setAutoAddBodyPaddingTopWhenOverlay(r3);
            if (r4.getShowing() == false) goto L9;
            r4.onPostShow();
            return;
        L9:
            return;
        }

        public static /* synthetic */ void a(a r15, OSheet.b r16, Integer r17, Integer r18, String r19, String r20, boolean r21, View.OnClickListener r22, View.OnClickListener r23, Integer r24, Integer r25, String r26, String r27, Integer r28, Integer r29, int r30, Object r31) {
            a r1 = (a) ZeusTransformUtils.wrapperContextForParams(r15, a.class, "com.obric.aiagent.plugin");
            View.OnClickListener r3 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r22, View.OnClickListener.class, "com.obric.aiagent.plugin");
            View.OnClickListener r2 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r23, View.OnClickListener.class, "com.obric.aiagent.plugin");
            if (r31 != null) goto L51;
            Integer r5 = null;
            if ((r30 & 2) == 0) goto L7;
            Integer r4 = null;
        L9:
            if ((r30 & 4) == 0) goto L11;
            Integer r6 = null;
        L13:
            if ((r30 & 8) == 0) goto L15;
            String r7 = null;
        L17:
            if ((r30 & 16) == 0) goto L19;
            String r8 = null;
        L21:
            if ((r30 & 32) == 0) goto L23;
            boolean r9 = false;
        L25:
            if ((r30 & 256) == 0) goto L27;
            Integer r10 = null;
        L29:
            if ((r30 & 512) == 0) goto L31;
            Integer r11 = null;
        L33:
            if ((r30 & 1024) == 0) goto L35;
            String r12 = null;
        L37:
            if ((r30 & 2048) == 0) goto L39;
            String r13 = null;
        L41:
            if ((r30 & 4096) == 0) goto L43;
            Integer r14 = null;
        L45:
            if ((r30 & 8192) != 0) goto L48;
            r5 = r29;
        L48:
            r1.setHeader(r16, r4, r6, r7, r8, r9, r3, r2, r10, r11, r12, r13, r14, r5);
            return;
        L43:
            r14 = r28;
            goto L45
        L39:
            r13 = r27;
            goto L41
        L35:
            r12 = r26;
            goto L37
        L31:
            r11 = r25;
            goto L33
        L27:
            r10 = r24;
            goto L29
        L23:
            r9 = r21;
            goto L25
        L19:
            r8 = r20;
            goto L21
        L15:
            r7 = r19;
            goto L17
        L11:
            r6 = r18;
            goto L13
        L7:
            r4 = r17;
            goto L9
        L51:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setHeader");
        }

        public static void a(a r19, OSheet.b r20, Integer r21, Integer r22, String r23, String r24, boolean r25, View.OnClickListener r26, View.OnClickListener r27, Integer r28, Integer r29, String r30, String r31, Integer r32, Integer r33) {
            a r0 = (a) ZeusTransformUtils.wrapperContextForParams(r19, a.class, "com.obric.aiagent.plugin");
            View.OnClickListener r10 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r26, View.OnClickListener.class, "com.obric.aiagent.plugin");
            View.OnClickListener r11 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r27, View.OnClickListener.class, "com.obric.aiagent.plugin");
            o.e(r0, "this");
            o.e(r20, "style");
            r0.getScaffoldController().a(r20, r21, r22, r23, r24, r25, r10, r11, r28, r29, r30, r31, r32, r33, (e) ZeusTransformUtils.preCheckCast(r0, e.class, "com.obric.aiagent.plugin"));
        }

        public static void a(a r2, View r3) {
            a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.aiagent.plugin");
            o.e(r4, "this");
            r4.getScaffoldController().a(r3);
        }

        public static OSheetTitleBar c(a r2) {
            a r3 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.aiagent.plugin");
            o.e(r3, "this");
            return r3.getScaffoldController().d();
        }

        public static void a(a r4, int r5) {
            a r6 = (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.aiagent.plugin");
            o.e(r6, "this");
            if (r6.getBgColor() == r5) goto L17;
            boolean r0 = r6.isDarkTheme();
            r6.setBgColor(r5);
            boolean r2 = r6.isDarkTheme();
            if (r6.getEnableMaterial() == true) goto L7;
            r6.getRootContainer().setBackgroundColor(r5);
        L8:
            if (r0 == r2) goto L18;
            View r7 = r6.getScaffoldController().b().getChildAt(0);
            if (ZeusTransformUtils.instanceOf(r7, OSheetTitleBar.class) == false) goto L19;
            OSheetTitleBar r8 = (OSheetTitleBar) ZeusTransformUtils.preCheckCast(r7, OSheetTitleBar.class, "com.obric.aiagent.plugin");
            if (r2 == false) goto L14;
            int r9 = 2;
        L15:
            r8.applyDynamicTheme(r9);
            return;
        L14:
            r9 = 1;
            goto L15
        L19:
            return;
        L18:
            return;
        L7:
            r6.updateMaterial();
            goto L8
        }

        public static void b(a r2, View r3) {
            a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.aiagent.plugin");
            o.e(r4, "this");
            r4.getScaffoldController().b(r3);
            if (r3 == null) goto L5;
            r4.setBodyContentPaddingTop(r3.getPaddingTop());
            r4.setBodyContentPaddingBottom(r3.getPaddingBottom());
            return;
        L5:
            r4.setBodyContentPaddingTop(0);
            r4.setBodyContentPaddingBottom(0);
        }

        public static void c(a r2, View r3) {
            a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.aiagent.plugin");
            o.e(r4, "this");
            r4.getScaffoldController().c(r3);
        }

        public static void a(a r9, Integer r10, boolean r11, View.OnClickListener r12, Integer r13, boolean r14, View.OnClickListener r15) {
            a r16 = (a) ZeusTransformUtils.wrapperContextForParams(r9, a.class, "com.obric.aiagent.plugin");
            View.OnClickListener r5 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r12, View.OnClickListener.class, "com.obric.aiagent.plugin");
            View.OnClickListener r8 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r15, View.OnClickListener.class, "com.obric.aiagent.plugin");
            o.e(r16, "this");
            r16.getScaffoldController().a(r10, r11, r5, r13, r14, r8);
        }

        public static void a(a r9, String r10, boolean r11, View.OnClickListener r12, String r13, boolean r14, View.OnClickListener r15) {
            a r16 = (a) ZeusTransformUtils.wrapperContextForParams(r9, a.class, "com.obric.aiagent.plugin");
            View.OnClickListener r5 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r12, View.OnClickListener.class, "com.obric.aiagent.plugin");
            View.OnClickListener r8 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r15, View.OnClickListener.class, "com.obric.aiagent.plugin");
            o.e(r16, "this");
            r16.getScaffoldController().a(r10, r11, r5, r13, r14, r8);
        }

        public static int d(a r2) {
            a r3 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.aiagent.plugin");
            o.e(r3, "this");
            return r3.getScaffoldController().k();
        }

        public static boolean e(a r2) {
            a r3 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.aiagent.plugin");
            o.e(r3, "this");
            return r3.getScaffoldController().l();
        }

        public static View f(a r4) {
            a r5 = (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.aiagent.plugin");
            o.e(r5, "this");
            View r0 = r5.getHeaderContainer().findViewById(ZeusTransformUtils.mapRes(R.id.btn_start_action, DbHelper.COL_ID, "btn_start_action"));
            if (r0 == null) goto L5;
            return r0;
        L5:
            return r5.getHeaderContainer().findViewById(ZeusTransformUtils.mapRes(R.id.left_action_back, DbHelper.COL_ID, "left_action_back"));
        }

        public static View g(a r3) {
            a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin");
            o.e(r4, "this");
            return r4.getHeaderContainer().findViewById(ZeusTransformUtils.mapRes(R.id.btn_end_action, DbHelper.COL_ID, "btn_end_action"));
        }

        public static View h(a r3) {
            a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin");
            o.e(r4, "this");
            return r4.getFooterContainer().findViewById(ZeusTransformUtils.mapRes(R.id.btn_negative, DbHelper.COL_ID, "btn_negative"));
        }

        public static View i(a r3) {
            a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin");
            o.e(r4, "this");
            return r4.getFooterContainer().findViewById(ZeusTransformUtils.mapRes(R.id.btn_positive, DbHelper.COL_ID, "btn_positive"));
        }

        public static void c(a r2, boolean r3) {
            a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.aiagent.plugin");
            o.e(r4, "this");
            r4.setMCancelable(r3);
        }

        public static void j(a r2) {
            a r3 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.aiagent.plugin");
            o.e(r3, "this");
            r3.getScaffoldController().j();
        }

        public static void k(a r2) {
            a r3 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.aiagent.plugin");
            o.e(r3, "this");
            r3.getScaffoldController().h();
        }

        public static void l(a r2) {
            a r3 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.aiagent.plugin");
            o.e(r3, "this");
            r3.getScaffoldController().i();
        }

        public static void m(a r7) {
            a r8 = (a) ZeusTransformUtils.wrapperContextForParams(r7, a.class, "com.obric.aiagent.plugin");
            o.e(r8, "this");
            r8.calculateBodyMaxHeight();
            int r2 = 0;
            View r0 = r8.getBodyContainer().getChildAt(0);
            if (ZeusTransformUtils.instanceOf(r0, ViewGroup.class) == false) goto L5;
            ViewGroup r1 = (ViewGroup) ZeusTransformUtils.preCheckCast(r0, ViewGroup.class, "com.obric.aiagent.plugin");
        L6:
            boolean r4 = true;
            if (ZeusTransformUtils.instanceOf(r8.getScaffoldContainer(), LinearLayout.class) == false) goto L18;
            r8.getBodyContainer().setPadding(0, 0, 0, 0);
            if (r1 == null) goto L12;
            r1.setClipToPadding(true);
        L12:
            if (r1 == null) goto L15;
            r1.setPadding(r1.getPaddingLeft(), r8.getBodyContentPaddingTop(), r1.getPaddingRight(), r8.getBodyContentPaddingBottom());
        L15:
            if (r1 == null) goto L45;
            r1.requestLayout();
            return;
        L45:
            return;
        L18:
            FrameLayout r3 = r8.getBodyContainer();
            if (((View) ZeusTransformUtils.preCheckCast(r8.getFooterContainer(), View.class, "com.obric.aiagent.plugin")).getVisibility() != 0) goto L21;
            boolean r5 = true;
        L22:
            if (r5 == false) goto L24;
            int r6 = r8.getFooterContainer().getMeasuredHeight();
        L25:
            r3.setPadding(0, 0, 0, r6);
            if (r1 == null) goto L29;
            r1.setClipToPadding(false);
        L29:
            if (r1 != null) goto L32;
        L40:
            if (r1 == null) goto L46;
            r1.requestLayout();
            return;
        L46:
            return;
        L32:
            if (r8.getAutoAddBodyPaddingTopWhenOverlay() == true) goto L34;
        L39:
            r1.setPadding(r1.getPaddingLeft(), r8.getBodyContentPaddingTop() + r2, r1.getPaddingRight(), r8.getBodyContentPaddingBottom());
            goto L40
        L34:
            if (((View) ZeusTransformUtils.preCheckCast(r8.getHeaderContainer(), View.class, "com.obric.aiagent.plugin")).getVisibility() == 0) goto L37;
            r4 = false;
        L37:
            if (r4 == false) goto L39;
            r2 = r8.getHeaderContainer().getMeasuredHeight();
            goto L39
        L24:
            r6 = 0;
            goto L25
        L21:
            r5 = false;
            goto L22
        L5:
            r1 = (ViewGroup) ZeusTransformUtils.preCheckCast(null, ViewGroup.class, "com.obric.aiagent.plugin");
            goto L6
        }

        public static void n(a r3) {
            a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin");
            o.e(r4, "this");
            if (r4.getConfigurationCallbackRegistered() == false) goto L5;
            return;
        L5:
            ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getSheetContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).registerComponentCallbacks(r4.getConfigurationCallback());
            r4.setConfigurationCallbackRegistered(true);
        }

        public static void o(a r3) {
            a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin");
            o.e(r4, "this");
            if (r4.getConfigurationCallbackRegistered() == true) goto L5;
            return;
        L5:
            ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getSheetContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).unregisterComponentCallbacks(r4.getConfigurationCallback());
            r4.setConfigurationCallbackRegistered(false);
        }

        public static void a(a r2, float r3, float r4, boolean r5) {
            a r6 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.aiagent.plugin");
            o.e(r6, "this");
            if (r5 == false) goto L9;
            r6.setRootTransMoveStartX(r6.getRootContainer().getTranslationX());
            r6.setRootTransMoveStartY(r6.getRootContainer().getTranslationY());
            com.obric.common.oea.foundation.animation.manager.d r7 = r6.getRunningAnim();
            if (r7 == null) goto L11;
            r7.a(true);
            return;
        L11:
            return;
        L9:
            r6.getRootContainer().setTranslationX(r6.getRootTransMoveStartX() + r3);
            r6.getRootContainer().setTranslationY(r6.getRootTransMoveStartY() + r4);
        }

        public static void a(a r15, float r16, float r17) {
            a r0 = (a) ZeusTransformUtils.wrapperContextForParams(r15, a.class, "com.obric.aiagent.plugin");
            o.e(r0, "this");
            if (d.a(d.f36236a, (View) ZeusTransformUtils.preCheckCast(r0.getRootContainer(), View.class, "com.obric.aiagent.plugin"), r17, 0.0f, 4, null) == false) goto L5;
            r0.performExitAnimation(r17);
            return;
        L5:
            com.obric.common.oea.foundation.animation.manager.d r3 = r0.getRunningAnim();
            if (r3 == null) goto L9;
            com.obric.common.oea.foundation.animation.manager.d.a(r3, false, 1, null);
        L9:
            r0.setRunningAnim(com.obric.common.oea.foundation.animation.a.b.a(d.a(d.f36236a, (View) ZeusTransformUtils.preCheckCast(r0.getRootContainer(), View.class, "com.obric.aiagent.plugin"), r0.windowForAnim(), r0.getDimView(), r0.needDimAnim(), r0.useWindowDim(), com.obric.oui.sheet.v2.b.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.getSheetContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), r17, null, 64, null).a((m) ZeusTransformUtils.preCheckCast(new C0992a(r0), m.class, "com.obric.aiagent.plugin")).b(), null, null, 3, null));
        }

        public static void p(a r6) {
            final a r7 = (a) ZeusTransformUtils.wrapperContextForParams(r6, a.class, "com.obric.aiagent.plugin");
            o.e(r7, "this");
            com.obric.common.oea.foundation.animation.manager.d r0 = r7.getRunningAnim();
            if (r0 == null) goto L7;
            com.obric.common.oea.foundation.animation.manager.d.a(r0, false, 1, null);
        L7:
            if (r7.getEnableEnterAnim() == true) goto L10;
            r7.calculateBodyMaxHeight();
            r7.getRootContainer().setAlpha(1.0f);
            r7.getRootContainer().setTranslationY(0.0f);
            d.f36236a.a((View) ZeusTransformUtils.preCheckCast(r7.getRootContainer(), View.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.id.o_dialog_anim_in, DbHelper.COL_ID, "o_dialog_anim_in"));
            r7.setRunningAnim(null);
            r7.onShowAnimStart();
            r7.onShowAnimEnd();
            return;
        L10:
            r7.getRootContainer().setAlpha(0.0f);
            r7.getRootContainer().post(new $$Lambda$a$a$1LaADmbk7p1KgnCKKM5Jrpch_ZU(r7));
        }

        private static void s(a r12) {
            a r13 = (a) ZeusTransformUtils.wrapperContextForParams(r12, a.class, "com.obric.aiagent.plugin");
            o.e(r13, "this$0");
            r13.setRunningAnim(com.obric.common.oea.foundation.animation.a.b.a(d.a(d.f36236a, (View) ZeusTransformUtils.preCheckCast(r13.getRootContainer(), View.class, "com.obric.aiagent.plugin"), r13.windowForAnim(), r13.getDimView(), r13.needDimAnim(), r13.useWindowDim(), com.obric.oui.sheet.v2.b.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r13.getSheetContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), null, 32, null).a((m) ZeusTransformUtils.preCheckCast(new b(r13), m.class, "com.obric.aiagent.plugin")).b(), null, null, 3, null));
            r13.onShowAnimStart();
        }

        public static /* synthetic */ void a(a r2, float r3, int r4, Object r5) {
            a r6 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.aiagent.plugin");
            if (r5 != null) goto L10;
            if ((r4 & 1) == 0) goto L7;
            r3 = 0.0f;
        L7:
            r6.performExitAnimation(r3);
            return;
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: performExitAnimation");
        }

        public static void a(a r17, float r18) {
            final a r0 = (a) ZeusTransformUtils.wrapperContextForParams(r17, a.class, "com.obric.aiagent.plugin");
            o.e(r0, "this");
            com.obric.common.oea.foundation.animation.manager.d r2 = r0.getRunningAnim();
            if (r2 == null) goto L6;
            com.obric.common.oea.foundation.animation.manager.d.a(r2, false, 1, null);
        L6:
            r0.setRunningAnim(com.obric.common.oea.foundation.animation.a.b.a(d.a(d.f36236a, (View) ZeusTransformUtils.preCheckCast(r0.getRootContainer(), View.class, "com.obric.aiagent.plugin"), r0.windowForAnim(), r0.getDimView(), r0.needDimAnim(), r0.useWindowDim(), r18, new $$Lambda$a$a$BJat3QW3bCBZSnIharfELGJygA(r0), null, 64, null).a((m) ZeusTransformUtils.preCheckCast(new c(r0), m.class, "com.obric.aiagent.plugin")).b(), null, null, 3, null));
            r0.onDismissAnimStart();
        }

        private static void t(a r2) {
            a r3 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.aiagent.plugin");
            o.e(r3, "this$0");
            com.obric.common.oea.foundation.animation.manager.d r0 = r3.getRunningAnim();
            if (r0 == null) goto L6;
            r0.a(true);
        L6:
            r3.getRootContainer().setAlpha(0.0f);
        }

        public static void q(a r3) {
            a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin");
            o.e(r4, "this");
            if (ZeusTransformUtils.instanceOf(r4.getRootContainer().getBackground(), ColorDrawable.class) == false) goto L6;
            Drawable r0 = r4.getRootContainer().getBackground();
            Objects.requireNonNull(r0, "null cannot be cast to non-null type android.graphics.drawable.ColorDrawable");
            r4.setBgColor(((ColorDrawable) ZeusTransformUtils.preCheckCast(r0, ColorDrawable.class, "com.obric.aiagent.plugin")).getColor());
            return;
        L6:
            if (ZeusTransformUtils.instanceOf(r4.getRootContainer().getBackground(), GradientDrawable.class) == false) goto L14;
            Drawable r1 = r4.getRootContainer().getBackground();
            Objects.requireNonNull(r1, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
            ColorStateList r2 = ((GradientDrawable) ZeusTransformUtils.preCheckCast(r1, GradientDrawable.class, "com.obric.aiagent.plugin")).getColor();
            if (r2 != null) goto L10;
            int r5 = -1;
        L11:
            r4.setBgColor(r5);
            return;
        L10:
            r5 = r2.getDefaultColor();
            goto L11
        }

        public static void d(a r9, boolean r10) {
            a r11 = (a) ZeusTransformUtils.wrapperContextForParams(r9, a.class, "com.obric.aiagent.plugin");
            o.e(r11, "this");
            if (r11.getEnableMaterial() == false) goto L9;
            Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r11.getRootContainer().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
            com.obric.oui.material.c[] r3 = (com.obric.oui.material.c[]) ZeusTransformUtils.preCheckCast(MaterialToken.OUI_Bg_Modal.invoke(Boolean.valueOf(!r11.isDarkTheme())), com.obric.oui.material.c[].class, "com.obric.aiagent.plugin");
            r11.getRootContainer().setBackgroundColor(0);
            if (r10 == false) goto L7;
            k.a((View) ZeusTransformUtils.preCheckCast(r11.getRootContainer(), View.class, "com.obric.aiagent.plugin"), r3, false, null, 6, null);
            return;
        L7:
            k.a((View) ZeusTransformUtils.preCheckCast(r11.getRootContainer(), View.class, "com.obric.aiagent.plugin"), r3, false, 0, null, 14, null);
            return;
        }

        public static boolean r(a r2) {
            a r3 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.aiagent.plugin");
            o.e(r3, "this");
            if (r3.getBgColor() != 0) goto L7;
            return i.a((View) ZeusTransformUtils.preCheckCast(r3.getRootContainer(), View.class, "com.obric.aiagent.plugin"));
        L7:
            return com.obric.oui.color.d.a(r3.getBgColor());
        }
    }

    void calculateBodyMaxHeight();

    boolean getAutoAddBodyPaddingTopWhenOverlay();

    int getBgColor();

    FrameLayout getBodyContainer();

    int getBodyContentPaddingBottom();

    int getBodyContentPaddingTop();

    ComponentCallbacks getConfigurationCallback();

    boolean getConfigurationCallbackRegistered();

    View getDimView();

    boolean getEnableEnterAnim();

    boolean getEnableMaterial();

    FrameLayout getFooterContainer();

    Size getFullWindowSize();

    FrameLayout getHeaderContainer();

    OSheet.c getHeightStyle();

    boolean getIgnoreInsetBottom();

    RadiusLayout getRootContainer();

    float getRootTransMoveStartX();

    float getRootTransMoveStartY();

    com.obric.common.oea.foundation.animation.manager.d getRunningAnim();

    ViewGroup getScaffoldContainer();

    c getScaffoldController();

    Context getSheetContext();

    boolean getShowing();

    int getUserWindowHeight();

    int getUserWindowWidth();

    <T extends View> T getViewById(int r1);

    void initBgColor();

    boolean isContentOverlayMode();

    boolean isDarkTheme();

    boolean needDimAnim();

    void onDismissAnimEnd();

    void onDismissAnimStart();

    void onDismissComplete();

    void onPostShow();

    void onShowAnimEnd();

    void onShowAnimStart();

    void performExitAnimation(float r1);

    void setAutoAddBodyPaddingTopWhenOverlay(boolean r1);

    void setBgColor(int r1);

    void setBodyContainer(FrameLayout r1);

    void setBodyContentPaddingBottom(int r1);

    void setBodyContentPaddingTop(int r1);

    void setBodyView(View r1);

    void setConfigurationCallbackRegistered(boolean r1);

    void setFooterContainer(FrameLayout r1);

    void setFullWindowSize(Size r1);

    void setHeader(OSheet.b r1, Integer r2, Integer r3, String r4, String r5, boolean r6, View.OnClickListener r7, View.OnClickListener r8, Integer r9, Integer r10, String r11, String r12, Integer r13, Integer r14);

    void setHeaderContainer(FrameLayout r1);

    void setHeightStyle(OSheet.c r1);

    void setIgnoreInsetBottom(boolean r1);

    void setMCancelable(boolean r1);

    void setRootContainer(RadiusLayout r1);

    void setRootTransMoveStartX(float r1);

    void setRootTransMoveStartY(float r1);

    void setRunningAnim(com.obric.common.oea.foundation.animation.manager.d r1);

    void setScaffoldContainer(ViewGroup r1);

    void setScaffoldController(c r1);

    void setupDimView(Context r1);

    void updateFullWindowSize();

    void updateMaterial();

    boolean useWindowDim();

    Window windowForAnim();
}
