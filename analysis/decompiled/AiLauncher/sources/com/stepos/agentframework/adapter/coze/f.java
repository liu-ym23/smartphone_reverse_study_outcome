package com.stepos.agentframework.adapter.coze;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R$\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR$\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR$\u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u0006\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\n¨\u0006\u0011"}, d2 = {"Lcom/stepos/agentframework/adapter/coze/f;", "", "<init>", "()V", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "c", "(Ljava/lang/String;)V", "text", "getText", Const.INTENT_KEY_PKGNAME, "file_id", "getFile_id", Const.INTENT_KEY_APIKEY, "protocol_coze_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class f {
    private String file_id;
    private String text;
    private String type;

    public final void a(String str) {
        this.file_id = str;
    }

    public final void b(String str) {
        this.text = str;
    }

    public final void c(String str) {
        this.type = str;
    }
}
