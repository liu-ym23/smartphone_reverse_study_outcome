package com.bytedance.android.live.recharge.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import vh7.j;

/* JADX INFO: loaded from: classes47.dex */
@JsonAdapter(NoPasswordFansConfigSerializableObjectImpl.Adapter.class)
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\t\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nR\"\u0010\t\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/recharge/model/NoPasswordFansConfig;", "Lvh7/j;", "", "getType", "()I", "setType", "(I)V", "getType$annotations", "()V", "type", "Companion", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface NoPasswordFansConfig extends j<NoPasswordFansConfig> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Companion f89992e = null;

    public static final class Companion {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Lazy f89993a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ Companion f89994b = null;

        public Companion() {
        }

        static {
            f89994b = new Companion();
            f89993a = LazyKt.lazy(NoPasswordFansConfig$Companion$DEFAULT$2.INSTANCE);
        }
    }

    @JsonAdapter(NoPasswordFansConfigSerializableObjectImpl.Adapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    static {
        f89992e = Companion.f89994b;
    }

    @FieldName(name = "gift_ids")
    List<Long> getGiftIds();

    @FieldName(name = "type")
    int getType();

    @FieldName(name = "gift_ids#setter")
    void setGiftIds(List<Long> r100);

    @FieldName(name = "type#setter")
    void setType(int r100);
}
