package xb;

import com.obric.common.oea.style.scene.transition.TransitionAnimStyle;

/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f25857a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f25858b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int[] f25859c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int[] f25860d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int[] f25861e = null;

    static {
        int[] r10 = new int[TransitionAnimStyle.values().length];
        f25857a = r10;
        TransitionAnimStyle r11 = TransitionAnimStyle.SubpageInOut;
        r10[r11.ordinal()] = 1;
        TransitionAnimStyle r12 = TransitionAnimStyle.SettingsInOut;
        r10[r12.ordinal()] = 2;
        int[] r13 = new int[TransitionAnimStyle.values().length];
        f25858b = r13;
        TransitionAnimStyle r14 = TransitionAnimStyle.Standard;
        r13[r14.ordinal()] = 1;
        TransitionAnimStyle r15 = TransitionAnimStyle.Modal;
        r13[r15.ordinal()] = 2;
        TransitionAnimStyle r16 = TransitionAnimStyle.Search;
        r13[r16.ordinal()] = 3;
        int[] r17 = new int[TransitionAnimStyle.values().length];
        f25859c = r17;
        r17[r11.ordinal()] = 1;
        r17[r12.ordinal()] = 2;
        int[] r18 = new int[TransitionAnimStyle.values().length];
        f25860d = r18;
        r18[r14.ordinal()] = 1;
        r18[r15.ordinal()] = 2;
        r18[r16.ordinal()] = 3;
        int[] r19 = new int[TransitionAnimStyle.values().length];
        f25861e = r19;
        r19[r14.ordinal()] = 1;
        r19[r15.ordinal()] = 2;
        r19[r16.ordinal()] = 3;
    }
}
