package com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.live.model;

import android.text.TextUtils;
import com.bytedance.android.live.core.utils.ListUtils;
import com.bytedance.android.livesdk.config.em;
import com.google.gson.annotations.SerializedName;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes12.dex */
@Deprecated(message = "弃用")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0006\u0010\u0014\u001a\u00020\u0010J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/live/model/LiveConvergeInnerUrl;", "", "key", "", "reqFrom", "innerUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getInnerUrl", "()Ljava/lang/String;", "getKey", "getReqFrom", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "isValid", "toString", "Companion", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveConvergeInnerUrl {
    public static final Companion Companion = null;

    @SerializedName("inner_url")
    private final String innerUrl;

    @SerializedName("key")
    private final String key;

    @SerializedName("req_from")
    private final String reqFrom;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/live/model/LiveConvergeInnerUrl$Companion;", "", "()V", "getInnerUrlSetting", "Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/live/model/LiveConvergeInnerUrl;", "enterMerge", "", "enterMethod", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final LiveConvergeInnerUrl getInnerUrlSetting(String r110, String r111) {
            List<? extends LiveConvergeInnerUrl> r100 = em.f120138a.getValue();
            if (ListUtils.isEmpty(r100) == false) goto L5;
        L45:
            return null;
        L5:
            if (TextUtils.isEmpty(r110) == true) goto L45;
            if (TextUtils.isEmpty(r111) == true) goto L45;
            String r112 = r110 + "_" + r111;
            Iterator<? extends LiveConvergeInnerUrl> r113 = r100.iterator();
            LiveConvergeInnerUrl r101 = null;
        L11:
            if (r113.hasNext() == false) goto L44;
            LiveConvergeInnerUrl r102 = r113.next();
            if (r102 == null) goto L15;
            String r103 = r102.getKey();
        L17:
            if (TextUtils.isEmpty(r103) == true) goto L11;
            if (r102 == null) goto L21;
            String r104 = r102.getKey();
        L23:
            if (TextUtils.equals(r104, r112) == true) goto L24;
            if (r102 == null) goto L27;
            String r105 = r102.getKey();
        L29:
            if (r105 != null) goto L31;
        L35:
            if (r102 == null) goto L37;
            String r106 = r102.getKey();
        L38:
            if (r106 == null) goto L11;
            if (StringsKt.endsWith$default(r102.getKey(), "*", false, 2, null) == false) goto L11;
            if (StringsKt.startsWith$default(r112, StringsKt.replace$default(r102.getKey(), "*", "", false, 4, null), false, 2, null) == false) goto L11;
        L43:
            r101 = r102;
            goto L11
        L37:
            r106 = null;
            goto L38
        L31:
            if (StringsKt.startsWith$default(r102.getKey(), "*", false, 2, null) == false) goto L35;
            if (StringsKt.endsWith$default(r112, StringsKt.replace$default(r102.getKey(), "*", "", false, 4, null), false, 2, null) == false) goto L35;
        L27:
            r105 = null;
            goto L29
        L24:
            return r102;
        L21:
            r104 = null;
            goto L23
        L15:
            r103 = null;
            goto L17
        L44:
            return r101;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ LiveConvergeInnerUrl copy$default(LiveConvergeInnerUrl r100, String r101, String r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.key;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.reqFrom;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.innerUrl;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.key;
    }

    public final String component2() {
        return this.reqFrom;
    }

    public final String component3() {
        return this.innerUrl;
    }

    public final LiveConvergeInnerUrl copy(String r100, String r101, String r102) {
        return new LiveConvergeInnerUrl(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof LiveConvergeInnerUrl) == false) goto L12;
        LiveConvergeInnerUrl r101 = (LiveConvergeInnerUrl) r100;
        if (Intrinsics.areEqual(this.key, r101.key) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.reqFrom, r101.reqFrom) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.innerUrl, r101.innerUrl) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        String r100 = this.key;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.reqFrom;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.innerUrl;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "LiveConvergeInnerUrl(key=" + this.key + ", reqFrom=" + this.reqFrom + ", innerUrl=" + this.innerUrl + ")";
    }

    public final boolean isValid() {
        if (LiveConvergeInnerUrlKt.access$isNotNullOrEmpty(this.innerUrl) == true) goto L5;
    L7:
        return false;
    L5:
        if (LiveConvergeInnerUrlKt.access$isNotNullOrEmpty(this.reqFrom) == false) goto L7;
        return true;
    }

    public final String getInnerUrl() {
        return this.innerUrl;
    }

    public final String getKey() {
        return this.key;
    }

    public final String getReqFrom() {
        return this.reqFrom;
    }

    public LiveConvergeInnerUrl(String r100, String r101, String r102) {
        this.key = r100;
        this.reqFrom = r101;
        this.innerUrl = r102;
    }
}
