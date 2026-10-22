package A;

import Ua.C1087w;
import Ua.InterfaceC1083u;
import Ua.Q;
import Y8.t;
import android.hardware.camera2.CaptureResult;
import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import p9.InterfaceC5074l;
import w.L;
import w.Result3A;
import w.x;
import w.y;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B3\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bB?\b\u0010\u0012\u001c\u0010\u0010\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\f\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u0011J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u001c\u0010\u001bJ\u000f\u0010\u001d\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u001d\u0010\u001bR \u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u001eR\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010\t\u001a\u0004\u0018\u00010\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010!R\u001a\u0010%\u001a\b\u0012\u0004\u0012\u00020#0\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010*\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010!R\u0018\u0010-\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0017\u00100\u001a\b\u0012\u0004\u0012\u00020#0.8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010/¨\u00061"}, d2 = {"LA/m;", "Landroidx/camera/camera2/pipe/graph/d;", "Lkotlin/Function1;", "Lw/x;", "", "exitCondition", "", "frameLimit", "", "timeLimitNs", "<init>", "(Lp9/l;Ljava/lang/Integer;Ljava/lang/Long;)V", "", "Landroid/hardware/camera2/CaptureResult$Key;", "", "", "exitConditionForKeys", "(Ljava/util/Map;Ljava/lang/Integer;Ljava/lang/Long;)V", "Lw/L;", "requestNumber", "LY8/t;", "c", "(J)V", "frameMetadata", Const.INTENT_KEY_APIKEY, "(JLw/x;)Z", "f", "()V", Const.INTENT_KEY_UMID, Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "Lp9/l;", Const.INTENT_KEY_PKGNAME, "Ljava/lang/Integer;", "Ljava/lang/Long;", "LUa/u;", "Lw/N;", "LUa/u;", "_result", "Lw/y;", "e", "Lw/y;", "frameNumberOfFirstUpdate", "timestampOfFirstUpdateNs", Const.INTENT_KEY_BACKGROUND_COMMAND, "Lw/L;", "initialRequestNumber", "LUa/Q;", "()LUa/Q;", "result", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class m implements androidx.camera.camera2.pipe.graph.d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC5074l<x, Boolean> exitCondition;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final Integer frameLimit;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final Long timeLimitNs;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC1083u<Result3A> _result;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public volatile y frameNumberOfFirstUpdate;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public volatile Long timestampOfFirstUpdateNs;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public L initialRequestNumber;

    /* JADX WARN: Multi-variable type inference failed */
    public m(InterfaceC5074l<? super x, Boolean> exitCondition, Integer num, Long l10) {
        kotlin.jvm.internal.p.i(exitCondition, "exitCondition");
        this.exitCondition = exitCondition;
        this.frameLimit = num;
        this.timeLimitNs = l10;
        this._result = C1087w.c(null, 1, null);
    }

    @Override // androidx.camera.camera2.pipe.graph.d
    public boolean a(long requestNumber, x frameMetadata) {
        kotlin.jvm.internal.p.i(frameMetadata, "frameMetadata");
        if (this._result.g() || this._result.isCancelled()) {
            return true;
        }
        synchronized (this) {
            L l10 = this.initialRequestNumber;
            if (l10 != null && requestNumber >= l10.getValue()) {
                t tVar = t.f7040a;
                CaptureResult.Key SENSOR_TIMESTAMP = CaptureResult.SENSOR_TIMESTAMP;
                kotlin.jvm.internal.p.h(SENSOR_TIMESTAMP, "SENSOR_TIMESTAMP");
                Long l11 = (Long) frameMetadata.U(SENSOR_TIMESTAMP);
                long jM1 = frameMetadata.m1();
                if (l11 != null && this.timestampOfFirstUpdateNs == null) {
                    this.timestampOfFirstUpdateNs = l11;
                }
                Long l12 = this.timestampOfFirstUpdateNs;
                if (this.timeLimitNs != null && l12 != null && l11 != null && l11.longValue() - l12.longValue() > this.timeLimitNs.longValue()) {
                    this._result.complete(new Result3A(Result3A.a.INSTANCE.e(), frameMetadata, null));
                    return true;
                }
                if (this.frameNumberOfFirstUpdate == null) {
                    this.frameNumberOfFirstUpdate = y.a(jM1);
                }
                y yVar = this.frameNumberOfFirstUpdate;
                if (yVar != null && this.frameLimit != null && jM1 - yVar.getValue() > this.frameLimit.intValue()) {
                    this._result.complete(new Result3A(Result3A.a.INSTANCE.a(), frameMetadata, null));
                    return true;
                }
                if (!this.exitCondition.invoke(frameMetadata).booleanValue()) {
                    return false;
                }
                this._result.complete(new Result3A(Result3A.a.INSTANCE.b(), frameMetadata, null));
                return true;
            }
            return false;
        }
    }

    public final Q<Result3A> b() {
        return this._result;
    }

    @Override // androidx.camera.camera2.pipe.graph.d
    public void c(long requestNumber) {
        synchronized (this) {
            try {
                if (this.initialRequestNumber == null) {
                    this.initialRequestNumber = L.a(requestNumber);
                }
                t tVar = t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.camera.camera2.pipe.graph.GraphLoop.b
    public void d() {
        this._result.complete(new Result3A(Result3A.a.INSTANCE.c(), null, 2, null));
    }

    @Override // androidx.camera.camera2.pipe.graph.GraphLoop.b
    public void f() {
        this._result.complete(new Result3A(Result3A.a.INSTANCE.c(), null, 2, null));
    }

    @Override // androidx.camera.camera2.pipe.graph.GraphLoop.b
    public void h() {
        this._result.complete(new Result3A(Result3A.a.INSTANCE.c(), null, 2, null));
    }

    public /* synthetic */ m(InterfaceC5074l interfaceC5074l, Integer num, Long l10, int i10, kotlin.jvm.internal.i iVar) {
        this((InterfaceC5074l<? super x, Boolean>) interfaceC5074l, (i10 & 2) != 0 ? null : num, (i10 & 4) != 0 ? null : l10);
    }

    public /* synthetic */ m(Map map, Integer num, Long l10, int i10, kotlin.jvm.internal.i iVar) {
        this((Map<CaptureResult.Key<?>, ? extends List<? extends Object>>) map, (i10 & 2) != 0 ? null : num, (i10 & 4) != 0 ? null : l10);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public m(Map<CaptureResult.Key<?>, ? extends List<? extends Object>> exitConditionForKeys, Integer num, Long l10) {
        this(o.b(exitConditionForKeys), num, l10);
        kotlin.jvm.internal.p.i(exitConditionForKeys, "exitConditionForKeys");
    }
}
