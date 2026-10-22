package com.bytedance.android.livesdk.utils.landscape;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import j40.v0;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes11.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f159073a = 0;

    @JvmStatic
    public static final int a() {
        v0 r100 = v0.f497310a;
        if (r100 == null) goto L7;
        Integer r101 = r100.getValue();
        if (r101 == null) goto L7;
        return r101.intValue();
    L7:
        return 0;
    }

    static {
    }

    @JvmStatic
    public static final boolean b(IRoom r100) {
        if (r100 == null) goto L4;
        boolean r101 = r100.isMediaRoom();
    L6:
        return !r101;
    L4:
        r101 = false;
        goto L6
    }

    @JvmStatic
    public static final boolean c(DataCenter r100) {
        IRoom r101 = null;
        if (r100 == null) goto L6;
        r101 = (IRoom) r100.get("data_room", null);
    L6:
        return b(r101);
    }
}
