package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.VerticalTypeInfo;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.MoreLiveSyncData")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\t\u0010\nR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/hg;", "", "Lcom/bytedance/android/live/base/model/moreliveentrance/b;", "info", "Lcom/bytedance/android/live/base/model/moreliveentrance/b;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/live/base/model/moreliveentrance/b;", "setInfo", "(Lcom/bytedance/android/live/base/model/moreliveentrance/b;)V", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class hg implements vh7.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f153652a = 0;

    @SerializedName("info")
    protected com.bytedance.android.live.base.model.moreliveentrance.b info;

    public static final class a {
        @JvmStatic
        public static hg a(Room r100) {
            hg r101 = null;
            if (r100 != null) goto L5;
            return null;
        L5:
            VerticalTypeInfo r102 = r100.mVerticalTypeInfo;
            if (r102 == null) goto L12;
            r101 = new hg();
            com.bytedance.android.live.base.model.moreliveentrance.b r103 = new com.bytedance.android.live.base.model.moreliveentrance.b();
            r103.s(r102.name);
            Long r104 = r102.tabType;
            if (r104 == null) goto L10;
            long r105 = r104.longValue();
        L11:
            r103.x(r105);
            r103.t(r102.priority);
            r103.y(r102.validTime);
            r103.q(r102.extra);
            r103.p(r102.eventExtra);
            Unit r106 = Unit.INSTANCE;
            r101.info = r103;
            goto L12
        L10:
            r105 = -1;
        L12:
            return r101;
        }

        @JvmStatic
        public static void b(Room r100, hg r101) {
            if (r100 != null) goto L5;
            return;
        L5:
            if (r100.mVerticalTypeInfo != null) goto L7;
            r100.mVerticalTypeInfo = new VerticalTypeInfo();
        L7:
            if (r101 == null) goto L14;
            com.bytedance.android.live.base.model.moreliveentrance.b r102 = r101.info;
            if (r102 == null) goto L15;
            VerticalTypeInfo r103 = r100.mVerticalTypeInfo;
            if (r103 == null) goto L16;
            r103.name = r102.e();
            r103.tabType = Long.valueOf(r102.l());
            r103.priority = r102.f();
            r103.validTime = r102.o();
            r103.extra = r102.c();
            r103.eventExtra = r102.b();
            return;
        L16:
            return;
        L15:
            return;
        }
    }

    static {
    }

    public hg() {
    }

    public hg(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L9;
        if (r102 != 1) goto L7;
        this.info = new com.bytedance.android.live.base.model.moreliveentrance.b(r100);
        goto L3
    L7:
        am3.h.e(r100);
        goto L3
    L9:
        r100.d(r101);
    }

    public final com.bytedance.android.live.base.model.moreliveentrance.b a() {
        return this.info;
    }
}
