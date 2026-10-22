package b2b;

import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageParams;
import com.ss.android.lark.chat.entity.message.content.LocationContent;

/* JADX INFO: loaded from: classes35.dex */
public final class a extends MessageParams<a, C0255a> {
    public final LocationContent A;
    public final String B;
    public final int C;
    public final int D;

    /* JADX INFO: renamed from: b2b.a$a, reason: collision with other inner class name */
    public static final class C0255a extends MessageParams.a<a, C0255a> {
        public LocationContent A;
        public String B;
        public int C;
        public int D;

        @Override // com.ss.android.lark.chat.entity.message.MessageParams.a
        public final MessageParams a() {
            this.f415276h = Message.Type.LOCATION;
            return new a(this);
        }

        public C0255a() {
        }
    }

    public a(C0255a r100) {
        super(r100);
        this.A = r100.A;
        this.B = r100.B;
        this.C = r100.C;
        this.D = r100.D;
    }

    @Override // com.ss.android.lark.chat.entity.message.MessageParams
    public final Message c(String r100, String r101) {
        Message r102 = b(r100, r101);
        r102.setType(Message.Type.LOCATION);
        r102.setMessageContent(this.A);
        return r102;
    }
}
