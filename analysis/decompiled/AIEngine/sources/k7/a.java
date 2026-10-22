package k7;

import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class a {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: k7.a$a, reason: collision with other inner class name */
    public static final class C0101a extends a {

        /* renamed from: a, reason: collision with root package name */
        public final String f9951a = "Task executed by AITaskSupervisor";

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof C0101a) && g.b(this.f9951a, ((C0101a) obj).f9951a);
        }

        public final int hashCode() {
            String str = this.f9951a;
            return (str == null ? 0 : str.hashCode()) * 31;
        }

        public final String toString() {
            return "Success(data=" + ((Object) this.f9951a) + ", metrics=null)";
        }
    }
}
