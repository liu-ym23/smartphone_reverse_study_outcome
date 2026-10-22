package bs8;

import com.larus.bmhome.taskskill.model.PcDevice;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<PcDevice> f20303a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<PcDevice> f20304b;

    public e() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f20303a, r101.f20303a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f20304b, r101.f20304b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f20303a.hashCode() * 31) + this.f20304b.hashCode();
    }

    public final String toString() {
        return "GroupedDeviceCollection(availableDevices=" + this.f20303a + ", notAvailableDevices=" + this.f20304b + ')';
    }

    public final List<PcDevice> a() {
        return CollectionsKt.plus(this.f20303a, this.f20304b);
    }

    public /* synthetic */ e(int r100) {
        this(CollectionsKt.emptyList(), CollectionsKt.emptyList());
    }

    public e(List<PcDevice> r100, List<PcDevice> r101) {
        Intrinsics.checkNotNullParameter(r100, "availableDevices");
        Intrinsics.checkNotNullParameter(r101, "notAvailableDevices");
        this.f20303a = r100;
        this.f20304b = r101;
    }
}
