package com.bytedance.android.livesdk.live.extension.plugin.api.audiosdk;

import android.util.SparseArray;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/audiosdk/LiveWrappedSAMICoreTokenType;", "", "", "value", "I", "getValue", "()I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "TOKEN_TO_B", "TOKEN_TO_C_D", "TOKEN_TO_B_MIXED", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedSAMICoreTokenType extends Enum<LiveWrappedSAMICoreTokenType> {
    public static final a Companion = null;
    public static final LiveWrappedSAMICoreTokenType TOKEN_TO_B = null;
    public static final LiveWrappedSAMICoreTokenType TOKEN_TO_B_MIXED = null;
    public static final LiveWrappedSAMICoreTokenType TOKEN_TO_C_D = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveWrappedSAMICoreTokenType[] f147279a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SparseArray<LiveWrappedSAMICoreTokenType> f147280b = null;
    private final int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.audiosdk.LiveWrappedSAMICoreTokenType$a] */
    static {
        int r100 = 0;
        LiveWrappedSAMICoreTokenType r101 = new LiveWrappedSAMICoreTokenType("TOKEN_TO_B", 0, 0);
        TOKEN_TO_B = r101;
        LiveWrappedSAMICoreTokenType r102 = new LiveWrappedSAMICoreTokenType("TOKEN_TO_C_D", 1, 1);
        TOKEN_TO_C_D = r102;
        LiveWrappedSAMICoreTokenType r103 = new LiveWrappedSAMICoreTokenType("TOKEN_TO_B_MIXED", 2, 2);
        TOKEN_TO_B_MIXED = r103;
        f147279a = new LiveWrappedSAMICoreTokenType[]{r101, r102, r103};
        Companion = new a();
        f147280b = new SparseArray();
        LiveWrappedSAMICoreTokenType[] r104 = values();
        int r105 = r104.length;
    L3:
        if (r100 >= r105) goto L5;
        LiveWrappedSAMICoreTokenType r106 = r104[r100];
        f147280b.put(r106.value, r106);
        r100 = r100 + 1;
        goto L3
    }

    public static LiveWrappedSAMICoreTokenType valueOf(String r100) {
        return (LiveWrappedSAMICoreTokenType) r27.a.a(LiveWrappedSAMICoreTokenType.class, r100);
    }

    public static LiveWrappedSAMICoreTokenType[] values() {
        return (LiveWrappedSAMICoreTokenType[]) f147279a.clone();
    }

    public static final /* synthetic */ SparseArray access$getIntToEnumMap$cp() {
        return f147280b;
    }

    public final int getValue() {
        return this.value;
    }

    public LiveWrappedSAMICoreTokenType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
