package com.stepos.ailauncher.chat.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.ListAdapter;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.adapter.S;
import com.stepos.ailauncher.chat.adapter.f0;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/stepos/ailauncher/chat/adapter/a0;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/stepos/ailauncher/chat/adapter/S$f$b;", "Lcom/stepos/ailauncher/chat/adapter/f0;", "Lcom/stepos/ailauncher/chat/adapter/f0$a;", "callbacks", "<init>", "(Lcom/stepos/ailauncher/chat/adapter/f0$a;)V", "Landroid/view/ViewGroup;", "parent", "", "viewType", Const.INTENT_KEY_UMID, "(Landroid/view/ViewGroup;I)Lcom/stepos/ailauncher/chat/adapter/f0;", "holder", "position", "LY8/t;", "c", "(Lcom/stepos/ailauncher/chat/adapter/f0;I)V", "e", "(Lcom/stepos/ailauncher/chat/adapter/f0;)V", "Lcom/stepos/ailauncher/chat/adapter/f0$a;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class a0 extends ListAdapter<S.f.AgentRow, f0> {
    private final f0.a callbacks;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a0(f0.a callbacks) {
        super(new g0());
        kotlin.jvm.internal.p.i(callbacks, "callbacks");
        this.callbacks = callbacks;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(f0 holder, int position) {
        kotlin.jvm.internal.p.i(holder, "holder");
        S.f.AgentRow item = getItem(position);
        kotlin.jvm.internal.p.h(item, "getItem(...)");
        holder.g(item);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public f0 onCreateViewHolder(ViewGroup parent, int viewType) {
        kotlin.jvm.internal.p.i(parent, "parent");
        return f0.INSTANCE.a(parent, this.callbacks, false);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void onViewRecycled(f0 holder) {
        kotlin.jvm.internal.p.i(holder, "holder");
        holder.h();
    }
}
