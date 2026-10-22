package afa;

import com.larus.utils.logger.FLogger;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes33.dex */
public final class a implements Function1<Throwable, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f3226a;

    public a(AtomicBoolean r100) {
        this.f3226a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Throwable r100) {
        this.f3226a.set(true);
        FLogger.f375446a.i("DismissKeyguardActionHandler", "dismissKeyguard continuation cancelled");
        return Unit.INSTANCE;
    }
}
