package com.bytedance.android.livesdk.jsbridge.methods;

import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.annotations.SerializedName;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
@XBridgeMethod(biz = "webcast", name = "privilege_wear_notification")
public final class g3 extends com.bytedance.ies.web.jsbridge2.f<b, JSONObject> {

    public static final class a {
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/jsbridge/methods/g3$b;", "", "", "privilegeName", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "toastText", "b", "", "wear_status", "I", "c", "()I", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b {

        @SerializedName("privilege_name")
        private final String privilegeName;

        @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_TASK_TOKEN_TOAST_TEXT)
        private final String toastText;

        @SerializedName("wear_status")
        private final int wear_status;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof b) == false) goto L12;
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.privilegeName, r101.privilegeName) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.toastText, r101.toastText) == true) goto L10;
            return false;
        L10:
            if (this.wear_status == r101.wear_status) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public final int hashCode() {
            String r100 = this.privilegeName;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            String r104 = this.toastText;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return ((r103 + r101) * 31) + this.wear_status;
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "Params(privilegeName=" + this.privilegeName + ", toastText=" + this.toastText + ", wear_status=" + this.wear_status + ")";
        }

        public b() {
            Intrinsics.checkNotNullParameter("", "privilegeName");
            Intrinsics.checkNotNullParameter("", "toastText");
            this.privilegeName = "";
            this.toastText = "";
            this.wear_status = 0;
        }

        public final String a() {
            return this.privilegeName;
        }

        public final String b() {
            return this.toastText;
        }

        public final int c() {
            return this.wear_status;
        }
    }

    static {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public g3() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(b r110, CallContext r111) {
        b r100 = r110;
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r101 = ((IUserService) jc1.k.n(IUserService.class)).user().b().getIdString();
        com.bytedance.android.livesdk.sharedpref.e<Map<String, String>> r102 = com.bytedance.android.livesdk.sharedpref.b.J2;
        Map<String, String> r103 = r102.getValue();
        r103.put(r101, r100.b());
        com.bytedance.android.livesdk.sharedpref.f.d(r102, r103);
        int r104 = r100.c();
        String r105 = r100.a();
        int r106 = r105.hashCode();
        String r107 = "";
        if (r106 == (-1103111423)) goto L13;
        if (r106 == 1025909779) goto L7;
    L19:
        String r112 = "";
    L20:
        int r108 = r100.c();
        String r109 = r100.a();
        int r113 = r109.hashCode();
        if (r113 == (-1103111423)) goto L31;
        if (r113 == 1025909779) goto L25;
    L36:
        String r114 = r107;
        com.bytedance.android.live.profit.privilege.a r115 = yt0.c.i();
        if (r115 == null) goto L40;
        r115.vo(2000, r112, r114, null);
        return;
    L40:
        return;
    L25:
        if (r109.equals("webcast_mystic") == false) goto L36;
        if (r108 != 1) goto L28;
        int r116 = R.string.ttlive_privilege_mystic_open_failed;
    L29:
        r107 = com.bytedance.android.live.core.utils.s1.B(r116);
        goto L36
    L28:
        r116 = R.string.ttlive_privilege_mystic_close_failed;
        goto L29
    L31:
        if (r109.equals("webcast_invisible") == false) goto L36;
        if (r108 != 1) goto L34;
        int r117 = R.string.ttlive_privilege_invisible_open_failed;
    L35:
        r107 = com.bytedance.android.live.core.utils.s1.B(r117);
        goto L36
    L34:
        r117 = R.string.ttlive_privilege_invisible_close_failed;
        goto L35
    L7:
        if (r105.equals("webcast_mystic") == false) goto L19;
        if (r104 != 1) goto L10;
        int r118 = R.string.ttlive_privilege_mystic_opening;
    L11:
        String r119 = com.bytedance.android.live.core.utils.s1.B(r118);
    L18:
        r112 = r119;
        goto L20
    L10:
        r118 = R.string.ttlive_privilege_mystic_closing;
        goto L11
    L13:
        if (r105.equals("webcast_invisible") == false) goto L19;
        if (r104 != 1) goto L16;
        int r120 = R.string.ttlive_privilege_invisible_opening;
    L17:
        r119 = com.bytedance.android.live.core.utils.s1.B(r120);
        goto L18
    L16:
        r120 = R.string.ttlive_privilege_invisible_closing;
        goto L17
    }
}
