package com.stepos.agentframework.chatui;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.autonavi.aps.amapapi.config.Const;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.resource.bitmap.FitCenter;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.stepos.agentframework.R$drawable;
import com.stepos.agentframework.R$id;
import com.stepos.agentframework.R$layout;
import com.stepos.agentframework.chatui.p2;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001$B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J#\u0010\t\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ#\u0010\u000e\u001a\u00020\r2\n\u0010\u000b\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001b\u0010\u0015\u001a\u00020\r2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0013¢\u0006\u0004\b\u0018\u0010\u0019J\u001b\u0010\u001b\u001a\u00020\r2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\u0004\b\u001b\u0010\u0016J\u0013\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00130\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u001e\u0010\"\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006%"}, d2 = {"Lcom/stepos/agentframework/chatui/p2;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/stepos/agentframework/chatui/p2$a;", "<init>", "()V", "Landroid/view/ViewGroup;", "parent", "", "viewType", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Landroid/view/ViewGroup;I)Lcom/stepos/agentframework/chatui/p2$a;", "holder", "position", "LY8/t;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Lcom/stepos/agentframework/chatui/p2$a;I)V", "getItemCount", "()I", "", "", "newList", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/util/List;)V", "item", Const.INTENT_KEY_UMID, "(Ljava/lang/String;)V", DidiCardProvider.KEY_ITEMS, "e", "f", "()Ljava/util/List;", "", "dataList", "Ljava/util/List;", "Lkotlin/Function0;", "onItemClickListener", "Lp9/a;", Const.INTENT_KEY_APIKEY, "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class p2 extends RecyclerView.Adapter<a> {
    private final List<String> dataList = new ArrayList();
    private InterfaceC5063a<Y8.t> onItemClickListener;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0012\u001a\n \u0011*\u0004\u0018\u00010\u00100\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/stepos/agentframework/chatui/p2$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "view", "<init>", "(Lcom/stepos/agentframework/chatui/p2;Landroid/view/View;)V", "", "item", "", "position", "LY8/t;", Const.INTENT_KEY_UMID, "(Ljava/lang/String;I)V", "imagePath", "c", "(Ljava/lang/String;)V", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "ivExecuteImg", "Landroid/widget/ImageView;", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public final class a extends RecyclerView.ViewHolder {
        private final ImageView ivExecuteImg;
        final /* synthetic */ p2 this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(final p2 p2Var, View view) {
            super(view);
            kotlin.jvm.internal.p.i(view, "view");
            this.this$0 = p2Var;
            this.ivExecuteImg = (ImageView) this.itemView.findViewById(R$id.iv_image);
            this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.agentframework.chatui.o2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    p2.a.b(p2Var, view2);
                }
            });
        }

        public static final void b(p2 p2Var, View view) {
            InterfaceC5063a interfaceC5063a = p2Var.onItemClickListener;
            if (interfaceC5063a != null) {
                interfaceC5063a.invoke();
            }
        }

        public final void c(String imagePath) {
            Context context = this.itemView.getContext();
            if ((context instanceof Activity) && ((Activity) context).isDestroyed()) {
                return;
            }
            RequestBuilder<Drawable> requestBuilderLoad = Glide.with(context).load(imagePath);
            FitCenter fitCenter = new FitCenter();
            O6.d dVar = O6.d.INSTANCE;
            kotlin.jvm.internal.p.f(context);
            requestBuilderLoad.transform(fitCenter, new RoundedCorners(dVar.a(context, 16.0f))).placeholder(R$drawable.placeholder_task_robot_execute_img).into(this.ivExecuteImg);
        }

        public final void d(String item, int position) {
            kotlin.jvm.internal.p.i(item, "item");
            c(item);
        }
    }

    public final void d(String item) {
        kotlin.jvm.internal.p.i(item, "item");
        this.dataList.add(item);
        notifyItemInserted(this.dataList.size() - 1);
    }

    public final void e(List<String> items) {
        kotlin.jvm.internal.p.i(items, "items");
        int size = this.dataList.size();
        this.dataList.addAll(items);
        notifyItemRangeInserted(size, items.size());
    }

    public final List<String> f() {
        return this.dataList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a holder, int position) {
        kotlin.jvm.internal.p.i(holder, "holder");
        holder.d(this.dataList.get(position), position);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.dataList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup parent, int viewType) {
        kotlin.jvm.internal.p.i(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R$layout.item_task_robot_image, parent, false);
        kotlin.jvm.internal.p.f(viewInflate);
        return new a(this, viewInflate);
    }

    public final void i(List<String> newList) {
        kotlin.jvm.internal.p.i(newList, "newList");
        this.dataList.clear();
        this.dataList.addAll(newList);
        notifyDataSetChanged();
    }
}
