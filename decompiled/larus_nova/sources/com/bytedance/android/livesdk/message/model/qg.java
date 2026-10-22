package com.bytedance.android.livesdk.message.model;

import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.common.utility.Logger;
import com.bytedance.ee.bear.document.customheader.CustomHeaderConfig;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.NotifyMessage.ContentList")
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/qg;", "", "", "color", "Ljava/lang/String;", "getColor", "()Ljava/lang/String;", "b", "(Ljava/lang/String;)V", "", "Lcom/bytedance/android/livesdk/chatroom/model/l2;", "contents", "Ljava/util/List;", "getContents", "()Ljava/util/List;", "c", "(Ljava/util/List;)V", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class qg implements vh7.h {

    @SerializedName("high_light_color")
    protected String color;

    @SerializedName("contents")
    protected List<com.bytedance.android.livesdk.chatroom.model.l2> contents;

    public qg() {
    }

    public qg(am3.g r100) {
        this.contents = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this.contents.add(new com.bytedance.android.livesdk.chatroom.model.l2(r100));
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.color = am3.h.c(r100);
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
    }

    public final CharSequence a() {
        List<com.bytedance.android.livesdk.chatroom.model.l2> r100 = this.contents;
        if (r100 == null) goto L28;
        Intrinsics.checkNotNull(r100);
        boolean r101 = true;
        if (r100.size() < 1) goto L43;
        String r102 = this.color;
        if (r102 != null) goto L30;
    L13:
        int r103 = -1;
        r101 = false;
    L14:
        SpannableStringBuilder r104 = new SpannableStringBuilder();
        ForegroundColorSpan r105 = new ForegroundColorSpan(r103);
        List<com.bytedance.android.livesdk.chatroom.model.l2> r106 = this.contents;
        Intrinsics.checkNotNull(r106);
        Iterator<com.bytedance.android.livesdk.chatroom.model.l2> r107 = r106.iterator();
    L16:
        if (r107.hasNext() == false) goto L27;
        com.bytedance.android.livesdk.chatroom.model.l2 r108 = r107.next();
        if (r108 == null) goto L16;
        if (TextUtils.isEmpty(r108.a()) == true) goto L16;
        r104.append(r108.a());
        if (r101 == false) goto L16;
        if (r108.b() == false) goto L16;
        String r109 = r108.a();
        Intrinsics.checkNotNull(r109);
        int r110 = r109.length();
        r104.setSpan(r105, r104.length() - r110, r104.length(), 33);
        goto L16
    L27:
        return r104;
    L30:
        r103 = Color.parseColor(r102);     // Catch: IllegalArgumentException -> L11
    L11:
        e = move-exception;
        Logger.e(e.toString());
        goto L13
    L43:
        return "";
    L28:
        return "";
    }

    public final void b(String r100) {
        this.color = CustomHeaderConfig.COLOR_LIGHT;
    }

    public final void c(List<com.bytedance.android.livesdk.chatroom.model.l2> r100) {
        this.contents = r100;
    }
}
