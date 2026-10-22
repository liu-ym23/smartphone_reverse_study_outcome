package com.android.ttcjpaysdk.base.settings.bean;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.ktextension.CJSchemaExtensionKt;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0018\b\u0002\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006¢\u0006\u0002\u0010\u0007J\u001a\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\n0\tH\u0002J\u001c\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00052\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fR \u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/android/ttcjpaysdk/base/settings/bean/CJPayAnnieToWebConfig;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "white_list", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "(Ljava/util/ArrayList;)V", "getWhiteListAllowedConfig", "", "Lkotlin/Pair;", "isAllowCJWeb", "", "url", "expose", "Lkotlin/Function0;", "", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayAnnieToWebConfig implements CJPayObject, Serializable {
    public final ArrayList<String> white_list;

    /* JADX WARN: Multi-variable type inference failed */
    public CJPayAnnieToWebConfig() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    private final List<Pair<String, String>> getWhiteListAllowedConfig() {
        ArrayList r100 = new ArrayList();
        Iterator<T> r101 = this.white_list.iterator();
    L4:
        if (r101.hasNext() == false) goto L15;
        List r102 = StringsKt.split$default((String) r101.next(), new String[]{" "}, false, 0, 6, null);
        Iterator r103 = r102.iterator();
    L7:
        if (r103.hasNext() == false) goto L10;
        StringsKt.replace$default((String) r103.next(), " ", "", false, 4, null);
        goto L7
    L10:
        if (2 != r102.size()) goto L4;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L13
        Result.m9449constructorimpl(Boolean.valueOf(r100.add(new Pair(CollectionsKt.first(r102), CollectionsKt.last(r102)))));     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L4
    L15:
        return r100;
    }

    public CJPayAnnieToWebConfig(ArrayList<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "white_list");
        this.white_list = r100;
    }

    public final boolean isAllowCJWeb(String r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "expose");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L12
        Iterator<T> r103 = getWhiteListAllowedConfig().iterator();     // Catch: Throwable -> L12
    L5:
        if (r103.hasNext() == false) goto L10;
        Pair r104 = (Pair) r103.next();     // Catch: Throwable -> L12
        if (Intrinsics.areEqual(CJSchemaExtensionKt.clearQuery(r100), r104.getFirst()) == false) goto L5;
        r101.invoke();     // Catch: Throwable -> L12
        return Intrinsics.areEqual("1", r104.getSecond());
    L10:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L12
        return false;
    L12:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return false;
    }

    public /* synthetic */ CJPayAnnieToWebConfig(ArrayList r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = new ArrayList();
    L5:
        this(r100);
    }
}
