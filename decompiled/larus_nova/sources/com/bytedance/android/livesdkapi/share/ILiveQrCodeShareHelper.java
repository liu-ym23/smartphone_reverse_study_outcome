package com.bytedance.android.livesdkapi.share;

import android.graphics.Bitmap;
import com.bytedance.android.live.base.model.ImageModel;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000bH\u0016J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0012\u001a\u00020\u0003H\u0016J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdkapi/share/ILiveQrCodeShareHelper;", "", "getRelatedReviewContent", "", "setMatchSchedule", "", "matchSchedule", "setMatchTiming", "matchTiming", "setOriginalPic", "imageModel", "Lcom/bytedance/android/live/base/model/ImageModel;", "setRaceLogo", "raceLogo", "setSavePicBitmap", SimplayerImageStrategy.RESULT_BITMAP, "Landroid/graphics/Bitmap;", "setTicketJson", "json", "setViewCutBitmap", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveQrCodeShareHelper {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static String getRelatedReviewContent(ILiveQrCodeShareHelper r100) {
            return "";
        }

        public static void setMatchSchedule(ILiveQrCodeShareHelper r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "matchSchedule");
        }

        public static void setMatchTiming(ILiveQrCodeShareHelper r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "matchTiming");
        }

        public static void setOriginalPic(ILiveQrCodeShareHelper r100, ImageModel r101) {
            Intrinsics.checkNotNullParameter(r101, "imageModel");
        }

        public static void setRaceLogo(ILiveQrCodeShareHelper r100, ImageModel r101) {
            Intrinsics.checkNotNullParameter(r101, "raceLogo");
        }

        public static void setSavePicBitmap(ILiveQrCodeShareHelper r100, Bitmap r101) {
            Intrinsics.checkNotNullParameter(r101, SimplayerImageStrategy.RESULT_BITMAP);
        }

        public static Object setTicketJson(ILiveQrCodeShareHelper r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "json");
            return null;
        }

        public static void setViewCutBitmap(ILiveQrCodeShareHelper r100, Bitmap r101) {
            Intrinsics.checkNotNullParameter(r101, SimplayerImageStrategy.RESULT_BITMAP);
        }
    }

    String getRelatedReviewContent();

    void setMatchSchedule(String r100);

    void setMatchTiming(String r100);

    void setOriginalPic(ImageModel r100);

    void setRaceLogo(ImageModel r100);

    void setSavePicBitmap(Bitmap r100);

    Object setTicketJson(String r100);

    void setViewCutBitmap(Bitmap r100);
}
