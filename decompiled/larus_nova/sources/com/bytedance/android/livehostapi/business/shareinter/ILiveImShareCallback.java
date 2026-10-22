package com.bytedance.android.livehostapi.business.shareinter;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u001c\u0010\u000b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\rÀ\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/shareinter/ILiveImShareCallback;", "", "onShareFailedWithUser", "", "sharePackage", "Lcom/bytedance/android/livehostapi/business/shareinter/LiveSharePackageWrapper;", "contractList", "", "Lcom/bytedance/android/livehostapi/business/shareinter/LiveIMContact;", "error", "Lcom/bytedance/android/livehostapi/business/shareinter/LiveIMError;", "onShareSuccessWithSingleUser", "contact", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveImShareCallback {

    /* JADX INFO: renamed from: com.bytedance.android.livehostapi.business.shareinter.ILiveImShareCallback$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$onShareFailedWithUser(ILiveImShareCallback r100, LiveSharePackageWrapper r101, List r102, LiveIMError r103) {
            Intrinsics.checkNotNullParameter(r102, "contractList");
        }

        public static void $default$onShareSuccessWithSingleUser(ILiveImShareCallback r100, LiveSharePackageWrapper r101, LiveIMContact r102) {
        }

        public static /* synthetic */ void access$onShareSuccessWithSingleUser$jd(ILiveImShareCallback r100, LiveSharePackageWrapper r101, LiveIMContact r102) {
            $default$onShareSuccessWithSingleUser(r100, r101, r102);
        }

        public static /* synthetic */ void access$onShareFailedWithUser$jd(ILiveImShareCallback r100, LiveSharePackageWrapper r101, List r102, LiveIMError r103) {
            $default$onShareFailedWithUser(r100, r101, r102, r103);
        }

        public static /* synthetic */ void onShareFailedWithUser$default(ILiveImShareCallback r100, LiveSharePackageWrapper r101, List r102, LiveIMError r103, int r104, Object r105) {
            if (r105 != null) goto L9;
            if ((r104 & 4) == 0) goto L6;
            r103 = null;
        L6:
            r100.onShareFailedWithUser(r101, r102, r103);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onShareFailedWithUser");
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static void onShareSuccessWithSingleUser(ILiveImShareCallback r100, LiveSharePackageWrapper r101, LiveIMContact r102) {
            CC.access$onShareSuccessWithSingleUser$jd(r100, r101, r102);
        }

        public static void onShareFailedWithUser(ILiveImShareCallback r100, LiveSharePackageWrapper r101, List<? extends LiveIMContact> r102, LiveIMError r103) {
            CC.access$onShareFailedWithUser$jd(r100, r101, r102, r103);
        }

        public static /* synthetic */ void onShareFailedWithUser$default(ILiveImShareCallback r100, LiveSharePackageWrapper r101, List r102, LiveIMError r103, int r104, Object r105) {
            CC.onShareFailedWithUser$default(r100, r101, r102, r103, r104, r105);
        }
    }

    void onShareFailedWithUser(LiveSharePackageWrapper r100, List<? extends LiveIMContact> r101, LiveIMError r102);

    void onShareSuccessWithSingleUser(LiveSharePackageWrapper r100, LiveIMContact r101);
}
