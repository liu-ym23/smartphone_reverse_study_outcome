package com.stepos.aiengine.adapter;

import M5.b;
import Y8.t;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.adapter.ImageMattingAbilityAdapter;
import com.stepos.aiengine.algorithm.imagematting.IImageMatting;
import com.stepos.aiengine.api.task.AlgorithmToken;
import com.stepos.aiengine.args.MattingOptionBundle;
import com.stepos.aiengine.args.result.ErrorBundleKt;
import com.stepos.ame.sdk.SkillStoreKt;
import com.stepos.core.AbilityHandle;
import com.stepos.core.ability.converter.BundleContentBridge;
import com.stepos.core.ability.converter.VisionParamKeys;
import com.stepos.core.data.ContentParams;
import com.stepos.core.data.ImageContent;
import com.stepos.core.data.base.Content;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.p;
import l9.C4877a;
import p9.InterfaceC5074l;
import p9.q;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J'\u0010\f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ'\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J'\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lcom/stepos/aiengine/adapter/ImageMattingAbilityAdapter;", "Lcom/stepos/aiengine/algorithm/imagematting/IImageMatting;", "Lcom/stepos/core/AbilityHandle;", "handle", "<init>", "(Lcom/stepos/core/AbilityHandle;)V", "Lcom/stepos/aiengine/api/task/AlgorithmToken;", b.CREDENTIAL_TOKEN, "Landroid/os/Bundle;", "image", "", MattingOptionBundle.KEY_ROTATE_ANGLE, "cutImage", "(Lcom/stepos/aiengine/api/task/AlgorithmToken;Landroid/os/Bundle;I)Landroid/os/Bundle;", "options", "mattingWith", "(Lcom/stepos/aiengine/api/task/AlgorithmToken;Landroid/os/Bundle;Landroid/os/Bundle;)Landroid/os/Bundle;", "", "requestId", "Lcom/stepos/core/data/base/Content;", "inputContent", Const.INTENT_KEY_UMID, "(Ljava/lang/String;Lcom/stepos/core/data/base/Content;)Landroid/os/Bundle;", "Lcom/stepos/core/data/ImageContent;", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "Lcom/stepos/core/data/ContentParams;", "params", "bundle", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Lcom/stepos/core/data/ImageContent;Lcom/stepos/core/data/ContentParams;Landroid/os/Bundle;)Z", Const.INTENT_KEY_APIKEY, "Lcom/stepos/core/AbilityHandle;", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ImageMattingAbilityAdapter implements IImageMatting {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final AbilityHandle handle;

    public ImageMattingAbilityAdapter(AbilityHandle handle) {
        p.i(handle, "handle");
        this.handle = handle;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v3, types: [T, android.os.BaseBundle, android.os.Bundle] */
    public static final t e(Ref$ObjectRef ref$ObjectRef, CountDownLatch countDownLatch, ImageMattingAbilityAdapter imageMattingAbilityAdapter, String str, ImageContent r10) throws ErrnoException {
        p.i(str, "<unused var>");
        p.i(r10, "r");
        ?? singleImageBundle = BundleContentBridge.INSTANCE.toSingleImageBundle(r10);
        ContentParams params = r10.getParams();
        if (params != null) {
            int[] intArray = params.getIntArray("mat_region");
            if (intArray != null) {
                singleImageBundle.putIntArray("mat_region", intArray);
            }
            if (params.containsKey("mat_proportion")) {
                singleImageBundle.putFloat("mat_proportion", ContentParams.getFloat$default(params, "mat_proportion", 0.0f, 2, null));
            }
            if (params.containsKey("mat_sample_size")) {
                singleImageBundle.putInt("mat_sample_size", ContentParams.getInt$default(params, "mat_sample_size", 0, 2, null));
            }
            if (!imageMattingAbilityAdapter.h(r10, params, singleImageBundle)) {
                int[] intArray2 = params.getIntArray("mat_contours");
                if (intArray2 != null) {
                    singleImageBundle.putIntArray("mat_contours", intArray2);
                }
                int[] intArray3 = params.getIntArray("mat_hierarchies");
                if (intArray3 != null) {
                    singleImageBundle.putIntArray("mat_hierarchies", intArray3);
                }
            }
        }
        ref$ObjectRef.f34820a = singleImageBundle;
        countDownLatch.countDown();
        return t.f7040a;
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [T, android.os.Bundle] */
    public static final t f(Ref$ObjectRef ref$ObjectRef, CountDownLatch countDownLatch, String str, int i10, String msg) {
        p.i(str, "<unused var>");
        p.i(msg, "msg");
        ?? bundle = new Bundle();
        ErrorBundleKt.writeInferError(bundle, i10, msg);
        ref$ObjectRef.f34820a = bundle;
        countDownLatch.countDown();
        return t.f7040a;
    }

    public static final t g(CountDownLatch countDownLatch, String it) {
        p.i(it, "it");
        countDownLatch.countDown();
        return t.f7040a;
    }

    @Override // com.stepos.aiengine.algorithm.imagematting.IImageMatting
    public Bundle cutImage(AlgorithmToken token, Bundle image, int rotateAngle) {
        Object objB;
        p.i(token, "token");
        p.i(image, "image");
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(BundleContentBridge.INSTANCE.fromVisionImageBundle(image, true));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE == null) {
            BundleContentBridge.VisionImageInput visionImageInput = (BundleContentBridge.VisionImageInput) objB;
            ContentParams.Builder builderPutInt = new ContentParams.Builder().putInt("rotate_angle", rotateAngle).putInt(VisionParamKeys.SAMPLE_SIZE, visionImageInput.getSampleSize());
            TaskPriorityArg.INSTANCE.applyTo(builderPutInt, image);
            visionImageInput.getContent().setParams(builderPutInt.build());
            return d(String.valueOf(token.getIdentity()), visionImageInput.getContent());
        }
        Bundle bundle = new Bundle();
        bundle.putString("exception", "cutImage: " + thE.getMessage());
        return bundle;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Bundle d(String requestId, Content inputContent) throws InterruptedException {
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        AbilityHandle.infer$default(this.handle, requestId, inputContent, new p9.p() { // from class: O4.O
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return ImageMattingAbilityAdapter.e(ref$ObjectRef, countDownLatch, this, (String) obj, (ImageContent) obj2);
            }
        }, new q() { // from class: O4.P
            @Override // p9.q
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return ImageMattingAbilityAdapter.f(ref$ObjectRef, countDownLatch, (String) obj, ((Integer) obj2).intValue(), (String) obj3);
            }
        }, new InterfaceC5074l() { // from class: O4.Q
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ImageMattingAbilityAdapter.g(countDownLatch, (String) obj);
            }
        }, (q) null, (p9.p) null, 96, (Object) null);
        boolean zAwait = countDownLatch.await(30L, TimeUnit.SECONDS);
        ImageContent imageContent = inputContent instanceof ImageContent ? (ImageContent) inputContent : null;
        if (imageContent != null) {
            imageContent.releaseSharedMemory();
        }
        Bundle bundle = (Bundle) ref$ObjectRef.f34820a;
        if (bundle == null) {
            bundle = new Bundle();
            bundle.putString("exception", zAwait ? "infer completed without result" : "infer timeout");
        }
        return bundle;
    }

    public final boolean h(ImageContent content, ContentParams params, Bundle bundle) {
        Object objB;
        int i10 = params.getInt("mat_contours_ints", 0);
        if (i10 <= 0) {
            return false;
        }
        int i11 = params.getInt("mat_hierarchies_ints", 0);
        ParcelFileDescriptor shmFd = content.getShmFd();
        if (shmFd == null) {
            return false;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            try {
                FileInputStream fileInputStream = new FileInputStream(shmFd.getFileDescriptor());
                try {
                    byte[] bArrC = C4877a.c(fileInputStream);
                    l9.b.a(fileInputStream, null);
                    l9.b.a(shmFd, null);
                    ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArrC).order(ByteOrder.LITTLE_ENDIAN);
                    int[] iArr = new int[i10];
                    for (int i12 = 0; i12 < i10; i12++) {
                        iArr[i12] = byteBufferOrder.getInt();
                    }
                    bundle.putIntArray("mat_contours", iArr);
                    if (i11 > 0) {
                        int[] iArr2 = new int[i11];
                        for (int i13 = 0; i13 < i11; i13++) {
                            iArr2[i13] = byteBufferOrder.getInt();
                        }
                        bundle.putIntArray("mat_hierarchies", iArr2);
                    }
                    objB = Result.b(Boolean.TRUE);
                } finally {
                }
            } finally {
            }
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Boolean bool = Boolean.FALSE;
        if (Result.g(objB)) {
            objB = bool;
        }
        return ((Boolean) objB).booleanValue();
    }

    @Override // com.stepos.aiengine.algorithm.imagematting.IImageMatting
    public Bundle mattingWith(AlgorithmToken token, Bundle image, Bundle options) {
        Object objB;
        p.i(token, "token");
        p.i(image, "image");
        p.i(options, "options");
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(BundleContentBridge.INSTANCE.fromVisionImageBundle(image, true));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            Bundle bundle = new Bundle();
            bundle.putString("exception", "mattingWith: " + thE.getMessage());
            return bundle;
        }
        BundleContentBridge.VisionImageInput visionImageInput = (BundleContentBridge.VisionImageInput) objB;
        MattingOptionBundle mattingOptionBundleFromBundle = MattingOptionBundle.INSTANCE.fromBundle(options);
        ContentParams.Builder builderPutBoolean = new ContentParams.Builder().putInt("rotate_angle", mattingOptionBundleFromBundle.getRotateAngle()).putInt(VisionParamKeys.SAMPLE_SIZE, visionImageInput.getSampleSize()).putBoolean(VisionParamKeys.UNLIMITED_PROPORTION, mattingOptionBundleFromBundle.isUnlimitedProportion()).putBoolean(VisionParamKeys.RETURN_IMAGE, mattingOptionBundleFromBundle.isReturnImage());
        TaskPriorityArg taskPriorityArg = TaskPriorityArg.INSTANCE;
        if (!taskPriorityArg.applyTo(builderPutBoolean, options)) {
            taskPriorityArg.applyTo(builderPutBoolean, image);
        }
        visionImageInput.getContent().setParams(builderPutBoolean.build());
        return d(String.valueOf(token.getIdentity()), visionImageInput.getContent());
    }
}
