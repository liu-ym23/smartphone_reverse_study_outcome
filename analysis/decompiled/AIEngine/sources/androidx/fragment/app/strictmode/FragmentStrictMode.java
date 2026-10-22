package androidx.fragment.app.strictmode;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.room.o;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.collections.EmptySet;
import kotlin.collections.b;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class FragmentStrictMode {

    /* renamed from: a, reason: collision with root package name */
    public static final a f2180a = a.f2189c;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Flag {

        /* renamed from: a, reason: collision with root package name */
        public static final Flag f2181a;

        /* renamed from: b, reason: collision with root package name */
        public static final Flag f2182b;

        /* renamed from: c, reason: collision with root package name */
        public static final Flag f2183c;

        /* renamed from: d, reason: collision with root package name */
        public static final Flag f2184d;

        /* renamed from: e, reason: collision with root package name */
        public static final Flag f2185e;
        public static final Flag h;

        /* renamed from: j, reason: collision with root package name */
        public static final Flag f2186j;

        /* renamed from: k, reason: collision with root package name */
        public static final Flag f2187k;

        /* renamed from: l, reason: collision with root package name */
        public static final /* synthetic */ Flag[] f2188l;

        static {
            Flag flag = new Flag("PENALTY_LOG", 0);
            f2181a = flag;
            Flag flag2 = new Flag("PENALTY_DEATH", 1);
            f2182b = flag2;
            Flag flag3 = new Flag("DETECT_FRAGMENT_REUSE", 2);
            f2183c = flag3;
            Flag flag4 = new Flag("DETECT_FRAGMENT_TAG_USAGE", 3);
            f2184d = flag4;
            Flag flag5 = new Flag("DETECT_RETAIN_INSTANCE_USAGE", 4);
            f2185e = flag5;
            Flag flag6 = new Flag("DETECT_SET_USER_VISIBLE_HINT", 5);
            h = flag6;
            Flag flag7 = new Flag("DETECT_TARGET_FRAGMENT_USAGE", 6);
            f2186j = flag7;
            Flag flag8 = new Flag("DETECT_WRONG_FRAGMENT_CONTAINER", 7);
            f2187k = flag8;
            f2188l = new Flag[]{flag, flag2, flag3, flag4, flag5, flag6, flag7, flag8};
        }

        public Flag() {
            throw null;
        }

        public static Flag valueOf(String str) {
            return (Flag) Enum.valueOf(Flag.class, str);
        }

        public static Flag[] values() {
            return (Flag[]) f2188l.clone();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {

        /* renamed from: c, reason: collision with root package name */
        public static final a f2189c = new a(b.d0(), EmptySet.f10003a);

        /* renamed from: a, reason: collision with root package name */
        public final Set<Flag> f2190a;

        /* renamed from: b, reason: collision with root package name */
        public final LinkedHashMap f2191b;

        public a(Map map, Set flags) {
            g.f(flags, "flags");
            this.f2190a = flags;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            ((EmptySet) map.entrySet()).getClass();
            this.f2191b = linkedHashMap;
        }
    }

    public static a a(Fragment fragment) {
        while (fragment != null) {
            if (fragment.isAdded()) {
                g.e(fragment.getParentFragmentManager(), "declaringFragment.parentFragmentManager");
            }
            fragment = fragment.getParentFragment();
        }
        return f2180a;
    }

    public static void b(a aVar, Violation violation) {
        Fragment fragment = violation.f2192a;
        String name = fragment.getClass().getName();
        Set<Flag> set = aVar.f2190a;
        if (set.contains(Flag.f2181a)) {
            Log.d("FragmentStrictMode", "Policy violation in ".concat(name), violation);
        }
        if (set.contains(Flag.f2182b)) {
            o oVar = new o(15, name, violation);
            if (!fragment.isAdded()) {
                oVar.run();
                throw null;
            }
            Handler handler = fragment.getParentFragmentManager().f2031u.f2195c;
            g.e(handler, "fragment.parentFragmentManager.host.handler");
            if (g.b(handler.getLooper(), Looper.myLooper())) {
                oVar.run();
                throw null;
            }
            handler.post(oVar);
        }
    }

    public static void c(Violation violation) {
        if (FragmentManager.G(3)) {
            Log.d("FragmentManager", "StrictMode violation in ".concat(violation.f2192a.getClass().getName()), violation);
        }
    }

    public static final void d(Fragment fragment, String previousFragmentId) {
        g.f(fragment, "fragment");
        g.f(previousFragmentId, "previousFragmentId");
        FragmentReuseViolation fragmentReuseViolation = new FragmentReuseViolation(fragment, "Attempting to reuse fragment " + fragment + " with previous ID " + previousFragmentId);
        c(fragmentReuseViolation);
        a aVarA = a(fragment);
        if (aVarA.f2190a.contains(Flag.f2183c) && e(aVarA, fragment.getClass(), FragmentReuseViolation.class)) {
            b(aVarA, fragmentReuseViolation);
        }
    }

    public static boolean e(a aVar, Class cls, Class cls2) {
        Set set = (Set) aVar.f2191b.get(cls.getName());
        if (set == null) {
            return true;
        }
        if (g.b(cls2.getSuperclass(), Violation.class) || !kotlin.collections.a.n0(set, cls2.getSuperclass())) {
            return !set.contains(cls2);
        }
        return false;
    }
}
