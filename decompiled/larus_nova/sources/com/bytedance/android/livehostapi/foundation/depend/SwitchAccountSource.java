package com.bytedance.android.livehostapi.foundation.depend;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livehostapi/foundation/depend/SwitchAccountSource;", "", "source", "", "(Ljava/lang/String;ILjava/lang/String;)V", "SOURCE_MORE_PANEL", "SOURCE_PERSONAL_CENTER", "hostapp-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum SwitchAccountSource extends Enum<SwitchAccountSource> {
    private static final /* synthetic */ SwitchAccountSource[] $VALUES = null;
    public static final SwitchAccountSource SOURCE_MORE_PANEL = null;
    public static final SwitchAccountSource SOURCE_PERSONAL_CENTER = null;

    static {
        SwitchAccountSource r100 = new SwitchAccountSource("SOURCE_MORE_PANEL", 0, "live_more_function_panel");
        SOURCE_MORE_PANEL = r100;
        SwitchAccountSource r101 = new SwitchAccountSource("SOURCE_PERSONAL_CENTER", 1, "live_personal_center");
        SOURCE_PERSONAL_CENTER = r101;
        $VALUES = new SwitchAccountSource[]{r100, r101};
    }

    public static SwitchAccountSource valueOf(String r100) {
        return (SwitchAccountSource) r27.a.a(SwitchAccountSource.class, r100);
    }

    public static SwitchAccountSource[] values() {
        return (SwitchAccountSource[]) $VALUES.clone();
    }

    private SwitchAccountSource(String r100, int r101, String r102) {
        super(r100, r101);
    }
}
