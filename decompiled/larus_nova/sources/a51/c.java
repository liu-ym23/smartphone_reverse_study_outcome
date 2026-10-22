package a51;

import com.bytedance.android.live.revlink.impl.settings.opt.model.RevLinkJankOptConfigSerializableObjectImpl;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import vh7.j;

/* JADX INFO: loaded from: classes47.dex */
@JsonAdapter(RevLinkJankOptConfigSerializableObjectImpl.Adapter.class)
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"La51/c;", "Lvh7/j;", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface c extends j<c> {

    @JsonAdapter(RevLinkJankOptConfigSerializableObjectImpl.Adapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @FieldName(name = "multi_sei_opt")
    boolean B6();

    @FieldName(name = "sei_opt")
    boolean a9();

    @FieldName(name = "pk_mvp_list_opt")
    boolean e7();

    @FieldName(name = "multi_anchor_title_opt")
    boolean t5();
}
