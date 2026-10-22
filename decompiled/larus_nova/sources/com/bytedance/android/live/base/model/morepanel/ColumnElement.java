package com.bytedance.android.live.base.model.morepanel;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import vh7.h;

/* JADX INFO: loaded from: classes45.dex */
@ProtoMessage("webcast.api.room.ColumnData")
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0011\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u0013\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016R*\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/live/base/model/morepanel/ColumnElement;", "", "other", "", "equals", "", "hashCode", "", "widgetIds", "Ljava/util/List;", "getWidgetIds", "()Ljava/util/List;", "setWidgetIds", "(Ljava/util/List;)V", "type", "Ljava/lang/Integer;", "getType", "()Ljava/lang/Integer;", "setType", "(Ljava/lang/Integer;)V", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ColumnElement implements h {
    public static final a Companion = null;
    public static final int typeBasic = 1;
    public static final int typeExtend = 2;
    public static final int typeLocalSimpleDivider = 1001;
    public static final int typeLocalToolbar = 1000;
    public static final int typeUnknown = 0;

    @SerializedName("type")
    protected Integer type;

    @SerializedName("widget_ids")
    protected List<Integer> widgetIds;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public int hashCode() {
        List<Integer> r100 = this.widgetIds;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.type;
        if (r104 == null) goto L10;
        r101 = r104.intValue();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public ColumnElement() {
        this.widgetIds = CollectionsKt.emptyList();
        this.type = 0;
    }

    public final Integer getType() {
        return this.type;
    }

    public final List<Integer> getWidgetIds() {
        return this.widgetIds;
    }

    public ColumnElement(g r100) {
        this.widgetIds = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this.type = Integer.valueOf(r100.i());
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.widgetIds.add(Integer.valueOf(r100.i()));
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
        if (this.widgetIds.isEmpty() == false) goto L16;
        this.widgetIds = CollectionsKt.emptyList();
    L16:
        if (this.type != null) goto L28;
        this.type = 0;
        return;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if ((!Intrinsics.areEqual(ColumnElement.class, r101)) == false) goto L12;
        return false;
    L12:
        if (r100 == null) goto L21;
        ColumnElement r102 = (ColumnElement) r100;
        if ((!Intrinsics.areEqual(this.widgetIds, r102.widgetIds)) == false) goto L17;
        return false;
    L17:
        if ((!Intrinsics.areEqual(this.type, r102.type)) == false) goto L19;
        return false;
    L19:
        return true;
    L21:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.base.model.morepanel.ColumnElement");
    L8:
        r101 = null;
        goto L10
    }

    public final void setType(Integer r100) {
        this.type = r100;
    }

    public final void setWidgetIds(List<Integer> r100) {
        this.widgetIds = r100;
    }
}
