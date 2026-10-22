package com.bytedance.android.livesdk.castscreen.castscreenapi.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@ProtoMessage("webcast.api.room.PlayFilterResponse")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0007B\u0007¢\u0006\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/castscreen/castscreenapi/model/c;", "", "Lcom/bytedance/android/livesdk/castscreen/castscreenapi/model/c$a;", "data", "Lcom/bytedance/android/livesdk/castscreen/castscreenapi/model/c$a;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c implements vh7.h {

    @SerializedName("data")
    public a data;

    @ProtoMessage("webcast.api.room.PlayFilterResponse.Data")
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bR$\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/castscreen/castscreenapi/model/c$a;", "", "", "", "", "result", "Ljava/util/Map;", "", "toast", "Ljava/lang/String;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a implements vh7.h {

        @SerializedName("result")
        public Map<Long, Boolean> result;

        @SerializedName("toast")
        public String toast;

        public a() {
            this.toast = "";
        }

        public a(am3.g r110) {
            this.result = new HashMap();
            long r100 = r110.c();
        L3:
            int r101 = r110.f();
            if (r101 == (-1)) goto L26;
            if (r101 != 1) goto L7;
            long r102 = r110.c();
            Long r103 = null;
            Boolean r104 = null;
        L11:
            int r105 = r110.f();
            if (r105 == (-1)) goto L18;
            if (r105 != 1) goto L14;
            r103 = Long.valueOf(r110.j());
            goto L11
        L14:
            if (r105 != 2) goto L15;
            r104 = Boolean.valueOf(am3.h.a(r110));
            goto L11
        L15:
            am3.h.e(r110);
            goto L11
        L18:
            r110.d(r102);
            Map<Long, Boolean> r106 = this.result;
            if (r103 == null) goto L25;
            if (r104 == null) goto L23;
            r106.put(r103, r104);
            goto L3
        L23:
            throw new IllegalStateException("Value must not be null");
        L25:
            throw new IllegalStateException("Key must not be null");
        L7:
            if (r101 != 2) goto L8;
            this.toast = am3.h.c(r110);
            goto L3
        L8:
            am3.h.e(r110);
            goto L3
        L26:
            r110.d(r100);
            if (this.toast != null) goto L50;
            this.toast = "";
            return;
        }
    }

    public c() {
    }

    public c(am3.g r100) {
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
