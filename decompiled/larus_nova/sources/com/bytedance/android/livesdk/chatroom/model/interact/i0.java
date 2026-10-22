package com.bytedance.android.livesdk.chatroom.model.interact;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\b\b\bg\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\u000eJ\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H&R.\u0010\f\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00068&@&X¦\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/interact/i0;", "Lvh7/c;", "", "", "key", "getLiveCoreInfo", "", "", "getLiveCoreExtInfoMap", "()Ljava/util/Map;", "setLiveCoreExtInfoMap", "(Ljava/util/Map;)V", "liveCoreExtInfoMap", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface i0 extends vh7.c<i0> {
    public static final String AUDIO = "4";
    public static final String AUDIO_CHORUS = "3";
    public static final String AVATAR = "5";
    public static final a Companion = null;
    public static final String VIDEO = "2";
    public static final String VIDEO_CHORUS = "1";

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f106952a = null;

        public a() {
        }

        static {
            f106952a = new a();
        }
    }

    static {
        Companion = a.f106952a;
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    Map<Long, String> getLiveCoreExtInfoMap();

    String getLiveCoreInfo(String r100);

    void setLiveCoreExtInfoMap(Map<Long, String> r100);
}
