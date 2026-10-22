package com.bytedance.android.livesdkapi.share;

import com.lynx.tasm.LynxError;
import io.reactivex.disposables.Disposable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\u001c\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH&J<\u0010\r\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u001e\u0010\u000e\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0010\u0018\u00010\u000fH&J\b\u0010\u0011\u001a\u00020\u0012H&¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdkapi/share/ILivePreviewShareCallback;", "", "onFail", "", LynxError.LYNX_THROWABLE, "", "onSendReport", "disposable", "Lio/reactivex/disposables/Disposable;", "onSuccess", "platform", "", "shareType", "onSuccessWithExtra", "extra", "", "", "showReportServer", "", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILivePreviewShareCallback {
    void onFail(Throwable r100);

    void onSendReport(Disposable r100);

    void onSuccess(String r100, String r101);

    void onSuccessWithExtra(String r100, String r101, Map<String, ? extends List<String>> r102);

    boolean showReportServer();
}
