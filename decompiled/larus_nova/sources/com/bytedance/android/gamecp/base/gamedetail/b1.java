package com.bytedance.android.gamecp.base.gamedetail;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class b1 implements s0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f51554a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f51555b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f51556c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f51557d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f51558e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f51559f;

    @Override // com.bytedance.android.gamecp.base.gamedetail.s0
    public final int a(Context r100) {
        return this.f51559f;
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.s0
    public final int b(Context r100) {
        return this.f51555b;
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.s0
    public final int c(Context r100) {
        return this.f51556c;
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.s0
    public final String d(Context r100) {
        return this.f51554a;
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.s0
    public final String e(Context r100) {
        return this.f51557d;
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.s0
    public final int f(Context r100) {
        return this.f51558e;
    }

    public b1(JSONObject r100, JSONObject r101) {
        int r102 = ColorProtector.parseColor("#CC000000");
        this.f51556c = r102;
        this.f51558e = r102;
        this.f51559f = r102;
        String r103 = null;
        if (r100 == null) goto L5;
        String r104 = r100.optString("text");
    L6:
        this.f51554a = String.valueOf(r104);
        if (r100 == null) goto L9;
        String r105 = r100.optString("sub_text");
    L10:
        this.f51557d = String.valueOf(r105);
        if (r100 == null) goto L14;
        r100.optString("sub_icon");
    L14:
        if (r101 == null) goto L16;
        int r106 = r101.optInt("sub_text_rich_type");
    L17:
        this.f51555b = r106;
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L47
        if (r101 == null) goto L23;
        String r108 = r101.optString("text_color");     // Catch: Throwable -> L47
        if (r108 == null) goto L23;
        String r109 = c1.a(r108);     // Catch: Throwable -> L47
    L25:
        if (TextUtils.isEmpty(r109) == true) goto L27;
        this.f51556c = Color.parseColor(r109);     // Catch: Throwable -> L47
    L28:
        if (r101 == null) goto L32;
        String r110 = r101.optString("sub_text_color");     // Catch: Throwable -> L47
        if (r110 == null) goto L32;
        String r111 = c1.a(r110);     // Catch: Throwable -> L47
    L34:
        if (TextUtils.isEmpty(r111) == true) goto L36;
        this.f51558e = Color.parseColor(r111);     // Catch: Throwable -> L47
    L37:
        if (r101 == null) goto L42;
        String r112 = r101.optString("background_color");     // Catch: Throwable -> L47
        if (r112 == null) goto L42;
        r103 = c1.a(r112);     // Catch: Throwable -> L47
    L42:
        if (TextUtils.isEmpty(r103) == true) goto L44;
        this.f51559f = Color.parseColor(r103);     // Catch: Throwable -> L47
    L45:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L47
        return;
    L44:
        this.f51559f = 0;     // Catch: Throwable -> L47
        goto L45
    L36:
        this.f51558e = 0;     // Catch: Throwable -> L47
    L32:
        r111 = null;
        goto L34
    L27:
        this.f51556c = 0;     // Catch: Throwable -> L47
    L23:
        r109 = null;
    L47:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return;
    L16:
        r106 = 0;
        goto L17
    L9:
        r105 = null;
        goto L10
    L5:
        r104 = null;
        goto L6
    }
}
