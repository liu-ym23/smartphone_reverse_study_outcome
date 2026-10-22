package jb;

import com.obric.common.oea.foundation.animation.constants.RepeatMode;
import com.obric.common.oea.foundation.animation.constants.RunMode;

/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f20955a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f20956b = null;

    static {
        int[] r10 = new int[RunMode.values().length];
        f20955a = r10;
        r10[RunMode.PARALLEL.ordinal()] = 1;
        r10[RunMode.SERIAL.ordinal()] = 2;
        int[] r11 = new int[RepeatMode.values().length];
        f20956b = r11;
        r11[RepeatMode.LOOP.ordinal()] = 1;
        r11[RepeatMode.REVERSE.ordinal()] = 2;
        r11[RepeatMode.NORMAL.ordinal()] = 3;
    }
}
