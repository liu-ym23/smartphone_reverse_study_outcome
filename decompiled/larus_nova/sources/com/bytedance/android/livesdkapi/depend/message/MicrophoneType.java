package com.bytedance.android.livesdkapi.depend.message;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/message/MicrophoneType;", "", "(Ljava/lang/String;I)V", "Unknown", "Silver", "Golden", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum MicrophoneType extends Enum<MicrophoneType> {
    private static final /* synthetic */ MicrophoneType[] $VALUES = null;
    public static final MicrophoneType Golden = null;
    public static final MicrophoneType Silver = null;
    public static final MicrophoneType Unknown = null;

    static {
        MicrophoneType r100 = new MicrophoneType("Unknown", 0);
        Unknown = r100;
        MicrophoneType r101 = new MicrophoneType("Silver", 1);
        Silver = r101;
        MicrophoneType r102 = new MicrophoneType("Golden", 2);
        Golden = r102;
        $VALUES = new MicrophoneType[]{r100, r101, r102};
    }

    public static MicrophoneType valueOf(String r100) {
        return (MicrophoneType) a.a(MicrophoneType.class, r100);
    }

    public static MicrophoneType[] values() {
        return (MicrophoneType[]) $VALUES.clone();
    }

    private MicrophoneType(String r100, int r101) {
        super(r100, r101);
    }
}
