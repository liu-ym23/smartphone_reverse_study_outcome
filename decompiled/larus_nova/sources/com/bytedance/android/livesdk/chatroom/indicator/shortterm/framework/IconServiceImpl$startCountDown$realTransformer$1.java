package com.bytedance.android.livesdk.chatroom.indicator.shortterm.framework;

import com.bytedance.android.livesdk.utils.p6;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001\"\b\b\u0000\u0010\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "kotlin.jvm.PlatformType", "STATE", "", "p1", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class IconServiceImpl$startCountDown$realTransformer$1 extends FunctionReferenceImpl implements Function1<Long, String> {
    public static final IconServiceImpl$startCountDown$realTransformer$1 INSTANCE = null;

    static {
        INSTANCE = new IconServiceImpl$startCountDown$realTransformer$1();
    }

    public IconServiceImpl$startCountDown$realTransformer$1() {
        super(1, p6.class, "second2SimpleString", "second2SimpleString(J)Ljava/lang/String;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ String invoke(Long r100) {
        return invoke(r100.longValue());
    }

    public final String invoke(long r100) {
        return p6.d(r100);
    }
}
