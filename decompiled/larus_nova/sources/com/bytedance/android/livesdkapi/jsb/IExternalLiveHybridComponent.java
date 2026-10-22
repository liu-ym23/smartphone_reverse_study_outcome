package com.bytedance.android.livesdkapi.jsb;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.alipay.sdk.m.p.e;
import com.bytedance.ies.web.jsbridge2.f;
import com.bytedance.ies.web.jsbridge2.g;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J*\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0004H&J0\u0010\u000e\u001a\u00020\u0007\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\n2\u0006\u0010\u000b\u001a\u00020\u00022\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\fH&J\u0018\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH&J\b\u0010\u0011\u001a\u00020\u0007H&J\b\u0010\u0012\u001a\u00020\u0007H&J(\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0004H&J\b\u0010\u0015\u001a\u00020\u0007H\u0016J\b\u0010\u0016\u001a\u00020\u0007H\u0016J\u001e\u0010\u0018\u001a\u00020\u00072\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004H&J0\u0010\u0018\u001a\u00020\u00072\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00042\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u0002H&J\u001e\u0010\u001c\u001a\u00020\u00072\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004H&J)\u0010 \u001a\u00020\u0007\"\b\b\u0000\u0010\u001d*\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00028\u0000H&¢\u0006\u0004\b \u0010!R\u0014\u0010\u0003\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0014\u0010'\u001a\u00020$8&X¦\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&¨\u0006("}, d2 = {"Lcom/bytedance/android/livesdkapi/jsb/IExternalLiveHybridComponent;", "Lcom/bytedance/android/livesdkapi/jsb/IExternalLiveHybridComponentForSaas;", "", "url", "", "", "initialData", "", "loadUrl", "P", "R", "name", "Lcom/bytedance/ies/web/jsbridge2/g;", e.f25671s, "registerMethod", "Lcom/bytedance/ies/web/jsbridge2/f$b;", ShortVideoSegments.KEY_PROP_PROVIDER, "reload", "release", "m", "renderTemplate", "registerCrashMonitor", "unRegisterCrashMonitor", "data", "updateData", "", "toTemplate", "templateAlias", "updateBusinessGlobalProps", ExifInterface.GPS_DIRECTION_TRUE, "event", "params", "sendJsEvent", "(Ljava/lang/String;Ljava/lang/Object;)V", "getUrl", "()Ljava/lang/String;", "Landroid/view/View;", "getHybridView", "()Landroid/view/View;", "hybridView", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IExternalLiveHybridComponent extends IExternalLiveHybridComponentForSaas {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static void loadUrl(IExternalLiveHybridComponent r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "url");
            IExternalLiveHybridComponentForSaas.DefaultImpls.loadUrl(r100, r101);
        }

        public static void registerCrashMonitor(IExternalLiveHybridComponent r100) {
        }

        public static void unRegisterCrashMonitor(IExternalLiveHybridComponent r100) {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void loadUrl$default(IExternalLiveHybridComponent r100, String r101, Map r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 2) == 0) goto L6;
            r102 = null;
        L6:
            r100.loadUrl(r101, r102);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadUrl");
        }
    }

    View getHybridView();

    String getUrl();

    void loadUrl(String r100, Map<String, ? extends Object> r101);

    void registerCrashMonitor();

    void registerMethod(String r100, f.b r101);

    <P, R> void registerMethod(String r100, g<P, R> r101);

    void release();

    void reload();

    void renderTemplate(String r100, Map<String, ? extends Object> r101);

    <T> void sendJsEvent(String r100, T r101);

    void unRegisterCrashMonitor();

    void updateBusinessGlobalProps(Map<String, ? extends Object> r100);

    void updateData(Map<String, ? extends Object> r100);

    void updateData(Map<String, ? extends Object> r100, boolean r101, String r102);
}
