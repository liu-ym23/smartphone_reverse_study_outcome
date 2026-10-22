package com.stepos.ailauncher.chat.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.R$color;
import com.stepos.ailauncher.chat.R$id;
import com.stepos.ailauncher.chat.R$layout;
import com.stepos.ailauncher.chat.adapter.X;
import com.stepos.ailauncher.contract.model.search.SessionSearchHit;
import kotlin.Metadata;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0003\u0017\u001b\u001cB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J#\u0010\n\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\u000f\u001a\u00020\u000e2\n\u0010\f\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\r\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0011\u001a\u00020\u000e2\n\u0010\f\u001a\u00060\u0003R\u00020\u0000H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R0\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lcom/stepos/ailauncher/chat/adapter/X;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/stepos/ailauncher/chat/adapter/X$c;", "Lcom/stepos/ailauncher/chat/adapter/X$b;", "<init>", "()V", "Landroid/view/ViewGroup;", "parent", "", "viewType", "e", "(Landroid/view/ViewGroup;I)Lcom/stepos/ailauncher/chat/adapter/X$b;", "holder", "position", "LY8/t;", Const.INTENT_KEY_UMID, "(Lcom/stepos/ailauncher/chat/adapter/X$b;I)V", "f", "(Lcom/stepos/ailauncher/chat/adapter/X$b;)V", "Lkotlin/Function1;", "Lcom/stepos/ailauncher/contract/model/search/SessionSearchHit;", "onHitClick", "Lp9/l;", "c", "()Lp9/l;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Lp9/l;)V", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class X extends ListAdapter<Row, b> {
    private InterfaceC5074l<? super SessionSearchHit, Y8.t> onHitClick;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0002\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\n\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\tJ\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/stepos/ailauncher/chat/adapter/X$a;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/stepos/ailauncher/chat/adapter/X$c;", "<init>", "()V", "oldItem", "newItem", "", Const.INTENT_KEY_PKGNAME, "(Lcom/stepos/ailauncher/chat/adapter/X$c;Lcom/stepos/ailauncher/chat/adapter/X$c;)Z", Const.INTENT_KEY_APIKEY, "", "c", "(Lcom/stepos/ailauncher/chat/adapter/X$c;Lcom/stepos/ailauncher/chat/adapter/X$c;)Ljava/lang/Object;", "Companion", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a extends DiffUtil.ItemCallback<Row> {
        private static final C0275a Companion = new C0275a(null);
        private static final Object PAYLOAD_REBIND = new Object();

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/stepos/ailauncher/chat/adapter/X$a$a;", "", "<init>", "()V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* renamed from: com.stepos.ailauncher.chat.adapter.X$a$a, reason: collision with other inner class name */
        public static final class C0275a {
            public /* synthetic */ C0275a(kotlin.jvm.internal.i iVar) {
                this();
            }

            public C0275a() {
            }
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(Row oldItem, Row newItem) {
            kotlin.jvm.internal.p.i(oldItem, "oldItem");
            kotlin.jvm.internal.p.i(newItem, "newItem");
            return kotlin.jvm.internal.p.d(oldItem, newItem);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(Row oldItem, Row newItem) {
            kotlin.jvm.internal.p.i(oldItem, "oldItem");
            kotlin.jvm.internal.p.i(newItem, "newItem");
            return kotlin.jvm.internal.p.d(oldItem.getHit().getSessionId(), newItem.getHit().getSessionId());
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Object getChangePayload(Row oldItem, Row newItem) {
            kotlin.jvm.internal.p.i(oldItem, "oldItem");
            kotlin.jvm.internal.p.i(newItem, "newItem");
            return PAYLOAD_REBIND;
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u000fR\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/stepos/ailauncher/chat/adapter/X$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "itemView", "<init>", "(Lcom/stepos/ailauncher/chat/adapter/X;Landroid/view/View;)V", "Lcom/stepos/ailauncher/chat/adapter/X$c;", "row", "LY8/t;", "c", "(Lcom/stepos/ailauncher/chat/adapter/X$c;)V", Const.INTENT_KEY_UMID, "()V", "Landroid/widget/TextView;", "title", "Landroid/widget/TextView;", "badge", "time", "secondary", "Landroid/view/View;", "snippet", "", "highlightColor", "I", "Lcom/stepos/ailauncher/contract/model/search/SessionSearchHit;", com.stepos.ailauncher.sla.G.JUDGE_HIT, "Lcom/stepos/ailauncher/contract/model/search/SessionSearchHit;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public final class b extends RecyclerView.ViewHolder {
        private final TextView badge;
        private final int highlightColor;
        private SessionSearchHit hit;
        private final View secondary;
        private final TextView snippet;
        final /* synthetic */ X this$0;
        private final TextView time;
        private final TextView title;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(final X x10, View itemView) {
            super(itemView);
            kotlin.jvm.internal.p.i(itemView, "itemView");
            this.this$0 = x10;
            View viewFindViewById = itemView.findViewById(R$id.tv_search_result_title);
            kotlin.jvm.internal.p.h(viewFindViewById, "findViewById(...)");
            this.title = (TextView) viewFindViewById;
            View viewFindViewById2 = itemView.findViewById(R$id.tv_search_result_badge);
            kotlin.jvm.internal.p.h(viewFindViewById2, "findViewById(...)");
            this.badge = (TextView) viewFindViewById2;
            View viewFindViewById3 = itemView.findViewById(R$id.tv_search_result_time);
            kotlin.jvm.internal.p.h(viewFindViewById3, "findViewById(...)");
            this.time = (TextView) viewFindViewById3;
            View viewFindViewById4 = itemView.findViewById(R$id.search_result_secondary);
            kotlin.jvm.internal.p.h(viewFindViewById4, "findViewById(...)");
            this.secondary = viewFindViewById4;
            View viewFindViewById5 = itemView.findViewById(R$id.tv_search_result_snippet);
            kotlin.jvm.internal.p.h(viewFindViewById5, "findViewById(...)");
            this.snippet = (TextView) viewFindViewById5;
            this.highlightColor = androidx.core.content.a.c(itemView.getContext(), R$color.search_match_highlight);
            itemView.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.adapter.Y
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    X.b.b(this.f24926a, x10, view);
                }
            });
            itemView.findViewById(R$id.tv_search_result_status).setVisibility(8);
            itemView.findViewById(R$id.tv_search_result_separator).setVisibility(8);
        }

        public static final void b(b bVar, X x10, View view) {
            InterfaceC5074l<SessionSearchHit, Y8.t> interfaceC5074lC;
            SessionSearchHit sessionSearchHit = bVar.hit;
            if (sessionSearchHit == null || (interfaceC5074lC = x10.c()) == null) {
                return;
            }
            interfaceC5074lC.invoke(sessionSearchHit);
        }

        public final void c(Row row) {
            kotlin.jvm.internal.p.i(row, "row");
            this.hit = row.getHit();
            this.title.setText(Z.b(row.getHit().getTitle(), row.getQuery(), this.highlightColor));
            this.snippet.setText(row.getHit().getSnippet());
            this.secondary.setVisibility(La.H.x0(row.getHit().getSnippet()) ? 8 : 0);
            this.badge.setText(row.getHit().getAgentLabel());
            this.badge.setVisibility(La.H.x0(row.getHit().getAgentLabel()) ? 8 : 0);
            TextView textView = this.time;
            com.stepos.ailauncher.chat.util.s sVar = com.stepos.ailauncher.chat.util.s.INSTANCE;
            Context context = this.itemView.getContext();
            kotlin.jvm.internal.p.h(context, "getContext(...)");
            textView.setText(com.stepos.ailauncher.chat.util.s.c(sVar, context, row.getHit().getUpdatedAt(), 0L, 4, null));
        }

        public final void d() {
            this.hit = null;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0015\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/stepos/ailauncher/chat/adapter/X$c;", "", "Lcom/stepos/ailauncher/contract/model/search/SessionSearchHit;", com.stepos.ailauncher.sla.G.JUDGE_HIT, "", "query", "<init>", "(Lcom/stepos/ailauncher/contract/model/search/SessionSearchHit;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/stepos/ailauncher/contract/model/search/SessionSearchHit;", Const.INTENT_KEY_APIKEY, "()Lcom/stepos/ailauncher/contract/model/search/SessionSearchHit;", "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.adapter.X$c, reason: from toString */
    public static final /* data */ class Row {
        private final SessionSearchHit hit;
        private final String query;

        public Row(SessionSearchHit hit, String query) {
            kotlin.jvm.internal.p.i(hit, "hit");
            kotlin.jvm.internal.p.i(query, "query");
            this.hit = hit;
            this.query = query;
        }

        /* renamed from: a, reason: from getter */
        public final SessionSearchHit getHit() {
            return this.hit;
        }

        /* renamed from: b, reason: from getter */
        public final String getQuery() {
            return this.query;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Row)) {
                return false;
            }
            Row row = (Row) other;
            return kotlin.jvm.internal.p.d(this.hit, row.hit) && kotlin.jvm.internal.p.d(this.query, row.query);
        }

        public int hashCode() {
            return (this.hit.hashCode() * 31) + this.query.hashCode();
        }

        public String toString() {
            return "Row(hit=" + this.hit + ", query=" + this.query + ")";
        }
    }

    public X() {
        super(new a());
    }

    public final InterfaceC5074l<SessionSearchHit, Y8.t> c() {
        return this.onHitClick;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(b holder, int position) {
        kotlin.jvm.internal.p.i(holder, "holder");
        Row item = getItem(position);
        kotlin.jvm.internal.p.h(item, "getItem(...)");
        holder.c(item);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(ViewGroup parent, int viewType) {
        kotlin.jvm.internal.p.i(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R$layout.item_search_result, parent, false);
        kotlin.jvm.internal.p.h(viewInflate, "inflate(...)");
        return new b(this, viewInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public void onViewRecycled(b holder) {
        kotlin.jvm.internal.p.i(holder, "holder");
        holder.d();
    }

    public final void g(InterfaceC5074l<? super SessionSearchHit, Y8.t> interfaceC5074l) {
        this.onHitClick = interfaceC5074l;
    }
}
