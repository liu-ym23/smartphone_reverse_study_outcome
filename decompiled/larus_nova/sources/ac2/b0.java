package ac2;

import com.bytedance.android.livesdkapi.ws.LiveWsConnectState;

/* JADX INFO: loaded from: classes9.dex */
public final /* synthetic */ class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f2567a = null;

    static {
        int[] r100 = new int[LiveWsConnectState.values().length];
        f2567a = r100;
        r100[LiveWsConnectState.CONNECTED.ordinal()] = 1;
        r100[LiveWsConnectState.CONNECT_CLOSED.ordinal()] = 2;
        r100[LiveWsConnectState.CONNECT_FAILED.ordinal()] = 3;
    }
}
