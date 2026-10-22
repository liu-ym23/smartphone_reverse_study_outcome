package com.bytedance.ai.bridge.method.device.calendar;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ai/bridge/method/device/calendar/RepeatInterval;", "", "<init>", "(Ljava/lang/String;I)V", "DAY", "WEEK", "MONTH", "YEAR", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
final enum RepeatInterval extends Enum<RepeatInterval> {
    public static final RepeatInterval DAY = null;
    public static final RepeatInterval MONTH = null;
    public static final RepeatInterval WEEK = null;
    public static final RepeatInterval YEAR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RepeatInterval[] f35449a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f35450b = null;

    public static EnumEntries<RepeatInterval> getEntries() {
        return f35450b;
    }

    static {
        RepeatInterval r100 = new RepeatInterval("DAY", 0);
        DAY = r100;
        RepeatInterval r101 = new RepeatInterval("WEEK", 1);
        WEEK = r101;
        RepeatInterval r102 = new RepeatInterval("MONTH", 2);
        MONTH = r102;
        RepeatInterval r103 = new RepeatInterval("YEAR", 3);
        YEAR = r103;
        RepeatInterval[] r104 = {r100, r101, r102, r103};
        f35449a = r104;
        f35450b = EnumEntriesKt.enumEntries(r104);
    }

    public static RepeatInterval[] values() {
        return (RepeatInterval[]) f35449a.clone();
    }

    public static RepeatInterval valueOf(String r100) {
        return (RepeatInterval) r27.a.a(RepeatInterval.class, r100);
    }

    public RepeatInterval(String r100, int r101) {
        super(r100, r101);
    }
}
