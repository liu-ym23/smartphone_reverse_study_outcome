package com.bytedance.android.live.openplatform.impl.minigameaudience.applog;

import android.os.SystemClock;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContextService;
import com.bytedance.android.live.openplatform.impl.minigamecommon.context.OnMiniGameLifecycleChangeListener;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/minigameaudience/applog/RoomWatchDurationContextService;", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContextService;", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;", "miniGameContext", "<init>", "(Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;)V", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RoomWatchDurationContextService extends OpenPlatformContextService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f85283a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f85284b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f85285c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f85286d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f85287e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final a f85288f;

    public static final class a implements OnMiniGameLifecycleChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RoomWatchDurationContextService f85289a;

        @Override // com.bytedance.android.live.openplatform.impl.minigamecommon.context.OnMiniGameLifecycleChangeListener
        public final void a() {
            this.f85289a.f85285c = true;
        }

        @Override // com.bytedance.android.live.openplatform.impl.minigamecommon.context.OnMiniGameLifecycleChangeListener
        public final void b() {
            RoomWatchDurationContextService r100 = this.f85289a;
            r100.f85285c = false;
            r100.f85287e = false;
        }

        @Override // com.bytedance.android.live.openplatform.impl.minigamecommon.context.OnMiniGameLifecycleChangeListener
        public final void c() {
            RoomWatchDurationContextService r100 = this.f85289a;
            if (r100.f85287e == false) goto L5;
            return;
        L5:
            if (r100.f85285c == true) goto L7;
            return;
        L7:
            if (r100.f85286d == false) goto L12;
            r100.f();
            return;
        }

        @Override // com.bytedance.android.live.openplatform.impl.minigamecommon.context.OnMiniGameLifecycleChangeListener
        public final void d() {
            RoomWatchDurationContextService r100 = this.f85289a;
            r100.f85285c = false;
            r100.f85287e = false;
        }

        @Override // com.bytedance.android.live.openplatform.impl.minigamecommon.context.OnMiniGameLifecycleChangeListener
        public final void e() {
            RoomWatchDurationContextService r100 = this.f85289a;
            if ((-1) == r100.f85284b) goto L5;
            return;
        L5:
            if (r100.f85287e == true) goto L9;
            r100.f85284b = SystemClock.elapsedRealtime();
            return;
        }

        public a(RoomWatchDurationContextService r100) {
            this.f85289a = r100;
        }
    }

    public final void f() {
        if (this.f85284b > 0) goto L5;
        return;
    L5:
        long r100 = SystemClock.elapsedRealtime() - this.f85284b;
        this.f85284b = -1;
        AudienceMiniGameAppLogContextService r101 = (AudienceMiniGameAppLogContextService) getOpenPlatformContext().getService(AudienceMiniGameAppLogContextService.class);
        HashMap<String, String> r102 = new HashMap();
        r102.put("duration", String.valueOf(r100));
        Unit r103 = Unit.INSTANCE;
        r101.h("mp_live_watch_duration", r102);
    }

    @Override // com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContextService
    public final void onDestroy() {
        super.onDestroy();
        int r100 = qo0.a.f534145a;
        qo0.a.c(this.f85283a, LiveCommonConstants.REASON_ON_DEDTROY);
        f();
        this.f85284b = -1;
        this.f85285c = false;
        this.f85287e = false;
    }

    public RoomWatchDurationContextService(OpenPlatformContext r100) {
        Intrinsics.checkNotNullParameter(r100, "miniGameContext");
        super(r100);
        this.f85283a = "RoomWatchDurationManager";
        this.f85284b = -1;
        this.f85288f = new a(this);
    }
}
