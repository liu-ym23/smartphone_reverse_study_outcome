package com.uxsense.ruleTrigger;

/* loaded from: classes3.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4207a;
    public final /* synthetic */ ApexTriggerManager b;
    public final /* synthetic */ int c;
    public final /* synthetic */ String d;

    public /* synthetic */ a(ApexTriggerManager apexTriggerManager, int i, String str, int i6) {
        this.f4207a = i6;
        this.b = apexTriggerManager;
        this.c = i;
        this.d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4207a) {
            case 0:
                this.b.lambda$onProcessStarted$2(this.c, this.d);
                break;
            default:
                this.b.lambda$restoreExistingProcesses$0(this.c, this.d);
                break;
        }
    }
}
