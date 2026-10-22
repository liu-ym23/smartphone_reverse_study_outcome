package androidx.core.widget;

import android.text.Editable;
import android.text.TextWatcher;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.r;
import d.x;

/* JADX INFO: compiled from: TextView.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TextViewKt$addTextChangedListener$textWatcher$1 implements TextWatcher {
    final /* synthetic */ d.h.a.b<Editable, x> $afterTextChanged;
    final /* synthetic */ r<CharSequence, Integer, Integer, Integer, x> $beforeTextChanged;
    final /* synthetic */ r<CharSequence, Integer, Integer, Integer, x> $onTextChanged;

    public TextViewKt$addTextChangedListener$textWatcher$1(d.h.a.b<? super Editable, x> r3, r<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, x> r4, r<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, x> r5) {
        d.h.a.b<Editable, x> r6 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
        r<CharSequence, Integer, Integer, Integer, x> r7 = (r) ZeusTransformUtils.wrapperContextForParams(r4, r.class, "com.obric.aiagent.plugin");
        r<CharSequence, Integer, Integer, Integer, x> r8 = (r) ZeusTransformUtils.wrapperContextForParams(r5, r.class, "com.obric.aiagent.plugin");
        this.$afterTextChanged = r6;
        this.$beforeTextChanged = r7;
        this.$onTextChanged = r8;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable r3) {
        Editable r4 = (Editable) ZeusTransformUtils.wrapperContextForParams(r3, Editable.class, "com.obric.aiagent.plugin");
        this.$afterTextChanged.invoke(r4);
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence r3, int r4, int r5, int r6) {
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        this.$beforeTextChanged.a(r7, Integer.valueOf(r4), Integer.valueOf(r5), Integer.valueOf(r6));
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence r3, int r4, int r5, int r6) {
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        this.$onTextChanged.a(r7, Integer.valueOf(r4), Integer.valueOf(r5), Integer.valueOf(r6));
    }
}
