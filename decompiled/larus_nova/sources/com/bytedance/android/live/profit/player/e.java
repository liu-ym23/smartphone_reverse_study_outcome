package com.bytedance.android.live.profit.player;

import android.content.Context;
import android.graphics.Bitmap;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.message.c5;
import com.bytedance.android.live.profit.dress.config.TextAlignType;
import com.bytedance.android.livesdkapi.depend.live.player.MaskSrc;
import io.reactivex.Single;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes47.dex */
public interface e {

    public static final class a {
        public static /* synthetic */ Single a(e r110, Context r111, String r112, a5 r113, Map r114, TextAlignType r115, String r116, String r210, int r211, o.e r212, int r213) {
            if ((r213 & 128) == 0) goto L5;
            int r117 = -1;
        L7:
            if ((r213 & 256) == 0) goto L9;
            boolean r118 = true;
        L11:
            if ((r213 & 512) == 0) goto L13;
            o.e r119 = null;
        L15:
            return r110.a(r111, r112, r113, r114, r115, r116, r210, r117, r118, r119);
        L13:
            r119 = r212;
            goto L15
        L9:
            r118 = false;
            goto L11
        L5:
            r117 = r211;
            goto L7
        }
    }

    Single<s<List<MaskSrc>>> a(Context r100, String r101, a5 r102, Map<String, ? extends c5> r103, TextAlignType r104, String r105, String r106, int r107, boolean r108, o.e r110);

    Single<s<Bitmap>> b(Context r100, a5 r101, Map<String, ? extends c5> r102, int r103, int r104, TextAlignType r105);
}
