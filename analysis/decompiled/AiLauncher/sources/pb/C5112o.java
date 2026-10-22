package pb;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import p9.InterfaceC5074l;
import w9.InterfaceC5745d;
import w9.InterfaceC5755n;

@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a;\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\u0004\b\u0000\u0010\u00002\u001e\u0010\u0004\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00030\u0001H\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001aI\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\f\"\u0004\b\u0000\u0010\u00002,\u0010\u0004\u001a(\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00030\bH\u0000¢\u0006\u0004\b\r\u0010\u000e\"\u0014\u0010\u0011\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0010¨\u0006\u0012"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function1;", "Lw9/d;", "Lkotlinx/serialization/KSerializer;", "factory", "Lpb/U0;", Const.INTENT_KEY_APIKEY, "(Lp9/l;)Lpb/U0;", "Lkotlin/Function2;", "", "", "Lw9/n;", "Lpb/B0;", Const.INTENT_KEY_PKGNAME, "(Lp9/p;)Lpb/B0;", "", "Z", "useClassValue", "kotlinx-serialization-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* renamed from: pb.o, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5112o {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f38395a;

    static {
        boolean z10;
        try {
            Class.forName("java.lang.ClassValue");
            z10 = true;
        } catch (Throwable unused) {
            z10 = false;
        }
        f38395a = z10;
    }

    public static final <T> U0<T> a(InterfaceC5074l<? super InterfaceC5745d<?>, ? extends KSerializer<T>> factory) {
        kotlin.jvm.internal.p.i(factory, "factory");
        return f38395a ? new C5119s(factory) : new C5129x(factory);
    }

    public static final <T> B0<T> b(p9.p<? super InterfaceC5745d<Object>, ? super List<? extends InterfaceC5755n>, ? extends KSerializer<T>> factory) {
        kotlin.jvm.internal.p.i(factory, "factory");
        return f38395a ? new C5121t(factory) : new C5131y(factory);
    }
}
