package com.bytedanceos.appstore.buss.widget.app.base;

import android.content.Context;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedanceos.appstore.buss.utilities.f;
import com.bytedanceos.common.toolbox.ServerElements;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B\u0019\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u000e\u001a\u00020\u000fH\u0014J\u0016\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00010\u0013H$J\u0017\u0010\u0014\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00018\u0000H&¢\u0006\u0002\u0010\u0016R\u001e\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u000b0\nX¤\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/bytedanceos/appstore/buss/widget/app/base/BasePagerView;", "W", "E", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "adapter", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "getAdapter", "()Lcom/chad/library/adapter/base/BaseQuickAdapter;", "getSpanCount", "", "setItems", "", ServerElements.LIST, "", "setNewData", "wrap", "(Ljava/lang/Object;)V", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class BasePagerView<W, E> extends ConstraintLayout {
    public BasePagerView(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        super(r10, r11);
    }

    @NotNull
    public abstract BaseQuickAdapter<E, BaseViewHolder> getAdapter();

    public int getSpanCount() {
        return f.f8838a.f(getContext());
    }

    public abstract void setItems(@NotNull List<? extends E> r10);

    public abstract void setNewData(@Nullable W r10);
}
