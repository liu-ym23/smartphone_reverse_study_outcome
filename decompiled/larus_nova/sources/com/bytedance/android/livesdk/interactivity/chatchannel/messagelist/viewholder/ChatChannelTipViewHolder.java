package com.bytedance.android.livesdk.interactivity.chatchannel.messagelist.viewholder;

import ak6.g;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.u;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import wb2.d;
import wb2.e;
import wb2.h;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/chatchannel/messagelist/viewholder/ChatChannelTipViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ChatChannelTipViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f134340d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f134341a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View.OnClickListener f134342b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d.a f134343c;

    public static final class a {
        @JvmStatic
        public static ChatChannelTipViewHolder a(LayoutInflater r100, ViewGroup r101) {
            Intrinsics.checkNotNullParameter(r100, "inflater");
            Intrinsics.checkNotNullParameter(r101, "parent");
            return new ChatChannelTipViewHolder(r100.inflate(R.layout.ttlive_item_chat_channel_tip_message, r101, false));
        }
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChatChannelTipViewHolder f134344a;

        public b(ChatChannelTipViewHolder r100) {
            this.f134344a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            if (e.a(r100) == true) goto L8;
            View.OnClickListener r101 = this.f134344a.f134342b;
            if (r101 == null) goto L9;
            r101.onClick(r100);
            return;
        L9:
            return;
        }
    }

    public static final class c implements qb2.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChatChannelTipViewHolder f134345a;

        public c(ChatChannelTipViewHolder r100) {
            this.f134345a = r100;
        }

        @Override // qb2.e
        public final void a(g r100) {
            Intrinsics.checkNotNullParameter(r100, "rendResult");
            Intrinsics.checkNotNullParameter(r100, "rendResult");
        }

        @Override // qb2.e
        public final void b(g r100) {
            Intrinsics.checkNotNullParameter(r100, "rendResult");
            TextView r101 = this.f134345a.f134341a;
            if (r101 == null) goto L10;
            SpannableString r102 = r100.f4074a;
            int r103 = 0;
            Object[] r104 = r102.getSpans(0, r102.length(), h.class);
            int r105 = r104.length;
        L5:
            if (r103 >= r105) goto L7;
            h r106 = (h) r104[r103];
            r106.f558922a = this.f134345a.f134343c;
            r103 = r103 + 1;
            goto L5
        L7:
            Unit r107 = Unit.INSTANCE;
            r101.setText(r102);
            return;
        }
    }

    static {
    }

    public ChatChannelTipViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        TextView r101 = (TextView) r100.findViewById(R.id.content);
        this.f134341a = r101;
        b r102 = new b(this);
        if (r101 == null) goto L5;
        r101.setMovementMethod(u.a());
    L5:
        if (r101 == null) goto L8;
        r101.setOnClickListener(r102);
    L8:
        if (o62.d.f522172a.booleanValue() == false) goto L12;
        if (r101 == null) goto L13;
        r101.setShadowLayer(o62.d.f522174c, 0.0f, 0.0f, o62.d.f522173b);
        return;
    L13:
        return;
    }

    public final void T3(tb2.d r100) {
        Intrinsics.checkNotNullParameter(r100, "renderText");
        qb2.c.b(r100, new c(this), null, 28);
    }
}
