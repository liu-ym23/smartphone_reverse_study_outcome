package com.bytedance.android.livesdkapi.depend.model.live.episode;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/episode/VSCameraType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "CAMERA_TYPE_UNKNOWN", "CAMERA_TYPE_EXPLICATION", "CAMERA_TYPE_MATCH", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum VSCameraType extends Enum<VSCameraType> {
    private static final /* synthetic */ VSCameraType[] $VALUES = null;
    public static final VSCameraType CAMERA_TYPE_EXPLICATION = null;
    public static final VSCameraType CAMERA_TYPE_MATCH = null;
    public static final VSCameraType CAMERA_TYPE_UNKNOWN = null;
    private final int value;

    static {
        VSCameraType r100 = new VSCameraType("CAMERA_TYPE_UNKNOWN", 0, 0);
        CAMERA_TYPE_UNKNOWN = r100;
        VSCameraType r101 = new VSCameraType("CAMERA_TYPE_EXPLICATION", 1, 1);
        CAMERA_TYPE_EXPLICATION = r101;
        VSCameraType r102 = new VSCameraType("CAMERA_TYPE_MATCH", 2, 2);
        CAMERA_TYPE_MATCH = r102;
        $VALUES = new VSCameraType[]{r100, r101, r102};
    }

    public static VSCameraType valueOf(String r100) {
        return (VSCameraType) a.a(VSCameraType.class, r100);
    }

    public static VSCameraType[] values() {
        return (VSCameraType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    private VSCameraType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
