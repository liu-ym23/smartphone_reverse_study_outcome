package com.obric.oui.coachmark;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bytedance.apm.constant.CommonKey;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.common.oui.R$styleable;
import com.obric.oui.button.OButton;
import com.obric.oui.button.OIconButton;
import com.obric.oui.layout.OUILinearLayout;
import com.obric.oui.text.OTextView;
import com.obric.oui.utils.log.L;
import com.tmall.wireless.tangram.structure.card.FixCard;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.d;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tc.f;
import tc.l;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b!\u0018\u0000 s2\u00020\u0001:\u0002tuB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0013\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0015\u0010\fJ\u0017\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0019\u0010\fJ\u000f\u0010\u001a\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001a\u0010\fJ\u0017\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u001c\u0010\u0018J\u000f\u0010\u001d\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001d\u0010\fJ\u000f\u0010\u001e\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001e\u0010\fJ\u000f\u0010\u001f\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001f\u0010\fJ1\u0010%\u001a\u00020\n2\b\u0010!\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#H\u0007¢\u0006\u0004\b%\u0010&J\u0017\u0010'\u001a\u00020\n2\b\u0010!\u001a\u0004\u0018\u00010 ¢\u0006\u0004\b'\u0010(J\u0017\u0010)\u001a\u00020\n2\b\u0010!\u001a\u0004\u0018\u00010 ¢\u0006\u0004\b)\u0010(J\u0017\u0010,\u001a\u00020\n2\b\u0010+\u001a\u0004\u0018\u00010*¢\u0006\u0004\b,\u0010-J\u0017\u00100\u001a\u00020\n2\b\u0010/\u001a\u0004\u0018\u00010.¢\u0006\u0004\b0\u00101J\u0017\u00102\u001a\u00020\n2\b\u0010/\u001a\u0004\u0018\u00010.¢\u0006\u0004\b2\u00101J\u0015\u00104\u001a\u00020\n2\u0006\u00103\u001a\u00020\u0010¢\u0006\u0004\b4\u0010\u0018J\u0015\u00106\u001a\u00020\n2\u0006\u00105\u001a\u00020\u0010¢\u0006\u0004\b6\u0010\u0018J\u0015\u00108\u001a\u00020\n2\u0006\u00107\u001a\u00020\u0010¢\u0006\u0004\b8\u0010\u0018J\u0015\u0010;\u001a\u00020\n2\u0006\u0010:\u001a\u000209¢\u0006\u0004\b;\u0010<J\u0017\u0010=\u001a\u00020\n2\b\u0010!\u001a\u0004\u0018\u00010 ¢\u0006\u0004\b=\u0010(J\u0017\u0010>\u001a\u00020\n2\b\u0010!\u001a\u0004\u0018\u00010 ¢\u0006\u0004\b>\u0010(J\u0017\u0010@\u001a\u00020\n2\u0006\u0010?\u001a\u00020\u0006H\u0016¢\u0006\u0004\b@\u0010AJ\u0015\u0010C\u001a\u00020\n2\u0006\u0010B\u001a\u00020\r¢\u0006\u0004\bC\u0010DR\u0014\u0010G\u001a\u00020E8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010FR\u0014\u0010J\u001a\u00020H8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010IR\u0014\u0010M\u001a\u00020K8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010LR\u0014\u0010P\u001a\u00020N8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010OR\u0014\u0010S\u001a\u00020Q8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010RR\u0014\u0010T\u001a\u00020E8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010FR\u0014\u0010W\u001a\u00020U8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010VR\u0014\u0010X\u001a\u00020H8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010IR\u0014\u0010Z\u001a\u00020E8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bY\u0010FR\u0014\u0010\\\u001a\u00020K8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b[\u0010LR\u0014\u0010^\u001a\u00020E8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b]\u0010FR\u0014\u0010`\u001a\u00020N8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b_\u0010OR\u0014\u0010b\u001a\u00020N8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\ba\u0010OR\u0016\u0010e\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bc\u0010dR\u0016\u00105\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bf\u0010dR\u0016\u0010i\u001a\u0002098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bg\u0010hR\u0016\u00107\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bj\u0010dR\u0018\u0010m\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bk\u0010lR\u0016\u0010o\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bn\u0010dR\u0018\u0010r\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bp\u0010q¨\u0006v"}, d2 = {"Lcom/obric/oui/coachmark/OCoachmarkTipView;", "Lcom/obric/oui/layout/OUILinearLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "i", "()V", "", "d", "()F", "", "e", "()Z", "b", "(Landroid/util/AttributeSet;I)V", "l", "multiLine", "c", "(Z)V", "k", "n", "hasActions", "o", "m", "j", "h", "", "text", "maxLines", "Landroid/text/TextUtils$TruncateAt;", "ellipsize", "f", "(Ljava/lang/CharSequence;Ljava/lang/Integer;Landroid/text/TextUtils$TruncateAt;)V", "setActionText", "(Ljava/lang/CharSequence;)V", "setDismissText", "Landroid/graphics/drawable/Drawable;", "drawable", "setIcon", "(Landroid/graphics/drawable/Drawable;)V", "Landroid/view/View$OnClickListener;", "listener", "setOnActionClickListener", "(Landroid/view/View$OnClickListener;)V", "setOnDismissClickListener", "show", "setShowIcon", "closable", "setClosable", "singleLine", "setSingleLine", "Lcom/obric/oui/coachmark/OCoachmarkTipView$ActionType;", "type", "setActionType", "(Lcom/obric/oui/coachmark/OCoachmarkTipView$ActionType;)V", "setPrimaryButtonText", "setSecondaryButtonText", "color", "setBackgroundColor", "(I)V", "radius", "setCornerRadius", "(F)V", "Landroid/view/View;", "Landroid/view/View;", "inlineContainer", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "inlineIcon", "Lcom/obric/oui/text/OTextView;", "Lcom/obric/oui/text/OTextView;", "inlineText", "Lcom/obric/oui/button/OButton;", "Lcom/obric/oui/button/OButton;", "inlineAction", "Lcom/obric/oui/button/OIconButton;", "Lcom/obric/oui/button/OIconButton;", "inlineDismiss", "multiContainer", "Landroid/widget/LinearLayout;", "Landroid/widget/LinearLayout;", "multiLeadingRow", "multiIcon", "p", "multiTextGroup", "q", "descText", "r", "multiActions", "s", "multiDismiss", "t", "multiAction", "u", "Z", "showIcon", "v", "w", "Lcom/obric/oui/coachmark/OCoachmarkTipView$ActionType;", "actionType", FixCard.FixStyle.KEY_X, FixCard.FixStyle.KEY_Y, "Ljava/lang/Integer;", "backgroundColor", "z", "hasXmlBackground", "A", "Ljava/lang/Float;", "customCornerRadius", "B", "ActionType", "a", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OCoachmarkTipView extends OUILinearLayout {
    public static final a B = null;
    public Float A;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final View f12812h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ImageView f12813i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final OTextView f12814j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final OButton f12815k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final OIconButton f12816l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final View f12817m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final LinearLayout f12818n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ImageView f12819o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final View f12820p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final OTextView f12821q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final View f12822r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final OButton f12823s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final OButton f12824t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f12825u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f12826v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public ActionType f12827w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f12828x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Integer f12829y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f12830z;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/obric/oui/coachmark/OCoachmarkTipView$ActionType;", "", "", CommonKey.KEY_VALUE, "<init>", "(Ljava/lang/String;II)V", "I", "getValue", "()I", "Companion", "a", "PRIMARY", "NEUTRAL", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum ActionType extends Enum<ActionType> {
        private static final /* synthetic */ ActionType[] $VALUES = null;

        @NotNull
        public static final a Companion = null;
        public static final ActionType NEUTRAL = null;
        public static final ActionType PRIMARY = null;
        private final int value;

        public static final class a {
            public /* synthetic */ a(DefaultConstructorMarker r10) {
                this();
            }

            public final ActionType a(int r10) {
                ActionType[] r11 = ActionType.values();
                int r12 = r11.length;
                int r13 = 0;
            L3:
                if (r13 >= r12) goto L8;
                ActionType r14 = r11[r13];
                if (r14.getValue() == r10) goto L9;
                r13 = r13 + 1;
            L9:
                if (r14 == null) goto L11;
                return r14;
            L11:
                return ActionType.PRIMARY;
            L8:
                r14 = null;
                goto L9
            }

            public a() {
            }
        }

        private static final /* synthetic */ ActionType[] $values() {
            return new ActionType[]{PRIMARY, NEUTRAL};
        }

        static {
            PRIMARY = new ActionType("PRIMARY", 0, 0);
            NEUTRAL = new ActionType("NEUTRAL", 1, 1);
            $VALUES = $values();
            Companion = new a(null);
        }

        private ActionType(String r10, int r11, int r12) {
            super(r10, r11);
            this.value = r12;
        }

        public static ActionType valueOf(String r10) {
            return (ActionType) Enum.valueOf(ActionType.class, r10);
        }

        public static ActionType[] values() {
            return (ActionType[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }
    }

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f12831a = null;

        static {
            int[] r10 = new int[ActionType.values().length];
            r10[ActionType.PRIMARY.ordinal()] = 1;
            r10[ActionType.NEUTRAL.ordinal()] = 2;
            f12831a = r10;
        }
    }

    static {
        B = new a(null);
    }

    @JvmOverloads
    public OCoachmarkTipView(@NotNull Context r10) {
        q.g(r10, "context");
        AttributeSet r11 = null;
        int r12 = 0;
        this(r10, r11, r12, 6, null);
    }

    public static /* synthetic */ void g(OCoachmarkTipView r10, CharSequence r11, Integer r12, TextUtils.TruncateAt r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L6;
        r12 = null;
    L6:
        if ((r14 & 4) == 0) goto L8;
        r13 = null;
    L8:
        r10.f(r11, r12, r13);
    }

    private final void l() {
        boolean r10 = e();
        l.p(this.f12812h, !r10);
        l.p(this.f12817m, r10);
        c(r10);
        if (r10 == false) goto L5;
        int r11 = 48;
    L6:
        setGravity(r11);
        j();
        k();
        n();
        m();
        h();
        return;
    L5:
        r11 = 16;
        goto L6
    }

    public final void b(AttributeSet r10, int r11) {
        if (r10 != null) goto L5;
        i();
        l();
        return;
    L5:
        TypedArray r12 = getContext().obtainStyledAttributes(r10, R$styleable.OCoachmarkTip, r11, 0);
        this.f12825u = r12.getBoolean(R$styleable.OCoachmarkTip_oui_cmTipShowIcon, true);
        this.f12826v = r12.getBoolean(R$styleable.OCoachmarkTip_oui_cmTipClosable, false);
        this.f12828x = r12.getBoolean(R$styleable.OCoachmarkTip_oui_cmTipSingleLine, false);
        this.f12827w = ActionType.Companion.a(r12.getInt(R$styleable.OCoachmarkTip_oui_cmTipActionType, ActionType.PRIMARY.getValue()));
        this.f12830z = r12.hasValue(R$styleable.OCoachmarkTip_android_background);
        CharSequence r13 = r12.getText(R$styleable.OCoachmarkTip_android_text);
        if (r13 == null) goto L9;
        this.f12814j.setText(r13);
        this.f12821q.setText(r13);
    L9:
        String r14 = r12.getString(R$styleable.OCoachmarkTip_oui_cmTipActionText);
        this.f12815k.setText(r14);
        this.f12824t.setText(r14);
        String r15 = r12.getString(R$styleable.OCoachmarkTip_oui_cmTipDismissText);
        this.f12823s.setText(r15);
        Drawable r16 = r12.getDrawable(R$styleable.OCoachmarkTip_android_src);
        if (r16 == null) goto L13;
        this.f12813i.setImageDrawable(r16);
        this.f12819o.setImageDrawable(r16);
    L13:
        String r17 = r12.getString(R$styleable.OCoachmarkTip_oui_cmTipPrimaryButtonText);
        if (r17 == null) goto L17;
        this.f12815k.setText(r17);
        this.f12824t.setText(r17);
    L17:
        String r18 = r12.getString(R$styleable.OCoachmarkTip_oui_cmTipSecondaryButtonText);
        if (r18 == null) goto L21;
        this.f12823s.setText(r18);
    L21:
        int r19 = R$styleable.OCoachmarkTip_oui_cmTipBackgroundColor;
        if (r12.hasValue(r19) == false) goto L24;
        this.f12829y = Integer.valueOf(r12.getColor(r19, 0));
    L24:
        int r20 = R$styleable.OCoachmarkTip_oui_cmTipCornerRadius;
        if (r12.hasValue(r20) == false) goto L27;
        this.A = Float.valueOf(r12.getDimension(r20, 0.0f));
    L27:
        r12.recycle();
        i();
        l();
    }

    public final void c(boolean r10) {
        Pair r11 = d.a(Boolean.valueOf(this.f12825u), Boolean.valueOf(r10));
        Boolean r12 = Boolean.TRUE;
        if (q.b(r11, d.a(r12, r12)) == false) goto L6;
        int r13 = f.r(this, 16);
    L9:
        if (r10 == false) goto L11;
        setPaddingRelative(r13, f.r(this, 16), f.r(this, 16), f.r(this, 16));
        setMinimumHeight(0);
        return;
    L11:
        setPaddingRelative(r13, f.r(this, 8), f.r(this, 8), f.r(this, 8));
        setMinimumHeight(f.r(this, 48));
        return;
    L6:
        if (q.b(r11, d.a(r12, Boolean.FALSE)) == false) goto L8;
        r13 = f.r(this, 12);
        goto L9
    L8:
        r13 = f.r(this, 20);
        goto L9
    }

    public final float d() {
        Float r10 = this.A;
        if (r10 != null) goto L9;
        if (e() == false) goto L11;
        return f.u(this, 20);
    L11:
        return f.u(this, 28);
    L9:
        return r10.floatValue();
    }

    public final boolean e() {
        return !this.f12828x;
    }

    public final void f(CharSequence r10, Integer r11, TextUtils.TruncateAt r12) {
        this.f12814j.setText(r10);
        this.f12821q.setText(r10);
        if (r11 == null) goto L6;
        int r13 = r11.intValue();
        this.f12814j.setMaxLines(r13);
        this.f12821q.setMaxLines(r13);
    L6:
        if (r12 == null) goto L9;
        this.f12814j.setEllipsize(r12);
        this.f12821q.setEllipsize(r12);
    L9:
        if (r10 != null) goto L11;
    L12:
        L r14 = L.f17615a;
        if (r14.f(8) == true) goto L16;
        r14.d().writeLog("OCoachmarkTipView", 8, "Description is empty.", null);
    L16:
        l();
        return;
    L11:
        if (o.r(r10) == false) goto L16;
        goto L12
    }

    public final void h() {
        ActionType r10 = this.f12827w;
        int r11 = b.f12831a[r10.ordinal()];
        if (r11 != 1) goto L5;
        int r12 = R$color.oui_accent_6_bg;
    L10:
        int r13 = getContext().getColor(r12);
        this.f12815k.setTextColor(r13);
        this.f12824t.setTextColor(r13);
        return;
    L5:
        if (r11 != 2) goto L8;
        r12 = R$color.oui_basic_text_1;
        goto L10
    L8:
        throw new NoWhenBranchMatchedException();
    }

    public final void i() {
        Integer r10 = this.f12829y;
        if (r10 != null) goto L5;
        int r11 = getContext().getColor(R$color.oui_fill_element_2);
    L7:
        if (this.f12829y == null) goto L9;
    L11:
        float r12 = d();
        GradientDrawable r13 = new GradientDrawable();
        r13.setShape(0);
        r13.setColor(r11);
        r13.setCornerRadius(r12);
        setBackground(r13);
        return;
    L9:
        if (this.f12830z == false) goto L11;
        return;
    L5:
        r11 = r10.intValue();
        goto L7
    }

    public final void j() {
        boolean r10 = e();
        ImageView r11 = this.f12813i;
        int r12 = 0;
        if (this.f12825u == false) goto L6;
        if (r10 == true) goto L6;
        boolean r13 = true;
    L7:
        l.p(r11, r13);
        OTextView r14 = this.f12814j;
        ViewGroup.LayoutParams r15 = r14.getLayoutParams();
        if (r15 == null) goto L16;
        ViewGroup.MarginLayoutParams r16 = (ViewGroup.MarginLayoutParams) r15;
        if (this.f12825u == false) goto L13;
        if (r10 == true) goto L13;
        r12 = f.r(this, 8);
    L13:
        r16.setMarginStart(r12);
        r14.setLayoutParams(r16);
        return;
    L16:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L6:
        r13 = false;
        goto L7
    }

    public final void k() {
        if (e() == false) goto L5;
        return;
    L5:
        CharSequence r10 = this.f12815k.getText();
        boolean r11 = true;
        if (r10 != null) goto L8;
    L11:
        boolean r12 = true;
    L12:
        OButton r13 = this.f12815k;
        if (r12 == false) goto L15;
    L17:
        r11 = false;
    L18:
        l.p(r13, r11);
        l.p(this.f12816l, this.f12826v);
        return;
    L15:
        if (this.f12826v == true) goto L17;
    L8:
        if (o.r(r10) == true) goto L11;
        r12 = false;
        goto L12
    }

    public final void m() {
        if (e() == true) goto L5;
        return;
    L5:
        l.p(this.f12819o, this.f12825u);
        View r10 = this.f12820p;
        ViewGroup.LayoutParams r11 = r10.getLayoutParams();
        if (r11 == null) goto L14;
        ViewGroup.MarginLayoutParams r12 = (ViewGroup.MarginLayoutParams) r11;
        if (this.f12825u == false) goto L10;
        int r13 = f.r(this, 8);
    L11:
        r12.setMarginStart(r13);
        r10.setLayoutParams(r12);
        return;
    L10:
        r13 = 0;
        goto L11
    L14:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    public final void n() {
        if (e() == true) goto L5;
        return;
    L5:
        CharSequence r10 = this.f12823s.getText();
        boolean r11 = true;
        int r12 = 0;
        if (r10 != null) goto L8;
    L11:
        boolean r13 = true;
    L12:
        boolean r14 = !r13;
        CharSequence r15 = this.f12824t.getText();
        if (r15 != null) goto L15;
    L18:
        boolean r16 = true;
    L19:
        boolean r17 = !r16;
        if (r13 == false) goto L24;
        if (r16 == false) goto L24;
        r11 = false;
    L24:
        l.p(this.f12822r, r11);
        View r18 = this.f12822r;
        ViewGroup.LayoutParams r19 = r18.getLayoutParams();
        if (r19 == null) goto L40;
        ViewGroup.MarginLayoutParams r20 = (ViewGroup.MarginLayoutParams) r19;
        if (r11 == false) goto L29;
        int r21 = f.r(this, 8);
    L30:
        r20.topMargin = r21;
        r18.setLayoutParams(r20);
        o(r11);
        l.p(this.f12823s, r14);
        l.p(this.f12824t, r17);
        OButton r22 = this.f12824t;
        ViewGroup.LayoutParams r23 = r22.getLayoutParams();
        if (r23 == null) goto L38;
        ViewGroup.MarginLayoutParams r24 = (ViewGroup.MarginLayoutParams) r23;
        if (this.f12823s.getVisibility() != 0) goto L35;
        r12 = f.r(this, 12);
    L35:
        r24.setMarginStart(r12);
        r22.setLayoutParams(r24);
        return;
    L38:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L29:
        r21 = 0;
        goto L30
    L40:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L15:
        if (o.r(r15) == true) goto L18;
        r16 = false;
        goto L19
    L8:
        if (o.r(r10) == true) goto L11;
        r13 = false;
        goto L12
    }

    public final void o(boolean r10) {
        if (r10 == false) goto L4;
        int r11 = 48;
    L6:
        if (this.f12818n.getGravity() == r11) goto L9;
        this.f12818n.setGravity(r11);
        return;
    L9:
        return;
    L4:
        r11 = 16;
        goto L6
    }

    public final void setActionText(@Nullable CharSequence r10) {
        this.f12815k.setText(r10);
        this.f12824t.setText(r10);
        l();
    }

    public final void setActionType(@NotNull ActionType r10) {
        q.g(r10, "type");
        if (this.f12827w == r10) goto L6;
        this.f12827w = r10;
        h();
        return;
    }

    @Override // android.view.View
    public void setBackgroundColor(int r10) {
        this.f12829y = Integer.valueOf(r10);
        i();
    }

    public final void setClosable(boolean r10) {
        if (this.f12826v == r10) goto L6;
        this.f12826v = r10;
        l();
        return;
    }

    public final void setCornerRadius(float r10) {
        this.A = Float.valueOf(r10);
        i();
    }

    @JvmOverloads
    public final void setDescription(@Nullable CharSequence r10) {
        g(this, r10, null, null, 6, null);
    }

    public final void setDismissText(@Nullable CharSequence r10) {
        this.f12823s.setText(r10);
        l();
    }

    public final void setIcon(@Nullable Drawable r10) {
        this.f12813i.setImageDrawable(r10);
        this.f12819o.setImageDrawable(r10);
        l();
    }

    public final void setOnActionClickListener(@Nullable View.OnClickListener r10) {
        this.f12815k.setOnClickListener(r10);
        this.f12824t.setOnClickListener(r10);
    }

    public final void setOnDismissClickListener(@Nullable View.OnClickListener r10) {
        this.f12816l.setOnClickListener(r10);
        this.f12823s.setOnClickListener(r10);
    }

    public final void setPrimaryButtonText(@Nullable CharSequence r10) {
        this.f12815k.setText(r10);
        this.f12824t.setText(r10);
        l();
    }

    public final void setSecondaryButtonText(@Nullable CharSequence r10) {
        this.f12823s.setText(r10);
        l();
    }

    public final void setShowIcon(boolean r10) {
        if (this.f12825u == r10) goto L6;
        this.f12825u = r10;
        l();
        return;
    }

    public final void setSingleLine(boolean r10) {
        if (this.f12828x == r10) goto L6;
        this.f12828x = r10;
        i();
        l();
        return;
    }

    @JvmOverloads
    public OCoachmarkTipView(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        int r12 = 0;
        this(r10, r11, r12, 4, null);
    }

    public /* synthetic */ OCoachmarkTipView(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    @JvmOverloads
    public OCoachmarkTipView(@NotNull Context r10, @Nullable AttributeSet r11, int r12) {
        q.g(r10, "context");
        super(r10, r11, r12, null, 8, null);
        this.f12825u = true;
        this.f12827w = ActionType.PRIMARY;
        setOrientation(1);
        LayoutInflater.from(r10).inflate(R$layout.o_coachmark_tip, this, true);
        View r13 = findViewById(R$id.inline_container);
        q.f(r13, "findViewById(R.id.inline_container)");
        this.f12812h = r13;
        View r14 = findViewById(R$id.iv_inline_icon);
        q.f(r14, "findViewById(R.id.iv_inline_icon)");
        this.f12813i = (ImageView) r14;
        View r15 = findViewById(R$id.tv_inline_text);
        q.f(r15, "findViewById(R.id.tv_inline_text)");
        this.f12814j = (OTextView) r15;
        View r16 = findViewById(R$id.btn_inline_action);
        q.f(r16, "findViewById(R.id.btn_inline_action)");
        this.f12815k = (OButton) r16;
        View r17 = findViewById(R$id.btn_inline_dismiss);
        q.f(r17, "findViewById(R.id.btn_inline_dismiss)");
        this.f12816l = (OIconButton) r17;
        View r18 = findViewById(R$id.multi_container);
        q.f(r18, "findViewById(R.id.multi_container)");
        this.f12817m = r18;
        View r19 = findViewById(R$id.multi_leading_row);
        q.f(r19, "findViewById(R.id.multi_leading_row)");
        this.f12818n = (LinearLayout) r19;
        View r20 = findViewById(R$id.iv_multi_icon);
        q.f(r20, "findViewById(R.id.iv_multi_icon)");
        this.f12819o = (ImageView) r20;
        View r21 = findViewById(R$id.multi_text_group);
        q.f(r21, "findViewById(R.id.multi_text_group)");
        this.f12820p = r21;
        View r22 = findViewById(R$id.tv_desc);
        q.f(r22, "findViewById(R.id.tv_desc)");
        this.f12821q = (OTextView) r22;
        View r23 = findViewById(R$id.multi_actions);
        q.f(r23, "findViewById(R.id.multi_actions)");
        this.f12822r = r23;
        View r24 = findViewById(R$id.btn_multi_dismiss);
        q.f(r24, "findViewById(R.id.btn_multi_dismiss)");
        this.f12823s = (OButton) r24;
        View r25 = findViewById(R$id.btn_multi_action);
        q.f(r25, "findViewById(R.id.btn_multi_action)");
        this.f12824t = (OButton) r25;
        b(r11, r12);
    }
}
