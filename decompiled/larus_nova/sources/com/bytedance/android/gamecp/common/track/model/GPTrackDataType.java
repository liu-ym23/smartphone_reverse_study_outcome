package com.bytedance.android.gamecp.common.track.model;

import com.ss.android.cert.manager.constants.EventConstant;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H\u0016R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/gamecp/common/track/model/GPTrackDataType;", "", "", "", "getIntValue", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "PAGE", "MODULE", "Result", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum GPTrackDataType extends Enum<GPTrackDataType> {
    public static final GPTrackDataType MODULE = null;
    public static final GPTrackDataType PAGE = null;
    public static final GPTrackDataType Result = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GPTrackDataType[] f56808a = null;
    private final String value;

    static {
        GPTrackDataType r100 = new GPTrackDataType("PAGE", 0, "page");
        PAGE = r100;
        GPTrackDataType r101 = new GPTrackDataType("MODULE", 1, EventConstant.Key.MODULE);
        MODULE = r101;
        GPTrackDataType r102 = new GPTrackDataType("Result", 2, "result");
        Result = r102;
        f56808a = new GPTrackDataType[]{r100, r101, r102};
    }

    public static GPTrackDataType valueOf(String r100) {
        return (GPTrackDataType) a.a(GPTrackDataType.class, r100);
    }

    public static GPTrackDataType[] values() {
        return (GPTrackDataType[]) f56808a.clone();
    }

    public int getIntValue() {
        if (this != PAGE) goto L7;
        return 0;
    L7:
        if (this != MODULE) goto L10;
        return 1;
    L10:
        return 2;
    }

    public final String getValue() {
        return this.value;
    }

    public GPTrackDataType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
