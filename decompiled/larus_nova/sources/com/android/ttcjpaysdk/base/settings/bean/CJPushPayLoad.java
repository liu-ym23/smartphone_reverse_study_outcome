package com.android.ttcjpaysdk.base.settings.bean;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/android/ttcjpaysdk/base/settings/bean/CJPushPayLoad;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "deploy_id", "", "item_id", "data", "Lorg/json/JSONObject;", "(JJLorg/json/JSONObject;)V", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPushPayLoad implements CJPayObject {
    public JSONObject data;
    public long deploy_id;
    public long item_id;

    public CJPushPayLoad() {
        this(0, 0, null, 7, null);
    }

    public CJPushPayLoad(long r100, long r101, JSONObject r102) {
        this.deploy_id = r100;
        this.item_id = r101;
        this.data = r102;
    }

    public /* synthetic */ CJPushPayLoad(long r100, long r101, JSONObject r102, int r110, DefaultConstructorMarker r111) {
        long r103 = 0;
        if ((r110 & 1) == 0) goto L5;
        long r104 = 0;
    L7:
        if ((r110 & 2) != 0) goto L11;
        r103 = r101;
    L11:
        if ((r110 & 4) == 0) goto L13;
        r102 = null;
    L13:
        this(r104, r103, r102);
        return;
    L5:
        r104 = r100;
        goto L7
    }
}
