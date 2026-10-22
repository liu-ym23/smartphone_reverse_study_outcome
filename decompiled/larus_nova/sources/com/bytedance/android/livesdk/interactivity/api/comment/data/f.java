package com.bytedance.android.livesdk.interactivity.api.comment.data;

import android.graphics.Bitmap;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import py.k;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\r¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/comment/data/f;", "", "", "type", "I", "", "status", "J", "Lpy/k;", "icon", "Lpy/k;", "", "text", "Ljava/lang/String;", "schema", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class f implements vh7.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Bitmap f133040a;

    @SerializedName("icon")
    public k icon;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_SCHEMA_URL)
    public String schema;

    @SerializedName("status")
    public long status;

    @SerializedName("display_text")
    public String text;

    @SerializedName("type")
    public int type;

    public static final class a {
    }

    static {
    }

    public f() {
        this.status = 2;
        this.text = "";
        this.schema = "";
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Object, py.k] */
    public f(am3.g r100) {
        long r101 = r100.c();
        boolean r102 = false;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L15;
        if (r103 != 1) goto L7;
        this.type = r100.i();
        goto L3
    L7:
        if (r103 != 2) goto L8;
        this.status = r100.i();
        r102 = r102 | true;
        goto L3
    L8:
        switch(r103) {
            case 21: goto L12;
            case 22: goto L11;
            case 23: goto L10;
            default: goto L9;
        };
    L10:
        this.schema = am3.h.c(r100);
        goto L3
    L11:
        this.text = am3.h.c(r100);
        goto L3
    L12:
        this.icon = vh7.f.a(r100, k.class);
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
        if ((r102 & true) == true) goto L19;
        this.status = 2;
    L19:
        if (this.text != null) goto L22;
        this.text = "";
    L22:
        if (this.schema != null) goto L41;
        this.schema = "";
        return;
    }
}
