package ci7;

import com.bytedance.ug.sdk.deeplink.SchemeType;

/* JADX INFO: loaded from: classes22.dex */
public final /* synthetic */ class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f23892a = null;

    static {
        int[] r100 = new int[SchemeType.values().length];
        f23892a = r100;
        r100[SchemeType.ALL.ordinal()] = 1;
        r100[SchemeType.APP_LINK.ordinal()] = 2;
        r100[SchemeType.SINGLE_SCHEME.ordinal()] = 3;
        r100[SchemeType.MULTI_SCHEME.ordinal()] = 4;
    }
}
