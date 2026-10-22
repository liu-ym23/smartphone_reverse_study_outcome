package com.stepos.aiengine.algorithm.chineseclip;

import android.graphics.Bitmap;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\n\u001a\u00020\u000bH&¢\u0006\u0004\b\f\u0010\rJ-\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0012H&¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/stepos/aiengine/algorithm/chineseclip/IChineseClip;", "", "extractImageFeature", "Lkotlin/Result;", "", "bitmap", "Landroid/graphics/Bitmap;", "extractImageFeature-IoAF18A", "(Landroid/graphics/Bitmap;)Ljava/lang/Object;", "extractTextFeature", "text", "", "extractTextFeature-IoAF18A", "(Ljava/lang/String;)Ljava/lang/Object;", "selectBestImage", "textFeature", "imagesFeature", "imageCount", "", "selectBestImage-0E7RQCE", "([F[FI)Ljava/lang/Object;", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface IChineseClip {
    /* renamed from: extractImageFeature-IoAF18A */
    Object mo7338extractImageFeatureIoAF18A(Bitmap bitmap);

    /* renamed from: extractTextFeature-IoAF18A */
    Object mo7339extractTextFeatureIoAF18A(String text);

    /* renamed from: selectBestImage-0E7RQCE */
    Object mo7340selectBestImage0E7RQCE(float[] textFeature, float[] imagesFeature, int imageCount);
}
