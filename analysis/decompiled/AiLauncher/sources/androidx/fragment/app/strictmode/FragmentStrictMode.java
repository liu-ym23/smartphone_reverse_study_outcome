package androidx.fragment.app.strictmode;

import Z8.F;
import Z8.Y;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.policy.sdk.config.PolicySdkConstants;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003;<#B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ!\u0010\r\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0007¢\u0006\u0004\b\r\u0010\u000eJ'\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0016\u0010\u0015J\u001f\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0017H\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ'\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0010H\u0007¢\u0006\u0004\b\u001e\u0010\u0013J\u0017\u0010\u001f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u001f\u0010\u0015J\u0017\u0010 \u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b \u0010\u0015J\u001f\u0010!\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b!\u0010\u000eJ\u0019\u0010#\u001a\u00020\"2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b#\u0010$J\u0017\u0010'\u001a\u00020\b2\u0006\u0010&\u001a\u00020%H\u0002¢\u0006\u0004\b'\u0010(J7\u0010-\u001a\u00020\u00172\u0006\u0010)\u001a\u00020\"2\u000e\u0010+\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040*2\u000e\u0010,\u001a\n\u0012\u0006\b\u0001\u0012\u00020%0*H\u0002¢\u0006\u0004\b-\u0010.J\u001f\u0010/\u001a\u00020\b2\u0006\u0010)\u001a\u00020\"2\u0006\u0010&\u001a\u00020%H\u0002¢\u0006\u0004\b/\u00100J\u001f\u00103\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u00102\u001a\u000201H\u0002¢\u0006\u0004\b3\u00104R\"\u0010:\u001a\u00020\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109¨\u0006="}, d2 = {"Landroidx/fragment/app/strictmode/FragmentStrictMode;", "", "<init>", "()V", "Landroidx/fragment/app/Fragment;", "fragment", "", "previousFragmentId", "LY8/t;", "f", "(Landroidx/fragment/app/Fragment;Ljava/lang/String;)V", "Landroid/view/ViewGroup;", "container", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Landroidx/fragment/app/Fragment;Landroid/view/ViewGroup;)V", "expectedParentFragment", "", "containerId", "o", "(Landroidx/fragment/app/Fragment;Landroidx/fragment/app/Fragment;I)V", "k", "(Landroidx/fragment/app/Fragment;)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "", "isVisibleToUser", "m", "(Landroidx/fragment/app/Fragment;Z)V", "violatingFragment", "targetFragment", "requestCode", "l", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "n", "Landroidx/fragment/app/strictmode/FragmentStrictMode$b;", Const.INTENT_KEY_PKGNAME, "(Landroidx/fragment/app/Fragment;)Landroidx/fragment/app/strictmode/FragmentStrictMode$b;", "Landroidx/fragment/app/strictmode/Violation;", "violation", "e", "(Landroidx/fragment/app/strictmode/Violation;)V", PolicySdkConstants.policyFileDir, "Ljava/lang/Class;", "fragmentClass", "violationClass", "q", "(Landroidx/fragment/app/strictmode/FragmentStrictMode$b;Ljava/lang/Class;Ljava/lang/Class;)Z", "c", "(Landroidx/fragment/app/strictmode/FragmentStrictMode$b;Landroidx/fragment/app/strictmode/Violation;)V", "Ljava/lang/Runnable;", "runnable", "p", "(Landroidx/fragment/app/Fragment;Ljava/lang/Runnable;)V", "Landroidx/fragment/app/strictmode/FragmentStrictMode$b;", "getDefaultPolicy", "()Landroidx/fragment/app/strictmode/FragmentStrictMode$b;", "setDefaultPolicy", "(Landroidx/fragment/app/strictmode/FragmentStrictMode$b;)V", "defaultPolicy", "Flag", Const.INTENT_KEY_APIKEY, "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class FragmentStrictMode {

    /* renamed from: a, reason: collision with root package name */
    public static final FragmentStrictMode f14127a = new FragmentStrictMode();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static b defaultPolicy = b.f14130d;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Landroidx/fragment/app/strictmode/FragmentStrictMode$Flag;", "", "(Ljava/lang/String;I)V", "PENALTY_LOG", "PENALTY_DEATH", "DETECT_FRAGMENT_REUSE", "DETECT_FRAGMENT_TAG_USAGE", "DETECT_WRONG_NESTED_HIERARCHY", "DETECT_RETAIN_INSTANCE_USAGE", "DETECT_SET_USER_VISIBLE_HINT", "DETECT_TARGET_FRAGMENT_USAGE", "DETECT_WRONG_FRAGMENT_CONTAINER", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum Flag {
        PENALTY_LOG,
        PENALTY_DEATH,
        DETECT_FRAGMENT_REUSE,
        DETECT_FRAGMENT_TAG_USAGE,
        DETECT_WRONG_NESTED_HIERARCHY,
        DETECT_RETAIN_INSTANCE_USAGE,
        DETECT_SET_USER_VISIBLE_HINT,
        DETECT_TARGET_FRAGMENT_USAGE,
        DETECT_WRONG_FRAGMENT_CONTAINER
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0002À\u0006\u0001"}, d2 = {"Landroidx/fragment/app/strictmode/FragmentStrictMode$a;", "", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface a {
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 \u00142\u00020\u0001:\u0001\u000fBC\b\u0000\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012 \u0010\f\u001a\u001c\u0012\u0004\u0012\u00020\b\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\n0\t0\u0007¢\u0006\u0004\b\r\u0010\u000eR \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011R4\u0010\u0016\u001a\u001c\u0012\u0004\u0012\u00020\b\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\n0\u00020\u00078\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0017\u001a\u0004\b\u0012\u0010\u0018¨\u0006\u0019"}, d2 = {"Landroidx/fragment/app/strictmode/FragmentStrictMode$b;", "", "", "Landroidx/fragment/app/strictmode/FragmentStrictMode$Flag;", "flags", "Landroidx/fragment/app/strictmode/FragmentStrictMode$a;", "listener", "", "", "", "Ljava/lang/Class;", "Landroidx/fragment/app/strictmode/Violation;", "allowedViolations", "<init>", "(Ljava/util/Set;Landroidx/fragment/app/strictmode/FragmentStrictMode$a;Ljava/util/Map;)V", Const.INTENT_KEY_APIKEY, "Ljava/util/Set;", "()Ljava/util/Set;", Const.INTENT_KEY_PKGNAME, "Ljava/util/Map;", "c", "()Ljava/util/Map;", "mAllowedViolations", "Landroidx/fragment/app/strictmode/FragmentStrictMode$a;", "()Landroidx/fragment/app/strictmode/FragmentStrictMode$a;", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class b {

        /* renamed from: d, reason: collision with root package name */
        public static final b f14130d = new b(Y.e(), null, kotlin.collections.a.i());

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final Set<Flag> flags;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final Map<String, Set<Class<? extends Violation>>> mAllowedViolations;

        /* JADX WARN: Multi-variable type inference failed */
        public b(Set<? extends Flag> flags, a aVar, Map<String, ? extends Set<Class<? extends Violation>>> allowedViolations) {
            p.i(flags, "flags");
            p.i(allowedViolations, "allowedViolations");
            this.flags = flags;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<String, ? extends Set<Class<? extends Violation>>> entry : allowedViolations.entrySet()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
            this.mAllowedViolations = linkedHashMap;
        }

        public final Set<Flag> a() {
            return this.flags;
        }

        public final a b() {
            return null;
        }

        public final Map<String, Set<Class<? extends Violation>>> c() {
            return this.mAllowedViolations;
        }
    }

    public static final void d(String str, Violation violation) {
        p.i(violation, "$violation");
        Log.e("FragmentStrictMode", "Policy violation with PENALTY_DEATH in " + str, violation);
        throw violation;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void f(Fragment fragment, String previousFragmentId) {
        p.i(fragment, "fragment");
        p.i(previousFragmentId, "previousFragmentId");
        FragmentReuseViolation fragmentReuseViolation = new FragmentReuseViolation(fragment, previousFragmentId);
        FragmentStrictMode fragmentStrictMode = f14127a;
        fragmentStrictMode.e(fragmentReuseViolation);
        b bVarB = fragmentStrictMode.b(fragment);
        if (bVarB.a().contains(Flag.DETECT_FRAGMENT_REUSE) && fragmentStrictMode.q(bVarB, fragment.getClass(), fragmentReuseViolation.getClass())) {
            fragmentStrictMode.c(bVarB, fragmentReuseViolation);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void g(Fragment fragment, ViewGroup container) {
        p.i(fragment, "fragment");
        FragmentTagUsageViolation fragmentTagUsageViolation = new FragmentTagUsageViolation(fragment, container);
        FragmentStrictMode fragmentStrictMode = f14127a;
        fragmentStrictMode.e(fragmentTagUsageViolation);
        b bVarB = fragmentStrictMode.b(fragment);
        if (bVarB.a().contains(Flag.DETECT_FRAGMENT_TAG_USAGE) && fragmentStrictMode.q(bVarB, fragment.getClass(), fragmentTagUsageViolation.getClass())) {
            fragmentStrictMode.c(bVarB, fragmentTagUsageViolation);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void h(Fragment fragment) {
        p.i(fragment, "fragment");
        GetRetainInstanceUsageViolation getRetainInstanceUsageViolation = new GetRetainInstanceUsageViolation(fragment);
        FragmentStrictMode fragmentStrictMode = f14127a;
        fragmentStrictMode.e(getRetainInstanceUsageViolation);
        b bVarB = fragmentStrictMode.b(fragment);
        if (bVarB.a().contains(Flag.DETECT_RETAIN_INSTANCE_USAGE) && fragmentStrictMode.q(bVarB, fragment.getClass(), getRetainInstanceUsageViolation.getClass())) {
            fragmentStrictMode.c(bVarB, getRetainInstanceUsageViolation);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void i(Fragment fragment) {
        p.i(fragment, "fragment");
        GetTargetFragmentRequestCodeUsageViolation getTargetFragmentRequestCodeUsageViolation = new GetTargetFragmentRequestCodeUsageViolation(fragment);
        FragmentStrictMode fragmentStrictMode = f14127a;
        fragmentStrictMode.e(getTargetFragmentRequestCodeUsageViolation);
        b bVarB = fragmentStrictMode.b(fragment);
        if (bVarB.a().contains(Flag.DETECT_TARGET_FRAGMENT_USAGE) && fragmentStrictMode.q(bVarB, fragment.getClass(), getTargetFragmentRequestCodeUsageViolation.getClass())) {
            fragmentStrictMode.c(bVarB, getTargetFragmentRequestCodeUsageViolation);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void j(Fragment fragment) {
        p.i(fragment, "fragment");
        GetTargetFragmentUsageViolation getTargetFragmentUsageViolation = new GetTargetFragmentUsageViolation(fragment);
        FragmentStrictMode fragmentStrictMode = f14127a;
        fragmentStrictMode.e(getTargetFragmentUsageViolation);
        b bVarB = fragmentStrictMode.b(fragment);
        if (bVarB.a().contains(Flag.DETECT_TARGET_FRAGMENT_USAGE) && fragmentStrictMode.q(bVarB, fragment.getClass(), getTargetFragmentUsageViolation.getClass())) {
            fragmentStrictMode.c(bVarB, getTargetFragmentUsageViolation);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void k(Fragment fragment) {
        p.i(fragment, "fragment");
        SetRetainInstanceUsageViolation setRetainInstanceUsageViolation = new SetRetainInstanceUsageViolation(fragment);
        FragmentStrictMode fragmentStrictMode = f14127a;
        fragmentStrictMode.e(setRetainInstanceUsageViolation);
        b bVarB = fragmentStrictMode.b(fragment);
        if (bVarB.a().contains(Flag.DETECT_RETAIN_INSTANCE_USAGE) && fragmentStrictMode.q(bVarB, fragment.getClass(), setRetainInstanceUsageViolation.getClass())) {
            fragmentStrictMode.c(bVarB, setRetainInstanceUsageViolation);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void l(Fragment violatingFragment, Fragment targetFragment, int requestCode) {
        p.i(violatingFragment, "violatingFragment");
        p.i(targetFragment, "targetFragment");
        SetTargetFragmentUsageViolation setTargetFragmentUsageViolation = new SetTargetFragmentUsageViolation(violatingFragment, targetFragment, requestCode);
        FragmentStrictMode fragmentStrictMode = f14127a;
        fragmentStrictMode.e(setTargetFragmentUsageViolation);
        b bVarB = fragmentStrictMode.b(violatingFragment);
        if (bVarB.a().contains(Flag.DETECT_TARGET_FRAGMENT_USAGE) && fragmentStrictMode.q(bVarB, violatingFragment.getClass(), setTargetFragmentUsageViolation.getClass())) {
            fragmentStrictMode.c(bVarB, setTargetFragmentUsageViolation);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void m(Fragment fragment, boolean isVisibleToUser) {
        p.i(fragment, "fragment");
        SetUserVisibleHintViolation setUserVisibleHintViolation = new SetUserVisibleHintViolation(fragment, isVisibleToUser);
        FragmentStrictMode fragmentStrictMode = f14127a;
        fragmentStrictMode.e(setUserVisibleHintViolation);
        b bVarB = fragmentStrictMode.b(fragment);
        if (bVarB.a().contains(Flag.DETECT_SET_USER_VISIBLE_HINT) && fragmentStrictMode.q(bVarB, fragment.getClass(), setUserVisibleHintViolation.getClass())) {
            fragmentStrictMode.c(bVarB, setUserVisibleHintViolation);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void n(Fragment fragment, ViewGroup container) {
        p.i(fragment, "fragment");
        p.i(container, "container");
        WrongFragmentContainerViolation wrongFragmentContainerViolation = new WrongFragmentContainerViolation(fragment, container);
        FragmentStrictMode fragmentStrictMode = f14127a;
        fragmentStrictMode.e(wrongFragmentContainerViolation);
        b bVarB = fragmentStrictMode.b(fragment);
        if (bVarB.a().contains(Flag.DETECT_WRONG_FRAGMENT_CONTAINER) && fragmentStrictMode.q(bVarB, fragment.getClass(), wrongFragmentContainerViolation.getClass())) {
            fragmentStrictMode.c(bVarB, wrongFragmentContainerViolation);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void o(Fragment fragment, Fragment expectedParentFragment, int containerId) {
        p.i(fragment, "fragment");
        p.i(expectedParentFragment, "expectedParentFragment");
        WrongNestedHierarchyViolation wrongNestedHierarchyViolation = new WrongNestedHierarchyViolation(fragment, expectedParentFragment, containerId);
        FragmentStrictMode fragmentStrictMode = f14127a;
        fragmentStrictMode.e(wrongNestedHierarchyViolation);
        b bVarB = fragmentStrictMode.b(fragment);
        if (bVarB.a().contains(Flag.DETECT_WRONG_NESTED_HIERARCHY) && fragmentStrictMode.q(bVarB, fragment.getClass(), wrongNestedHierarchyViolation.getClass())) {
            fragmentStrictMode.c(bVarB, wrongNestedHierarchyViolation);
        }
    }

    public final b b(Fragment fragment) {
        while (fragment != null) {
            if (fragment.isAdded()) {
                FragmentManager parentFragmentManager = fragment.getParentFragmentManager();
                p.h(parentFragmentManager, "declaringFragment.parentFragmentManager");
                if (parentFragmentManager.G0() != null) {
                    b bVarG0 = parentFragmentManager.G0();
                    p.f(bVarG0);
                    return bVarG0;
                }
            }
            fragment = fragment.getParentFragment();
        }
        return defaultPolicy;
    }

    public final void c(b policy, final Violation violation) {
        Fragment fragmentA = violation.getFragment();
        final String name = fragmentA.getClass().getName();
        if (policy.a().contains(Flag.PENALTY_LOG)) {
            Log.d("FragmentStrictMode", "Policy violation in " + name, violation);
        }
        policy.b();
        if (policy.a().contains(Flag.PENALTY_DEATH)) {
            p(fragmentA, new Runnable() { // from class: R0.a
                @Override // java.lang.Runnable
                public final void run() {
                    FragmentStrictMode.d(name, violation);
                }
            });
        }
    }

    public final void e(Violation violation) {
        if (FragmentManager.N0(3)) {
            Log.d("FragmentManager", "StrictMode violation in " + violation.getFragment().getClass().getName(), violation);
        }
    }

    public final void p(Fragment fragment, Runnable runnable) {
        if (!fragment.isAdded()) {
            runnable.run();
            return;
        }
        Handler handler = fragment.getParentFragmentManager().A0().getHandler();
        if (p.d(handler.getLooper(), Looper.myLooper())) {
            runnable.run();
        } else {
            handler.post(runnable);
        }
    }

    public final boolean q(b policy, Class<? extends Fragment> fragmentClass, Class<? extends Violation> violationClass) {
        Set<Class<? extends Violation>> set = policy.c().get(fragmentClass.getName());
        if (set == null) {
            return true;
        }
        if (p.d(violationClass.getSuperclass(), Violation.class) || !F.f0(set, violationClass.getSuperclass())) {
            return !set.contains(violationClass);
        }
        return false;
    }
}
