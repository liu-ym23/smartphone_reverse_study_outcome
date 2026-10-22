package com.bytedance.android.livesdk.chatroom.vs_base;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.android.scope.l;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import e33.k;
import java.util.concurrent.ConcurrentHashMap;
import ju2.a;
import ju2.g;
import kotlin.UninitializedPropertyAccessException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import pm1.h;

/* JADX INFO: loaded from: classes8.dex */
public final class VSDataCenterScopeUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<Integer, a> f117877a = null;

    static {
        f117877a = new ConcurrentHashMap();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.bytedance.android.scope.j] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r2v3, types: [T, com.bytedance.android.scope.j] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r4v0, types: [T, java.lang.Object, ju2.g] */
    public static a a(DataCenter r100) {
        ?? r101 = 0;
        if (r100.isCleared() == false) goto L5;
        return null;
    L5:
        LifecycleOwner r102 = r100.lifecycleOwner;
        if (r102 == null) goto L28;
        final int r103 = r102.hashCode();
        ConcurrentHashMap<Integer, a> r104 = f117877a;
        if (r104.containsKey(Integer.valueOf(r103)) == true) goto L10;
        final Ref.ObjectRef r105 = new Ref.ObjectRef();
        ?? r106 = new g(h.f529822d.b());
        Intrinsics.checkNotNullParameter(r106, "scope");
        Intrinsics.checkNotNullParameter(r100, "value");
        r106.f500466e = r100;
        if (r100 != k.f470908a) goto L14;
        String r107 = "dataCenter";
    L15:
        if (r107 != null) goto L27;
        r105.element = r106;
        a r108 = r104.putIfAbsent(Integer.valueOf(r103), (a) r105.element);
        ?? r109 = r108;
        if (r108 != null) goto L19;
        r109 = (a) r105.element;
    L19:
        r105.element = r109;
        if ((!l.b(r109)) == false) goto L22;
        r101 = r109;
    L22:
        if (r101 == 0) goto L25;
        ALogger.d("VSDataCenterScopeUtil", "enter:" + r103);
        l.a(r101);
        r100.lifecycleOwner.getLifecycle().addObserver(new VSDataCenterScopeUtil$provideDataCenterScope$$inlined$let$lambda$1(r103, r105));
    L25:
        return (a) r105.element;
    L27:
        throw new UninitializedPropertyAccessException(r107);
    L14:
        r107 = null;
        goto L15
    L10:
        return r104.get(Integer.valueOf(r103));
    L28:
        return null;
    }

    public static a b(DataCenter r100, Widget r101) {
        if (r100 == null) goto L6;
        return a(r100);
    L6:
        if (r101 == null) goto L8;
        DataCenter r102 = r101.dataCenter;
    L9:
        if (r102 != null) goto L11;
        DataCenter r103 = r.d().c(null, 0);
        if (r103 != null) goto L15;
        return null;
    L15:
        return a(r103);
    L11:
        return a(r101.dataCenter);
    L8:
        r102 = null;
        goto L9
    }
}
