package com.bytedance.android.live.liveinteract.animation;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;
import java.util.Iterator;

/* JADX INFO: loaded from: classes46.dex */
public final class x<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InteractFlyMicAnimationTask f71383a;

    public x(InteractFlyMicAnimationTask r100) {
        this.f71383a = r100;
    }

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
    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        ALogger.d("InteractAnimation.InteractFlyMicAnimationTask" + this.f71383a.f70971b, "it is time to revealAllDetails");
        InteractFlyMicAnimationTask r102 = this.f71383a;
        r102.h(r102);
        Iterator<com.bytedance.android.live.liveinteract.animation.tasklet.d> r103 = this.f71383a.f70956n.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r103.next().stop();
        goto L4
    }
}
