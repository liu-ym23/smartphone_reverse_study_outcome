package com.bytedance.android.livesdkapi.depend.model.live.roomchannel;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00042\b\b\u0002\u0010\u0019\u001a\u00020\nJ\u0016\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0004R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\f\"\u0004\b\u0013\u0010\u000eR\u001a\u0010\u0014\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\f\"\u0004\b\u0015\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/roomchannel/PreviewCleanScreenUtils;", "", "()V", "enterRoomId", "", "getEnterRoomId", "()J", "setEnterRoomId", "(J)V", "ignoreExitBtnAnimFrequencyLimit", "", "getIgnoreExitBtnAnimFrequencyLimit", "()Z", "setIgnoreExitBtnAnimFrequencyLimit", "(Z)V", "initHashCode", "getInitHashCode", "setInitHashCode", "isPreviewCleanScreenEnter", "setPreviewCleanScreenEnter", "isPreviewLandscapeEnterForVS", "setPreviewLandscapeEnterForVS", "clear", "", "hashCode", "isPageSelect", "init", "enterRoom", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PreviewCleanScreenUtils {
    public static final PreviewCleanScreenUtils INSTANCE = null;
    private static long enterRoomId;
    private static boolean ignoreExitBtnAnimFrequencyLimit;
    private static long initHashCode;
    private static volatile boolean isPreviewCleanScreenEnter;
    private static boolean isPreviewLandscapeEnterForVS;

    private PreviewCleanScreenUtils() {
    }

    static {
        INSTANCE = new PreviewCleanScreenUtils();
    }

    public final long getEnterRoomId() {
        return enterRoomId;
    }

    public final boolean getIgnoreExitBtnAnimFrequencyLimit() {
        return ignoreExitBtnAnimFrequencyLimit;
    }

    public final long getInitHashCode() {
        return initHashCode;
    }

    public final boolean isPreviewCleanScreenEnter() {
        return isPreviewCleanScreenEnter;
    }

    public final boolean isPreviewLandscapeEnterForVS() {
        return isPreviewLandscapeEnterForVS;
    }

    public final void setEnterRoomId(long r100) {
        enterRoomId = r100;
    }

    public final void setIgnoreExitBtnAnimFrequencyLimit(boolean r100) {
        ignoreExitBtnAnimFrequencyLimit = r100;
    }

    public final void setInitHashCode(long r100) {
        initHashCode = r100;
    }

    public final void setPreviewCleanScreenEnter(boolean r100) {
        isPreviewCleanScreenEnter = r100;
    }

    public final void setPreviewLandscapeEnterForVS(boolean r100) {
        isPreviewLandscapeEnterForVS = r100;
    }

    public final void clear(long r100, boolean r101) {
        if (r100 != initHashCode) goto L5;
    L6:
        isPreviewCleanScreenEnter = false;
        initHashCode = 0;
        enterRoomId = 0;
        if (r101 == true) goto L11;
        isPreviewLandscapeEnterForVS = false;
        return;
    L11:
        return;
    L5:
        if (r100 == 0) goto L6;
    }

    public final void init(long r100, long r101) {
        isPreviewCleanScreenEnter = true;
        initHashCode = r100;
        enterRoomId = r101;
        isPreviewLandscapeEnterForVS = true;
    }

    public static /* synthetic */ void clear$default(PreviewCleanScreenUtils r100, long r101, boolean r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L5;
        r102 = false;
    L5:
        r100.clear(r101, r102);
    }
}
