package com.android.ttcjpaysdk.base.auth.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/android/ttcjpaysdk/base/auth/data/CJPayBusiAuthorizeInfo;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "()V", "authType", "", "busi_auth_info", "Lcom/android/ttcjpaysdk/base/auth/data/CJPayAuthInfo;", "busi_authorize_content", "Lcom/android/ttcjpaysdk/base/auth/data/CJPayAuthContent;", "hasPass", "", "isOneStep", "is_authed", "", "is_conflict", "is_need_authorize", "needIdentify", "protocol_group_contents", "Lcom/android/ttcjpaysdk/base/auth/data/CJPayProtocolGroupContents;", "showOneStep", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayBusiAuthorizeInfo implements CJPayObject {
    public String authType;
    public CJPayAuthInfo busi_auth_info;
    public CJPayAuthContent busi_authorize_content;
    public int hasPass;
    public int isOneStep;
    public boolean is_authed;
    public boolean is_conflict;
    public boolean is_need_authorize;
    public int needIdentify;
    public CJPayProtocolGroupContents protocol_group_contents;
    public int showOneStep;

    public CJPayBusiAuthorizeInfo() {
        this.busi_auth_info = new CJPayAuthInfo();
        this.busi_authorize_content = new CJPayAuthContent();
        this.protocol_group_contents = new CJPayProtocolGroupContents();
        this.needIdentify = 1;
        this.authType = "";
    }
}
