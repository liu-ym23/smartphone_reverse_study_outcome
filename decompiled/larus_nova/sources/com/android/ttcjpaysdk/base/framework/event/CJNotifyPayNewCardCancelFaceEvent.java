package com.android.ttcjpaysdk.base.framework.event;

import com.android.ttcjpaysdk.base.eventbus.BaseEvent;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B?\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\b\u0010\f\u001a\u0004\u0018\u00010\u0005R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/event/CJNotifyPayNewCardCancelFaceEvent;", "Lcom/android/ttcjpaysdk/base/eventbus/BaseEvent;", "isFaceVerifyCancel", "", "errorCode", "", "errorMsg", "action", "certStatusCode", "", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "buildExt", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJNotifyPayNewCardCancelFaceEvent extends BaseEvent {
    public String action;
    public Integer certStatusCode;
    public String errorCode;
    public String errorMsg;
    public boolean isFaceVerifyCancel;

    public CJNotifyPayNewCardCancelFaceEvent() {
        this(false, null, null, null, null, 31, null);
    }

    public final String buildExt() {
        if (this.errorCode == null) goto L5;
    L9:
        JSONObject r100 = new JSONObject();
        String r101 = this.errorCode;
        String r102 = "";
        if (r101 != null) goto L12;
        r101 = "";
    L12:
        KtSafeMethodExtensionKt.safePut(r100, "error_code", r101);
        String r103 = this.errorMsg;
        if (r103 != null) goto L15;
        r103 = "";
    L15:
        KtSafeMethodExtensionKt.safePut(r100, "error_msg", r103);
        String r104 = this.action;
        if (r104 == null) goto L19;
        r102 = r104;
    L19:
        KtSafeMethodExtensionKt.safePut(r100, "action", r102);
        return r100.toString();
    L5:
        if (this.errorMsg != null) goto L9;
        if (this.action != null) goto L9;
        return null;
    }

    public CJNotifyPayNewCardCancelFaceEvent(boolean r100, String r101, String r102, String r103, Integer r104) {
        this.isFaceVerifyCancel = r100;
        this.errorCode = r101;
        this.errorMsg = r102;
        this.action = r103;
        this.certStatusCode = r104;
    }

    public /* synthetic */ CJNotifyPayNewCardCancelFaceEvent(boolean r100, String r101, String r102, String r103, Integer r104, int r105, DefaultConstructorMarker r110) {
        if ((r105 & 1) == 0) goto L5;
        r100 = false;
    L5:
        Integer r106 = null;
        if ((r105 & 2) == 0) goto L8;
        String r111 = null;
    L10:
        if ((r105 & 4) == 0) goto L12;
        String r107 = null;
    L14:
        if ((r105 & 8) == 0) goto L16;
        String r108 = null;
    L18:
        if ((r105 & 16) != 0) goto L21;
        r106 = r104;
    L21:
        this(r100, r111, r107, r108, r106);
        return;
    L16:
        r108 = r103;
        goto L18
    L12:
        r107 = r102;
        goto L14
    L8:
        r111 = r101;
        goto L10
    }
}
