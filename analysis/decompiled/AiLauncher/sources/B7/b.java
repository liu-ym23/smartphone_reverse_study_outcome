package B7;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import io.ktor.http.ContentDisposition;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import v9.C5685n;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\t\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ%\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000b¢\u0006\u0004\b\u0012\u0010\u0013J-\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000b¢\u0006\u0004\b\u0015\u0010\u0016J5\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u000b¢\u0006\u0004\b\u0018\u0010\u0019J%\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001d\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u001f\u0010 J\r\u0010\"\u001a\u00020!¢\u0006\u0004\b\"\u0010#J\u0013\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00060$¢\u0006\u0004\b%\u0010&R\u0016\u0010(\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010'R\u0016\u0010*\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010)R \u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00020+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010,R \u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00020+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010,¨\u0006/"}, d2 = {"LB7/b;", "", "", "capacity", "<init>", "(I)V", "", "name", "floatCount", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;I)I", "", UxipConstants.f30680s, "LY8/t;", "f", "(Ljava/lang/String;F)V", "x", "y", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;FF)V", "z", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/lang/String;FFF)V", "w", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/lang/String;FFFF)V", "component", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ljava/lang/String;IF)V", Const.INTENT_KEY_UMID, "(Ljava/lang/String;)Ljava/lang/Integer;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)I", "", "e", "()[F", "", "c", "()Ljava/util/Set;", "[F", "data", "I", ContentDisposition.Parameters.Size, "", "Ljava/util/Map;", "nameToOffset", "nameToSize", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public float[] data;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public int size;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final Map<String, Integer> nameToOffset;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final Map<String, Integer> nameToSize;

    public b(int i10) {
        this.data = new float[i10];
        this.nameToOffset = new LinkedHashMap();
        this.nameToSize = new LinkedHashMap();
    }

    public final int a(String name, int floatCount) {
        p.i(name, "name");
        int i10 = this.size;
        int i11 = i10 + floatCount;
        float[] fArr = this.data;
        if (i11 > fArr.length) {
            float[] fArrCopyOf = Arrays.copyOf(fArr, C5685n.f(fArr.length * 2, i10 + floatCount));
            p.h(fArrCopyOf, "copyOf(...)");
            this.data = fArrCopyOf;
        }
        this.nameToOffset.put(name, Integer.valueOf(i10));
        this.nameToSize.put(name, Integer.valueOf(floatCount));
        this.size += floatCount;
        return i10;
    }

    public final int b(String name) {
        p.i(name, "name");
        Integer num = this.nameToSize.get(name);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public final Set<String> c() {
        return this.nameToOffset.keySet();
    }

    public final Integer d(String name) {
        p.i(name, "name");
        return this.nameToOffset.get(name);
    }

    /* renamed from: e, reason: from getter */
    public final float[] getData() {
        return this.data;
    }

    public final void f(String name, float value) {
        p.i(name, "name");
        Integer num = this.nameToOffset.get(name);
        if (num != null) {
            this.data[num.intValue()] = value;
        }
    }

    public final void g(String name, float x10, float y10) {
        p.i(name, "name");
        Integer num = this.nameToOffset.get(name);
        if (num != null) {
            int iIntValue = num.intValue();
            float[] fArr = this.data;
            fArr[iIntValue] = x10;
            fArr[iIntValue + 1] = y10;
        }
    }

    public final void h(String name, float x10, float y10, float z10) {
        p.i(name, "name");
        Integer num = this.nameToOffset.get(name);
        if (num != null) {
            int iIntValue = num.intValue();
            float[] fArr = this.data;
            fArr[iIntValue] = x10;
            fArr[iIntValue + 1] = y10;
            fArr[iIntValue + 2] = z10;
        }
    }

    public final void i(String name, float x10, float y10, float z10, float w10) {
        p.i(name, "name");
        Integer num = this.nameToOffset.get(name);
        if (num != null) {
            int iIntValue = num.intValue();
            float[] fArr = this.data;
            fArr[iIntValue] = x10;
            fArr[iIntValue + 1] = y10;
            fArr[iIntValue + 2] = z10;
            fArr[iIntValue + 3] = w10;
        }
    }

    public final void j(String name, int component, float value) {
        p.i(name, "name");
        Integer num = this.nameToOffset.get(name);
        if (num != null) {
            this.data[num.intValue() + component] = value;
        }
    }

    public /* synthetic */ b(int i10, int i11, i iVar) {
        this((i11 & 1) != 0 ? 64 : i10);
    }
}
