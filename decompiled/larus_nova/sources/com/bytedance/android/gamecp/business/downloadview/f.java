package com.bytedance.android.gamecp.business.downloadview;

import com.bytedance.android.gamecp.base.core.service.depend.x;
import com.bytedance.android.gamecp.business.i0;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class f {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f53025e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Integer f53026a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Integer f53027b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Integer f53028c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public x f53029d;

    public static final class a {
        public static f b(int r100) {
            f r101 = new f();
            if (r100 != 12) goto L5;
        L8:
            r101.f53026a = 3;
        L9:
            return r101;
        L5:
            if (r100 == 13) goto L8;
            r101.f53026a = Integer.valueOf(r100);
            goto L9
        }

        public static f a(int r100, x r101) {
            Intrinsics.checkNotNullParameter(r101, "progressData");
            f r102 = new f();
            r102.f53026a = Integer.valueOf(r100);
            r102.f53029d = r101;
            r102.f53027b = Integer.valueOf(i0.h(r101));
            return r102;
        }
    }

    static {
    }

    public f() {
    }

    public final Map<String, Integer> a() {
        LinkedHashMap r100 = new LinkedHashMap();
        Integer r101 = this.f53026a;
        if (r101 == null) goto L5;
        Intrinsics.checkNotNull(r101);
        r100.put("downloadStatus", r101);
    L5:
        Integer r102 = this.f53027b;
        if (r102 == null) goto L8;
        Intrinsics.checkNotNull(r102);
        r100.put("progress", r102);
    L8:
        Integer r103 = this.f53028c;
        if (r103 == null) goto L11;
        Intrinsics.checkNotNull(r103);
        r100.put("errorCode", r103);
    L11:
        return r100;
    }
}
