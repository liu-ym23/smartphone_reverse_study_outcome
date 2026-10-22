package com.stepos.aiengine.adapter;

import Y8.t;
import Z8.C1172u;
import Z8.C1173v;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.adapter.ChineseClipAbilityAdapter;
import com.stepos.aiengine.algorithm.chineseclip.IChineseClip;
import com.stepos.core.AbilityHandle;
import com.stepos.core.data.ContentParams;
import com.stepos.core.data.ImageContent;
import com.stepos.core.data.MixedContent;
import com.stepos.core.data.PrimitiveContent;
import com.stepos.core.data.TextContent;
import com.stepos.core.data.base.Content;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;
import p9.q;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0001\u0018\u0000 *2\u00020\u0001:\u0001*B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J-\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ7\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u001f\u0010 J\u001d\u0010\"\u001a\u00020!*\u00020!2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b\"\u0010#J\u001d\u0010&\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010%\u001a\u00020$H\u0002¢\u0006\u0004\b&\u0010'R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)¨\u0006+"}, d2 = {"Lcom/stepos/aiengine/adapter/ChineseClipAbilityAdapter;", "Lcom/stepos/aiengine/algorithm/chineseclip/IChineseClip;", "Lcom/stepos/core/AbilityHandle;", "handle", "<init>", "(Lcom/stepos/core/AbilityHandle;)V", "Landroid/graphics/Bitmap;", "bitmap", "Lkotlin/Result;", "", "extractImageFeature-IoAF18A", "(Landroid/graphics/Bitmap;)Ljava/lang/Object;", "extractImageFeature", "Landroid/os/Bundle;", "args", "extractImageFeature-gIAlu-s", "(Landroid/graphics/Bitmap;Landroid/os/Bundle;)Ljava/lang/Object;", "", "text", "extractTextFeature-IoAF18A", "(Ljava/lang/String;)Ljava/lang/Object;", "extractTextFeature", "extractTextFeature-gIAlu-s", "(Ljava/lang/String;Landroid/os/Bundle;)Ljava/lang/Object;", "textFeature", "imagesFeature", "", "imageCount", "selectBestImage-0E7RQCE", "([F[FI)Ljava/lang/Object;", "selectBestImage", "selectBestImage-BWLJW6A", "([F[FILandroid/os/Bundle;)Ljava/lang/Object;", "Lcom/stepos/core/data/MixedContent;", Const.INTENT_KEY_UMID, "(Lcom/stepos/core/data/MixedContent;Landroid/os/Bundle;)Lcom/stepos/core/data/MixedContent;", "Lcom/stepos/core/data/base/Content;", "input", "e", "(Lcom/stepos/core/data/base/Content;)Ljava/lang/Object;", Const.INTENT_KEY_APIKEY, "Lcom/stepos/core/AbilityHandle;", "Companion", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ChineseClipAbilityAdapter implements IChineseClip {
    public static final String KEY_IMAGES_FEATURE = "images_feature";
    public static final String KEY_IMAGE_COUNT = "image_count";
    public static final String KEY_TEXT_FEATURE = "text_feature";

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final AbilityHandle handle;

    public ChineseClipAbilityAdapter(AbilityHandle handle) {
        p.i(handle, "handle");
        this.handle = handle;
    }

    /* JADX WARN: Type inference failed for: r3v4, types: [T, java.lang.Object] */
    public static final t f(Ref$ObjectRef ref$ObjectRef, CountDownLatch countDownLatch, String str, PrimitiveContent r10) {
        p.i(str, "<unused var>");
        p.i(r10, "r");
        Result.Companion companion = Result.INSTANCE;
        ref$ObjectRef.f34820a = Result.b(r10.getValue());
        countDownLatch.countDown();
        return t.f7040a;
    }

    /* JADX WARN: Type inference failed for: r4v5, types: [T, java.lang.Object] */
    public static final t g(Ref$ObjectRef ref$ObjectRef, CountDownLatch countDownLatch, String str, int i10, String msg) {
        p.i(str, "<unused var>");
        p.i(msg, "msg");
        Result.Companion companion = Result.INSTANCE;
        ref$ObjectRef.f34820a = Result.b(C4849c.a(new RuntimeException("code=" + i10 + ", " + msg)));
        countDownLatch.countDown();
        return t.f7040a;
    }

    public static final t h(CountDownLatch countDownLatch, String it) {
        p.i(it, "it");
        countDownLatch.countDown();
        return t.f7040a;
    }

    public final MixedContent d(MixedContent mixedContent, Bundle bundle) {
        ContentParams.Builder builder = new ContentParams.Builder();
        if (TaskPriorityArg.INSTANCE.applyTo(builder, bundle)) {
            mixedContent.setParams(builder.build());
        }
        return mixedContent;
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [T, java.lang.Object] */
    public final Object e(Content input) throws InterruptedException {
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        Result.Companion companion = Result.INSTANCE;
        ref$ObjectRef.f34820a = Result.b(C4849c.a(new RuntimeException("timeout")));
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        AbilityHandle.infer$default(this.handle, input, new p9.p() { // from class: O4.p
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return ChineseClipAbilityAdapter.f(ref$ObjectRef, countDownLatch, (String) obj, (PrimitiveContent) obj2);
            }
        }, new q() { // from class: O4.q
            @Override // p9.q
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return ChineseClipAbilityAdapter.g(ref$ObjectRef, countDownLatch, (String) obj, ((Integer) obj2).intValue(), (String) obj3);
            }
        }, new InterfaceC5074l() { // from class: O4.r
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ChineseClipAbilityAdapter.h(countDownLatch, (String) obj);
            }
        }, null, null, 48, null);
        countDownLatch.await(30L, TimeUnit.SECONDS);
        return ref$ObjectRef.f34820a;
    }

    @Override // com.stepos.aiengine.algorithm.chineseclip.IChineseClip
    /* renamed from: extractImageFeature-IoAF18A, reason: not valid java name */
    public Object mo49extractImageFeatureIoAF18A(Bitmap bitmap) {
        p.i(bitmap, "bitmap");
        return mo50extractImageFeaturegIAlus(bitmap, null);
    }

    @Override // com.stepos.aiengine.algorithm.chineseclip.IChineseClip
    /* renamed from: extractImageFeature-gIAlu-s, reason: not valid java name */
    public Object mo50extractImageFeaturegIAlus(Bitmap bitmap, Bundle args) throws InterruptedException {
        p.i(bitmap, "bitmap");
        ImageContent imageContentFromBitmap$default = ImageContent.Companion.fromBitmap$default(ImageContent.INSTANCE, bitmap, 0, 0, 0, 0, 30, null);
        Object objE = e(d(new MixedContent((List<? extends Content>) C1172u.e(imageContentFromBitmap$default)), args));
        imageContentFromBitmap$default.releaseSharedMemory();
        return objE;
    }

    @Override // com.stepos.aiengine.algorithm.chineseclip.IChineseClip
    /* renamed from: extractTextFeature-IoAF18A, reason: not valid java name */
    public Object mo51extractTextFeatureIoAF18A(String text) {
        p.i(text, "text");
        return mo52extractTextFeaturegIAlus(text, null);
    }

    @Override // com.stepos.aiengine.algorithm.chineseclip.IChineseClip
    /* renamed from: extractTextFeature-gIAlu-s, reason: not valid java name */
    public Object mo52extractTextFeaturegIAlus(String text, Bundle args) {
        p.i(text, "text");
        return e(d(new MixedContent((List<? extends Content>) C1172u.e(new TextContent(text))), args));
    }

    @Override // com.stepos.aiengine.algorithm.chineseclip.IChineseClip
    /* renamed from: selectBestImage-0E7RQCE, reason: not valid java name */
    public Object mo53selectBestImage0E7RQCE(float[] textFeature, float[] imagesFeature, int imageCount) {
        p.i(textFeature, "textFeature");
        p.i(imagesFeature, "imagesFeature");
        return mo54selectBestImageBWLJW6A(textFeature, imagesFeature, imageCount, null);
    }

    @Override // com.stepos.aiengine.algorithm.chineseclip.IChineseClip
    /* renamed from: selectBestImage-BWLJW6A, reason: not valid java name */
    public Object mo54selectBestImageBWLJW6A(float[] textFeature, float[] imagesFeature, int imageCount, Bundle args) {
        p.i(textFeature, "textFeature");
        p.i(imagesFeature, "imagesFeature");
        ContentParams.Builder builderPutInt = new ContentParams.Builder().putFloatArray(KEY_TEXT_FEATURE, textFeature).putFloatArray(KEY_IMAGES_FEATURE, imagesFeature).putInt("image_count", imageCount);
        TaskPriorityArg.INSTANCE.applyTo(builderPutInt, args);
        MixedContent mixedContent = new MixedContent((List<? extends Content>) C1173v.m());
        mixedContent.setParams(builderPutInt.build());
        return e(mixedContent);
    }
}
