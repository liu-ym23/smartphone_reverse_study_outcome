package com.bytedance.android.livesdk.chatroom.viewmodel;

import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.config.iw0;
import com.bytedance.android.livesdk.config.j11;
import com.bytedance.android.livesdk.config.pd;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public interface IAnimationScheduler {
    public static final Companion M0 = null;

    public static final class Companion {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Companion f114764a = null;

        public Companion() {
        }

        static {
            f114764a = new Companion();
        }

        public static boolean b() {
            Integer r100 = iw0.f120484a.getValue();
            if (r100 == null) goto L5;
            int r101 = r100.intValue();
        L6:
            if (r101 <= 0) goto L9;
            return true;
        L9:
            return false;
        L5:
            r101 = 0;
            goto L6
        }

        public static boolean c() {
            Integer r100 = iw0.f120484a.getValue();
            if (r100 == null) goto L5;
            int r101 = r100.intValue();
        L7:
            if (r101 <= 0) goto L9;
            boolean r102 = true;
        L23:
            j11 r103 = pd.f120969a.getValue();     // Catch: Exception -> L16
            if (r103 == null) goto L15;
            if (r103.enable != true) goto L15;
        L18:
            boolean r104 = true;
        L19:
            if (r102 == true) goto L21;
            if (r104 == true) goto L21;
            return false;
        L21:
            return true;
        L15:
            r104 = false;
        L16:
            e = move-exception;
            SafetyGuard.a(null, e, "live animation center setting error.");
            goto L18
        L9:
            r102 = false;
            goto L23
        L5:
            r101 = 0;
            goto L7
        }

        public static IAnimationScheduler a(DataCenter r100) {
            IRoomContextService r101 = (IRoomContextService) jc1.k.f(IRoomContextService.class);
            Object r102 = null;
            if (r101 == null) goto L9;
            o r103 = IRoomContextService.a.a(r101, r100, 0, 2);
            if (r103 == null) goto L9;
            com.bytedance.live.datacontext.j<ViewModel> r104 = r103.x2();
            if (r104 == null) goto L9;
            ViewModel r105 = r104.getValue();
        L11:
            if ((r105 instanceof IAnimationScheduler) == false) goto L15;
            r102 = r105;
        L15:
            return (IAnimationScheduler) r102;
        L9:
            r105 = null;
            goto L11
        }

        public static void d(DataCenter r100, final Function1 r101) {
            Intrinsics.checkNotNullParameter(r101, "callback");
            IRoomContextService r102 = (IRoomContextService) jc1.k.f(IRoomContextService.class);
            if (r102 == null) goto L10;
            o r103 = IRoomContextService.a.a(r102, r100, 0, 2);
            if (r103 == null) goto L11;
            com.bytedance.live.datacontext.j<ViewModel> r104 = r103.x2();
            if (r104 == null) goto L12;
            r104.c(new IAnimationScheduler$Companion$use$1(r101));
            return;
        L12:
            return;
        L11:
            return;
        }
    }

    static {
        M0 = Companion.f114764a;
    }

    void enableShowAnim(boolean r100);

    void onToolbarLoaded();

    void registerListener(c r100);

    void requestAnimationAtOnce(a r100);

    void unRegisterListener(c r100);
}
