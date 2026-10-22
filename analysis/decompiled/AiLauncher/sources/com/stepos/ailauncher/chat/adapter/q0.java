package com.stepos.ailauncher.chat.adapter;

import Z8.C1173v;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.R$color;
import com.stepos.ailauncher.chat.R$drawable;
import com.stepos.ailauncher.chat.R$id;
import com.stepos.ailauncher.chat.R$layout;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u000b\u0018\u0000 (2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002)*B+\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\t\u0010\nJ%\u0010\u000f\u001a\u00020\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ-\u0010\"\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u00162\f\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u0003H\u0016¢\u0006\u0004\b\"\u0010#R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010$R \u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010%R\u0018\u0010&\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'¨\u0006+"}, d2 = {"Lcom/stepos/ailauncher/chat/adapter/q0;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/stepos/ailauncher/chat/adapter/q0$b;", "", "Lcom/stepos/ailauncher/chat/adapter/r0;", DidiCardProvider.KEY_ITEMS, "Lkotlin/Function1;", "LY8/t;", "onItemClick", "<init>", "(Ljava/util/List;Lp9/l;)V", "", "newItems", "", "selectedId", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/util/List;Ljava/lang/String;)V", "newSelectedId", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/lang/String;)V", "Landroid/view/ViewGroup;", "parent", "", "viewType", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Landroid/view/ViewGroup;I)Lcom/stepos/ailauncher/chat/adapter/q0$b;", "getItemCount", "()I", "holder", "position", Const.INTENT_KEY_UMID, "(Lcom/stepos/ailauncher/chat/adapter/q0$b;I)V", "", "payloads", "e", "(Lcom/stepos/ailauncher/chat/adapter/q0$b;ILjava/util/List;)V", "Ljava/util/List;", "Lp9/l;", "selectedVoiceId", "Ljava/lang/String;", "Companion", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class q0 extends RecyclerView.Adapter<b> {
    private static final a Companion = new a(null);

    @Deprecated
    public static final String PAYLOAD_SELECTION = "voice_selection";
    private final List<VoiceChoiceItem> items;
    private final InterfaceC5074l<VoiceChoiceItem, Y8.t> onItemClick;
    private String selectedVoiceId;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/ailauncher/chat/adapter/q0$a;", "", "<init>", "()V", "", "PAYLOAD_SELECTION", "Ljava/lang/String;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.i iVar) {
            this();
        }

        public a() {
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\r\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0011¨\u0006\u0017"}, d2 = {"Lcom/stepos/ailauncher/chat/adapter/q0$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "Lcom/stepos/ailauncher/chat/adapter/r0;", "item", "", "selected", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/ailauncher/chat/adapter/r0;Z)V", Const.INTENT_KEY_PKGNAME, "(Z)V", "Landroid/widget/ImageView;", "ivAvatar", "Landroid/widget/ImageView;", "Landroid/widget/TextView;", "tvName", "Landroid/widget/TextView;", "tvDesc", "ivSelected", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b extends RecyclerView.ViewHolder {
        private final ImageView ivAvatar;
        private final ImageView ivSelected;
        private final TextView tvDesc;
        private final TextView tvName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(View itemView) {
            super(itemView);
            kotlin.jvm.internal.p.i(itemView, "itemView");
            View viewFindViewById = itemView.findViewById(R$id.ivVoiceAvatar);
            kotlin.jvm.internal.p.h(viewFindViewById, "findViewById(...)");
            this.ivAvatar = (ImageView) viewFindViewById;
            View viewFindViewById2 = itemView.findViewById(R$id.tvVoiceName);
            kotlin.jvm.internal.p.h(viewFindViewById2, "findViewById(...)");
            this.tvName = (TextView) viewFindViewById2;
            View viewFindViewById3 = itemView.findViewById(R$id.tvVoiceDescription);
            kotlin.jvm.internal.p.h(viewFindViewById3, "findViewById(...)");
            this.tvDesc = (TextView) viewFindViewById3;
            View viewFindViewById4 = itemView.findViewById(R$id.ivVoiceSelected);
            kotlin.jvm.internal.p.h(viewFindViewById4, "findViewById(...)");
            this.ivSelected = (ImageView) viewFindViewById4;
        }

        public final void a(VoiceChoiceItem item, boolean selected) {
            kotlin.jvm.internal.p.i(item, "item");
            this.tvName.setText(item.getName());
            this.tvDesc.setText(item.getDescription());
            TextView textView = this.tvDesc;
            String description = item.getDescription();
            textView.setVisibility((description == null || La.H.x0(description)) ? 8 : 0);
            b(selected);
            String avatarUrl = item.getAvatarUrl();
            if (avatarUrl == null || La.H.x0(avatarUrl)) {
                com.stepos.ailauncher.common.imageloader.g.INSTANCE.l(this.ivAvatar);
                this.ivAvatar.setImageDrawable(null);
                return;
            }
            com.stepos.ailauncher.common.imageloader.g gVar = com.stepos.ailauncher.common.imageloader.g.INSTANCE;
            ImageView imageView = this.ivAvatar;
            String avatarUrl2 = item.getAvatarUrl();
            int i10 = R$drawable.bg_voice_avatar_placeholder;
            com.stepos.ailauncher.common.imageloader.g.t(gVar, imageView, avatarUrl2, i10, i10, 0, false, 0, 0, null, 496, null);
        }

        public final void b(boolean selected) {
            this.tvName.setTextColor(androidx.core.content.a.c(this.itemView.getContext(), selected ? R$color.chat_color_voice_selected : R$color.chat_color_setting_title));
            this.ivSelected.setVisibility(selected ? 0 : 4);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public q0(List<VoiceChoiceItem> items, InterfaceC5074l<? super VoiceChoiceItem, Y8.t> onItemClick) {
        kotlin.jvm.internal.p.i(items, "items");
        kotlin.jvm.internal.p.i(onItemClick, "onItemClick");
        this.items = items;
        this.onItemClick = onItemClick;
    }

    public static final void f(q0 q0Var, VoiceChoiceItem voiceChoiceItem, View view) {
        q0Var.onItemClick.invoke(voiceChoiceItem);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(b holder, int position) {
        kotlin.jvm.internal.p.i(holder, "holder");
        final VoiceChoiceItem voiceChoiceItem = this.items.get(position);
        holder.a(voiceChoiceItem, kotlin.jvm.internal.p.d(voiceChoiceItem.getVoiceId(), this.selectedVoiceId));
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.adapter.p0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                q0.f(this.f24964a, voiceChoiceItem, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(b holder, int position, List<Object> payloads) {
        kotlin.jvm.internal.p.i(holder, "holder");
        kotlin.jvm.internal.p.i(payloads, "payloads");
        if (payloads.contains(PAYLOAD_SELECTION)) {
            holder.b(kotlin.jvm.internal.p.d(this.items.get(position).getVoiceId(), this.selectedVoiceId));
        } else {
            super.onBindViewHolder(holder, position, payloads);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(ViewGroup parent, int viewType) {
        kotlin.jvm.internal.p.i(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R$layout.item_voice_choice, parent, false);
        kotlin.jvm.internal.p.f(viewInflate);
        return new b(viewInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.items.size();
    }

    public final void h(List<VoiceChoiceItem> newItems, String selectedId) {
        kotlin.jvm.internal.p.i(newItems, "newItems");
        this.items.clear();
        this.items.addAll(newItems);
        this.selectedVoiceId = selectedId;
        notifyDataSetChanged();
    }

    public final void i(String newSelectedId) {
        String str = this.selectedVoiceId;
        if (kotlin.jvm.internal.p.d(str, newSelectedId)) {
            return;
        }
        this.selectedVoiceId = newSelectedId;
        int i10 = 0;
        for (Object obj : this.items) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                C1173v.w();
            }
            VoiceChoiceItem voiceChoiceItem = (VoiceChoiceItem) obj;
            if (kotlin.jvm.internal.p.d(voiceChoiceItem.getVoiceId(), str) || kotlin.jvm.internal.p.d(voiceChoiceItem.getVoiceId(), newSelectedId)) {
                notifyItemChanged(i10, PAYLOAD_SELECTION);
            }
            i10 = i11;
        }
    }

    public /* synthetic */ q0(List list, InterfaceC5074l interfaceC5074l, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? new ArrayList() : list, interfaceC5074l);
    }
}
