package com.bytedance.android.live.liveinteract.wrds;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002R\u001a\u0010\b\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005R(\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n\u0018\u00010\t8&X§\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u0007\u001a\u0004\b\u000b\u0010\fR(\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\t8&X§\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0007\u001a\u0004\b\u0010\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/liveinteract/wrds/RoomLinkmicMicDisplayInfo;", "Lvh7/c;", "Lja0/a;", "", "getRoomId", "()J", "getRoomId$annotations", "()V", "roomId", "", "Lkd1/b;", "get_micDressInfo", "()Ljava/util/Map;", "get_micDressInfo$annotations", "_micDressInfo", "", "get_micDressOpenInfo", "get_micDressOpenInfo$annotations", "_micDressOpenInfo", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface RoomLinkmicMicDisplayInfo extends vh7.c<RoomLinkmicMicDisplayInfo>, ja0.a {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "room_id")
    long getRoomId();

    @FieldName(name = "mic_dress_info")
    Map<Long, kd1.b> get_micDressInfo();

    @FieldName(name = "open_mic_dress_info")
    Map<String, kd1.b> get_micDressOpenInfo();
}
