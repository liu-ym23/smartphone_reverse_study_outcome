package com.bytedance.android.btm.impl;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes3.dex */
public final class BtmLaunchImpl implements com.bytedance.android.btm.api.c, bd.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final BtmLaunchImpl f42115a = null;

    /* JADX INFO: renamed from: com.bytedance.android.btm.impl.BtmLaunchImpl$onPagePaused$1, reason: invalid class name */
    /* JADX INFO: loaded from: classes43.dex */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 16})
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public static final AnonymousClass1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass1();
        }

        public AnonymousClass1() {
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }
    }

    public BtmLaunchImpl() {
    }

    @Override // bd.b
    public final void onPageCreated(Object r100) {
    }

    @Override // bd.b
    public final void onPageDestroyed(Object r100) {
    }

    @Override // bd.b
    public final void onPagePaused(Object r100) {
    }

    @Override // bd.b
    public final void onPageResumed(Object r100) {
    }

    static {
        f42115a = new BtmLaunchImpl();
    }
}
