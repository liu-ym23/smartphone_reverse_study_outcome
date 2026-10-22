package com.bytedance.android.live.liveinteract.plantform.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\b\bg\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u001a\u0010\t\u001a\u00020\u00048VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/model/e;", "Lvh7/c;", "", "isGameInvite", "", "getInviteSource", "()I", "getInviteSource$annotations", "()V", "inviteSource", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface e extends vh7.c<e> {
    public static final a Companion = null;
    public static final int INVITE_SOURCE_PANEL = 1;
    public static final int INVITE_SOURCE_UNKNOWN = 0;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f77234a = null;

        public a() {
        }

        static {
            f77234a = new a();
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class b {
    }

    static {
        Companion = a.f77234a;
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "invite_source")
    int getInviteSource();

    boolean isGameInvite();
}
