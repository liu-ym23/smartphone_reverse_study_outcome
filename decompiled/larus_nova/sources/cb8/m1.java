package cb8;

import com.larus.im.bean.bot.BotModel;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class m1 implements com.larus.bmhome.chat.component.cvs.y.a<BotModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.larus.bmhome.chat.component.cvs.y f23044a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1<BotModel, Unit> f23045b;

    @Override // com.larus.bmhome.chat.component.cvs.y.a
    public final void c(BotModel r100) {
        BotModel r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "new");
        this.f23044a.lQ(this);
        this.f23045b.invoke(r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public m1(com.larus.bmhome.chat.component.cvs.y r100, Function1<? super BotModel, Unit> r101) {
        this.f23044a = r100;
        this.f23045b = r101;
    }
}
