package com.obric.oui.panel.header;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.view.ViewCompat;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.oui.common.util.g;
import com.obric.oui.common.util.k;
import com.obric.oui.divider.ODivider;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.Objects;

/* JADX INFO: compiled from: BasicPanelHeader.kt */
/* JADX INFO: loaded from: classes4.dex */
public class a extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AppCompatImageView f35912a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TextView f35913b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ImageView f35914c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ODivider f35915d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final View f35916e;
    private final View f;
    private final View g;

    public static final /* synthetic */ View a(a r0) {
        return r0.g;
    }

    public static final /* synthetic */ ImageView b(a r0) {
        return r0.f35914c;
    }

    public static final /* synthetic */ AppCompatImageView c(a r0) {
        return r0.f35912a;
    }

    public a(Context r10, View.OnClickListener r11, CharSequence r12, boolean r13) {
        Context r14 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        View.OnClickListener r15 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r11, View.OnClickListener.class, "com.obric.aiagent.plugin");
        CharSequence r16 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r12, CharSequence.class, "com.obric.aiagent.plugin");
        o.e(r14, "context");
        super(r14, r13, 0, 4, null);
        final View r17 = ZeusTransformUtils.inflate((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(c.a((c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.aiagent.plugin"), r14, false, 2, null), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.layout.o_basic_panel_normal_header, "layout", "o_basic_panel_normal_header"), null, "com.obric.aiagent.plugin");
        o.c(r17, "inflate(generateThemedCo…anel_normal_header, null)");
        this.g = r17;
        int r18 = com.obric.oui.common.util.b.f34567a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(c(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.attr.oui_PanelDefaultHeaderHeight, "attr", "oui_PanelDefaultHeaderHeight"), ZeusTransformUtils.mapRes(R.dimen.oui_panel_default_header_height, "dimen", "oui_panel_default_header_height"));
        r17.setBackgroundColor(0);
        View r2 = r17.findViewById(ZeusTransformUtils.mapRes(R.id.iv_close, DbHelper.COL_ID, "iv_close"));
        o.c(r2, "rootView.findViewById(R.id.iv_close)");
        this.f35912a = (AppCompatImageView) ZeusTransformUtils.preCheckCast(r2, AppCompatImageView.class, "com.obric.aiagent.plugin");
        View r3 = r17.findViewById(ZeusTransformUtils.mapRes(R.id.tv_title, DbHelper.COL_ID, "tv_title"));
        o.c(r3, "rootView.findViewById(R.id.tv_title)");
        this.f35913b = (TextView) ZeusTransformUtils.preCheckCast(r3, TextView.class, "com.obric.aiagent.plugin");
        View r4 = r17.findViewById(ZeusTransformUtils.mapRes(R.id.iv_back, DbHelper.COL_ID, "iv_back"));
        o.c(r4, "rootView.findViewById(R.id.iv_back)");
        this.f35914c = (ImageView) ZeusTransformUtils.preCheckCast(r4, ImageView.class, "com.obric.aiagent.plugin");
        View r5 = r17.findViewById(ZeusTransformUtils.mapRes(R.id.divider, DbHelper.COL_ID, "divider"));
        o.c(r5, "rootView.findViewById(R.id.divider)");
        this.f35915d = (ODivider) ZeusTransformUtils.preCheckCast(r5, ODivider.class, "com.obric.aiagent.plugin");
        View r6 = r17.findViewById(ZeusTransformUtils.mapRes(R.id.grabber, DbHelper.COL_ID, "grabber"));
        o.c(r6, "rootView.findViewById(R.id.grabber)");
        this.f35916e = r6;
        View r7 = r17.findViewById(ZeusTransformUtils.mapRes(R.id.main_view, DbHelper.COL_ID, "main_view"));
        o.c(r7, "rootView.findViewById(R.id.main_view)");
        this.f = r7;
        ViewGroup.LayoutParams r8 = r7.getLayoutParams();
        Objects.requireNonNull(r8, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        r8.height = r18;
        r7.setLayoutParams(r8);
        if (r15 == null) goto L6;
        a(r15);
    L6:
        if (TextUtils.isEmpty(r16) == true) goto L9;
        o.a(r16);
        a(this, r16, null, null, 6, null);
    L9:
        if (ViewCompat.I(r17) == false) goto L11;
        int r19 = g.a(r17, 44);
        k.a(a(this), r19, r19, new View[]{(View) ZeusTransformUtils.preCheckCast(b(this), View.class, "com.obric.aiagent.plugin"), (View) ZeusTransformUtils.preCheckCast(c(this), View.class, "com.obric.aiagent.plugin")});
        return;
    L11:
        r17.addOnAttachStateChangeListener((View.OnAttachStateChangeListener) ZeusTransformUtils.preCheckCast(new BasicPanelDefaultHeader$special$$inlined$doOnAttach$1(r17, this), View.OnAttachStateChangeListener.class, "com.obric.aiagent.plugin"));
    }

    public /* synthetic */ a(Context r2, View.OnClickListener r3, CharSequence r4, int r5, h r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        View.OnClickListener r8 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnClickListener.class, "com.obric.aiagent.plugin");
        CharSequence r9 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r9 = null;
    L8:
        this(r7, r8, r9);
    }

    public a(Context r3, View.OnClickListener r4, CharSequence r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        View.OnClickListener r7 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r4, View.OnClickListener.class, "com.obric.aiagent.plugin");
        CharSequence r8 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r5, CharSequence.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        this(r6, r7, r8, false);
    }

    public final void a(View.OnClickListener r5) {
        View.OnClickListener r6 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r5, View.OnClickListener.class, "com.obric.aiagent.plugin");
        k.a((View) ZeusTransformUtils.preCheckCast(this.f35912a, View.class, "com.obric.aiagent.plugin"), g.a((View) ZeusTransformUtils.preCheckCast(this.f35912a, View.class, "com.obric.aiagent.plugin"), 44));
        this.f35912a.setOnClickListener(r6);
    }

    public static /* synthetic */ void a(a r2, CharSequence r3, Drawable r4, Boolean r5, int r6, Object r7) {
        CharSequence r8 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L13;
        if ((r6 & 2) == 0) goto L8;
        r4 = null;
    L8:
        if ((r6 & 4) == 0) goto L10;
        r5 = false;
    L10:
        r2.a(r8, r4, r5);
        return;
    L13:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setTitle");
    }

    public final void a(CharSequence r3, Drawable r4, Boolean r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        o.e(r6, "charSequence");
        this.f35913b.setText(r6);
        if (r4 == null) goto L6;
        r4.setBounds(0, 0, 70, 70);
    L6:
        this.f35913b.setCompoundDrawables(r4, null, null, null);
        if (o.a(r5, true) == false) goto L10;
        this.f35913b.setTypeface(Typeface.defaultFromStyle(1));
        return;
    }

    @Override // com.obric.oui.panel.header.c
    public View a() {
        return this.g;
    }
}
