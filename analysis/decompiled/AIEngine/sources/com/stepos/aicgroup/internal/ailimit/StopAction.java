package com.stepos.aicgroup.internal.ailimit;

import sb.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class StopAction {
    public static final StopAction CANCEL;
    public static final StopAction PAUSE;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ StopAction[] f5738a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ a f5739b;

    static {
        StopAction stopAction = new StopAction("PAUSE", 0);
        PAUSE = stopAction;
        StopAction stopAction2 = new StopAction("CANCEL", 1);
        CANCEL = stopAction2;
        StopAction[] stopActionArr = {stopAction, stopAction2};
        f5738a = stopActionArr;
        f5739b = kotlin.enums.a.a(stopActionArr);
    }

    public StopAction() {
        throw null;
    }

    public static a<StopAction> getEntries() {
        return f5739b;
    }

    public static StopAction valueOf(String str) {
        return (StopAction) Enum.valueOf(StopAction.class, str);
    }

    public static StopAction[] values() {
        return (StopAction[]) f5738a.clone();
    }
}
