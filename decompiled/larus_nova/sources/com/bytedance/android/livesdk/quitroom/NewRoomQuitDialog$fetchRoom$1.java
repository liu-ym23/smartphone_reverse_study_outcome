package com.bytedance.android.livesdk.quitroom;

import android.view.View;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00032\u0016\u0010\u0005\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00040\u0006\"\u0004\u0018\u00010\u0004H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"setViewsClickListener", "", "listener", "Lkotlin/Function1;", "Landroid/view/View;", "view", "", AbsMethodDelegate.TAG_INVOKE, "(Lkotlin/jvm/functions/Function1;[Landroid/view/View;)V"}, k = 3, mv = {1, 4, 3})
final class NewRoomQuitDialog$fetchRoom$1 extends Lambda implements Function2<Function1<? super View, ? extends Unit>, View[], Unit> {
    public static final NewRoomQuitDialog$fetchRoom$1 INSTANCE = null;

    public final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f156892a;

        public a(Function1 r100) {
            this.f156892a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final /* synthetic */ void onClick(View r100) {
            this.f156892a.invoke(r100);
        }
    }

    static {
        INSTANCE = new NewRoomQuitDialog$fetchRoom$1();
    }

    public NewRoomQuitDialog$fetchRoom$1() {
        super(2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Function1<? super View, Unit> r100, View... r101) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        Intrinsics.checkNotNullParameter(r101, "view");
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L11;
        View r104 = r101[r103];
        if (r104 == null) goto L10;
        if (r100 == null) goto L8;
        Object r105 = new a(r100);
    L9:
        r104.setOnClickListener((View.OnClickListener) r105);
        goto L10
    L8:
        r105 = r100;
    L10:
        r103 = r103 + 1;
        goto L3
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Function1<? super View, ? extends Unit> r100, View[] r101) {
        invoke2(r100, r101);
        return Unit.INSTANCE;
    }
}
