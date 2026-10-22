package com.stepos.aiengine.adapter;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.stepos.aiengine.algorithm.chineseclip.IChineseClip;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\f\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ-\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/stepos/aiengine/adapter/ChineseClipStubAdapter;", "Lcom/stepos/aiengine/algorithm/chineseclip/IChineseClip;", "<init>", "()V", "extractImageFeature", "Lkotlin/Result;", "", "bitmap", "Landroid/graphics/Bitmap;", "extractImageFeature-IoAF18A", "(Landroid/graphics/Bitmap;)Ljava/lang/Object;", "extractTextFeature", "text", "", "extractTextFeature-IoAF18A", "(Ljava/lang/String;)Ljava/lang/Object;", "selectBestImage", "textFeature", "imagesFeature", "imageCount", "", "selectBestImage-0E7RQCE", "([F[FI)Ljava/lang/Object;", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ChineseClipStubAdapter implements IChineseClip {
    @Override // com.stepos.aiengine.algorithm.chineseclip.IChineseClip
    /* renamed from: extractImageFeature-IoAF18A */
    public Object mo49extractImageFeatureIoAF18A(Bitmap bitmap) {
        p.i(bitmap, "bitmap");
        Result.Companion companion = Result.INSTANCE;
        return Result.b(C4849c.a(new UnsupportedOperationException("ChineseClip: not implemented yet")));
    }

    @Override // com.stepos.aiengine.algorithm.chineseclip.IChineseClip
    /* renamed from: extractImageFeature-gIAlu-s */
    public Object mo50extractImageFeaturegIAlus(Bitmap bitmap, Bundle bundle) {
        return IChineseClip.DefaultImpls.m57extractImageFeaturegIAlus(this, bitmap, bundle);
    }

    @Override // com.stepos.aiengine.algorithm.chineseclip.IChineseClip
    /* renamed from: extractTextFeature-IoAF18A */
    public Object mo51extractTextFeatureIoAF18A(String text) {
        p.i(text, "text");
        Result.Companion companion = Result.INSTANCE;
        return Result.b(C4849c.a(new UnsupportedOperationException("ChineseClip: not implemented yet")));
    }

    @Override // com.stepos.aiengine.algorithm.chineseclip.IChineseClip
    /* renamed from: extractTextFeature-gIAlu-s */
    public Object mo52extractTextFeaturegIAlus(String str, Bundle bundle) {
        return IChineseClip.DefaultImpls.m58extractTextFeaturegIAlus(this, str, bundle);
    }

    @Override // com.stepos.aiengine.algorithm.chineseclip.IChineseClip
    /* renamed from: selectBestImage-0E7RQCE */
    public Object mo53selectBestImage0E7RQCE(float[] textFeature, float[] imagesFeature, int imageCount) {
        p.i(textFeature, "textFeature");
        p.i(imagesFeature, "imagesFeature");
        Result.Companion companion = Result.INSTANCE;
        return Result.b(C4849c.a(new UnsupportedOperationException("ChineseClip: not implemented yet")));
    }

    @Override // com.stepos.aiengine.algorithm.chineseclip.IChineseClip
    /* renamed from: selectBestImage-BWLJW6A */
    public Object mo54selectBestImageBWLJW6A(float[] fArr, float[] fArr2, int i10, Bundle bundle) {
        return IChineseClip.DefaultImpls.m59selectBestImageBWLJW6A(this, fArr, fArr2, i10, bundle);
    }
}
