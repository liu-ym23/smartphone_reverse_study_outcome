package com.bytedance.android.livesdk.wrds.interact;

import am3.g;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.texturerender.VideoSurfaceTexture;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.WebcastInteractControlSyncData")
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001:\u0002\r\u000eB\u0007¢\u0006\u0004\b\u000b\u0010\fR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u001e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\n\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/wrds/interact/a;", "", "", "roomId", "Ljava/lang/String;", VideoSurfaceTexture.KEY_TIME, "", "Lcom/bytedance/android/livesdk/wrds/interact/a$a;", "anchorOperationList", "Ljava/util/List;", "audienceOperationList", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a implements h {

    @SerializedName("anchor_operation")
    public List<C2484a> anchorOperationList;

    @SerializedName("audience_operation")
    public List<C2484a> audienceOperationList;

    @SerializedName("room_id")
    public String roomId;

    @SerializedName("time_stamp")
    public String timeStamp;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.wrds.interact.a$a, reason: collision with other inner class name */
    @ProtoMessage("webcast.im.ClientOperation")
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR$\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0007\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/wrds/interact/a$a;", "", "", "appId", "Ljava/lang/String;", "", "operationType", "Ljava/lang/Integer;", "Lcom/bytedance/android/livesdk/wrds/interact/a$b;", "popBoxContent", "Lcom/bytedance/android/livesdk/wrds/interact/a$b;", "showTime", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Integer;", "b", "(Ljava/lang/Integer;)V", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class C2484a implements h {

        @SerializedName("app_id")
        public String appId;

        @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_OPERATION_TYPE)
        public Integer operationType;

        @SerializedName("pop_box_content")
        public b popBoxContent;

        @SerializedName("show_time")
        protected Integer showTime;

        public C2484a() {
        }

        public final Integer a() {
            return this.showTime;
        }

        public C2484a(g r100) {
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L18;
            if (r102 != 1) goto L8;
            this.appId = am3.h.c(r100);
            goto L3
        L8:
            if (r102 != 2) goto L10;
            this.operationType = Integer.valueOf(r100.i());
            goto L3
        L10:
            if (r102 != 3) goto L12;
            this.popBoxContent = new b(r100);
            goto L3
        L12:
            if (r102 != 4) goto L13;
            this.showTime = Integer.valueOf(r100.i());
            goto L3
        L13:
            am3.h.e(r100);
            goto L3
        L18:
            r100.d(r101);
        }

        public final void b(Integer r100) {
            this.showTime = r100;
        }
    }

    @ProtoMessage("webcast.im.PopBoxContent")
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\bR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\n\u0010\bR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\f\u0010\bR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\r\u0010\b¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/wrds/interact/a$b;", "", "", "largeType", "Ljava/lang/Integer;", "iconType", "", "title", "Ljava/lang/String;", "description", "url", "countDownSec", "buttonDesc", "mControlType", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f162524a;

        @SerializedName("button_desc")
        public String buttonDesc;

        @SerializedName("count_down_sec")
        public Integer countDownSec;

        @SerializedName("description")
        public String description;

        @SerializedName("icon_type")
        public Integer iconType;

        @SerializedName("large_type")
        public Integer largeType;

        @SerializedName("control_type")
        public String mControlType;

        @SerializedName("title")
        public String title;

        @SerializedName("url")
        public String url;

        public b() {
        }

        public final String a() {
            String r100 = this.mControlType;
            if (r100 != null) goto L6;
            return "unknown";
        L6:
            return r100;
        }

        public b(g r100) {
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
            this.buttonDesc = am3.h.c(r100);
            goto L3
        L8:
            this.countDownSec = Integer.valueOf(r100.i());
            goto L3
        L9:
            this.url = am3.h.c(r100);
            goto L3
        L10:
            this.description = am3.h.c(r100);
            goto L3
        L11:
            this.title = am3.h.c(r100);
            goto L3
        L12:
            this.mControlType = am3.h.c(r100);
            goto L3
        L13:
            this.iconType = Integer.valueOf(r100.i());
            goto L3
        L14:
            this.largeType = Integer.valueOf(r100.i());
            goto L3
        L6:
            am3.h.e(r100);
            goto L3
        L15:
            r100.d(r101);
        }
    }

    public a() {
    }

    public a(g r100) {
        this.anchorOperationList = new ArrayList();
        this.audienceOperationList = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L19;
        if (r102 != 2) goto L8;
        this.roomId = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 3) goto L10;
        this.timeStamp = am3.h.c(r100);
        goto L3
    L10:
        if (r102 == 4) goto L15;
        if (r102 != 5) goto L13;
        List<C2484a> r103 = this.audienceOperationList;
        C2484a r104 = new C2484a(r100);
    L16:
        r103.add(r104);
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L15:
        r103 = this.anchorOperationList;
        r104 = new C2484a(r100);
        goto L16
    L19:
        r100.d(r101);
    }
}
