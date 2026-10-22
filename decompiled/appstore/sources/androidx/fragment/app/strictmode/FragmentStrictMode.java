package androidx.fragment.app.strictmode;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.b0;
import kotlin.collections.k0;
import kotlin.collections.r0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import w.b;

/* JADX INFO: loaded from: classes.dex */
public final class FragmentStrictMode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final FragmentStrictMode f3385a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static a f3386b;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Landroidx/fragment/app/strictmode/FragmentStrictMode$Flag;", "", "(Ljava/lang/String;I)V", "PENALTY_LOG", "PENALTY_DEATH", "DETECT_FRAGMENT_REUSE", "DETECT_FRAGMENT_TAG_USAGE", "DETECT_WRONG_NESTED_HIERARCHY", "DETECT_RETAIN_INSTANCE_USAGE", "DETECT_SET_USER_VISIBLE_HINT", "DETECT_TARGET_FRAGMENT_USAGE", "DETECT_WRONG_FRAGMENT_CONTAINER", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final enum Flag extends Enum<Flag> {
        private static final /* synthetic */ Flag[] $VALUES = null;
        public static final Flag DETECT_FRAGMENT_REUSE = null;
        public static final Flag DETECT_FRAGMENT_TAG_USAGE = null;
        public static final Flag DETECT_RETAIN_INSTANCE_USAGE = null;
        public static final Flag DETECT_SET_USER_VISIBLE_HINT = null;
        public static final Flag DETECT_TARGET_FRAGMENT_USAGE = null;
        public static final Flag DETECT_WRONG_FRAGMENT_CONTAINER = null;
        public static final Flag DETECT_WRONG_NESTED_HIERARCHY = null;
        public static final Flag PENALTY_DEATH = null;
        public static final Flag PENALTY_LOG = null;

        private static final /* synthetic */ Flag[] $values() {
            return new Flag[]{PENALTY_LOG, PENALTY_DEATH, DETECT_FRAGMENT_REUSE, DETECT_FRAGMENT_TAG_USAGE, DETECT_WRONG_NESTED_HIERARCHY, DETECT_RETAIN_INSTANCE_USAGE, DETECT_SET_USER_VISIBLE_HINT, DETECT_TARGET_FRAGMENT_USAGE, DETECT_WRONG_FRAGMENT_CONTAINER};
        }

        static {
            PENALTY_LOG = new Flag("PENALTY_LOG", 0);
            PENALTY_DEATH = new Flag("PENALTY_DEATH", 1);
            DETECT_FRAGMENT_REUSE = new Flag("DETECT_FRAGMENT_REUSE", 2);
            DETECT_FRAGMENT_TAG_USAGE = new Flag("DETECT_FRAGMENT_TAG_USAGE", 3);
            DETECT_WRONG_NESTED_HIERARCHY = new Flag("DETECT_WRONG_NESTED_HIERARCHY", 4);
            DETECT_RETAIN_INSTANCE_USAGE = new Flag("DETECT_RETAIN_INSTANCE_USAGE", 5);
            DETECT_SET_USER_VISIBLE_HINT = new Flag("DETECT_SET_USER_VISIBLE_HINT", 6);
            DETECT_TARGET_FRAGMENT_USAGE = new Flag("DETECT_TARGET_FRAGMENT_USAGE", 7);
            DETECT_WRONG_FRAGMENT_CONTAINER = new Flag("DETECT_WRONG_FRAGMENT_CONTAINER", 8);
            $VALUES = $values();
        }

        private Flag(String r10, int r11) {
            super(r10, r11);
        }

        public static Flag valueOf(String r10) {
            return (Flag) Enum.valueOf(Flag.class, r10);
        }

        public static Flag[] values() {
            return (Flag[]) $VALUES.clone();
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Landroidx/fragment/app/strictmode/FragmentStrictMode$OnViolationListener;", "", "onViolation", "", "violation", "Landroidx/fragment/app/strictmode/Violation;", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface OnViolationListener {
        void onViolation(@NotNull Violation r10);
    }

    public static final class a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final C0029a f3387d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final a f3388e = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Set f3389a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final OnViolationListener f3390b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Map f3391c;

        /* JADX INFO: renamed from: androidx.fragment.app.strictmode.FragmentStrictMode$a$a, reason: collision with other inner class name */
        public static final class C0029a {
            public /* synthetic */ C0029a(DefaultConstructorMarker r10) {
                this();
            }

            public C0029a() {
            }
        }

        static {
            f3387d = new C0029a(null);
            f3388e = new a(r0.e(), null, k0.h());
        }

        public a(Set r10, OnViolationListener r11, Map r12) {
            q.g(r10, "flags");
            q.g(r12, "allowedViolations");
            this.f3389a = r10;
            this.f3390b = r11;
            LinkedHashMap r13 = new LinkedHashMap();
            Iterator r14 = r12.entrySet().iterator();
        L4:
            if (r14.hasNext() == false) goto L6;
            Map.Entry r15 = (Map.Entry) r14.next();
            r13.put((String) r15.getKey(), (Set) r15.getValue());
            goto L4
        L6:
            this.f3391c = r13;
        }

        public final Set a() {
            return this.f3389a;
        }

        public final OnViolationListener b() {
            return this.f3390b;
        }

        public final Map c() {
            return this.f3391c;
        }
    }

    static {
        f3385a = new FragmentStrictMode();
        f3386b = a.f3388e;
    }

    public FragmentStrictMode() {
    }

    public static /* synthetic */ void a(String r10, Violation r11) {
        f(r10, r11);
    }

    public static /* synthetic */ void b(a r10, Violation r11) {
        e(r10, r11);
    }

    public static final void e(a r10, Violation r11) {
        q.g(r10, "$policy");
        q.g(r11, "$violation");
        r10.b().onViolation(r11);
    }

    public static final void f(String r10, Violation r11) {
        q.g(r11, "$violation");
        Log.e("FragmentStrictMode", "Policy violation with PENALTY_DEATH in " + r10, r11);
        throw r11;
    }

    public static final void h(Fragment r10, String r11) {
        q.g(r10, "fragment");
        q.g(r11, "previousFragmentId");
        FragmentReuseViolation r12 = new FragmentReuseViolation(r10, r11);
        FragmentStrictMode r13 = f3385a;
        r13.g(r12);
        a r14 = r13.c(r10);
        if (r14.a().contains(Flag.DETECT_FRAGMENT_REUSE) == true) goto L5;
        return;
    L5:
        if (r13.s(r14, r10.getClass(), r12.getClass()) == false) goto L9;
        r13.d(r14, r12);
        return;
    }

    public static final void i(Fragment r10, ViewGroup r11) {
        q.g(r10, "fragment");
        FragmentTagUsageViolation r12 = new FragmentTagUsageViolation(r10, r11);
        FragmentStrictMode r13 = f3385a;
        r13.g(r12);
        a r14 = r13.c(r10);
        if (r14.a().contains(Flag.DETECT_FRAGMENT_TAG_USAGE) == true) goto L5;
        return;
    L5:
        if (r13.s(r14, r10.getClass(), r12.getClass()) == false) goto L9;
        r13.d(r14, r12);
        return;
    }

    public static final void j(Fragment r10) {
        q.g(r10, "fragment");
        GetRetainInstanceUsageViolation r11 = new GetRetainInstanceUsageViolation(r10);
        FragmentStrictMode r12 = f3385a;
        r12.g(r11);
        a r13 = r12.c(r10);
        if (r13.a().contains(Flag.DETECT_RETAIN_INSTANCE_USAGE) == true) goto L5;
        return;
    L5:
        if (r12.s(r13, r10.getClass(), r11.getClass()) == false) goto L9;
        r12.d(r13, r11);
        return;
    }

    public static final void k(Fragment r10) {
        q.g(r10, "fragment");
        GetTargetFragmentRequestCodeUsageViolation r11 = new GetTargetFragmentRequestCodeUsageViolation(r10);
        FragmentStrictMode r12 = f3385a;
        r12.g(r11);
        a r13 = r12.c(r10);
        if (r13.a().contains(Flag.DETECT_TARGET_FRAGMENT_USAGE) == true) goto L5;
        return;
    L5:
        if (r12.s(r13, r10.getClass(), r11.getClass()) == false) goto L9;
        r12.d(r13, r11);
        return;
    }

    public static final void l(Fragment r10) {
        q.g(r10, "fragment");
        GetTargetFragmentUsageViolation r11 = new GetTargetFragmentUsageViolation(r10);
        FragmentStrictMode r12 = f3385a;
        r12.g(r11);
        a r13 = r12.c(r10);
        if (r13.a().contains(Flag.DETECT_TARGET_FRAGMENT_USAGE) == true) goto L5;
        return;
    L5:
        if (r12.s(r13, r10.getClass(), r11.getClass()) == false) goto L9;
        r12.d(r13, r11);
        return;
    }

    public static final void m(Fragment r10) {
        q.g(r10, "fragment");
        SetRetainInstanceUsageViolation r11 = new SetRetainInstanceUsageViolation(r10);
        FragmentStrictMode r12 = f3385a;
        r12.g(r11);
        a r13 = r12.c(r10);
        if (r13.a().contains(Flag.DETECT_RETAIN_INSTANCE_USAGE) == true) goto L5;
        return;
    L5:
        if (r12.s(r13, r10.getClass(), r11.getClass()) == false) goto L9;
        r12.d(r13, r11);
        return;
    }

    public static final void n(Fragment r10, Fragment r11, int r12) {
        q.g(r10, "violatingFragment");
        q.g(r11, "targetFragment");
        SetTargetFragmentUsageViolation r13 = new SetTargetFragmentUsageViolation(r10, r11, r12);
        FragmentStrictMode r14 = f3385a;
        r14.g(r13);
        a r15 = r14.c(r10);
        if (r15.a().contains(Flag.DETECT_TARGET_FRAGMENT_USAGE) == true) goto L5;
        return;
    L5:
        if (r14.s(r15, r10.getClass(), r13.getClass()) == false) goto L9;
        r14.d(r15, r13);
        return;
    }

    public static final void o(Fragment r10, boolean r11) {
        q.g(r10, "fragment");
        SetUserVisibleHintViolation r12 = new SetUserVisibleHintViolation(r10, r11);
        FragmentStrictMode r13 = f3385a;
        r13.g(r12);
        a r14 = r13.c(r10);
        if (r14.a().contains(Flag.DETECT_SET_USER_VISIBLE_HINT) == true) goto L5;
        return;
    L5:
        if (r13.s(r14, r10.getClass(), r12.getClass()) == false) goto L9;
        r13.d(r14, r12);
        return;
    }

    public static final void p(Fragment r10, ViewGroup r11) {
        q.g(r10, "fragment");
        q.g(r11, "container");
        WrongFragmentContainerViolation r12 = new WrongFragmentContainerViolation(r10, r11);
        FragmentStrictMode r13 = f3385a;
        r13.g(r12);
        a r14 = r13.c(r10);
        if (r14.a().contains(Flag.DETECT_WRONG_FRAGMENT_CONTAINER) == true) goto L5;
        return;
    L5:
        if (r13.s(r14, r10.getClass(), r12.getClass()) == false) goto L9;
        r13.d(r14, r12);
        return;
    }

    public static final void q(Fragment r10, Fragment r11, int r12) {
        q.g(r10, "fragment");
        q.g(r11, "expectedParentFragment");
        WrongNestedHierarchyViolation r13 = new WrongNestedHierarchyViolation(r10, r11, r12);
        FragmentStrictMode r14 = f3385a;
        r14.g(r13);
        a r15 = r14.c(r10);
        if (r15.a().contains(Flag.DETECT_WRONG_NESTED_HIERARCHY) == true) goto L5;
        return;
    L5:
        if (r14.s(r15, r10.getClass(), r13.getClass()) == false) goto L9;
        r14.d(r15, r13);
        return;
    }

    public final a c(Fragment r10) {
    L2:
        if (r10 == null) goto L11;
        if (r10.isAdded() == false) goto L9;
        FragmentManager r11 = r10.getParentFragmentManager();
        q.f(r11, "declaringFragment.parentFragmentManager");
        if (r11.E0() == null) goto L9;
        a r12 = r11.E0();
        q.d(r12);
        return r12;
    L9:
        r10 = r10.getParentFragment();
        goto L2
    L11:
        return f3386b;
    }

    public final void d(final a r10, final Violation r11) {
        Fragment r12 = r11.getFragment();
        final String r13 = r12.getClass().getName();
        if (r10.a().contains(Flag.PENALTY_LOG) == false) goto L6;
        Log.d("FragmentStrictMode", "Policy violation in " + r13, r11);
    L6:
        if (r10.b() == null) goto L9;
        r(r12, new w.a(r10, r11));
    L9:
        if (r10.a().contains(Flag.PENALTY_DEATH) == false) goto L12;
        r(r12, new b(r13, r11));
        return;
    }

    public final void g(Violation r10) {
        if (FragmentManager.L0(3) == false) goto L6;
        Log.d("FragmentManager", "StrictMode violation in " + r10.getFragment().getClass().getName(), r10);
        return;
    }

    public final void r(Fragment r10, Runnable r11) {
        if (r10.isAdded() == false) goto L8;
        Handler r12 = r10.getParentFragmentManager().y0().f();
        q.f(r12, "fragment.parentFragmentManager.host.handler");
        if (q.b(r12.getLooper(), Looper.myLooper()) == false) goto L7;
        r11.run();
        return;
    L7:
        r12.post(r11);
        return;
    L8:
        r11.run();
    }

    public final boolean s(a r10, Class r11, Class r12) {
        Set r13 = (Set) r10.c().get(r11.getName());
        if (r13 != null) goto L6;
        return true;
    L6:
        if (q.b(r12.getSuperclass(), Violation.class) == true) goto L12;
        if (b0.S(r13, r12.getSuperclass()) == false) goto L12;
        return false;
    L12:
        return !r13.contains(r12);
    }
}
