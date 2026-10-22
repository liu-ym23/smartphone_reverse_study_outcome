package com.obric.oui.selection;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.aiagent.plugin.R;
import com.obric.oui.button.OButton;
import com.obric.oui.common.util.g;
import com.obric.oui.sheet.OInsetSheet;
import com.obric.oui.sheet.OInsetSheetTitleBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.k;
import d.x;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: OSelectionSheet.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OSelectionSheet extends OInsetSheet {
    public static final a Companion = null;
    private static final String TAG = "OSelectionSheet";

    /* JADX INFO: compiled from: OSelectionSheet.kt */
    public static final class a {

        /* JADX INFO: renamed from: com.obric.oui.selection.OSelectionSheet$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: OSelectionSheet.kt */
        public static final class C0988a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final OInsetSheet.b f36164a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final String f36165b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final b f36166c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private final d.h.a.a<x> f36167d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            private final d.h.a.a<x> f36168e;

            public final OInsetSheet.b a() {
                return this.f36164a;
            }

            public final String b() {
                return this.f36165b;
            }

            public final b c() {
                return this.f36166c;
            }

            public final d.h.a.a<x> d() {
                return this.f36167d;
            }

            public final d.h.a.a<x> e() {
                return this.f36168e;
            }
        }

        /* JADX INFO: compiled from: OSelectionSheet.kt */
        public static final enum b extends Enum<b> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f36169a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final b f36170b = null;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private static final /* synthetic */ b[] f36171c = null;

            private static final /* synthetic */ b[] a() {
                return new b[]{f36169a, f36170b};
            }

            public static b valueOf(String r2) {
                return (b) ZeusTransformUtils.preCheckCast(Enum.valueOf(b.class, r2), b.class, "com.obric.aiagent.plugin");
            }

            public static b[] values() {
                return (b[]) ZeusTransformUtils.preCheckCast(f36171c.clone(), b[].class, "com.obric.aiagent.plugin");
            }

            private b(String r1, int r2) {
                super(r1, r2);
            }

            static {
                f36169a = new b("CLOSE_ONLY", 0);
                f36170b = new b("CLOSE_AND_CONFIRM", 1);
                f36171c = a();
            }
        }

        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: OSelectionSheet.kt */
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f36172a = null;

        static {
            int[] r0 = new int[a.b.values().length];
            r0[a.b.f36170b.ordinal()] = 1;
            r0[a.b.f36169a.ordinal()] = 2;
            f36172a = r0;
        }
    }

    static {
        Companion = new a(null);
    }

    public static /* synthetic */ int access$000(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$JFzSGkVXBrovWbfMdI47jLXNK2E(d.h.a.a r0, View r1) {
        m1167genHeaderView$lambda3$lambda1(r0, r1);
    }

    public static /* synthetic */ void lambda$QdzmqTjV4RdKDB9UpUTh9yYunKU(d.h.a.a r0, View r1) {
        m1169genHeaderView$lambda5$lambda4(r0, r1);
    }

    public static /* synthetic */ void lambda$dGlJ7Cmjy54Tq_WWXf8TKmfljUE(d.h.a.a r0, View r1) {
        m1168genHeaderView$lambda3$lambda2(r0, r1);
    }

    public OSelectionSheet(Context r7, a.C0988a r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r9, "context");
        o.e(r8, "modifier");
        super(r9);
        setRootWidth(r8.a());
        setHeaderView(genHeaderView(r9, r8.b(), r8.c(), r8.d(), r8.e()));
        setClearDimFlag(false);
        getContentContainer().setPadding(g.a(r9, 6), 0, g.a(r9, 6), g.a(r9, 6));
        getFooterContainer().setVisibility(8);
    }

    @Override // com.obric.oui.sheet.OInsetSheet, android.app.Dialog
    public void show() {
        super.show();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        INVOKESTATIC_com_obric_oui_selection_OSelectionSheet_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "show failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.oui.sheet.OInsetSheet, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        INVOKESTATIC_com_obric_oui_selection_OSelectionSheet_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "dismiss failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    }

    static /* synthetic */ View genHeaderView$default(OSelectionSheet r7, Context r8, String r9, a.b r10, d.h.a.a r11, d.h.a.a r12, int r13, Object r14) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
        d.h.a.a<x> r15 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r11, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.a.a<x> r16 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r12, d.h.a.a.class, "com.obric.aiagent.plugin");
        if ((r13 & 8) == 0) goto L5;
        d.h.a.a<x> r5 = null;
    L7:
        if ((r13 & 16) == 0) goto L9;
        d.h.a.a<x> r6 = null;
    L11:
        return r7.genHeaderView(r2, r9, r10, r5, r6);
    L9:
        r6 = r16;
        goto L11
    L5:
        r5 = r15;
        goto L7
    }

    private final View genHeaderView(Context r11, String r12, a.b r13, d.h.a.a<x> r14, d.h.a.a<x> r15) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.aiagent.plugin");
        final d.h.a.a r16 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r14, d.h.a.a.class, "com.obric.aiagent.plugin");
        final d.h.a.a r17 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r15, d.h.a.a.class, "com.obric.aiagent.plugin");
        int r18 = b.f36172a[r13.ordinal()];
        if (r18 != 1) goto L5;
        OInsetSheetTitleBar r19 = new OInsetSheetTitleBar(r10, null, 0, 6, null);
        r19.setTitleText(r12);
        r19.setShowLeftBack(false);
        OButton r110 = r19.createNeutralButton(r10, (ViewGroup) ZeusTransformUtils.preCheckCast(r19.getMLeftContainer(), ViewGroup.class, "com.obric.aiagent.plugin"));
        r110.setButtonSourceBitmap(ZeusTransformUtils.mapRes(R.drawable.o_ic_close, "drawable", "o_ic_close"));
        r110.setOnClickListener(new $$Lambda$OSelectionSheet$JFzSGkVXBrovWbfMdI47jLXNK2E(r16));
        OButton r111 = r19.createPrimaryLightButton(r10, (ViewGroup) ZeusTransformUtils.preCheckCast(r19.getMRightContainer(), ViewGroup.class, "com.obric.aiagent.plugin"));
        r111.setButtonSourceBitmap(ZeusTransformUtils.mapRes(R.drawable.o_ic_confirm, "drawable", "o_ic_confirm"), r10.getColor(ZeusTransformUtils.mapRes(R.color.oui_accent_7_fg, "color", "oui_accent_7_fg")));
        r111.setOnClickListener(new $$Lambda$OSelectionSheet$dGlJ7Cmjy54Tq_WWXf8TKmfljUE(r17));
        return (View) ZeusTransformUtils.preCheckCast(r19, View.class, "com.obric.aiagent.plugin");
    L5:
        if (r18 != 2) goto L8;
        OInsetSheetTitleBar r112 = new OInsetSheetTitleBar(r10, null, 0, 6, null);
        r112.setTitleText(r12);
        r112.setShowLeftBack(false);
        OButton r113 = r112.createUnderstatedButton(r10, (ViewGroup) ZeusTransformUtils.preCheckCast(r112.getMRightContainer(), ViewGroup.class, "com.obric.aiagent.plugin"));
        r113.setButtonSourceBitmap(ZeusTransformUtils.mapRes(R.drawable.o_ic_xmark_fill, "drawable", "o_ic_xmark_fill"), r10.getColor(ZeusTransformUtils.mapRes(R.color.oui_basic_text_4, "color", "oui_basic_text_4")));
        r113.setOnClickListener(new $$Lambda$OSelectionSheet$QdzmqTjV4RdKDB9UpUTh9yYunKU(r16));
        return (View) ZeusTransformUtils.preCheckCast(r112, View.class, "com.obric.aiagent.plugin");
    L8:
        throw new k();
    }

    /* JADX INFO: renamed from: genHeaderView$lambda-3$lambda-1, reason: not valid java name */
    private static final void m1167genHeaderView$lambda3$lambda1(d.h.a.a r1, View r2) {
        d.h.a.a r3 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r1, d.h.a.a.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L7;
        r3.invoke();
        return;
    }

    /* JADX INFO: renamed from: genHeaderView$lambda-3$lambda-2, reason: not valid java name */
    private static final void m1168genHeaderView$lambda3$lambda2(d.h.a.a r1, View r2) {
        d.h.a.a r3 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r1, d.h.a.a.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L7;
        r3.invoke();
        return;
    }

    /* JADX INFO: renamed from: genHeaderView$lambda-5$lambda-4, reason: not valid java name */
    private static final void m1169genHeaderView$lambda5$lambda4(d.h.a.a r1, View r2) {
        d.h.a.a r3 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r1, d.h.a.a.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L7;
        r3.invoke();
        return;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_oui_selection_OSelectionSheet_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
