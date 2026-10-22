package com.stepos.ailauncher.agent.skill.detail;

import android.text.Spanned;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00070\u0001¢\u0006\u0002\b\u0002*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LUa/M;", "Landroid/text/Spanned;", "Lkotlin/jvm/internal/EnhancedNullability;", "<anonymous>", "(LUa/M;)Landroid/text/Spanned;"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.agent.skill.detail.SkillMarkwonFactoryKt$renderReadmePreview$spanned$1", f = "SkillMarkwonFactory.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class SkillMarkwonFactoryKt$renderReadmePreview$spanned$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Spanned>, Object> {
    final /* synthetic */ u8.e $markwon;
    final /* synthetic */ String $md;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SkillMarkwonFactoryKt$renderReadmePreview$spanned$1(u8.e eVar, String str, InterfaceC4014c<? super SkillMarkwonFactoryKt$renderReadmePreview$spanned$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$markwon = eVar;
        this.$md = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new SkillMarkwonFactoryKt$renderReadmePreview$spanned$1(this.$markwon, this.$md, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Spanned> interfaceC4014c) {
        return ((SkillMarkwonFactoryKt$renderReadmePreview$spanned$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        return this.$markwon.h(this.$md);
    }
}
