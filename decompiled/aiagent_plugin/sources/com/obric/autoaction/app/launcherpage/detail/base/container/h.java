package com.obric.autoaction.app.launcherpage.detail.base.container;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.app.launcherpage.condition.config.condition.AutoCondition;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.sectiontitlebar.OSectionSupportiveText;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: compiled from: DetailInstructInfoViewContainer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h extends z<g> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f23320a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.obric.autoaction.app.launcherpage.a.g f23321b;

    public h() {
        this(false, 1, null);
    }

    /* JADX INFO: renamed from: lambda$2Ixh8e7Qa1vuwytpl-CFur5oH0o, reason: not valid java name */
    public static /* synthetic */ void m480lambda$2Ixh8e7Qa1vuwytplCFur5oH0o(h r0, View r1) {
        a(r0, r1);
    }

    public /* synthetic */ h(boolean r1, int r2, d.h.b.h r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = false;
    L5:
        this(r1);
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.container.z
    public /* synthetic */ com.obric.autoaction.app.launcherpage.detail.base.f b(com.obric.autoaction.app.launcherpage.detail.base.a r2) {
        return (com.obric.autoaction.app.launcherpage.detail.base.f) ZeusTransformUtils.preCheckCast(a(r2), com.obric.autoaction.app.launcherpage.detail.base.f.class, "com.obric.aiagent.plugin");
    }

    public h(boolean r1) {
        this.f23320a = r1;
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.container.z
    public View a(ViewGroup r4) {
        d.h.b.o.e(r4, "parent");
        com.obric.autoaction.app.launcherpage.a.g r5 = com.obric.autoaction.app.launcherpage.a.g.a(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), r4, false);
        d.h.b.o.c(r5, "inflate(...)");
        this.f23321b = r5;
        if (r5 != null) goto L5;
        d.h.b.o.c("binding");
        r5 = null;
    L5:
        LinearLayout r3 = r5.b();
        d.h.b.o.c(r3, "getRoot(...)");
        return (View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.aiagent.plugin");
    }

    public g a(com.obric.autoaction.app.launcherpage.detail.base.a r1) {
        d.h.b.o.e(r1, "context");
        return i.a(r1.c().a(), r1.c().d());
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.container.z
    public void b() {
        a((g) ZeusTransformUtils.preCheckCast(f(), g.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.container.z
    public void a() {
        i();
    }

    private final void a(g r15) {
        com.obric.autoaction.app.launcherpage.a.g r0 = this.f23321b;
        com.obric.autoaction.app.launcherpage.a.g r2 = null;
        if (r0 != null) goto L5;
        d.h.b.o.c("binding");
        r0 = null;
    L5:
        r0.f22818b.setTitle((CharSequence) ZeusTransformUtils.preCheckCast(r15.b(), CharSequence.class, "com.obric.aiagent.plugin"));
        com.obric.autoaction.app.launcherpage.a.g r1 = this.f23321b;
        if (r1 != null) goto L8;
        d.h.b.o.c("binding");
        r1 = null;
    L8:
        Context r3 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r1.b().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (r15.a() == 3) goto L11;
        List<AutoCondition> r16 = r15.c();
        d.h.b.o.a(r3);
        CharSequence r17 = (CharSequence) ZeusTransformUtils.preCheckCast(com.obric.autoaction.app.launcherpage.condition.a.a.a(r16, r3), CharSequence.class, "com.obric.aiagent.plugin");
    L24:
        com.obric.autoaction.app.launcherpage.a.g r4 = this.f23321b;
        if (r4 != null) goto L27;
        d.h.b.o.c("binding");
        r4 = null;
    L27:
        r4.f22818b.getTitleView().setTextAppearance(ZeusTransformUtils.mapRes(R.style.Title_1_Regular, "style", "Title_1_Regular"));
        com.obric.autoaction.app.launcherpage.a.g r5 = this.f23321b;
        if (r5 != null) goto L30;
        d.h.b.o.c("binding");
        r5 = null;
    L30:
        r5.f22818b.getSubTitleView().setTextAppearance(ZeusTransformUtils.mapRes(R.style.Subtitle_3_Regular, "style", "Subtitle_3_Regular"));
        com.obric.autoaction.app.launcherpage.a.g r6 = this.f23321b;
        if (r6 != null) goto L33;
        d.h.b.o.c("binding");
        r6 = null;
    L33:
        r6.f22818b.getSubTitleView().setLineSpacing(3.0f, 1.1f);
        com.obric.autoaction.app.launcherpage.a.g r7 = this.f23321b;
        if (r7 != null) goto L36;
        d.h.b.o.c("binding");
        r7 = null;
    L36:
        OCardListItem r8 = r7.f22818b;
        int r9 = ZeusTransformUtils.mapRes(R.color.oui_basic_text_1, "color", "oui_basic_text_1");
        com.obric.autoaction.app.launcherpage.a.g r10 = this.f23321b;
        if (r10 != null) goto L39;
        d.h.b.o.c("binding");
        r10 = null;
    L39:
        Context r11 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r10.b().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.c(r11, "getContext(...)");
        int r12 = com.obric.autoaction.app.launcherpage.utils.p.b(r9, r11, null, 2, null);
        int r13 = ZeusTransformUtils.mapRes(R.color.oui_basic_text_3, "color", "oui_basic_text_3");
        com.obric.autoaction.app.launcherpage.a.g r14 = this.f23321b;
        if (r14 != null) goto L42;
        d.h.b.o.c("binding");
        r14 = null;
    L42:
        Context r18 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r14.b().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.c(r18, "getContext(...)");
        r8.setTitleColor(r12, com.obric.autoaction.app.launcherpage.utils.p.b(r13, r18, null, 2, null));
        com.obric.autoaction.app.launcherpage.a.g r19 = this.f23321b;
        if (r19 != null) goto L45;
        d.h.b.o.c("binding");
        r19 = null;
    L45:
        r19.f22818b.setSubTitle(r17);
        com.obric.autoaction.app.launcherpage.a.g r110 = this.f23321b;
        if (r110 != null) goto L48;
        d.h.b.o.c("binding");
        r110 = null;
    L48:
        com.obric.autoaction.app.launcherpage.utils.p.a((View) ZeusTransformUtils.preCheckCast(r110.f22818b.getSubTitleView(), View.class, "com.obric.aiagent.plugin"), 0, d.i.a.a(TypedValue.applyDimension(1, 12, Resources.getSystem().getDisplayMetrics())), 0, 0, 13, null);
        com.obric.autoaction.app.launcherpage.a.g r111 = this.f23321b;
        if (r111 != null) goto L51;
        d.h.b.o.c("binding");
        r111 = null;
    L51:
        r111.f22818b.showSubTitle(true);
        if (this.f23320a == false) goto L58;
        com.obric.autoaction.app.launcherpage.a.g r112 = this.f23321b;
        if (r112 != null) goto L56;
        d.h.b.o.c("binding");
    L57:
        OSectionSupportiveText r113 = r2.f22817a;
        d.h.b.o.c(r113, "bottomTip");
        com.obric.oui.common.util.k.a((View) ZeusTransformUtils.preCheckCast(r113, View.class, "com.obric.aiagent.plugin"));
        return;
    L56:
        r2 = r112;
        goto L57
    L58:
        com.obric.autoaction.app.launcherpage.a.g r114 = this.f23321b;
        if (r114 != null) goto L61;
        d.h.b.o.c("binding");
    L62:
        OSectionSupportiveText r115 = r2.f22817a;
        d.h.b.o.c(r115, "bottomTip");
        com.obric.oui.common.util.k.b((View) ZeusTransformUtils.preCheckCast(r115, View.class, "com.obric.aiagent.plugin"));
        return;
    L61:
        r2 = r114;
        goto L62
    L11:
        if (r15.e() == false) goto L21;
        CharSequence r20 = (CharSequence) ZeusTransformUtils.preCheckCast(r15.d(), CharSequence.class, "com.obric.aiagent.plugin");
        if (r20 != null) goto L15;
    L18:
        boolean r21 = true;
    L19:
        if (r21 == true) goto L21;
        String r116 = r3.getString(ZeusTransformUtils.mapRes(R.string.detail_shortcut_prefix, WsChannelMultiProcessSharedProvider.STRING_TYPE, "detail_shortcut_prefix"), new Object[]{r15.d()});
    L22:
        d.h.b.o.a(r116);
        r17 = (CharSequence) ZeusTransformUtils.preCheckCast(r116, CharSequence.class, "com.obric.aiagent.plugin");
        goto L24
    L15:
        if (r20.length() == 0) goto L18;
        r21 = false;
    L21:
        r116 = r3.getString(ZeusTransformUtils.mapRes(R.string.detail_shortcut_undefined, WsChannelMultiProcessSharedProvider.STRING_TYPE, "detail_shortcut_undefined"));
        goto L22
    }

    private final void i() {
        com.obric.autoaction.app.launcherpage.a.g r0 = this.f23321b;
        if (r0 != null) goto L5;
        d.h.b.o.c("binding");
        r0 = null;
    L5:
        r0.f22818b.setOnContentClickListener(new $$Lambda$h$2Ixh8e7Qa1vuwytplCFur5oH0o(this));
    }

    private static final void a(h r0, View r1) {
        com.obric.autoaction.app.launcherpage.detail.base.a r2 = r0.getContext();
        if (r2 == null) goto L8;
        com.obric.autoaction.app.launcherpage.detail.base.d r3 = r2.a();
        if (r3 == null) goto L9;
        r3.navigateToEditPage();
        return;
    L9:
        return;
    }
}
