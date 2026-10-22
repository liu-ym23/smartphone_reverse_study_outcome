package coil.intercept;

import A1.g;
import A1.h;
import B1.Size;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001:\u0001\u0005J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H¦@¢\u0006\u0004\b\u0005\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2 = {"Lcoil/intercept/a;", "", "Lcoil/intercept/a$a;", "chain", "LA1/h;", Const.INTENT_KEY_APIKEY, "(Lcoil/intercept/a$a;Le9/c;)Ljava/lang/Object;", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public interface a {

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0005\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00068&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0001"}, d2 = {"Lcoil/intercept/a$a;", "", "LA1/g;", "getRequest", "()LA1/g;", "request", "LB1/g;", "getSize", "()LB1/g;", ContentDisposition.Parameters.Size, "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: coil.intercept.a$a, reason: collision with other inner class name */
    public interface InterfaceC0199a {
        g getRequest();

        Size getSize();
    }

    Object a(InterfaceC0199a interfaceC0199a, InterfaceC4014c<? super h> interfaceC4014c);
}
