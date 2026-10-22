package com.stepos.aiengine.adapter;

import La.H;
import M5.b;
import Y8.t;
import android.os.Bundle;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.adapter.RiskClassifyAbilityAdapter;
import com.stepos.aiengine.algorithm.riskclassify.IRiskClassify;
import com.stepos.aiengine.algorithm.riskclassify.RiskClassifyCallback;
import com.stepos.aiengine.algorithm.riskclassify.RiskClassifyResult;
import com.stepos.aiengine.api.task.AlgorithmToken;
import com.stepos.aiengine.api.task.IBundleCallback;
import com.stepos.core.AbilityHandle;
import com.stepos.core.data.TextContent;
import com.stepos.core.error.AIEngineError;
import com.stepos.statsapp.v3.lib.plugin.net.multipart.e;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;
import p9.q;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\b\u0000\u0018\u0000 &2\u00020\u0001:\u0001$B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ!\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J1\u0010\u0010\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0010\u0010\u0017J!\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b\u0018\u0010\u0011J!\u0010\u001a\u001a\u00020\u00192\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010\"\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\"\u0010#R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006'"}, d2 = {"Lcom/stepos/aiengine/adapter/RiskClassifyAbilityAdapter;", "Lcom/stepos/aiengine/algorithm/riskclassify/IRiskClassify;", "Lcom/stepos/core/AbilityHandle;", "handle", "<init>", "(Lcom/stepos/core/AbilityHandle;)V", "", e.f30860s, "", "cancel", "(J)Z", "", "text", "Landroid/os/Bundle;", "args", "Lcom/stepos/aiengine/algorithm/riskclassify/RiskClassifyResult;", "classify", "(Ljava/lang/String;Landroid/os/Bundle;)Lcom/stepos/aiengine/algorithm/riskclassify/RiskClassifyResult;", "Lcom/stepos/aiengine/api/task/AlgorithmToken;", b.CREDENTIAL_TOKEN, "Lcom/stepos/aiengine/api/task/IBundleCallback;", "callback", "LY8/t;", "(Lcom/stepos/aiengine/api/task/AlgorithmToken;Ljava/lang/String;Landroid/os/Bundle;Lcom/stepos/aiengine/api/task/IBundleCallback;)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "Lcom/stepos/core/data/TextContent;", "p", "(Ljava/lang/String;Landroid/os/Bundle;)Lcom/stepos/core/data/TextContent;", "payload", "o", "(Ljava/lang/String;)Lcom/stepos/aiengine/algorithm/riskclassify/RiskClassifyResult;", "", "code", "message", "n", "(ILjava/lang/String;)Landroid/os/Bundle;", Const.INTENT_KEY_APIKEY, "Lcom/stepos/core/AbilityHandle;", Const.INTENT_KEY_PKGNAME, "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class RiskClassifyAbilityAdapter implements IRiskClassify {

    @Deprecated
    public static final long TIMEOUT_SECONDS = 30;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final AbilityHandle handle;

    public RiskClassifyAbilityAdapter(AbilityHandle handle) {
        p.i(handle, "handle");
        this.handle = handle;
    }

    public static final t g(RiskClassifyAbilityAdapter riskClassifyAbilityAdapter, IBundleCallback iBundleCallback, String str, TextContent content) {
        p.i(str, "<unused var>");
        p.i(content, "content");
        String text = content.getText();
        if (text == null) {
            text = "";
        }
        RiskClassifyResult riskClassifyResultO = riskClassifyAbilityAdapter.o(text);
        if (riskClassifyResultO.getErrorMessage() != null) {
            iBundleCallback.onCall(riskClassifyAbilityAdapter.n(AIEngineError.INFERENCE_RESULT_PARSE_FAILED, riskClassifyResultO.getErrorMessage()));
        } else {
            iBundleCallback.onCall(RiskClassifyCallback.INSTANCE.bundleOf(riskClassifyResultO));
        }
        return t.f7040a;
    }

    public static final t h(IBundleCallback iBundleCallback, RiskClassifyAbilityAdapter riskClassifyAbilityAdapter, String str, int i10, String message) {
        p.i(str, "<unused var>");
        p.i(message, "message");
        iBundleCallback.onCall(riskClassifyAbilityAdapter.n(i10, message));
        return t.f7040a;
    }

    public static final t i(IBundleCallback iBundleCallback, String str, int i10, String str2) {
        p.i(str, "<unused var>");
        p.i(str2, "<unused var>");
        Bundle bundle = new Bundle();
        bundle.putBoolean(RiskClassifyCallback.KEY_CANCELLED, true);
        iBundleCallback.onCall(bundle);
        return t.f7040a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final t k(Ref$ObjectRef ref$ObjectRef, CountDownLatch countDownLatch, String str, TextContent content) {
        p.i(str, "<unused var>");
        p.i(content, "content");
        ref$ObjectRef.f34820a = content;
        countDownLatch.countDown();
        return t.f7040a;
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [T, java.lang.String] */
    public static final t l(Ref$ObjectRef ref$ObjectRef, CountDownLatch countDownLatch, String str, int i10, String message) {
        p.i(str, "<unused var>");
        p.i(message, "message");
        ref$ObjectRef.f34820a = "[" + i10 + "] " + message;
        countDownLatch.countDown();
        return t.f7040a;
    }

    public static final t m(CountDownLatch countDownLatch, String it) {
        p.i(it, "it");
        countDownLatch.countDown();
        return t.f7040a;
    }

    @Override // com.stepos.aiengine.algorithm.riskclassify.IRiskClassify
    public boolean cancel(long identity) {
        return this.handle.cancel(String.valueOf(identity));
    }

    @Override // com.stepos.aiengine.algorithm.riskclassify.IRiskClassify
    public RiskClassifyResult classify(String text, Bundle args) {
        p.i(text, "text");
        return j(text, args);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final RiskClassifyResult j(String text, Bundle args) {
        if (H.x0(text)) {
            return RiskClassifyResult.INSTANCE.error("text is empty");
        }
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        final Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
        AbilityHandle.infer$default(this.handle, p(text, args), new p9.p() { // from class: O4.k0
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return RiskClassifyAbilityAdapter.k(ref$ObjectRef, countDownLatch, (String) obj, (TextContent) obj2);
            }
        }, new q() { // from class: O4.l0
            @Override // p9.q
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return RiskClassifyAbilityAdapter.l(ref$ObjectRef2, countDownLatch, (String) obj, ((Integer) obj2).intValue(), (String) obj3);
            }
        }, new InterfaceC5074l() { // from class: O4.m0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return RiskClassifyAbilityAdapter.m(countDownLatch, (String) obj);
            }
        }, null, null, 48, null);
        if (!countDownLatch.await(30L, TimeUnit.SECONDS)) {
            return RiskClassifyResult.INSTANCE.error("inference timeout");
        }
        String str = (String) ref$ObjectRef2.f34820a;
        if (str != null) {
            return RiskClassifyResult.INSTANCE.error(str);
        }
        TextContent textContent = (TextContent) ref$ObjectRef.f34820a;
        String text2 = textContent != null ? textContent.getText() : null;
        if (text2 == null) {
            text2 = "";
        }
        return o(text2);
    }

    public final Bundle n(int code, String message) {
        Bundle bundle = new Bundle();
        bundle.putString(RiskClassifyCallback.KEY_EXCEPTION, message);
        bundle.putInt(RiskClassifyCallback.KEY_ERROR_CODE, code);
        return bundle;
    }

    public final RiskClassifyResult o(String payload) {
        String upperCase = H.D1(payload).toString().toUpperCase(Locale.ROOT);
        p.h(upperCase, "toUpperCase(...)");
        if (p.d(upperCase, "PASS") || p.d(upperCase, "BLOCK")) {
            return new RiskClassifyResult(upperCase, null, 2, null);
        }
        return RiskClassifyResult.INSTANCE.error("invalid risk decision: " + payload);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.stepos.core.data.TextContent p(java.lang.String r4, android.os.Bundle r5) {
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
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.aiengine.adapter.RiskClassifyAbilityAdapter.p(java.lang.String, android.os.Bundle):com.stepos.core.data.TextContent");
    }

    @Override // com.stepos.aiengine.algorithm.riskclassify.IRiskClassify
    public void classify(AlgorithmToken token, String text, Bundle args, final IBundleCallback callback) {
        p.i(token, "token");
        p.i(text, "text");
        p.i(callback, "callback");
        if (H.x0(text)) {
            callback.onCall(n(AIEngineError.INVALID_ARGUMENT, "text is empty"));
        } else {
            AbilityHandle.infer$default(this.handle, String.valueOf(token.getIdentity()), p(text, args), new p9.p() { // from class: O4.n0
                @Override // p9.p
                public final Object invoke(Object obj, Object obj2) {
                    return RiskClassifyAbilityAdapter.g(this.f5231a, callback, (String) obj, (TextContent) obj2);
                }
            }, new q() { // from class: O4.o0
                @Override // p9.q
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return RiskClassifyAbilityAdapter.h(callback, this, (String) obj, ((Integer) obj2).intValue(), (String) obj3);
                }
            }, (InterfaceC5074l) null, new q() { // from class: O4.p0
                @Override // p9.q
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return RiskClassifyAbilityAdapter.i(callback, (String) obj, ((Integer) obj2).intValue(), (String) obj3);
                }
            }, (p9.p) null, 80, (Object) null);
        }
    }
}
