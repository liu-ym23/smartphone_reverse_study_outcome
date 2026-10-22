package androidx.fragment.app;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.aa;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: DefaultSpecialEffectsController.java */
/* JADX INFO: loaded from: classes.dex */
class b extends t {

    /* JADX INFO: renamed from: androidx.fragment.app.b$2, reason: invalid class name */
    /* JADX INFO: compiled from: DefaultSpecialEffectsController.java */
    static /* synthetic */ class AnonymousClass2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f1772a = null;

        static {
            int[] r0 = new int[t.b.EnumC0056b.values().length];
            f1772a = r0;
            r0[t.b.EnumC0056b.f1906c.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            f1772a[t.b.EnumC0056b.f1907d.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            f1772a[t.b.EnumC0056b.f1904a.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            f1772a[t.b.EnumC0056b.f1905b.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    /* JADX INFO: compiled from: DefaultSpecialEffectsController.java */
    private static class a extends C0055b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f1792a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f1793b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private FragmentAnim.a f1794c;

        a(t.b r1, androidx.core.os.f r2, boolean r3) {
            super(r1, r2);
            this.f1793b = false;
            this.f1792a = r3;
        }

        FragmentAnim.a a(Context r5) {
            Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
            if (this.f1793b == true) goto L5;
            Fragment r0 = a().e();
            if (a().c() != t.b.EnumC0056b.f1905b) goto L9;
            boolean r1 = true;
        L10:
            FragmentAnim.a r7 = FragmentAnim.a(r6, r0, r1, this.f1792a);
            this.f1794c = r7;
            this.f1793b = true;
            return r7;
        L9:
            r1 = false;
            goto L10
        L5:
            return this.f1794c;
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DefaultSpecialEffectsController.java */
    private static class C0055b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final t.b f1795a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final androidx.core.os.f f1796b;

        C0055b(t.b r1, androidx.core.os.f r2) {
            this.f1795a = r1;
            this.f1796b = r2;
        }

        t.b a() {
            return this.f1795a;
        }

        androidx.core.os.f b() {
            return this.f1796b;
        }

        boolean c() {
            t.b.EnumC0056b r0 = t.b.EnumC0056b.a(this.f1795a.e().mView);
            t.b.EnumC0056b r2 = this.f1795a.c();
            if (r0 != r2) goto L5;
        L10:
            return true;
        L5:
            if (r0 != t.b.EnumC0056b.f1905b) goto L7;
        L9:
            return false;
        L7:
            if (r2 == t.b.EnumC0056b.f1905b) goto L9;
            goto L9
        }

        void d() {
            this.f1795a.b(this.f1796b);
        }
    }

    /* JADX INFO: compiled from: DefaultSpecialEffectsController.java */
    private static class c extends C0055b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object f1797a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f1798b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Object f1799c;

        c(t.b r2, androidx.core.os.f r3, boolean r4, boolean r5) {
            super(r2, r3);
            if (r2.c() != t.b.EnumC0056b.f1905b) goto L12;
            if (r4 == false) goto L6;
            Object r6 = r2.e().getReenterTransition();
        L7:
            this.f1797a = r6;
            if (r4 == false) goto L10;
            boolean r7 = r2.e().getAllowReturnTransitionOverlap();
        L11:
            this.f1798b = r7;
        L16:
            if (r5 == false) goto L20;
            if (r4 == false) goto L19;
            this.f1799c = r2.e().getSharedElementReturnTransition();
            return;
        L19:
            this.f1799c = r2.e().getSharedElementEnterTransition();
            return;
        L20:
            this.f1799c = null;
            return;
        L10:
            r7 = r2.e().getAllowEnterTransitionOverlap();
            goto L11
        L6:
            r6 = r2.e().getEnterTransition();
            goto L7
        L12:
            if (r4 == false) goto L14;
            Object r8 = r2.e().getReturnTransition();
        L15:
            this.f1797a = r8;
            this.f1798b = true;
            goto L16
        L14:
            r8 = r2.e().getExitTransition();
            goto L15
        }

        Object e() {
            return this.f1797a;
        }

        boolean f() {
            return this.f1798b;
        }

        public boolean g() {
            if (this.f1799c == null) goto L5;
            return true;
        L5:
            return false;
        }

        public Object h() {
            return this.f1799c;
        }

        p i() {
            p r0 = a(this.f1797a);
            p r1 = a(this.f1799c);
            if (r0 == null) goto L9;
            if (r1 == null) goto L9;
            if (r0 == r1) goto L9;
            throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + a().e() + " returned Transition " + this.f1797a + " which uses a different Transition  type than its shared element transition " + this.f1799c);
        L9:
            if (r0 == null) goto L12;
            return r0;
        L12:
            return r1;
        }

        private p a(Object r4) {
            if (r4 != null) goto L6;
            return null;
        L6:
            if (n.f1833a == null) goto L12;
            if (n.f1833a.a(r4) == false) goto L12;
            return n.f1833a;
        L12:
            if (n.f1834b == null) goto L18;
            if (n.f1834b.a(r4) == false) goto L18;
            return n.f1834b;
        L18:
            throw new IllegalArgumentException("Transition " + r4 + " for fragment " + a().e() + " is not a valid framework Transition or AndroidX Transition");
        }
    }

    b(ViewGroup r1) {
        super(r1);
    }

    @Override // androidx.fragment.app.t
    void a(List<t.b> r12, boolean r13) {
        List r14 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.aiagent.plugin");
        Iterator r0 = r14.iterator();
        t.b r7 = null;
        t.b r8 = null;
    L4:
        if (r0.hasNext() == false) goto L21;
        t.b r2 = (t.b) ZeusTransformUtils.preCheckCast(r0.next(), t.b.class, "com.obric.aiagent.plugin");
        t.b.EnumC0056b r3 = t.b.EnumC0056b.a(r2.e().mView);
        int r4 = AnonymousClass2.f1772a[r2.c().ordinal()];
        if (r4 == 1) goto L18;
        if (r4 == 2) goto L18;
        if (r4 == 3) goto L18;
        if (r4 != 4) goto L4;
        if (r3 == t.b.EnumC0056b.f1905b) goto L4;
        r8 = r2;
    L18:
        if (r3 != t.b.EnumC0056b.f1905b) goto L4;
        if (r7 != null) goto L4;
        r7 = r2;
        goto L4
    L21:
        ArrayList r1 = new ArrayList();
        ArrayList r5 = new ArrayList();
        final ArrayList r6 = new ArrayList(r14);
        Iterator r15 = r14.iterator();
    L23:
        if (r15.hasNext() == false) goto L31;
        final t.b r9 = (t.b) ZeusTransformUtils.preCheckCast(r15.next(), t.b.class, "com.obric.aiagent.plugin");
        androidx.core.os.f r10 = new androidx.core.os.f();
        r9.a(r10);
        r1.add(new a(r9, r10, r13));
        androidx.core.os.f r11 = new androidx.core.os.f();
        r9.a(r11);
        boolean r16 = false;
        if (r13 == false) goto L28;
        if (r9 != r7) goto L30;
    L29:
        r16 = true;
    L30:
        r5.add(new c(r9, r11, r13, r16));
        r9.a(new AnonymousClass1(this, r6, r9));
        goto L23
    L28:
        if (r9 != r8) goto L30;
    L31:
        Map<t.b, Boolean> r17 = a(r5, r6, r13, r7, r8);
        a(r1, r6, r17.containsValue(true), r17);
        Iterator<t.b> r18 = r6.iterator();
    L33:
        if (r18.hasNext() == false) goto L35;
        a((t.b) ZeusTransformUtils.preCheckCast(r18.next(), t.b.class, "com.obric.aiagent.plugin"));
        goto L33
    L35:
        r6.clear();
    }

    private void a(List<a> r20, List<t.b> r21, boolean r22, Map<t.b, Boolean> r23) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r20, List.class, "com.obric.aiagent.plugin");
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r21, List.class, "com.obric.aiagent.plugin");
        Map r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r23, Map.class, "com.obric.aiagent.plugin");
        final ViewGroup r11 = a();
        Context r12 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r11.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        ArrayList r13 = new ArrayList();
        Iterator r14 = r0.iterator();
        boolean r1 = false;
    L4:
        if (r14.hasNext() == false) goto L27;
        final a r6 = (a) ZeusTransformUtils.preCheckCast(r14.next(), a.class, "com.obric.aiagent.plugin");
        if (r6.c() == true) goto L7;
        FragmentAnim.a r2 = r6.a(r12);
        if (r2 == null) goto L10;
        final Animator r5 = r2.f1729b;
        if (r5 == null) goto L13;
        final t.b r4 = r6.a();
        Fragment r3 = r4.e();
        if (Boolean.TRUE.equals(r10.get(r4)) == true) goto L17;
        if (r4.c() != t.b.EnumC0056b.f1906c) goto L23;
        boolean r15 = true;
    L24:
        if (r15 == false) goto L26;
        r9.remove(r4);
    L26:
        final View r7 = r3.mView;
        r11.startViewTransition(r7);
        final boolean r8 = r15;
        r5.addListener(new DefaultSpecialEffectsController$2(this, r11, r7, r8, r4, r6));
        r5.setTarget(r7);
        r5.start();
        r6.b().a(new AnonymousClass3(this, r5));
        r9 = r9;
        r1 = true;
        goto L4
    L23:
        r15 = false;
        goto L24
    L17:
        if (FragmentManager.a(2) == false) goto L19;
        a("FragmentManager", "Ignoring Animator set on " + r3 + " as this Fragment was involved in a Transition.");
    L19:
        r6.d();
        goto L4
    L13:
        r13.add(r6);
        goto L4
    L10:
        r6.d();
        goto L4
    L7:
        r6.d();
        goto L4
    L27:
        Iterator r16 = r13.iterator();
    L29:
        if (r16.hasNext() == false) goto L46;
        final a r17 = (a) ZeusTransformUtils.preCheckCast(r16.next(), a.class, "com.obric.aiagent.plugin");
        t.b r18 = r17.a();
        Fragment r19 = r18.e();
        if (r22 == true) goto L33;
        if (r1 == true) goto L38;
        final View r24 = r19.mView;
        Animation r25 = (Animation) ZeusTransformUtils.preCheckCast(androidx.core.util.g.a(((FragmentAnim.a) ZeusTransformUtils.preCheckCast(androidx.core.util.g.a(r17.a(r12)), FragmentAnim.a.class, "com.obric.aiagent.plugin")).f1728a), Animation.class, "com.obric.aiagent.plugin");
        if (r18.c() == t.b.EnumC0056b.f1904a) goto L44;
        r24.startAnimation(r25);
        r17.d();
    L45:
        r17.b().a(new AnonymousClass4(this, r24, r11, r17));
        goto L29
    L44:
        r11.startViewTransition(r24);
        FragmentAnim.EndViewTransitionAnimation r26 = new FragmentAnim.EndViewTransitionAnimation(r25, r11, r24);
        r26.setAnimationListener(new DefaultSpecialEffectsController$4(this, r11, r24, r17));
        r24.startAnimation(r26);
        goto L45
    L38:
        if (FragmentManager.a(2) == false) goto L40;
        a("FragmentManager", "Ignoring Animation set on " + r19 + " as Animations cannot run alongside Animators.");
    L40:
        r17.d();
        goto L29
    L33:
        if (FragmentManager.a(2) == false) goto L35;
        a("FragmentManager", "Ignoring Animation set on " + r19 + " as Animations cannot run alongside Transitions.");
    L35:
        r17.d();
        goto L29
    }

    private Map<t.b, Boolean> a(List<c> r33, List<t.b> r34, final boolean r35, final t.b r36, final t.b r37) {
        b r6 = this;
        t.b r8 = r36;
        t.b r9 = r37;
        String r10 = "com.obric.aiagent.plugin";
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r33, List.class, "com.obric.aiagent.plugin");
        List r12 = (List) ZeusTransformUtils.wrapperContextForParams(r34, List.class, "com.obric.aiagent.plugin");
        HashMap r13 = new HashMap();
        Iterator r0 = r11.iterator();
        final p r15 = null;
    L4:
        if (r0.hasNext() == false) goto L17;
        c r1 = (c) ZeusTransformUtils.preCheckCast(r0.next(), c.class, "com.obric.aiagent.plugin");
        if (r1.c() == true) goto L4;
        p r2 = r1.i();
        if (r15 == null) goto L10;
        if (r2 == null) goto L4;
        if (r15 == r2) goto L4;
        throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + r1.a().e() + " returned Transition " + r1.e() + " which uses a different Transition  type than other Fragments.");
    L10:
        r15 = r2;
        goto L4
    L17:
        if (r15 != null) goto L23;
        Iterator r3 = r11.iterator();
    L20:
        if (r3.hasNext() == false) goto L22;
        c r4 = (c) ZeusTransformUtils.preCheckCast(r3.next(), c.class, "com.obric.aiagent.plugin");
        r13.put(r4.a(), false);
        r4.d();
        goto L20
    L22:
        return r13;
    L23:
        View r5 = new View((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(a().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        Rect r7 = new Rect();
        ArrayList<View> r14 = new ArrayList();
        ArrayList<View> r16 = new ArrayList();
        androidx.b.a r17 = new androidx.b.a();
        Iterator r23 = r11.iterator();
        boolean r24 = false;
        Object r18 = null;
        View r19 = null;
    L24:
        View r25 = r19;
        if (r23.hasNext() == false) goto L88;
        Rect r110 = r7;
        c r20 = (c) ZeusTransformUtils.preCheckCast(r23.next(), c.class, "com.obric.aiagent.plugin");
        if (r20.g() == false) goto L86;
        if (r8 == null) goto L86;
        if (r9 == null) goto L86;
        Object r111 = r15.c(r15.b(r20.h()));
        ArrayList<String> r21 = r37.e().getSharedElementSourceNames();
        ArrayList<String> r22 = r36.e().getSharedElementSourceNames();
        View r112 = r5;
        ArrayList<String> r26 = r36.e().getSharedElementTargetNames();
        List r27 = r11;
        List r28 = r12;
        int r113 = 0;
    L32:
        if (r113 >= r26.size()) goto L37;
        int r114 = r21.indexOf(r26.get(r113));
        ArrayList<String> r115 = r26;
        if (r114 == (-1)) goto L36;
        r21.set(r114, r22.get(r113));
    L36:
        r113 = r113 + 1;
        r26 = r115;
        goto L32
    L37:
        ArrayList<String> r116 = r37.e().getSharedElementTargetNames();
        if (r35 != 0) goto L40;
        androidx.core.app.q r29 = r36.e().getExitTransitionCallback();
        androidx.core.app.q r30 = r37.e().getEnterTransitionCallback();
    L41:
        int r117 = r21.size();
        int r31 = 0;
    L42:
        if (r31 >= r117) goto L44;
        r17.put((String) ZeusTransformUtils.preCheckCast(r21.get(r31), String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r116.get(r31), String.class, "com.obric.aiagent.plugin"));
        r31 = r31 + 1;
        r117 = r117;
        r13 = r13;
        goto L42
    L44:
        HashMap r210 = r13;
        androidx.b.a<String, View> r32 = new androidx.b.a();
        r6.a(r32, r36.e().mView);
        r32.a(r21);
        if (r29 == null) goto L55;
        r29.a(r21, r32);
        int r38 = r21.size() - 1;
    L47:
        if (r38 < 0) goto L56;
        String r39 = (String) ZeusTransformUtils.preCheckCast(r21.get(r38), String.class, "com.obric.aiagent.plugin");
        View r118 = (View) ZeusTransformUtils.preCheckCast(r32.get(r39), View.class, "com.obric.aiagent.plugin");
        if (r118 != null) goto L52;
        r17.remove(r39);
    L54:
        r38 = r38 - 1;
        goto L47
    L52:
        if (r39.equals(ViewCompat.s(r118)) == true) goto L54;
        r17.put(ViewCompat.s(r118), (String) ZeusTransformUtils.preCheckCast(r17.remove(r39), String.class, "com.obric.aiagent.plugin"));
    L56:
        final androidx.b.a<String, View> r40 = new androidx.b.a();
        r6.a(r40, r37.e().mView);
        r40.a(r116);
        r40.a(r17.values());
        if (r30 == null) goto L71;
        r30.a(r116, r40);
        int r41 = r116.size() - 1;
    L59:
        if (r41 < 0) goto L72;
        String r42 = (String) ZeusTransformUtils.preCheckCast(r116.get(r41), String.class, "com.obric.aiagent.plugin");
        View r119 = (View) ZeusTransformUtils.preCheckCast(r40.get(r42), View.class, "com.obric.aiagent.plugin");
        if (r119 != null) goto L66;
        String r43 = n.a(r17, r42);
        if (r43 == null) goto L70;
        r17.remove(r43);
    L70:
        r41 = r41 - 1;
        goto L59
    L66:
        if (r42.equals(ViewCompat.s(r119)) == true) goto L70;
        String r44 = n.a(r17, r42);
        if (r44 == null) goto L70;
        r17.put(r44, ViewCompat.s(r119));
    L72:
        r6.a(r32, r17.keySet());
        r6.a(r40, r17.values());
        if (r17.isEmpty() == false) goto L75;
        r14.clear();
        r16.clear();
        t.b r45 = r36;
        t.b r120 = r37;
        ArrayList<View> r46 = r16;
        ArrayList<View> r47 = r14;
        final b r48 = r6;
        final Rect r49 = r110;
        View r50 = r112;
        r19 = r25;
        HashMap r121 = r210;
        r18 = null;
    L87:
        r15 = r15;
        r7 = r49;
        r14 = r47;
        r8 = r45;
        r9 = r120;
        r11 = r27;
        r17 = r17;
        r6 = r48;
        r13 = r121;
        r12 = r28;
        r5 = r50;
        r16 = r46;
        goto L24
    L75:
        n.a(r37.e(), r36.e(), r35, r32, true);
        r47 = r14;
        r50 = r112;
        r46 = r16;
        OneShotPreDrawListener.add(a(), new AnonymousClass5(this, r37, r36, r35, r40));
        r47.addAll(r32.values());
        if (r21.isEmpty() == true) goto L78;
        View r51 = (View) ZeusTransformUtils.preCheckCast(r32.get((String) ZeusTransformUtils.preCheckCast(r21.get(0), String.class, "com.obric.aiagent.plugin")), View.class, "com.obric.aiagent.plugin");
        r15.a(r111, r51);
    L79:
        r46.addAll(r40.values());
        if (r116.isEmpty() == true) goto L84;
        final View r52 = (View) ZeusTransformUtils.preCheckCast(r40.get((String) ZeusTransformUtils.preCheckCast(r116.get(0), String.class, "com.obric.aiagent.plugin")), View.class, "com.obric.aiagent.plugin");
        if (r52 == null) goto L84;
        r48 = this;
        r49 = r110;
        OneShotPreDrawListener.add(a(), new AnonymousClass6(r48, r15, r52, r49));
        r24 = true;
    L85:
        r15.a(r111, r50, r47);
        r15.a(r111, null, null, null, null, r111, r46);
        r45 = r36;
        r121 = r210;
        r121.put(r45, true);
        r120 = r37;
        r121.put(r120, true);
        r18 = r111;
        r19 = r51;
    L84:
        r48 = this;
        r49 = r110;
        goto L85
    L78:
        r51 = r25;
        goto L79
    L71:
        n.a(r17, r40);
        goto L72
    L55:
        r17.a(r32.keySet());
        goto L56
    L40:
        r29 = r36.e().getEnterTransitionCallback();
        r30 = r37.e().getExitTransitionCallback();
    L86:
        r46 = r16;
        r50 = r5;
        r48 = r6;
        r27 = r11;
        r28 = r12;
        r121 = r13;
        r49 = r110;
        r120 = r9;
        r45 = r8;
        r47 = r14;
        r19 = r25;
        goto L87
    L88:
        androidx.b.a r211 = r17;
        ArrayList<View> r53 = r16;
        View r54 = r5;
        final b r55 = r6;
        List r212 = r11;
        List r213 = r12;
        HashMap r122 = r13;
        Rect r56 = r7;
        t.b r123 = r9;
        t.b r57 = r8;
        ArrayList<View> r58 = r14;
        p r59 = r15;
        ArrayList r60 = new ArrayList();
        Iterator r61 = r212.iterator();
        Object r124 = null;
        Object r125 = null;
    L90:
        if (r61.hasNext() == false) goto L130;
        r61 = r61;
        c r62 = (c) ZeusTransformUtils.preCheckCast(r61.next(), c.class, r10);
        if (r62.c() == false) goto L95;
        r122.put(r62.a(), false);
        r62.d();
        r125 = r125;
        goto L90
    L95:
        Object r310 = r125;
        Object r126 = r59.b(r62.e());
        t.b r127 = r62.a();
        if (r18 == null) goto L100;
        if (r127 == r57) goto L99;
        if (r127 != r123) goto L100;
    L99:
        boolean r128 = true;
    L101:
        if (r126 != null) goto L105;
        if (r128 == true) goto L104;
        r122.put(r127, false);
        r62.d();
    L104:
        r125 = r310;
        View r311 = r54;
        r58 = r58;
        String r214 = r10;
        View r63 = r25;
    L129:
        r123 = r37;
        r25 = r63;
        r58 = r58;
        r10 = r214;
        r54 = r311;
        goto L90
    L105:
        final ArrayList<View> r129 = new ArrayList();
        r214 = r10;
        r55.a(r129, r127.e().mView);
        if (r128 == false) goto L111;
        if (r127 != r57) goto L109;
        r129.removeAll(r58);
        goto L111
    L109:
        r129.removeAll(r53);
    L111:
        if (r129.isEmpty() == false) goto L113;
        r59.b(r126, r54);
        Object r130 = r310;
        r311 = r54;
    L119:
        if (r127.c() != t.b.EnumC0056b.f1905b) goto L124;
        r60.addAll(r129);
        if (r24 == false) goto L123;
        r59.a(r126, r56);
    L123:
        r63 = r25;
    L125:
        r122.put(r127, true);
        if (r62.f() == false) goto L128;
        r125 = r130;
        r124 = r59.a(r124, r126, null);
        goto L129
    L128:
        r125 = r59.a(r130, r126, null);
        goto L129
    L124:
        r63 = r25;
        r59.a(r126, r63);
        goto L125
    L113:
        r59.a(r126, r129);
        r130 = r310;
        r59.a(r126, r126, r129, null, null, null, null);
        r311 = r54;
        if (r127.c() != t.b.EnumC0056b.f1906c) goto L116;
        r127 = r127;
        r213.remove(r127);
        ArrayList<View> r64 = new ArrayList(r129);
        r64.remove(r127.e().mView);
        r59.b(r126, r127.e().mView, r64);
        OneShotPreDrawListener.add(a(), new AnonymousClass7(r55, r129));
        goto L119
    L116:
        r127 = r127;
    L100:
        r128 = false;
        goto L101
    L130:
        ArrayList<View> r131 = r58;
        String r215 = r10;
        Object r65 = r59.b(r124, r125, r18);
        Iterator r66 = r212.iterator();
    L132:
        if (r66.hasNext() == false) goto L152;
        String r132 = r215;
        final c r67 = (c) ZeusTransformUtils.preCheckCast(r66.next(), c.class, r132);
        if (r67.c() == true) goto L135;
        Object r133 = r67.e();
        t.b r134 = r67.a();
        if (r18 == null) goto L141;
        if (r134 == r57) goto L140;
        if (r134 != r37) goto L141;
    L140:
        boolean r135 = true;
    L142:
        if (r133 != null) goto L145;
        if (r135 == false) goto L135;
    L145:
        if (ViewCompat.F(a()) == false) goto L147;
        r59.a(r67.a().e(), r65, r67.b(), new AnonymousClass8(r55, r67));
        goto L135
    L147:
        if (FragmentManager.a(2) == false) goto L149;
        a("FragmentManager", "SpecialEffectsController: Container " + a() + " has not been laid out. Completing operation " + r134);
    L149:
        r67.d();
    L141:
        r135 = false;
    L135:
        r215 = r132;
        goto L132
    L152:
        if (ViewCompat.F(a()) == true) goto L154;
        return r122;
    L154:
        n.a(r60, 4);
        ArrayList<String> r68 = r59.a(r53);
        r59.a(a(), r65);
        r59.a(a(), r131, r53, r68, r211);
        n.a(r60, 0);
        r59.a(r18, r131, r53);
        return r122;
    }

    void a(androidx.b.a<String, View> r3, Collection<String> r4) {
        Collection r2 = (Collection) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.aiagent.plugin");
        Iterator<Map.Entry<String, View>> r5 = r3.entrySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        if (r2.contains(ViewCompat.s((View) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r5.next(), Map.Entry.class, "com.obric.aiagent.plugin")).getValue(), View.class, "com.obric.aiagent.plugin"))) == true) goto L4;
        r5.remove();
        goto L4
    }

    void a(ArrayList<View> r5, View r6) {
        if (ZeusTransformUtils.instanceOf(r6, ViewGroup.class) == false) goto L16;
        ViewGroup r0 = (ViewGroup) ZeusTransformUtils.preCheckCast(r6, ViewGroup.class, "com.obric.aiagent.plugin");
        if (aa.a(r0) == true) goto L7;
        int r7 = r0.getChildCount();
        int r1 = 0;
    L10:
        if (r1 >= r7) goto L25;
        View r2 = r0.getChildAt(r1);
        if (r2.getVisibility() != 0) goto L14;
        a(r5, r2);
    L14:
        r1 = r1 + 1;
        goto L10
    L25:
        return;
    L7:
        if (r5.contains(r6) == true) goto L22;
        r5.add(r0);
        return;
    L22:
        return;
    L16:
        if (r5.contains(r6) == true) goto L24;
        r5.add(r6);
        return;
    }

    void a(Map<String, View> r5, View r6) {
        Map<String, View> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        String r0 = ViewCompat.s(r6);
        if (r0 == null) goto L6;
        r7.put(r0, r6);
    L6:
        if (ZeusTransformUtils.instanceOf(r6, ViewGroup.class) == false) goto L13;
        ViewGroup r8 = (ViewGroup) ZeusTransformUtils.preCheckCast(r6, ViewGroup.class, "com.obric.aiagent.plugin");
        int r1 = r8.getChildCount();
        int r2 = 0;
    L8:
        if (r2 >= r1) goto L17;
        View r3 = r8.getChildAt(r2);
        if (r3.getVisibility() != 0) goto L12;
        a(r7, r3);
    L12:
        r2 = r2 + 1;
        goto L8
    L17:
        return;
    }

    void a(t.b r1) {
        View r0 = r1.e().mView;
        r1.c().b(r0);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.v(r1, r2);
    }
}
