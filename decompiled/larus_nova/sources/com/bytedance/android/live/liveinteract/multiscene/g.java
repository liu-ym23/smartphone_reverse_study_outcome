package com.bytedance.android.live.liveinteract.multiscene;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0015\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R(\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u000e\u001a\u00020\n8&X§\u0004¢\u0006\f\u0012\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u000f8&X§\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\b\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00148&X§\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\b\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u000f8&X§\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\b\u001a\u0004\b\u0019\u0010\u0011R\u001a\u0010\u001f\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\b\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\"\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b!\u0010\b\u001a\u0004\b \u0010\u001dR\u001c\u0010%\u001a\u0004\u0018\u00010\u000f8&X§\u0004¢\u0006\f\u0012\u0004\b$\u0010\b\u001a\u0004\b#\u0010\u0011R\u001c\u0010(\u001a\u0004\u0018\u00010\u000f8&X§\u0004¢\u0006\f\u0012\u0004\b'\u0010\b\u001a\u0004\b&\u0010\u0011¨\u0006)"}, d2 = {"Lcom/bytedance/android/live/liveinteract/multiscene/g;", "Lvh7/c;", "", "", "Lcom/bytedance/android/live/liveinteract/multiscene/d;", "getRoomInfoMap", "()Ljava/util/Map;", "getRoomInfoMap$annotations", "()V", "roomInfoMap", "", "getInviteSource", "()I", "getInviteSource$annotations", "inviteSource", "", "getExtra", "()Ljava/lang/String;", "getExtra$annotations", "extra", "Lcom/bytedance/android/live/liveinteract/multiscene/c;", "getRoomBattleMode", "()Lcom/bytedance/android/live/liveinteract/multiscene/c;", "getRoomBattleMode$annotations", "roomBattleMode", "getIfThemeDefault", "getIfThemeDefault$annotations", "ifThemeDefault", "getThemeChooserRoomId", "()J", "getThemeChooserRoomId$annotations", "themeChooserRoomId", "getIfPeakHour", "getIfPeakHour$annotations", "ifPeakHour", "getAnchorRelationType", "getAnchorRelationType$annotations", "anchorRelationType", "getBeginType", "getBeginType$annotations", "beginType", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface g extends vh7.c<g> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "anchor_relation_type")
    String getAnchorRelationType();

    @FieldName(name = "begin_type")
    String getBeginType();

    @FieldName(name = "extra")
    String getExtra();

    @FieldName(name = "if_peak_hour")
    long getIfPeakHour();

    @FieldName(name = "if_theme_default")
    String getIfThemeDefault();

    @FieldName(name = "invite_source")
    int getInviteSource();

    @FieldName(name = "room_battle_mode")
    c getRoomBattleMode();

    @FieldName(name = "room_info_map")
    Map<Long, d> getRoomInfoMap();

    @FieldName(name = "theme_chooser_room_id")
    long getThemeChooserRoomId();
}
