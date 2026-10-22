package androidx.compose.runtime.internal;

import C7.r;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScope;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Stable;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import g1.AbstractC1451a;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Stable
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J*\u0010\u0019\u001a\u0004\u0018\u00010\u00132\u0016\u0010\u0018\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00130\u0017\"\u0004\u0018\u00010\u0013H\u0096\u0002¢\u0006\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001eR\u001a\u0010\u0006\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u001b\u001a\u0004\b\u001f\u0010\u001dR\u0018\u0010 \u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010#\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u001e\u0010&\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'¨\u0006("}, d2 = {"Landroidx/compose/runtime/internal/ComposableLambdaNImpl;", "Landroidx/compose/runtime/internal/ComposableLambdaN;", "", "key", "", "tracked", "arity", AppAgent.CONSTRUCT, "(IZI)V", "LC7/r;", "trackWrite", "()V", "Landroidx/compose/runtime/Composer;", "composer", "trackRead", "(Landroidx/compose/runtime/Composer;)V", "params", "realParamCount", "(I)I", "", "block", "update", "(Ljava/lang/Object;)V", "", "args", "invoke", "([Ljava/lang/Object;)Ljava/lang/Object;", "I", "getKey", "()I", "Z", "getArity", "_block", "Ljava/lang/Object;", "Landroidx/compose/runtime/RecomposeScope;", "scope", "Landroidx/compose/runtime/RecomposeScope;", "", "scopes", "Ljava/util/List;", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ComposableLambdaNImpl implements ComposableLambdaN {
    public static final int $stable = 0;
    private Object _block;
    private final int arity;
    private final int key;
    private RecomposeScope scope;
    private List<RecomposeScope> scopes;
    private final boolean tracked;

    public ComposableLambdaNImpl(int i, boolean z10, int i6) {
        this.key = i;
        this.tracked = z10;
        this.arity = i6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r invoke$lambda$0(Object[] objArr, int i, ComposableLambdaNImpl composableLambdaNImpl, Composer composer, int i6) {
        Object[] array = D7.q.B0(objArr, AbstractC1451a.X(0, i)).toArray(new Object[0]);
        Object obj = objArr[i + 1];
        kotlin.jvm.internal.k.d(obj, "null cannot be cast to non-null type kotlin.Int");
        int iUpdateChangedFlags = RecomposeScopeImplKt.updateChangedFlags(((Integer) obj).intValue());
        int length = (objArr.length - i) - 2;
        Object[] objArr2 = new Object[length];
        for (int i10 = 0; i10 < length; i10++) {
            Object obj2 = objArr[i + 2 + i10];
            kotlin.jvm.internal.k.d(obj2, "null cannot be cast to non-null type kotlin.Int");
            objArr2[i10] = Integer.valueOf(RecomposeScopeImplKt.updateChangedFlags(((Integer) obj2).intValue()));
        }
        Z0.a aVar = new Z0.a(4);
        ArrayList arrayList = (ArrayList) aVar.f1582a;
        aVar.E(array);
        aVar.D(composer);
        aVar.D(Integer.valueOf(iUpdateChangedFlags | 1));
        aVar.E(objArr2);
        composableLambdaNImpl.invoke(arrayList.toArray(new Object[arrayList.size()]));
        return r.f317a;
    }

    private final int realParamCount(int params) {
        int i = params - 2;
        for (int i6 = 1; i6 * 10 < i; i6++) {
            i--;
        }
        return i;
    }

    private final void trackRead(Composer composer) {
        RecomposeScope recomposeScope;
        if (!this.tracked || (recomposeScope = composer.getRecomposeScope()) == null) {
            return;
        }
        composer.recordUsed(recomposeScope);
        if (ComposableLambdaKt.replacableWith(this.scope, recomposeScope)) {
            this.scope = recomposeScope;
            return;
        }
        List<RecomposeScope> list = this.scopes;
        if (list == null) {
            ArrayList arrayList = new ArrayList();
            this.scopes = arrayList;
            arrayList.add(recomposeScope);
            return;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (ComposableLambdaKt.replacableWith(list.get(i), recomposeScope)) {
                list.set(i, recomposeScope);
                return;
            }
        }
        list.add(recomposeScope);
    }

    private final void trackWrite() {
        if (this.tracked) {
            RecomposeScope recomposeScope = this.scope;
            if (recomposeScope != null) {
                recomposeScope.invalidate();
                this.scope = null;
            }
            List<RecomposeScope> list = this.scopes;
            if (list != null) {
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    list.get(i).invalidate();
                }
                list.clear();
            }
        }
    }

    @Override // androidx.compose.runtime.internal.ComposableLambdaN, kotlin.jvm.internal.h
    public int getArity() {
        return this.arity;
    }

    public final int getKey() {
        return this.key;
    }

    @Override // androidx.compose.runtime.internal.ComposableLambdaN
    public Object invoke(Object... args) {
        int iRealParamCount = realParamCount(args.length);
        Object obj = args[iRealParamCount];
        kotlin.jvm.internal.k.d(obj, "null cannot be cast to non-null type androidx.compose.runtime.Composer");
        Object[] array = D7.q.B0(args, AbstractC1451a.X(0, args.length - 1)).toArray(new Object[0]);
        Object obj2 = args[args.length - 1];
        kotlin.jvm.internal.k.d(obj2, "null cannot be cast to non-null type kotlin.Int");
        int iIntValue = ((Integer) obj2).intValue();
        Composer composerStartRestartGroup = ((Composer) obj).startRestartGroup(this.key);
        trackRead(composerStartRestartGroup);
        int iDifferentBits = iIntValue | (composerStartRestartGroup.changed(this) ? ComposableLambdaKt.differentBits(iRealParamCount) : ComposableLambdaKt.sameBits(iRealParamCount));
        Object obj3 = this._block;
        kotlin.jvm.internal.k.d(obj3, "null cannot be cast to non-null type kotlin.jvm.functions.FunctionN<*>");
        Z0.a aVar = new Z0.a(2);
        ArrayList arrayList = (ArrayList) aVar.f1582a;
        aVar.E(array);
        aVar.D(Integer.valueOf(iDifferentBits));
        Object objInvoke = ((ComposableLambdaN) obj3).invoke(arrayList.toArray(new Object[arrayList.size()]));
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new androidx.compose.runtime.e(args, iRealParamCount, this));
        }
        return objInvoke;
    }

    public final void update(Object block) {
        if (kotlin.jvm.internal.k.b(block, this._block)) {
            return;
        }
        boolean z10 = this._block == null;
        kotlin.jvm.internal.k.d(block, "null cannot be cast to non-null type kotlin.jvm.functions.FunctionN<*>");
        this._block = (ComposableLambdaN) block;
        if (z10) {
            return;
        }
        trackWrite();
    }
}
