package androidx.fragment.app;

import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.aa;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: FragmentTransitionImpl.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class p {
    public abstract Object a(Object r1, Object r2, Object r3);

    public abstract void a(ViewGroup r1, Object r2);

    public abstract void a(Object r1, Rect r2);

    public abstract void a(Object r1, View r2);

    public abstract void a(Object r1, View r2, ArrayList<View> r3);

    public abstract void a(Object r1, Object r2, ArrayList<View> r3, Object r4, ArrayList<View> r5, Object r6, ArrayList<View> r7);

    public abstract void a(Object r1, ArrayList<View> r2);

    public abstract void a(Object r1, ArrayList<View> r2, ArrayList<View> r3);

    public abstract boolean a(Object r1);

    public abstract Object b(Object r1);

    public abstract Object b(Object r1, Object r2, Object r3);

    public abstract void b(Object r1, View r2);

    public abstract void b(Object r1, View r2, ArrayList<View> r3);

    public abstract void b(Object r1, ArrayList<View> r2, ArrayList<View> r3);

    public abstract Object c(Object r1);

    public abstract void c(Object r1, View r2);

    public p() {
    }

    public void a(View r4, Rect r5) {
        if (ViewCompat.I(r4) == true) goto L5;
        return;
    L5:
        RectF r3 = new RectF();
        r3.set(0.0f, 0.0f, r4.getWidth(), r4.getHeight());
        r4.getMatrix().mapRect(r3);
        r3.offset(r4.getLeft(), r4.getTop());
        ViewParent r0 = r4.getParent();
    L7:
        if (ZeusTransformUtils.instanceOf(r0, View.class) == false) goto L9;
        View r1 = (View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.aiagent.plugin");
        r3.offset(-r1.getScrollX(), -r1.getScrollY());
        r1.getMatrix().mapRect(r3);
        r3.offset(r1.getLeft(), r1.getTop());
        r0 = r1.getParent();
        goto L7
    L9:
        int[] r2 = new int[2];
        r4.getRootView().getLocationOnScreen(r2);
        r3.offset(r2[0], r2[1]);
        r5.set(Math.round(r3.left), Math.round(r3.top), Math.round(r3.right), Math.round(r3.bottom));
    }

    ArrayList<String> a(ArrayList<View> r6) {
        ArrayList<String> r5 = new ArrayList();
        int r0 = r6.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        View r2 = (View) ZeusTransformUtils.preCheckCast(r6.get(r1), View.class, "com.obric.aiagent.plugin");
        r5.add(ViewCompat.s(r2));
        ViewCompat.a(r2, null);
        r1 = r1 + 1;
        goto L3
    L5:
        return r5;
    }

    void a(View r10, final ArrayList<View> r11, final ArrayList<View> r12, final ArrayList<String> r13, Map<String, String> r14) {
        Map r15 = (Map) ZeusTransformUtils.wrapperContextForParams(r14, Map.class, "com.obric.aiagent.plugin");
        final int r4 = r12.size();
        final ArrayList r8 = new ArrayList();
        int r2 = 0;
    L3:
        if (r2 >= r4) goto L14;
        View r3 = (View) ZeusTransformUtils.preCheckCast(r11.get(r2), View.class, "com.obric.aiagent.plugin");
        String r5 = ViewCompat.s(r3);
        r8.add(r5);
        if (r5 == null) goto L13;
        ViewCompat.a(r3, null);
        String r6 = (String) ZeusTransformUtils.preCheckCast(r15.get(r5), String.class, "com.obric.aiagent.plugin");
        int r7 = 0;
    L8:
        if (r7 >= r4) goto L13;
        if (r6.equals(r13.get(r7)) == true) goto L11;
        r7 = r7 + 1;
        goto L8
    L11:
        ViewCompat.a((View) ZeusTransformUtils.preCheckCast(r12.get(r7), View.class, "com.obric.aiagent.plugin"), r5);
    L13:
        r2 = r2 + 1;
        goto L3
    L14:
        OneShotPreDrawListener.add(r10, new AnonymousClass1(this, r4, r12, r13, r11, r8));
    }

    void a(ArrayList<View> r4, View r5) {
        if (r5.getVisibility() == 0) goto L5;
        return;
    L5:
        if (ZeusTransformUtils.instanceOf(r5, ViewGroup.class) == false) goto L12;
        ViewGroup r6 = (ViewGroup) ZeusTransformUtils.preCheckCast(r5, ViewGroup.class, "com.obric.aiagent.plugin");
        if (aa.a(r6) == false) goto L9;
        r4.add(r6);
        return;
    L9:
        int r0 = r6.getChildCount();
        int r1 = 0;
    L10:
        if (r1 >= r0) goto L17;
        a(r4, r6.getChildAt(r1));
        r1 = r1 + 1;
        goto L10
    L17:
        return;
    L12:
        r4.add(r5);
    }

    void a(Map<String, View> r4, View r5) {
        Map<String, View> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        if (r5.getVisibility() != 0) goto L12;
        String r0 = ViewCompat.s(r5);
        if (r0 == null) goto L8;
        r6.put(r0, r5);
    L8:
        if (ZeusTransformUtils.instanceOf(r5, ViewGroup.class) == false) goto L14;
        ViewGroup r7 = (ViewGroup) ZeusTransformUtils.preCheckCast(r5, ViewGroup.class, "com.obric.aiagent.plugin");
        int r1 = r7.getChildCount();
        int r2 = 0;
    L10:
        if (r2 >= r1) goto L15;
        a(r6, r7.getChildAt(r2));
        r2 = r2 + 1;
        goto L10
    L15:
        return;
    L14:
        return;
    }

    void a(View r3, final ArrayList<View> r4, Map<String, String> r5) {
        final Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        OneShotPreDrawListener.add(r3, new AnonymousClass2(this, r4, r6));
    }

    public void a(Fragment r1, Object r2, androidx.core.os.f r3, Runnable r4) {
        ((Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.aiagent.plugin")).run();
    }

    void a(ViewGroup r3, final ArrayList<View> r4, Map<String, String> r5) {
        final Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        OneShotPreDrawListener.add(r3, new AnonymousClass3(this, r4, r6));
    }

    public static void a(List<View> r7, View r8) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        int r0 = r9.size();
        if (a(r9, r8, r0) == false) goto L6;
        return;
    L6:
        if (ViewCompat.s(r8) == null) goto L8;
        r9.add(r8);
    L8:
        int r10 = r0;
    L10:
        if (r10 >= r9.size()) goto L22;
        View r2 = (View) ZeusTransformUtils.preCheckCast(r9.get(r10), View.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r2, ViewGroup.class) == false) goto L21;
        ViewGroup r3 = (ViewGroup) ZeusTransformUtils.preCheckCast(r2, ViewGroup.class, "com.obric.aiagent.plugin");
        int r4 = r3.getChildCount();
        int r5 = 0;
    L14:
        if (r5 >= r4) goto L21;
        View r6 = r3.getChildAt(r5);
        if (a(r9, r6, r0) == true) goto L20;
        if (ViewCompat.s(r6) == null) goto L20;
        r9.add(r6);
    L20:
        r5 = r5 + 1;
    L21:
        r10 = r10 + 1;
        goto L10
    }

    private static boolean a(List<View> r3, View r4, int r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        int r1 = 0;
    L3:
        if (r1 >= r5) goto L9;
        if (r6.get(r1) == r4) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public static boolean a(List r2) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L5;
    L8:
        return true;
    L5:
        if (r3.isEmpty() == true) goto L8;
        return false;
    }

    static String a(Map<String, String> r3, String r4) {
        Iterator r5 = ((Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin")).entrySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L9;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r5.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        if (r4.equals(r0.getValue()) == false) goto L4;
        return (String) ZeusTransformUtils.preCheckCast(r0.getKey(), String.class, "com.obric.aiagent.plugin");
    L9:
        return null;
    }
}
