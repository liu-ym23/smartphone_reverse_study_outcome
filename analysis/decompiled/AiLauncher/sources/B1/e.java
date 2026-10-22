package B1;

import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0002H\u0096@¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0096\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0010¨\u0006\u0011"}, d2 = {"LB1/e;", "LB1/h;", "LB1/g;", ContentDisposition.Parameters.Size, "<init>", "(LB1/g;)V", Const.INTENT_KEY_APIKEY, "(Le9/c;)Ljava/lang/Object;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "LB1/g;", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class e implements h {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Size size;

    public e(Size size) {
        this.size = size;
    }

    @Override // B1.h
    public Object a(InterfaceC4014c<? super Size> interfaceC4014c) {
        return this.size;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof e) && p.d(this.size, ((e) other).size);
    }

    public int hashCode() {
        return this.size.hashCode();
    }
}
