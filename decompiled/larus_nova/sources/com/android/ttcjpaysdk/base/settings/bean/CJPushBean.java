package com.android.ttcjpaysdk.base.settings.bean;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.bytedance.common.wschannel.WsConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \f2\u00020\u0001:\u0001\fB/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\u0006\u0010\n\u001a\u00020\u000bR\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/android/ttcjpaysdk/base/settings/bean/CJPushBean;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "action", "", WsConstants.KEY_PAYLOAD, "Lcom/android/ttcjpaysdk/base/settings/bean/CJPushPayLoad;", "create_time", "", "config_id", "(Ljava/lang/String;Lcom/android/ttcjpaysdk/base/settings/bean/CJPushPayLoad;JJ)V", "isFetchSettings", "", "Companion", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPushBean implements CJPayObject {
    public static final String ACTION_FETCH_SETTINGS = "fetch_settings";
    public static final String ACTION_UPDATE_SETTINGS = "update_settings";
    public static final Companion Companion = null;
    public String action;
    public long config_id;
    public long create_time;
    public CJPushPayLoad payload;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/android/ttcjpaysdk/base/settings/bean/CJPushBean$Companion;", "", "()V", "ACTION_FETCH_SETTINGS", "", "ACTION_UPDATE_SETTINGS", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public CJPushBean() {
        this(null, null, 0, 0, 15, null);
    }

    public final boolean isFetchSettings() {
        if (Intrinsics.areEqual(ACTION_FETCH_SETTINGS, this.action) == false) goto L5;
    L8:
        return true;
    L5:
        if (Intrinsics.areEqual(ACTION_UPDATE_SETTINGS, this.action) == true) goto L8;
        return false;
    }

    public CJPushBean(String r100, CJPushPayLoad r101, long r102, long r103) {
        Intrinsics.checkNotNullParameter(r100, "action");
        this.action = r100;
        this.payload = r101;
        this.create_time = r102;
        this.config_id = r103;
    }

    public /* synthetic */ CJPushBean(String r100, CJPushPayLoad r101, long r102, long r103, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r110 & 2) == 0) goto L8;
        r101 = null;
    L8:
        CJPushPayLoad r112 = r101;
        long r104 = 0;
        if ((r110 & 4) == 0) goto L11;
        long r105 = 0;
    L13:
        if ((r110 & 8) != 0) goto L16;
        r104 = r103;
    L16:
        this(r100, r112, r105, r104);
        return;
    L11:
        r105 = r102;
        goto L13
    }
}
