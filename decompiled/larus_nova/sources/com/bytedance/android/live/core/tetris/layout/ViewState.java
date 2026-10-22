package com.bytedance.android.live.core.tetris.layout;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/core/tetris/layout/ViewState;", "", "UN_CREATED", "CREATING", "CREATED", "USING", "tetris_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ViewState extends Enum<ViewState> {
    public static final ViewState CREATED = null;
    public static final ViewState CREATING = null;
    public static final ViewState UN_CREATED = null;
    public static final ViewState USING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ViewState[] f65898a = null;

    static {
        ViewState r100 = new ViewState("UN_CREATED", 0);
        UN_CREATED = r100;
        ViewState r101 = new ViewState("CREATING", 1);
        CREATING = r101;
        ViewState r102 = new ViewState("CREATED", 2);
        CREATED = r102;
        ViewState r103 = new ViewState("USING", 3);
        USING = r103;
        f65898a = new ViewState[]{r100, r101, r102, r103};
    }

    public static ViewState valueOf(String r100) {
        return (ViewState) a.a(ViewState.class, r100);
    }

    public static ViewState[] values() {
        return (ViewState[]) f65898a.clone();
    }

    public ViewState(String r100, int r101) {
        super(r100, r101);
    }
}
