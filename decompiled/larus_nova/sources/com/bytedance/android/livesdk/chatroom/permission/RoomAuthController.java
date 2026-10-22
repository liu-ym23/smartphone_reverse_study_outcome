package com.bytedance.android.livesdk.chatroom.permission;

import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.core.arch.mvvm.d;
import com.heytap.mcssdk.constant.b;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import lk1.a;
import lk1.c;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0018\u0010\t\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0018\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0005H\u0014R3\u0010\u0016\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\r0\u0014j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\r`\u00158\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/permission/RoomAuthController;", "Landroidx/lifecycle/ViewModel;", "Llk1/c;", "", "key", "", "checkExisted", "Lmk1/b;", b.f276366p, "updateComponentRule", "Lcom/bytedance/android/live/core/arch/mvvm/d;", "Lmk1/a;", "observeStatusChanged", "Llk1/a;", "addComponentRule", "getComponentStatus", "Lmk1/c;", "config", "getComponentStatusByConfig", "onCleared", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "componentAuthMap", "Ljava/util/HashMap;", "getComponentAuthMap", "()Ljava/util/HashMap;", "<init>", "()V", "liveroom-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RoomAuthController extends ViewModel implements c {
    private final HashMap<String, a> componentAuthMap;

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        this.componentAuthMap.clear();
    }

    public RoomAuthController() {
        this.componentAuthMap = new HashMap();
    }

    public final HashMap<String, a> getComponentAuthMap() {
        return this.componentAuthMap;
    }

    private final void checkExisted(String r100) {
        if (this.componentAuthMap.get(r100) != null) goto L6;
        this.componentAuthMap.put(r100, new a());
        return;
    }

    @Override // lk1.c
    public mk1.a getComponentStatus(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if (r100.length() != 0) goto L5;
        boolean r101 = true;
    L7:
        if (r101 == false) goto L9;
        return null;
    L9:
        a r102 = this.componentAuthMap.get(r100);
        if (r102 != null) goto L12;
        return null;
    L12:
        return r102.a();
    L5:
        r101 = false;
        goto L7
    }

    @Override // lk1.c
    public d<mk1.a> observeStatusChanged(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if (r100.length() != 0) goto L5;
        boolean r101 = true;
    L7:
        if (r101 == false) goto L9;
        return null;
    L9:
        a r102 = this.componentAuthMap.get(r100);
        if (r102 != null) goto L12;
        return null;
    L12:
        return r102.f509543b;
    L5:
        r101 = false;
        goto L7
    }

    @Override // lk1.c
    public a addComponentRule(String r100, mk1.b r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, b.f276366p);
        if (r100.length() != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L8;
        checkExisted(r100);
        a r103 = this.componentAuthMap.get(r100);
        if (r103 == null) goto L12;
        Intrinsics.checkNotNullParameter(r101, b.f276366p);
        r103.f509544c.remove(r101);
        r103.f509544c.add(r101);
    L12:
        a r104 = this.componentAuthMap.get(r100);
        if (r104 == null) goto L15;
        return r104;
    L15:
        return new a();
    L8:
        return new a();
    L5:
        r102 = false;
        goto L6
    }

    @Override // lk1.c
    public mk1.a getComponentStatusByConfig(String r100, mk1.c r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "config");
        if (r100.length() != 0) goto L5;
        boolean r102 = true;
    L6:
        mk1.b r103 = null;
        if (r102 == false) goto L9;
        return null;
    L9:
        a r104 = this.componentAuthMap.get(r100);
        if (r104 == null) goto L27;
        Intrinsics.checkNotNullParameter(r101, "config");
        Iterator<mk1.b> r105 = r104.f509544c.iterator();
    L13:
        if (r105.hasNext() == false) goto L17;
        mk1.b r106 = r105.next();
        if (Intrinsics.areEqual(r106.b(), r101) == false) goto L13;
        r103 = r106;
    L17:
        mk1.b r107 = r103;
        if (r107 == null) goto L21;
        mk1.a r108 = r107.a();
        if (r108 == null) goto L21;
    L23:
        return r108;
    L21:
        r108 = mk1.a.f514291d;
        goto L23
    L27:
        return null;
    L5:
        r102 = false;
        goto L6
    }

    @Override // lk1.c
    public void updateComponentRule(String r100, mk1.b r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, b.f276366p);
        if (r100.length() != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L8;
        return;
    L8:
        checkExisted(r100);
        a r103 = this.componentAuthMap.get(r100);
        if (r103 == null) goto L27;
        Intrinsics.checkNotNullParameter(r101, b.f276366p);
        Iterator<mk1.b> r104 = r103.f509544c.iterator();
    L11:
        mk1.a r105 = null;
        if (r104.hasNext() == false) goto L16;
        mk1.b r106 = r104.next();
        if (Intrinsics.areEqual(r106, r101) == false) goto L11;
    L17:
        mk1.b r107 = r106;
        if (r107 == null) goto L21;
        r105 = r107.a();
    L21:
        if ((!Intrinsics.areEqual(r105, r101.a())) == false) goto L28;
        Intrinsics.checkNotNullParameter(r101, b.f276366p);
        r103.f509544c.remove(r101);
        r103.f509544c.add(r101);
        r103.f509542a.a(r103.a());
        return;
    L28:
        return;
    L16:
        r106 = null;
        goto L17
    L27:
        return;
    L5:
        r102 = false;
        goto L6
    }
}
