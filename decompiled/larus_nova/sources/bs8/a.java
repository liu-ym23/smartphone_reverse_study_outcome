package bs8;

import com.larus.utils.logger.FLogger;
import com.ss.texturerender.effect.ICEffect.ICEffectKeys;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final C0354a f20295h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f20296a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f20297b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f20298c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f20299d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f20300e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f20301f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f20302g;

    /* JADX INFO: renamed from: bs8.a$a, reason: collision with other inner class name */
    public static final class C0354a {
        public C0354a() {
        }

        public static a a(String r110) {
            if (r110 != null) goto L5;
        L8:
            boolean r100 = true;
        L9:
            Object r101 = null;
            if (r100 == false) goto L41;
            return null;
        L41:
            Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L30
            JSONObject r103 = new JSONObject(new JSONObject(r110).optString("agent_task_param"));     // Catch: Throwable -> L30
            String r111 = r103.optString(ICEffectKeys.KEY_IS_IC_EFFECT_DEVICE_NAME);     // Catch: Throwable -> L30
            Intrinsics.checkNotNull(r111);     // Catch: Throwable -> L30
            if ((!StringsKt.isBlank(r111)) == false) goto L15;
            String r104 = r111;
        L16:
            String r112 = r103.optString("folder_name");     // Catch: Throwable -> L30
            Intrinsics.checkNotNull(r112);     // Catch: Throwable -> L30
            if ((!StringsKt.isBlank(r112)) == false) goto L19;
            String r105 = r112;
        L20:
            int r113 = r103.optInt("runtime_type");     // Catch: Throwable -> L30
            String r106 = r103.optString("local_device_id");     // Catch: Throwable -> L30
            Intrinsics.checkNotNull(r106);     // Catch: Throwable -> L30
            if ((!StringsKt.isBlank(r106)) == false) goto L23;
            String r107 = r106;
        L24:
            String r108 = r103.optString("workspace");     // Catch: Throwable -> L30
            Intrinsics.checkNotNull(r108);     // Catch: Throwable -> L30
            if ((true ^ StringsKt.isBlank(r108)) == false) goto L27;
            String r109 = r108;
        L28:
            Object r114 = Result.m9449constructorimpl(new a(r104, r105, Integer.valueOf(r113), r109, r107, null, null, 96));     // Catch: Throwable -> L30
        L33:
            if (Result.m9452exceptionOrNullimpl(r114) == null) goto L36;
            FLogger.f375446a.w("ConversationAgentTaskParam", "[fromExt] parse ext failed");
        L36:
            if (Result.m9455isFailureimpl(r114) == true) goto L40;
            r101 = r114;
        L40:
            return (a) r101;
        L27:
            r109 = null;
            goto L28
        L23:
            r107 = null;
            goto L24
        L19:
            r105 = null;
            goto L20
        L15:
            r104 = null;
        L30:
            th = move-exception;
            Result.Companion r115 = Result.Companion;
            r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L33
        L5:
            if (StringsKt.isBlank(r110) == true) goto L8;
            r100 = false;
            goto L9
        }
    }

    public a() {
        this(null, null, null, null, null, null, null, 127);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f20296a, r101.f20296a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f20297b, r101.f20297b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f20298c, r101.f20298c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f20299d, r101.f20299d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f20300e, r101.f20300e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f20301f, r101.f20301f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f20302g, r101.f20302g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f20296a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f20297b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.f20298c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f20299d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f20300e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f20301f;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.f20302g;
        if (r119 == null) goto L31;
        r101 = r119.hashCode();
    L31:
        return r118 + r101;
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ConversationAgentTaskParam(deviceName=" + this.f20296a + ", folderName=" + this.f20297b + ", runtimeType=" + this.f20298c + ", workspace=" + this.f20299d + ", localPcDeviceId=" + this.f20300e + ", connectPcDeviceType=" + this.f20301f + ", localAppId=" + this.f20302g + ')';
    }

    static {
        f20295h = new C0354a();
    }

    public final boolean b() {
        Integer r100 = this.f20298c;
        if (r100 != null) goto L6;
    L8:
        return false;
    L6:
        if (r100.intValue() != 1) goto L8;
        return true;
    }

    public final boolean c() {
        Integer r100 = this.f20298c;
        if (r100 != null) goto L6;
    L8:
        return false;
    L6:
        if (r100.intValue() != 2) goto L8;
        return true;
    }

    public a(String r100, String r101, Integer r102, String r103, String r104, String r105, String r106) {
        this.f20296a = r100;
        this.f20297b = r101;
        this.f20298c = r102;
        this.f20299d = r103;
        this.f20300e = r104;
        this.f20301f = r105;
        this.f20302g = r106;
    }

    public static a a(a r100, String r101, Integer r110, String r111, String r112, String r113, int r114) {
        if ((r114 & 1) == 0) goto L5;
        r101 = r100.f20296a;
    L5:
        String r102 = r101;
        if ((r114 & 2) == 0) goto L8;
        String r103 = r100.f20297b;
    L10:
        if ((r114 & 4) == 0) goto L12;
        r110 = r100.f20298c;
    L12:
        Integer r104 = r110;
        if ((r114 & 8) == 0) goto L15;
        String r105 = r100.f20299d;
    L17:
        if ((r114 & 16) == 0) goto L19;
        r111 = r100.f20300e;
    L19:
        String r106 = r111;
        if ((r114 & 32) == 0) goto L22;
        r112 = r100.f20301f;
    L22:
        String r107 = r112;
        if ((r114 & 64) == 0) goto L26;
        r113 = r100.f20302g;
    L26:
        return new a(r102, r103, r104, r105, r106, r107, r113);
    L15:
        r105 = null;
        goto L17
    L8:
        r103 = null;
        goto L10
    }

    public /* synthetic */ a(String r100, String r101, Integer r110, String r111, String r112, String r113, String r114, int r115) {
        if ((r115 & 1) == 0) goto L5;
        String r102 = null;
    L7:
        if ((r115 & 2) == 0) goto L9;
        String r103 = null;
    L11:
        if ((r115 & 4) == 0) goto L13;
        Integer r104 = null;
    L15:
        if ((r115 & 8) == 0) goto L17;
        String r105 = null;
    L19:
        if ((r115 & 16) == 0) goto L21;
        String r106 = null;
    L23:
        if ((r115 & 32) == 0) goto L25;
        String r107 = null;
    L27:
        if ((r115 & 64) == 0) goto L29;
        String r116 = null;
    L30:
        this(r102, r103, r104, r105, r106, r107, r116);
        return;
    L29:
        r116 = r114;
        goto L30
    L25:
        r107 = r113;
        goto L27
    L21:
        r106 = r112;
        goto L23
    L17:
        r105 = r111;
        goto L19
    L13:
        r104 = r110;
        goto L15
    L9:
        r103 = r101;
        goto L11
    L5:
        r102 = r100;
        goto L7
    }
}
