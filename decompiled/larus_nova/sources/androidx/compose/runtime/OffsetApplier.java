package androidx.compose.runtime;

import com.bytedance.android.livesdk.chatroom.model.interact.e1;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000fJ\b\u0010\u0010\u001a\u00020\rH\u0016J\u001d\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0014J\u001d\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0014J\u0018\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005H\u0016J \u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005H\u0016J\b\u0010\u001b\u001a\u00020\rH\u0016J3\u0010\u001c\u001a\u00020\r2\u001f\u0010\u001d\u001a\u001b\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u001f\u0012\u0004\u0012\u00020\r0\u001e¢\u0006\u0002\b 2\b\u0010!\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010\"\u001a\u00020\rH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00028\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006#"}, d2 = {"Landroidx/compose/runtime/OffsetApplier;", "N", "Landroidx/compose/runtime/Applier;", "applier", "offset", "", "<init>", "(Landroidx/compose/runtime/Applier;I)V", "nesting", "current", "getCurrent", "()Ljava/lang/Object;", ILiveRoomPlayFragmentConstant.LOG_DIRECTION_DOWN, "", "node", "(Ljava/lang/Object;)V", "up", "insertTopDown", "index", "instance", "(ILjava/lang/Object;)V", "insertBottomUp", "remove", "count", "move", "from", RemoteMessageConst.TO, "clear", e1.REPLY_ACTION_APPLY, "block", "Lkotlin/Function2;", "", "Lkotlin/ExtensionFunctionType;", "value", "reuse", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class OffsetApplier<N> implements Applier<N> {
    public static final int $stable = 8;
    private final Applier<N> applier;
    private int nesting;
    private final int offset;

    @Override // androidx.compose.runtime.Applier
    public final /* synthetic */ void onBeginChanges() {
        Applier.CC.$default$onBeginChanges(this);
    }

    @Override // androidx.compose.runtime.Applier
    public final /* synthetic */ void onEndChanges() {
        Applier.CC.$default$onEndChanges(this);
    }

    @Override // androidx.compose.runtime.Applier
    public void clear() {
        ComposerKt.composeImmediateRuntimeError("Clear is not valid on OffsetApplier");
    }

    @Override // androidx.compose.runtime.Applier
    public N getCurrent() {
        return this.applier.getCurrent();
    }

    @Override // androidx.compose.runtime.Applier
    public void reuse() {
        this.applier.reuse();
    }

    @Override // androidx.compose.runtime.Applier
    public void up() {
        if (this.nesting <= 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == true) goto L8;
        ComposerKt.composeImmediateRuntimeError("OffsetApplier up called with no corresponding down");
    L8:
        this.nesting--;
        this.applier.up();
        return;
    L5:
        r100 = false;
        goto L6
    }

    @Override // androidx.compose.runtime.Applier
    public void down(N r100) {
        this.nesting++;
        this.applier.down(r100);
    }

    public OffsetApplier(Applier<N> r100, int r101) {
        this.applier = r100;
        this.offset = r101;
    }

    @Override // androidx.compose.runtime.Applier
    public void apply(Function2<? super N, Object, Unit> r100, Object r101) {
        this.applier.apply(r100, r101);
    }

    @Override // androidx.compose.runtime.Applier
    public void insertBottomUp(int r100, N r101) {
        Applier<N> r102 = this.applier;
        if (this.nesting != 0) goto L5;
        int r103 = this.offset;
    L6:
        r102.insertBottomUp(r100 + r103, r101);
        return;
    L5:
        r103 = 0;
        goto L6
    }

    @Override // androidx.compose.runtime.Applier
    public void insertTopDown(int r100, N r101) {
        Applier<N> r102 = this.applier;
        if (this.nesting != 0) goto L5;
        int r103 = this.offset;
    L6:
        r102.insertTopDown(r100 + r103, r101);
        return;
    L5:
        r103 = 0;
        goto L6
    }

    @Override // androidx.compose.runtime.Applier
    public void remove(int r100, int r101) {
        Applier<N> r102 = this.applier;
        if (this.nesting != 0) goto L5;
        int r103 = this.offset;
    L6:
        r102.remove(r100 + r103, r101);
        return;
    L5:
        r103 = 0;
        goto L6
    }

    @Override // androidx.compose.runtime.Applier
    public void move(int r100, int r101, int r102) {
        if (this.nesting != 0) goto L5;
        int r103 = this.offset;
    L6:
        this.applier.move(r100 + r103, r101 + r103, r102);
        return;
    L5:
        r103 = 0;
        goto L6
    }
}
