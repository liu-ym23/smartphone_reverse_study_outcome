package com.bytedance.android.live.revenue.platform.hybrid.api.shareview;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/revenue/platform/hybrid/api/shareview/LoadFailCode;", "", "", "code", "I", "getCode", "()I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Unknown", "CompLoadFailed", "SharerCreateFailed", "SharerNotSupported", "SharerReleased", "live-kmp-platform-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum LoadFailCode extends Enum<LoadFailCode> {
    public static final LoadFailCode CompLoadFailed = null;
    public static final a Companion = null;
    public static final LoadFailCode SharerCreateFailed = null;
    public static final LoadFailCode SharerNotSupported = null;
    public static final LoadFailCode SharerReleased = null;
    public static final LoadFailCode Unknown = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LoadFailCode[] f91378a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<Integer, LoadFailCode> f91379b = null;
    private final int code;

    public static final class a {
        public a() {
        }
    }

    static {
        int r100 = 0;
        LoadFailCode r101 = new LoadFailCode("Unknown", 0, 0);
        Unknown = r101;
        LoadFailCode r102 = new LoadFailCode("CompLoadFailed", 1, 1);
        CompLoadFailed = r102;
        LoadFailCode r103 = new LoadFailCode("SharerCreateFailed", 2, 2);
        SharerCreateFailed = r103;
        LoadFailCode r104 = new LoadFailCode("SharerNotSupported", 3, 3);
        SharerNotSupported = r104;
        LoadFailCode r105 = new LoadFailCode("SharerReleased", 4, 4);
        SharerReleased = r105;
        f91378a = new LoadFailCode[]{r101, r102, r103, r104, r105};
        Companion = new a();
        LoadFailCode[] r106 = values();
        LinkedHashMap r107 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(r106.length), 16));
        int r108 = r106.length;
    L3:
        if (r100 >= r108) goto L5;
        LoadFailCode r109 = r106[r100];
        r107.put(Integer.valueOf(r109.code), r109);
        r100 = r100 + 1;
        goto L3
    L5:
        f91379b = r107;
    }

    public static LoadFailCode valueOf(String r100) {
        return (LoadFailCode) r27.a.a(LoadFailCode.class, r100);
    }

    public static LoadFailCode[] values() {
        return (LoadFailCode[]) f91378a.clone();
    }

    public static final /* synthetic */ Map access$getMap$cp() {
        return f91379b;
    }

    public final int getCode() {
        return this.code;
    }

    public LoadFailCode(String r100, int r101, int r102) {
        super(r100, r101);
        this.code = r102;
    }
}
