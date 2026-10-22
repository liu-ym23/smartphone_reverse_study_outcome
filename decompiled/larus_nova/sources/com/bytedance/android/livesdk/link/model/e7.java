package com.bytedance.android.livesdk.link.model;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\b\u0006\bg\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\nR\"\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00038&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/e7;", "Lvh7/c;", "", "", "", "", "getRevUserIdToTeamId", "()Ljava/util/Map;", "revUserIdToTeamId", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface e7 extends vh7.c<e7> {
    public static final a Companion = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f147095a = null;

        public a() {
        }

        static {
            f147095a = new a();
        }
    }

    static {
        Companion = a.f147095a;
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    /* synthetic */ String getBattleConfigSettingStr();

    /* synthetic */ int getModeTab();

    Map<String, Long> getRevUserIdToTeamId();

    /* synthetic */ int getSwitchSource();

    /* synthetic */ long getVersion();
}
