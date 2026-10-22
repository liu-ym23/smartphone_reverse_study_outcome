package com.stepos.ailauncher.chat.adapter;

import Z8.C1173v;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.R$id;
import com.stepos.ailauncher.chat.R$layout;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import java.util.List;
import kotlin.Metadata;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001cB/\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000f\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001b\u0010\u0018\u001a\u00020\u00072\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u001aR\"\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u001b¨\u0006\u001d"}, d2 = {"Lcom/stepos/ailauncher/chat/adapter/W;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/stepos/ailauncher/chat/adapter/W$a;", "", "Lcom/stepos/ailauncher/chat/adapter/U;", DidiCardProvider.KEY_ITEMS, "Lkotlin/Function1;", "LY8/t;", "onItemClick", "<init>", "(Ljava/util/List;Lp9/l;)V", "Landroid/view/ViewGroup;", "parent", "", "viewType", "f", "(Landroid/view/ViewGroup;I)Lcom/stepos/ailauncher/chat/adapter/W$a;", "holder", "position", Const.INTENT_KEY_UMID, "(Lcom/stepos/ailauncher/chat/adapter/W$a;I)V", "getItemCount", "()I", "newItems", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/util/List;)V", "Ljava/util/List;", "Lp9/l;", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class W extends RecyclerView.Adapter<a> {
    private List<SessionItem> items;
    private final InterfaceC5074l<SessionItem, Y8.t> onItemClick;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/stepos/ailauncher/chat/adapter/W$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "Landroid/widget/ImageView;", "ivSessionIcon", "Landroid/widget/ImageView;", "getIvSessionIcon", "()Landroid/widget/ImageView;", "Landroid/widget/TextView;", "tvSessionName", "Landroid/widget/TextView;", Const.INTENT_KEY_APIKEY, "()Landroid/widget/TextView;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a extends RecyclerView.ViewHolder {
        private final ImageView ivSessionIcon;
        private final TextView tvSessionName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View itemView) {
            super(itemView);
            kotlin.jvm.internal.p.i(itemView, "itemView");
            View viewFindViewById = itemView.findViewById(R$id.iv_session_icon);
            kotlin.jvm.internal.p.h(viewFindViewById, "findViewById(...)");
            this.ivSessionIcon = (ImageView) viewFindViewById;
            View viewFindViewById2 = itemView.findViewById(R$id.tv_session_name);
            kotlin.jvm.internal.p.h(viewFindViewById2, "findViewById(...)");
            this.tvSessionName = (TextView) viewFindViewById2;
        }

        /* renamed from: a, reason: from getter */
        public final TextView getTvSessionName() {
            return this.tvSessionName;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public W() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static final void e(W w10, SessionItem sessionItem, View view) {
        InterfaceC5074l<SessionItem, Y8.t> interfaceC5074l = w10.onItemClick;
        if (interfaceC5074l != null) {
            interfaceC5074l.invoke(sessionItem);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a holder, int position) {
        kotlin.jvm.internal.p.i(holder, "holder");
        final SessionItem sessionItem = this.items.get(position);
        holder.getTvSessionName().setText(sessionItem.getTitle());
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.adapter.V
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                W.e(this.f24924a, sessionItem, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup parent, int viewType) {
        kotlin.jvm.internal.p.i(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R$layout.item_session_list, parent, false);
        kotlin.jvm.internal.p.f(viewInflate);
        return new a(viewInflate);
    }

    public final void g(List<SessionItem> newItems) {
        kotlin.jvm.internal.p.i(newItems, "newItems");
        this.items = newItems;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.items.size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public W(List<SessionItem> items, InterfaceC5074l<? super SessionItem, Y8.t> interfaceC5074l) {
        kotlin.jvm.internal.p.i(items, "items");
        this.items = items;
        this.onItemClick = interfaceC5074l;
    }

    public /* synthetic */ W(List list, InterfaceC5074l interfaceC5074l, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? C1173v.m() : list, (i10 & 2) != 0 ? null : interfaceC5074l);
    }
}
