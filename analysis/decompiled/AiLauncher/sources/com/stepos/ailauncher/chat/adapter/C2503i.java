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
import com.stepos.ailauncher.chat.R$drawable;
import com.stepos.ailauncher.chat.adapter.C2503i;
import com.stepos.ailauncher.chat.view.C2765a9;
import com.stepos.ailauncher.chat.view.T9;
import com.stepos.ailauncher.foundation.appstore.api.AppVersionItem;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import java.util.ArrayList;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\"B3\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\f\u001a\u00020\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\n¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0012\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J#\u0010\u001b\u001a\u00020\u00052\n\u0010\u001a\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u001b\u0010\u001cR \u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u001dR\"\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u001dR$\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u00040\u001ej\b\u0012\u0004\u0012\u00020\u0004`\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!¨\u0006#"}, d2 = {"Lcom/stepos/ailauncher/chat/adapter/i;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/stepos/ailauncher/chat/adapter/i$a;", "Lkotlin/Function1;", "Lcom/stepos/ailauncher/foundation/appstore/api/AppVersionItem;", "LY8/t;", "onClick", "onUninstall", "<init>", "(Lp9/l;Lp9/l;)V", "", "list", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/util/List;)V", "Landroid/view/ViewGroup;", "parent", "", "viewType", "f", "(Landroid/view/ViewGroup;I)Lcom/stepos/ailauncher/chat/adapter/i$a;", "getItemCount", "()I", "position", "", "getItemId", "(I)J", "holder", "e", "(Lcom/stepos/ailauncher/chat/adapter/i$a;I)V", "Lp9/l;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", DidiCardProvider.KEY_ITEMS, "Ljava/util/ArrayList;", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.chat.adapter.i, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2503i extends RecyclerView.Adapter<a> {
    private final ArrayList<AppVersionItem> items;
    private final InterfaceC5074l<AppVersionItem, Y8.t> onClick;
    private final InterfaceC5074l<AppVersionItem, Y8.t> onUninstall;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0012¨\u0006\u0018"}, d2 = {"Lcom/stepos/ailauncher/chat/adapter/i$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Ll5/l;", "binding", "<init>", "(Lcom/stepos/ailauncher/chat/adapter/i;Ll5/l;)V", "", AMapLocationStaticsEntity.FIRST_LOCATE, "last", "LY8/t;", Const.INTENT_KEY_UMID, "(ZZ)V", "Lcom/stepos/ailauncher/foundation/appstore/api/AppVersionItem;", "item", "e", "(Lcom/stepos/ailauncher/foundation/appstore/api/AppVersionItem;)V", "Landroid/widget/ImageView;", "icon", "Landroid/widget/ImageView;", "Landroid/widget/TextView;", "name", "Landroid/widget/TextView;", Const.JSON_KEY_DESC, "more", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.adapter.i$a */
    public final class a extends RecyclerView.ViewHolder {
        private final TextView desc;
        private final ImageView icon;
        private final ImageView more;
        private final TextView name;
        final /* synthetic */ C2503i this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(C2503i c2503i, l5.l binding) {
            super(binding.b());
            kotlin.jvm.internal.p.i(binding, "binding");
            this.this$0 = c2503i;
            ImageView ivAiAppIcon = binding.ivAiAppIcon;
            kotlin.jvm.internal.p.h(ivAiAppIcon, "ivAiAppIcon");
            this.icon = ivAiAppIcon;
            TextView tvAiAppName = binding.tvAiAppName;
            kotlin.jvm.internal.p.h(tvAiAppName, "tvAiAppName");
            this.name = tvAiAppName;
            TextView tvAiAppDesc = binding.tvAiAppDesc;
            kotlin.jvm.internal.p.h(tvAiAppDesc, "tvAiAppDesc");
            this.desc = tvAiAppDesc;
            ImageView ivAiAppMore = binding.ivAiAppMore;
            kotlin.jvm.internal.p.h(ivAiAppMore, "ivAiAppMore");
            this.more = ivAiAppMore;
        }

        public static final void f(C2503i c2503i, AppVersionItem appVersionItem, View view) {
            c2503i.onClick.invoke(appVersionItem);
        }

        public static final void g(a aVar, final C2503i c2503i, final AppVersionItem appVersionItem, View view) {
            T9.d(aVar.more, 0.0f, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.adapter.h
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return C2503i.a.h(c2503i, appVersionItem);
                }
            }, 2, null);
        }

        public static final Y8.t h(C2503i c2503i, AppVersionItem appVersionItem) {
            c2503i.onUninstall.invoke(appVersionItem);
            return Y8.t.f7040a;
        }

        public final void d(boolean first, boolean last) {
            float f10 = this.itemView.getResources().getDisplayMetrics().density;
            int i10 = (int) (16 * f10);
            this.itemView.setPaddingRelative(i10, (int) ((first ? 16 : 12) * f10), i10, (int) ((last ? 16 : 12) * f10));
        }

        public final void e(final AppVersionItem item) {
            kotlin.jvm.internal.p.i(item, "item");
            C2765a9.b(this.icon, item.getIconUrl(), R$drawable.ic_amoo_market_agent, false);
            this.name.setText(item.getName());
            this.desc.setText(item.getDesc());
            TextView textView = this.desc;
            String desc = item.getDesc();
            textView.setVisibility((desc == null || La.H.x0(desc)) ? 8 : 0);
            View view = this.itemView;
            final C2503i c2503i = this.this$0;
            view.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.adapter.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    C2503i.a.f(c2503i, item, view2);
                }
            });
            if (this.this$0.onUninstall == null) {
                this.more.setVisibility(8);
                this.more.setOnClickListener(null);
            } else {
                this.more.setVisibility(0);
                ImageView imageView = this.more;
                final C2503i c2503i2 = this.this$0;
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.adapter.g
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        C2503i.a.g(this.f24941a, c2503i2, item, view2);
                    }
                });
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C2503i(InterfaceC5074l<? super AppVersionItem, Y8.t> onClick, InterfaceC5074l<? super AppVersionItem, Y8.t> interfaceC5074l) {
        kotlin.jvm.internal.p.i(onClick, "onClick");
        this.onClick = onClick;
        this.onUninstall = interfaceC5074l;
        this.items = new ArrayList<>();
        setHasStableIds(true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a holder, int position) {
        kotlin.jvm.internal.p.i(holder, "holder");
        holder.d(position == 0, position == C1173v.o(this.items));
        AppVersionItem appVersionItem = this.items.get(position);
        kotlin.jvm.internal.p.h(appVersionItem, "get(...)");
        holder.e(appVersionItem);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup parent, int viewType) {
        kotlin.jvm.internal.p.i(parent, "parent");
        l5.l lVarC = l5.l.c(LayoutInflater.from(parent.getContext()), parent, false);
        kotlin.jvm.internal.p.h(lVarC, "inflate(...)");
        return new a(this, lVarC);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g(java.util.List<com.stepos.ailauncher.foundation.appstore.api.AppVersionItem> r7) {
        /*
            r6 = this;
            java.lang.String r0 = "list"
            kotlin.jvm.internal.p.i(r7, r0)
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Iterator r7 = r7.iterator()
        L15:
            boolean r2 = r7.hasNext()
            if (r2 == 0) goto L44
            java.lang.Object r2 = r7.next()
            r3 = r2
            com.stepos.ailauncher.foundation.appstore.api.AppVersionItem r3 = (com.stepos.ailauncher.foundation.appstore.api.AppVersionItem) r3
            java.lang.String r4 = r3.getPackageName()
            if (r4 == 0) goto L32
            boolean r5 = La.H.x0(r4)
            if (r5 != 0) goto L2f
            goto L30
        L2f:
            r4 = 0
        L30:
            if (r4 != 0) goto L3a
        L32:
            long r3 = r3.getId()
            java.lang.String r4 = java.lang.String.valueOf(r3)
        L3a:
            boolean r3 = r0.add(r4)
            if (r3 == 0) goto L15
            r1.add(r2)
            goto L15
        L44:
            java.util.ArrayList<com.stepos.ailauncher.foundation.appstore.api.AppVersionItem> r7 = r6.items
            boolean r7 = kotlin.jvm.internal.p.d(r7, r1)
            if (r7 == 0) goto L4d
            return
        L4d:
            java.util.ArrayList<com.stepos.ailauncher.foundation.appstore.api.AppVersionItem> r7 = r6.items
            r7.clear()
            java.util.ArrayList<com.stepos.ailauncher.foundation.appstore.api.AppVersionItem> r7 = r6.items
            r7.addAll(r1)
            r6.notifyDataSetChanged()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.adapter.C2503i.g(java.util.List):void");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.items.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        return this.items.get(position).getId();
    }

    public /* synthetic */ C2503i(InterfaceC5074l interfaceC5074l, InterfaceC5074l interfaceC5074l2, int i10, kotlin.jvm.internal.i iVar) {
        this(interfaceC5074l, (i10 & 2) != 0 ? null : interfaceC5074l2);
    }
}
