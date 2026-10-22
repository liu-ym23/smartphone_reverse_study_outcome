package com.android.ttcjpaysdk.base.framework;

import android.app.Activity;
import android.content.Context;
import com.android.ttcjpaysdk.base.eventbus.EventManager;
import com.android.ttcjpaysdk.base.framework.event.CJPayFinishAllBindCardPageEvent;
import com.android.ttcjpaysdk.base.framework.event.CJPayFinishAllH5Event;
import com.android.ttcjpaysdk.base.framework.event.CJPayFinishAllSingleFragmentActivityEvent;
import com.android.ttcjpaysdk.base.framework.event.CJPayFinishPaymentMethodActivityEvent;
import com.bytedance.caijing.sdk.infra.base.env.CJEnv;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.Stack;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0007J\u0012\u0010\n\u001a\u00020\u000b2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\rJ\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0007J\u0012\u0010\u0010\u001a\u00020\u00072\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\rJ\u0010\u0010\u0011\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u0012\u0010\u0014\u001a\u00020\u00072\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\rJ\u0010\u0010\u0015\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u0010\u0010\u0016\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u0010\u0010\u0017\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u0010\u0010\u0018\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\b\u0010\u0019\u001a\u00020\u001aH\u0007J\u000e\u0010\u001b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005J\u0014\u0010\u001c\u001a\u00020\u001a2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\rH\u0007J\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u00052\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\rH\u0007R\u0016\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/CJPayActivityManager;", "", "()V", "activityStack", "Ljava/util/Stack;", "Landroid/app/Activity;", "addActivity", "", "activity", "allowCaptureScreen", "containActivityClass", "", "cls", "Ljava/lang/Class;", "currentActivity", "disallowCaptureScreen", "finishActivityClass", "finishAll", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "finishAllActivityClass", "finishAllExceptH5", "finishAllWithOutH5page", "finishBindCard", "finishPaymentMethod", "getStackSize", "", "removeActivity", "searchActivityClass", "searchTopActivityClass", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayActivityManager {
    public static final CJPayActivityManager INSTANCE = null;
    private static Stack<Activity> activityStack;

    private CJPayActivityManager() {
    }

    static {
        INSTANCE = new CJPayActivityManager();
        activityStack = new Stack();
    }

    @JvmStatic
    public static final int getStackSize() {
        Stack<Activity> r100 = activityStack;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.size();
    }

    public final Activity currentActivity() {
        Stack<Activity> r100 = activityStack;
        if (r100 != null) goto L5;
        return null;
    L5:
        if ((!r100.empty()) == true) goto L8;
        r100 = null;
    L8:
        if (r100 != null) goto L10;
        return null;
    L10:
        return r100.peek();
    }

    @JvmStatic
    public static final void allowCaptureScreen(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        if (Intrinsics.areEqual("local_test", CJEnv.b()) == true) goto L6;
        r100.getWindow().clearFlags(8192);
        return;
    }

    @JvmStatic
    public static final void disallowCaptureScreen(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        if (Intrinsics.areEqual("local_test", CJEnv.b()) == true) goto L6;
        r100.getWindow().addFlags(8192);
        return;
    }

    @JvmStatic
    public static final int searchActivityClass(Class<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "cls");
        Stack<Activity> r101 = activityStack;
        if (r101 == null) goto L14;
        Iterator<T> r102 = r101.iterator();
        int r103 = 0;
    L6:
        if (r102.hasNext() == false) goto L18;
        Object r104 = r102.next();
        int r105 = r103 + 1;
        if (r103 >= 0) goto L11;
        CollectionsKt.throwIndexOverflow();
    L11:
        if (Intrinsics.areEqual(((Activity) r104).getClass(), r100) == true) goto L12;
        r103 = r105;
        goto L6
    L12:
        return r103;
    L18:
        return -1;
    L14:
        return -1;
    }

    @JvmStatic
    public static final Activity searchTopActivityClass(Class<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "cls");
        Stack<Activity> r101 = activityStack;
        Activity r102 = null;
        if (r101 == null) goto L10;
        Iterator<T> r103 = r101.iterator();
    L6:
        if (r103.hasNext() == false) goto L10;
        Activity r104 = (Activity) r103.next();
        if (Intrinsics.areEqual(r104.getClass(), r100) == false) goto L6;
        r102 = r104;
    L10:
        return r102;
    }

    public final void addActivity(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Stack<Activity> r101 = activityStack;
        if (r101 == null) goto L6;
        r101.add(r100);
        return;
    }

    public final boolean containActivityClass(Class<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "cls");
        Stack<Activity> r101 = activityStack;
        if (r101 == null) goto L11;
        Iterator<T> r102 = r101.iterator();
    L6:
        if (r102.hasNext() == false) goto L16;
        if (Intrinsics.areEqual(((Activity) r102.next()).getClass(), r100) == false) goto L6;
        return true;
    L16:
        return false;
    L11:
        return false;
    }

    public final void finishActivityClass(Class<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "cls");
        Stack<Activity> r101 = activityStack;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101 != null) goto L7;
    L9:
        boolean r102 = false;
    L10:
        if (r102 == true) goto L38;
        Stack<Activity> r103 = activityStack;
        Intrinsics.checkNotNull(r103);
        int r104 = r103.size();
    L13:
        if (r104 < 0) goto L39;
        Stack<Activity> r105 = activityStack;
        Intrinsics.checkNotNull(r105);
        Activity r106 = (Activity) CollectionsKt.getOrNull(r105, r104);
        if (r106 == null) goto L17;
        Class<?> r107 = r106.getClass();
    L19:
        if (Intrinsics.areEqual(r107, r100) == false) goto L31;
        Stack<Activity> r108 = activityStack;
        Intrinsics.checkNotNull(r108);
        Activity r109 = (Activity) CollectionsKt.getOrNull(r108, r104);
        if (r109 != null) goto L23;
    L25:
        boolean r110 = false;
    L26:
        if (r110 == true) goto L31;
        Stack<Activity> r111 = activityStack;
        Intrinsics.checkNotNull(r111);
        Activity r112 = (Activity) CollectionsKt.getOrNull(r111, r104);
        if (r112 == null) goto L37;
        r112.finish();
        return;
    L37:
        return;
    L23:
        if (r109.isFinishing() != true) goto L25;
        r110 = true;
    L31:
        r104 = r104 - 1;
        goto L13
    L17:
        r107 = null;
        goto L19
    L39:
        return;
    L38:
        return;
    L7:
        if (r101.size() != 0) goto L9;
        r102 = true;
        goto L10
    }

    public final void finishAll(Context r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        EventManager r101 = EventManager.INSTANCE;
        r101.notify(new CJPayFinishAllH5Event());
        r101.notify(new CJPayFinishAllSingleFragmentActivityEvent());
        r101.notify(new CJPayFinishAllBindCardPageEvent(false, 1, null));
    }

    public final void finishAllActivityClass(Class<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "cls");
        Stack<Activity> r101 = activityStack;
        if (r101 == null) goto L19;
        boolean r102 = false;
        if (r101 != null) goto L7;
    L9:
        if (r102 == true) goto L27;
        Stack<Activity> r103 = activityStack;
        Intrinsics.checkNotNull(r103);
        Iterator<Activity> r104 = r103.iterator();
    L13:
        if (r104.hasNext() == false) goto L28;
        Activity r105 = r104.next();
        if (Intrinsics.areEqual(r105.getClass(), r100) == false) goto L13;
        if (r105.isFinishing() == true) goto L13;
        r105.finish();
        goto L13
    L28:
        return;
    L27:
        return;
    L7:
        if (r101.size() != 0) goto L9;
        r102 = true;
        goto L9
    }

    public final void finishAllExceptH5(Context r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        EventManager r101 = EventManager.INSTANCE;
        r101.notify(new CJPayFinishAllSingleFragmentActivityEvent());
        r101.notify(new CJPayFinishAllBindCardPageEvent(false, 1, null));
    }

    public final void finishAllWithOutH5page(Context r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        EventManager r101 = EventManager.INSTANCE;
        r101.notify(new CJPayFinishAllSingleFragmentActivityEvent());
        r101.notify(new CJPayFinishAllBindCardPageEvent(false, 1, null));
    }

    public final void finishBindCard(Context r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        EventManager.INSTANCE.notify(new CJPayFinishAllBindCardPageEvent(false, 1, null));
    }

    public final void finishPaymentMethod(Context r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        EventManager.INSTANCE.notify(new CJPayFinishPaymentMethodActivityEvent());
    }

    public final void removeActivity(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Stack<Activity> r101 = activityStack;
        if (r101 == null) goto L6;
        r101.remove(r100);
        return;
    }
}
