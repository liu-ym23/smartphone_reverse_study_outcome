package com.bytedance.android.livehostapi.business.depend.share;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/share/ShareScreenOrientation;", "", "status", "", "(Ljava/lang/String;II)V", "getStatus", "()I", "unknown", "Landscape", "Portrait", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ShareScreenOrientation extends Enum<ShareScreenOrientation> {
    private static final /* synthetic */ ShareScreenOrientation[] $VALUES = null;
    public static final ShareScreenOrientation Landscape = null;
    public static final ShareScreenOrientation Portrait = null;
    public static final ShareScreenOrientation unknown = null;
    private final int status;

    static {
        ShareScreenOrientation r100 = new ShareScreenOrientation("unknown", 0, 0);
        unknown = r100;
        ShareScreenOrientation r101 = new ShareScreenOrientation("Landscape", 1, 1);
        Landscape = r101;
        ShareScreenOrientation r102 = new ShareScreenOrientation("Portrait", 2, 2);
        Portrait = r102;
        $VALUES = new ShareScreenOrientation[]{r100, r101, r102};
    }

    public static ShareScreenOrientation valueOf(String r100) {
        return (ShareScreenOrientation) a.a(ShareScreenOrientation.class, r100);
    }

    public static ShareScreenOrientation[] values() {
        return (ShareScreenOrientation[]) $VALUES.clone();
    }

    public final int getStatus() {
        return this.status;
    }

    private ShareScreenOrientation(String r100, int r101, int r102) {
        super(r100, r101);
        this.status = r102;
    }
}
