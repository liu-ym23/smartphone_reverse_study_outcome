package androidx.compose.foundation;

import S7.n;
import Z7.l;
import androidx.compose.foundation.text.input.internal.selection.TextFieldPreparedSelection;
import androidx.compose.foundation.text.selection.BaseTextPreparedSelection;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.snapshots.SnapshotStateMapKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.ValueElementSequence;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import kotlin.KotlinNothingValueException;
import kotlin.jvm.internal.MutablePropertyReference1Impl;

/* loaded from: classes.dex */
public abstract /* synthetic */ class b {
    public static void A(n nVar, Composer composer, int i) {
        nVar.invoke(composer, Integer.valueOf(i));
        composer.endNode();
    }

    public static void B(StringBuilder sb, String str, String str2, int i, String str3) {
        sb.append(str);
        sb.append(str2);
        sb.append(i);
        sb.append(str3);
    }

    public static void C(StringBuilder sb, String str, String str2, String str3) {
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
    }

    public static int D(Placeable placeable, int i, int i6) {
        return (i - placeable.getWidth()) / i6;
    }

    public static float a(float f, float f7, float f9, float f10) {
        return (f9 - (f * f7)) * f10;
    }

    public static int b(float f, int i, int i6) {
        return (Dp.m6850hashCodeimpl(f) + i) * i6;
    }

    public static int c(int i, int i6, long j5) {
        return (Color.m4146hashCodeimpl(j5) + i) * i6;
    }

    public static int d(TextFieldPreparedSelection textFieldPreparedSelection, TextFieldPreparedSelection textFieldPreparedSelection2) {
        textFieldPreparedSelection.textPreparedSelectionState.resetCachedX();
        return textFieldPreparedSelection2.text.length();
    }

    public static int e(BaseTextPreparedSelection baseTextPreparedSelection) {
        baseTextPreparedSelection.getState().resetCachedX();
        return baseTextPreparedSelection.getText$foundation_release().length();
    }

    public static int f(Placeable placeable, int i, int i6) {
        return (i - placeable.getHeight()) / i6;
    }

    public static int g(LayoutNode layoutNode) {
        return layoutNode.getNodes().getHead().getAggregateChildKindSet();
    }

    public static long h(Placeable.PlacementScope placementScope, Placeable placeable, Placeable placeable2, long j5) {
        placementScope.handleMotionFrameOfReferencePlacement(placeable);
        return IntOffset.m6976plusqkQi6aY(j5, placeable2.apparentToRealOffset);
    }

    public static l i(Class cls, String str, String str2, int i, kotlin.jvm.internal.n nVar) {
        return nVar.e(new MutablePropertyReference1Impl(cls, str, str2, i));
    }

    public static ValueElementSequence j(float f, ValueElementSequence valueElementSequence, String str, InspectorInfo inspectorInfo) {
        valueElementSequence.set(str, Dp.m6842boximpl(f));
        return inspectorInfo.getProperties();
    }

    public static ValueElementSequence k(boolean z10, ValueElementSequence valueElementSequence, String str, InspectorInfo inspectorInfo) {
        valueElementSequence.set(str, Boolean.valueOf(z10));
        return inspectorInfo.getProperties();
    }

    public static Object l(MutableVector mutableVector, int i) {
        return mutableVector.removeAt(mutableVector.getSize() - i);
    }

    public static String m(char c, String str, String str2) {
        return str + str2 + c;
    }

    public static String n(int i, int i6, String str, String str2) {
        return str + i + str2 + i6;
    }

    public static String o(int i, String str, int i6, String str2, String str3) {
        return str + i + str2 + i6 + str3;
    }

    public static String p(long j5, String str) {
        return str + j5;
    }

    public static String q(long j5, String str, String str2) {
        return str + j5 + str2;
    }

    public static String r(Object obj, String str) {
        return (str + obj).toString();
    }

    public static String s(Object obj, String str, String str2) {
        return str + obj + str2;
    }

    public static String t(StringBuilder sb, Object obj, char c) {
        sb.append(obj);
        sb.append(c);
        return sb.toString();
    }

    public static String u(StringBuilder sb, String str, float f) {
        sb.append(f);
        sb.append(str);
        return sb.toString();
    }

    public static StringBuilder v(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        return sb;
    }

    public static KotlinNothingValueException w() {
        SnapshotStateMapKt.unsupported();
        return new KotlinNothingValueException();
    }

    public static KotlinNothingValueException x(String str) {
        InlineClassHelperKt.throwIllegalStateExceptionForNullCheck(str);
        return new KotlinNothingValueException();
    }

    public static void y(long j5, String str, String str2, StringBuilder sb) {
        sb.append(str);
        sb.append(j5);
        sb.append(str2);
    }

    public static void z(long j5, String str, StringBuilder sb) {
        sb.append((Object) Color.m4147toStringimpl(j5));
        sb.append(str);
    }
}
