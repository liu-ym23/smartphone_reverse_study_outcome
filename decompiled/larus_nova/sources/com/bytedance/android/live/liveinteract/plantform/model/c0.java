package com.bytedance.android.live.liveinteract.plantform.model;

import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eR\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001c\u0010\f\u001a\u0004\u0018\u00010\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/model/c0;", "Lvh7/c;", "", "getEventInfoType", "()I", "getEventInfoType$annotations", "()V", "eventInfoType", "Lcom/bytedance/android/live/base/model/message/a5;", "getContent", "()Lcom/bytedance/android/live/base/model/message/a5;", "getContent$annotations", "content", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface c0 extends vh7.c<c0> {
    public static final a Companion = null;
    public static final int LIST_USER_EVENT_INFO_TYPE_ADD_PRICE = 4;
    public static final int LIST_USER_EVENT_INFO_TYPE_ECOM_PURCHASED = 6;
    public static final int LIST_USER_EVENT_INFO_TYPE_ECOM_VIEW = 5;
    public static final int LIST_USER_EVENT_INFO_TYPE_INVITE_FRIEND = 3;
    public static final int LIST_USER_EVENT_INFO_TYPE_KTV = 2;
    public static final int LIST_USER_EVENT_INFO_TYPE_NONE = 0;
    public static final int LIST_USER_EVENT_INFO_TYPE_RECOMMEND = 8;
    public static final int LIST_USER_EVENT_INFO_TYPE_SEARCH = 7;
    public static final int LIST_USER_EVENT_INFO_TYPE_TEAM_FIGHT = 1;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f77230a = null;

        public a() {
        }

        static {
            f77230a = new a();
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class b {
    }

    static {
        Companion = a.f77230a;
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "content")
    a5 getContent();

    @FieldName(name = "event_info_type")
    int getEventInfoType();
}
