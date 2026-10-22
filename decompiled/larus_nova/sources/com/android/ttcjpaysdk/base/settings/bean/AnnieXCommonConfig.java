package com.android.ttcjpaysdk.base.settings.bean;

import android.net.Uri;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.bytedance.mt.protector.impl.UriProtector;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002BW\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\u0018\b\u0002\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u0012\u0018\b\u0002\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0004¢\u0006\u0002\u0010\fJ\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0007J\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0007J\u0006\u0010\u0010\u001a\u00020\u0004R\"\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\"\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/android/ttcjpaysdk/base/settings/bean/AnnieXCommonConfig;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "enable_annie_card", "", "annie_card_allow_url_list", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "enable_annie_live_card", "annie_live_card_allow_url_list", "live_card_to_anniex_live_card", "(ZLjava/util/ArrayList;ZLjava/util/ArrayList;Z)V", "enableAnnieXLiveCard", "schema", "isAllowAnnieXCard", "liveCardToAnnieXLiveCard", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AnnieXCommonConfig implements CJPayObject, Serializable {
    public ArrayList<String> annie_card_allow_url_list;
    public ArrayList<String> annie_live_card_allow_url_list;
    public boolean enable_annie_card;
    public boolean enable_annie_live_card;
    public boolean live_card_to_anniex_live_card;

    public AnnieXCommonConfig() {
        this(false, null, false, null, false, 31, null);
    }

    public final boolean liveCardToAnnieXLiveCard() {
        return this.live_card_to_anniex_live_card;
    }

    public final boolean enableAnnieXLiveCard(String r100) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        if (this.enable_annie_live_card == false) goto L22;
        Uri r101 = UriProtector.parse(r100);
        String r102 = UriProtector.getQueryParameter(r101, "url");
        if (r102 == null) goto L22;
        if (StringsKt.isBlank(r102) == false) goto L13;
        String r103 = UriProtector.getQueryParameter(r101, "surl");
        if (r103 != null) goto L11;
        r103 = "";
    L11:
        r102 = r103;
    L13:
        if (StringsKt.isBlank(r102) == false) goto L15;
        return false;
    L15:
        Iterator<T> r104 = this.annie_live_card_allow_url_list.iterator();
    L17:
        if (r104.hasNext() == false) goto L22;
        if (StringsKt.endsWith$default(r102, (String) r104.next(), false, 2, null) == false) goto L17;
        return true;
    L22:
        return false;
    }

    public final boolean isAllowAnnieXCard(String r100) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        if (this.enable_annie_card == false) goto L22;
        Uri r101 = UriProtector.parse(r100);
        String r102 = UriProtector.getQueryParameter(r101, "url");
        if (r102 == null) goto L22;
        if (StringsKt.isBlank(r102) == false) goto L13;
        String r103 = UriProtector.getQueryParameter(r101, "surl");
        if (r103 != null) goto L11;
        r103 = "";
    L11:
        r102 = r103;
    L13:
        if (StringsKt.isBlank(r102) == false) goto L15;
        return false;
    L15:
        Iterator<T> r104 = this.annie_card_allow_url_list.iterator();
    L17:
        if (r104.hasNext() == false) goto L22;
        if (StringsKt.endsWith$default(r102, (String) r104.next(), false, 2, null) == false) goto L17;
        return true;
    L22:
        return false;
    }

    public AnnieXCommonConfig(boolean r100, ArrayList<String> r101, boolean r102, ArrayList<String> r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r101, "annie_card_allow_url_list");
        Intrinsics.checkNotNullParameter(r103, "annie_live_card_allow_url_list");
        this.enable_annie_card = r100;
        this.annie_card_allow_url_list = r101;
        this.enable_annie_live_card = r102;
        this.annie_live_card_allow_url_list = r103;
        this.live_card_to_anniex_live_card = r104;
    }

    public /* synthetic */ AnnieXCommonConfig(boolean r100, ArrayList r101, boolean r102, ArrayList r103, boolean r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        boolean r112 = false;
    L7:
        if ((r110 & 2) == 0) goto L9;
        r101 = new ArrayList();
    L9:
        ArrayList r105 = r101;
        if ((r110 & 4) == 0) goto L12;
        boolean r106 = false;
    L14:
        if ((r110 & 8) == 0) goto L16;
        r103 = new ArrayList();
    L16:
        ArrayList r107 = r103;
        if ((r110 & 16) == 0) goto L19;
        boolean r113 = false;
    L20:
        this(r112, r105, r106, r107, r113);
        return;
    L19:
        r113 = r104;
        goto L20
    L12:
        r106 = r102;
        goto L14
    L5:
        r112 = r100;
        goto L7
    }
}
