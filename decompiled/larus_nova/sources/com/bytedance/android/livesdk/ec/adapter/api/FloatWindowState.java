package com.bytedance.android.livesdk.ec.adapter.api;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/ec/adapter/api/FloatWindowState;", "", "OPEN", "STOP", "ec-adapter-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum FloatWindowState extends Enum<FloatWindowState> {
    public static final FloatWindowState OPEN = null;
    public static final FloatWindowState STOP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FloatWindowState[] f123293a = null;

    static {
        FloatWindowState r100 = new FloatWindowState("OPEN", 0);
        OPEN = r100;
        FloatWindowState r101 = new FloatWindowState("STOP", 1);
        STOP = r101;
        f123293a = new FloatWindowState[]{r100, r101};
    }

    public static FloatWindowState valueOf(String r100) {
        return (FloatWindowState) a.a(FloatWindowState.class, r100);
    }

    public static FloatWindowState[] values() {
        return (FloatWindowState[]) f123293a.clone();
    }

    public FloatWindowState(String r100, int r101) {
        super(r100, r101);
    }
}
