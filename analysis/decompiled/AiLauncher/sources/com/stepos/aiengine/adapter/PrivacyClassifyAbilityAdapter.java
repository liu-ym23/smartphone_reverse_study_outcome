package com.stepos.aiengine.adapter;

import M5.b;
import Y8.t;
import android.os.Bundle;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.adapter.PrivacyClassifyAbilityAdapter;
import com.stepos.aiengine.algorithm.privacyclassify.IPrivacyClassify;
import com.stepos.aiengine.algorithm.privacyclassify.PrivacyClassifyCallback;
import com.stepos.aiengine.algorithm.privacyclassify.PrivacyClassifyResult;
import com.stepos.aiengine.api.task.AlgorithmToken;
import com.stepos.aiengine.api.task.IBundleCallback;
import com.stepos.core.AbilityHandle;
import com.stepos.core.data.TextContent;
import com.stepos.core.error.AIEngineError;
import com.stepos.statsapp.v3.lib.plugin.net.multipart.e;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.p;
import org.json.JSONArray;
import org.json.JSONObject;
import p9.InterfaceC5074l;
import p9.q;
import v9.C5685n;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 %2\u00020\u0001:\u0001#B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ!\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J)\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J9\u0010\u0010\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0010\u0010\u001bJ)\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b\u001c\u0010\u0015J!\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u001f\u0010!\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b!\u0010\"R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$¨\u0006&"}, d2 = {"Lcom/stepos/aiengine/adapter/PrivacyClassifyAbilityAdapter;", "Lcom/stepos/aiengine/algorithm/privacyclassify/IPrivacyClassify;", "Lcom/stepos/core/AbilityHandle;", "handle", "<init>", "(Lcom/stepos/core/AbilityHandle;)V", "", e.f30860s, "", "cancel", "(J)Z", "", "text", "Landroid/os/Bundle;", "args", "Lcom/stepos/aiengine/algorithm/privacyclassify/PrivacyClassifyResult;", "classify", "(Ljava/lang/String;Landroid/os/Bundle;)Lcom/stepos/aiengine/algorithm/privacyclassify/PrivacyClassifyResult;", "", "threshold", "classifyWithThreshold", "(Ljava/lang/String;FLandroid/os/Bundle;)Lcom/stepos/aiengine/algorithm/privacyclassify/PrivacyClassifyResult;", "Lcom/stepos/aiengine/api/task/AlgorithmToken;", b.CREDENTIAL_TOKEN, "Lcom/stepos/aiengine/api/task/IBundleCallback;", "callback", "LY8/t;", "(Lcom/stepos/aiengine/api/task/AlgorithmToken;Ljava/lang/String;FLandroid/os/Bundle;Lcom/stepos/aiengine/api/task/IBundleCallback;)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "Lcom/stepos/core/data/TextContent;", "o", "(Ljava/lang/String;Landroid/os/Bundle;)Lcom/stepos/core/data/TextContent;", "json", "n", "(Ljava/lang/String;F)Lcom/stepos/aiengine/algorithm/privacyclassify/PrivacyClassifyResult;", Const.INTENT_KEY_APIKEY, "Lcom/stepos/core/AbilityHandle;", Const.INTENT_KEY_PKGNAME, "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PrivacyClassifyAbilityAdapter implements IPrivacyClassify {

    @Deprecated
    public static final float DEFAULT_THRESHOLD = 0.8f;

    @Deprecated
    public static final long TIMEOUT_SEC = 30;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final AbilityHandle handle;

    public PrivacyClassifyAbilityAdapter(AbilityHandle handle) {
        p.i(handle, "handle");
        this.handle = handle;
    }

    public static final t g(float f10, PrivacyClassifyAbilityAdapter privacyClassifyAbilityAdapter, IBundleCallback iBundleCallback, String str, TextContent r10) {
        p.i(str, "<unused var>");
        p.i(r10, "r");
        String text = r10.getText();
        PrivacyClassifyResult privacyClassifyResultError = (text == null || text.length() == 0) ? PrivacyClassifyResult.INSTANCE.error("empty result", f10) : privacyClassifyAbilityAdapter.n(text, f10);
        if (privacyClassifyResultError.getErrorMessage() != null) {
            Bundle bundle = new Bundle();
            bundle.putString("pc_exception", privacyClassifyResultError.getErrorMessage());
            bundle.putInt("pc_error_code", AIEngineError.INFERENCE_RESULT_PARSE_FAILED);
            iBundleCallback.onCall(bundle);
        } else {
            iBundleCallback.onCall(PrivacyClassifyCallback.INSTANCE.bundleOf(privacyClassifyResultError));
        }
        return t.f7040a;
    }

    public static final t h(IBundleCallback iBundleCallback, String str, int i10, String msg) {
        p.i(str, "<unused var>");
        p.i(msg, "msg");
        Bundle bundle = new Bundle();
        bundle.putString("pc_exception", msg);
        bundle.putInt("pc_error_code", i10);
        iBundleCallback.onCall(bundle);
        return t.f7040a;
    }

    public static final t i(IBundleCallback iBundleCallback, String str, int i10, String str2) {
        p.i(str, "<unused var>");
        p.i(str2, "<unused var>");
        Bundle bundle = new Bundle();
        bundle.putBoolean(PrivacyClassifyCallback.KEY_CANCELLED, true);
        iBundleCallback.onCall(bundle);
        return t.f7040a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final t k(Ref$ObjectRef ref$ObjectRef, CountDownLatch countDownLatch, String str, TextContent r10) {
        p.i(str, "<unused var>");
        p.i(r10, "r");
        ref$ObjectRef.f34820a = r10;
        countDownLatch.countDown();
        return t.f7040a;
    }

    /* JADX WARN: Type inference failed for: r4v2, types: [T, java.lang.RuntimeException] */
    public static final t l(Ref$ObjectRef ref$ObjectRef, CountDownLatch countDownLatch, String str, int i10, String msg) {
        p.i(str, "<unused var>");
        p.i(msg, "msg");
        ref$ObjectRef.f34820a = new RuntimeException("[" + i10 + "] " + msg);
        countDownLatch.countDown();
        return t.f7040a;
    }

    public static final t m(CountDownLatch countDownLatch, String str) {
        p.i(str, "<unused var>");
        countDownLatch.countDown();
        return t.f7040a;
    }

    @Override // com.stepos.aiengine.algorithm.privacyclassify.IPrivacyClassify
    public boolean cancel(long identity) {
        return this.handle.cancel(String.valueOf(identity));
    }

    @Override // com.stepos.aiengine.algorithm.privacyclassify.IPrivacyClassify
    public PrivacyClassifyResult classify(String text, Bundle args) {
        p.i(text, "text");
        return j(text, 0.8f, args);
    }

    @Override // com.stepos.aiengine.algorithm.privacyclassify.IPrivacyClassify
    public PrivacyClassifyResult classifyWithThreshold(String text, float threshold, Bundle args) {
        p.i(text, "text");
        return j(text, C5685n.m(threshold, 0.0f, 1.0f), args);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final PrivacyClassifyResult j(String text, float threshold, Bundle args) {
        String text2;
        if (text.length() == 0) {
            return PrivacyClassifyResult.INSTANCE.error("text is empty", threshold);
        }
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        final Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
        AbilityHandle.infer$default(this.handle, o(text, args), new p9.p() { // from class: O4.b0
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return PrivacyClassifyAbilityAdapter.k(ref$ObjectRef, countDownLatch, (String) obj, (TextContent) obj2);
            }
        }, new q() { // from class: O4.c0
            @Override // p9.q
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return PrivacyClassifyAbilityAdapter.l(ref$ObjectRef2, countDownLatch, (String) obj, ((Integer) obj2).intValue(), (String) obj3);
            }
        }, new InterfaceC5074l() { // from class: O4.d0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return PrivacyClassifyAbilityAdapter.m(countDownLatch, (String) obj);
            }
        }, null, null, 48, null);
        if (!countDownLatch.await(30L, TimeUnit.SECONDS)) {
            return PrivacyClassifyResult.INSTANCE.error("inference timeout", threshold);
        }
        Throwable th = (Throwable) ref$ObjectRef2.f34820a;
        if (th == null) {
            TextContent textContent = (TextContent) ref$ObjectRef.f34820a;
            return (textContent == null || (text2 = textContent.getText()) == null) ? PrivacyClassifyResult.INSTANCE.error("empty result", threshold) : n(text2, threshold);
        }
        PrivacyClassifyResult.Companion companion = PrivacyClassifyResult.INSTANCE;
        String message = th.getMessage();
        if (message == null) {
            message = "infer error";
        }
        return companion.error(message, threshold);
    }

    public final PrivacyClassifyResult n(String json, float threshold) {
        float f10;
        Exception exc;
        int iOptInt;
        int iOptInt2;
        float[] fArr;
        float[] fArr2;
        float[] fArr3;
        float[] fArr4;
        float f11;
        try {
            JSONObject jSONObject = new JSONObject(json);
            iOptInt = jSONObject.optInt("predictedClass", 0);
            iOptInt2 = jSONObject.optInt("classCount", 0);
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("logits");
            if (jSONArrayOptJSONArray != null) {
                try {
                    int length = jSONArrayOptJSONArray.length();
                    fArr = new float[length];
                    for (int i10 = 0; i10 < length; i10++) {
                        fArr[i10] = (float) jSONArrayOptJSONArray.optDouble(i10, 0.0d);
                    }
                } catch (Exception e10) {
                    exc = e10;
                    f10 = threshold;
                    return PrivacyClassifyResult.INSTANCE.error("parse failed: " + exc.getMessage(), f10);
                }
            } else {
                fArr = new float[0];
            }
            fArr2 = fArr;
            JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("probs");
            if (jSONArrayOptJSONArray2 != null) {
                int length2 = jSONArrayOptJSONArray2.length();
                fArr3 = new float[length2];
                for (int i11 = 0; i11 < length2; i11++) {
                    fArr3[i11] = (float) jSONArrayOptJSONArray2.optDouble(i11, 0.0d);
                }
            } else {
                fArr3 = new float[0];
            }
            fArr4 = fArr3;
            f11 = fArr4.length >= 2 ? fArr4[1] : 0.0f;
            f10 = threshold;
        } catch (Exception e11) {
            e = e11;
            f10 = threshold;
        }
        try {
            return new PrivacyClassifyResult(f11 >= threshold, f11, f10, iOptInt, fArr2, fArr4, iOptInt2, null);
        } catch (Exception e12) {
            e = e12;
            exc = e;
            return PrivacyClassifyResult.INSTANCE.error("parse failed: " + exc.getMessage(), f10);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.stepos.core.data.TextContent o(java.lang.String r4, android.os.Bundle r5) {
        /*
            r3 = this;
            com.stepos.core.data.TextContent r3 = new com.stepos.core.data.TextContent
            r3.<init>(r4)
            com.stepos.core.data.ContentParams$Builder r4 = new com.stepos.core.data.ContentParams$Builder
            r4.<init>()
            r0 = 1
            if (r5 == 0) goto L2c
            java.lang.String r1 = "trace_id"
            java.lang.String r1 = r5.getString(r1)
            if (r1 == 0) goto L2c
            boolean r2 = La.H.x0(r1)
            if (r2 != 0) goto L1c
            goto L1d
        L1c:
            r1 = 0
        L1d:
            if (r1 == 0) goto L2c
            r2 = 128(0x80, float:1.8E-43)
            java.lang.String r1 = La.K.R1(r1, r2)
            java.lang.String r2 = "__trace_id"
            r4.putString(r2, r1)
            r1 = r0
            goto L2d
        L2c:
            r1 = 0
        L2d:
            com.stepos.aiengine.adapter.TaskPriorityArg r2 = com.stepos.aiengine.adapter.TaskPriorityArg.INSTANCE
            boolean r5 = r2.applyTo(r4, r5)
            if (r5 == 0) goto L36
            goto L37
        L36:
            r0 = r1
        L37:
            if (r0 == 0) goto L40
            com.stepos.core.data.ContentParams r4 = r4.build()
            r3.setParams(r4)
        L40:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.aiengine.adapter.PrivacyClassifyAbilityAdapter.o(java.lang.String, android.os.Bundle):com.stepos.core.data.TextContent");
    }

    @Override // com.stepos.aiengine.algorithm.privacyclassify.IPrivacyClassify
    public void classify(AlgorithmToken token, String text, float threshold, Bundle args, final IBundleCallback callback) {
        p.i(token, "token");
        p.i(text, "text");
        p.i(callback, "callback");
        final float fM = C5685n.m(threshold, 0.0f, 1.0f);
        if (text.length() != 0) {
            AbilityHandle.infer$default(this.handle, String.valueOf(token.getIdentity()), o(text, args), new p9.p() { // from class: O4.Y
                @Override // p9.p
                public final Object invoke(Object obj, Object obj2) {
                    return PrivacyClassifyAbilityAdapter.g(fM, this, callback, (String) obj, (TextContent) obj2);
                }
            }, new q() { // from class: O4.Z
                @Override // p9.q
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return PrivacyClassifyAbilityAdapter.h(callback, (String) obj, ((Integer) obj2).intValue(), (String) obj3);
                }
            }, (InterfaceC5074l) null, new q() { // from class: O4.a0
                @Override // p9.q
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return PrivacyClassifyAbilityAdapter.i(callback, (String) obj, ((Integer) obj2).intValue(), (String) obj3);
                }
            }, (p9.p) null, 80, (Object) null);
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("pc_exception", "text is empty");
            bundle.putInt("pc_error_code", AIEngineError.INVALID_ARGUMENT);
            callback.onCall(bundle);
        }
    }
}
