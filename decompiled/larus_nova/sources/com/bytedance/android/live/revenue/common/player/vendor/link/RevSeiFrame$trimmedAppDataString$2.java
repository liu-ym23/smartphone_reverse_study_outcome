package com.bytedance.android.live.revenue.common.player.vendor.link;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class RevSeiFrame$trimmedAppDataString$2 extends FunctionReferenceImpl implements Function0<String> {
    public RevSeiFrame$trimmedAppDataString$2(RevSeiFrame r100) {
        super(0, r100, RevSeiFrame.class, "parseTrimmedAppDataStr", "parseTrimmedAppDataStr()Ljava/lang/String;", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2() {
        RevSeiFrame r100 = (RevSeiFrame) this.receiver;
        Lazy r101 = RevSeiFrame.D;
        String r102 = (String) r100.f90923f.getValue();
        if (r102 != null) goto L7;
        return null;
    L7:
        return new Regex("\\\\\"talk\\\\\":[012]").replace(r102, "");
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ String invoke() {
        return invoke2();
    }
}
