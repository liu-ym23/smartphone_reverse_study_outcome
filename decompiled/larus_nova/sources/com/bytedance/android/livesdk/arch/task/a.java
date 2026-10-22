package com.bytedance.android.livesdk.arch.task;

import com.bytedance.android.live.room.api.base.alog.SimpleAlogArgsBuilder;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.util.Iterator;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public abstract class a implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f103877a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e f103878b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ObservableEmitter<TaskResult> f103879c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TaskId f103880d;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.arch.task.a$a, reason: collision with other inner class name */
    public static final class C1571a<T> implements ObservableOnSubscribe {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f103881a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e f103882b;

        public C1571a(a r100, e r101) {
            this.f103881a = r100;
            this.f103882b = r101;
        }

        @Override // io.reactivex.ObservableOnSubscribe
        public final void subscribe(ObservableEmitter<TaskResult> r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            a r101 = this.f103881a;
            r101.f103879c = r100;
            a.e(this.f103882b, new ne1.b.e(String.valueOf(r101.f103880d.name())));     // Catch: Exception -> L5
            this.f103881a.f(this.f103882b);     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            ObservableEmitter<TaskResult> r102 = this.f103881a.f103879c;
            if (r102 == null) goto L9;
            r102.onError(e);
        L9:
            this.f103881a.f103879c = null;
        }
    }

    public abstract void f(e r100);

    @Override // com.bytedance.android.livesdk.arch.task.d
    public final TaskId getId() {
        return this.f103880d;
    }

    @Override // com.bytedance.android.livesdk.arch.task.d
    public final boolean isComplete() {
        return this.f103877a;
    }

    public a(TaskId r100) {
        Intrinsics.checkNotNullParameter(r100, "id");
        this.f103880d = r100;
    }

    public static void d(a r100) {
        r100.f103877a = r100.g(r100.f103878b);
        ObservableEmitter<TaskResult> r101 = r100.f103879c;
        if (r101 == null) goto L6;
        int r102 = TaskResult.f103870c;
        Intrinsics.checkNotNullParameter(r100, "$this$successResult");
        r101.onNext(new TaskResult.c(r100.f103880d));
    L6:
        if (r100.f103877a == false) goto L12;
        ObservableEmitter<TaskResult> r103 = r100.f103879c;
        if (r103 == null) goto L10;
        r103.onComplete();
    L10:
        r100.f103879c = null;
        return;
    }

    @Override // com.bytedance.android.livesdk.arch.task.d
    public final Observable<TaskResult> a(e r100) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        this.f103878b = r100;
        return Observable.create(new C1571a(this, r100));
    }

    public boolean g(e r100) {
        if (r100 != null) goto L4;
    L7:
        return true;
    L4:
        if (r100.c() == true) goto L7;
        return false;
    }

    public static void e(e r100, ne1.b r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$dispatchState");
        Intrinsics.checkNotNullParameter(r101, "taskEvent");
        int r102 = me1.a.f513447a;
        z51.e r103 = r100.a().stateDispatcher().c();
        if ((r103 instanceof z51.e) == true) goto L5;
        r103 = null;
    L5:
        if (r103 == null) goto L8;
        int r104 = ne1.f.f518876e;
        com.bytedance.android.livesdk.arch.comp.b r105 = r100.d();
        l.b r106 = r100.getCommandType();
        Intrinsics.checkNotNullParameter(r105, "comp");
        Intrinsics.checkNotNullParameter(r101, "event");
        Intrinsics.checkNotNullParameter(r106, "commandType");
        r103.b(new ne1.f(r105, r101, r106));
        return;
    }

    public static void h(String r100, Map r101) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        ke1.a.f502996a.getClass();
        ke1.a r102 = ke1.a.C6543a.a();
        if (r102 == null) goto L30;
        SimpleAlogArgsBuilder r103 = new SimpleAlogArgsBuilder();
        r103.c(r100);
        if (r101 != null) goto L7;
    L15:
        Unit r104 = Unit.INSTANCE;
        r102.c(r103.b());
        ke1.f.a r105 = new ke1.f.a(r100);
        if (r101 != null) goto L18;
    L26:
        Unit r106 = Unit.INSTANCE;
        r102.a(new ke1.f(r105));
        return;
    L18:
        if ((!r101.isEmpty()) == true) goto L21;
        r101 = null;
    L21:
        if (r101 == null) goto L26;
        Iterator r107 = r101.entrySet().iterator();
    L24:
        if (r107.hasNext() == false) goto L26;
        Map.Entry r108 = (Map.Entry) r107.next();
        r105.a((String) r108.getKey(), String.valueOf(r108.getValue()));
        goto L24
    L7:
        if ((!r101.isEmpty()) == false) goto L9;
        Map r109 = r101;
    L10:
        if (r109 == null) goto L15;
        Iterator r110 = r109.entrySet().iterator();
    L13:
        if (r110.hasNext() == false) goto L15;
        Map.Entry r111 = (Map.Entry) r110.next();
        r103.a((String) r111.getKey(), String.valueOf(r111.getValue()));
        goto L13
    L9:
        r109 = null;
        goto L10
    }

    public final void b(String r100, Throwable r101, Map<String, Object> r102) {
        this.f103877a = g(this.f103878b);
        ObservableEmitter<TaskResult> r103 = this.f103879c;
        if (r103 == null) goto L9;
        int r104 = TaskResult.f103870c;
        Intrinsics.checkNotNullParameter(this, "$this$failureResult");
        TaskResult.b r105 = new TaskResult.b(this.f103880d, new TaskFailureException(r100, r101));
        if (r102 == null) goto L7;
        ((Map) r105.f103871a.getValue()).putAll(r102);
    L7:
        r103.onNext(r105);
    L9:
        if (this.f103877a == false) goto L15;
        ObservableEmitter<TaskResult> r106 = this.f103879c;
        if (r106 == null) goto L13;
        r106.onComplete();
    L13:
        this.f103879c = null;
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void c(a r100, String r101, Map r102, int r103) {
        if ((r103 & 4) == 0) goto L5;
        r102 = null;
    L5:
        r100.b(r101, null, r102);
    }
}
