package com.bytedance.android.anniex.detect;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: classes43.dex */
public final class DetectionPipeline {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<h> f40640a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f40641b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<c, Boolean> f40642c;

    /* JADX INFO: renamed from: com.bytedance.android.anniex.detect.DetectionPipeline$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/anniex/detect/c;", "it", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/anniex/detect/c;)Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    final class AnonymousClass1 extends Lambda implements Function1<c, Boolean> {
        public static final AnonymousClass1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass1();
        }

        public AnonymousClass1() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Boolean invoke2(c r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            return Boolean.valueOf(!(r100 instanceof c.C0757c));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(c r100) {
            return invoke2(r100);
        }
    }

    public DetectionPipeline() {
        throw null;
    }

    public DetectionPipeline(List r100, Function1 r101) {
        Intrinsics.checkNotNullParameter(r100, "steps");
        Intrinsics.checkNotNullParameter(r101, "shouldInterrupt");
        this.f40640a = r100;
        this.f40641b = false;
        this.f40642c = r101;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0071 -> B:25:0x0074). Please report as a decompilation issue!!! */
    public final Object a(f r100, Continuation<? super c> r101) {
        if ((r101 instanceof DetectionPipeline$run$1) == false) goto L7;
        DetectionPipeline$run$1 r102 = (DetectionPipeline$run$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L16;
        if (r106 == 1) goto L15;
        if (r106 != 2) goto L14;
        ResultKt.throwOnFailure(r104);
    L34:
        return r104;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        Iterator<h> r107 = (Iterator) r102.L$2;
        f r108 = (f) r102.L$1;
        DetectionPipeline r109 = (DetectionPipeline) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L25:
        c r110 = (c) r104;
        if (r109.f40642c.invoke(r110).booleanValue() == false) goto L28;
        return r110;
    L28:
        f r111 = r108;
    L20:
        if (r107.hasNext() == false) goto L30;
        h r112 = r107.next();
        r102.L$0 = r109;
        r102.L$1 = r111;
        r102.L$2 = r107;
        r102.label = 1;
        Object r113 = r112.a(r111, r102);
        if (r113 != r105) goto L24;
        return r105;
    L24:
        r108 = r111;
        r104 = r113;
        goto L25
    L30:
        return new c.C0757c();
    L16:
        ResultKt.throwOnFailure(r104);
        if (this.f40641b == true) goto L31;
        Iterator<h> r114 = this.f40640a.iterator();
        r109 = this;
        r111 = r100;
        r107 = r114;
        goto L20
    L31:
        DetectionPipeline$run$2 r115 = new DetectionPipeline$run$2(this, r100, null);
        r102.label = 2;
        r104 = CoroutineScopeKt.coroutineScope(r115, r102);
        if (r104 != r105) goto L34;
        return r105;
    L7:
        r102 = new DetectionPipeline$run$1(this, r101);
        goto L8
    }
}
