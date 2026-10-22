package com.bytedance.android.shopping.anchorv4.helper;

import com.bytedance.android.ec.core.utils.UIUtils;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import io.reactivex.disposables.Disposable;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class JisooManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Disposable f166873a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LinkedList<k> f166874b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f166875c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static dl.a f166876d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final JisooManager$loopAction$1 f166877e = null;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.anchorv4.helper.JisooManager$1, reason: invalid class name */
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
            Disposable r100 = JisooManager.f166873a;
            cl.d r101 = com.bytedance.android.ec.sdk.helper.k.a();
            if (r101 == null) goto L5;
            r101.q();
        L5:
            dl.a r102 = new dl.a(0);
            JisooManager.f166876d = r102;
            if (r102.b() == false) goto L8;
            JisooManager.d();
            return;
        L8:
            JisooManager.e();
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [com.bytedance.android.shopping.anchorv4.helper.JisooManager$loopAction$1] */
    static {
        f166874b = new LinkedList();
        if (ECAppInfoService.f48114e.i() == false) goto L8;
        cl.d r100 = com.bytedance.android.ec.sdk.helper.k.a();
        if (r100 == null) goto L7;
        r100.q();
    L7:
        dl.a r101 = new dl.a(0);
    L9:
        f166876d = r101;
        f166877e = new JisooManager$loopAction$1();
        cl.d r102 = com.bytedance.android.ec.sdk.helper.k.a();
        if (r102 == null) goto L13;
        r102.q();
        return;
    L13:
        return;
    L8:
        r101 = new dl.a(0);
        goto L9
    }

    public static void d() {
        if (f166875c == false) goto L5;
        return;
    L5:
        if (f166876d.a() == true) goto L7;
        return;
    L7:
        if (f166876d.b() == true) goto L9;
        return;
    L9:
        if (f166874b.size() <= 0) goto L15;
        f166875c = true;
        Lazy r100 = UIUtils.f45548a;
        UIUtils.c().post(f166877e);
        b("start loop...");
        return;
    }

    public static void e() {
        if (f166876d.a() == true) goto L5;
    L8:
        Lazy r100 = UIUtils.f45548a;
        UIUtils.c().removeCallbacks(f166877e);
        f166875c = false;
        b("stop loop...");
        return;
    L5:
        if (f166876d.b() == false) goto L8;
        if (f166874b.size() == 0) goto L8;
    }

    public static void a(f r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (f166876d.a() == true) goto L7;
        return;
    L7:
        Iterator<T> r101 = f166874b.iterator();
    L9:
        if (r101.hasNext() == false) goto L13;
        Object r102 = r101.next();
        if (Intrinsics.areEqual(((k) r102).f166961b, r100) == false) goto L9;
    L14:
        if (r102 != null) goto L16;
        k r103 = new k(r100);
        f166874b.addFirst(r103);
    L16:
        d();
        return;
    L13:
        r102 = null;
        goto L14
    }

    public static void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        dm.a.a("JisooManager").i(r100);
    }

    public static void c(f r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        LinkedList<k> r101 = f166874b;
        if (r101.size() != 0) goto L7;
        return;
    L7:
        Iterator<T> r102 = r101.iterator();
    L9:
        if (r102.hasNext() == false) goto L13;
        Object r103 = r102.next();
        if (Intrinsics.areEqual(((k) r103).f166961b, r100) == false) goto L9;
    L14:
        k r104 = (k) r103;
        LinkedList<k> r105 = f166874b;
        if (r105 == null) goto L19;
        TypeIntrinsics.asMutableCollection(r105).remove(r104);
        e();
        return;
    L19:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
    L13:
        r103 = null;
        goto L14
    }
}
