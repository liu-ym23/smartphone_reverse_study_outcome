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
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u00002\u00020\u0001J0\u0010\t\u001a\u00020\b\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006H&J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH&J)\u0010\u000f\u001a\u00020\b\"\b\b\u0000\u0010\r*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00028\u0000H&¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0011\u001a\u00020\bH&J.\u0010\u0015\u001a\u00020\b2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00042\u0018\b\u0002\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0013H&J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0016H&J\b\u0010\u0018\u001a\u00020\bH\u0016J\b\u0010\u0019\u001a\u00020\bH\u0016J\u001e\u0010\u001a\u001a\u00020\b2\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0013H&R\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u00168&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/livesdkapi/jsb/IOuterAnnieCardComponent;", "", "P", "R", "", "name", "Lcom/bytedance/ies/web/jsbridge2/g;", e.f25671s, "", "registerMethod", "Lcom/bytedance/ies/web/jsbridge2/f$b;", ShortVideoSegments.KEY_PROP_PROVIDER, "registerStatefulMethod", ExifInterface.GPS_DIRECTION_TRUE, "data", "sendJsEvent", "(Ljava/lang/String;Ljava/lang/Object;)V", "release", "url", "", "renderData", "load", "Landroid/view/View;", "getHybridView", "registerCrashMonitor", "unRegisterCrashMonitor", "updateData", "getMView", "()Landroid/view/View;", "mView", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IOuterAnnieCardComponent {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static void registerCrashMonitor(IOuterAnnieCardComponent r100) {
        }

        public static void unRegisterCrashMonitor(IOuterAnnieCardComponent r100) {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void load$default(IOuterAnnieCardComponent r100, String r101, Map r102, int r103, Object r104) {
            if (r104 != null) goto L12;
            if ((r103 & 1) == 0) goto L7;
            r101 = null;
        L7:
            if ((r103 & 2) == 0) goto L9;
            r102 = null;
        L9:
            r100.load(r101, r102);
            return;
        L12:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: load");
        }
    }

    View getHybridView();

    View getMView();

    void load(String r100, Map<String, ? extends Object> r101);

    void registerCrashMonitor();

    <P, R> void registerMethod(String r100, g<P, R> r101);

    void registerStatefulMethod(String r100, f.b r101);

    void release();

    <T> void sendJsEvent(String r100, T r101);

    void unRegisterCrashMonitor();

    void updateData(Map<String, ? extends Object> r100);
}
