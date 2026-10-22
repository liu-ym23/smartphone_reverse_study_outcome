package com.bytedance.android.ec.hybrid.data.gecko;

import com.bytedance.forest.model.Response;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "response", "Lcom/bytedance/forest/model/Response;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class DefaultGeckoDataLoader$loadGeckoByteArrayByUrlDirectly$1 extends Lambda implements Function1<Response, Unit> {
    final /* synthetic */ a $geckoLoadCallback;

    public DefaultGeckoDataLoader$loadGeckoByteArrayByUrlDirectly$1(a r100) {
        this.$geckoLoadCallback = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Response r100) {
        Intrinsics.checkNotNullParameter(r100, "response");
        byte[] r101 = r100.j();
        if (r101 != null) goto L11;
        a r102 = this.$geckoLoadCallback;
        if (r102 == null) goto L15;
        String r103 = r100.f244317s.toString();
        Charset r104 = Charsets.UTF_8;
        if (r103 == null) goto L10;
        r102.a(false, r103.getBytes(r104), r100.f244319u);
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L15:
        return;
    L11:
        a r105 = this.$geckoLoadCallback;
        if (r105 == null) goto L17;
        r105.a(true, r101, r100.f244319u);
        return;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Response r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
