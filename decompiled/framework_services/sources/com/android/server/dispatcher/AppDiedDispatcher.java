package com.android.server.dispatcher;

/* JADX INFO: loaded from: classes2.dex */
public class AppDiedDispatcher extends AbsDispatcher<AppDiedObserver> {
    private static final AbsDispatcher.Lazy<AppDiedDispatcher> INSTANCE = null;
    public static final String TAG = "GameAssist.AppDiedDispatcher";

    public static /* synthetic */ void $r8$lambda$2luBEXAwSUDAcZn4H3AUVeHc_0k(String r0, AppDiedObserver r1) {
        lambda$notifyAppDied$0(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$jDrKrQaBNmBlT-hzMFupRjDxyAo, reason: not valid java name */
    public static /* synthetic */ AppDiedDispatcher m3552$r8$lambda$jDrKrQaBNmBlThzMFupRjDxyAo() {
        return new AppDiedDispatcher();
    }

    static {
        INSTANCE = new AbsDispatcher.Lazy(new AppDiedDispatcher$$ExternalSyntheticLambda1());
    }

    private AppDiedDispatcher() {
    }

    public static AppDiedDispatcher getInstance() {
        return (AppDiedDispatcher) INSTANCE.get();
    }

    private static /* synthetic */ void lambda$notifyAppDied$0(String packageName, AppDiedObserver observer) {
        observer.onAppDied(packageName);
    }

    public void notifyAppDied(final String packageName) {
        notifyObserver(new AppDiedDispatcher$$ExternalSyntheticLambda0(packageName));
    }
}
