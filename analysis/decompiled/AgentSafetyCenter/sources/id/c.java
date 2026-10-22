package id;

import ad.x;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.provider.Settings;
import android.text.Spanned;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.PathInterpolator;
import androidx.activity.f0;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.lifecycle.c0;
import androidx.lifecycle.d0;
import androidx.lifecycle.s0;
import androidx.lifecycle.y0;
import com.fasterxml.jackson.core.ErrorReportConfiguration;
import com.google.crypto.tink.shaded.protobuf.Reader;
import com.stepos.agentsafetycenter.R;
import com.stepos.perfbinder.client.PerfBinderClient;
import g5.y;
import hc.o;
import io.modelcontextprotocol.spec.HttpHeaders;
import java.lang.invoke.VarHandle;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.WeakHashMap;
import java.util.concurrent.Executor;
import jb.v;
import k0.c1;
import k0.i2;
import k0.k1;
import k0.p;
import k0.s;
import k0.v1;
import k0.z;
import n3.e0;
import n3.k0;
import o1.q;
import p5.u;
import t.m0;
import v1.a1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public static i1.f f5948a;

    public c(View view) {
        new PathInterpolator(0.1f, 0.1f, 0.0f, 1.0f);
        Context context = view.getContext();
        k.O(context, R.attr.motionDurationMedium2, 300);
        k.O(context, R.attr.motionDurationShort3, 150);
        k.O(context, R.attr.motionDurationShort2, 100);
    }

    public static b2.a A(String str) throws ProtocolException, NumberFormatException {
        int i;
        String strSubstring;
        boolean zU = o.U(str, "HTTP/1.", false);
        x xVar = x.HTTP_1_0;
        if (zU) {
            i = 9;
            if (str.length() < 9 || str.charAt(8) != ' ') {
                throw new ProtocolException("Unexpected status line: ".concat(str));
            }
            int iCharAt = str.charAt(7) - '0';
            if (iCharAt != 0) {
                if (iCharAt != 1) {
                    throw new ProtocolException("Unexpected status line: ".concat(str));
                }
                xVar = x.HTTP_1_1;
            }
        } else {
            if (!o.U(str, "ICY ", false)) {
                throw new ProtocolException("Unexpected status line: ".concat(str));
            }
            i = 4;
        }
        int i3 = i + 3;
        if (str.length() < i3) {
            throw new ProtocolException("Unexpected status line: ".concat(str));
        }
        try {
            int i10 = Integer.parseInt(str.substring(i, i3));
            if (str.length() <= i3) {
                strSubstring = "";
            } else {
                if (str.charAt(i3) != ' ') {
                    throw new ProtocolException("Unexpected status line: ".concat(str));
                }
                strSubstring = str.substring(i + 4);
            }
            b2.a aVar = new b2.a(2);
            aVar.f1861c = xVar;
            aVar.f1860b = i10;
            aVar.f1862d = strSubstring;
            VarHandle.storeStoreFence();
            return aVar;
        } catch (NumberFormatException unused) {
            throw new ProtocolException("Unexpected status line: ".concat(str));
        }
    }

    public static void B(Context context, AttributeSet attributeSet) {
        Resources resources = context.getResources();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, xa.a.f15601d, R.attr.steposPreferenceStyle, R.style.StepOSWidget_Preference);
        try {
            int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.stepos_list_item_height);
            int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.stepos_list_item_padding_start);
            int dimensionPixelSize3 = resources.getDimensionPixelSize(R.dimen.stepos_list_item_padding_vertical);
            int dimensionPixelSize4 = resources.getDimensionPixelSize(R.dimen.stepos_list_item_icon_text_gap);
            int dimensionPixelSize5 = resources.getDimensionPixelSize(R.dimen.stepos_list_item_accessory_size);
            int dimensionPixelSize6 = resources.getDimensionPixelSize(R.dimen.stepos_divider_height);
            int dimensionPixelSize7 = resources.getDimensionPixelSize(R.dimen.stepos_divider_inset_start);
            int dimensionPixelSize8 = resources.getDimensionPixelSize(R.dimen.stepos_divider_inset_end);
            typedArrayObtainStyledAttributes.getDimensionPixelSize(22, dimensionPixelSize);
            typedArrayObtainStyledAttributes.getDimensionPixelSize(23, dimensionPixelSize2);
            typedArrayObtainStyledAttributes.getDimensionPixelSize(24, dimensionPixelSize3);
            typedArrayObtainStyledAttributes.getDimensionPixelSize(18, dimensionPixelSize4);
            typedArrayObtainStyledAttributes.getResourceId(41, 0);
            typedArrayObtainStyledAttributes.getResourceId(36, 0);
            typedArrayObtainStyledAttributes.getResourceId(45, 0);
            G(attributeSet, typedArrayObtainStyledAttributes, 35, "steposListItemSubtitleMaxLines", 1);
            H(context, attributeSet, typedArrayObtainStyledAttributes, 38, "steposListItemTitle");
            H(context, attributeSet, typedArrayObtainStyledAttributes, 39, "steposListItemTitleEndText");
            H(context, attributeSet, typedArrayObtainStyledAttributes, 34, "steposListItemSubtitle");
            if (H(context, attributeSet, typedArrayObtainStyledAttributes, 29, "steposListItemRightText") == null) {
                H(context, attributeSet, typedArrayObtainStyledAttributes, 43, "steposListItemValue");
            }
            u(attributeSet, "steposListItemIconBackground");
            if (u(attributeSet, "steposListItemIconBackground") && typedArrayObtainStyledAttributes.hasValue(14)) {
                typedArrayObtainStyledAttributes.getColor(14, 0);
            }
            int iF = f(attributeSet, "steposListItemIcon");
            if (iF < 0 || attributeSet == null || attributeSet.getAttributeResourceValue(iF, 0) == 0) {
                typedArrayObtainStyledAttributes.getResourceId(13, 0);
            }
            u(attributeSet, "steposListItemIconTint");
            if (u(attributeSet, "steposListItemIconTint") && typedArrayObtainStyledAttributes.hasValue(19)) {
                typedArrayObtainStyledAttributes.getColor(19, 0);
            }
            F(attributeSet, typedArrayObtainStyledAttributes, 20, "steposListItemIconVisible", true);
            G(attributeSet, typedArrayObtainStyledAttributes, 17, "steposListItemIconStyle", 0);
            if (!u(attributeSet, "steposListItemIconSize")) {
                typedArrayObtainStyledAttributes.hasValue(16);
            }
            typedArrayObtainStyledAttributes.getDimensionPixelSize(16, 0);
            if (!u(attributeSet, "steposListItemIconCornerRadius")) {
                typedArrayObtainStyledAttributes.hasValue(15);
            }
            typedArrayObtainStyledAttributes.getDimension(15, 0.0f);
            G(attributeSet, typedArrayObtainStyledAttributes, 3, "steposListItemBadgeStyle", 0);
            if (!u(attributeSet, "steposListItemBadgeTint")) {
                typedArrayObtainStyledAttributes.hasValue(4);
            }
            if (typedArrayObtainStyledAttributes.hasValue(4)) {
                typedArrayObtainStyledAttributes.getColor(4, 0);
            }
            F(attributeSet, typedArrayObtainStyledAttributes, 31, "steposListItemShowBadge", false);
            G(attributeSet, typedArrayObtainStyledAttributes, 26, "steposListItemRightBadgeStyle", 1);
            if (!u(attributeSet, "steposListItemRightBadgeTint")) {
                typedArrayObtainStyledAttributes.hasValue(27);
            }
            if (typedArrayObtainStyledAttributes.hasValue(27)) {
                typedArrayObtainStyledAttributes.getColor(27, 0);
            }
            F(attributeSet, typedArrayObtainStyledAttributes, 33, "steposListItemShowRightBadge", false);
            F(attributeSet, typedArrayObtainStyledAttributes, 30, "steposListItemShowAccessory", true);
            typedArrayObtainStyledAttributes.getDimensionPixelSize(1, dimensionPixelSize5);
            G(attributeSet, typedArrayObtainStyledAttributes, 42, "steposListItemTrailingType", 1);
            H(context, attributeSet, typedArrayObtainStyledAttributes, 5, "steposListItemButtonText");
            G(attributeSet, typedArrayObtainStyledAttributes, 21, "steposListItemLineMode", 0);
            F(attributeSet, typedArrayObtainStyledAttributes, 6, "steposListItemChecked", false);
            F(attributeSet, typedArrayObtainStyledAttributes, 37, "steposListItemSwitchChecked", false);
            F(attributeSet, typedArrayObtainStyledAttributes, 25, "steposListItemPressScaleEnabled", false);
            F(attributeSet, typedArrayObtainStyledAttributes, 32, "steposListItemShowDivider", false);
            typedArrayObtainStyledAttributes.getDimensionPixelSize(9, dimensionPixelSize6);
            typedArrayObtainStyledAttributes.getDimensionPixelSize(11, dimensionPixelSize7);
            typedArrayObtainStyledAttributes.getDimensionPixelSize(10, dimensionPixelSize8);
            typedArrayObtainStyledAttributes.getColor(8, context.getColor(R.color.stepos_divider));
            G(attributeSet, typedArrayObtainStyledAttributes, 40, "steposListItemTitleStyle", 0);
            t2.a.h(typedArrayObtainStyledAttributes, null);
        } finally {
        }
    }

    public static final void C(float[] fArr, float[] fArr2, int i, float[] fArr3) {
        if (i == 0) {
            r1.a.a("At least one point must be provided");
        }
        int i3 = 2 >= i ? i - 1 : 2;
        int i10 = i3 + 1;
        float[][] fArr4 = new float[i10][];
        for (int i11 = 0; i11 < i10; i11++) {
            fArr4[i11] = new float[i];
        }
        for (int i12 = 0; i12 < i; i12++) {
            fArr4[0][i12] = 1.0f;
            for (int i13 = 1; i13 < i10; i13++) {
                fArr4[i13][i12] = fArr4[i13 - 1][i12] * fArr[i12];
            }
        }
        float[][] fArr5 = new float[i10][];
        for (int i14 = 0; i14 < i10; i14++) {
            fArr5[i14] = new float[i];
        }
        float[][] fArr6 = new float[i10][];
        for (int i15 = 0; i15 < i10; i15++) {
            fArr6[i15] = new float[i10];
        }
        int i16 = 0;
        while (i16 < i10) {
            float[] fArr7 = fArr5[i16];
            float[] fArr8 = fArr4[i16];
            fArr8.getClass();
            fArr7.getClass();
            System.arraycopy(fArr8, 0, fArr7, 0, i);
            for (int i17 = 0; i17 < i16; i17++) {
                float[] fArr9 = fArr5[i17];
                float fP = p(fArr7, fArr9);
                for (int i18 = 0; i18 < i; i18++) {
                    fArr7[i18] = fArr7[i18] - (fArr9[i18] * fP);
                }
            }
            float fSqrt = (float) Math.sqrt(p(fArr7, fArr7));
            if (fSqrt < 1.0E-6f) {
                fSqrt = 1.0E-6f;
            }
            float f5 = 1.0f / fSqrt;
            for (int i19 = 0; i19 < i; i19++) {
                fArr7[i19] = fArr7[i19] * f5;
            }
            float[] fArr10 = fArr6[i16];
            int i20 = 0;
            while (i20 < i10) {
                fArr10[i20] = i20 < i16 ? 0.0f : p(fArr7, fArr4[i20]);
                i20++;
            }
            i16++;
        }
        for (int i21 = i3; -1 < i21; i21--) {
            float fP2 = p(fArr5[i21], fArr2);
            float[] fArr11 = fArr6[i21];
            int i22 = i21 + 1;
            if (i22 <= i3) {
                int i23 = i3;
                while (true) {
                    fP2 -= fArr11[i23] * fArr3[i23];
                    if (i23 != i22) {
                        i23--;
                    }
                }
            }
            fArr3[i21] = fP2 / fArr11[i21];
        }
    }

    public static final void D(i2 i2Var, k0.d dVar, int i) {
        while (true) {
            int i3 = i2Var.f6958v;
            if (i > i3 && i < i2Var.f6957u) {
                return;
            }
            if (i3 == 0 && i == 0) {
                return;
            }
            i2Var.L();
            if (i2Var.x(i2Var.f6958v)) {
                dVar.i();
            }
            i2Var.j();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:67:0x01e0, code lost:
    
        r0 = h5.t.n(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x01e4, code lost:
    
        t2.a.h(r2, null);
        r10 = r0;
     */
    /* JADX WARN: Finally extract failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static s4.h E(x4.a r31, java.lang.String r32) {
        /*
            Method dump skipped, instructions count: 522
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: id.c.E(x4.a, java.lang.String):s4.h");
    }

    public static boolean F(AttributeSet attributeSet, TypedArray typedArray, int i, String str, boolean z10) {
        int iF = f(attributeSet, str);
        return (iF < 0 || attributeSet == null) ? typedArray.hasValue(i) ? typedArray.getBoolean(i, z10) : z10 : attributeSet.getAttributeBooleanValue(iF, z10);
    }

    public static int G(AttributeSet attributeSet, TypedArray typedArray, int i, String str, int i3) {
        int iF = f(attributeSet, str);
        return (iF < 0 || attributeSet == null) ? typedArray.hasValue(i) ? typedArray.getInt(i, i3) : i3 : attributeSet.getAttributeIntValue(iF, i3);
    }

    public static CharSequence H(Context context, AttributeSet attributeSet, TypedArray typedArray, int i, String str) {
        int iF = f(attributeSet, str);
        if (iF < 0 || attributeSet == null) {
            return typedArray.getText(i);
        }
        int attributeResourceValue = attributeSet.getAttributeResourceValue(iF, 0);
        if (attributeResourceValue == 0) {
            return attributeSet.getAttributeValue(iF);
        }
        try {
            return context.getResources().getText(attributeResourceValue);
        } catch (Exception unused) {
            return null;
        }
    }

    public static final void I(Object obj) {
        if (obj instanceof jb.h) {
            throw ((jb.h) obj).f6761c;
        }
    }

    public static a9.g J(a9.j jVar) {
        if (jVar instanceof a9.i) {
            return new a9.g(true, ((a9.i) jVar).b(), null, null);
        }
        if (jVar instanceof a9.h) {
            a9.h hVar = (a9.h) jVar;
            return new a9.g(false, hVar.b(), hVar.f264a.f254c, hVar.f265b);
        }
        g5.f.a();
        return null;
    }

    public static final int K(p5.f fVar, f6.f fVar2) {
        if (fVar instanceof f6.a) {
            return ((f6.a) fVar).f3916c;
        }
        int iOrdinal = fVar2.ordinal();
        if (iOrdinal == 0) {
            return Integer.MIN_VALUE;
        }
        if (iOrdinal == 1) {
            return Reader.READ_DONE;
        }
        g5.f.a();
        return 0;
    }

    public static final String L(float f5) {
        if (Float.isNaN(f5)) {
            return "NaN";
        }
        if (Float.isInfinite(f5)) {
            return f5 < 0.0f ? "-Infinity" : "Infinity";
        }
        int iMax = Math.max(1, 0);
        float fPow = (float) Math.pow(10.0f, iMax);
        float f10 = f5 * fPow;
        int i = (int) f10;
        if (f10 - i >= 0.5f) {
            i++;
        }
        float f11 = i / fPow;
        return iMax > 0 ? String.valueOf(f11) : String.valueOf((int) f11);
    }

    public static final o2.e a(Context context) {
        float f5 = context.getResources().getConfiguration().fontScale;
        float f10 = context.getResources().getDisplayMetrics().density;
        p2.a aVarA = p2.b.a(f5);
        p2.a aVar = aVarA;
        if (aVarA == null) {
            o2.m mVar = new o2.m();
            mVar.f9126a = f5;
            VarHandle.storeStoreFence();
            aVar = mVar;
        }
        o2.e eVar = new o2.e();
        eVar.f9111c = f10;
        eVar.f9112f = f5;
        eVar.f9113g = aVar;
        VarHandle.storeStoreFence();
        return eVar;
    }

    public static final void b(xb.a aVar, s2.k kVar, s0.c cVar, s sVar, int i) {
        int i3;
        o2.l lVar;
        Object obj;
        int i10;
        Object obj2;
        int i11;
        Object obj3;
        sVar.Z(826668973);
        if ((i & 6) == 0) {
            i3 = (sVar.h(aVar) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= sVar.f(kVar) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= sVar.h(cVar) ? ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH : 128;
        }
        int i12 = i3;
        if (sVar.P(i12 & 1, (i12 & 147) != 146)) {
            View view = (View) sVar.j(AndroidCompositionLocals_androidKt.f986f);
            o2.c cVar2 = (o2.c) sVar.j(a1.f14363h);
            o2.l lVar2 = (o2.l) sVar.j(a1.f14368n);
            p pVarY = z.y(sVar);
            c1 c1VarZ = z.z(cVar, sVar);
            Object[] objArr = new Object[0];
            Object objM = sVar.M();
            Object obj4 = k0.m.f6974a;
            Object obj5 = objM;
            if (objM == obj4) {
                Object obj6 = s2.c.f11339f;
                sVar.i0(obj6);
                obj5 = obj6;
            }
            Object[] objArrCopyOf = Arrays.copyOf(objArr, 0);
            u uVar = t0.l.f13125a;
            uVar.getClass();
            UUID uuid = (UUID) t0.a.j(objArrCopyOf, uVar, (xb.a) obj5, sVar, 3456, 0);
            boolean zF = sVar.f(view) | sVar.f(cVar2);
            Object objM2 = sVar.M();
            if (zF || objM2 == obj4) {
                s2.m mVar = new s2.m(new ContextThemeWrapper(view.getContext(), kVar.f11358e ? R.style.DialogWindowTheme : R.style.FloatingDialogWindowTheme), 0);
                mVar.f11361h = aVar;
                mVar.i = kVar;
                mVar.f11362j = view;
                float f5 = 8;
                Window window = mVar.getWindow();
                if (window == null) {
                    od.f.e("Dialog has no window");
                    return;
                }
                window.requestFeature(1);
                window.setBackgroundDrawableResource(android.R.color.transparent);
                com.stepos.statsrpk.h.F(window, mVar.i.f11358e);
                window.setGravity(17);
                if (!mVar.i.f11358e) {
                    window.addFlags(65792);
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    s2.f.f11344a.a(attributes);
                    s2.g gVar = s2.g.f11345a;
                    gVar.a(attributes, 0);
                    gVar.b(attributes, 0);
                    window.setAttributes(attributes);
                }
                s2.j jVar = new s2.j(mVar.getContext());
                jVar.f11348m = window;
                k1 k1VarV = z.v(s2.i.f11347a);
                jVar.f11349n = k1VarV;
                WeakHashMap weakHashMap = k0.f8724a;
                e0.b(jVar, jVar);
                k0.i(jVar, new r2.a(jVar, 1));
                VarHandle.storeStoreFence();
                mVar.setTitle(mVar.i.f11359f);
                jVar.setTag(R.id.compose_view_saveable_id_tag, "Dialog:" + uuid);
                jVar.setClipChildren(false);
                jVar.setElevation(cVar2.X(f5));
                jVar.setOutlineProvider(new s2.l(0));
                mVar.f11363k = jVar;
                View decorView = window.getDecorView();
                ViewGroup viewGroup = decorView instanceof ViewGroup ? (ViewGroup) decorView : null;
                if (viewGroup != null) {
                    s2.m.d(viewGroup);
                }
                mVar.setContentView(jVar);
                jVar.setTag(R.id.view_tree_lifecycle_owner, s0.d(view));
                jVar.setTag(R.id.view_tree_view_model_store_owner, s0.e(view));
                jVar.setTag(R.id.view_tree_saved_state_registry_owner, m0.i(view));
                lVar = lVar2;
                mVar.e(mVar.f11361h, mVar.i, lVar);
                s2.a aVar2 = new s2.a(mVar, 1);
                androidx.activity.e0 e0Var = mVar.f695g;
                e0Var.getClass();
                e0Var.a(mVar, new f0(aVar2, 0));
                VarHandle.storeStoreFence();
                s0.c cVar3 = new s0.c(346960332, true, new b0.s(c1VarZ, 3));
                jVar.setParentCompositionContext(pVarY);
                k1VarV.setValue(cVar3);
                jVar.f11353r = true;
                if (jVar.f14327h == null && !jVar.isAttachedToWindow()) {
                    od.f.e("createComposition requires either a parent reference or the View to be attachedto a window. Attach the View or call setParentCompositionReference.");
                    return;
                } else {
                    jVar.c();
                    sVar.i0(mVar);
                    obj = mVar;
                }
            } else {
                lVar = lVar2;
                obj = objM2;
            }
            s2.m mVar2 = (s2.m) obj;
            boolean zH = sVar.h(mVar2);
            Object objM3 = sVar.M();
            if (zH || objM3 == obj4) {
                i10 = 1;
                Object fVar = new k8.f(mVar2, null, i10);
                sVar.i0(fVar);
                obj2 = fVar;
            } else {
                i10 = 1;
                obj2 = objM3;
            }
            z.h(v.f6774a, sVar, (xb.p) obj2);
            boolean zH2 = sVar.h(mVar2);
            Object objM4 = sVar.M();
            if (zH2 || objM4 == obj4) {
                i11 = 0;
                Object aVar3 = new s2.a(mVar2, i11);
                sVar.i0(aVar3);
                obj3 = aVar3;
            } else {
                i11 = 0;
                obj3 = objM4;
            }
            z.d(mVar2, (xb.l) obj3, sVar);
            int i13 = (sVar.h(mVar2) ? 1 : 0) | ((i12 & 14) == 4 ? i10 : i11) | ((i12 & 112) == 32 ? i10 : i11) | (sVar.d(lVar.ordinal()) ? 1 : 0);
            Object objM5 = sVar.M();
            Object obj7 = objM5;
            if (i13 != 0 || objM5 == obj4) {
                Object f0Var = new s.f0(mVar2, aVar, kVar, lVar);
                sVar.i0(f0Var);
                obj7 = f0Var;
            }
            z.j((xb.a) obj7, sVar);
        } else {
            sVar.S();
        }
        v1 v1VarS = sVar.s();
        if (v1VarS != null) {
            v1VarS.f7091d = new b0.u(aVar, kVar, cVar, i, 2);
        }
    }

    public static final void c(w0.m mVar, xb.p pVar, s sVar, int i) {
        int i3;
        sVar.Z(1090521195);
        if ((i & 6) == 0) {
            i3 = (sVar.f(mVar) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= sVar.h(pVar) ? 32 : 16;
        }
        if (sVar.P(i3 & 1, (i3 & 19) != 18)) {
            Object objM = sVar.M();
            if (objM == k0.m.f6974a) {
                objM = s2.d.f11342a;
                sVar.i0(objM);
            }
            s1.f0 f0Var = (s1.f0) objM;
            int iHashCode = Long.hashCode(sVar.T);
            s0.g gVarL = sVar.l();
            w0.m mVarM = t.o.m(sVar, mVar);
            u1.j.f13840e.getClass();
            u1.z zVar = u1.i.f13833b;
            int i10 = (((((i3 << 3) & 112) | (((i3 >> 3) & 14) | 384)) << 6) & 896) | 6;
            sVar.b0();
            if (sVar.S) {
                sVar.k(zVar);
            } else {
                sVar.l0();
            }
            z.B(f0Var, sVar, u1.i.f13836e);
            z.B(gVarL, sVar, u1.i.f13835d);
            u1.h hVar = u1.i.f13837f;
            if (sVar.S || !yb.k.a(sVar.M(), Integer.valueOf(iHashCode))) {
                k0.a.y(iHashCode, sVar, iHashCode, hVar);
            }
            z.B(mVarM, sVar, u1.i.f13834c);
            pVar.invoke(sVar, Integer.valueOf((i10 >> 6) & 14));
            sVar.q(true);
        } else {
            sVar.S();
        }
        v1 v1VarS = sVar.s();
        if (v1VarS != null) {
            v1VarS.f7091d = new b0.c(mVar, i, 2, pVar);
        }
    }

    public static final void d(b8.p pVar, o1.s sVar) {
        p1.c cVar = (p1.c) pVar.f2003f;
        p1.c cVar2 = (p1.c) pVar.f2005h;
        boolean zA = q.a(sVar);
        long j10 = sVar.f9072b;
        long j11 = 0;
        if (zA) {
            p1.a[] aVarArr = cVar2.f9687c;
            kb.k.m0(null, 0, aVarArr, aVarArr.length);
            cVar2.f9688d = 0;
            p1.a[] aVarArr2 = cVar.f9687c;
            kb.k.m0(null, 0, aVarArr2, aVarArr2.length);
            cVar.f9688d = 0;
            pVar.f2004g = 0L;
        }
        if (!q.b(sVar)) {
            List list = sVar.f9080k;
            if (list == null) {
                list = kb.s.f7404c;
            }
            int size = list.size();
            int i = 0;
            while (i < size) {
                o1.c cVar3 = (o1.c) list.get(i);
                long j12 = cVar3.f9004a;
                long jH = c1.b.h(cVar3.f9006c, j11);
                cVar2.a(Float.intBitsToFloat((int) (jH >> 32)), j12);
                cVar.a(Float.intBitsToFloat((int) (jH & 4294967295L)), j12);
                i++;
                j11 = 0;
            }
            long jH2 = c1.b.h(sVar.f9081l, 0L);
            cVar2.a(Float.intBitsToFloat((int) (jH2 >> 32)), j10);
            cVar.a(Float.intBitsToFloat((int) (jH2 & 4294967295L)), j10);
        }
        if (q.b(sVar) && j10 - pVar.f2004g > 40) {
            p1.a[] aVarArr3 = cVar2.f9687c;
            kb.k.m0(null, 0, aVarArr3, aVarArr3.length);
            cVar2.f9688d = 0;
            p1.a[] aVarArr4 = cVar.f9687c;
            kb.k.m0(null, 0, aVarArr4, aVarArr4.length);
            cVar.f9688d = 0;
            pVar.f2004g = 0L;
        }
        pVar.f2004g = j10;
    }

    public static void e(StringBuilder sb2, Object obj, xb.l lVar) {
        if (lVar != null) {
            sb2.append((CharSequence) lVar.invoke(obj));
            return;
        }
        if (obj == null ? true : obj instanceof CharSequence) {
            sb2.append((CharSequence) obj);
        } else if (obj instanceof Character) {
            sb2.append(((Character) obj).charValue());
        } else {
            sb2.append((CharSequence) obj.toString());
        }
    }

    public static int f(AttributeSet attributeSet, String str) {
        if (attributeSet == null) {
            return -1;
        }
        int attributeCount = attributeSet.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            if (yb.k.a(attributeSet.getAttributeName(i), str)) {
                return i;
            }
        }
        return -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object g(mc.r r5, xb.a r6, pb.c r7) {
        /*
            boolean r0 = r7 instanceof mc.q
            if (r0 == 0) goto L13
            r0 = r7
            mc.q r0 = (mc.q) r0
            int r1 = r0.f8602g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f8602g = r1
            goto L18
        L13:
            mc.q r0 = new mc.q
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f8601f
            ob.a r1 = ob.a.f9351c
            int r2 = r0.f8602g
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L32
            if (r2 != r4) goto L2c
            xb.a r6 = r0.f8600c
            I(r7)     // Catch: java.lang.Throwable -> L2a
            goto L65
        L2a:
            r5 = move-exception
            goto L6b
        L2c:
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r5)
            return r3
        L32:
            I(r7)
            nb.g r7 = r0.getContext()
            kc.w0 r2 = kc.w0.f7498c
            nb.e r7 = r7.get(r2)
            if (r7 != r5) goto L6f
            r0.f8600c = r6     // Catch: java.lang.Throwable -> L2a
            r0.f8602g = r4     // Catch: java.lang.Throwable -> L2a
            kc.g r7 = new kc.g     // Catch: java.lang.Throwable -> L2a
            nb.c r0 = td.h.y(r0)     // Catch: java.lang.Throwable -> L2a
            r7.<init>(r4, r0)     // Catch: java.lang.Throwable -> L2a
            r7.s()     // Catch: java.lang.Throwable -> L2a
            j9.f r0 = new j9.f     // Catch: java.lang.Throwable -> L2a
            r0.<init>(r4)     // Catch: java.lang.Throwable -> L2a
            r0.f6662f = r7     // Catch: java.lang.Throwable -> L2a
            java.lang.invoke.VarHandle.storeStoreFence()     // Catch: java.lang.Throwable -> L2a
            r5.d0(r0)     // Catch: java.lang.Throwable -> L2a
            java.lang.Object r5 = r7.r()     // Catch: java.lang.Throwable -> L2a
            if (r5 != r1) goto L65
            return r1
        L65:
            r6.invoke()
            jb.v r5 = jb.v.f6774a
            return r5
        L6b:
            r6.invoke()
            throw r5
        L6f:
            java.lang.String r5 = "awaitClose() can only be invoked from the producer context"
            od.f.e(r5)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: id.c.g(mc.r, xb.a, pb.c):java.lang.Object");
    }

    public static void h(String str) {
        if (str.length() <= 0) {
            g5.f.s("name is empty");
            return;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if ('!' > cCharAt || cCharAt >= 127) {
                od.f.c(bd.b.h("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(cCharAt), Integer.valueOf(i), str));
                return;
            }
        }
    }

    public static void i(String str, String str2) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt != '\t' && (' ' > cCharAt || cCharAt >= 127)) {
                od.f.c(bd.b.h("Unexpected char %#04x at %d in %s value", Integer.valueOf(cCharAt), Integer.valueOf(i), str2).concat(bd.b.p(str2) ? "" : ": ".concat(str)));
                return;
            }
        }
    }

    public static ad.n j(ad.n nVar, ad.n nVar2) {
        ne.b bVar = new ne.b();
        int size = nVar.size();
        for (int i = 0; i < size; i++) {
            String strB = nVar.b(i);
            String strD = nVar.d(i);
            if ((!"Warning".equalsIgnoreCase(strB) || !o.U(strD, "1", false)) && (HttpHeaders.CONTENT_LENGTH.equalsIgnoreCase(strB) || "Content-Encoding".equalsIgnoreCase(strB) || HttpHeaders.CONTENT_TYPE.equalsIgnoreCase(strB) || !w(strB) || nVar2.a(strB) == null)) {
                bVar.c(strB, strD);
            }
        }
        int size2 = nVar2.size();
        for (int i3 = 0; i3 < size2; i3++) {
            String strB2 = nVar2.b(i3);
            if (!HttpHeaders.CONTENT_LENGTH.equalsIgnoreCase(strB2) && !"Content-Encoding".equalsIgnoreCase(strB2) && !HttpHeaders.CONTENT_TYPE.equalsIgnoreCase(strB2) && w(strB2)) {
                bVar.c(strB2, nVar2.d(i3));
            }
        }
        return bVar.d();
    }

    public static a4.v k(Context context) {
        ProviderInfo providerInfo;
        k3.c cVar;
        ApplicationInfo applicationInfo;
        PackageManager packageManager = context.getPackageManager();
        p5.f.k(packageManager, "Package manager required to locate emoji font provider");
        Iterator<ResolveInfo> it = packageManager.queryIntentContentProviders(new Intent("androidx.content.action.LOAD_EMOJI_FONT"), 0).iterator();
        while (true) {
            if (!it.hasNext()) {
                providerInfo = null;
                break;
            }
            providerInfo = it.next().providerInfo;
            if (providerInfo != null && (applicationInfo = providerInfo.applicationInfo) != null && (applicationInfo.flags & 1) == 1) {
                break;
            }
        }
        if (providerInfo == null) {
            cVar = null;
        } else {
            try {
                String str = providerInfo.authority;
                String str2 = providerInfo.packageName;
                Signature[] signatureArr = packageManager.getPackageInfo(str2, 64).signatures;
                ArrayList arrayList = new ArrayList();
                for (Signature signature : signatureArr) {
                    arrayList.add(signature.toByteArray());
                }
                cVar = new k3.c(str, str2, "emojicompat-emoji-font", Collections.singletonList(arrayList), null, null);
            } catch (PackageManager.NameNotFoundException e10) {
                Log.wtf("emoji2.text.DefaultEmojiConfig", e10);
            }
        }
        if (cVar == null) {
            return null;
        }
        a4.u uVar = new a4.u();
        uVar.f204d = new Object();
        uVar.f201a = context.getApplicationContext();
        uVar.f202b = cVar;
        uVar.f203c = a4.v.f209d;
        VarHandle.storeStoreFence();
        return new a4.v(uVar);
    }

    public static final jb.h l(Throwable th) {
        th.getClass();
        jb.h hVar = new jb.h();
        hVar.f6761c = th;
        VarHandle.storeStoreFence();
        return hVar;
    }

    public static y0 m(Class cls) throws IllegalAccessException, NoSuchMethodException, InstantiationException, SecurityException, IllegalArgumentException, InvocationTargetException {
        try {
            Constructor declaredConstructor = cls.getDeclaredConstructor(null);
            if (!Modifier.isPublic(declaredConstructor.getModifiers())) {
                ad.o.k(cls, "Cannot create an instance of ");
                return null;
            }
            try {
                Object objNewInstance = declaredConstructor.newInstance(null);
                objNewInstance.getClass();
                return (y0) objNewInstance;
            } catch (IllegalAccessException e10) {
                b8.z.v(e10, cls, "Cannot create an instance of ");
                return null;
            } catch (InstantiationException e11) {
                b8.z.v(e11, cls, "Cannot create an instance of ");
                return null;
            }
        } catch (NoSuchMethodException e12) {
            b8.z.v(e12, cls, "Cannot create an instance of ");
            return null;
        }
    }

    public static final long n() {
        return Thread.currentThread().getId();
    }

    public static final float p(float[] fArr, float[] fArr2) {
        int length = fArr.length;
        float f5 = 0.0f;
        for (int i = 0; i < length; i++) {
            f5 += fArr[i] * fArr2[i];
        }
        return f5;
    }

    public static View r(cb.i iVar, int i) {
        int childCount = iVar.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View viewFindViewById = iVar.getChildAt(i3).findViewById(i);
            if (viewFindViewById != null) {
                return viewFindViewById;
            }
        }
        return null;
    }

    public static final ViewParent s(View view) {
        ViewParent parent = view.getParent();
        if (parent != null) {
            return parent;
        }
        Object tag = view.getTag(R.id.view_tree_disjoint_parent);
        if (tag instanceof ViewParent) {
            return (ViewParent) tag;
        }
        return null;
    }

    public static final int t(KeyEvent keyEvent) {
        int action = keyEvent.getAction();
        if (action != 0) {
            return action != 1 ? 0 : 1;
        }
        return 2;
    }

    public static boolean u(AttributeSet attributeSet, String str) {
        if (attributeSet != null) {
            int attributeCount = attributeSet.getAttributeCount();
            for (int i = 0; i < attributeCount; i++) {
                if (yb.k.a(attributeSet.getAttributeName(i), str)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static final boolean v(Spanned spanned, Class cls) {
        return spanned.nextSpanTransition(-1, spanned.length(), cls) != spanned.length();
    }

    public static boolean w(String str) {
        return ("Connection".equalsIgnoreCase(str) || "Keep-Alive".equalsIgnoreCase(str) || "Proxy-Authenticate".equalsIgnoreCase(str) || "Proxy-Authorization".equalsIgnoreCase(str) || "TE".equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || "Transfer-Encoding".equalsIgnoreCase(str) || "Upgrade".equalsIgnoreCase(str)) ? false : true;
    }

    public static final g5.j x(g5.j jVar, String str, Executor executor, xb.a aVar) {
        jVar.getClass();
        executor.getClass();
        y yVar = g5.j.f4324d;
        d0 d0Var = new d0();
        d0Var.f1371a = new Object();
        d0Var.f1372b = new o.f();
        d0Var.f1374d = d0.f1370h;
        c0 c0Var = new c0();
        c0Var.f1365c = d0Var;
        VarHandle.storeStoreFence();
        d0Var.f1377g = c0Var;
        d0Var.f1373c = yVar;
        VarHandle.storeStoreFence();
        ab.h hVar = new ab.h();
        hVar.f412a = executor;
        hVar.f413b = jVar;
        hVar.f414c = str;
        hVar.f415d = aVar;
        hVar.f416e = d0Var;
        VarHandle.storeStoreFence();
        t.n.i(hVar);
        return new g5.j();
    }

    public static boolean y(Context context) {
        boolean z10;
        try {
            Bundle bundle = new Bundle();
            bundle.putBoolean("PERMISSION_CLOUD_RESET_DONE", true);
            z10 = PerfBinderClient.INSTANCE.safeIpcRequest("com.stepos.appplatform", "com.stepos.appplatform.agentsafetycenter.AgentSafetySettingsSystem", "markPermissionCloudResetDone", bundle).getBoolean("RESULT", false);
        } catch (Exception e10) {
            Log.w("AscPerfBinder", "markPermissionCloudResetDone failed", e10);
            z10 = false;
        }
        if (!z10) {
            Log.w("PermCloudResetMarker", "markDone via AppPlatform failed");
            return false;
        }
        Context applicationContext = context.getApplicationContext();
        applicationContext.getClass();
        boolean zA = yb.k.a(Settings.Global.getString(applicationContext.getContentResolver(), "stepos_agentsafetycenter_permission_cloud_reset_done"), "1");
        if (!zA) {
            Log.w("PermCloudResetMarker", "markDone write ok but local read-back still not done");
        }
        return zA;
    }

    public static ad.n z(String... strArr) {
        if (strArr.length % 2 != 0) {
            g5.f.s("Expected alternating header names and values");
            return null;
        }
        String[] strArr2 = (String[]) strArr.clone();
        int length = strArr2.length;
        int i = 0;
        for (int i3 = 0; i3 < length; i3++) {
            String str = strArr2[i3];
            if (str == null) {
                g5.f.s("Headers cannot be null");
                return null;
            }
            strArr2[i3] = hc.h.w0(str).toString();
        }
        int iR = com.stepos.statsrpk.h.r(0, strArr2.length - 1, 2);
        if (iR >= 0) {
            while (true) {
                String str2 = strArr2[i];
                String str3 = strArr2[i + 1];
                h(str2);
                i(str3, str2);
                if (i == iR) {
                    break;
                }
                i += 2;
            }
        }
        return new ad.n(strArr2);
    }

    public abstract String o(byte[] bArr, int i, int i3);

    public abstract int q(String str, byte[] bArr, int i, int i3);
}
