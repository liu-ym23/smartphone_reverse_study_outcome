package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.gamecp.business.instantplay.InstantPlayContext;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b'\u0010(R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087D¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001a\u0010\u0010\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001d\u001a\u00020\u001c8\u0006X\u0087D¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\"\u0010#\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&¨\u0006)"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/s3;", "", "", "roomId", "J", "getRoomId", "()J", "playId", "getPlayId", "", "status", "I", "getStatus", "()I", "themeId", "getThemeId", "bgId", "getBgId", "Lpy/k;", "bgUrl", "Lpy/k;", "getBgUrl", "()Lpy/k;", "Lcom/bytedance/android/livesdk/message/model/rc;", "themeRole", "Lcom/bytedance/android/livesdk/message/model/rc;", "getThemeRole", "()Lcom/bytedance/android/livesdk/message/model/rc;", "", "showRoleNickName", "Z", "getShowRoleNickName", "()Z", "", "Lcom/bytedance/android/livesdk/message/model/i;", "actingUserInfos", "Ljava/util/List;", "getActingUserInfos", "()Ljava/util/List;", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class s3 implements vh7.h {

    @SerializedName("acting_user_infos")
    protected List<i> actingUserInfos;

    @SerializedName("bg_id")
    protected long bgId;

    @SerializedName("bg_url")
    protected py.k bgUrl;

    @SerializedName(InstantPlayContext.PLAY_ID)
    protected long playId;

    @SerializedName("room_id")
    protected long roomId;

    @SerializedName("show_role_nick_name")
    protected boolean showRoleNickName;

    @SerializedName("status")
    protected int status;

    @SerializedName("theme_id")
    protected long themeId;

    @SerializedName("theme_role")
    protected rc themeRole;

    public s3() {
    }

    /* JADX WARN: Type inference failed for: r2v7, types: [java.lang.Object, py.k] */
    public s3(am3.g r100) {
        this.actingUserInfos = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L16;
        switch(r102) {
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            case 8: goto L8;
            case 9: goto L7;
            default: goto L6;
        };
    L7:
        this.actingUserInfos.add(new i(r100));
        goto L3
    L8:
        this.showRoleNickName = am3.h.a(r100);
        goto L3
    L9:
        this.themeRole = new rc(r100);
        goto L3
    L10:
        this.bgUrl = vh7.f.a(r100, py.k.class);
        goto L3
    L11:
        this.bgId = r100.j();
        goto L3
    L12:
        this.themeId = r100.j();
        goto L3
    L13:
        this.status = r100.i();
        goto L3
    L14:
        this.playId = r100.j();
        goto L3
    L15:
        this.roomId = r100.j();
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L16:
        r100.d(r101);
    }
}
