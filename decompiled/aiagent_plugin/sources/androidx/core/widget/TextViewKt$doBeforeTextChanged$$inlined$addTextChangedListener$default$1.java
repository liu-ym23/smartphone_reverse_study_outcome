package androidx.core.widget;

import android.text.Editable;
import android.text.TextWatcher;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.r;

/* JADX INFO: compiled from: TextView.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TextViewKt$doBeforeTextChanged$$inlined$addTextChangedListener$default$1 implements TextWatcher {
    final /* synthetic */ r $beforeTextChanged;

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable r2) {
        Editable r1 = (Editable) ZeusTransformUtils.wrapperContextForParams(r2, Editable.class, "com.obric.aiagent.plugin");
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r1, CharSequence.class, "com.obric.aiagent.plugin");
    }

    public TextViewKt$doBeforeTextChanged$$inlined$addTextChangedListener$default$1(r r3) {
        this.$beforeTextChanged = (r) ZeusTransformUtils.wrapperContextForParams(r3, r.class, "com.obric.aiagent.plugin");
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence r3, int r4, int r5, int r6) {
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        this.$beforeTextChanged.a(r7, Integer.valueOf(r4), Integer.valueOf(r5), Integer.valueOf(r6));
    }
}
