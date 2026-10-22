package com.bytedance.android.live.anchormodelink.util;

import com.bytedance.android.ecom.arch.slice.slices.template.TemplateNodeType;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.lark.widget.span.InlineCodeInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"sanitizeUrl", "", TemplateNodeType.RAW, AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 5, 1})
public final class JsbParamParseUtil$getGiftUserList$1 extends Lambda implements Function1<String, String> {
    public static final JsbParamParseUtil$getGiftUserList$1 INSTANCE = null;

    static {
        INSTANCE = new JsbParamParseUtil$getGiftUserList$1();
    }

    public JsbParamParseUtil$getGiftUserList$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2(String r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        String r101 = StringsKt.replace$default(r100, InlineCodeInfo.INLINE_CODE_EDGE_PLACEHOLDER, "", false, 4, null);
        if (r101 == null) goto L10;
        return StringsKt.trim(r101).toString();
    L10:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ String invoke(String r100) {
        return invoke2(r100);
    }
}
