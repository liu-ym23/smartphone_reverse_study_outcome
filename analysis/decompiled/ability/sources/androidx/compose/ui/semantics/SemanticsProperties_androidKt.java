package androidx.compose.ui.semantics;

import Z7.t;
import androidx.autofill.HintConstants;
import androidx.compose.foundation.b;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\u001aI\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u001e\b\u0002\u0010\u0005\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0004¢\u0006\u0004\b\u0007\u0010\b\"/\u0010\u0012\u001a\u00020\n*\u00020\t2\u0006\u0010\u000b\u001a\u00020\n8F@FX\u0086\u008e\u0002¢\u0006\u0012\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f*\u0004\b\u0010\u0010\u0011\"/\u0010\u0018\u001a\u00020\u0001*\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00018F@FX\u0086\u008e\u0002¢\u0006\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016*\u0004\b\u0017\u0010\u0011¨\u0006\u0019"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", HintConstants.AUTOFILL_HINT_NAME, "accessibilityExtraKey", "Lkotlin/Function2;", "mergePolicy", "Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "SemanticsPropertyKey", "(Ljava/lang/String;Ljava/lang/String;LS7/n;)Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "", "<set-?>", "getTestTagsAsResourceId", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Z", "setTestTagsAsResourceId", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Z)V", "getTestTagsAsResourceId$delegate", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/lang/Object;", "testTagsAsResourceId", "getAccessibilityClassName", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/lang/String;", "setAccessibilityClassName", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Ljava/lang/String;)V", "getAccessibilityClassName$delegate", "accessibilityClassName", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SemanticsProperties_androidKt {
    static final /* synthetic */ t[] $$delegatedProperties;

    static {
        MutablePropertyReference1Impl mutablePropertyReference1Impl = new MutablePropertyReference1Impl(SemanticsProperties_androidKt.class, "testTagsAsResourceId", "getTestTagsAsResourceId(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Z", 1);
        n nVar = m.f4928a;
        $$delegatedProperties = new t[]{nVar.e(mutablePropertyReference1Impl), b.i(SemanticsProperties_androidKt.class, "accessibilityClassName", "getAccessibilityClassName(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/lang/String;", 1, nVar)};
        SemanticsPropertiesAndroid semanticsPropertiesAndroid = SemanticsPropertiesAndroid.INSTANCE;
        semanticsPropertiesAndroid.getTestTagsAsResourceId();
        semanticsPropertiesAndroid.getAccessibilityClassName();
    }

    public static final <T> SemanticsPropertyKey<T> SemanticsPropertyKey(String str, String str2, S7.n nVar) {
        return new SemanticsPropertyKey<>(str, false, nVar, str2);
    }

    public static /* synthetic */ SemanticsPropertyKey SemanticsPropertyKey$default(String str, String str2, S7.n nVar, int i, Object obj) {
        if ((i & 4) != 0) {
            nVar = new S7.n() { // from class: androidx.compose.ui.semantics.SemanticsProperties_androidKt.SemanticsPropertyKey.1
                @Override // S7.n
                public final Object invoke(Object obj2, Object obj3) {
                    return obj2;
                }
            };
        }
        return SemanticsPropertyKey(str, str2, nVar);
    }

    public static final String getAccessibilityClassName(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        return SemanticsPropertiesAndroid.INSTANCE.getAccessibilityClassName().getValue(semanticsPropertyReceiver, $$delegatedProperties[1]);
    }

    public static final boolean getTestTagsAsResourceId(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        return SemanticsPropertiesAndroid.INSTANCE.getTestTagsAsResourceId().getValue(semanticsPropertyReceiver, $$delegatedProperties[0]).booleanValue();
    }

    public static final void setAccessibilityClassName(SemanticsPropertyReceiver semanticsPropertyReceiver, String str) {
        SemanticsPropertiesAndroid.INSTANCE.getAccessibilityClassName().setValue(semanticsPropertyReceiver, $$delegatedProperties[1], str);
    }

    public static final void setTestTagsAsResourceId(SemanticsPropertyReceiver semanticsPropertyReceiver, boolean z10) {
        SemanticsPropertiesAndroid.INSTANCE.getTestTagsAsResourceId().setValue(semanticsPropertyReceiver, $$delegatedProperties[0], Boolean.valueOf(z10));
    }
}
