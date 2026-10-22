package com.bytedance.android.live.profit.livepet.utils;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.profit.livepet.container.n;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.scope.m;
import com.bytedance.android.scope.o;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lio/reactivex/disposables/Disposable;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 5, 1})
public final class DebugModeKt$enableLivePetDebugView$8 extends Lambda implements Function0<Disposable> {
    final /* synthetic */ Context $context;
    final /* synthetic */ ViewGroup $petContainer;
    final /* synthetic */ ru0.a $petRoomScope;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f87912a = null;

        static {
            f87912a = new a();
        }

        public a() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Disposable r101 = (Disposable) r100;
            ToastUtil.b("Start displaying link region", 0);
        }
    }

    public static final class b implements Action {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f87913a = null;

        static {
            f87913a = new b();
        }

        public b() {
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            ToastUtil.b("Stop displaying link region", 0);
        }
    }

    public static final class c<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DebugModeKt$enableLivePetDebugView$8 f87914a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ n f87915b;

        public c(DebugModeKt$enableLivePetDebugView$8 r100, n r101) {
            this.f87914a = r100;
            this.f87915b = r101;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r110) {
            Map r111 = (Map) r110;
            Intrinsics.checkNotNullParameter(r111, "regionMap");
            final AnimatorSet r100 = new AnimatorSet();
            com.bytedance.android.live.revenue.common.e.a(r100, new DebugModeKt$enableLivePetDebugView$8$3$animatorSet$1$1(r100));
            Collection r112 = r111.values();
            ArrayList r101 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r112, 10));
            Iterator<T> r113 = r112.iterator();
        L4:
            if (r113.hasNext() == false) goto L6;
            com.bytedance.android.live.profit.livepet.container.a r102 = (com.bytedance.android.live.profit.livepet.container.a) r113.next();
            View r103 = new View(this.f87914a.$context);
            r103.setBackgroundColor(ColorProtector.parseColor("#990000FF"));
            r103.setAlpha(0.0f);
            this.f87914a.$petContainer.addView(r103);
            r103.setLayoutParams(a1.c(r103.getLayoutParams(), null, null, Integer.valueOf(r102.getLeft()), Integer.valueOf(r102.getTop()), Integer.valueOf(this.f87915b.f87867a - r102.getRight()), Integer.valueOf(this.f87915b.f87868b - r102.getBottom()), 67));
            ObjectAnimator r104 = ObjectAnimator.ofFloat(r103, "alpha", new float[]{0.0f, 1.0f, 0.0f});
            r104.setDuration(1000);
            r104.addListener(new com.bytedance.android.live.profit.livepet.utils.b(r103, this));
            r101.add(r104);
            goto L4
        L6:
            r100.playSequentially(r101);
            return Observable.never().doOnSubscribe(new com.bytedance.android.live.profit.livepet.utils.c(r100)).doOnDispose(new d(r100));
        }
    }

    public DebugModeKt$enableLivePetDebugView$8(ru0.a r100, Context r101, ViewGroup r102) {
        this.$petRoomScope = r100;
        this.$context = r101;
        this.$petContainer = r102;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Disposable invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Disposable invoke() {
        ru0.a r100 = this.$petRoomScope;
        m r101 = m.f163449e;
        if (r100 == null) goto L11;
        Object r102 = r101.d(r100, com.bytedance.android.live.profit.livepet.container.e.class);
        if (r102 == null) goto L9;
        n r103 = ((com.bytedance.android.live.profit.livepet.container.e) ((o) r102)).f87847c;
        Intrinsics.checkNotNullParameter(r103, "parent");
        return Observable.defer(new com.bytedance.android.live.profit.livepet.container.b(r103)).doOnSubscribe(a.f87912a).doOnDispose(b.f87913a).switchMap(new c(this, r103)).subscribe();
    L9:
        throw new IllegalStateException(("Service " + Reflection.getOrCreateKotlinClass(com.bytedance.android.live.profit.livepet.container.e.class) + " does not exist").toString());
    L11:
        throw new IllegalArgumentException("Scope is null".toString());
    }
}
