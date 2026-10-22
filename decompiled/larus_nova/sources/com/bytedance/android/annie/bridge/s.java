package com.bytedance.android.annie.bridge;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0003\n\u0005\u000fB\u0007¢\u0006\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/annie/bridge/s;", "", "Lcom/bytedance/android/annie/bridge/s$b;", "pageUI", "Lcom/bytedance/android/annie/bridge/s$b;", "b", "()Lcom/bytedance/android/annie/bridge/s$b;", "Lcom/bytedance/android/annie/bridge/s$a;", "commonInteraction", "Lcom/bytedance/android/annie/bridge/s$a;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/annie/bridge/s$a;", "Lcom/bytedance/android/annie/bridge/s$c;", "popupInteraction", "Lcom/bytedance/android/annie/bridge/s$c;", "c", "()Lcom/bytedance/android/annie/bridge/s$c;", "<init>", "()V", "annie_release"}, k = 1, mv = {1, 4, 3})
public final class s {

    @SerializedName("commonInteraction")
    private final a commonInteraction;

    @SerializedName("pageUI")
    private final b pageUI;

    @SerializedName("popupInteraction")
    private final c popupInteraction;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/bytedance/android/annie/bridge/s$a;", "", "", "disableBackPress", "Ljava/lang/Integer;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Integer;", "disableNativeClose", "Ljava/lang/Object;", "b", "()Ljava/lang/Object;", "<init>", "()V", "annie_release"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("disableBackPress")
        private final Integer disableBackPress;

        @SerializedName("disableNativeClose")
        private final Object disableNativeClose;

        public a() {
        }

        public final Integer a() {
            return this.disableBackPress;
        }

        public final Object b() {
            return this.disableNativeClose;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/annie/bridge/s$b;", "", "", "title", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "titleColor", ce.f26391f, "navBarColor", "b", "statusBarBgColor", "c", "statusFontMode", "e", "", "statusBarHidden", "Ljava/lang/Integer;", "d", "()Ljava/lang/Integer;", "bottomNavigationBarHidden", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "<init>", "()V", "annie_release"}, k = 1, mv = {1, 4, 3})
    public static final class b {

        @SerializedName("bottomNavigationBarHidden")
        private final Integer bottomNavigationBarHidden;

        @SerializedName("navBarColor")
        private final String navBarColor;

        @SerializedName("statusBarBgColor")
        private final String statusBarBgColor;

        @SerializedName("statusBarHidden")
        private final Integer statusBarHidden;

        @SerializedName("statusFontMode")
        private final String statusFontMode;

        @SerializedName("title")
        private final String title;

        @SerializedName("titleColor")
        private final String titleColor;

        public b() {
        }

        public final Integer a() {
            return this.bottomNavigationBarHidden;
        }

        public final String b() {
            return this.navBarColor;
        }

        public final String c() {
            return this.statusBarBgColor;
        }

        public final Integer d() {
            return this.statusBarHidden;
        }

        public final String e() {
            return this.statusFontMode;
        }

        public final String f() {
            return this.title;
        }

        public final String g() {
            return this.titleColor;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/annie/bridge/s$c;", "", "", "disableMaskClickClose", "Ljava/lang/Integer;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Integer;", "enablePullDownClose", "b", "<init>", "()V", "annie_release"}, k = 1, mv = {1, 4, 3})
    public static final class c {

        @SerializedName("disableMaskClickClose")
        private final Integer disableMaskClickClose;

        @SerializedName("enablePullDownClose")
        private final Integer enablePullDownClose;

        public c() {
        }

        public final Integer a() {
            return this.disableMaskClickClose;
        }

        public final Integer b() {
            return this.enablePullDownClose;
        }
    }

    public s() {
    }

    public final a a() {
        return this.commonInteraction;
    }

    public final b b() {
        return this.pageUI;
    }

    public final c c() {
        return this.popupInteraction;
    }
}
