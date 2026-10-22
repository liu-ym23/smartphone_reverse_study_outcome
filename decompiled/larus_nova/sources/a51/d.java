package a51;

import com.bytedance.android.live.revlink.impl.settings.opt.model.RevLinkLayoutOptConfigSerializableObjectImpl;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import vh7.j;

/* JADX INFO: loaded from: classes47.dex */
@JsonAdapter(RevLinkLayoutOptConfigSerializableObjectImpl.Adapter.class)
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"La51/d;", "Lvh7/j;", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface d extends j<d> {

    @JsonAdapter(RevLinkLayoutOptConfigSerializableObjectImpl.Adapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @FieldName(name = "multi_anchor_window_simplify")
    boolean G3();

    @FieldName(name = "pk_layout_pre_inflate")
    boolean S7();

    @FieldName(name = "multi_anchor_pre_inflate")
    boolean e9();

    @FieldName(name = "pk_layout_pre_inflate_anchor")
    boolean x0();

    @FieldName(name = "multi_anchor_pre_inflate_anchor")
    boolean y4();
}
