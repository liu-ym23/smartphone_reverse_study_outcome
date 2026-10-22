package com.stepos.ailauncher.task.space.credential;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.autonavi.aps.amapapi.config.Const;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import com.stepos.ailauncher.task.R$color;
import com.stepos.ailauncher.task.R$drawable;
import com.stepos.ailauncher.task.R$string;
import com.stepos.ailauncher.task.space.credential.C3590b;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010!\n\u0002\b\u0006\u0018\u0000 \u001e2\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u001f B/\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\f\u001a\u00020\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\n¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0012\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J#\u0010\u0016\u001a\u00020\u00052\n\u0010\u0014\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R \u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u001aR \u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u001aR\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00040\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006!"}, d2 = {"Lcom/stepos/ailauncher/task/space/credential/b;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/stepos/ailauncher/task/space/credential/b$b;", "Lkotlin/Function1;", "Lcom/stepos/ailauncher/task/space/credential/f;", "LY8/t;", "onItemClick", "onRevokeClick", "<init>", "(Lp9/l;Lp9/l;)V", "", "list", "submitList", "(Ljava/util/List;)V", "Landroid/view/ViewGroup;", "parent", "", "viewType", "f", "(Landroid/view/ViewGroup;I)Lcom/stepos/ailauncher/task/space/credential/b$b;", "holder", "position", "e", "(Lcom/stepos/ailauncher/task/space/credential/b$b;I)V", "getItemCount", "()I", "Lp9/l;", "", DidiCardProvider.KEY_ITEMS, "Ljava/util/List;", "Companion", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.task.space.credential.b, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3590b extends RecyclerView.Adapter<C0336b> {
    private static final float FALLBACK_ICON_PADDING_DP = 6.0f;
    private final List<CredentialItem> items;
    private final InterfaceC5074l<CredentialItem, Y8.t> onItemClick;
    private final InterfaceC5074l<CredentialItem, Y8.t> onRevokeClick;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\nJ\u0019\u0010\u000e\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0011\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/stepos/ailauncher/task/space/credential/b$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lr6/l;", "binding", "<init>", "(Lcom/stepos/ailauncher/task/space/credential/b;Lr6/l;)V", "Lcom/stepos/ailauncher/task/space/credential/f;", "item", "LY8/t;", "c", "(Lcom/stepos/ailauncher/task/space/credential/f;)V", "f", "", "iconUrl", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;)V", "isoDate", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/lang/String;)Ljava/lang/String;", "Lr6/l;", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.task.space.credential.b$b, reason: collision with other inner class name */
    public final class C0336b extends RecyclerView.ViewHolder {
        private final r6.l binding;
        final /* synthetic */ C3590b this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0336b(C3590b c3590b, r6.l binding) {
            super(binding.b());
            kotlin.jvm.internal.p.i(binding, "binding");
            this.this$0 = c3590b;
            this.binding = binding;
        }

        public static final void d(C3590b c3590b, CredentialItem credentialItem, View view) {
            c3590b.onItemClick.invoke(credentialItem);
        }

        public static final void e(C3590b c3590b, CredentialItem credentialItem, View view) {
            c3590b.onRevokeClick.invoke(credentialItem);
        }

        public final void c(final CredentialItem item) {
            String string;
            kotlin.jvm.internal.p.i(item, "item");
            this.binding.tvAppName.setText(item.getVendorName());
            f(item);
            String strH = h(item.getAuthorizedAt());
            TextView tvAuthTime = this.binding.tvAuthTime;
            kotlin.jvm.internal.p.h(tvAuthTime, "tvAuthTime");
            tvAuthTime.setVisibility(strH.length() > 0 ? 0 : 8);
            TextView textView = this.binding.tvAuthTime;
            if (strH.length() == 0) {
                string = "";
            } else {
                string = this.binding.b().getContext().getString(R$string.third_party_auth_authorized_at, strH);
                kotlin.jvm.internal.p.f(string);
            }
            textView.setText(string);
            g(item.getIconUrl());
            ConstraintLayout constraintLayoutB = this.binding.b();
            final C3590b c3590b = this.this$0;
            constraintLayoutB.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.space.credential.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    C3590b.C0336b.d(c3590b, item, view);
                }
            });
            TextView textView2 = this.binding.btnRevoke;
            final C3590b c3590b2 = this.this$0;
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.space.credential.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    C3590b.C0336b.e(c3590b2, item, view);
                }
            });
        }

        public final void f(CredentialItem item) {
            TextView tvAuthMethod = this.binding.tvAuthMethod;
            kotlin.jvm.internal.p.h(tvAuthMethod, "tvAuthMethod");
            String authMethodLabel = item.getAuthMethodLabel();
            tvAuthMethod.setVisibility(authMethodLabel == null || La.H.x0(authMethodLabel) ? 8 : 0);
            if (authMethodLabel == null || La.H.x0(authMethodLabel)) {
                return;
            }
            tvAuthMethod.setText(authMethodLabel);
            boolean zD = kotlin.jvm.internal.p.d(Q.d(item), "oauth");
            tvAuthMethod.setBackgroundResource(zD ? R$drawable.bg_auth_method_badge_oauth : R$drawable.bg_auth_method_badge_appkey);
            tvAuthMethod.setTextColor(tvAuthMethod.getContext().getColor(zD ? R$color.third_party_auth_badge_oauth_text : R$color.third_party_auth_badge_appkey_text));
        }

        public final void g(String iconUrl) {
            ImageView ivAppIcon = this.binding.ivAppIcon;
            kotlin.jvm.internal.p.h(ivAppIcon, "ivAppIcon");
            if (iconUrl == null || iconUrl.length() == 0) {
                Glide.with(ivAppIcon).clear(ivAppIcon);
                int i10 = (int) (ivAppIcon.getResources().getDisplayMetrics().density * 6.0f);
                ivAppIcon.setPadding(i10, i10, i10, i10);
                ivAppIcon.setImageResource(R$drawable.ic_repair_third_party_auth);
                return;
            }
            ivAppIcon.setPadding(0, 0, 0, 0);
            RequestBuilder<Drawable> requestBuilderLoad = Glide.with(ivAppIcon).load(iconUrl);
            int i11 = R$drawable.ic_repair_third_party_auth;
            kotlin.jvm.internal.p.f(requestBuilderLoad.placeholder(i11).error(i11).circleCrop().into(ivAppIcon));
        }

        public final String h(String isoDate) {
            if (isoDate == null || isoDate.length() == 0) {
                return "";
            }
            try {
                String str = ZonedDateTime.parse(isoDate).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                kotlin.jvm.internal.p.f(str);
                return str;
            } catch (Exception unused) {
                return La.K.R1(isoDate, 10);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C3590b(InterfaceC5074l<? super CredentialItem, Y8.t> onItemClick, InterfaceC5074l<? super CredentialItem, Y8.t> onRevokeClick) {
        kotlin.jvm.internal.p.i(onItemClick, "onItemClick");
        kotlin.jvm.internal.p.i(onRevokeClick, "onRevokeClick");
        this.onItemClick = onItemClick;
        this.onRevokeClick = onRevokeClick;
        this.items = new ArrayList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(C0336b holder, int position) {
        kotlin.jvm.internal.p.i(holder, "holder");
        holder.c(this.items.get(position));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public C0336b onCreateViewHolder(ViewGroup parent, int viewType) {
        kotlin.jvm.internal.p.i(parent, "parent");
        r6.l lVarC = r6.l.c(LayoutInflater.from(parent.getContext()), parent, false);
        kotlin.jvm.internal.p.h(lVarC, "inflate(...)");
        return new C0336b(this, lVarC);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.items.size();
    }

    public final void submitList(List<CredentialItem> list) {
        kotlin.jvm.internal.p.i(list, "list");
        this.items.clear();
        this.items.addAll(list);
        notifyDataSetChanged();
    }
}
