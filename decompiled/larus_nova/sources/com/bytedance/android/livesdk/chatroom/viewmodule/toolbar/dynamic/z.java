package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic;

import android.util.SparseArray;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.o6;
import com.bytedance.android.livesdk.y7;
import com.bytedance.android.livesdkapi.room.handler.toolbar.NewToolbarButtonConstants;
import com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarComponentCheckInterface;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class z implements n {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashSet<Integer> f116221b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SparseArray<ToolbarComponentCheckInterface> f116222c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashMap<a, Runnable> f116223d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f116224e;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f116225a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f116226b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L10;
            a r101 = (a) r100;
            if (this.f116225a == r101.f116225a) goto L8;
            return false;
        L8:
            if (this.f116226b == r101.f116226b) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            return (this.f116225a * 31) + this.f116226b;
        }

        public final String toString() {
            return "ToolbarComponentKey(id=" + this.f116225a + ", groupId=" + this.f116226b + ")";
        }

        public a(int r100, int r101) {
            this.f116225a = r100;
            this.f116226b = r101;
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ z f116227a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ s f116228b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Function0 f116229c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Function1 f116230d;

        public b(z r100, s r101, Function0 r102, Function1 r103) {
            this.f116227a = r100;
            this.f116228b = r101;
            this.f116229c = r102;
            this.f116230d = r103;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f116227a.e(this.f116228b, this.f116229c, this.f116230d);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ z f116231a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ s f116232b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Function0 f116233c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Function1 f116234d;

        public c(z r100, s r101, Function0 r102, Function1 r103) {
            this.f116231a = r100;
            this.f116232b = r101;
            this.f116233c = r102;
            this.f116234d = r103;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f116231a.e(this.f116232b, this.f116233c, this.f116234d);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.n
    public final void a() {
        ALogger.i(this.f116224e, "CheckManager clear check list");
        this.f116222c.clear();
        this.f116223d.clear();
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.n
    public final void clear() {
        ALogger.i(this.f116224e, "CheckManager clear");
        this.f116222c.clear();
        this.f116221b.clear();
    }

    public z() {
        this.f116221b = new HashSet();
        this.f116222c = new SparseArray();
        this.f116223d = new HashMap();
        this.f116224e = "NewToolbarLogV2";
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.n
    public final boolean c(int r100) {
        Iterator<T> r101 = this.f116223d.keySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L11;
        Object r102 = r101.next();
        if (((a) r102).f116225a != r100) goto L8;
        boolean r103 = true;
    L9:
        if (r103 == false) goto L4;
    L12:
        if (r102 != null) goto L21;
        return false;
    L21:
        return true;
    L8:
        r103 = false;
        goto L9
    L11:
        r102 = null;
        goto L12
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.n
    public final void d(NewToolbarButtonConstants r100) {
        Intrinsics.checkNotNullParameter(r100, "toolbarButton");
        Map.Entry<a, Runnable> r101 = g(r100.getId());
        if (r101 == null) goto L5;
        Runnable r102 = this.f116223d.remove(r101.getKey());
    L5:
        this.f116222c.remove(r100.getId());
    }

    public final Map.Entry<a, Runnable> g(int r100) {
        Iterator<Map.Entry<a, Runnable>> r101 = this.f116223d.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        Map.Entry<a, Runnable> r102 = r101.next();
        if (r102.getKey().f116225a != r100) goto L4;
        return r102;
    L8:
        return null;
    }

    public final void h(NewToolbarButtonConstants r100) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        this.f116221b.add(Integer.valueOf(r100.getId()));
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.n
    public final void b(NewToolbarButtonConstants r100, ToolbarComponentCheckInterface r101) {
        Intrinsics.checkNotNullParameter(r100, "toolbarButton");
        Intrinsics.checkNotNullParameter(r101, "service");
        ALogger.i(this.f116224e, "register filter - " + r100);
        this.f116222c.put(r100.getId(), r101);
        Map.Entry<a, Runnable> r102 = g(r100.getId());
        if (r102 == null) goto L8;
        Runnable r103 = this.f116223d.remove(r102.getKey());
        if (r103 == null) goto L9;
        r103.run();
        return;
    L9:
        return;
    }

    public final void e(s r100, Function0<Unit> r101, Function1<? super String, Unit> r102) {
        ToolbarComponentCheckInterface r103 = this.f116222c.get(r100.f116191a);
        if (r103 == null) goto L5;
        Boolean r104 = Boolean.valueOf(r103.checkThenLoad(r100, r101, r102));
    L6:
        Boolean r105 = Boolean.TRUE;
        if ((!Intrinsics.areEqual(r104, r105)) == false) goto L10;
        r101.invoke();
    L10:
        if (Intrinsics.areEqual(r104, r105) == false) goto L13;
        ALogger.i(this.f116224e, "component handle! - " + r100);
        return;
    L13:
        if (Intrinsics.areEqual(r104, Boolean.FALSE) == false) goto L15;
        ALogger.i(this.f116224e, "component don't handle! - " + r100);
        return;
    L15:
        if (r104 != null) goto L20;
        ALogger.i(this.f116224e, "no component filter - " + r100);
        return;
    L20:
        return;
    L5:
        r104 = null;
        goto L6
    }

    public final void f(String r100, s r101, Function0<Unit> r102, Function1<? super String, Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, "actionName");
        Intrinsics.checkNotNullParameter(r101, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r102, "loadButton");
        Intrinsics.checkNotNullParameter(r103, "stopLoadCallback");
        if (y7.f162551a.getValue().booleanValue() == false) goto L11;
        int r104 = r101.f116196f;
        Iterator<T> r105 = this.f116223d.keySet().iterator();
    L6:
        if (r105.hasNext() == false) goto L11;
        a r106 = (a) r105.next();
        if (r104 != r106.f116226b) goto L6;
        this.f116223d.remove(r106);
    L11:
        if (this.f116221b.contains(Integer.valueOf(r101.f116191a)) == true) goto L13;
    L15:
        boolean r107 = false;
    L16:
        if (r107 == false) goto L32;
        Iterator<T> r108 = this.f116223d.keySet().iterator();
    L19:
        if (r108.hasNext() == false) goto L24;
        if (((a) r108.next()).f116226b != r101.f116196f) goto L19;
        ALogger.e(this.f116224e, "delayListNew same groupId is error");
        goto L19
    L24:
        if (Intrinsics.areEqual(r100, "refresh") == true) goto L26;
    L31:
        this.f116223d.put(new a(r101.f116191a, r101.f116196f), new c(this, r101, r102, r103));
        ALogger.i(this.f116224e, "put " + r101 + " to delay list");
        return;
    L26:
        if (o6.f154129a.getValue().booleanValue() == false) goto L31;
        a r109 = new a(r101.f116191a, r101.f116196f);
        if (this.f116223d.containsKey(r109) == false) goto L30;
        ALogger.i(this.f116224e, "refresh but no register, model: " + r101);
        return;
    L30:
        ALogger.i(this.f116224e, "refresh, put " + r101 + " to delay list");
        this.f116223d.put(r109, new b(this, r101, r102, r103));
        return;
    L32:
        e(r101, r102, r103);
        return;
    L13:
        if (this.f116222c.get(r101.f116191a) != null) goto L15;
        r107 = true;
        goto L16
    }
}
