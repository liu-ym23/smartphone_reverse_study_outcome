package com.bytedance.android.livesdk.dispatch.utils;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.livesdk.schema.interfaces.IBaseCallbackSchemaHandler;
import com.bytedance.android.livesdk.schema.interfaces.ILiveActionHandler;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f122282a = 0;

    static {
    }

    public static void a(Context r100, String r101, String r102, IBaseCallbackSchemaHandler.SchemaCallback r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "path");
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r103, "outerCallback");
        ILiveActionHandler r104 = ((IRoomService) k.n(IRoomService.class)).actionHandler();
        Uri r105 = UriProtector.parse("sslocal://webcast_dispatch/" + r101 + '?' + r102);
        Intrinsics.checkNotNullParameter(r101, "path");
        r104.handle(r100, r105, new e(r103, r101));
    }
}
