package Ka;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import e9.InterfaceC4014c;
import f9.C4063a;
import java.util.Iterator;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b'\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u0002B\t\b\u0000¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00028\u0000H¦@¢\u0006\u0004\b\u0007\u0010\bJ\u001e\u0010\u000b\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\tH¦@¢\u0006\u0004\b\u000b\u0010\fJ\u001e\u0010\u000f\u001a\u00020\u00062\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\rH\u0086@¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"LKa/l;", ExifInterface.GPS_DIRECTION_TRUE, "", "<init>", "()V", UxipConstants.f30680s, "LY8/t;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/Object;Le9/c;)Ljava/lang/Object;", "", "iterator", "e", "(Ljava/util/Iterator;Le9/c;)Ljava/lang/Object;", "LKa/j;", "sequence", "c", "(LKa/j;Le9/c;)Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class l<T> {
    public abstract Object a(T t10, InterfaceC4014c<? super Y8.t> interfaceC4014c);

    public final Object c(j<? extends T> jVar, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        Object objE = e(jVar.iterator(), interfaceC4014c);
        return objE == C4063a.g() ? objE : Y8.t.f7040a;
    }

    public abstract Object e(Iterator<? extends T> it, InterfaceC4014c<? super Y8.t> interfaceC4014c);
}
