package com.bytedance.android.annie.param;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0010\u0000\u001a\u0016\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0012\u0004\u0012\u0002H\u00040\u0001\"\u0004\b\u0000\u0010\u00042\u000e\u0010\u0005\u001a\n \u0003*\u0004\u0018\u00010\u00020\u0002H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "", "kotlin.jvm.PlatformType", ExifInterface.GPS_DIRECTION_TRUE, "key", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3}, xi = 176)
public final class UtilsKt$shallowToMap$1 extends Lambda implements Function1<String, Pair<? extends String, Object>> {
    final /* synthetic */ JsonObject $this_shallowToMap;
    final /* synthetic */ Function2<String, JsonElement, Object> $transformValue;

    /* JADX WARN: Multi-variable type inference failed */
    public UtilsKt$shallowToMap$1(Function2<? super String, ? super JsonElement, Object> r100, JsonObject r101) {
        this.$transformValue = r100;
        this.$this_shallowToMap = r101;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Pair<String, Object> invoke2(String r100) {
        Function2<String, JsonElement, Object> r101 = this.$transformValue;
        JsonElement r102 = this.$this_shallowToMap.get(r100);
        Intrinsics.checkNotNull(r102);
        return new Pair(r100, r101.invoke(r100, r102));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Pair<? extends String, Object> invoke(String r100) {
        return invoke2(r100);
    }
}
