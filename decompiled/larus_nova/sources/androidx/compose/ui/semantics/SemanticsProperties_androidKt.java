package androidx.compose.ui.semantics;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u001aB\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u001e\b\u0002\u0010\u0006\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u0001H\u0002\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0007\"/\u0010\n\u001a\u00020\t*\u00020\u000b2\u0006\u0010\b\u001a\u00020\t8F@FX\u0086\u008e\u0002¢\u0006\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011*\u0004\b\f\u0010\r\"/\u0010\u0012\u001a\u00020\u0004*\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00048F@FX\u0086\u008e\u0002¢\u0006\u0012\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017*\u0004\b\u0013\u0010\r¨\u0006\u0018"}, d2 = {"SemanticsPropertyKey", "Landroidx/compose/ui/semantics/SemanticsPropertyKey;", ExifInterface.GPS_DIRECTION_TRUE, "name", "", "accessibilityExtraKey", "mergePolicy", "Lkotlin/Function2;", "<set-?>", "", "testTagsAsResourceId", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "getTestTagsAsResourceId$delegate", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/lang/Object;", "getTestTagsAsResourceId", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Z", "setTestTagsAsResourceId", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Z)V", "accessibilityClassName", "getAccessibilityClassName$delegate", "getAccessibilityClassName", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/lang/String;", "setAccessibilityClassName", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Ljava/lang/String;)V", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SemanticsProperties_androidKt {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = null;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(SemanticsProperties_androidKt.class, "testTagsAsResourceId", "getTestTagsAsResourceId(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Z", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SemanticsProperties_androidKt.class, "accessibilityClassName", "getAccessibilityClassName(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/lang/String;", 1))};
        SemanticsPropertiesAndroid r100 = SemanticsPropertiesAndroid.INSTANCE;
        r100.getTestTagsAsResourceId();
        r100.getAccessibilityClassName();
    }

    public static final String getAccessibilityClassName(SemanticsPropertyReceiver r100) {
        return SemanticsPropertiesAndroid.INSTANCE.getAccessibilityClassName().getValue(r100, $$delegatedProperties[1]);
    }

    private static Object getAccessibilityClassName$delegate(SemanticsPropertyReceiver r100) {
        return SemanticsPropertiesAndroid.INSTANCE.getAccessibilityClassName();
    }

    public static final boolean getTestTagsAsResourceId(SemanticsPropertyReceiver r100) {
        return SemanticsPropertiesAndroid.INSTANCE.getTestTagsAsResourceId().getValue(r100, $$delegatedProperties[0]).booleanValue();
    }

    private static Object getTestTagsAsResourceId$delegate(SemanticsPropertyReceiver r100) {
        return SemanticsPropertiesAndroid.INSTANCE.getTestTagsAsResourceId();
    }

    public static final void setAccessibilityClassName(SemanticsPropertyReceiver r100, String r101) {
        SemanticsPropertiesAndroid.INSTANCE.getAccessibilityClassName().setValue(r100, $$delegatedProperties[1], r101);
    }

    public static final void setTestTagsAsResourceId(SemanticsPropertyReceiver r100, boolean r101) {
        SemanticsPropertiesAndroid.INSTANCE.getTestTagsAsResourceId().setValue(r100, $$delegatedProperties[0], Boolean.valueOf(r101));
    }

    public static final <T> SemanticsPropertyKey<T> SemanticsPropertyKey(String r100, String r101, Function2<? super T, ? super T, ? extends T> r102) {
        return new SemanticsPropertyKey(r100, false, r102, r101);
    }

    public static /* synthetic */ SemanticsPropertyKey SemanticsPropertyKey$default(String r100, String r101, Function2 r102, int r103, Object r104) {
        if ((r103 & 4) == 0) goto L6;
        r102 = AnonymousClass1.INSTANCE;
    L6:
        return SemanticsPropertyKey(r100, r101, r102);
    }
}
