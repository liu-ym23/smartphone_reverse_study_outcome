package com.bytedance.android.live.emoji.online;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010&\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class HadesEmojiResManager$loadEmoji$1 extends Lambda implements Function1<Map.Entry<? extends String, ? extends String>, Boolean> {
    final /* synthetic */ boolean $needFilterRecentKeys;

    public HadesEmojiResManager$loadEmoji$1(boolean r100) {
        this.$needFilterRecentKeys = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(Map.Entry<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        if (this.$needFilterRecentKeys == false) goto L7;
        LinkedHashMap<String, String> r101 = a.f68922a;
        if (a.f68923b.contains(r100.getKey()) == false) goto L7;
        return true;
    L7:
        return false;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Map.Entry<? extends String, ? extends String> r100) {
        return Boolean.valueOf(invoke2(r100));
    }
}
