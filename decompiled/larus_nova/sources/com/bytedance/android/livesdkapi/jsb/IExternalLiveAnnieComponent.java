package com.bytedance.android.livesdkapi.jsb;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.alipay.sdk.m.p.e;
import com.bytedance.ies.web.jsbridge2.f;
import com.bytedance.ies.web.jsbridge2.g;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\bg\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J(\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0006H&J0\u0010\u000f\u001a\u00020\b\"\u0004\b\u0000\u0010\n\"\u0004\b\u0001\u0010\u000b2\u0006\u0010\f\u001a\u00020\u00042\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\rH&J\u0018\u0010\u000f\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H&J\u001e\u0010\u0013\u001a\u00020\b2\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006H&J)\u0010\u0017\u001a\u00020\b\"\b\b\u0000\u0010\u0014*\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00028\u0000H&¢\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0019\u001a\u00020\bH&¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdkapi/jsb/IExternalLiveAnnieComponent;", "", "Landroid/view/View;", "getHybridView", "", "url", "", "m", "", "load", "P", "R", "name", "Lcom/bytedance/ies/web/jsbridge2/g;", e.f25671s, "registerMethod", "Lcom/bytedance/ies/web/jsbridge2/f$b;", ShortVideoSegments.KEY_PROP_PROVIDER, "data", "updateData", ExifInterface.GPS_DIRECTION_TRUE, "event", "params", "sendJsEvent", "(Ljava/lang/String;Ljava/lang/Object;)V", "release", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IExternalLiveAnnieComponent {
    View getHybridView();

    void load(String r100, Map<String, ? extends Object> r101);

    void registerMethod(String r100, f.b r101);

    <P, R> void registerMethod(String r100, g<P, R> r101);

    void release();

    <T> void sendJsEvent(String r100, T r101);

    void updateData(Map<String, ? extends Object> r100);
}
