package com.bytedance.android.live.liveinteract.videotalk.avatarmix.bitmap;

import android.graphics.Bitmap;
import com.bytedance.android.live.liveinteract.videotalk.avatarmix.MicseatType;
import com.bytedance.android.live.liveinteract.videotalk.avatarmix.d;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f79071b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, Pair<String, Bitmap>> f79072a;

    /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.videotalk.avatarmix.bitmap.a$a, reason: collision with other inner class name */
    public static final class C1233a {
        public static String a(d r100) {
            Intrinsics.checkNotNullParameter(r100, "struct");
            if (r100.getType() != MicseatType.Empty) goto L6;
            return "e_" + r100.f79078d.f546164f + '_' + r100.f79078d.f546165g;
        L6:
            return r100.f79075a + '_' + r100.f79078d.f546164f + '_' + r100.f79078d.f546165g;
        }
    }

    static {
    }

    public a() {
        this.f79072a = new ConcurrentHashMap();
    }
}
