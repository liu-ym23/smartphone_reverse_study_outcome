package com.bytedance.android.livesdk.live.model;

import android.text.TextUtils;
import com.bytedance.android.livesdk.config.jd0;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\f\b\u0087\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0016B\u001b\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0013\u0010\u0014J\u0006\u0010\u0003\u001a\u00020\u0002J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0006\u001a\u0004\u0018\u00010\u0004HÆ\u0003J!\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\t\u0010\n\u001a\u00020\u0004HÖ\u0001J\t\u0010\f\u001a\u00020\u000bHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u000f\u001a\u0004\b\u0012\u0010\u0011¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/live/model/LiveNotFeedInnerUrl;", "", "", "isValid", "", "component1", "component2", "key", "path", "copy", "toString", "", "hashCode", "other", "equals", "Ljava/lang/String;", "getKey", "()Ljava/lang/String;", "getPath", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveNotFeedInnerUrl {
    public static final a Companion = null;

    @SerializedName("key")
    private final String key;

    @SerializedName("path")
    private final String path;

    public static final class a {
        public a() {
        }

        public static LiveNotFeedInnerUrl a(String r110, String r111) {
            List<? extends LiveNotFeedInnerUrl> r100 = jd0.f120517a.getValue();
            List<? extends LiveNotFeedInnerUrl> r101 = r100;
            boolean r102 = true;
            if (r101 != null) goto L5;
        L8:
            boolean r103 = true;
        L10:
            if (r103 == true) goto L61;
            if (r110 != null) goto L13;
        L16:
            boolean r104 = true;
        L17:
            if (r104 == true) goto L61;
            if (r111 != null) goto L20;
        L23:
            if (r102 == true) goto L61;
            String r112 = r110 + "_" + r111;
            Iterator<? extends LiveNotFeedInnerUrl> r113 = r100.iterator();
            LiveNotFeedInnerUrl r105 = null;
        L27:
            if (r113.hasNext() == false) goto L60;
            LiveNotFeedInnerUrl r106 = r113.next();
            if (r106 == null) goto L31;
            String r107 = r106.getKey();
        L33:
            if (TextUtils.isEmpty(r107) == true) goto L27;
            if (r106 == null) goto L37;
            String r108 = r106.getKey();
        L39:
            if (TextUtils.equals(r108, r112) == true) goto L40;
            if (r106 == null) goto L43;
            String r109 = r106.getKey();
        L45:
            if (r109 != null) goto L47;
        L51:
            if (r106 == null) goto L53;
            String r114 = r106.getKey();
        L54:
            if (r114 == null) goto L27;
            if (StringsKt.endsWith$default(r106.getKey(), "*", false, 2, null) == false) goto L27;
            if (StringsKt.startsWith$default(r112, StringsKt.replace$default(r106.getKey(), "*", "", false, 4, null), false, 2, null) == false) goto L27;
        L59:
            r105 = r106;
            goto L27
        L53:
            r114 = null;
            goto L54
        L47:
            if (StringsKt.startsWith$default(r106.getKey(), "*", false, 2, null) == false) goto L51;
            if (StringsKt.endsWith$default(r112, StringsKt.replace$default(r106.getKey(), "*", "", false, 4, null), false, 2, null) == false) goto L51;
        L43:
            r109 = null;
            goto L45
        L40:
            return r106;
        L37:
            r108 = null;
            goto L39
        L31:
            r107 = null;
            goto L33
        L60:
            return r105;
        L20:
            if (r111.length() == 0) goto L23;
            r102 = false;
            goto L23
        L13:
            if (r110.length() == 0) goto L16;
            r104 = false;
        L61:
            return null;
        L5:
            if (r101.isEmpty() == true) goto L8;
            r103 = false;
            goto L10
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ LiveNotFeedInnerUrl copy$default(LiveNotFeedInnerUrl r100, String r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.key;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.path;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.key;
    }

    public final String component2() {
        return this.path;
    }

    public final LiveNotFeedInnerUrl copy(String r100, String r101) {
        return new LiveNotFeedInnerUrl(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof LiveNotFeedInnerUrl) == false) goto L10;
        LiveNotFeedInnerUrl r101 = (LiveNotFeedInnerUrl) r100;
        if (Intrinsics.areEqual(this.key, r101.key) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.path, r101.path) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        String r100 = this.key;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.path;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "LiveNotFeedInnerUrl(key=" + this.key + ", path=" + this.path + ")";
    }

    public final boolean isValid() {
        int r100 = ln1.a.C6715a.f509979a;
        return ln1.a.C6715a.a(this.path);
    }

    public final String getKey() {
        return this.key;
    }

    public final String getPath() {
        return this.path;
    }

    public LiveNotFeedInnerUrl(String r100, String r101) {
        this.key = r100;
        this.path = r101;
    }
}
