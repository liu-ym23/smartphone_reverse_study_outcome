package com.bytedance.android.livehostapi.business.castscreen.interfaces;

import com.bytedance.android.livehostapi.business.castscreen.bean.LiveCastPlayInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0016J\u001a\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/castscreen/interfaces/ILiveCastGetPlayInfoCallback;", "", "error", "", "code", "", "msg", "", "setPlayInfo", "playInfo", "Lcom/bytedance/android/livehostapi/business/castscreen/bean/LiveCastPlayInfo;", "hostapp-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveCastGetPlayInfoCallback {

    /* JADX INFO: renamed from: com.bytedance.android.livehostapi.business.castscreen.interfaces.ILiveCastGetPlayInfoCallback$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$setPlayInfo(ILiveCastGetPlayInfoCallback r100, LiveCastPlayInfo r101) {
            Intrinsics.checkNotNullParameter(r101, "playInfo");
        }

        public static void $default$setPlayInfo(ILiveCastGetPlayInfoCallback r100, LiveCastPlayInfo r101, String r102) {
            Intrinsics.checkNotNullParameter(r101, "playInfo");
        }

        public static /* synthetic */ void access$setPlayInfo$jd(ILiveCastGetPlayInfoCallback r100, LiveCastPlayInfo r101) {
            $default$setPlayInfo(r100, r101);
        }

        public static /* synthetic */ void access$setPlayInfo$jd(ILiveCastGetPlayInfoCallback r100, LiveCastPlayInfo r101, String r102) {
            $default$setPlayInfo(r100, r101, r102);
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static void setPlayInfo(ILiveCastGetPlayInfoCallback r100, LiveCastPlayInfo r101) {
            CC.access$setPlayInfo$jd(r100, r101);
        }

        public static void setPlayInfo(ILiveCastGetPlayInfoCallback r100, LiveCastPlayInfo r101, String r102) {
            CC.access$setPlayInfo$jd(r100, r101, r102);
        }
    }

    void error(int r100, String r101);

    void setPlayInfo(LiveCastPlayInfo r100);

    void setPlayInfo(LiveCastPlayInfo r100, String r101);
}
