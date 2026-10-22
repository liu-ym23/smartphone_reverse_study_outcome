package com.bytedance.android.livesdk.link.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0007R\u001a\u0010\u0003\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IPropInfoNotifyResponse;", "Lvh7/c;", "", "isNotify", "()Z", "isNotify$annotations", "()V", "RequestPropCardNotifyType", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IPropInfoNotifyResponse extends vh7.c<IPropInfoNotifyResponse> {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IPropInfoNotifyResponse$RequestPropCardNotifyType;", "", "TypeUnknown", "TypeAvailable", "TypeExpired", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum RequestPropCardNotifyType extends Enum<RequestPropCardNotifyType> {
        public static final RequestPropCardNotifyType TypeAvailable = null;
        public static final RequestPropCardNotifyType TypeExpired = null;
        public static final RequestPropCardNotifyType TypeUnknown = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ RequestPropCardNotifyType[] f147065a = null;

        static {
            RequestPropCardNotifyType r100 = new RequestPropCardNotifyType("TypeUnknown", 0);
            TypeUnknown = r100;
            RequestPropCardNotifyType r101 = new RequestPropCardNotifyType("TypeAvailable", 1);
            TypeAvailable = r101;
            RequestPropCardNotifyType r102 = new RequestPropCardNotifyType("TypeExpired", 2);
            TypeExpired = r102;
            f147065a = new RequestPropCardNotifyType[]{r100, r101, r102};
        }

        public static RequestPropCardNotifyType valueOf(String r100) {
            return (RequestPropCardNotifyType) r27.a.a(RequestPropCardNotifyType.class, r100);
        }

        public static RequestPropCardNotifyType[] values() {
            return (RequestPropCardNotifyType[]) f147065a.clone();
        }

        public RequestPropCardNotifyType(String r100, int r101) {
            super(r100, r101);
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "is_notify")
    boolean isNotify();
}
