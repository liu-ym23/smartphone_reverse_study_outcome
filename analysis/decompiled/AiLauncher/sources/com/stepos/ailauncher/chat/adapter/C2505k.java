package com.stepos.ailauncher.chat.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.autonavi.aps.amapapi.config.Const;
import com.bumptech.glide.Glide;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001fB-\u0012$\u0010\t\u001a \u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\r\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R2\u0010\t\u001a \u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u001aR$\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u001bj\b\u0012\u0004\u0012\u00020\u0006`\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006 "}, d2 = {"Lcom/stepos/ailauncher/chat/adapter/k;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/stepos/ailauncher/chat/adapter/k$a;", "Lkotlin/Function3;", "Landroid/view/View;", "", "", "", "LY8/t;", "onScreenshotClick", "<init>", "(Lp9/q;)V", "list", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/util/List;)V", "Landroid/view/ViewGroup;", "parent", "viewType", "f", "(Landroid/view/ViewGroup;I)Lcom/stepos/ailauncher/chat/adapter/k$a;", "getItemCount", "()I", "holder", "position", Const.INTENT_KEY_UMID, "(Lcom/stepos/ailauncher/chat/adapter/k$a;I)V", "Lp9/q;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "urls", "Ljava/util/ArrayList;", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.chat.adapter.k, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2505k extends RecyclerView.Adapter<a> {
    private final p9.q<View, List<String>, Integer, Y8.t> onScreenshotClick;
    private final ArrayList<String> urls;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/stepos/ailauncher/chat/adapter/k$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Ll5/m;", "binding", "<init>", "(Ll5/m;)V", "Landroid/widget/ImageView;", "image", "Landroid/widget/ImageView;", Const.INTENT_KEY_APIKEY, "()Landroid/widget/ImageView;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.adapter.k$a */
    public static final class a extends RecyclerView.ViewHolder {
        private final ImageView image;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(l5.m binding) {
            super(binding.b());
            kotlin.jvm.internal.p.i(binding, "binding");
            ImageView ivScreenshot = binding.ivScreenshot;
            kotlin.jvm.internal.p.h(ivScreenshot, "ivScreenshot");
            this.image = ivScreenshot;
        }

        /* renamed from: a, reason: from getter */
        public final ImageView getImage() {
            return this.image;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C2505k(p9.q<? super View, ? super List<String>, ? super Integer, Y8.t> onScreenshotClick) {
        kotlin.jvm.internal.p.i(onScreenshotClick, "onScreenshotClick");
        this.onScreenshotClick = onScreenshotClick;
        this.urls = new ArrayList<>();
    }

    public static final void e(a aVar, C2505k c2505k, View view) {
        int bindingAdapterPosition = aVar.getBindingAdapterPosition();
        if (bindingAdapterPosition == -1 || bindingAdapterPosition < 0 || bindingAdapterPosition >= c2505k.urls.size()) {
            return;
        }
        c2505k.onScreenshotClick.invoke(aVar.getImage(), Z8.F.m1(c2505k.urls), Integer.valueOf(bindingAdapterPosition));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(final a holder, int position) {
        kotlin.jvm.internal.p.i(holder, "holder");
        Glide.with(holder.getImage()).load(this.urls.get(position)).into(holder.getImage());
        holder.getImage().setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.adapter.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C2505k.e(holder, this, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup parent, int viewType) {
        kotlin.jvm.internal.p.i(parent, "parent");
        l5.m mVarC = l5.m.c(LayoutInflater.from(parent.getContext()), parent, false);
        kotlin.jvm.internal.p.h(mVarC, "inflate(...)");
        return new a(mVarC);
    }

    public final void g(List<String> list) {
        kotlin.jvm.internal.p.i(list, "list");
        this.urls.clear();
        this.urls.addAll(list);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.urls.size();
    }
}
