package com.bytedance.android.live.recharge.platform.core.keyboard;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.utils.e4;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0018B\u001b\b\u0016\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0013\u0010\u0014B#\b\u0016\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0013\u0010\u0017J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\n¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/live/recharge/platform/core/keyboard/LiveRechargeKeyBoardView;", "Landroid/inputmethodservice/KeyboardView;", "Landroid/inputmethodservice/KeyboardView$OnKeyboardActionListener;", "Ldx0/a;", "listener", "", "setKeyboardListener", "", "label", "setDoneLabel", "", "inputEmpty", "setInputStatus", "showFastPayment", "setShowFastPayment", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LiveRechargeKeyBoardView extends KeyboardView implements KeyboardView.OnKeyboardActionListener {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f90231l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f90232m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f90233n = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f90234o = 0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f90235p = 0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f90236q = 0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f90237r = 0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f90238s = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Paint f90239a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Rect f90240b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f90241c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f90242d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f90243e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Typeface f90244f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Typeface f90245g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f90246h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f90247i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public dx0.a f90248j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f90249k;

    public static final class a {
    }

    @Override // android.inputmethodservice.KeyboardView.OnKeyboardActionListener
    public final void onRelease(int r100) {
    }

    @Override // android.inputmethodservice.KeyboardView.OnKeyboardActionListener
    public final void onText(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
    }

    @Override // android.inputmethodservice.KeyboardView, android.inputmethodservice.KeyboardView.OnKeyboardActionListener
    public final void swipeDown() {
    }

    @Override // android.inputmethodservice.KeyboardView, android.inputmethodservice.KeyboardView.OnKeyboardActionListener
    public final void swipeLeft() {
    }

    @Override // android.inputmethodservice.KeyboardView, android.inputmethodservice.KeyboardView.OnKeyboardActionListener
    public final void swipeRight() {
    }

    @Override // android.inputmethodservice.KeyboardView, android.inputmethodservice.KeyboardView.OnKeyboardActionListener
    public final void swipeUp() {
    }

    static {
        f90231l = s1.f(18.0f);
        f90232m = s1.f(15.0f);
        f90233n = s1.f(20.0f);
        f90234o = s1.f(15.0f);
        f90235p = s1.f(6.0f);
        f90236q = s1.f(10.0f);
        f90237r = -1;
        f90238s = s1.h(R.color.ttlive_recharge_diamond_color);
    }

    public final void c(Context r100) {
        setKeyboard(new Keyboard(r100, R.xml.ttlive_custom_key_board_number));
        setEnabled(true);
        setFocusable(true);
        setPreviewEnabled(false);
        setOnKeyboardActionListener(this);
        Paint r101 = new Paint(1);
        this.f90239a = r101;
        r101.setTextAlign(Paint.Align.CENTER);
        Paint r102 = this.f90239a;
        if (r102 == null) goto L5;
        r102.setTextSize(this.f90242d);
    L5:
        Paint r103 = this.f90239a;
        if (r103 == null) goto L8;
        r103.setColor(this.f90243e);
    L8:
        Paint r104 = this.f90239a;
        if (r104 == null) goto L11;
        r104.setTypeface(this.f90244f);
    L11:
        setDoneLabel(e4.a());
    }

    @Override // android.inputmethodservice.KeyboardView, android.view.View
    public final void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        super.onDraw(r110);
        Iterator<Keyboard.Key> r100 = getKeyboard().getKeys().iterator();
    L4:
        if (r100.hasNext() == false) goto L45;
        Keyboard.Key r101 = r100.next();
        int r102 = r101.codes[0];
        if (r102 == (-5)) goto L7;
        if (r102 == (-4)) goto L38;
        b(r101, r110);
        a(r101, r110, f90231l, f90238s);
        goto L4
    L38:
        if (StringsKt.isBlank(this.f90246h) == true) goto L40;
        r101.label = this.f90246h;
    L40:
        boolean r103 = this.f90247i;
        Drawable r104 = s1.m(R.drawable.ttlive_bg_custom_key_board_key_normal);
        int r105 = r101.x;
        int r106 = r101.y;
        r104.setBounds(r105, r106, r101.width + r105, r101.height + r106);
        r104.draw(r110);
        Drawable r107 = s1.m(R.drawable.ttlive_bg_custom_key_board_done);
        if (r103 == false) goto L43;
        r107 = s1.m(R.drawable.ttlive_bg_custom_key_board_done_shallow);
    L43:
        int r108 = r101.x;
        int r109 = r101.y;
        r107.setBounds(r108, r109, r101.width + r108, r101.height + r109);
        r107.setState(r101.getCurrentDrawableState());
        r107.draw(r110);
        a(r101, r110, f90232m, f90237r);
        goto L4
    L7:
        b(r101, r110);
        Drawable r111 = s1.m(R.drawable.ttlive_custom_key_board_delete);
        int r112 = f90234o;
        int r113 = f90233n;
        if (r111 == null) goto L4;
        Rect r114 = this.f90240b;
        if (r114 != null) goto L13;
    L14:
        if (r113 > 0) goto L17;
        r113 = r111.getIntrinsicWidth();
    L17:
        if (r112 > 0) goto L20;
        r112 = r111.getIntrinsicHeight();
    L20:
        int r115 = r101.width;
        if (r113 <= r115) goto L23;
        r112 = (int) (((r115 * 1.0f) / r113) * r112);
        r113 = r115;
    L26:
        int r116 = (r101.x + (r115 / 2)) - (r113 / 2);
        int r117 = (r101.y + (r101.height / 2)) - (r112 / 2);
        this.f90240b = new Rect(r116, r117, r113 + r116, r112 + r117);
    L27:
        Rect r118 = this.f90240b;
        if (r118 == null) goto L4;
        if (r118.isEmpty() == true) goto L4;
        Rect r119 = this.f90240b;
        if (r119 == null) goto L34;
        r111.setBounds(r119);
    L34:
        r111.draw(r110);
        goto L4
    L23:
        int r120 = r101.height;
        if (r112 <= r120) goto L26;
        r113 = (int) (((r120 * 1.0f) / r112) * r113);
        r112 = r120;
        goto L26
    L13:
        if (r114.isEmpty() != true) goto L27;
    }

    @Override // android.inputmethodservice.KeyboardView.OnKeyboardActionListener
    public final void onPress(int r100) {
        dx0.a r101 = this.f90248j;
        if (r101 == null) goto L6;
        r101.a();
        return;
    }

    public final void setDoneLabel(String r100) {
        Intrinsics.checkNotNullParameter(r100, "label");
        this.f90246h = r100;
        invalidate();
    }

    public final void setInputStatus(boolean r100) {
        this.f90247i = r100;
    }

    public final void setKeyboardListener(dx0.a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f90248j = r100;
    }

    public final void setShowFastPayment(boolean r100) {
        this.f90249k = r100;
    }

    public LiveRechargeKeyBoardView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f90242d = s1.f(18.0f);
        this.f90243e = s1.h(R.color.ttlive_recharge_diamond_color);
        this.f90244f = Typeface.DEFAULT_BOLD;
        this.f90245g = Typeface.create(Typeface.SANS_SERIF, 0);
        this.f90246h = "";
        c(r100);
    }

    public final void b(Keyboard.Key r100, Canvas r101) {
        int r102 = r100.codes[0];
        if (r102 != 51) goto L5;
        this.f90241c = r100.x + r100.width;
    L5:
        int r103 = r100.x + r100.width;
        if (r102 != 48) goto L8;
        r103 = this.f90241c;
    L8:
        Drawable r104 = s1.m(R.drawable.ttlive_bg_custom_key_board_key_normal);
        int r105 = r100.x;
        int r106 = r100.y;
        r104.setBounds(r105, r106, r103, r100.height + r106);
        r104.draw(r101);
        Drawable r107 = s1.m(R.drawable.ttlive_bg_custom_key_board_number);
        int r108 = r100.x;
        int r109 = r100.y;
        r107.setBounds(r108, r109, r103, r100.height + r109);
        r107.setState(r100.getCurrentDrawableState());
        r107.draw(r101);
    }

    @Override // android.inputmethodservice.KeyboardView.OnKeyboardActionListener
    public final void onKey(int r100, int[] r101) {
        Intrinsics.checkNotNullParameter(r101, "keyCodes");
        char r102 = (char) r100;
        if (r100 != (-5)) goto L5;
        dx0.a r103 = this.f90248j;
        if (r103 == null) goto L20;
        r103.onDelete();
        return;
    L20:
        return;
    L5:
        if (r100 == (-4)) goto L9;
        dx0.a r104 = this.f90248j;
        if (r104 == null) goto L16;
        r104.onInput(String.valueOf(r102));
        return;
    L16:
        return;
    L9:
        dx0.a r105 = this.f90248j;
        if (r105 == null) goto L18;
        r105.onDone();
        return;
    }

    public LiveRechargeKeyBoardView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f90242d = s1.f(18.0f);
        this.f90243e = s1.h(R.color.ttlive_recharge_diamond_color);
        this.f90244f = Typeface.DEFAULT_BOLD;
        this.f90245g = Typeface.create(Typeface.SANS_SERIF, 0);
        this.f90246h = "";
        c(r100);
    }

    public final void a(Keyboard.Key r210, Canvas r211, int r212, int r213) {
        Canvas r100 = r211;
        if (TextUtils.isEmpty(r210.label) == true) goto L38;
        Paint r101 = this.f90239a;
        if (r101 == null) goto L43;
        float r102 = r212;
        r101.setTextSize(r102);
        r101.setColor(r213);
        r101.setTypeface(this.f90244f);
        Paint.FontMetrics r103 = r101.getFontMetrics();
        float r104 = r103.bottom - r103.top;
        List r105 = StringsKt.split$default(r210.label.toString(), new String[]{"\n"}, false, 0, 6, null);
        int r106 = 1;
        if ((!r105.isEmpty()) == false) goto L9;
        List r107 = r105;
    L10:
        if (r107 == null) goto L44;
        Iterator r108 = r107.iterator();
        int r110 = 0;
    L13:
        if (r108.hasNext() == false) goto L45;
        Object r111 = r108.next();
        int r112 = r110 + 1;
        if (r110 >= 0) goto L17;
        CollectionsKt.throwIndexOverflow();
    L17:
        String r113 = (String) r111;
        int r114 = r210.width;
        Paint r115 = this.f90239a;
        if (r115 == null) goto L23;
        r115.setTextSize(r102);
    L21:
        if (r115.measureText(r113) <= (r114 - (f90235p * 2))) goto L23;
        r115.setTextSize(r115.getTextSize() - r106);
        r102 = r102;
    L23:
        float r116 = r102;
        if ((r105.size() % 2) != r106) goto L26;
        Paint r117 = r101;
        r211.drawText(r113, (r210.x + (r210.width / 2)) + 0, (float) ((((((double) r210.y) + (((double) r210.height) / 2.0d)) + ((double) (r104 / 2))) - ((double) r103.bottom)) + ((double) ((r110 - (r105.size() / 2)) * r104))), r117);
        r108 = r108;
        Canvas r109 = r211;
    L37:
        r100 = r109;
        r101 = r117;
        r110 = r112;
        r102 = r116;
        r108 = r108;
        r106 = 1;
        goto L13
    L26:
        r117 = r101;
        if (r210.codes[0] != (-4)) goto L33;
        if (this.f90249k == false) goto L33;
        if (r110 <= 0) goto L33;
        r117.setTypeface(this.f90245g);
        r117.setTextSize(f90236q);
    L33:
        if (r110 >= (r105.size() / 2)) goto L35;
        double r118 = ((((double) r210.y) + (((double) r210.height) / 2.0d)) - ((double) r103.bottom)) - ((double) ((((r105.size() / 2) - r110) - 1) * r104));
        int r119 = 2;
    L36:
        r109 = r211;
        r109.drawText(r113, (r210.x + (r210.width / r119)) + 0, (float) r118, r117);
        goto L37
    L35:
        r119 = 2;
        r118 = ((((double) r210.y) + (((double) r210.height) / 2.0d)) + ((double) Math.abs(r103.top))) + ((double) ((r110 - (r105.size() / 2)) * r104));
        goto L36
    L45:
        return;
    L44:
        return;
    L9:
        r107 = null;
        goto L10
    L43:
        return;
    }
}
