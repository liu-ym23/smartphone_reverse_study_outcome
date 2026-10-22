package Ya;

import Wa.s;
import Y8.t;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import e9.InterfaceC4014c;
import f9.C4063a;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00028\u0000H\u0096@¢\u0006\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"LYa/o;", ExifInterface.GPS_DIRECTION_TRUE, "LXa/c;", "LWa/s;", "channel", "<init>", "(LWa/s;)V", UxipConstants.f30680s, "LY8/t;", "emit", "(Ljava/lang/Object;Le9/c;)Ljava/lang/Object;", Const.INTENT_KEY_APIKEY, "LWa/s;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class o<T> implements Xa.c<T> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final s<T> channel;

    /* JADX WARN: Multi-variable type inference failed */
    public o(s<? super T> sVar) {
        this.channel = sVar;
    }

    @Override // Xa.c
    public Object emit(T t10, InterfaceC4014c<? super t> interfaceC4014c) {
        Object objSend = this.channel.send(t10, interfaceC4014c);
        return objSend == C4063a.g() ? objSend : t.f7040a;
    }
}
