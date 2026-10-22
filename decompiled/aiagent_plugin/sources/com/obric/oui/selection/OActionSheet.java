package com.obric.oui.selection;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.aiagent.plugin.R;
import com.obric.oui.button.OButton;
import com.obric.oui.common.util.g;
import com.obric.oui.sheet.OInsetSheet;
import com.obric.oui.sheet.OInsetSheetTitleBar;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.x;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: OActionSheet.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OActionSheet extends OInsetSheet {
    public static final a Companion = null;
    private static final String TAG = "OSelectionSheet";

    /* JADX INFO: compiled from: OActionSheet.kt */
    public static final class a {

        /* JADX INFO: renamed from: com.obric.oui.selection.OActionSheet$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: OActionSheet.kt */
        public static final class C0987a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final OInsetSheet.b f36156a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final String f36157b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final String f36158c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private final d.h.a.a<x> f36159d;

            public C0987a(OInsetSheet.b r3, String r4, String r5, d.h.a.a<x> r6) {
                d.h.a.a<x> r7 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r6, d.h.a.a.class, "com.obric.aiagent.plugin");
                o.e(r3, "width");
                o.e(r4, DBDefinition.TITLE);
                this.f36156a = r3;
                this.f36157b = r4;
                this.f36158c = r5;
                this.f36159d = r7;
            }

            public /* synthetic */ C0987a(OInsetSheet.b r2, String r3, String r4, d.h.a.a r5, int r6, h r7) {
                d.h.a.a r8 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.a.class, "com.obric.aiagent.plugin");
                if ((r6 & 4) == 0) goto L5;
                r4 = null;
            L5:
                this(r2, r3, r4, r8);
            }

            public final OInsetSheet.b a() {
                return this.f36156a;
            }

            public final String b() {
                return this.f36157b;
            }

            public final String c() {
                return this.f36158c;
            }

            public final d.h.a.a<x> d() {
                return this.f36159d;
            }
        }

        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        Companion = new a(null);
    }

    public static /* synthetic */ int access$000(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$AYYcVverxokj1bvy8HzkNiBM49E(d.h.a.a r0, View r1) {
        m1165genHeaderView$lambda2$lambda1(r0, r1);
    }

    public OActionSheet(Context r5, a.C0987a r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        o.e(r7, "context");
        o.e(r6, "modifier");
        super(r7);
        setRootWidth(r6.a());
        setHeaderView(genHeaderView(r7, r6.b(), r6.c(), r6.d()));
        setClearDimFlag(false);
        getContentContainer().setPadding(g.a(r7, 16), g.a(r7, 4), g.a(r7, 16), g.a(r7, 16));
        getFooterContainer().setVisibility(8);
    }

    @Override // com.obric.oui.sheet.OInsetSheet, android.app.Dialog
    public void show() {
        super.show();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        INVOKESTATIC_com_obric_oui_selection_OActionSheet_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "show failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.oui.sheet.OInsetSheet, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        INVOKESTATIC_com_obric_oui_selection_OActionSheet_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "dismiss failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    }

    static /* synthetic */ View genHeaderView$default(OActionSheet r1, Context r2, String r3, String r4, d.h.a.a r5, int r6, Object r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        d.h.a.a<x> r9 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.a.class, "com.obric.aiagent.plugin");
        if ((r6 & 8) == 0) goto L6;
        r9 = null;
    L6:
        return r1.genHeaderView(r8, r3, r4, r9);
    }

    private final View genHeaderView(Context r9, String r10, String r11, d.h.a.a<x> r12) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        final d.h.a.a r13 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r12, d.h.a.a.class, "com.obric.aiagent.plugin");
        LinearLayout r14 = new LinearLayout(r8);
        r14.setOrientation(1);
        r14.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new LinearLayout.LayoutParams(-1, -2), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        OInsetSheetTitleBar r7 = new OInsetSheetTitleBar(r8, null, 0, 6, null);
        r7.setTitleText(r10);
        r7.setShowLeftBack(false);
        OButton r15 = r7.createUnderstatedButton(r8, (ViewGroup) ZeusTransformUtils.preCheckCast(r7.getMRightContainer(), ViewGroup.class, "com.obric.aiagent.plugin"));
        r15.setButtonSourceBitmap(ZeusTransformUtils.mapRes(R.drawable.o_ic_xmark_fill, "drawable", "o_ic_xmark_fill"), r8.getColor(ZeusTransformUtils.mapRes(R.color.oui_basic_text_4, "color", "oui_basic_text_4")));
        r15.setOnClickListener(new $$Lambda$OActionSheet$AYYcVverxokj1bvy8HzkNiBM49E(r13));
        r14.addView((View) ZeusTransformUtils.preCheckCast(r7, View.class, "com.obric.aiagent.plugin"));
        r7.setDesText(r11);
        return (View) ZeusTransformUtils.preCheckCast(r14, View.class, "com.obric.aiagent.plugin");
    }

    /* JADX INFO: renamed from: genHeaderView$lambda-2$lambda-1, reason: not valid java name */
    private static final void m1165genHeaderView$lambda2$lambda1(d.h.a.a r1, View r2) {
        d.h.a.a r3 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r1, d.h.a.a.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L7;
        r3.invoke();
        return;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_oui_selection_OActionSheet_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
