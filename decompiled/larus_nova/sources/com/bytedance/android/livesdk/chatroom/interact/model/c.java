package com.bytedance.android.livesdk.chatroom.interact.model;

import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.dypay.api.DyPayConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@ProtoMessage("webcast.api.linkmic.RivalsResponse.ActivityTime")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001:\u0002\u000e\u000fB\u0007¢\u0006\u0004\b\f\u0010\rR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/interact/model/c;", "", "", DyPayConstant.KEY_START_TIME, "J", "getStartTime", "()J", "setStartTime", "(J)V", "endTime", "getEndTime", "setEndTime", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c implements vh7.h {

    @SerializedName("end_time")
    protected long endTime;

    @SerializedName(ILoadStallMonitor.START_TIME)
    protected long startTime;

    @ProtoMessage("webcast.api.linkmic.RivalsResponse.PanelBanner")
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/interact/model/c$a;", "", "Lcom/bytedance/android/livesdk/chatroom/interact/model/c$b;", "bannerAction", "Lcom/bytedance/android/livesdk/chatroom/interact/model/c$b;", "getBannerAction", "()Lcom/bytedance/android/livesdk/chatroom/interact/model/c$b;", "setBannerAction", "(Lcom/bytedance/android/livesdk/chatroom/interact/model/c$b;)V", "Lcom/bytedance/android/live/base/model/ImageModel;", "bgImage", "Lcom/bytedance/android/live/base/model/ImageModel;", "getBgImage", "()Lcom/bytedance/android/live/base/model/ImageModel;", "setBgImage", "(Lcom/bytedance/android/live/base/model/ImageModel;)V", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a implements vh7.h {

        @SerializedName("action")
        protected b bannerAction;

        @SerializedName("bg_image")
        protected ImageModel bgImage;

        public a() {
        }

        public a(am3.g r100) {
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L12;
            if (r102 != 1) goto L8;
            this.bannerAction = new b(r100);
            goto L3
        L8:
            if (r102 != 2) goto L9;
            this.bgImage = com.bytedance.android.live.base.model.x.a(r100);
            goto L3
        L9:
            am3.h.e(r100);
            goto L3
        L12:
            r100.d(r101);
        }
    }

    @ProtoMessage("webcast.api.linkmic.RivalsResponse.PanelBanner.Action")
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/interact/model/c$b;", "", "", "schemeUrl", "Ljava/lang/String;", "getSchemeUrl", "()Ljava/lang/String;", "setSchemeUrl", "(Ljava/lang/String;)V", "Lcom/bytedance/android/live/base/model/ImageModel;", "actionImage", "Lcom/bytedance/android/live/base/model/ImageModel;", "getActionImage", "()Lcom/bytedance/android/live/base/model/ImageModel;", "setActionImage", "(Lcom/bytedance/android/live/base/model/ImageModel;)V", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b implements vh7.h {

        @SerializedName("action_image")
        protected ImageModel actionImage;

        @SerializedName("scheme_url")
        protected String schemeUrl;

        public b() {
        }

        public b(am3.g r100) {
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L12;
            if (r102 != 1) goto L8;
            this.schemeUrl = am3.h.c(r100);
            goto L3
        L8:
            if (r102 != 2) goto L9;
            this.actionImage = com.bytedance.android.live.base.model.x.a(r100);
            goto L3
        L9:
            am3.h.e(r100);
            goto L3
        L12:
            r100.d(r101);
        }
    }

    public c() {
    }

    public c(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this.startTime = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.endTime = r100.j();
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
    }
}
