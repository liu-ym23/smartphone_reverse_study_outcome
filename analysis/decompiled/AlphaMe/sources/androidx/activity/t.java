package androidx.activity;

import android.window.OnBackInvokedCallback;
import androidx.appcompat.app.F;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final /* synthetic */ class t implements OnBackInvokedCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2441a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2442b;

    public /* synthetic */ t(int i4, Object obj) {
        this.f2441a = i4;
        this.f2442b = obj;
    }

    @Override // android.window.OnBackInvokedCallback
    public final void onBackInvoked() {
        int i4 = this.f2441a;
        Object obj = this.f2442b;
        switch (i4) {
            case 0:
                Function0 onBackInvoked = (Function0) obj;
                Intrinsics.checkNotNullParameter(onBackInvoked, "$onBackInvoked");
                onBackInvoked.invoke();
                break;
            case 1:
                ((F) obj).r();
                break;
            default:
                ((Runnable) obj).run();
                break;
        }
    }
}
