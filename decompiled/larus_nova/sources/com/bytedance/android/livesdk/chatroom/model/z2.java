package com.bytedance.android.livesdk.chatroom.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.tencent.open.SocialConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@ProtoMessage("webcast.gameplay.api.QueryCollectResponse")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001:\u0002\u0007\bB\u0007¢\u0006\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/z2;", "", "Lcom/bytedance/android/livesdk/chatroom/model/z2$a;", "data", "Lcom/bytedance/android/livesdk/chatroom/model/z2$a;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class z2 implements vh7.h {

    @SerializedName("data")
    public a data;

    @ProtoMessage("webcast.gameplay.api.QueryCollectResponse.Data")
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007R\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/z2$a;", "", "", "Lcom/bytedance/android/livesdk/chatroom/model/z2$b;", "items", "Ljava/util/List;", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a implements vh7.h {

        @SerializedName("items")
        public List<b> items;

        public a() {
        }

        public a(am3.g r100) {
            this.items = new ArrayList();
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L9;
            if (r102 != 1) goto L7;
            this.items.add(new b(r100));
            goto L3
        L7:
            am3.h.e(r100);
            goto L3
        L9:
            r100.d(r101);
        }
    }

    @ProtoMessage("webcast.gameplay.api.QueryCollectResponse.EntranceItem")
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0016\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u0004¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/z2$b;", "", "", "appId", "Ljava/lang/String;", "name", "iconUrl", "version", "config", SocialConstants.PARAM_APP_DESC, "", "canStartByAudience", "Z", "gameCategory", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b implements vh7.h {

        @SerializedName("app_id")
        public String appId;

        @SerializedName("can_start_by_audience")
        public boolean canStartByAudience;

        @SerializedName("config")
        public String config;

        @SerializedName(SocialConstants.PARAM_APP_DESC)
        public String desc;

        @SerializedName(BdpAppEventConstant.PARAMS_GAME_CATEGORY)
        public String gameCategory;

        @SerializedName("icon_url")
        public String iconUrl;

        @SerializedName("name")
        public String name;

        @SerializedName("version")
        public String version;

        public b() {
            this.appId = "";
            this.name = "";
            this.iconUrl = "";
            this.version = "";
            this.config = "";
            this.desc = "";
            this.gameCategory = "";
        }

        public b(am3.g r100) {
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L15;
            switch(r102) {
                case 1: goto L14;
                case 2: goto L13;
                case 3: goto L12;
                case 4: goto L11;
                case 5: goto L10;
                case 6: goto L9;
                case 7: goto L8;
                case 8: goto L7;
                default: goto L6;
            };
        L7:
            this.gameCategory = am3.h.c(r100);
            goto L3
        L8:
            this.canStartByAudience = am3.h.a(r100);
            goto L3
        L9:
            this.desc = am3.h.c(r100);
            goto L3
        L10:
            this.config = am3.h.c(r100);
            goto L3
        L11:
            this.version = am3.h.c(r100);
            goto L3
        L12:
            this.iconUrl = am3.h.c(r100);
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
            if (this.iconUrl != null) goto L25;
            this.iconUrl = "";
        L25:
            if (this.version != null) goto L28;
            this.version = "";
        L28:
            if (this.config != null) goto L31;
            this.config = "";
        L31:
            if (this.desc != null) goto L34;
            this.desc = "";
        L34:
            if (this.gameCategory != null) goto L57;
            this.gameCategory = "";
            return;
        }
    }

    public z2() {
    }

    public z2(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L9;
        if (r102 != 1) goto L7;
        this.data = new a(r100);
        goto L3
    L7:
        am3.h.e(r100);
        goto L3
    L9:
        r100.d(r101);
    }
}
