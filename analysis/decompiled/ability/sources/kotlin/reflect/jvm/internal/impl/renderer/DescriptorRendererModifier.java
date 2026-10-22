package kotlin.reflect.jvm.internal.impl.renderer;

import D7.q;
import D7.v;
import java.util.ArrayList;
import java.util.Set;
import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes4.dex */
public final class DescriptorRendererModifier {
    public static final Set b;
    public static final Set c;
    public static final DescriptorRendererModifier d;
    public static final DescriptorRendererModifier e;
    public static final DescriptorRendererModifier f;
    public static final DescriptorRendererModifier g;
    public static final DescriptorRendererModifier h;
    public static final DescriptorRendererModifier i;

    /* renamed from: j, reason: collision with root package name */
    public static final DescriptorRendererModifier f5106j;
    public static final DescriptorRendererModifier k;
    public static final DescriptorRendererModifier l;
    public static final DescriptorRendererModifier m;
    public static final DescriptorRendererModifier n;
    public static final DescriptorRendererModifier o;
    public static final DescriptorRendererModifier p;

    /* renamed from: q, reason: collision with root package name */
    public static final DescriptorRendererModifier f5107q;

    /* renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ DescriptorRendererModifier[] f5108r;

    /* renamed from: a, reason: collision with root package name */
    public final boolean f5109a;

    static {
        DescriptorRendererModifier descriptorRendererModifier = new DescriptorRendererModifier("VISIBILITY", 0, true);
        d = descriptorRendererModifier;
        DescriptorRendererModifier descriptorRendererModifier2 = new DescriptorRendererModifier("MODALITY", 1, true);
        e = descriptorRendererModifier2;
        DescriptorRendererModifier descriptorRendererModifier3 = new DescriptorRendererModifier("OVERRIDE", 2, true);
        f = descriptorRendererModifier3;
        DescriptorRendererModifier descriptorRendererModifier4 = new DescriptorRendererModifier("ANNOTATIONS", 3, false);
        g = descriptorRendererModifier4;
        DescriptorRendererModifier descriptorRendererModifier5 = new DescriptorRendererModifier("INNER", 4, true);
        h = descriptorRendererModifier5;
        DescriptorRendererModifier descriptorRendererModifier6 = new DescriptorRendererModifier("MEMBER_KIND", 5, true);
        i = descriptorRendererModifier6;
        DescriptorRendererModifier descriptorRendererModifier7 = new DescriptorRendererModifier("DATA", 6, true);
        f5106j = descriptorRendererModifier7;
        DescriptorRendererModifier descriptorRendererModifier8 = new DescriptorRendererModifier("INLINE", 7, true);
        k = descriptorRendererModifier8;
        DescriptorRendererModifier descriptorRendererModifier9 = new DescriptorRendererModifier("EXPECT", 8, true);
        l = descriptorRendererModifier9;
        DescriptorRendererModifier descriptorRendererModifier10 = new DescriptorRendererModifier("ACTUAL", 9, true);
        m = descriptorRendererModifier10;
        DescriptorRendererModifier descriptorRendererModifier11 = new DescriptorRendererModifier("CONST", 10, true);
        n = descriptorRendererModifier11;
        DescriptorRendererModifier descriptorRendererModifier12 = new DescriptorRendererModifier("LATEINIT", 11, true);
        o = descriptorRendererModifier12;
        DescriptorRendererModifier descriptorRendererModifier13 = new DescriptorRendererModifier("FUN", 12, true);
        p = descriptorRendererModifier13;
        DescriptorRendererModifier descriptorRendererModifier14 = new DescriptorRendererModifier("VALUE", 13, true);
        f5107q = descriptorRendererModifier14;
        DescriptorRendererModifier[] descriptorRendererModifierArr = {descriptorRendererModifier, descriptorRendererModifier2, descriptorRendererModifier3, descriptorRendererModifier4, descriptorRendererModifier5, descriptorRendererModifier6, descriptorRendererModifier7, descriptorRendererModifier8, descriptorRendererModifier9, descriptorRendererModifier10, descriptorRendererModifier11, descriptorRendererModifier12, descriptorRendererModifier13, descriptorRendererModifier14};
        f5108r = descriptorRendererModifierArr;
        a.a(descriptorRendererModifierArr);
        DescriptorRendererModifier[] descriptorRendererModifierArrValues = values();
        ArrayList arrayList = new ArrayList();
        for (DescriptorRendererModifier descriptorRendererModifier15 : descriptorRendererModifierArrValues) {
            if (descriptorRendererModifier15.f5109a) {
                arrayList.add(descriptorRendererModifier15);
            }
        }
        b = v.j1(arrayList);
        c = q.K0(values());
    }

    public DescriptorRendererModifier(String str, int i6, boolean z10) {
        this.f5109a = z10;
    }

    public static DescriptorRendererModifier valueOf(String str) {
        return (DescriptorRendererModifier) Enum.valueOf(DescriptorRendererModifier.class, str);
    }

    public static DescriptorRendererModifier[] values() {
        return (DescriptorRendererModifier[]) f5108r.clone();
    }
}
