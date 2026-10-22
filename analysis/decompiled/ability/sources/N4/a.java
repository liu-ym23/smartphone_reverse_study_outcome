package N4;

import S7.k;
import S7.p;
import com.stepos.agentframework.adapter.netcore.TOSUploadHelper;
import java.util.List;

/* loaded from: classes3.dex */
public final /* synthetic */ class a implements k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1008a;
    public final /* synthetic */ p b;

    public /* synthetic */ a(p pVar, int i) {
        this.f1008a = i;
        this.b = pVar;
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        switch (this.f1008a) {
            case 0:
                return TOSUploadHelper.uploadUri$lambda$0(this.b, ((Integer) obj).intValue());
            case 1:
                return TOSUploadHelper.uploadUri$lambda$1(this.b, (List) obj);
            case 2:
                return TOSUploadHelper.uploadFile$lambda$0(this.b, ((Integer) obj).intValue());
            default:
                return TOSUploadHelper.uploadFile$lambda$1(this.b, (List) obj);
        }
    }
}
