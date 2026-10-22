package com.bytedance.android.livesdk.interactivity.chatchannel.messagelist.viewholder;

import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.u;
import com.bytedance.android.livesdk.r3;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import wb2.d;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/chatchannel/messagelist/viewholder/ChatChannelChatViewHolder;", "Lcom/bytedance/android/livesdk/interactivity/chatchannel/messagelist/viewholder/PadAdjustViewHolder;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ChatChannelChatViewHolder extends PadAdjustViewHolder {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f134327e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f134328f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HSImageView f134329a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f134330b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f134331c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public d.a f134332d;

    public static final class a {
    }

    static {
        f134327e = s1.f(36.0f);
        f134328f = s1.f(18.0f);
    }

    public ChatChannelChatViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.f134329a = (HSImageView) r100.findViewById(R.id.avatar);
        TextView r101 = (TextView) r100.findViewById(R.id.nick_name);
        this.f134330b = r101;
        TextView r102 = (TextView) r100.findViewById(R.id.text_content);
        this.f134331c = r102;
        if (r102 == null) goto L5;
        r102.setMovementMethod(u.a());
    L5:
        Boolean r103 = o62.d.f522172a;
        if (o62.d.f522172a.booleanValue() == false) goto L10;
        if (r101 == null) goto L11;
        r101.setShadowLayer(o62.d.f522174c, 0.0f, 0.0f, o62.d.f522173b);
        return;
    L11:
        return;
    }

    public final void T3(ImageModel r100, String r101) {
        ImageLoader.bindImage(this.f134329a, r100);
        HSImageView r102 = this.f134329a;
        if (r102 == null) goto L6;
        r102.setImportantForAccessibility(1);
        r102.setFocusable(true);
        r3.c(r102, r101 + "头像", true);
        return;
    }
}
