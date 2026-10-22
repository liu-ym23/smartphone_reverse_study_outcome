package com.bytedance.android.livesdk.chatroom.record;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveMonitor;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.livesdk.chatroom.record.anchor.IRoomAnchorApi;
import com.bytedance.android.livesdk.config.nb;
import com.bytedance.android.livesdk.live.extension.plugin.api.vesdk.ILiveWrappedVESdkService;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdkapi.depend.model.broadcast.RoomClipStickerData;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import java.util.Iterator;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f108051a = 0;

    public static final class a {
        public static String a(String r100, Map r101, String r102) {
            if (nb.f120818a.getValue().booleanValue() == false) goto L34;
            ALogger.i("FileMetadataUtils", "metadata file = " + r100);
            if (r102 != null) goto L7;
        L11:
            r102 = r100 + ".temp";
        L12:
            int r103 = qc1.b.f532434a;
            Intrinsics.checkNotNullParameter(r100, "srcPath");
            Intrinsics.checkNotNullParameter(r102, "dstPath");
            Intrinsics.checkNotNullParameter(r101, "metadata");
            Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L18
            ILiveWrappedVESdkService.Companion.getClass();     // Catch: Throwable -> L18
            ILiveWrappedVESdkService r105 = ILiveWrappedVESdkService.a.a();     // Catch: Throwable -> L18
            if (r105 == null) goto L16;
            r105.getVEUtils();     // Catch: Throwable -> L18
        L16:
            Object r106 = Result.m9449constructorimpl(null);     // Catch: Throwable -> L18
        L21:
            if (Result.m9452exceptionOrNullimpl(r106) == null) goto L24;
            ALogger.e("LiveVEFileUtils", "setMetadata failed, srcPath = " + r100 + ", dstPath = " + r102 + ", metadata = " + r101);
        L24:
            if (com.bytedance.android.live.core.utils.v.a() == false) goto L33;
            int r107 = qc1.b.f532434a;
            Intrinsics.checkNotNullParameter(r102, "srcPath");
            ILiveWrappedVESdkService.Companion.getClass();
            ILiveWrappedVESdkService r108 = ILiveWrappedVESdkService.a.a();
            if (r108 == null) goto L28;
            r108.getVEUtils();
        L28:
            Map r109 = MapsKt.emptyMap();
            StringBuilder r110 = new StringBuilder(" get metadata = ");
            Intrinsics.checkNotNullParameter(r109, "map");
            StringBuilder r111 = new StringBuilder();
            Iterator r112 = r109.keySet().iterator();
        L30:
            if (r112.hasNext() == false) goto L32;
            String r113 = (String) r112.next();
            r111.append("{" + r113 + ", " + ((String) r109.get(r113)) + "} - ");
            goto L30
        L32:
            r110.append(r111.toString());
            ALogger.i("FileMetadataUtils", r110.toString());
        L33:
            return r102;
        L18:
            th = move-exception;
            Result.Companion r114 = Result.Companion;
            r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L21
        L7:
            if (r2.a(r102) == true) goto L10;
            r102 = null;
        L10:
            if (r102 != null) goto L12;
        L34:
            return r100;
        }
    }

    static {
    }

    public d() {
    }

    public static final void a(d r100, String r101) {
        r100.getClass();
        LiveTracingMonitor.EventModule r102 = LiveTracingMonitor.EventModule.OPEN_LIVE;
        JSONObject r103 = new JSONObject();
        r103.put("status_code", 0);     // Catch: JSONException -> L8
    L12:
        r103.put("type", r101);     // Catch: JSONException -> L9
    L6:
        LiveMonitor r104 = new LiveMonitor();
        r104.mCategory = r103;
        r104.mEventModule = r102;
        r104.mServiceName = "ttlive_anchor_high_light_metadata_monitor";
        r104.mExtraLog = null;
        r104.mMetrics = null;
        LiveMonitor.access$002(r104, true);
        LiveMonitor.access$102(r104, true);
        LiveMonitor.access$202(r104, true);
        LiveMonitor.access$302(r104, false);
        LiveMonitor.access$402(r104, false);
        r104.report();
    }

    public final Disposable b(String r110, long r111, long r112, long r113, Function2 r114) {
        Intrinsics.checkNotNullParameter(r110, "originFilePath");
        Intrinsics.checkNotNullParameter("anchor_record", "source");
        Intrinsics.checkNotNullParameter(r114, "callback");
        IRoomAnchorApi r100 = (IRoomAnchorApi) com.bytedance.android.live.network.c.b().e(IRoomAnchorApi.class);
        if (r100 == null) goto L11;
        long r101 = 1000;
        Observable<BaseResponse<RoomClipStickerData, Extra>> r102 = r100.getWebcastRoomClipSticker(r111, r112 / r101, r113 / r101, "anchor_record");
        if (r102 == null) goto L11;
        Observable<R> r103 = r102.map(new e(r110));
        if (r103 == 0) goto L11;
        Observable r104 = r103.compose(RxUtil.rxSchedulerHelper());
        if (r104 == null) goto L11;
        return r104.subscribe(new f(this, r114, r110), new g(this, r110, r114));
    L11:
        return null;
    }
}
