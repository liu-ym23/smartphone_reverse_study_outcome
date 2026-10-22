package com.byted.cast.mediacommon.render;

import r27.a;

/* JADX INFO: loaded from: classes39.dex */
public final enum MediaRenderState extends Enum<MediaRenderState> {
    private static final /* synthetic */ MediaRenderState[] $VALUES = null;
    public static final MediaRenderState STATE_EXECUTING = null;
    public static final MediaRenderState STATE_UNINITIALIZED = null;

    static {
        MediaRenderState r100 = new MediaRenderState("STATE_UNINITIALIZED", 0);
        STATE_UNINITIALIZED = r100;
        MediaRenderState r101 = new MediaRenderState("STATE_EXECUTING", 1);
        STATE_EXECUTING = r101;
        $VALUES = new MediaRenderState[]{r100, r101};
    }

    public static MediaRenderState[] values() {
        return (MediaRenderState[]) $VALUES.clone();
    }

    public static MediaRenderState valueOf(String r100) {
        return (MediaRenderState) a.a(MediaRenderState.class, r100);
    }

    private MediaRenderState(String r100, int r101) {
        super(r100, r101);
    }
}
