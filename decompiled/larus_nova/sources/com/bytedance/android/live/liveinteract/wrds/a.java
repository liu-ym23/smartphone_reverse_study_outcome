package com.bytedance.android.live.liveinteract.wrds;

import com.bytedance.android.live.liveinteract.plantform.model.IChannelLinkUser;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005R\u001c\u0010\r\u001a\u0004\u0018\u00010\t8&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0007\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/liveinteract/wrds/a;", "Lvh7/c;", "", "Lcom/bytedance/android/live/liveinteract/plantform/model/IChannelLinkUser;", "getChannelLinkUsers", "()Ljava/util/List;", "getChannelLinkUsers$annotations", "()V", "channelLinkUsers", "", "getRtcRoomIdStr", "()Ljava/lang/String;", "getRtcRoomIdStr$annotations", "rtcRoomIdStr", "liveinteract-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface a extends vh7.c<a> {

    /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.wrds.a$a, reason: collision with other inner class name */
    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class C1246a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "channel_link_users")
    List<IChannelLinkUser> getChannelLinkUsers();

    @FieldName(name = "rtc_room_id_str")
    String getRtcRoomIdStr();
}
