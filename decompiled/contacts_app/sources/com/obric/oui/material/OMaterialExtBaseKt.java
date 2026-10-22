package com.obric.oui.material;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.GlobalProxyLancet;
import com.obric.oui.common.style.IOUILayout;
import com.obric.oui.common.style.Shadow;
import com.obric.oui.res.BlendConfigStateList;
import com.obric.oui.shadow.ShadowConfig;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OMaterialExtBase.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0014\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0002\u001a\f\u0010\t\u001a\u00020\u0002*\u00020\nH\u0002\u001a0\u0010\u000b\u001a\u00020\u0001*\u00020\f2\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e\u001a&\u0010\u0011\u001a\u00020\u0001*\u00020\f2\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e\u001a;\u0010\u0012\u001a\u00020\u0001*\u00020\f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u00142\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e¢\u0006\u0002\u0010\u0015\u001a1\u0010\u0016\u001a\u00020\u0001*\u00020\f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u00142\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e¢\u0006\u0002\u0010\u0017\u001a\n\u0010\u0018\u001a\u00020\u000e*\u00020\u0019\u001a\n\u0010\u0018\u001a\u00020\u000e*\u00020\u0002\u001a\n\u0010\u001a\u001a\u00020\u0004*\u00020\u0019\u001a\n\u0010\u001a\u001a\u00020\u0004*\u00020\u0002\u001a\u001c\u0010\u0007\u001a\u00020\u0001*\u00020\u001b2\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\u000e\u001a\u001c\u0010\u0007\u001a\u00020\u0001*\u00020\u001c2\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\u000e\u001a&\u0010\u0007\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u001d\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u000e\u001a&\u0010\u0007\u001a\u00020\u0001*\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u001d\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u000e\u001a\u0012\u0010\u0007\u001a\u00020\u0001*\u00020\u001e2\u0006\u0010\u0007\u001a\u00020\b\u001a\u0012\u0010\u001f\u001a\u00020\u0001*\u00020\u001b2\u0006\u0010\u0007\u001a\u00020\b\u001a\u0012\u0010\u001f\u001a\u00020\u0001*\u00020\u001c2\u0006\u0010\u0007\u001a\u00020\b\u001a\u001c\u0010\u001f\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u001d\u001a\u00020\u0004\u001a\u001c\u0010\u001f\u001a\u00020\u0001*\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u001d\u001a\u00020\u0004\u001a\u0012\u0010\u001f\u001a\u00020\u0001*\u00020\u001e2\u0006\u0010\u0007\u001a\u00020\b\u001a'\u0010\u0013\u001a\u00020\u0001*\u00020\u001b2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u00142\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010 \u001a'\u0010\u0013\u001a\u00020\u0001*\u00020\u001c2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u00142\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010!\u001a=\u0010\u0013\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u00142\b\b\u0002\u0010\u001d\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010#\u001a1\u0010\u0013\u001a\u00020\u0001*\u00020\n2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u00142\b\b\u0002\u0010\u001d\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010$\u001a'\u0010\u0013\u001a\u00020\u0001*\u00020\n2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u00142\b\u0010\"\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010%\u001a)\u0010\u0013\u001a\u00020\u0001*\u00020\u001e2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u00142\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010&\u001a3\u0010'\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u00142\b\b\u0002\u0010\u001d\u001a\u00020\u00042\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010(\u001a3\u0010'\u001a\u00020\u0001*\u00020\n2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u00142\b\b\u0002\u0010\u001d\u001a\u00020\u00042\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010)\u001a\u001d\u0010*\u001a\u00020\u0001*\u00020\u001b2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0014¢\u0006\u0002\u0010+\u001a\u001d\u0010*\u001a\u00020\u0001*\u00020\u001c2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0014¢\u0006\u0002\u0010,\u001a3\u0010*\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u00142\b\b\u0002\u0010\u001d\u001a\u00020\u00042\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010(\u001a3\u0010*\u001a\u00020\u0001*\u00020\n2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u00142\b\b\u0002\u0010\u001d\u001a\u00020\u00042\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010)\u001a)\u0010*\u001a\u00020\u0001*\u00020\u001e2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u00142\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010&\u001a\u001c\u0010-\u001a\u00020\u0001*\u00020\u001b2\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\u000e\u001a\u001c\u0010-\u001a\u00020\u0001*\u00020\u001c2\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\u000e\u001a&\u0010-\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u001d\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u000e\u001a&\u0010-\u001a\u00020\u0001*\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u001d\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u000e\u001a\u001c\u0010-\u001a\u00020\u0001*\u00020\u001e2\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\u000e\u001a\u0012\u0010.\u001a\u00020\u0001*\u00020\u001b2\u0006\u0010/\u001a\u00020\u0002\u001a\u0012\u0010.\u001a\u00020\u0001*\u00020\u001c2\u0006\u0010/\u001a\u00020\u0002\u001a\u0014\u0010.\u001a\u00020\u0001*\u00020\u00022\b\u0010/\u001a\u0004\u0018\u00010\u0002\u001a\u001c\u00100\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u001d\u001a\u00020\u0004\u001a\u001c\u00100\u001a\u00020\u0001*\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u001d\u001a\u00020\u0004\u001a'\u00101\u001a\u00020\u0001*\u00020\u001b2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u00142\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010 \u001a'\u00101\u001a\u00020\u0001*\u00020\u001c2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u00142\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010!\u001a1\u00101\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u00142\b\b\u0002\u0010\u001d\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u00102\u001a1\u00101\u001a\u00020\u0001*\u00020\n2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u00142\b\b\u0002\u0010\u001d\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010$\u001a'\u00101\u001a\u00020\u0001*\u00020\u001e2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u00142\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u00103\u001a\u0012\u00104\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\r\u001a\u00020\u000e\u001a\u0012\u00105\u001a\u00020\u0001*\u00020\u001b2\u0006\u00106\u001a\u00020\u0004\u001a\u0012\u00105\u001a\u00020\u0001*\u00020\u001c2\u0006\u00106\u001a\u00020\u0004\u001a\u0012\u00105\u001a\u00020\u0001*\u00020\u00022\u0006\u00106\u001a\u00020\u0004\u001a\u0012\u00107\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\b\u001a\u0012\u00107\u001a\u00020\u0001*\u00020\u00022\u0006\u00108\u001a\u000209¨\u0006:"}, d2 = {"applyMaterial", "", "Landroid/view/View;", "enable", "", "applyMaterialFromWindow", "applyMaterialShadow", "material", "Lcom/obric/oui/material/MaterialConfig;", "asMaterialView", "Landroid/widget/Button;", "contentMaterial", "Landroid/widget/ImageView;", "srcType", "", "drawMode", "drawableSrc", "contentMaterialFromWindow", "contentMaterials", "materials", "", "(Landroid/widget/ImageView;[Lcom/obric/oui/material/MaterialConfig;III)V", "contentMaterialsFromWindow", "(Landroid/widget/ImageView;[Lcom/obric/oui/material/MaterialConfig;II)V", "getMaterialLevel", "Landroid/content/Context;", "isMaterialEffectEnabled", "Landroid/graphics/Paint;", "Landroid/graphics/drawable/Drawable;", "clearBackground", "Landroid/widget/TextView;", "materialFromWindow", "(Landroid/graphics/Paint;[Lcom/obric/oui/material/MaterialConfig;I)V", "(Landroid/graphics/drawable/Drawable;[Lcom/obric/oui/material/MaterialConfig;I)V", "level", "(Landroid/view/View;[Lcom/obric/oui/material/MaterialConfig;ZILjava/lang/Integer;)V", "(Landroid/widget/Button;[Lcom/obric/oui/material/MaterialConfig;ZI)V", "(Landroid/widget/Button;[Lcom/obric/oui/material/MaterialConfig;Ljava/lang/Integer;)V", "(Landroid/widget/TextView;[Lcom/obric/oui/material/MaterialConfig;Ljava/lang/Integer;)V", "materialsComplex", "(Landroid/view/View;[Lcom/obric/oui/material/MaterialConfig;ZLjava/lang/Integer;)V", "(Landroid/widget/Button;[Lcom/obric/oui/material/MaterialConfig;ZLjava/lang/Integer;)V", "materialsFromWindow", "(Landroid/graphics/Paint;[Lcom/obric/oui/material/MaterialConfig;)V", "(Landroid/graphics/drawable/Drawable;[Lcom/obric/oui/material/MaterialConfig;)V", "setMaterial", "setMaterialBackdropTarget", "target", "setMaterialFromWindow", "setMaterials", "(Landroid/view/View;[Lcom/obric/oui/material/MaterialConfig;ZI)V", "(Landroid/widget/TextView;[Lcom/obric/oui/material/MaterialConfig;I)V", "updateMaterialBackdropSrcType", "updateMaterialBackdropTargetType", "backdropView", "updateStatefulOverlayBlend", "overlayBlendConfigs", "Lcom/obric/oui/res/BlendConfigStateList;", "OUI_standardRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class OMaterialExtBaseKt {
    public static final boolean isMaterialEffectEnabled(View r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return OMaterialHelper.isMaterialEffectEnabled(r1.getContext());
    }

    public static final boolean isMaterialEffectEnabled(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return OMaterialHelper.isMaterialEffectEnabled(r1);
    }

    public static final int getMaterialLevel(View r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return OMaterialHelper.getMaterialLevel(r1.getContext());
    }

    public static final int getMaterialLevel(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return OMaterialHelper.getMaterialLevel(r1);
    }

    public static final void applyMaterial(View r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        OMaterialHelper.applyMaterial(r1, r2);
    }

    public static final void applyMaterialFromWindow(View r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        OMaterialHelper.applyMaterialFromWindow(r1, r2);
    }

    public static /* synthetic */ void materials$default(View r0, MaterialConfig[] r1, boolean r2, int r3, Integer r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r2 = false;
    L6:
        if ((r5 & 4) == 0) goto L9;
        r3 = 2;
    L9:
        if ((r5 & 8) == 0) goto L11;
        r4 = null;
    L11:
        materials(r0, r1, r2, r3, r4);
    }

    public static final void materials(View r2, MaterialConfig[] r3, boolean r4, int r5, Integer r6) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "materials");
        if (r6 == null) goto L5;
        setMaterial(r2, r3[r6.intValue() - 1], r4, r5);     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e("OUIMaterial", "error!! View.materials: error level=" + r6 + ", " + e);
        return;
    L5:
        if (r3.length != 1) goto L8;
        material(r2, r3[0], r4, r5);
        return;
    L8:
        setMaterials(r2, r3, r4, r5);
        applyMaterialShadow(r2, r3[Math.min(r3.length - 1, Math.max(0, getMaterialLevel(r2) - 1))]);
    }

    public static /* synthetic */ void materialsFromWindow$default(View r0, MaterialConfig[] r1, boolean r2, Integer r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = false;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = null;
    L8:
        materialsFromWindow(r0, r1, r2, r3);
    }

    public static final void materialsFromWindow(View r8, MaterialConfig[] r9, boolean r10, Integer r11) {
        Intrinsics.checkNotNullParameter(r8, "<this>");
        Intrinsics.checkNotNullParameter(r9, "materials");
        boolean r0 = true;
        if (r11 == null) goto L5;
        material(r8, r9[r11.intValue() - 1], r10, 3);     // Catch: Exception -> L13
        return;
    L13:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e("OUIMaterial", "error!! View.materialsFromWindow: error level=" + r11 + ", " + e);
        return;
    L5:
        if (r9.length == 0) goto L8;
        r0 = false;
    L8:
        if (r0 == false) goto L10;
        return;
    L10:
        materials$default(r8, r9, r10, 3, null, 8, null);
    }

    public static /* synthetic */ void materialsComplex$default(View r0, MaterialConfig[] r1, boolean r2, Integer r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = false;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = null;
    L8:
        materialsComplex(r0, r1, r2, r3);
    }

    public static final void materialsComplex(View r8, MaterialConfig[] r9, boolean r10, Integer r11) {
        Intrinsics.checkNotNullParameter(r8, "<this>");
        Intrinsics.checkNotNullParameter(r9, "materials");
        if (r11 != null) goto L10;
        materials$default(r8, r9, r10, 5, null, 8, null);
        return;
    L10:
        material(r8, r9[r11.intValue() - 1], r10, 5);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e("OUIMaterial", "error!! View.materialsComplex: error level=" + r11 + ", " + e);
    }

    public static /* synthetic */ void setMaterials$default(View r0, MaterialConfig[] r1, boolean r2, int r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = false;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 2;
    L8:
        setMaterials(r0, r1, r2, r3);
    }

    public static final void setMaterials(View r1, MaterialConfig[] r2, boolean r3, int r4) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "materials");
        if (r3 == false) goto L5;
        r1.setBackgroundColor(0);
    L5:
        OMaterialHelper.setMaterials(r1, r4, r2);
    }

    public static /* synthetic */ void material$default(View r0, MaterialConfig r1, boolean r2, int r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = false;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 2;
    L8:
        material(r0, r1, r2, r3);
    }

    public static final void material(View r1, MaterialConfig r2, boolean r3, int r4) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "material");
        setMaterial(r1, r2, r3, r4);
    }

    public static /* synthetic */ void setMaterial$default(View r0, MaterialConfig r1, boolean r2, int r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = false;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 2;
    L8:
        setMaterial(r0, r1, r2, r3);
    }

    public static final void setMaterial(View r1, MaterialConfig r2, boolean r3, int r4) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "material");
        applyMaterialShadow(r1, r2);
        if (OMaterialHelper.isSupportObricMaterial() == true) goto L5;
        return;
    L5:
        if (r3 == false) goto L7;
        r1.setBackgroundColor(0);
    L7:
        OMaterialHelper.setMaterial(r1, r4, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final void applyMaterialShadow(View r5, MaterialConfig r6) {
        if ((r5 instanceof IOUILayout) == false) goto L18;
        IOUILayout r0 = (IOUILayout) r5;
        if (r0.isEnableShadowWidthRadius() == false) goto L21;
        ShadowConfig[] r7 = r6.getShadow();
        if (r7 != null) goto L12;
        r0.setShadow(null, null);
        return;
    L12:
        if (r7.length <= 1) goto L15;
        float r8 = r5.getResources().getDisplayMetrics().density;
        r0.setShadow(Shadow.Companion.fromConfigWithDensity(r7[0], r8), Shadow.Companion.fromConfigWithDensity(r7[1], r8));
        return;
    L15:
        if (r7.length != 1) goto L20;
        float r9 = r5.getResources().getDisplayMetrics().density;
        r0.setShadow(Shadow.Companion.fromConfigWithDensity(r7[0], r9), null);
        return;
    L20:
        return;
    L21:
        return;
    }

    public static /* synthetic */ void materialFromWindow$default(View r0, MaterialConfig r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = false;
    L5:
        materialFromWindow(r0, r1, r2);
    }

    public static final void materialFromWindow(View r1, MaterialConfig r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "material");
        setMaterial(r1, r2, r3, 3);
    }

    public static /* synthetic */ void setMaterialFromWindow$default(View r0, MaterialConfig r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = false;
    L5:
        setMaterialFromWindow(r0, r1, r2);
    }

    public static final void setMaterialFromWindow(View r1, MaterialConfig r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "material");
        setMaterial(r1, r2, r3, 3);
    }

    private static final View asMaterialView(Button r0) {
        return r0;
    }

    public static /* synthetic */ void materials$default(Button r0, MaterialConfig[] r1, boolean r2, int r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = false;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 2;
    L8:
        materials(r0, r1, r2, r3);
    }

    public static final void materials(Button r8, MaterialConfig[] r9, boolean r10, int r11) {
        Intrinsics.checkNotNullParameter(r8, "<this>");
        Intrinsics.checkNotNullParameter(r9, "materials");
        materials$default(asMaterialView(r8), r9, r10, r11, null, 8, null);
    }

    public static final void materials(Button r8, MaterialConfig[] r9, Integer r10) {
        Intrinsics.checkNotNullParameter(r8, "<this>");
        Intrinsics.checkNotNullParameter(r9, "materials");
        materials$default(asMaterialView(r8), r9, false, 0, r10, 6, null);
    }

    public static /* synthetic */ void materialsFromWindow$default(Button r0, MaterialConfig[] r1, boolean r2, Integer r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = false;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = null;
    L8:
        materialsFromWindow(r0, r1, r2, r3);
    }

    public static final void materialsFromWindow(Button r1, MaterialConfig[] r2, boolean r3, Integer r4) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "materials");
        materialsFromWindow(asMaterialView(r1), r2, r3, r4);
    }

    public static /* synthetic */ void setMaterials$default(Button r0, MaterialConfig[] r1, boolean r2, int r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = false;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 2;
    L8:
        setMaterials(r0, r1, r2, r3);
    }

    public static final void setMaterials(Button r1, MaterialConfig[] r2, boolean r3, int r4) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "materials");
        setMaterials(asMaterialView(r1), r2, r3, r4);
    }

    public static /* synthetic */ void materialsComplex$default(Button r0, MaterialConfig[] r1, boolean r2, Integer r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = false;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = null;
    L8:
        materialsComplex(r0, r1, r2, r3);
    }

    public static final void materialsComplex(Button r1, MaterialConfig[] r2, boolean r3, Integer r4) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "materials");
        materialsComplex(asMaterialView(r1), r2, r3, r4);
    }

    public static /* synthetic */ void material$default(Button r0, MaterialConfig r1, boolean r2, int r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = false;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 2;
    L8:
        material(r0, r1, r2, r3);
    }

    public static final void material(Button r1, MaterialConfig r2, boolean r3, int r4) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "material");
        material(asMaterialView(r1), r2, r3, r4);
    }

    public static /* synthetic */ void setMaterial$default(Button r0, MaterialConfig r1, boolean r2, int r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = false;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 2;
    L8:
        setMaterial(r0, r1, r2, r3);
    }

    public static final void setMaterial(Button r1, MaterialConfig r2, boolean r3, int r4) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "material");
        setMaterial(asMaterialView(r1), r2, r3, r4);
    }

    public static /* synthetic */ void materialFromWindow$default(Button r0, MaterialConfig r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = false;
    L5:
        materialFromWindow(r0, r1, r2);
    }

    public static final void materialFromWindow(Button r1, MaterialConfig r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "material");
        materialFromWindow(asMaterialView(r1), r2, r3);
    }

    public static /* synthetic */ void setMaterialFromWindow$default(Button r0, MaterialConfig r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = false;
    L5:
        setMaterialFromWindow(r0, r1, r2);
    }

    public static final void setMaterialFromWindow(Button r1, MaterialConfig r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "material");
        setMaterialFromWindow(asMaterialView(r1), r2, r3);
    }

    public static final void material(TextView r3, MaterialConfig r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "material");
        setMaterial$default(r3, r4, 0, 2, null);
    }

    public static /* synthetic */ void materials$default(TextView r0, MaterialConfig[] r1, Integer r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        materials(r0, r1, r2);
    }

    public static final void materials(TextView r4, MaterialConfig[] r5, Integer r6) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, "materials");
        if (r6 != null) goto L10;
        setMaterials$default(r4, r5, 0, 2, null);
        return;
    L10:
        setMaterial$default(r4, r5[r6.intValue() - 1], 0, 2, null);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e("OUIMaterial", "error!! TextView.materials: error level=" + r6 + ", " + e);
    }

    public static final void materialFromWindow(TextView r1, MaterialConfig r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "material");
        setMaterial(r1, r2, 3);
    }

    public static /* synthetic */ void materialsFromWindow$default(TextView r0, MaterialConfig[] r1, Integer r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        materialsFromWindow(r0, r1, r2);
    }

    public static final void materialsFromWindow(TextView r2, MaterialConfig[] r3, Integer r4) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "materials");
        if (r4 != null) goto L10;
        setMaterials(r2, r3, 3);
        return;
    L10:
        setMaterial(r2, r3[r4.intValue() - 1], 3);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e("OUIMaterial", "error!! TextView.materialsFromWindow: error level=" + r4 + ", " + e);
    }

    public static /* synthetic */ void setMaterial$default(TextView r0, MaterialConfig r1, int r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = 2;
    L5:
        setMaterial(r0, r1, r2);
    }

    public static final void setMaterial(TextView r1, MaterialConfig r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "material");
        OMaterialHelper.setTextMaterial(r1, r3, r2);
    }

    public static /* synthetic */ void setMaterials$default(TextView r0, MaterialConfig[] r1, int r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = 2;
    L5:
        setMaterials(r0, r1, r2);
    }

    public static final void setMaterials(TextView r1, MaterialConfig[] r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "materials");
        OMaterialHelper.setTextMaterials(r1, r3, r2);
    }

    public static final void updateStatefulOverlayBlend(View r1, MaterialConfig r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "material");
        BlendConfigStateList r3 = r2.getOverlayBlendConfigStateList();
        if (r3 == null) goto L7;
        updateStatefulOverlayBlend(r1, r3);
        return;
    }

    public static final void updateStatefulOverlayBlend(View r3, BlendConfigStateList r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "overlayBlendConfigs");
        int[] r0 = r3.getDrawableState();
        Intrinsics.checkNotNullExpressionValue(r0, "this.drawableState");
        int[] r5 = OMaterialHelper.transformToBlendIntArray(BlendConfigStateList.getConfigForState$default(r4, r0, null, 2, null));
        OMaterialHelper.setOverlayBlendEffect(r3, Arrays.copyOf(r5, r5.length));
    }

    public static final void updateMaterialBackdropTargetType(View r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r2 == false) goto L5;
        OMaterialHelper.setEffectSrc(r1, 2);
        return;
    L5:
        OMaterialHelper.setEffectSrc(r1, 3);
    }

    public static final void updateMaterialBackdropSrcType(View r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r2 == (-1)) goto L6;
        OMaterialHelper.setEffectSrc(r1, r2);
        return;
    }

    public static final void setMaterialBackdropTarget(View r1, View r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        OMaterialHelper.setEffectSrcTarget(r1, r2);
    }

    public static /* synthetic */ void material$default(Paint r0, MaterialConfig r1, int r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = 2;
    L5:
        material(r0, r1, r2);
    }

    public static final void material(Paint r1, MaterialConfig r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "material");
        setMaterial(r1, r2, r3);
    }

    public static final void materialFromWindow(Paint r1, MaterialConfig r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "material");
        setMaterial(r1, r2, 3);
    }

    public static /* synthetic */ void setMaterial$default(Paint r0, MaterialConfig r1, int r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = 2;
    L5:
        setMaterial(r0, r1, r2);
    }

    public static final void setMaterial(Paint r1, MaterialConfig r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "material");
        OMaterialHelper.setMaterial(r1, r3, r2);
    }

    public static /* synthetic */ void materials$default(Paint r0, MaterialConfig[] r1, int r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = 2;
    L5:
        materials(r0, r1, r2);
    }

    public static final void materials(Paint r1, MaterialConfig[] r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "materials");
        setMaterials(r1, r2, r3);
    }

    public static final void materialsFromWindow(Paint r1, MaterialConfig[] r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "materials");
        setMaterials(r1, r2, 3);
    }

    public static /* synthetic */ void setMaterials$default(Paint r0, MaterialConfig[] r1, int r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = 2;
    L5:
        setMaterials(r0, r1, r2);
    }

    public static final void setMaterials(Paint r1, MaterialConfig[] r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "materials");
        OMaterialHelper.setMaterials(r1, r3, r2);
    }

    public static final void updateMaterialBackdropTargetType(Paint r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r2 == false) goto L5;
        OMaterialHelper.setEffectSrc(r1, 2);
        return;
    L5:
        OMaterialHelper.setEffectSrc(r1, 3);
    }

    public static final void setMaterialBackdropTarget(Paint r1, View r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "target");
        OMaterialHelper.setEffectSrcTarget(r1, r2);
    }

    public static /* synthetic */ void material$default(Drawable r0, MaterialConfig r1, int r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = 2;
    L5:
        material(r0, r1, r2);
    }

    public static final void material(Drawable r1, MaterialConfig r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "material");
        setMaterial(r1, r2, r3);
    }

    public static final void materialFromWindow(Drawable r1, MaterialConfig r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "material");
        setMaterial(r1, r2, 3);
    }

    public static /* synthetic */ void setMaterial$default(Drawable r0, MaterialConfig r1, int r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = 2;
    L5:
        setMaterial(r0, r1, r2);
    }

    public static final void setMaterial(Drawable r1, MaterialConfig r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "material");
        OMaterialHelper.setMaterial(r1, r3, r2);
    }

    public static /* synthetic */ void materials$default(Drawable r0, MaterialConfig[] r1, int r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = 2;
    L5:
        materials(r0, r1, r2);
    }

    public static final void materials(Drawable r1, MaterialConfig[] r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "materials");
        setMaterials(r1, r2, r3);
    }

    public static final void materialsFromWindow(Drawable r1, MaterialConfig[] r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "materials");
        setMaterials(r1, r2, 3);
    }

    public static /* synthetic */ void setMaterials$default(Drawable r0, MaterialConfig[] r1, int r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = 2;
    L5:
        setMaterials(r0, r1, r2);
    }

    public static final void setMaterials(Drawable r1, MaterialConfig[] r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "materials");
        OMaterialHelper.setMaterials(r1, r3, r2);
    }

    public static final void updateMaterialBackdropTargetType(Drawable r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r2 == false) goto L5;
        OMaterialHelper.setEffectSrc(r1, 2);
        return;
    L5:
        OMaterialHelper.setEffectSrc(r1, 3);
    }

    public static final void setMaterialBackdropTarget(Drawable r1, View r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "target");
        OMaterialHelper.setEffectSrcTarget(r1, r2);
    }

    public static /* synthetic */ void contentMaterial$default(ImageView r1, MaterialConfig r2, int r3, int r4, int r5, int r6, Object r7) {
        if ((r6 & 2) == 0) goto L6;
        r3 = 2;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = 2;
    L9:
        if ((r6 & 8) == 0) goto L11;
        r5 = 0;
    L11:
        contentMaterial(r1, r2, r3, r4, r5);
    }

    public static final void contentMaterial(ImageView r1, MaterialConfig r2, int r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "material");
        OMaterialHelper.setImageMaterial(r1, r3, r4, r5, r2);
    }

    public static /* synthetic */ void contentMaterialFromWindow$default(ImageView r0, MaterialConfig r1, int r2, int r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = 2;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        contentMaterialFromWindow(r0, r1, r2, r3);
    }

    public static final void contentMaterialFromWindow(ImageView r1, MaterialConfig r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "material");
        contentMaterial(r1, r2, 3, r3, r4);
    }

    public static /* synthetic */ void contentMaterials$default(ImageView r1, MaterialConfig[] r2, int r3, int r4, int r5, int r6, Object r7) {
        if ((r6 & 2) == 0) goto L6;
        r3 = 2;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = 2;
    L9:
        if ((r6 & 8) == 0) goto L11;
        r5 = 0;
    L11:
        contentMaterials(r1, r2, r3, r4, r5);
    }

    public static final void contentMaterials(ImageView r1, MaterialConfig[] r2, int r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "materials");
        OMaterialHelper.setImageMaterials(r1, r3, r4, r5, r2);
    }

    public static /* synthetic */ void contentMaterialsFromWindow$default(ImageView r0, MaterialConfig[] r1, int r2, int r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = 2;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        contentMaterialsFromWindow(r0, r1, r2, r3);
    }

    public static final void contentMaterialsFromWindow(ImageView r1, MaterialConfig[] r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "materials");
        contentMaterials(r1, r2, 3, r3, r4);
    }
}
