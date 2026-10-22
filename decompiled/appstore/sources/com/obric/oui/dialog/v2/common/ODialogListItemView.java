package com.obric.oui.dialog.v2.common;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.j;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.layout.OUILinearLayout;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.b;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tc.f;
import tc.l;
import td.c;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000e\u001a\u00020\b*\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ/\u0010\u0016\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001c\u0010\u001bJ\u0017\u0010\u001e\u001a\u00020\b2\b\u0010\u001d\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010 \u001a\u00020\b2\b\u0010\u001d\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b \u0010\u001fJ\u0015\u0010\"\u001a\u00020\b2\u0006\u0010!\u001a\u00020\u0012¢\u0006\u0004\b\"\u0010#J\u001d\u0010$\u001a\u00020\b2\u0006\u0010!\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b$\u0010%J\u0017\u0010(\u001a\u00020\b2\b\u0010'\u001a\u0004\u0018\u00010&¢\u0006\u0004\b(\u0010)J\u0017\u0010,\u001a\u00020\u00182\u0006\u0010+\u001a\u00020*H\u0016¢\u0006\u0004\b,\u0010-J\u0017\u0010/\u001a\u00020\b2\u0006\u0010.\u001a\u00020\u0018H\u0016¢\u0006\u0004\b/\u0010\u001bJ\u000f\u00100\u001a\u00020\u0018H\u0016¢\u0006\u0004\b0\u00101R\"\u00109\u001a\u0002028\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\"\u0010@\u001a\u00020:8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0016\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\"\u0010C\u001a\u00020:8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b$\u0010;\u001a\u0004\bA\u0010=\"\u0004\bB\u0010?R\"\u0010I\u001a\u00020\u000b8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u001c\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\"\u0010L\u001a\u00020\u000b8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u001a\u0010D\u001a\u0004\bJ\u0010F\"\u0004\bK\u0010HR\u0016\u0010N\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010MR\u001b\u0010T\u001a\u00020O8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010SR\u001b\u0010W\u001a\u00020O8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bU\u0010Q\u001a\u0004\bV\u0010S¨\u0006X"}, d2 = {"Lcom/obric/oui/dialog/v2/common/ODialogListItemView;", "Lcom/obric/oui/layout/OUIFrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "init", "(Landroid/content/Context;)V", "Landroid/widget/TextView;", "", "text", "f", "(Landroid/widget/TextView;Ljava/lang/CharSequence;)V", "Landroid/view/ViewGroup;", "parent", "Landroid/view/View;", "child", "Landroid/view/ViewGroup$LayoutParams;", "layoutParams", "b", "(Landroid/view/ViewGroup;Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V", "", "show", "e", "(Z)V", "d", "str", "setTitle", "(Ljava/lang/CharSequence;)V", "setSubtitle", "view", "setTrailingView", "(Landroid/view/View;)V", "c", "(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V", "Landroid/graphics/drawable/Drawable;", "drawable", "setTrailingImageView", "(Landroid/graphics/drawable/Drawable;)V", "Landroid/view/MotionEvent;", "event", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "selected", "setSelected", "shouldUpdateDividerColorOnPress", "()Z", "Lcom/obric/oui/layout/OUILinearLayout;", "a", "Lcom/obric/oui/layout/OUILinearLayout;", "getListItemRoot", "()Lcom/obric/oui/layout/OUILinearLayout;", "setListItemRoot", "(Lcom/obric/oui/layout/OUILinearLayout;)V", "listItemRoot", "Landroid/widget/FrameLayout;", "Landroid/widget/FrameLayout;", "getLeadingContainer", "()Landroid/widget/FrameLayout;", "setLeadingContainer", "(Landroid/widget/FrameLayout;)V", "leadingContainer", "getTrailingContainer", "setTrailingContainer", "trailingContainer", "Landroid/widget/TextView;", "getTitleView", "()Landroid/widget/TextView;", "setTitleView", "(Landroid/widget/TextView;)V", "titleView", "getSubtitleView", "setSubtitleView", "subtitleView", "Z", "isShowDivider", "", "g", "Lkotlin/Lazy;", "getLineColor", "()I", "lineColor", "h", "getLineHeight", "lineHeight", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class ODialogListItemView extends OUIFrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public OUILinearLayout f14487a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FrameLayout f14488b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public FrameLayout f14489c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f14490d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f14491e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f14492f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f14493g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f14494h;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f14495a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ODialogListItemView f14496b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f14497c;

        public a(View r10, ODialogListItemView r11, boolean r12) {
            this.f14495a = r10;
            this.f14496b = r11;
            this.f14497c = r12;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ODialogListItemView.a(this.f14496b, this.f14497c);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public ODialogListItemView(@NotNull Context r10) {
        q.g(r10, "context");
        this(r10, null, 2, 0 == true ? 1 : 0);
    }

    public static final /* synthetic */ void a(ODialogListItemView r10, boolean r11) {
        r10.e(r11);
    }

    private final void b(ViewGroup r10, View r11, ViewGroup.LayoutParams r12) {
        if (r11 == null) goto L16;
        if (r10 == null) goto L6;
        l.m(r10);
    L6:
        if (r10 == null) goto L9;
        r10.removeAllViews();
    L9:
        if (r12 != null) goto L13;
        if (r10 == null) goto L22;
        r10.addView(r11);
        return;
    L22:
        return;
    L13:
        if (r10 == null) goto L23;
        r10.addView(r11, r12);
        return;
    L23:
        return;
    L16:
        if (r10 == null) goto L24;
        l.k(r10);
        return;
    }

    private final int getLineColor() {
        return ((Number) this.f14493g.getValue()).intValue();
    }

    private final int getLineHeight() {
        return ((Number) this.f14494h.getValue()).intValue();
    }

    public final void c(View r10, ViewGroup.LayoutParams r11) {
        q.g(r10, "view");
        q.g(r11, "layoutParams");
        b(getTrailingContainer(), r10, r11);
    }

    public final void d(boolean r10) {
        this.f14492f = r10;
        getLeadingContainer().measure(0, 0);
        q.f(j.a(this, new a(this, this, r10)), "OneShotPreDrawListener.add(this) { action(this) }");
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r10) {
        q.g(r10, "event");
        if (isEnabled() == true) goto L7;
        return false;
    L7:
        return super.dispatchTouchEvent(r10);
    }

    public final void e(boolean r10) {
        if (r10 == false) goto L5;
        updateBottomDivider(getListItemRoot().getPaddingLeft() + getLeadingContainer().getMeasuredWidth(), 0, getLineHeight(), getLineColor());
        return;
    L5:
        updateBottomDivider(getListItemRoot().getPaddingLeft(), 0, 0, getLineColor());
    }

    public final void f(TextView r10, CharSequence r11) {
        if (r11 != null) goto L4;
    L7:
        l.k(r10);
        return;
    L4:
        if (r11.length() == 0) goto L7;
        r10.setText(r11);
        l.m(r10);
    }

    @NotNull
    public final FrameLayout getLeadingContainer() {
        FrameLayout r10 = this.f14488b;
        if (r10 == null) goto L5;
        return r10;
    L5:
        q.y("leadingContainer");
        return null;
    }

    @NotNull
    public final OUILinearLayout getListItemRoot() {
        OUILinearLayout r10 = this.f14487a;
        if (r10 == null) goto L5;
        return r10;
    L5:
        q.y("listItemRoot");
        return null;
    }

    @NotNull
    public final TextView getSubtitleView() {
        TextView r10 = this.f14491e;
        if (r10 == null) goto L5;
        return r10;
    L5:
        q.y("subtitleView");
        return null;
    }

    @NotNull
    public final TextView getTitleView() {
        TextView r10 = this.f14490d;
        if (r10 == null) goto L5;
        return r10;
    L5:
        q.y("titleView");
        return null;
    }

    @NotNull
    public final FrameLayout getTrailingContainer() {
        FrameLayout r10 = this.f14489c;
        if (r10 == null) goto L5;
        return r10;
    L5:
        q.y("trailingContainer");
        return null;
    }

    public final void init(Context r10) {
        LayoutInflater.from(r10).inflate(R$layout.o_dialog_listitem_view, this);
        View r11 = findViewById(R$id.list_item_root);
        q.f(r11, "findViewById(R.id.list_item_root)");
        setListItemRoot((OUILinearLayout) r11);
        c r12 = c.f24796a;
        OUILinearLayout r13 = getListItemRoot();
        if (r13 != null) goto L6;
        r13 = null;
    L6:
        if (r13 == null) goto L9;
        r13.setChangeAlphaWhenPress(false);
    L9:
        View r14 = findViewById(R$id.list_item_title);
        q.f(r14, "findViewById(R.id.list_item_title)");
        setTitleView((TextView) r14);
        View r15 = findViewById(R$id.list_item_subtitle);
        q.f(r15, "findViewById(R.id.list_item_subtitle)");
        setSubtitleView((TextView) r15);
        View r16 = findViewById(R$id.list_leading_element);
        q.f(r16, "findViewById(R.id.list_leading_element)");
        setLeadingContainer((FrameLayout) r16);
        View r17 = findViewById(R$id.list_trailing_element);
        q.f(r17, "findViewById(R.id.list_trailing_element)");
        setTrailingContainer((FrameLayout) r17);
        setRadius(f.r(this, 12));
        setChangeAlphaWhenDisable(false);
    }

    public final void setLeadingContainer(@NotNull FrameLayout r10) {
        q.g(r10, "<set-?>");
        this.f14488b = r10;
    }

    public final void setListItemRoot(@NotNull OUILinearLayout r10) {
        q.g(r10, "<set-?>");
        this.f14487a = r10;
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.View
    public void setSelected(boolean r10) {
        super.setSelected(r10);
        getAlphaHelper().onSelectedChanged(this, r10);
    }

    public final void setSubtitle(@Nullable CharSequence r10) {
        f(getSubtitleView(), r10);
    }

    public final void setSubtitleView(@NotNull TextView r10) {
        q.g(r10, "<set-?>");
        this.f14491e = r10;
    }

    public final void setTitle(@Nullable CharSequence r10) {
        f(getTitleView(), r10);
    }

    public final void setTitleView(@NotNull TextView r10) {
        q.g(r10, "<set-?>");
        this.f14490d = r10;
    }

    public final void setTrailingContainer(@NotNull FrameLayout r10) {
        q.g(r10, "<set-?>");
        this.f14489c = r10;
    }

    public final void setTrailingImageView(@Nullable Drawable r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        ImageView r11 = new ImageView(getContext());
        r11.setImageDrawable(r10);
        setTrailingView(r11);
    }

    public final void setTrailingView(@NotNull View r10) {
        q.g(r10, "view");
        FrameLayout.LayoutParams r11 = new FrameLayout.LayoutParams(-2, -2);
        r11.gravity = 17;
        b(getTrailingContainer(), r10, r11);
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, com.obric.oui.common.style.IOUILayout
    public boolean shouldUpdateDividerColorOnPress() {
        return true;
    }

    public /* synthetic */ ODialogListItemView(Context r10, AttributeSet r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = null;
    L5:
        this(r10, r11);
    }

    @JvmOverloads
    public ODialogListItemView(@NotNull final Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        super(r10, r11, 0, null, 12, null);
        this.f14493g = b.b(new ODialogListItemView$lineColor$2(r10));
        this.f14494h = b.b(new ODialogListItemView$lineHeight$2(this));
        init(r10);
    }
}
