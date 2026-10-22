package rb;

import Z8.C1168p;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Arrays;
import kotlin.Metadata;
import kotlinx.serialization.descriptors.SerialDescriptor;
import nb.AbstractC4960m;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\u0006¢\u0006\u0004\b\u0010\u0010\u0003J\r\u0010\u0011\u001a\u00020\u0006¢\u0006\u0004\b\u0011\u0010\u0003J\r\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0015\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0016\u0010\u0003R\u001e\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u001d¨\u0006\u001f"}, d2 = {"Lrb/v;", "", "<init>", "()V", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "sd", "LY8/t;", "c", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "", "index", Const.INTENT_KEY_BACKGROUND_COMMAND, "(I)V", "key", "f", "(Ljava/lang/Object;)V", Const.INTENT_KEY_UMID, Const.INTENT_KEY_PKGNAME, "", Const.INTENT_KEY_APIKEY, "()Ljava/lang/String;", "toString", "e", "", "[Ljava/lang/Object;", "currentObjectPath", "", "[I", "indicies", "I", "currentDepth", "kotlinx-serialization-json"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class v {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public Object[] currentObjectPath = new Object[8];

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public int[] indicies;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public int currentDepth;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lrb/v$a;", "", "<init>", "()V", "kotlinx-serialization-json"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final a f39005a = new a();
    }

    public v() {
        int[] iArr = new int[8];
        for (int i10 = 0; i10 < 8; i10++) {
            iArr[i10] = -1;
        }
        this.indicies = iArr;
        this.currentDepth = -1;
    }

    public final String a() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("$");
        int i10 = this.currentDepth + 1;
        for (int i11 = 0; i11 < i10; i11++) {
            Object obj = this.currentObjectPath[i11];
            if (obj instanceof SerialDescriptor) {
                SerialDescriptor serialDescriptor = (SerialDescriptor) obj;
                if (!kotlin.jvm.internal.p.d(serialDescriptor.getKind(), AbstractC4960m.b.f37294a)) {
                    int i12 = this.indicies[i11];
                    if (i12 >= 0) {
                        sb2.append(".");
                        sb2.append(serialDescriptor.e(i12));
                    }
                } else if (this.indicies[i11] != -1) {
                    sb2.append("[");
                    sb2.append(this.indicies[i11]);
                    sb2.append("]");
                }
            } else if (obj != a.f39005a) {
                sb2.append("[");
                sb2.append("'");
                sb2.append(obj);
                sb2.append("'");
                sb2.append("]");
            }
        }
        return sb2.toString();
    }

    public final void b() {
        int i10 = this.currentDepth;
        int[] iArr = this.indicies;
        if (iArr[i10] == -2) {
            iArr[i10] = -1;
            this.currentDepth = i10 - 1;
        }
        int i11 = this.currentDepth;
        if (i11 != -1) {
            this.currentDepth = i11 - 1;
        }
    }

    public final void c(SerialDescriptor sd) {
        kotlin.jvm.internal.p.i(sd, "sd");
        int i10 = this.currentDepth + 1;
        this.currentDepth = i10;
        if (i10 == this.currentObjectPath.length) {
            e();
        }
        this.currentObjectPath[i10] = sd;
    }

    public final void d() {
        int[] iArr = this.indicies;
        int i10 = this.currentDepth;
        if (iArr[i10] == -2) {
            this.currentObjectPath[i10] = a.f39005a;
        }
    }

    public final void e() {
        int i10 = this.currentDepth * 2;
        Object[] objArrCopyOf = Arrays.copyOf(this.currentObjectPath, i10);
        kotlin.jvm.internal.p.h(objArrCopyOf, "copyOf(...)");
        this.currentObjectPath = objArrCopyOf;
        int[] iArr = new int[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            iArr[i11] = -1;
        }
        C1168p.l(this.indicies, iArr, 0, 0, 0, 14, null);
        this.indicies = iArr;
    }

    public final void f(Object key) {
        int[] iArr = this.indicies;
        int i10 = this.currentDepth;
        if (iArr[i10] != -2) {
            int i11 = i10 + 1;
            this.currentDepth = i11;
            if (i11 == this.currentObjectPath.length) {
                e();
            }
        }
        Object[] objArr = this.currentObjectPath;
        int i12 = this.currentDepth;
        objArr[i12] = key;
        this.indicies[i12] = -2;
    }

    public final void g(int index) {
        this.indicies[this.currentDepth] = index;
    }

    public String toString() {
        return a();
    }
}
