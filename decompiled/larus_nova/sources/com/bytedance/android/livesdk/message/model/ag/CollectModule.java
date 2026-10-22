package com.bytedance.android.livesdk.message.model.ag;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.CollectModule")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R&\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR&\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0007\"\u0004\b\u0016\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/ag/CollectModule;", "", "()V", "delete_list", "", "", "getDelete_list", "()Ljava/util/List;", "setDelete_list", "(Ljava/util/List;)V", "module_id", "", "getModule_id", "()J", "setModule_id", "(J)V", "module_version", "getModule_version", "setModule_version", "update_list", "Lcom/bytedance/android/livesdk/message/model/ag/Highlight;", "getUpdate_list", "setUpdate_list", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CollectModule implements h {

    @SerializedName("delete_list")
    protected List<String> delete_list;

    @SerializedName("module_id")
    protected long module_id;

    @SerializedName("module_version")
    protected long module_version;

    @SerializedName("update_list")
    protected List<Highlight> update_list;

    public CollectModule() {
    }

    public final List<String> getDelete_list() {
        return this.delete_list;
    }

    public final long getModule_id() {
        return this.module_id;
    }

    public final long getModule_version() {
        return this.module_version;
    }

    public final List<Highlight> getUpdate_list() {
        return this.update_list;
    }

    public CollectModule(g r100) {
        this.update_list = new ArrayList();
        this.delete_list = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L19;
        if (r102 != 1) goto L8;
        this.module_id = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.module_version = r100.j();
        goto L3
    L10:
        if (r102 == 3) goto L15;
        if (r102 != 4) goto L13;
        List r103 = this.delete_list;
        Object r104 = am3.h.c(r100);
    L16:
        r103.add(r104);
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L15:
        r103 = this.update_list;
        r104 = new Highlight(r100);
        goto L16
    L19:
        r100.d(r101);
    }

    public final void setDelete_list(List<String> r100) {
        this.delete_list = r100;
    }

    public final void setModule_id(long r100) {
        this.module_id = r100;
    }

    public final void setModule_version(long r100) {
        this.module_version = r100;
    }

    public final void setUpdate_list(List<Highlight> r100) {
        this.update_list = r100;
    }
}
