package com.bytedance.android.livesdk.landscapeslide;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/landscapeslide/MatchMode;", "", "REGEX", "EQUALS", "liveroom-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum MatchMode extends Enum<MatchMode> {
    public static final MatchMode EQUALS = null;
    public static final MatchMode REGEX = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MatchMode[] f147004a = null;

    static {
        MatchMode r100 = new MatchMode("REGEX", 0);
        REGEX = r100;
        MatchMode r101 = new MatchMode("EQUALS", 1);
        EQUALS = r101;
        f147004a = new MatchMode[]{r100, r101};
    }

    public static MatchMode valueOf(String r100) {
        return (MatchMode) r27.a.a(MatchMode.class, r100);
    }

    public static MatchMode[] values() {
        return (MatchMode[]) f147004a.clone();
    }

    public MatchMode(String r100, int r101) {
        super(r100, r101);
    }
}
