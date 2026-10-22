package com.stepos.agentframework.chatui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.autonavi.aps.amapapi.config.Const;
import com.bumptech.glide.Glide;
import com.stepos.agentframework.R$id;
import com.stepos.agentframework.R$layout;
import com.stepos.agentframework.chatui.m2;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\t\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001$B!\u0012\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0004\b\b\u0010\tJ#\u0010\r\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\r\u0010\u000eJ#\u0010\u0011\u001a\u00020\u00062\n\u0010\u000f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0017\u001a\u00020\u00062\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0005¢\u0006\u0004\b\u0019\u0010\u001aR&\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u001bR(\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00040\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\u0018R\u0016\u0010\"\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006%"}, d2 = {"Lcom/stepos/agentframework/chatui/m2;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/stepos/agentframework/chatui/m2$a;", "Lkotlin/Function2;", "Lcom/stepos/agentframework/chatui/n2;", "", "LY8/t;", "onItemClickListener", "<init>", "(Lp9/p;)V", "Landroid/view/ViewGroup;", "parent", "viewType", "f", "(Landroid/view/ViewGroup;I)Lcom/stepos/agentframework/chatui/m2$a;", "holder", "position", "e", "(Lcom/stepos/agentframework/chatui/m2$a;I)V", "getItemCount", "()I", "", "images", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/util/List;)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(I)V", "Lp9/p;", "", DidiCardProvider.KEY_ITEMS, "Ljava/util/List;", "getItems", "()Ljava/util/List;", "setItems", "selectedPosition", "I", Const.INTENT_KEY_APIKEY, "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class m2 extends RecyclerView.Adapter<a> {
    private List<TaskRobotExecuteThumbnailBean> items;
    private final p9.p<TaskRobotExecuteThumbnailBean, Integer, Y8.t> onItemClickListener;
    private int selectedPosition;

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/stepos/agentframework/chatui/m2$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "itemView", "<init>", "(Lcom/stepos/agentframework/chatui/m2;Landroid/view/View;)V", "Lcom/stepos/agentframework/chatui/n2;", "item", "", "position", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Lcom/stepos/agentframework/chatui/n2;I)V", "", "imageUrl", Const.INTENT_KEY_UMID, "(Ljava/lang/String;)V", "Landroid/widget/ImageView;", "ivImage", "Landroid/widget/ImageView;", "Landroid/widget/LinearLayout;", "rootLayout", "Landroid/widget/LinearLayout;", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public final class a extends RecyclerView.ViewHolder {
        private final ImageView ivImage;
        private final LinearLayout rootLayout;
        final /* synthetic */ m2 this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(m2 m2Var, View itemView) {
            super(itemView);
            kotlin.jvm.internal.p.i(itemView, "itemView");
            this.this$0 = m2Var;
            View viewFindViewById = itemView.findViewById(R$id.iv_image);
            kotlin.jvm.internal.p.h(viewFindViewById, "findViewById(...)");
            this.ivImage = (ImageView) viewFindViewById;
            View viewFindViewById2 = itemView.findViewById(R$id.root);
            kotlin.jvm.internal.p.h(viewFindViewById2, "findViewById(...)");
            this.rootLayout = (LinearLayout) viewFindViewById2;
        }

        public static final void c(m2 m2Var, TaskRobotExecuteThumbnailBean taskRobotExecuteThumbnailBean, int i10, View view) {
            m2Var.onItemClickListener.invoke(taskRobotExecuteThumbnailBean, Integer.valueOf(i10));
            m2Var.h(i10);
        }

        public final void b(final TaskRobotExecuteThumbnailBean item, final int position) {
            kotlin.jvm.internal.p.i(item, "item");
            d(item.getImagePath());
            this.rootLayout.setSelected(position == this.this$0.selectedPosition);
            View view = this.itemView;
            final m2 m2Var = this.this$0;
            view.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.agentframework.chatui.l2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    m2.a.c(m2Var, item, position, view2);
                }
            });
        }

        public final void d(String imageUrl) {
            Glide.with(this.itemView.getContext()).load(imageUrl).into(this.ivImage);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public m2(p9.p<? super TaskRobotExecuteThumbnailBean, ? super Integer, Y8.t> onItemClickListener) {
        kotlin.jvm.internal.p.i(onItemClickListener, "onItemClickListener");
        this.onItemClickListener = onItemClickListener;
        this.items = new ArrayList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a holder, int position) {
        kotlin.jvm.internal.p.i(holder, "holder");
        holder.b(this.items.get(position), position);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup parent, int viewType) {
        kotlin.jvm.internal.p.i(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R$layout.item_task_robot_execute_image, parent, false);
        kotlin.jvm.internal.p.f(viewInflate);
        return new a(this, viewInflate);
    }

    public final void g(List<TaskRobotExecuteThumbnailBean> images) {
        kotlin.jvm.internal.p.i(images, "images");
        this.items.clear();
        this.items.addAll(images);
        this.selectedPosition = 0;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.items.size();
    }

    public final void h(int position) {
        if (position < 0 || position >= this.items.size()) {
            return;
        }
        int i10 = this.selectedPosition;
        this.selectedPosition = position;
        if (i10 >= 0 && i10 < this.items.size()) {
            notifyItemChanged(i10);
        }
        int size = this.items.size();
        int i11 = this.selectedPosition;
        if (i11 < 0 || i11 >= size) {
            return;
        }
        notifyItemChanged(i11);
    }
}
