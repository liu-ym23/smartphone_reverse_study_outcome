package c2b;

import com.ss.android.lark.chat.core.model.ObservableMappedArrayList;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ObservableMappedArrayList<String, MessageInfo> f22250a;

    public a(ObservableMappedArrayList<String, MessageInfo> r100) {
        Intrinsics.checkNotNullParameter(r100, "messageList");
        this.f22250a = r100;
    }

    @Override // c2b.b
    public final c a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "anchorMsgId");
        this.f22250a.acquireReadAccess();
        int r101 = this.f22250a.getItemPosByKey(new String[]{r100});
        this.f22250a.size();
        if (r101 > 0) goto L5;
    L7:
        List<MessageInfo> r102 = null;
    L8:
        this.f22250a.releaseReadAccess();
        return new c(r102);
    L5:
        if (r101 >= this.f22250a.size()) goto L7;
        ObservableMappedArrayList<String, MessageInfo> r103 = this.f22250a;
        r102 = r103.subList(r101, Math.min((0 + r101) + 1, r103.size()));
        goto L8
    }
}
