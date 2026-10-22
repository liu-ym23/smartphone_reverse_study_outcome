package com.stepos.aiengine.adapter;

import M5.b;
import Y8.t;
import android.os.Bundle;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.adapter.FaceQualityAbilityAdapter;
import com.stepos.aiengine.algorithm.face.IFaceQuality;
import com.stepos.aiengine.api.task.AlgorithmToken;
import com.stepos.aiengine.args.result.ErrorBundleKt;
import com.stepos.aiengine.args.result.FaceQualityResultBundle;
import com.stepos.core.AbilityHandle;
import com.stepos.core.ability.converter.BundleContentBridge;
import com.stepos.core.data.ContentParams;
import com.stepos.core.data.ImageContent;
import com.stepos.core.data.TextContent;
import com.stepos.core.data.base.Content;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.p;
import org.json.JSONObject;
import p9.InterfaceC5074l;
import p9.q;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/stepos/aiengine/adapter/FaceQualityAbilityAdapter;", "Lcom/stepos/aiengine/algorithm/face/IFaceQuality;", "Lcom/stepos/core/AbilityHandle;", "handle", "<init>", "(Lcom/stepos/core/AbilityHandle;)V", "Lcom/stepos/aiengine/api/task/AlgorithmToken;", b.CREDENTIAL_TOKEN, "Landroid/os/Bundle;", "image", "assessQuality", "(Lcom/stepos/aiengine/api/task/AlgorithmToken;Landroid/os/Bundle;)Landroid/os/Bundle;", "", "json", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;)Landroid/os/Bundle;", Const.INTENT_KEY_APIKEY, "Lcom/stepos/core/AbilityHandle;", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FaceQualityAbilityAdapter implements IFaceQuality {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final AbilityHandle handle;

    public FaceQualityAbilityAdapter(AbilityHandle handle) {
        p.i(handle, "handle");
        this.handle = handle;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [T, android.os.Bundle] */
    public static final t d(Ref$ObjectRef ref$ObjectRef, FaceQualityAbilityAdapter faceQualityAbilityAdapter, CountDownLatch countDownLatch, String str, TextContent r10) {
        p.i(str, "<unused var>");
        p.i(r10, "r");
        ref$ObjectRef.f34820a = faceQualityAbilityAdapter.g(r10.getText());
        countDownLatch.countDown();
        return t.f7040a;
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [T, android.os.Bundle] */
    public static final t e(Ref$ObjectRef ref$ObjectRef, CountDownLatch countDownLatch, String str, int i10, String msg) {
        p.i(str, "<unused var>");
        p.i(msg, "msg");
        ?? bundle = new Bundle();
        ErrorBundleKt.writeInferError(bundle, i10, msg);
        ref$ObjectRef.f34820a = bundle;
        countDownLatch.countDown();
        return t.f7040a;
    }

    public static final t f(CountDownLatch countDownLatch, String it) {
        p.i(it, "it");
        countDownLatch.countDown();
        return t.f7040a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.stepos.aiengine.algorithm.face.IFaceQuality
    public Bundle assessQuality(AlgorithmToken token, Bundle image) throws InterruptedException {
        Object objB;
        p.i(token, "token");
        p.i(image, "image");
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(BundleContentBridge.INSTANCE.fromVisionImageBundle(image, false).getContent());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            Bundle bundle = new Bundle();
            bundle.putString("exception", "assessQuality: " + thE.getMessage());
            return bundle;
        }
        Content content = (Content) objB;
        ContentParams.Builder builder = new ContentParams.Builder();
        if (TaskPriorityArg.INSTANCE.applyTo(builder, image)) {
            content.setParams(builder.build());
        }
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        AbilityHandle.infer$default(this.handle, String.valueOf(token.getIdentity()), content, new p9.p() { // from class: O4.F
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return FaceQualityAbilityAdapter.d(ref$ObjectRef, this, countDownLatch, (String) obj, (TextContent) obj2);
            }
        }, new q() { // from class: O4.G
            @Override // p9.q
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return FaceQualityAbilityAdapter.e(ref$ObjectRef, countDownLatch, (String) obj, ((Integer) obj2).intValue(), (String) obj3);
            }
        }, new InterfaceC5074l() { // from class: O4.H
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return FaceQualityAbilityAdapter.f(countDownLatch, (String) obj);
            }
        }, (q) null, (p9.p) null, 96, (Object) null);
        boolean zAwait = countDownLatch.await(30L, TimeUnit.SECONDS);
        ImageContent imageContent = content instanceof ImageContent ? (ImageContent) content : null;
        if (imageContent != null) {
            imageContent.releaseSharedMemory();
        }
        Bundle bundle2 = (Bundle) ref$ObjectRef.f34820a;
        if (bundle2 == null) {
            bundle2 = new Bundle();
            bundle2.putString("exception", zAwait ? "infer completed without result" : "infer timeout");
        }
        return bundle2;
    }

    public final Bundle g(String json) {
        try {
            JSONObject jSONObject = new JSONObject(json);
            if (p.d(jSONObject.optString("type"), "error")) {
                Bundle bundle = new Bundle();
                bundle.putString("exception", jSONObject.optString("message"));
                return bundle;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putFloat(FaceQualityResultBundle.KEY_QUALITY_SCORE, (float) jSONObject.optDouble("quality", -1.0d));
            return bundle2;
        } catch (Exception e10) {
            Bundle bundle3 = new Bundle();
            bundle3.putString("exception", "parse error: " + e10.getMessage());
            return bundle3;
        }
    }
}
