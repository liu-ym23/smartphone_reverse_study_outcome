package androidx.compose.ui.text.android;

import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\tH\u0016¨\u0006\r"}, d2 = {"Landroidx/compose/ui/text/android/StaticLayoutFactoryDefault;", "Landroidx/compose/ui/text/android/StaticLayoutFactoryImpl;", "<init>", "()V", "create", "Landroid/text/StaticLayout;", "params", "Landroidx/compose/ui/text/android/StaticLayoutParams;", "isFallbackLineSpacingEnabled", "", "layout", "useFallbackLineSpacing", "Companion", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class StaticLayoutFactoryDefault implements StaticLayoutFactoryImpl {
    public static final Companion Companion = null;
    private static boolean isInitialized;
    private static Constructor<StaticLayout> staticLayoutConstructor;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Landroidx/compose/ui/text/android/StaticLayoutFactoryDefault$Companion;", "", "<init>", "()V", "isInitialized", "", "staticLayoutConstructor", "Ljava/lang/reflect/Constructor;", "Landroid/text/StaticLayout;", "getStaticLayoutConstructor", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        private final Constructor<StaticLayout> getStaticLayoutConstructor() {
            if (StaticLayoutFactoryDefault.access$isInitialized$cp() == true) goto L5;
            StaticLayoutFactoryDefault.access$setInitialized$cp(true);
            Class r100 = Integer.TYPE;     // Catch: NoSuchMethodException -> L9
            Class r101 = Float.TYPE;     // Catch: NoSuchMethodException -> L9
            StaticLayoutFactoryDefault.access$setStaticLayoutConstructor$cp(StaticLayout.class.getConstructor(new Class[]{CharSequence.class, r100, r100, TextPaint.class, r100, Layout.Alignment.class, TextDirectionHeuristic.class, r101, r101, Boolean.TYPE, TextUtils.TruncateAt.class, r100, r100}));     // Catch: NoSuchMethodException -> L9
        L11:
            return StaticLayoutFactoryDefault.access$getStaticLayoutConstructor$cp();
        L9:
            StaticLayoutFactoryDefault.access$setStaticLayoutConstructor$cp(null);
            goto L11
        L5:
            return StaticLayoutFactoryDefault.access$getStaticLayoutConstructor$cp();
        }

        public static final /* synthetic */ Constructor access$getStaticLayoutConstructor(Companion r100) {
            return r100.getStaticLayoutConstructor();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public StaticLayoutFactoryDefault() {
    }

    @Override // androidx.compose.ui.text.android.StaticLayoutFactoryImpl
    public boolean isFallbackLineSpacingEnabled(StaticLayout r100, boolean r101) {
        return false;
    }

    public static final /* synthetic */ Constructor access$getStaticLayoutConstructor$cp() {
        return staticLayoutConstructor;
    }

    public static final /* synthetic */ boolean access$isInitialized$cp() {
        return isInitialized;
    }

    public static final /* synthetic */ void access$setInitialized$cp(boolean r100) {
        isInitialized = r100;
    }

    public static final /* synthetic */ void access$setStaticLayoutConstructor$cp(Constructor r100) {
        staticLayoutConstructor = r100;
    }

    @Override // androidx.compose.ui.text.android.StaticLayoutFactoryImpl
    public StaticLayout create(StaticLayoutParams r110) {
        Constructor r100 = Companion.access$getStaticLayoutConstructor(Companion);
        StaticLayout r101 = null;
        if (r100 != null) goto L14;
    L10:
        if (r101 == null) goto L13;
        return r101;
    L13:
        return new StaticLayout(r110.getText(), r110.getStart(), r110.getEnd(), r110.getPaint(), r110.getWidth(), r110.getAlignment(), r110.getLineSpacingMultiplier(), r110.getLineSpacingExtra(), r110.getIncludePadding(), r110.getEllipsize(), r110.getEllipsizedWidth());
    L14:
        r101 = (StaticLayout) r100.newInstance(new Object[]{r110.getText(), Integer.valueOf(r110.getStart()), Integer.valueOf(r110.getEnd()), r110.getPaint(), Integer.valueOf(r110.getWidth()), r110.getAlignment(), r110.getTextDir(), Float.valueOf(r110.getLineSpacingMultiplier()), Float.valueOf(r110.getLineSpacingExtra()), Boolean.valueOf(r110.getIncludePadding()), r110.getEllipsize(), Integer.valueOf(r110.getEllipsizedWidth()), Integer.valueOf(r110.getMaxLines())});     // Catch: InvocationTargetException -> L7 InstantiationException -> L8 IllegalAccessException -> L9
        goto L10
    L9:
        staticLayoutConstructor = null;
    L8:
        staticLayoutConstructor = null;
    L7:
        staticLayoutConstructor = null;
        goto L10
    }
}
