package s9;

import androidx.exifinterface.media.ExifInterface;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import w9.InterfaceC5752k;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00028\u00000\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00028\u0000¢\u0006\u0004\b\u0005\u0010\u0006J+\u0010\f\u001a\u00020\u000b2\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u00072\u0006\u0010\t\u001a\u00028\u00002\u0006\u0010\n\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\f\u0010\rJ+\u0010\u000f\u001a\u00020\u000e2\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u00072\u0006\u0010\t\u001a\u00028\u00002\u0006\u0010\n\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u000f\u0010\u0010J&\u0010\u0012\u001a\u00028\u00002\b\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0007H\u0096\u0002¢\u0006\u0004\b\u0012\u0010\u0013J.\u0010\u0015\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u00072\u0006\u0010\u0014\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u0016\u0010\u0014\u001a\u00028\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u001a¨\u0006\u001b"}, d2 = {"Ls9/c;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Ls9/e;", "", "initialValue", "<init>", "(Ljava/lang/Object;)V", "Lw9/k;", "property", "oldValue", "newValue", "", "beforeChange", "(Lw9/k;Ljava/lang/Object;Ljava/lang/Object;)Z", "LY8/t;", "afterChange", "(Lw9/k;Ljava/lang/Object;Ljava/lang/Object;)V", "thisRef", "getValue", "(Ljava/lang/Object;Lw9/k;)Ljava/lang/Object;", UxipConstants.f30680s, "setValue", "(Ljava/lang/Object;Lw9/k;Ljava/lang/Object;)V", "", "toString", "()Ljava/lang/String;", "Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: s9.c, reason: case insensitive filesystem and from toString */
/* loaded from: classes4.dex */
public abstract class ObservableProperty<V> implements InterfaceC5453e<Object, V> {
    private V value;

    public ObservableProperty(V v10) {
        this.value = v10;
    }

    public void afterChange(InterfaceC5752k<?> property, V oldValue, V newValue) {
        p.i(property, "property");
    }

    public boolean beforeChange(InterfaceC5752k<?> property, V oldValue, V newValue) {
        p.i(property, "property");
        return true;
    }

    @Override // s9.InterfaceC5453e, s9.InterfaceC5452d
    public V getValue(Object thisRef, InterfaceC5752k<?> property) {
        p.i(property, "property");
        return this.value;
    }

    @Override // s9.InterfaceC5453e
    public void setValue(Object thisRef, InterfaceC5752k<?> property, V value) {
        p.i(property, "property");
        V v10 = this.value;
        if (beforeChange(property, v10, value)) {
            this.value = value;
            afterChange(property, v10, value);
        }
    }

    public String toString() {
        return "ObservableProperty(value=" + this.value + ')';
    }
}
