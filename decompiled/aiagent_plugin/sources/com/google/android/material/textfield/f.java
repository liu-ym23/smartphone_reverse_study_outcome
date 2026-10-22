package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: IndicatorViewController.java */
/* JADX INFO: loaded from: classes2.dex */
final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f13649a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TextInputLayout f13650b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private LinearLayout f13651c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f13652d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private FrameLayout f13653e;
    private Animator f;
    private final float g;
    private int h;
    private int i;
    private CharSequence j;
    private boolean k;
    private TextView l;
    private CharSequence m;
    private int n;
    private ColorStateList o;
    private CharSequence p;
    private boolean q;
    private TextView r;
    private int s;
    private ColorStateList t;
    private Typeface u;

    boolean a(int r1) {
        if (r1 == 0) goto L8;
        if (r1 == 1) goto L9;
        return false;
    L9:
        return true;
    L8:
        return true;
    }

    static /* synthetic */ int a(f r0, int r1) {
        r0.h = r1;
        return r1;
    }

    static /* synthetic */ Animator a(f r0, Animator r1) {
        r0.f = r1;
        return r1;
    }

    static /* synthetic */ TextView a(f r0) {
        return r0.l;
    }

    static /* synthetic */ TextInputLayout b(f r0) {
        return r0.f13650b;
    }

    public f(TextInputLayout r4) {
        Context r0 = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        this.f13649a = r0;
        this.f13650b = r4;
        this.g = ZeusTransformUtils.getResources(r0, "com.obric.aiagent.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.design_textinput_caption_translate_y, "dimen", "design_textinput_caption_translate_y"));
    }

    void a(CharSequence r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.aiagent.plugin");
        c();
        this.p = r5;
        this.r.setText(r5);
        int r0 = this.h;
        if (r0 == 2) goto L5;
        this.i = 2;
    L5:
        a(r0, this.i, a(this.r, r5));
    }

    void a() {
        c();
        int r0 = this.h;
        if (r0 != 2) goto L5;
        this.i = 0;
    L5:
        a(r0, this.i, a(this.r, ""));
    }

    void b(CharSequence r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.aiagent.plugin");
        c();
        this.j = r5;
        this.l.setText(r5);
        int r0 = this.h;
        if (r0 == 1) goto L5;
        this.i = 1;
    L5:
        a(r0, this.i, a(this.l, r5));
    }

    void b() {
        this.j = null;
        c();
        if (this.h == 1) goto L5;
    L10:
        a(this.h, this.i, a(this.l, ""));
        return;
    L5:
        if (this.q == true) goto L7;
    L9:
        this.i = 0;
        goto L10
    L7:
        if (TextUtils.isEmpty(this.p) == true) goto L9;
        this.i = 2;
        goto L10
    }

    private boolean a(TextView r3, CharSequence r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.aiagent.plugin");
        if (ViewCompat.F(this.f13650b) == true) goto L5;
    L12:
        return false;
    L5:
        if (this.f13650b.isEnabled() == false) goto L12;
        if (this.i != this.h) goto L11;
        if (r3 == null) goto L11;
        if (TextUtils.equals(r3.getText(), r5) == true) goto L12;
    L11:
        return true;
    }

    private void a(final int r14, final int r15, boolean r16) {
        if (r14 != r15) goto L5;
        return;
    L5:
        if (r16 == false) goto L7;
        AnimatorSet r11 = new AnimatorSet();
        this.f = r11;
        ArrayList r12 = new ArrayList();
        a(r12, this.q, this.r, 2, r14, r15);
        a(r12, this.k, this.l, 1, r14, r15);
        com.google.android.material.animation.b.a(r11, r12);
        final TextView r3 = d(r14);
        final TextView r5 = d(r15);
        r11.addListener(new IndicatorViewController$1(this, r15, r3, r14, r5));
        r11.start();
    L8:
        this.f13650b.updateEditTextBackground();
        this.f13650b.updateLabelState(r16);
        this.f13650b.updateTextInputBoxState();
        return;
    L7:
        a(r14, r15);
        goto L8
    }

    private void a(int r3, int r4) {
        if (r3 != r4) goto L4;
        return;
    L4:
        if (r4 == 0) goto L8;
        TextView r0 = d(r4);
        if (r0 == null) goto L8;
        r0.setVisibility(0);
        r0.setAlpha(1.0f);
    L8:
        if (r3 == 0) goto L14;
        TextView r1 = d(r3);
        if (r1 == null) goto L14;
        r1.setVisibility(4);
        if (r3 != 1) goto L14;
        r1.setText(null);
    L14:
        this.h = r4;
    }

    private void a(List<Animator> r3, boolean r4, TextView r5, int r6, int r7, int r8) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L15;
        if (r4 == false) goto L18;
        if (r6 == r8) goto L8;
        if (r6 == r7) goto L8;
        return;
    L8:
        if (r8 != r6) goto L10;
        boolean r10 = true;
    L11:
        r9.add(a(r5, r10));
        if (r8 != r6) goto L17;
        r9.add(a(r5));
        return;
    L17:
        return;
    L10:
        r10 = false;
        goto L11
    L18:
        return;
    }

    private ObjectAnimator a(TextView r3, boolean r4) {
        if (r4 == false) goto L4;
        float r2 = 1.0f;
    L5:
        ObjectAnimator r5 = ObjectAnimator.ofFloat(r3, View.ALPHA, new float[]{r2});
        r5.setDuration(167);
        r5.setInterpolator(com.google.android.material.animation.a.f13142a);
        return r5;
    L4:
        r2 = 0.0f;
        goto L5
    }

    private ObjectAnimator a(TextView r4) {
        ObjectAnimator r3 = ObjectAnimator.ofFloat(r4, View.TRANSLATION_Y, new float[]{-this.g, 0.0f});
        r3.setDuration(217);
        r3.setInterpolator(com.google.android.material.animation.a.f13145d);
        return r3;
    }

    void c() {
        Animator r0 = this.f;
        if (r0 == null) goto L6;
        r0.cancel();
        return;
    }

    private TextView d(int r2) {
        if (r2 == 1) goto L11;
        if (r2 == 2) goto L9;
        return null;
    L9:
        return this.r;
    L11:
        return this.l;
    }

    void d() {
        if (p() == false) goto L6;
        EditText r0 = this.f13650b.getEditText();
        boolean r1 = com.google.android.material.g.c.a(this.f13649a);
        ViewCompat.b(this.f13651c, a(r1, ZeusTransformUtils.mapRes(R.dimen.material_helper_text_font_1_3_padding_horizontal, "dimen", "material_helper_text_font_1_3_padding_horizontal"), ViewCompat.l(r0)), a(r1, ZeusTransformUtils.mapRes(R.dimen.material_helper_text_font_1_3_padding_top, "dimen", "material_helper_text_font_1_3_padding_top"), ZeusTransformUtils.getResources(this.f13649a, "com.obric.aiagent.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.material_helper_text_default_padding_top, "dimen", "material_helper_text_default_padding_top"))), a(r1, ZeusTransformUtils.mapRes(R.dimen.material_helper_text_font_1_3_padding_horizontal, "dimen", "material_helper_text_font_1_3_padding_horizontal"), ViewCompat.m(r0)), 0);
        return;
    }

    private boolean p() {
        if (this.f13651c != null) goto L5;
    L7:
        return false;
    L5:
        if (this.f13650b.getEditText() == null) goto L7;
        return true;
    }

    private int a(boolean r1, int r2, int r3) {
        if (r1 == true) goto L4;
        return r3;
    L4:
        return ZeusTransformUtils.getResources(this.f13649a, "com.obric.aiagent.plugin").getDimensionPixelSize(r2);
    }

    void a(TextView r6, int r7) {
        if (this.f13651c != null) goto L10;
        if (this.f13653e != null) goto L10;
        LinearLayout r0 = new LinearLayout(this.f13649a);
        this.f13651c = r0;
        r0.setOrientation(0);
        this.f13650b.addView(this.f13651c, -1, -2);
        this.f13653e = new FrameLayout(this.f13649a);
        this.f13651c.addView(this.f13653e, new LinearLayout.LayoutParams(0, -2, 1.0f));
        if (this.f13650b.getEditText() == null) goto L10;
        d();
    L10:
        if (a(r7) == false) goto L12;
        this.f13653e.setVisibility(0);
        this.f13653e.addView(r6);
    L13:
        this.f13651c.setVisibility(0);
        this.f13652d++;
        return;
    L12:
        this.f13651c.addView(r6, new LinearLayout.LayoutParams(-2, -2));
        goto L13
    }

    void b(TextView r2, int r3) {
        if (this.f13651c != null) goto L6;
        return;
    L6:
        if (a(r3) == false) goto L10;
        FrameLayout r4 = this.f13653e;
        if (r4 == null) goto L10;
        r4.removeView(r2);
    L11:
        int r5 = this.f13652d - 1;
        this.f13652d = r5;
        a(this.f13651c, r5);
        return;
    L10:
        this.f13651c.removeView(r2);
        goto L11
    }

    private void a(ViewGroup r1, int r2) {
        if (r2 != 0) goto L5;
        r1.setVisibility(8);
        return;
    }

    void a(boolean r6) {
        if (this.k != r6) goto L5;
        return;
    L5:
        c();
        if (r6 == false) goto L14;
        AppCompatTextView r1 = new AppCompatTextView(this.f13649a);
        this.l = r1;
        r1.setId(ZeusTransformUtils.mapRes(R.id.textinput_error, DbHelper.COL_ID, "textinput_error"));
        if (Build.VERSION.SDK_INT < 17) goto L10;
        this.l.setTextAlignment(5);
    L10:
        Typeface r2 = this.u;
        if (r2 == null) goto L13;
        this.l.setTypeface(r2);
    L13:
        b(this.n);
        a(this.o);
        c(this.m);
        this.l.setVisibility(4);
        ViewCompat.e(this.l, 1);
        a(this.l, 0);
    L15:
        this.k = r6;
        return;
    L14:
        b();
        b(this.l, 0);
        this.l = null;
        this.f13650b.updateEditTextBackground();
        this.f13650b.updateTextInputBoxState();
        goto L15
    }

    boolean e() {
        return this.k;
    }

    boolean f() {
        return this.q;
    }

    void b(boolean r6) {
        if (this.q != r6) goto L5;
        return;
    L5:
        c();
        if (r6 == false) goto L16;
        AppCompatTextView r1 = new AppCompatTextView(this.f13649a);
        this.r = r1;
        r1.setId(ZeusTransformUtils.mapRes(R.id.textinput_helper_text, DbHelper.COL_ID, "textinput_helper_text"));
        if (Build.VERSION.SDK_INT < 17) goto L10;
        this.r.setTextAlignment(5);
    L10:
        Typeface r2 = this.u;
        if (r2 == null) goto L13;
        this.r.setTypeface(r2);
    L13:
        this.r.setVisibility(4);
        ViewCompat.e(this.r, 1);
        c(this.s);
        b(this.t);
        a(this.r, 1);
        if (Build.VERSION.SDK_INT < 17) goto L17;
        this.r.setAccessibilityDelegate(new IndicatorViewController$2(this));
    L17:
        this.q = r6;
        return;
    L16:
        a();
        b(this.r, 1);
        this.r = null;
        this.f13650b.updateEditTextBackground();
        this.f13650b.updateTextInputBoxState();
        goto L17
    }

    View g() {
        return this.r;
    }

    boolean h() {
        return e(this.i);
    }

    private boolean e(int r2) {
        if (r2 == 1) goto L5;
    L9:
        return false;
    L5:
        if (this.l == null) goto L9;
        if (TextUtils.isEmpty(this.j) == true) goto L9;
        return true;
    }

    boolean i() {
        return f(this.h);
    }

    private boolean f(int r2) {
        if (r2 == 2) goto L5;
    L9:
        return false;
    L5:
        if (this.r == null) goto L9;
        if (TextUtils.isEmpty(this.p) == true) goto L9;
        return true;
    }

    CharSequence j() {
        return this.j;
    }

    CharSequence k() {
        return this.p;
    }

    void a(Typeface r2) {
        if (r2 == this.u) goto L6;
        this.u = r2;
        a(this.l, r2);
        a(this.r, r2);
        return;
    }

    private void a(TextView r1, Typeface r2) {
        if (r1 == null) goto L5;
        r1.setTypeface(r2);
        return;
    }

    int l() {
        TextView r0 = this.l;
        if (r0 != null) goto L7;
        return -1;
    L7:
        return r0.getCurrentTextColor();
    }

    ColorStateList m() {
        TextView r0 = this.l;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getTextColors();
    }

    void a(ColorStateList r1) {
        this.o = r1;
        TextView r0 = this.l;
        if (r0 == null) goto L7;
        if (r1 == null) goto L8;
        r0.setTextColor(r1);
        return;
    L8:
        return;
    }

    void b(int r2) {
        this.n = r2;
        TextView r0 = this.l;
        if (r0 == null) goto L6;
        this.f13650b.setTextAppearanceCompatWithErrorFallback(r0, r2);
        return;
    }

    void c(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        this.m = r4;
        TextView r2 = this.l;
        if (r2 == null) goto L6;
        r2.setContentDescription(r4);
        return;
    }

    CharSequence n() {
        return this.m;
    }

    int o() {
        TextView r0 = this.r;
        if (r0 != null) goto L7;
        return -1;
    L7:
        return r0.getCurrentTextColor();
    }

    void b(ColorStateList r1) {
        this.t = r1;
        TextView r0 = this.r;
        if (r0 == null) goto L7;
        if (r1 == null) goto L8;
        r0.setTextColor(r1);
        return;
    L8:
        return;
    }

    void c(int r1) {
        this.s = r1;
        TextView r0 = this.r;
        if (r0 == null) goto L6;
        TextViewCompat.a(r0, r1);
        return;
    }
}
