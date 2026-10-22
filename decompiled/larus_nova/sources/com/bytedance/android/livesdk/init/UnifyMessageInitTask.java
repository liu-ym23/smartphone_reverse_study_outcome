package com.bytedance.android.livesdk.init;

import com.bytedance.android.live.core.launch.AbsTask;
import com.bytedance.android.live.core.launch.Task;
import com.bytedance.android.live.core.launch.WorkThreadTask;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.config.xi;
import com.bytedance.android.livesdk.config.yi;
import com.bytedance.android.livesdk.utils.d4;
import com.bytedance.android.livesdkapi.ws.GlobalUnifyMessageManager;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@WorkThreadTask
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0014¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/init/UnifyMessageInitTask;", "Lcom/bytedance/android/live/core/launch/AbsTask;", "()V", "injectMessagePlatform", "", "run", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
@Task(businessInfo = "WTO_UnifyMessageInitTask", value = 17)
public final class UnifyMessageInitTask extends AbsTask {

    public static final class a implements slc.a {
        public a() {
        }
    }

    public static final class b<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f132653a = null;

        static {
            f132653a = new b();
        }

        public b() {
        }
    }

    public static final class c extends com.ss.ugc.live.sdk.platform.bytelink.b {
        public c(vs1.a r100, vs1.b r101) {
        }
    }

    private final void injectMessagePlatform() {
        im2.d r100 = new im2.d(false);
        List<com.ss.ugc.live.sdk.msg.dispatch.f> r101 = com.ss.ugc.live.sdk.platform.a.f458519a;
        Intrinsics.checkNotNullParameter(r100, "messageDecoder");
        ((CopyOnWriteArrayList) com.ss.ugc.live.sdk.platform.a.f458519a).add(r100);
        com.bytedance.android.livesdk.wrds.a r102 = new com.bytedance.android.livesdk.wrds.a();
        Intrinsics.checkNotNullParameter(r102, "wrdsDecoder");
        ((CopyOnWriteArrayList) com.ss.ugc.live.sdk.platform.a.f458520b).add(r102);
        if (yi.f121690a.getValue().a() == false) goto L5;
        gm2.c r103 = gm2.c.f481653a;
        com.ss.ugc.live.sdk.platform.a.b(new gm2.o());
    L6:
        Intrinsics.checkNotNullParameter(new a(), "depend");
        List<com.ss.ugc.live.sdk.msg.dispatch.f> r104 = com.ss.ugc.live.sdk.platform.a.f458519a;
        b r105 = b.f132653a;
        Intrinsics.checkNotNullParameter(r105, "supplier");
        ((CopyOnWriteArrayList) com.ss.ugc.live.sdk.platform.a.f458522d).add(r105);
        return;
    L5:
        gm2.o r106 = new gm2.o();
        Intrinsics.checkNotNullParameter(r106, "decoder");
        ((CopyOnWriteArrayList) com.ss.ugc.live.sdk.platform.a.f458521c).add(r106);
        goto L6
    }

    @Override // com.bytedance.android.live.core.launch.AbsTask
    public void run() {
        GlobalUnifyMessageManager.getInstance().init(new rt2.a());
        injectMessagePlatform();
        int r100 = d4.f158930a;
        xi r101 = xi.f121606a;
        if (r101.getValue().a() == false) goto L8;
        gm2.c r102 = gm2.c.f481653a;
        gm2.c.a();
        vs1.a r103 = r101.getValue();
        c r104 = new c(r103, yi.f121690a.getValue());
        if (r103.b() == false) goto L7;
        com.ss.ugc.live.sdk.platform.a.f458524f.getClass();
        Intrinsics.checkNotNullParameter(r102, "cursorCache");
    L7:
        com.ss.ugc.live.sdk.platform.a.f458524f.getClass();
        Intrinsics.checkNotNullParameter(r104, "config");
        com.ss.ugc.live.sdk.platform.a.f458524f.getClass();
    L8:
        ALogger.i("UnifyMessageInitTask", "UnifyMessageInitTask run");
    }

    public UnifyMessageInitTask() {
    }
}
