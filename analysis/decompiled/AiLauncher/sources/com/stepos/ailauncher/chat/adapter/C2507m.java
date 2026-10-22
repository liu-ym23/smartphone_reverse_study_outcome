package com.stepos.ailauncher.chat.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.R$id;
import com.stepos.ailauncher.chat.R$layout;
import com.stepos.ailauncher.chat.R$string;
import com.stepos.ailauncher.contract.model.ArtifactAvailability;
import com.stepos.ailauncher.contract.model.SessionArtifact;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import h8.C4148a;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010#\n\u0002\b\u0006\u0018\u0000 $2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002%&BW\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006\u0012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0018\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001dR \u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u001eR \u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u001fR&\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000b0\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010 R\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000e0!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006'"}, d2 = {"Lcom/stepos/ailauncher/chat/adapter/m;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/stepos/ailauncher/chat/adapter/m$b;", "", "Lcom/stepos/ailauncher/contract/model/SessionArtifact;", DidiCardProvider.KEY_ITEMS, "", "", "Lcom/stepos/ailauncher/contract/model/ArtifactAvailability;", "availability", "Lkotlin/Function1;", "LY8/t;", "onClick", "Lkotlin/Function2;", "", "onExpose", "<init>", "(Ljava/util/List;Ljava/util/Map;Lp9/l;Lp9/p;)V", "Landroid/view/ViewGroup;", "parent", "viewType", "f", "(Landroid/view/ViewGroup;I)Lcom/stepos/ailauncher/chat/adapter/m$b;", "holder", "position", Const.INTENT_KEY_UMID, "(Lcom/stepos/ailauncher/chat/adapter/m$b;I)V", "getItemCount", "()I", "Ljava/util/List;", "Ljava/util/Map;", "Lp9/l;", "Lp9/p;", "", "exposed", "Ljava/util/Set;", "Companion", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.chat.adapter.m, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2507m extends RecyclerView.Adapter<b> {

    @Deprecated
    public static final float ALPHA_EXPIRED_ROW = 0.4f;
    private static final a Companion = new a(null);

    @Deprecated
    public static final String TAG = "ArtifactListAdapter";
    private final Map<String, ArtifactAvailability> availability;
    private final Set<Integer> exposed;
    private final List<SessionArtifact> items;
    private final InterfaceC5074l<SessionArtifact, Y8.t> onClick;
    private final p9.p<SessionArtifact, Integer, Y8.t> onExpose;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/stepos/ailauncher/chat/adapter/m$a;", "", "<init>", "()V", "", "TAG", "Ljava/lang/String;", "", "ALPHA_EXPIRED_ROW", "F", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.adapter.m$a */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.i iVar) {
            this();
        }

        public a() {
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0010\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/stepos/ailauncher/chat/adapter/m$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "Landroid/widget/ImageView;", "icon", "Landroid/widget/ImageView;", Const.INTENT_KEY_PKGNAME, "()Landroid/widget/ImageView;", "Landroid/widget/TextView;", "name", "Landroid/widget/TextView;", "c", "()Landroid/widget/TextView;", "chevron", "Landroid/view/View;", Const.INTENT_KEY_APIKEY, "()Landroid/view/View;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.adapter.m$b */
    public static final class b extends RecyclerView.ViewHolder {
        private final View chevron;
        private final ImageView icon;
        private final TextView name;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(View view) {
            super(view);
            kotlin.jvm.internal.p.i(view, "view");
            View viewFindViewById = view.findViewById(R$id.iv_artifact_icon);
            kotlin.jvm.internal.p.h(viewFindViewById, "findViewById(...)");
            this.icon = (ImageView) viewFindViewById;
            View viewFindViewById2 = view.findViewById(R$id.tv_artifact_name);
            kotlin.jvm.internal.p.h(viewFindViewById2, "findViewById(...)");
            this.name = (TextView) viewFindViewById2;
            View viewFindViewById3 = view.findViewById(R$id.iv_artifact_chevron);
            kotlin.jvm.internal.p.h(viewFindViewById3, "findViewById(...)");
            this.chevron = viewFindViewById3;
        }

        /* renamed from: a, reason: from getter */
        public final View getChevron() {
            return this.chevron;
        }

        /* renamed from: b, reason: from getter */
        public final ImageView getIcon() {
            return this.icon;
        }

        /* renamed from: c, reason: from getter */
        public final TextView getName() {
            return this.name;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C2507m(List<SessionArtifact> items, Map<String, ? extends ArtifactAvailability> availability, InterfaceC5074l<? super SessionArtifact, Y8.t> onClick, p9.p<? super SessionArtifact, ? super Integer, Y8.t> onExpose) {
        kotlin.jvm.internal.p.i(items, "items");
        kotlin.jvm.internal.p.i(availability, "availability");
        kotlin.jvm.internal.p.i(onClick, "onClick");
        kotlin.jvm.internal.p.i(onExpose, "onExpose");
        this.items = items;
        this.availability = availability;
        this.onClick = onClick;
        this.onExpose = onExpose;
        this.exposed = new LinkedHashSet();
    }

    public static final void e(C2507m c2507m, SessionArtifact sessionArtifact, View view) {
        c2507m.onClick.invoke(sessionArtifact);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(b holder, int position) {
        String name;
        kotlin.jvm.internal.p.i(holder, "holder");
        final SessionArtifact sessionArtifact = this.items.get(position);
        boolean z10 = this.availability.get(sessionArtifact.getFileId()) == ArtifactAvailability.UNAVAILABLE;
        C4148a.k(TAG, "bind position=" + position + " itemCount=" + this.items.size() + " taskId=" + sessionArtifact.getTaskId() + " fileId=" + sessionArtifact.getFileId() + " mime=" + sessionArtifact.getMimeType() + " fileName=" + sessionArtifact.getFileName() + " expired=" + z10 + " holder=" + holder.hashCode(), false, 4, null);
        holder.getIcon().setImageResource(sessionArtifact.getIconRes());
        TextView name2 = holder.getName();
        if (z10) {
            name = sessionArtifact.getName() + holder.itemView.getContext().getString(R$string.chat_artifact_expired_suffix);
        } else {
            name = sessionArtifact.getName();
        }
        name2.setText(name);
        holder.itemView.setAlpha(z10 ? 0.4f : 1.0f);
        holder.getChevron().setVisibility(z10 ? 8 : 0);
        if (z10) {
            holder.itemView.setOnClickListener(null);
            holder.itemView.setClickable(false);
        } else {
            holder.itemView.setClickable(true);
            holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.adapter.l
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    C2507m.e(this.f24954a, sessionArtifact, view);
                }
            });
        }
        if (this.exposed.add(Integer.valueOf(position))) {
            this.onExpose.invoke(sessionArtifact, Integer.valueOf(position));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(ViewGroup parent, int viewType) {
        kotlin.jvm.internal.p.i(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R$layout.item_agent_artifact, parent, false);
        kotlin.jvm.internal.p.f(viewInflate);
        return new b(viewInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.items.size();
    }
}
