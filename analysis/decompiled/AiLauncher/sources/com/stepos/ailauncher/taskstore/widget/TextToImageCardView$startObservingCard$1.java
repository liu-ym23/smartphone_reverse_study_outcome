package com.stepos.ailauncher.taskstore.widget;

import android.util.Log;
import com.stepos.ailauncher.taskstore.entity.TaskInfoCard;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.taskstore.widget.TextToImageCardView$startObservingCard$1", f = "TextToImageCardView.kt", l = {684}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class TextToImageCardView$startObservingCard$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ String $id;
    final /* synthetic */ com.stepos.ailauncher.taskstore.repository.a $repo;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ TextToImageCardView this$0;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class a<T> implements Xa.c {
        final /* synthetic */ Ua.M $$this$launch;
        final /* synthetic */ String $id;
        final /* synthetic */ TextToImageCardView this$0;

        public a(Ua.M m10, TextToImageCardView textToImageCardView, String str) {
            this.$$this$launch = m10;
            this.this$0 = textToImageCardView;
            this.$id = str;
        }

        @Override // Xa.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Object emit(TaskInfoCard taskInfoCard, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            Object objB;
            TextToImageCardView textToImageCardView = this.this$0;
            String str = this.$id;
            try {
                Result.Companion companion = Result.INSTANCE;
                if (taskInfoCard != null) {
                    textToImageCardView.X(taskInfoCard);
                } else if (textToImageCardView.getBoundCard() == null) {
                    textToImageCardView.n1(str);
                }
                objB = Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            String str2 = this.$id;
            Throwable thE = Result.e(objB);
            if (thE != null) {
                Log.w("TextToImageCardView", "observeByTaskId bind failed taskId=" + str2, thE);
            }
            return Y8.t.f7040a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextToImageCardView$startObservingCard$1(com.stepos.ailauncher.taskstore.repository.a aVar, String str, TextToImageCardView textToImageCardView, InterfaceC4014c<? super TextToImageCardView$startObservingCard$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$repo = aVar;
        this.$id = str;
        this.this$0 = textToImageCardView;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        TextToImageCardView$startObservingCard$1 textToImageCardView$startObservingCard$1 = new TextToImageCardView$startObservingCard$1(this.$repo, this.$id, this.this$0, interfaceC4014c);
        textToImageCardView$startObservingCard$1.L$0 = obj;
        return textToImageCardView$startObservingCard$1;
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((TextToImageCardView$startObservingCard$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Ua.M m10 = (Ua.M) this.L$0;
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            Xa.b bVarE = Xa.d.E(this.$repo.b(this.$id), Ua.Y.b());
            a aVar = new a(m10, this.this$0, this.$id);
            this.L$0 = g9.h.a(m10);
            this.label = 1;
            if (bVarE.collect(aVar, this) == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        return Y8.t.f7040a;
    }
}
