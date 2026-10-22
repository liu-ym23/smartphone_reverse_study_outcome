package com.bytedance.android.gamecp.business.gamedetail.base.model;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/base/model/VideoRotation;", "", "", "value", "I", "getValue", "()I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Vertical", "Horizontal", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum VideoRotation extends Enum<VideoRotation> {
    public static final a Companion = null;
    public static final VideoRotation Horizontal = null;
    public static final VideoRotation Vertical = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VideoRotation[] f53480a = null;
    private final int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.gamecp.business.gamedetail.base.model.VideoRotation$a] */
    static {
        VideoRotation r100 = new VideoRotation("Vertical", 0, 0);
        Vertical = r100;
        VideoRotation r101 = new VideoRotation("Horizontal", 1, 1);
        Horizontal = r101;
        f53480a = new VideoRotation[]{r100, r101};
        Companion = new a();
    }

    public static VideoRotation valueOf(String r100) {
        return (VideoRotation) r27.a.a(VideoRotation.class, r100);
    }

    public static VideoRotation[] values() {
        return (VideoRotation[]) f53480a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public VideoRotation(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
