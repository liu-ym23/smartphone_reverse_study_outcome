package com.stepos.alphame.dailyusage;

import com.stepos.alphame.ocr.OcrEngine;
import com.stepos.alphame.utils.CorountinesUtilsKt;
import java.util.concurrent.ThreadFactory;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11178a;

    public /* synthetic */ a(int i4) {
        this.f11178a = i4;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        switch (this.f11178a) {
            case 0:
                return DailyUsageEngineService.singleDispatcher$lambda$1(runnable);
            case 1:
                return DefaultDailyUsageEventHandler.singleDispatcher$lambda$1(runnable);
            case 2:
                return OcrEngine.ocrExecutor$lambda$1(runnable);
            case 3:
                return OcrEngine.idleScheduler$lambda$3(runnable);
            case 4:
                return CorountinesUtilsKt.singleDispatcher$lambda$1(runnable);
            case 5:
                return CorountinesUtilsKt.singleIoDispatcher$lambda$3(runnable);
            case 6:
                return CorountinesUtilsKt.singleLocationDispatcher$lambda$5(runnable);
            case 7:
                return new Thread(runnable, "ResponseTask");
            default:
                return new Thread(runnable, "GlobalTask");
        }
    }
}
