package com.bytedance.android.livesdkapi.livetrace;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R2\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R2\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\b\"\u0004\b\u0013\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdkapi/livetrace/LivePreviewTraceSettingConfig;", "", "()V", "eventList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getEventList", "()Ljava/util/ArrayList;", "setEventList", "(Ljava/util/ArrayList;)V", "open", "", "getOpen", "()Z", "setOpen", "(Z)V", "supportUploadAlog", "getSupportUploadAlog", "setSupportUploadAlog", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LivePreviewTraceSettingConfig {

    @SerializedName("valid_event")
    private ArrayList<String> eventList;

    @SerializedName("is_open")
    private boolean open;

    @SerializedName("support_upload_alog_event")
    private ArrayList<String> supportUploadAlog;

    public LivePreviewTraceSettingConfig() {
    }

    public final ArrayList<String> getEventList() {
        return this.eventList;
    }

    public final boolean getOpen() {
        return this.open;
    }

    public final ArrayList<String> getSupportUploadAlog() {
        return this.supportUploadAlog;
    }

    public final void setEventList(ArrayList<String> r100) {
        this.eventList = r100;
    }

    public final void setOpen(boolean r100) {
        this.open = r100;
    }

    public final void setSupportUploadAlog(ArrayList<String> r100) {
        this.supportUploadAlog = r100;
    }
}
