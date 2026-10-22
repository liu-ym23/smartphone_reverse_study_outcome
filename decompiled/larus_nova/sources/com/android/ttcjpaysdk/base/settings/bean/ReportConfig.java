package com.android.ttcjpaysdk.base.settings.bean;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import ke4.a;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u001b\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\b\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016R\u0016\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/android/ttcjpaysdk/base/settings/bean/ReportConfig;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "Lke4/a;", "", "eventName", "", "isBlackTeaEvent", "isBlackSlardarEvent", "Lcom/android/ttcjpaysdk/base/settings/bean/SlardarConfig;", "slardar_config", "Lcom/android/ttcjpaysdk/base/settings/bean/SlardarConfig;", "Lcom/android/ttcjpaysdk/base/settings/bean/TeaConfig;", "tea_config", "Lcom/android/ttcjpaysdk/base/settings/bean/TeaConfig;", "<init>", "(Lcom/android/ttcjpaysdk/base/settings/bean/SlardarConfig;Lcom/android/ttcjpaysdk/base/settings/bean/TeaConfig;)V", "base-context_release"}, k = 1, mv = {1, 6, 0})
public final class ReportConfig implements CJPayObject, Serializable, a {
    public SlardarConfig slardar_config;
    public TeaConfig tea_config;

    /* JADX WARN: Multi-variable type inference failed */
    public ReportConfig() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    @Override // ke4.a
    public boolean isBlackSlardarEvent(String r100) {
        if (r100 == null) goto L4;
        Boolean r101 = Boolean.valueOf(StringsKt.isBlank(r100));
    L5:
        if (r101 == null) goto L7;
        boolean r102 = r101.booleanValue();
    L8:
        if (r102 == false) goto L11;
        return false;
    L11:
        ArrayList<BlackConfig> r103 = this.slardar_config.black_list;
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator<T> r105 = r103.iterator();
    L13:
        if (r105.hasNext() == false) goto L16;
        r104.add(((BlackConfig) r105.next()).event_name);
        goto L13
    L16:
        return CollectionsKt.contains(r104, r100);
    L7:
        r102 = true;
        goto L8
    L4:
        r101 = null;
        goto L5
    }

    @Override // ke4.a
    public boolean isBlackTeaEvent(String r100) {
        if (r100 == null) goto L4;
        Boolean r101 = Boolean.valueOf(StringsKt.isBlank(r100));
    L5:
        if (r101 == null) goto L7;
        boolean r102 = r101.booleanValue();
    L8:
        if (r102 == false) goto L11;
        return false;
    L11:
        ArrayList<BlackConfig> r103 = this.tea_config.black_list;
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator<T> r105 = r103.iterator();
    L13:
        if (r105.hasNext() == false) goto L16;
        r104.add(((BlackConfig) r105.next()).event_name);
        goto L13
    L16:
        return CollectionsKt.contains(r104, r100);
    L7:
        r102 = true;
        goto L8
    L4:
        r101 = null;
        goto L5
    }

    public ReportConfig(SlardarConfig r100, TeaConfig r101) {
        Intrinsics.checkNotNullParameter(r100, "slardar_config");
        Intrinsics.checkNotNullParameter(r101, "tea_config");
        this.slardar_config = r100;
        this.tea_config = r101;
    }

    public /* synthetic */ ReportConfig(SlardarConfig r100, TeaConfig r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = new SlardarConfig();
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = new TeaConfig();
    L8:
        this(r100, r101);
    }
}
