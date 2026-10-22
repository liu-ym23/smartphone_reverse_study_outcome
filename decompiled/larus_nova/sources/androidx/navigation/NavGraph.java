package androidx.navigation;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.collection.SparseArrayCompat;
import androidx.collection.SparseArrayKt;
import com.alipay.sdk.m.u.i;
import com.byted.cast.common.TeaEventTrack;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.larus.nova.R;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.jvm.internal.markers.KMutableIterator;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 >2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00010\u0002:\u0001>B\u0015\u0012\u000e\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00000\u0004¢\u0006\u0002\u0010\u0005J\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0000J\u000e\u0010 \u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u0001J\u001f\u0010\"\u001a\u00020\u001e2\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010#\"\u00020\u0001¢\u0006\u0002\u0010$J\u0016\u0010\"\u001a\u00020\u001e2\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010%J\u0006\u0010&\u001a\u00020\u001eJ\u0013\u0010'\u001a\u00020(2\b\u0010\u001f\u001a\u0004\u0018\u00010)H\u0096\u0002J\u0012\u0010*\u001a\u0004\u0018\u00010\u00012\b\b\u0001\u0010+\u001a\u00020\u0011J\u001c\u0010*\u001a\u0004\u0018\u00010\u00012\b\b\u0001\u0010+\u001a\u00020\u00112\u0006\u0010,\u001a\u00020(H\u0007J\u001a\u0010*\u001a\u0004\u0018\u00010\u00012\u0006\u0010-\u001a\u00020\u00072\u0006\u0010,\u001a\u00020(H\u0007J\u0012\u0010*\u001a\u0004\u0018\u00010\u00012\b\u0010-\u001a\u0004\u0018\u00010\u0007J\b\u0010.\u001a\u00020\u0011H\u0007J\b\u0010/\u001a\u00020\u0011H\u0016J\u000f\u00100\u001a\b\u0012\u0004\u0012\u00020\u000101H\u0086\u0002J\u0012\u00102\u001a\u0004\u0018\u0001032\u0006\u00104\u001a\u000205H\u0017J\u0018\u00106\u001a\u00020\u001e2\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:H\u0016J\u000e\u0010;\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u0001J\u000e\u0010<\u001a\u00020\u001e2\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010<\u001a\u00020\u001e2\u0006\u0010\u0018\u001a\u00020\u0007J\b\u0010=\u001a\u00020\u0007H\u0016R\u0014\u0010\u0006\u001a\u00020\u00078WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0019\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b8G¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u00078G¢\u0006\u0006\u001a\u0004\b\u000f\u0010\tR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u00118G@BX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R(\u0010\u0019\u001a\u0004\u0018\u00010\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0007@BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\t\"\u0004\b\u001b\u0010\u001c¨\u0006?"}, d2 = {"Landroidx/navigation/NavGraph;", "Landroidx/navigation/NavDestination;", "", "navGraphNavigator", "Landroidx/navigation/Navigator;", "(Landroidx/navigation/Navigator;)V", CommonConstant.KEY_DISPLAY_NAME, "", "getDisplayName", "()Ljava/lang/String;", "nodes", "Landroidx/collection/SparseArrayCompat;", "getNodes", "()Landroidx/collection/SparseArrayCompat;", "startDestDisplayName", "getStartDestDisplayName", "startDestId", "", "startDestIdName", "startDestinationId", "getStartDestinationId", "()I", "setStartDestinationId", "(I)V", "startDestRoute", "startDestinationRoute", "getStartDestinationRoute", "setStartDestinationRoute", "(Ljava/lang/String;)V", "addAll", "", "other", "addDestination", "node", "addDestinations", "", "([Landroidx/navigation/NavDestination;)V", "", "clear", "equals", "", "", "findNode", "resId", "searchParents", CloudControlInf.ROUTE, "getStartDestination", "hashCode", "iterator", "", "matchDeepLink", "Landroidx/navigation/NavDestination$DeepLinkMatch;", "navDeepLinkRequest", "Landroidx/navigation/NavDeepLinkRequest;", "onInflate", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "remove", "setStartDestination", "toString", "Companion", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class NavGraph extends NavDestination implements Iterable<NavDestination>, KMappedMarker {
    public static final Companion Companion = null;
    private final SparseArrayCompat<NavDestination> nodes;
    private int startDestId;
    private String startDestIdName;
    private String startDestinationRoute;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\f\u0010\u0003\u001a\u00020\u0004*\u00020\u0005H\u0007¨\u0006\u0006"}, d2 = {"Landroidx/navigation/NavGraph$Companion;", "", "()V", "findStartDestination", "Landroidx/navigation/NavDestination;", "Landroidx/navigation/NavGraph;", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        @JvmStatic
        public final NavDestination findStartDestination(NavGraph r100) {
            Intrinsics.checkNotNullParameter(r100, "<this>");
            return (NavDestination) SequencesKt.last(SequencesKt.generateSequence(r100.findNode(r100.getStartDestinationId()), NavGraph$Companion$findStartDestination$1.INSTANCE));
        }
    }

    /* JADX INFO: renamed from: androidx.navigation.NavGraph$iterator$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0010)\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u0096\u0002J\t\u0010\b\u001a\u00020\u0002H\u0096\u0002J\b\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"androidx/navigation/NavGraph$iterator$1", "", "Landroidx/navigation/NavDestination;", "index", "", "wentToNext", "", "hasNext", TeaEventTrack.ACTION_DRAMA_NEXT, "remove", "", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class AnonymousClass1 implements Iterator<NavDestination>, KMutableIterator {
        private int index;
        final /* synthetic */ NavGraph this$0;
        private boolean wentToNext;

        @Override // java.util.Iterator
        public boolean hasNext() {
            if ((this.index + 1) < this.this$0.getNodes().size()) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.wentToNext == false) goto L7;
            SparseArrayCompat<NavDestination> r100 = this.this$0.getNodes();
            r100.valueAt(this.index).setParent(null);
            r100.removeAt(this.index);
            this.index--;
            this.wentToNext = false;
            return;
        L7:
            throw new IllegalStateException("You must call next() before you can remove an element".toString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public NavDestination next() {
            if (hasNext() == false) goto L7;
            this.wentToNext = true;
            SparseArrayCompat<NavDestination> r100 = this.this$0.getNodes();
            int r101 = this.index + 1;
            this.index = r101;
            return r100.valueAt(r101);
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ NavDestination next() {
            return next();
        }

        public AnonymousClass1(NavGraph r100) {
            this.this$0 = r100;
            this.index = -1;
        }
    }

    static {
        Companion = new Companion(null);
    }

    @JvmStatic
    public static final NavDestination findStartDestination(NavGraph r100) {
        return Companion.findStartDestination(r100);
    }

    public final String getStartDestDisplayName() {
        if (this.startDestIdName != null) goto L8;
        String r100 = this.startDestinationRoute;
        if (r100 != null) goto L7;
        r100 = String.valueOf(this.startDestId);
    L7:
        this.startDestIdName = r100;
    L8:
        String r101 = this.startDestIdName;
        Intrinsics.checkNotNull(r101);
        return r101;
    }

    @Override // java.lang.Iterable
    public final Iterator<NavDestination> iterator() {
        return new AnonymousClass1(this);
    }

    @Override // androidx.navigation.NavDestination
    public String toString() {
        StringBuilder r100 = new StringBuilder();
        r100.append(super.toString());
        NavDestination r101 = findNode(this.startDestinationRoute);
        if (r101 != null) goto L5;
        r101 = findNode(getStartDestinationId());
    L5:
        r100.append(" startDestination=");
        if (r101 != null) goto L14;
        String r102 = this.startDestinationRoute;
        if (r102 == null) goto L10;
        r100.append(r102);
    L16:
        return r100.toString();
    L10:
        String r103 = this.startDestIdName;
        if (r103 == null) goto L13;
        r100.append(r103);
        goto L16
    L13:
        r100.append(Intrinsics.stringPlus("0x", Integer.toHexString(this.startDestId)));
        goto L16
    L14:
        r100.append("{");
        r100.append(r101.toString());
        r100.append(i.f25855d);
        goto L16
    }

    public final void clear() {
        Iterator<NavDestination> r100 = iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next();
        r100.remove();
        goto L4
    }

    @Override // androidx.navigation.NavDestination
    public String getDisplayName() {
        if (getId() != 0) goto L7;
        return "the root navigation";
    L7:
        return super.getDisplayName();
    }

    @Deprecated(message = "Use getStartDestinationId instead.", replaceWith = @ReplaceWith(expression = "startDestinationId", imports = {}))
    public final int getStartDestination() {
        return getStartDestinationId();
    }

    @Override // androidx.navigation.NavDestination
    public int hashCode() {
        int r100 = getStartDestinationId();
        SparseArrayCompat<NavDestination> r101 = this.nodes;
        int r102 = r101.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        int r104 = r101.keyAt(r103);
        r100 = (((r100 * 31) + r104) * 31) + r101.valueAt(r103).hashCode();
        r103 = r103 + 1;
        goto L3
    L5:
        return r100;
    }

    public final SparseArrayCompat<NavDestination> getNodes() {
        return this.nodes;
    }

    public final int getStartDestinationId() {
        return this.startDestId;
    }

    public final String getStartDestinationRoute() {
        return this.startDestinationRoute;
    }

    public NavGraph(Navigator<? extends NavGraph> r100) {
        Intrinsics.checkNotNullParameter(r100, "navGraphNavigator");
        super(r100);
        this.nodes = new SparseArrayCompat();
    }

    private final void setStartDestinationId(int r100) {
        if (r100 == getId()) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L13;
        if (this.startDestinationRoute == null) goto L10;
        setStartDestinationRoute(null);
    L10:
        this.startDestId = r100;
        this.startDestIdName = null;
        return;
    L13:
        throw new IllegalArgumentException(("Start destination " + r100 + " cannot use the same id as the graph " + this).toString());
    L5:
        r101 = false;
        goto L6
    }

    private final void setStartDestinationRoute(String r100) {
        if (r100 != null) goto L5;
        int r101 = 0;
    L9:
        this.startDestId = r101;
        this.startDestinationRoute = r100;
        return;
    L5:
        if ((!Intrinsics.areEqual(r100, getRoute())) == false) goto L14;
        if ((!StringsKt.isBlank(r100)) == false) goto L12;
        r101 = NavDestination.Companion.createRoute(r100).hashCode();
        goto L9
    L12:
        throw new IllegalArgumentException("Cannot have an empty start destination route".toString());
    L14:
        throw new IllegalArgumentException(("Start destination " + r100 + " cannot use the same route as the graph " + this).toString());
    }

    public final void addAll(NavGraph r100) {
        Intrinsics.checkNotNullParameter(r100, "other");
        Iterator<NavDestination> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        NavDestination r102 = r101.next();
        r101.remove();
        addDestination(r102);
        goto L4
    }

    public final void addDestination(NavDestination r100) {
        Intrinsics.checkNotNullParameter(r100, "node");
        int r101 = r100.getId();
        String r102 = r100.getRoute();
        boolean r103 = false;
        if (r101 != 0) goto L7;
        if (r102 != null) goto L7;
        boolean r104 = false;
    L8:
        if (r104 == false) goto L37;
        if (getRoute() == null) goto L17;
        if ((!Intrinsics.areEqual(r102, getRoute())) == true) goto L17;
        throw new IllegalArgumentException(("Destination " + r100 + " cannot have the same route as graph " + this).toString());
    L17:
        if (r101 == getId()) goto L19;
        boolean r105 = true;
    L20:
        if (r105 == false) goto L35;
        NavDestination r106 = this.nodes.get(r101);
        if (r106 != r100) goto L25;
        return;
    L25:
        if (r100.getParent() != null) goto L27;
        r103 = true;
    L27:
        if (r103 == false) goto L33;
        if (r106 == null) goto L30;
        r106.setParent(null);
    L30:
        r100.setParent(this);
        this.nodes.put(r100.getId(), r100);
        return;
    L33:
        throw new IllegalStateException("Destination already has a parent set. Call NavGraph.remove() to remove the previous parent.".toString());
    L35:
        throw new IllegalArgumentException(("Destination " + r100 + " cannot have the same id as graph " + this).toString());
    L19:
        r105 = false;
        goto L20
    L37:
        throw new IllegalArgumentException("Destinations must have an id or route. Call setId(), setRoute(), or include an android:id or app:route in your navigation XML.".toString());
    L7:
        r104 = true;
        goto L8
    }

    public final void addDestinations(Collection<? extends NavDestination> r100) {
        Intrinsics.checkNotNullParameter(r100, "nodes");
        Iterator<? extends NavDestination> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        NavDestination r102 = r101.next();
        if (r102 == null) goto L4;
        addDestination(r102);
        goto L4
    }

    @Override // androidx.navigation.NavDestination
    public boolean equals(Object r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if ((r100 instanceof NavGraph) == false) goto L27;
        List r101 = SequencesKt.toMutableList(SequencesKt.asSequence(SparseArrayKt.valueIterator(this.nodes)));
        NavGraph r102 = (NavGraph) r100;
        Iterator r103 = SparseArrayKt.valueIterator(r102.nodes);
    L9:
        if (r103.hasNext() == false) goto L12;
        r101.remove((NavDestination) r103.next());
        goto L9
    L12:
        if (super.equals(r100) == true) goto L14;
        return false;
    L14:
        if (this.nodes.size() == r102.nodes.size()) goto L16;
        return false;
    L16:
        if (getStartDestinationId() == r102.getStartDestinationId()) goto L18;
        return false;
    L18:
        if (r101.isEmpty() == false) goto L26;
        return true;
    L26:
        return false;
    L27:
        return false;
    }

    public final NavDestination findNode(String r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L13;
        return null;
    L13:
        return findNode(r100, true);
    L5:
        if (StringsKt.isBlank(r100) == true) goto L8;
        r101 = false;
        goto L9
    }

    @Override // androidx.navigation.NavDestination
    public NavDestination.DeepLinkMatch matchDeepLink(NavDeepLinkRequest r100) {
        Intrinsics.checkNotNullParameter(r100, "navDeepLinkRequest");
        NavDestination.DeepLinkMatch r101 = super.matchDeepLink(r100);
        ArrayList r102 = new ArrayList();
        Iterator<NavDestination> r103 = iterator();
    L4:
        if (r103.hasNext() == false) goto L10;
        NavDestination.DeepLinkMatch r104 = r103.next().matchDeepLink(r100);
        if (r104 == null) goto L4;
        r102.add(r104);
        goto L4
    L10:
        return (NavDestination.DeepLinkMatch) CollectionsKt.maxOrNull(CollectionsKt.listOfNotNull(new NavDestination.DeepLinkMatch[]{r101, (NavDestination.DeepLinkMatch) CollectionsKt.maxOrNull(r102)}));
    }

    public final void remove(NavDestination r100) {
        Intrinsics.checkNotNullParameter(r100, "node");
        int r101 = this.nodes.indexOfKey(r100.getId());
        if (r101 < 0) goto L6;
        this.nodes.valueAt(r101).setParent(null);
        this.nodes.removeAt(r101);
        return;
    }

    public final void setStartDestination(String r100) {
        Intrinsics.checkNotNullParameter(r100, "startDestRoute");
        setStartDestinationRoute(r100);
    }

    public final void addDestinations(NavDestination... r100) {
        Intrinsics.checkNotNullParameter(r100, "nodes");
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        NavDestination r103 = r100[r102];
        r102 = r102 + 1;
        addDestination(r103);
        goto L3
    }

    public final NavDestination findNode(int r100) {
        return findNode(r100, true);
    }

    public final void setStartDestination(int r100) {
        setStartDestinationId(r100);
    }

    public final NavDestination findNode(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, CloudControlInf.ROUTE);
        int r102 = NavDestination.Companion.createRoute(r100).hashCode();
        NavDestination r103 = this.nodes.get(r102);
        if (r103 != null) goto L10;
        if (r101 == true) goto L6;
    L8:
        return null;
    L6:
        if (getParent() == null) goto L8;
        NavGraph r104 = getParent();
        Intrinsics.checkNotNull(r104);
        return r104.findNode(r100);
    L10:
        return r103;
    }

    @Override // androidx.navigation.NavDestination
    public void onInflate(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super.onInflate(r100, r101);
        TypedArray r102 = r100.getResources().obtainAttributes(r101, new int[]{R.attr.startDestination});
        setStartDestinationId(r102.getResourceId(0, 0));
        this.startDestIdName = NavDestination.Companion.getDisplayName(r100, this.startDestId);
        Unit r103 = Unit.INSTANCE;
        r102.recycle();
    }

    public final NavDestination findNode(int r100, boolean r101) {
        NavDestination r102 = this.nodes.get(r100);
        if (r102 != null) goto L10;
        if (r101 == true) goto L6;
    L8:
        return null;
    L6:
        if (getParent() == null) goto L8;
        NavGraph r103 = getParent();
        Intrinsics.checkNotNull(r103);
        return r103.findNode(r100);
    L10:
        return r102;
    }
}
