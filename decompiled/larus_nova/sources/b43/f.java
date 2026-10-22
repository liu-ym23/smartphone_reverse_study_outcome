package b43;

import com.bytedance.android.shopping.abscontainer.arch.core.data.RefreshProtocolSource;

/* JADX INFO: loaded from: classes12.dex */
public final /* synthetic */ class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f17510a = null;

    static {
        int[] r100 = new int[RefreshProtocolSource.values().length];
        f17510a = r100;
        r100[RefreshProtocolSource.ADJUST.ordinal()] = 1;
        r100[RefreshProtocolSource.QUERY.ordinal()] = 2;
        r100[RefreshProtocolSource.UPDATE.ordinal()] = 3;
        r100[RefreshProtocolSource.PATCH.ordinal()] = 4;
    }
}
