package com.obric.oui.popover.menu;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import bg.h;
import com.bytedance.apm.constant.CommonKey;
import com.google.common.primitives.Ints;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$dimen;
import com.obric.common.oui.R$drawable;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.oui.badge.OBadgeView;
import com.obric.oui.common.style.OStateGradientDrawable;
import com.obric.oui.common.widget.MaxHeightNestedScrollView;
import com.obric.oui.divider.ODivider;
import com.obric.oui.popover.view.CheckableImageView;
import com.obric.oui.sectiontitlebar.OSectionTitleBar;
import com.obric.oui.text.OTextView;
import com.tmall.wireless.tangram.dataparser.concrete.Card;
import com.tmall.wireless.tangram.structure.card.FixCard;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.t;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tc.f;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0004XY\"ZB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000e\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000e\u0010\fJ\u001f\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ7\u0010#\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u0006H\u0014¢\u0006\u0004\b#\u0010$R1\u0010+\u001a\u001d\u0012\u0013\u0012\u00110&¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\n0%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R&\u00101\u001a\u0012\u0012\u0004\u0012\u00020-0,j\b\u0012\u0004\u0012\u00020-`.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0018\u00104\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0018\u00106\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00103R\u0016\u00109\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010<\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010>\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010;R\u0016\u0010?\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010;R\u0016\u0010A\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010;R\u0016\u0010C\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010;R&\u0010F\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010D\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010*R&\u0010H\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010D\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010*R\u0014\u0010J\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u0010;R\u0014\u0010K\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010;R$\u0010O\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010L8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010NR\u0014\u0010P\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010;R\u0016\u0010\u001b\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010;R\u0016\u0010S\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bR\u00108R\u0018\u0010W\u001a\u0004\u0018\u00010T8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bU\u0010V¨\u0006["}, d2 = {"Lcom/obric/oui/popover/menu/OPopoverEntranceMenuView;", "Lcom/obric/oui/popover/menu/OPopoverMenuView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "C", "()V", "B", FixCard.FixStyle.KEY_X, "Lcom/obric/oui/popover/menu/PopoverMenuLinearLayout;", "itemView", "", "enabled", "A", "(Lcom/obric/oui/popover/menu/PopoverMenuLinearLayout;Z)V", "getAvailableItemWidth", "()I", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "maxHeight", "setPopoverMaxHeight", "(I)V", "changed", "l", "t", "r", "b", "onLayout", "(ZIIII)V", "Lkotlin/Function1;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "e", "Lkotlin/jvm/functions/Function1;", "itemLayoutProcess", "Ljava/util/ArrayList;", "Lcom/obric/oui/popover/menu/OPopoverEntranceMenuView$b;", "Lkotlin/collections/ArrayList;", "f", "Ljava/util/ArrayList;", Card.KEY_ITEMS, "g", "Landroid/view/View;", "topView", "h", "bottomView", "i", "Z", "topDividerVisibility", "j", "I", "topViewHeight", "k", "bottomViewHeight", "itemWidth", "m", "itemHeight", "n", "isOption", "Landroid/graphics/drawable/Drawable;", "o", "imgGetter", "p", "tailImgGetter", "q", "verticalPadding", "itemVerticalMargin", "Lkotlin/Pair;", "s", "Lkotlin/Pair;", "widthConstraint", "defaultMaxHeight", "u", "v", "titleSingleLine", "Lcom/obric/oui/common/widget/MaxHeightNestedScrollView;", "w", "Lcom/obric/oui/common/widget/MaxHeightNestedScrollView;", "popOverScroll", "Builder", "a", "WidthLevel", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OPopoverEntranceMenuView extends OPopoverMenuView {
    public static final int A = 0;
    public static final int B = 0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final a f16133x = null;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f16134y = 0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f16135z = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Function1 f16136e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ArrayList f16137f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f16138g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f16139h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f16140i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f16141j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f16142k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f16143l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f16144m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f16145n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Function1 f16146o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Function1 f16147p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f16148q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f16149r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Pair f16150s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final int f16151t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f16152u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f16153v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public MaxHeightNestedScrollView f16154w;

    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Context f16155a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Function1 f16156b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public View f16157c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public View f16158d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public ArrayList f16159e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f16160f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f16161g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f16162h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f16163i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f16164j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f16165k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f16166l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f16167m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public Function1 f16168n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public Function1 f16169o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public Pair f16170p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public boolean f16171q;

        public static final class BadgeInfo {

            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/popover/menu/OPopoverEntranceMenuView$Builder$BadgeInfo$Style;", "", "(Ljava/lang/String;I)V", "DOT", "NUMBER", "ELLIPSIS", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
            public static final enum Style extends Enum<Style> {
                private static final /* synthetic */ Style[] $VALUES = null;
                public static final Style DOT = null;
                public static final Style ELLIPSIS = null;
                public static final Style NUMBER = null;

                private static final /* synthetic */ Style[] $values() {
                    return new Style[]{DOT, NUMBER, ELLIPSIS};
                }

                static {
                    DOT = new Style("DOT", 0);
                    NUMBER = new Style("NUMBER", 1);
                    ELLIPSIS = new Style("ELLIPSIS", 2);
                    $VALUES = $values();
                }

                private Style(String r10, int r11) {
                    super(r10, r11);
                }

                public static Style valueOf(String r10) {
                    return (Style) Enum.valueOf(Style.class, r10);
                }

                public static Style[] values() {
                    return (Style[]) $VALUES.clone();
                }
            }
        }

        public Builder(Context r10) {
            q.g(r10, "context");
            this.f16155a = r10;
            this.f16156b = OPopoverEntranceMenuView$Builder$itemLayoutProcess$1.INSTANCE;
            this.f16159e = new ArrayList();
            this.f16164j = f.b(this.f16155a, OPopoverEntranceMenuView.h());
        }

        public static /* synthetic */ Builder c(Builder r10, Integer r11, Integer r12, Integer r13, CharSequence r14, CharSequence r15, CharSequence r16, boolean r17, BadgeInfo r18, Function2 r19, int r110, Object r111) {
            if ((r110 & 1) == 0) goto L6;
            r11 = 0;
        L6:
            if ((r110 & 2) == 0) goto L9;
            r12 = 0;
        L9:
            if ((r110 & 4) == 0) goto L12;
            r13 = 0;
        L12:
            if ((r110 & 8) == 0) goto L15;
            r14 = "";
        L15:
            if ((r110 & 16) == 0) goto L18;
            r15 = null;
        L18:
            if ((r110 & 32) == 0) goto L21;
            r16 = null;
        L21:
            if ((r110 & 64) == 0) goto L24;
            r17 = false;
        L24:
            if ((r110 & 128) == 0) goto L27;
            r18 = null;
        L27:
            if ((r110 & 256) == 0) goto L30;
            r19 = null;
        L30:
            return r10.b(r11, r12, r13, r14, r15, r16, r17, r18, r19);
        }

        public final Builder a(int r18, boolean r19, Integer r20, Integer r21, Integer r22, CharSequence r23, CharSequence r24, CharSequence r25, boolean r26, BadgeInfo r27, Integer r28, Function2 r29) {
            if (this.f16167m <= 0) goto L5;
            boolean r10 = true;
        L6:
            if (r10 == false) goto L11;
            if (r18 != 0) goto L11;
            throw new IllegalArgumentException("option menu item 请使用 addStartOptionItem() 或者 addEndOptionItem()");
        L11:
            if (r10 == true) goto L16;
            if (r18 == 0) goto L16;
            throw new IllegalArgumentException("menu item 请不要使用 addStartOptionItem() 或者 addEndOptionItem()");
        L16:
            ArrayList r15 = this.f16159e;
            if (r20 != null) goto L19;
            int r11 = 0;
        L20:
            if (r21 != null) goto L22;
            int r12 = 0;
        L23:
            if (r22 != null) goto L25;
            int r13 = 0;
        L26:
            r15.add(new b(r18, r19, r11, r12, r13, r23, r24, r25, r26, true, r29, 0, r27, r28));
            return this;
        L25:
            r13 = r22.intValue();
            goto L26
        L22:
            r12 = r21.intValue();
            goto L23
        L19:
            r11 = r20.intValue();
            goto L20
        L5:
            r10 = false;
            goto L6
        }

        public final Builder b(Integer r14, Integer r15, Integer r16, CharSequence r17, CharSequence r18, CharSequence r19, boolean r20, BadgeInfo r21, Function2 r22) {
            return a(0, false, r14, r15, r16, r17, r18, r19, r20, r21, null, r22);
        }

        public final OPopoverEntranceMenuView d() {
            AttributeSet r10 = null;
            int r11 = 0;
            OPopoverEntranceMenuView r12 = new OPopoverEntranceMenuView(this.f16155a, r10, r11, 6, null);
            OPopoverEntranceMenuView.p(r12, this.f16159e);
            r12.setPressedWithArrow(this.f16160f);
            r12.setForceDark(f());
            OPopoverEntranceMenuView.n(r12, this.f16156b);
            OPopoverEntranceMenuView.t(r12, this.f16161g);
            OPopoverEntranceMenuView.v(r12, this.f16162h);
            OPopoverEntranceMenuView.k(r12, this.f16163i);
            OPopoverEntranceMenuView.m(r12, this.f16165k);
            OPopoverEntranceMenuView.u(r12, this.f16157c);
            OPopoverEntranceMenuView.j(r12, this.f16158d);
            OPopoverEntranceMenuView.q(r12, this.f16167m);
            OPopoverEntranceMenuView.l(r12, this.f16168n);
            OPopoverEntranceMenuView.r(r12, this.f16169o);
            OPopoverEntranceMenuView.w(r12, this.f16170p);
            OPopoverEntranceMenuView.s(r12, this.f16171q);
            OPopoverEntranceMenuView.o(r12, this.f16164j);
            OPopoverEntranceMenuView.i(r12);
            return r12;
        }

        public final void e() {
            this.f16167m = 1;
        }

        public final boolean f() {
            return this.f16166l;
        }

        public final void g(int r10) {
            if (r10 < f.b(this.f16155a, OPopoverEntranceMenuView.g())) goto L5;
            h(WidthLevel.WIDTH_LEVEL_BROAD);
            return;
        L5:
            h(WidthLevel.WIDTH_LEVEL_STANDARD);
        }

        public final Builder h(WidthLevel r10) {
            q.g(r10, "level");
            this.f16164j = f.b(this.f16155a, r10.getValue());
            return this;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/obric/oui/popover/menu/OPopoverEntranceMenuView$WidthLevel;", "", CommonKey.KEY_VALUE, "", "(Ljava/lang/String;II)V", "getValue", "()I", "WIDTH_LEVEL_STANDARD", "WIDTH_LEVEL_BROAD", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum WidthLevel extends Enum<WidthLevel> {
        private static final /* synthetic */ WidthLevel[] $VALUES = null;
        public static final WidthLevel WIDTH_LEVEL_BROAD = null;
        public static final WidthLevel WIDTH_LEVEL_STANDARD = null;
        private final int value;

        private static final /* synthetic */ WidthLevel[] $values() {
            return new WidthLevel[]{WIDTH_LEVEL_STANDARD, WIDTH_LEVEL_BROAD};
        }

        static {
            WIDTH_LEVEL_STANDARD = new WidthLevel("WIDTH_LEVEL_STANDARD", 0, OPopoverEntranceMenuView.h());
            WIDTH_LEVEL_BROAD = new WidthLevel("WIDTH_LEVEL_BROAD", 1, OPopoverEntranceMenuView.g());
            $VALUES = $values();
        }

        private WidthLevel(String r10, int r11, int r12) {
            super(r10, r11);
            this.value = r12;
        }

        public static WidthLevel valueOf(String r10) {
            return (WidthLevel) Enum.valueOf(WidthLevel.class, r10);
        }

        public static WidthLevel[] values() {
            return (WidthLevel[]) $VALUES.clone();
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

    public static final class b {

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final a f16172n = null;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final b f16173o = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f16174a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f16175b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f16176c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f16177d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f16178e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public CharSequence f16179f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public CharSequence f16180g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public CharSequence f16181h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f16182i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f16183j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Function2 f16184k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f16185l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public Integer f16186m;

        public static final class a {
            public /* synthetic */ a(DefaultConstructorMarker r10) {
                this();
            }

            public a() {
            }
        }

        static {
            f16172n = new a(null);
            int r10 = 0;
            boolean r11 = false;
            int r12 = 0;
            int r13 = 0;
            int r14 = 0;
            CharSequence r15 = null;
            CharSequence r16 = null;
            CharSequence r17 = null;
            boolean r18 = false;
            boolean r19 = false;
            Function2 r110 = null;
            int r111 = 1;
            Builder.BadgeInfo r112 = null;
            Integer r113 = null;
            f16173o = new b(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112, r113, 14335, null);
        }

        public b(int r10, boolean r11, int r12, int r13, int r14, CharSequence r15, CharSequence r16, CharSequence r17, boolean r18, boolean r19, Function2 r110, int r111, Builder.BadgeInfo r112, Integer r113) {
            this.f16174a = r10;
            this.f16175b = r11;
            this.f16176c = r12;
            this.f16177d = r13;
            this.f16178e = r14;
            this.f16179f = r15;
            this.f16180g = r16;
            this.f16181h = r17;
            this.f16182i = r18;
            this.f16183j = r19;
            this.f16184k = r110;
            this.f16185l = r111;
            this.f16186m = r113;
        }

        public final Builder.BadgeInfo a() {
            return null;
        }

        public final boolean b() {
            return this.f16175b;
        }

        public final int c() {
            return this.f16176c;
        }

        public final int d() {
            return this.f16185l;
        }

        public final Function2 e() {
            return this.f16184k;
        }

        public final int f() {
            return this.f16178e;
        }

        public final CharSequence g() {
            return this.f16180g;
        }

        public final int h() {
            return this.f16177d;
        }

        public final CharSequence i() {
            return this.f16179f;
        }

        public final Integer j() {
            return this.f16186m;
        }

        public final CharSequence k() {
            return this.f16181h;
        }

        public final boolean l() {
            return this.f16183j;
        }

        public final boolean m() {
            return this.f16182i;
        }

        public final boolean n() {
            if ((this.f16174a & 1) != 0) goto L7;
            return false;
        L7:
            return true;
        }

        public final boolean o() {
            if ((this.f16174a & 4) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public final boolean p() {
            if ((this.f16174a & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public /* synthetic */ b(int r16, boolean r17, int r18, int r19, int r20, CharSequence r21, CharSequence r22, CharSequence r23, boolean r24, boolean r25, Function2 r26, int r27, Builder.BadgeInfo r28, Integer r29, int r30, DefaultConstructorMarker r31) {
            int r10 = 0;
            if ((r30 & 1) == 0) goto L5;
            int r11 = 0;
        L7:
            if ((r30 & 2) == 0) goto L9;
            boolean r12 = false;
        L11:
            if ((r30 & 4) == 0) goto L13;
            int r13 = 0;
        L15:
            if ((r30 & 8) == 0) goto L17;
            int r14 = 0;
        L19:
            if ((r30 & 16) == 0) goto L21;
            int r15 = 0;
        L23:
            if ((r30 & 32) == 0) goto L25;
            CharSequence r32 = "";
        L26:
            Integer r33 = null;
            if ((r30 & 64) == 0) goto L29;
            CharSequence r34 = null;
        L31:
            if ((r30 & 128) == 0) goto L33;
            CharSequence r110 = null;
        L35:
            if ((r30 & 256) == 0) goto L37;
            boolean r111 = false;
        L39:
            if ((r30 & 512) == 0) goto L41;
            boolean r112 = true;
        L43:
            if ((r30 & 1024) == 0) goto L45;
            Function2 r113 = null;
        L47:
            if ((r30 & 2048) != 0) goto L51;
            r10 = r27;
        L51:
            if ((r30 & 4096) == 0) goto L53;
            Builder.BadgeInfo r114 = null;
        L55:
            if ((r30 & 8192) != 0) goto L58;
            r33 = r29;
        L58:
            this(r11, r12, r13, r14, r15, r32, r34, r110, r111, r112, r113, r10, r114, r33);
            return;
        L53:
            r114 = r28;
            goto L55
        L45:
            r113 = r26;
            goto L47
        L41:
            r112 = r25;
            goto L43
        L37:
            r111 = r24;
            goto L39
        L33:
            r110 = r23;
            goto L35
        L29:
            r34 = r22;
            goto L31
        L25:
            r32 = r21;
            goto L26
        L21:
            r15 = r20;
            goto L23
        L17:
            r14 = r19;
            goto L19
        L13:
            r13 = r18;
            goto L15
        L9:
            r12 = r17;
            goto L11
        L5:
            r11 = r16;
            goto L7
        }
    }

    static {
        f16133x = new a(null);
        f16134y = 184;
        f16135z = 208;
        A = 6;
        B = 40;
    }

    @JvmOverloads
    public OPopoverEntranceMenuView(@NotNull Context r10) {
        q.g(r10, "context");
        AttributeSet r11 = null;
        int r12 = 0;
        this(r10, r11, r12, 6, null);
    }

    public static /* synthetic */ void e(b r10, CheckableImageView r11, LinearLayout r12, OPopoverEntranceMenuView r13, int r14, View r15) {
        y(r10, r11, r12, r13, r14, r15);
    }

    public static /* synthetic */ void f(b r10, View r11, int r12) {
        z(r10, r11, r12);
    }

    public static final /* synthetic */ int g() {
        return f16135z;
    }

    private final int getAvailableItemWidth() {
        return this.f16143l;
    }

    public static final /* synthetic */ int h() {
        return f16134y;
    }

    public static final /* synthetic */ void i(OPopoverEntranceMenuView r10) {
        r10.C();
    }

    public static final /* synthetic */ void j(OPopoverEntranceMenuView r10, View r11) {
        r10.f16139h = r11;
    }

    public static final /* synthetic */ void k(OPopoverEntranceMenuView r10, int r11) {
        r10.f16142k = r11;
    }

    public static final /* synthetic */ void l(OPopoverEntranceMenuView r10, Function1 r11) {
        r10.f16146o = r11;
    }

    public static final /* synthetic */ void m(OPopoverEntranceMenuView r10, int r11) {
        r10.f16144m = r11;
    }

    public static final /* synthetic */ void n(OPopoverEntranceMenuView r10, Function1 r11) {
        r10.f16136e = r11;
    }

    public static final /* synthetic */ void o(OPopoverEntranceMenuView r10, int r11) {
        r10.f16143l = r11;
    }

    public static final /* synthetic */ void p(OPopoverEntranceMenuView r10, ArrayList r11) {
        r10.f16137f = r11;
    }

    public static final /* synthetic */ void q(OPopoverEntranceMenuView r10, int r11) {
        r10.f16145n = r11;
    }

    public static final /* synthetic */ void r(OPopoverEntranceMenuView r10, Function1 r11) {
        r10.f16147p = r11;
    }

    public static final /* synthetic */ void s(OPopoverEntranceMenuView r10, boolean r11) {
        r10.f16153v = r11;
    }

    public static final /* synthetic */ void t(OPopoverEntranceMenuView r10, boolean r11) {
        r10.f16140i = r11;
    }

    public static final /* synthetic */ void u(OPopoverEntranceMenuView r10, View r11) {
        r10.f16138g = r11;
    }

    public static final /* synthetic */ void v(OPopoverEntranceMenuView r10, int r11) {
        r10.f16141j = r11;
    }

    public static final /* synthetic */ void w(OPopoverEntranceMenuView r10, Pair r11) {
        r10.f16150s = r11;
    }

    public static final void y(final b r10, CheckableImageView r11, LinearLayout r12, OPopoverEntranceMenuView r13, final int r14, final View r15) {
        q.g(r10, "$item");
        q.g(r13, "this$0");
        if (r10.b() == false) goto L19;
        if (r11 == null) goto L19;
        boolean r16 = !r11.isChecked();
        if (r13.f16145n != 1) goto L18;
        int r17 = r12.getChildCount();
        int r18 = 0;
    L9:
        if (r18 >= r17) goto L17;
        int r19 = r18 + 1;
        View r20 = r12.getChildAt(r18);
        if ((r20 instanceof PopoverMenuLinearLayout) == false) goto L16;
        CheckableImageView r21 = (CheckableImageView) r20.findViewById(R$id.popover_menu_radio);
        if (r21 == null) goto L16;
        r21.setChecked(false);
    L16:
        r18 = r19;
        goto L9
    L17:
        r11.setChecked(true);
        goto L19
    L18:
        r11.setChecked(r16);
    L19:
        r12.post(new com.obric.oui.popover.menu.b(r10, r15, r14));
    }

    public static final void z(b r10, View r11, int r12) {
        q.g(r10, "$item");
        Function2 r13 = r10.e();
        if (r13 == null) goto L7;
        q.f(r11, "it");
        r13.mo0invoke(r11, Integer.valueOf(r12));
        return;
    }

    public final void A(PopoverMenuLinearLayout r10, boolean r11) {
        r10.setEnabled(r11);
        r10.setClickable(r11);
        if (r11 == false) goto L5;
        float r12 = 1.0f;
    L6:
        r10.setAlpha(r12);
        return;
    L5:
        r12 = 0.3f;
        goto L6
    }

    public final void B() {
        ((FrameLayout) findViewById(R$id.top_container)).removeAllViews();
        ((LinearLayout) findViewById(R$id.popover_container)).removeAllViews();
        ((FrameLayout) findViewById(R$id.bottom_container)).removeAllViews();
    }

    public final void C() {
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(R$layout.o_view_popover_menu_type, this, true);
        MaxHeightNestedScrollView r10 = (MaxHeightNestedScrollView) findViewById(R$id.popover_scroll);
        this.f16154w = r10;
        if (r10 == null) goto L6;
        r10.setMaxHeight(this.f16152u);
    L6:
        MaxHeightNestedScrollView r11 = this.f16154w;
        if (r11 == null) goto L10;
        int r12 = this.f16148q;
        r11.setPadding(0, r12, 0, r12);
    L10:
        MaxHeightNestedScrollView r13 = this.f16154w;
        if (r13 == null) goto L14;
        r13.setScrollBarStyle(33554432);
    L14:
        MaxHeightNestedScrollView r14 = this.f16154w;
        if (r14 == null) goto L18;
        r14.setClipToPadding(false);
    L18:
        int r15 = -2;
        if (this.f16138g == null) goto L28;
        ViewGroup r16 = (ViewGroup) findViewById(R$id.top_container);
        r16.addView(this.f16138g, new ViewGroup.LayoutParams(-1, -2));
        if (this.f16150s == null) goto L23;
        r16.getLayoutParams().width = -2;
    L24:
        ViewGroup.LayoutParams r17 = r16.getLayoutParams();
        int r18 = this.f16141j;
        if (r18 != 0) goto L27;
        r18 = -2;
    L27:
        r17.height = r18;
        goto L28
    L23:
        r16.getLayoutParams().width = getAvailableItemWidth();
    L28:
        x();
        if (this.f16139h == null) goto L40;
        ViewGroup r19 = (ViewGroup) findViewById(R$id.bottom_container);
        r19.addView(this.f16139h, new ViewGroup.LayoutParams(-1, -2));
        if (this.f16150s == null) goto L33;
        r19.getLayoutParams().width = -2;
    L34:
        ViewGroup.LayoutParams r20 = r19.getLayoutParams();
        int r21 = this.f16142k;
        if (r21 == 0) goto L38;
        r15 = r21;
    L38:
        r20.height = r15;
        goto L40
    L33:
        r19.getLayoutParams().width = getAvailableItemWidth();
    L40:
        if (this.f16150s == null) goto L43;
        measure(0, 0);
        Log.d("OPopoverEntranceMenuView", "initView, handle widthConstraint: " + this.f16150s + ", measuredWidth: " + getMeasuredWidth());
        int r22 = getMeasuredWidth();
        Pair r23 = this.f16150s;
        q.d(r23);
        int r24 = ((Number) r23.getFirst()).intValue();
        Pair r25 = this.f16150s;
        q.d(r25);
        this.f16143l = h.k(r22, r24, ((Number) r25.getSecond()).intValue());
        this.f16150s = null;
        B();
        C();
        return;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int r10, int r11) {
        int r12 = View.MeasureSpec.getMode(r11);
        int r13 = View.MeasureSpec.getSize(r11);
        if (r12 != Integer.MIN_VALUE) goto L5;
        int r14 = View.MeasureSpec.makeMeasureSpec(h.g(r13, this.f16152u), Integer.MIN_VALUE);
    L9:
        super.onMeasure(r10, r14);
        if (getMeasuredHeight() <= this.f16152u) goto L13;
        setMeasuredDimension(getMeasuredWidth(), this.f16152u);
        return;
    L13:
        return;
    L5:
        if (r12 == 1073741824) goto L7;
        r14 = View.MeasureSpec.makeMeasureSpec(this.f16152u, Integer.MIN_VALUE);
        goto L9
    L7:
        r14 = View.MeasureSpec.makeMeasureSpec(h.g(r13, this.f16152u), Ints.MAX_POWER_OF_TWO);
        goto L9
    }

    @Override // com.obric.oui.popover.menu.OPopoverMenuView
    public void setPopoverMaxHeight(int r10) {
        int r11 = h.g(h.d(r10, f.r(this, B)), this.f16151t);
        if (this.f16152u != r11) goto L5;
        return;
    L5:
        this.f16152u = r11;
        MaxHeightNestedScrollView r12 = this.f16154w;
        if (r12 == null) goto L9;
        r12.setMaxHeight(r11);
    L9:
        requestLayout();
    }

    public final void x() {
        int r10 = 1;
        LinearLayout r11 = (LinearLayout) findViewById(R$id.popover_container);
        Iterator r12 = this.f16137f.iterator();
        boolean r13 = false;
        int r14 = 0;
        int r15 = 0;
    L4:
        if (r12.hasNext() == false) goto L178;
        Object r16 = r12.next();
        int r17 = r14 + 1;
        if (r14 >= 0) goto L8;
        t.q();
    L8:
        final b r18 = (b) r16;
        if (r18.d() == r10) goto L10;
        if (r18.d() == 2) goto L13;
        if (r18.n() == false) goto L22;
    L25:
        int r19 = r10;
    L27:
        if (r19 == 0) goto L34;
        View r20 = LayoutInflater.from(getContext()).inflate(R$layout.o_item_popover_menu_filter, r11, r13);
        if (r20 == null) goto L33;
        PopoverMenuLinearLayout r21 = (PopoverMenuLinearLayout) r20;
    L31:
        PopoverMenuLinearLayout r22 = r21;
        OStateGradientDrawable r23 = new OStateGradientDrawable();
        Context r24 = getContext();
        q.f(r24, "context");
        r23.setCornerRadius(f.e(r24, 20));
        ColorStateList r25 = ContextCompat.c(getContext(), R$color.o_pop_list_item_bg_color);
        q.d(r25);
        q.f(r25, "getColorStateList(contex…pop_list_item_bg_color)!!");
        r23.setSolidColors(r25);
        r22.setBackground(r23);
        LinearLayout r26 = (LinearLayout) r22.findViewById(R$id.item_container);
        ImageView r27 = (ImageView) r22.findViewById(R$id.iv_popover_action);
        ImageView r28 = (ImageView) r22.findViewById(R$id.iv_popover_tail_image);
        OTextView r29 = (OTextView) r22.findViewById(R$id.tv_popover_action);
        OTextView r110 = (OTextView) r22.findViewById(R$id.tv_popover_action_sub);
        OTextView r111 = (OTextView) r22.findViewById(R$id.tv_popover_value);
        LinearLayout.LayoutParams r210 = null;
        if (r19 == 0) goto L40;
        CheckableImageView r30 = (CheckableImageView) r22.findViewById(R$id.popover_menu_radio);
    L41:
        r22.findViewById(R$id.popover_badge_default);
        OBadgeView r31 = (OBadgeView) r22.findViewById(R$id.popover_badge_number);
        OBadgeView r32 = (OBadgeView) r22.findViewById(R$id.popover_badge_ellipsis);
        LinearLayout r211 = (LinearLayout) r22.findViewById(R$id.ll_popover_text_container);
        r18.a();
        if (r30 != null) goto L45;
    L49:
        final CheckableImageView r212 = r30;
        Iterator r213 = r12;
        final LinearLayout r33 = r11;
        LinearLayout r214 = r11;
        final int r34 = r15;
        r22.setOnClickListener(new com.obric.oui.popover.menu.a(r18, r212, r33, this, r34));
        if (this.f16150s == null) goto L52;
        int r35 = -2;
        r22.getLayoutParams().width = -2;
    L54:
        if (r18.g() != null) goto L60;
        r110.setVisibility(8);
        ViewGroup.LayoutParams r36 = r22.getLayoutParams();
        int r37 = this.f16144m;
        if (r37 == 0) goto L59;
        r35 = r37;
    L59:
        r36.height = r35;
    L65:
        r110.setText(r18.g());
        r111.setText(r18.k());
        if (TextUtils.isEmpty(r18.k()) == false) goto L68;
        int r38 = 8;
    L69:
        r111.setVisibility(r38);
        if (this.f16137f.size() != 1) goto L80;
        r22.setIndexPos(PopoverMenuLinearLayout.Index.ONLY_ONE);
        ViewGroup.LayoutParams r39 = r22.getLayoutParams();
        if ((r39 instanceof LinearLayout.LayoutParams) == false) goto L74;
        LinearLayout.LayoutParams r40 = (LinearLayout.LayoutParams) r39;
    L75:
        if (r40 == null) goto L78;
        r40.topMargin = 0;
        r40.bottomMargin = 0;
        Unit r41 = Unit.f21064a;
    L78:
        int r42 = 0;
    L98:
        d(r22);
        if (r18.c() == 0) goto L107;
        r27.setVisibility(r42);
        Function1 r43 = this.f16146o;
        if (r43 == null) goto L106;
        if (r43 != null) goto L104;
        Drawable r44 = null;
    L105:
        r27.setImageDrawable(r44);
    L109:
        if (r18.h() == 0) goto L117;
        ImageView r45 = r28;
        r45.setVisibility(0);
        Function1 r46 = this.f16147p;
        if (r46 == null) goto L116;
        if (r46 != null) goto L114;
        Drawable r47 = null;
    L115:
        r45.setImageDrawable(r47);
    L119:
        if (r18.i() == null) goto L121;
        OTextView r48 = r29;
        r48.setText(r18.i());
    L122:
        r48.setSingleLine(this.f16153v);
        r48.setEllipsize(TextUtils.TruncateAt.END);
        if (this.f16153v == false) goto L125;
        int r49 = 1;
    L126:
        r48.setMaxLines(r49);
        if (r18.f() == 0) goto L129;
        r27.setImageTintList(ColorStateList.valueOf(r18.f()));
        r45.setImageTintList(ColorStateList.valueOf(r18.f()));
    L129:
        Integer r50 = r18.j();
        if (r50 == null) goto L134;
        r48.setTextColor(r50.intValue());
        Unit r51 = Unit.f21064a;
    L134:
        if (getForceDark() == false) goto L137;
        int r52 = ContextCompat.b(getContext(), R$color.ConstTextInverse2);
        r48.setTextColor(r52);
        r27.setImageTintList(ColorStateList.valueOf(r52));
        r45.setImageTintList(ColorStateList.valueOf(r52));
        r22.setForceDark(true);
    L137:
        if (r18.m() == false) goto L140;
        int r53 = ContextCompat.b(getContext(), R$color.Negative);
        r48.setTextColor(r53);
        r27.setImageTintList(ColorStateList.valueOf(r53));
    L140:
        if (r212 != null) goto L143;
        boolean r54 = false;
    L175:
        this.f16136e.invoke(r22);
        A(r22, r18.l());
        r214.addView(r22);
        r15 = r15 + 1;
        r11 = r214;
        r13 = r54;
        r10 = 1;
        r14 = r17;
        r12 = r213;
        goto L4
    L143:
        if (r18.f() == 0) goto L145;
        int r55 = r18.f();
    L146:
        r212.setImageTintList(ColorStateList.valueOf(r55));
        r212.setVisibility(0);
        r212.setChecked(r18.o());
        if (r18.p() == false) goto L173;
        ViewGroup.LayoutParams r56 = r212.getLayoutParams();
        if ((r56 instanceof LinearLayout.LayoutParams) == false) goto L151;
        LinearLayout.LayoutParams r57 = (LinearLayout.LayoutParams) r56;
    L152:
        if (r57 != null) goto L154;
        String r58 = "context";
        r54 = false;
    L155:
        r28.removeView(r212);
        r26.addView(r212);
        ViewGroup.LayoutParams r59 = r27.getLayoutParams();
        if ((r59 instanceof LinearLayout.LayoutParams) == false) goto L158;
        LinearLayout.LayoutParams r60 = (LinearLayout.LayoutParams) r59;
    L160:
        if (r60 == null) goto L164;
        Context r61 = getContext();
        q.f(r61, r58);
        r60.setMarginStart(f.b(r61, 12));
        Unit r62 = Unit.f21064a;
    L164:
        if (r27.getVisibility() != 8) goto L174;
        if (r211 == null) goto L174;
        ViewGroup.LayoutParams r63 = r211.getLayoutParams();
        if ((r63 instanceof LinearLayout.LayoutParams) == false) goto L169;
        r210 = (LinearLayout.LayoutParams) r63;
    L169:
        LinearLayout.LayoutParams r64 = r210;
        if (r64 == null) goto L174;
        Context r65 = getContext();
        q.f(r65, r58);
        r64.setMarginStart(f.b(r65, 12));
        Unit r66 = Unit.f21064a;
    L174:
        Unit r67 = Unit.f21064a;
        goto L175
    L158:
        r60 = null;
        goto L160
    L154:
        r54 = false;
        r57.setMarginStart(0);
        Context r68 = getContext();
        r58 = "context";
        q.f(r68, r58);
        r57.setMarginEnd(f.b(r68, 8));
        Unit r69 = Unit.f21064a;
        goto L155
    L151:
        r57 = null;
        goto L152
    L173:
        r54 = false;
        goto L174
    L145:
        r55 = ContextCompat.b(getContext(), R$color.oui_accent_fg);
        goto L146
    L125:
        r49 = A;
        goto L126
    L121:
        r48 = r29;
        goto L122
    L114:
        r47 = (Drawable) r46.invoke(Integer.valueOf(r18.h()));
        goto L115
    L116:
        r45.setImageResource(r18.h());
        goto L119
    L117:
        r45 = r28;
        r45.setVisibility(8);
        goto L119
    L104:
        r44 = (Drawable) r43.invoke(Integer.valueOf(r18.c()));
        goto L105
    L106:
        r27.setImageResource(r18.c());
        goto L109
    L107:
        r27.setVisibility(8);
        goto L109
    L74:
        r40 = null;
        goto L75
    L80:
        if (r14 != (this.f16137f.size() - 1)) goto L88;
        r22.setIndexPos(PopoverMenuLinearLayout.Index.LAST);
        ViewGroup.LayoutParams r70 = r22.getLayoutParams();
        if ((r70 instanceof LinearLayout.LayoutParams) == false) goto L84;
        LinearLayout.LayoutParams r71 = (LinearLayout.LayoutParams) r70;
    L85:
        if (r71 == null) goto L78;
        r71.topMargin = 0;
        r71.bottomMargin = 0;
        Unit r72 = Unit.f21064a;
        goto L78
    L84:
        r71 = null;
        goto L85
    L88:
        if (r14 < 0) goto L78;
        if (r14 != 0) goto L91;
        r22.setIndexPos(PopoverMenuLinearLayout.Index.FIRST);
    L91:
        ViewGroup.LayoutParams r73 = r22.getLayoutParams();
        if ((r73 instanceof LinearLayout.LayoutParams) == false) goto L94;
        LinearLayout.LayoutParams r74 = (LinearLayout.LayoutParams) r73;
    L95:
        if (r74 == null) goto L78;
        r42 = 0;
        r74.topMargin = 0;
        r74.bottomMargin = this.f16149r;
        Unit r75 = Unit.f21064a;
        goto L98
    L94:
        r74 = null;
        goto L95
    L68:
        r38 = 0;
        goto L69
    L60:
        r110.setVisibility(0);
        ViewGroup.LayoutParams r76 = r22.getLayoutParams();
        int r77 = this.f16144m;
        if (r77 == 0) goto L64;
        r35 = r77;
    L64:
        r76.height = r35;
        goto L65
    L52:
        r35 = -2;
        r22.getLayoutParams().width = getAvailableItemWidth();
        goto L54
    L45:
        if (r18.b() == false) goto L47;
        int r78 = 0;
    L48:
        r30.setVisibility(r78);
        goto L49
    L47:
        r78 = 4;
        goto L48
    L40:
        r30 = null;
        goto L41
    L33:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.popover.menu.PopoverMenuLinearLayout");
    L34:
        View r79 = LayoutInflater.from(getContext()).inflate(R$layout.o_item_popover_menu_type, r11, r13);
        if (r79 == null) goto L177;
        r21 = (PopoverMenuLinearLayout) r79;
        goto L31
    L177:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.popover.menu.PopoverMenuLinearLayout");
    L22:
        if (r18.p() == true) goto L25;
        r19 = r13 ? 1 : 0;
        goto L27
    L13:
        View r80 = LayoutInflater.from(getContext()).inflate(R$layout.o_item_popover_menu_sectionbar, r11, r13);
        if (r80 == null) goto L18;
        OSectionTitleBar r81 = (OSectionTitleBar) r80;
        r81.setTitleText(String.valueOf(r18.i()));
        LinearLayout.LayoutParams r82 = new LinearLayout.LayoutParams(-1, -2);
        r82.bottomMargin = this.f16149r;
        r11.addView(r81, r82);
    L16:
        r14 = r17;
        goto L4
    L18:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.sectiontitlebar.OSectionTitleBar");
    L10:
        Context r83 = getContext();
        q.f(r83, "context");
        View r84 = new ODivider(r83, null, 0, 6, null);
        r84.setBackground(getContext().getDrawable(R$drawable.o_item_vertical_divider));
        Context r85 = getContext();
        q.f(r85, "context");
        int r86 = f.b(r85, 8);
        r84.setPadding(r86, r13 ? 1 : 0, r86, r13 ? 1 : 0);
        ViewGroup.MarginLayoutParams r87 = new ViewGroup.MarginLayoutParams(-1, -2);
        int r88 = getContext().getResources().getDimensionPixelSize(R$dimen.oui_popover_divider_margin);
        r87.leftMargin = r88;
        r87.rightMargin = r88;
        r87.bottomMargin = this.f16149r;
        r11.addView(r84, r87);
        goto L16
    }

    @JvmOverloads
    public OPopoverEntranceMenuView(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        int r12 = 0;
        this(r10, r11, r12, 4, null);
    }

    public /* synthetic */ OPopoverEntranceMenuView(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    @JvmOverloads
    public OPopoverEntranceMenuView(@NotNull Context r10, @Nullable AttributeSet r11, int r12) {
        q.g(r10, "context");
        super(r10, r11, r12);
        this.f16136e = OPopoverEntranceMenuView$itemLayoutProcess$1.INSTANCE;
        this.f16137f = new ArrayList();
        this.f16143l = f.b(r10, f16134y);
        this.f16148q = f.b(r10, 8);
        this.f16149r = f.b(r10, 4);
        if (r10.getResources().getConfiguration().orientation != 2) goto L5;
        int r13 = r10.getResources().getDimensionPixelSize(R$dimen.oui_popover_max_height_landscape);
    L6:
        this.f16151t = r13;
        this.f16152u = r13;
        return;
    L5:
        r13 = r10.getResources().getDimensionPixelSize(R$dimen.oui_popover_max_height);
        goto L6
    }
}
