package Wa;

import Ua.U0;
import Za.z;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u001b\u0012\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\r\u001a\u00020\f2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\b2\u0006\u0010\u000b\u001a\u00020\nH\u0096\u0001¢\u0006\u0004\b\r\u0010\u000eR \u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u00038\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"LWa/q;", ExifInterface.LONGITUDE_EAST, "LUa/U0;", "Lkotlinx/coroutines/c;", "Lkotlinx/coroutines/channels/a;", "cont", "<init>", "(Lkotlinx/coroutines/c;)V", "LZa/z;", "segment", "", "index", "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(LZa/z;I)V", Const.INTENT_KEY_APIKEY, "Lkotlinx/coroutines/c;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class q<E> implements U0 {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final kotlinx.coroutines.c<kotlinx.coroutines.channels.a<? extends E>> cont;

    /* JADX WARN: Multi-variable type inference failed */
    public q(kotlinx.coroutines.c<? super kotlinx.coroutines.channels.a<? extends E>> cVar) {
        this.cont = cVar;
    }

    @Override // Ua.U0
    public void h(z<?> segment, int index) {
        this.cont.h(segment, index);
    }
}
