package com.bytedance.android.live.openplatform.impl.minigamecommon.utils;

import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdkapi.hybridapi.SubscriberJsEvent;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import jc1.k;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class MiniGameLiveJsBridgeUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f85366a = 0;

    static {
    }

    public static HashMap b(SubscriberJsEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "jsEvent");
        HashMap r101 = new HashMap();
        Map<String, Object> r102 = r100.getParams();
        if (r102 == null) goto L8;
        Iterator<Map.Entry<String, Object>> r103 = r102.entrySet().iterator();
    L6:
        if (r103.hasNext() == false) goto L8;
        Map.Entry<String, Object> r104 = r103.next();
        r101.put(r104.getKey(), String.valueOf(r104.getValue()));
    L8:
        return r101;
    }

    public static Disposable a(final String r100, final Function1 r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "executable");
        return RxUtilKt.n(((IBrowserService) k.n(IBrowserService.class)).registerJsEventSubscriber(r100).observeOn(AndroidSchedulers.mainThread()), new MiniGameLiveJsBridgeUtils$addPublishEventJsbListener$1(r100, r101));
    }
}
