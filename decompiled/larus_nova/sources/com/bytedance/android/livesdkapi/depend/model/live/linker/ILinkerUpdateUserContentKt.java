package com.bytedance.android.livesdkapi.depend.model.live.linker;

import com.alipay.sdk.m.u.i;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0007\"\u0015\u0010\b\u001a\u00020\u0006*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\b\u0010\u0007\"\u0015\u0010\t\u001a\u00020\u0006*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007\"\u0015\u0010\n\u001a\u00020\u0006*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\n\u0010\u0007\"\u0015\u0010\u000b\u001a\u00020\f*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e\"\u0015\u0010\u000f\u001a\u00020\f*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000e\"\u0015\u0010\u0011\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0004\"\u0015\u0010\u0013\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0015"}, d2 = {"fromUserIdString", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerUpdateUserContent;", "getFromUserIdString", "(Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerUpdateUserContent;)Ljava/lang/String;", "isBackground", "", "(Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerUpdateUserContent;)Z", "isBackgroundStatusUpdate", "isMcStatusUpdate", "isSilenceStatusUpdate", "mcStatus", "", "getMcStatus", "(Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerUpdateUserContent;)I", "silenceStatus", "getSilenceStatus", "toUserIdString", "getToUserIdString", "updateInfoStr", "getUpdateInfoStr", "live-model-api_saasRelease"}, k = 2, mv = {1, 5, 1})
public final class ILinkerUpdateUserContentKt {
    public static final String getFromUserIdString(ILinkerUpdateUserContent r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$fromUserIdString");
        return String.valueOf(r100.getFromUid());
    }

    public static final int getMcStatus(ILinkerUpdateUserContent r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$mcStatus");
        Map<String, String> r101 = r100.getUpdateInfo();
        if (r101 != null) goto L6;
        return -1;
    L6:
        if (r101.containsKey("McStatus") == false) goto L11;
        String r102 = r101.get("McStatus");
        if (r102 != null) goto L10;
        return -1;
    L10:
        return CastIntegerProtector.parseInt(r102);
    L11:
        return -1;
    }

    public static final int getSilenceStatus(ILinkerUpdateUserContent r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$silenceStatus");
        if (r100.getUpdateInfo() != null) goto L5;
        return -1;
    L5:
        Map<String, String> r101 = r100.getUpdateInfo();
        Intrinsics.checkNotNull(r101);
        String r102 = r101.get("SilenceStatus");
        if (r102 != null) goto L8;
    L25:
        return -1;
    L8:
        if (r102.length() == 0) goto L25;
        if (Intrinsics.areEqual(r102, String.valueOf(0)) == false) goto L14;
        return 0;
    L14:
        if (Intrinsics.areEqual(r102, String.valueOf(1)) == false) goto L17;
        return 1;
    L17:
        if (Intrinsics.areEqual(r102, String.valueOf(2)) == false) goto L20;
        return 2;
    L20:
        if (Intrinsics.areEqual(r102, String.valueOf(3)) == false) goto L23;
        return 3;
    L23:
        if (Intrinsics.areEqual(r102, String.valueOf(4)) == false) goto L25;
        return 4;
    }

    public static final String getToUserIdString(ILinkerUpdateUserContent r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$toUserIdString");
        return String.valueOf(r100.getToUid());
    }

    public static final String getUpdateInfoStr(ILinkerUpdateUserContent r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$updateInfoStr");
        return "UpdateContent{version:" + r100.getVersion() + ",fromUid:" + r100.getFromUid() + ",toUid:" + r100.getToUid() + ",updateInfo:" + r100.getUpdateInfo() + i.f25855d;
    }

    public static final boolean isBackground(ILinkerUpdateUserContent r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isBackground");
        Map<String, String> r101 = r100.getUpdateInfo();
        if (r101 == null) goto L5;
        String r102 = r101.get("IsBackground");
    L7:
        return Intrinsics.areEqual("1", r102);
    L5:
        r102 = null;
        goto L7
    }

    public static final boolean isBackgroundStatusUpdate(ILinkerUpdateUserContent r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isBackgroundStatusUpdate");
        Map<String, String> r101 = r100.getUpdateInfo();
        if (r101 != null) goto L5;
    L7:
        return false;
    L5:
        if (r101.containsKey("IsBackground") != true) goto L7;
        return true;
    }

    public static final boolean isMcStatusUpdate(ILinkerUpdateUserContent r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isMcStatusUpdate");
        Map<String, String> r101 = r100.getUpdateInfo();
        if (r101 != null) goto L5;
    L7:
        return false;
    L5:
        if (r101.containsKey("McStatus") != true) goto L7;
        return true;
    }

    public static final boolean isSilenceStatusUpdate(ILinkerUpdateUserContent r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isSilenceStatusUpdate");
        Map<String, String> r101 = r100.getUpdateInfo();
        if (r101 != null) goto L5;
    L7:
        return false;
    L5:
        if (r101.containsKey("SilenceStatus") != true) goto L7;
        return true;
    }
}
