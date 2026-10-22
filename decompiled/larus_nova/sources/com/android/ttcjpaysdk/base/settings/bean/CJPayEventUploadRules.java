package com.android.ttcjpaysdk.base.settings.bean;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/android/ttcjpaysdk/base/settings/bean/CJPayEventUploadRules;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "is_hit_event_upload_sampled", "", "(Z)V", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayEventUploadRules implements CJPayObject, Serializable {
    public boolean is_hit_event_upload_sampled;

    public CJPayEventUploadRules() {
        boolean r100 = false;
        this(r100, 1, null);
    }

    public CJPayEventUploadRules(boolean r100) {
        this.is_hit_event_upload_sampled = r100;
    }

    public /* synthetic */ CJPayEventUploadRules(boolean r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = false;
    L5:
        this(r100);
    }
}
