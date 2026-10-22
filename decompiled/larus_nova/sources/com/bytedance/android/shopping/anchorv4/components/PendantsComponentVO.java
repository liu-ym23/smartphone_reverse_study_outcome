package com.bytedance.android.shopping.anchorv4.components;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.shopping.anchorv4.dto.adapter.JsonToStringAdapter;
import com.bytedance.android.shopping.anchorv4.dto.business.ComponentDTO;
import com.bytedance.android.shopping.anchorv4.dto.business.VO;
import com.google.gson.JsonObject;
import com.google.gson.annotations.JsonAdapter;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u0000 !2\u00020\u0001:\u0001\"B7\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u001f\u0010 J\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0004\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0003J9\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\t\u0010\u000e\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0010\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0015\u001a\u0004\b\u0018\u0010\u0017R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\f\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006#"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/components/PendantsComponentVO;", "Ljava/io/Serializable;", "", "component1", "component2", "Lcom/bytedance/android/shopping/anchorv4/components/Frame;", "component3", "Lcom/bytedance/android/shopping/anchorv4/components/Timing;", "component4", "schema", "data", "frame", "timing", "copy", "toString", "", "hashCode", "", "other", "", "equals", "Ljava/lang/String;", "getSchema", "()Ljava/lang/String;", "getData", "Lcom/bytedance/android/shopping/anchorv4/components/Frame;", "getFrame", "()Lcom/bytedance/android/shopping/anchorv4/components/Frame;", "Lcom/bytedance/android/shopping/anchorv4/components/Timing;", "getTiming", "()Lcom/bytedance/android/shopping/anchorv4/components/Timing;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/shopping/anchorv4/components/Frame;Lcom/bytedance/android/shopping/anchorv4/components/Timing;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PendantsComponentVO implements Serializable {
    public static final a Companion = null;

    @JsonAdapter(JsonToStringAdapter.class)
    private final String data;
    private final Frame frame;
    private final String schema;
    private final Timing timing;

    public static final class a {
        public a() {
        }

        public static Map a(ComponentDTO r100) {
            LinkedHashMap r101 = new LinkedHashMap();
            Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L20
            if (r100 == null) goto L17;
            VO r103 = r100.getVo();     // Catch: Throwable -> L20
            if (r103 == null) goto L17;
            JsonObject r104 = r103.getDisplay();     // Catch: Throwable -> L20
            if (r104 == null) goto L17;
            JsonObject r105 = r104.getAsJsonObject("pendants");     // Catch: Throwable -> L20
            if (r105 == null) goto L17;
            Set<String> r106 = r105.keySet();     // Catch: Throwable -> L20
            if (r106 == null) goto L18;
            Iterator<T> r107 = r106.iterator();     // Catch: Throwable -> L20
        L15:
            if (r107.hasNext() == false) goto L18;
            String r108 = (String) r107.next();     // Catch: Throwable -> L20
            r101.put(r108, u0.b(r105.get(r108).toString(), PendantsComponentVO.class));     // Catch: Throwable -> L20
        L18:
            Object r109 = Result.m9449constructorimpl(r105);     // Catch: Throwable -> L20
        L22:
            Throwable r110 = Result.m9452exceptionOrNullimpl(r109);
            if (r110 == null) goto L25;
            ECExceptionMonitor.e(r110);
        L25:
            return r101;
        L17:
            r105 = null;
        L20:
            th = move-exception;
            Result.Companion r111 = Result.Companion;
            r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L22
        }
    }

    static {
        Companion = new a();
    }

    public PendantsComponentVO() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ PendantsComponentVO copy$default(PendantsComponentVO r100, String r101, String r102, Frame r103, Timing r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.schema;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.data;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.frame;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.timing;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.schema;
    }

    public final String component2() {
        return this.data;
    }

    public final Frame component3() {
        return this.frame;
    }

    public final Timing component4() {
        return this.timing;
    }

    public final PendantsComponentVO copy(String r100, String r101, Frame r102, Timing r103) {
        return new PendantsComponentVO(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof PendantsComponentVO) == false) goto L14;
        PendantsComponentVO r101 = (PendantsComponentVO) r100;
        if (Intrinsics.areEqual(this.schema, r101.schema) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.data, r101.data) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.frame, r101.frame) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.timing, r101.timing) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        String r100 = this.schema;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.data;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Frame r107 = this.frame;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Timing r110 = this.timing;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "PendantsComponentVO(schema=" + this.schema + ", data=" + this.data + ", frame=" + this.frame + ", timing=" + this.timing + ")";
    }

    public final String getData() {
        return this.data;
    }

    public final Frame getFrame() {
        return this.frame;
    }

    public final String getSchema() {
        return this.schema;
    }

    public final Timing getTiming() {
        return this.timing;
    }

    public PendantsComponentVO(String r100, String r101, Frame r102, Timing r103) {
        this.schema = r100;
        this.data = r101;
        this.frame = r102;
        this.timing = r103;
    }

    public /* synthetic */ PendantsComponentVO(String r100, String r101, Frame r102, Timing r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
