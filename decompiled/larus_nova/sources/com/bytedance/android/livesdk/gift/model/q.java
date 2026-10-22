package com.bytedance.android.livesdk.gift.model;

import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\bg\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001aR*\u0010\n\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R$\u0010\u0011\u001a\u0004\u0018\u00010\u000b8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0010\u0010\t\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0018\u001a\u00020\u00128&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0017\u0010\t\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/q;", "Lvh7/c;", "Lcom/bytedance/android/live/base/model/message/a5;", "Lcom/bytedance/android/live/base/model/message/ITextKt;", "getText", "()Lcom/bytedance/android/live/base/model/message/a5;", "setText", "(Lcom/bytedance/android/live/base/model/message/a5;)V", "getText$annotations", "()V", "text", "", "getSchema", "()Ljava/lang/String;", "setSchema", "(Ljava/lang/String;)V", "getSchema$annotations", "schema", "", "getLocked", "()Z", "setLocked", "(Z)V", "getLocked$annotations", "locked", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface q extends vh7.c<q> {
    public static final a Companion = null;
    public static final String LOCKED = "locked";
    public static final String UNLOCKED = "unlocked";

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f126404a = null;

        public a() {
        }

        static {
            f126404a = new a();
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class b {
    }

    static {
        Companion = a.f126404a;
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "locked")
    boolean getLocked();

    @FieldName(name = "schema")
    String getSchema();

    @FieldName(name = "text")
    a5 getText();

    @FieldName(name = "locked#setter")
    void setLocked(boolean r100);

    @FieldName(name = "schema#setter")
    void setSchema(String r100);

    @FieldName(name = "text#setter")
    void setText(a5 r100);
}
