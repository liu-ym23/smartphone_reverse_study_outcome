package com.android.ttcjpaysdk.base.ui.component.dialog.bean;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R.\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000bj\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\"\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/component/dialog/bean/CJPayAgreementBean;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "()V", "guide_desc", "", "is_checked", "", "panelHeightDp", "", "protocol_group_names", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "protocol_list", "Ljava/util/ArrayList;", "Lcom/android/ttcjpaysdk/base/ui/component/dialog/bean/CJPayAgreementBean$ProtocolBean;", "Lkotlin/collections/ArrayList;", "style", "suffix_message", "ProtocolBean", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayAgreementBean implements CJPayObject, Serializable {
    public String guide_desc;
    public boolean is_checked;
    public int panelHeightDp;
    public HashMap<String, String> protocol_group_names;
    public ArrayList<ProtocolBean> protocol_list;
    public String style;
    public String suffix_message;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/component/dialog/bean/CJPayAgreementBean$ProtocolBean;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "()V", "group", "", "name", "template_url", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ProtocolBean implements CJPayObject, Serializable {
        public String group;
        public String name;
        public String template_url;

        public ProtocolBean() {
            this.name = "";
            this.template_url = "";
            this.group = "";
        }
    }

    public CJPayAgreementBean() {
        this.panelHeightDp = 470;
        this.guide_desc = "";
        this.protocol_group_names = new HashMap();
        this.protocol_list = new ArrayList();
        this.style = "";
        this.suffix_message = "";
    }
}
