package com.stepos.widget.list;

import kotlin.Metadata;
import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/stepos/widget/list/StepOSCardPosition;", "", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class StepOSCardPosition {

    /* renamed from: a, reason: collision with root package name */
    public static final StepOSCardPosition f4109a;
    public static final StepOSCardPosition b;
    public static final StepOSCardPosition c;
    public static final StepOSCardPosition d;
    public static final StepOSCardPosition e;
    public static final /* synthetic */ StepOSCardPosition[] f;

    static {
        StepOSCardPosition stepOSCardPosition = new StepOSCardPosition("NONE", 0);
        f4109a = stepOSCardPosition;
        StepOSCardPosition stepOSCardPosition2 = new StepOSCardPosition("SINGLE", 1);
        b = stepOSCardPosition2;
        StepOSCardPosition stepOSCardPosition3 = new StepOSCardPosition("FIRST", 2);
        c = stepOSCardPosition3;
        StepOSCardPosition stepOSCardPosition4 = new StepOSCardPosition("MIDDLE", 3);
        d = stepOSCardPosition4;
        StepOSCardPosition stepOSCardPosition5 = new StepOSCardPosition("LAST", 4);
        e = stepOSCardPosition5;
        StepOSCardPosition[] stepOSCardPositionArr = {stepOSCardPosition, stepOSCardPosition2, stepOSCardPosition3, stepOSCardPosition4, stepOSCardPosition5};
        f = stepOSCardPositionArr;
        a.a(stepOSCardPositionArr);
    }

    public static StepOSCardPosition valueOf(String str) {
        return (StepOSCardPosition) Enum.valueOf(StepOSCardPosition.class, str);
    }

    public static StepOSCardPosition[] values() {
        return (StepOSCardPosition[]) f.clone();
    }
}
