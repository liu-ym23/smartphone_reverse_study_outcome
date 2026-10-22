package com.bytedance.android.live.revlink.link.core.layoutstatus;

import com.bytedance.android.live.core.utils.b0;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.CompositeDisposable;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class ValidStreamsSnapShot implements c<Map<String, ? extends com.bytedance.android.live.revlink.link.infra.rtcbiz.d>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f98285a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<String, com.bytedance.android.live.revlink.link.infra.rtcbiz.d> f98286b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.android.live.revlink.link.infra.rtcbiz.b f98287c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d f98288d;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.core.layoutstatus.ValidStreamsSnapShot$attach$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\u0016\u0010\u0004\u001a\u0012\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u00030\u0000¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "", "Lcom/bytedance/android/live/revlink/link/utils/LinkerID;", "Lcom/bytedance/android/live/revlink/link/infra/rtcbiz/d;", "p1", "", AbsMethodDelegate.TAG_INVOKE, "(Ljava/util/Map;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Map<String, ? extends com.bytedance.android.live.revlink.link.infra.rtcbiz.d>, Unit> {
        public AnonymousClass1(ValidStreamsSnapShot r100) {
            super(1, r100, ValidStreamsSnapShot.class, "onRenderFramesUpdate", "onRenderFramesUpdate(Ljava/util/Map;)V", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Map<String, com.bytedance.android.live.revlink.link.infra.rtcbiz.d> r100) {
            Intrinsics.checkNotNullParameter(r100, "p1");
            ValidStreamsSnapShot r101 = (ValidStreamsSnapShot) this.receiver;
            if (r101.a(r101.f98286b, r100) == true) goto L7;
            r101.f98286b = r100;
            r101.f98288d.requestLayout();
            return;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Map<String, ? extends com.bytedance.android.live.revlink.link.infra.rtcbiz.d> r100) {
            invoke2(r100);
            return Unit.INSTANCE;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.revlink.link.core.layoutstatus.c
    public final void attach() {
        jy0.b.c("ValidStreamsSnapShot", "attach with validStream: " + this.f98286b, null, 4);
        com.bytedance.revenue.platform.api.core.rx.f.a(b0.a(this.f98287c.getRenderFrames(), new AnonymousClass1(this)), this.f98285a);
    }

    @Override // com.bytedance.android.live.revlink.link.core.layoutstatus.c
    public final void detach() {
        this.f98285a.clear();
        this.f98286b = MapsKt.emptyMap();
        jy0.b.c("ValidStreamsSnapShot", "attach with validStream: " + this.f98286b, null, 4);
    }

    public ValidStreamsSnapShot(com.bytedance.android.live.revlink.link.infra.rtcbiz.b r100, h r101) {
        Intrinsics.checkNotNullParameter(r100, "rtcDataContext");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f98287c = r100;
        this.f98288d = r101;
        this.f98285a = new CompositeDisposable();
        this.f98286b = MapsKt.emptyMap();
    }

    public final boolean a(Map<String, com.bytedance.android.live.revlink.link.infra.rtcbiz.d> r100, Map<String, com.bytedance.android.live.revlink.link.infra.rtcbiz.d> r101) {
        if (r100 != null) goto L7;
        if (r101 != null) goto L7;
        return true;
    L7:
        if (r100 == null) goto L19;
        if (r101 == null) goto L19;
        if (r100.size() != r101.size()) goto L19;
        Iterator<T> r102 = r100.keySet().iterator();
    L14:
        if (r102.hasNext() == false) goto L18;
        if (r101.containsKey((String) r102.next()) == true) goto L14;
        return false;
    L18:
        return true;
    L19:
        return false;
    }
}
