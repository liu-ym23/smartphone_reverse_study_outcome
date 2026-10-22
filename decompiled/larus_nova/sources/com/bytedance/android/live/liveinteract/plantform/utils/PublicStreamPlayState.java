package com.bytedance.android.live.liveinteract.plantform.utils;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\u0006\u0010\u0003\u001a\u00020\u0002j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/utils/PublicStreamPlayState;", "", "", "usingMcu", "None", "Pulling", "Playing", "Fallback", "End", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum PublicStreamPlayState extends Enum<PublicStreamPlayState> {
    public static final PublicStreamPlayState End = null;
    public static final PublicStreamPlayState Fallback = null;
    public static final PublicStreamPlayState None = null;
    public static final PublicStreamPlayState Playing = null;
    public static final PublicStreamPlayState Pulling = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PublicStreamPlayState[] f77432a = null;

    static {
        PublicStreamPlayState r100 = new PublicStreamPlayState("None", 0);
        None = r100;
        PublicStreamPlayState r101 = new PublicStreamPlayState("Pulling", 1);
        Pulling = r101;
        PublicStreamPlayState r102 = new PublicStreamPlayState("Playing", 2);
        Playing = r102;
        PublicStreamPlayState r103 = new PublicStreamPlayState("Fallback", 3);
        Fallback = r103;
        PublicStreamPlayState r104 = new PublicStreamPlayState("End", 4);
        End = r104;
        f77432a = new PublicStreamPlayState[]{r100, r101, r102, r103, r104};
    }

    public static PublicStreamPlayState valueOf(String r100) {
        return (PublicStreamPlayState) r27.a.a(PublicStreamPlayState.class, r100);
    }

    public static PublicStreamPlayState[] values() {
        return (PublicStreamPlayState[]) f77432a.clone();
    }

    public final boolean usingMcu() {
        if (this != Playing) goto L5;
        return true;
    L5:
        return false;
    }

    public PublicStreamPlayState(String r100, int r101) {
        super(r100, r101);
    }
}
