package com.bytedance.android.gamecp.common.network.preload;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/gamecp/common/network/preload/PreloadState;", "", "", "value", "I", "getValue", "()I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "UNKNOWN", "RUNNING", "FINISH", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PreloadState extends Enum<PreloadState> {
    public static final a Companion = null;
    public static final PreloadState FINISH = null;
    public static final PreloadState RUNNING = null;
    public static final PreloadState UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PreloadState[] f56707a = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    static {
        PreloadState r100 = new PreloadState("UNKNOWN", 0, -1);
        UNKNOWN = r100;
        PreloadState r101 = new PreloadState("RUNNING", 1, 0);
        RUNNING = r101;
        PreloadState r102 = new PreloadState("FINISH", 2, 1);
        FINISH = r102;
        f56707a = new PreloadState[]{r100, r101, r102};
        Companion = new a();
    }

    public static PreloadState valueOf(String r100) {
        return (PreloadState) r27.a.a(PreloadState.class, r100);
    }

    public static PreloadState[] values() {
        return (PreloadState[]) f56707a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public PreloadState(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
