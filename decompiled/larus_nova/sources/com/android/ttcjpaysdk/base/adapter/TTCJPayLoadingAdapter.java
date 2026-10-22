package com.android.ttcjpaysdk.base.adapter;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u001f\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0002\u0010\bJ\u0017\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00018\u0000H&¢\u0006\u0002\u0010\fJ\u0017\u0010\r\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00018\u0000H&¢\u0006\u0002\u0010\fJ\u001f\u0010\u000e\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/android/ttcjpaysdk/base/adapter/TTCJPayLoadingAdapter;", ExifInterface.GPS_DIRECTION_TRUE, "", "initLoadingView", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "message", "", "(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/Object;", "onHide", "", "loadingView", "(Ljava/lang/Object;)V", SendEventContainerMethodParamModel.EventKinds.onShow, "textAndBackgroundVisible", "visible", "", "(Ljava/lang/Object;Z)V", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface TTCJPayLoadingAdapter<T> {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static <T> void textAndBackgroundVisible(TTCJPayLoadingAdapter<T> r100, T r101, boolean r102) {
        }
    }

    T initLoadingView(Context r100, String r101);

    void onHide(T r100);

    void onShow(T r100);

    void textAndBackgroundVisible(T r100, boolean r101);
}
