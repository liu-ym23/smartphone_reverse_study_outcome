package com.obric.oui.dialog.input;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import com.obric.oui.common.util.k;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: TextView.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class InputBodyController$special$$inlined$addTextChangedListener$default$1 implements TextWatcher {
    final /* synthetic */ a this$0;

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r1, CharSequence.class, "com.obric.aiagent.plugin");
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r1, CharSequence.class, "com.obric.aiagent.plugin");
    }

    public InputBodyController$special$$inlined$addTextChangedListener$default$1(a r1) {
        this.this$0 = r1;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable r3) {
        Editable r4 = (Editable) ZeusTransformUtils.wrapperContextForParams(r3, Editable.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L5;
    L7:
        k.b((View) ZeusTransformUtils.preCheckCast(this.this$0.a(), View.class, "com.obric.aiagent.plugin"));
        return;
    L5:
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r4.toString(), CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L7;
        k.a((View) ZeusTransformUtils.preCheckCast(this.this$0.a(), View.class, "com.obric.aiagent.plugin"));
    }
}
