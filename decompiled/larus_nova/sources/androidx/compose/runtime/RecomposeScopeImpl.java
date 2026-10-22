package androidx.compose.runtime;

import androidx.collection.MutableObjectIntMap;
import androidx.collection.MutableScatterMap;
import androidx.collection.ScatterSet;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.chat.core.dependency.ForwardDependency$ForwardLocation;
import com.ss.android.ugc.effectmanager.effect.model.ComposerHelper;
import com.ttnet.org.chromium.net.NetError;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000 `2\u00020\u00012\u00020\u0002:\u0001`B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u00106\u001a\u0002052\u0006\u00107\u001a\u000204J\u0010\u00108\u001a\u0002092\b\u0010\u0018\u001a\u0004\u0018\u00010:J\u0006\u0010;\u001a\u000205J\u000e\u0010<\u001a\u0002052\u0006\u0010\u0003\u001a\u00020\u0004J\b\u0010=\u001a\u000205H\u0016J\"\u0010>\u001a\u0002052\u0018\u00102\u001a\u0014\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020503H\u0016J\u000e\u0010N\u001a\u0002052\u0006\u0010O\u001a\u00020\u000bJ\u0006\u0010P\u001a\u000205J\u000e\u0010Q\u001a\u00020\u00132\u0006\u0010R\u001a\u00020:J\u001c\u0010S\u001a\u0002052\n\u0010R\u001a\u0006\u0012\u0002\b\u00030D2\b\u0010\u0018\u001a\u0004\u0018\u00010:J\u0010\u0010U\u001a\u00020\u00132\b\u0010V\u001a\u0004\u0018\u00010:J*\u0010W\u001a\u00020\u0013*\u0006\u0012\u0002\b\u00030D2\u0018\u0010X\u001a\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030D\u0012\u0006\u0012\u0004\u0018\u00010:0CH\u0002J\u0006\u0010Y\u001a\u000205J\u001c\u0010Z\u001a\u0010\u0012\u0004\u0012\u00020\\\u0012\u0004\u0012\u000205\u0018\u00010[2\u0006\u0010O\u001a\u00020\u000bJ\u0011\u0010]\u001a\u00020\u00132\u0006\u0010^\u001a\u00020\u000bH\u0082\bJ\u0019\u0010_\u001a\u0002052\u0006\u0010^\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0013H\u0082\bR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0015R$\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00138F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u001cR$\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00138F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\u0015\"\u0004\b\u001f\u0010\u001cR$\u0010 \u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00138F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b!\u0010\u0015\"\u0004\b\"\u0010\u001cR$\u0010#\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00138F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b$\u0010\u0015\"\u0004\b%\u0010\u001cR$\u0010&\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00138F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b'\u0010\u0015\"\u0004\b(\u0010\u001cR$\u0010)\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00138F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b*\u0010\u0015\"\u0004\b+\u0010\u001cR$\u0010,\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00138F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b-\u0010\u0015\"\u0004\b.\u0010\u001cR$\u0010/\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00138F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b0\u0010\u0015\"\u0004\b1\u0010\u001cR\"\u00102\u001a\u0016\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u000205\u0018\u000103X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010@\u001a\n\u0012\u0004\u0012\u00020:\u0018\u00010AX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010B\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030D\u0012\u0006\u0012\u0004\u0018\u00010:\u0018\u00010CX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010E\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00138B@BX\u0082\u000e¢\u0006\f\u001a\u0004\bF\u0010\u0015\"\u0004\bG\u0010\u001cR$\u0010H\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00138F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bI\u0010\u0015\"\u0004\bJ\u0010\u001cR$\u0010K\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00138@@BX\u0080\u000e¢\u0006\f\u001a\u0004\bL\u0010\u0015\"\u0004\bM\u0010\u001cR\u0011\u0010T\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\bT\u0010\u0015¨\u0006a"}, d2 = {"Landroidx/compose/runtime/RecomposeScopeImpl;", "Landroidx/compose/runtime/ScopeUpdateScope;", "Landroidx/compose/runtime/RecomposeScope;", "owner", "Landroidx/compose/runtime/RecomposeScopeOwner;", "<init>", "(Landroidx/compose/runtime/RecomposeScopeOwner;)V", "getOwner$runtime", "()Landroidx/compose/runtime/RecomposeScopeOwner;", "setOwner$runtime", "flags", "", "anchor", "Landroidx/compose/runtime/Anchor;", "getAnchor", "()Landroidx/compose/runtime/Anchor;", "setAnchor", "(Landroidx/compose/runtime/Anchor;)V", "valid", "", "getValid", "()Z", "canRecompose", "getCanRecompose", "value", "used", "getUsed", "setUsed", "(Z)V", "reusing", "getReusing", "setReusing", "resetReusing", "getResetReusing", "setResetReusing", "paused", "getPaused", "setPaused", "resuming", "getResuming", "setResuming", "defaultsInScope", "getDefaultsInScope", "setDefaultsInScope", "defaultsInvalid", "getDefaultsInvalid", "setDefaultsInvalid", "requiresRecompose", "getRequiresRecompose", "setRequiresRecompose", "block", "Lkotlin/Function2;", "Landroidx/compose/runtime/Composer;", "", "compose", ComposerHelper.CONFIG_TYPE_COMPOSER, "invalidateForResult", "Landroidx/compose/runtime/InvalidationResult;", "", "release", "adoptedBy", "invalidate", "updateScope", "currentToken", "trackedInstances", "Landroidx/collection/MutableObjectIntMap;", "trackedDependencies", "Landroidx/collection/MutableScatterMap;", "Landroidx/compose/runtime/DerivedState;", "rereading", "getRereading", "setRereading", "forcedRecompose", "getForcedRecompose", "setForcedRecompose", "skipped", "getSkipped$runtime", "setSkipped", "start", "token", "scopeSkipped", "recordRead", "instance", "recordDerivedStateValue", "isConditional", "isInvalidFor", "instances", "checkDerivedStateChanged", "dependencies", "rereadTrackedInstances", "end", "Lkotlin/Function1;", "Landroidx/compose/runtime/Composition;", "getFlag", ForwardDependency$ForwardLocation.FLAG, "setFlag", "Companion", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RecomposeScopeImpl implements ScopeUpdateScope, RecomposeScope {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    private Anchor anchor;
    private Function2<? super Composer, ? super Integer, Unit> block;
    private int currentToken;
    private int flags;
    private RecomposeScopeOwner owner;
    private MutableScatterMap<DerivedState<?>, Object> trackedDependencies;
    private MutableObjectIntMap<Object> trackedInstances;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J+\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\fH\u0000¢\u0006\u0002\b\rJ#\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00102\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0000¢\u0006\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Landroidx/compose/runtime/RecomposeScopeImpl$Companion;", "", "<init>", "()V", "adoptAnchoredScopes", "", "slots", "Landroidx/compose/runtime/SlotWriter;", "anchors", "", "Landroidx/compose/runtime/Anchor;", "newOwner", "Landroidx/compose/runtime/RecomposeScopeOwner;", "adoptAnchoredScopes$runtime", "hasAnchoredRecomposeScopes", "", "Landroidx/compose/runtime/SlotTable;", "hasAnchoredRecomposeScopes$runtime", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final boolean hasAnchoredRecomposeScopes$runtime(SlotTable r100, List<Anchor> r101) {
            List<Anchor> r102 = r101;
            if ((!r102.isEmpty()) == false) goto L18;
            int r103 = r102.size();
            int r104 = 0;
        L5:
            if (r104 >= r103) goto L15;
            Anchor r105 = (Anchor) ListProtector.get(r101, r104);
            if (r100.ownsAnchor(r105) == true) goto L9;
        L11:
            boolean r106 = false;
        L12:
            if (r106 == true) goto L13;
            r104 = r104 + 1;
            goto L5
        L13:
            boolean r107 = true;
        L16:
            if (r107 == false) goto L18;
            return true;
        L9:
            if ((r100.slot$runtime(r100.anchorIndex(r105), 0) instanceof RecomposeScopeImpl) == false) goto L11;
            r106 = true;
            goto L12
        L15:
            r107 = false;
        L18:
            return false;
        }

        public final void adoptAnchoredScopes$runtime(SlotWriter r100, List<Anchor> r101, RecomposeScopeOwner r102) {
            List<Anchor> r103 = r101;
            if ((!r103.isEmpty()) == false) goto L13;
            int r104 = r103.size();
            int r105 = 0;
        L5:
            if (r105 >= r104) goto L17;
            Object r106 = r100.slot((Anchor) ListProtector.get(r101, r105), 0);
            if ((r106 instanceof RecomposeScopeImpl) == false) goto L9;
            RecomposeScopeImpl r107 = (RecomposeScopeImpl) r106;
        L10:
            if (r107 == null) goto L12;
            r107.adoptedBy(r102);
        L12:
            r105 = r105 + 1;
            goto L5
        L9:
            r107 = null;
            goto L10
        L17:
            return;
        }
    }

    static {
        Companion = new Companion(null);
        $stable = 8;
    }

    public static /* synthetic */ Unit a(RecomposeScopeImpl r100, int r101, MutableObjectIntMap r102, Composition r103) {
        return end$lambda$9$lambda$8(r100, r101, r102, r103);
    }

    private final boolean getRereading() {
        if ((this.flags & 32) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean getCanRecompose() {
        if (this.block == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean getDefaultsInScope() {
        if ((this.flags & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean getDefaultsInvalid() {
        if ((this.flags & 4) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean getForcedRecompose() {
        if ((this.flags & 64) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean getPaused() {
        if ((this.flags & 256) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean getRequiresRecompose() {
        if ((this.flags & 8) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean getResetReusing() {
        if ((this.flags & 1024) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean getResuming() {
        if ((this.flags & 512) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean getReusing() {
        if ((this.flags & 128) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean getSkipped$runtime() {
        if ((this.flags & 16) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean getUsed() {
        if ((this.flags & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean getValid() {
        if (this.owner == null) goto L11;
        Anchor r100 = this.anchor;
        if (r100 == null) goto L7;
        boolean r101 = r100.getValid();
    L8:
        if (r101 == false) goto L12;
        return true;
    L12:
        return false;
    L7:
        r101 = false;
        goto L8
    L11:
        return false;
    }

    @Override // androidx.compose.runtime.RecomposeScope
    public void invalidate() {
        RecomposeScopeOwner r100 = this.owner;
        if (r100 == null) goto L6;
        r100.invalidate(this, null);
        return;
    }

    public final boolean isConditional() {
        if (this.trackedDependencies == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final void release() {
        RecomposeScopeOwner r100 = this.owner;
        if (r100 == null) goto L5;
        r100.recomposeScopeReleased(this);
    L5:
        this.owner = null;
        this.trackedInstances = null;
        this.trackedDependencies = null;
        this.block = null;
    }

    public final void rereadTrackedInstances() {
        RecomposeScopeOwner r100 = this.owner;
        if (r100 == null) goto L28;
        MutableObjectIntMap<Object> r101 = this.trackedInstances;
        if (r101 == null) goto L36;
        setRereading(true);
        Object[] r102 = r101.keys;     // Catch: Throwable -> L25
        int[] r103 = r101.values;     // Catch: Throwable -> L25
        long[] r104 = r101.metadata;     // Catch: Throwable -> L25
        int r105 = r104.length - 2;     // Catch: Throwable -> L25
        if (r105 < 0) goto L24;
        int r106 = 0;
    L10:
        long r107 = r104[r106];     // Catch: Throwable -> L25
        if (((((~r107) << 7) & r107) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L22;
        int r110 = 8 - ((~(r106 - r105)) >>> 31);     // Catch: Throwable -> L25
        int r111 = 0;
    L13:
        if (r111 >= r110) goto L21;
        if ((255 & r107) >= 128) goto L17;
        boolean r112 = true;
    L18:
        if (r112 == false) goto L20;
        int r113 = (r106 << 3) + r111;     // Catch: Throwable -> L25
        Object r114 = r102[r113];     // Catch: Throwable -> L25
        int r115 = r103[r113];     // Catch: Throwable -> L25
        r100.recordReadOf(r114);     // Catch: Throwable -> L25
    L20:
        r107 = r107 >> 8;
        r111 = r111 + 1;
        goto L13
    L17:
        r112 = false;
        goto L18
    L21:
        if (r110 != 8) goto L24;
    L22:
        if (r106 == r105) goto L24;
        r106 = r106 + 1;
    L24:
        setRereading(false);
        return;
    L25:
        th = move-exception;
        setRereading(false);
        throw th;
    L36:
        return;
    }

    public final void scopeSkipped() {
        if (getReusing() == true) goto L6;
        setSkipped(true);
        return;
    }

    public final Anchor getAnchor() {
        return this.anchor;
    }

    public final RecomposeScopeOwner getOwner$runtime() {
        return this.owner;
    }

    public RecomposeScopeImpl(RecomposeScopeOwner r100) {
        this.owner = r100;
    }

    private final boolean getFlag(int r100) {
        if ((r100 & this.flags) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private final void setRereading(boolean r100) {
        int r101 = this.flags;
        if (r100 == false) goto L5;
        int r102 = r101 | 32;
    L6:
        this.flags = r102;
        return;
    L5:
        r102 = r101 & (-33);
        goto L6
    }

    private final void setSkipped(boolean r100) {
        int r101 = this.flags;
        if (r100 == false) goto L5;
        int r102 = r101 | 16;
    L6:
        this.flags = r102;
        return;
    L5:
        r102 = r101 & (-17);
        goto L6
    }

    public final void adoptedBy(RecomposeScopeOwner r100) {
        this.owner = r100;
    }

    public final void compose(Composer r100) {
        Function2<? super Composer, ? super Integer, Unit> r101 = this.block;
        if (r101 == null) goto L7;
        r101.invoke(r100, 1);
        return;
    L7:
        throw new IllegalStateException("Invalid restart scope".toString());
    }

    public final Function1<Composition, Unit> end(final int r210) {
        final MutableObjectIntMap<Object> r100 = this.trackedInstances;
        if (r100 != null) goto L5;
        return null;
    L5:
        if (getSkipped$runtime() == true) goto L38;
        Object[] r101 = r100.keys;
        int[] r102 = r100.values;
        long[] r103 = r100.metadata;
        int r104 = r103.length - 2;
        boolean r105 = false;
        if (r104 < 0) goto L28;
        int r106 = 0;
    L9:
        long r110 = r103[r106];
        if (((((~r110) << 7) & r110) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L26;
        int r111 = 8 - ((~(r106 - r104)) >>> 31);
        int r112 = 0;
    L12:
        if (r112 >= r111) goto L25;
        if ((255 & r110) >= 128) goto L16;
        boolean r113 = true;
    L17:
        if (r113 == false) goto L24;
        int r114 = (r106 << 3) + r112;
        Object r115 = r101[r114];
        if (r102[r114] == r210) goto L21;
        boolean r116 = true;
    L22:
        if (r116 == false) goto L24;
        r105 = true;
        goto L28
    L21:
        r116 = false;
    L24:
        r110 = r110 >> 8;
        r112 = r112 + 1;
        goto L12
    L16:
        r113 = false;
        goto L17
    L25:
        if (r111 != 8) goto L28;
    L26:
        if (r106 == r104) goto L28;
        r106 = r106 + 1;
    L28:
        if (r105 == true) goto L30;
        return null;
    L30:
        return new r(this, r210, r100);
    L38:
        return null;
    }

    public final InvalidationResult invalidateForResult(Object r100) {
        RecomposeScopeOwner r101 = this.owner;
        if (r101 == null) goto L7;
        InvalidationResult r102 = r101.invalidate(this, r100);
        if (r102 == null) goto L7;
        return r102;
    L7:
        return InvalidationResult.IGNORED;
    }

    public final boolean isInvalidFor(Object r110) {
        if (r110 != null) goto L5;
        return true;
    L5:
        MutableScatterMap<DerivedState<?>, Object> r100 = this.trackedDependencies;
        if (r100 != null) goto L9;
        return true;
    L9:
        if ((r110 instanceof DerivedState) == false) goto L12;
        return checkDerivedStateChanged((DerivedState) r110, r100);
    L12:
        if ((r110 instanceof ScatterSet) == false) goto L52;
        ScatterSet r101 = (ScatterSet) r110;
        if (r101.isNotEmpty() == false) goto L43;
        Object[] r102 = r101.elements;
        long[] r103 = r101.metadata;
        int r104 = r103.length - 2;
        if (r104 < 0) goto L40;
        int r105 = 0;
    L18:
        long r106 = r103[r105];
        if (((((~r106) << 7) & r106) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L38;
        int r111 = 8 - ((~(r105 - r104)) >>> 31);
        int r112 = 0;
    L21:
        if (r112 >= r111) goto L37;
        if ((255 & r106) >= 128) goto L25;
        boolean r113 = true;
    L26:
        if (r113 == false) goto L36;
        Object r114 = r102[(r105 << 3) + r112];
        if ((r114 instanceof DerivedState) == true) goto L30;
    L33:
        boolean r115 = true;
    L34:
        if (r115 == false) goto L36;
        boolean r107 = true;
    L41:
        if (r107 == false) goto L43;
        return true;
    L30:
        if (checkDerivedStateChanged((DerivedState) r114, r100) == true) goto L33;
        r115 = false;
    L36:
        r106 = r106 >> 8;
        r112 = r112 + 1;
        goto L21
    L25:
        r113 = false;
        goto L26
    L37:
        if (r111 != 8) goto L40;
    L38:
        if (r105 == r104) goto L40;
        r105 = r105 + 1;
    L40:
        r107 = false;
    L43:
        return false;
    L52:
        return true;
    }

    public final boolean recordRead(Object r100) {
        int r101 = 0;
        if (getRereading() == false) goto L5;
        return false;
    L5:
        MutableObjectIntMap<Object> r102 = this.trackedInstances;
        int r103 = 1;
        if (r102 != null) goto L9;
        r102 = new MutableObjectIntMap(r101, r103, null);
        this.trackedInstances = r102;
    L9:
        if (r102.put(r100, this.currentToken, -1) != this.currentToken) goto L11;
        return true;
    L11:
        return false;
    }

    public final void setAnchor(Anchor r100) {
        this.anchor = r100;
    }

    public final void setDefaultsInScope(boolean r100) {
        int r101 = this.flags;
        if (r100 == false) goto L5;
        int r102 = r101 | 2;
    L6:
        this.flags = r102;
        return;
    L5:
        r102 = r101 & (-3);
        goto L6
    }

    public final void setDefaultsInvalid(boolean r100) {
        int r101 = this.flags;
        if (r100 == false) goto L5;
        int r102 = r101 | 4;
    L6:
        this.flags = r102;
        return;
    L5:
        r102 = r101 & (-5);
        goto L6
    }

    public final void setForcedRecompose(boolean r100) {
        int r101 = this.flags;
        if (r100 == false) goto L5;
        int r102 = r101 | 64;
    L6:
        this.flags = r102;
        return;
    L5:
        r102 = r101 & (-65);
        goto L6
    }

    public final void setOwner$runtime(RecomposeScopeOwner r100) {
        this.owner = r100;
    }

    public final void setPaused(boolean r100) {
        int r101 = this.flags;
        if (r100 == false) goto L5;
        int r102 = r101 | 256;
    L6:
        this.flags = r102;
        return;
    L5:
        r102 = r101 & (-257);
        goto L6
    }

    public final void setRequiresRecompose(boolean r100) {
        int r101 = this.flags;
        if (r100 == false) goto L5;
        int r102 = r101 | 8;
    L6:
        this.flags = r102;
        return;
    L5:
        r102 = r101 & (-9);
        goto L6
    }

    public final void setResetReusing(boolean r100) {
        int r101 = this.flags;
        if (r100 == false) goto L5;
        int r102 = r101 | 1024;
    L6:
        this.flags = r102;
        return;
    L5:
        r102 = r101 & (-1025);
        goto L6
    }

    public final void setResuming(boolean r100) {
        int r101 = this.flags;
        if (r100 == false) goto L5;
        int r102 = r101 | 512;
    L6:
        this.flags = r102;
        return;
    L5:
        r102 = r101 & NetError.ERR_TTNET_FT_INVALID_STREAM;
        goto L6
    }

    public final void setReusing(boolean r100) {
        int r101 = this.flags;
        if (r100 == false) goto L5;
        int r102 = r101 | 128;
    L6:
        this.flags = r102;
        return;
    L5:
        r102 = r101 & (-129);
        goto L6
    }

    public final void setUsed(boolean r100) {
        int r101 = this.flags;
        if (r100 == false) goto L5;
        int r102 = r101 | 1;
    L6:
        this.flags = r102;
        return;
    L5:
        r102 = r101 & (-2);
        goto L6
    }

    public final void start(int r100) {
        this.currentToken = r100;
        setSkipped(false);
    }

    @Override // androidx.compose.runtime.ScopeUpdateScope
    public void updateScope(Function2<? super Composer, ? super Integer, Unit> r100) {
        this.block = r100;
    }

    private final boolean checkDerivedStateChanged(DerivedState<?> r100, MutableScatterMap<DerivedState<?>, Object> r101) {
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type androidx.compose.runtime.DerivedState<kotlin.Any?>");
        SnapshotMutationPolicy<?> r102 = r100.getPolicy();
        if (r102 != null) goto L6;
        r102 = SnapshotStateKt.structuralEqualityPolicy();
    L6:
        return !r102.equivalent(r100.getCurrentRecord().getCurrentValue(), r101.get(r100));
    }

    private final void setFlag(int r100, boolean r101) {
        int r102 = this.flags;
        if (r101 == false) goto L5;
        int r103 = r100 | r102;
    L6:
        this.flags = r103;
        return;
    L5:
        r103 = (~r100) & r102;
        goto L6
    }

    public final void recordDerivedStateValue(DerivedState<?> r100, Object r101) {
        MutableScatterMap<DerivedState<?>, Object> r102 = this.trackedDependencies;
        if (r102 != null) goto L5;
        int r103 = 0;
        r102 = new MutableScatterMap(r103, 1, null);
        this.trackedDependencies = r102;
    L5:
        r102.set(r100, r101);
    }

    private static final Unit end$lambda$9$lambda$8(RecomposeScopeImpl r110, int r210, MutableObjectIntMap r211, Composition r212) {
        if (r110.currentToken != r210) goto L37;
        if (Intrinsics.areEqual(r211, r110.trackedInstances) == false) goto L37;
        if ((r212 instanceof CompositionImpl) == false) goto L37;
        long[] r100 = r211.metadata;
        int r101 = r100.length - 2;
        if (r101 < 0) goto L37;
        int r102 = 0;
    L11:
        long r103 = r100[r102];
        if (((((~r103) << 7) & r103) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L34;
        int r111 = 8 - ((~(r102 - r101)) >>> 31);
        int r112 = 0;
    L14:
        if (r112 >= r111) goto L33;
        boolean r113 = true;
        if ((255 & r103) >= 128) goto L18;
        boolean r114 = true;
    L19:
        if (r114 == false) goto L32;
        int r115 = (r102 << 3) + r112;
        Object r116 = r211.keys[r115];
        if (r211.values[r115] != r210) goto L24;
        r113 = false;
    L24:
        if (r113 == false) goto L30;
        CompositionImpl r117 = (CompositionImpl) r212;
        r117.removeObservation$runtime(r116, r110);
        if ((r116 instanceof DerivedState) == false) goto L30;
        r117.removeDerivedStateObservation$runtime((DerivedState) r116);
        MutableScatterMap<DerivedState<?>, Object> r104 = r110.trackedDependencies;
        if (r104 == null) goto L30;
        r104.remove((DerivedState<?>) r116);
    L30:
        if (r113 == false) goto L32;
        r211.removeValueAt(r115);
    L32:
        r103 = r103 >> 8;
        r112 = r112 + 1;
        goto L14
    L18:
        r114 = false;
        goto L19
    L33:
        if (r111 != 8) goto L37;
    L34:
        if (r102 == r101) goto L37;
        r102 = r102 + 1;
    L37:
        return Unit.INSTANCE;
    }
}
