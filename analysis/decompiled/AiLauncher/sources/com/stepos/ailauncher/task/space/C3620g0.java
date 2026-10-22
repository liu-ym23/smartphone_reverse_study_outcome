package com.stepos.ailauncher.task.space;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import com.stepos.ailauncher.task.space.C3620g0;
import com.stepos.ame.sdk.SkillStoreKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001-B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\t\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rJ%\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000e¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0019H\u0016¢\u0006\u0004\b!\u0010\"R\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00060#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R6\u0010'\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\b\u0018\u00010&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,¨\u0006."}, d2 = {"Lcom/stepos/ailauncher/task/space/g0;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/stepos/ailauncher/task/space/g0$a;", "<init>", "()V", "", "Lcom/stepos/ailauncher/task/space/e0;", "list", "LY8/t;", "submitList", "(Ljava/util/List;)V", "item", "c", "(Lcom/stepos/ailauncher/task/space/e0;)V", "", "memoryId", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "time", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z", "f", "(Ljava/lang/String;)Z", "Landroid/view/ViewGroup;", "parent", "", "viewType", "e", "(Landroid/view/ViewGroup;I)Lcom/stepos/ailauncher/task/space/g0$a;", "holder", "position", Const.INTENT_KEY_UMID, "(Lcom/stepos/ailauncher/task/space/g0$a;I)V", "getItemCount", "()I", "", DidiCardProvider.KEY_ITEMS, "Ljava/util/List;", "Lkotlin/Function2;", "onItemClick", "Lp9/p;", "getOnItemClick", "()Lp9/p;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Lp9/p;)V", Const.INTENT_KEY_APIKEY, "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.task.space.g0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3620g0 extends RecyclerView.Adapter<a> {
    private final List<MemoryItem> items = new ArrayList();
    private p9.p<? super MemoryItem, ? super Integer, Y8.t> onItemClick;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J1\u0010\f\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u001a\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/stepos/ailauncher/task/space/g0$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lr6/o;", "binding", "<init>", "(Lr6/o;)V", "Lcom/stepos/ailauncher/task/space/e0;", "item", "Lkotlin/Function2;", "", "LY8/t;", "onItemClick", Const.INTENT_KEY_PKGNAME, "(Lcom/stepos/ailauncher/task/space/e0;Lp9/p;)V", "Lr6/o;", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.task.space.g0$a */
    public static final class a extends RecyclerView.ViewHolder {
        private final r6.o binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(r6.o binding) {
            super(binding.b());
            kotlin.jvm.internal.p.i(binding, "binding");
            this.binding = binding;
        }

        public static final void c(a aVar, p9.p pVar, MemoryItem memoryItem, View view) {
            int bindingAdapterPosition = aVar.getBindingAdapterPosition();
            if (bindingAdapterPosition == -1 || pVar == null) {
                return;
            }
            pVar.invoke(memoryItem, Integer.valueOf(bindingAdapterPosition));
        }

        public final void b(final MemoryItem item, final p9.p<? super MemoryItem, ? super Integer, Y8.t> onItemClick) {
            kotlin.jvm.internal.p.i(item, "item");
            this.binding.tvContent.setText(item.getContent());
            this.binding.tvTime.setText(item.getTime());
            this.binding.tvTime.setVisibility(item.getTime().length() > 0 ? 0 : 8);
            this.binding.b().setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.space.f0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    C3620g0.a.c(this.f29023a, onItemClick, item, view);
                }
            });
        }
    }

    public final void c(MemoryItem item) {
        kotlin.jvm.internal.p.i(item, "item");
        this.items.add(0, item);
        notifyItemInserted(0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a holder, int position) {
        kotlin.jvm.internal.p.i(holder, "holder");
        holder.b(this.items.get(position), this.onItemClick);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup parent, int viewType) {
        kotlin.jvm.internal.p.i(parent, "parent");
        r6.o oVarC = r6.o.c(LayoutInflater.from(parent.getContext()), parent, false);
        kotlin.jvm.internal.p.h(oVarC, "inflate(...)");
        return new a(oVarC);
    }

    public final boolean f(String memoryId) {
        kotlin.jvm.internal.p.i(memoryId, "memoryId");
        if (memoryId.length() == 0) {
            return false;
        }
        Iterator<MemoryItem> it = this.items.iterator();
        int i10 = 0;
        while (true) {
            if (!it.hasNext()) {
                i10 = -1;
                break;
            }
            if (kotlin.jvm.internal.p.d(it.next().getMemoryId(), memoryId)) {
                break;
            }
            i10++;
        }
        if (i10 < 0) {
            return false;
        }
        this.items.remove(i10);
        notifyItemRemoved(i10);
        return true;
    }

    public final void g(p9.p<? super MemoryItem, ? super Integer, Y8.t> pVar) {
        this.onItemClick = pVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.items.size();
    }

    public final boolean h(String memoryId, String content, String time) {
        kotlin.jvm.internal.p.i(memoryId, "memoryId");
        kotlin.jvm.internal.p.i(content, "content");
        kotlin.jvm.internal.p.i(time, "time");
        if (memoryId.length() == 0) {
            return false;
        }
        Iterator<MemoryItem> it = this.items.iterator();
        int i10 = 0;
        while (true) {
            if (!it.hasNext()) {
                i10 = -1;
                break;
            }
            if (kotlin.jvm.internal.p.d(it.next().getMemoryId(), memoryId)) {
                break;
            }
            i10++;
        }
        int i11 = i10;
        if (i11 < 0) {
            return false;
        }
        List<MemoryItem> list = this.items;
        list.set(i11, MemoryItem.b(list.get(i11), content, time, null, null, false, System.currentTimeMillis(), null, 92, null));
        notifyItemChanged(i11);
        return true;
    }

    public final void submitList(List<MemoryItem> list) {
        kotlin.jvm.internal.p.i(list, "list");
        this.items.clear();
        this.items.addAll(list);
        notifyDataSetChanged();
    }
}
