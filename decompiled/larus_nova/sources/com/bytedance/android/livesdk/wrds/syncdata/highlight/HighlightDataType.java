package com.bytedance.android.livesdk.wrds.syncdata.highlight;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/wrds/syncdata/highlight/HighlightDataType;", "", "", "dataType", "I", "getDataType", "()I", "Unknown", "CommonText", "Appointment", "Answer", "Comment", "Video", "MicroApp", "Im", "CommonPictureText", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum HighlightDataType extends Enum<HighlightDataType> {
    public static final HighlightDataType Answer = null;
    public static final HighlightDataType Appointment = null;
    public static final HighlightDataType Comment = null;
    public static final HighlightDataType CommonPictureText = null;
    public static final HighlightDataType CommonText = null;
    public static final HighlightDataType Im = null;
    public static final HighlightDataType MicroApp = null;
    public static final HighlightDataType Unknown = null;
    public static final HighlightDataType Video = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ HighlightDataType[] f162525a = null;
    private final int dataType;

    public static HighlightDataType valueOf(String r100) {
        return (HighlightDataType) r27.a.a(HighlightDataType.class, r100);
    }

    public static HighlightDataType[] values() {
        return (HighlightDataType[]) f162525a.clone();
    }

    static {
        HighlightDataType r100 = new HighlightDataType("Unknown", 0, 0);
        Unknown = r100;
        HighlightDataType r101 = new HighlightDataType("CommonText", 1, 1);
        CommonText = r101;
        HighlightDataType r102 = new HighlightDataType("Appointment", 2, 2);
        Appointment = r102;
        HighlightDataType r103 = new HighlightDataType("Answer", 3, 3);
        Answer = r103;
        HighlightDataType r104 = new HighlightDataType("Comment", 4, 4);
        Comment = r104;
        HighlightDataType r105 = new HighlightDataType("Video", 5, 5);
        Video = r105;
        HighlightDataType r106 = new HighlightDataType("MicroApp", 6, 6);
        MicroApp = r106;
        HighlightDataType r107 = new HighlightDataType("Im", 7, 7);
        Im = r107;
        HighlightDataType r108 = new HighlightDataType("CommonPictureText", 8, 8);
        CommonPictureText = r108;
        f162525a = new HighlightDataType[]{r100, r101, r102, r103, r104, r105, r106, r107, r108};
    }

    public final int getDataType() {
        return this.dataType;
    }

    public HighlightDataType(String r100, int r101, int r102) {
        super(r100, r101);
        this.dataType = r102;
    }
}
