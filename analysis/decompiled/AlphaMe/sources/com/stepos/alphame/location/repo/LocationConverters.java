package com.stepos.alphame.location.repo;

import F1.n;
import androidx.room.TypeConverter;
import com.baidu.mapapi.http.wrapper.annotation.BodyData;
import com.google.gson.reflect.TypeToken;
import com.stepos.alphame.location.FrequentWifi;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0007¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/stepos/alphame/location/repo/LocationConverters;", "", "", "Lcom/stepos/alphame/location/FrequentWifi;", "list", "", "objectToString", "(Ljava/util/List;)Ljava/lang/String;", BodyData.TYPE_JSON, "stringToObject", "(Ljava/lang/String;)Ljava/util/List;", "LF1/n;", "gson", "LF1/n;", "<init>", "()V", "app_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes.dex */
public final class LocationConverters {

    @NotNull
    private final n gson = new n();

    @TypeConverter
    @NotNull
    public final String objectToString(@NotNull List<FrequentWifi> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        String strG = this.gson.g(list);
        Intrinsics.checkNotNullExpressionValue(strG, "toJson(...)");
        return strG;
    }

    @TypeConverter
    @NotNull
    public final List<FrequentWifi> stringToObject(@Nullable String json) {
        Type type = new TypeToken<List<? extends FrequentWifi>>() { // from class: com.stepos.alphame.location.repo.LocationConverters$stringToObject$listType$1
        }.getType();
        Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
        Object objD = this.gson.d(json, type);
        Intrinsics.checkNotNullExpressionValue(objD, "fromJson(...)");
        return (List) objD;
    }
}
