package com.chad.library.adapter.base.diff;

import androidx.recyclerview.widget.ListUpdateCallback;
import com.bytedance.common.wschannel.WsConstants;
import com.chad.library.adapter.base.BaseQuickAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\u0010\u0002\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003¢\u0006\u0002\u0010\u0004J\"\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\bH\u0016J\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016R\u0016\u0010\u0002\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/chad/library/adapter/base/diff/BrvahListUpdateCallback;", "Landroidx/recyclerview/widget/ListUpdateCallback;", "mAdapter", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "(Lcom/chad/library/adapter/base/BaseQuickAdapter;)V", "onChanged", "", "position", "", "count", WsConstants.KEY_PAYLOAD, "", "onInserted", "onMoved", "fromPosition", "toPosition", "onRemoved", "com.github.CymChad.brvah"}, k = 1, mv = {1, 1, 16})
public final class BrvahListUpdateCallback implements ListUpdateCallback {
    private final BaseQuickAdapter<?, ?> mAdapter;

    public BrvahListUpdateCallback(@NotNull BaseQuickAdapter<?, ?> r10) {
        q.h(r10, "mAdapter");
        this.mAdapter = r10;
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onChanged(int r10, int r11, @Nullable Object r12) {
        BaseQuickAdapter<?, ?> r13 = this.mAdapter;
        r13.notifyItemRangeChanged(r10 + r13.getHeaderLayoutCount(), r11, r12);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onInserted(int r10, int r11) {
        BaseQuickAdapter<?, ?> r12 = this.mAdapter;
        r12.notifyItemRangeInserted(r10 + r12.getHeaderLayoutCount(), r11);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onMoved(int r10, int r11) {
        BaseQuickAdapter<?, ?> r12 = this.mAdapter;
        r12.notifyItemMoved(r10 + r12.getHeaderLayoutCount(), r11 + this.mAdapter.getHeaderLayoutCount());
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onRemoved(int r10, int r11) {
        BaseQuickAdapter<?, ?> r12 = this.mAdapter;
        r12.notifyItemRangeRemoved(r10 + r12.getHeaderLayoutCount(), r11);
    }
}
