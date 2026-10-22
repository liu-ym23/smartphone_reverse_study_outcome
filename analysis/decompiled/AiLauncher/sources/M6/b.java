package M6;

import La.H;
import O6.l;
import Y8.j;
import Z8.C1165m;
import Z8.F;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import h8.C4148a;
import io.ktor.sse.ServerSentEventKt;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0013\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0010\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0013\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0015\u0010\u0012J\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0014\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J%\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\n\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\u00182\u0006\u0010\u001a\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010 \u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b \u0010!J\u0017\u0010$\u001a\u00020#2\u0006\u0010\"\u001a\u00020\u0004H\u0002¢\u0006\u0004\b$\u0010%J#\u0010)\u001a\u00020\n2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020'0&H\u0002¢\u0006\u0004\b)\u0010*R\u0014\u0010+\u001a\u00020'8\u0002X\u0082T¢\u0006\u0006\n\u0004\b+\u0010,R\u0014\u0010-\u001a\u00020'8\u0002X\u0082T¢\u0006\u0006\n\u0004\b-\u0010,R<\u00101\u001a*\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0018\u0012\u0006\u0012\u0004\u0018\u00010/0.j\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0018\u0012\u0006\u0012\u0004\u0018\u00010/`08\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102¨\u00063"}, d2 = {"LM6/b;", "", "<init>", "()V", "Landroid/view/View;", Parameters.ROOT, "LY8/t;", "f", "(Landroid/view/View;)V", Const.INTENT_KEY_BACKGROUND_COMMAND, "", "e", "()Ljava/lang/String;", "", Const.INTENT_KEY_PKGNAME, "()Ljava/util/List;", "callback", "l", "(Ljava/lang/Object;)Ljava/lang/String;", "n", "listener", "o", "c", "(Ljava/lang/Object;)Landroid/view/View;", "Ljava/lang/Class;", "type", "name", "Ljava/lang/reflect/Field;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/reflect/Field;", "m", "(Ljava/lang/String;)Ljava/lang/String;", Const.INTENT_KEY_UMID, "(Landroid/view/View;)Ljava/lang/String;", "view", "", "k", "(Landroid/view/View;)Z", "", "", "tally", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/util/Map;)Ljava/lang/String;", "MAX_DEPTH", "I", "MAX_LABELS", "Ljava/util/HashMap;", "Ljava/lang/reflect/Method;", "Lkotlin/collections/HashMap;", "isAnimatingCache", "Ljava/util/HashMap;", "common_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class b {
    private static final int MAX_DEPTH = 24;
    private static final int MAX_LABELS = 10;
    public static final b INSTANCE = new b();
    private static final HashMap<Class<?>, Method> isAnimatingCache = new HashMap<>();

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class a<T> implements Comparator {
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            return b9.b.d((Integer) ((Map.Entry) t11).getValue(), (Integer) ((Map.Entry) t10).getValue());
        }
    }

    public static final CharSequence j(Map.Entry it) {
        p.i(it, "it");
        if (((Number) it.getValue()).intValue() <= 1) {
            return (CharSequence) it.getKey();
        }
        return it.getKey() + "x" + it.getValue();
    }

    public final List<Object> b() {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            Class<?> cls = Class.forName("android.animation.AnimationHandler");
            Object objInvoke = cls.getMethod("getInstance", null).invoke(null, null);
            Field declaredField = cls.getDeclaredField("mAnimationCallbacks");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(objInvoke);
            List list = obj instanceof List ? (List) obj : null;
            objB = Result.b(list != null ? F.m1(list) : null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        return (List) (Result.g(objB) ? null : objB);
    }

    public final View c(Object listener) {
        Object objB;
        View view;
        try {
            Result.Companion companion = Result.INSTANCE;
            Field[] declaredFields = listener.getClass().getDeclaredFields();
            p.h(declaredFields, "getDeclaredFields(...)");
            int length = declaredFields.length;
            int i10 = 0;
            while (true) {
                if (i10 >= length) {
                    view = null;
                    break;
                }
                Field field = declaredFields[i10];
                field.setAccessible(true);
                Object obj = field.get(listener);
                view = obj instanceof View ? (View) obj : null;
                if (view != null) {
                    break;
                }
                i10++;
            }
            objB = Result.b(view);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        return (View) (Result.g(objB) ? null : objB);
    }

    public final String d(View root) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        C1165m c1165m = new C1165m();
        c1165m.addLast(j.a(root, 0));
        while (!c1165m.isEmpty()) {
            Pair pair = (Pair) c1165m.removeLast();
            View view = (View) pair.a();
            int iIntValue = ((Number) pair.b()).intValue();
            if (view.getVisibility() == 0) {
                Animation animation = view.getAnimation();
                String str = (animation == null || animation.hasEnded()) ? k(view) ? "self" : null : "anim";
                if (str != null) {
                    String str2 = view.getClass().getSimpleName() + ServerSentEventKt.COLON + str;
                    Integer num = (Integer) linkedHashMap.get(str2);
                    linkedHashMap.put(str2, Integer.valueOf((num != null ? num.intValue() : 0) + 1));
                }
                if (iIntValue < 24 && (view instanceof ViewGroup)) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    int childCount = viewGroup.getChildCount();
                    for (int i10 = 0; i10 < childCount; i10++) {
                        c1165m.addLast(j.a(viewGroup.getChildAt(i10), Integer.valueOf(iIntValue + 1)));
                    }
                }
            }
        }
        return i(linkedHashMap);
    }

    public final String e() {
        List<Object> listB = b();
        if (listB == null) {
            return "?";
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : listB) {
            if (obj != null) {
                String strL = l(obj);
                Integer num = (Integer) linkedHashMap.get(strL);
                linkedHashMap.put(strL, Integer.valueOf((num != null ? num.intValue() : 0) + 1));
            }
        }
        return i(linkedHashMap);
    }

    public final void f(View root) {
        String strD;
        String strE = e();
        if (root == null || (strD = INSTANCE.d(root)) == null) {
            strD = l.DATE_SEPARATOR;
        }
        C4148a.k(c.TAG, "frameSrc animator=[" + strE + "] view=[" + strD + "]", false, 4, null);
    }

    public final void g(View root) {
        Object objB;
        Object objB2;
        Object objB3;
        p.i(root, "root");
        Display display = root.getDisplay();
        if (display == null) {
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            String str = String.format(Locale.US, "%.0f", Arrays.copyOf(new Object[]{Float.valueOf(display.getRefreshRate())}, 1));
            p.h(str, "format(...)");
            objB = Result.b(str);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = "?";
        }
        String str2 = (String) objB;
        try {
            Display.Mode[] supportedModes = display.getSupportedModes();
            p.h(supportedModes, "getSupportedModes(...)");
            ArrayList arrayList = new ArrayList(supportedModes.length);
            for (Display.Mode mode : supportedModes) {
                String str3 = String.format(Locale.US, "%.0f", Arrays.copyOf(new Object[]{Float.valueOf(mode.getRefreshRate())}, 1));
                p.h(str3, "format(...)");
                arrayList.add(str3);
            }
            objB2 = Result.b(F.b1(F.g0(arrayList)));
        } catch (Throwable th2) {
            Result.Companion companion3 = Result.INSTANCE;
            objB2 = Result.b(C4849c.a(th2));
        }
        if (Result.g(objB2)) {
            objB2 = null;
        }
        Object obj = (List) objB2;
        try {
            float[] supportedRefreshRates = display.getSupportedRefreshRates();
            p.h(supportedRefreshRates, "getSupportedRefreshRates(...)");
            ArrayList arrayList2 = new ArrayList(supportedRefreshRates.length);
            for (float f10 : supportedRefreshRates) {
                String str4 = String.format(Locale.US, "%.0f", Arrays.copyOf(new Object[]{Float.valueOf(f10)}, 1));
                p.h(str4, "format(...)");
                arrayList2.add(str4);
            }
            objB3 = Result.b(F.b1(F.g0(arrayList2)));
        } catch (Throwable th3) {
            Result.Companion companion4 = Result.INSTANCE;
            objB3 = Result.b(C4849c.a(th3));
        }
        if (Result.g(objB3)) {
            objB3 = null;
        }
        Object obj2 = (List) objB3;
        if (obj == null) {
            obj = "?";
        }
        C4148a.k(c.TAG, "displayModes cur=" + str2 + " modes=" + obj + " rates=" + (obj2 != null ? obj2 : "?"), false, 4, null);
    }

    public final Field h(Class<?> type, String name) {
        Object objB;
        while (true) {
            if (type == null) {
                return null;
            }
            try {
                Result.Companion companion = Result.INSTANCE;
                objB = Result.b(type.getDeclaredField(name));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Field field = (Field) (Result.g(objB) ? null : objB);
            if (field != null) {
                return field;
            }
            type = type.getSuperclass();
        }
    }

    public final String i(Map<String, Integer> tally) {
        return tally.isEmpty() ? l.DATE_SEPARATOR : F.A0(F.f1(F.c1(tally.entrySet(), new a()), 10), Const.STR_MART_COMMA, null, null, 0, null, new InterfaceC5074l() { // from class: M6.a
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return b.j((Map.Entry) obj);
            }
        }, 30, null);
    }

    public final boolean k(View view) {
        Object objB;
        Object objB2;
        HashMap<Class<?>, Method> map = isAnimatingCache;
        Class<?> cls = view.getClass();
        Method method = map.get(cls);
        if (method == null) {
            try {
                Result.Companion companion = Result.INSTANCE;
                objB = Result.b(view.getClass().getMethod("isAnimating", null));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            if (Result.g(objB)) {
                objB = null;
            }
            method = (Method) objB;
            if (method == null || !p.d(method.getReturnType(), Boolean.TYPE)) {
                method = null;
            }
            map.put(cls, method);
        }
        Method method2 = method;
        if (method2 == null) {
            return false;
        }
        try {
            Result.Companion companion3 = Result.INSTANCE;
            objB2 = Result.b(method2.invoke(view, null));
        } catch (Throwable th2) {
            Result.Companion companion4 = Result.INSTANCE;
            objB2 = Result.b(C4849c.a(th2));
        }
        return p.d(Result.g(objB2) ? null : objB2, Boolean.TRUE);
    }

    public final String l(Object callback) {
        String strN = n(callback);
        if (strN != null) {
            return strN;
        }
        String name = callback.getClass().getName();
        p.h(name, "getName(...)");
        return m(name);
    }

    public final String m(String name) {
        String strY1 = H.y1(name, '.', "");
        String strS1 = H.s1(name, '.', null, 2, null);
        String strW1 = H.w1(H.x1(strS1, "$$", null, 2, null), '$', null, 2, null);
        if (strW1.length() != 0) {
            strS1 = strW1;
        }
        if (strY1.length() == 0) {
            return strS1;
        }
        return strY1 + "." + strS1;
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x000f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String n(java.lang.Object r12) {
        /*
            r11 = this;
            r1 = 0
            kotlin.Result$a r0 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L21
            java.lang.Class r0 = r12.getClass()     // Catch: java.lang.Throwable -> L21
            java.lang.String r2 = "mUpdateListeners"
            java.lang.reflect.Field r0 = r11.h(r0, r2)     // Catch: java.lang.Throwable -> L21
            if (r0 != 0) goto L12
        Lf:
            r11 = r1
            goto L97
        L12:
            r2 = 1
            r0.setAccessible(r2)     // Catch: java.lang.Throwable -> L21
            java.lang.Object r12 = r0.get(r12)     // Catch: java.lang.Throwable -> L21
            boolean r0 = r12 instanceof java.util.List     // Catch: java.lang.Throwable -> L21
            if (r0 == 0) goto L25
            java.util.List r12 = (java.util.List) r12     // Catch: java.lang.Throwable -> L21
            goto L26
        L21:
            r0 = move-exception
            r11 = r0
            goto L9c
        L25:
            r12 = r1
        L26:
            if (r12 == 0) goto Lf
            java.lang.Iterable r12 = (java.lang.Iterable) r12     // Catch: java.lang.Throwable -> L21
            java.util.List r12 = Z8.F.n0(r12)     // Catch: java.lang.Throwable -> L21
            if (r12 == 0) goto Lf
            java.lang.Iterable r12 = (java.lang.Iterable) r12     // Catch: java.lang.Throwable -> L21
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L21
            r2 = 10
            int r2 = Z8.C1174w.x(r12, r2)     // Catch: java.lang.Throwable -> L21
            r0.<init>(r2)     // Catch: java.lang.Throwable -> L21
            java.util.Iterator r12 = r12.iterator()     // Catch: java.lang.Throwable -> L21
        L41:
            boolean r2 = r12.hasNext()     // Catch: java.lang.Throwable -> L21
            if (r2 == 0) goto L73
            java.lang.Object r2 = r12.next()     // Catch: java.lang.Throwable -> L21
            java.lang.Class r3 = r2.getClass()     // Catch: java.lang.Throwable -> L21
            java.lang.String r3 = r3.getName()     // Catch: java.lang.Throwable -> L21
            java.lang.String r4 = "getName(...)"
            kotlin.jvm.internal.p.h(r3, r4)     // Catch: java.lang.Throwable -> L21
            java.lang.String r3 = r11.m(r3)     // Catch: java.lang.Throwable -> L21
            java.lang.String r2 = r11.o(r2)     // Catch: java.lang.Throwable -> L21
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L21
            r4.<init>()     // Catch: java.lang.Throwable -> L21
            r4.append(r3)     // Catch: java.lang.Throwable -> L21
            r4.append(r2)     // Catch: java.lang.Throwable -> L21
            java.lang.String r2 = r4.toString()     // Catch: java.lang.Throwable -> L21
            r0.add(r2)     // Catch: java.lang.Throwable -> L21
            goto L41
        L73:
            java.util.List r11 = Z8.F.g0(r0)     // Catch: java.lang.Throwable -> L21
            if (r11 == 0) goto Lf
            r12 = r11
            java.util.Collection r12 = (java.util.Collection) r12     // Catch: java.lang.Throwable -> L21
            boolean r12 = r12.isEmpty()     // Catch: java.lang.Throwable -> L21
            if (r12 != 0) goto L83
            goto L84
        L83:
            r11 = r1
        L84:
            if (r11 == 0) goto Lf
            r2 = r11
            java.lang.Iterable r2 = (java.lang.Iterable) r2     // Catch: java.lang.Throwable -> L21
            java.lang.String r3 = "+"
            r9 = 62
            r10 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            java.lang.String r11 = Z8.F.A0(r2, r3, r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L21
        L97:
            java.lang.Object r11 = kotlin.Result.b(r11)     // Catch: java.lang.Throwable -> L21
            goto La6
        L9c:
            kotlin.Result$a r12 = kotlin.Result.INSTANCE
            java.lang.Object r11 = kotlin.C4849c.a(r11)
            java.lang.Object r11 = kotlin.Result.b(r11)
        La6:
            boolean r12 = kotlin.Result.g(r11)
            if (r12 == 0) goto Lad
            goto Lae
        Lad:
            r1 = r11
        Lae:
            java.lang.String r1 = (java.lang.String) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: M6.b.n(java.lang.Object):java.lang.String");
    }

    public final String o(Object listener) {
        View viewC = c(listener);
        return viewC == null ? "" : (viewC.isShown() && viewC.getWindowVisibility() == 0) ? "(shown)" : "(hidden)";
    }
}
