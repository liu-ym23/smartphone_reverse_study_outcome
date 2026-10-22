package com.bytedance.android.livesdkapi.roomplayer;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdkapi/roomplayer/LiveStreamInfo;", "", "streamData", "", "legacyUrl", "resolution", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getLegacyUrl", "()Ljava/lang/String;", "getResolution", "getStreamData", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveStreamInfo {
    private final String legacyUrl;
    private final String resolution;
    private final String streamData;

    public LiveStreamInfo() {
        this(null, null, null, 7, null);
    }

    public final String getLegacyUrl() {
        return this.legacyUrl;
    }

    public final String getResolution() {
        return this.resolution;
    }

    public final String getStreamData() {
        return this.streamData;
    }

    public LiveStreamInfo(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "streamData");
        Intrinsics.checkNotNullParameter(r101, "legacyUrl");
        Intrinsics.checkNotNullParameter(r102, "resolution");
        this.streamData = r100;
        this.legacyUrl = r101;
        this.resolution = r102;
    }

    public /* synthetic */ LiveStreamInfo(String r100, String r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = "";
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = "";
    L11:
        this(r100, r101, r102);
    }
}
