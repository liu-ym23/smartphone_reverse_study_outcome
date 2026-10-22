package kotlin.reflect.jvm.internal.impl.renderer;

import Z8.F;
import Z8.r;
import h9.InterfaceC4149a;
import java.util.ArrayList;
import java.util.Set;
import kotlin.jvm.internal.i;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes5.dex */
public final class DescriptorRendererModifier {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ DescriptorRendererModifier[] $VALUES;
    public static final Set<DescriptorRendererModifier> ALL;
    public static final Set<DescriptorRendererModifier> ALL_EXCEPT_ANNOTATIONS;
    public static final a Companion;
    private final boolean includeByDefault;
    public static final DescriptorRendererModifier VISIBILITY = new DescriptorRendererModifier("VISIBILITY", 0, true);
    public static final DescriptorRendererModifier MODALITY = new DescriptorRendererModifier("MODALITY", 1, true);
    public static final DescriptorRendererModifier OVERRIDE = new DescriptorRendererModifier("OVERRIDE", 2, true);
    public static final DescriptorRendererModifier ANNOTATIONS = new DescriptorRendererModifier("ANNOTATIONS", 3, false);
    public static final DescriptorRendererModifier INNER = new DescriptorRendererModifier("INNER", 4, true);
    public static final DescriptorRendererModifier MEMBER_KIND = new DescriptorRendererModifier("MEMBER_KIND", 5, true);
    public static final DescriptorRendererModifier DATA = new DescriptorRendererModifier("DATA", 6, true);
    public static final DescriptorRendererModifier INLINE = new DescriptorRendererModifier("INLINE", 7, true);
    public static final DescriptorRendererModifier EXPECT = new DescriptorRendererModifier("EXPECT", 8, true);
    public static final DescriptorRendererModifier ACTUAL = new DescriptorRendererModifier("ACTUAL", 9, true);
    public static final DescriptorRendererModifier CONST = new DescriptorRendererModifier("CONST", 10, true);
    public static final DescriptorRendererModifier LATEINIT = new DescriptorRendererModifier("LATEINIT", 11, true);
    public static final DescriptorRendererModifier FUN = new DescriptorRendererModifier("FUN", 12, true);
    public static final DescriptorRendererModifier VALUE = new DescriptorRendererModifier("VALUE", 13, true);

    public static final class a {
        public /* synthetic */ a(i iVar) {
            this();
        }

        public a() {
        }
    }

    private static final /* synthetic */ DescriptorRendererModifier[] $values() {
        return new DescriptorRendererModifier[]{VISIBILITY, MODALITY, OVERRIDE, ANNOTATIONS, INNER, MEMBER_KIND, DATA, INLINE, EXPECT, ACTUAL, CONST, LATEINIT, FUN, VALUE};
    }

    static {
        DescriptorRendererModifier[] descriptorRendererModifierArr$values = $values();
        $VALUES = descriptorRendererModifierArr$values;
        $ENTRIES = kotlin.enums.a.a(descriptorRendererModifierArr$values);
        Companion = new a(null);
        DescriptorRendererModifier[] descriptorRendererModifierArrValues = values();
        ArrayList arrayList = new ArrayList();
        for (DescriptorRendererModifier descriptorRendererModifier : descriptorRendererModifierArrValues) {
            if (descriptorRendererModifier.includeByDefault) {
                arrayList.add(descriptorRendererModifier);
            }
        }
        ALL_EXCEPT_ANNOTATIONS = F.r1(arrayList);
        ALL = r.i1(values());
    }

    private DescriptorRendererModifier(String str, int i10, boolean z10) {
        this.includeByDefault = z10;
    }

    public static DescriptorRendererModifier valueOf(String str) {
        return (DescriptorRendererModifier) Enum.valueOf(DescriptorRendererModifier.class, str);
    }

    public static DescriptorRendererModifier[] values() {
        return (DescriptorRendererModifier[]) $VALUES.clone();
    }
}
