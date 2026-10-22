package com.android.ttcjpaysdk.facelive.data;

import android.text.TextUtils;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.bytedance.android.livehostapi.business.depend.share.LiveFansDataSourceKt;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0012\u0018\u00002\u00020\u00012\u00020\u0002B\u009b\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u0012\b\b\u0002\u0010\n\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\r\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0004¢\u0006\u0002\u0010\u0014J\u0006\u0010\u0015\u001a\u00020\bJ\u0006\u0010\u0016\u001a\u00020\bJ\u0006\u0010\u0017\u001a\u00020\bJ\u0006\u0010\u0018\u001a\u00020\bJ\u0006\u0010\u0019\u001a\u00020\bR\u0012\u0010\n\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/android/ttcjpaysdk/facelive/data/GetTicketResponse;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "code", "", "msg", "ticket", "is_signed", "", "agreement_url", "agreement_desc", "protocol_check_box", "name_mask", "scene", "member_biz_order_no", "live_route", "face_scene", LiveFansDataSourceKt.MAP_KEY_TEXT, "compare_in_cert", "asynchronous_invoke_result", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "hasSrc", "isAILab", "isAliYun", "isNeedCheckBox", "isResponseOK", "bdpay-facecheck_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetTicketResponse implements CJPayObject, Serializable {
    public String agreement_desc;
    public String agreement_url;
    public String asynchronous_invoke_result;
    public String code;
    public String compare_in_cert;
    public String face_scene;
    public boolean is_signed;
    public String live_route;
    public String live_text;
    public String member_biz_order_no;
    public String msg;
    public String name_mask;
    public String protocol_check_box;
    public String scene;
    public String ticket;

    public GetTicketResponse() {
        this(null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, 32767, null);
    }

    public final boolean hasSrc() {
        return TextUtils.equals(this.scene, "cj_live_check");
    }

    public final boolean isAILab() {
        return Intrinsics.areEqual(this.live_route, "AILABFIA");
    }

    public final boolean isAliYun() {
        return Intrinsics.areEqual(this.live_route, "ALIYUNFIA");
    }

    public final boolean isNeedCheckBox() {
        return Intrinsics.areEqual("1", this.protocol_check_box);
    }

    public final boolean isResponseOK() {
        return Intrinsics.areEqual(this.code, "MP000000");
    }

    public GetTicketResponse(String r110, String r111, String r112, boolean r210, String r211, String r212, String r213, String r214, String r215, String r216, String r217, String r218, String r219, String r310, String r311) {
        Intrinsics.checkNotNullParameter(r110, "code");
        Intrinsics.checkNotNullParameter(r111, "msg");
        Intrinsics.checkNotNullParameter(r112, "ticket");
        Intrinsics.checkNotNullParameter(r211, "agreement_url");
        Intrinsics.checkNotNullParameter(r212, "agreement_desc");
        Intrinsics.checkNotNullParameter(r213, "protocol_check_box");
        Intrinsics.checkNotNullParameter(r214, "name_mask");
        Intrinsics.checkNotNullParameter(r215, "scene");
        Intrinsics.checkNotNullParameter(r216, "member_biz_order_no");
        Intrinsics.checkNotNullParameter(r217, "live_route");
        Intrinsics.checkNotNullParameter(r218, "face_scene");
        Intrinsics.checkNotNullParameter(r219, LiveFansDataSourceKt.MAP_KEY_TEXT);
        Intrinsics.checkNotNullParameter(r310, "compare_in_cert");
        Intrinsics.checkNotNullParameter(r311, "asynchronous_invoke_result");
        this.code = r110;
        this.msg = r111;
        this.ticket = r112;
        this.is_signed = r210;
        this.agreement_url = r211;
        this.agreement_desc = r212;
        this.protocol_check_box = r213;
        this.name_mask = r214;
        this.scene = r215;
        this.member_biz_order_no = r216;
        this.live_route = r217;
        this.face_scene = r218;
        this.live_text = r219;
        this.compare_in_cert = r310;
        this.asynchronous_invoke_result = r311;
    }

    public /* synthetic */ GetTicketResponse(String r110, String r111, String r112, boolean r210, String r211, String r212, String r213, String r214, String r215, String r216, String r217, String r218, String r219, String r310, String r311, int r312, DefaultConstructorMarker r313) {
        String r100 = "";
        if ((r312 & 1) == 0) goto L5;
        String r101 = "";
    L7:
        if ((r312 & 2) == 0) goto L9;
        String r102 = "";
    L11:
        if ((r312 & 4) == 0) goto L13;
        String r103 = "";
    L15:
        if ((r312 & 8) == 0) goto L17;
        boolean r104 = false;
    L19:
        if ((r312 & 16) == 0) goto L21;
        String r105 = "";
    L23:
        if ((r312 & 32) == 0) goto L25;
        String r106 = "";
    L27:
        if ((r312 & 64) == 0) goto L29;
        String r107 = "1";
    L31:
        if ((r312 & 128) == 0) goto L33;
        String r108 = "";
    L35:
        if ((r312 & 256) == 0) goto L37;
        String r113 = "";
    L39:
        if ((r312 & 512) == 0) goto L41;
        String r114 = "";
    L43:
        if ((r312 & 1024) == 0) goto L45;
        String r115 = "";
    L47:
        if ((r312 & 2048) == 0) goto L49;
        String r116 = "";
    L51:
        if ((r312 & 4096) == 0) goto L53;
        String r117 = "";
    L55:
        if ((r312 & 8192) == 0) goto L57;
        String r118 = "";
    L59:
        if ((r312 & 16384) != 0) goto L62;
        r100 = r311;
    L62:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r113, r114, r115, r116, r117, r118, r100);
        return;
    L57:
        r118 = r310;
        goto L59
    L53:
        r117 = r219;
        goto L55
    L49:
        r116 = r218;
        goto L51
    L45:
        r115 = r217;
        goto L47
    L41:
        r114 = r216;
        goto L43
    L37:
        r113 = r215;
        goto L39
    L33:
        r108 = r214;
        goto L35
    L29:
        r107 = r213;
        goto L31
    L25:
        r106 = r212;
        goto L27
    L21:
        r105 = r211;
        goto L23
    L17:
        r104 = r210;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
