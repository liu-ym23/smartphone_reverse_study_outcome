package pb;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import o9.C5013a;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import w9.InterfaceC5745d;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B'\u0012\u001e\u0010\u0006\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00050\u0003¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\u000b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fR/\u0010\u0006\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00050\u00038\u0006¢\u0006\f\n\u0004\b\u000b\u0010\r\u001a\u0004\b\u000e\u0010\u000fR \u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00110\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0012¨\u0006\u0014"}, d2 = {"Lpb/s;", ExifInterface.GPS_DIRECTION_TRUE, "Lpb/U0;", "Lkotlin/Function1;", "Lw9/d;", "Lkotlinx/serialization/KSerializer;", "compute", "<init>", "(Lp9/l;)V", "", "key", Const.INTENT_KEY_APIKEY, "(Lw9/d;)Lkotlinx/serialization/KSerializer;", "Lp9/l;", Const.INTENT_KEY_PKGNAME, "()Lp9/l;", "Lpb/u;", "Lpb/m;", "Lpb/u;", "classValue", "kotlinx-serialization-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: pb.s, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5119s<T> implements U0<T> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC5074l<InterfaceC5745d<?>, KSerializer<T>> compute;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final C5123u<C5108m<T>> classValue;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: pb.s$a */
    public static final class a implements InterfaceC5063a<T> {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ InterfaceC5745d f38413b;

        public a(InterfaceC5745d interfaceC5745d) {
            this.f38413b = interfaceC5745d;
        }

        @Override // p9.InterfaceC5063a
        public final T invoke() {
            return (T) new C5108m(C5119s.this.b().invoke(this.f38413b));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C5119s(InterfaceC5074l<? super InterfaceC5745d<?>, ? extends KSerializer<T>> compute) {
        kotlin.jvm.internal.p.i(compute, "compute");
        this.compute = compute;
        this.classValue = new C5123u<>();
    }

    @Override // pb.U0
    public KSerializer<T> a(InterfaceC5745d<Object> key) {
        kotlin.jvm.internal.p.i(key, "key");
        C5108m<T> c5108m = this.classValue.get(C5013a.b(key));
        kotlin.jvm.internal.p.h(c5108m, "get(...)");
        C5111n0 c5111n0 = (C5111n0) c5108m;
        T t10 = c5111n0.reference.get();
        if (t10 == null) {
            t10 = (T) c5111n0.a(new a(key));
        }
        return t10.serializer;
    }

    public final InterfaceC5074l<InterfaceC5745d<?>, KSerializer<T>> b() {
        return this.compute;
    }
}
