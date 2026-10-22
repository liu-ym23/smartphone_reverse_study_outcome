package com.stepos.ailauncher.chat.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.R$id;
import com.stepos.ailauncher.chat.R$layout;
import com.stepos.ailauncher.chat.adapter.o0;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import java.util.List;
import kotlin.Metadata;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019B)\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000f\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0017R \u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0018¨\u0006\u001a"}, d2 = {"Lcom/stepos/ailauncher/chat/adapter/o0;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/stepos/ailauncher/chat/adapter/o0$a;", "", "", DidiCardProvider.KEY_ITEMS, "Lkotlin/Function1;", "LY8/t;", "onClick", "<init>", "(Ljava/util/List;Lp9/l;)V", "Landroid/view/ViewGroup;", "parent", "", "viewType", Const.INTENT_KEY_UMID, "(Landroid/view/ViewGroup;I)Lcom/stepos/ailauncher/chat/adapter/o0$a;", "holder", "position", "c", "(Lcom/stepos/ailauncher/chat/adapter/o0$a;I)V", "getItemCount", "()I", "Ljava/util/List;", "Lp9/l;", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class o0 extends RecyclerView.Adapter<a> {
    private final List<String> items;
    private final InterfaceC5074l<String, Y8.t> onClick;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\fR \u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/stepos/ailauncher/chat/adapter/o0$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "itemView", "Lkotlin/Function1;", "", "LY8/t;", "onClick", "<init>", "(Landroid/view/View;Lp9/l;)V", "text", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)V", "Lp9/l;", "Landroid/widget/TextView;", "textView", "Landroid/widget/TextView;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a extends RecyclerView.ViewHolder {
        private final InterfaceC5074l<String, Y8.t> onClick;
        private final TextView textView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(View itemView, InterfaceC5074l<? super String, Y8.t> onClick) {
            super(itemView);
            kotlin.jvm.internal.p.i(itemView, "itemView");
            kotlin.jvm.internal.p.i(onClick, "onClick");
            this.onClick = onClick;
            View viewFindViewById = itemView.findViewById(R$id.tv_suggestion);
            kotlin.jvm.internal.p.h(viewFindViewById, "findViewById(...)");
            this.textView = (TextView) viewFindViewById;
        }

        public static final void c(a aVar, String str, View view) {
            aVar.onClick.invoke(str);
        }

        public final void b(final String text) {
            kotlin.jvm.internal.p.i(text, "text");
            this.textView.setText(text);
            this.textView.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.adapter.n0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    o0.a.c(this.f24959a, text, view);
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public o0(List<String> items, InterfaceC5074l<? super String, Y8.t> onClick) {
        kotlin.jvm.internal.p.i(items, "items");
        kotlin.jvm.internal.p.i(onClick, "onClick");
        this.items = items;
        this.onClick = onClick;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a holder, int position) {
        kotlin.jvm.internal.p.i(holder, "holder");
        holder.b(this.items.get(position));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup parent, int viewType) {
        kotlin.jvm.internal.p.i(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R$layout.item_assistant_suggestion, parent, false);
        kotlin.jvm.internal.p.f(viewInflate);
        return new a(viewInflate, this.onClick);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.items.size();
    }
}
