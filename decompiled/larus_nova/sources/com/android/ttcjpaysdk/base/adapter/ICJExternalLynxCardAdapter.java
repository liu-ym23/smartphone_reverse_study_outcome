package com.android.ttcjpaysdk.base.adapter;

import android.net.Uri;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.android.ttcjpaysdk.base.service.ICJExternalLivePluginCallback;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u000bH&J*\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u00072\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000fH&J*\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00122\u0018\b\u0002\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000fH&J\b\u0010\u0013\u001a\u00020\u0003H&J'\u0010\u0014\u001a\u00020\u0003\"\b\b\u0000\u0010\u0015*\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u0002H\u0015H&¢\u0006\u0002\u0010\u0018J \u0010\u0019\u001a\u00020\u00032\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000fH&¨\u0006\u001a"}, d2 = {"Lcom/android/ttcjpaysdk/base/adapter/ICJExternalLynxCardAdapter;", "", "checkLiveAvailableAndInstall", "", "callback", "Lcom/android/ttcjpaysdk/base/service/ICJExternalLivePluginCallback;", "containerId", "", "getHybridView", "Landroid/view/View;", "isInit", "", "load", "url", "renderData", "", "loadSchema", "schema", "Landroid/net/Uri;", "release", "sendJsEvent", ExifInterface.GPS_DIRECTION_TRUE, "name", "data", "(Ljava/lang/String;Ljava/lang/Object;)V", "updateGlobalProps", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ICJExternalLynxCardAdapter {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void loadSchema$default(ICJExternalLynxCardAdapter r100, Uri r101, Map r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 2) == 0) goto L6;
            r102 = null;
        L6:
            r100.loadSchema(r101, r102);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadSchema");
        }
    }

    void checkLiveAvailableAndInstall(ICJExternalLivePluginCallback r100);

    String containerId();

    View getHybridView();

    boolean isInit();

    void load(String r100, Map<String, ? extends Object> r101);

    void loadSchema(Uri r100, Map<String, ? extends Object> r101);

    void release();

    <T> void sendJsEvent(String r100, T r101);

    void updateGlobalProps(Map<String, ? extends Object> r100);
}
