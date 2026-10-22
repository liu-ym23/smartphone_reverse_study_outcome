package com.android.ttcjpaysdk.ocr.data;

import androidx.compose.ui.spatial.RectListKt;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0019\u0018\u00002\u00020\u00012\u00020\u0002B\u0089\u0002\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u0012\b\b\u0002\u0010\n\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\r\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0011\u001a\u00020\b\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u001d\u001a\u00020\b\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0004¢\u0006\u0002\u0010 R\u0012\u0010\u000e\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001c\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001a\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0019\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001b\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001d\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0018\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0016\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001e\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/android/ttcjpaysdk/ocr/data/CJOCRSettingsConfig;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "idType", "", "scanNumber", "", "isIdCardType", "", "profileIcon", "emblemIcon", "optTipsProfileContent", "optTipsEmblemContent", "profileEmptyIcon", "emblemEmptyIcon", "profileFillIcon", "emblemFillIcon", "isProfileIconLeft", "scanLightIcon", "scanWidth", "scanHeight", "profileTopPadding", "profileHorPadding", "profileWidth", "profileHeight", "emblemTopPadding", "emblemLeftPadding", "emblemWidth", "emblemHeight", "needCapture", "successContent", "failContent", "(Ljava/lang/String;IZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;IIIIIIIIIIZLjava/lang/String;Ljava/lang/String;)V", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJOCRSettingsConfig implements CJPayObject, Serializable {
    public String emblemEmptyIcon;
    public String emblemFillIcon;
    public int emblemHeight;
    public String emblemIcon;
    public int emblemLeftPadding;
    public int emblemTopPadding;
    public int emblemWidth;
    public String failContent;
    public String idType;
    public boolean isIdCardType;
    public boolean isProfileIconLeft;
    public boolean needCapture;
    public String optTipsEmblemContent;
    public String optTipsProfileContent;
    public String profileEmptyIcon;
    public String profileFillIcon;
    public int profileHeight;
    public int profileHorPadding;
    public String profileIcon;
    public int profileTopPadding;
    public int profileWidth;
    public int scanHeight;
    public String scanLightIcon;
    public int scanNumber;
    public int scanWidth;
    public String successContent;

    public CJOCRSettingsConfig() {
        this(null, 0, false, null, null, null, null, null, null, null, null, false, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, false, null, null, RectListKt.Lower26Bits, null);
    }

    public CJOCRSettingsConfig(String r110, int r111, boolean r112, String r113, String r114, String r210, String r211, String r212, String r213, String r214, String r215, boolean r216, String r217, int r218, int r219, int r310, int r311, int r312, int r313, int r314, int r315, int r316, int r317, boolean r318, String r319, String r410) {
        Intrinsics.checkNotNullParameter(r110, "idType");
        Intrinsics.checkNotNullParameter(r113, "profileIcon");
        Intrinsics.checkNotNullParameter(r114, "emblemIcon");
        Intrinsics.checkNotNullParameter(r210, "optTipsProfileContent");
        Intrinsics.checkNotNullParameter(r211, "optTipsEmblemContent");
        Intrinsics.checkNotNullParameter(r212, "profileEmptyIcon");
        Intrinsics.checkNotNullParameter(r213, "emblemEmptyIcon");
        Intrinsics.checkNotNullParameter(r214, "profileFillIcon");
        Intrinsics.checkNotNullParameter(r215, "emblemFillIcon");
        Intrinsics.checkNotNullParameter(r217, "scanLightIcon");
        Intrinsics.checkNotNullParameter(r319, "successContent");
        Intrinsics.checkNotNullParameter(r410, "failContent");
        this.idType = r110;
        this.scanNumber = r111;
        this.isIdCardType = r112;
        this.profileIcon = r113;
        this.emblemIcon = r114;
        this.optTipsProfileContent = r210;
        this.optTipsEmblemContent = r211;
        this.profileEmptyIcon = r212;
        this.emblemEmptyIcon = r213;
        this.profileFillIcon = r214;
        this.emblemFillIcon = r215;
        this.isProfileIconLeft = r216;
        this.scanLightIcon = r217;
        this.scanWidth = r218;
        this.scanHeight = r219;
        this.profileTopPadding = r310;
        this.profileHorPadding = r311;
        this.profileWidth = r312;
        this.profileHeight = r313;
        this.emblemTopPadding = r314;
        this.emblemLeftPadding = r315;
        this.emblemWidth = r316;
        this.emblemHeight = r317;
        this.needCapture = r318;
        this.successContent = r319;
        this.failContent = r410;
    }

    public /* synthetic */ CJOCRSettingsConfig(String r210, int r211, boolean r310, String r311, String r312, String r313, String r314, String r315, String r316, String r317, String r318, boolean r319, String r410, int r411, int r412, int r413, int r414, int r415, int r416, int r417, int r418, int r419, int r510, boolean r511, String r512, String r513, int r514, DefaultConstructorMarker r515) {
        String r100 = "";
        if ((r514 & 1) == 0) goto L5;
        String r101 = "";
    L7:
        if ((r514 & 2) == 0) goto L9;
        int r102 = 1;
    L11:
        if ((r514 & 4) == 0) goto L13;
        boolean r103 = false;
    L15:
        if ((r514 & 8) == 0) goto L17;
        String r104 = "";
    L19:
        if ((r514 & 16) == 0) goto L21;
        String r105 = "";
    L23:
        if ((r514 & 32) == 0) goto L25;
        String r106 = "请扫描证件正面";
    L27:
        if ((r514 & 64) == 0) goto L29;
        String r107 = "请扫描证件反面";
    L31:
        if ((r514 & 128) == 0) goto L33;
        String r110 = "";
    L35:
        if ((r514 & 256) == 0) goto L37;
        String r111 = "";
    L39:
        if ((r514 & 512) == 0) goto L41;
        String r112 = "";
    L43:
        if ((r514 & 1024) != 0) goto L47;
        r100 = r318;
    L47:
        if ((r514 & 2048) == 0) goto L49;
        boolean r113 = false;
    L51:
        if ((r514 & 4096) == 0) goto L53;
        String r114 = "cj_pay_ocr_scan_line";
    L55:
        if ((r514 & 8192) == 0) goto L57;
        int r115 = 327;
    L59:
        if ((r514 & 16384) == 0) goto L61;
        int r108 = 212;
    L63:
        if ((r514 & 32768) == 0) goto L65;
        int r116 = 0;
    L67:
        if ((r514 & 65536) == 0) goto L69;
        int r117 = 0;
    L71:
        if ((r514 & 131072) == 0) goto L73;
        int r118 = 0;
    L75:
        if ((r514 & 262144) == 0) goto L77;
        int r119 = 0;
    L79:
        if ((r514 & 524288) == 0) goto L81;
        int r212 = 0;
    L83:
        if ((r514 & 1048576) == 0) goto L85;
        int r213 = 0;
    L87:
        if ((r514 & 2097152) == 0) goto L89;
        int r214 = 0;
    L91:
        if ((r514 & 4194304) == 0) goto L93;
        int r215 = 0;
    L95:
        if ((r514 & 8388608) == 0) goto L97;
        boolean r216 = false;
    L99:
        if ((r514 & 16777216) == 0) goto L101;
        String r217 = "上传成功";
    L103:
        if ((r514 & 33554432) == 0) goto L105;
        String r109 = "识别失败";
    L106:
        this(r101, r102, r103, r104, r105, r106, r107, r110, r111, r112, r100, r113, r114, r115, r108, r116, r117, r118, r119, r212, r213, r214, r215, r216, r217, r109);
        return;
    L105:
        r109 = r513;
        goto L106
    L101:
        r217 = r512;
        goto L103
    L97:
        r216 = r511;
        goto L99
    L93:
        r215 = r510;
        goto L95
    L89:
        r214 = r419;
        goto L91
    L85:
        r213 = r418;
        goto L87
    L81:
        r212 = r417;
        goto L83
    L77:
        r119 = r416;
        goto L79
    L73:
        r118 = r415;
        goto L75
    L69:
        r117 = r414;
        goto L71
    L65:
        r116 = r413;
        goto L67
    L61:
        r108 = r412;
        goto L63
    L57:
        r115 = r411;
        goto L59
    L53:
        r114 = r410;
        goto L55
    L49:
        r113 = r319;
        goto L51
    L41:
        r112 = r317;
        goto L43
    L37:
        r111 = r316;
        goto L39
    L33:
        r110 = r315;
        goto L35
    L29:
        r107 = r314;
        goto L31
    L25:
        r106 = r313;
        goto L27
    L21:
        r105 = r312;
        goto L23
    L17:
        r104 = r311;
        goto L19
    L13:
        r103 = r310;
        goto L15
    L9:
        r102 = r211;
        goto L11
    L5:
        r101 = r210;
        goto L7
    }
}
