package com.bytedance.android.livesdkapi.room.handler.viewinterface;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0005H\u0016J,\u0010\u000e\u001a\u00020\n2\"\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bj\u0002`\u000bH\u0016J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u0010\u0010\u0014\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0005H\u0016J,\u0010\u0015\u001a\u00020\n2\"\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bj\u0002`\u000bH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R0\u0010\u0006\u001a$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bj\u0002`\u000b0\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdkapi/room/handler/viewinterface/BasicViewGroup;", "Lcom/bytedance/android/livesdkapi/room/handler/viewinterface/IExternalViewGroup;", "()V", "children", "", "Lcom/bytedance/android/livesdkapi/room/handler/viewinterface/IExternalView;", "listeners", "", "Lkotlin/Function3;", "Lcom/bytedance/android/livesdkapi/room/handler/viewinterface/ExternalViewGroupAction;", "", "Lcom/bytedance/android/livesdkapi/room/handler/viewinterface/ExternalViewGroupListener;", "add", "view", "addListener", "listener", "childAt", "idx", "", "childCount", "remove", "removeListener", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public class BasicViewGroup implements IExternalViewGroup {
    private List<? extends IExternalView> children;
    private Set<? extends Function3<? super IExternalViewGroup, ? super IExternalView, ? super ExternalViewGroupAction, Unit>> listeners;

    @Override // com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalViewGroup
    public int childCount() {
        return this.children.size();
    }

    public BasicViewGroup() {
        this.children = CollectionsKt.emptyList();
        this.listeners = SetsKt.emptySet();
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalViewGroup
    public void add(IExternalView r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        if (this.children.contains(r100) == true) goto L8;
        this.children = CollectionsKt.plus(this.children, r100);
        Iterator<T> r101 = this.listeners.iterator();
    L6:
        if (r101.hasNext() == false) goto L10;
        ((Function3) r101.next()).invoke(this, r100, ExternalViewGroupAction.Add);
        goto L6
    L10:
        return;
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalViewGroup
    public void addListener(Function3<? super IExternalViewGroup, ? super IExternalView, ? super ExternalViewGroupAction, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.listeners = SetsKt.plus(this.listeners, r100);
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalViewGroup
    public IExternalView childAt(int r100) {
        return (IExternalView) ListProtector.get(this.children, r100);
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalViewGroup
    public void remove(IExternalView r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        int r101 = childCount();
        this.children = CollectionsKt.minus(this.children, r100);
        if (r101 == childCount()) goto L8;
        Iterator<T> r102 = this.listeners.iterator();
    L6:
        if (r102.hasNext() == false) goto L10;
        ((Function3) r102.next()).invoke(this, r100, ExternalViewGroupAction.Remove);
        goto L6
    L10:
        return;
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalViewGroup
    public void removeListener(Function3<? super IExternalViewGroup, ? super IExternalView, ? super ExternalViewGroupAction, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.listeners = SetsKt.minus(this.listeners, r100);
    }
}
