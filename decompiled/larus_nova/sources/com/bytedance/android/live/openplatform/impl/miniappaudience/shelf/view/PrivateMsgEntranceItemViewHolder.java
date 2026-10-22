package com.bytedance.android.live.openplatform.impl.miniappaudience.shelf.view;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.widget.HSImageView;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappaudience/shelf/view/PrivateMsgEntranceItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PrivateMsgEntranceItemViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HSImageView f84985a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HSImageView f84986b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f84987c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f84988d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Button f84989e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final a f84990f;

    public interface a {
        void a(lo0.a r100);

        void b(lo0.a r100);
    }

    public PrivateMsgEntranceItemViewHolder(View r100, a r101) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        Intrinsics.checkNotNullParameter(r101, "callback");
        super(r100);
        this.f84990f = r101;
        this.f84985a = (HSImageView) r100.findViewById(R.id.private_msg_avatar);
        this.f84986b = (HSImageView) r100.findViewById(R.id.private_msg_identity);
        this.f84987c = (TextView) r100.findViewById(R.id.private_msg_title);
        this.f84988d = (TextView) r100.findViewById(R.id.private_msg_desc);
        this.f84989e = (Button) r100.findViewById(R.id.private_msg_btn);
    }
}
