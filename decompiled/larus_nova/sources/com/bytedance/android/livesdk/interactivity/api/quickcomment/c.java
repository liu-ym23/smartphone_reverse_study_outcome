package com.bytedance.android.livesdk.interactivity.api.quickcomment;

import com.bytedance.android.live.base.annotation.ForMain;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import py.k;

/* JADX INFO: loaded from: classes9.dex */
@ForMain
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0005R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\n\u0010\tR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\tR\u0018\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/quickcomment/c;", "", "", "", "fixedChatList", "Ljava/util/List;", "Lcom/bytedance/android/livesdk/interactivity/api/quickcomment/a;", "fixedEmojiList", "titleColor", "Ljava/lang/String;", "textDefaultColor", "textSelectedColor", "Lpy/k;", "cancelIcon", "Lpy/k;", "<init>", "()V", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c implements vh7.h {

    @SerializedName("cancel_icon")
    public k cancelIcon;

    @SerializedName("fixed_chat_list")
    public List<String> fixedChatList;

    @SerializedName("fixed_emoji_list")
    public List<a> fixedEmojiList;

    @SerializedName("text_default_color")
    public String textDefaultColor;

    @SerializedName("text_selected_color")
    public String textSelectedColor;

    @SerializedName("title_color")
    public String titleColor;

    public c() {
        this.textDefaultColor = "";
        this.textSelectedColor = "";
    }

    /* JADX WARN: Type inference failed for: r2v8, types: [java.lang.Object, py.k] */
    public c(am3.g r100) {
        this.fixedChatList = new ArrayList();
        this.fixedEmojiList = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L14;
        switch(r102) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            default: goto L6;
        };
    L7:
        this.cancelIcon = vh7.f.a(r100, k.class);
        goto L3
    L8:
        this.textSelectedColor = am3.h.c(r100);
        goto L3
    L9:
        this.textDefaultColor = am3.h.c(r100);
        goto L3
    L10:
        this.titleColor = am3.h.c(r100);
        goto L3
    L11:
        List r103 = this.fixedEmojiList;
        Object r104 = new a(r100);
    L13:
        r103.add(r104);
        goto L3
    L12:
        r103 = this.fixedChatList;
        r104 = am3.h.c(r100);
        goto L13
    L6:
        am3.h.e(r100);
        goto L3
    L14:
        r100.d(r101);
        if (this.textDefaultColor != null) goto L18;
        this.textDefaultColor = "";
    L18:
        if (this.textSelectedColor != null) goto L36;
        this.textSelectedColor = "";
        return;
    }
}
