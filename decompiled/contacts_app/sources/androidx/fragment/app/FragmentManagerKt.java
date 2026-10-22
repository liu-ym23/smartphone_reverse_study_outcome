package androidx.fragment.app;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FragmentManager.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a3\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\bH\u0086\bø\u0001\u0000\u001a3\u0010\t\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\bH\u0087\bø\u0001\u0000\u001a=\u0010\n\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\bH\u0087\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\f"}, d2 = {"commit", "", "Landroidx/fragment/app/FragmentManager;", "allowStateLoss", "", "body", "Lkotlin/Function1;", "Landroidx/fragment/app/FragmentTransaction;", "Lkotlin/ExtensionFunctionType;", "commitNow", "transaction", "now", "fragment-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class FragmentManagerKt {
    public static /* synthetic */ void commit$default(FragmentManager r0, boolean r1, Function1 r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L5;
        r1 = false;
    L5:
        Intrinsics.checkNotNullParameter(r0, "<this>");
        Intrinsics.checkNotNullParameter(r2, "body");
        FragmentTransaction r5 = r0.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(r5, "beginTransaction()");
        r2.invoke(r5);
        if (r1 == false) goto L8;
        r5.commitAllowingStateLoss();
        return;
    L8:
        r5.commit();
    }

    public static final void commit(FragmentManager r1, boolean r2, Function1<? super FragmentTransaction, Unit> r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r3, "body");
        FragmentTransaction r4 = r1.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(r4, "beginTransaction()");
        r3.invoke(r4);
        if (r2 == false) goto L5;
        r4.commitAllowingStateLoss();
        return;
    L5:
        r4.commit();
    }

    public static /* synthetic */ void commitNow$default(FragmentManager r0, boolean r1, Function1 r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L5;
        r1 = false;
    L5:
        Intrinsics.checkNotNullParameter(r0, "<this>");
        Intrinsics.checkNotNullParameter(r2, "body");
        FragmentTransaction r5 = r0.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(r5, "beginTransaction()");
        r2.invoke(r5);
        if (r1 == false) goto L8;
        r5.commitNowAllowingStateLoss();
        return;
    L8:
        r5.commitNow();
    }

    public static final void commitNow(FragmentManager r1, boolean r2, Function1<? super FragmentTransaction, Unit> r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r3, "body");
        FragmentTransaction r4 = r1.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(r4, "beginTransaction()");
        r3.invoke(r4);
        if (r2 == false) goto L5;
        r4.commitNowAllowingStateLoss();
        return;
    L5:
        r4.commitNow();
    }

    public static /* synthetic */ void transaction$default(FragmentManager r1, boolean r2, boolean r3, Function1 r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = false;
    L6:
        if ((r5 & 2) == 0) goto L8;
        r3 = false;
    L8:
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r4, "body");
        FragmentTransaction r7 = r1.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(r7, "beginTransaction()");
        r4.invoke(r7);
        if (r2 == false) goto L13;
        if (r3 == false) goto L12;
        r7.commitNowAllowingStateLoss();
        return;
    L12:
        r7.commitNow();
        return;
    L13:
        if (r3 == false) goto L15;
        r7.commitAllowingStateLoss();
        return;
    L15:
        r7.commit();
    }

    @Deprecated(message = "Use commit { .. } or commitNow { .. } extensions")
    public static final void transaction(FragmentManager r1, boolean r2, boolean r3, Function1<? super FragmentTransaction, Unit> r4) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r4, "body");
        FragmentTransaction r5 = r1.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(r5, "beginTransaction()");
        r4.invoke(r5);
        if (r2 == false) goto L7;
        if (r3 == false) goto L6;
        r5.commitNowAllowingStateLoss();
        return;
    L6:
        r5.commitNow();
        return;
    L7:
        if (r3 == false) goto L9;
        r5.commitAllowingStateLoss();
        return;
    L9:
        r5.commit();
    }
}
