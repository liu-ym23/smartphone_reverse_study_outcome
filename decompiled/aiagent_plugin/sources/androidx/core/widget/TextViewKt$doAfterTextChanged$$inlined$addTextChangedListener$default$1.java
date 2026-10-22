package androidx.core.widget;

import android.text.Editable;
import android.text.TextWatcher;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: TextView.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TextViewKt$doAfterTextChanged$$inlined$addTextChangedListener$default$1 implements TextWatcher {
    final /* synthetic */ d.h.a.b $afterTextChanged;

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r1, CharSequence.class, "com.obric.aiagent.plugin");
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r1, CharSequence.class, "com.obric.aiagent.plugin");
    }

    public TextViewKt$doAfterTextChanged$$inlined$addTextChangedListener$default$1(d.h.a.b r3) {
        this.$afterTextChanged = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable r3) {
        Editable r4 = (Editable) ZeusTransformUtils.wrapperContextForParams(r3, Editable.class, "com.obric.aiagent.plugin");
        this.$afterTextChanged.invoke(r4);
    }
}
