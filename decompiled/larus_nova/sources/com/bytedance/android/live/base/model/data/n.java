package com.bytedance.android.live.base.model.data;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\r\u0010\u000eR\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\bR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/live/base/model/data/n;", "", "", "Lcom/bytedance/android/live/base/model/data/n$a;", "templateList", "Ljava/util/List;", "", "templatePanelTitle", "Ljava/lang/String;", "photoPanelTitle", "Lpy/k;", "bgPhoto", "Lpy/k;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class n implements vh7.h {

    @SerializedName("bg_photo")
    public py.k bgPhoto;

    @SerializedName("photo_panel_title")
    public String photoPanelTitle;

    @SerializedName(MusicAppletPage.SOURCE_TEMPLATE_LIST)
    public List<a> templateList;

    @SerializedName("template_panel_title")
    public String templatePanelTitle;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u0004¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/live/base/model/data/n$a;", "", "", GXTemplateKey.GAIAX_TEMPLATE_ID, "Ljava/lang/String;", "Lpy/k;", "templatePhoto", "Lpy/k;", "authorName", "templateTitle", "", "supportReplace", "Ljava/lang/Boolean;", "replaceContent", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class a implements vh7.h {

        @SerializedName("author_name")
        public String authorName;

        @SerializedName("replace_content")
        public String replaceContent;

        @SerializedName("support_replace")
        public Boolean supportReplace;

        @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_TEMPLATE_ID)
        public String templateId;

        @SerializedName("template_photo")
        public py.k templatePhoto;

        @SerializedName("template_title")
        public String templateTitle;

        public a() {
        }

        /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object, py.k] */
        public a(am3.g r100) {
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L13;
            switch(r102) {
                case 1: goto L12;
                case 2: goto L11;
                case 3: goto L10;
                case 4: goto L9;
                case 5: goto L8;
                case 6: goto L7;
                default: goto L6;
            };
        L7:
            this.replaceContent = am3.h.c(r100);
            goto L3
        L8:
            this.supportReplace = Boolean.valueOf(am3.h.a(r100));
            goto L3
        L9:
            this.templateTitle = am3.h.c(r100);
            goto L3
        L10:
            this.authorName = am3.h.c(r100);
            goto L3
        L11:
            this.templatePhoto = vh7.f.a(r100, py.k.class);
            goto L3
        L12:
            this.templateId = am3.h.c(r100);
            goto L3
        L6:
            am3.h.e(r100);
            goto L3
        L13:
            r100.d(r101);
        }

        public final String toString() {
            return "TemplateInfo(templateId=" + this.templateId + ", templatePhoto=" + this.templatePhoto + ", authorName=" + this.authorName + ", templateTitle=" + this.templateTitle + ", supportReplace=" + this.supportReplace + ", replaceContent=" + this.replaceContent + ')';
        }
    }

    public n() {
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object, py.k] */
    public n(am3.g r100) {
        this.templateList = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        if (r102 != 1) goto L8;
        this.templateList.add(new a(r100));
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.templatePanelTitle = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.photoPanelTitle = am3.h.c(r100);
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this.bgPhoto = vh7.f.a(r100, py.k.class);
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
    }

    public final List<a> a() {
        List<a> r100 = this.templateList;
        if (r100 == null) goto L22;
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L6:
        if (r102.hasNext() == false) goto L29;
        Object r103 = r102.next();
        a r104 = (a) r103;
        py.k r105 = r104.templatePhoto;
        boolean r106 = false;
        if (r105 != null) goto L10;
    L20:
        if (r106 == false) goto L6;
        r101.add(r103);
        goto L6
    L10:
        if (r105.isValid() != true) goto L20;
        String r107 = r104.templateId;
        if (r107 != null) goto L14;
    L17:
        boolean r108 = true;
    L18:
        if (r108 == true) goto L20;
        r106 = true;
        goto L20
    L14:
        if (r107.length() == 0) goto L17;
        r108 = false;
        goto L18
    L29:
        return r101;
    L22:
        return null;
    }

    public final String toString() {
        return "TemplatePhotoJumpDetail(templateList=" + this.templateList + ", templatePanelTitle=" + this.templatePanelTitle + ", photoPanelTitle=" + this.photoPanelTitle + ", bgPhoto=" + this.bgPhoto + ')';
    }
}
