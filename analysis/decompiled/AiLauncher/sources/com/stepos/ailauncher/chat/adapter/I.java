package com.stepos.ailauncher.chat.adapter;

import Z8.C1173v;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.autonavi.aps.amapapi.AMapLocationStaticsEntity;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.R$id;
import com.stepos.ailauncher.chat.R$layout;
import com.stepos.ailauncher.contract.api.agent.IExternalAgentUiService;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010!\n\u0002\b\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u001dB\u001b\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\u000b\u001a\u00020\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\t¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\u0011\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J#\u0010\u0017\u001a\u00020\u00052\n\u0010\u0015\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0017\u0010\u0018R \u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0019R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, d2 = {"Lcom/stepos/ailauncher/chat/adapter/I;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/stepos/ailauncher/chat/adapter/I$a;", "Lkotlin/Function1;", "Lcom/stepos/ailauncher/contract/api/agent/IExternalAgentUiService$RemoteAgentEntry;", "LY8/t;", "onClick", "<init>", "(Lp9/l;)V", "", "list", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/util/List;)V", "Landroid/view/ViewGroup;", "parent", "", "viewType", "f", "(Landroid/view/ViewGroup;I)Lcom/stepos/ailauncher/chat/adapter/I$a;", "getItemCount", "()I", "holder", "position", Const.INTENT_KEY_UMID, "(Lcom/stepos/ailauncher/chat/adapter/I$a;I)V", "Lp9/l;", "", DidiCardProvider.KEY_ITEMS, "Ljava/util/List;", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class I extends RecyclerView.Adapter<a> {
    private final List<IExternalAgentUiService.RemoteAgentEntry> items;
    private final InterfaceC5074l<IExternalAgentUiService.RemoteAgentEntry, Y8.t> onClick;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u000f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0014\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0019\u001a\u00020\u00188\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u001d\u001a\u00020\u00188\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001a\u001a\u0004\b\u001e\u0010\u001cR\u0017\u0010\u001f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u0010\u001a\u0004\b \u0010\u0012¨\u0006!"}, d2 = {"Lcom/stepos/ailauncher/chat/adapter/I$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "v", "<init>", "(Lcom/stepos/ailauncher/chat/adapter/I;Landroid/view/View;)V", "", Const.INTENT_KEY_PKGNAME, "(I)I", "", AMapLocationStaticsEntity.FIRST_LOCATE, "last", "LY8/t;", Const.INTENT_KEY_APIKEY, "(ZZ)V", "row", "Landroid/view/View;", "f", "()Landroid/view/View;", "Landroid/widget/ImageView;", "icon", "Landroid/widget/ImageView;", "e", "()Landroid/widget/ImageView;", "Landroid/widget/TextView;", "title", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", Const.JSON_KEY_DESC, "c", "divider", Const.INTENT_KEY_UMID, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public final class a extends RecyclerView.ViewHolder {
        private final TextView desc;
        private final View divider;
        private final ImageView icon;
        private final View row;
        final /* synthetic */ I this$0;
        private final TextView title;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(I i10, View v10) {
            super(v10);
            kotlin.jvm.internal.p.i(v10, "v");
            this.this$0 = i10;
            View viewFindViewById = v10.findViewById(R$id.rowRemoteAgent);
            kotlin.jvm.internal.p.h(viewFindViewById, "findViewById(...)");
            this.row = viewFindViewById;
            View viewFindViewById2 = v10.findViewById(R$id.ivRemoteIcon);
            kotlin.jvm.internal.p.h(viewFindViewById2, "findViewById(...)");
            this.icon = (ImageView) viewFindViewById2;
            View viewFindViewById3 = v10.findViewById(R$id.tvRemoteTitle);
            kotlin.jvm.internal.p.h(viewFindViewById3, "findViewById(...)");
            this.title = (TextView) viewFindViewById3;
            View viewFindViewById4 = v10.findViewById(R$id.tvRemoteDesc);
            kotlin.jvm.internal.p.h(viewFindViewById4, "findViewById(...)");
            this.desc = (TextView) viewFindViewById4;
            View viewFindViewById5 = v10.findViewById(R$id.vRemoteDivider);
            kotlin.jvm.internal.p.h(viewFindViewById5, "findViewById(...)");
            this.divider = viewFindViewById5;
        }

        private final int b(int v10) {
            return (int) (v10 * this.itemView.getResources().getDisplayMetrics().density);
        }

        public final void a(boolean first, boolean last) {
            this.row.setPaddingRelative(b(16), first ? b(16) : b(12), b(16), last ? b(16) : b(12));
        }

        /* renamed from: c, reason: from getter */
        public final TextView getDesc() {
            return this.desc;
        }

        /* renamed from: d, reason: from getter */
        public final View getDivider() {
            return this.divider;
        }

        /* renamed from: e, reason: from getter */
        public final ImageView getIcon() {
            return this.icon;
        }

        /* renamed from: f, reason: from getter */
        public final View getRow() {
            return this.row;
        }

        public final TextView getTitle() {
            return this.title;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public I(InterfaceC5074l<? super IExternalAgentUiService.RemoteAgentEntry, Y8.t> onClick) {
        kotlin.jvm.internal.p.i(onClick, "onClick");
        this.onClick = onClick;
        this.items = new ArrayList();
    }

    public static final void e(I i10, IExternalAgentUiService.RemoteAgentEntry remoteAgentEntry, View view) {
        i10.onClick.invoke(remoteAgentEntry);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a holder, int position) {
        kotlin.jvm.internal.p.i(holder, "holder");
        final IExternalAgentUiService.RemoteAgentEntry remoteAgentEntry = this.items.get(position);
        holder.a(position == 0, position == C1173v.o(this.items));
        holder.getIcon().setImageResource(remoteAgentEntry.getIconRes());
        holder.getTitle().setText(remoteAgentEntry.getTitle());
        holder.getDesc().setText(remoteAgentEntry.getDescription());
        holder.getDesc().setVisibility(La.H.x0(remoteAgentEntry.getDescription()) ? 8 : 0);
        holder.getDivider().setVisibility(position == C1173v.o(this.items) ? 8 : 0);
        holder.getRow().setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.adapter.H
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                I.e(this.f24913a, remoteAgentEntry, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup parent, int viewType) {
        kotlin.jvm.internal.p.i(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R$layout.item_connect_remote_agent, parent, false);
        kotlin.jvm.internal.p.f(viewInflate);
        return new a(this, viewInflate);
    }

    public final void g(List<IExternalAgentUiService.RemoteAgentEntry> list) {
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
