package com.bytedance.android.livesdk.feed;

import android.text.TextUtils;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.livesdk.feed.feed.FeedDataKey;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.functions.Function4;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public final class a implements Function4<FeedDataKey, List<FeedItem>, Integer, List<FeedItem>, List<FeedItem>> {
    public a() {
    }

    @Override // io.reactivex.functions.Function4
    public final List<FeedItem> apply(FeedDataKey r100, List<FeedItem> r101, Integer r102, List<FeedItem> r103) throws Exception {
        FeedDataKey r104 = r100;
        List<FeedItem> r105 = r101;
        List<FeedItem> r106 = r103;
        if (r104 != null) goto L5;
    L56:
        return r106;
    L5:
        if (TextUtils.isEmpty(r104.f124003a) == true) goto L56;
        if (TextUtils.isEmpty(r104.f124003a) == false) goto L58;
    L10:
        String r107 = null;
    L12:
        if ("5".equals(r107) == false) goto L56;
        int r108 = 0;
        if (CollectionUtils.isEmpty(r105) == true) goto L28;
        int r109 = 0;
        boolean r110 = true;
    L17:
        if (r109 >= r105.size()) goto L30;
        if (((FeedItem) ListProtector.get(r105, r109)).type != 6) goto L27;
        if ((r109 % 2) != 1) goto L24;
        if (r110 == false) goto L26;
        Collections.swap(r105, r109, r109 - 1);
    L26:
        r110 = !r110;
        goto L27
    L24:
        if (r110 == true) goto L26;
        Collections.swap(r105, r109, r109 - 1);
    L27:
        r109 = r109 + 1;
    L30:
        if (CollectionUtils.isEmpty(r106) == true) goto L56;
        if (CollectionUtils.isEmpty(r105) == false) goto L34;
        int r111 = 0;
    L36:
        if (r108 >= r106.size()) goto L56;
        int r112 = r108 + r111;
        if (((FeedItem) ListProtector.get(r106, r108)).type != 6) goto L55;
        if ((r112 % 2) != 1) goto L47;
        if (r110 == false) goto L54;
        if (r108 == 0) goto L44;
    L46:
        Collections.swap(r106, r108, r108 - 1);
        goto L54
    L44:
        if (r108 >= (r106.size() + 1)) goto L46;
        int r113 = r108 + 1;
        Collections.swap(r106, r108, r113);
    L52:
        r108 = r113;
    L54:
        r110 = !r110;
        goto L55
    L47:
        if (r110 == true) goto L54;
        if (r108 == 0) goto L50;
    L53:
        Collections.swap(r106, r108, r108 - 1);
        goto L54
    L50:
        if (r106.size() <= 1) goto L53;
        r113 = r108 + 1;
        Collections.swap(r106, r108, r113);
    L55:
        r108 = r108 + 1;
        goto L36
    L34:
        r111 = r105.size();
        goto L36
    L28:
        r110 = true;
        goto L30
    L58:
        r107 = UriProtector.getQueryParameter(UriProtector.parse(r104.f124003a), "style");     // Catch: Exception -> L57
        goto L12
    }
}
