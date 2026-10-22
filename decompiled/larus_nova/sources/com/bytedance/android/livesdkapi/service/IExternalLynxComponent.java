package com.bytedance.android.livesdkapi.service;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.alipay.sdk.m.p.e;
import com.bytedance.ies.web.jsbridge2.f;
import com.bytedance.ies.web.jsbridge2.g;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\bg\u0018\u00002\u00020\u0001J0\u0010\t\u001a\u00020\b\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006H&J$\u0010\u000b\u001a\u00020\b\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\nH&J\b\u0010\r\u001a\u00020\fH&J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u0004H&J\b\u0010\u0010\u001a\u00020\bH&J\b\u0010\u0011\u001a\u00020\bH&J(\u0010\u0014\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00042\u0016\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0012H&J\u001e\u0010\u0015\u001a\u00020\b2\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0012H&J0\u0010\u0015\u001a\u00020\b2\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00122\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u0004H&J)\u0010\u001c\u001a\u00020\b\"\b\b\u0000\u0010\u0019*\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00028\u0000H&¢\u0006\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/livesdkapi/service/IExternalLynxComponent;", "", "P", "R", "", "name", "Lcom/bytedance/ies/web/jsbridge2/g;", e.f25671s, "", "registerStatelessMethod", "Lcom/bytedance/ies/web/jsbridge2/f$b;", "registerStatefulMethod", "Landroid/view/View;", "getHybridView", "url", "loadUrl", "reload", "release", "", "args", "renderTemplate", "updateData", "", "toTemplate", "templateAlias", ExifInterface.GPS_DIRECTION_TRUE, "event", "params", "sendJsEvent", "(Ljava/lang/String;Ljava/lang/Object;)V", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IExternalLynxComponent {
    View getHybridView();

    void loadUrl(String r100);

    <P, R> void registerStatefulMethod(String r100, f.b r101);

    <P, R> void registerStatelessMethod(String r100, g<P, R> r101);

    void release();

    void reload();

    void renderTemplate(String r100, Map<String, ? extends Object> r101);

    <T> void sendJsEvent(String r100, T r101);

    void updateData(Map<String, ? extends Object> r100);

    void updateData(Map<String, ? extends Object> r100, boolean r101, String r102);
}
