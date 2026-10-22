package ag0;

import com.bytedance.android.live.liveinteract.multianchor.model.c;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;
import vh7.e;

/* JADX INFO: loaded from: classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0006\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lag0/a;", "Lvh7/e;", "Lcom/bytedance/android/live/liveinteract/multianchor/model/c;", "", "", "getRankUserIds", "()Ljava/util/List;", "getRankUserIds$annotations", "()V", "rankUserIds", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface a extends e<c>, c {

    /* JADX INFO: renamed from: ag0.a$a, reason: collision with other inner class name */
    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class C0065a {
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.c, vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.c, vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.c
    @FieldName(name = "app_id")
    /* synthetic */ long getAppId();

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.c
    @FieldName(name = "client_version")
    /* synthetic */ long getClientVersion();

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.c
    @FieldName(name = "current_time")
    /* synthetic */ long getCurrentTime();

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.c
    @FieldName(name = "device_platform")
    /* synthetic */ String getDevicePlatform();

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.c
    @FieldName(name = "expected_leave_time")
    /* synthetic */ long getExpectLeaveTime();

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.c
    @FieldName(name = "fan_ticket")
    /* synthetic */ long getFanTicket();

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.c
    @FieldName(name = "fan_ticket_fuzzy_str")
    /* synthetic */ String getFanTicketFuzzyStr();

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.c
    @FieldName(name = "fan_ticket_real_str")
    /* synthetic */ String getFanTicketRealStr();

    @Override // vh7.e
    /* synthetic */ Object getFlexInstance();

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.c
    @FieldName(name = "join_channel_time")
    /* synthetic */ long getJoinChannelTime();

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.c
    @FieldName(name = "list_user_role")
    /* synthetic */ int getListUserRole();

    @FieldName(name = "rank_contributor_ids")
    List<Long> getRankUserIds();

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.c
    @FieldName(name = "host_permission")
    /* synthetic */ boolean isHost();
}
