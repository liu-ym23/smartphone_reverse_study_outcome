package Xa;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import f9.C4063a;
import kotlin.Metadata;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.ChannelFlow;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0012\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002BO\u0012(\u0010\b\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u001e\u0010\u0012\u001a\u00020\u00062\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0094@¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R6\u0010\b\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"LXa/a;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/internal/ChannelFlow;", "Lkotlin/Function2;", "LWa/p;", "Le9/c;", "LY8/t;", "", "block", "Lkotlin/coroutines/d;", "context", "", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "<init>", "(Lp9/p;Lkotlin/coroutines/d;ILkotlinx/coroutines/channels/BufferOverflow;)V", "scope", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(LWa/p;Le9/c;)Ljava/lang/Object;", "", "toString", "()Ljava/lang/String;", Const.INTENT_KEY_UMID, "Lp9/p;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public class a<T> extends ChannelFlow<T> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final p9.p<Wa.p<? super T>, InterfaceC4014c<? super Y8.t>, Object> block;

    /* JADX WARN: Multi-variable type inference failed */
    public a(p9.p<? super Wa.p<? super T>, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> pVar, kotlin.coroutines.d dVar, int i10, BufferOverflow bufferOverflow) {
        super(dVar, i10, bufferOverflow);
        this.block = pVar;
    }

    public static /* synthetic */ <T> Object o(a<T> aVar, Wa.p<? super T> pVar, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        Object objInvoke = aVar.block.invoke(pVar, interfaceC4014c);
        return objInvoke == C4063a.g() ? objInvoke : Y8.t.f7040a;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public Object i(Wa.p<? super T> pVar, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return o(this, pVar, interfaceC4014c);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public String toString() {
        return "block[" + this.block + "] -> " + super.toString();
    }
}
