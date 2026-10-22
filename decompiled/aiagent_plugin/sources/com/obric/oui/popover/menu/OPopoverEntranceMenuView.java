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
import androidx.core.view.ab;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.aiagent.plugin.R;
import com.obric.oui.badge.OBadgeView;
import com.obric.oui.common.style.OStateGradientDrawable;
import com.obric.oui.common.widget.MaxHeightNestedScrollView;
import com.obric.oui.divider.ODivider;
import com.obric.oui.popover.view.CheckableImageView;
import com.obric.oui.sectiontitlebar.OSectionTitleBar;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.h.b.p;
import d.l.n;
import d.m;
import d.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: OPopoverEntranceMenuView.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OPopoverEntranceMenuView extends OPopoverMenuView {
    public static final b Companion = null;
    private static final float DISABLED_ALPHA = 0.3f;
    private static final int MAX_LINES = 0;
    private static final int MIN_AVAILABLE_HEIGHT_DP = 0;
    private static final String TAG = "OPopoverEntranceMenuView";
    private static final int WIDTH_BROAD_DP = 0;
    private static final int WIDTH_STANDARD_DP = 0;
    private View bottomView;
    private int bottomViewHeight;
    private final int defaultMaxHeight;
    private d.h.a.b<? super Integer, ? extends Drawable> imgGetter;
    private int isOption;
    private int itemHeight;
    private d.h.a.b<? super View, x> itemLayoutProcess;
    private final int itemVerticalMargin;
    private int itemWidth;
    private ArrayList<c> items;
    private int maxHeight;
    private MaxHeightNestedScrollView popOverScroll;
    private d.h.a.b<? super Integer, ? extends Drawable> tailImgGetter;
    private boolean titleSingleLine;
    private boolean topDividerVisibility;
    private View topView;
    private int topViewHeight;
    private final int verticalPadding;
    private m<Integer, Integer> widthConstraint;

    /* JADX INFO: compiled from: OPopoverEntranceMenuView.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Context f35998a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private d.h.a.b<? super View, x> f35999b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private View f36000c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private View f36001d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private ArrayList<c> f36002e;
        private boolean f;
        private boolean g;
        private int h;
        private int i;
        private int j;
        private int k;
        private boolean l;
        private int m;
        private d.h.a.b<? super Integer, ? extends Drawable> n;
        private d.h.a.b<? super Integer, ? extends Drawable> o;
        private m<Integer, Integer> p;
        private boolean q;

        /* JADX INFO: renamed from: com.obric.oui.popover.menu.OPopoverEntranceMenuView$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: OPopoverEntranceMenuView.kt */
        public static final class C0972a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private EnumC0973a f36003a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private int f36004b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private int f36005c;

            /* JADX INFO: renamed from: com.obric.oui.popover.menu.OPopoverEntranceMenuView$a$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: OPopoverEntranceMenuView.kt */
            public static final enum EnumC0973a extends Enum<EnumC0973a> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final EnumC0973a f36006a = null;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public static final EnumC0973a f36007b = null;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                public static final EnumC0973a f36008c = null;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                private static final /* synthetic */ EnumC0973a[] f36009d = null;

                private static final /* synthetic */ EnumC0973a[] a() {
                    return new EnumC0973a[]{f36006a, f36007b, f36008c};
                }

                public static EnumC0973a valueOf(String r2) {
                    return (EnumC0973a) ZeusTransformUtils.preCheckCast(Enum.valueOf(EnumC0973a.class, r2), EnumC0973a.class, "com.obric.aiagent.plugin");
                }

                public static EnumC0973a[] values() {
                    return (EnumC0973a[]) ZeusTransformUtils.preCheckCast(f36009d.clone(), EnumC0973a[].class, "com.obric.aiagent.plugin");
                }

                private EnumC0973a(String r1, int r2) {
                    super(r1, r2);
                }

                static {
                    f36006a = new EnumC0973a("DOT", 0);
                    f36007b = new EnumC0973a("NUMBER", 1);
                    f36008c = new EnumC0973a("ELLIPSIS", 2);
                    f36009d = a();
                }
            }

            public final EnumC0973a a() {
                return this.f36003a;
            }

            public final int b() {
                return this.f36004b;
            }

            public final int c() {
                return this.f36005c;
            }
        }

        /* JADX INFO: compiled from: OPopoverEntranceMenuView.kt */
        static final class b extends p implements d.h.a.b<View, x> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f36010a = null;

            static {
                f36010a = new b();
            }

            b() {
                super(1);
            }

            public final void a(View r1) {
                o.e(r1, "it");
            }

            @Override // d.h.a.b
            public /* synthetic */ x invoke(View r3) {
                a((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.aiagent.plugin"));
                return x.f38692a;
            }
        }

        public a(Context r3) {
            Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            o.e(r4, "context");
            this.f35998a = ZeusTransformUtils.wrapperContext(r4, "com.obric.aiagent.plugin");
            this.f35999b = (d.h.a.b) ZeusTransformUtils.preCheckCast(b.f36010a, d.h.a.b.class, "com.obric.aiagent.plugin");
            this.f36002e = new ArrayList();
            this.j = com.obric.oui.common.util.g.a(this.f35998a, OPopoverEntranceMenuView.access$getWIDTH_STANDARD_DP$cp());
        }

        public final Context getContext() {
            return this.f35998a;
        }

        public final boolean a() {
            return this.l;
        }

        public final void b() {
            this.m = 1;
        }

        public final void c() {
            this.f36002e.add(c.f36011a.a());
        }

        public static /* synthetic */ a a(a r12, Integer r13, Integer r14, Integer r15, CharSequence r16, CharSequence r17, boolean r18, boolean r19, boolean r20, d.h.a.m r21, int r22, Object r23) {
            CharSequence r1 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r16, CharSequence.class, "com.obric.aiagent.plugin");
            CharSequence r3 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r17, CharSequence.class, "com.obric.aiagent.plugin");
            d.h.a.m<? super View, ? super Integer, x> r4 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r21, d.h.a.m.class, "com.obric.aiagent.plugin");
            boolean r6 = false;
            Integer r7 = 0;
            if ((r22 & 1) == 0) goto L5;
            Integer r5 = r7;
        L7:
            if ((r22 & 2) == 0) goto L9;
            Integer r8 = r7;
        L11:
            if ((r22 & 4) != 0) goto L15;
            r7 = r15;
        L15:
            if ((r22 & 8) == 0) goto L18;
            r1 = (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.aiagent.plugin");
        L18:
            if ((r22 & 16) == 0) goto L21;
            r3 = null;
        L21:
            if ((r22 & 32) == 0) goto L23;
            boolean r2 = false;
        L25:
            if ((r22 & 64) == 0) goto L27;
            boolean r10 = true;
        L29:
            if ((r22 & 128) != 0) goto L33;
            r6 = r20;
        L33:
            if ((r22 & 256) == 0) goto L36;
            r4 = null;
        L36:
            return r12.a(r5, r8, r7, r1, r3, r2, r10, r6, r4);
        L27:
            r10 = r19;
            goto L29
        L23:
            r2 = r18;
            goto L25
        L9:
            r8 = r14;
            goto L11
        L5:
            r5 = r13;
            goto L7
        }

        public final a a(Integer r16, Integer r17, Integer r18, CharSequence r19, CharSequence r20, boolean r21, boolean r22, boolean r23, d.h.a.m<? super View, ? super Integer, x> r24) {
            CharSequence r8 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r19, CharSequence.class, "com.obric.aiagent.plugin");
            CharSequence r9 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r20, CharSequence.class, "com.obric.aiagent.plugin");
            d.h.a.m<? super View, ? super Integer, x> r14 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r24, d.h.a.m.class, "com.obric.aiagent.plugin");
            if (r23 == false) goto L5;
            int r0 = 5;
        L7:
            return a(r0, r22, r16, r17, r18, r8, r9, null, r21, null, null, r14);
        L5:
            r0 = 1;
            goto L7
        }

        public static /* synthetic */ a a(a r12, boolean r13, Integer r14, Integer r15, Integer r16, CharSequence r17, CharSequence r18, boolean r19, boolean r20, d.h.a.m r21, int r22, Object r23) {
            CharSequence r1 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r17, CharSequence.class, "com.obric.aiagent.plugin");
            CharSequence r3 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r18, CharSequence.class, "com.obric.aiagent.plugin");
            d.h.a.m<? super View, ? super Integer, x> r4 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r21, d.h.a.m.class, "com.obric.aiagent.plugin");
            if ((r22 & 1) == 0) goto L5;
            boolean r5 = true;
        L6:
            boolean r7 = false;
            if ((r22 & 2) == 0) goto L9;
            Integer r6 = 0;
        L11:
            if ((r22 & 4) == 0) goto L13;
            Integer r8 = 0;
        L15:
            if ((r22 & 8) == 0) goto L17;
            Integer r9 = 0;
        L19:
            if ((r22 & 16) == 0) goto L22;
            r1 = (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.aiagent.plugin");
        L22:
            if ((r22 & 32) == 0) goto L25;
            r3 = null;
        L25:
            if ((r22 & 64) == 0) goto L27;
            boolean r2 = false;
        L29:
            if ((r22 & 128) != 0) goto L33;
            r7 = r20;
        L33:
            if ((r22 & 256) == 0) goto L36;
            r4 = null;
        L36:
            return r12.a(r5, r6, r8, r9, r1, r3, r2, r7, r4);
        L27:
            r2 = r19;
            goto L29
        L17:
            r9 = r16;
            goto L19
        L13:
            r8 = r15;
            goto L15
        L9:
            r6 = r14;
            goto L11
        L5:
            r5 = r13;
            goto L6
        }

        public final a a(boolean r16, Integer r17, Integer r18, Integer r19, CharSequence r20, CharSequence r21, boolean r22, boolean r23, d.h.a.m<? super View, ? super Integer, x> r24) {
            CharSequence r8 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r20, CharSequence.class, "com.obric.aiagent.plugin");
            CharSequence r9 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r21, CharSequence.class, "com.obric.aiagent.plugin");
            d.h.a.m<? super View, ? super Integer, x> r14 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r24, d.h.a.m.class, "com.obric.aiagent.plugin");
            if (r23 == false) goto L5;
            int r0 = 6;
        L7:
            return a(r0, r16, r17, r18, r19, r8, r9, null, r22, null, null, r14);
        L5:
            r0 = 2;
            goto L7
        }

        public static /* synthetic */ a a(a r11, Integer r12, Integer r13, Integer r14, CharSequence r15, CharSequence r16, CharSequence r17, boolean r18, C0972a r19, d.h.a.m r20, int r21, Object r22) {
            CharSequence r1 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r15, CharSequence.class, "com.obric.aiagent.plugin");
            CharSequence r3 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r16, CharSequence.class, "com.obric.aiagent.plugin");
            CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r17, CharSequence.class, "com.obric.aiagent.plugin");
            d.h.a.m<? super View, ? super Integer, x> r5 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r20, d.h.a.m.class, "com.obric.aiagent.plugin");
            boolean r7 = false;
            Integer r8 = 0;
            if ((r21 & 1) == 0) goto L5;
            Integer r6 = r8;
        L7:
            if ((r21 & 2) == 0) goto L9;
            Integer r9 = r8;
        L11:
            if ((r21 & 4) != 0) goto L15;
            r8 = r14;
        L15:
            if ((r21 & 8) == 0) goto L18;
            r1 = (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.aiagent.plugin");
        L18:
            if ((r21 & 16) == 0) goto L21;
            r3 = null;
        L21:
            if ((r21 & 32) == 0) goto L24;
            r4 = null;
        L24:
            if ((r21 & 64) != 0) goto L28;
            r7 = r18;
        L28:
            if ((r21 & 128) == 0) goto L30;
            C0972a r2 = null;
        L32:
            if ((r21 & 256) == 0) goto L35;
            r5 = null;
        L35:
            return r11.a(r6, r9, r8, r1, r3, r4, r7, r2, r5);
        L30:
            r2 = r19;
            goto L32
        L9:
            r9 = r13;
            goto L11
        L5:
            r6 = r12;
            goto L7
        }

        public final a a(Integer r16, Integer r17, Integer r18, CharSequence r19, CharSequence r20, CharSequence r21, boolean r22, C0972a r23, d.h.a.m<? super View, ? super Integer, x> r24) {
            return a(0, false, r16, r17, r18, (CharSequence) ZeusTransformUtils.wrapperContextForParams(r19, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.wrapperContextForParams(r20, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.wrapperContextForParams(r21, CharSequence.class, "com.obric.aiagent.plugin"), r22, r23, null, (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r24, d.h.a.m.class, "com.obric.aiagent.plugin"));
        }

        private final a a(int r18, boolean r19, Integer r20, Integer r21, Integer r22, CharSequence r23, CharSequence r24, CharSequence r25, boolean r26, C0972a r27, Integer r28, d.h.a.m<? super View, ? super Integer, x> r29) {
            CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r23, CharSequence.class, "com.obric.aiagent.plugin");
            CharSequence r8 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r24, CharSequence.class, "com.obric.aiagent.plugin");
            CharSequence r9 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r25, CharSequence.class, "com.obric.aiagent.plugin");
            d.h.a.m r12 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r29, d.h.a.m.class, "com.obric.aiagent.plugin");
            if (this.m <= 0) goto L5;
            boolean r1 = true;
        L6:
            if (r1 == false) goto L11;
            if (r18 != 0) goto L11;
            throw new IllegalArgumentException("option menu item 请使用 addStartOptionItem() 或者 addEndOptionItem()");
        L11:
            if (r1 == true) goto L16;
            if (r18 == 0) goto L16;
            throw new IllegalArgumentException("menu item 请不要使用 addStartOptionItem() 或者 addEndOptionItem()");
        L16:
            ArrayList<c> r15 = this.f36002e;
            if (r20 != null) goto L19;
            int r4 = 0;
        L20:
            if (r21 != null) goto L22;
            int r5 = 0;
        L23:
            if (r22 != null) goto L25;
            int r6 = 0;
        L26:
            r15.add(new c(r18, r19, r4, r5, r6, r7, r8, r9, r26, true, r12, 0, r27, r28));
            return this;
        L25:
            r6 = r22.intValue();
            goto L26
        L22:
            r5 = r21.intValue();
            goto L23
        L19:
            r4 = r20.intValue();
            goto L20
        L5:
            r1 = false;
            goto L6
        }

        public final a a(e r2) {
            o.e(r2, "level");
            this.j = com.obric.oui.common.util.g.a(this.f35998a, r2.a());
            return this;
        }

        public final void a(int r3) {
            if (r3 < com.obric.oui.common.util.g.a(this.f35998a, OPopoverEntranceMenuView.access$getWIDTH_BROAD_DP$cp())) goto L5;
            a(e.f36018b);
            return;
        L5:
            a(e.f36017a);
        }

        public final a a(boolean r1) {
            this.q = r1;
            return this;
        }

        public final OPopoverEntranceMenuView d() {
            OPopoverEntranceMenuView r6 = new OPopoverEntranceMenuView(this.f35998a, null, 0, 6, null);
            OPopoverEntranceMenuView.access$setItems$p(r6, this.f36002e);
            r6.setPressedWithArrow(this.f);
            r6.setForceDark(a());
            OPopoverEntranceMenuView.access$setItemLayoutProcess$p(r6, this.f35999b);
            OPopoverEntranceMenuView.access$setTopDividerVisibility$p(r6, this.g);
            OPopoverEntranceMenuView.access$setTopViewHeight$p(r6, this.h);
            OPopoverEntranceMenuView.access$setBottomViewHeight$p(r6, this.i);
            OPopoverEntranceMenuView.access$setItemHeight$p(r6, this.k);
            OPopoverEntranceMenuView.access$setTopView$p(r6, this.f36000c);
            OPopoverEntranceMenuView.access$setBottomView$p(r6, this.f36001d);
            OPopoverEntranceMenuView.access$setOption$p(r6, this.m);
            OPopoverEntranceMenuView.access$setImgGetter$p(r6, this.n);
            OPopoverEntranceMenuView.access$setTailImgGetter$p(r6, this.o);
            OPopoverEntranceMenuView.access$setWidthConstraint$p(r6, this.p);
            OPopoverEntranceMenuView.access$setTitleSingleLine$p(r6, this.q);
            OPopoverEntranceMenuView.access$setItemWidth$p(r6, this.j);
            OPopoverEntranceMenuView.access$initView(r6);
            return r6;
        }
    }

    /* JADX INFO: compiled from: OPopoverEntranceMenuView.kt */
    public static final class b {
        public /* synthetic */ b(d.h.b.h r1) {
            this();
        }

        private b() {
        }
    }

    /* JADX INFO: compiled from: OPopoverEntranceMenuView.kt */
    private static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f36011a = null;
        private static final c p = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f36012b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f36013c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f36014d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f36015e;
        private int f;
        private CharSequence g;
        private CharSequence h;
        private CharSequence i;
        private boolean j;
        private boolean k;
        private d.h.a.m<? super View, ? super Integer, x> l;
        private int m;
        private a.C0972a n;
        private Integer o;

        /* JADX INFO: compiled from: OPopoverEntranceMenuView.kt */
        public static final class a {
            public /* synthetic */ a(d.h.b.h r1) {
                this();
            }

            private a() {
            }

            public final c a() {
                return c.q();
            }
        }

        public c() {
            this(0, false, 0, 0, 0, null, null, null, false, false, null, 0, null, null, 16383, null);
        }

        public c(int r8, boolean r9, int r10, int r11, int r12, CharSequence r13, CharSequence r14, CharSequence r15, boolean r16, boolean r17, d.h.a.m<? super View, ? super Integer, x> r18, int r19, a.C0972a r20, Integer r21) {
            CharSequence r1 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r13, CharSequence.class, "com.obric.aiagent.plugin");
            CharSequence r3 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r14, CharSequence.class, "com.obric.aiagent.plugin");
            CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r15, CharSequence.class, "com.obric.aiagent.plugin");
            d.h.a.m<? super View, ? super Integer, x> r2 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r18, d.h.a.m.class, "com.obric.aiagent.plugin");
            this.f36012b = r8;
            this.f36013c = r9;
            this.f36014d = r10;
            this.f36015e = r11;
            this.f = r12;
            this.g = r1;
            this.h = r3;
            this.i = r4;
            this.j = r16;
            this.k = r17;
            this.l = r2;
            this.m = r19;
            this.n = r20;
            this.o = r21;
        }

        public static final /* synthetic */ c q() {
            return p;
        }

        public final boolean a() {
            return this.f36013c;
        }

        public final int b() {
            return this.f36014d;
        }

        public final int c() {
            return this.f36015e;
        }

        public final int d() {
            return this.f;
        }

        public /* synthetic */ c(int r16, boolean r17, int r18, int r19, int r20, CharSequence r21, CharSequence r22, CharSequence r23, boolean r24, boolean r25, d.h.a.m r26, int r27, a.C0972a r28, Integer r29, int r30, d.h.b.h r31) {
            CharSequence r1 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r21, CharSequence.class, "com.obric.aiagent.plugin");
            CharSequence r3 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r22, CharSequence.class, "com.obric.aiagent.plugin");
            CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r23, CharSequence.class, "com.obric.aiagent.plugin");
            d.h.a.m r5 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r26, d.h.a.m.class, "com.obric.aiagent.plugin");
            int r7 = 0;
            if ((r30 & 1) == 0) goto L5;
            int r6 = 0;
        L7:
            if ((r30 & 2) == 0) goto L9;
            boolean r8 = false;
        L11:
            if ((r30 & 4) == 0) goto L13;
            int r9 = 0;
        L15:
            if ((r30 & 8) == 0) goto L17;
            int r10 = 0;
        L19:
            if ((r30 & 16) == 0) goto L21;
            int r11 = 0;
        L23:
            if ((r30 & 32) == 0) goto L25;
            r1 = (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.aiagent.plugin");
        L25:
            Integer r12 = null;
            if ((r30 & 64) == 0) goto L29;
            r3 = null;
        L29:
            if ((r30 & 128) == 0) goto L32;
            r4 = null;
        L32:
            if ((r30 & 256) == 0) goto L34;
            boolean r2 = false;
        L36:
            if ((r30 & 512) == 0) goto L38;
            boolean r13 = true;
        L40:
            if ((r30 & 1024) == 0) goto L43;
            r5 = null;
        L43:
            if ((r30 & 2048) != 0) goto L47;
            r7 = r27;
        L47:
            if ((r30 & 4096) == 0) goto L49;
            a.C0972a r14 = null;
        L51:
            if ((r30 & 8192) != 0) goto L54;
            r12 = r29;
        L54:
            this(r6, r8, r9, r10, r11, r1, r3, r4, r2, r13, r5, r7, r14, r12);
            return;
        L49:
            r14 = r28;
            goto L51
        L38:
            r13 = r25;
            goto L40
        L34:
            r2 = r24;
            goto L36
        L21:
            r11 = r20;
            goto L23
        L17:
            r10 = r19;
            goto L19
        L13:
            r9 = r18;
            goto L15
        L9:
            r8 = r17;
            goto L11
        L5:
            r6 = r16;
            goto L7
        }

        public final CharSequence e() {
            return this.g;
        }

        public final CharSequence f() {
            return this.h;
        }

        public final CharSequence g() {
            return this.i;
        }

        public final boolean h() {
            return this.j;
        }

        public final void a(boolean r1) {
            this.k = r1;
        }

        public final boolean i() {
            return this.k;
        }

        public final d.h.a.m<View, Integer, x> j() {
            return this.l;
        }

        public final int k() {
            return this.m;
        }

        public final a.C0972a l() {
            return this.n;
        }

        public final Integer m() {
            return this.o;
        }

        static {
            f36011a = new a(null);
            p = new c(0, false, 0, 0, 0, null, null, null, false, false, null, 1, null, null, 14335, null);
        }

        public final boolean n() {
            if ((this.f36012b & 4) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public final boolean o() {
            if ((this.f36012b & 1) != 0) goto L7;
            return false;
        L7:
            return true;
        }

        public final boolean p() {
            if ((this.f36012b & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }
    }

    /* JADX INFO: compiled from: OPopoverEntranceMenuView.kt */
    public /* synthetic */ class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f36016a = null;

        static {
            int[] r0 = new int[a.C0972a.EnumC0973a.values().length];
            r0[a.C0972a.EnumC0973a.f36006a.ordinal()] = 1;
            r0[a.C0972a.EnumC0973a.f36007b.ordinal()] = 2;
            r0[a.C0972a.EnumC0973a.f36008c.ordinal()] = 3;
            f36016a = r0;
        }
    }

    /* JADX INFO: compiled from: OPopoverEntranceMenuView.kt */
    public static final enum e extends Enum<e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f36017a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final e f36018b = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ e[] f36019d = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f36020c;

        private static final /* synthetic */ e[] b() {
            return new e[]{f36017a, f36018b};
        }

        public static e valueOf(String r2) {
            return (e) ZeusTransformUtils.preCheckCast(Enum.valueOf(e.class, r2), e.class, "com.obric.aiagent.plugin");
        }

        public static e[] values() {
            return (e[]) ZeusTransformUtils.preCheckCast(f36019d.clone(), e[].class, "com.obric.aiagent.plugin");
        }

        private e(String r1, int r2, int r3) {
            super(r1, r2);
            this.f36020c = r3;
        }

        public final int a() {
            return this.f36020c;
        }

        static {
            f36017a = new e("WIDTH_LEVEL_STANDARD", 0, OPopoverEntranceMenuView.access$getWIDTH_STANDARD_DP$cp());
            f36018b = new e("WIDTH_LEVEL_BROAD", 1, OPopoverEntranceMenuView.access$getWIDTH_BROAD_DP$cp());
            f36019d = b();
        }
    }

    /* JADX INFO: compiled from: OPopoverEntranceMenuView.kt */
    static final class f extends p implements d.h.a.b<c, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f36021a = null;

        static {
            f36021a = new f();
        }

        f() {
            super(1);
        }

        public final Boolean a(c r1) {
            o.e(r1, "it");
            if (r1.k() != 0) goto L5;
            boolean r0 = true;
        L7:
            return Boolean.valueOf(r0);
        L5:
            r0 = false;
            goto L7
        }

        @Override // d.h.a.b
        public /* synthetic */ Boolean invoke(c r3) {
            return a((c) ZeusTransformUtils.preCheckCast(r3, c.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: _Sequences.kt */
    public static final class g extends p implements d.h.a.b<Object, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f36022a = null;

        static {
            f36022a = new g();
        }

        public g() {
            super(1);
        }

        public final Boolean a(Object r1) {
            return Boolean.valueOf(ZeusTransformUtils.instanceOf(r1, PopoverMenuLinearLayout.class));
        }

        @Override // d.h.a.b
        public /* synthetic */ Boolean invoke(Object r1) {
            return a(r1);
        }
    }

    /* JADX INFO: compiled from: OPopoverEntranceMenuView.kt */
    static final class h extends p implements d.h.a.b<View, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final h f36023a = null;

        static {
            f36023a = new h();
        }

        h() {
            super(1);
        }

        public final void a(View r1) {
            o.e(r1, "it");
        }

        @Override // d.h.a.b
        public /* synthetic */ x invoke(View r3) {
            a((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }
    }

    public OPopoverEntranceMenuView(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public OPopoverEntranceMenuView(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public static /* synthetic */ int access$000(String r0, String r1) {
        return Log.d(r0, r1);
    }

    public static /* synthetic */ int access$001(String r0, String r1) {
        return Log.w(r0, r1);
    }

    public static /* synthetic */ void lambda$B00oiyAGO4JJCyVGkNRthSSf0fo(c r0, View r1, int r2) {
        m1131addPopoverItems$lambda12$lambda3$lambda2(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$hVk0WmBtnSAuj4v-rYElkp8z7KA, reason: not valid java name */
    public static /* synthetic */ void m1132lambda$hVk0WmBtnSAuj4vrYElkp8z7KA(c r0, CheckableImageView r1, LinearLayout r2, OPopoverEntranceMenuView r3, int r4, View r5) {
        m1130addPopoverItems$lambda12$lambda3(r0, r1, r2, r3, r4, r5);
    }

    public /* synthetic */ OPopoverEntranceMenuView(Context r2, AttributeSet r3, int r4, int r5, d.h.b.h r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r7, r8, r4);
    }

    public static final /* synthetic */ int access$getWIDTH_BROAD_DP$cp() {
        return WIDTH_BROAD_DP;
    }

    public static final /* synthetic */ int access$getWIDTH_STANDARD_DP$cp() {
        return WIDTH_STANDARD_DP;
    }

    public static final /* synthetic */ void access$initView(OPopoverEntranceMenuView r0) {
        r0.initView();
    }

    public static final /* synthetic */ void access$setBottomView$p(OPopoverEntranceMenuView r0, View r1) {
        r0.bottomView = r1;
    }

    public static final /* synthetic */ void access$setBottomViewHeight$p(OPopoverEntranceMenuView r0, int r1) {
        r0.bottomViewHeight = r1;
    }

    public static final /* synthetic */ void access$setImgGetter$p(OPopoverEntranceMenuView r2, d.h.a.b r3) {
        r2.imgGetter = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
    }

    public static final /* synthetic */ void access$setItemHeight$p(OPopoverEntranceMenuView r0, int r1) {
        r0.itemHeight = r1;
    }

    public static final /* synthetic */ void access$setItemLayoutProcess$p(OPopoverEntranceMenuView r2, d.h.a.b r3) {
        r2.itemLayoutProcess = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
    }

    public static final /* synthetic */ void access$setItemWidth$p(OPopoverEntranceMenuView r0, int r1) {
        r0.itemWidth = r1;
    }

    public static final /* synthetic */ void access$setItems$p(OPopoverEntranceMenuView r0, ArrayList r1) {
        r0.items = r1;
    }

    public static final /* synthetic */ void access$setOption$p(OPopoverEntranceMenuView r0, int r1) {
        r0.isOption = r1;
    }

    public static final /* synthetic */ void access$setTailImgGetter$p(OPopoverEntranceMenuView r2, d.h.a.b r3) {
        r2.tailImgGetter = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
    }

    public static final /* synthetic */ void access$setTitleSingleLine$p(OPopoverEntranceMenuView r0, boolean r1) {
        r0.titleSingleLine = r1;
    }

    public static final /* synthetic */ void access$setTopDividerVisibility$p(OPopoverEntranceMenuView r0, boolean r1) {
        r0.topDividerVisibility = r1;
    }

    public static final /* synthetic */ void access$setTopView$p(OPopoverEntranceMenuView r0, View r1) {
        r0.topView = r1;
    }

    public static final /* synthetic */ void access$setTopViewHeight$p(OPopoverEntranceMenuView r0, int r1) {
        r0.topViewHeight = r1;
    }

    public static final /* synthetic */ void access$setWidthConstraint$p(OPopoverEntranceMenuView r0, m r1) {
        r0.widthConstraint = r1;
    }

    public OPopoverEntranceMenuView(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        super(r6, r7, r5);
        this.itemLayoutProcess = (d.h.a.b) ZeusTransformUtils.preCheckCast(h.f36023a, d.h.a.b.class, "com.obric.aiagent.plugin");
        this.items = new ArrayList();
        this.itemWidth = com.obric.oui.common.util.g.a(r6, WIDTH_STANDARD_DP);
        this.verticalPadding = com.obric.oui.common.util.g.a(r6, 8);
        this.itemVerticalMargin = com.obric.oui.common.util.g.a(r6, 4);
        if (ZeusTransformUtils.getResources(r6, "com.obric.aiagent.plugin").getConfiguration().orientation != 2) goto L5;
        int r8 = ZeusTransformUtils.getResources(r6, "com.obric.aiagent.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.oui_popover_max_height_landscape, "dimen", "oui_popover_max_height_landscape"));
    L6:
        this.defaultMaxHeight = r8;
        this.maxHeight = r8;
        return;
    L5:
        r8 = ZeusTransformUtils.getResources(r6, "com.obric.aiagent.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.oui_popover_max_height, "dimen", "oui_popover_max_height"));
        goto L6
    }

    private final void initView() {
        setOrientation(1);
        ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), ZeusTransformUtils.mapRes(R.layout.o_view_popover_menu_type, "layout", "o_view_popover_menu_type"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.aiagent.plugin"), true, "com.obric.aiagent.plugin");
        MaxHeightNestedScrollView r0 = (MaxHeightNestedScrollView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.popover_scroll, DbHelper.COL_ID, "popover_scroll")), MaxHeightNestedScrollView.class, "com.obric.aiagent.plugin");
        this.popOverScroll = r0;
        if (r0 == null) goto L6;
        r0.setMaxHeight(this.maxHeight);
    L6:
        MaxHeightNestedScrollView r1 = this.popOverScroll;
        if (r1 == null) goto L10;
        int r4 = this.verticalPadding;
        r1.setPadding(0, r4, 0, r4);
    L10:
        MaxHeightNestedScrollView r2 = this.popOverScroll;
        if (r2 == null) goto L14;
        r2.setScrollBarStyle(33554432);
    L14:
        MaxHeightNestedScrollView r3 = this.popOverScroll;
        if (r3 == null) goto L18;
        r3.setClipToPadding(false);
    L18:
        int r5 = -2;
        if (this.topView == null) goto L28;
        ViewGroup r6 = (ViewGroup) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.top_container, DbHelper.COL_ID, "top_container")), ViewGroup.class, "com.obric.aiagent.plugin");
        r6.addView(this.topView, new ViewGroup.LayoutParams(-1, -2));
        if (this.widthConstraint == null) goto L23;
        r6.getLayoutParams().width = -2;
    L24:
        ViewGroup.LayoutParams r7 = r6.getLayoutParams();
        int r8 = this.topViewHeight;
        if (r8 != 0) goto L27;
        r8 = -2;
    L27:
        r7.height = r8;
        goto L28
    L23:
        r6.getLayoutParams().width = getAvailableItemWidth();
    L28:
        addPopoverItems();
        if (this.bottomView == null) goto L40;
        ViewGroup r9 = (ViewGroup) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.bottom_container, DbHelper.COL_ID, "bottom_container")), ViewGroup.class, "com.obric.aiagent.plugin");
        r9.addView(this.bottomView, new ViewGroup.LayoutParams(-1, -2));
        if (this.widthConstraint == null) goto L33;
        r9.getLayoutParams().width = -2;
    L34:
        ViewGroup.LayoutParams r10 = r9.getLayoutParams();
        int r11 = this.bottomViewHeight;
        if (r11 == 0) goto L38;
        r5 = r11;
    L38:
        r10.height = r5;
        goto L40
    L33:
        r9.getLayoutParams().width = getAvailableItemWidth();
    L40:
        if (this.widthConstraint == null) goto L43;
        measure(0, 0);
        INVOKESTATIC_com_obric_oui_popover_menu_OPopoverEntranceMenuView_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(TAG, "initView, handle widthConstraint: " + this.widthConstraint + ", measuredWidth: " + getMeasuredWidth());
        int r12 = getMeasuredWidth();
        m<Integer, Integer> r13 = this.widthConstraint;
        o.a(r13);
        int r14 = ((Number) ZeusTransformUtils.preCheckCast(r13.a(), Number.class, "com.obric.aiagent.plugin")).intValue();
        m<Integer, Integer> r15 = this.widthConstraint;
        o.a(r15);
        this.itemWidth = n.a(r12, r14, ((Number) ZeusTransformUtils.preCheckCast(r15.b(), Number.class, "com.obric.aiagent.plugin")).intValue());
        this.widthConstraint = null;
        clearViews();
        initView();
        return;
    }

    private final void clearViews() {
        ((FrameLayout) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.top_container, DbHelper.COL_ID, "top_container")), FrameLayout.class, "com.obric.aiagent.plugin")).removeAllViews();
        ((LinearLayout) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.popover_container, DbHelper.COL_ID, "popover_container")), LinearLayout.class, "com.obric.aiagent.plugin")).removeAllViews();
        ((FrameLayout) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.bottom_container, DbHelper.COL_ID, "bottom_container")), FrameLayout.class, "com.obric.aiagent.plugin")).removeAllViews();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void addPopoverItems() {
        int r0 = R.id.popover_container;
        String r7 = DbHelper.COL_ID;
        final LinearLayout r9 = (LinearLayout) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(r0, DbHelper.COL_ID, "popover_container")), LinearLayout.class, "com.obric.aiagent.plugin");
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(this.items, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        boolean r11 = false;
        int r12 = 0;
        int r13 = 0;
    L4:
        if (r10.hasNext() == false) goto L177;
        Object r1 = r10.next();
        int r14 = r12 + 1;
        if (r12 >= 0) goto L8;
        d.a.p.c();
    L8:
        final c r15 = (c) ZeusTransformUtils.preCheckCast(r1, c.class, "com.obric.aiagent.plugin");
        if (r15.k() == 1) goto L10;
        if (r15.k() == 2) goto L13;
        if (r15.o() == false) goto L18;
    L21:
        Object[] r2 = 1;
    L23:
        if (r2 == 0) goto L25;
        View r3 = ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), ZeusTransformUtils.mapRes(R.layout.o_item_popover_menu_filter, "layout", "o_item_popover_menu_filter"), (ViewGroup) ZeusTransformUtils.preCheckCast(r9, ViewGroup.class, "com.obric.aiagent.plugin"), false, "com.obric.aiagent.plugin");
        Objects.requireNonNull(r3, "null cannot be cast to non-null type com.obric.oui.popover.menu.PopoverMenuLinearLayout");
        PopoverMenuLinearLayout r4 = (PopoverMenuLinearLayout) ZeusTransformUtils.preCheckCast(r3, PopoverMenuLinearLayout.class, "com.obric.aiagent.plugin");
    L26:
        PopoverMenuLinearLayout r16 = r4;
        OStateGradientDrawable r5 = new OStateGradientDrawable();
        Context r6 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r6, "context");
        r5.setCornerRadius(com.obric.oui.common.util.g.b(r6, 20));
        ColorStateList r8 = androidx.core.content.a.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.color.o_pop_list_item_bg_color, "color", "o_pop_list_item_bg_color"));
        o.a(r8);
        o.c(r8, "getColorStateList(contex…pop_list_item_bg_color)!!");
        r5.setSolidColors(r8);
        r16.setBackground((Drawable) ZeusTransformUtils.preCheckCast(r5, Drawable.class, "com.obric.aiagent.plugin"));
        LinearLayout r17 = (LinearLayout) ZeusTransformUtils.preCheckCast(r16.findViewById(ZeusTransformUtils.mapRes(R.id.item_container, r7, "item_container")), LinearLayout.class, "com.obric.aiagent.plugin");
        ImageView r18 = (ImageView) ZeusTransformUtils.preCheckCast(r16.findViewById(ZeusTransformUtils.mapRes(R.id.iv_popover_action, r7, "iv_popover_action")), ImageView.class, "com.obric.aiagent.plugin");
        ImageView r19 = (ImageView) ZeusTransformUtils.preCheckCast(r16.findViewById(ZeusTransformUtils.mapRes(R.id.iv_popover_tail_image, r7, "iv_popover_tail_image")), ImageView.class, "com.obric.aiagent.plugin");
        OTextView r20 = (OTextView) ZeusTransformUtils.preCheckCast(r16.findViewById(ZeusTransformUtils.mapRes(R.id.tv_popover_action, r7, "tv_popover_action")), OTextView.class, "com.obric.aiagent.plugin");
        OTextView r21 = (OTextView) ZeusTransformUtils.preCheckCast(r16.findViewById(ZeusTransformUtils.mapRes(R.id.tv_popover_action_sub, r7, "tv_popover_action_sub")), OTextView.class, "com.obric.aiagent.plugin");
        OTextView r22 = (OTextView) ZeusTransformUtils.preCheckCast(r16.findViewById(ZeusTransformUtils.mapRes(R.id.tv_popover_value, r7, "tv_popover_value")), OTextView.class, "com.obric.aiagent.plugin");
        LinearLayout.LayoutParams r25 = null;
        if (r2 == 0) goto L29;
        CheckableImageView r23 = (CheckableImageView) ZeusTransformUtils.preCheckCast(r16.findViewById(ZeusTransformUtils.mapRes(R.id.popover_menu_radio, r7, "popover_menu_radio")), CheckableImageView.class, "com.obric.aiagent.plugin");
    L30:
        View r24 = r16.findViewById(ZeusTransformUtils.mapRes(R.id.popover_badge_default, r7, "popover_badge_default"));
        OBadgeView r26 = (OBadgeView) ZeusTransformUtils.preCheckCast(r16.findViewById(ZeusTransformUtils.mapRes(R.id.popover_badge_number, r7, "popover_badge_number")), OBadgeView.class, "com.obric.aiagent.plugin");
        OBadgeView r27 = (OBadgeView) ZeusTransformUtils.preCheckCast(r16.findViewById(ZeusTransformUtils.mapRes(R.id.popover_badge_ellipsis, r7, "popover_badge_ellipsis")), OBadgeView.class, "com.obric.aiagent.plugin");
        LinearLayout r30 = (LinearLayout) ZeusTransformUtils.preCheckCast(r16.findViewById(ZeusTransformUtils.mapRes(R.id.ll_popover_text_container, r7, "ll_popover_text_container")), LinearLayout.class, "com.obric.aiagent.plugin");
        a.C0972a r28 = r15.l();
        if (r28 == null) goto L44;
        int r29 = d.f36016a[r28.a().ordinal()];
        if (r29 != 1) goto L36;
        r24.setVisibility(0);
    L43:
        x r31 = x.f38692a;
        x r32 = x.f38692a;
        goto L44
    L36:
        if (r29 != 2) goto L38;
        r26.setVisibility(0);
        r26.setMaxNumberInCount(r28.c());
        r26.setText((CharSequence) ZeusTransformUtils.preCheckCast(String.valueOf(r28.b()), CharSequence.class, "com.obric.aiagent.plugin"));
        goto L43
    L38:
        if (r29 != 3) goto L43;
        r27.setVisibility(0);
    L44:
        if (r23 != null) goto L47;
    L51:
        final CheckableImageView r33 = r23;
        Iterator r110 = r10;
        int r210 = r12;
        final int r34 = r13;
        r16.setOnClickListener(new $$Lambda$OPopoverEntranceMenuView$hVk0WmBtnSAuj4vrYElkp8z7KA(r15, r33, r9, this, r34));
        if (this.widthConstraint == null) goto L54;
        r16.getLayoutParams().width = -2;
    L56:
        if (r15.f() != null) goto L61;
        r21.setVisibility(8);
        ViewGroup.LayoutParams r35 = r16.getLayoutParams();
        int r36 = this.itemHeight;
        if (r36 != 0) goto L60;
        r36 = -2;
    L60:
        r35.height = r36;
    L65:
        r21.setText(r15.f());
        r22.setText(r15.g());
        if (TextUtils.isEmpty(r15.g()) == false) goto L68;
        int r37 = 8;
    L69:
        r22.setVisibility(r37);
        if (this.items.size() != 1) goto L79;
        r16.setIndexPos(PopoverMenuLinearLayout.a.f36034d);
        ViewGroup.LayoutParams r38 = r16.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r38, LinearLayout.LayoutParams.class) == false) goto L74;
        LinearLayout.LayoutParams r39 = (LinearLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r38, LinearLayout.LayoutParams.class, "com.obric.aiagent.plugin");
    L75:
        if (r39 == null) goto L97;
        r39.topMargin = 0;
        r39.bottomMargin = 0;
        x r40 = x.f38692a;
    L97:
        int r41 = 0;
    L98:
        registerPressedCallback(r16);
        if (r15.b() == 0) goto L107;
        ImageView r42 = r18;
        r42.setVisibility(r41);
        d.h.a.b<? super Integer, ? extends Drawable> r43 = this.imgGetter;
        if (r43 == null) goto L106;
        if (r43 != null) goto L104;
        Drawable r44 = null;
    L105:
        r42.setImageDrawable(r44);
    L109:
        if (r15.c() == 0) goto L117;
        ImageView r45 = r19;
        r45.setVisibility(0);
        d.h.a.b<? super Integer, ? extends Drawable> r46 = this.tailImgGetter;
        if (r46 == null) goto L116;
        if (r46 != null) goto L114;
        Drawable r47 = null;
    L115:
        r45.setImageDrawable(r47);
    L119:
        if (r15.e() == null) goto L121;
        OTextView r48 = r20;
        r48.setText(r15.e());
    L122:
        r48.setSingleLine(this.titleSingleLine);
        r48.setEllipsize(TextUtils.TruncateAt.END);
        if (this.titleSingleLine == false) goto L125;
        int r49 = 1;
    L126:
        r48.setMaxLines(r49);
        if (r15.d() == 0) goto L129;
        r42.setImageTintList(ColorStateList.valueOf(r15.d()));
        r45.setImageTintList(ColorStateList.valueOf(r15.d()));
    L129:
        Integer r50 = r15.m();
        if (r50 == null) goto L134;
        r48.setTextColor(((Number) ZeusTransformUtils.preCheckCast(r50, Number.class, "com.obric.aiagent.plugin")).intValue());
        x r51 = x.f38692a;
    L134:
        if (getForceDark() == false) goto L136;
        String r111 = "color";
        int r52 = androidx.core.content.a.c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.color.ConstTextInverse2, r111, "ConstTextInverse2"));
        r48.setTextColor(r52);
        r42.setImageTintList(ColorStateList.valueOf(r52));
        r45.setImageTintList(ColorStateList.valueOf(r52));
        r16.setForceDark(true);
    L138:
        if (r15.h() == false) goto L141;
        int r53 = androidx.core.content.a.c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.color.Negative, r111, "Negative"));
        r48.setTextColor(r53);
        r42.setImageTintList(ColorStateList.valueOf(r53));
    L141:
        if (r33 != null) goto L144;
        boolean r54 = false;
    L176:
        this.itemLayoutProcess.invoke(r16);
        applyItemEnabledState(r16, r15.i());
        r9.addView((View) ZeusTransformUtils.preCheckCast(r16, View.class, "com.obric.aiagent.plugin"));
        r13 = r13 + 1;
        r11 = r54;
        r10 = r110;
        r12 = r14;
        r7 = r7;
        goto L4
    L144:
        if (r15.d() == 0) goto L146;
        int r55 = r15.d();
    L147:
        r33.setImageTintList(ColorStateList.valueOf(r55));
        r33.setVisibility(0);
        r33.setChecked(r15.n());
        if (r15.p() == false) goto L174;
        ViewGroup.LayoutParams r56 = r33.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r56, LinearLayout.LayoutParams.class) == false) goto L152;
        LinearLayout.LayoutParams r57 = (LinearLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r56, LinearLayout.LayoutParams.class, "com.obric.aiagent.plugin");
    L153:
        if (r57 != null) goto L155;
        String r58 = "context";
        r54 = false;
    L156:
        r17.removeView((View) ZeusTransformUtils.preCheckCast(r33, View.class, "com.obric.aiagent.plugin"));
        r17.addView((View) ZeusTransformUtils.preCheckCast(r33, View.class, "com.obric.aiagent.plugin"));
        ViewGroup.LayoutParams r59 = r42.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r59, LinearLayout.LayoutParams.class) == false) goto L159;
        LinearLayout.LayoutParams r60 = (LinearLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r59, LinearLayout.LayoutParams.class, "com.obric.aiagent.plugin");
    L161:
        if (r60 == null) goto L165;
        Context r61 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r61, r58);
        r60.setMarginStart(com.obric.oui.common.util.g.a(r61, 12));
        x r62 = x.f38692a;
    L165:
        if (r42.getVisibility() != 8) goto L175;
        if (r30 == null) goto L175;
        ViewGroup.LayoutParams r63 = r30.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r63, LinearLayout.LayoutParams.class) == false) goto L170;
        r25 = (LinearLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r63, LinearLayout.LayoutParams.class, "com.obric.aiagent.plugin");
    L170:
        LinearLayout.LayoutParams r64 = r25;
        if (r64 == null) goto L175;
        Context r65 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r65, r58);
        r64.setMarginStart(com.obric.oui.common.util.g.a(r65, 12));
        x r66 = x.f38692a;
    L175:
        x r67 = x.f38692a;
        x r68 = x.f38692a;
        goto L176
    L159:
        r60 = null;
        goto L161
    L155:
        r54 = false;
        r57.setMarginStart(0);
        Context r69 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        r58 = "context";
        o.c(r69, r58);
        r57.setMarginEnd(com.obric.oui.common.util.g.a(r69, 8));
        x r70 = x.f38692a;
        goto L156
    L152:
        r57 = null;
        goto L153
    L174:
        r54 = false;
        goto L175
    L146:
        r55 = androidx.core.content.a.c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.color.oui_accent_fg, r111, "oui_accent_fg"));
        goto L147
    L136:
        r111 = "color";
        goto L138
    L125:
        r49 = MAX_LINES;
        goto L126
    L121:
        r48 = r20;
        goto L122
    L114:
        r47 = (Drawable) ZeusTransformUtils.preCheckCast(r46.invoke(Integer.valueOf(r15.c())), Drawable.class, "com.obric.aiagent.plugin");
        goto L115
    L116:
        r45.setImageResource(r15.c());
        goto L119
    L117:
        r45 = r19;
        r45.setVisibility(8);
        goto L119
    L104:
        r44 = (Drawable) ZeusTransformUtils.preCheckCast(r43.invoke(Integer.valueOf(r15.b())), Drawable.class, "com.obric.aiagent.plugin");
        goto L105
    L106:
        r42.setImageResource(r15.b());
        goto L109
    L107:
        r42 = r18;
        r42.setVisibility(8);
        goto L109
    L74:
        r39 = null;
        goto L75
    L79:
        if (r210 != (this.items.size() - 1)) goto L87;
        r16.setIndexPos(PopoverMenuLinearLayout.a.f36032b);
        ViewGroup.LayoutParams r71 = r16.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r71, LinearLayout.LayoutParams.class) == false) goto L83;
        LinearLayout.LayoutParams r72 = (LinearLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r71, LinearLayout.LayoutParams.class, "com.obric.aiagent.plugin");
    L84:
        if (r72 == null) goto L97;
        r72.topMargin = 0;
        r72.bottomMargin = 0;
        x r73 = x.f38692a;
        goto L97
    L83:
        r72 = null;
        goto L84
    L87:
        if (r210 < 0) goto L97;
        if (r210 != 0) goto L90;
        r16.setIndexPos(PopoverMenuLinearLayout.a.f36031a);
    L90:
        ViewGroup.LayoutParams r74 = r16.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r74, LinearLayout.LayoutParams.class) == false) goto L93;
        LinearLayout.LayoutParams r75 = (LinearLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r74, LinearLayout.LayoutParams.class, "com.obric.aiagent.plugin");
    L94:
        if (r75 == null) goto L97;
        r41 = 0;
        r75.topMargin = 0;
        r75.bottomMargin = this.itemVerticalMargin;
        x r76 = x.f38692a;
        goto L98
    L93:
        r75 = null;
        goto L94
    L68:
        r37 = 0;
        goto L69
    L61:
        r21.setVisibility(0);
        ViewGroup.LayoutParams r77 = r16.getLayoutParams();
        int r78 = this.itemHeight;
        if (r78 != 0) goto L64;
        r78 = -2;
    L64:
        r77.height = r78;
        goto L65
    L54:
        r16.getLayoutParams().width = getAvailableItemWidth();
        goto L56
    L47:
        if (r15.a() == false) goto L49;
        int r79 = 0;
    L50:
        r23.setVisibility(r79);
        goto L51
    L49:
        r79 = 4;
        goto L50
    L29:
        r23 = null;
        goto L30
    L25:
        View r80 = ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), ZeusTransformUtils.mapRes(R.layout.o_item_popover_menu_type, "layout", "o_item_popover_menu_type"), (ViewGroup) ZeusTransformUtils.preCheckCast(r9, ViewGroup.class, "com.obric.aiagent.plugin"), false, "com.obric.aiagent.plugin");
        Objects.requireNonNull(r80, "null cannot be cast to non-null type com.obric.oui.popover.menu.PopoverMenuLinearLayout");
        r4 = (PopoverMenuLinearLayout) ZeusTransformUtils.preCheckCast(r80, PopoverMenuLinearLayout.class, "com.obric.aiagent.plugin");
        goto L26
    L18:
        if (r15.p() == true) goto L21;
        r2 = r11 ? 1 : 0;
        goto L23
    L13:
        View r81 = ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), ZeusTransformUtils.mapRes(R.layout.o_item_popover_menu_sectionbar, "layout", "o_item_popover_menu_sectionbar"), (ViewGroup) ZeusTransformUtils.preCheckCast(r9, ViewGroup.class, "com.obric.aiagent.plugin"), r11, "com.obric.aiagent.plugin");
        Objects.requireNonNull(r81, "null cannot be cast to non-null type com.obric.oui.sectiontitlebar.OSectionTitleBar");
        OSectionTitleBar r82 = (OSectionTitleBar) ZeusTransformUtils.preCheckCast(r81, OSectionTitleBar.class, "com.obric.aiagent.plugin");
        r82.setTitleText((CharSequence) ZeusTransformUtils.preCheckCast(String.valueOf(r15.e()), CharSequence.class, "com.obric.aiagent.plugin"));
        LinearLayout.LayoutParams r83 = new LinearLayout.LayoutParams(-1, -2);
        r83.bottomMargin = this.itemVerticalMargin;
        r9.addView((View) ZeusTransformUtils.preCheckCast(r82, View.class, "com.obric.aiagent.plugin"), (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r83, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
    L14:
        r12 = r14;
        goto L4
    L10:
        Context r84 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r84, "context");
        ODivider r85 = new ODivider(r84, null, 0, 6, null);
        r85.setBackground(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getDrawable(ZeusTransformUtils.mapRes(R.drawable.o_item_vertical_divider, "drawable", "o_item_vertical_divider")));
        Context r86 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r86, "context");
        int r87 = com.obric.oui.common.util.g.a(r86, 8);
        r85.setPadding(r87, r11 ? 1 : 0, r87, r11 ? 1 : 0);
        ViewGroup.MarginLayoutParams r88 = new ViewGroup.MarginLayoutParams(-1, -2);
        r88.leftMargin = ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.oui_popover_divider_margin, "dimen", "oui_popover_divider_margin"));
        r88.rightMargin = r88.leftMargin;
        r88.bottomMargin = this.itemVerticalMargin;
        r9.addView((View) ZeusTransformUtils.preCheckCast(r85, View.class, "com.obric.aiagent.plugin"), (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r88, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        goto L14
    }

    /* JADX INFO: renamed from: addPopoverItems$lambda-12$lambda-3, reason: not valid java name */
    private static final void m1130addPopoverItems$lambda12$lambda3(final c r7, CheckableImageView r8, LinearLayout r9, OPopoverEntranceMenuView r10, final int r11, final View r12) {
        o.e(r7, "$item");
        o.e(r10, "this$0");
        if (r7.a() == false) goto L19;
        if (r8 == null) goto L19;
        boolean r0 = !r8.isChecked();
        if (r10.isOption != 1) goto L18;
        int r13 = r9.getChildCount();
        int r2 = 0;
    L9:
        if (r2 >= r13) goto L17;
        int r3 = r2 + 1;
        View r4 = r9.getChildAt(r2);
        if (ZeusTransformUtils.instanceOf(r4, PopoverMenuLinearLayout.class) == false) goto L16;
        CheckableImageView r5 = (CheckableImageView) ZeusTransformUtils.preCheckCast(r4.findViewById(ZeusTransformUtils.mapRes(R.id.popover_menu_radio, DbHelper.COL_ID, "popover_menu_radio")), CheckableImageView.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L16;
        r5.setChecked(false);
    L16:
        r2 = r3;
        goto L9
    L17:
        r8.setChecked(true);
        goto L19
    L18:
        r8.setChecked(r0);
    L19:
        r9.post(new $$Lambda$OPopoverEntranceMenuView$B00oiyAGO4JJCyVGkNRthSSf0fo(r7, r12, r11));
    }

    /* JADX INFO: renamed from: addPopoverItems$lambda-12$lambda-3$lambda-2, reason: not valid java name */
    private static final void m1131addPopoverItems$lambda12$lambda3$lambda2(c r1, View r2, int r3) {
        o.e(r1, "$item");
        d.h.a.m<View, Integer, x> r4 = r1.j();
        if (r4 == null) goto L7;
        o.c(r2, "it");
        r4.invoke(r2, Integer.valueOf(r3));
        return;
    }

    private final void applyItemEnabledState(PopoverMenuLinearLayout r1, boolean r2) {
        r1.setEnabled(r2);
        r1.setClickable(r2);
        if (r2 == false) goto L5;
        float r0 = 1.0f;
    L6:
        r1.setAlpha(r0);
        return;
    L5:
        r0 = DISABLED_ALPHA;
        goto L6
    }

    private final c findItemByPosition(int r4) {
        if (r4 >= 0) goto L6;
        return null;
    L6:
        return (c) ZeusTransformUtils.preCheckCast(d.n.m.a(d.n.m.a(d.a.p.y((Iterable) ZeusTransformUtils.preCheckCast(this.items, Iterable.class, "com.obric.aiagent.plugin")), (d.h.a.b) ZeusTransformUtils.preCheckCast(f.f36021a, d.h.a.b.class, "com.obric.aiagent.plugin")), r4), c.class, "com.obric.aiagent.plugin");
    }

    public final void setItemEnabled(int r2, boolean r3) {
        PopoverMenuLinearLayout r0 = getItemView(r2);
        if (r0 != null) goto L5;
        return;
    L5:
        applyItemEnabledState(r0, r3);
        c r1 = findItemByPosition(r2);
        if (r1 != null) goto L9;
        INVOKESTATIC_com_obric_oui_popover_menu_OPopoverEntranceMenuView_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(TAG, o.a("setItemEnabled: no item model for position=", Integer.valueOf(r2)));
        return;
    L9:
        r1.a(r3);
    }

    public final PopoverMenuLinearLayout getItemView(int r5) {
        if (r5 >= 0) goto L6;
        INVOKESTATIC_com_obric_oui_popover_menu_OPopoverEntranceMenuView_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(TAG, o.a("getItemView: invalid position=", Integer.valueOf(r5)));
        return null;
    L6:
        LinearLayout r4 = (LinearLayout) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.popover_container, DbHelper.COL_ID, "popover_container")), LinearLayout.class, "com.obric.aiagent.plugin");
        o.c(r4, "popoverContainer");
        PopoverMenuLinearLayout r6 = (PopoverMenuLinearLayout) ZeusTransformUtils.preCheckCast(d.n.m.a(d.n.m.a(ab.b((ViewGroup) ZeusTransformUtils.preCheckCast(r4, ViewGroup.class, "com.obric.aiagent.plugin")), (d.h.a.b) ZeusTransformUtils.preCheckCast(g.f36022a, d.h.a.b.class, "com.obric.aiagent.plugin")), r5), PopoverMenuLinearLayout.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L9;
        INVOKESTATIC_com_obric_oui_popover_menu_OPopoverEntranceMenuView_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(TAG, o.a("getItemView: no item view for position=", Integer.valueOf(r5)));
    L9:
        return r6;
    }

    private final int getAvailableItemWidth() {
        return this.itemWidth;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int r4, int r5) {
        int r0 = View.MeasureSpec.getMode(r5);
        int r6 = View.MeasureSpec.getSize(r5);
        if (r0 != Integer.MIN_VALUE) goto L5;
        int r7 = View.MeasureSpec.makeMeasureSpec(n.d(r6, this.maxHeight), Integer.MIN_VALUE);
    L9:
        super.onMeasure(r4, r7);
        if (getMeasuredHeight() <= this.maxHeight) goto L13;
        setMeasuredDimension(getMeasuredWidth(), this.maxHeight);
        return;
    L13:
        return;
    L5:
        if (r0 == 1073741824) goto L7;
        r7 = View.MeasureSpec.makeMeasureSpec(this.maxHeight, Integer.MIN_VALUE);
        goto L9
    L7:
        r7 = View.MeasureSpec.makeMeasureSpec(n.d(r6, this.maxHeight), 1073741824);
        goto L9
    }

    @Override // com.obric.oui.popover.menu.OPopoverMenuView
    public void setPopoverMaxHeight(int r3) {
        int r4 = n.d(n.c(r3, com.obric.oui.common.util.g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), MIN_AVAILABLE_HEIGHT_DP)), this.defaultMaxHeight);
        if (this.maxHeight != r4) goto L5;
        return;
    L5:
        this.maxHeight = r4;
        MaxHeightNestedScrollView r0 = this.popOverScroll;
        if (r0 == null) goto L9;
        r0.setMaxHeight(r4);
    L9:
        requestLayout();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }

    static {
        Companion = new b(null);
        WIDTH_STANDARD_DP = 184;
        WIDTH_BROAD_DP = 208;
        MAX_LINES = 6;
        MIN_AVAILABLE_HEIGHT_DP = 40;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_oui_popover_menu_OPopoverEntranceMenuView_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_oui_popover_menu_OPopoverEntranceMenuView_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2);
    }
}
