package b7c;

import com.ss.android.lark.chat.entity.message.SendStatus;
import com.ss.android.lark.chatbase.model.c;
import f5b.b;

/* JADX INFO: loaded from: classes38.dex */
public final class a extends c.b<b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SendStatus f17991a;

    public a(SendStatus r100) {
        this.f17991a = r100;
    }

    @Override // com.ss.android.lark.chatbase.model.c.b
    public final b b(Object r100) {
        b r101 = (b) r100;
        r101.getMessage().setSendStatus(this.f17991a);
        return r101;
    }
}
