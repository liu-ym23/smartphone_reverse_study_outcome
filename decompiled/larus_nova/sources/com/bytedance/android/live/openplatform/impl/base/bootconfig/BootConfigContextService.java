package com.bytedance.android.live.openplatform.impl.base.bootconfig;

import com.alipay.sdk.m.p.e;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContextService;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002\u0006\u0007B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/base/bootconfig/BootConfigContextService;", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContextService;", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;", "openPlatformContext", "<init>", "(Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BootConfigContextService extends OpenPlatformContextService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f84009b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, com.bytedance.android.live.openplatform.impl.base.api.response.a> f84010a;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f84011a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f84012b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof b) == false) goto L10;
            b r101 = (b) r100;
            if (this.f84011a == r101.f84011a) goto L8;
            return false;
        L8:
            if (this.f84012b == r101.f84012b) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            return (this.f84011a * 31) + this.f84012b;
        }

        public final String toString() {
            return "FrequencyLimit(maxTimes=" + this.f84011a + ", unitTime=" + this.f84012b + ")";
        }

        public b(int r100, int r101) {
            this.f84011a = r100;
            this.f84012b = r101;
        }
    }

    static {
    }

    public BootConfigContextService(OpenPlatformContext r100) {
        Intrinsics.checkNotNullParameter(r100, "openPlatformContext");
        super(r100);
        this.f84010a = new LinkedHashMap();
    }

    public final b f(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "appId");
        Intrinsics.checkNotNullParameter(r101, e.f25671s);
        com.bytedance.android.live.openplatform.impl.base.api.response.a r102 = (com.bytedance.android.live.openplatform.impl.base.api.response.a) ((LinkedHashMap) this.f84010a).get(r100);
        if (r102 == null) goto L13;
        List<com.bytedance.android.live.openplatform.impl.base.api.response.a.C1276a> r103 = r102.a();
        if (r103 == null) goto L18;
        Iterator<T> r104 = r103.iterator();
    L8:
        if (r104.hasNext() == false) goto L19;
        com.bytedance.android.live.openplatform.impl.base.api.response.a.C1276a r105 = (com.bytedance.android.live.openplatform.impl.base.api.response.a.C1276a) r104.next();
        if (Intrinsics.areEqual(r101, r105.b()) == false) goto L8;
        return new b(r105.a(), r105.c());
    L19:
        return null;
    L18:
        return null;
    L13:
        return null;
    }
}
