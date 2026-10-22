package com.bytedance.android.livesdk.dislike.preload.loader;

import com.bytedance.android.livesdk.dislike.n;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DataCenter f122199a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IRoom f122200b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.android.livesdk.dislike.preload.context.a f122201c;

    public boolean a() {
        return true;
    }

    public void b() {
    }

    public void c() {
    }

    public abstract List<n> d();

    public a(com.bytedance.android.livesdk.dislike.preload.context.a r100) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        this.f122201c = r100;
        DataCenter r101 = r100.getDataCenter();
        this.f122199a = r101;
        if (r101 == null) goto L5;
        gb2.a.b(r101);
    L5:
        if (r101 == null) goto L7;
        gb2.a.d(r101);
    L7:
        if (r101 == null) goto L9;
        IRoom r102 = (IRoom) r101.get("data_room");
    L10:
        this.f122200b = r102;
        return;
    L9:
        r102 = null;
        goto L10
    }
}
