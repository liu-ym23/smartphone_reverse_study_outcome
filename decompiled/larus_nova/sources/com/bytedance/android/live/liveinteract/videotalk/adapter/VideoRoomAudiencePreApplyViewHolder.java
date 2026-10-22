package com.bytedance.android.live.liveinteract.videotalk.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.liveinteract.plantform.model.c1;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/liveinteract/videotalk/adapter/VideoRoomAudiencePreApplyViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class VideoRoomAudiencePreApplyViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HSImageView f79051a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f79052b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f79053c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinearLayout f79054d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f79055e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ImageView f79056f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f79057g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final IRoom f79058h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f79059i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final a f79060j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Map<com.bytedance.android.live.liveinteract.linkpanel.util.c, View> f79061k;

    public interface a {
        void a(c1 r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public VideoRoomAudiencePreApplyViewHolder(View r100, a r101, Map<com.bytedance.android.live.liveinteract.linkpanel.util.c, ? extends View> r102) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        Intrinsics.checkNotNullParameter(r102, "badgeTypeMap");
        super(r100);
        this.f79060j = r101;
        this.f79061k = r102;
        this.f79051a = (HSImageView) r100.findViewById(R.id.iv_head);
        this.f79052b = (TextView) r100.findViewById(R.id.tv_name);
        this.f79053c = (TextView) r100.findViewById(R.id.tv_time);
        this.f79054d = (LinearLayout) r100.findViewById(R.id.name_container);
        this.f79055e = (TextView) r100.findViewById(R.id.permit_btn);
        this.f79056f = (ImageView) r100.findViewById(R.id.iv_gender);
        Boolean r103 = m.i().isAnchor();
        if (r103 == null) goto L5;
        boolean r104 = r103.booleanValue();
    L6:
        this.f79057g = r104;
        com.bytedance.live.datacontext.m<IRoom> r105 = m.i().getRoom();
        if (r105 == null) goto L9;
        IRoom r106 = r105.getValue();
    L10:
        this.f79058h = r106;
        this.f79059i = "";
        return;
    L9:
        r106 = null;
        goto L10
    L5:
        r104 = false;
        goto L6
    }
}
