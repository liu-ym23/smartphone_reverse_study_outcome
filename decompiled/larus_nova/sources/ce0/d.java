package ce0;

import com.bytedance.android.live.liveinteract.plantform.model.IChannelLinkUser;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0018\u0010\u0019R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0012\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lce0/d;", "", "", "prompts", "Ljava/lang/String;", "getPrompts", "()Ljava/lang/String;", "setPrompts", "(Ljava/lang/String;)V", "", "Lcom/bytedance/android/live/liveinteract/plantform/model/IChannelLinkUser;", "linkedUsers", "Ljava/util/List;", "getLinkedUsers", "()Ljava/util/List;", "setLinkedUsers", "(Ljava/util/List;)V", "", "version", "J", "getVersion", "()J", "setVersion", "(J)V", "<init>", "()V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class d {

    @SerializedName("linked_users")
    private List<? extends IChannelLinkUser> linkedUsers;

    @SerializedName("prompts")
    private String prompts;

    @SerializedName("version")
    private long version;

    public d() {
    }
}
