package com.bytedance.android.ec.window.base.common.bubble;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class ECWindowBubbleController$bubbleTask$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ d this$0;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECWindowBubbleController$bubbleTask$1 f49108a;

        public a(ECWindowBubbleController$bubbleTask$1 r100) {
            this.f49108a = r100;
        }

        public final void a() {
            this.f49108a.this$0.getClass();
            d r100 = this.f49108a.this$0;
            WindowBubbleShowStrategy r101 = r100.f49119a;
            Intrinsics.checkNotNullParameter(r101, "showStrategy");
            if (((ArrayList) r100.f49120b).isEmpty() == true) goto L35;
            ArrayList r102 = (ArrayList) r100.f49120b;
            if (r102.size() <= 1) goto L8;
            CollectionsKt.sortWith(r102, new c());
        L8:
            int r103 = b.f49118a[r101.ordinal()];
            if (r103 != 1) goto L11;
            Pair r104 = (Pair) CollectionsKt.firstOrNull(r100.f49120b);
            if (r104 == null) goto L33;
            e r105 = (e) r104.getSecond();
            if (r105 == null) goto L34;
            r105.onShow();
            return;
        L34:
            return;
        L33:
            return;
        L11:
            if (r103 != 2) goto L13;
            return;
        L13:
            if (r103 != 3) goto L36;
            Iterator r106 = ((ArrayList) r100.f49120b).iterator();
        L17:
            if (r106.hasNext() == false) goto L37;
            e r107 = (e) ((Pair) r106.next()).getSecond();
            if (r107 == null) goto L17;
            r107.onShow();
            goto L17
        L37:
            return;
        L36:
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public ECWindowBubbleController$bubbleTask$1(d r100) {
        this.this$0 = r100;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.this$0.f49121c.post(new a(this));
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
