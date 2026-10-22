package com.bytedance.android.live.revenue.common.player.vendor.link;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class RevSeiFrame$appDataStr$2 extends FunctionReferenceImpl implements Function0<String> {
    public RevSeiFrame$appDataStr$2(RevSeiFrame r100) {
        super(0, r100, RevSeiFrame.class, "parseAppDataStr", "parseAppDataStr()Ljava/lang/String;", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2() {
        RevSeiFrame r100 = (RevSeiFrame) this.receiver;
        Lazy r101 = RevSeiFrame.D;
        r100.getClass();
        Object r102 = null;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L38
        int r104 = 0;
        if (StringsKt.contains$default(r100.C, "TTLiveSDK_", false, 2, null) == true) goto L50;
        int r105 = StringsKt.indexOf$default(r100.C, "app_data", 0, false, 6, null);     // Catch: Throwable -> L38
        if (r105 == (-1)) goto L51;
        int r106 = r100.C.length();     // Catch: Throwable -> L38
    L11:
        if (r105 >= r106) goto L15;
        if (r100.C.charAt(r105) == '{') goto L15;
        r105 = r105 + 1;     // Catch: Throwable -> L38
    L15:
        if (r105 < r106) goto L17;
    L19:
        int r107 = -1;
    L20:
        if (r107 == (-1)) goto L52;
    L22:
        if (r105 >= r106) goto L32;
        if (r100.C.charAt(r105) != '{') goto L27;
        r104 = r104 + 1;     // Catch: Throwable -> L38
    L29:
        if (r104 == 0) goto L32;
        r105 = r105 + 1;     // Catch: Throwable -> L38
        goto L22
    L27:
        if (r100.C.charAt(r105) != '}') goto L29;
        r104 = r104 - 1;     // Catch: Throwable -> L38
    L32:
        if (r104 != 0) goto L53;
        String r108 = r100.C;     // Catch: Throwable -> L38
        int r109 = r105 + 1;     // Catch: Throwable -> L38
        if (r108 == null) goto L37;
        return r108.substring(r107, r109);
    L37:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");     // Catch: Throwable -> L38
    L53:
        return null;
    L52:
        return null;
    L17:
        if (r100.C.charAt(r105) != '{') goto L19;
        r107 = r105;
        goto L20
    L51:
        return null;
    L50:
        return null;
    L38:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        Object r111 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r111) == true) goto L44;
        r102 = r111;
    L44:
        return (String) r102;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ String invoke() {
        return invoke2();
    }
}
