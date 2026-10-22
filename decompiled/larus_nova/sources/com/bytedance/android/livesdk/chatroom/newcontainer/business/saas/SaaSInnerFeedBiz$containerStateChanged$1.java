package com.bytedance.android.livesdk.chatroom.newcontainer.business.saas;

import com.bytedance.android.livesdk.interactivity.api.enterroom.IEnterGuideService;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.List;
import jc1.k;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
public final class SaaSInnerFeedBiz$containerStateChanged$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ls2.d $context;
    final /* synthetic */ List $taskList;

    public SaaSInnerFeedBiz$containerStateChanged$1(ls2.d r100, List r101) {
        this.$context = r100;
        this.$taskList = r101;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        boolean r100 = e.f107551a;
        e.f107551a = false;
        final IEnterGuideService r101 = (IEnterGuideService) k.f(IEnterGuideService.class);
        if (r101 == null) goto L5;
        r101.initSlideTask(new SaaSInnerFeedBiz$containerStateChanged$1$slideTaskAction$1(this, r101));
    L5:
        this.$taskList.add(new b());
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
