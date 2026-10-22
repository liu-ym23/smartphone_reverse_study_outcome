package com.bytedance.android.livesdk.slideuptip;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/slideuptip/SlideUpTipsTriggerSource;", "", "RESUME_TRIGGER", "STRATEGY_TRIGGER", "USER_CLOSE", "SLIDE_UP_V1", "XT_SLIDE_UP", "LOAD_MORE", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum SlideUpTipsTriggerSource extends Enum<SlideUpTipsTriggerSource> {
    public static final SlideUpTipsTriggerSource LOAD_MORE = null;
    public static final SlideUpTipsTriggerSource RESUME_TRIGGER = null;
    public static final SlideUpTipsTriggerSource SLIDE_UP_V1 = null;
    public static final SlideUpTipsTriggerSource STRATEGY_TRIGGER = null;
    public static final SlideUpTipsTriggerSource USER_CLOSE = null;
    public static final SlideUpTipsTriggerSource XT_SLIDE_UP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SlideUpTipsTriggerSource[] f158395a = null;

    static {
        SlideUpTipsTriggerSource r100 = new SlideUpTipsTriggerSource("RESUME_TRIGGER", 0);
        RESUME_TRIGGER = r100;
        SlideUpTipsTriggerSource r101 = new SlideUpTipsTriggerSource("STRATEGY_TRIGGER", 1);
        STRATEGY_TRIGGER = r101;
        SlideUpTipsTriggerSource r102 = new SlideUpTipsTriggerSource("USER_CLOSE", 2);
        USER_CLOSE = r102;
        SlideUpTipsTriggerSource r103 = new SlideUpTipsTriggerSource("SLIDE_UP_V1", 3);
        SLIDE_UP_V1 = r103;
        SlideUpTipsTriggerSource r104 = new SlideUpTipsTriggerSource("XT_SLIDE_UP", 4);
        XT_SLIDE_UP = r104;
        SlideUpTipsTriggerSource r105 = new SlideUpTipsTriggerSource("LOAD_MORE", 5);
        LOAD_MORE = r105;
        f158395a = new SlideUpTipsTriggerSource[]{r100, r101, r102, r103, r104, r105};
    }

    public static SlideUpTipsTriggerSource valueOf(String r100) {
        return (SlideUpTipsTriggerSource) r27.a.a(SlideUpTipsTriggerSource.class, r100);
    }

    public static SlideUpTipsTriggerSource[] values() {
        return (SlideUpTipsTriggerSource[]) f158395a.clone();
    }

    public SlideUpTipsTriggerSource(String r100, int r101) {
        super(r100, r101);
    }
}
