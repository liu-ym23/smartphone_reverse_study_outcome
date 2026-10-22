package com.bytedance.android.livesdk.interactivity.chatchannel.messagelist.viewholder;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.u;
import com.bytedance.android.livesdk.widget.roundcorner.RoundCornerImageView;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import i62.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/chatchannel/messagelist/viewholder/ChatChannelGiftViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ChatChannelGiftViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RoundCornerImageView f134333a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f134334b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public e f134335c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public e f134336d;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChatChannelGiftViewHolder f134337a;

        public b(ChatChannelGiftViewHolder r100) {
            this.f134337a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            if (wb2.e.a(r100) == true) goto L8;
            e r101 = this.f134337a.f134335c;
            if (r101 == null) goto L9;
            r101.onClick(r100);
            return;
        L9:
            return;
        }
    }

    static {
    }

    public ChatChannelGiftViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        LinearLayout r101 = (LinearLayout) r100.findViewById(R.id.container);
        RoundCornerImageView r102 = (RoundCornerImageView) r100.findViewById(R.id.avatar);
        this.f134333a = r102;
        TextView r103 = (TextView) r100.findViewById(R.id.content);
        this.f134334b = r103;
        b r104 = new b(this);
        r103.setMovementMethod(u.a());
        r103.setOnClickListener(r104);
        r102.setOnClickListener(r104);
    }
}
