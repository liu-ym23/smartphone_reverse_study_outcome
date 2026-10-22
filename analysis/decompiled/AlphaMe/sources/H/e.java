package H;

import android.content.Context;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class e implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f666a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f667b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Context f668c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ d f669d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f670e;

    public /* synthetic */ e(String str, Context context, d dVar, int i4, int i5) {
        this.f666a = i5;
        this.f667b = str;
        this.f668c = context;
        this.f669d = dVar;
        this.f670e = i4;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        String str = this.f667b;
        Context context = this.f668c;
        d dVar = this.f669d;
        int i4 = this.f670e;
        int i5 = this.f666a;
        switch (i5) {
            case 0:
                switch (i5) {
                }
            default:
                switch (i5) {
                }
        }
        return h.a(str, context, dVar, i4);
    }
}
