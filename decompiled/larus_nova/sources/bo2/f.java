package bo2;

import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;

/* JADX INFO: loaded from: classes11.dex */
public final /* synthetic */ class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f19793a = null;

    static {
        int[] r100 = new int[LiveMode.values().length];
        f19793a = r100;
        r100[LiveMode.VIDEO.ordinal()] = 1;
        r100[LiveMode.SCREEN_RECORD.ordinal()] = 2;
        r100[LiveMode.THIRD_PARTY.ordinal()] = 3;
        r100[LiveMode.AUDIO.ordinal()] = 4;
        r100[LiveMode.MEDIA.ordinal()] = 5;
    }
}
