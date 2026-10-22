package a4a;

import androidx.appcompat.app.AppCompatActivity;
import com.larus.voicecall.impl.ui.RealtimeCallActivity;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AppCompatActivity f1818a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f1819b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f1820c;

    public abstract void a();

    public final AppCompatActivity getActivity() {
        return this.f1818a;
    }

    public c(RealtimeCallActivity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        this.f1818a = r100;
        this.f1819b = LazyKt.lazy(new a(this));
        this.f1820c = LazyKt.lazy(new b());
    }
}
