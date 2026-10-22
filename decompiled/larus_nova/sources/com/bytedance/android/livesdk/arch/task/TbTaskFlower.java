package com.bytedance.android.livesdk.arch.task;

import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdkapi.room.handler.toolbar.LiveTbArchUtils;
import com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarMatchInterface;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes7.dex */
public final class TbTaskFlower implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f103874a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CompositeDisposable f103875b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.android.livesdk.arch.context.a f103876c;

    public TbTaskFlower(com.bytedance.android.livesdk.arch.context.a r100) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        this.f103876c = r100;
        this.f103874a = LazyKt.lazy(new TbTaskFlower$taskDispatcher$2(this));
        this.f103875b = new CompositeDisposable();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [io.reactivex.disposables.Disposable] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.bytedance.android.livesdk.arch.task.TbTaskFlower] */
    /* JADX WARN: Type inference failed for: r8v19, types: [T, io.reactivex.disposables.Disposable] */
    /* JADX WARN: Type inference failed for: r8v20, types: [io.reactivex.disposables.CompositeDisposable] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.bytedance.android.livesdk.arch.task.f
    public final void a(final l r100) {
        Intrinsics.checkNotNullParameter(r100, "command");
        com.bytedance.android.livesdk.arch.comp.b r101 = r100.f103901d;
        l.b r102 = r100.getType();
        Intrinsics.checkNotNullParameter(r101, "comp");
        Intrinsics.checkNotNullParameter(r102, "type");
        final x r103 = new x(this.f103876c, r101, r102);
        e(r103, ne1.b.a.c.f518861b);
        l.b r104 = r100.getType();
        if (Intrinsics.areEqual(r104, l.b.C1573b.f103904b) == false) goto L6;
        final ToolbarMatchInterface r105 = r103.f103936c.d();
        final boolean r106 = Intrinsics.areEqual(((com.bytedance.android.livesdk.arch.comp.h) r103.f103936c).p(), com.bytedance.android.livesdk.arch.container.d.a.f103756c);
        ArrayList r107 = new ArrayList();
        r107.add(new RecordTask(RecordTask.Type.Pending));
        r107.add(new g());
        d(r107, new j(), new TbTaskFlower$createShowTask$$inlined$apply$lambda$1(this, r105, r103, r106));
        r107.add(new b());
        d(r107, new SlotPkTask(r103.f103936c.f103727f.getDataCenter()), new TbTaskFlower$createShowTask$$inlined$apply$lambda$2(this, r105, r103, r106));
        r107.add(new RecordTask(RecordTask.Type.Show));
        r107.add(new LogRecordTask());
        r107.add(new i());
        r107.add(new LoadContentTask());
        r107.add(new c(ne1.b.C6918b.a.f518862b));
        List r108 = r107;
    L21:
        if (r108.isEmpty() == false) goto L25;
        e(r103, ne1.b.a.C6916a.f518859b);
        return;
    L25:
        if (LiveTbArchUtils.INSTANCE.enablePrefOpt() == false) goto L27;
        this.f103875b.add(Observable.fromIterable(r108).concatMap(new r(this, r103)).subscribe(m.f103907a, new n(this, r103), new o(this, r103)));
        return;
    L27:
        Observable<TaskResult> r109 = ((d) CollectionsKt.first(r108)).a(r103);
        int r110 = r108.size();
        int r111 = 1;
    L28:
        if (r111 >= r110) goto L30;
        r109 = r109.doOnNext(new s(this, r103, r108, r111)).flatMap(new t(r108, r111, (d) ListProtector.get(r108, r111), r103));
        r111 = r111 + 1;
        goto L28
    L30:
        Ref.ObjectRef r112 = new Ref.ObjectRef();
        ?? r113 = 0;
        r112.element = null;
        ?? r114 = r109.subscribe(new u(this, r103, r108), new v(this, r103, r112), new w(this, r103, r112));
        r112.element = r114;
        if (r114 != 0) goto L33;
        return;
    L33:
        if ((!r114.isDisposed()) == false) goto L35;
        r113 = r114;
    L35:
        if (r113 == 0) goto L41;
        this.f103875b.add(r113);
        return;
    L41:
        return;
    L6:
        if (Intrinsics.areEqual(r104, l.b.a.f103903b) == false) goto L9;
        Intrinsics.areEqual(((com.bytedance.android.livesdk.arch.comp.h) r103.f103936c).p(), com.bytedance.android.livesdk.arch.container.d.a.f103756c);
        ArrayList r115 = new ArrayList();
        r115.add(new RecordTask(RecordTask.Type.Dismiss));
        r115.add(new c(ne1.b.C6918b.C6919b.f518863b));
        d(r115, new y(), new TbTaskFlower$createDismissTask$$inlined$apply$lambda$1(this, r100));
        r115.add(new h());
        r115.add(new LogRecordTask());
        r108 = r115;
        goto L21
    L9:
        if (Intrinsics.areEqual(r104, l.b.d.f103906b) == false) goto L17;
        com.bytedance.android.livesdk.arch.comp.b r116 = r103.f103936c;
        ArrayList r117 = new ArrayList();
        Object r118 = r100.f103898a;
        r108 = r117;
        if ((r118 instanceof ToolbarMatchInterface) == false) goto L21;
        if (r118 == null) goto L15;
        r116.o((ToolbarMatchInterface) r118);
        r117.add(new c(ne1.b.C6918b.c.f518864b));
        r108 = r117;
        goto L21
    L15:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarMatchInterface");
    L17:
        if (Intrinsics.areEqual(r104, l.b.c.f103905b) == false) goto L19;
        ArrayList r119 = new ArrayList();
        r119.add(new c(ne1.b.C6918b.C6919b.f518863b));
        r119.add(new RecordTask(RecordTask.Type.Wait));
        r119.add(new LogRecordTask());
        r108 = r119;
        goto L21
    L19:
        r108 = CollectionsKt.emptyList();
        goto L21
    }

    public final void e(e r100, ne1.b r101) {
        z51.e r102 = (z51.e) this.f103874a.getValue();
        if (r102 == null) goto L6;
        int r103 = ne1.f.f518876e;
        com.bytedance.android.livesdk.arch.comp.b r104 = r100.d();
        l.b r105 = r100.getCommandType();
        Intrinsics.checkNotNullParameter(r104, "comp");
        Intrinsics.checkNotNullParameter(r101, "event");
        Intrinsics.checkNotNullParameter(r105, "commandType");
        r102.b(new ne1.f(r104, r101, r105));
        return;
    }

    public static final void b(TbTaskFlower r100, e r101, Throwable r102) {
        r100.getClass();
        if ((r102 instanceof TaskFailureException) == true) goto L8;
        r100.e(r101, new ne1.b.a.C6917b(r102));
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L8;
        throw r102;
    L8:
        r101.a().recordManager(((com.bytedance.android.livesdk.arch.comp.h) r101.d()).p()).b(r101.d());
        r100.e(r101, ne1.b.a.C6916a.f518859b);
    }

    public static void d(List r100, a r101, Function0 r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$addIf");
        Intrinsics.checkNotNullParameter(r101, "task");
        Intrinsics.checkNotNullParameter(r102, "predicate");
        if (((Boolean) r102.invoke()).booleanValue() == false) goto L6;
        ((ArrayList) r100).add(r101);
        return;
    }

    public static final void c(TbTaskFlower r100, TaskResult r101, e r102, d r103) {
        r100.getClass();
        if ((r101 instanceof TaskResult.b) == false) goto L10;
        TaskResult.b r104 = (TaskResult.b) r101;
        r100.e(r102, new ne1.b.f(r104));
        if (r103.isComplete() == false) goto L13;
        throw r104.f103873d;
    L13:
        if (r103.isComplete() == false) goto L16;
        r100.e(r102, new ne1.b.d(r103.getId()));
        return;
    L16:
        return;
    L10:
        if ((r101 instanceof TaskResult.c) == false) goto L13;
        r100.e(r102, new ne1.b.g((TaskResult.c) r101));
        goto L13
    }
}
