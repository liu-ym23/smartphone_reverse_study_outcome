package com.bytedance.android.live.openplatform.impl.openapi.api.response;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes46.dex */
@ProtoMessage("webcast.open.api.GetFollowAnchorStatusResponse.Data")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\t\u0010\nR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/openapi/api/response/a;", "", "Lcom/bytedance/android/live/openplatform/impl/openapi/api/response/a$a;", "followInfo", "Lcom/bytedance/android/live/openplatform/impl/openapi/api/response/a$a;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/live/openplatform/impl/openapi/api/response/a$a;", "setFollowInfo", "(Lcom/bytedance/android/live/openplatform/impl/openapi/api/response/a$a;)V", "<init>", "()V", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a implements h {

    @SerializedName("follow_info")
    protected C1319a followInfo;

    /* JADX INFO: renamed from: com.bytedance.android.live.openplatform.impl.openapi.api.response.a$a, reason: collision with other inner class name */
    @ProtoMessage("webcast.open.api.GetFollowAnchorStatusResponse.Data.FollowInfo")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/openapi/api/response/a$a;", "", "", "hasFollow", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "setHasFollow", "(Z)V", "<init>", "()V", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class C1319a implements h {

        @SerializedName("has_followed")
        protected boolean hasFollow;

        public C1319a() {
        }

        public C1319a(g r100) {
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L9;
            if (r102 != 1) goto L7;
            this.hasFollow = am3.h.a(r100);
            goto L3
        L7:
            am3.h.e(r100);
            goto L3
        L9:
            r100.d(r101);
        }

        public final boolean a() {
            return this.hasFollow;
        }
    }

    public a() {
    }

    public a(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L9;
        if (r102 != 1) goto L7;
        this.followInfo = new C1319a(r100);
        goto L3
    L7:
        am3.h.e(r100);
        goto L3
    L9:
        r100.d(r101);
    }

    public final C1319a a() {
        return this.followInfo;
    }
}
