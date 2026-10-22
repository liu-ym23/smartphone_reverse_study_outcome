package com.obric.oui.material;

import android.R;
import com.obric.oui.graphic.BlendMode;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MaterialConfigFormatBuilders.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0003\u001a\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0001H\u0002\u001a\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0001H\u0002\u001a\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0001H\u0002\u001a\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0001H\u0002\u001a\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0011H\u0002\u001a\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0001H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"FLUID_API3_PARAM_COUNT", "", "FLUID_API4_PARAM_COUNT", "MATERIAL_STATES", "", "Lcom/obric/oui/material/MaterialOutputState;", "formatBlendMode", "", "mode", "formatBlurDirection", MaterialConfigFormatNames.DIRECTION, "formatColor", "color", "formatCurveType", "curveType", "formatFloat", "value", "", "indent", "level", "OUI_standardRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class MaterialConfigFormatBuildersKt {
    public static final int FLUID_API3_PARAM_COUNT = 8;
    public static final int FLUID_API4_PARAM_COUNT = 13;
    private static final List<MaterialOutputState> MATERIAL_STATES = null;

    public static final /* synthetic */ String access$formatBlendMode(int r0) {
        return formatBlendMode(r0);
    }

    public static final /* synthetic */ String access$formatBlurDirection(int r0) {
        return formatBlurDirection(r0);
    }

    public static final /* synthetic */ String access$formatColor(int r0) {
        return formatColor(r0);
    }

    public static final /* synthetic */ String access$formatCurveType(int r0) {
        return formatCurveType(r0);
    }

    public static final /* synthetic */ String access$formatFloat(float r0) {
        return formatFloat(r0);
    }

    public static final /* synthetic */ List access$getMATERIAL_STATES$p() {
        return MATERIAL_STATES;
    }

    public static final /* synthetic */ String access$indent(int r0) {
        return indent(r0);
    }

    static {
        MATERIAL_STATES = CollectionsKt.listOf(new MaterialOutputState[]{new MaterialOutputState("normal", new int[]{R.attr.state_enabled}), new MaterialOutputState(MaterialConfigFormatNames.PRESS, new int[]{R.attr.state_pressed}), new MaterialOutputState(MaterialConfigFormatNames.HOVER, new int[]{R.attr.state_hovered}), new MaterialOutputState(MaterialConfigFormatNames.CHECKED, new int[]{R.attr.state_checked}), new MaterialOutputState("selected", new int[]{R.attr.state_selected}), new MaterialOutputState(MaterialConfigFormatNames.DISABLE, new int[]{-16842910})});
    }

    private static final String indent(int r3) {
        StringBuilder r0 = new StringBuilder();
        int r1 = 0;
    L3:
        if (r1 >= r3) goto L5;
        r0.append("    ");
        r1 = r1 + 1;
        goto L3
    L5:
        String r4 = r0.toString();
        Intrinsics.checkNotNullExpressionValue(r4, "StringBuilder().apply(builderAction).toString()");
        return r4;
    }

    private static final String formatColor(int r3) {
        String r4 = String.format("#%08X", Arrays.copyOf(new Object[]{Integer.valueOf(r3)}, 1));
        Intrinsics.checkNotNullExpressionValue(r4, "format(this, *args)");
        return r4;
    }

    private static final String formatFloat(float r2) {
        if ((r2 % 1.0f) != 0.0f) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return String.valueOf((int) r2);
    L9:
        return String.valueOf(r2);
    L5:
        r0 = false;
        goto L6
    }

    private static final String formatBlendMode(int r1) {
        if (r1 == (-1)) goto L5;
        BlendMode r0 = BlendMode.fromValue(r1);
        if (r0 != null) goto L9;
        String r2 = null;
    L10:
        if (r2 == null) goto L12;
        return r2;
    L12:
        return String.valueOf(r1);
    L9:
        r2 = r0.name();
        goto L10
    L5:
        return BlendMode.SRC_OVER.name();
    }

    private static final String formatBlurDirection(int r1) {
        if (r1 == (-1)) goto L19;
        if (r1 != 0) goto L6;
        return "normal";
    L6:
        if (r1 != 1) goto L8;
        return "progress_downup";
    L8:
        if (r1 != 2) goto L10;
        return "progress_updown";
    L10:
        if (r1 != 3) goto L12;
        return "progress_leftright";
    L12:
        if (r1 != 4) goto L21;
        return "progress_rightleft";
    L21:
        return String.valueOf(r1);
    L19:
        return "none";
    }

    private static final String formatCurveType(int r0) {
        switch(r0) {
            case 0: goto L10;
            case 1: goto L9;
            case 2: goto L8;
            case 3: goto L7;
            case 4: goto L6;
            case 5: goto L5;
            case 6: goto L4;
            default: goto L12;
        };
    L4:
        return "inout_cubic";
    L5:
        return "out_cubic";
    L6:
        return "in_cubic";
    L7:
        return "inout_quad";
    L8:
        return "out_quad";
    L9:
        return "in_quad";
    L10:
        return "linear";
    L12:
        return String.valueOf(r0);
    }
}
