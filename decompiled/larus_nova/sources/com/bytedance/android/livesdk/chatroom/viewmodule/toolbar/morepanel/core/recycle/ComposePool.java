package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.core.recycle;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.core.recycle.b;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public class ComposePool<ItemId, Item extends b<ItemId>> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f116601e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Pair<ItemId, Item>[] f116602a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f116603b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<Item, Unit> f116604c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f116605d;

    public static final class a {
    }

    static {
    }

    public ComposePool(int r100) {
        this.f116605d = r100;
        this.f116602a = new Pair[r100];
        this.f116604c = ComposePool$recycleAction$1.INSTANCE;
    }

    public final Item a(ItemId r100) {
        Intrinsics.checkNotNullParameter(r100, "id");
        int r101 = 0;
    L3:
        int r102 = this.f116605d;
        if (r101 < 0) goto L25;
        if (r102 <= r101) goto L26;
        if (this.f116603b <= 0) goto L27;
        Pair<ItemId, Item> r103 = this.f116602a[r101];
        if (r103 == null) goto L12;
        ItemId r104 = r103.getFirst();
    L14:
        if (Intrinsics.areEqual(r104, r100) == true) goto L15;
        r101 = r101 + 1;
        goto L3
    L15:
        if (r103 == null) goto L17;
        Item r105 = r103.getSecond();
    L18:
        this.f116602a[r101] = null;
        this.f116603b--;
        return r105;
    L17:
        r105 = null;
        goto L18
    L12:
        r104 = null;
        goto L14
    L27:
        return null;
    L26:
        return null;
    L25:
        return null;
    }

    public final void b(Function1<? super Item, Unit> r100) {
        int r101 = this.f116605d;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L11;
        if (r100 == null) goto L10;
        Pair<ItemId, Item> r103 = this.f116602a[r102];
        if (r103 == null) goto L10;
        Item r104 = r103.getSecond();
        if (r104 == null) goto L10;
        r100.invoke(r104);
    L10:
        this.f116602a[r102] = null;
        r102 = r102 + 1;
        goto L3
    L11:
        this.f116603b = 0;
    }

    public static void c(ComposePool r100, b r110) {
        Function1<Item, Unit> r101 = r100.f116604c;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r110, MapController.ITEM_LAYER_TAG);
        Object r102 = r110.g();
        if (r101 == null) goto L5;
        Unit r103 = r101.invoke(r110);
    L5:
        int r104 = 0;
        if (r100.f116603b <= 0) goto L27;
        Intrinsics.checkNotNullParameter(r110, "instance");
        int r105 = r100.f116605d;
        int r106 = 0;
    L8:
        if (r106 >= r105) goto L24;
        Pair<ItemId, Item> r107 = r100.f116602a[r106];
        Pair<ItemId, Item> r108 = null;
        if (r107 != null) goto L12;
    L21:
        if (r108 != null) goto L22;
        r106 = r106 + 1;
        goto L8
    L22:
        boolean r109 = true;
    L25:
        if (r109 == true) goto L27;
    L28:
        int r111 = r100.f116605d;
    L29:
        if (r104 >= r111) goto L40;
        Pair<ItemId, Item>[] r112 = r100.f116602a;
        if (r112[r104] == null) goto L32;
        r104 = r104 + 1;
        goto L29
    L32:
        r112[r104] = new Pair(r102, r110);
        r100.f116603b++;
        return;
    L40:
        return;
    L12:
        if (Intrinsics.areEqual(r107.getFirst(), r110.g()) == true) goto L14;
    L16:
        boolean r113 = false;
    L17:
        if (r113 == true) goto L20;
        r107 = null;
    L20:
        r108 = r107;
        goto L21
    L14:
        if (r107.getSecond() != r110) goto L16;
        r113 = true;
        goto L17
    L24:
        r109 = false;
    L27:
        if (r100.f116603b == 0) goto L28;
    }
}
