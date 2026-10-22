package com.bytedance.android.live.browser;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u000b\n\u0002\u0010\"\n\u0002\b\u0004*\u0001\u0001\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "com/bytedance/android/live/browser/ReadonlyJSONObjectMap$entries$2$1$a", AbsMethodDelegate.TAG_INVOKE, "()Ljava/util/Set;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final class ReadonlyJSONObjectMap$entries$2 extends Lambda implements Function0<Set<? extends AnonymousClass1.a>> {
    final /* synthetic */ ReadonlyJSONObjectMap this$0;

    public ReadonlyJSONObjectMap$entries$2(ReadonlyJSONObjectMap r100) {
        this.this$0 = r100;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Set<? extends AnonymousClass1.a> invoke2() {
        return SequencesKt.toSet(SequencesKt.map(SequencesKt.asSequence(this.this$0.f62570b.keys()), new AnonymousClass1(this)));
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Set<? extends AnonymousClass1.a> invoke() {
        return invoke2();
    }
}
