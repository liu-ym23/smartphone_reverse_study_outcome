package y1;

import android.app.Activity;
import android.app.FragmentManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.a0;
import androidx.lifecycle.AbstractC0328z;
import androidx.lifecycle.EnumC0326x;
import androidx.lifecycle.G;
import androidx.lifecycle.I;
import androidx.lifecycle.b0;
import androidx.lifecycle.c0;
import androidx.lifecycle.e0;
import androidx.lifecycle.n0;
import androidx.lifecycle.q0;
import androidx.preference.EditTextPreference;
import androidx.preference.Preference;
import com.stepos.alphame.R;
import h3.InterfaceC0613w;
import j3.InterfaceC0638b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.platform.Platform;
import p.C0810a;

/* loaded from: classes.dex */
public class f implements androidx.preference.r, q0, InterfaceC0613w, InterfaceC0638b {

    /* renamed from: a, reason: collision with root package name */
    public static f f16200a;

    /* renamed from: b, reason: collision with root package name */
    public static f f16201b;

    public /* synthetic */ f(int i4) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /* JADX WARN: Type inference failed for: r5v4, types: [T, java.lang.Throwable] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x008a -> B:25:0x006d). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x008d -> B:25:0x006d). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object d(y1.f r5, java.util.List r6, S.E r7, kotlin.coroutines.Continuation r8) throws java.lang.Throwable {
        /*
            r5.getClass()
            boolean r0 = r8 instanceof S.C0099e
            if (r0 == 0) goto L16
            r0 = r8
            S.e r0 = (S.C0099e) r0
            int r1 = r0.f1745e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L16
            int r1 = r1 - r2
            r0.f1745e = r1
            goto L1b
        L16:
            S.e r0 = new S.e
            r0.<init>(r5, r8)
        L1b:
            java.lang.Object r5 = r0.f1743c
            java.lang.Object r8 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r0.f1745e
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L47
            if (r1 == r3) goto L3f
            if (r1 != r2) goto L37
            java.util.Iterator r6 = r0.f1742b
            java.io.Serializable r7 = r0.f1741a
            kotlin.jvm.internal.Ref$ObjectRef r7 = (kotlin.jvm.internal.Ref.ObjectRef) r7
            kotlin.ResultKt.throwOnFailure(r5)     // Catch: java.lang.Throwable -> L35
            goto L6d
        L35:
            r5 = move-exception
            goto L86
        L37:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3f:
            java.io.Serializable r6 = r0.f1741a
            java.util.List r6 = (java.util.List) r6
            kotlin.ResultKt.throwOnFailure(r5)
            goto L61
        L47:
            kotlin.ResultKt.throwOnFailure(r5)
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            S.g r1 = new S.g
            r4 = 0
            r1.<init>(r6, r5, r4)
            r0.f1741a = r5
            r0.f1745e = r3
            java.lang.Object r6 = r7.a(r1, r0)
            if (r6 != r8) goto L60
            goto La0
        L60:
            r6 = r5
        L61:
            kotlin.jvm.internal.Ref$ObjectRef r5 = new kotlin.jvm.internal.Ref$ObjectRef
            r5.<init>()
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.Iterator r6 = r6.iterator()
            r7 = r5
        L6d:
            boolean r5 = r6.hasNext()
            if (r5 == 0) goto L98
            java.lang.Object r5 = r6.next()
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            r0.f1741a = r7     // Catch: java.lang.Throwable -> L35
            r0.f1742b = r6     // Catch: java.lang.Throwable -> L35
            r0.f1745e = r2     // Catch: java.lang.Throwable -> L35
            java.lang.Object r5 = r5.invoke(r0)     // Catch: java.lang.Throwable -> L35
            if (r5 != r8) goto L6d
            goto La0
        L86:
            T r1 = r7.element
            if (r1 != 0) goto L8d
            r7.element = r5
            goto L6d
        L8d:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            T r1 = r7.element
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            kotlin.ExceptionsKt.addSuppressed(r1, r5)
            goto L6d
        L98:
            T r5 = r7.element
            java.lang.Throwable r5 = (java.lang.Throwable) r5
            if (r5 != 0) goto La1
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
        La0:
            return r8
        La1:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: y1.f.d(y1.f, java.util.List, S.E, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static e0 e(Bundle bundle, Bundle bundle2) {
        if (bundle == null) {
            if (bundle2 == null) {
                return new e0();
            }
            HashMap map = new HashMap();
            for (String key : bundle2.keySet()) {
                Intrinsics.checkNotNullExpressionValue(key, "key");
                map.put(key, bundle2.get(key));
            }
            return new e0(map);
        }
        ClassLoader classLoader = e0.class.getClassLoader();
        Intrinsics.checkNotNull(classLoader);
        bundle.setClassLoader(classLoader);
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("keys");
        ArrayList parcelableArrayList2 = bundle.getParcelableArrayList("values");
        if (parcelableArrayList == null || parcelableArrayList2 == null || parcelableArrayList.size() != parcelableArrayList2.size()) {
            throw new IllegalStateException("Invalid bundle passed as restored state".toString());
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int size = parcelableArrayList.size();
        for (int i4 = 0; i4 < size; i4++) {
            Object obj = parcelableArrayList.get(i4);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            linkedHashMap.put((String) obj, parcelableArrayList2.get(i4));
        }
        return new e0(linkedHashMap);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void f(Activity activity, EnumC0326x event) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(event, "event");
        if (activity instanceof G) {
            AbstractC0328z lifecycle = ((G) activity).getLifecycle();
            if (lifecycle instanceof I) {
                ((I) lifecycle).e(event);
            }
        }
    }

    public static C0810a g(B0.m mVar) {
        return (C0810a) ((Drawable) mVar.f155b);
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x004b, code lost:
    
        if (java.lang.Character.isHighSurrogate(r5) != false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0088, code lost:
    
        if (java.lang.Character.isLowSurrogate(r5) != false) goto L60;
     */
    /* JADX WARN: Removed duplicated region for block: B:106:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0072 A[EDGE_INSN: B:91:0x0072->B:48:0x0072 BREAK  A[LOOP:2: B:49:0x0074->B:60:0x008b, LOOP_LABEL: LOOP:2: B:49:0x0074->B:60:0x008b], EDGE_INSN: B:94:0x0072->B:48:0x0072 BREAK  A[LOOP:2: B:49:0x0074->B:60:0x008b]] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00a8 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean i(android.view.inputmethod.InputConnection r7, android.text.Editable r8, int r9, int r10, boolean r11) {
        /*
            Method dump skipped, instructions count: 246
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y1.f.i(android.view.inputmethod.InputConnection, android.text.Editable, int, int, boolean):boolean");
    }

    public static void j(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        b0.Companion.getClass();
        Intrinsics.checkNotNullParameter(activity, "activity");
        activity.registerActivityLifecycleCallbacks(new b0());
        FragmentManager fragmentManager = activity.getFragmentManager();
        if (fragmentManager.findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag") == null) {
            fragmentManager.beginTransaction().add(new c0(), "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
            fragmentManager.executePendingTransactions();
        }
    }

    @Override // androidx.lifecycle.q0
    public n0 a(Class cls) {
        return new a0(true);
    }

    @Override // androidx.preference.r
    public CharSequence b(Preference preference) {
        EditTextPreference editTextPreference = (EditTextPreference) preference;
        return TextUtils.isEmpty(editTextPreference.T) ? editTextPreference.f4077a.getString(R.string.not_set) : editTextPreference.T;
    }

    public InputFilter[] h(InputFilter[] inputFilterArr) {
        return inputFilterArr;
    }

    public boolean k() {
        return false;
    }

    public void l(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        Platform.log$default(Platform.INSTANCE.get(), message, 0, null, 6, null);
    }

    public void m(boolean z4) {
    }

    public void n(boolean z4) {
    }

    public void o(B0.m mVar, float f4) {
        C0810a c0810aG = g(mVar);
        boolean useCompatPadding = ((CardView) mVar.f156c).getUseCompatPadding();
        boolean preventCornerOverlap = ((CardView) mVar.f156c).getPreventCornerOverlap();
        if (f4 != c0810aG.f13832e || c0810aG.f13833f != useCompatPadding || c0810aG.f13834g != preventCornerOverlap) {
            c0810aG.f13832e = f4;
            c0810aG.f13833f = useCompatPadding;
            c0810aG.f13834g = preventCornerOverlap;
            c0810aG.b(null);
            c0810aG.invalidateSelf();
        }
        if (!((CardView) mVar.f156c).getUseCompatPadding()) {
            mVar.b(0, 0, 0, 0);
            return;
        }
        Object obj = mVar.f155b;
        float f5 = ((C0810a) ((Drawable) obj)).f13832e;
        float f6 = ((C0810a) ((Drawable) obj)).f13828a;
        int iCeil = (int) Math.ceil(p.b.a(f5, f6, ((CardView) mVar.f156c).getPreventCornerOverlap()));
        int iCeil2 = (int) Math.ceil(p.b.b(f5, f6, ((CardView) mVar.f156c).getPreventCornerOverlap()));
        mVar.b(iCeil, iCeil2, iCeil, iCeil2);
    }

    public void p() {
    }

    public TransformationMethod q(TransformationMethod transformationMethod) {
        return transformationMethod;
    }
}
