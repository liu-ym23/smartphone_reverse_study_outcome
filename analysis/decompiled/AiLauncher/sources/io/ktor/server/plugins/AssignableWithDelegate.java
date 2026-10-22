package io.ktor.server.plugins;

import androidx.exifinterface.media.ExifInterface;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;
import w9.InterfaceC5752k;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0004\b\u0005\u0010\u0006J$\u0010\t\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00020\u00012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\bH\u0086\u0002¢\u0006\u0004\b\t\u0010\nJ,\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\b2\u0006\u0010\u000b\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0004\b\r\u0010\u000eR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0012\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lio/ktor/server/plugins/AssignableWithDelegate;", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function0;", "property", "<init>", "(Lp9/a;)V", "thisRef", "Lw9/k;", "getValue", "(Ljava/lang/Object;Lw9/k;)Ljava/lang/Object;", UxipConstants.f30680s, "LY8/t;", "setValue", "(Ljava/lang/Object;Lw9/k;Ljava/lang/Object;)V", "Lp9/a;", "getProperty", "()Lp9/a;", "assigned", "Ljava/lang/Object;", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
final class AssignableWithDelegate<T> {
    private T assigned;
    private final InterfaceC5063a<T> property;

    /* JADX WARN: Multi-variable type inference failed */
    public AssignableWithDelegate(InterfaceC5063a<? extends T> property) {
        p.i(property, "property");
        this.property = property;
    }

    public final InterfaceC5063a<T> getProperty() {
        return this.property;
    }

    public final T getValue(Object thisRef, InterfaceC5752k<?> property) {
        p.i(thisRef, "thisRef");
        p.i(property, "property");
        T t10 = this.assigned;
        return t10 == null ? this.property.invoke() : t10;
    }

    public final void setValue(Object thisRef, InterfaceC5752k<?> property, T value) {
        p.i(thisRef, "thisRef");
        p.i(property, "property");
        p.i(value, "value");
        this.assigned = value;
    }
}
