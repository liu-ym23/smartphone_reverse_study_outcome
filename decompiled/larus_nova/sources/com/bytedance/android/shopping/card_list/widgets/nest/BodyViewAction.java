package com.bytedance.android.shopping.card_list.widgets.nest;

import com.bytedance.android.shopping.card_list.components.q;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes13.dex */
public final class BodyViewAction implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<Unit> f171960a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<Integer, Boolean> f171961b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f171962c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CardListTwoRevViewAction f171963d;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.card_list.widgets.nest.BodyViewAction$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
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

    /* JADX INFO: renamed from: com.bytedance.android.shopping.card_list.widgets.nest.BodyViewAction$2, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
    public static final class AnonymousClass2 extends Lambda implements Function1<Integer, Boolean> {
        public static final AnonymousClass2 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass2();
        }

        public AnonymousClass2() {
            super(1);
        }

        public final boolean invoke(int r100) {
            return false;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(Integer r100) {
            return Boolean.valueOf(invoke(r100.intValue()));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BodyViewAction(Function0<Unit> r100, Function1<? super Integer, Boolean> r101, boolean r102, CardListTwoRevViewAction r103) {
        Intrinsics.checkNotNullParameter(r100, "refresh");
        Intrinsics.checkNotNullParameter(r101, "canScrollVerticallyAsMultiList");
        Intrinsics.checkNotNullParameter(r103, "cardListTwoRevViewAction");
        this.f171960a = r100;
        this.f171961b = r101;
        this.f171962c = r102;
        this.f171963d = r103;
    }
}
