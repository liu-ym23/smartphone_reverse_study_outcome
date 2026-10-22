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
import com.obric.common.oui.R$attr;
import com.obric.common.oui.R$dimen;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.oui.divider.ODivider;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tc.f;
import tc.l;

/* JADX INFO: loaded from: classes4.dex */
public class a extends b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AppCompatImageView f15888g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TextView f15889h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ImageView f15890i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ODivider f15891j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final View f15892k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final View f15893l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final View f15894m;

    /* JADX INFO: renamed from: com.obric.oui.panel.header.a$a, reason: collision with other inner class name */
    public static final class ViewOnAttachStateChangeListenerC0204a implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f15895a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f15896b;

        public ViewOnAttachStateChangeListenerC0204a(View r10, a r11) {
            this.f15895a = r10;
            this.f15896b = r11;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View r10) {
            q.g(r10, "view");
            this.f15895a.removeOnAttachStateChangeListener(this);
            int r11 = f.r(r10, 44);
            l.g(a.h(this.f15896b), r11, r11, new View[]{a.f(this.f15896b), a.g(this.f15896b)});
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View r10) {
            q.g(r10, "view");
        }
    }

    public a(Context r10, View.OnClickListener r11, CharSequence r12, boolean r13) {
        q.g(r10, "context");
        super(r10, r13, 0, 4, null);
        View r14 = View.inflate(b.b(this, r10, false, 2, null), R$layout.o_basic_panel_normal_header, null);
        q.f(r14, "inflate(generateThemedCo…anel_normal_header, null)");
        this.f15894m = r14;
        int r15 = tc.a.f24778a.b(d(), R$attr.oui_PanelDefaultHeaderHeight, R$dimen.oui_panel_default_header_height);
        r14.setBackgroundColor(0);
        View r16 = r14.findViewById(R$id.iv_close);
        q.f(r16, "rootView.findViewById(R.id.iv_close)");
        this.f15888g = (AppCompatImageView) r16;
        View r17 = r14.findViewById(R$id.tv_title);
        q.f(r17, "rootView.findViewById(R.id.tv_title)");
        this.f15889h = (TextView) r17;
        View r18 = r14.findViewById(R$id.iv_back);
        q.f(r18, "rootView.findViewById(R.id.iv_back)");
        this.f15890i = (ImageView) r18;
        View r19 = r14.findViewById(R$id.divider);
        q.f(r19, "rootView.findViewById(R.id.divider)");
        this.f15891j = (ODivider) r19;
        View r20 = r14.findViewById(R$id.grabber);
        q.f(r20, "rootView.findViewById(R.id.grabber)");
        this.f15892k = r20;
        View r21 = r14.findViewById(R$id.main_view);
        q.f(r21, "rootView.findViewById(R.id.main_view)");
        this.f15893l = r21;
        ViewGroup.LayoutParams r22 = r21.getLayoutParams();
        if (r22 == null) goto L16;
        r22.height = r15;
        r21.setLayoutParams(r22);
        if (r11 == null) goto L8;
        setOnCloseClickListener(r11);
    L8:
        if (TextUtils.isEmpty(r12) == true) goto L11;
        q.d(r12);
        j(this, r12, null, null, 6, null);
    L11:
        if (ViewCompat.S(r14) == false) goto L13;
        int r23 = f.r(r14, 44);
        l.g(h(this), r23, r23, new View[]{f(this), g(this)});
        return;
    L13:
        r14.addOnAttachStateChangeListener(new ViewOnAttachStateChangeListenerC0204a(r14, this));
        return;
    L16:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    public static final /* synthetic */ ImageView f(a r10) {
        return r10.f15890i;
    }

    public static final /* synthetic */ AppCompatImageView g(a r10) {
        return r10.f15888g;
    }

    public static final /* synthetic */ View h(a r10) {
        return r10.f15894m;
    }

    public static /* synthetic */ void j(a r10, CharSequence r11, Drawable r12, Boolean r13, int r14, Object r15) {
        if (r15 != null) goto L12;
        if ((r14 & 2) == 0) goto L7;
        r12 = null;
    L7:
        if ((r14 & 4) == 0) goto L9;
        r13 = Boolean.FALSE;
    L9:
        r10.i(r11, r12, r13);
        return;
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setTitle");
    }

    @Override // com.obric.oui.panel.header.b
    public View e() {
        return this.f15894m;
    }

    public final void i(CharSequence r10, Drawable r11, Boolean r12) {
        q.g(r10, "charSequence");
        this.f15889h.setText(r10);
        if (r11 == null) goto L6;
        r11.setBounds(0, 0, 70, 70);
    L6:
        this.f15889h.setCompoundDrawables(r11, null, null, null);
        if (q.b(r12, Boolean.TRUE) == false) goto L10;
        this.f15889h.setTypeface(Typeface.defaultFromStyle(1));
        return;
    }

    public final void setOnCloseClickListener(@Nullable View.OnClickListener r10) {
        AppCompatImageView r11 = this.f15888g;
        l.c(r11, f.r(r11, 44));
        this.f15888g.setOnClickListener(r10);
    }

    public final void showBackBtn(@NotNull View.OnClickListener r10) {
        q.g(r10, "listener");
        l.m(this.f15890i);
        this.f15889h.setGravity(17);
        this.f15890i.setOnClickListener(r10);
    }

    public /* synthetic */ a(Context r10, View.OnClickListener r11, CharSequence r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = null;
    L8:
        this(r10, r11, r12);
    }

    public a(Context r10, View.OnClickListener r11, CharSequence r12) {
        q.g(r10, "context");
        this(r10, r11, r12, false);
    }
}
