package com.bytedance.android.livesdk.ktvapi.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/ktvapi/model/VideoChorusSource;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "UNKNOWN", "LINK_ICON", "PK_ICON", "livektv-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum VideoChorusSource extends Enum<VideoChorusSource> {
    public static final VideoChorusSource LINK_ICON = null;
    public static final VideoChorusSource PK_ICON = null;
    public static final VideoChorusSource UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VideoChorusSource[] f142326a = null;
    private final String value;

    static {
        VideoChorusSource r100 = new VideoChorusSource("UNKNOWN", 0, "unknown");
        UNKNOWN = r100;
        VideoChorusSource r101 = new VideoChorusSource("LINK_ICON", 1, "link_icon");
        LINK_ICON = r101;
        VideoChorusSource r102 = new VideoChorusSource("PK_ICON", 2, "pk_icon");
        PK_ICON = r102;
        f142326a = new VideoChorusSource[]{r100, r101, r102};
    }

    public static VideoChorusSource valueOf(String r100) {
        return (VideoChorusSource) a.a(VideoChorusSource.class, r100);
    }

    public static VideoChorusSource[] values() {
        return (VideoChorusSource[]) f142326a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public VideoChorusSource(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
