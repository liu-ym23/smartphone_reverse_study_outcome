package com.bytedance.android.livesdk.interactivity.interactive.dialog.provider;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.GravityCompat;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.GradientEditText;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.ui.t9;
import com.bytedance.android.livesdk.chatroom.ui.u9;
import com.bytedance.android.livesdk.interactivity.interactive.dialog.SkinSelection;
import com.bytedance.android.livesdk.interactivity.interactive.dialog.VSMsgBoardPortraitInputDialog;
import com.bytedance.android.livesdk.interactivity.interactive.dialog.framework.VSInputSectionType;
import com.bytedance.android.livesdk.log.b0;
import com.facebook.drawee.drawable.RoundedColorDrawable;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.larus.nova.R;
import io.reactivex.disposables.CompositeDisposable;
import java.lang.reflect.Field;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a implements k82.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public k82.a f137248a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final VSInputSectionType f137249b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CompositeDisposable f137250c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public k82.c f137251d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c f137252e;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.interactivity.interactive.dialog.provider.a$a, reason: collision with other inner class name */
    public static final class C2177a {
    }

    public final class b extends k82.c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public FrameLayout f137253c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public FrameLayout f137254d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public EditText f137255e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public TextView f137256f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public HSImageView f137257g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public View f137258h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public View f137259i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public HSImageView f137260j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public TextView f137261k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public HSImageView f137262l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public ImageView f137263m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public TextView f137264n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public String f137265o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final float f137266p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final CopyOnWriteArrayList<TextWatcher> f137267q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public int f137268r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public final g f137269s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public final /* synthetic */ a f137270t;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.interactivity.interactive.dialog.provider.a$b$a, reason: collision with other inner class name */
        public static final class C2178a implements ValueAnimator.AnimatorUpdateListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f137271a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ boolean f137272b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ boolean f137273c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ boolean f137274d;

            public C2178a(b r100, boolean r101, boolean r102, boolean r103) {
                this.f137271a = r100;
                this.f137272b = r101;
                this.f137273c = r102;
                this.f137274d = r103;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator r100) {
                Intrinsics.checkNotNullParameter(r100, "it");
                FrameLayout r101 = this.f137271a.f137254d;
                if (r101 == null) goto L39;
                ViewGroup.LayoutParams r102 = r101.getLayoutParams();
                if (r102 == null) goto L38;
                LinearLayout.LayoutParams r103 = (LinearLayout.LayoutParams) r102;
                if (this.f137272b == false) goto L21;
                r103.height = (int) (s1.f(35.0f) * r100.getAnimatedFraction());
                r101.setLayoutParams(r103);
                r101.requestLayout();
                HSImageView r104 = this.f137271a.f137260j;
                if (r104 == null) goto L11;
                r104.setAlpha(r100.getAnimatedFraction());
            L11:
                TextView r105 = this.f137271a.f137261k;
                if (r105 == null) goto L14;
                r105.setAlpha(r100.getAnimatedFraction());
            L14:
                HSImageView r106 = this.f137271a.f137262l;
                if (r106 == null) goto L17;
                r106.setAlpha(r100.getAnimatedFraction());
            L17:
                ImageView r107 = this.f137271a.f137263m;
                if (r107 == null) goto L20;
                r107.setAlpha(r100.getAnimatedFraction());
            L20:
                UtilityKotlinExtentionsKt.z(r101, true);
                return;
            L21:
                float r108 = 1;
                r103.height = (int) (s1.f(35.0f) * (r108 - r100.getAnimatedFraction()));
                r101.setLayoutParams(r103);
                r101.requestLayout();
                HSImageView r109 = this.f137271a.f137260j;
                if (r109 == null) goto L24;
                r109.setAlpha(r108 - r100.getAnimatedFraction());
            L24:
                TextView r110 = this.f137271a.f137261k;
                if (r110 == null) goto L27;
                r110.setAlpha(r108 - r100.getAnimatedFraction());
            L27:
                HSImageView r111 = this.f137271a.f137262l;
                if (r111 == null) goto L30;
                r111.setAlpha(r108 - r100.getAnimatedFraction());
            L30:
                ImageView r112 = this.f137271a.f137263m;
                if (r112 == null) goto L34;
                r112.setAlpha(r108 - r100.getAnimatedFraction());
            L34:
                if (r100.getAnimatedFraction() < r108) goto L36;
                UtilityKotlinExtentionsKt.z(r101, false);
                this.f137271a.f(false, this.f137273c, this.f137274d);
                return;
            L36:
                UtilityKotlinExtentionsKt.z(r101, true);
                this.f137271a.f(true, this.f137273c, this.f137274d);
                return;
            L38:
                throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            }
        }

        @Override // k82.c
        public final void a() {
            this.f137270t.f137250c.clear();
            this.f137267q.clear();
        }

        public final void c() {
            ImageUtil.loadRoundImage(this.f137260j, fq1.t.a().h());
            TextView r100 = this.f137261k;
            if (r100 == null) goto L6;
            r100.setText(fq1.t.a().i());
            return;
        }

        public final void e() {
            t9 r100 = this.f502091b.s();
            String r101 = null;
            if (r100 == null) goto L5;
            String r102 = r100.f114218b;
        L6:
            if (r102 == null) goto L13;
            TextView r103 = this.f137264n;
            if (r103 == null) goto L17;
            t9 r104 = this.f502091b.s();
            if (r104 == null) goto L12;
            r101 = r104.f114218b;
        L12:
            r103.setText(r101);
            return;
        L17:
            return;
        L13:
            TextView r105 = this.f137264n;
            if (r105 == null) goto L19;
            r105.setText(R.string.ttlive_say_something);
            return;
        L19:
            return;
        L5:
            r102 = null;
            goto L6
        }

        public static final void b(b r100) {
            TextView r101 = r100.f137264n;
            String r102 = null;
            if (r101 == null) goto L5;
            r101.setOnClickListener(null);
        L5:
            FrameLayout r103 = r100.f137253c;
            if (r103 == null) goto L8;
            UtilityKotlinExtentionsKt.z(r103, true);
        L8:
            r100.e();
            if (TextUtils.isEmpty(r100.f137265o) == false) goto L16;
            k82.a r104 = r100.f137270t.f137248a;
            if (r104 == null) goto L13;
            r104.d(false);
        L13:
            TextView r105 = r100.f137264n;
            if (r105 == null) goto L22;
            UtilityKotlinExtentionsKt.w(r105);
        L22:
            int r106 = n82.c.k("#161823", -1);
            View r107 = r100.f137259i;
            if (r107 == null) goto L30;
            t9 r108 = r100.f502091b.s();
            if (r108 == null) goto L29;
            u9 r109 = r108.f114219c;
            if (r109 == null) goto L29;
            r102 = r109.f114254d;
        L29:
            r107.setBackground(new RoundedColorDrawable(UtilityKotlinExtentionsKt.h(12), ColorUtils.setAlphaComponent(n82.c.k(r102, r106), (int) 12.75f)));
        L30:
            FrameLayout r110 = r100.f137254d;
            if (r110 != null) goto L33;
        L35:
            r100.f(false, false, false);
            return;
        L33:
            if (r110.getVisibility() != 0) goto L35;
            r100.d(false, false, false);
            return;
        L16:
            k82.a r111 = r100.f137270t.f137248a;
            if (r111 == null) goto L19;
            r111.d(true);
        L19:
            TextView r112 = r100.f137264n;
            if (r112 == null) goto L22;
            UtilityKotlinExtentionsKt.t(r112);
            goto L22
        }

        public b(a r100, View r101, h82.b r102) {
            Intrinsics.checkNotNullParameter(r101, "view");
            Intrinsics.checkNotNullParameter(r102, "panelBridge");
            this.f137270t = r100;
            super(r101, r102);
            this.f137265o = "";
            this.f137266p = 15.0f;
            this.f137267q = new CopyOnWriteArrayList();
            this.f137269s = new g(this, r102);
        }

        public final void d(boolean r100, boolean r101, boolean r102) {
            ValueAnimator r103 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(300);
            r103.addUpdateListener(new C2178a(this, r100, r101, r102));
            r103.setInterpolator(new om3.d());
            r103.start();
        }

        public final void f(boolean r100, boolean r101, boolean r102) {
            HSImageView r103 = this.f137260j;
            if (r103 == null) goto L5;
            UtilityKotlinExtentionsKt.z(r103, r100);
        L5:
            TextView r104 = this.f137261k;
            if (r104 == null) goto L8;
            UtilityKotlinExtentionsKt.z(r104, r100);
        L8:
            if (r100 == false) goto L15;
            HSImageView r105 = this.f137262l;
            if (r105 == null) goto L12;
            UtilityKotlinExtentionsKt.z(r105, r102);
        L12:
            ImageView r106 = this.f137263m;
            if (r106 == null) goto L22;
            UtilityKotlinExtentionsKt.z(r106, r101);
            return;
        L22:
            return;
        L15:
            HSImageView r107 = this.f137262l;
            if (r107 == null) goto L18;
            UtilityKotlinExtentionsKt.z(r107, false);
        L18:
            ImageView r108 = this.f137263m;
            if (r108 == null) goto L24;
            UtilityKotlinExtentionsKt.z(r108, false);
            return;
        }
    }

    public static final class c implements j82.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f137275a;

        @Override // j82.a
        public final void c() {
            k82.a r100 = this.f137275a.f137248a;     // Catch: Exception -> L16
            if (r100 == null) goto L9;
            EditText r101 = r100.f502082a;     // Catch: Exception -> L16
            if (r101 == null) goto L9;
            Editable r102 = r101.getText();     // Catch: Exception -> L16
            if (r102 == null) goto L9;
            int r103 = r102.length();     // Catch: Exception -> L16
        L10:
            k82.a r104 = this.f137275a.f137248a;     // Catch: Exception -> L16
            if (r104 == null) goto L21;
            EditText r105 = r104.f502082a;     // Catch: Exception -> L16
            if (r105 == null) goto L22;
            r105.setSelection(r103);     // Catch: Exception -> L16
            return;
        L22:
            return;
        L21:
            return;
        L9:
            r103 = 0;
        L16:
            e = move-exception;
            b0 r106 = b0.o();
            StackTraceElement[] r107 = e.getStackTrace();
            r106.getClass();
            com.bytedance.android.live.core.log.g.m(6, r107);
        }

        @Override // j82.a
        public final int e() {
            k82.c r100 = this.f137275a.f137251d;
            if (r100 == null) goto L7;
            return ((b) r100).f137268r;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.interactivity.interactive.dialog.provider.VSMsgBoardContentSectionProvider.ContentSectionController");
        }

        public c(a r100) {
            this.f137275a = r100;
        }

        @Override // j82.a
        public final void f(SkinSelection r100) {
            k82.c r101 = this.f137275a.f137251d;
            if ((r101 instanceof b) == true) goto L5;
            r101 = null;
        L5:
            b r102 = (b) r101;
            if (r102 == null) goto L11;
            View r103 = r102.f502090a;
            if (r103 == null) goto L12;
            r103.post(new h(r102, r100));
            return;
        L12:
            return;
        }
    }

    static {
    }

    @Override // k82.d
    public final void a() {
    }

    @Override // k82.d
    public final void e() {
    }

    @Override // k82.d
    public final void d() {
        k82.c r100 = this.f137251d;
        if (r100 == null) goto L6;
        r100.a();
        return;
    }

    public a() {
        this.f137249b = VSInputSectionType.CONTENT;
        this.f137250c = new CompositeDisposable();
        this.f137252e = new c(this);
    }

    @Override // k82.d
    public final VSInputSectionType b() {
        return this.f137249b;
    }

    @Override // k82.d
    public final k82.c c() {
        return this.f137251d;
    }

    @Override // k82.d
    public final View g(h82.b r110) {
        Intrinsics.checkNotNullParameter(r110, "panelBridge");
        Activity r100 = r110.getActivity();
        String r101 = null;
        if (r100 != null) goto L5;
        return null;
    L5:
        this.f137248a = r110;
        LayoutInflater r102 = LayoutInflater.from(r100);
        t9 r103 = r110.f484061h.f137180d;
        if (r103 != null) goto L8;
    L10:
        if (r103 != null) goto L12;
    L14:
        int r104 = R.layout.ttlive_view_input_content_vs_landscape;
    L15:
        View r105 = r102.inflate(r104, null);
        b r106 = new b(this, r105, r110);
        r106.f137253c = (FrameLayout) r106.f502090a.findViewById(R.id.edit_text_container);
        View r111 = r106.f502090a;
        k82.a r107 = r106.f137270t.f137248a;
        if (r107 == null) goto L19;
        Context r108 = r107.getContext();
        if (r108 == null) goto L19;
    L20:
        FrameLayout r112 = r106.f137253c;
        if (r112 == null) goto L23;
        r112.getPaddingRight();
    L23:
        GradientEditText r113 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.g().a(r108, VSMsgBoardPortraitInputDialog.f137194x);
        FrameLayout.LayoutParams r109 = new FrameLayout.LayoutParams(-1, -1);
        r109.gravity = GravityCompat.START;
        r113.setGravity(8388659);
        r113.setLayoutParams(r109);
        r113.setImeOptions(268435460);
        r113.setInputType(1);
        r113.setLineSpacing(s1.f(3.0f), r113.getLineSpacingMultiplier());
        r113.setTextAlignment(5);
        r113.setTextColor(s1.h(R.color.ttlive_live_input_text_color));
        r113.setTextSize(1, r106.f137266p);
        r113.setInputType(131072);
        r113.setSingleLine(false);
        r113.setPadding(0, 0, 0, 0);
        k82.a r114 = r106.f137270t.f137248a;
        if (r114 == null) goto L28;
        t9 r115 = r114.s();
        if (r115 == null) goto L28;
        int r116 = r115.f114226j;
    L29:
        r113.setMaxLines(r116);
        k82.a r117 = r106.f137270t.f137248a;
        if (r117 == null) goto L34;
        t9 r118 = r117.s();
        if (r118 == null) goto L34;
        int r119 = r118.f114227k;
    L35:
        r113.setMinLines(r119);
        r113.setHorizontallyScrolling(false);
        r113.setOnEditorActionListener(f.f137281a);
        r113.setBackground(null);
        Field r120 = TextView.class.getDeclaredField("mCursorDrawableRes");     // Catch: Exception -> L38
        r120.setAccessible(true);     // Catch: Exception -> L38
        r120.set(r113, Integer.valueOf(R.drawable.ttlive_edit_text_cursor_drawable_red));     // Catch: Exception -> L38
    L40:
        FrameLayout r121 = r106.f137253c;
        if (r121 == null) goto L43;
        r121.addView(r113);
    L43:
        r106.f137255e = r113;
        r106.f137264n = (TextView) r106.f502090a.findViewById(R.id.edit_text_hint);
        r106.f137256f = (TextView) r106.f502090a.findViewById(R.id.title_tv);
        r106.f137257g = (HSImageView) r106.f502090a.findViewById(R.id.title_iv);
        r106.f137258h = r106.f502090a.findViewById(R.id.top_container);
        r106.f137260j = (HSImageView) r106.f502090a.findViewById(R.id.ttlive_input_content_decoration_head);
        r106.f137261k = (TextView) r106.f502090a.findViewById(R.id.ttlive_input_content_decoration_nickname);
        r106.f137259i = r106.f502090a.findViewById(R.id.ttlive_input_content_decoration_container);
        r106.f137262l = (HSImageView) r106.f502090a.findViewById(R.id.ttlive_input_content_decoration_badge);
        r106.f137263m = (ImageView) r106.f502090a.findViewById(R.id.ttlive_input_content_decoration_gradient);
        r106.f137254d = (FrameLayout) r106.f502090a.findViewById(R.id.ttlive_input_content_top_decoration);
        t9 r122 = r106.f502091b.s();
        if (r122 == null) goto L48;
        u9 r123 = r122.f114219c;
        if (r123 == null) goto L48;
        u9.a r124 = r123.f114252b;
    L49:
        k82.a r125 = r106.f137270t.f137248a;
        if (r125 == null) goto L101;
        t9 r126 = r125.s();
        if (r126 == null) goto L101;
        if (r126.f114225i != true) goto L101;
        if (r124 == null) goto L57;
        String r127 = r124.f114258b;
    L59:
        if (TextUtils.isEmpty(r127) == false) goto L66;
        if (r124 == null) goto L62;
        String r128 = r124.f114259c;
    L64:
        if (TextUtils.isEmpty(r128) == false) goto L66;
    L62:
        r128 = null;
    L66:
        if (r124 == null) goto L104;
        View r129 = r106.f137258h;
        if (r129 == null) goto L70;
        UtilityKotlinExtentionsKt.w(r129);
    L70:
        int r130 = r124.f114257a;
        if (r130 != 1) goto L73;
        TextView r131 = r106.f137256f;
        if (r131 == null) goto L92;
        r131.setText(r124.f114258b);
    L92:
        TextView r132 = r106.f137256f;
        if (r132 == null) goto L95;
        int r133 = n82.c.f518247a;
        r132.setTextColor(n82.c.k(r124.f114260d, n82.c.k("#161823", -1)));
    L95:
        TextView r134 = r106.f137256f;
        if (r134 == null) goto L98;
        UtilityKotlinExtentionsKt.w(r134);
    L98:
        HSImageView r135 = r106.f137257g;
        if (r135 == null) goto L104;
        UtilityKotlinExtentionsKt.t(r135);
        goto L104
    L73:
        if (r130 != 2) goto L104;
        String r136 = r124.f114259c;
        if (r136 == null) goto L83;
        py.k r137 = (py.k) vh7.f.c(py.k.class);
        r137.setUrls(CollectionsKt.listOf(r136));
        HSImageView r138 = r106.f137257g;
        if (r138 == null) goto L82;
        GenericDraweeHierarchy r139 = r138.getHierarchy();
        if (r139 == null) goto L82;
        r139.setActualImageScaleType(new n82.d());
    L82:
        ImageLoader.bindImage(r106.f137257g, r137);
    L83:
        HSImageView r140 = r106.f137257g;
        if (r140 == null) goto L86;
        UtilityKotlinExtentionsKt.w(r140);
    L86:
        TextView r141 = r106.f137256f;
        if (r141 == null) goto L104;
        UtilityKotlinExtentionsKt.t(r141);
    L104:
        r106.c();
        EditText r142 = r106.f137255e;
        if (r142 == null) goto L107;
        r142.postDelayed(new com.bytedance.android.livesdk.interactivity.interactive.dialog.provider.c(r106), 1000);
    L107:
        EditText r143 = r106.f137255e;
        if (r143 == null) goto L110;
        r143.addTextChangedListener(r106.f137269s);
    L110:
        k82.a r144 = r106.f137270t.f137248a;
        if (r144 == null) goto L113;
        r144.f502082a = r106.f137255e;
    L113:
        EditText r145 = r106.f137255e;
        if (r145 == null) goto L116;
        r145.setOnClickListener(new d(r106));
    L116:
        EditText r146 = r106.f137255e;
        if (r146 == null) goto L119;
        r146.setOnKeyListener(new e(r106));
    L119:
        r106.e();
        t9 r147 = r106.f502091b.s();
        if (r147 == null) goto L126;
        CharSequence r148 = r147.f114217a;
        if (r148 == null) goto L126;
        EditText r149 = r106.f137255e;
        if (r149 == null) goto L126;
        r149.post(new com.bytedance.android.livesdk.interactivity.interactive.dialog.provider.b(r148, r106));
    L126:
        int r150 = n82.c.k("#161823", -1);
        int r151 = n82.c.k("#ffac89", -1);
        t9 r152 = r106.f502091b.s();
        if (r152 == null) goto L131;
        u9 r153 = r152.f114219c;
        if (r153 == null) goto L131;
        String r154 = r153.f114256f;
    L132:
        int r155 = n82.c.k(r154, r151);
        t9 r156 = r106.f502091b.s();
        if (r156 == null) goto L137;
        u9 r157 = r156.f114219c;
        if (r157 == null) goto L137;
        r101 = r157.f114255e;
    L137:
        int r158 = n82.c.k(r101, r150);
        TextView r159 = r106.f137264n;
        if (r159 == null) goto L140;
        r159.setTextColor(ColorUtils.setAlphaComponent(r158, (int) 86.700005f));
    L140:
        EditText r160 = r106.f137255e;
        if (r160 == null) goto L143;
        r160.setTextColor(r158);
    L143:
        View r161 = r106.f137258h;
        if (r161 == null) goto L146;
        int r162 = n82.b.f518246a;
        r161.setBackground(n82.b.a(Color.argb(40, Color.red(r155), Color.green(r155), Color.blue(r155)), 0, GradientDrawable.Orientation.TOP_BOTTOM));
    L146:
        Unit r163 = Unit.INSTANCE;
        this.f137251d = r106;
        return r105;
    L131:
        r154 = null;
        goto L132
    L57:
        r127 = null;
    L101:
        View r164 = r106.f137258h;
        if (r164 == null) goto L104;
        UtilityKotlinExtentionsKt.t(r164);
    L48:
        r124 = null;
    L38:
        e = move-exception;
        i40.h.b("V3 emoji key board mCursorDrawableRes", e);
    L34:
        r119 = 1;
    L28:
        r116 = 1;
    L19:
        r108 = r111.getContext();
        goto L20
    L12:
        if (r103.f114223g != true) goto L14;
        r104 = R.layout.ttlive_view_input_content_vs;
        goto L15
    L8:
        if (r103.f114224h != true) goto L10;
        r104 = R.layout.ttlive_view_input_content_vs_pad;
        goto L15
    }

    @Override // k82.d
    public final void h(VSInputSectionType r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, "sectionType");
        Intrinsics.checkNotNullParameter(r101, "view");
        k82.d.a.a(r100, r101);
    }
}
