package com.obric.oui.segmentedtab;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;
import bg.h;
import com.obric.oui.utils.log.L;
import com.ttnet.org.chromium.net.PrivateKeyType;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 22\u00020\u0001:\u00013B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u001a\u0010\u0011J\u0017\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u001b\u0010\u0011J\u001f\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u001d\u0010\u0019J\u001f\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u001e\u0010\u0019R\u0014\u0010!\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\"R\u0016\u0010%\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010\"R\u0016\u0010\n\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010\"R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00101\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100¨\u00064"}, d2 = {"Lcom/obric/oui/segmentedtab/OSegmentTabMiniView;", "Lcom/obric/oui/segmentedtab/OTouchAnimView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "originIconAlpha", "", "setOriginIconAlpha", "(I)V", "", "isSelected", "o", "(Z)V", "c", "()Z", "", "animFraction", "", "scene", "f", "(FLjava/lang/String;)V", "q", "m", "fraction", "p", "n", "e", "Ljava/lang/String;", "TAG", "I", "textSelectColor", "g", "textUnselectColor", "h", "Landroid/widget/TextView;", "i", "Landroid/widget/TextView;", "tabTitle", "Landroid/widget/ImageView;", "j", "Landroid/widget/ImageView;", "iconView", "k", "Z", "selectState", "l", "a", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OSegmentTabMiniView extends OTouchAnimView {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final a f16653l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static int f16654m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static Typeface f16655n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static Typeface f16656o;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f16657e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f16658f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f16659g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f16660h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TextView f16661i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ImageView f16662j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f16663k;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final Typeface a(Typeface r10, int r11) {
            q.g(r10, "typeface");
            if (OSegmentTabMiniView.k() != null) goto L6;
            OSegmentTabMiniView.l(Typeface.create(r10, r11, false));
        L6:
            return OSegmentTabMiniView.k();
        }

        public a() {
        }
    }

    static {
        f16653l = new a(null);
    }

    @JvmOverloads
    public OSegmentTabMiniView(@NotNull Context r10) {
        q.g(r10, "context");
        AttributeSet r11 = null;
        int r12 = 0;
        this(r10, r11, r12, 6, null);
    }

    public static final /* synthetic */ Typeface k() {
        return f16656o;
    }

    public static final /* synthetic */ void l(Typeface r10) {
        f16656o = r10;
    }

    @Override // com.obric.oui.segmentedtab.OTouchAnimView
    public boolean c() {
        return !this.f16663k;
    }

    @Override // com.obric.oui.segmentedtab.OTouchAnimView
    public void f(float r10, String r11) {
        q.g(r11, "scene");
        L.a(this.f16657e, "onTouchAnimUpdate, scene: " + r11 + ", animFraction: " + r10);
        p(r10, r11);
        n(r10, r11);
    }

    public final void m(boolean r10) {
        ImageView r11 = null;
        if (r10 == true) goto L5;
        d();
        ImageView r12 = this.f16662j;
        if (r12 != null) goto L15;
        q.y("iconView");
    L16:
        r11.setImageAlpha(this.f16660h);
        return;
    L15:
        r11 = r12;
        goto L16
    L5:
        if (e() == true) goto L19;
        ImageView r13 = this.f16662j;
        if (r13 != null) goto L10;
        q.y("iconView");
    L11:
        r11.setImageAlpha(this.f16660h);
        return;
    L10:
        r11 = r13;
        goto L11
    }

    public final void n(float r10, String r11) {
        int r12 = h.k((int) (this.f16660h * OTouchAnimView.f16713d.a(r10)), 0, PrivateKeyType.INVALID);
        ImageView r13 = this.f16662j;
        if (r13 != null) goto L5;
        q.y("iconView");
        r13 = null;
    L5:
        r13.setImageAlpha(r12);
        L.a(this.f16657e, "updateIconAlphaOnPress, scene: " + r11 + ", fraction: " + r10 + ", alpha: " + r12 + ", originIconAlpha: " + this.f16660h);
    }

    public final void o(boolean r10) {
        L.a(this.f16657e, q.p("updateSelectState, isSelected: ", Boolean.valueOf(r10)));
        this.f16663k = r10;
        setSelected(r10);
        q(r10);
        m(r10);
    }

    public final void p(float r10, String r11) {
        if (q.b(r11, "press_anim") == false) goto L6;
        int r12 = this.f16659g;
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
        TextView r19 = this.f16661i;
        Typeface r20 = null;
        if (r19 != null) goto L17;
        q.y("tabTitle");
        r19 = null;
    L17:
        r19.setTextColor(r18);
        TextView r21 = this.f16661i;
        if (r21 != null) goto L21;
        q.y("tabTitle");
        r21 = null;
    L21:
        if (this.f16663k == true) goto L23;
    L29:
        Typeface r22 = f16655n;
        if (r22 != null) goto L32;
        q.y("DEFAULT_TYPE_FACE");
    L33:
        r21.setTypeface(r20);
        L.a(this.f16657e, "updateTextColorOnPress, scene: " + r11 + ", fraction: " + r10 + ", newTextAlpha: " + r17 + ", originTextAlpha: " + r13);
        return;
    L32:
        r20 = r22;
        goto L33
    L23:
        if (r10 != 0.0f) goto L29;
        a r23 = f16653l;
        Typeface r24 = f16655n;
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
        if (this.f16663k == false) goto L10;
        r12 = this.f16658f;
        goto L12
    L10:
        r12 = this.f16659g;
        goto L12
    }

    public final void q(boolean r10) {
        TextView r11 = null;
        if (r10 == true) goto L5;
        d();
        TextView r12 = this.f16661i;
        if (r12 != null) goto L15;
        q.y("tabTitle");
    L16:
        r11.setTextColor(this.f16659g);
        return;
    L15:
        r11 = r12;
        goto L16
    L5:
        if (e() == true) goto L19;
        TextView r13 = this.f16661i;
        if (r13 != null) goto L10;
        q.y("tabTitle");
    L11:
        r11.setTextColor(this.f16658f);
        return;
    L10:
        r11 = r13;
        goto L11
    }

    public final void setOriginIconAlpha(int r10) {
        this.f16660h = r10;
    }

    @JvmOverloads
    public OSegmentTabMiniView(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        int r12 = 0;
        this(r10, r11, r12, 4, null);
    }

    public /* synthetic */ OSegmentTabMiniView(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    @JvmOverloads
    public OSegmentTabMiniView(@NotNull Context r10, @Nullable AttributeSet r11, int r12) {
        q.g(r10, "context");
        super(r10, r11, r12);
        int r13 = f16654m;
        f16654m = r13 + 1;
        this.f16657e = q.p("OSegmentTabView_", Integer.valueOf(r13));
    }
}
