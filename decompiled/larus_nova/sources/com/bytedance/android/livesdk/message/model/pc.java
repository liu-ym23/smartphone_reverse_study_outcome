package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.gamecp.business.instantplay.InstantPlayContext;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b4\u00105R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001a\u0010\u000e\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001b\u001a\u00020\u001a8\u0006X\u0087D¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\"\u0010!\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001c\u0010&\u001a\u0004\u0018\u00010%8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u001c\u0010+\u001a\u0004\u0018\u00010*8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u001a\u00100\u001a\u00020/8\u0006X\u0087D¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103¨\u00066"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/pc;", "", "", "playId", "J", "getPlayId", "()J", "", "status", "I", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()I", "themeId", "getThemeId", "bgId", "getBgId", "Lpy/k;", "bgUrl", "Lpy/k;", "getBgUrl", "()Lpy/k;", "Lcom/bytedance/android/livesdk/message/model/rc;", "themeRole", "Lcom/bytedance/android/livesdk/message/model/rc;", "getThemeRole", "()Lcom/bytedance/android/livesdk/message/model/rc;", "", "showRoleNickName", "Z", "getShowRoleNickName", "()Z", "", "Lcom/bytedance/android/livesdk/message/model/i;", "actingUserInfos", "Ljava/util/List;", "getActingUserInfos", "()Ljava/util/List;", "Lcom/bytedance/android/livesdk/message/model/oc;", "giftContent", "Lcom/bytedance/android/livesdk/message/model/oc;", "getGiftContent", "()Lcom/bytedance/android/livesdk/message/model/oc;", "Lcom/bytedance/android/livesdk/message/model/s3;", "crossRoomInfo", "Lcom/bytedance/android/livesdk/message/model/s3;", "getCrossRoomInfo", "()Lcom/bytedance/android/livesdk/message/model/s3;", "", "extra", "Ljava/lang/String;", "getExtra", "()Ljava/lang/String;", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class pc implements vh7.h {

    @SerializedName("acting_user_infos")
    protected List<i> actingUserInfos;

    @SerializedName("bg_id")
    protected long bgId;

    @SerializedName("bg_url")
    protected py.k bgUrl;

    @SerializedName("cross_room_info")
    protected s3 crossRoomInfo;

    @SerializedName("extra")
    protected String extra;

    @SerializedName("gift_content")
    protected oc giftContent;

    @SerializedName(InstantPlayContext.PLAY_ID)
    protected long playId;

    @SerializedName("show_role_nick_name")
    protected boolean showRoleNickName;

    @SerializedName("status")
    protected int status;

    @SerializedName("theme_id")
    protected long themeId;

    @SerializedName("theme_role")
    protected rc themeRole;

    public pc() {
        this.extra = "";
    }

    public final int a() {
        return this.status;
    }

    /* JADX WARN: Type inference failed for: r2v6, types: [java.lang.Object, py.k] */
    public pc(am3.g r100) {
        this.actingUserInfos = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L22;
        if (r102 != 20) goto L8;
        this.crossRoomInfo = new s3(r100);
        goto L3
    L8:
        if (r102 != 100) goto L9;
        this.extra = am3.h.c(r100);
        goto L3
    L9:
        switch(r102) {
            case 1: goto L19;
            case 2: goto L18;
            case 3: goto L17;
            case 4: goto L16;
            case 5: goto L15;
            case 6: goto L14;
            case 7: goto L13;
            case 8: goto L12;
            case 9: goto L11;
            default: goto L10;
        };
    L11:
        this.giftContent = new oc(r100);
        goto L3
    L12:
        this.actingUserInfos.add(new i(r100));
        goto L3
    L13:
        this.showRoleNickName = am3.h.a(r100);
        goto L3
    L14:
        this.themeRole = new rc(r100);
        goto L3
    L15:
        this.bgUrl = vh7.f.a(r100, py.k.class);
        goto L3
    L16:
        this.bgId = r100.j();
        goto L3
    L17:
        this.themeId = r100.j();
        goto L3
    L18:
        this.status = r100.i();
        goto L3
    L19:
        this.playId = r100.j();
        goto L3
    L10:
        am3.h.e(r100);
        goto L3
    L22:
        r100.d(r101);
        if (this.extra != null) goto L54;
        this.extra = "";
        return;
    }
}
