package androidx.fragment.app;

import com.bytedance.android.shopping.yata.business.ability.common.TriggerTiming;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a3\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\bH\u0086\bø\u0001\u0000\u001a3\u0010\t\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\bH\u0086\bø\u0001\u0000\u001a=\u0010\n\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\bH\u0087\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\f"}, d2 = {"commit", "", "Landroidx/fragment/app/FragmentManager;", "allowStateLoss", "", ContainerPosition.BODY, "Lkotlin/Function1;", "Landroidx/fragment/app/FragmentTransaction;", "Lkotlin/ExtensionFunctionType;", "commitNow", "transaction", TriggerTiming.NOW, "fragment-ktx_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class FragmentManagerKt {
    public static final void commit(FragmentManager r100, boolean r101, Function1<? super FragmentTransaction, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r102, ContainerPosition.BODY);
        FragmentTransaction r103 = r100.beginTransaction();
        r102.invoke(r103);
        if (r101 == false) goto L5;
        r103.commitAllowingStateLoss();
        return;
    L5:
        r103.commit();
    }

    public static final void commitNow(FragmentManager r100, boolean r101, Function1<? super FragmentTransaction, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r102, ContainerPosition.BODY);
        FragmentTransaction r103 = r100.beginTransaction();
        r102.invoke(r103);
        if (r101 == false) goto L5;
        r103.commitNowAllowingStateLoss();
        return;
    L5:
        r103.commitNow();
    }

    @Deprecated(message = "Use commit { .. } or commitNow { .. } extensions")
    public static final void transaction(FragmentManager r100, boolean r101, boolean r102, Function1<? super FragmentTransaction, Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r103, ContainerPosition.BODY);
        FragmentTransaction r104 = r100.beginTransaction();
        r103.invoke(r104);
        if (r101 == false) goto L7;
        if (r102 == false) goto L6;
        r104.commitNowAllowingStateLoss();
        return;
    L6:
        r104.commitNow();
        return;
    L7:
        if (r102 == false) goto L9;
        r104.commitAllowingStateLoss();
        return;
    L9:
        r104.commit();
    }

    public static /* synthetic */ void commit$default(FragmentManager r100, boolean r101, Function1 r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L5;
        r101 = false;
    L5:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r102, ContainerPosition.BODY);
        FragmentTransaction r105 = r100.beginTransaction();
        r102.invoke(r105);
        if (r101 == false) goto L8;
        r105.commitAllowingStateLoss();
        return;
    L8:
        r105.commit();
    }

    public static /* synthetic */ void commitNow$default(FragmentManager r100, boolean r101, Function1 r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L5;
        r101 = false;
    L5:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r102, ContainerPosition.BODY);
        FragmentTransaction r105 = r100.beginTransaction();
        r102.invoke(r105);
        if (r101 == false) goto L8;
        r105.commitNowAllowingStateLoss();
        return;
    L8:
        r105.commitNow();
    }

    public static /* synthetic */ void transaction$default(FragmentManager r100, boolean r101, boolean r102, Function1 r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = false;
    L6:
        if ((r104 & 2) == 0) goto L8;
        r102 = false;
    L8:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r103, ContainerPosition.BODY);
        FragmentTransaction r106 = r100.beginTransaction();
        r103.invoke(r106);
        if (r101 == false) goto L13;
        if (r102 == false) goto L12;
        r106.commitNowAllowingStateLoss();
        return;
    L12:
        r106.commitNow();
        return;
    L13:
        if (r102 == false) goto L15;
        r106.commitAllowingStateLoss();
        return;
    L15:
        r106.commit();
    }
}
