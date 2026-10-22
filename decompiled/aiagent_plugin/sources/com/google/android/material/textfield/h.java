package com.google.android.material.textfield;

import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.widget.EditText;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: PasswordToggleEndIconDelegate.java */
/* JADX INFO: loaded from: classes2.dex */
class h extends d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final TextWatcher f13654e;
    private final TextInputLayout.b f;
    private final TextInputLayout.c g;

    static /* synthetic */ boolean a(h r0) {
        return r0.c();
    }

    static /* synthetic */ TextWatcher b(h r0) {
        return r0.f13654e;
    }

    h(TextInputLayout r1, int r2) {
        super(r1, r2);
        this.f13654e = new PasswordToggleEndIconDelegate$1(this);
        this.f = new AnonymousClass1(this);
        this.g = new AnonymousClass2(this);
    }

    @Override // com.google.android.material.textfield.d
    void a() {
        TextInputLayout r0 = this.f13645a;
        if (this.f13648d != 0) goto L5;
        int r1 = ZeusTransformUtils.mapRes(R.drawable.design_password_eye, "drawable", "design_password_eye");
    L6:
        r0.setEndIconDrawable(r1);
        this.f13645a.setEndIconContentDescription(ZeusTransformUtils.getResources(this.f13645a, "com.obric.aiagent.plugin").getText(ZeusTransformUtils.mapRes(R.string.password_toggle_content_description, WsChannelMultiProcessSharedProvider.STRING_TYPE, "password_toggle_content_description")));
        this.f13645a.setEndIconVisible(true);
        this.f13645a.setEndIconCheckable(true);
        this.f13645a.setEndIconOnClickListener(new PasswordToggleEndIconDelegate$4(this));
        this.f13645a.addOnEditTextAttachedListener(this.f);
        this.f13645a.addOnEndIconChangedListener(this.g);
        EditText r5 = this.f13645a.getEditText();
        if (a(r5) == false) goto L10;
        r5.setTransformationMethod(PasswordTransformationMethod.getInstance());
        return;
    L10:
        return;
    L5:
        r1 = this.f13648d;
        goto L6
    }

    private boolean c() {
        EditText r1 = this.f13645a.getEditText();
        if (r1 != null) goto L5;
    L7:
        return false;
    L5:
        if (ZeusTransformUtils.instanceOf(r1.getTransformationMethod(), PasswordTransformationMethod.class) == false) goto L7;
        return true;
    }

    private static boolean a(EditText r2) {
        if (r2 != null) goto L4;
    L12:
        return false;
    L4:
        if (r2.getInputType() != 16) goto L6;
    L11:
        return true;
    L6:
        if (r2.getInputType() == 128) goto L11;
        if (r2.getInputType() == 144) goto L11;
        if (r2.getInputType() != 224) goto L12;
        goto L11
    }
}
