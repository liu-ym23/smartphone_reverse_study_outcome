package kotlin.reflect.jvm.internal.impl.renderer;

import com.android.vcard.VCardConstants;
import java.util.ArrayList;
import java.util.Set;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: DescriptorRenderer.kt */
/* JADX INFO: loaded from: classes4.dex */
public final enum DescriptorRendererModifier extends Enum<DescriptorRendererModifier> {
    private static final /* synthetic */ DescriptorRendererModifier[] $VALUES = null;
    public static final DescriptorRendererModifier ACTUAL = null;
    public static final Set<DescriptorRendererModifier> ALL = null;
    public static final Set<DescriptorRendererModifier> ALL_EXCEPT_ANNOTATIONS = null;
    public static final DescriptorRendererModifier ANNOTATIONS = null;
    public static final DescriptorRendererModifier CONST = null;
    public static final Companion Companion = null;
    public static final DescriptorRendererModifier DATA = null;
    public static final DescriptorRendererModifier EXPECT = null;
    public static final DescriptorRendererModifier FUN = null;
    public static final DescriptorRendererModifier INLINE = null;
    public static final DescriptorRendererModifier INNER = null;
    public static final DescriptorRendererModifier LATEINIT = null;
    public static final DescriptorRendererModifier MEMBER_KIND = null;
    public static final DescriptorRendererModifier MODALITY = null;
    public static final DescriptorRendererModifier OVERRIDE = null;
    public static final DescriptorRendererModifier VALUE = null;
    public static final DescriptorRendererModifier VISIBILITY = null;
    private final boolean includeByDefault;

    /* JADX INFO: compiled from: DescriptorRenderer.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ DescriptorRendererModifier[] $values() {
        return new DescriptorRendererModifier[]{VISIBILITY, MODALITY, OVERRIDE, ANNOTATIONS, INNER, MEMBER_KIND, DATA, INLINE, EXPECT, ACTUAL, CONST, LATEINIT, FUN, VALUE};
    }

    public static DescriptorRendererModifier valueOf(String r1) {
        return (DescriptorRendererModifier) Enum.valueOf(DescriptorRendererModifier.class, r1);
    }

    public static DescriptorRendererModifier[] values() {
        return (DescriptorRendererModifier[]) $VALUES.clone();
    }

    private DescriptorRendererModifier(String r1, int r2, boolean r3) {
        super(r1, r2);
        this.includeByDefault = r3;
    }

    static {
        int r2 = 0;
        VISIBILITY = new DescriptorRendererModifier("VISIBILITY", 0, true);
        MODALITY = new DescriptorRendererModifier("MODALITY", 1, true);
        OVERRIDE = new DescriptorRendererModifier("OVERRIDE", 2, true);
        ANNOTATIONS = new DescriptorRendererModifier("ANNOTATIONS", 3, false);
        INNER = new DescriptorRendererModifier("INNER", 4, true);
        MEMBER_KIND = new DescriptorRendererModifier("MEMBER_KIND", 5, true);
        DATA = new DescriptorRendererModifier("DATA", 6, true);
        INLINE = new DescriptorRendererModifier("INLINE", 7, true);
        EXPECT = new DescriptorRendererModifier("EXPECT", 8, true);
        ACTUAL = new DescriptorRendererModifier("ACTUAL", 9, true);
        CONST = new DescriptorRendererModifier("CONST", 10, true);
        LATEINIT = new DescriptorRendererModifier("LATEINIT", 11, true);
        FUN = new DescriptorRendererModifier("FUN", 12, true);
        VALUE = new DescriptorRendererModifier(VCardConstants.PARAM_VALUE, 13, true);
        $VALUES = $values();
        Companion = new Companion(null);
        DescriptorRendererModifier[] r0 = values();
        ArrayList r1 = new ArrayList();
        int r3 = r0.length;
    L3:
        if (r2 >= r3) goto L8;
        DescriptorRendererModifier r4 = r0[r2];
        if (r4.includeByDefault == false) goto L7;
        r1.add(r4);
    L7:
        r2 = r2 + 1;
        goto L3
    L8:
        ALL_EXCEPT_ANNOTATIONS = CollectionsKt.toSet(r1);
        ALL = ArraysKt.toSet(values());
    }
}
