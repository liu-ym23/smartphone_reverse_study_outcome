package com.bytedance.android.livesdk.utils.condition.base;

import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class Condition {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Disposable f158907a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f158908b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f158909c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConditionConstant$ConditionType f158910d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final e f158911e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final d f158912f;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.utils.condition.base.Condition$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/utils/condition/base/b;", "p1", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/livesdk/utils/condition/base/b;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<b, Unit> {
        public AnonymousClass1(Condition r100) {
            super(1, r100, Condition.class, "onEvent", "onEvent(Lcom/bytedance/android/livesdk/utils/condition/base/ConditionEvent;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(b r100) {
            invoke2(r100);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(b r100) {
            ((Condition) this.receiver).onEvent(r100);
        }
    }

    public final void b() {
        Iterator r100 = ((HashMap) this.f158909c.getValue()).values().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((Condition) r100.next()).b();
        goto L4
    L6:
        Disposable r101 = this.f158907a;
        if (r101 == null) goto L9;
        r101.dispose();
    L9:
        this.f158908b = 0;
    }

    public final void c() {
        Iterator r100 = ((HashMap) this.f158909c.getValue()).values().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((Condition) r100.next()).c();
        goto L4
    L6:
        this.f158908b = 0;
        this.f158912f.reset();
    }

    public final ConditionConstant$ConditionType getType() {
        return this.f158910d;
    }

    public final void onEvent(b r100) {
        if (this.f158911e.a() == false) goto L15;
        if (r100 == null) goto L6;
        ConditionConstant$ConditionType r101 = r100.f158920a;
    L8:
        if (r101 == this.f158910d) goto L10;
        return;
    L10:
        if (r100.f158920a.f158916id <= 1000) goto L12;
        long r102 = this.f158912f.c(r100, this.f158908b, (HashMap) this.f158909c.getValue());
    L13:
        this.f158908b = r102;
        this.f158912f.d();
        return;
    L12:
        r102 = this.f158912f.a(r100, this.f158908b);
        goto L13
    L6:
        r101 = null;
        goto L8
    }

    public final void a(ConditionConstant$ConditionType r100, Condition r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        ((HashMap) this.f158909c.getValue()).put(r100, r101);
    }

    public Condition(ConditionConstant$ConditionType r100, e r101, d r102) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "conditionInterceptor");
        Intrinsics.checkNotNullParameter(r102, "conditionHandler");
        this.f158910d = r100;
        this.f158911e = r101;
        this.f158912f = r102;
        if (r101.b() == false) goto L5;
        AnonymousClass1 r103 = new AnonymousClass1(this);
        this.f158907a = xs2.b.a().b(b.class).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(r103));
    L5:
        this.f158909c = LazyKt.lazy(Condition$childConditions$2.INSTANCE);
    }
}
