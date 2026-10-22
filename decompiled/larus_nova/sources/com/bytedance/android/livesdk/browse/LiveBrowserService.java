package com.bytedance.android.livesdk.browse;

import android.content.Context;
import android.net.Uri;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.annie.api.container.HybridDialog;
import com.bytedance.android.annie.api.container.HybridFragment;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.livesdkapi.browse.ILiveBrowserService;
import com.bytedance.android.livesdkapi.browse.LiveSubscriberJsEvent;
import com.bytedance.android.livesdkapi.hybridapi.SubscriberJsEvent;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ$\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J$\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J$\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0010\u001a\u00020\u000eH\u0016J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0014\u001a\u00020\u0011H\u0016J%\u0010\u001b\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u00182\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdk/browse/LiveBrowserService;", "Lcom/bytedance/android/livesdkapi/browse/ILiveBrowserService;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/net/Uri;", "uri", "Lb7/a;", "commonLifecycle", "Lcom/bytedance/android/annie/api/container/HybridDialog;", "showHybridDialog", "Lcom/bytedance/android/annie/api/card/HybridCard;", "getHybridCard", "Lcom/bytedance/android/annie/api/container/HybridFragment;", "getHybridFragment", "", "initAnnie", "xBridge3Adapter", "", "url", "createH5SchemeByUrl", "eventName", "Lio/reactivex/Observable;", "Lcom/bytedance/android/livesdkapi/browse/LiveSubscriberJsEvent;", "registerJsEventSubscriber", ExifInterface.GPS_DIRECTION_TRUE, "event", "params", "sendEventToAllJsBridges", "(Ljava/lang/String;Ljava/lang/Object;)V", "createLynxSchemeByUrl", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public class LiveBrowserService implements ILiveBrowserService {

    public static final class a<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f104371a = null;

        static {
            f104371a = new a();
        }

        public a() {
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            SubscriberJsEvent r101 = (SubscriberJsEvent) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            return new LiveSubscriberJsEvent(r101.getEventName(), r101.getParams());
        }
    }

    public LiveBrowserService() {
    }

    @Override // com.bytedance.android.livesdkapi.browse.ILiveBrowserService
    public void initAnnie() {
        ((IBrowserService) k.n(IBrowserService.class)).initAnnie();
    }

    @Override // com.bytedance.android.livesdkapi.browse.ILiveBrowserService
    public void xBridge3Adapter() {
        ((IBrowserService) k.n(IBrowserService.class)).xBridge3Adapter();
    }

    @Override // com.bytedance.android.livesdkapi.browse.ILiveBrowserService
    public Uri createH5SchemeByUrl(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        return x6.a.b(r100);
    }

    @Override // com.bytedance.android.livesdkapi.browse.ILiveBrowserService
    public Uri createLynxSchemeByUrl(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        return x6.a.d(r100);
    }

    @Override // com.bytedance.android.livesdkapi.browse.ILiveBrowserService
    public Observable<LiveSubscriberJsEvent> registerJsEventSubscriber(String r100) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        return ((IBrowserService) k.n(IBrowserService.class)).registerJsEventSubscriber(r100).map(a.f104371a);
    }

    @Override // com.bytedance.android.livesdkapi.browse.ILiveBrowserService
    public <T> void sendEventToAllJsBridges(String r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        ((IBrowserService) k.n(IBrowserService.class)).sendEventToAllJsBridges(r100, r101);
    }

    @Override // com.bytedance.android.livesdkapi.browse.ILiveBrowserService
    public HybridCard getHybridCard(Context r100, Uri r101, b7.a r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "uri");
        return ((IBrowserService) k.n(IBrowserService.class)).getHybridCard(r100, r101, r102);
    }

    @Override // com.bytedance.android.livesdkapi.browse.ILiveBrowserService
    public HybridFragment getHybridFragment(Context r100, Uri r101, b7.a r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "uri");
        return ((IBrowserService) k.n(IBrowserService.class)).getHybridFragment(r100, r101, r102);
    }

    @Override // com.bytedance.android.livesdkapi.browse.ILiveBrowserService
    public HybridDialog showHybridDialog(Context r100, Uri r101, b7.a r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "uri");
        return ((IBrowserService) k.n(IBrowserService.class)).showHybridDialog(r100, r101, r102);
    }
}
