package com.bytedance.android.livesdk.interactivity.comment.frequentchat.presenter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.FrequentChatShowMode;
import com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.FrequentChatViewHolder;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0003\u0004\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/frequentchat/presenter/FrequentChatListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "c", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FrequentChatListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.c> f134887a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f134888b;

    public final class a extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f134889a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f134890b;

        public a(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            this.f134889a = r100.findViewById(R.id.add_icon);
            this.f134890b = (TextView) r100.findViewById(R.id.add_text);
        }
    }

    public interface b {
        FrequentChatShowMode L();

        void O(FrequentChatViewHolder r100);

        void R();

        void U(com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.c r100);

        boolean j();

        void k(CharSequence r100, com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.c r101);

        long o();

        void u(com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.c r100);
    }

    public static final class c {
    }

    public static final class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FrequentChatListAdapter f134891a;

        public d(FrequentChatListAdapter r100) {
            this.f134891a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            f2.c(s1.C(R.string.frequent_chat_full_hint, new Object[]{Long.valueOf(this.f134891a.f134888b.o())}), 0);
        }
    }

    public static final class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FrequentChatListAdapter f134892a;

        public e(FrequentChatListAdapter r100) {
            this.f134892a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f134892a.f134888b.R();
        }
    }

    static {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f134887a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        return ((com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.c) ListProtector.get(this.f134887a, r100)).getType();
    }

    public FrequentChatListAdapter(List<com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.c> r100, b r101) {
        Intrinsics.checkNotNullParameter(r100, "mDataList");
        Intrinsics.checkNotNullParameter(r101, "callback");
        this.f134887a = r100;
        this.f134888b = r101;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.c r102 = (com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.c) ListProtector.get(this.f134887a, r101);
        if ((r100 instanceof FrequentChatViewHolder) == false) goto L21;
        FrequentChatViewHolder r103 = (FrequentChatViewHolder) r100;
        r103.f134878a.setText(r102.f134883a);
        FrequentChatShowMode r104 = this.f134888b.L();
        int r105 = com.bytedance.android.livesdk.interactivity.comment.frequentchat.presenter.a.f134905a[r104.ordinal()];
        if (r105 == 1) goto L11;
        if (r105 == 2) goto L10;
        if (r105 != 3) goto L12;
        r103.f134881d.setOnClickListener(null);
        r103.f134880c.setOnClickListener(null);
        r103.f134878a.setOnClickListener(null);
        r103.f134882e.setOnLongClickListener(new com.bytedance.android.livesdk.interactivity.comment.frequentchat.presenter.e(this, r103));
    L12:
        FrequentChatShowMode r106 = this.f134888b.L();
        int r107 = com.bytedance.android.livesdk.interactivity.comment.frequentchat.presenter.a.f134906b[r106.ordinal()];
        if (r107 == 1) goto L19;
        if (r107 == 2) goto L18;
        if (r107 != 3) goto L32;
        UtilityKotlinExtentionsKt.t(r103.f134881d);
        UtilityKotlinExtentionsKt.t(r103.f134880c);
        UtilityKotlinExtentionsKt.w(r103.f134882e);
        return;
    L32:
        return;
    L18:
        UtilityKotlinExtentionsKt.t(r103.f134881d);
        UtilityKotlinExtentionsKt.t(r103.f134880c);
        UtilityKotlinExtentionsKt.t(r103.f134882e);
        return;
    L19:
        UtilityKotlinExtentionsKt.w(r103.f134881d);
        UtilityKotlinExtentionsKt.w(r103.f134880c);
        UtilityKotlinExtentionsKt.t(r103.f134882e);
        return;
    L10:
        r103.f134878a.setOnClickListener(null);
        r103.f134882e.setOnLongClickListener(null);
        r103.f134880c.setOnClickListener(new com.bytedance.android.livesdk.interactivity.comment.frequentchat.presenter.c(this, r102));
        r103.f134881d.setOnClickListener(new com.bytedance.android.livesdk.interactivity.comment.frequentchat.presenter.d(this, r102));
        goto L12
    L11:
        r103.f134881d.setOnClickListener(null);
        r103.f134880c.setOnClickListener(null);
        r103.f134882e.setOnLongClickListener(null);
        r103.f134878a.setOnClickListener(new com.bytedance.android.livesdk.interactivity.comment.frequentchat.presenter.b(this, r102));
        goto L12
    L21:
        if ((r100 instanceof a) == true) goto L23;
        return;
    L23:
        if (this.f134888b.j() == false) goto L25;
        a r108 = (a) r100;
        r108.f134889a.setBackground(s1.m(R.drawable.ttlive_frequent_chat_add_icon_gray));
        r108.f134890b.setTextColor(s1.h(R.color.ttlive_color_57_161823));
        r100.itemView.setOnClickListener(new d(this));
        return;
    L25:
        a r109 = (a) r100;
        r109.f134889a.setBackground(s1.m(R.drawable.ttlive_add_frequent_comment_icon));
        r109.f134890b.setTextColor(s1.h(R.color.ttlive_color_BF_161823));
        r100.itemView.setOnClickListener(new e(this));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        if (r101 == 1) goto L13;
        if (r101 == 2) goto L15;
        if (v.a() == true) goto L10;
        ALogger.e("FrequentChatListAdapter", "viewType{" + r101 + "}not supported");
        return new FrequentChatViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.ttlive_view_frequent_chat_item, r100, false));
    L10:
        throw new NoSuchElementException("FrequentChatListAdapter, viewType{" + r101 + "}not supported");
    L15:
        return new a(LayoutInflater.from(r100.getContext()).inflate(R.layout.ttlive_view_add_frequent_chat, r100, false));
    L13:
        return new FrequentChatViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.ttlive_view_frequent_chat_item, r100, false));
    }
}
