package app.visly.stretch;

import com.baidu.platform.comapi.map.MapBundleKey;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import u.b;
import u.c;
import u.e;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0017\u0018\u0000 A2\u00020\u0001:\u0001BB)\b\u0016\u0012\u0006\u00100\u001a\u00020-\u0012\u0006\u00104\u001a\u00020-\u0012\u0006\u0010\u0004\u001a\u00020%\u0012\u0006\u0010\t\u001a\u00020;¢\u0006\u0004\b=\u0010>B/\b\u0016\u0012\u0006\u00100\u001a\u00020-\u0012\u0006\u00104\u001a\u00020-\u0012\u0006\u0010\u0004\u001a\u00020%\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00000\"¢\u0006\u0004\b=\u0010?B!\b\u0016\u0012\u0006\u00100\u001a\u00020-\u0012\u0006\u00104\u001a\u00020-\u0012\u0006\u0010\u0004\u001a\u00020%¢\u0006\u0004\b=\u0010@J!\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0082 J!\u0010\n\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0082 J\u0019\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002H\u0082 J!\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0082 J!\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0082 J!\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0002H\u0082 J)\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u0002H\u0082 J!\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0002H\u0082 J!\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0082 J!\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0002H\u0082 J\u0019\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002H\u0082 J\u0019\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002H\u0082 J)\u0010 \u001a\u00020\u001f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001cH\u0082 J\u0006\u0010!\u001a\u00020\fJ\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00000\"J\u000e\u0010$\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0000J\u0006\u0010&\u001a\u00020%J\u000e\u0010'\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020%J\u0006\u0010(\u001a\u00020\fJ\u0016\u0010,\u001a\u00020+2\u000e\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0)J\b\u0010.\u001a\u00020-H\u0016J\u0006\u0010/\u001a\u00020\fR\u0017\u00100\u001a\u00020-8\u0006¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\u0017\u00104\u001a\u00020-8\u0006¢\u0006\f\n\u0004\b4\u00101\u001a\u0004\b5\u00103R\u0016\u00106\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010\u0004\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0004\u00108R\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u0000098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010:R\u0018\u0010\t\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010<¨\u0006C"}, d2 = {"Lapp/visly/stretch/Node;", "", "", "stretch", "style", "", "children", "nConstruct", "Lapp/visly/stretch/MeasureFuncImpl;", "measure", "nConstructLeaf", "ptr", "", "nFree", "nSetMeasure", "nSetChildren", MapBundleKey.OfflineMapKey.OFFLINE_CHILD, "nAddChild", "", "index", "nReplaceChildAtIndex", "nRemoveChild", "nRemoveChildAtIndex", "args", "", "nSetStyle", "nIsDirty", "nMarkDirty", "", "width", "height", "", "nComputeLayout", "free", "", "getChildren", "addChild", "Lapp/visly/stretch/Style;", "getStyle", "setStyle", "markDirty", "Lu/e;", "size", "Lu/b;", "computeLayout", "", "toString", "markDirtyAll", "id", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "idPath", "getIdPath", "rustptr", "J", "Lapp/visly/stretch/Style;", "", "Ljava/util/List;", "Lu/c;", "Lu/c;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lapp/visly/stretch/Style;Lu/c;)V", "(Ljava/lang/String;Ljava/lang/String;Lapp/visly/stretch/Style;Ljava/util/List;)V", "(Ljava/lang/String;Ljava/lang/String;Lapp/visly/stretch/Style;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "GaiaX"}, k = 1, mv = {1, 7, 1})
public class Node {
    public static final a Companion = null;
    private List<Node> children;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final String f15873id;
    private final String idPath;
    private c measure;
    private long rustptr;
    private Style style;

    public static final class a {
        public a() {
        }
    }

    private final native void nAddChild(long r100, long r101, long r102);

    private final native float[] nComputeLayout(long r100, long r101, float r102, float r103);

    private final native long nConstruct(long r100, long r101, long[] r102);

    private final native long nConstructLeaf(long r100, long r101, MeasureFuncImpl r102);

    private final native void nFree(long r100, long r101);

    private final native boolean nIsDirty(long r100, long r101);

    private final native void nMarkDirty(long r100, long r101);

    private final native long nRemoveChild(long r100, long r101, long r102);

    private final native long nRemoveChildAtIndex(long r100, long r101, int r102);

    private final native long nReplaceChildAtIndex(long r100, long r101, int r102, long r103);

    private final native void nSetChildren(long r100, long r101, long[] r102);

    private final native void nSetMeasure(long r100, long r101, MeasureFuncImpl r102);

    private final native boolean nSetStyle(long r100, long r101, long r102);

    static {
        Companion = new a();
        Stretch.Companion.getClass();
        Stretch.a.b();
    }

    public final void free() {
        monitor-enter(Stretch.class);
        this.style.free();     // Catch: Throwable -> L10
        if (this.rustptr == (-1)) goto L7;
        Stretch.Companion.getClass();     // Catch: Throwable -> L10
        nFree(Stretch.access$getPtr$cp(), this.rustptr);     // Catch: Throwable -> L10
        this.rustptr = -1;     // Catch: Throwable -> L10
    L7:
        Unit r100 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(Stretch.class);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public final void markDirty() {
        monitor-enter(Stretch.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.rustptr == (-1)) goto L7;
        Stretch.Companion.getClass();     // Catch: Throwable -> L10
        nMarkDirty(Stretch.access$getPtr$cp(), this.rustptr);     // Catch: Throwable -> L10
    L7:
        Unit r100 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(Stretch.class);
    }

    public String toString() {
        return "Node(id='" + this.f15873id + "', style=" + this.style + ", children=" + this.children + ')';
    }

    public final void markDirtyAll() {
        markDirty();
        Iterator<T> r100 = this.children.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((Node) r100.next()).markDirtyAll();
        goto L4
    }

    public final List<Node> getChildren() {
        return this.children;
    }

    public final String getId() {
        return this.f15873id;
    }

    public final String getIdPath() {
        return this.idPath;
    }

    public final Style getStyle() {
        return this.style;
    }

    public final void addChild(Node r110) {
        Intrinsics.checkNotNullParameter(r110, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        monitor-enter(Stretch.class);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.rustptr != (-1)) goto L7;
    L9:
        Unit r111 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(Stretch.class);
        return;
    L7:
        if (r110.rustptr == (-1)) goto L9;
        Stretch.Companion.getClass();     // Catch: Throwable -> L12
        nAddChild(Stretch.access$getPtr$cp(), this.rustptr, r110.rustptr);     // Catch: Throwable -> L12
        this.children.add(r110);     // Catch: Throwable -> L12
        goto L9
    }

    public final b computeLayout(e<Float> r110) {
        Intrinsics.checkNotNullParameter(r110, "size");
        monitor-enter(Stretch.class);
    L19:
        th = move-exception;
        throw th;
    L5:
        if (this.rustptr == (-1)) goto L18;
        Stretch.Companion.getClass();     // Catch: Throwable -> L19
        long r100 = Stretch.access$getPtr$cp();     // Catch: Throwable -> L19
        long r101 = this.rustptr;     // Catch: Throwable -> L19
        Float r102 = r110.f548094a;     // Catch: Throwable -> L19
        if (r102 == null) goto L9;
        float r103 = r102.floatValue() - 0.01f;     // Catch: Throwable -> L19
    L10:
        Float r111 = r110.f548095b;     // Catch: Throwable -> L19
        if (r111 == null) goto L13;
        float r104 = r111.floatValue() - 0.01f;     // Catch: Throwable -> L19
    L14:
        float[] r112 = nComputeLayout(r100, r101, r103, r104);     // Catch: Throwable -> L19
        int r105 = b.f548082h;     // Catch: Throwable -> L19
        b r113 = (b) b.a.a(r112, 0).getSecond();     // Catch: Throwable -> L19
        monitor-exit(Stretch.class);
        return r113;
    L13:
        r104 = Float.NaN;
        goto L14
    L9:
        r103 = Float.NaN;
        goto L10
    L18:
        throw new IllegalArgumentException("rustptr is null");     // Catch: Throwable -> L19
    }

    public final void setStyle(Style r110) {
        Intrinsics.checkNotNullParameter(r110, "style");
        monitor-enter(Stretch.class);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.rustptr != (-1)) goto L7;
    L9:
        Unit r111 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(Stretch.class);
        return;
    L7:
        if (r110.getRustptr() == (-1)) goto L9;
        Stretch.Companion.getClass();     // Catch: Throwable -> L12
        nSetStyle(Stretch.access$getPtr$cp(), this.rustptr, r110.getRustptr());     // Catch: Throwable -> L12
        this.style = r110;     // Catch: Throwable -> L12
        goto L9
    }

    public Node(String r110, String r111, Style r112) {
        Intrinsics.checkNotNullParameter(r110, "id");
        Intrinsics.checkNotNullParameter(r111, "idPath");
        Intrinsics.checkNotNullParameter(r112, "style");
        monitor-enter(Stretch.class);
        ArrayList r100 = new ArrayList();     // Catch: Throwable -> L10
        this.f15873id = r110;     // Catch: Throwable -> L10
        this.idPath = r111;     // Catch: Throwable -> L10
        Stretch.Companion.getClass();     // Catch: Throwable -> L10
        long r101 = Stretch.access$getPtr$cp();     // Catch: Throwable -> L10
        long r102 = r112.getRustptr();     // Catch: Throwable -> L10
        int r113 = r100.size();     // Catch: Throwable -> L10
        long[] r103 = new long[r113];     // Catch: Throwable -> L10
        int r114 = 0;
    L5:
        if (r114 >= r113) goto L7;
        r103[r114] = ((Node) r100.get(r114)).rustptr;     // Catch: Throwable -> L10
        r114 = r114 + 1;     // Catch: Throwable -> L10
        goto L5
    L7:
        this.rustptr = nConstruct(r101, r102, r103);     // Catch: Throwable -> L10
        this.style = r112;     // Catch: Throwable -> L10
        this.children = CollectionsKt.toMutableList(r100);     // Catch: Throwable -> L10
        Unit r115 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(Stretch.class);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public Node(String r110, String r111, Style r112, List<? extends Node> r113) {
        Intrinsics.checkNotNullParameter(r110, "id");
        Intrinsics.checkNotNullParameter(r111, "idPath");
        Intrinsics.checkNotNullParameter(r112, "style");
        Intrinsics.checkNotNullParameter(r113, "children");
        monitor-enter(Stretch.class);
        this.f15873id = r110;     // Catch: Throwable -> L10
        this.idPath = r111;     // Catch: Throwable -> L10
        Stretch.Companion.getClass();     // Catch: Throwable -> L10
        long r100 = Stretch.access$getPtr$cp();     // Catch: Throwable -> L10
        long r101 = r112.getRustptr();     // Catch: Throwable -> L10
        int r114 = r113.size();     // Catch: Throwable -> L10
        long[] r102 = new long[r114];     // Catch: Throwable -> L10
        int r115 = 0;
    L5:
        if (r115 >= r114) goto L7;
        r102[r115] = r113.get(r115).rustptr;     // Catch: Throwable -> L10
        r115 = r115 + 1;     // Catch: Throwable -> L10
        goto L5
    L7:
        this.rustptr = nConstruct(r100, r101, r102);     // Catch: Throwable -> L10
        this.style = r112;     // Catch: Throwable -> L10
        this.children = CollectionsKt.toMutableList(r113);     // Catch: Throwable -> L10
        Unit r116 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(Stretch.class);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public Node(String r100, String r101, Style r110, c r111) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "idPath");
        Intrinsics.checkNotNullParameter(r110, "style");
        Intrinsics.checkNotNullParameter(r111, "measure");
        monitor-enter(Stretch.class);
        this.f15873id = r100;     // Catch: Throwable -> L7
        this.idPath = r101;     // Catch: Throwable -> L7
        Stretch.Companion.getClass();     // Catch: Throwable -> L7
        this.rustptr = nConstructLeaf(Stretch.access$getPtr$cp(), r110.getRustptr(), new MeasureFuncImpl(new WeakReference(r111)));     // Catch: Throwable -> L7
        this.style = r110;     // Catch: Throwable -> L7
        this.children = new ArrayList();     // Catch: Throwable -> L7
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(Stretch.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
