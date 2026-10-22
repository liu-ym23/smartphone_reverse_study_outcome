package com.bytedance.android.livesdk.vs;

import android.content.Context;
import android.view.View;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes11.dex */
public final class VSMessageHandlePopup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Disposable f159368a;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.vs.VSMessageHandlePopup$2, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
    final class AnonymousClass2 extends Lambda implements Function1<View, Unit> {
        final /* synthetic */ VSMessageHandlePopup this$0;

        public AnonymousClass2(VSMessageHandlePopup r100) {
            this.this$0 = r100;
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            this.this$0.getClass();
            throw null;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View r100) {
            invoke2(r100);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.vs.VSMessageHandlePopup$3, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
    final class AnonymousClass3 extends Lambda implements Function1<View, Unit> {
        final /* synthetic */ VSMessageHandlePopup this$0;

        public AnonymousClass3(VSMessageHandlePopup r100) {
            this.this$0 = r100;
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            this.this$0.getClass();
            throw null;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View r100) {
            invoke2(r100);
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/vs/VSMessageHandlePopup$TrianglePosition;", "", "CENTER_TOP", "CENTER_BOTTOM", "RIGHT_TOP", "RIGHT_BOTTOM", "LEFT_TOP", "LEFT_BOTTOM", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum TrianglePosition extends Enum<TrianglePosition> {
        public static final TrianglePosition CENTER_BOTTOM = null;
        public static final TrianglePosition CENTER_TOP = null;
        public static final TrianglePosition LEFT_BOTTOM = null;
        public static final TrianglePosition LEFT_TOP = null;
        public static final TrianglePosition RIGHT_BOTTOM = null;
        public static final TrianglePosition RIGHT_TOP = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TrianglePosition[] f159369a = null;

        static {
            TrianglePosition r100 = new TrianglePosition("CENTER_TOP", 0);
            CENTER_TOP = r100;
            TrianglePosition r101 = new TrianglePosition("CENTER_BOTTOM", 1);
            CENTER_BOTTOM = r101;
            TrianglePosition r102 = new TrianglePosition("RIGHT_TOP", 2);
            RIGHT_TOP = r102;
            TrianglePosition r103 = new TrianglePosition("RIGHT_BOTTOM", 3);
            RIGHT_BOTTOM = r103;
            TrianglePosition r104 = new TrianglePosition("LEFT_TOP", 4);
            LEFT_TOP = r104;
            TrianglePosition r105 = new TrianglePosition("LEFT_BOTTOM", 5);
            LEFT_BOTTOM = r105;
            f159369a = new TrianglePosition[]{r100, r101, r102, r103, r104, r105};
        }

        public static TrianglePosition valueOf(String r100) {
            return (TrianglePosition) r27.a.a(TrianglePosition.class, r100);
        }

        public static TrianglePosition[] values() {
            return (TrianglePosition[]) f159369a.clone();
        }

        public TrianglePosition(String r100, int r101) {
            super(r100, r101);
        }
    }

    public final Context getContext() {
        return null;
    }
}
