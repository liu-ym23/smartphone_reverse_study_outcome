package C;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00028\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\rR\u0014\u0010\u0010\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u000fR$\u0010\u0014\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00040\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"LC/s;", ExifInterface.GPS_DIRECTION_TRUE, "", UxipConstants.f30680s, "LC/g;", "defaultFinalizer", "<init>", "(Ljava/lang/Object;LC/g;)V", Const.INTENT_KEY_APIKEY, "()Ljava/lang/Object;", "LY8/t;", Const.INTENT_KEY_PKGNAME, "()V", "Ljava/lang/Object;", "LOa/c;", "LOa/c;", "count", "LOa/e;", "c", "LOa/e;", "currentFinalizer", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class s<T> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final T value;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final Oa.c count;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public Oa.e<g<T>> currentFinalizer;

    public s(T t10, g<? super T> defaultFinalizer) {
        kotlin.jvm.internal.p.i(defaultFinalizer, "defaultFinalizer");
        this.value = t10;
        this.count = Oa.b.c(1);
        this.currentFinalizer = Oa.b.g(defaultFinalizer);
    }

    public final T a() {
        int value;
        int i10;
        Oa.c cVar = this.count;
        do {
            value = cVar.getValue();
            i10 = value == 0 ? 0 : value + 1;
        } while (!cVar.a(value, i10));
        if (i10 != 0) {
            return this.value;
        }
        return null;
    }

    public final void b() {
        if (this.count.b() == 0) {
            g<T> gVarB = this.currentFinalizer.b(null);
            kotlin.jvm.internal.p.f(gVarB);
            gVarB.a(this.value);
        }
    }
}
