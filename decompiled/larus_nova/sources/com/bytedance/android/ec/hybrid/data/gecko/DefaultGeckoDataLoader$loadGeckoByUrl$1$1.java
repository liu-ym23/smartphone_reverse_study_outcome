package com.bytedance.android.ec.hybrid.data.gecko;

import com.byted.cast.linkcommon.cybergarage.xml.XML;
import com.bytedance.forest.model.Response;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import io.reactivex.ObservableEmitter;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "response", "Lcom/bytedance/forest/model/Response;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class DefaultGeckoDataLoader$loadGeckoByUrl$1$1 extends Lambda implements Function1<Response, Unit> {
    final /* synthetic */ ObservableEmitter $emitter;

    public DefaultGeckoDataLoader$loadGeckoByUrl$1$1(ObservableEmitter r100) {
        this.$emitter = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Response r100) {
        Intrinsics.checkNotNullParameter(r100, "response");
        byte[] r101 = r100.j();
        if (r101 == null) goto L5;
        String r102 = new String(r101, Charset.forName(XML.CHARSET_UTF8));
    L6:
        if (r102 != null) goto L8;
        this.$emitter.onError(new Throwable(r100.f244317s.toString()));
        return;
    L8:
        this.$emitter.onNext(r102);
        this.$emitter.onComplete();
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Response r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
