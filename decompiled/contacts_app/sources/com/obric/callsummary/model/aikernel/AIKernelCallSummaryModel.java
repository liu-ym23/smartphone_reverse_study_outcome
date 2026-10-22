package com.obric.callsummary.model.aikernel;

import android.content.Context;
import android.net.Uri;
import androidx.core.content.FileProvider;
import com.GlobalProxyLancet;
import com.android.contacts.RegionConstants;
import com.android.contacts.util.ContactPhotoUtils;
import com.obric.contactprovider.bean.CallSummaryASRMessageBean;
import com.obric.utils.DeviceIdPrivacy;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Charsets;
import org.json.JSONObject;

/* JADX INFO: compiled from: AIKernelCallSummaryModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0014J*\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u00102\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002JB\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00120\u00102\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0018H\u0014R\u001b\u0010\u0003\u001a\u00020\u00048TX\u0094\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u001d"}, d2 = {"Lcom/obric/callsummary/model/aikernel/AIKernelCallSummaryModel;", "Lcom/obric/callsummary/model/aikernel/ABSAIKernelCallSummaryModel;", "()V", "modelLoadHelper", "Lcom/obric/callsummary/model/aikernel/ScriptModelLoadHelper;", "getModelLoadHelper", "()Lcom/obric/callsummary/model/aikernel/ScriptModelLoadHelper;", "modelLoadHelper$delegate", "Lkotlin/Lazy;", "generateCallSummaryCleanup", "", "context", "Landroid/content/Context;", "parameter", "Lorg/json/JSONObject;", "generateContentFileUri", "Lkotlin/Pair;", "Landroid/net/Uri;", "", "asrMessage", "", "Lcom/obric/contactprovider/bean/CallSummaryASRMessageBean;", "generateModelParameter", "isSimplify", "", ABSAIKernelCallSummaryModel.PARAMETER_KEY_POWER_MODE, "Lcom/obric/callsummary/model/aikernel/ABSAIKernelCallSummaryModel$PowerMode;", "isRetry", "Companion", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AIKernelCallSummaryModel extends ABSAIKernelCallSummaryModel {
    private static final String AI_KERNEL_PACKAGE_NAME = "com.obric.aikernel";
    public static final Companion Companion = null;
    private static final String PARAMETER_KEY_CONTENT_FILE = "contentFile";
    private static final String PARAMETER_KEY_LANGUAGE = "language";
    private static final String PARAMETER_KEY_PSEUDONYM_ID = "pseudonymID";
    private static final String PARAMETER_KEY_REGION = "region";
    private static final String TAG = "AIKernelCallSummaryModel";
    private final Lazy modelLoadHelper$delegate;

    /* JADX INFO: compiled from: AIKernelCallSummaryModel.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/callsummary/model/aikernel/AIKernelCallSummaryModel$Companion;", "", "()V", "AI_KERNEL_PACKAGE_NAME", "", "PARAMETER_KEY_CONTENT_FILE", "PARAMETER_KEY_LANGUAGE", "PARAMETER_KEY_PSEUDONYM_ID", "PARAMETER_KEY_REGION", "TAG", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public AIKernelCallSummaryModel() {
        this.modelLoadHelper$delegate = LazyKt.lazy(AIKernelCallSummaryModel$modelLoadHelper$2.INSTANCE);
    }

    @Override // com.obric.callsummary.model.aikernel.ABSAIKernelCallSummaryModel
    protected ScriptModelLoadHelper getModelLoadHelper() {
        return (ScriptModelLoadHelper) this.modelLoadHelper$delegate.getValue();
    }

    @Override // com.obric.callsummary.model.aikernel.ABSAIKernelCallSummaryModel
    protected Pair<JSONObject, Integer> generateModelParameter(Context r2, List<CallSummaryASRMessageBean> r3, boolean r4, ABSAIKernelCallSummaryModel.PowerMode r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "asrMessage");
        Intrinsics.checkNotNullParameter(r5, ABSAIKernelCallSummaryModel.PARAMETER_KEY_POWER_MODE);
        Pair<Uri, Integer> r1 = generateContentFileUri(r2, r3);
        Uri r7 = r1.component1();
        int r8 = r1.component2().intValue();
        final Ref.ObjectRef r9 = new Ref.ObjectRef();
        DeviceIdPrivacy.INSTANCE.getPrivacyDeviceId(new AnonymousClass1(r9));
        JSONObject r10 = new JSONObject();
        r10.put(PARAMETER_KEY_CONTENT_FILE, r7.toString());
        r10.put(ABSAIKernelCallSummaryModel.PARAMETER_KEY_POWER_MODE, r5.getValue());
        r10.put("region", RegionConstants.REGION);
        r10.put("language", RegionConstants.LANGUAGE);
        String r11 = (String) r9.element;
        if (r11 == null) goto L6;
        r10.put(PARAMETER_KEY_PSEUDONYM_ID, r11);
    L6:
        return new Pair(r10, Integer.valueOf(r8));
    }

    @Override // com.obric.callsummary.model.aikernel.ABSAIKernelCallSummaryModel
    protected void generateCallSummaryCleanup(Context r5, JSONObject r6) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "parameter");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        AIKernelCallSummaryModel r1 = this;     // Catch: Throwable -> L5
        Object r7 = Result.m803constructorimpl(r6.getString(PARAMETER_KEY_CONTENT_FILE));     // Catch: Throwable -> L5
    L8:
        if (Result.m806exceptionOrNullimpl(r7) != null) goto L37;
        String r8 = (String) r7;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "generateCallSummaryCleanup: " + r8);
        Uri r9 = Uri.parse(r8);
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L12
        AIKernelCallSummaryModel r3 = this;     // Catch: Throwable -> L12
        r5.revokeUriPermission("com.obric.aikernel", r9, 1);     // Catch: Throwable -> L12
        Object r4 = Result.m803constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L12
    L15:
        if (Result.m810isSuccessimpl(r4) == false) goto L17;
        Unit r10 = (Unit) r4;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "revokeUriPermission success! Uri: " + r9);
    L17:
        Throwable r11 = Result.m806exceptionOrNullimpl(r4);
        if (r11 == null) goto L35;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "revokeUriPermission error! Uri: " + r9, r11);
    L35:
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L22
        AIKernelCallSummaryModel r13 = this;     // Catch: Throwable -> L22
        Object r14 = Result.m803constructorimpl(Integer.valueOf(r5.getContentResolver().delete(r9, null)));     // Catch: Throwable -> L22
    L25:
        if (Result.m810isSuccessimpl(r14) == false) goto L27;
        ((Number) r14).intValue();
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "delete cache file success! Uri: " + r9);
    L27:
        Throwable r15 = Result.m806exceptionOrNullimpl(r14);
        if (r15 == null) goto L38;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "delete cache file error! Uri: " + r9, r15);
        return;
    L38:
        return;
    L22:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r14 = Result.m803constructorimpl(ResultKt.createFailure(th));
    L12:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r4 = Result.m803constructorimpl(ResultKt.createFailure(th));
        goto L15
    L37:
        return;
    L5:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r7 = Result.m803constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    private final Pair<Uri, Integer> generateContentFileUri(Context r7, List<CallSummaryASRMessageBean> r8) {
        File r6 = new File(r7.getCacheDir().getAbsolutePath() + '/' + UUID.randomUUID());
        int r1 = 0;
        FileOutputStream r0 = new FileOutputStream(r6, false);
        FileOutputStream r2 = r0;     // Catch: Throwable -> L10
        Iterator<CallSummaryASRMessageBean> r9 = r8.iterator();     // Catch: Throwable -> L10
    L5:
        if (r9.hasNext() == false) goto L7;
        CallSummaryASRMessageBean r3 = r9.next();     // Catch: Throwable -> L10
        String r4 = r3.getName() + ": " + r3.getAsrText() + '\n';     // Catch: Throwable -> L10
        byte[] r5 = r4.getBytes(Charsets.UTF_8);     // Catch: Throwable -> L10
        Intrinsics.checkNotNullExpressionValue(r5, "getBytes(...)");     // Catch: Throwable -> L10
        r2.write(r5);     // Catch: Throwable -> L10
        r1 = r1 + r4.length();     // Catch: Throwable -> L10
        goto L5
    L7:
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L10
        CloseableKt.closeFinally(r0, null);
        Uri r11 = FileProvider.getUriForFile(r7, ContactPhotoUtils.FILE_PROVIDER_AUTHORITY, r6);
        r7.grantUriPermission("com.obric.aikernel", r11, 1);
        return new Pair(r11, Integer.valueOf(r1));
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        CloseableKt.closeFinally(r0, th);
        throw th;
    }
}
