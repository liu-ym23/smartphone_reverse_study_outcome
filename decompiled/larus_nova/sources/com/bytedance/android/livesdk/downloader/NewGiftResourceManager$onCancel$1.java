package com.bytedance.android.livesdk.downloader;

import com.bytedance.android.livesdk.gift.platform.business.effect.assets.e;
import com.bytedance.kmp.livesdk.gift.platform.resourcemanager.c;
import com.bytedance.kmp.livesdk.gift.platform.resourcemanager.f;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 5, 1})
final class NewGiftResourceManager$onCancel$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ e $resourceRequest;
    final /* synthetic */ NewGiftResourceManager this$0;

    public NewGiftResourceManager$onCancel$1(NewGiftResourceManager r100, e r101) {
        this.this$0 = r100;
        this.$resourceRequest = r101;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        f r100 = this.this$0.f122287a.get(Long.valueOf(this.$resourceRequest.f129099i));
        if (r100 == null) goto L8;
        Iterator<c> r101 = r100.b().iterator();
    L6:
        if (r101.hasNext() == false) goto L8;
        r101.next().a(this.$resourceRequest.f129099i);
    L8:
        this.this$0.f122287a.remove(Long.valueOf(this.$resourceRequest.f129099i));
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
