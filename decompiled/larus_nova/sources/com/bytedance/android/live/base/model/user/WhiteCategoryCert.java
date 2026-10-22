package com.bytedance.android.live.base.model.user;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.tencent.open.SocialConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0002\u0007\bB\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/base/model/user/WhiteCategoryCert;", "", "()V", "certIcon", "Lcom/bytedance/android/live/base/model/user/WhiteCategoryCert$CertIcon;", "subCertInfo", "Lcom/bytedance/android/live/base/model/user/WhiteCategoryCert$SubCertInfo;", "CertIcon", "SubCertInfo", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WhiteCategoryCert implements vh7.h {

    @SerializedName("cert_icon")
    public CertIcon certIcon;

    @SerializedName("sub_cert_info")
    public SubCertInfo subCertInfo;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/base/model/user/WhiteCategoryCert$CertIcon;", "", "", "text", "Ljava/lang/String;", "Lpy/k;", "icon", "Lpy/k;", "<init>", "()V", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class CertIcon implements vh7.h {

        @SerializedName("icon")
        public py.k icon;

        @SerializedName("text")
        public String text;

        public CertIcon() {
        }

        /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object, py.k] */
        public CertIcon(am3.g r100) {
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L12;
            if (r102 != 1) goto L8;
            this.text = am3.h.c(r100);
            goto L3
        L8:
            if (r102 != 2) goto L9;
            this.icon = vh7.f.a(r100, py.k.class);
            goto L3
        L9:
            am3.h.e(r100);
            goto L3
        L12:
            r100.d(r101);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0007R\u0018\u0010\f\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\f\u0010\nR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u0007R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/base/model/user/WhiteCategoryCert$SubCertInfo;", "", "", "certStatus", "I", "", "name", "Ljava/lang/String;", "Lpy/k;", "smallIcon", "Lpy/k;", "smallIconDesc", "background", SocialConstants.PARAM_APP_DESC, "schema", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class SubCertInfo implements vh7.h {
        public static final int CERT_STATUS_CERTIFIED = 1;
        public static final int CERT_STATUS_NO_CERTIFIED = 0;
        public static final a Companion = null;

        @SerializedName("background")
        public py.k background;

        @SerializedName("cert_status")
        public int certStatus;

        @SerializedName(SocialConstants.PARAM_APP_DESC)
        public String desc;

        @SerializedName("name")
        public String name;

        @SerializedName("schema")
        public String schema;

        @SerializedName("small_icon")
        public py.k smallIcon;

        @SerializedName("small_icon_desc")
        public String smallIconDesc;

        public static final class a {
            public a() {
            }
        }

        static {
            Companion = new a();
        }

        public SubCertInfo() {
        }

        /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Object, py.k] */
        /* JADX WARN: Type inference failed for: r2v7, types: [java.lang.Object, py.k] */
        public SubCertInfo(am3.g r100) {
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L14;
            switch(r102) {
                case 1: goto L13;
                case 2: goto L12;
                case 3: goto L11;
                case 4: goto L10;
                case 5: goto L9;
                case 6: goto L8;
                case 7: goto L7;
                default: goto L6;
            };
        L7:
            this.schema = am3.h.c(r100);
            goto L3
        L8:
            this.desc = am3.h.c(r100);
            goto L3
        L9:
            this.background = vh7.f.a(r100, py.k.class);
            goto L3
        L10:
            this.smallIconDesc = am3.h.c(r100);
            goto L3
        L11:
            this.smallIcon = vh7.f.a(r100, py.k.class);
            goto L3
        L12:
            this.name = am3.h.c(r100);
            goto L3
        L13:
            this.certStatus = r100.i();
            goto L3
        L6:
            am3.h.e(r100);
            goto L3
        L14:
            r100.d(r101);
        }
    }

    public WhiteCategoryCert() {
    }

    public WhiteCategoryCert(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this.certIcon = new CertIcon(r100);
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.subCertInfo = new SubCertInfo(r100);
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
    }
}
