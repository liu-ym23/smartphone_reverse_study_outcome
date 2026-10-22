package com.obric.autoaction.presentation.doubao;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.widget.RemoteViews;
import com.obric.autogui.common.api.AOPackagesTools;
import com.obric.autogui.common.api.assistant.AssistCardBgResType;
import com.obric.autogui.common.api.assistant.AssistCardIdResType;
import com.obric.autogui.common.api.assistant.IAssistCardResourceProvider;
import com.obric.autogui.common.api.configs.AutoActionConfigs;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.l.n;
import org.json.JSONObject;

/* JADX INFO: compiled from: AssistWidgetBuilder.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f24853a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final RemoteViews f24854b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.obric.aiagent.assistant_card.provider_core.bean.c.a f24855c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final IAssistCardResourceProvider f24856d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f24857e;
    private int f;

    /* JADX INFO: renamed from: com.obric.autoaction.presentation.doubao.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AssistWidgetBuilder.kt */
    public static final class C0577a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f24858a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Integer f24859b;

        public C0577a(int r1, Integer r2) {
            this.f24858a = r1;
            this.f24859b = r2;
        }

        public /* synthetic */ C0577a(int r1, Integer r2, int r3, d.h.b.h r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = null;
        L5:
            this(r1, r2);
        }

        public final int getResources(boolean r1) {
            if (r1 == false) goto L8;
            Integer r2 = this.f24859b;
            if (r2 == null) goto L10;
            return r2.intValue();
        L10:
            return this.f24858a;
        L8:
            return this.f24858a;
        }
    }

    public a(Context r3, RemoteViews r4, com.obric.aiagent.assistant_card.provider_core.bean.c.a r5, IAssistCardResourceProvider r6, boolean r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        IAssistCardResourceProvider r9 = (IAssistCardResourceProvider) ZeusTransformUtils.wrapperContextForParams(r6, IAssistCardResourceProvider.class, "com.obric.aiagent.plugin");
        o.e(r8, "appContext");
        o.e(r4, "remoteViews");
        o.e(r5, "cardBuilder");
        o.e(r9, "resProvider");
        this.f24853a = ZeusTransformUtils.wrapperContext(r8, "com.obric.aiagent.plugin");
        this.f24854b = r4;
        this.f24855c = r5;
        this.f24856d = r9;
        this.f24857e = r7;
    }

    public final IAssistCardResourceProvider a() {
        return this.f24856d;
    }

    public final boolean b() {
        return this.f24857e;
    }

    public static /* synthetic */ void a(a r1, CharSequence r2, int r3, int r4, int r5, int r6, Object r7) {
        CharSequence r8 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.aiagent.plugin");
        if ((r6 & 2) == 0) goto L6;
        r3 = -6710887;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = 14;
    L9:
        if ((r6 & 8) == 0) goto L11;
        r5 = 0;
    L11:
        r1.a(r8, r3, r4, r5);
    }

    public final void a(CharSequence r4, int r5, int r6, int r7) {
        CharSequence r8 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.aiagent.plugin");
        o.e(r8, "text");
        this.f24854b.setTextViewTextSize(this.f24856d.getIdRes(AssistCardIdResType.STATUS_TEXT), 2, r6);
        this.f24854b.setTextColor(this.f24856d.getIdRes(AssistCardIdResType.STATUS_TEXT), r5);
        this.f24854b.setTextViewText(this.f24856d.getIdRes(AssistCardIdResType.STATUS_TEXT), e.a(r8, r7));
    }

    public static /* synthetic */ void b(a r2, CharSequence r3, int r4, int r5, int r6, int r7, Object r8) {
        CharSequence r9 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        if ((r7 & 2) == 0) goto L6;
        r4 = i.f24892a.a(r2.f24853a, h.h, r2.f24857e);
    L6:
        if ((r7 & 4) == 0) goto L9;
        r5 = 16;
    L9:
        if ((r7 & 8) == 0) goto L11;
        r6 = 1;
    L11:
        r2.b(r9, r4, r5, r6);
    }

    public final void b(CharSequence r4, int r5, int r6, int r7) {
        CharSequence r8 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.aiagent.plugin");
        o.e(r8, "text");
        this.f24854b.setTextViewTextSize(this.f24856d.getIdRes(AssistCardIdResType.CONTENT_TEXT), 2, r6);
        this.f24854b.setTextColor(this.f24856d.getIdRes(AssistCardIdResType.CONTENT_TEXT), r5);
        this.f24854b.setTextViewText(this.f24856d.getIdRes(AssistCardIdResType.CONTENT_TEXT), e.a(r8, r7));
    }

    public final void a(C0577a r4) {
        o.e(r4, "background");
        this.f24854b.setInt(this.f24856d.getIdRes(AssistCardIdResType.ROOT), "setBackgroundResource", r4.getResources(this.f24857e));
    }

    public final void b(C0577a r4) {
        o.e(r4, "icon");
        this.f24854b.setImageViewResource(this.f24856d.getIdRes(AssistCardIdResType.STATUS_ICON), r4.getResources(this.f24857e));
        this.f24854b.setViewVisibility(this.f24856d.getIdRes(AssistCardIdResType.APP_ICON), 8);
        this.f24854b.setViewVisibility(this.f24856d.getIdRes(AssistCardIdResType.STATUS_ICON), 0);
    }

    public final void a(String r5) {
        o.e(r5, "app");
        if (AutoActionConfigs.INSTANCE.getBooleanCfg("vlm.assistant.new_drawable", true) == false) goto L16;
        Drawable r0 = AOPackagesTools.INSTANCE.getAppIconDrawable(this.f24853a, r5);
        if (r0 == null) goto L15;
        Drawable r6 = e.a(r0, r5);
        if (r6 == null) goto L26;
        Bitmap r7 = com.obric.oui.common.util.c.a(r6);
        if (r7 == null) goto L27;
        float r1 = 20;
        Bitmap r8 = Bitmap.createScaledBitmap(r7, d.i.a.a(TypedValue.applyDimension(1, r1, Resources.getSystem().getDisplayMetrics())), d.i.a.a(TypedValue.applyDimension(1, r1, Resources.getSystem().getDisplayMetrics())), true);
        if (r8 == null) goto L28;
        Bitmap r9 = e.a(r8);
        if (r9 == null) goto L29;
    L24:
        this.f24854b.setViewVisibility(this.f24856d.getIdRes(AssistCardIdResType.APP_ICON), 0);
        this.f24854b.setViewVisibility(this.f24856d.getIdRes(AssistCardIdResType.STATUS_ICON), 8);
        this.f24854b.setImageViewBitmap(this.f24856d.getIdRes(AssistCardIdResType.APP_ICON), r9);
        return;
    L29:
        return;
    L28:
        return;
    L27:
        return;
    L26:
        return;
    L15:
        return;
    L16:
        Drawable r10 = AOPackagesTools.INSTANCE.getAppIconDrawable(this.f24853a, r5);
        if (r10 == null) goto L30;
        Bitmap r11 = com.obric.oui.common.util.c.a(r10);
        if (r11 == null) goto L31;
        float r2 = 20;
        Bitmap r12 = Bitmap.createScaledBitmap(r11, d.i.a.a(TypedValue.applyDimension(1, r2, Resources.getSystem().getDisplayMetrics())), d.i.a.a(TypedValue.applyDimension(1, r2, Resources.getSystem().getDisplayMetrics())), true);
        if (r12 == null) goto L32;
        r9 = e.a(r12);
        if (r9 != null) goto L24;
        return;
    L32:
        return;
    L31:
        return;
    }

    public static /* synthetic */ Integer a(a r8, C0577a r9, CharSequence r10, int r11, C0577a r12, String r13, JSONObject r14, boolean r15, int r16, Object r17) {
        CharSequence r2 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r10, CharSequence.class, "com.obric.aiagent.plugin");
        if ((r16 & 4) == 0) goto L5;
        int r3 = i.f24892a.a(r8.f24853a, h.f, r8.f24857e);
    L7:
        if ((r16 & 8) == 0) goto L9;
        C0577a r5 = new C0577a(r8.f24856d.getBackgroundRes(AssistCardBgResType.GREY, false), Integer.valueOf(r8.f24856d.getBackgroundRes(AssistCardBgResType.GREY, true)));
    L11:
        if ((r16 & 32) == 0) goto L13;
        JSONObject r6 = null;
    L15:
        if ((r16 & 64) == 0) goto L17;
        boolean r7 = true;
    L19:
        return r8.a(r9, r2, r3, r5, r13, r6, r7);
    L17:
        r7 = r15;
        goto L19
    L13:
        r6 = r14;
        goto L15
    L9:
        r5 = r12;
        goto L11
    L5:
        r3 = r11;
        goto L7
    }

    public final Integer a(C0577a r6, CharSequence r7, int r8, C0577a r9, String r10, JSONObject r11, boolean r12) {
        CharSequence r13 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r7, CharSequence.class, "com.obric.aiagent.plugin");
        o.e(r13, "text");
        o.e(r9, "background");
        o.e(r10, "actionName");
        int r0 = this.f + 1;
        this.f = r0;
        if (r0 <= 3) goto L7;
        return null;
    L7:
        if (r0 == 1) goto L11;
        if (r0 == 2) goto L10;
        int r1 = this.f24856d.getIdRes(AssistCardIdResType.BTN_3_ICON);
    L12:
        int r3 = this.f;
        if (r3 == 1) goto L17;
        if (r3 == 2) goto L16;
        int r4 = this.f24856d.getIdRes(AssistCardIdResType.BTN_3_TEXT);
    L18:
        int r5 = this.f;
        if (r5 == 1) goto L23;
        if (r5 == 2) goto L22;
        int r2 = this.f24856d.getIdRes(AssistCardIdResType.BTN_3);
    L24:
        if (r6 != null) goto L26;
        this.f24854b.setViewVisibility(r1, 8);
    L27:
        this.f24854b.setTextColor(r4, r8);
        this.f24854b.setTextViewText(r4, r13);
        this.f24854b.setInt(r2, "setBackgroundResource", r9.getResources(this.f24857e));
        if (r12 == false) goto L30;
        this.f24855c.a(r2, r10, r11);
    L32:
        return Integer.valueOf(r2);
    L30:
        this.f24854b.setTextColor(r4, a(r8, 0.3f));
        goto L32
    L26:
        this.f24854b.setViewVisibility(r1, 0);
        this.f24854b.setImageViewResource(r1, r6.getResources(this.f24857e));
        goto L27
    L22:
        r2 = this.f24856d.getIdRes(AssistCardIdResType.BTN_2);
        goto L24
    L23:
        r2 = this.f24856d.getIdRes(AssistCardIdResType.BTN_1);
        goto L24
    L16:
        r4 = this.f24856d.getIdRes(AssistCardIdResType.BTN_2_TEXT);
        goto L18
    L17:
        r4 = this.f24856d.getIdRes(AssistCardIdResType.BTN_1_TEXT);
        goto L18
    L10:
        r1 = this.f24856d.getIdRes(AssistCardIdResType.BTN_2_ICON);
        goto L12
    L11:
        r1 = this.f24856d.getIdRes(AssistCardIdResType.BTN_1_ICON);
        goto L12
    }

    public final int a(int r2, float r3) {
        return (((int) (n.a(r3, 0.0f, 1.0f) * 255)) << 24) | (r2 & 16777215);
    }

    public final RemoteViews c() {
        RemoteViews r0 = this.f24854b;
        int r1 = this.f24856d.getIdRes(AssistCardIdResType.BTN_1);
        int r4 = 8;
        if (this.f < 1) goto L5;
        int r2 = 0;
    L6:
        r0.setViewVisibility(r1, r2);
        RemoteViews r3 = this.f24854b;
        int r5 = this.f24856d.getIdRes(AssistCardIdResType.BTN_2);
        if (this.f < 2) goto L9;
        int r6 = 0;
    L10:
        r3.setViewVisibility(r5, r6);
        RemoteViews r7 = this.f24854b;
        int r8 = this.f24856d.getIdRes(AssistCardIdResType.BTN_3);
        if (this.f < 3) goto L13;
        r4 = 0;
    L13:
        r7.setViewVisibility(r8, r4);
        if (this.f != 1) goto L16;
        int r9 = -2;
    L17:
        this.f24854b.setViewLayoutWidth(this.f24856d.getIdRes(AssistCardIdResType.BTN_GROUP), r9, 0);
        return this.f24854b;
    L16:
        r9 = -1;
        goto L17
    L9:
        r6 = 8;
        goto L10
    L5:
        r2 = 8;
        goto L6
    }
}
