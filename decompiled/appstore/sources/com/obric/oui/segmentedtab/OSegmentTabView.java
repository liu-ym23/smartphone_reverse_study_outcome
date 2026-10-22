package com.obric.oui.segmentedtab;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import bg.h;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.oui.utils.log.L;
import com.ttnet.org.chromium.net.PrivateKeyType;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 82\u00020\u0001:\u00019B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0015\u0010\u0014J\r\u0010\u0016\u001a\u00020\f¢\u0006\u0004\b\u0016\u0010\u0017J\u001d\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0006¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u0006¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010\u001f\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u001f\u0010\u000eJ\u000f\u0010 \u001a\u00020\nH\u0016¢\u0006\u0004\b \u0010!J\u001f\u0010#\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b#\u0010\u0014J\u0017\u0010$\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b$\u0010\u000eR\u0014\u0010'\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010)\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010(R\u0016\u0010+\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010(R\u0016\u0010\u001c\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010(R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00107\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106¨\u0006:"}, d2 = {"Lcom/obric/oui/segmentedtab/OSegmentTabView;", "Lcom/obric/oui/segmentedtab/OTouchAnimView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "isSelected", "", "o", "(Z)V", "", "fraction", "", "scene", "s", "(FLjava/lang/String;)V", "p", "m", "()V", "selectedTextColor", "unselectedTextColor", "n", "(II)V", "originIconAlpha", "setOriginIconAlpha", "(I)V", "q", "c", "()Z", "animFraction", "f", "r", "e", "Ljava/lang/String;", "TAG", "I", "textSelectColor", "g", "textUnselectColor", "h", "Landroid/widget/TextView;", "i", "Landroid/widget/TextView;", "tabTitle", "Landroid/widget/ImageView;", "j", "Landroid/widget/ImageView;", "iconView", "k", "Z", "selectState", "l", "a", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OSegmentTabView extends OTouchAnimView {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final a f16664l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static int f16665m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static Typeface f16666n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static Typeface f16667o;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f16668e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f16669f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f16670g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f16671h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TextView f16672i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ImageView f16673j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f16674k;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final Typeface a(Typeface r10, int r11) {
            q.g(r10, "typeface");
            if (OSegmentTabView.k() != null) goto L6;
            OSegmentTabView.l(Typeface.create(r10, r11, false));
        L6:
            return OSegmentTabView.k();
        }

        public final OSegmentTabView b(Context r10) {
            q.g(r10, "context");
            View r11 = RelativeLayout.inflate(r10, R$layout.o_layout_tab_segment, null);
            if (r11 == null) goto L7;
            OSegmentTabView r12 = (OSegmentTabView) r11;
            r12.m();
            return r12;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.segmentedtab.OSegmentTabView");
        }

        public a() {
        }
    }

    static {
        f16664l = new a(null);
    }

    @JvmOverloads
    public OSegmentTabView(@NotNull Context r10) {
        q.g(r10, "context");
        AttributeSet r11 = null;
        int r12 = 0;
        this(r10, r11, r12, 6, null);
    }

    public static final /* synthetic */ Typeface k() {
        return f16667o;
    }

    public static final /* synthetic */ void l(Typeface r10) {
        f16667o = r10;
    }

    private final void o(boolean r10) {
        ImageView r11 = null;
        if (r10 == true) goto L5;
        d();
        ImageView r12 = this.f16673j;
        if (r12 != null) goto L15;
        q.y("iconView");
    L16:
        r11.setImageAlpha(this.f16671h);
        return;
    L15:
        r11 = r12;
        goto L16
    L5:
        if (e() == true) goto L19;
        ImageView r13 = this.f16673j;
        if (r13 != null) goto L10;
        q.y("iconView");
    L11:
        r11.setImageAlpha(this.f16671h);
        return;
    L10:
        r11 = r13;
        goto L11
    }

    private final void p(float r10, String r11) {
        int r12 = h.k((int) (this.f16671h * OTouchAnimView.f16713d.a(r10)), 0, PrivateKeyType.INVALID);
        ImageView r13 = this.f16673j;
        if (r13 != null) goto L5;
        q.y("iconView");
        r13 = null;
    L5:
        r13.setImageAlpha(r12);
        L.a(this.f16668e, "updateIconAlphaOnPress, scene: " + r11 + ", fraction: " + r10 + ", alpha: " + r12 + ", originIconAlpha: " + this.f16671h);
    }

    private final void s(float r10, String r11) {
        if (q.b(r11, "press_anim") == false) goto L6;
        int r12 = this.f16670g;
    L12:
        if (r12 != 0) goto L14;
        return;
    L14:
        int r13 = (r12 >> 24) & PrivateKeyType.INVALID;
        int r14 = (r12 >> 16) & PrivateKeyType.INVALID;
        int r15 = (r12 >> 8) & PrivateKeyType.INVALID;
        int r16 = r12 & PrivateKeyType.INVALID;
        int r17 = h.k((int) (r13 * OTouchAnimView.f16713d.a(r10)), 0, PrivateKeyType.INVALID);
        int r18 = r16 | (((r17 << 24) | (r14 << 16)) | (r15 << 8));
        TextView r19 = this.f16672i;
        Typeface r20 = null;
        if (r19 != null) goto L17;
        q.y("tabTitle");
        r19 = null;
    L17:
        r19.setTextColor(r18);
        TextView r21 = this.f16672i;
        if (r21 != null) goto L21;
        q.y("tabTitle");
        r21 = null;
    L21:
        if (this.f16674k == true) goto L23;
    L29:
        Typeface r22 = f16666n;
        if (r22 != null) goto L32;
        q.y("DEFAULT_TYPE_FACE");
    L33:
        r21.setTypeface(r20);
        L.a(this.f16668e, "updateTextColorOnPress, scene: " + r11 + ", fraction: " + r10 + ", newTextAlpha: " + r17 + ", originTextAlpha: " + r13);
        return;
    L32:
        r20 = r22;
        goto L33
    L23:
        if (r10 != 0.0f) goto L29;
        a r23 = f16664l;
        Typeface r24 = f16666n;
        if (r24 != null) goto L27;
        q.y("DEFAULT_TYPE_FACE");
    L28:
        r20 = r23.a(r20, 500);
        goto L33
    L27:
        r20 = r24;
        goto L28
    L6:
        if (q.b(r11, "release_anim") == true) goto L8;
        r12 = 0;
        goto L12
    L8:
        if (this.f16674k == false) goto L10;
        r12 = this.f16669f;
        goto L12
    L10:
        r12 = this.f16670g;
        goto L12
    }

    @Override // com.obric.oui.segmentedtab.OTouchAnimView
    public boolean c() {
        return !this.f16674k;
    }

    @Override // com.obric.oui.segmentedtab.OTouchAnimView
    public void f(float r10, String r11) {
        q.g(r11, "scene");
        L.a(this.f16668e, "onTouchAnimUpdate, scene: " + r11 + ", animFraction: " + r10);
        s(r10, r11);
        p(r10, r11);
    }

    public final void m() {
        View r10 = findViewById(R$id.tv_tab_title);
        q.f(r10, "findViewById(R.id.tv_tab_title)");
        TextView r11 = (TextView) r10;
        this.f16672i = r11;
        if (r11 != null) goto L5;
        q.y("tabTitle");
        r11 = null;
    L5:
        Typeface r12 = r11.getTypeface();
        q.f(r12, "tabTitle.typeface");
        f16666n = r12;
        View r13 = findViewById(R$id.tv_tab_icon);
        q.f(r13, "findViewById(R.id.tv_tab_icon)");
        this.f16673j = (ImageView) r13;
    }

    public final void n(int r10, int r11) {
        this.f16669f = r10;
        this.f16670g = r11;
    }

    public final void q(boolean r10) {
        L.a(this.f16668e, q.p("updateSelectState, isSelected: ", Boolean.valueOf(r10)));
        this.f16674k = r10;
        setSelected(r10);
        r(r10);
        o(r10);
    }

    public final void r(boolean r10) {
        Typeface r11 = null;
        if (r10 == true) goto L5;
        d();
        TextView r12 = this.f16672i;
        if (r12 != null) goto L21;
        q.y("tabTitle");
        r12 = null;
    L21:
        r12.setTextColor(this.f16670g);
        TextView r13 = this.f16672i;
        if (r13 != null) goto L24;
        q.y("tabTitle");
        r13 = null;
    L24:
        Typeface r14 = f16666n;
        if (r14 != null) goto L27;
        q.y("DEFAULT_TYPE_FACE");
    L28:
        r13.setTypeface(r11);
        return;
    L27:
        r11 = r14;
        goto L28
    L5:
        if (e() == true) goto L31;
        TextView r15 = this.f16672i;
        if (r15 != null) goto L10;
        q.y("tabTitle");
        r15 = null;
    L10:
        r15.setTextColor(this.f16669f);
        TextView r16 = this.f16672i;
        if (r16 != null) goto L13;
        q.y("tabTitle");
        r16 = null;
    L13:
        a r17 = f16664l;
        Typeface r18 = f16666n;
        if (r18 != null) goto L16;
        q.y("DEFAULT_TYPE_FACE");
    L17:
        r16.setTypeface(r17.a(r11, 500));
        return;
    L16:
        r11 = r18;
        goto L17
    }

    public final void setOriginIconAlpha(int r10) {
        this.f16671h = r10;
    }

    @JvmOverloads
    public OSegmentTabView(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        int r12 = 0;
        this(r10, r11, r12, 4, null);
    }

    public /* synthetic */ OSegmentTabView(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    @JvmOverloads
    public OSegmentTabView(@NotNull Context r10, @Nullable AttributeSet r11, int r12) {
        q.g(r10, "context");
        super(r10, r11, r12);
        int r13 = f16665m;
        f16665m = r13 + 1;
        this.f16668e = q.p("OSegmentTabView_", Integer.valueOf(r13));
    }
}
