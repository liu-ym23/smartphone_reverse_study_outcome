package com.bytedance.android.livesdkapi.depend.model.live;

import com.bytedance.android.livesdkapi.roomplayer.VrBgLogData;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001R\u001a\u0010\u0002\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\t8&X§\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000e8&X§\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/IBaseStreamUrlKtDef;", "", "extra", "Lcom/bytedance/android/livesdkapi/depend/model/live/IStreamUrlExtra;", "getExtra$annotations", "()V", "getExtra", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IStreamUrlExtra;", "rtmpPushUrl", "", "getRtmpPushUrl$annotations", "getRtmpPushUrl", "()Ljava/lang/String;", "vrType", "", "getVrType$annotations", "getVrType", "()I", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IBaseStreamUrlKtDef {

    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "extra")
        public static /* synthetic */ void getExtra$annotations() {
        }

        @FieldName(name = "rtmp_push_url")
        public static /* synthetic */ void getRtmpPushUrl$annotations() {
        }

        @FieldName(name = VrBgLogData.KEY_VR_TYPE)
        public static /* synthetic */ void getVrType$annotations() {
        }
    }

    IStreamUrlExtra getExtra();

    String getRtmpPushUrl();

    int getVrType();
}
