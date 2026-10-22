package Xa;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import f9.C4063a;
import kotlin.Metadata;
import kotlinx.coroutines.flow.AbstractFlow;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B1\u0012(\u0010\b\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0003¢\u0006\u0004\b\t\u0010\nJ\u001e\u0010\f\u001a\u00020\u00062\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0096@¢\u0006\u0004\b\f\u0010\rR6\u0010\b\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"LXa/n;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/AbstractFlow;", "Lkotlin/Function2;", "LXa/c;", "Le9/c;", "LY8/t;", "", "block", "<init>", "(Lp9/p;)V", "collector", Const.INTENT_KEY_BACKGROUND_COMMAND, "(LXa/c;Le9/c;)Ljava/lang/Object;", Const.INTENT_KEY_APIKEY, "Lp9/p;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class n<T> extends AbstractFlow<T> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final p9.p<c<? super T>, InterfaceC4014c<? super Y8.t>, Object> block;

    /* JADX WARN: Multi-variable type inference failed */
    public n(p9.p<? super c<? super T>, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> pVar) {
        this.block = pVar;
    }

    @Override // kotlinx.coroutines.flow.AbstractFlow
    public Object g(c<? super T> cVar, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        Object objInvoke = this.block.invoke(cVar, interfaceC4014c);
        return objInvoke == C4063a.g() ? objInvoke : Y8.t.f7040a;
    }
}
