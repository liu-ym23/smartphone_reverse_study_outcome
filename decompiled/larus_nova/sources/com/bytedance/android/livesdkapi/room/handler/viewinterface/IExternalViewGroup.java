package com.bytedance.android.livesdkapi.room.handler.viewinterface;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J,\u0010\u0006\u001a\u00020\u00032\"\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00030\bj\u0002`\nH&J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH&J\b\u0010\u000e\u001a\u00020\rH&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J,\u0010\u0010\u001a\u00020\u00032\"\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00030\bj\u0002`\nH&¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdkapi/room/handler/viewinterface/IExternalViewGroup;", "", "add", "", "view", "Lcom/bytedance/android/livesdkapi/room/handler/viewinterface/IExternalView;", "addListener", "listener", "Lkotlin/Function3;", "Lcom/bytedance/android/livesdkapi/room/handler/viewinterface/ExternalViewGroupAction;", "Lcom/bytedance/android/livesdkapi/room/handler/viewinterface/ExternalViewGroupListener;", "childAt", "idx", "", "childCount", "remove", "removeListener", "live-room-controller-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IExternalViewGroup {
    void add(IExternalView r100);

    void addListener(Function3<? super IExternalViewGroup, ? super IExternalView, ? super ExternalViewGroupAction, Unit> r100);

    IExternalView childAt(int r100);

    int childCount();

    void remove(IExternalView r100);

    void removeListener(Function3<? super IExternalViewGroup, ? super IExternalView, ? super ExternalViewGroupAction, Unit> r100);
}
