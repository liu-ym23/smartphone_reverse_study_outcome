package kotlin.reflect.jvm.internal.impl.resolve.constants;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* JADX INFO: compiled from: constantValues.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class CharValue extends IntegerValueConstant<Character> {
    public CharValue(char r1) {
        super(Character.valueOf(r1));
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
    public /* bridge */ /* synthetic */ KotlinType getType(ModuleDescriptor r1) {
        return getType(r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
    public SimpleType getType(ModuleDescriptor r1) {
        Intrinsics.checkNotNullParameter(r1, "module");
        SimpleType r0 = r1.getBuiltIns().getCharType();
        Intrinsics.checkNotNullExpressionValue(r0, "module.builtIns.charType");
        return r0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
    public String toString() {
        String r4 = String.format("\\u%04X ('%s')", Arrays.copyOf(new Object[]{Integer.valueOf(getValue().charValue()), getPrintablePart(getValue().charValue())}, 2));
        Intrinsics.checkNotNullExpressionValue(r4, "format(this, *args)");
        return r4;
    }

    private final String getPrintablePart(char r2) {
        if (r2 != '\b') goto L6;
        return "\\b";
    L6:
        if (r2 != '\t') goto L9;
        return "\\t";
    L9:
        if (r2 != '\n') goto L12;
        return "\\n";
    L12:
        if (r2 != '\f') goto L15;
        return "\\f";
    L15:
        if (r2 != '\r') goto L18;
        return "\\r";
    L18:
        if (isPrintableUnicode(r2) == true) goto L27;
        return "?";
    L27:
        return String.valueOf(r2);
    }

    private final boolean isPrintableUnicode(char r1) {
        byte r0 = (byte) Character.getType(r1);
        if (r0 != 0) goto L5;
    L17:
        return false;
    L5:
        if (r0 == 13) goto L17;
        if (r0 == 14) goto L17;
        if (r0 == 15) goto L17;
        if (r0 == 16) goto L17;
        if (r0 == 18) goto L17;
        if (r0 == 19) goto L17;
        return true;
    }
}
