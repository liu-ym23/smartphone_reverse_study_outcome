package com.stepos.aiengine.adapter;

import android.graphics.Bitmap;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.aiengine.algorithm.chineseclip.IChineseClip;
import kotlin.Metadata;
import kotlin.b;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\f\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ-\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/stepos/aiengine/adapter/ChineseClipStubAdapter;", "Lcom/stepos/aiengine/algorithm/chineseclip/IChineseClip;", AppAgent.CONSTRUCT, "()V", "extractImageFeature", "Lkotlin/Result;", "", "bitmap", "Landroid/graphics/Bitmap;", "extractImageFeature-IoAF18A", "(Landroid/graphics/Bitmap;)Ljava/lang/Object;", "extractTextFeature", "text", "", "extractTextFeature-IoAF18A", "(Ljava/lang/String;)Ljava/lang/Object;", "selectBestImage", "textFeature", "imagesFeature", "imageCount", "", "selectBestImage-0E7RQCE", "([F[FI)Ljava/lang/Object;", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ChineseClipStubAdapter implements IChineseClip {
    @Override // com.stepos.aiengine.algorithm.chineseclip.IChineseClip
    /* renamed from: extractImageFeature-IoAF18A */
    public Object mo7338extractImageFeatureIoAF18A(Bitmap bitmap) {
        k.f(bitmap, "bitmap");
        return b.a(new UnsupportedOperationException("ChineseClip: not implemented yet"));
    }

    @Override // com.stepos.aiengine.algorithm.chineseclip.IChineseClip
    /* renamed from: extractTextFeature-IoAF18A */
    public Object mo7339extractTextFeatureIoAF18A(String text) {
        k.f(text, "text");
        return b.a(new UnsupportedOperationException("ChineseClip: not implemented yet"));
    }

    @Override // com.stepos.aiengine.algorithm.chineseclip.IChineseClip
    /* renamed from: selectBestImage-0E7RQCE */
    public Object mo7340selectBestImage0E7RQCE(float[] textFeature, float[] imagesFeature, int imageCount) {
        k.f(textFeature, "textFeature");
        k.f(imagesFeature, "imagesFeature");
        return b.a(new UnsupportedOperationException("ChineseClip: not implemented yet"));
    }
}
