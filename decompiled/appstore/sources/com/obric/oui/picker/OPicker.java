package com.obric.oui.picker;

import android.view.View;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0004H&J\u000f\u0010\u0005\u001a\u0004\u0018\u00018\u0000H&¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/picker/OPicker;", "T", "", "asView", "Landroid/view/View;", "getPicked", "()Ljava/lang/Object;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface OPicker<T> {
    @Nullable
    View asView();

    @Nullable
    T getPicked();
}
