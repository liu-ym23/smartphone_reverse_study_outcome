package com.bytedance.android.live.openplatform.impl.miniappaudience.explaincard;

import android.animation.Animator;
import android.widget.LinearLayout;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.live.core.utils.h;
import com.bytedance.android.live.core.utils.s;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class AudienceExplainCardWidget$hideCard$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ s $listener;
    final /* synthetic */ AudienceExplainCardWidget this$0;

    public AudienceExplainCardWidget$hideCard$1(AudienceExplainCardWidget r100, s r101) {
        this.this$0 = r100;
        this.$listener = r101;
        super(0);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.this$0.f84843g.setPivotX(0.0f);
        LinearLayout r100 = this.this$0.f84843g;
        r100.setPivotY(r100.getHeight());
        Animator r101 = this.this$0.f84841e;
        if (r101 == null) goto L9;
        h.a(r101, new AudienceExplainCardWidget$hideCard$1$$special$$inlined$run$lambda$1(this));
        s r102 = this.$listener;
        if (r102 == null) goto L7;
        r101.addListener(r102);
    L7:
        r101.start();
        return;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
