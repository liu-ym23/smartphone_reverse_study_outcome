package com.bytedance.android.livesdkapi.feed;

import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.lynx.tasm.LynxError;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdkapi/feed/ILoadMore;", "", "setLoadMoreCallback", "", "callback", "Lcom/bytedance/android/livesdkapi/feed/ILoadMore$ILoadMoreCallback;", "ILoadMoreCallback", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILoadMore {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\"\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u0007H&¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdkapi/feed/ILoadMore$ILoadMoreCallback;", "", LynxVideoManagerLite.EVENT_ON_ERROR, "", LynxError.LYNX_THROWABLE, "", "hasMore", "", "onSuccess", "result", "", "isPersonal", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface ILoadMoreCallback {

        @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
        public static final class DefaultImpls {
            public static /* synthetic */ void onSuccess$default(ILoadMoreCallback r100, int r101, boolean r102, boolean r103, int r104, Object r105) {
                if (r105 != null) goto L9;
                if ((r104 & 4) == 0) goto L6;
                r103 = false;
            L6:
                r100.onSuccess(r101, r102, r103);
                return;
            L9:
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onSuccess");
            }
        }

        void onError(Throwable r100, boolean r101);

        void onSuccess(int r100, boolean r101, boolean r102);
    }

    void setLoadMoreCallback(ILoadMoreCallback r100);
}
