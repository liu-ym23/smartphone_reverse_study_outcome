package com.bytedance.android.livesdk.interactivity.chatchannel.messagelist.viewholder;

import android.view.View;
import android.widget.TextView;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/chatchannel/messagelist/viewholder/ChatChannelSystemViewHolder;", "Lcom/bytedance/android/livesdk/interactivity/chatchannel/messagelist/viewholder/PadAdjustViewHolder;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ChatChannelSystemViewHolder extends PadAdjustViewHolder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f134338b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f134339a;

    public static final class a {
        public a() {
        }
    }

    static {
        f134338b = new a();
    }

    public ChatChannelSystemViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.f134339a = (TextView) r100.findViewById(R.id.content);
    }
}
