package android.llama.cpp;

import com.stepos.core.ability.AbilityBinderImpl;
import java.util.concurrent.ThreadFactory;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f184a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f185b;

    public /* synthetic */ a(Object obj, int i10) {
        this.f184a = i10;
        this.f185b = obj;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        int i10 = this.f184a;
        Object obj = this.f185b;
        switch (i10) {
            case 0:
                return LLamaAndroid.runLoop$lambda$3((LLamaAndroid) obj, runnable);
            case 1:
                return AbilityBinderImpl.singleThreadDispatcher$lambda$0((AbilityBinderImpl) obj, runnable);
            default:
                Thread thread = new Thread(runnable, (String) obj);
                thread.setPriority(10);
                return thread;
        }
    }
}
