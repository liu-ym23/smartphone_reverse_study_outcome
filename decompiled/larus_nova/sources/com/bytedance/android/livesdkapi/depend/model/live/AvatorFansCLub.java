package com.bytedance.android.livesdkapi.depend.model.live;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/AvatorFansCLub;", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/IAvatorFansCLub;", "style", "", "(Ljava/lang/String;II)V", "getStyle", "()I", "AvatorFansCLubOpen", "AvatorFansCLubMediaClose", "AvatorFansCLubOfficialChannel", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum AvatorFansCLub extends Enum<AvatorFansCLub> implements IAvatorFansCLub {
    private static final /* synthetic */ AvatorFansCLub[] $VALUES = null;
    public static final AvatorFansCLub AvatorFansCLubMediaClose = null;
    public static final AvatorFansCLub AvatorFansCLubOfficialChannel = null;
    public static final AvatorFansCLub AvatorFansCLubOpen = null;
    private final int style;

    static {
        AvatorFansCLub r100 = new AvatorFansCLub("AvatorFansCLubOpen", 0, 0);
        AvatorFansCLubOpen = r100;
        AvatorFansCLub r101 = new AvatorFansCLub("AvatorFansCLubMediaClose", 1, 1);
        AvatorFansCLubMediaClose = r101;
        AvatorFansCLub r102 = new AvatorFansCLub("AvatorFansCLubOfficialChannel", 2, 2);
        AvatorFansCLubOfficialChannel = r102;
        $VALUES = new AvatorFansCLub[]{r100, r101, r102};
    }

    public static AvatorFansCLub valueOf(String r100) {
        return (AvatorFansCLub) a.a(AvatorFansCLub.class, r100);
    }

    public static AvatorFansCLub[] values() {
        return (AvatorFansCLub[]) $VALUES.clone();
    }

    public final int getStyle() {
        return this.style;
    }

    private AvatorFansCLub(String r100, int r101, int r102) {
        super(r100, r101);
        this.style = r102;
    }
}
