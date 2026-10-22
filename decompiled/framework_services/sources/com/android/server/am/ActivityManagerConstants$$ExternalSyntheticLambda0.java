package com.android.server.am;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ActivityManagerConstants$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ PhantomProcessList f$0;

    public /* synthetic */ ActivityManagerConstants$$ExternalSyntheticLambda0(PhantomProcessList r1) {
        this.f$0 = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f$0.trimPhantomProcessesIfNecessary();
    }
}
