package kotlin.reflect.jvm.internal.impl.load.kotlin;

import com.bytedance.apm.constant.SlardarConfigConsts;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SignatureBuildingComponents.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class SignatureBuildingComponents {
    public static final SignatureBuildingComponents INSTANCE = null;

    static {
        INSTANCE = new SignatureBuildingComponents();
    }

    private SignatureBuildingComponents() {
    }

    public static final /* synthetic */ String access$escapeClassName(SignatureBuildingComponents r0, String r1) {
        return r0.escapeClassName(r1);
    }

    public final String javaLang(String r2) {
        Intrinsics.checkNotNullParameter(r2, "name");
        return "java/lang/" + r2;
    }

    public final String javaUtil(String r2) {
        Intrinsics.checkNotNullParameter(r2, "name");
        return "java/util/" + r2;
    }

    public final String javaFunction(String r2) {
        Intrinsics.checkNotNullParameter(r2, "name");
        return "java/util/function/" + r2;
    }

    public final Set<String> inJavaLang(String r2, String... r3) {
        Intrinsics.checkNotNullParameter(r2, "name");
        Intrinsics.checkNotNullParameter(r3, "signatures");
        return inClass(javaLang(r2), (String[]) Arrays.copyOf(r3, r3.length));
    }

    public final Set<String> inJavaUtil(String r2, String... r3) {
        Intrinsics.checkNotNullParameter(r2, "name");
        Intrinsics.checkNotNullParameter(r3, "signatures");
        return inClass(javaUtil(r2), (String[]) Arrays.copyOf(r3, r3.length));
    }

    public final Set<String> inClass(String r6, String... r7) {
        Intrinsics.checkNotNullParameter(r6, "internalName");
        Intrinsics.checkNotNullParameter(r7, "signatures");
        LinkedHashSet r5 = new LinkedHashSet();
        int r0 = r7.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L6;
        r5.add(r6 + '.' + r7[r1]);
        r1 = r1 + 1;
        goto L3
    L6:
        return r5;
    }

    public final String signature(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "internalName");
        Intrinsics.checkNotNullParameter(r2, "jvmDescriptor");
        return r1 + '.' + r2;
    }

    public final String jvmDescriptor(String r10, List<String> r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "name");
        Intrinsics.checkNotNullParameter(r11, "parameters");
        Intrinsics.checkNotNullParameter(r12, SlardarConfigConsts.CONFIG_RET);
        return r10 + '(' + CollectionsKt.joinToString$default(r11, "", null, null, 0, null, AnonymousClass1.INSTANCE, 30, null) + ')' + escapeClassName(r12);
    }

    private final String escapeClassName(String r2) {
        if (r2.length() > 1) goto L5;
        return r2;
    L5:
        return "L" + r2 + ';';
    }

    public final String[] constructors(String... r7) {
        Intrinsics.checkNotNullParameter(r7, "signatures");
        ArrayList r6 = new ArrayList(r7.length);
        int r0 = r7.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        r6.add("<init>(" + r7[r2] + ")V");
        r2 = r2 + 1;
        goto L3
    L5:
        Object[] r8 = r6.toArray(new String[0]);
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (String[]) r8;
    }
}
