package bt2;

import com.bytedance.android.livesdk.room.state.LiveSdkState;

/* JADX INFO: loaded from: classes11.dex */
public final /* synthetic */ class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f20528a = null;

    static {
        int[] r100 = new int[LiveSdkState.values().length];
        f20528a = r100;
        r100[LiveSdkState.SDK_START_LOAD.ordinal()] = 1;
        r100[LiveSdkState.SDK_START_LOAD_FINISH.ordinal()] = 2;
        r100[LiveSdkState.SDK_UN_INSTALL.ordinal()] = 3;
    }
}
