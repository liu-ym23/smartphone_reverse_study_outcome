package com.bytedance.android.livesdk.castscreen.castscreenapi.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes7.dex */
@ProtoMessage("webcast.api.room.RelatedPcDevicesResponse")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\t\u0010\nR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/castscreen/castscreenapi/model/g;", "", "Lcom/bytedance/android/livesdk/castscreen/castscreenapi/model/g$a;", "data", "Lcom/bytedance/android/livesdk/castscreen/castscreenapi/model/g$a;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/livesdk/castscreen/castscreenapi/model/g$a;", "setData", "(Lcom/bytedance/android/livesdk/castscreen/castscreenapi/model/g$a;)V", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class g implements vh7.h {

    @SerializedName("data")
    protected a data;

    @ProtoMessage("webcast.api.room.RelatedPcDevicesResponse.Data")
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0018\u0010\u0019R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR*\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdk/castscreen/castscreenapi/model/g$a;", "", "", "isOnlyOnPushed", "Ljava/lang/Long;", "c", "()Ljava/lang/Long;", "setOnlyOnPushed", "(Ljava/lang/Long;)V", "Lcom/bytedance/android/livesdk/castscreen/castscreenapi/model/f;", "pushRes", "Lcom/bytedance/android/livesdk/castscreen/castscreenapi/model/f;", "b", "()Lcom/bytedance/android/livesdk/castscreen/castscreenapi/model/f;", "setPushRes", "(Lcom/bytedance/android/livesdk/castscreen/castscreenapi/model/f;)V", "", "Lcom/bytedance/android/livesdk/castscreen/castscreenapi/model/b;", "devices", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "setDevices", "(Ljava/util/List;)V", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a implements vh7.h {

        @SerializedName("device_list")
        protected List<b> devices;

        @SerializedName("is_only_one_pushed")
        protected Long isOnlyOnPushed;

        @SerializedName("push_res")
        protected f pushRes;

        public a() {
            this.isOnlyOnPushed = 0L;
            this.devices = CollectionsKt.emptyList();
        }

        public final List<b> a() {
            return this.devices;
        }

        public final f b() {
            return this.pushRes;
        }

        public final Long c() {
            return this.isOnlyOnPushed;
        }

        public a(am3.g r100) {
            this.devices = new ArrayList();
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L15;
            if (r102 != 1) goto L8;
            this.isOnlyOnPushed = Long.valueOf(r100.j());
            goto L3
        L8:
            if (r102 != 2) goto L10;
            this.pushRes = new f(r100);
            goto L3
        L10:
            if (r102 != 3) goto L11;
            this.devices.add(new b(r100));
            goto L3
        L11:
            am3.h.e(r100);
            goto L3
        L15:
            r100.d(r101);
            if (this.isOnlyOnPushed != null) goto L19;
            this.isOnlyOnPushed = 0L;
        L19:
            if (this.devices.isEmpty() == false) goto L34;
            this.devices = CollectionsKt.emptyList();
            return;
        }
    }

    public g() {
    }

    public g(am3.g r100) {
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

    public final a a() {
        return this.data;
    }
}
