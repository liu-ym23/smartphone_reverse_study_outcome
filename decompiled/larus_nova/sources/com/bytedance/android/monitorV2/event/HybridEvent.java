package com.bytedance.android.monitorV2.event;

import com.bytedance.android.monitorV2.entity.NativeCommon;
import com.bytedance.android.monitorV2.executor.HybridMonitorSingleExecutor;
import com.bytedance.android.monitorV2.hybridSetting.Switches;
import com.bytedance.android.monitorV2.listener.g;
import com.bytedance.android.monitorV2.util.f;
import com.bytedance.android.monitorV2.util.l;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import gz2.e;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public class HybridEvent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f163001a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f163002b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f163003c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f163004d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, Object> f163005e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public NativeCommon f163006f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public JSONObject f163007g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public jz2.a f163008h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f163009i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f163010j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Map<String, Object> f163011k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final gz2.d f163012l;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/monitorV2/event/HybridEvent$EventPhase;", "", "EVENT_CREATE", "EVENT_TERMINATED", "SAMPLE_THROW", "EVENT_UPLOAD", "EVENT_UPDATED", "anniex_release"}, k = 1, mv = {1, 4, 3})
    public static final enum EventPhase extends Enum<EventPhase> {
        public static final EventPhase EVENT_CREATE = null;
        public static final EventPhase EVENT_TERMINATED = null;
        public static final EventPhase EVENT_UPDATED = null;
        public static final EventPhase EVENT_UPLOAD = null;
        public static final EventPhase SAMPLE_THROW = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ EventPhase[] f163013a = null;

        public static EventPhase valueOf(String r100) {
            return (EventPhase) r27.a.a(EventPhase.class, r100);
        }

        public static EventPhase[] values() {
            return (EventPhase[]) f163013a.clone();
        }

        static {
            EventPhase r100 = new EventPhase("EVENT_CREATE", 0);
            EVENT_CREATE = r100;
            EventPhase r101 = new EventPhase("EVENT_TERMINATED", 1);
            EVENT_TERMINATED = r101;
            EventPhase r102 = new EventPhase("SAMPLE_THROW", 2);
            SAMPLE_THROW = r102;
            EventPhase r103 = new EventPhase("EVENT_UPLOAD", 3);
            EVENT_UPLOAD = r103;
            EventPhase r104 = new EventPhase("EVENT_UPDATED", 4);
            EVENT_UPDATED = r104;
            f163013a = new EventPhase[]{r100, r101, r102, r103, r104};
        }

        public EventPhase(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/monitorV2/event/HybridEvent$TerminateType;", "", "SWITCH_OFF", "PARAM_EXCEPTION", "CATCH_EXCEPTION", "EVENT_REPEATED", "INVALID_CASE", "HOST_VIEW_DESTROYED", "BLOCK_LIST", "anniex_release"}, k = 1, mv = {1, 4, 3})
    public static final enum TerminateType extends Enum<TerminateType> {
        public static final TerminateType BLOCK_LIST = null;
        public static final TerminateType CATCH_EXCEPTION = null;
        public static final TerminateType EVENT_REPEATED = null;
        public static final TerminateType HOST_VIEW_DESTROYED = null;
        public static final TerminateType INVALID_CASE = null;
        public static final TerminateType PARAM_EXCEPTION = null;
        public static final TerminateType SWITCH_OFF = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TerminateType[] f163014a = null;

        public static TerminateType valueOf(String r100) {
            return (TerminateType) r27.a.a(TerminateType.class, r100);
        }

        public static TerminateType[] values() {
            return (TerminateType[]) f163014a.clone();
        }

        static {
            TerminateType r100 = new TerminateType("SWITCH_OFF", 0);
            SWITCH_OFF = r100;
            TerminateType r101 = new TerminateType("PARAM_EXCEPTION", 1);
            PARAM_EXCEPTION = r101;
            TerminateType r102 = new TerminateType("CATCH_EXCEPTION", 2);
            CATCH_EXCEPTION = r102;
            TerminateType r103 = new TerminateType("EVENT_REPEATED", 3);
            EVENT_REPEATED = r103;
            TerminateType r104 = new TerminateType("INVALID_CASE", 4);
            INVALID_CASE = r104;
            TerminateType r105 = new TerminateType("HOST_VIEW_DESTROYED", 5);
            HOST_VIEW_DESTROYED = r105;
            TerminateType r110 = new TerminateType("BLOCK_LIST", 6);
            BLOCK_LIST = r110;
            f163014a = new TerminateType[]{r100, r101, r102, r103, r104, r105, r110};
        }

        public TerminateType(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/monitorV2/event/HybridEvent$TransferTarget;", "", "Slardar", "Tea", "Both", "anniex_release"}, k = 1, mv = {1, 4, 3})
    public static final enum TransferTarget extends Enum<TransferTarget> {
        public static final TransferTarget Both = null;
        public static final TransferTarget Slardar = null;
        public static final TransferTarget Tea = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TransferTarget[] f163015a = null;

        public static TransferTarget valueOf(String r100) {
            return (TransferTarget) r27.a.a(TransferTarget.class, r100);
        }

        public static TransferTarget[] values() {
            return (TransferTarget[]) f163015a.clone();
        }

        static {
            TransferTarget r100 = new TransferTarget("Slardar", 0);
            Slardar = r100;
            TransferTarget r101 = new TransferTarget("Tea", 1);
            Tea = r101;
            TransferTarget r102 = new TransferTarget("Both", 2);
            Both = r102;
            f163015a = new TransferTarget[]{r100, r101, r102};
        }

        public TransferTarget(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public EventPhase f163016a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public TerminateType f163017b;

        public a() {
        }
    }

    public final UUID a() {
        return (UUID) this.f163002b.getValue();
    }

    public final List<String> b() {
        jz2.a r100 = this.f163008h;
        if (r100 == null) goto L5;
        JSONObject r101 = r100.toJsonObject();
    L6:
        String r102 = l.l(r101, "schema");
        if ((this instanceof com.bytedance.android.monitorV2.event.a) == false) goto L12;
        String r103 = this.f163006f.url;
        if (r103 != null) goto L18;
    L16:
        r103 = "";
    L18:
        return CollectionsKt.arrayListOf(new String[]{r103, r102});
    L12:
        if ((this instanceof b) == false) goto L16;
        r103 = ((b) this).f163022m.f501101a;
        if (r103 == null) goto L16;
    L5:
        r101 = null;
        goto L6
    }

    public final void c() {
        if (Switches.eventStream.isEnabled() == true) goto L5;
        return;
    L5:
        Lazy r100 = HybridMonitorSingleExecutor.f163031a;
        HybridMonitorSingleExecutor.a(new HybridEvent$onEventCreated$1(this));
    }

    public final void d() {
        if (Switches.eventStream.isEnabled() == true) goto L5;
        return;
    L5:
        Lazy r100 = HybridMonitorSingleExecutor.f163031a;
        HybridMonitorSingleExecutor.a(new HybridEvent$onEventSampled$1(this));
    }

    public final void e() {
        if (Switches.eventStream.isEnabled() == true) goto L5;
        return;
    L5:
        Lazy r100 = HybridMonitorSingleExecutor.f163031a;
        HybridMonitorSingleExecutor.a(new HybridEvent$onEventUpdated$1(this));
    }

    public final void f() {
        if (Switches.eventStream.isEnabled() == true) goto L5;
        return;
    L5:
        Lazy r100 = HybridMonitorSingleExecutor.f163031a;
        HybridMonitorSingleExecutor.a(new HybridEvent$onEventUploaded$1(this));
    }

    public final String toString() {
        return "HybridEvent(eventType='" + this.f163001a + "', eventId=" + a() + ", state=" + this.f163004d + ')';
    }

    public HybridEvent(String r100) {
        Intrinsics.checkNotNullParameter(r100, "eventType");
        this.f163001a = r100;
        this.f163002b = LazyKt.lazy(HybridEvent$eventId$2.INSTANCE);
        this.f163004d = new a();
        this.f163005e = new LinkedHashMap();
        this.f163006f = new NativeCommon();
        TransferTarget r101 = TransferTarget.Slardar;
        this.f163009i = "__hybrid_default";
        this.f163010j = "default_bid";
        CopyOnWriteArrayList<g> r102 = e.f483376a;
        this.f163012l = new gz2.d();
    }

    public final void g(Object r100) {
        Intrinsics.checkNotNullParameter("regex_source", "key");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L8
        if (this.f163011k != null) goto L6;
        this.f163011k = new LinkedHashMap();     // Catch: Throwable -> L8
    L6:
        Map<String, Object> r102 = this.f163011k;     // Catch: Throwable -> L8
        Intrinsics.checkNotNull(r102);     // Catch: Throwable -> L8
        r102.put("regex_source", r100);     // Catch: Throwable -> L8
        Object r103 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L16;
        f.b(r104);
        return;
    L16:
        return;
    L8:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    public final void h(NativeCommon r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f163006f = r100;
    }

    public final void onEventTerminated(TerminateType r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        this.f163004d.f163017b = r100;
        if (Switches.eventStream.isEnabled() == true) goto L5;
        return;
    L5:
        Lazy r101 = HybridMonitorSingleExecutor.f163031a;
        HybridMonitorSingleExecutor.a(new AnonymousClass1(this));
    }

    public final void i(boolean r100, TerminateType r101) {
        Intrinsics.checkNotNullParameter(r101, "reason");
        if (r100 == false) goto L25;
        String r102 = "Event terminated, type = " + r101.name();
        nz2.c r103 = nz2.b.f521377c;
        String r104 = nz2.b.d("HBMonitorSDK_V2");
        r103.getClass();
        HybridLogger r105 = HybridLogger.f246343a;
        if (HybridLogger.c(r104, r102, LogLevel.W) == false) goto L8;
    L20:
        onEventTerminated(r101);
        return;
    L8:
        if (r102.length() <= 3000) goto L16;
        if (nz2.c.f521378a == false) goto L12;
    L13:
        r102.substring(0, 3000);
    L14:
        r102 = r102.substring(3000);
        goto L8
    L12:
        if (nz2.a.c(nz2.a.b("w"), r104, r102.substring(0, 3000)) == true) goto L14;
    L16:
        if (nz2.c.f521378a == true) goto L20;
        if (nz2.a.c(nz2.a.b("w"), r104, r102) == true) goto L20;
        goto L20
    }
}
