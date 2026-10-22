package androidx.navigation;

import android.R;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.content.ContextCompat;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.regex.Matcher;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes17.dex */
@Navigator.Name("activity")
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0017\u0018\u0000 \u00162\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0016\u0017\u0018B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\n\u001a\u00020\u0002H\u0016J0\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u0013\u0010\u0003\u001a\u00020\u00048\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Landroidx/navigation/ActivityNavigator;", "Landroidx/navigation/Navigator;", "Landroidx/navigation/ActivityNavigator$Destination;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "hostActivity", "Landroid/app/Activity;", "createDestination", MusicAppletPage.ROUTE_MODE_NAVIGATION, "Landroidx/navigation/NavDestination;", com.bytedance.android.ec.core.event.a.KEY_DESTINATION, "args", "Landroid/os/Bundle;", "navOptions", "Landroidx/navigation/NavOptions;", "navigatorExtras", "Landroidx/navigation/Navigator$Extras;", "popBackStack", "", "Companion", "Destination", "Extras", "navigation-runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class ActivityNavigator extends Navigator<Destination> {
    public static final Companion Companion = null;
    private static final String EXTRA_NAV_CURRENT = "android-support-navigation:ActivityNavigator:current";
    private static final String EXTRA_NAV_SOURCE = "android-support-navigation:ActivityNavigator:source";
    private static final String EXTRA_POP_ENTER_ANIM = "android-support-navigation:ActivityNavigator:popEnterAnim";
    private static final String EXTRA_POP_EXIT_ANIM = "android-support-navigation:ActivityNavigator:popExitAnim";
    private static final String LOG_TAG = "ActivityNavigator";
    private final Context context;
    private final Activity hostActivity;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Landroidx/navigation/ActivityNavigator$Companion;", "", "()V", "EXTRA_NAV_CURRENT", "", "EXTRA_NAV_SOURCE", "EXTRA_POP_ENTER_ANIM", "EXTRA_POP_EXIT_ANIM", "LOG_TAG", "applyPopAnimationsToPendingTransition", "", "activity", "Landroid/app/Activity;", "navigation-runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        @JvmStatic
        public final void applyPopAnimationsToPendingTransition(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            Intent r101 = r100.getIntent();
            if (r101 != null) goto L5;
            return;
        L5:
            int r102 = r101.getIntExtra(ActivityNavigator.EXTRA_POP_ENTER_ANIM, -1);
            int r103 = r101.getIntExtra(ActivityNavigator.EXTRA_POP_EXIT_ANIM, -1);
            if (r102 != (-1)) goto L9;
            if (r103 != (-1)) goto L9;
            return;
        L9:
            if (r102 != (-1)) goto L12;
            r102 = 0;
        L12:
            if (r103 != (-1)) goto L15;
            r103 = 0;
        L15:
            r100.overridePendingTransition(r102, r103);
        }
    }

    @Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0017\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0015\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00000\u0006¢\u0006\u0002\u0010\u0007J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0096\u0002J\b\u0010!\u001a\u00020\"H\u0016J\u0018\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0017J\u0010\u0010)\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\tJ\u0010\u0010*\u001a\u00020\u00002\b\u0010+\u001a\u0004\u0018\u00010\rJ\u0010\u0010,\u001a\u00020\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011J\u0010\u0010-\u001a\u00020\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\tJ\u0010\u0010.\u001a\u00020\u00002\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017J\u0010\u0010/\u001a\u00020\u00002\b\u00100\u001a\u0004\u0018\u00010\tJ\b\u00101\u001a\u00020\u001eH\u0017J\b\u00102\u001a\u00020\tH\u0016R$\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\t8F@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR$\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\b\u001a\u0004\u0018\u00010\r8F@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R$\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\b\u001a\u0004\u0018\u00010\u00118F@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\"\u0010\u0015\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\t@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\fR\"\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\b\u001a\u0004\u0018\u00010\u0017@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR$\u0010\u001b\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\t8F@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\f¨\u00063"}, d2 = {"Landroidx/navigation/ActivityNavigator$Destination;", "Landroidx/navigation/NavDestination;", "navigatorProvider", "Landroidx/navigation/NavigatorProvider;", "(Landroidx/navigation/NavigatorProvider;)V", "activityNavigator", "Landroidx/navigation/Navigator;", "(Landroidx/navigation/Navigator;)V", "<set-?>", "", "action", "getAction", "()Ljava/lang/String;", "Landroid/content/ComponentName;", "component", "getComponent", "()Landroid/content/ComponentName;", "Landroid/net/Uri;", "data", "getData", "()Landroid/net/Uri;", "dataPattern", "getDataPattern", "Landroid/content/Intent;", "intent", "getIntent", "()Landroid/content/Intent;", "targetPackage", "getTargetPackage", "equals", "", "other", "", "hashCode", "", "onInflate", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "setAction", "setComponentName", "name", "setData", "setDataPattern", "setIntent", "setTargetPackage", "packageName", "supportsActions", "toString", "navigation-runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static class Destination extends NavDestination {
        private String action;

        /* JADX INFO: renamed from: component, reason: collision with root package name */
        private ComponentName f15581component;
        private Uri data;
        private String dataPattern;
        private Intent intent;
        private String targetPackage;

        @Override // androidx.navigation.NavDestination
        public boolean supportsActions() {
            return false;
        }

        public final String getAction() {
            Intent r100 = this.intent;
            if (r100 != null) goto L6;
            return null;
        L6:
            return r100.getAction();
        }

        public final ComponentName getComponent() {
            Intent r100 = this.intent;
            if (r100 != null) goto L6;
            return null;
        L6:
            return r100.getComponent();
        }

        public final Uri getData() {
            Intent r100 = this.intent;
            if (r100 != null) goto L6;
            return null;
        L6:
            return r100.getData();
        }

        public final String getTargetPackage() {
            Intent r100 = this.intent;
            if (r100 != null) goto L6;
            return null;
        L6:
            return r100.getPackage();
        }

        @Override // androidx.navigation.NavDestination
        public int hashCode() {
            int r100 = super.hashCode() * 31;
            Intent r101 = this.intent;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (r100 + r103) * 31;
            String r105 = this.dataPattern;
            if (r105 == null) goto L11;
            r102 = r105.hashCode();
        L11:
            return r104 + r102;
        L5:
            r103 = r101.filterHashCode();
            goto L6
        }

        @Override // androidx.navigation.NavDestination
        public String toString() {
            ComponentName r100 = getComponent();
            StringBuilder r101 = new StringBuilder();
            r101.append(super.toString());
            if (r100 == null) goto L5;
            r101.append(" class=");
            r101.append(r100.getClassName());
        L9:
            return r101.toString();
        L5:
            String r102 = getAction();
            if (r102 == null) goto L9;
            r101.append(" action=");
            r101.append(r102);
            goto L9
        }

        public final String getDataPattern() {
            return this.dataPattern;
        }

        public final Intent getIntent() {
            return this.intent;
        }

        public Destination(NavigatorProvider r100) {
            Intrinsics.checkNotNullParameter(r100, "navigatorProvider");
            this(r100.getNavigator(ActivityNavigator.class));
        }

        @Override // androidx.navigation.NavDestination
        public boolean equals(Object r100) {
            if (r100 != null) goto L5;
            return false;
        L5:
            if ((r100 instanceof Destination) == true) goto L8;
            return false;
        L8:
            if (super.equals(r100) == false) goto L26;
            Intent r101 = this.intent;
            if (r101 != null) goto L12;
            Boolean r102 = null;
        L14:
            if (r102 == null) goto L16;
            boolean r103 = r102.booleanValue();
        L20:
            if (r103 == true) goto L22;
            return false;
        L22:
            if (Intrinsics.areEqual(this.dataPattern, ((Destination) r100).dataPattern) == false) goto L28;
            return true;
        L28:
            return false;
        L16:
            if (((Destination) r100).intent != null) goto L18;
            r103 = true;
            goto L20
        L18:
            r103 = false;
            goto L20
        L12:
            r102 = Boolean.valueOf(r101.filterEquals(((Destination) r100).intent));
            goto L14
        L26:
            return false;
        }

        public final Destination setAction(String r100) {
            if (this.intent != null) goto L5;
            this.intent = new Intent();
        L5:
            Intent r101 = this.intent;
            Intrinsics.checkNotNull(r101);
            r101.setAction(r100);
            return this;
        }

        public final Destination setComponentName(ComponentName r100) {
            if (this.intent != null) goto L5;
            this.intent = new Intent();
        L5:
            Intent r101 = this.intent;
            Intrinsics.checkNotNull(r101);
            r101.setComponent(r100);
            return this;
        }

        public final Destination setData(Uri r100) {
            if (this.intent != null) goto L5;
            this.intent = new Intent();
        L5:
            Intent r101 = this.intent;
            Intrinsics.checkNotNull(r101);
            r101.setData(r100);
            return this;
        }

        public final Destination setDataPattern(String r100) {
            this.dataPattern = r100;
            return this;
        }

        public final Destination setIntent(Intent r100) {
            this.intent = r100;
            return this;
        }

        public final Destination setTargetPackage(String r100) {
            if (this.intent != null) goto L5;
            this.intent = new Intent();
        L5:
            Intent r101 = this.intent;
            Intrinsics.checkNotNull(r101);
            r101.setPackage(r100);
            return this;
        }

        public Destination(Navigator<? extends Destination> r100) {
            Intrinsics.checkNotNullParameter(r100, "activityNavigator");
            super(r100);
        }

        @Override // androidx.navigation.NavDestination
        public void onInflate(Context r100, AttributeSet r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "attrs");
            super.onInflate(r100, r101);
            TypedArray r102 = r100.getResources().obtainAttributes(r101, new int[]{R.attr.name, com.larus.nova.R.attr.action, com.larus.nova.R.attr.data, com.larus.nova.R.attr.dataPattern, com.larus.nova.R.attr.targetPackage});
            String r103 = r102.getString(4);
            if (r103 == null) goto L5;
            r103 = StringsKt.replace$default(r103, NavInflater.APPLICATION_ID_PLACEHOLDER, r100.getPackageName(), false, 4, null);
        L5:
            setTargetPackage(r103);
            String r104 = r102.getString(0);
            if (r104 != null) goto L8;
        L11:
            setAction(r102.getString(1));
            String r105 = r102.getString(2);
            if (r105 == null) goto L14;
            setData(UriProtector.parse(r105));
        L14:
            setDataPattern(r102.getString(3));
            r102.recycle();
            return;
        L8:
            if (r104.charAt(0) != '.') goto L10;
            r104 = Intrinsics.stringPlus(r100.getPackageName(), r104);
        L10:
            setComponentName(new ComponentName(r100, r104));
            goto L11
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u000bB\u0019\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Landroidx/navigation/ActivityNavigator$Extras;", "Landroidx/navigation/Navigator$Extras;", "flags", "", "activityOptions", "Landroidx/core/app/ActivityOptionsCompat;", "(ILandroidx/core/app/ActivityOptionsCompat;)V", "getActivityOptions", "()Landroidx/core/app/ActivityOptionsCompat;", "getFlags", "()I", "Builder", "navigation-runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Extras implements Navigator.Extras {
        private final ActivityOptionsCompat activityOptions;
        private final int flags;

        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Landroidx/navigation/ActivityNavigator$Extras$Builder;", "", "()V", "activityOptions", "Landroidx/core/app/ActivityOptionsCompat;", "flags", "", "addFlags", "build", "Landroidx/navigation/ActivityNavigator$Extras;", "setActivityOptions", "navigation-runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class Builder {
            private ActivityOptionsCompat activityOptions;
            private int flags;

            public Builder() {
            }

            public final Extras build() {
                return new Extras(this.flags, this.activityOptions);
            }

            public final Builder addFlags(int r100) {
                this.flags = r100 | this.flags;
                return this;
            }

            public final Builder setActivityOptions(ActivityOptionsCompat r100) {
                Intrinsics.checkNotNullParameter(r100, "activityOptions");
                this.activityOptions = r100;
                return this;
            }
        }

        public final ActivityOptionsCompat getActivityOptions() {
            return this.activityOptions;
        }

        public final int getFlags() {
            return this.flags;
        }

        public Extras(int r100, ActivityOptionsCompat r101) {
            this.flags = r100;
            this.activityOptions = r101;
        }
    }

    static {
        Companion = new Companion(null);
    }

    @JvmStatic
    public static final void applyPopAnimationsToPendingTransition(Activity r100) {
        Companion.applyPopAnimationsToPendingTransition(r100);
    }

    @Override // androidx.navigation.Navigator
    public Destination createDestination() {
        return new Destination(this);
    }

    @Override // androidx.navigation.Navigator
    public boolean popBackStack() {
        Activity r100 = this.hostActivity;
        if (r100 == null) goto L6;
        r100.finish();
        return true;
    L6:
        return false;
    }

    public final Context getContext() {
        return this.context;
    }

    @Override // androidx.navigation.Navigator
    public /* bridge */ /* synthetic */ NavDestination createDestination() {
        return createDestination();
    }

    public ActivityNavigator(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.context = r100;
        Iterator r101 = SequencesKt.generateSequence(r100, ActivityNavigator$hostActivity$1.INSTANCE).iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        Object r102 = r101.next();
        if ((((Context) r102) instanceof Activity) == false) goto L4;
    L9:
        this.hostActivity = (Activity) r102;
        return;
    L8:
        r102 = null;
        goto L9
    }

    public NavDestination navigate(Destination r100, Bundle r110, NavOptions r111, Navigator.Extras r112) {
        Intrinsics.checkNotNullParameter(r100, com.bytedance.android.ec.core.event.a.KEY_DESTINATION);
        if (r100.getIntent() == null) goto L74;
        Intent r101 = new Intent(r100.getIntent());
        if (r110 == null) goto L23;
        r101.putExtras(r110);
        String r102 = r100.getDataPattern();
        if (r102 != null) goto L9;
    L12:
        boolean r103 = true;
    L13:
        if (r103 == true) goto L23;
        StringBuffer r104 = new StringBuffer();
        Matcher r105 = PatternProtector.compile("\\{(.+?)\\}").matcher(r102);
    L16:
        if (r105.find() == false) goto L22;
        String r106 = r105.group(1);
        if (r110.containsKey(r106) == false) goto L21;
        r105.appendReplacement(r104, "");
        r104.append(Uri.encode(String.valueOf(r110.get(r106))));
        goto L16
    L21:
        throw new IllegalArgumentException("Could not find " + r106 + " in " + r110 + " to fill data pattern " + r102);
    L22:
        r105.appendTail(r104);
        r101.setData(UriProtector.parse(r104.toString()));
        goto L23
    L9:
        if (r102.length() == 0) goto L12;
        r103 = false;
    L23:
        boolean r113 = r112 instanceof Extras;
        if (r113 == false) goto L27;
        r101.addFlags(((Extras) r112).getFlags());
    L27:
        if (this.hostActivity != null) goto L29;
        r101.addFlags(268435456);
    L29:
        if (r111 != null) goto L31;
    L33:
        Activity r107 = this.hostActivity;
        if (r107 == null) goto L40;
        Intent r108 = r107.getIntent();
        if (r108 == null) goto L40;
        int r109 = r108.getIntExtra(EXTRA_NAV_CURRENT, 0);
        if (r109 == 0) goto L40;
        r101.putExtra(EXTRA_NAV_SOURCE, r109);
    L40:
        r101.putExtra(EXTRA_NAV_CURRENT, r100.getId());
        Resources r114 = this.context.getResources();
        if (r111 == null) goto L51;
        int r115 = r111.getPopEnterAnim();
        int r116 = r111.getPopExitAnim();
        if (r115 > 0) goto L45;
    L46:
        if (r116 > 0) goto L48;
    L50:
        r101.putExtra(EXTRA_POP_ENTER_ANIM, r115);
        r101.putExtra(EXTRA_POP_EXIT_ANIM, r116);
        goto L51
    L48:
        if (Intrinsics.areEqual(r114.getResourceTypeName(r116), "animator") == false) goto L50;
    L49:
        r114.getResourceName(r115);
        r114.getResourceName(r116);
        r100.toString();
        goto L51
    L45:
        if (Intrinsics.areEqual(r114.getResourceTypeName(r115), "animator") == true) goto L49;
    L51:
        if (r113 == false) goto L56;
        ActivityOptionsCompat r117 = ((Extras) r112).getActivityOptions();
        if (r117 == null) goto L55;
        ContextCompat.startActivity(this.context, r101, r117.toBundle());
    L57:
        if (r111 != null) goto L59;
        return null;
    L59:
        if (this.hostActivity == null) goto L78;
        int r118 = r111.getEnterAnim();
        int r119 = r111.getExitAnim();
        if (r118 > 0) goto L63;
    L64:
        if (r119 > 0) goto L66;
    L68:
        if (r118 >= 0) goto L70;
        if (r119 >= 0) goto L70;
        return null;
    L70:
        this.hostActivity.overridePendingTransition(RangesKt.coerceAtLeast(r118, 0), RangesKt.coerceAtLeast(r119, 0));
        return null;
    L66:
        if (Intrinsics.areEqual(r114.getResourceTypeName(r119), "animator") == false) goto L68;
    L67:
        r114.getResourceName(r118);
        r114.getResourceName(r119);
        r100.toString();
        return null;
    L63:
        if (Intrinsics.areEqual(r114.getResourceTypeName(r118), "animator") == true) goto L67;
    L78:
        return null;
    L55:
        this.context.startActivity(r101);
        goto L57
    L56:
        this.context.startActivity(r101);
        goto L57
    L31:
        if (r111.shouldLaunchSingleTop() == false) goto L33;
        r101.addFlags(536870912);
        goto L33
    L74:
        throw new IllegalStateException(("Destination " + r100.getId() + " does not have an Intent set.").toString());
    }

    @Override // androidx.navigation.Navigator
    public /* bridge */ /* synthetic */ NavDestination navigate(NavDestination r100, Bundle r101, NavOptions r102, Navigator.Extras r103) {
        return navigate((Destination) r100, r101, r102, r103);
    }
}
