package al6;

import com.bytedance.livesdk.ktvcommon.midi.model.HitType;

/* JADX INFO: loaded from: classes20.dex */
public final /* synthetic */ class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f4139a = null;

    static {
        int[] r100 = new int[HitType.values().length];
        f4139a = r100;
        r100[HitType.GOOD.ordinal()] = 1;
        r100[HitType.GREAT.ordinal()] = 2;
        r100[HitType.PERFECT.ordinal()] = 3;
    }
}
