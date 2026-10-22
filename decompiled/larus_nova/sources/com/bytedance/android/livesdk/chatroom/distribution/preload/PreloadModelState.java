package com.bytedance.android.livesdk.chatroom.distribution.preload;

import com.android.ttcjpaysdk.base.h5.cjjsb.constant.ErrorCode;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/distribution/preload/PreloadModelState;", "", ErrorCode.INIT, "PENDING_ADD", "PENDING_REMOVE", "ADDED", "livesdkshell_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PreloadModelState extends Enum<PreloadModelState> {
    public static final PreloadModelState ADDED = null;
    public static final PreloadModelState INIT = null;
    public static final PreloadModelState PENDING_ADD = null;
    public static final PreloadModelState PENDING_REMOVE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PreloadModelState[] f105813a = null;

    static {
        PreloadModelState r100 = new PreloadModelState(ErrorCode.INIT, 0);
        INIT = r100;
        PreloadModelState r101 = new PreloadModelState("PENDING_ADD", 1);
        PENDING_ADD = r101;
        PreloadModelState r102 = new PreloadModelState("PENDING_REMOVE", 2);
        PENDING_REMOVE = r102;
        PreloadModelState r103 = new PreloadModelState("ADDED", 3);
        ADDED = r103;
        f105813a = new PreloadModelState[]{r100, r101, r102, r103};
    }

    public static PreloadModelState valueOf(String r100) {
        return (PreloadModelState) a.a(PreloadModelState.class, r100);
    }

    public static PreloadModelState[] values() {
        return (PreloadModelState[]) f105813a.clone();
    }

    public PreloadModelState(String r100, int r101) {
        super(r100, r101);
    }
}
