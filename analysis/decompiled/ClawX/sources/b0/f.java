package b0;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class f implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f821a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f822b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Context f823c;
    public final /* synthetic */ int d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f824e;

    public /* synthetic */ f(String str, Context context, Object obj, int i8, int i9) {
        this.f821a = i9;
        this.f822b = str;
        this.f823c = context;
        this.f824e = obj;
        this.d = i8;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.f821a) {
            case 0:
                return i.b(this.f822b, this.f823c, List.of((e) this.f824e), this.d);
            default:
                try {
                    return i.b(this.f822b, this.f823c, (ArrayList) this.f824e, this.d);
                } catch (Throwable unused) {
                    return new h(-3);
                }
        }
    }
}
