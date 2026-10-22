package com.bytedance.android.livesdk.revenue.datacenter;

import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.facebook.keyframes.model.KFAnimation;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty1;

/* JADX INFO: loaded from: classes11.dex */
public abstract class h<Env> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DataCenter f157147a;

    public abstract String a(KProperty1<Env, ? extends Object> r100);

    public h(DataCenter r100) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        this.f157147a = r100;
    }

    public final void b(KProperty1 r100, Observer r101) {
        Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r101, "observer");
        String r102 = a(r100);
        if (r102.length() <= 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L9;
        this.f157147a.observeForever(r102, r101);
        return;
    L9:
        return;
    L5:
        r103 = false;
        goto L6
    }

    public final void c(KProperty1<Env, ? extends Object> r100, Observer<KVData> r101) {
        Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r101, "observer");
        String r102 = a(r100);
        if (r102.length() <= 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L9;
        this.f157147a.removeObserver(r102, r101);
        return;
    L9:
        return;
    L5:
        r103 = false;
        goto L6
    }
}
