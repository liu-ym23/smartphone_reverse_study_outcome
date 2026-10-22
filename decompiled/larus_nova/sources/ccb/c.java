package ccb;

import com.ss.android.lark.chat.entity.message.Message;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<a> f23342a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f23343a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Message.Type f23344b;

        public final int hashCode() {
            return this.f23343a.hashCode();
        }

        public final Message.Type getType() {
            return this.f23344b;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 == null) goto L8;
            Class<?> r101 = r100.getClass();
        L10:
            if (Intrinsics.areEqual(a.class, r101) == true) goto L12;
            return false;
        L12:
            Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.ss.android.lark.dto.chat.GetMessageIdsByPositionResponse.MessageTypeInfo");
            if (Intrinsics.areEqual(this.f23343a, ((a) r100).f23343a) == true) goto L15;
            return false;
        L15:
            return true;
        L8:
            r101 = null;
            goto L10
        }

        public a(String r100, Message.Type r101) {
            Intrinsics.checkNotNullParameter(r100, "id");
            Intrinsics.checkNotNullParameter(r101, "type");
            this.f23343a = r100;
            this.f23344b = r101;
        }
    }

    public c(List<a> r100) {
        Intrinsics.checkNotNullParameter(r100, "msgList");
        this.f23342a = r100;
    }
}
