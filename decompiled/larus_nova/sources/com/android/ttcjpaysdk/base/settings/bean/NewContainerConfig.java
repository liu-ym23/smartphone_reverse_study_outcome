package com.android.ttcjpaysdk.base.settings.bean;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.ktextension.CJSchemaExtensionKt;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0018\u0018\u00002\u00020\u00012\u00020\u0002B\u0091\u0002\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\u0018\b\u0002\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u0012\u0018\b\u0002\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0004\u0012\u0018\b\u0002\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b\u0012\u0018\b\u0002\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b\u0012\u0018\b\u0002\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b\u0012\u0018\b\u0002\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0004\u0012\u0018\b\u0002\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b\u0012\u0018\b\u0002\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b¢\u0006\u0002\u0010\u0016J\u0006\u0010\u0017\u001a\u00020\u0004J\u000e\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0007J\u0006\u0010\u001a\u001a\u00020\rJ\u000e\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0007J\u000e\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0007J\u000e\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0007J\u0010\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0007H\u0002J\u000e\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0007J\u0010\u0010 \u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0007H\u0002J\u0006\u0010!\u001a\u00020\u0004J\u000e\u0010\"\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0007J\u000e\u0010#\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0007J\u000e\u0010$\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0007R\"\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\"\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\"\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/android/ttcjpaysdk/base/settings/bean/NewContainerConfig;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "enable", "", "url_prefix_block_list", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "cjweb_hybrid_enable", "cjweb_hybrid_url_block_list", "disable_alog", "color_diff", "", "disable_blank_detect", "cjweb_hybrid_url_allow_list", "cjweb_annie_url_allow_list", "cj_annie_url_allow_list", "cj_annie_prefix_url_allow_list", "is_cjweb_to_annie_jsb_adapt", "cjweb_xjsb_url_allow_list", "annie_url_black_list", "(ZLjava/util/ArrayList;ZLjava/util/ArrayList;ZIZLjava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;ZLjava/util/ArrayList;Ljava/util/ArrayList;)V", "enableDetectBlank", "enableXJSBUrl", "url", "getBlankColorDiff", "isAnnieXBlackUrl", "isAnnieXPrefixMatchUrl", "isAnnieXUrl", "isBlackUrl", "isDispatchAnnieXUrl", "isOldContainerBlackUrl", "isOpenH52AnnieJSBAdapt", "isWhiteUrl", "newContainerEnable", "newKernelEnable", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NewContainerConfig implements CJPayObject, Serializable {
    public ArrayList<String> annie_url_black_list;
    public ArrayList<String> cj_annie_prefix_url_allow_list;
    public ArrayList<String> cj_annie_url_allow_list;
    public ArrayList<String> cjweb_annie_url_allow_list;
    public boolean cjweb_hybrid_enable;
    public ArrayList<String> cjweb_hybrid_url_allow_list;
    public ArrayList<String> cjweb_hybrid_url_block_list;
    public ArrayList<String> cjweb_xjsb_url_allow_list;
    public int color_diff;
    public boolean disable_alog;
    public boolean disable_blank_detect;
    public boolean enable;
    public boolean is_cjweb_to_annie_jsb_adapt;
    public ArrayList<String> url_prefix_block_list;

    public NewContainerConfig() {
        this(false, null, false, null, false, 0, false, null, null, null, null, false, null, null, 16383, null);
    }

    public final boolean enableDetectBlank() {
        return !this.disable_blank_detect;
    }

    public final int getBlankColorDiff() {
        return this.color_diff;
    }

    public final boolean isOpenH52AnnieJSBAdapt() {
        return this.is_cjweb_to_annie_jsb_adapt;
    }

    private final boolean isBlackUrl(String r100) {
        Iterator<T> r101 = this.url_prefix_block_list.iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        if (StringsKt.startsWith$default(r100, (String) r101.next(), false, 2, null) == false) goto L4;
        return true;
    L9:
        return false;
    }

    private final boolean isOldContainerBlackUrl(String r100) {
        Iterator<T> r101 = this.cjweb_hybrid_url_block_list.iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        if (StringsKt.startsWith$default(r100, (String) r101.next(), false, 2, null) == false) goto L4;
        return true;
    L9:
        return false;
    }

    public final boolean enableXJSBUrl(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        if (StringsKt.isBlank(r100) == false) goto L5;
        return false;
    L5:
        Iterator<T> r101 = this.cjweb_xjsb_url_allow_list.iterator();
    L7:
        if (r101.hasNext() == false) goto L12;
        if (StringsKt.startsWith$default(r100, (String) r101.next(), false, 2, null) == false) goto L7;
        return true;
    L12:
        return false;
    }

    public final boolean isAnnieXBlackUrl(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        if (StringsKt.isBlank(r100) == false) goto L5;
        return false;
    L5:
        String r101 = CJSchemaExtensionKt.clearQuery(r100);
        Iterator<T> r102 = this.annie_url_black_list.iterator();
    L7:
        if (r102.hasNext() == false) goto L12;
        if (StringsKt.startsWith$default(r101, (String) r102.next(), false, 2, null) == false) goto L7;
        return true;
    L12:
        return false;
    }

    public final boolean isAnnieXPrefixMatchUrl(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        if (StringsKt.isBlank(r100) == false) goto L5;
        return false;
    L5:
        Iterator<T> r101 = this.cj_annie_prefix_url_allow_list.iterator();
    L7:
        if (r101.hasNext() == false) goto L12;
        String r102 = (String) r101.next();
        if (StringsKt.startsWith$default(CJSchemaExtensionKt.clearQuery(r100), r102, false, 2, null) == false) goto L7;
        return true;
    L12:
        return false;
    }

    public final boolean isAnnieXUrl(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        if (StringsKt.isBlank(r100) == false) goto L5;
        return false;
    L5:
        Iterator<T> r101 = this.cj_annie_url_allow_list.iterator();
    L7:
        if (r101.hasNext() == false) goto L12;
        String r102 = (String) r101.next();
        if (Intrinsics.areEqual(CJSchemaExtensionKt.clearQuery(r100), r102) == false) goto L7;
        return true;
    L12:
        return false;
    }

    public final boolean isDispatchAnnieXUrl(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        if (StringsKt.isBlank(r100) == false) goto L5;
        return false;
    L5:
        Iterator<T> r101 = this.cjweb_annie_url_allow_list.iterator();
    L7:
        if (r101.hasNext() == false) goto L12;
        if (StringsKt.startsWith$default(r100, (String) r101.next(), false, 2, null) == false) goto L7;
        return true;
    L12:
        return false;
    }

    public final boolean isWhiteUrl(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        if (StringsKt.isBlank(r100) == false) goto L5;
        return false;
    L5:
        Iterator<T> r101 = this.cjweb_hybrid_url_allow_list.iterator();
    L7:
        if (r101.hasNext() == false) goto L12;
        if (StringsKt.startsWith$default(r100, (String) r101.next(), false, 2, null) == false) goto L7;
        return true;
    L12:
        return false;
    }

    public final boolean newContainerEnable(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        if ((!StringsKt.isBlank(r100)) == true) goto L5;
    L9:
        return false;
    L5:
        if (this.enable == false) goto L9;
        if (isBlackUrl(r100) == true) goto L9;
        return true;
    }

    public final boolean newKernelEnable(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        if ((!StringsKt.isBlank(r100)) == true) goto L5;
    L9:
        return false;
    L5:
        if (this.cjweb_hybrid_enable == false) goto L9;
        if (isOldContainerBlackUrl(r100) == true) goto L9;
        return true;
    }

    public NewContainerConfig(boolean r100, ArrayList<String> r101, boolean r102, ArrayList<String> r103, boolean r104, int r105, boolean r106, ArrayList<String> r107, ArrayList<String> r110, ArrayList<String> r111, ArrayList<String> r112, boolean r113, ArrayList<String> r114, ArrayList<String> r115) {
        Intrinsics.checkNotNullParameter(r101, "url_prefix_block_list");
        Intrinsics.checkNotNullParameter(r103, "cjweb_hybrid_url_block_list");
        Intrinsics.checkNotNullParameter(r107, "cjweb_hybrid_url_allow_list");
        Intrinsics.checkNotNullParameter(r110, "cjweb_annie_url_allow_list");
        Intrinsics.checkNotNullParameter(r111, "cj_annie_url_allow_list");
        Intrinsics.checkNotNullParameter(r112, "cj_annie_prefix_url_allow_list");
        Intrinsics.checkNotNullParameter(r114, "cjweb_xjsb_url_allow_list");
        Intrinsics.checkNotNullParameter(r115, "annie_url_black_list");
        this.enable = r100;
        this.url_prefix_block_list = r101;
        this.cjweb_hybrid_enable = r102;
        this.cjweb_hybrid_url_block_list = r103;
        this.disable_alog = r104;
        this.color_diff = r105;
        this.disable_blank_detect = r106;
        this.cjweb_hybrid_url_allow_list = r107;
        this.cjweb_annie_url_allow_list = r110;
        this.cj_annie_url_allow_list = r111;
        this.cj_annie_prefix_url_allow_list = r112;
        this.is_cjweb_to_annie_jsb_adapt = r113;
        this.cjweb_xjsb_url_allow_list = r114;
        this.annie_url_black_list = r115;
    }

    public /* synthetic */ NewContainerConfig(boolean r110, ArrayList r111, boolean r112, ArrayList r113, boolean r114, int r210, boolean r211, ArrayList r212, ArrayList r213, ArrayList r214, ArrayList r215, boolean r216, ArrayList r217, ArrayList r218, int r219, DefaultConstructorMarker r310) {
        boolean r100 = false;
        if ((r219 & 1) == 0) goto L5;
        boolean r101 = false;
    L7:
        if ((r219 & 2) == 0) goto L9;
        ArrayList r102 = new ArrayList();
    L11:
        if ((r219 & 4) != 0) goto L15;
        r100 = r112;
    L15:
        if ((r219 & 8) == 0) goto L17;
        ArrayList r103 = new ArrayList();
    L18:
        boolean r104 = true;
        if ((r219 & 16) == 0) goto L21;
        boolean r105 = true;
    L23:
        if ((r219 & 32) == 0) goto L25;
        int r106 = 75;
    L27:
        if ((r219 & 64) == 0) goto L29;
        boolean r107 = true;
    L31:
        if ((r219 & 128) == 0) goto L33;
        ArrayList r108 = new ArrayList();
    L35:
        if ((r219 & 256) == 0) goto L37;
        ArrayList r115 = new ArrayList();
    L39:
        if ((r219 & 512) == 0) goto L41;
        ArrayList r116 = new ArrayList();
    L43:
        if ((r219 & 1024) == 0) goto L45;
        ArrayList r117 = new ArrayList();
    L47:
        if ((r219 & 2048) != 0) goto L51;
        r104 = r216;
    L51:
        if ((r219 & 4096) == 0) goto L53;
        ArrayList r118 = new ArrayList();
    L55:
        if ((r219 & 8192) == 0) goto L57;
        ArrayList r109 = new ArrayList();
    L58:
        this(r101, r102, r100, r103, r105, r106, r107, r108, r115, r116, r117, r104, r118, r109);
        return;
    L57:
        r109 = r218;
        goto L58
    L53:
        r118 = r217;
        goto L55
    L45:
        r117 = r215;
        goto L47
    L41:
        r116 = r214;
        goto L43
    L37:
        r115 = r213;
        goto L39
    L33:
        r108 = r212;
        goto L35
    L29:
        r107 = r211;
        goto L31
    L25:
        r106 = r210;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r103 = r113;
        goto L18
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
