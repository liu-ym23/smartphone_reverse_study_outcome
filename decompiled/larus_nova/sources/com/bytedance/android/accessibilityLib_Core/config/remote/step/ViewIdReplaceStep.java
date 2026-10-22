package com.bytedance.android.accessibilityLib_Core.config.remote.step;

import android.content.Context;
import com.bytedance.android.accessibilityLib_Core.config.remote.dsl.f;
import com.bytedance.android.accessibilityLib_Core.config.remote.subjob.LocalFileCheckJob;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.huawei.hms.framework.common.ContainerUtils;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function1;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class ViewIdReplaceStep extends com.bytedance.android.accessibilityLib_Core.config.remote.step.a<Boolean, List<? extends f>> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f38222c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ParseStep f38223a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.accessibilityLib_Core.config.remote.subjob.b f38224b;

    public static final class a {
    }

    static {
    }

    public ViewIdReplaceStep(ParseStep r100, com.bytedance.android.accessibilityLib_Core.config.remote.subjob.b r101) {
        this.f38223a = r100;
        this.f38224b = r101;
    }

    public final Object a(Boolean r210, Continuation<? super List<f>> r211) {
        if ((r211 instanceof ViewIdReplaceStep$excute$1) == false) goto L7;
        ViewIdReplaceStep$excute$1 r100 = (ViewIdReplaceStep$excute$1) r211;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L16;
        if (r104 == 1) goto L15;
        if (r104 != 2) goto L14;
        List r105 = (List) r100.L$1;
        ViewIdReplaceStep r106 = (ViewIdReplaceStep) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L77:
        return r102;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ViewIdReplaceStep r107 = (ViewIdReplaceStep) r100.L$0;
        ResultKt.throwOnFailure(r102);
        final ViewIdReplaceStep r110 = r107;
    L20:
        final List r108 = (List) r102;
        r100.L$0 = r110;
        r100.L$1 = r108;
        r100.label = 2;
        final SafeContinuation r111 = new SafeContinuation(IntrinsicsKt.intercepted(r100));
    L28:
        e = move-exception;
        if (("Try exception occur " + e.getMessage()) == null) goto L71;
        Context r109 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;
    L71:
        Context r112 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;
        r111.resumeWith(Result.m9449constructorimpl(r108));
        Unit r113 = Unit.INSTANCE;
    L72:
        r102 = r111.getOrThrow();
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L75;
        DebugProbesKt.probeCoroutineSuspended(r100);
    L75:
        if (r102 != r103) goto L77;
        return r103;
    L80:
        InputStream r114 = com.bytedance.android.accessibilityLib_Core.helper.a.a().getResources().getAssets().open("raw_r_accessibility.txt");     // Catch: Exception -> L24
    L23:
        InputStream r115 = r114;
        if (r115 == null) goto L65;
        Reader r116 = new InputStreamReader(r115, Charsets.UTF_8);     // Catch: Exception -> L28
        if ((r116 instanceof BufferedReader) == false) goto L35;
        BufferedReader r117 = (BufferedReader) r116;     // Catch: Exception -> L28
    L36:
        List<String> r118 = TextStreamsKt.readLines(r117);     // Catch: Exception -> L28
        if (r118.isEmpty() == false) goto L39;
        r111.resumeWith(Result.m9449constructorimpl(r108));     // Catch: Exception -> L28
    L66:
        Unit r119 = Unit.INSTANCE;     // Catch: Exception -> L28
        goto L72
    L39:
        final Function1<List<? extends String>, Unit> r120 = new ViewIdReplaceStep$excute$$inlined$suspendCoroutine$lambda$1(r111, r110, r108);     // Catch: Exception -> L28
        if (r118.size() >= 2) goto L57;
        List r121 = StringsKt.split$default((String) ListProtector.get(r118, 0), new String[]{ContainerUtils.KEY_VALUE_DELIMITER}, false, 0, 6, null);     // Catch: Exception -> L28
        if (r121.size() >= 2) goto L44;
        r111.resumeWith(Result.m9449constructorimpl(r108));     // Catch: Exception -> L28
        goto L66
    L44:
        final String r122 = (String) ListProtector.get(r121, 1);     // Catch: Exception -> L28
        String r123 = "rTxtUrlValue = " + r122;     // Catch: Exception -> L28
        InputStream r124 = r115;
        new LocalFileCheckJob(r110.f38224b).a(r122, new ViewIdReplaceStep$excute$$inlined$suspendCoroutine$lambda$2(r122, r120, r111, r110, r108));     // Catch: Exception -> L49
        Unit r125 = Unit.INSTANCE;     // Catch: Exception -> L49
    L78:
        r124.close();     // Catch: Exception -> L60
        Unit r126 = Unit.INSTANCE;     // Catch: Exception -> L60
    L60:
        e = move-exception;
        if (("Try exception occur " + e.getMessage()) == null) goto L64;
        Context r127 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;     // Catch: Exception -> L28
    L64:
        Context r128 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;     // Catch: Exception -> L28
        Unit r129 = Unit.INSTANCE;     // Catch: Exception -> L28
    L49:
        e = e;
    L54:
        if (("Try exception occur " + e.getMessage()) == null) goto L56;
        Context r130 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;     // Catch: Exception -> L28
    L56:
        Context r131 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;     // Catch: Exception -> L28
        r111.resumeWith(Result.m9449constructorimpl(r108));     // Catch: Exception -> L28
        Unit r132 = Unit.INSTANCE;     // Catch: Exception -> L28
    L51:
        e = e;
        r124 = r115;
        goto L54
    L57:
        r124 = r115;
        r120.invoke(r118);     // Catch: Exception -> L28
        goto L78
    L35:
        r117 = new BufferedReader(r116, 8192);     // Catch: Exception -> L28
        goto L36
    L65:
        r111.resumeWith(Result.m9449constructorimpl(r108));     // Catch: Exception -> L28
        goto L66
    L24:
        e = move-exception;
        if (("Try exception occur " + e.getMessage()) == null) goto L30;
        Context r133 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;     // Catch: Exception -> L28
    L30:
        Context r134 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;     // Catch: Exception -> L28
        r114 = null;
        goto L23
    L16:
        ResultKt.throwOnFailure(r102);
        Context r135 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;
        ParseStep r136 = this.f38223a;
        Boolean r137 = Boxing.boxBoolean(true);
        r100.L$0 = this;
        r100.label = 1;
        r102 = r136.a(r137, r100);
        if (r102 != r103) goto L19;
        return r103;
    L19:
        r110 = this;
    L7:
        r100 = new ViewIdReplaceStep$excute$1(this, r211);
        goto L8
    }
}
