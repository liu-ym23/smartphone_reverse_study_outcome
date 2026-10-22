package com.bytedance.android.live.emoji.online;

import com.bytedance.android.live.emoji.online.model.OnlineSmallEmojiResInfo;
import com.bytedance.android.livehostapi.business.model.emoji.BaseEmoji;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.lark.imagewidget.subsampling.decoder.custom.MSkiaImageRegionDecoder;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010&\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lcom/bytedance/android/livehostapi/business/model/emoji/BaseEmoji;", "it", "", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class HadesEmojiResManager$loadEmoji$2 extends Lambda implements Function1<Map.Entry<? extends String, ? extends String>, BaseEmoji> {
    public static final HadesEmojiResManager$loadEmoji$2 INSTANCE = null;

    static {
        INSTANCE = new HadesEmojiResManager$loadEmoji$2();
    }

    public HadesEmojiResManager$loadEmoji$2() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final BaseEmoji invoke2(Map.Entry<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        BaseEmoji r101 = new BaseEmoji();
        r101.setDescription(r100.getKey());
        LinkedHashMap<String, String> r102 = a.f68922a;
        String r103 = r100.getValue();
        OnlineSmallEmojiResInfo r104 = a.f68924c;
        if (r104 == null) goto L8;
        String r105 = r104.getPicFileDirPath();
        if (r105 == null) goto L8;
        String r106 = MSkiaImageRegionDecoder.FILE_PREFIX + r105 + File.separator + r103;
    L9:
        r101.setLocalFilePath(r106);
        return r101;
    L8:
        r106 = "";
        goto L9
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ BaseEmoji invoke(Map.Entry<? extends String, ? extends String> r100) {
        return invoke2(r100);
    }
}
