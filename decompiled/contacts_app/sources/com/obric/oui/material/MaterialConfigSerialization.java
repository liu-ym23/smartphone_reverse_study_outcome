package com.obric.oui.material;

import android.R;
import android.content.res.ColorStateList;
import androidx.exifinterface.media.ExifInterface;
import com.android.vcard.VCardConstants;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.apm6.consumer.slardar.Constants;
import com.obric.oui.blur.BlurConfig;
import com.obric.oui.color.BlendConfig;
import com.obric.oui.color.StrokeConfig;
import com.obric.oui.fluid.FluidConfig;
import com.obric.oui.res.BlendConfigStateList;
import com.obric.oui.res.StrokeStateList;
import com.obric.oui.shadow.ShadowConfig;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MaterialConfigSerialization.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001HB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001b\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u001d\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00062\u0006\u0010\u0011\u001a\u00020\u0012H\u0002¢\u0006\u0002\u0010\u0013J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J%\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00062\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0012H\u0002¢\u0006\u0002\u0010\u001dJ\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0017\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002¢\u0006\u0002\u0010\"J\u001d\u0010#\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010\u00062\u0006\u0010\u0011\u001a\u00020\u0012H\u0002¢\u0006\u0002\u0010%J\u0012\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0012\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u000e\u0010*\u001a\u00020\r2\u0006\u0010+\u001a\u00020\u000bJ\u0019\u0010,\u001a\u00020\r2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006¢\u0006\u0002\u0010.J%\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0006H\u0002¢\u0006\u0002\u00103J\u001a\u00104\u001a\u0002002\u0006\u00101\u001a\u0002022\b\u00105\u001a\u0004\u0018\u00010\u0015H\u0002J\u001a\u00106\u001a\u0002002\u0006\u00101\u001a\u0002022\b\u00107\u001a\u0004\u0018\u00010\u0017H\u0002J\u001a\u00108\u001a\u0002002\u0006\u00101\u001a\u0002022\b\u00109\u001a\u0004\u0018\u00010\u0019H\u0002J\u0018\u0010:\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u0010+\u001a\u00020\u000bH\u0002J#\u0010;\u001a\u0002002\u0006\u00101\u001a\u0002022\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006H\u0002¢\u0006\u0002\u0010<J\u001a\u0010=\u001a\u0002002\u0006\u00101\u001a\u0002022\b\u0010>\u001a\u0004\u0018\u00010\u001fH\u0002J\u001f\u0010?\u001a\u0002002\u0006\u00101\u001a\u0002022\b\u0010@\u001a\u0004\u0018\u00010!H\u0002¢\u0006\u0002\u0010AJ%\u0010B\u001a\u0002002\u0006\u00101\u001a\u0002022\u000e\u0010C\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010\u0006H\u0002¢\u0006\u0002\u0010DJ\u001a\u0010E\u001a\u0002002\u0006\u00101\u001a\u0002022\b\u0010F\u001a\u0004\u0018\u00010'H\u0002J\u001a\u0010G\u001a\u0002002\u0006\u00101\u001a\u0002022\b\u00105\u001a\u0004\u0018\u00010)H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\bR\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006I"}, d2 = {"Lcom/obric/oui/material/MaterialConfigSerialization;", "", "()V", "MAGIC", "", "SERIALIZATION_STATE_SPECS", "", "", "[[I", VCardConstants.PROPERTY_VERSION, "deserializeArray", "Lcom/obric/oui/material/MaterialConfig;", "payload", "", "([B)[Lcom/obric/oui/material/MaterialConfig;", "readBlendConfigArray", "Lcom/obric/oui/color/BlendConfig;", "input", "Ljava/io/DataInputStream;", "(Ljava/io/DataInputStream;)[Lcom/obric/oui/color/BlendConfig;", "readBlendConfigStateList", "Lcom/obric/oui/res/BlendConfigStateList;", "readBlurConfig", "Lcom/obric/oui/blur/BlurConfig;", "readColorStateList", "Landroid/content/res/ColorStateList;", "readConfig", "readConfigArray", PerfConsts.PERF_DISK_FILE_SIZE, "(ILjava/io/DataInputStream;)[Lcom/obric/oui/material/MaterialConfig;", "readFluidConfig", "Lcom/obric/oui/fluid/FluidConfig;", "readNullableFloat", "", "(Ljava/io/DataInputStream;)Ljava/lang/Float;", "readShadowArray", "Lcom/obric/oui/shadow/ShadowConfig;", "(Ljava/io/DataInputStream;)[Lcom/obric/oui/shadow/ShadowConfig;", "readStroke", "Lcom/obric/oui/color/StrokeConfig;", "readStrokeStateList", "Lcom/obric/oui/res/StrokeStateList;", "serialize", "config", "serializeArray", Constants.KEY_CONFIG, "([Lcom/obric/oui/material/MaterialConfig;)[B", "writeBlendConfigArray", "", "output", "Ljava/io/DataOutputStream;", "(Ljava/io/DataOutputStream;[Lcom/obric/oui/color/BlendConfig;)V", "writeBlendConfigStateList", "stateList", "writeBlurConfig", "blurConfig", "writeColorStateList", "colorStateList", "writeConfig", "writeConfigArray", "(Ljava/io/DataOutputStream;[Lcom/obric/oui/material/MaterialConfig;)V", "writeFluidConfig", "fluidConfig", "writeNullableFloat", "value", "(Ljava/io/DataOutputStream;Ljava/lang/Float;)V", "writeShadowArray", MaterialConfigFormatNames.SHADOWS, "(Ljava/io/DataOutputStream;[Lcom/obric/oui/shadow/ShadowConfig;)V", "writeStroke", MaterialConfigFormatNames.STROKE, "writeStrokeStateList", "StatefulValue", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MaterialConfigSerialization {
    public static final MaterialConfigSerialization INSTANCE = null;
    private static final int MAGIC = 1296254535;
    private static final int[][] SERIALIZATION_STATE_SPECS = null;
    private static final int VERSION = 1;

    /* JADX INFO: compiled from: MaterialConfigSerialization.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B5\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\u0006\u0010\u0005\u001a\u00028\u0000\u0012\u0006\u0010\u0006\u001a\u00028\u0000\u0012\u0006\u0010\u0007\u001a\u00028\u0000\u0012\u0006\u0010\b\u001a\u00028\u0000¢\u0006\u0002\u0010\tJ\u0006\u0010\u0012\u001a\u00020\u0013J \u0010\u0012\u001a\u00020\u00132\u0018\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00130\u0015J\u000e\u0010\u0016\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000e\u0010\u0017\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000e\u0010\u0018\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000e\u0010\u0019\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000e\u0010\u001a\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000e\u0010\u001b\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\u000bJP\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00028\u00002\b\b\u0002\u0010\u0004\u001a\u00028\u00002\b\b\u0002\u0010\u0005\u001a\u00028\u00002\b\b\u0002\u0010\u0006\u001a\u00028\u00002\b\b\u0002\u0010\u0007\u001a\u00028\u00002\b\b\u0002\u0010\b\u001a\u00028\u0000HÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u00132\b\u0010\u001f\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020#HÖ\u0001R\u0013\u0010\u0006\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\b\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u0005\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000e\u0010\u000bR\u0013\u0010\u0003\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000f\u0010\u000bR\u0013\u0010\u0004\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0010\u0010\u000bR\u0013\u0010\u0007\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0011\u0010\u000b¨\u0006$"}, d2 = {"Lcom/obric/oui/material/MaterialConfigSerialization$StatefulValue;", ExifInterface.GPS_DIRECTION_TRUE, "", "normal", "pressed", "hovered", MaterialConfigFormatNames.CHECKED, "selected", "disabled", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "getChecked", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getDisabled", "getHovered", "getNormal", "getPressed", "getSelected", "allEqual", "", "comparator", "Lkotlin/Function2;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lcom/obric/oui/material/MaterialConfigSerialization$StatefulValue;", "equals", "other", "hashCode", "", "toString", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class StatefulValue<T> {
        private final T checked;
        private final T disabled;
        private final T hovered;
        private final T normal;
        private final T pressed;
        private final T selected;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ StatefulValue copy$default(StatefulValue r4, Object r5, Object r6, Object r7, Object r8, Object r9, Object r10, int r11, Object r12) {
            if ((r11 & 1) == 0) goto L6;
            r5 = r4.normal;
        L6:
            if ((r11 & 2) == 0) goto L8;
            r6 = r4.pressed;
        L8:
            Object r13 = r6;
            if ((r11 & 4) == 0) goto L11;
            r7 = r4.hovered;
        L11:
            Object r0 = r7;
            if ((r11 & 8) == 0) goto L14;
            r8 = r4.checked;
        L14:
            Object r1 = r8;
            if ((r11 & 16) == 0) goto L17;
            r9 = r4.selected;
        L17:
            Object r2 = r9;
            if ((r11 & 32) == 0) goto L20;
            r10 = r4.disabled;
        L20:
            Object r14 = r5;
            return r4.copy(r14, r13, r0, r1, r2, r10);
        }

        public final T component1() {
            return this.normal;
        }

        public final T component2() {
            return this.pressed;
        }

        public final T component3() {
            return this.hovered;
        }

        public final T component4() {
            return this.checked;
        }

        public final T component5() {
            return this.selected;
        }

        public final T component6() {
            return this.disabled;
        }

        public final StatefulValue<T> copy(T r8, T r9, T r10, T r11, T r12, T r13) {
            return new StatefulValue(r8, r9, r10, r11, r12, r13);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof StatefulValue) == true) goto L8;
            return false;
        L8:
            StatefulValue r6 = (StatefulValue) r5;
            if (Intrinsics.areEqual(this.normal, r6.normal) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.pressed, r6.pressed) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.hovered, r6.hovered) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.checked, r6.checked) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.selected, r6.selected) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.disabled, r6.disabled) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public int hashCode() {
            T r0 = this.normal;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            T r4 = this.pressed;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            T r7 = this.hovered;
            if (r7 != null) goto L13;
            int r8 = 0;
        L14:
            int r9 = (r6 + r8) * 31;
            T r10 = this.checked;
            if (r10 != null) goto L17;
            int r11 = 0;
        L18:
            int r12 = (r9 + r11) * 31;
            T r13 = this.selected;
            if (r13 != null) goto L21;
            int r14 = 0;
        L22:
            int r15 = (r12 + r14) * 31;
            T r16 = this.disabled;
            if (r16 == null) goto L27;
            r1 = r16.hashCode();
        L27:
            return r15 + r1;
        L21:
            r14 = r13.hashCode();
            goto L22
        L17:
            r11 = r10.hashCode();
            goto L18
        L13:
            r8 = r7.hashCode();
            goto L14
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public String toString() {
            return "StatefulValue(normal=" + this.normal + ", pressed=" + this.pressed + ", hovered=" + this.hovered + ", checked=" + this.checked + ", selected=" + this.selected + ", disabled=" + this.disabled + ')';
        }

        public StatefulValue(T r1, T r2, T r3, T r4, T r5, T r6) {
            this.normal = r1;
            this.pressed = r2;
            this.hovered = r3;
            this.checked = r4;
            this.selected = r5;
            this.disabled = r6;
        }

        public final T getNormal() {
            return this.normal;
        }

        public final T getPressed() {
            return this.pressed;
        }

        public final T getHovered() {
            return this.hovered;
        }

        public final T getChecked() {
            return this.checked;
        }

        public final T getSelected() {
            return this.selected;
        }

        public final T getDisabled() {
            return this.disabled;
        }

        public final boolean allEqual() {
            if (Intrinsics.areEqual(this.normal, this.pressed) == true) goto L5;
        L13:
            return false;
        L5:
            if (Intrinsics.areEqual(this.normal, this.hovered) == false) goto L13;
            if (Intrinsics.areEqual(this.normal, this.checked) == false) goto L13;
            if (Intrinsics.areEqual(this.normal, this.selected) == false) goto L13;
            if (Intrinsics.areEqual(this.normal, this.disabled) == false) goto L13;
            return true;
        }

        public final boolean allEqual(Function2<? super T, ? super T, Boolean> r3) {
            Intrinsics.checkNotNullParameter(r3, "comparator");
            if (r3.invoke(this.normal, this.pressed).booleanValue() == true) goto L5;
        L13:
            return false;
        L5:
            if (r3.invoke(this.normal, this.hovered).booleanValue() == false) goto L13;
            if (r3.invoke(this.normal, this.checked).booleanValue() == false) goto L13;
            if (r3.invoke(this.normal, this.selected).booleanValue() == false) goto L13;
            if (r3.invoke(this.normal, this.disabled).booleanValue() == false) goto L13;
            return true;
        }
    }

    private MaterialConfigSerialization() {
    }

    static {
        INSTANCE = new MaterialConfigSerialization();
        SERIALIZATION_STATE_SPECS = new int[][]{new int[]{R.attr.state_pressed}, new int[]{R.attr.state_hovered}, new int[]{R.attr.state_checked}, new int[]{R.attr.state_selected}, new int[]{-16842910}, new int[]{R.attr.state_enabled}};
    }

    public final byte[] serialize(MaterialConfig r3) {
        Intrinsics.checkNotNullParameter(r3, "config");
        return serializeArray(new MaterialConfig[]{r3});
    }

    public final byte[] serializeArray(MaterialConfig[] r5) {
        Intrinsics.checkNotNullParameter(r5, Constants.KEY_CONFIG);
        ByteArrayOutputStream r4 = new ByteArrayOutputStream();
        ByteArrayOutputStream r0 = r4;     // Catch: Throwable -> L14
        DataOutputStream r1 = new DataOutputStream(r0);     // Catch: Throwable -> L14
        DataOutputStream r2 = r1;     // Catch: Throwable -> L9
        r2.writeInt(MAGIC);     // Catch: Throwable -> L9
        r2.writeByte(1);     // Catch: Throwable -> L9
        r2.writeInt(r5.length);     // Catch: Throwable -> L9
        INSTANCE.writeConfigArray(r2, r5);     // Catch: Throwable -> L9
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L9
    L6:
        CloseableKt.closeFinally(r1, null);     // Catch: Throwable -> L14
        byte[] r3 = r0.toByteArray();     // Catch: Throwable -> L14
        CloseableKt.closeFinally(r4, null);
        Intrinsics.checkNotNullExpressionValue(r3, "ByteArrayOutputStream().…m.toByteArray()\n        }");
        return r3;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        CloseableKt.closeFinally(r1, th);     // Catch: Throwable -> L14
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        CloseableKt.closeFinally(r4, th);
        throw th;
    }

    public final MaterialConfig[] deserializeArray(byte[] r4) {
        Intrinsics.checkNotNullParameter(r4, "payload");
        DataInputStream r0 = new DataInputStream(new ByteArrayInputStream(r4));     // Catch: Throwable -> L22
        DataInputStream r5 = r0;     // Catch: Throwable -> L17
        if (r5.readInt() == MAGIC) goto L11;
        CloseableKt.closeFinally(r0, null);     // Catch: Throwable -> L22
        return null;
    L11:
        if (r5.readUnsignedByte() == 1) goto L14;
        CloseableKt.closeFinally(r0, null);     // Catch: Throwable -> L22
        return null;
    L14:
        MaterialConfig[] r6 = INSTANCE.readConfigArray(r5.readInt(), r5);     // Catch: Throwable -> L17
        CloseableKt.closeFinally(r0, null);     // Catch: Throwable -> L22
        return r6;
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        CloseableKt.closeFinally(r0, th);     // Catch: Throwable -> L22
        throw th;     // Catch: Throwable -> L22
    L22:
        MaterialConfig[] r7 = (MaterialConfig[]) null;
        return null;
    }

    private final void writeConfig(DataOutputStream r2, MaterialConfig r3) {
        writeColorStateList(r2, r3.getFallbackBgColor());
        writeBlendConfigStateList(r2, r3.getBlendConfigStateList());
        writeBlendConfigArray(r2, r3.getBlendConfig());
        writeStrokeStateList(r2, r3.getStrokeStateList());
        writeStroke(r2, r3.getStroke());
        writeBlendConfigStateList(r2, r3.getOverlayBlendConfigStateList());
        writeBlurConfig(r2, r3.getBlurConfig());
        writeNullableFloat(r2, r3.getBlurRadius());
        writeShadowArray(r2, r3.getShadow());
        writeFluidConfig(r2, r3.getFluid());
    }

    private final MaterialConfig readConfig(DataInputStream r13) {
        ColorStateList r1 = readColorStateList(r13);
        BlendConfigStateList r2 = readBlendConfigStateList(r13);
        BlendConfig[] r0 = readBlendConfigArray(r13);
        if (r0 != null) goto L8;
        if (r2 != null) goto L6;
        r0 = null;
        goto L8
    L6:
        r0 = r2.getDefaultBlendConfig();
    L8:
        return new MaterialConfig(r1, r2, r0, readStrokeStateList(r13), readStroke(r13), readBlendConfigStateList(r13), readBlurConfig(r13), readNullableFloat(r13), readShadowArray(r13), readFluidConfig(r13));
    }

    private final MaterialConfig[] readConfigArray(int r3, DataInputStream r4) {
        if (r3 > 0) goto L5;
        return null;
    L5:
        MaterialConfig[] r2 = new MaterialConfig[r3];
        int r0 = 0;
    L6:
        if (r0 >= r3) goto L8;
        r2[r0] = INSTANCE.readConfig(r4);
        r0 = r0 + 1;
        goto L6
    L8:
        return r2;
    }

    private final void writeColorStateList(DataOutputStream r4, ColorStateList r5) {
        if (r5 == null) goto L5;
        boolean r1 = true;
    L6:
        r4.writeBoolean(r1);
        if (r5 != null) goto L9;
        return;
    L9:
        r4.writeInt(r5.getColorForState(new int[]{R.attr.state_enabled}, r5.getDefaultColor()));
        r4.writeInt(r5.getColorForState(new int[]{R.attr.state_pressed}, r5.getDefaultColor()));
        r4.writeInt(r5.getColorForState(new int[]{R.attr.state_hovered}, r5.getDefaultColor()));
        r4.writeInt(r5.getColorForState(new int[]{R.attr.state_checked}, r5.getDefaultColor()));
        r4.writeInt(r5.getColorForState(new int[]{R.attr.state_selected}, r5.getDefaultColor()));
        r4.writeInt(r5.getColorForState(new int[]{-16842910}, r5.getDefaultColor()));
        return;
    L5:
        r1 = false;
        goto L6
    }

    private final ColorStateList readColorStateList(DataInputStream r8) {
        if (r8.readBoolean() == true) goto L6;
        return null;
    L6:
        StatefulValue r7 = new StatefulValue(Integer.valueOf(r8.readInt()), Integer.valueOf(r8.readInt()), Integer.valueOf(r8.readInt()), Integer.valueOf(r8.readInt()), Integer.valueOf(r8.readInt()), Integer.valueOf(r8.readInt()));
        if (r7.allEqual() == false) goto L10;
        return ColorStateList.valueOf(((Number) r7.getNormal()).intValue());
    L10:
        return new ColorStateList(SERIALIZATION_STATE_SPECS, new int[]{((Number) r7.getPressed()).intValue(), ((Number) r7.getHovered()).intValue(), ((Number) r7.getChecked()).intValue(), ((Number) r7.getSelected()).intValue(), ((Number) r7.getDisabled()).intValue(), ((Number) r7.getNormal()).intValue()});
    }

    private final void writeBlendConfigStateList(DataOutputStream r7, BlendConfigStateList r8) {
        if (r8 == null) goto L5;
        boolean r2 = true;
    L6:
        r7.writeBoolean(r2);
        if (r8 != null) goto L9;
        return;
    L9:
        writeBlendConfigArray(r7, BlendConfigStateList.getConfigForState$default(r8, new int[]{R.attr.state_enabled}, null, 2, null));
        writeBlendConfigArray(r7, BlendConfigStateList.getConfigForState$default(r8, new int[]{R.attr.state_pressed}, null, 2, null));
        writeBlendConfigArray(r7, BlendConfigStateList.getConfigForState$default(r8, new int[]{R.attr.state_hovered}, null, 2, null));
        writeBlendConfigArray(r7, BlendConfigStateList.getConfigForState$default(r8, new int[]{R.attr.state_checked}, null, 2, null));
        writeBlendConfigArray(r7, BlendConfigStateList.getConfigForState$default(r8, new int[]{R.attr.state_selected}, null, 2, null));
        writeBlendConfigArray(r7, BlendConfigStateList.getConfigForState$default(r8, new int[]{-16842910}, null, 2, null));
        return;
    L5:
        r2 = false;
        goto L6
    }

    private final BlendConfigStateList readBlendConfigStateList(DataInputStream r10) {
        if (r10.readBoolean() == true) goto L5;
        return null;
    L5:
        BlendConfig[] r3 = readBlendConfigArray(r10);
        if (r3 != null) goto L8;
        return null;
    L8:
        BlendConfig[] r4 = readBlendConfigArray(r10);
        if (r4 != null) goto L11;
        return null;
    L11:
        BlendConfig[] r5 = readBlendConfigArray(r10);
        if (r5 != null) goto L14;
        return null;
    L14:
        BlendConfig[] r6 = readBlendConfigArray(r10);
        if (r6 != null) goto L17;
        return null;
    L17:
        BlendConfig[] r7 = readBlendConfigArray(r10);
        if (r7 != null) goto L20;
        return null;
    L20:
        BlendConfig[] r8 = readBlendConfigArray(r10);
        if (r8 != null) goto L23;
        return null;
    L23:
        StatefulValue r0 = new StatefulValue(r3, r4, r5, r6, r7, r8);
        if (r0.allEqual(AnonymousClass1.INSTANCE) == false) goto L27;
        return BlendConfigStateList.Companion.valueOf((BlendConfig[]) r0.getNormal());
    L27:
        return BlendConfigStateList.Companion.of(SERIALIZATION_STATE_SPECS, new BlendConfig[][]{(BlendConfig[]) r0.getPressed(), (BlendConfig[]) r0.getHovered(), (BlendConfig[]) r0.getChecked(), (BlendConfig[]) r0.getSelected(), (BlendConfig[]) r0.getDisabled(), (BlendConfig[]) r0.getNormal()});
    }

    private final void writeBlendConfigArray(DataOutputStream r4, BlendConfig[] r5) {
        int r3 = 0;
        if (r5 == null) goto L5;
        boolean r0 = true;
    L6:
        r4.writeBoolean(r0);
        if (r5 != null) goto L9;
        return;
    L9:
        r4.writeInt(r5.length);
        int r1 = r5.length;
    L10:
        if (r3 >= r1) goto L12;
        BlendConfig r2 = r5[r3];
        r4.writeInt(r2.getColor());
        r4.writeInt(r2.getBlendMode());
        r3 = r3 + 1;
        goto L10
    L12:
        return;
    L5:
        r0 = false;
        goto L6
    }

    private final BlendConfig[] readBlendConfigArray(DataInputStream r6) {
        if (r6.readBoolean() == true) goto L6;
        return null;
    L6:
        int r5 = r6.readInt();
        BlendConfig[] r0 = new BlendConfig[r5];
        int r1 = 0;
    L7:
        if (r1 >= r5) goto L9;
        r0[r1] = new BlendConfig(r6.readInt(), r6.readInt());
        r1 = r1 + 1;
        goto L7
    L9:
        return r0;
    }

    private final void writeStrokeStateList(DataOutputStream r7, StrokeStateList r8) {
        if (r8 == null) goto L5;
        boolean r2 = true;
    L6:
        r7.writeBoolean(r2);
        if (r8 != null) goto L9;
        return;
    L9:
        writeStroke(r7, StrokeStateList.getConfigForState$default(r8, new int[]{R.attr.state_enabled}, null, 2, null));
        writeStroke(r7, StrokeStateList.getConfigForState$default(r8, new int[]{R.attr.state_pressed}, null, 2, null));
        writeStroke(r7, StrokeStateList.getConfigForState$default(r8, new int[]{R.attr.state_hovered}, null, 2, null));
        writeStroke(r7, StrokeStateList.getConfigForState$default(r8, new int[]{R.attr.state_checked}, null, 2, null));
        writeStroke(r7, StrokeStateList.getConfigForState$default(r8, new int[]{R.attr.state_selected}, null, 2, null));
        writeStroke(r7, StrokeStateList.getConfigForState$default(r8, new int[]{-16842910}, null, 2, null));
        return;
    L5:
        r2 = false;
        goto L6
    }

    private final StrokeStateList readStrokeStateList(DataInputStream r10) {
        if (r10.readBoolean() == true) goto L5;
        return null;
    L5:
        StrokeConfig r3 = readStroke(r10);
        if (r3 != null) goto L8;
        return null;
    L8:
        StrokeConfig r4 = readStroke(r10);
        if (r4 != null) goto L11;
        return null;
    L11:
        StrokeConfig r5 = readStroke(r10);
        if (r5 != null) goto L14;
        return null;
    L14:
        StrokeConfig r6 = readStroke(r10);
        if (r6 != null) goto L17;
        return null;
    L17:
        StrokeConfig r7 = readStroke(r10);
        if (r7 != null) goto L20;
        return null;
    L20:
        StrokeConfig r8 = readStroke(r10);
        if (r8 != null) goto L23;
        return null;
    L23:
        StatefulValue r0 = new StatefulValue(r3, r4, r5, r6, r7, r8);
        if (r0.allEqual() == false) goto L27;
        return StrokeStateList.Companion.valueOf((StrokeConfig) r0.getNormal());
    L27:
        return StrokeStateList.Companion.of(SERIALIZATION_STATE_SPECS, new StrokeConfig[]{(StrokeConfig) r0.getPressed(), (StrokeConfig) r0.getHovered(), (StrokeConfig) r0.getChecked(), (StrokeConfig) r0.getSelected(), (StrokeConfig) r0.getDisabled(), (StrokeConfig) r0.getNormal()});
    }

    private final void writeStroke(DataOutputStream r1, StrokeConfig r2) {
        if (r2 == null) goto L4;
        boolean r0 = true;
    L5:
        r1.writeBoolean(r0);
        if (r2 != null) goto L8;
        return;
    L8:
        r1.writeFloat(r2.getWidth());
        r1.writeInt(r2.getColor());
        return;
    L4:
        r0 = false;
        goto L5
    }

    private final StrokeConfig readStroke(DataInputStream r7) {
        if (r7.readBoolean() == true) goto L7;
        return null;
    L7:
        return new StrokeConfig(r7.readFloat(), r7.readInt(), null, 4, null);
    }

    private final void writeBlurConfig(DataOutputStream r1, BlurConfig r2) {
        if (r2 == null) goto L4;
        boolean r0 = true;
    L5:
        r1.writeBoolean(r0);
        if (r2 != null) goto L8;
        return;
    L8:
        r1.writeFloat(r2.getBlurRadius());
        r1.writeInt(r2.getDirection());
        r1.writeFloat(r2.getAlpha());
        r1.writeInt(r2.getCurveType());
        r1.writeFloat(r2.getEndPoint());
        return;
    L4:
        r0 = false;
        goto L5
    }

    private final BlurConfig readBlurConfig(DataInputStream r7) {
        if (r7.readBoolean() == true) goto L7;
        return null;
    L7:
        return new BlurConfig(r7.readFloat(), r7.readInt(), r7.readFloat(), r7.readInt(), r7.readFloat());
    }

    private final void writeNullableFloat(DataOutputStream r1, Float r2) {
        if (r2 == null) goto L4;
        boolean r0 = true;
    L5:
        r1.writeBoolean(r0);
        if (r2 == null) goto L9;
        r1.writeFloat(r2.floatValue());
        return;
    L9:
        return;
    L4:
        r0 = false;
        goto L5
    }

    private final Float readNullableFloat(DataInputStream r1) {
        if (r1.readBoolean() == true) goto L7;
        return null;
    L7:
        return Float.valueOf(r1.readFloat());
    }

    private final void writeShadowArray(DataOutputStream r4, ShadowConfig[] r5) {
        int r3 = 0;
        if (r5 == null) goto L5;
        boolean r0 = true;
    L6:
        r4.writeBoolean(r0);
        if (r5 != null) goto L9;
        return;
    L9:
        r4.writeInt(r5.length);
        int r1 = r5.length;
    L10:
        if (r3 >= r1) goto L12;
        ShadowConfig r2 = r5[r3];
        r4.writeFloat(r2.getX());
        r4.writeFloat(r2.getY());
        r4.writeFloat(r2.getBlurRadius());
        r4.writeInt(r2.getColor());
        r4.writeFloat(r2.getSpread());
        r4.writeInt(r2.getBlendMode());
        r3 = r3 + 1;
        goto L10
    L12:
        return;
    L5:
        r0 = false;
        goto L6
    }

    private final ShadowConfig[] readShadowArray(DataInputStream r11) {
        if (r11.readBoolean() == true) goto L6;
        return null;
    L6:
        int r10 = r11.readInt();
        ShadowConfig[] r0 = new ShadowConfig[r10];
        int r1 = 0;
    L7:
        if (r1 >= r10) goto L9;
        r0[r1] = new ShadowConfig(r11.readFloat(), r11.readFloat(), r11.readFloat(), r11.readInt(), r11.readFloat(), r11.readInt());
        r1 = r1 + 1;
        goto L7
    L9:
        return r0;
    }

    private final void writeFluidConfig(DataOutputStream r3, FluidConfig r4) {
        boolean r2 = true;
        int r0 = 0;
        if (r4 == null) goto L5;
        boolean r1 = true;
    L6:
        r3.writeBoolean(r1);
        if (r4 != null) goto L9;
        return;
    L9:
        float[] r5 = r4.getGlassParams();
        if (r5 != null) goto L13;
        r2 = false;
    L13:
        r3.writeBoolean(r2);
        if (r5 == null) goto L18;
        r3.writeInt(r5.length);
        int r6 = r5.length;
    L16:
        if (r0 >= r6) goto L20;
        r3.writeFloat(r5[r0]);
        r0 = r0 + 1;
        goto L16
    L20:
        return;
    L18:
        return;
    L5:
        r1 = false;
        goto L6
    }

    private final FluidConfig readFluidConfig(DataInputStream r4) {
        float[] r0 = null;
        if (r4.readBoolean() == true) goto L6;
        return null;
    L6:
        if (r4.readBoolean() == true) goto L8;
        float[] r3 = (float[]) null;
    L12:
        return new FluidConfig(r0);
    L8:
        int r5 = r4.readInt();
        r0 = new float[r5];
        int r1 = 0;
    L9:
        if (r1 >= r5) goto L12;
        r0[r1] = r4.readFloat();
        r1 = r1 + 1;
        goto L9
    }

    private final void writeConfigArray(DataOutputStream r4, MaterialConfig[] r5) {
        int r3 = r5.length;
        int r0 = 0;
    L3:
        if (r0 >= r3) goto L5;
        MaterialConfig r1 = r5[r0];
        INSTANCE.writeConfig(r4, r1);
        r0 = r0 + 1;
        goto L3
    }
}
