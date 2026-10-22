package sb;

import Z8.C1173v;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlinx.serialization.KSerializer;
import lb.InterfaceC4883a;
import lb.m;
import w9.InterfaceC5745d;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003JC\u0010\n\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\b\"\b\b\u0000\u0010\u0004*\u00020\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\u0012\b\u0002\u0010\t\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ9\u0010\u000f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000e\"\b\b\u0000\u0010\u0004*\u00020\u00012\u000e\u0010\f\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00052\u0006\u0010\r\u001a\u00028\u0000H'¢\u0006\u0004\b\u000f\u0010\u0010J;\u0010\u0014\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0013\"\b\b\u0000\u0010\u0004*\u00020\u00012\u000e\u0010\f\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H'¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0016H'¢\u0006\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001f\u001a\u00020\u001b8 X¡\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\u0003\u001a\u0004\b\u001c\u0010\u001d\u0082\u0001\u0001 ¨\u0006!"}, d2 = {"Lsb/c;", "", "<init>", "()V", ExifInterface.GPS_DIRECTION_TRUE, "Lw9/d;", "kClass", "", "Lkotlinx/serialization/KSerializer;", "typeArgumentsSerializers", Const.INTENT_KEY_PKGNAME, "(Lw9/d;Ljava/util/List;)Lkotlinx/serialization/KSerializer;", "baseClass", UxipConstants.f30680s, "Llb/m;", "f", "(Lw9/d;Ljava/lang/Object;)Llb/m;", "", "serializedClassName", "Llb/a;", "e", "(Lw9/d;Ljava/lang/String;)Llb/a;", "Lsb/f;", "collector", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Lsb/f;)V", "", Const.INTENT_KEY_UMID, "()Z", "getHasInterfaceContextualSerializers$kotlinx_serialization_core$annotations", "hasInterfaceContextualSerializers", "Lsb/b;", "kotlinx-serialization-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: sb.c, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC5465c {
    public /* synthetic */ AbstractC5465c(i iVar) {
        this();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ KSerializer c(AbstractC5465c abstractC5465c, InterfaceC5745d interfaceC5745d, List list, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getContextual");
        }
        if ((i10 & 2) != 0) {
            list = C1173v.m();
        }
        return abstractC5465c.b(interfaceC5745d, list);
    }

    public abstract void a(f collector);

    public abstract <T> KSerializer<T> b(InterfaceC5745d<T> kClass, List<? extends KSerializer<?>> typeArgumentsSerializers);

    /* renamed from: d */
    public abstract boolean getHasInterfaceContextualSerializers();

    public abstract <T> InterfaceC4883a<T> e(InterfaceC5745d<? super T> baseClass, String serializedClassName);

    public abstract <T> m<T> f(InterfaceC5745d<? super T> baseClass, T value);

    public AbstractC5465c() {
    }
}
