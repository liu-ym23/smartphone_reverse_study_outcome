package Za;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import e9.InterfaceC4014c;
import g9.InterfaceC4111c;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0010\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000\u00022\u00060\u0003j\u0002`\u0004B\u001d\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0012\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0014¢\u0006\u0004\b\u0012\u0010\u000fR\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0017\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00048F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, d2 = {"LZa/y;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/a;", "Lg9/c;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "Lkotlin/coroutines/d;", "context", "Le9/c;", "uCont", "<init>", "(Lkotlin/coroutines/d;Le9/c;)V", "", VoiceWakeupReceiver.EXTRA_STATE, "LY8/t;", "C", "(Ljava/lang/Object;)V", "Z0", "()V", "U0", Const.INTENT_KEY_UMID, "Le9/c;", "getCallerFrame", "()Lg9/c;", "callerFrame", "", "l0", "()Z", "isScopedCoroutine", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public class y<T> extends kotlinx.coroutines.a<T> implements InterfaceC4111c {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC4014c<T> uCont;

    /* JADX WARN: Multi-variable type inference failed */
    public y(kotlin.coroutines.d dVar, InterfaceC4014c<? super T> interfaceC4014c) {
        super(dVar, true, true);
        this.uCont = interfaceC4014c;
    }

    @Override // kotlinx.coroutines.JobSupport
    public void C(Object state) {
        C1189i.b(IntrinsicsKt__IntrinsicsJvmKt.d(this.uCont), Ua.A.a(state, this.uCont));
    }

    @Override // kotlinx.coroutines.a
    public void U0(Object state) {
        InterfaceC4014c<T> interfaceC4014c = this.uCont;
        interfaceC4014c.resumeWith(Ua.A.a(state, interfaceC4014c));
    }

    public void Z0() {
    }

    @Override // g9.InterfaceC4111c
    public final InterfaceC4111c getCallerFrame() {
        InterfaceC4014c<T> interfaceC4014c = this.uCont;
        if (interfaceC4014c instanceof InterfaceC4111c) {
            return (InterfaceC4111c) interfaceC4014c;
        }
        return null;
    }

    @Override // kotlinx.coroutines.JobSupport
    public final boolean l0() {
        return true;
    }
}
