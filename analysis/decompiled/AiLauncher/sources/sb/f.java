package sb;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlinx.serialization.KSerializer;
import lb.InterfaceC4883a;
import lb.m;
import p9.InterfaceC5074l;
import w9.InterfaceC5745d;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J5\u0010\b\u001a\u00020\u0007\"\b\b\u0000\u0010\u0002*\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJI\u0010\r\u001a\u00020\u0007\"\b\b\u0000\u0010\u0002*\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032 \u0010\f\u001a\u001c\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u000b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\nH&¢\u0006\u0004\b\r\u0010\u000eJM\u0010\u0014\u001a\u00020\u0007\"\b\b\u0000\u0010\u000f*\u00020\u0001\"\b\b\u0001\u0010\u0010*\u00028\u00002\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005H&¢\u0006\u0004\b\u0014\u0010\u0015JC\u0010\u0018\u001a\u00020\u0007\"\b\b\u0000\u0010\u000f*\u00020\u00012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u001a\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00160\nH&¢\u0006\u0004\b\u0018\u0010\u000eJE\u0010\u001c\u001a\u00020\u0007\"\b\b\u0000\u0010\u000f*\u00020\u00012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u001c\u0010\u001b\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001a0\nH&¢\u0006\u0004\b\u001c\u0010\u000e¨\u0006\u001dÀ\u0006\u0003"}, d2 = {"Lsb/f;", "", ExifInterface.GPS_DIRECTION_TRUE, "Lw9/d;", "kClass", "Lkotlinx/serialization/KSerializer;", "serializer", "LY8/t;", "f", "(Lw9/d;Lkotlinx/serialization/KSerializer;)V", "Lkotlin/Function1;", "", Const.JSON_KEY_PROVIDER, Const.INTENT_KEY_PKGNAME, "(Lw9/d;Lp9/l;)V", "Base", "Sub", "baseClass", "actualClass", "actualSerializer", Const.INTENT_KEY_UMID, "(Lw9/d;Lw9/d;Lkotlinx/serialization/KSerializer;)V", "Llb/m;", "defaultSerializerProvider", Const.INTENT_KEY_APIKEY, "", "Llb/a;", "defaultDeserializerProvider", "c", "kotlinx-serialization-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface f {
    static KSerializer g(KSerializer kSerializer, List it) {
        p.i(it, "it");
        return kSerializer;
    }

    <Base> void a(InterfaceC5745d<Base> baseClass, InterfaceC5074l<? super Base, ? extends m<? super Base>> defaultSerializerProvider);

    <T> void b(InterfaceC5745d<T> kClass, InterfaceC5074l<? super List<? extends KSerializer<?>>, ? extends KSerializer<?>> provider);

    <Base> void c(InterfaceC5745d<Base> baseClass, InterfaceC5074l<? super String, ? extends InterfaceC4883a<? extends Base>> defaultDeserializerProvider);

    <Base, Sub extends Base> void d(InterfaceC5745d<Base> baseClass, InterfaceC5745d<Sub> actualClass, KSerializer<Sub> actualSerializer);

    default <T> void f(InterfaceC5745d<T> kClass, final KSerializer<T> serializer) {
        p.i(kClass, "kClass");
        p.i(serializer, "serializer");
        b(kClass, new InterfaceC5074l() { // from class: sb.e
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return f.g(serializer, (List) obj);
            }
        });
    }
}
