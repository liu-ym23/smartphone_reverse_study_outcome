package com.stepos.aiengine.adapter;

import H4.o;
import Q4.f;
import Q4.g;
import Q4.h;
import android.graphics.Bitmap;
import androidx.annotation.RequiresApi;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.aiengine.algorithm.chineseclip.IChineseClip;
import com.stepos.core.c;
import com.stepos.core.data.ContentParams;
import com.stepos.core.data.ImageContent;
import com.stepos.core.data.MixedContent;
import com.stepos.core.data.TextContent;
import com.stepos.core.data.base.Content;
import com.stepos.taskrobot.llmapi.stepfun.InjectExperienceResult;
import d5.i;
import d5.n;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.b;
import kotlin.collections.EmptyList;
import kotlin.collections.a;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@RequiresApi(27)
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\b\u0001\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J-\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/stepos/aiengine/adapter/ChineseClipAbilityAdapter;", "Lcom/stepos/aiengine/algorithm/chineseclip/IChineseClip;", "Lcom/stepos/core/c;", "handle", AppAgent.CONSTRUCT, "(Lcom/stepos/core/c;)V", "Landroid/graphics/Bitmap;", "bitmap", "Lkotlin/Result;", "", "extractImageFeature-IoAF18A", "(Landroid/graphics/Bitmap;)Ljava/lang/Object;", "extractImageFeature", "", "text", "extractTextFeature-IoAF18A", "(Ljava/lang/String;)Ljava/lang/Object;", "extractTextFeature", "textFeature", "imagesFeature", "", "imageCount", "selectBestImage-0E7RQCE", "([F[FI)Ljava/lang/Object;", "selectBestImage", "Companion", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ChineseClipAbilityAdapter implements IChineseClip {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String KEY_IMAGES_FEATURE = "images_feature";
    public static final String KEY_IMAGE_COUNT = "image_count";
    public static final String KEY_TEXT_FEATURE = "text_feature";

    /* renamed from: a, reason: collision with root package name */
    public final c f3458a;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/stepos/aiengine/adapter/ChineseClipAbilityAdapter$Companion;", "", "", "KEY_TEXT_FEATURE", "Ljava/lang/String;", "KEY_IMAGES_FEATURE", "KEY_IMAGE_COUNT", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public Companion(e eVar) {
        }
    }

    public ChineseClipAbilityAdapter(c handle) {
        k.f(handle, "handle");
        this.f3458a = handle;
    }

    public final Object a(MixedContent mixedContent) throws InterruptedException {
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.f4920a = b.a(new RuntimeException(InjectExperienceResult.REASON_TIMEOUT));
        CountDownLatch countDownLatch = new CountDownLatch(1);
        c.h(this.f3458a, mixedContent, new f(ref$ObjectRef, countDownLatch, 0), new g(ref$ObjectRef, countDownLatch, 0), new h(countDownLatch, 0));
        countDownLatch.await(30L, TimeUnit.SECONDS);
        return ref$ObjectRef.f4920a;
    }

    @Override // com.stepos.aiengine.algorithm.chineseclip.IChineseClip
    /* renamed from: extractImageFeature-IoAF18A, reason: not valid java name */
    public Object mo7338extractImageFeatureIoAF18A(Bitmap bitmap) throws InterruptedException {
        k.f(bitmap, "bitmap");
        ImageContent imageContentB = n.b(ImageContent.Companion, bitmap, 0, 0, 0, 0, 30);
        Object objA = a(new MixedContent((List<? extends Content>) o.M(imageContentB)));
        imageContentB.releaseSharedMemory();
        return objA;
    }

    @Override // com.stepos.aiengine.algorithm.chineseclip.IChineseClip
    /* renamed from: extractTextFeature-IoAF18A, reason: not valid java name */
    public Object mo7339extractTextFeatureIoAF18A(String text) {
        k.f(text, "text");
        return a(new MixedContent((List<? extends Content>) o.M(new TextContent(text))));
    }

    @Override // com.stepos.aiengine.algorithm.chineseclip.IChineseClip
    /* renamed from: selectBestImage-0E7RQCE, reason: not valid java name */
    public Object mo7340selectBestImage0E7RQCE(float[] textFeature, float[] imagesFeature, int imageCount) {
        k.f(textFeature, "textFeature");
        k.f(imagesFeature, "imagesFeature");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(KEY_TEXT_FEATURE, new d5.f(textFeature));
        linkedHashMap.put(KEY_IMAGES_FEATURE, new d5.f(imagesFeature));
        linkedHashMap.put("image_count", new i(imageCount));
        ContentParams contentParams = new ContentParams(a.Y(linkedHashMap), null);
        MixedContent mixedContent = new MixedContent(EmptyList.f4893a);
        mixedContent.setParams(contentParams);
        return a(mixedContent);
    }
}
