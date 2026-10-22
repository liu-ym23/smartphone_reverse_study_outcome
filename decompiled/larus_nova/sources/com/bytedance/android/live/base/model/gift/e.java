package com.bytedance.android.live.base.model.gift;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@ProtoMessage("webcast.api.gift.ExhibitionNotice")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/base/model/gift/e;", "", "", "id", "J", "getId", "()J", "", "schema", "Ljava/lang/String;", "getSchema", "()Ljava/lang/String;", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class e implements vh7.h {

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    protected long f58834id;

    @SerializedName("schema")
    protected String schema;

    public e() {
        this.f58834id = 0;
        this.schema = "";
    }

    public e(am3.g r100) {
        long r101 = r100.c();
        boolean r102 = false;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L11;
        if (r103 != 1) goto L7;
        this.f58834id = r100.j();
        r102 = r102 | true;
        goto L3
    L7:
        if (r103 != 2) goto L8;
        this.schema = am3.h.c(r100);
        goto L3
    L8:
        am3.h.e(r100);
        goto L3
    L11:
        r100.d(r101);
        if ((r102 & true) == true) goto L15;
        this.f58834id = 0;
    L15:
        if (this.schema != null) goto L27;
        this.schema = "";
        return;
    }
}
