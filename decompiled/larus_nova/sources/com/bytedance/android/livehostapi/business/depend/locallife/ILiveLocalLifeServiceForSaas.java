package com.bytedance.android.livehostapi.business.depend.locallife;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/locallife/ILiveLocalLifeServiceForSaas;", "", "getLiveLocalRoomInfo", "Landroid/os/Bundle;", "activity", "Landroidx/fragment/app/FragmentActivity;", "removeLiveLocalRoomInfo", "", "key", "", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveLocalLifeServiceForSaas {

    /* JADX INFO: renamed from: com.bytedance.android.livehostapi.business.depend.locallife.ILiveLocalLifeServiceForSaas$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static Bundle $default$getLiveLocalRoomInfo(ILiveLocalLifeServiceForSaas r100, FragmentActivity r101) {
            Intrinsics.checkNotNullParameter(r101, "activity");
            return null;
        }

        public static void $default$removeLiveLocalRoomInfo(ILiveLocalLifeServiceForSaas r100, FragmentActivity r101, String r102) {
            Intrinsics.checkNotNullParameter(r101, "activity");
            Intrinsics.checkNotNullParameter(r102, "key");
        }

        public static /* synthetic */ Bundle access$getLiveLocalRoomInfo$jd(ILiveLocalLifeServiceForSaas r100, FragmentActivity r101) {
            return $default$getLiveLocalRoomInfo(r100, r101);
        }

        public static /* synthetic */ void access$removeLiveLocalRoomInfo$jd(ILiveLocalLifeServiceForSaas r100, FragmentActivity r101, String r102) {
            $default$removeLiveLocalRoomInfo(r100, r101, r102);
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static Bundle getLiveLocalRoomInfo(ILiveLocalLifeServiceForSaas r100, FragmentActivity r101) {
            return CC.access$getLiveLocalRoomInfo$jd(r100, r101);
        }

        public static void removeLiveLocalRoomInfo(ILiveLocalLifeServiceForSaas r100, FragmentActivity r101, String r102) {
            CC.access$removeLiveLocalRoomInfo$jd(r100, r101, r102);
        }
    }

    Bundle getLiveLocalRoomInfo(FragmentActivity r100);

    void removeLiveLocalRoomInfo(FragmentActivity r100, String r101);
}
