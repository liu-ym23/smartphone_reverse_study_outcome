package com.bytedance.android.livesdk.feedback.service;

import com.bytedance.sdk.open.aweme.core.net.OpenNetMethod;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/feedback/service/FeedbackHideCode;", "", "LIVE_END", "RIGHT_BOTTOM_CARD_SHOW", OpenNetMethod.REPORT, "NEGATIVE_ACTION", "OUT_OF_TIME", "REMOVE_DATA", "CLEAR_MODE", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum FeedbackHideCode extends Enum<FeedbackHideCode> {
    public static final FeedbackHideCode CLEAR_MODE = null;
    public static final FeedbackHideCode LIVE_END = null;
    public static final FeedbackHideCode NEGATIVE_ACTION = null;
    public static final FeedbackHideCode OUT_OF_TIME = null;
    public static final FeedbackHideCode REMOVE_DATA = null;
    public static final FeedbackHideCode REPORT = null;
    public static final FeedbackHideCode RIGHT_BOTTOM_CARD_SHOW = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FeedbackHideCode[] f124833a = null;

    static {
        FeedbackHideCode r100 = new FeedbackHideCode("LIVE_END", 0);
        LIVE_END = r100;
        FeedbackHideCode r101 = new FeedbackHideCode("RIGHT_BOTTOM_CARD_SHOW", 1);
        RIGHT_BOTTOM_CARD_SHOW = r101;
        FeedbackHideCode r102 = new FeedbackHideCode(OpenNetMethod.REPORT, 2);
        REPORT = r102;
        FeedbackHideCode r103 = new FeedbackHideCode("NEGATIVE_ACTION", 3);
        NEGATIVE_ACTION = r103;
        FeedbackHideCode r104 = new FeedbackHideCode("OUT_OF_TIME", 4);
        OUT_OF_TIME = r104;
        FeedbackHideCode r105 = new FeedbackHideCode("REMOVE_DATA", 5);
        REMOVE_DATA = r105;
        FeedbackHideCode r106 = new FeedbackHideCode("CLEAR_MODE", 6);
        CLEAR_MODE = r106;
        f124833a = new FeedbackHideCode[]{r100, r101, r102, r103, r104, r105, r106};
    }

    public static FeedbackHideCode valueOf(String r100) {
        return (FeedbackHideCode) r27.a.a(FeedbackHideCode.class, r100);
    }

    public static FeedbackHideCode[] values() {
        return (FeedbackHideCode[]) f124833a.clone();
    }

    public FeedbackHideCode(String r100, int r101) {
        super(r100, r101);
    }
}
