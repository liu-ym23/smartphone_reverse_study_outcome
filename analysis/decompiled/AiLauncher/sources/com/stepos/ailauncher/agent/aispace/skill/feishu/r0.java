package com.stepos.ailauncher.agent.aispace.skill.feishu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.agent.aispace.skill.feishu.r0;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010!\n\u0002\b\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u001dB\u001b\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\u000b\u001a\u00020\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\t¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\u0011\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J#\u0010\u0017\u001a\u00020\u00052\n\u0010\u0015\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0017\u0010\u0018R \u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0019R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/skill/feishu/r0;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/stepos/ailauncher/agent/aispace/skill/feishu/r0$a;", "Lkotlin/Function1;", "Lcom/stepos/ailauncher/agent/aispace/skill/feishu/p0;", "LY8/t;", "onClick", "<init>", "(Lp9/l;)V", "", "list", "f", "(Ljava/util/List;)V", "Landroid/view/ViewGroup;", "parent", "", "viewType", "e", "(Landroid/view/ViewGroup;I)Lcom/stepos/ailauncher/agent/aispace/skill/feishu/r0$a;", "getItemCount", "()I", "holder", "position", Const.INTENT_KEY_UMID, "(Lcom/stepos/ailauncher/agent/aispace/skill/feishu/r0$a;I)V", "Lp9/l;", "", DidiCardProvider.KEY_ITEMS, "Ljava/util/List;", Const.INTENT_KEY_APIKEY, "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class r0 extends RecyclerView.Adapter<a> {
    private final List<RecommendedTask> items;
    private final InterfaceC5074l<RecommendedTask, Y8.t> onClick;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/skill/feishu/r0$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "LY4/y;", "binding", "<init>", "(Lcom/stepos/ailauncher/agent/aispace/skill/feishu/r0;LY4/y;)V", "Lcom/stepos/ailauncher/agent/aispace/skill/feishu/p0;", "item", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Lcom/stepos/ailauncher/agent/aispace/skill/feishu/p0;)V", "LY4/y;", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public final class a extends RecyclerView.ViewHolder {
        private final Y4.y binding;
        final /* synthetic */ r0 this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(r0 r0Var, Y4.y binding) {
            super(binding.b());
            kotlin.jvm.internal.p.i(binding, "binding");
            this.this$0 = r0Var;
            this.binding = binding;
        }

        public static final void c(r0 r0Var, RecommendedTask recommendedTask, View view) {
            r0Var.onClick.invoke(recommendedTask);
        }

        public final void b(final RecommendedTask item) {
            kotlin.jvm.internal.p.i(item, "item");
            this.binding.tvRecTitle.setText(item.getTitle());
            this.binding.tvRecBadge.setVisibility(item.getRecommended() ? 0 : 8);
            String description = item.getDescription();
            if (description == null || La.H.x0(description)) {
                this.binding.tvRecDesc.setVisibility(8);
            } else {
                this.binding.tvRecDesc.setVisibility(0);
                this.binding.tvRecDesc.setText(item.getDescription());
            }
            LinearLayout linearLayoutB = this.binding.b();
            final r0 r0Var = this.this$0;
            linearLayoutB.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.skill.feishu.q0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    r0.a.c(r0Var, item, view);
                }
            });
            ViewGroup.LayoutParams layoutParams = this.binding.b().getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
            if (marginLayoutParams != null) {
                marginLayoutParams.bottomMargin = (int) (12 * this.binding.b().getResources().getDisplayMetrics().density);
                this.binding.b().setLayoutParams(marginLayoutParams);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public r0(InterfaceC5074l<? super RecommendedTask, Y8.t> onClick) {
        kotlin.jvm.internal.p.i(onClick, "onClick");
        this.onClick = onClick;
        this.items = new ArrayList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a holder, int position) {
        kotlin.jvm.internal.p.i(holder, "holder");
        holder.b(this.items.get(position));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup parent, int viewType) {
        kotlin.jvm.internal.p.i(parent, "parent");
        Y4.y yVarC = Y4.y.c(LayoutInflater.from(parent.getContext()), parent, false);
        kotlin.jvm.internal.p.h(yVarC, "inflate(...)");
        return new a(this, yVarC);
    }

    public final void f(List<RecommendedTask> list) {
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
