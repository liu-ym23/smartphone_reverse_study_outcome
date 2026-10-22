package com.bytedance.android.live.network.impl.utils;

import android.graphics.BitmapFactory;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.network.api.INetworkService;
import com.bytedance.common.utility.Logger;
import io.reactivex.functions.Function;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class e<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f83927a;

    public e(String r100) {
        this.f83927a = r100;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        Intrinsics.checkNotNullParameter((Integer) r100, "it");
        return BitmapFactory.decodeStream(new ByteArrayInputStream(((INetworkService) jc1.k.n(INetworkService.class)).downloadFile(false, Integer.MAX_VALUE, this.f83927a, new ArrayList(), null).execute().getBody()));
    L5:
        e = move-exception;
        ALogger.stacktrace(6, "NinePatchUtil", e.getStackTrace());
        Logger.e("NinePatchUtil", e.getMessage());
        return null;
    }
}
