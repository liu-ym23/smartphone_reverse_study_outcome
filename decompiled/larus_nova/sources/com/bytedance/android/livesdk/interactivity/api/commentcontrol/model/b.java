package com.bytedance.android.livesdk.interactivity.api.commentcontrol.model;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes9.dex */
@ProtoMessage("webcast.api.interaction.GetCommentControlStatusResponse.ResponseData")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/commentcontrol/model/b;", "", "", "status", "J", "d", "()J", "setStatus", "(J)V", "level", "b", "setLevel", "ability", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setAbility", "", "schema", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setSchema", "(Ljava/lang/String;)V", "<init>", "()V", "interactivity-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b implements h {

    @SerializedName("ability_qualification")
    protected long ability;

    @SerializedName("comment_control_level")
    protected long level;

    @SerializedName("schema")
    protected String schema;

    @SerializedName("status")
    protected long status;

    public static final class a {
    }

    static {
    }

    public b() {
        this.schema = "";
    }

    public final long a() {
        return this.ability;
    }

    public final long b() {
        return this.level;
    }

    public final String c() {
        return this.schema;
    }

    public final long d() {
        return this.status;
    }

    public b(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        if (r102 != 1) goto L8;
        this.status = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.level = r100.j();
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.ability = r100.j();
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this.schema = am3.h.c(r100);
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
        if (this.schema != null) goto L37;
        this.schema = "";
        return;
    }
}
