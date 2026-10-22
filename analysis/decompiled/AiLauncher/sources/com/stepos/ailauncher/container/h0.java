package com.stepos.ailauncher.container;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ailauncher.container.api.IOverlayPageHost;
import com.stepos.ailauncher.container.api.IOverlayPageProvider;
import com.stepos.ailauncher.container.api.IOverlayPageView;
import com.stepos.ailauncher.container.api.OverlayPageDestroyReason;
import com.stepos.ailauncher.container.api.OverlayPageLoadPolicy;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001+B\u001d\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\f\u001a\u00020\u000b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001e\u001a\u00020\u000b2\b\b\u0002\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ+\u0010#\u001a\u00020\"2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002¢\u0006\u0004\b#\u0010$R\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010%R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010&R\u001a\u0010)\u001a\b\u0012\u0004\u0012\u00020(0'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*¨\u0006,"}, d2 = {"Lcom/stepos/ailauncher/container/h0;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/stepos/ailauncher/container/h0$a;", "", "Lcom/stepos/ailauncher/container/api/IOverlayPageProvider;", "providers", "Lcom/stepos/ailauncher/container/api/IOverlayPageHost;", "host", "<init>", "(Ljava/util/List;Lcom/stepos/ailauncher/container/api/IOverlayPageHost;)V", "newProviders", "LY8/t;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/util/List;)V", "Landroid/view/ViewGroup;", "parent", "", "viewType", "e", "(Landroid/view/ViewGroup;I)Lcom/stepos/ailauncher/container/h0$a;", "holder", "position", Const.INTENT_KEY_UMID, "(Lcom/stepos/ailauncher/container/h0$a;I)V", "getItemCount", "()I", "getItemViewType", "(I)I", "Lcom/stepos/ailauncher/container/api/OverlayPageDestroyReason;", "reason", "c", "(Lcom/stepos/ailauncher/container/api/OverlayPageDestroyReason;)V", ChatTracker.WORLD_OLD, Const.STR_NEW, "", "f", "(Ljava/util/List;Ljava/util/List;)Z", "Ljava/util/List;", "Lcom/stepos/ailauncher/container/api/IOverlayPageHost;", "", "Landroid/view/View;", "createdViews", "Ljava/util/Set;", Const.INTENT_KEY_APIKEY, "container_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class h0 extends RecyclerView.Adapter<a> {
    private final Set<View> createdViews;
    private final IOverlayPageHost host;
    private List<? extends IOverlayPageProvider> providers;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/stepos/ailauncher/container/h0$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "container_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a extends RecyclerView.ViewHolder {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View itemView) {
            super(itemView);
            kotlin.jvm.internal.p.i(itemView, "itemView");
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class b {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[OverlayPageLoadPolicy.values().length];
            try {
                iArr[OverlayPageLoadPolicy.IMMEDIATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[OverlayPageLoadPolicy.LAZY_ON_RESUME.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public h0(List<? extends IOverlayPageProvider> providers, IOverlayPageHost host) {
        kotlin.jvm.internal.p.i(providers, "providers");
        kotlin.jvm.internal.p.i(host, "host");
        this.providers = providers;
        this.host = host;
        this.createdViews = new LinkedHashSet();
    }

    public final void c(OverlayPageDestroyReason reason) {
        kotlin.jvm.internal.p.i(reason, "reason");
        for (KeyEvent.Callback callback : this.createdViews) {
            IOverlayPageView iOverlayPageView = callback instanceof IOverlayPageView ? (IOverlayPageView) callback : null;
            if (iOverlayPageView != null) {
                iOverlayPageView.onPageStop();
                iOverlayPageView.onPageDestroy(reason);
            }
        }
        this.createdViews.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a holder, int position) {
        kotlin.jvm.internal.p.i(holder, "holder");
        KeyEvent.Callback itemView = holder.itemView;
        kotlin.jvm.internal.p.h(itemView, "itemView");
        if (this.createdViews.contains(itemView)) {
            return;
        }
        this.createdViews.add(itemView);
        IOverlayPageView iOverlayPageView = itemView instanceof IOverlayPageView ? (IOverlayPageView) itemView : null;
        if (iOverlayPageView != null) {
            iOverlayPageView.onPageCreate(this.host);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup parent, int viewType) {
        View viewCreateView;
        kotlin.jvm.internal.p.i(parent, "parent");
        IOverlayPageProvider iOverlayPageProvider = this.providers.get(viewType);
        int i10 = b.$EnumSwitchMapping$0[iOverlayPageProvider.getLoadPolicy().ordinal()];
        if (i10 == 1) {
            viewCreateView = iOverlayPageProvider.createView(parent);
        } else {
            if (i10 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            Context context = parent.getContext();
            kotlin.jvm.internal.p.h(context, "getContext(...)");
            viewCreateView = new C3210c(context, iOverlayPageProvider, this.host);
        }
        return new a(viewCreateView);
    }

    public final boolean f(List<? extends IOverlayPageProvider> old, List<? extends IOverlayPageProvider> list) {
        if (old.size() != list.size()) {
            return false;
        }
        int size = old.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (!kotlin.jvm.internal.p.d(old.get(i10).getPageId(), list.get(i10).getPageId())) {
                return false;
            }
        }
        return true;
    }

    public final void g(List<? extends IOverlayPageProvider> newProviders) {
        kotlin.jvm.internal.p.i(newProviders, "newProviders");
        if (f(this.providers, newProviders)) {
            return;
        }
        c(OverlayPageDestroyReason.PAGE_LIST_CHANGED);
        this.providers = newProviders;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.providers.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return position;
    }
}
