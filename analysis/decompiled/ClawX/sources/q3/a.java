package q3;

import com.stepos.stepclaw.memory.lightmem.remote.OfflineUpdateFirstRequest;
import com.stepos.stepclaw.memory.lightmem.remote.OfflineUpdateGroupMessage;
import com.stepos.stepclaw.memory.lightmem.remote.OfflineUpdateResponse;
import com.stepos.stepclaw.memory.lightmem.remote.SearchItem;
import kotlinx.serialization.internal.EnumsKt;
import r4.d;
import u4.e;
import u4.f;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements p5.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4841a;

    public /* synthetic */ a(int i8) {
        this.f4841a = i8;
    }

    @Override // p5.a
    public final Object invoke() {
        switch (this.f4841a) {
            case 0:
                return OfflineUpdateFirstRequest._childSerializers$_anonymous_();
            case 1:
                return OfflineUpdateGroupMessage._childSerializers$_anonymous_();
            case 2:
                return OfflineUpdateResponse._childSerializers$_anonymous_();
            case 3:
                return SearchItem._childSerializers$_anonymous_();
            case 4:
                return new d();
            case 5:
                return EnumsKt.createSimpleEnumSerializer("io.ktor.util.date.WeekDay", f.values());
            default:
                return EnumsKt.createSimpleEnumSerializer("io.ktor.util.date.Month", e.values());
        }
    }
}
