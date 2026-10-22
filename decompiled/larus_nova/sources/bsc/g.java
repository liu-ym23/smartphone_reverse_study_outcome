package bsc;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.util.MathHelpersKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Float> f20396a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Color> f20397b;

    public g(int r100) {
        this.f20396a = new ArrayList(r100);
        this.f20397b = new ArrayList(r100);
    }

    public final void c(int r100) {
    L3:
        if (((ArrayList) this.f20396a).size() >= r100) goto L6;
        List<Float> r101 = this.f20396a;
        ArrayList r102 = (ArrayList) r101;
        r102.add(Float.valueOf(0.0f));
        List<Color> r103 = this.f20397b;
        ArrayList r104 = (ArrayList) r103;
        r104.add(Color.m4817boximpl(Color.Companion.m4862getTransparent0d7_KjU()));
    L6:
        if (((ArrayList) this.f20396a).size() <= r100) goto L8;
        CollectionsKt.removeLast(this.f20396a);
        CollectionsKt.removeLast(this.f20397b);
        goto L6
    }

    public final void a(List<Float> r210, int r211) {
        Intrinsics.checkNotNullParameter(r210, "colors");
        c(r211);
        int r100 = 0;
    L3:
        if (r100 >= r211) goto L5;
        int r101 = r100 * 4;
        ListProtector.set(this.f20396a, r100, ListProtector.get(r210, r101));
        ListProtector.set(this.f20397b, r100, Color.m4817boximpl(ColorKt.Color$default(((Number) ListProtector.get(r210, r101 + 1)).floatValue(), ((Number) ListProtector.get(r210, r101 + 2)).floatValue(), ((Number) ListProtector.get(r210, r101 + 3)).floatValue(), 0.0f, null, 24, null)));
        r100 = r100 + 1;
        goto L3
    L5:
        int r102 = r211 * 4;
        if (r210.size() <= r102) goto L119;
        int r103 = 2;
        int r104 = (r210.size() - r102) / 2;
        ArrayList r110 = new ArrayList(r104);
        int r105 = 0;
    L10:
        if (r105 >= r104) goto L12;
        r110.add(Float.valueOf(0.0f));
        r105 = r105 + 1;
        goto L10
    L12:
        ArrayList r111 = new ArrayList(r104);
        int r106 = 0;
    L13:
        if (r106 >= r104) goto L15;
        r111.add(Float.valueOf(0.0f));
        r106 = r106 + 1;
        goto L13
    L15:
        int r107 = 0;
    L17:
        if (r102 >= r210.size()) goto L23;
        if ((r102 % 2) != 0) goto L21;
        ListProtector.set(r110, r107, ListProtector.get(r210, r102));
    L22:
        r102 = r102 + 1;
        goto L17
    L21:
        ListProtector.set(r111, r107, ListProtector.get(r210, r102));
        r107 = r107 + 1;
        goto L22
    L23:
        ArrayList r108 = (ArrayList) this.f20396a;
        if (r108.size() != 0) goto L26;
        List r109 = r110;
    L58:
        int r112 = r109.size();
        ArrayList r113 = new ArrayList(r112);
        int r114 = 0;
    L59:
        if (r114 >= r112) goto L61;
        r113.add(Color.m4817boximpl(Color.Companion.m4862getTransparent0d7_KjU()));
        r114 = r114 + 1;
        goto L59
    L61:
        int r115 = 0;
    L62:
        if (r115 >= r112) goto L116;
        float r116 = ((Number) ListProtector.get(r109, r115)).floatValue();
        int r117 = CollectionsKt.binarySearch$default(this.f20396a, Float.valueOf(r116), 0, 0, 6, null);
        int r118 = CollectionsKt.binarySearch$default(r110, Float.valueOf(r116), 0, 0, 6, null);
        int r119 = 1;
        if (r117 < 0) goto L87;
        if (r118 > 0) goto L87;
        long r120 = ((Color) ListProtector.get(this.f20397b, r117)).m4837unboximpl();
        if (r111.size() < r103) goto L72;
        int r121 = 0;
        if (r116 <= ((Number) ListProtector.get(r110, 0)).floatValue()) goto L73;
    L74:
        int r122 = r110.size();
    L75:
        if (r119 >= r122) goto L86;
        float r123 = ((Number) ListProtector.get(r110, r119)).floatValue();
        if (r123 >= r116) goto L81;
        if (r119 == (r110.size() - 1)) goto L81;
        r119 = r119 + 1;
    L81:
        if (r123 > r116) goto L83;
        float r124 = ((Number) ListProtector.get(r111, r119)).floatValue();
    L84:
        ListProtector.set(r113, r115, Color.m4817boximpl(Color.m4826copywmQWz5c$default(r120, r124, 0.0f, 0.0f, 0.0f, 14, null)));
    L115:
        r115 = r115 + 1;
        r103 = 2;
        goto L62
    L83:
        int r125 = r119 - 1;
        r124 = MathHelpersKt.lerp(((Number) ListProtector.get(r111, r125)).floatValue(), ((Number) ListProtector.get(r111, r119)).floatValue(), (r116 - ((Number) ListProtector.get(r110, r125)).floatValue()) / (((Number) ListProtector.get(r110, r119)).floatValue() - ((Number) ListProtector.get(r110, r125)).floatValue()));
        goto L84
    L86:
        throw new IllegalArgumentException("Unreachable code.");
    L73:
        Color.m4826copywmQWz5c$default(r120, ((Number) ListProtector.get(r111, r121)).floatValue(), 0.0f, 0.0f, 0.0f, 14, null);
        goto L74
    L72:
        r121 = 0;
    L87:
        if (r118 >= 0) goto L89;
        r118 = -(r118 + 1);
    L89:
        float r126 = ((Number) ListProtector.get(r111, r118)).floatValue();
        List<Float> r127 = this.f20396a;
        ArrayList r128 = (ArrayList) this.f20397b;
        if (r128.size() >= r103) goto L92;
    L113:
        long r129 = ((Color) ListProtector.get(r128, 0)).m4837unboximpl();
    L114:
        ListProtector.set(r113, r115, Color.m4817boximpl(r129));
        goto L115
    L92:
        if (r116 != ((Number) ListProtector.get(r127, 0)).floatValue()) goto L94;
        boolean r130 = true;
    L95:
        if (r130 == true) goto L113;
        ArrayList r131 = (ArrayList) r127;
        int r132 = r131.size();
        int r133 = 1;
    L98:
        if (r133 >= r132) goto L112;
        float r134 = ((Number) ListProtector.get(r131, r133)).floatValue();
        if (r134 >= r116) goto L105;
        if (r133 == (r131.size() - 1)) goto L105;
        r133 = r133 + 1;
    L105:
        if (r133 == (r131.size() - 1)) goto L107;
    L109:
        int r135 = r133 - 1;
        float r136 = (r116 - ((Number) ListProtector.get(r131, r135)).floatValue()) / (((Number) ListProtector.get(r131, r133)).floatValue() - ((Number) ListProtector.get(r131, r135)).floatValue());
        r129 = Color.m4826copywmQWz5c$default(ColorKt.m4878lerpjxsXWHM(((Color) ListProtector.get(r128, r135)).m4837unboximpl(), ((Color) ListProtector.get(r128, r133)).m4837unboximpl(), r136), r126, 0.0f, 0.0f, 0.0f, 14, null);
        goto L114
    L107:
        if (r116 < r134) goto L109;
        r129 = ColorKt.Color$default(Color.m4833getRedimpl(((Color) ListProtector.get(r128, r133)).m4837unboximpl()), Color.m4832getGreenimpl(((Color) ListProtector.get(r128, r133)).m4837unboximpl()), Color.m4830getBlueimpl(((Color) ListProtector.get(r128, r133)).m4837unboximpl()), r126, null, 16, null);
        goto L114
    L112:
        throw new IllegalArgumentException("Unreachable code.");
    L94:
        r130 = false;
        goto L95
    L116:
        int r137 = 0;
        c(r113.size());
        int r138 = r113.size();
    L117:
        if (r137 >= r138) goto L142;
        ListProtector.set(this.f20397b, r137, ListProtector.get(r113, r137));
        ListProtector.set(this.f20396a, r137, ListProtector.get(r109, r137));
        r137 = r137 + 1;
        goto L117
    L142:
        return;
    L26:
        r109 = r108;
        if (r110.size() == 0) goto L58;
        int r139 = r108.size() + r110.size();
        ArrayList r140 = new ArrayList(r139);
        int r141 = 0;
    L30:
        if (r141 >= r139) goto L32;
        r140.add(Float.valueOf(0.0f));
        r141 = r141 + 1;
        goto L30
    L32:
        int r142 = r140.size();
        int r143 = 0;
        int r144 = 0;
        int r145 = 0;
        int r146 = 0;
    L33:
        if (r143 >= r142) goto L55;
        float r147 = Float.NaN;
        if (r145 >= r108.size()) goto L37;
        float r148 = ((Number) ListProtector.get(r108, r145)).floatValue();
    L39:
        if (r146 >= r110.size()) goto L42;
        r147 = ((Number) ListProtector.get(r110, r146)).floatValue();
    L42:
        if (Float.isNaN(r147) == false) goto L44;
    L53:
        ListProtector.set(r140, r143, Float.valueOf(r148));
        r145 = r145 + 1;
    L54:
        r143 = r143 + 1;
        goto L33
    L44:
        if (r148 < r147) goto L53;
        if (Float.isNaN(r148) == false) goto L49;
    L52:
        ListProtector.set(r140, r143, Float.valueOf(r147));
        r146 = r146 + 1;
        goto L54
    L49:
        if (r147 < r148) goto L52;
        ListProtector.set(r140, r143, Float.valueOf(r148));
        r145 = r145 + 1;
        r146 = r146 + 1;
        r144 = r144 + 1;
        goto L54
    L37:
        r148 = Float.NaN;
        goto L39
    L55:
        if (r144 != 0) goto L57;
        r109 = r140;
        goto L58
    L57:
        r109 = CollectionsKt.take(r140, r140.size() - r144);
        goto L58
    }

    public final void b(g r100, g r101, float r110) {
        Intrinsics.checkNotNullParameter(r100, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY);
        Intrinsics.checkNotNullParameter(r101, "b");
        int r102 = Math.min(((ArrayList) r100.f20397b).size(), ((ArrayList) r101.f20397b).size());
        c(r102);
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        ListProtector.set(this.f20397b, r103, Color.m4817boximpl(ColorKt.m4878lerpjxsXWHM(((Color) ListProtector.get(r100.f20397b, r103)).m4837unboximpl(), ((Color) ListProtector.get(r101.f20397b, r103)).m4837unboximpl(), r110)));
        ListProtector.set(this.f20396a, r103, Float.valueOf(MathHelpersKt.lerp(((Number) ListProtector.get(r100.f20396a, r103)).floatValue(), ((Number) ListProtector.get(r101.f20396a, r103)).floatValue(), r110)));
        r103 = r103 + 1;
        goto L3
    }
}
