package com.bytedance.android.livehostapi.business.depend;

import com.lynx.tasm.LynxError;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J2\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u000bH\u0016¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/IGenCodeShareCallback;", "", "onShareFail", "", LynxError.LYNX_THROWABLE, "", "onShareSuccess", "platform", "", "shareType", "params", "", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IGenCodeShareCallback {

    /* JADX INFO: renamed from: com.bytedance.android.livehostapi.business.depend.IGenCodeShareCallback$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$onShareFail(IGenCodeShareCallback r100, Throwable r101) {
        }

        public static void $default$onShareSuccess(IGenCodeShareCallback r100, String r101, String r102, Map r103) {
        }

        public static /* synthetic */ void access$onShareFail$jd(IGenCodeShareCallback r100, Throwable r101) {
            $default$onShareFail(r100, r101);
        }

        public static /* synthetic */ void access$onShareSuccess$jd(IGenCodeShareCallback r100, String r101, String r102, Map r103) {
            $default$onShareSuccess(r100, r101, r102, r103);
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static void onShareFail(IGenCodeShareCallback r100, Throwable r101) {
            CC.access$onShareFail$jd(r100, r101);
        }

        public static void onShareSuccess(IGenCodeShareCallback r100, String r101, String r102, Map<String, String> r103) {
            CC.access$onShareSuccess$jd(r100, r101, r102, r103);
        }
    }

    void onShareFail(Throwable r100);

    void onShareSuccess(String r100, String r101, Map<String, String> r102);
}
