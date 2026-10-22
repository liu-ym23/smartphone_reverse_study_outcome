package android.view;

import Ba.f;
import S7.k;
import android.content.res.Resources;
import androidx.annotation.ColorInt;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B5\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\bH\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\bH\u0000¢\u0006\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0012R\u001a\u0010\u0004\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0005\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0015\u0010\u0014R&\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00068\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Landroidx/activity/SystemBarStyle;", "", "", "lightScrim", "darkScrim", "nightMode", "Lkotlin/Function1;", "Landroid/content/res/Resources;", "", "detectDarkMode", AppAgent.CONSTRUCT, "(IIILS7/k;)V", "isDark", "getScrim$activity_release", "(Z)I", "getScrim", "getScrimWithEnforcedContrast$activity_release", "getScrimWithEnforcedContrast", "I", "getDarkScrim$activity_release", "()I", "getNightMode$activity_release", "LS7/k;", "getDetectDarkMode$activity_release", "()LS7/k;", "Companion", "activity_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SystemBarStyle {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int darkScrim;
    private final k detectDarkMode;
    private final int lightScrim;
    private final int nightMode;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J9\u0010\f\u001a\u00020\u000b2\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0006\u001a\u00020\u00042\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007H\u0007¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000f\u001a\u00020\u000b2\b\b\u0001\u0010\u000e\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u000f\u0010\u0010J#\u0010\u0011\u001a\u00020\u000b2\b\b\u0001\u0010\u000e\u001a\u00020\u00042\b\b\u0001\u0010\u0006\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Landroidx/activity/SystemBarStyle$Companion;", "", AppAgent.CONSTRUCT, "()V", "", "lightScrim", "darkScrim", "Lkotlin/Function1;", "Landroid/content/res/Resources;", "", "detectDarkMode", "Landroidx/activity/SystemBarStyle;", "auto", "(IILS7/k;)Landroidx/activity/SystemBarStyle;", "scrim", "dark", "(I)Landroidx/activity/SystemBarStyle;", "light", "(II)Landroidx/activity/SystemBarStyle;", "activity_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public static /* synthetic */ SystemBarStyle auto$default(Companion companion, int i, int i6, k kVar, int i10, Object obj) {
            if ((i10 & 4) != 0) {
                kVar = new p(1);
            }
            return companion.auto(i, i6, kVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean auto$lambda$0(Resources resources) {
            kotlin.jvm.internal.k.f(resources, "resources");
            return (resources.getConfiguration().uiMode & 48) == 32;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean dark$lambda$1(Resources resources) {
            kotlin.jvm.internal.k.f(resources, "<unused var>");
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean light$lambda$2(Resources resources) {
            kotlin.jvm.internal.k.f(resources, "<unused var>");
            return false;
        }

        public final SystemBarStyle auto(@ColorInt int i, @ColorInt int i6) {
            return auto$default(this, i, i6, null, 4, null);
        }

        public final SystemBarStyle dark(@ColorInt int scrim) {
            return new SystemBarStyle(scrim, scrim, 2, new p(0), null);
        }

        public final SystemBarStyle light(@ColorInt int scrim, @ColorInt int darkScrim) {
            return new SystemBarStyle(scrim, darkScrim, 1, new f(29), null);
        }

        private Companion() {
        }

        public final SystemBarStyle auto(@ColorInt int lightScrim, @ColorInt int darkScrim, k detectDarkMode) {
            kotlin.jvm.internal.k.f(detectDarkMode, "detectDarkMode");
            return new SystemBarStyle(lightScrim, darkScrim, 0, detectDarkMode, null);
        }
    }

    public /* synthetic */ SystemBarStyle(int i, int i6, int i10, k kVar, e eVar) {
        this(i, i6, i10, kVar);
    }

    public static final SystemBarStyle auto(@ColorInt int i, @ColorInt int i6) {
        return INSTANCE.auto(i, i6);
    }

    public static final SystemBarStyle dark(@ColorInt int i) {
        return INSTANCE.dark(i);
    }

    public static final SystemBarStyle light(@ColorInt int i, @ColorInt int i6) {
        return INSTANCE.light(i, i6);
    }

    /* renamed from: getDarkScrim$activity_release, reason: from getter */
    public final int getDarkScrim() {
        return this.darkScrim;
    }

    /* renamed from: getDetectDarkMode$activity_release, reason: from getter */
    public final k getDetectDarkMode() {
        return this.detectDarkMode;
    }

    /* renamed from: getNightMode$activity_release, reason: from getter */
    public final int getNightMode() {
        return this.nightMode;
    }

    public final int getScrim$activity_release(boolean isDark) {
        return isDark ? this.darkScrim : this.lightScrim;
    }

    public final int getScrimWithEnforcedContrast$activity_release(boolean isDark) {
        if (this.nightMode == 0) {
            return 0;
        }
        return isDark ? this.darkScrim : this.lightScrim;
    }

    private SystemBarStyle(int i, int i6, int i10, k kVar) {
        this.lightScrim = i;
        this.darkScrim = i6;
        this.nightMode = i10;
        this.detectDarkMode = kVar;
    }

    public static final SystemBarStyle auto(@ColorInt int i, @ColorInt int i6, k kVar) {
        return INSTANCE.auto(i, i6, kVar);
    }
}
