package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ClearTextEndIconDelegate.java */
/* JADX INFO: loaded from: classes2.dex */
class a extends d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final TextWatcher f13633e;
    private final View.OnFocusChangeListener f;
    private final TextInputLayout.b g;
    private final TextInputLayout.c h;
    private AnimatorSet i;
    private ValueAnimator j;

    static /* synthetic */ void a(a r0, boolean r1) {
        r0.b(r1);
    }

    static /* synthetic */ boolean a(a r0) {
        return r0.e();
    }

    static /* synthetic */ View.OnFocusChangeListener b(a r0) {
        return r0.f;
    }

    static /* synthetic */ TextWatcher c(a r0) {
        return r0.f13633e;
    }

    a(TextInputLayout r1, int r2) {
        super(r1, r2);
        this.f13633e = new ClearTextEndIconDelegate$1(this);
        this.f = new ClearTextEndIconDelegate$2(this);
        this.g = new AnonymousClass1(this);
        this.h = new AnonymousClass2(this);
    }

    @Override // com.google.android.material.textfield.d
    void a() {
        TextInputLayout r0 = this.f13645a;
        if (this.f13648d != 0) goto L5;
        int r1 = ZeusTransformUtils.mapRes(R.drawable.mtrl_ic_cancel, "drawable", "mtrl_ic_cancel");
    L6:
        r0.setEndIconDrawable(r1);
        this.f13645a.setEndIconContentDescription(ZeusTransformUtils.getResources(this.f13645a, "com.obric.aiagent.plugin").getText(ZeusTransformUtils.mapRes(R.string.clear_text_end_icon_content_description, WsChannelMultiProcessSharedProvider.STRING_TYPE, "clear_text_end_icon_content_description")));
        this.f13645a.setEndIconCheckable(false);
        this.f13645a.setEndIconOnClickListener(new ClearTextEndIconDelegate$5(this));
        this.f13645a.addOnEditTextAttachedListener(this.g);
        this.f13645a.addOnEndIconChangedListener(this.h);
        c();
        return;
    L5:
        r1 = this.f13648d;
        goto L6
    }

    @Override // com.google.android.material.textfield.d
    void a(boolean r2) {
        if (this.f13645a.getSuffixText() != null) goto L5;
        return;
    L5:
        b(r2);
    }

    private void b(boolean r3) {
        if (this.f13645a.isEndIconVisible() != r3) goto L5;
        boolean r0 = true;
    L6:
        if (r3 == true) goto L8;
    L12:
        if (r3 == true) goto L19;
        this.i.cancel();
        this.j.start();
        if (r0 == false) goto L20;
        this.j.end();
        return;
    L20:
        return;
    L19:
        return;
    L8:
        if (this.i.isRunning() == true) goto L12;
        this.j.cancel();
        this.i.start();
        if (r0 == false) goto L17;
        this.i.end();
        return;
    L17:
        return;
    L5:
        r0 = false;
        goto L6
    }

    private void c() {
        ValueAnimator r0 = d();
        ValueAnimator r2 = a(new float[]{0.0f, 1.0f});
        AnimatorSet r3 = new AnimatorSet();
        this.i = r3;
        r3.playTogether(new Animator[]{r0, r2});
        this.i.addListener(new ClearTextEndIconDelegate$6(this));
        ValueAnimator r1 = a(new float[]{1.0f, 0.0f});
        this.j = r1;
        r1.addListener(new ClearTextEndIconDelegate$7(this));
    }

    private ValueAnimator a(float... r3) {
        ValueAnimator r4 = ValueAnimator.ofFloat(r3);
        r4.setInterpolator(com.google.android.material.animation.a.f13142a);
        r4.setDuration(100);
        r4.addUpdateListener(new ClearTextEndIconDelegate$8(this));
        return r4;
    }

    private ValueAnimator d() {
        ValueAnimator r0 = ValueAnimator.ofFloat(new float[]{0.8f, 1.0f});
        r0.setInterpolator(com.google.android.material.animation.a.f13145d);
        r0.setDuration(150);
        r0.addUpdateListener(new ClearTextEndIconDelegate$9(this));
        return r0;
    }

    private boolean e() {
        EditText r0 = this.f13645a.getEditText();
        if (r0 != null) goto L5;
    L11:
        return false;
    L5:
        if (r0.hasFocus() == true) goto L9;
        if (this.f13647c.hasFocus() == false) goto L11;
    L9:
        if (r0.getText().length() <= 0) goto L11;
        return true;
    }
}
