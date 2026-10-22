package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.ss.texturerender.VideoSurfaceTexture;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00060\u0002j\u0002`\u0003R\u001a\u0010\t\u001a\u00020\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u000e\u001a\u00020\n8&X§\u0004¢\u0006\f\u0012\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0013\u001a\u00020\u000f8&X§\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\b\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0018\u001a\u00020\u00148&X§\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\b\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u001d\u001a\u00020\u00198&X§\u0004¢\u0006\f\u0012\u0004\b\u001c\u0010\b\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\"\u001a\u00020\u001e8&X§\u0004¢\u0006\f\u0012\u0004\b!\u0010\b\u001a\u0004\b\u001f\u0010 ¨\u0006#"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/q6;", "Lvh7/c;", "Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", "", "getScene", "()Ljava/lang/String;", "getScene$annotations", "()V", "scene", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "getCurrentAnchor", "()Lcom/bytedance/android/live/base/model/user/IBaseUser;", "getCurrentAnchor$annotations", "currentAnchor", "", "getTimeStamp", "()J", "getTimeStamp$annotations", VideoSurfaceTexture.KEY_TIME, "Lcom/bytedance/android/livesdk/gift/model/x1;", "getGiftPanelTopBar", "()Lcom/bytedance/android/livesdk/gift/model/x1;", "getGiftPanelTopBar$annotations", "giftPanelTopBar", "Lcom/bytedance/android/livesdk/message/model/a7;", "getComboTrayInfo", "()Lcom/bytedance/android/livesdk/message/model/a7;", "getComboTrayInfo$annotations", "comboTrayInfo", "", "getDisplayPosition", "()I", "getDisplayPosition$annotations", "displayPosition", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface q6 extends vh7.c<q6>, yh6.c {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "combo_tray_info")
    a7 getComboTrayInfo();

    @Override // yh6.c
    /* synthetic */ com.bytedance.android.live.base.model.message.m0 getCommonData();

    @FieldName(name = "to_user")
    IBaseUser getCurrentAnchor();

    @FieldName(name = "display_position")
    int getDisplayPosition();

    @FieldName(name = "gift_panel_topbar")
    com.bytedance.android.livesdk.gift.model.x1 getGiftPanelTopBar();

    @FieldName(name = "scene")
    String getScene();

    @FieldName(name = "now_millis")
    long getTimeStamp();

    /* synthetic */ void setCommonData(com.bytedance.android.live.base.model.message.m0 r100);
}
