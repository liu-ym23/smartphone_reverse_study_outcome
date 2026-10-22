package com.bytedance.android.ec.common.impl.sku.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import androidx.appcompat.widget.AppCompatEditText;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0014\u0010\u0005\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/ec/common/impl/sku/view/SkuEditView;", "Landroidx/appcompat/widget/AppCompatEditText;", "Lkotlin/Function0;", "", "listener", "setOnKeyPreImeListener", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attributes", "", "def", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-common-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SkuEditView extends AppCompatEditText {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function0<Unit> f43414a;

    public SkuEditView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public SkuEditView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void setOnKeyPreImeListener(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f43414a = r100;
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onKeyPreIme(int r100, KeyEvent r101) {
        if (r100 != 4) goto L10;
        Function0<Unit> r102 = this.f43414a;
        if (r102 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("listener");
    L7:
        r102.invoke();
        return true;
    L10:
        return true;
    }

    public SkuEditView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ SkuEditView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r102 & 4) == 0) goto L8;
        int r104 = R.attr.editTextStyle;
    L9:
        this(r100, r101, r104);
        return;
    L8:
        r104 = 0;
        goto L9
    }
}
