package q3;

import com.google.android.gms.common.internal.C1668i;
import com.google.mlkit.common.sdkinternal.ModelType;
import com.google.mlkit.common.sdkinternal.model.BaseModel;
import java.util.EnumMap;
import java.util.Map;
import y2.C5932m;
import y2.C5933n;

/* renamed from: q3.b, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC5146b {

    /* renamed from: d, reason: collision with root package name */
    public static final Map f38598d = new EnumMap(BaseModel.class);

    /* renamed from: e, reason: collision with root package name */
    public static final Map f38599e = new EnumMap(BaseModel.class);

    /* renamed from: a, reason: collision with root package name */
    public final String f38600a;

    /* renamed from: b, reason: collision with root package name */
    public final BaseModel f38601b;

    /* renamed from: c, reason: collision with root package name */
    public final ModelType f38602c;

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC5146b)) {
            return false;
        }
        AbstractC5146b abstractC5146b = (AbstractC5146b) obj;
        return C1668i.a(this.f38600a, abstractC5146b.f38600a) && C1668i.a(this.f38601b, abstractC5146b.f38601b) && C1668i.a(this.f38602c, abstractC5146b.f38602c);
    }

    public int hashCode() {
        return C1668i.b(this.f38600a, this.f38601b, this.f38602c);
    }

    public String toString() {
        C5932m c5932mA = C5933n.a("RemoteModel");
        c5932mA.a("modelName", this.f38600a);
        c5932mA.a("baseModel", this.f38601b);
        c5932mA.a("modelType", this.f38602c);
        return c5932mA.toString();
    }
}
