package androidx.compose.ui.semantics;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.keyframes.model.KFAnimation;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B/\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u001e\b\u0002\u0010\u0005\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0006¢\u0006\u0004\b\u0007\u0010\bB\u0019\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0007\u0010\u000bBC\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u001c\u0010\u0005\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0006\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\rJ\u001f\u0010\u0018\u001a\u0004\u0018\u00018\u00002\b\u0010\u0019\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u001a\u001a\u00028\u0000¢\u0006\u0002\u0010\u001bJ\"\u0010\u001c\u001a\u00028\u00002\u0006\u0010\u001d\u001a\u00020\u001e2\n\u0010\u001f\u001a\u0006\u0012\u0002\b\u00030 H\u0086\u0002¢\u0006\u0002\u0010!J*\u0010\"\u001a\u00020#2\u0006\u0010\u001d\u001a\u00020\u001e2\n\u0010\u001f\u001a\u0006\u0012\u0002\b\u00030 2\u0006\u0010\u0012\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010$J\b\u0010%\u001a\u00020\u0004H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR*\u0010\u0005\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\n@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000f\"\u0004\b\u0016\u0010\u0017¨\u0006&"}, d2 = {"Landroidx/compose/ui/semantics/SemanticsPropertyKey;", ExifInterface.GPS_DIRECTION_TRUE, "", "name", "", "mergePolicy", "Lkotlin/Function2;", "<init>", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;)V", "isImportantForAccessibility", "", "(Ljava/lang/String;Z)V", "accessibilityExtraKey", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function2;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getMergePolicy$ui_release", "()Lkotlin/jvm/functions/Function2;", "value", "isImportantForAccessibility$ui_release", "()Z", "getAccessibilityExtraKey$ui_release", "setAccessibilityExtraKey$ui_release", "(Ljava/lang/String;)V", "merge", "parentValue", "childValue", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "getValue", "thisRef", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", KFAnimation.PROPERTY_TYPE_JSON_FIELD, "Lkotlin/reflect/KProperty;", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "setValue", "", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "toString", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SemanticsPropertyKey<T> {
    public static final int $stable = 8;
    private String accessibilityExtraKey;
    private boolean isImportantForAccessibility;
    private final Function2<T, T, T> mergePolicy;
    private final String name;

    public String toString() {
        return "AccessibilityKey: " + this.name;
    }

    public final String getAccessibilityExtraKey$ui_release() {
        return this.accessibilityExtraKey;
    }

    public final Function2<T, T, T> getMergePolicy$ui_release() {
        return this.mergePolicy;
    }

    public final String getName() {
        return this.name;
    }

    public final boolean isImportantForAccessibility$ui_release() {
        return this.isImportantForAccessibility;
    }

    public final void setAccessibilityExtraKey$ui_release(String r100) {
        this.accessibilityExtraKey = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SemanticsPropertyKey(String r100, Function2<? super T, ? super T, ? extends T> r101) {
        this.name = r100;
        this.mergePolicy = r101;
    }

    public final T getValue(SemanticsPropertyReceiver r100, KProperty<?> r101) {
        return (T) SemanticsPropertiesKt.access$throwSemanticsGetNotSupported();
    }

    public final T merge(T r100, T r101) {
        return this.mergePolicy.invoke(r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SemanticsPropertyKey(String r100, boolean r101) {
        this(r100, null, 2, 0 == true ? 1 : 0);
        this.isImportantForAccessibility = r101;
    }

    public final void setValue(SemanticsPropertyReceiver r100, KProperty<?> r101, T r102) {
        r100.set(this, r102);
    }

    public /* synthetic */ SemanticsPropertyKey(String r100, Function2 r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = AnonymousClass1.INSTANCE;
    L5:
        this(r100, r101);
    }

    public SemanticsPropertyKey(String r100, boolean r101, Function2<? super T, ? super T, ? extends T> r102, String r103) {
        this(r100, r102);
        this.isImportantForAccessibility = r101;
        this.accessibilityExtraKey = r103;
    }

    public /* synthetic */ SemanticsPropertyKey(String r100, boolean r101, Function2 r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 8) == 0) goto L5;
        r103 = null;
    L5:
        this(r100, r101, r102, r103);
    }
}
