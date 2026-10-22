package com.bytedance.android.livesdkapi.feed;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J5\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH&¢\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\u0003H&¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdkapi/feed/IAutoPull;", "", "autoLoadMore", "", "curIndex", "", "dealType", "hotUpdateType", "highValueRoomId", "", "(IIILjava/lang/Long;)V", "cancelAutoLoadMore", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IAutoPull {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static /* synthetic */ void autoLoadMore$default(IAutoPull r100, int r101, int r102, int r103, Long r104, int r105, Object r106) {
            if (r106 != null) goto L15;
            if ((r105 & 2) == 0) goto L7;
            r102 = 1;
        L7:
            if ((r105 & 4) == 0) goto L10;
            r103 = 1;
        L10:
            if ((r105 & 8) == 0) goto L12;
            r104 = null;
        L12:
            r100.autoLoadMore(r101, r102, r103, r104);
            return;
        L15:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: autoLoadMore");
        }
    }

    void autoLoadMore(int r100, int r101, int r102, Long r103);

    void cancelAutoLoadMore();
}
