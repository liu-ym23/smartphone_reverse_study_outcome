package androidx.compose.runtime.internal;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScope;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;
import com.ss.android.ugc.effectmanager.effect.model.ComposerHelper;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.FunctionN;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u000e\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\rJ\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0003H\u0002J(\u0010\u001b\u001a\u0004\u0018\u00010\r2\u0016\u0010\u001c\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\r0\u001d\"\u0004\u0018\u00010\rH\u0096\u0002¢\u0006\u0002\u0010\u001eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Landroidx/compose/runtime/internal/ComposableLambdaNImpl;", "Landroidx/compose/runtime/internal/ComposableLambdaN;", "key", "", "tracked", "", "arity", "<init>", "(IZI)V", "getKey", "()I", "getArity", "_block", "", "scope", "Landroidx/compose/runtime/RecomposeScope;", ParamKeyConstants.WebViewConstants.REDIRECT_QUERY_SCOPE, "", "trackWrite", "", "trackRead", ComposerHelper.CONFIG_TYPE_COMPOSER, "Landroidx/compose/runtime/Composer;", "update", "block", "realParamCount", "params", AbsMethodDelegate.TAG_INVOKE, "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ComposableLambdaNImpl implements ComposableLambdaN {
    public static final int $stable = 0;
    private Object _block;
    private final int arity;
    private final int key;
    private RecomposeScope scope;
    private List<RecomposeScope> scopes;
    private final boolean tracked;

    public static /* synthetic */ Unit a(Object[] r100, int r101, ComposableLambdaNImpl r102, Composer r103, int r104) {
        return invoke$lambda$0(r100, r101, r102, r103, r104);
    }

    private final int realParamCount(int r100) {
        int r101 = (r100 - 1) - 1;
        int r102 = 1;
    L4:
        if ((r102 * 10) >= r101) goto L6;
        r101 = r101 - 1;
        r102 = r102 + 1;
        goto L4
    L6:
        return r101;
    }

    private final void trackWrite() {
        if (this.tracked == false) goto L15;
        RecomposeScope r100 = this.scope;
        if (r100 == null) goto L7;
        r100.invalidate();
        this.scope = null;
    L7:
        List<RecomposeScope> r101 = this.scopes;
        if (r101 == null) goto L16;
        int r102 = r101.size();
        int r103 = 0;
    L10:
        if (r103 >= r102) goto L12;
        ((RecomposeScope) ListProtector.get(r101, r103)).invalidate();
        r103 = r103 + 1;
        goto L10
    L12:
        r101.clear();
        return;
    L16:
        return;
    }

    @Override // kotlin.jvm.functions.FunctionN, kotlin.jvm.internal.FunctionBase
    public int getArity() {
        return this.arity;
    }

    public final int getKey() {
        return this.key;
    }

    private final void trackRead(Composer r100) {
        if (this.tracked == false) goto L23;
        RecomposeScope r101 = r100.getRecomposeScope();
        if (r101 == null) goto L24;
        r100.recordUsed(r101);
        if (ComposableLambdaKt.replacableWith(this.scope, r101) == false) goto L9;
        this.scope = r101;
        return;
    L9:
        List<RecomposeScope> r102 = this.scopes;
        if (r102 != null) goto L12;
        ArrayList r103 = new ArrayList();
        this.scopes = r103;
        r103.add(r101);
        return;
    L12:
        int r104 = r102.size();
        int r105 = 0;
    L13:
        if (r105 >= r104) goto L19;
        if (ComposableLambdaKt.replacableWith((RecomposeScope) ListProtector.get(r102, r105), r101) == true) goto L16;
        r105 = r105 + 1;
        goto L13
    L16:
        ListProtector.set(r102, r105, r101);
        return;
    L19:
        r102.add(r101);
        return;
    L24:
        return;
    }

    @Override // kotlin.jvm.functions.FunctionN
    public Object invoke(final Object... r100) {
        final int r101 = realParamCount(r100.length);
        Object r102 = r100[r101];
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type androidx.compose.runtime.Composer");
        Object[] r103 = ArraysKt.slice(r100, RangesKt.until(0, r100.length - 1)).toArray(new Object[0]);
        Object r104 = r100[r100.length - 1];
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type kotlin.Int");
        int r105 = ((Integer) r104).intValue();
        Composer r106 = ((Composer) r102).startRestartGroup(this.key);
        trackRead(r106);
        if (r106.changed(this) == false) goto L5;
        int r107 = ComposableLambdaKt.differentBits(r101);
    L6:
        int r108 = r105 | r107;
        Object r109 = this._block;
        Intrinsics.checkNotNull(r109, "null cannot be cast to non-null type kotlin.jvm.functions.FunctionN<*>");
        SpreadBuilder r110 = new SpreadBuilder(2);
        r110.addSpread(r103);
        r110.add(Integer.valueOf(r108));
        Object r111 = ((FunctionN) r109).invoke(r110.toArray(new Object[r110.size()]));
        ScopeUpdateScope r112 = r106.endRestartGroup();
        if (r112 == null) goto L9;
        r112.updateScope(new s(r100, r101, this));
    L9:
        return r111;
    L5:
        r107 = ComposableLambdaKt.sameBits(r101);
        goto L6
    }

    public final void update(Object r100) {
        if (Intrinsics.areEqual(r100, this._block) == false) goto L5;
        return;
    L5:
        if (this._block != null) goto L7;
        boolean r101 = true;
    L8:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type kotlin.jvm.functions.FunctionN<*>");
        this._block = (FunctionN) r100;
        if (r101 == true) goto L13;
        trackWrite();
        return;
    L13:
        return;
    L7:
        r101 = false;
        goto L8
    }

    public ComposableLambdaNImpl(int r100, boolean r101, int r102) {
        this.key = r100;
        this.tracked = r101;
        this.arity = r102;
    }

    private static final Unit invoke$lambda$0(Object[] r100, int r101, ComposableLambdaNImpl r102, Composer r103, int r110) {
        int r111 = 0;
        Object[] r104 = ArraysKt.slice(r100, RangesKt.until(0, r101)).toArray(new Object[0]);
        Object r105 = r100[r101 + 1];
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type kotlin.Int");
        int r106 = RecomposeScopeImplKt.updateChangedFlags(((Integer) r105).intValue());
        int r107 = (r100.length - r101) - 2;
        Object[] r108 = new Object[r107];
    L3:
        if (r111 >= r107) goto L5;
        Object r109 = r100[(r101 + 2) + r111];
        Intrinsics.checkNotNull(r109, "null cannot be cast to non-null type kotlin.Int");
        r108[r111] = Integer.valueOf(RecomposeScopeImplKt.updateChangedFlags(((Integer) r109).intValue()));
        r111 = r111 + 1;
        goto L3
    L5:
        SpreadBuilder r112 = new SpreadBuilder(4);
        r112.addSpread(r104);
        r112.add(r103);
        r112.add(Integer.valueOf(r106 | 1));
        r112.addSpread(r108);
        r102.invoke(r112.toArray(new Object[r112.size()]));
        return Unit.INSTANCE;
    }
}
