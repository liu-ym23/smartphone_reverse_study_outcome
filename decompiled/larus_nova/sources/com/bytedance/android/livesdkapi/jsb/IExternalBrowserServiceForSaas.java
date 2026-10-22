package com.bytedance.android.livesdkapi.jsb;

import android.app.Activity;
import com.bytedance.android.live.base.IService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J$\u0010\n\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdkapi/jsb/IExternalBrowserServiceForSaas;", "Lcom/bytedance/android/live/base/IService;", "createLynxComponent", "Lcom/bytedance/android/livesdkapi/jsb/IExternalLiveHybridComponent;", "activity", "Landroid/app/Activity;", "url", "", "lynxCallback", "Lcom/bytedance/android/livesdkapi/jsb/IExternalLiveLynxCallback;", "createWebViewRecord", "webCallback", "Lcom/bytedance/android/livesdkapi/jsb/IExternalLiveWebCallback;", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IExternalBrowserServiceForSaas extends IService {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static IExternalLiveHybridComponent createLynxComponent(IExternalBrowserServiceForSaas r100, Activity r101, String r102, IExternalLiveLynxCallback r103) {
            Intrinsics.checkNotNullParameter(r101, "activity");
            Intrinsics.checkNotNullParameter(r102, "url");
            return null;
        }

        public static IExternalLiveHybridComponent createWebViewRecord(IExternalBrowserServiceForSaas r100, Activity r101, String r102, IExternalLiveWebCallback r103) {
            Intrinsics.checkNotNullParameter(r101, "activity");
            Intrinsics.checkNotNullParameter(r102, "url");
            return null;
        }
    }

    IExternalLiveHybridComponent createLynxComponent(Activity r100, String r101, IExternalLiveLynxCallback r102);

    IExternalLiveHybridComponent createWebViewRecord(Activity r100, String r101, IExternalLiveWebCallback r102);
}
