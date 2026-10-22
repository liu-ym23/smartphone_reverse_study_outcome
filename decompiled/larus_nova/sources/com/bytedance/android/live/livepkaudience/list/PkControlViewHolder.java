package com.bytedance.android.live.livepkaudience.list;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\bR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/livepkaudience/list/PkControlViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "c", "I", "getType", "()I", "type", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livepkaudience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PkControlViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView f82024a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f82025b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f82026c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final xk0.c f82027d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<dl0.c, View> f82028e;

    public static final class a {
    }

    static {
    }

    public final int getType() {
        return this.f82026c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PkControlViewHolder(View r100, int r101, xk0.c r102, Map<dl0.c, ? extends View> r103) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r103, "badgeTypeMap");
        super(r100);
        this.f82026c = r101;
        this.f82027d = r102;
        this.f82028e = r103;
        this.f82024a = (ImageView) this.itemView.findViewById(R.id.iv_arrow);
        TextView r104 = (TextView) this.itemView.findViewById(R.id.tv_control);
        HSImageView r105 = (HSImageView) this.itemView.findViewById(R.id.iv_head);
        TextView r106 = (TextView) this.itemView.findViewById(R.id.tv_name);
        LinearLayout r107 = (LinearLayout) this.itemView.findViewById(R.id.name_container);
        ImageView r108 = (ImageView) this.itemView.findViewById(R.id.iv_gender);
        TextView r109 = (TextView) this.itemView.findViewById(R.id.tv_distance);
        ImageView r110 = (ImageView) this.itemView.findViewById(R.id.iv_location);
        this.f82025b = this.itemView.findViewById(R.id.gap);
        LinearLayout r111 = (LinearLayout) this.itemView.findViewById(R.id.other_info_container);
        RoomContext.a r112 = RoomContext.Companion;
        RoomContext r113 = RoomContext.a.c(r112, null, 0, 3);
        if (r113 == null) goto L9;
        com.bytedance.live.datacontext.i<Boolean> r114 = r113.isAnchor();
        if (r114 == null) goto L9;
        Boolean r115 = r114.getValue();
        if (r115 == null) goto L9;
        r115.booleanValue();
    L9:
        RoomContext r116 = RoomContext.a.c(r112, null, 0, 3);
        if (r116 == null) goto L15;
        com.bytedance.live.datacontext.m<Room> r117 = r116.getRoom();
        if (r117 == null) goto L16;
        Room r118 = r117.getValue();
        return;
    L16:
        return;
    }
}
