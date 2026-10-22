package com.stepos.aiengine.algorithm.chineseclip;

import android.graphics.Bitmap;
import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\n\u001a\u00020\u000bH&¢\u0006\u0004\b\f\u0010\rJ-\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0012H&¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ7\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/stepos/aiengine/algorithm/chineseclip/IChineseClip;", "", "extractImageFeature", "Lkotlin/Result;", "", "bitmap", "Landroid/graphics/Bitmap;", "extractImageFeature-IoAF18A", "(Landroid/graphics/Bitmap;)Ljava/lang/Object;", "extractTextFeature", "text", "", "extractTextFeature-IoAF18A", "(Ljava/lang/String;)Ljava/lang/Object;", "selectBestImage", "textFeature", "imagesFeature", "imageCount", "", "selectBestImage-0E7RQCE", "([F[FI)Ljava/lang/Object;", "args", "Landroid/os/Bundle;", "extractImageFeature-gIAlu-s", "(Landroid/graphics/Bitmap;Landroid/os/Bundle;)Ljava/lang/Object;", "extractTextFeature-gIAlu-s", "(Ljava/lang/String;Landroid/os/Bundle;)Ljava/lang/Object;", "selectBestImage-BWLJW6A", "([F[FILandroid/os/Bundle;)Ljava/lang/Object;", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface IChineseClip {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        /* renamed from: extractImageFeature-gIAlu-s, reason: not valid java name */
        public static Object m57extractImageFeaturegIAlus(IChineseClip iChineseClip, Bitmap bitmap, Bundle bundle) {
            p.i(bitmap, "bitmap");
            return iChineseClip.mo49extractImageFeatureIoAF18A(bitmap);
        }

        /* renamed from: extractTextFeature-gIAlu-s, reason: not valid java name */
        public static Object m58extractTextFeaturegIAlus(IChineseClip iChineseClip, String text, Bundle bundle) {
            p.i(text, "text");
            return iChineseClip.mo51extractTextFeatureIoAF18A(text);
        }

        /* renamed from: selectBestImage-BWLJW6A, reason: not valid java name */
        public static Object m59selectBestImageBWLJW6A(IChineseClip iChineseClip, float[] textFeature, float[] imagesFeature, int i10, Bundle bundle) {
            p.i(textFeature, "textFeature");
            p.i(imagesFeature, "imagesFeature");
            return iChineseClip.mo53selectBestImage0E7RQCE(textFeature, imagesFeature, i10);
        }
    }

    /* renamed from: extractImageFeature-IoAF18A */
    Object mo49extractImageFeatureIoAF18A(Bitmap bitmap);

    /* renamed from: extractImageFeature-gIAlu-s */
    Object mo50extractImageFeaturegIAlus(Bitmap bitmap, Bundle args);

    /* renamed from: extractTextFeature-IoAF18A */
    Object mo51extractTextFeatureIoAF18A(String text);

    /* renamed from: extractTextFeature-gIAlu-s */
    Object mo52extractTextFeaturegIAlus(String text, Bundle args);

    /* renamed from: selectBestImage-0E7RQCE */
    Object mo53selectBestImage0E7RQCE(float[] textFeature, float[] imagesFeature, int imageCount);

    /* renamed from: selectBestImage-BWLJW6A */
    Object mo54selectBestImageBWLJW6A(float[] textFeature, float[] imagesFeature, int imageCount, Bundle args);
}
