package androidx.appcompat.app;

import android.content.Context;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1689a;
    public final /* synthetic */ Context b;

    public /* synthetic */ a(Context context, int i) {
        this.f1689a = i;
        this.b = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.f1689a;
        Context context = this.b;
        switch (i) {
            case 0:
                AppCompatDelegate.lambda$syncRequestedAndStoredLocales$1(context);
                break;
            default:
                AppCompatDelegate.syncRequestedAndStoredLocales(context);
                break;
        }
    }
}
