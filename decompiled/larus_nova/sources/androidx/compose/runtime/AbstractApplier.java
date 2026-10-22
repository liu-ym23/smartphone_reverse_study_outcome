package androidx.compose.runtime;

import androidx.exifinterface.media.ExifInterface;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b'\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0005J\b\u0010\u0013\u001a\u00020\u0011H\u0016J\u0006\u0010\u0014\u001a\u00020\u0011J\b\u0010\u0015\u001a\u00020\u0011H$J\"\u0010\u0016\u001a\u00020\u0011*\b\u0012\u0004\u0012\u00028\u00000\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0004J*\u0010\u001b\u001a\u00020\u0011*\b\u0012\u0004\u0012\u00028\u00000\u00172\u0006\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0004R\u0013\u0010\u0003\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR&\u0010\r\u001a\u00028\u00002\u0006\u0010\f\u001a\u00028\u0000@TX\u0096\u000e¢\u0006\u0010\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\u0005¨\u0006\u001e"}, d2 = {"Landroidx/compose/runtime/AbstractApplier;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/runtime/Applier;", RootDescription.ROOT_ELEMENT, "<init>", "(Ljava/lang/Object;)V", "getRoot", "()Ljava/lang/Object;", "Ljava/lang/Object;", "stack", "Landroidx/compose/runtime/Stack;", "Ljava/util/ArrayList;", "value", "current", "getCurrent", "setCurrent", ILiveRoomPlayFragmentConstant.LOG_DIRECTION_DOWN, "", "node", "up", "clear", "onClear", "remove", "", "index", "", "count", "move", "from", RemoteMessageConst.TO, "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class AbstractApplier<T> implements Applier<T> {
    public static final int $stable = 8;
    private T current;
    private final T root;
    private final ArrayList<T> stack;

    @Override // androidx.compose.runtime.Applier
    public final /* synthetic */ void apply(Function2 r100, Object r101) {
        Applier.CC.$default$apply(this, r100, r101);
    }

    @Override // androidx.compose.runtime.Applier
    public final /* synthetic */ void onBeginChanges() {
        Applier.CC.$default$onBeginChanges(this);
    }

    public abstract void onClear();

    @Override // androidx.compose.runtime.Applier
    public /* synthetic */ void onEndChanges() {
        Applier.CC.$default$onEndChanges(this);
    }

    @Override // androidx.compose.runtime.Applier
    public /* synthetic */ void reuse() {
        Applier.CC.$default$reuse(this);
    }

    @Override // androidx.compose.runtime.Applier
    public final void clear() {
        Stack.m4149clearimpl(this.stack);
        setCurrent(this.root);
        onClear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.runtime.Applier
    public void up() {
        setCurrent(Stack.m4160popimpl(this.stack));
    }

    @Override // androidx.compose.runtime.Applier
    public T getCurrent() {
        return this.current;
    }

    public final T getRoot() {
        return this.root;
    }

    public AbstractApplier(T r100) {
        this.root = r100;
        this.stack = Stack.m4151constructorimpl$default(null, 1, null);
        this.current = r100;
    }

    @Override // androidx.compose.runtime.Applier
    public void down(T r100) {
        Stack.m4161pushimpl(this.stack, getCurrent());
        setCurrent(r100);
    }

    public void setCurrent(T r100) {
        this.current = r100;
    }

    public final void remove(List<T> r100, int r101, int r102) {
        if (r102 != 1) goto L5;
        ListProtector.remove(r100, r101);
        return;
    L5:
        r100.subList(r101, r102 + r101).clear();
    }

    public final void move(List<T> r100, int r101, int r102, int r103) {
        if (r101 <= r102) goto L4;
        int r104 = r102;
    L6:
        if (r103 == 1) goto L8;
        List<T> r105 = r100.subList(r101, r103 + r101);
        List r106 = CollectionsKt.toMutableList(r105);
        r105.clear();
        r100.addAll(r104, r106);
        return;
    L8:
        if (r101 != (r102 + 1)) goto L10;
    L13:
        ListProtector.set(r100, r101, ListProtector.set(r100, r102, ListProtector.get(r100, r101)));
        return;
    L10:
        if (r101 == (r102 - 1)) goto L13;
        ListProtector.add(r100, r104, ListProtector.remove(r100, r101));
        return;
    L4:
        r104 = r102 - r103;
        goto L6
    }
}
