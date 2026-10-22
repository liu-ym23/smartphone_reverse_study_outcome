package androidx.fragment.app;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: FragmentTransition.java */
/* JADX INFO: loaded from: classes.dex */
class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final p f1833a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final p f1834b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int[] f1835c = null;

    /* JADX INFO: compiled from: FragmentTransition.java */
    interface a {
        void a(Fragment r1, androidx.core.os.f r2);

        void b(Fragment r1, androidx.core.os.f r2);
    }

    /* JADX INFO: compiled from: FragmentTransition.java */
    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Fragment f1858a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f1859b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public androidx.fragment.app.a f1860c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Fragment f1861d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f1862e;
        public androidx.fragment.app.a f;

        b() {
        }
    }

    static {
        f1835c = new int[]{0, 3, 0, 1, 5, 4, 7, 6, 9, 8, 10};
        if (Build.VERSION.SDK_INT < 21) goto L5;
        o r0 = new o();
    L6:
        f1833a = r0;
        f1834b = a();
        return;
    L5:
        r0 = null;
        goto L6
    }

    private static p a() {
        return (p) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.forName("androidx.transition.FragmentTransitionSupport", "com.obric.aiagent.plugin").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]), p.class, "com.obric.aiagent.plugin");
    L5:
        return null;
    }

    static void a(Context r8, c r9, ArrayList<androidx.fragment.app.a> r10, ArrayList<Boolean> r11, int r12, int r13, boolean r14, a r15) {
        Context r16 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
        a r17 = (a) ZeusTransformUtils.wrapperContextForParams(r15, a.class, "com.obric.aiagent.plugin");
        SparseArray r0 = new SparseArray();
        int r2 = r12;
    L3:
        if (r2 >= r13) goto L10;
        androidx.fragment.app.a r3 = (androidx.fragment.app.a) ZeusTransformUtils.preCheckCast(r10.get(r2), androidx.fragment.app.a.class, "com.obric.aiagent.plugin");
        if (((Boolean) ZeusTransformUtils.preCheckCast(r11.get(r2), Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == false) goto L7;
        b(r3, r0, r14);
    L8:
        r2 = r2 + 1;
        goto L3
    L7:
        a(r3, r0, r14);
        goto L8
    L10:
        if (r0.size() == 0) goto L22;
        View r4 = new View(r16);
        int r18 = r0.size();
        int r5 = 0;
    L12:
        if (r5 >= r18) goto L31;
        int r6 = r0.keyAt(r5);
        androidx.b.a<String, String> r7 = a(r6, r10, r11, r12, r13);
        b r19 = (b) ZeusTransformUtils.preCheckCast(r0.valueAt(r5), b.class, "com.obric.aiagent.plugin");
        if (r9.a() == false) goto L21;
        ViewGroup r20 = (ViewGroup) ZeusTransformUtils.preCheckCast(r9.a(r6), ViewGroup.class, "com.obric.aiagent.plugin");
        if (r20 == null) goto L21;
        if (r14 == false) goto L20;
        a(r20, r19, r4, r7, r17);
        goto L21
    L20:
        b(r20, r19, r4, r7, r17);
    L21:
        r5 = r5 + 1;
        goto L12
    L31:
        return;
    }

    private static androidx.b.a<String, String> a(int r11, ArrayList<androidx.fragment.app.a> r12, ArrayList<Boolean> r13, int r14, int r15) {
        androidx.b.a<String, String> r0 = new androidx.b.a();
        int r16 = r15 - 1;
    L3:
        if (r16 < r14) goto L21;
        androidx.fragment.app.a r1 = (androidx.fragment.app.a) ZeusTransformUtils.preCheckCast(r12.get(r16), androidx.fragment.app.a.class, "com.obric.aiagent.plugin");
        if (r1.b(r11) == false) goto L20;
        boolean r2 = ((Boolean) ZeusTransformUtils.preCheckCast(r13.get(r16), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
        if (r1.q == null) goto L20;
        int r4 = r1.q.size();
        if (r2 == false) goto L12;
        ArrayList<String> r3 = r1.q;
        ArrayList<String> r5 = r1.r;
    L13:
        int r6 = 0;
    L14:
        if (r6 >= r4) goto L20;
        String r7 = (String) ZeusTransformUtils.preCheckCast(r5.get(r6), String.class, "com.obric.aiagent.plugin");
        String r8 = (String) ZeusTransformUtils.preCheckCast(r3.get(r6), String.class, "com.obric.aiagent.plugin");
        String r9 = (String) ZeusTransformUtils.preCheckCast(r0.remove(r8), String.class, "com.obric.aiagent.plugin");
        if (r9 == null) goto L18;
        r0.put(r7, r9);
    L19:
        r6 = r6 + 1;
        goto L14
    L18:
        r0.put(r7, r8);
        goto L19
    L12:
        ArrayList<String> r10 = r1.q;
        r3 = r1.r;
        r5 = r10;
    L20:
        r16 = r16 - 1;
        goto L3
    L21:
        return r0;
    }

    private static void a(ViewGroup r17, b r18, View r19, androidx.b.a<String, String> r20, a r21) {
        final a r10 = (a) ZeusTransformUtils.wrapperContextForParams(r21, a.class, "com.obric.aiagent.plugin");
        Fragment r11 = r18.f1858a;
        final Fragment r12 = r18.f1861d;
        p r13 = a(r12, r11);
        if (r13 != null) goto L5;
        return;
    L5:
        boolean r14 = r18.f1859b;
        boolean r0 = r18.f1862e;
        ArrayList<View> r15 = new ArrayList();
        ArrayList<View> r8 = new ArrayList();
        Object r7 = a(r13, r11, r14);
        Object r6 = b(r13, r12, r0);
        Object r9 = a(r13, r17, r19, r20, r18, r8, r15, r7, r6);
        if (r7 != null) goto L11;
        if (r9 != null) goto L11;
        Object r16 = r6;
        if (r16 != null) goto L12;
        return;
    L12:
        ArrayList<View> r5 = a(r13, r16, r12, r8, r19);
        ArrayList<View> r22 = a(r13, r7, r11, r15, r19);
        a(r22, 4);
        Object r110 = a(r13, r7, r16, r9, r11, r14);
        if (r12 == null) goto L20;
        if (r5 == null) goto L20;
        if (r5.size() <= 0) goto L18;
    L19:
        final androidx.core.os.f r1 = new androidx.core.os.f();
        r10.a(r12, r1);
        r13.a(r12, r110, r1, new AnonymousClass1(r10, r12, r1));
        goto L20
    L18:
        if (r8.size() > 0) goto L19;
    L20:
        if (r110 == null) goto L23;
        a(r13, r16, r12, r5);
        ArrayList<String> r111 = r13.a(r15);
        r13.a(r110, r7, r22, r16, r5, r9, r15);
        r13.a(r17, r110);
        r13.a(r17, r8, r15, r111, r20);
        a(r22, 0);
        r13.a(r9, r8, r15);
        return;
    L23:
        return;
    L11:
        r16 = r6;
        goto L12
    }

    private static void a(p r1, Object r2, Fragment r3, final ArrayList<View> r4) {
        if (r3 == null) goto L12;
        if (r2 != null) goto L5;
        return;
    L5:
        if (r3.mAdded == true) goto L7;
        return;
    L7:
        if (r3.mHidden == true) goto L9;
        return;
    L9:
        if (r3.mHiddenChanged == false) goto L16;
        r3.setHideReplaced(true);
        r1.b(r2, r3.getView(), r4);
        OneShotPreDrawListener.add(r3.mContainer, new AnonymousClass2(r4));
        return;
    L16:
        return;
    }

    private static void b(ViewGroup r19, b r20, View r21, androidx.b.a<String, String> r22, a r23) {
        final a r13 = (a) ZeusTransformUtils.wrapperContextForParams(r23, a.class, "com.obric.aiagent.plugin");
        Fragment r14 = r20.f1858a;
        final Fragment r15 = r20.f1861d;
        p r8 = a(r15, r14);
        if (r8 != null) goto L5;
        return;
    L5:
        boolean r0 = r20.f1859b;
        boolean r1 = r20.f1862e;
        Object r7 = a(r8, r14, r0);
        Object r6 = b(r8, r15, r1);
        ArrayList r5 = new ArrayList();
        ArrayList<View> r4 = new ArrayList();
        Object r9 = b(r8, r19, r21, r22, r20, r5, r4, r7, r6);
        if (r7 != null) goto L11;
        if (r9 != null) goto L11;
        Object r2 = r6;
        if (r2 != null) goto L12;
        return;
    L12:
        ArrayList<View> r16 = a(r8, r2, r15, r5, r21);
        if (r16 != null) goto L15;
    L16:
        r2 = null;
    L17:
        Object r17 = r2;
        r8.b(r7, r21);
        Object r10 = a(r8, r7, r17, r9, r14, r20.f1859b);
        if (r15 == null) goto L25;
        if (r16 == null) goto L25;
        if (r16.size() <= 0) goto L23;
    L24:
        final androidx.core.os.f r3 = new androidx.core.os.f();
        r13.a(r15, r3);
        r8.a(r15, r10, r3, new AnonymousClass3(r13, r15, r3));
        goto L25
    L23:
        if (r5.size() > 0) goto L24;
    L25:
        if (r10 == null) goto L28;
        ArrayList<View> r18 = new ArrayList();
        r8.a(r10, r7, r18, r17, r16, r9, r4);
        a(r8, r19, r14, r21, r4, r7, r18, r17, r16);
        r8.a(r19, r4, r22);
        r8.a(r19, r10);
        r8.a(r19, r4, r22);
        return;
    L28:
        return;
    L15:
        if (r16.isEmpty() == false) goto L17;
    L11:
        r2 = r6;
        goto L12
    }

    private static void a(final p r10, ViewGroup r11, final Fragment r12, final View r13, final ArrayList<View> r14, final Object r15, final ArrayList<View> r16, final Object r17, final ArrayList<View> r18) {
        OneShotPreDrawListener.add(r11, new AnonymousClass4(r15, r10, r13, r12, r14, r16, r18, r17));
    }

    private static p a(Fragment r2, Fragment r3) {
        ArrayList r0 = new ArrayList();
        if (r2 == null) goto L13;
        Object r1 = r2.getExitTransition();
        if (r1 == null) goto L7;
        r0.add(r1);
    L7:
        Object r4 = r2.getReturnTransition();
        if (r4 == null) goto L10;
        r0.add(r4);
    L10:
        Object r5 = r2.getSharedElementReturnTransition();
        if (r5 == null) goto L13;
        r0.add(r5);
    L13:
        if (r3 == null) goto L24;
        Object r6 = r3.getEnterTransition();
        if (r6 == null) goto L17;
        r0.add(r6);
    L17:
        Object r7 = r3.getReenterTransition();
        if (r7 == null) goto L20;
        r0.add(r7);
    L20:
        Object r8 = r3.getSharedElementEnterTransition();
        if (r8 == null) goto L24;
        r0.add(r8);
    L24:
        if (r0.isEmpty() == false) goto L26;
        return null;
    L26:
        p r9 = f1833a;
        if (r9 != null) goto L29;
    L31:
        p r10 = f1834b;
        if (r10 != null) goto L34;
    L36:
        if (r9 != null) goto L40;
        if (r10 != null) goto L40;
        return null;
    L40:
        throw new IllegalArgumentException("Invalid Transition types");
    L34:
        if (a(r10, r0) == false) goto L36;
        return r10;
    L29:
        if (a(r9, r0) == false) goto L31;
        return r9;
    }

    private static boolean a(p r4, List<Object> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        int r0 = r6.size();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L8;
        if (r4.a(r6.get(r2)) == false) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return false;
    L8:
        return true;
    }

    private static Object a(p r0, Fragment r1, Fragment r2, boolean r3) {
        if (r1 == null) goto L10;
        if (r2 == null) goto L12;
        if (r3 == false) goto L7;
        Object r4 = r2.getSharedElementReturnTransition();
    L9:
        return r0.c(r0.b(r4));
    L7:
        r4 = r1.getSharedElementEnterTransition();
        goto L9
    L12:
        return null;
    L10:
        return null;
    }

    private static Object a(p r0, Fragment r1, boolean r2) {
        if (r1 != null) goto L5;
        return null;
    L5:
        if (r2 == false) goto L7;
        Object r3 = r1.getReenterTransition();
    L9:
        return r0.b(r3);
    L7:
        r3 = r1.getEnterTransition();
        goto L9
    }

    private static Object b(p r0, Fragment r1, boolean r2) {
        if (r1 != null) goto L5;
        return null;
    L5:
        if (r2 == false) goto L7;
        Object r3 = r1.getReturnTransition();
    L9:
        return r0.b(r3);
    L7:
        r3 = r1.getExitTransition();
        goto L9
    }

    private static Object a(final p r15, ViewGroup r16, View r17, androidx.b.a<String, String> r18, b r19, ArrayList<View> r20, ArrayList<View> r21, Object r22, Object r23) {
        final Fragment r9 = r19.f1858a;
        final Fragment r10 = r19.f1861d;
        if (r9 == null) goto L6;
        r9.requireView().setVisibility(0);
    L6:
        if (r9 == null) goto L34;
        if (r10 == null) goto L34;
        final boolean r11 = r19.f1859b;
        if (r18.isEmpty() == false) goto L12;
        Object r5 = null;
    L13:
        androidx.b.a<String, View> r12 = b(r15, r18, r5, r19);
        final androidx.b.a<String, View> r13 = a(r15, r18, r5, r19);
        if (r18.isEmpty() == false) goto L20;
        if (r12 == null) goto L17;
        r12.clear();
    L17:
        if (r13 == null) goto L19;
        r13.clear();
    L19:
        Object r14 = null;
    L21:
        if (r22 != null) goto L25;
        if (r23 != null) goto L25;
        if (r14 != null) goto L25;
        return null;
    L25:
        a(r9, r10, r11, r12, true);
        if (r14 == null) goto L31;
        r21.add(r17);
        r15.a(r14, r17, r20);
        a(r15, r14, r23, r12, r19.f1862e, r19.f);
        Rect r0 = new Rect();
        View r1 = a(r13, r19, r22, r11);
        if (r1 == null) goto L30;
        r15.a(r22, r0);
    L30:
        final Rect r7 = r0;
        final View r6 = r1;
    L32:
        OneShotPreDrawListener.add(r16, new AnonymousClass5(r9, r10, r11, r13, r6, r15, r7));
        return r14;
    L31:
        r6 = null;
        r7 = null;
        goto L32
    L20:
        a(r20, r12, r18.keySet());
        a(r21, r13, r18.values());
        r14 = r5;
        goto L21
    L12:
        r5 = a(r15, r9, r10, r11);
    L34:
        return null;
    }

    private static void a(ArrayList<View> r4, androidx.b.a<String, View> r5, Collection<String> r6) {
        Collection r7 = (Collection) ZeusTransformUtils.wrapperContextForParams(r6, Collection.class, "com.obric.aiagent.plugin");
        int r0 = r5.size() - 1;
    L3:
        if (r0 < 0) goto L8;
        View r2 = (View) ZeusTransformUtils.preCheckCast(r5.c(r0), View.class, "com.obric.aiagent.plugin");
        if (r7.contains(ViewCompat.s(r2)) == false) goto L7;
        r4.add(r2);
    L7:
        r0 = r0 - 1;
        goto L3
    }

    private static Object b(final p r17, ViewGroup r18, final View r19, final androidx.b.a<String, String> r20, final b r21, final ArrayList<View> r22, final ArrayList<View> r23, final Object r24, Object r25) {
        final Fragment r8 = r21.f1858a;
        final Fragment r9 = r21.f1861d;
        if (r8 == null) goto L26;
        if (r9 == null) goto L26;
        final boolean r12 = r21.f1859b;
        if (r20.isEmpty() == false) goto L9;
        Object r1 = null;
    L10:
        androidx.b.a<String, View> r3 = b(r17, r20, r1, r21);
        if (r20.isEmpty() == false) goto L13;
        Object r14 = null;
    L14:
        if (r24 != null) goto L18;
        if (r25 != null) goto L18;
        if (r14 != null) goto L18;
        return null;
    L18:
        a(r8, r9, r12, r3, true);
        if (r14 == null) goto L23;
        Rect r15 = new Rect();
        r17.a(r14, r19, r22);
        a(r17, r14, r25, r3, r21.f1862e, r21.f);
        if (r24 == null) goto L24;
        r17.a(r24, r15);
    L24:
        final Object r4 = r14;
        final Rect r13 = r15;
        OneShotPreDrawListener.add(r18, new AnonymousClass6(r17, r20, r4, r21, r23, r19, r8, r9, r12, r22, r24, r13));
        return r14;
    L23:
        r15 = null;
        goto L24
    L13:
        r22.addAll(r3.values());
        r14 = r1;
        goto L14
    L9:
        r1 = a(r17, r8, r9, r12);
    L26:
        return null;
    }

    private static androidx.b.a<String, View> b(p r4, androidx.b.a<String, String> r5, Object r6, b r7) {
        if (r5.isEmpty() == true) goto L24;
        if (r6 == null) goto L24;
        Fragment r8 = r7.f1861d;
        androidx.b.a<String, View> r0 = new androidx.b.a();
        r4.a(r0, r8.requireView());
        androidx.fragment.app.a r9 = r7.f;
        if (r7.f1862e == false) goto L9;
        androidx.core.app.q r10 = r8.getEnterTransitionCallback();
        ArrayList<String> r11 = r9.r;
    L10:
        if (r11 == null) goto L12;
        r0.a(r11);
    L12:
        if (r10 == null) goto L22;
        r10.a(r11, r0);
        int r12 = r11.size() - 1;
    L14:
        if (r12 < 0) goto L23;
        String r13 = (String) ZeusTransformUtils.preCheckCast(r11.get(r12), String.class, "com.obric.aiagent.plugin");
        View r1 = (View) ZeusTransformUtils.preCheckCast(r0.get(r13), View.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L19;
        r5.remove(r13);
    L21:
        r12 = r12 - 1;
        goto L14
    L19:
        if (r13.equals(ViewCompat.s(r1)) == true) goto L21;
        r5.put(ViewCompat.s(r1), (String) ZeusTransformUtils.preCheckCast(r5.remove(r13), String.class, "com.obric.aiagent.plugin"));
    L23:
        return r0;
    L22:
        r5.a(r0.keySet());
        goto L23
    L9:
        r10 = r8.getExitTransitionCallback();
        r11 = r9.q;
    L24:
        r5.clear();
        return null;
    }

    static androidx.b.a<String, View> a(p r4, androidx.b.a<String, String> r5, Object r6, b r7) {
        Fragment r0 = r7.f1858a;
        View r1 = r0.getView();
        if (r5.isEmpty() == true) goto L29;
        if (r6 == null) goto L29;
        if (r1 == null) goto L29;
        androidx.b.a<String, View> r8 = new androidx.b.a();
        r4.a(r8, r1);
        androidx.fragment.app.a r9 = r7.f1860c;
        if (r7.f1859b == false) goto L10;
        androidx.core.app.q r10 = r0.getExitTransitionCallback();
        ArrayList<String> r11 = r9.q;
    L11:
        if (r11 == null) goto L13;
        r8.a(r11);
        r8.a(r5.values());
    L13:
        if (r10 == null) goto L27;
        r10.a(r11, r8);
        int r12 = r11.size() - 1;
    L15:
        if (r12 < 0) goto L28;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r11.get(r12), String.class, "com.obric.aiagent.plugin");
        View r3 = (View) ZeusTransformUtils.preCheckCast(r8.get(r2), View.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L22;
        String r13 = a(r5, r2);
        if (r13 == null) goto L26;
        r5.remove(r13);
    L26:
        r12 = r12 - 1;
        goto L15
    L22:
        if (r2.equals(ViewCompat.s(r3)) == true) goto L26;
        String r14 = a(r5, r2);
        if (r14 == null) goto L26;
        r5.put(r14, ViewCompat.s(r3));
    L28:
        return r8;
    L27:
        a(r5, r8);
        goto L28
    L10:
        r10 = r0.getEnterTransitionCallback();
        r11 = r9.r;
    L29:
        r5.clear();
        return null;
    }

    static String a(androidx.b.a<String, String> r3, String r4) {
        int r0 = r3.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L9;
        if (r4.equals(r3.c(r1)) == true) goto L7;
        r1 = r1 + 1;
        goto L3
    L7:
        return (String) ZeusTransformUtils.preCheckCast(r3.b(r1), String.class, "com.obric.aiagent.plugin");
    L9:
        return null;
    }

    static View a(androidx.b.a<String, View> r1, b r2, Object r3, boolean r4) {
        androidx.fragment.app.a r5 = r2.f1860c;
        if (r3 == null) goto L15;
        if (r1 != null) goto L6;
        return null;
    L6:
        if (r5.q != null) goto L8;
        return null;
    L8:
        if (r5.q.isEmpty() == false) goto L10;
        return null;
    L10:
        if (r4 == false) goto L12;
        String r6 = (String) ZeusTransformUtils.preCheckCast(r5.q.get(0), String.class, "com.obric.aiagent.plugin");
    L14:
        return (View) ZeusTransformUtils.preCheckCast(r1.get(r6), View.class, "com.obric.aiagent.plugin");
    L12:
        r6 = (String) ZeusTransformUtils.preCheckCast(r5.r.get(0), String.class, "com.obric.aiagent.plugin");
        goto L14
    L15:
        return null;
    }

    private static void a(p r2, Object r3, Object r4, androidx.b.a<String, View> r5, boolean r6, androidx.fragment.app.a r7) {
        if (r7.q != null) goto L5;
        return;
    L5:
        if (r7.q.isEmpty() == false) goto L7;
        return;
    L7:
        if (r6 == false) goto L9;
        String r8 = (String) ZeusTransformUtils.preCheckCast(r7.r.get(0), String.class, "com.obric.aiagent.plugin");
    L10:
        View r9 = (View) ZeusTransformUtils.preCheckCast(r5.get(r8), View.class, "com.obric.aiagent.plugin");
        r2.a(r3, r9);
        if (r4 == null) goto L16;
        r2.a(r4, r9);
        return;
    L16:
        return;
    L9:
        r8 = (String) ZeusTransformUtils.preCheckCast(r7.q.get(0), String.class, "com.obric.aiagent.plugin");
        goto L10
    }

    static void a(androidx.b.a<String, String> r4, androidx.b.a<String, View> r5) {
        int r0 = r4.size() - 1;
    L3:
        if (r0 < 0) goto L8;
        if (r5.containsKey((String) ZeusTransformUtils.preCheckCast(r4.c(r0), String.class, "com.obric.aiagent.plugin")) == true) goto L7;
        r4.d(r0);
    L7:
        r0 = r0 - 1;
        goto L3
    }

    static void a(Fragment r3, Fragment r4, boolean r5, androidx.b.a<String, View> r6, boolean r7) {
        if (r5 == false) goto L4;
        androidx.core.app.q r8 = r4.getEnterTransitionCallback();
    L5:
        if (r8 == null) goto L19;
        ArrayList r9 = new ArrayList();
        ArrayList r10 = new ArrayList();
        int r0 = 0;
        if (r6 != null) goto L9;
        int r1 = 0;
    L10:
        if (r0 >= r1) goto L13;
        r10.add(r6.b(r0));
        r9.add(r6.c(r0));
        r0 = r0 + 1;
        goto L10
    L13:
        if (r7 == false) goto L15;
        r8.a(r10, r9, null);
        return;
    L15:
        r8.b(r10, r9, null);
        return;
    L9:
        r1 = r6.size();
        goto L10
    L19:
        return;
    L4:
        r8 = r3.getEnterTransitionCallback();
        goto L5
    }

    static ArrayList<View> a(p r1, Object r2, Fragment r3, ArrayList<View> r4, View r5) {
        if (r2 == null) goto L11;
        ArrayList<View> r0 = new ArrayList();
        View r6 = r3.getView();
        if (r6 == null) goto L6;
        r1.a(r0, r6);
    L6:
        if (r4 == null) goto L9;
        r0.removeAll(r4);
    L9:
        if (r0.isEmpty() == true) goto L13;
        r0.add(r5);
        r1.a(r2, r0);
        return r0;
    L13:
        return r0;
    L11:
        return null;
    }

    static void a(ArrayList<View> r4, int r5) {
        if (r4 != null) goto L4;
        return;
    L4:
        int r0 = r4.size() - 1;
    L5:
        if (r0 < 0) goto L7;
        ((View) ZeusTransformUtils.preCheckCast(r4.get(r0), View.class, "com.obric.aiagent.plugin")).setVisibility(r5);
        r0 = r0 - 1;
        goto L5
    }

    private static Object a(p r0, Object r1, Object r2, Object r3, Fragment r4, boolean r5) {
        if (r1 == null) goto L8;
        if (r2 == null) goto L8;
        if (r4 == null) goto L8;
        if (r5 == false) goto L7;
        boolean r6 = r4.getAllowReturnTransitionOverlap();
    L9:
        if (r6 == false) goto L12;
        return r0.a(r2, r1, r3);
    L12:
        return r0.b(r2, r1, r3);
    L7:
        r6 = r4.getAllowEnterTransitionOverlap();
    L8:
        r6 = true;
        goto L9
    }

    public static void a(androidx.fragment.app.a r6, SparseArray<b> r7, boolean r8) {
        int r0 = r6.f1826d.size();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        a(r6, (m.a) ZeusTransformUtils.preCheckCast(r6.f1826d.get(r2), m.a.class, "com.obric.aiagent.plugin"), r7, false, r8);
        r2 = r2 + 1;
        goto L3
    }

    public static void b(androidx.fragment.app.a r5, SparseArray<b> r6, boolean r7) {
        if (r5.f1766a.n().a() == true) goto L5;
        return;
    L5:
        int r0 = r5.f1826d.size() - 1;
    L6:
        if (r0 < 0) goto L8;
        a(r5, (m.a) ZeusTransformUtils.preCheckCast(r5.f1826d.get(r0), m.a.class, "com.obric.aiagent.plugin"), r6, true, r7);
        r0 = r0 - 1;
        goto L6
    }

    private static void a(androidx.fragment.app.a r8, m.a r9, SparseArray<b> r10, boolean r11, boolean r12) {
        Fragment r0 = r9.f1829b;
        if (r0 != null) goto L5;
        return;
    L5:
        int r1 = r0.mContainerId;
        if (r1 != 0) goto L8;
        return;
    L8:
        if (r11 == false) goto L10;
        int r13 = f1835c[r9.f1828a];
    L11:
        boolean r2 = false;
        boolean r3 = true;
        if (r13 != 1) goto L14;
    L63:
        if (r12 == false) goto L66;
        boolean r14 = r0.mIsNewlyAdded;
    L71:
        boolean r4 = false;
        r2 = r14;
        boolean r15 = false;
    L72:
        b r5 = (b) ZeusTransformUtils.preCheckCast(r10.get(r1), b.class, "com.obric.aiagent.plugin");
        if (r2 == false) goto L76;
        r5 = a(r5, r10, r1);
        r5.f1858a = r0;
        r5.f1859b = r11;
        r5.f1860c = r8;
    L76:
        if (r12 == true) goto L85;
        if (r3 == false) goto L85;
        if (r5 == null) goto L83;
        if (r5.f1861d != r0) goto L83;
        r5.f1861d = null;
    L83:
        if (r8.s == true) goto L85;
        FragmentManager r6 = r8.f1766a;
        r6.o().a(r6.i(r0));
        r6.g(r0);
    L85:
        if (r4 == false) goto L90;
        if (r5 != null) goto L88;
    L89:
        r5 = a(r5, r10, r1);
        r5.f1861d = r0;
        r5.f1862e = r11;
        r5.f = r8;
        goto L90
    L88:
        if (r5.f1861d == null) goto L89;
    L90:
        if (r12 == true) goto L97;
        if (r15 == false) goto L98;
        if (r5 != null) goto L94;
        return;
    L94:
        if (r5.f1858a != r0) goto L100;
        r5.f1858a = null;
        return;
    L100:
        return;
    L98:
        return;
    L97:
        return;
    L66:
        if (r0.mAdded == false) goto L68;
    L70:
        r14 = false;
        goto L71
    L68:
        if (r0.mHidden == true) goto L70;
    L69:
        r14 = true;
        goto L71
    L14:
        if (r13 != 3) goto L16;
    L46:
        if (r12 == false) goto L58;
        if (r0.mAdded == false) goto L50;
    L56:
        boolean r16 = false;
    L62:
        r4 = r16;
        r15 = true;
        r3 = false;
        goto L72
    L50:
        if (r0.mView == null) goto L56;
        if (r0.mView.getVisibility() != 0) goto L56;
        if (r0.mPostponedAlpha < 0.0f) goto L56;
    L55:
        r16 = true;
        goto L62
    L58:
        if (r0.mAdded == false) goto L56;
        if (r0.mHidden == true) goto L56;
    L16:
        if (r13 != 4) goto L18;
        if (r12 == false) goto L42;
        if (r0.mHiddenChanged == false) goto L56;
        if (r0.mAdded == false) goto L56;
        if (r0.mHidden == false) goto L56;
    L42:
        if (r0.mAdded == false) goto L56;
        if (r0.mHidden == true) goto L56;
    L18:
        if (r13 != 5) goto L20;
        if (r12 == true) goto L26;
        r14 = r0.mHidden;
        goto L71
    L26:
        if (r0.mHiddenChanged == false) goto L70;
        if (r0.mHidden == true) goto L70;
        if (r0.mAdded == false) goto L70;
    L20:
        if (r13 == 6) goto L46;
        if (r13 == 7) goto L63;
        r15 = false;
        r3 = false;
        r4 = false;
        goto L72
    L10:
        r13 = r9.f1828a;
        goto L11
    }

    private static b a(b r0, SparseArray<b> r1, int r2) {
        if (r0 != null) goto L5;
        b r3 = new b();
        r1.put(r2, r3);
        return r3;
    L5:
        return r0;
    }
}
