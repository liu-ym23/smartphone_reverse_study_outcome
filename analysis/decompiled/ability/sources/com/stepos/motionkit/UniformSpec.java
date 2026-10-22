package com.stepos.motionkit;

import Y7.b;
import androidx.autofill.HintConstants;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import g1.AbstractC1451a;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0006\u000b\f\r\u000e\u000f\u0010B\u001d\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\n\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b\u0082\u0001\u0006\u0011\u0012\u0013\u0014\u0015\u0016¨\u0006\u0017"}, d2 = {"Lcom/stepos/motionkit/UniformSpec;", "", HintConstants.AUTOFILL_HINT_NAME, "", "label", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getLabel", "displayName", "Float1", "Float2", "Float3", "Float4", "Color", "Mat3", "Lcom/stepos/motionkit/UniformSpec$Color;", "Lcom/stepos/motionkit/UniformSpec$Float1;", "Lcom/stepos/motionkit/UniformSpec$Float2;", "Lcom/stepos/motionkit/UniformSpec$Float3;", "Lcom/stepos/motionkit/UniformSpec$Float4;", "Lcom/stepos/motionkit/UniformSpec$Mat3;", "motionkit-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class UniformSpec {
    private final String label;
    private final String name;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/stepos/motionkit/UniformSpec$Color;", "Lcom/stepos/motionkit/UniformSpec;", HintConstants.AUTOFILL_HINT_NAME, "", "defaultColor", "", "label", AppAgent.CONSTRUCT, "(Ljava/lang/String;ILjava/lang/String;)V", "getDefaultColor", "()I", "motionkit-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Color extends UniformSpec {
        private final int defaultColor;

        public /* synthetic */ Color(String str, int i, String str2, int i6, e eVar) {
            this(str, (i6 & 2) != 0 ? -1 : i, (i6 & 4) != 0 ? null : str2);
        }

        public final int getDefaultColor() {
            return this.defaultColor;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Color(String name, int i, String str) {
            super(name, str, null);
            k.f(name, "name");
            this.defaultColor = i;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001f\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/stepos/motionkit/UniformSpec$Float1;", "Lcom/stepos/motionkit/UniformSpec;", "", HintConstants.AUTOFILL_HINT_NAME, "", "default", "LY7/b;", "range", "label", AppAgent.CONSTRUCT, "(Ljava/lang/String;FLY7/b;Ljava/lang/String;)V", "v", "clamp", "(F)F", "F", "getDefault", "()F", "LY7/b;", "getRange", "()LY7/b;", "motionkit-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Float1 extends UniformSpec {
        private final float default;
        private final b range;

        public /* synthetic */ Float1(String str, float f, b bVar, String str2, int i, e eVar) {
            this(str, (i & 2) != 0 ? 0.0f : f, (i & 4) != 0 ? null : bVar, (i & 8) != 0 ? null : str2);
        }

        public final float clamp(float v10) {
            b bVar = this.range;
            return bVar != null ? ((Number) AbstractC1451a.w(Float.valueOf(v10), bVar)).floatValue() : v10;
        }

        public final float getDefault() {
            return this.default;
        }

        public final b getRange() {
            return this.range;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Float1(String name, float f, b bVar, String str) {
            super(name, str, null);
            k.f(name, "name");
            this.default = f;
            this.range = bVar;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/stepos/motionkit/UniformSpec$Float2;", "Lcom/stepos/motionkit/UniformSpec;", HintConstants.AUTOFILL_HINT_NAME, "", "defaultX", "", "defaultY", "label", AppAgent.CONSTRUCT, "(Ljava/lang/String;FFLjava/lang/String;)V", "getDefaultX", "()F", "getDefaultY", "motionkit-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Float2 extends UniformSpec {
        private final float defaultX;
        private final float defaultY;

        public /* synthetic */ Float2(String str, float f, float f7, String str2, int i, e eVar) {
            this(str, (i & 2) != 0 ? 0.0f : f, (i & 4) != 0 ? 0.0f : f7, (i & 8) != 0 ? null : str2);
        }

        public final float getDefaultX() {
            return this.defaultX;
        }

        public final float getDefaultY() {
            return this.defaultY;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Float2(String name, float f, float f7, String str) {
            super(name, str, null);
            k.f(name, "name");
            this.defaultX = f;
            this.defaultY = f7;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/stepos/motionkit/UniformSpec$Float3;", "Lcom/stepos/motionkit/UniformSpec;", HintConstants.AUTOFILL_HINT_NAME, "", "defaultX", "", "defaultY", "defaultZ", "label", AppAgent.CONSTRUCT, "(Ljava/lang/String;FFFLjava/lang/String;)V", "getDefaultX", "()F", "getDefaultY", "getDefaultZ", "motionkit-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Float3 extends UniformSpec {
        private final float defaultX;
        private final float defaultY;
        private final float defaultZ;

        public /* synthetic */ Float3(String str, float f, float f7, float f9, String str2, int i, e eVar) {
            this(str, (i & 2) != 0 ? 0.0f : f, (i & 4) != 0 ? 0.0f : f7, (i & 8) != 0 ? 0.0f : f9, (i & 16) != 0 ? null : str2);
        }

        public final float getDefaultX() {
            return this.defaultX;
        }

        public final float getDefaultY() {
            return this.defaultY;
        }

        public final float getDefaultZ() {
            return this.defaultZ;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Float3(String name, float f, float f7, float f9, String str) {
            super(name, str, null);
            k.f(name, "name");
            this.defaultX = f;
            this.defaultY = f7;
            this.defaultZ = f9;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\f\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/stepos/motionkit/UniformSpec$Float4;", "Lcom/stepos/motionkit/UniformSpec;", HintConstants.AUTOFILL_HINT_NAME, "", "defaultX", "", "defaultY", "defaultZ", "defaultW", "label", AppAgent.CONSTRUCT, "(Ljava/lang/String;FFFFLjava/lang/String;)V", "getDefaultX", "()F", "getDefaultY", "getDefaultZ", "getDefaultW", "motionkit-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Float4 extends UniformSpec {
        private final float defaultW;
        private final float defaultX;
        private final float defaultY;
        private final float defaultZ;

        public /* synthetic */ Float4(String str, float f, float f7, float f9, float f10, String str2, int i, e eVar) {
            this(str, (i & 2) != 0 ? 0.0f : f, (i & 4) != 0 ? 0.0f : f7, (i & 8) != 0 ? 0.0f : f9, (i & 16) != 0 ? 0.0f : f10, (i & 32) != 0 ? null : str2);
        }

        public final float getDefaultW() {
            return this.defaultW;
        }

        public final float getDefaultX() {
            return this.defaultX;
        }

        public final float getDefaultY() {
            return this.defaultY;
        }

        public final float getDefaultZ() {
            return this.defaultZ;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Float4(String name, float f, float f7, float f9, float f10, String str) {
            super(name, str, null);
            k.f(name, "name");
            this.defaultX = f;
            this.defaultY = f7;
            this.defaultZ = f9;
            this.defaultW = f10;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/motionkit/UniformSpec$Mat3;", "Lcom/stepos/motionkit/UniformSpec;", HintConstants.AUTOFILL_HINT_NAME, "", "label", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;)V", "motionkit-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Mat3 extends UniformSpec {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Mat3(String name, String str) {
            super(name, str, null);
            k.f(name, "name");
        }

        public /* synthetic */ Mat3(String str, String str2, int i, e eVar) {
            this(str, (i & 2) != 0 ? null : str2);
        }
    }

    public /* synthetic */ UniformSpec(String str, String str2, e eVar) {
        this(str, str2);
    }

    public final String displayName() {
        String str = this.label;
        return str == null ? this.name : str;
    }

    public final String getLabel() {
        return this.label;
    }

    public final String getName() {
        return this.name;
    }

    private UniformSpec(String str, String str2) {
        this.name = str;
        this.label = str2;
    }

    public /* synthetic */ UniformSpec(String str, String str2, int i, e eVar) {
        this(str, (i & 2) != 0 ? null : str2, null);
    }
}
