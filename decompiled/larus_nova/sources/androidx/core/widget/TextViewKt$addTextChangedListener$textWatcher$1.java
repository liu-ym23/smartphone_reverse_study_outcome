package androidx.core.widget;

import android.text.Editable;
import android.text.TextWatcher;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J*\u0010\r\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016¨\u0006\u000f"}, d2 = {"androidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "text", "", "start", "", "count", "after", "onTextChanged", "before", "core-ktx_release"}, k = 1, mv = {1, 8, 0}, xi = 176)
public final class TextViewKt$addTextChangedListener$textWatcher$1 implements TextWatcher {
    final /* synthetic */ Function1<Editable, Unit> $afterTextChanged;
    final /* synthetic */ Function4<CharSequence, Integer, Integer, Integer, Unit> $beforeTextChanged;
    final /* synthetic */ Function4<CharSequence, Integer, Integer, Integer, Unit> $onTextChanged;

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable r100) {
        this.$afterTextChanged.invoke(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TextViewKt$addTextChangedListener$textWatcher$1(Function1<? super Editable, Unit> r100, Function4<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, Unit> r101, Function4<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, Unit> r102) {
        this.$afterTextChanged = r100;
        this.$beforeTextChanged = r101;
        this.$onTextChanged = r102;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
        this.$beforeTextChanged.invoke(r100, Integer.valueOf(r101), Integer.valueOf(r102), Integer.valueOf(r103));
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
        this.$onTextChanged.invoke(r100, Integer.valueOf(r101), Integer.valueOf(r102), Integer.valueOf(r103));
    }
}
