package com.bytedance.android.livesdk.live.listprovider;

import com.bytedance.android.livesdk.utils.personalfeed.PersonalizedFeedUtils;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Object> f147572a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Disposable> f147573b = null;

    static {
        f147572a = new ConcurrentHashMap();
        f147573b = new ConcurrentHashMap();
    }

    public static void a(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "enterFromMerge");
        if (PersonalizedFeedUtils.c() == true) goto L5;
        return;
    L5:
        if (PersonalizedFeedUtils.b().a() == false) goto L13;
        String r102 = r100 + '_' + r101;
        f147572a.remove(r102);
        Disposable r103 = f147573b.remove(r102);
        if (r103 == null) goto L12;
        r103.dispose();
        return;
    L12:
        return;
    }
}
