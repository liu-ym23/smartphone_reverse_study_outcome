package rb;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voice.support.C3081a;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.Map;
import kotlin.Metadata;
import kotlinx.serialization.descriptors.SerialDescriptor;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J8\u0010\u000b\u001a\u00020\n\"\b\b\u0000\u0010\u0004*\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\u0006\u0010\t\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0004\b\u000b\u0010\fJ;\u0010\u000f\u001a\u00028\u0000\"\b\b\u0000\u0010\u0004*\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\r¢\u0006\u0004\b\u000f\u0010\u0010J2\u0010\u0011\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0004*\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0086\u0002¢\u0006\u0004\b\u0011\u0010\u0012R<\u0010\u0016\u001a*\u0012\u0004\u0012\u00020\u0005\u0012 \u0012\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0007\u0012\u0004\u0012\u00020\u00010\u0013j\b\u0012\u0004\u0012\u00020\u0001`\u00140\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0015¨\u0006\u0017"}, d2 = {"Lrb/p;", "", "<init>", "()V", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "Lrb/p$a;", "key", UxipConstants.f30680s, "LY8/t;", "c", "(Lkotlinx/serialization/descriptors/SerialDescriptor;Lrb/p$a;Ljava/lang/Object;)V", "Lkotlin/Function0;", "defaultValue", Const.INTENT_KEY_PKGNAME, "(Lkotlinx/serialization/descriptors/SerialDescriptor;Lrb/p$a;Lp9/a;)Ljava/lang/Object;", Const.INTENT_KEY_APIKEY, "(Lkotlinx/serialization/descriptors/SerialDescriptor;Lrb/p$a;)Ljava/lang/Object;", "", "Lkotlinx/serialization/json/internal/DescriptorData;", "Ljava/util/Map;", C3081a.FOCUS_MAP_NAME, "kotlinx-serialization-json"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: rb.p, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5266p {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Map<SerialDescriptor, Map<a<Object>, Object>> map = C5265o.a(16);

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lrb/p$a;", "", ExifInterface.GPS_DIRECTION_TRUE, "<init>", "()V", "kotlinx-serialization-json"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: rb.p$a */
    public static final class a<T> {
    }

    public final <T> T a(SerialDescriptor descriptor, a<T> key) {
        kotlin.jvm.internal.p.i(descriptor, "descriptor");
        kotlin.jvm.internal.p.i(key, "key");
        Map<a<Object>, Object> map = this.map.get(descriptor);
        T t10 = map != null ? (T) map.get(key) : null;
        if (t10 == null) {
            return null;
        }
        return t10;
    }

    public final <T> T b(SerialDescriptor descriptor, a<T> key, InterfaceC5063a<? extends T> defaultValue) {
        kotlin.jvm.internal.p.i(descriptor, "descriptor");
        kotlin.jvm.internal.p.i(key, "key");
        kotlin.jvm.internal.p.i(defaultValue, "defaultValue");
        T t10 = (T) a(descriptor, key);
        if (t10 != null) {
            return t10;
        }
        T tInvoke = defaultValue.invoke();
        c(descriptor, key, tInvoke);
        return tInvoke;
    }

    public final <T> void c(SerialDescriptor descriptor, a<T> key, T value) {
        kotlin.jvm.internal.p.i(descriptor, "descriptor");
        kotlin.jvm.internal.p.i(key, "key");
        kotlin.jvm.internal.p.i(value, "value");
        Map<SerialDescriptor, Map<a<Object>, Object>> map = this.map;
        Map<a<Object>, Object> mapA = map.get(descriptor);
        if (mapA == null) {
            mapA = C5265o.a(2);
            map.put(descriptor, mapA);
        }
        mapA.put(key, value);
    }
}
