package com.bytedance.android.livehostapi.business.depend.gamecenter;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J^\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000fH&¨\u0006\u0011À\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/gamecenter/IDownloadStateChangeListener;", "", "onStateChanged", "", "status", "", DBDefinition.TOTAL_BYTES, "", "currentBytes", "fileName", "", "failStatus", DBDefinition.ONLY_WIFI, "", "reserveInfo", "Lorg/json/JSONObject;", "enableFeature", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IDownloadStateChangeListener {

    /* JADX INFO: renamed from: com.bytedance.android.livehostapi.business.depend.gamecenter.IDownloadStateChangeListener$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static /* synthetic */ void onStateChanged$default(IDownloadStateChangeListener r100, int r101, long r102, long r103, String r104, int r110, boolean r111, JSONObject r112, JSONObject r113, int r114, Object r115) {
            if (r115 != null) goto L30;
            if ((r114 & 1) == 0) goto L7;
            r101 = 0;
        L7:
            if ((r114 & 2) == 0) goto L10;
            r102 = -1;
        L10:
            if ((r114 & 4) == 0) goto L13;
            r103 = -1;
        L13:
            if ((r114 & 8) == 0) goto L16;
            r104 = null;
        L16:
            if ((r114 & 16) == 0) goto L19;
            r110 = 0;
        L19:
            if ((r114 & 32) == 0) goto L22;
            r111 = false;
        L22:
            if ((r114 & 64) == 0) goto L25;
            r112 = null;
        L25:
            if ((r114 & 128) == 0) goto L27;
            r113 = null;
        L27:
            r100.onStateChanged(r101, r102, r103, r104, r110, r111, r112, r113);
            return;
        L30:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onStateChanged");
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static /* synthetic */ void onStateChanged$default(IDownloadStateChangeListener r100, int r101, long r102, long r103, String r104, int r105, boolean r106, JSONObject r107, JSONObject r110, int r111, Object r112) {
            CC.onStateChanged$default(r100, r101, r102, r103, r104, r105, r106, r107, r110, r111, r112);
        }
    }

    void onStateChanged(int r100, long r101, long r102, String r103, int r104, boolean r105, JSONObject r106, JSONObject r110);
}
