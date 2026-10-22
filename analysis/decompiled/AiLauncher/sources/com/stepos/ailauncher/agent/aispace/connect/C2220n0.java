package com.stepos.ailauncher.agent.aispace.connect;

import Z8.C1173v;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.agent.aispace.connect.data.AgentEntranceItem;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010!\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001dB\u001b\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\u000b\u001a\u00020\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\t¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0017\u0010\u0018R \u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0019R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/connect/n0;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/stepos/ailauncher/agent/aispace/connect/n0$a;", "Lkotlin/Function1;", "Lcom/stepos/ailauncher/agent/aispace/connect/data/i;", "LY8/t;", "onClick", "<init>", "(Lp9/l;)V", "", "list", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/util/List;)V", "Landroid/view/ViewGroup;", "parent", "", "viewType", "f", "(Landroid/view/ViewGroup;I)Lcom/stepos/ailauncher/agent/aispace/connect/n0$a;", "getItemCount", "()I", "holder", "position", Const.INTENT_KEY_UMID, "(Lcom/stepos/ailauncher/agent/aispace/connect/n0$a;I)V", "Lp9/l;", "", DidiCardProvider.KEY_ITEMS, "Ljava/util/List;", Const.INTENT_KEY_APIKEY, "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.agent.aispace.connect.n0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2220n0 extends RecyclerView.Adapter<a> {
    private final List<AgentEntranceItem> items;
    private final InterfaceC5074l<AgentEntranceItem, Y8.t> onClick;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/connect/n0$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "LY4/x;", "binding", "<init>", "(LY4/x;)V", "LY4/x;", Const.INTENT_KEY_APIKEY, "()LY4/x;", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.agent.aispace.connect.n0$a */
    public static final class a extends RecyclerView.ViewHolder {
        private final Y4.x binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Y4.x binding) {
            super(binding.b());
            kotlin.jvm.internal.p.i(binding, "binding");
            this.binding = binding;
        }

        /* renamed from: a, reason: from getter */
        public final Y4.x getBinding() {
            return this.binding;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C2220n0(InterfaceC5074l<? super AgentEntranceItem, Y8.t> onClick) {
        kotlin.jvm.internal.p.i(onClick, "onClick");
        this.onClick = onClick;
        this.items = new ArrayList();
    }

    public static final void e(C2220n0 c2220n0, AgentEntranceItem agentEntranceItem, View view) {
        c2220n0.onClick.invoke(agentEntranceItem);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a holder, int position) {
        kotlin.jvm.internal.p.i(holder, "holder");
        final AgentEntranceItem agentEntranceItem = this.items.get(position);
        holder.getBinding().tvAgentTitle.setText(agentEntranceItem.getTitle());
        holder.getBinding().tvAgentDesc.setText(agentEntranceItem.getDescription());
        holder.getBinding().ivAgentIcon.setImageResource(com.stepos.ailauncher.agent.aispace.x.INSTANCE.b(agentEntranceItem.getName()));
        holder.getBinding().vDivider.setVisibility(position == C1173v.o(this.items) ? 8 : 0);
        holder.getBinding().rowAgent.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.connect.m0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C2220n0.e(this.f24066a, agentEntranceItem, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup parent, int viewType) {
        kotlin.jvm.internal.p.i(parent, "parent");
        Y4.x xVarC = Y4.x.c(LayoutInflater.from(parent.getContext()), parent, false);
        kotlin.jvm.internal.p.h(xVarC, "inflate(...)");
        return new a(xVarC);
    }

    public final void g(List<AgentEntranceItem> list) {
        kotlin.jvm.internal.p.i(list, "list");
        this.items.clear();
        this.items.addAll(list);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.items.size();
    }
}
