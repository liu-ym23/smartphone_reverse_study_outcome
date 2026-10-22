package com.bytedance.android.livehostapi.business.depend.xplay;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\u000eJ\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\u001c\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u0003H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004¨\u0006\u000fÀ\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/xplay/IXplayApi;", "", "isInitialized", "", "()Z", "createInstance", "Lcom/bytedance/android/livehostapi/business/depend/xplay/IXplayInstanceApi;", "envParams", "Lcom/bytedance/android/livehostapi/business/depend/xplay/XplayEnvParams;", "initializeAsync", "", "callback", "Lcom/bytedance/android/livehostapi/business/depend/xplay/IXplayApi$IXplayInitCallback;", "isSilent", "IXplayInitCallback", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IXplayApi {

    /* JADX INFO: renamed from: com.bytedance.android.livehostapi.business.depend.xplay.IXplayApi$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static /* synthetic */ void initializeAsync$default(IXplayApi r100, IXplayInitCallback r101, boolean r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 2) == 0) goto L6;
            r102 = false;
        L6:
            r100.initializeAsync(r101, r102);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: initializeAsync");
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static /* synthetic */ void initializeAsync$default(IXplayApi r100, IXplayInitCallback r101, boolean r102, int r103, Object r104) {
            CC.initializeAsync$default(r100, r101, r102, r103, r104);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/xplay/IXplayApi$IXplayInitCallback;", "", "onFailure", "", "errorCode", "", "onSuccess", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface IXplayInitCallback {
        void onFailure(int r100);

        void onSuccess();
    }

    IXplayInstanceApi createInstance(XplayEnvParams r100);

    void initializeAsync(IXplayInitCallback r100, boolean r101);

    boolean isInitialized();
}
