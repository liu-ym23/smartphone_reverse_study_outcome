package bl0;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lbl0/c;", "", "", "", "invitedUidList", "Ljava/util/List;", "<init>", "()V", "livepkaudience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c {

    @SerializedName("invited_user_id_list")
    public List<Long> invitedUidList;

    public c() {
        this.invitedUidList = CollectionsKt.emptyList();
    }
}
