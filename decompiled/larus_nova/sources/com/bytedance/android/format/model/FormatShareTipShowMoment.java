package com.bytedance.android.format.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/format/model/FormatShareTipShowMoment;", "", "None", "Start", "SuccessOrFail", "After", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum FormatShareTipShowMoment extends Enum<FormatShareTipShowMoment> {
    public static final FormatShareTipShowMoment After = null;
    public static final FormatShareTipShowMoment None = null;
    public static final FormatShareTipShowMoment Start = null;
    public static final FormatShareTipShowMoment SuccessOrFail = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FormatShareTipShowMoment[] f51339a = null;

    static {
        FormatShareTipShowMoment r100 = new FormatShareTipShowMoment("None", 0);
        None = r100;
        FormatShareTipShowMoment r101 = new FormatShareTipShowMoment("Start", 1);
        Start = r101;
        FormatShareTipShowMoment r102 = new FormatShareTipShowMoment("SuccessOrFail", 2);
        SuccessOrFail = r102;
        FormatShareTipShowMoment r103 = new FormatShareTipShowMoment("After", 3);
        After = r103;
        f51339a = new FormatShareTipShowMoment[]{r100, r101, r102, r103};
    }

    public static FormatShareTipShowMoment valueOf(String r100) {
        return (FormatShareTipShowMoment) r27.a.a(FormatShareTipShowMoment.class, r100);
    }

    public static FormatShareTipShowMoment[] values() {
        return (FormatShareTipShowMoment[]) f51339a.clone();
    }

    public FormatShareTipShowMoment(String r100, int r101) {
        super(r100, r101);
    }
}
