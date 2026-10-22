package com.bytedance.android.livesdk.chatroom.model;

import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.tencent.open.SocialConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@ProtoMessage("webcast.api.profit_open_game.CenterEntranceResponse.Data")
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\nR\u001e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/x;", "", "", "disable", "Ljava/lang/Boolean;", "Lcom/bytedance/android/live/base/model/ImageModel;", "icon", "Lcom/bytedance/android/live/base/model/ImageModel;", "", "title", "Ljava/lang/String;", "entranceSchema", "", "Lcom/bytedance/android/livesdk/chatroom/model/x$a;", "items", "Ljava/util/List;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class x implements vh7.h {

    @SerializedName("disable")
    public Boolean disable;

    @SerializedName("url_scheme")
    public String entranceSchema;

    @SerializedName("icon")
    public ImageModel icon;

    @SerializedName("collections")
    public List<a> items;

    @SerializedName("title")
    public String title;

    @ProtoMessage("webcast.data.ProfitOpenGameCenterItem")
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0018\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0004¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/x$a;", "", "", "appId", "Ljava/lang/String;", "name", "Lcom/bytedance/android/live/base/model/ImageModel;", "iconUrl", "Lcom/bytedance/android/live/base/model/ImageModel;", "version", "config", SocialConstants.PARAM_APP_DESC, "", "disabled", "Ljava/lang/Boolean;", "gameCategory", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a implements vh7.h {

        @SerializedName("mini_app")
        public String appId;

        @SerializedName("config")
        public String config;

        @SerializedName(SocialConstants.PARAM_APP_DESC)
        public String desc;

        @SerializedName("disabled")
        public Boolean disabled;

        @SerializedName(BdpAppEventConstant.PARAMS_GAME_CATEGORY)
        public String gameCategory;

        @SerializedName("icon")
        public ImageModel iconUrl;

        @SerializedName("title")
        public String name;

        @SerializedName("version")
        public String version;

        public a() {
            this.appId = "";
            this.name = "";
            this.version = "";
            this.config = "";
            this.desc = "";
            this.disabled = Boolean.FALSE;
            this.gameCategory = "";
        }

        public a(am3.g r100) {
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L15;
            switch(r102) {
                case 1: goto L14;
                case 2: goto L13;
                case 3: goto L12;
                case 4: goto L11;
                case 5: goto L6;
                case 6: goto L6;
                case 7: goto L10;
                case 8: goto L6;
                case 9: goto L9;
                case 10: goto L8;
                case 11: goto L7;
                default: goto L6;
            };
        L7:
            this.gameCategory = am3.h.c(r100);
            goto L3
        L8:
            this.config = am3.h.c(r100);
            goto L3
        L9:
            this.version = am3.h.c(r100);
            goto L3
        L10:
            this.disabled = Boolean.valueOf(am3.h.a(r100));
            goto L3
        L11:
            this.iconUrl = com.bytedance.android.live.base.model.x.a(r100);
            goto L3
        L12:
            this.desc = am3.h.c(r100);
            goto L3
        L13:
            this.name = am3.h.c(r100);
            goto L3
        L14:
            this.appId = am3.h.c(r100);
            goto L3
        L6:
            am3.h.e(r100);
            goto L3
        L15:
            r100.d(r101);
            if (this.appId != null) goto L19;
            this.appId = "";
        L19:
            if (this.name != null) goto L22;
            this.name = "";
        L22:
            if (this.version != null) goto L25;
            this.version = "";
        L25:
            if (this.config != null) goto L28;
            this.config = "";
        L28:
            if (this.desc != null) goto L31;
            this.desc = "";
        L31:
            if (this.disabled != null) goto L34;
            this.disabled = Boolean.FALSE;
        L34:
            if (this.gameCategory != null) goto L57;
            this.gameCategory = "";
            return;
        }
    }

    public x() {
        this.disable = Boolean.FALSE;
        this.title = "";
        this.entranceSchema = "";
    }

    public x(am3.g r100) {
        this.items = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L21;
        if (r102 != 1) goto L8;
        this.disable = Boolean.valueOf(am3.h.a(r100));
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.icon = com.bytedance.android.live.base.model.x.a(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.entranceSchema = am3.h.c(r100);
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this.title = am3.h.c(r100);
        goto L3
    L14:
        if (r102 != 5) goto L15;
        this.items.add(new a(r100));
        goto L3
    L15:
        am3.h.e(r100);
        goto L3
    L21:
        r100.d(r101);
        if (this.disable != null) goto L25;
        this.disable = Boolean.FALSE;
    L25:
        if (this.title != null) goto L28;
        this.title = "";
    L28:
        if (this.entranceSchema != null) goto L49;
        this.entranceSchema = "";
        return;
    }
}
