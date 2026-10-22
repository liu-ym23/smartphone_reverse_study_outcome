package com.android.ttcjpaysdk.facelive.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002BK\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0004¢\u0006\u0002\u0010\fR\u0012\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/android/ttcjpaysdk/facelive/data/CJPayFaceCommonLogParams;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "risk_source", "", "guidepage_type", "", "is_pass_guidepage", "user_type", "alivecheck_style", "alivecheck_type", "alivecheck_scene", "(Ljava/lang/String;IILjava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "bdpay-facecheck_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayFaceCommonLogParams implements CJPayObject, Serializable {
    public String alivecheck_scene;
    public int alivecheck_style;
    public String alivecheck_type;
    public int guidepage_type;
    public int is_pass_guidepage;
    public String risk_source;
    public String user_type;

    public CJPayFaceCommonLogParams() {
        this(null, 0, 0, null, 0, null, null, 127, null);
    }

    public CJPayFaceCommonLogParams(String r100, int r101, int r102, String r103, int r104, String r105, String r106) {
        Intrinsics.checkNotNullParameter(r100, "risk_source");
        Intrinsics.checkNotNullParameter(r103, "user_type");
        Intrinsics.checkNotNullParameter(r105, "alivecheck_type");
        Intrinsics.checkNotNullParameter(r106, "alivecheck_scene");
        this.risk_source = r100;
        this.guidepage_type = r101;
        this.is_pass_guidepage = r102;
        this.user_type = r103;
        this.alivecheck_style = r104;
        this.alivecheck_type = r105;
        this.alivecheck_scene = r106;
    }

    public /* synthetic */ CJPayFaceCommonLogParams(String r100, int r101, int r102, String r110, int r111, String r112, String r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 1) == 0) goto L5;
        String r116 = "";
    L7:
        if ((r114 & 2) == 0) goto L9;
        int r103 = 1;
    L11:
        if ((r114 & 4) == 0) goto L13;
        int r104 = 0;
    L15:
        if ((r114 & 8) == 0) goto L17;
        String r105 = "";
    L19:
        if ((r114 & 16) == 0) goto L21;
        int r106 = 0;
    L23:
        if ((r114 & 32) == 0) goto L25;
        String r107 = "";
    L27:
        if ((r114 & 64) == 0) goto L29;
        String r117 = "";
    L30:
        this(r116, r103, r104, r105, r106, r107, r117);
        return;
    L29:
        r117 = r113;
        goto L30
    L25:
        r107 = r112;
        goto L27
    L21:
        r106 = r111;
        goto L23
    L17:
        r105 = r110;
        goto L19
    L13:
        r104 = r102;
        goto L15
    L9:
        r103 = r101;
        goto L11
    L5:
        r116 = r100;
        goto L7
    }
}
