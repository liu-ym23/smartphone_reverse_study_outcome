package com.stepos.core.common.telemetry;

import com.stepos.core.model.task.AITaskRecord;
import com.stepos.core.model.task.AITaskStack;
import com.stepos.core.model.task.TaskSession;
import zb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class d implements l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7389a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f7390b;

    public /* synthetic */ d(String str, int i10) {
        this.f7389a = i10;
        this.f7390b = str;
    }

    @Override // zb.l
    public final Object invoke(Object obj) {
        boolean zReportTerminalOnce$lambda$4;
        int i10 = this.f7389a;
        String str = this.f7390b;
        switch (i10) {
            case 0:
                zReportTerminalOnce$lambda$4 = ModelCallSessionTracker.reportTerminalOnce$lambda$4(str, (String) obj);
                break;
            case 1:
                zReportTerminalOnce$lambda$4 = AITaskStack.remove$lambda$13(str, (AITaskRecord) obj);
                break;
            case 2:
                zReportTerminalOnce$lambda$4 = AITaskStack.markCancelled$lambda$9(str, (AITaskRecord) obj);
                break;
            case 3:
                zReportTerminalOnce$lambda$4 = AITaskStack.removeSession$lambda$4(str, (TaskSession) obj);
                break;
            default:
                zReportTerminalOnce$lambda$4 = AITaskStack.markSessionCancelled$lambda$2(str, (TaskSession) obj);
                break;
        }
        return Boolean.valueOf(zReportTerminalOnce$lambda$4);
    }
}
