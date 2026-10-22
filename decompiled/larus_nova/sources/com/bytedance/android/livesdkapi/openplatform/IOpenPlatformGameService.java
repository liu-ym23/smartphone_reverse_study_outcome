package com.bytedance.android.livesdkapi.openplatform;

import android.app.Dialog;
import android.content.Context;
import com.bytedance.android.live.base.IService;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.Disposable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012J \u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H&J\u001a\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH&J8\u0010\r\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\fH&¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdkapi/openplatform/IOpenPlatformGameService;", "Lcom/bytedance/android/live/base/IService;", "openCertificatePage", "Lio/reactivex/disposables/Disposable;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "onCertificate", "Lkotlin/Function0;", "", "openOuterGameFeedback", "Landroid/app/Dialog;", "isLandscape", "", "openOuterGameReport", "develop", "", "appId", "appName", "Companion", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IOpenPlatformGameService extends IService {
    public static final Companion Companion = null;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\n\u001a\u0004\u0018\u00010\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdkapi/openplatform/IOpenPlatformGameService$Companion;", "", "()V", "SERVICE_IMPL_NAME", "", "service", "getService", "()Ljava/lang/Object;", "service$delegate", "Lkotlin/Lazy;", "Inst", "Lcom/bytedance/android/livesdkapi/openplatform/IOpenPlatformGameService;", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        private static final String SERVICE_IMPL_NAME = "com.bytedance.android.live.broadcastgame.OpenPlatformGameService";
        private static final Lazy service$delegate = null;

        private Companion() {
        }

        private final Object getService() {
            return service$delegate.getValue();
        }

        static {
            final Companion r100 = new Companion();
            $$INSTANCE = r100;
            service$delegate = LazyKt.lazy(new IOpenPlatformGameService$Companion$service$2(r100));
        }

        public final IOpenPlatformGameService Inst() {
            Object r100 = getService();
            if ((r100 instanceof IOpenPlatformGameService) == true) goto L6;
            r100 = null;
        L6:
            return (IOpenPlatformGameService) r100;
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static /* synthetic */ Dialog openOuterGameReport$default(IOpenPlatformGameService r100, Context r101, String r102, String r110, String r111, boolean r112, int r113, Object r114) {
            if (r114 != null) goto L18;
            if ((r113 & 2) == 0) goto L6;
            String r103 = "";
        L8:
            if ((r113 & 4) == 0) goto L10;
            String r104 = "";
        L12:
            if ((r113 & 8) == 0) goto L14;
            String r105 = "";
        L16:
            return r100.openOuterGameReport(r101, r103, r104, r105, r112);
        L14:
            r105 = r111;
            goto L16
        L10:
            r104 = r110;
            goto L12
        L6:
            r103 = r102;
            goto L8
        L18:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openOuterGameReport");
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    Disposable openCertificatePage(Context r100, Function0<Unit> r101);

    Dialog openOuterGameFeedback(Context r100, boolean r101);

    Dialog openOuterGameReport(Context r100, String r101, String r102, String r103, boolean r104);
}
