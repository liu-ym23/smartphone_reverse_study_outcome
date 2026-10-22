package com.android.contacts.list;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: NewContactListFragment.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "success", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class NewContactListFragment$enterSearch$2$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ long $animationGeneration;
    final /* synthetic */ NewContactListFragment this$0;

    NewContactListFragment$enterSearch$2$1(long r1, NewContactListFragment r3) {
        this.$animationGeneration = r1;
        this.this$0 = r3;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean r1) {
        invoke(r1.booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean r5) {
        if (this.$animationGeneration == NewContactListFragment.access$getMSearchAnimationGeneration$p(this.this$0)) goto L5;
        return;
    L5:
        NewContactListFragment.access$onEnterSearchAnimEnd(this.this$0, r5);
    }
}
