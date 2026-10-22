package kotlinx.coroutines.channels;

import Ua.C1062j;
import Wa.s;
import Y8.t;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlinx.coroutines.channels.a;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a+\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0002\u001a\u00028\u0000¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {ExifInterface.LONGITUDE_EAST, "LWa/s;", "element", "Lkotlinx/coroutines/channels/a;", "LY8/t;", Const.INTENT_KEY_APIKEY, "(LWa/s;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 5, mv = {2, 2, 0}, xi = 48, xs = "kotlinx/coroutines/channels/ChannelsKt")
/* loaded from: classes5.dex */
public final /* synthetic */ class ChannelsKt__ChannelsKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <E> Object a(s<? super E> sVar, E e10) {
        Object objMo0trySendJP2dKIU = sVar.mo0trySendJP2dKIU(e10);
        if (objMo0trySendJP2dKIU instanceof a.c) {
            return ((a) C1062j.b(null, new ChannelsKt__ChannelsKt$trySendBlocking$2(sVar, e10, null), 1, null)).getHolder();
        }
        return a.INSTANCE.c(t.f7040a);
    }
}
