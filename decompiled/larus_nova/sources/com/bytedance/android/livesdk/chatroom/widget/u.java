package com.bytedance.android.livesdk.chatroom.widget;

import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GravityCompat;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.ui.livesticker.utils.LiveStickerTtfUtil;
import com.bytedance.android.livesdk.config.ew;
import com.bytedance.android.livesdk.config.gt;
import com.bytedance.android.livesdk.config.vm;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.PublicScreenStyleHelper;
import com.bytedance.android.livesdkapi.depend.model.live.DecorationFontConfig;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomDecoration;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.bytedance.sysoptimizer.TypeFaceLancet;
import com.bytedance.sysoptimizer.TypeFaceOptimizer;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public final class u extends FrameLayout {
    public static final c P = null;
    public final boolean A;
    public final b B;
    public final int C;
    public final boolean D;
    public boolean E;
    public final int[] F;
    public final int[] G;
    public final Rect H;
    public final Rect I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final Lazy f119188J;
    public final r K;
    public boolean L;
    public long M;
    public final s N;
    public final a O;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RoomDecoration f119189a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f119190b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f119191c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f119192d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Button f119193e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f119194f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f119195g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f119196h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public View f119197i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final TextView f119198j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ConstraintLayout f119199k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final TextView f119200l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ImageView f119201m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int[] f119202n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f119203o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f119204p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f119205q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f119206r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final int f119207s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final int f119208t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f119209u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f119210v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f119211w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f119212x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f119213y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f119214z;

    public interface a {
        void T9(boolean r100);

        void X6(boolean r100);

        boolean o8(boolean r100);

        boolean s9(boolean r100);
    }

    public interface b {
        void Jb(boolean r100);

        void Lf(String r100, RoomDecoration r101);

        void q8(RoomDecoration r100);

        void vd();
    }

    public static final class c {
        public c() {
        }

        @JvmStatic
        public static boolean a() {
            int r100 = ((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene();
            DataContext r101 = com.bytedance.live.datacontext.d.d(RoomContext.class);
            Room r102 = null;
            if ((r101 instanceof RoomContext) == true) goto L5;
            r101 = null;
        L5:
            RoomContext r103 = (RoomContext) r101;
            if (r100 != 5) goto L14;
            if (r103 == null) goto L12;
            com.bytedance.live.datacontext.m<Room> r104 = r103.getRoom();
            if (r104 == null) goto L12;
            r102 = r104.getValue();
        L12:
            if (com.bytedance.android.livesdk.chatroom.interact.model.d0.h(r102) == true) goto L14;
            return true;
        L14:
            return false;
        }

        @JvmStatic
        public static boolean b() {
            if (((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene() != 9) goto L5;
            return true;
        L5:
            return false;
        }

        @JvmStatic
        public static boolean c() {
            return vm.f121462a.getValue().booleanValue();
        }

        @JvmStatic
        public static boolean d(int r100) {
            int r101 = (int) UtilityKotlinExtentionsKt.h(r100 / 2.0f);
            if (a() == false) goto L7;
            if (r101 <= UtilityKotlinExtentionsKt.i(157)) goto L7;
        L10:
            return true;
        L7:
            if (b() == true) goto L9;
        L11:
            return false;
        L9:
            if (r101 <= UtilityKotlinExtentionsKt.i(179)) goto L11;
            goto L10
        }

        public static void e(String r100, Function1 r101) {
            Intrinsics.checkNotNullParameter(r100, "color");
            Intrinsics.checkNotNullParameter(r101, "success");
            Integer r102 = null;
            Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L5
            r102 = Integer.valueOf(Color.parseColor(r100));     // Catch: Throwable -> L5
            Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
        L7:
            if (r102 != null) goto L9;
            ALogger.e("DecorationView", "parse color failed, from str: " + r101);
            return;
        L9:
            Intrinsics.checkNotNull(r102);
            r101.invoke(r102);
            return;
        L5:
            th = move-exception;
            Result.Companion r104 = Result.Companion;
            Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L7
        }
    }

    public static final class d extends com.bytedance.android.live.core.utils.q0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f119215a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ u f119216b;

        public d(u r100) {
            this.f119216b = r100;
        }

        @Override // com.bytedance.android.live.core.utils.q0
        public final void h(py.k r100, int r101, int r102) {
            if (this.f119215a == false) goto L5;
            return;
        L5:
            this.f119215a = true;
            u r103 = this.f119216b;
            r103.f119203o = (int) UIUtils.dip2Px(r103.getContext(), r101 / 2.0f);
            u r104 = this.f119216b;
            r104.f119204p = (int) UIUtils.dip2Px(r104.getContext(), r102 / 2.0f);
            u r105 = this.f119216b;
            r105.f119205q = r105.f119203o / 2;
            r105.f119206r = r105.f119204p / 2;
            u.c(r105);
            u r106 = this.f119216b;
            if (r106.A == false) goto L11;
            b r107 = r106.B;
            if (r107 == null) goto L11;
            r107.vd();
        L11:
            if (1 != this.f119216b.getRoomDecoration().getType()) goto L37;
            ViewGroup.LayoutParams r108 = this.f119216b.f119191c.getLayoutParams();
            if (r108 == null) goto L36;
            FrameLayout.LayoutParams r109 = (FrameLayout.LayoutParams) r108;
            if (this.f119216b.getRoomDecoration().getInputRect() == null) goto L20;
            if (this.f119216b.getRoomDecoration().getInputRect().size() != 4) goto L20;
            r109.leftMargin = (int) UIUtils.dip2Px(this.f119216b.getContext(), ((Number) ListProtector.get(this.f119216b.getRoomDecoration().getInputRect(), 0)).floatValue() / 2.0f);
            r109.topMargin = (int) UIUtils.dip2Px(this.f119216b.getContext(), ((Number) ListProtector.get(this.f119216b.getRoomDecoration().getInputRect(), 1)).floatValue() / 2.0f);
            r109.width = (int) UIUtils.dip2Px(this.f119216b.getContext(), ((Number) ListProtector.get(this.f119216b.getRoomDecoration().getInputRect(), 2)).floatValue() / 2.0f);
            r109.height = (int) UIUtils.dip2Px(this.f119216b.getContext(), ((Number) ListProtector.get(this.f119216b.getRoomDecoration().getInputRect(), 3)).floatValue() / 2.0f);
        L20:
            if (this.f119216b.getRoomDecoration().getSubType() != 3) goto L22;
            this.f119216b.f119191c.setGravity(GravityCompat.START);
        L23:
            this.f119216b.f119191c.setLayoutParams(r109);
            u r110 = this.f119216b;
            r110.f119191c.setTextSize(1, r110.getRoomDecoration().getTextSize() / 2);
            c r111 = u.P;
            String r112 = this.f119216b.getRoomDecoration().getTextColor();
            Function1<Integer, Unit> r113 = new DecorationView$loadImage$1$onLoadSuccess$1(this);
            r111.getClass();
            c.e(r112, r113);
            u r114 = this.f119216b;
            String r115 = r114.f119214z;
            if (r115 != null) goto L26;
            r115 = r114.getRoomDecoration().getContent();
        L26:
            if (r115 != null) goto L28;
            r115 = "";
        L28:
            this.f119216b.f119191c.setText(r115);
            u r116 = this.f119216b;
            r116.f119191c.setTypeface(u.b(r116));
            u r117 = this.f119216b;
            if (r117.A == false) goto L31;
            r117.f119191c.setOnClickListener(r117.K);
        L32:
            this.f119216b.f119191c.setVisibility(0);
            UIUtils.setViewVisibility(this.f119216b.f119192d, 8);
            u r118 = this.f119216b;
            if (r118.L == false) goto L40;
            r118.j();
        L40:
            this.f119216b.setVisibility(0);
            u r119 = this.f119216b;
            if (r119.A == true) goto L46;
            ImageView r120 = r119.f119190b;
            if (r120 == null) goto L47;
            r120.post(new w(this));
            return;
        L47:
            return;
        L46:
            return;
        L31:
            r117.f119191c.setOnClickListener(r117.N);
            goto L32
        L22:
            this.f119216b.f119191c.setGravity(17);
            goto L23
        L36:
            throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        L37:
            this.f119216b.f119191c.setVisibility(8);
            this.f119216b.f119192d.setVisibility(8);
            u r121 = this.f119216b;
            if (r121.A == true) goto L40;
            r121.f119190b.setOnClickListener(r121.N);
            goto L40
        }
    }

    public static final class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u f119217a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TextView f119218b;

        public e(u r100, TextView r101) {
            this.f119217a = r100;
            this.f119218b = r101;
        }

        public final void a() {
            this.f119217a.f119203o = this.f119218b.getWidth();
            float r100 = this.f119217a.getX();
            u r101 = this.f119217a;
            int r102 = r101.f119203o;
            float r103 = r100 + r102;
            int r104 = r101.f119202n[3];
            if (r103 <= r104) goto L8;
            ObjectAnimator r105 = ObjectAnimator.ofFloat(r101, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{r101.getX(), r104 - r102});
            r105.setDuration(300);
            r105.start();
            b r106 = this.f119217a.B;
            if (r106 == null) goto L9;
            r106.vd();
            return;
        L9:
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    private final Handler getNinePatchHandler() {
        return (Handler) this.f119188J.getValue();
    }

    static {
        P = new c();
    }

    public final void e() {
        if (this.A == true) goto L5;
        return;
    L5:
        this.L = false;
        if (this.f119199k.getVisibility() != 8) goto L9;
        return;
    L9:
        if (this.f119198j.getVisibility() != 0) goto L11;
        TextView r100 = this.f119198j;
        r100.setPadding(r100.getPaddingLeft() - UtilityKotlinExtentionsKt.i(38), r100.getPaddingTop(), r100.getPaddingRight(), r100.getPaddingBottom());
    L12:
        this.f119199k.setVisibility(8);
        return;
    L11:
        int r101 = UtilityKotlinExtentionsKt.i(38);
        this.f119191c.getLayoutParams().width += r101;
        TextView r102 = this.f119191c;
        com.bytedance.android.live.core.utils.a1.m(r102, com.bytedance.android.live.core.utils.a1.f(r102) - r101);
        goto L12
    }

    public final JSONObject getDecorationInfo() {
        JSONObject r100 = new JSONObject();
        r100.put("id", getRoomDecoration().getId());     // Catch: JSONException -> L5
        r100.put("x", getRoomDecoration().getX());     // Catch: JSONException -> L5
        r100.put("y", getRoomDecoration().getY());     // Catch: JSONException -> L5
        r100.put("w", this.f119207s);     // Catch: JSONException -> L5
        r100.put("h", this.f119208t);     // Catch: JSONException -> L5
        r100.put("type", getRoomDecoration().getType());     // Catch: JSONException -> L5
        r100.put("content", this.f119214z);     // Catch: JSONException -> L5
    L7:
        return r100;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public final RoomDecoration getRoomDecoration() {
        if (this.A == false) goto L6;
        this.f119189a.setScreenWidth(this.f119207s);
        this.f119189a.setScreenHeight(this.f119208t);
    L6:
        return this.f119189a;
    }

    public final String getStickerInfoMonitor() {
        JSONObject r100 = new JSONObject();
        r100.put("id", String.valueOf(getRoomDecoration().getId()));
        if (getRoomDecoration().isTextSticker() == false) goto L5;
        r100.put("type", "textSticker");
        r100.put("content", this.f119214z);
        r100.put("fontID", this.M);
    L6:
        r100.put("x", Float.valueOf(getX()));
        r100.put("y", Float.valueOf(getY()));
        r100.put("w", this.f119208t);
        r100.put("h", this.f119207s);
        return r100.toString();
    L5:
        r100.put("type", "imageSticker");
        goto L6
    }

    public final void h() {
        this.f119190b.setVisibility(0);
        this.f119198j.setVisibility(8);
        ImageUtil.loadImage(this.f119190b, getRoomDecoration().getImage(), new d(this));
    }

    public final void j() {
        if (this.A == true) goto L5;
        return;
    L5:
        this.L = false;
        if (this.f119199k.getVisibility() != 0) goto L9;
        return;
    L9:
        if (this.f119198j.getVisibility() != 0) goto L16;
        TextView r100 = this.f119198j;
        ConstraintLayout r101 = this.f119199k;
        ViewGroup.LayoutParams r102 = r101.getLayoutParams();
        if (r102 == null) goto L14;
        FrameLayout.LayoutParams r103 = (FrameLayout.LayoutParams) r102;
        r103.leftMargin = r100.getPaddingLeft();
        r103.topMargin = r100.getPaddingTop();
        r103.height = (this.f119204p - r100.getPaddingTop()) - r100.getPaddingBottom();
        Unit r104 = Unit.INSTANCE;
        r101.setLayoutParams(r103);
        r100.setPadding(r100.getPaddingLeft() + UtilityKotlinExtentionsKt.i(38), r100.getPaddingTop(), r100.getPaddingRight(), r100.getPaddingBottom());
    L20:
        GradientDrawable r105 = new GradientDrawable();
        c r106 = P;
        String r107 = getRoomDecoration().getAuditTextColor();
        r106.getClass();
        Intrinsics.checkNotNullParameter("#FFEBA825", "defaultColor");
        int r108 = ColorProtector.parseColor("#FFEBA825");
        Result.Companion r109 = Result.Companion;     // Catch: Throwable -> L23
        r108 = Color.parseColor(r107);     // Catch: Throwable -> L23
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L23
    L25:
        r105.setStroke((int) UtilityKotlinExtentionsKt.h(0.5f), r108);
        r105.setCornerRadius(UtilityKotlinExtentionsKt.h(2));
        this.f119200l.setBackground(r105);
        this.f119200l.setTextColor(r108);
        this.f119199k.setVisibility(0);
        return;
    L23:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L25
    L14:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    L16:
        if (this.f119191c.getVisibility() != 0) goto L29;
        TextView r111 = this.f119191c;
        ConstraintLayout r112 = this.f119199k;
        ViewGroup.LayoutParams r113 = r112.getLayoutParams();
        if (r113 == null) goto L28;
        FrameLayout.LayoutParams r114 = (FrameLayout.LayoutParams) r113;
        r114.leftMargin = com.bytedance.android.live.core.utils.a1.f(r111);
        r114.topMargin = com.bytedance.android.live.core.utils.a1.h(r111);
        r114.height = r111.getLayoutParams().height;
        Unit r115 = Unit.INSTANCE;
        r112.setLayoutParams(r114);
        int r116 = UtilityKotlinExtentionsKt.i(38);
        r111.getLayoutParams().width -= r116;
        com.bytedance.android.live.core.utils.a1.m(r111, com.bytedance.android.live.core.utils.a1.f(r111) + r116);
        goto L20
    L28:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    L29:
        this.L = true;
    }

    public final void k() {
        if (this.A == true) goto L11;
        ImageView r100 = this.f119201m;
        if (r100 == null) goto L7;
        UtilityKotlinExtentionsKt.w(r100);
    L7:
        a r101 = this.O;
        if (r101 == null) goto L12;
        r101.X6(getRoomDecoration().isTextSticker());
        return;
    L12:
        return;
    }

    private final Typeface getCustomTypeface() {
        DecorationFontConfig r100 = getRoomDecoration().getTextFontConfig();
        if (r100 == null) goto L5;
        long r101 = r100.getStatus();
    L6:
        Typeface r102 = null;
        if (r101 != 1) goto L33;
        DecorationFontConfig r103 = getRoomDecoration().getTextFontConfig();
        if (r103 == null) goto L11;
        Long r104 = Long.valueOf(r103.getFontId());
    L12:
        Lazy<String> r105 = LiveStickerTtfUtil.f113697a;
        if (r104 == null) goto L33;
        long r106 = r104.longValue();
        ConcurrentHashMap r107 = (ConcurrentHashMap) LiveStickerTtfUtil.f113698b;
        if (r107.containsKey(Long.valueOf(r106)) == false) goto L19;
        Typeface r108 = (Typeface) r107.get(Long.valueOf(r106));
    L17:
        r102 = r108;
        goto L33
    L19:
        if (LiveStickerTtfUtil.a(r104) == false) goto L33;
        String r109 = LiveStickerTtfUtil.c(r104.longValue());
        if (TypeFaceOptimizer.getSwitch() == false) goto L29;
        if (r109 == null) goto L29;
        if (TypeFaceLancet.cache.contains(r109) == false) goto L26;
        Typeface r110 = (Typeface) TypeFaceLancet.cache.get(r109);
    L30:
        if (r110 == null) goto L32;
        r107.put(Long.valueOf(r106), r110);
    L32:
        r108 = (Typeface) r107.get(Long.valueOf(r106));
        goto L17
    L26:
        Typeface r111 = Typeface.createFromFile(r109);
        if (r111 == null) goto L29;
        TypeFaceLancet.cache.put(r109, r111);
        r110 = r111;
    L29:
        r110 = Typeface.createFromFile(r109);
        goto L30
    L11:
        r104 = null;
    L33:
        if (r102 == null) goto L39;
        DecorationFontConfig r112 = getRoomDecoration().getTextFontConfig();
        if (r112 == null) goto L37;
        long r113 = r112.getFontId();
    L38:
        this.M = r113;
        goto L39
    L37:
        r113 = -1;
    L39:
        if (r102 == null) goto L41;
        return r102;
    L41:
        return Typeface.DEFAULT;
    L5:
        r101 = 0;
        goto L6
    }

    public final int getType() {
        return getRoomDecoration().getType();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        setDecorationLayout(false);
        if (getRoomDecoration().getNinePatchImage() != null) goto L5;
    L9:
        h();
    L11:
        if (this.A == false) goto L14;
        com.bytedance.android.livesdk.chatroom.ui.livesticker.utils.a.b(1);
        return;
    L14:
        return;
    L5:
        if (getRoomDecoration().isTextSticker() == false) goto L9;
        if (getRoomDecoration().isReserveDecoration() == true) goto L9;
        com.bytedance.android.livesdk.chatroom.utils.a1.u(getRoomDecoration().getNinePatchImage(), new DecorationView$loadNinePatchImage$1(this));
        goto L11
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public static final /* synthetic */ Typeface b(u r100) {
        return r100.getCustomTypeface();
    }

    public static final /* synthetic */ void c(u r100) {
        r100.setDecorationLayout(true);
    }

    private final void setDecorationLayout(boolean r110) {
        if (this.f119203o <= 0) goto L5;
    L6:
        ViewGroup.LayoutParams r100 = getLayoutParams();
        if (r100 == null) goto L10;
        r100.width = this.f119203o;
        r100.height = this.f119204p;
        setLayoutParams(r100);
    L10:
        if (getRoomDecoration().getX() == (-1)) goto L12;
    L20:
        float r101 = 1.0f;
        if (getRoomDecoration().getScreenWidth() <= 0) goto L23;
        float r102 = this.f119207s / getRoomDecoration().getScreenWidth();
    L25:
        if (getRoomDecoration().getScreenHeight() <= 0) goto L27;
        r101 = this.f119208t / getRoomDecoration().getScreenHeight();
    L27:
        int r103 = ((int) (getRoomDecoration().getX() * r102)) - this.f119205q;
        int r104 = (int) (getRoomDecoration().getY() * r101);
        int r105 = this.f119206r;
    L28:
        int r106 = r104 - r105;
    L29:
        int[] r107 = this.f119202n;
        int r108 = r107[2];
        int r109 = r107[3];
        if (r103 >= r108) goto L32;
        r103 = r108;
    L35:
        int r111 = r107[0];
        int r112 = r107[1];
        if (r106 >= r111) goto L38;
        r106 = r111;
    L42:
        if (this.D == false) goto L46;
        r103 = ((r109 - r108) - this.f119203o) / 2;
        r106 = ((r112 - r111) - this.f119204p) / 2;
        if (r106 >= UtilityKotlinExtentionsKt.h(8)) goto L46;
        r106 = UtilityKotlinExtentionsKt.i(8);
    L46:
        setX(r103);
        setY(r106);
        l(false);
        if (r110 == false) goto L50;
        getRoomDecoration().setX(r103 + this.f119205q);
        getRoomDecoration().setY(r106 + this.f119206r);
        return;
    L50:
        return;
    L38:
        int r113 = this.f119204p;
        if ((r106 + r113) <= r112) goto L42;
        r106 = r112 - r113;
        goto L42
    L32:
        int r114 = this.f119203o;
        if ((r103 + r114) <= r109) goto L35;
        r103 = r109 - r114;
        goto L35
    L23:
        r102 = 1.0f;
        goto L25
    L12:
        if (getRoomDecoration().getY() != (-1)) goto L20;
        if (getRoomDecoration().getSit_rect() != null) goto L17;
    L19:
        r103 = (this.f119207s / 2) - this.f119205q;
        r104 = this.f119208t / 3;
        r105 = this.f119206r;
        goto L28
    L17:
        if (getRoomDecoration().getSit_rect().size() <= 1) goto L19;
        r103 = (int) (((double) this.f119207s) * ((Number) ListProtector.get(getRoomDecoration().getSit_rect(), 0)).doubleValue());
        r106 = (int) (((double) this.f119208t) * ((Number) ListProtector.get(getRoomDecoration().getSit_rect(), 1)).doubleValue());
        goto L29
    L5:
        if (this.f119204p <= 0) goto L10;
        goto L6
    }

    public final void d(MotionEvent r100) {
        if (r100.getX() >= (this.f119192d.getX() - 10.0f)) goto L5;
    L11:
        boolean r101 = false;
    L12:
        if (r101 == false) goto L15;
        this.f119192d.performClick();
        return;
    L15:
        if (this.f119191c.getVisibility() != 0) goto L18;
        this.f119191c.performClick();
    L18:
        if (this.f119198j.getVisibility() != 0) goto L22;
        this.f119198j.performClick();
        return;
    L22:
        return;
    L5:
        if (r100.getY() < (this.f119192d.getY() - 10.0f)) goto L11;
        if (r100.getX() > ((this.f119192d.getX() + this.f119192d.getWidth()) + 10.0f)) goto L11;
        if (r100.getY() > ((this.f119192d.getY() + this.f119192d.getHeight()) + 10.0f)) goto L11;
        r101 = true;
        goto L12
    }

    public final void l(boolean r100) {
        P.getClass();
        if (c.c() == true) goto L5;
        return;
    L5:
        if (c.b() == false) goto L17;
        float r101 = getX() + this.f119205q;
        int r102 = this.f119207s;
        if (r101 > (r102 / 2)) goto L10;
        float r103 = 0.0f;
    L11:
        if (r100 == false) goto L13;
        ObjectAnimator r104 = ObjectAnimator.ofFloat(this, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{getX(), r103});
        r104.setDuration(300);
        r104.start();
        return;
    L13:
        setX(r103);
        return;
    L10:
        r103 = r102 - this.f119203o;
        goto L11
    }

    public final void m(int[] r100) {
        Intrinsics.checkNotNullParameter(r100, "validArea");
        if (r100.length >= 4) goto L5;
        return;
    L5:
        P.getClass();
        boolean r101 = false;
        if (c.c() == false) goto L43;
        if (c.a() == false) goto L22;
        View r102 = this.f119196h;
        if (r102 == null) goto L20;
        int r103 = this.f119208t;
        View r104 = this.f119195g;
        if (r104 == null) goto L14;
        int r105 = com.bytedance.android.live.core.utils.a1.d(r104);
    L15:
        int r106 = r103 - r105;
        View r107 = this.f119197i;
        if (r107 == null) goto L18;
        int r108 = com.bytedance.android.live.core.utils.a1.d(r107);
    L19:
        com.bytedance.android.live.core.utils.a1.k(r102, (r106 - r108) - UtilityKotlinExtentionsKt.i(157));
        goto L20
    L18:
        r108 = 0;
        goto L19
    L14:
        r105 = 0;
    L20:
        r100[1] = UtilityKotlinExtentionsKt.i(260);
        goto L43
    L22:
        if (c.b() == false) goto L35;
        View r109 = this.f119196h;
        if (r109 == null) goto L34;
        int r110 = this.f119208t;
        View r111 = this.f119195g;
        if (r111 == null) goto L28;
        int r112 = com.bytedance.android.live.core.utils.a1.d(r111);
    L29:
        int r113 = r110 - r112;
        View r114 = this.f119197i;
        if (r114 == null) goto L32;
        int r115 = com.bytedance.android.live.core.utils.a1.d(r114);
    L33:
        com.bytedance.android.live.core.utils.a1.k(r109, (r113 - r115) - UtilityKotlinExtentionsKt.i(179));
        goto L34
    L32:
        r115 = 0;
        goto L33
    L28:
        r112 = 0;
    L34:
        r100[1] = UtilityKotlinExtentionsKt.i(280);
        goto L43
    L35:
        View r116 = this.f119196h;
        if (r116 == null) goto L43;
        if (getResources().getConfiguration().orientation != 1) goto L40;
        int r117 = UtilityKotlinExtentionsKt.i(177);
    L41:
        com.bytedance.android.live.core.utils.a1.k(r116, r117);
        goto L43
    L40:
        r117 = UtilityKotlinExtentionsKt.i(1);
    L43:
        if (PublicScreenStyleHelper.f133624n == true) goto L45;
    L47:
        boolean r118 = false;
    L48:
        if (r118 == false) goto L56;
        View r119 = this.f119196h;
        if (r119 == null) goto L56;
        int r120 = this.f119208t - r100[1];
        View r121 = this.f119197i;
        if (r121 == null) goto L54;
        int r122 = com.bytedance.android.live.core.utils.a1.d(r121);
    L55:
        com.bytedance.android.live.core.utils.a1.k(r119, r120 - r122);
        goto L56
    L54:
        r122 = 0;
    L56:
        this.f119202n = r100;
        float r123 = getX();
        float r124 = this.f119202n[2];
        if (r123 >= r124) goto L59;
        setX(r124);
    L62:
        float r125 = getY();
        float r126 = this.f119202n[0];
        if (r125 >= r126) goto L65;
        setY(r126);
    L69:
        if (c.c() == false) goto L82;
        if (c.d((int) UtilityKotlinExtentionsKt.j(this.f119204p * 2)) == false) goto L76;
        b r127 = this.B;
        if (r127 == null) goto L75;
        r127.q8(getRoomDecoration());
        this.B.vd();
    L75:
        com.bytedance.android.live.core.utils.f2.c(com.bytedance.android.live.core.utils.s1.B(R.string.ttlive_decoration_view_oversize), 0);
    L92:
        Logger.i("DecorationView", "updateValidArea. bottom=" + r100[1]);
        return;
    L76:
        l(true);
        if (this.A == false) goto L92;
        getRoomDecoration().setX((int) (getX() + this.f119205q));
        getRoomDecoration().setY((int) (getY() + this.f119206r));
        b r128 = this.B;
        if (r128 == null) goto L92;
        r128.vd();
        goto L92
    L82:
        if (PublicScreenStyleHelper.f133624n == true) goto L84;
    L86:
        if (r101 == false) goto L92;
        l(true);
        if (this.A == false) goto L92;
        getRoomDecoration().setX((int) (getX() + this.f119205q));
        getRoomDecoration().setY((int) (getY() + this.f119206r));
        b r129 = this.B;
        if (r129 == null) goto L92;
        r129.vd();
        goto L92
    L84:
        if (PublicScreenStyleHelper.b().d() == false) goto L86;
        r101 = true;
        goto L86
    L65:
        float r130 = getY();
        float r131 = this.f119204p;
        float r132 = r130 + r131;
        float r133 = this.f119202n[1];
        if (r132 <= r133) goto L69;
        setY(r133 - r131);
        goto L69
    L59:
        float r134 = getX() + this.f119203o;
        float r135 = this.f119202n[3];
        if (r134 <= r135) goto L62;
        setX(r135);
        goto L62
    L45:
        if (PublicScreenStyleHelper.b().d() == false) goto L47;
        r118 = true;
        goto L48
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        return this.A;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r110) {
        Intrinsics.checkNotNullParameter(r110, "event");
        if (this.D == false) goto L7;
        return super.onTouchEvent(r110);
    L7:
        if (this.A == false) goto L115;
        int r100 = r110.getAction();
        if (r100 != 0) goto L12;
        this.f119209u = r110.getRawX();
        float r111 = r110.getRawY();
        this.f119210v = r111;
        this.f119211w = this.f119209u;
        this.f119212x = r111;
        Logger.i("DecorationView", "action_down. valid bottom=" + this.f119202n[1]);
    L113:
        return true;
    L12:
        if (r100 == 1) goto L83;
        if (r100 == 2) goto L26;
        if (r100 != 3) goto L113;
        View r112 = this.f119194f;
        if (r112 == null) goto L22;
        Intrinsics.checkNotNull(r112);
        r112.setVisibility(4);
        View r113 = this.f119194f;
        Intrinsics.checkNotNull(r113);
        r113.setAlpha(1.0f);
    L22:
        if (this.B == null) goto L113;
        if (com.bytedance.android.live.core.utils.s1.F() == false) goto L113;
        this.B.Jb(false);
        goto L113
    L26:
        float r101 = Math.abs(r110.getRawX() - this.f119211w);
        float r102 = Math.abs(r110.getRawY() - this.f119212x);
        float r103 = this.C;
        if (r101 < r103) goto L29;
    L31:
        this.f119213y = true;
        float r104 = r110.getRawX() - this.f119209u;
        float r105 = r110.getRawY() - this.f119210v;
        if ((getX() + r104) < this.f119202n[2]) goto L37;
        if (((getX() + this.f119203o) + r104) > this.f119202n[3]) goto L37;
        this.f119209u = r110.getRawX();
        setX(getX() + r104);
    L37:
        if ((getY() + r105) >= this.f119202n[0]) goto L39;
    L41:
        boolean r114 = g(this, this.f119195g);
        if (r114 == false) goto L57;
        if (this.E == true) goto L57;
        this.E = true;
        Button r115 = this.f119193e;
        if (r115 == null) goto L71;
        ViewPropertyAnimator r116 = r115.animate();
        if (r116 == null) goto L71;
        ViewPropertyAnimator r117 = r116.scaleX(1.2f);
        if (r117 == null) goto L71;
        ViewPropertyAnimator r118 = r117.scaleY(1.2f);
        if (r118 == null) goto L71;
        ViewPropertyAnimator r119 = r118.setDuration(200);
        if (r119 == null) goto L71;
        r119.start();
    L71:
        if (this.B != null) goto L73;
    L75:
        View r120 = this.f119194f;
        if (r120 == null) goto L113;
        Intrinsics.checkNotNull(r120);
        r120.setAlpha(1.0f);
        View r121 = this.f119194f;
        Intrinsics.checkNotNull(r121);
        if (r121.getVisibility() == 0) goto L113;
        View r122 = this.f119194f;
        Intrinsics.checkNotNull(r122);
        r122.setVisibility(0);
        goto L113
    L73:
        if (com.bytedance.android.live.core.utils.s1.F() == false) goto L75;
        this.B.Jb(true);
    L57:
        if (this.E == false) goto L71;
        if (r114 == true) goto L71;
        this.E = false;
        Button r123 = this.f119193e;
        if (r123 == null) goto L71;
        ViewPropertyAnimator r124 = r123.animate();
        if (r124 == null) goto L71;
        ViewPropertyAnimator r125 = r124.scaleX(1.0f);
        if (r125 == null) goto L71;
        ViewPropertyAnimator r126 = r125.scaleY(1.0f);
        if (r126 == null) goto L71;
        ViewPropertyAnimator r127 = r126.setDuration(200);
        if (r127 == null) goto L71;
        r127.start();
        goto L71
    L39:
        if (((getY() + this.f119204p) + r105) > this.f119202n[1]) goto L41;
        this.f119210v = r110.getRawY();
        setY(getY() + r105);
        goto L41
    L29:
        if (r102 >= r103) goto L31;
        return true;
    L83:
        if (g(this, this.f119195g) == false) goto L88;
        b r128 = this.B;
        if (r128 == null) goto L103;
        r128.q8(getRoomDecoration());
        this.B.vd();
    L103:
        View r129 = this.f119194f;
        if (r129 == null) goto L108;
        Intrinsics.checkNotNull(r129);
        r129.setVisibility(4);
        View r130 = this.f119194f;
        Intrinsics.checkNotNull(r130);
        r130.setAlpha(1.0f);
    L108:
        if (this.B == null) goto L113;
        if (com.bytedance.android.live.core.utils.s1.F() == false) goto L113;
        this.B.Jb(false);
        goto L113
    L88:
        if (this.f119191c.getVisibility() != 0) goto L93;
        if (this.f119213y == true) goto L93;
        d(r110);
    L93:
        if (this.f119198j.getVisibility() != 0) goto L98;
        if (this.f119213y == true) goto L98;
        d(r110);
    L98:
        if (this.f119213y == false) goto L103;
        l(true);
        getRoomDecoration().setX((int) (getX() + this.f119205q));
        getRoomDecoration().setY((int) (getY() + this.f119206r));
        b r131 = this.B;
        if (r131 == null) goto L102;
        r131.vd();
    L102:
        this.f119213y = false;
        goto L103
    L115:
        return false;
    }

    public final void setText(String r100) {
        this.f119214z = r100;
        this.f119191c.setText(r100);
        if (this.f119198j.getVisibility() != 0) goto L6;
        i(this.f119198j, this.f119214z);
        return;
    }

    public static final void a(u r100, Integer r101) {
        r100.getClass();
        if (r101 == null) goto L11;
        r101.intValue();
        ImageView r102 = r100.f119201m;
        if (r102 == null) goto L12;
        ViewGroup.LayoutParams r103 = r102.getLayoutParams();
        if (r103 == null) goto L10;
        FrameLayout.LayoutParams r104 = (FrameLayout.LayoutParams) r103;
        r104.leftMargin = r101.intValue() - UtilityKotlinExtentionsKt.i(14);
        r102.setLayoutParams(r104);
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    L12:
        return;
    }

    public final boolean g(View r100, View r101) {
        if (r101 != null) goto L5;
        return false;
    L5:
        r100.getLocationOnScreen(this.G);
        r101.getLocationOnScreen(this.F);
        f(r100, this.H, this.G);
        f(r101, this.I, this.F);
        return this.H.intersect(this.I);
    }

    public final void i(TextView r100, String r101) {
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        r100.setText(r101);
        if (this.A == false) goto L9;
        getNinePatchHandler().postDelayed(new e(this, r100), 200);
        return;
    }

    public static void f(View r100, Rect r101, int[] r102) {
        int r103 = r102[0];
        r101.left = r103;
        r101.top = r102[1];
        Intrinsics.checkNotNull(r100);
        r101.right = r103 + r100.getMeasuredWidth();
        r101.bottom = r101.top + r100.getMeasuredHeight();
    }

    public u(ViewGroup r100, RoomDecoration r101, boolean r102, int[] r103, b r104, a r105) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        Intrinsics.checkNotNullParameter(r101, "roomDecoration");
        Intrinsics.checkNotNullParameter(r103, "validArea");
        super(r100.getContext());
        this.O = r105;
        this.F = new int[2];
        this.G = new int[2];
        this.H = new Rect();
        this.I = new Rect();
        this.f119188J = LazyKt.lazy(DecorationView$ninePatchHandler$2.INSTANCE);
        this.M = -1;
        View.inflate(r100.getContext(), R.layout.ttlive_decoration_view, this);
        this.f119189a = r101;
        this.A = r102;
        this.f119202n = r103;
        this.B = r104;
        this.f119207s = UIUtils.getScreenWidth(getContext());
        this.f119208t = UIUtils.getScreenHeight(getContext());
        this.f119190b = (ImageView) findViewById(R.id.room_decoration_image);
        this.f119191c = (TextView) findViewById(R.id.room_decoration_text);
        this.f119192d = (TextView) findViewById(R.id.room_decoration_button);
        this.f119198j = (TextView) findViewById(R.id.nine_patch_sticker_text);
        this.f119199k = (ConstraintLayout) findViewById(R.id.room_decoration_audit_layout);
        this.f119200l = (TextView) findViewById(R.id.room_decoration_audit_text);
        ImageView r106 = (ImageView) findViewById(R.id.room_decoration_cancel);
        this.f119201m = r106;
        this.C = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        View.inflate(r100.getContext(), R.layout.ttlive_decoration_sticker_region_warn, r100);
        this.f119194f = r100.findViewById(R.id.layout_region_v);
        this.f119195g = r100.findViewById(R.id.delete_region_v);
        this.f119196h = r100.findViewById(R.id.message_region_v);
        this.f119197i = r100.findViewById(R.id.bottom_region_v);
        this.f119193e = (Button) r100.findViewById(R.id.delete_sticker_btn);
        if (ew.f120158a.getValue().booleanValue() == false) goto L5;
        post(new v(this));
    L5:
        this.D = false;
        this.K = new r(this, r102);
        this.N = new s(this);
        r106.setOnClickListener(new t(this, r101));
        if (r105 != null) goto L8;
    L12:
        if (r106 == null) goto L14;
        UtilityKotlinExtentionsKt.t(r106);
    L14:
        if (r105 != null) goto L16;
        return;
    L16:
        if (r105.s9(r101.isTextSticker()) == true) goto L20;
        UtilityKotlinExtentionsKt.t(this);
        return;
    L20:
        return;
    L8:
        if (r105.o8(r101.isTextSticker()) != true) goto L12;
        int r107 = com.bytedance.android.livesdk.chatroom.ui.livesticker.utils.c.f113702a;
        if (gt.f120312a.getValue().booleanValue() == false) goto L12;
        k();
        goto L14
    }
}
