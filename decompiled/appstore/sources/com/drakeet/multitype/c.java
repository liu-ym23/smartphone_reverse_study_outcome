package com.drakeet.multitype;

import android.content.Context;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.apm.constant.CommonKey;
import java.util.List;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c {

    @Nullable
    private MultiTypeAdapter _adapter;

    public c() {
    }

    public static /* synthetic */ void _adapter$annotations() {
    }

    @NotNull
    public final MultiTypeAdapter getAdapter() {
        MultiTypeAdapter r10 = this._adapter;
        if (r10 == null) goto L8;
        if (r10 != null) goto L6;
        q.s();
    L6:
        return r10;
    L8:
        throw new IllegalStateException("This " + this + " has not been attached to MultiTypeAdapter yet. You should not call the method before registering the delegate.");
    }

    @NotNull
    public final List<Object> getAdapterItems() {
        return getAdapter().a();
    }

    public long getItemId(Object r10) {
        return -1;
    }

    public final int getPosition(@NotNull RecyclerView.ViewHolder r10) {
        q.h(r10, "holder");
        return r10.getAdapterPosition();
    }

    @Nullable
    public final MultiTypeAdapter get_adapter$multitype() {
        return this._adapter;
    }

    public abstract void onBindViewHolder(RecyclerView.ViewHolder r10, Object r11);

    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder r10, Object r11, @NotNull List<? extends Object> r12) {
        q.h(r10, "holder");
        q.h(r12, "payloads");
        onBindViewHolder(r10, r11);
    }

    public abstract RecyclerView.ViewHolder onCreateViewHolder(Context r10, ViewGroup r11);

    public boolean onFailedToRecycleView(@NotNull RecyclerView.ViewHolder r10) {
        q.h(r10, "holder");
        return false;
    }

    public void onViewAttachedToWindow(@NotNull RecyclerView.ViewHolder r10) {
        q.h(r10, "holder");
    }

    public void onViewDetachedFromWindow(@NotNull RecyclerView.ViewHolder r10) {
        q.h(r10, "holder");
    }

    public void onViewRecycled(@NotNull RecyclerView.ViewHolder r10) {
        q.h(r10, "holder");
    }

    public final void setAdapterItems(@NotNull List<? extends Object> r10) {
        q.h(r10, CommonKey.KEY_VALUE);
        getAdapter().h(r10);
    }

    public final void set_adapter$multitype(@Nullable MultiTypeAdapter r10) {
        this._adapter = r10;
    }
}
